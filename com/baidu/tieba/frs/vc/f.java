package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes9.dex */
public class f {
    private TBSpecificationBtn gLV;
    private boolean gLX;
    private FrsFragment gpZ;
    private LikeModel djU = null;
    private y gLW = null;
    private AntiHelper.a gLY = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d gLZ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData bEp;
            t tVar;
            boolean z = false;
            if (f.this.gpZ != null && (bEp = f.this.gpZ.bEp()) != null && bEp.getForum() != null && obj != null) {
                if (AntiHelper.bb(f.this.djU.getErrorCode(), f.this.djU.getErrorString())) {
                    if (AntiHelper.a(f.this.gpZ.getActivity(), f.this.djU.getBlockPopInfoData(), f.this.gLY) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = bEp.getForum().getName();
                String id = bEp.getForum().getId();
                if (!(obj instanceof t)) {
                    tVar = null;
                } else {
                    tVar = (t) obj;
                }
                boolean z2 = tVar != null && f.this.djU.getErrorCode() == 0;
                if (tVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), tVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEH();
                } else {
                    z = z2;
                }
                if (tVar == null || !z) {
                    if (f.this.djU.getErrorCode() == 22) {
                        f.this.gpZ.showToast(f.this.gpZ.getString(R.string.had_liked_forum));
                    } else {
                        f.this.gpZ.showToast(f.this.djU.getErrorString());
                    }
                } else {
                    h bDM = f.this.gpZ.bDM();
                    if (bDM != null) {
                        bDM.BQ(name);
                    }
                    tVar.setLike(1);
                    bEp.updateLikeData(tVar);
                    bEp.setLikeFeedForumDataList(tVar.cKn());
                    if (bDM != null) {
                        bDM.a(bEp, f.this.gLX);
                    }
                    f.this.gLX = true;
                    f.this.gpZ.showToast(f.this.gpZ.getResources().getString(R.string.attention_success));
                    f.this.m(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                    f.this.bKy();
                }
                f.this.gpZ.au(Boolean.valueOf(z));
            }
        }
    };
    private y.a gMa = new y.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.y.a
        public void D(String str, long j) {
            FrsViewData bEp;
            if (f.this.gpZ != null && (bEp = f.this.gpZ.bEp()) != null && bEp.getForum() != null) {
                String name = bEp.getForum().getName();
                String id = bEp.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h bDM = f.this.gpZ.bDM();
                    if (bDM != null) {
                        bDM.BQ(str);
                    }
                    bEp.getForum().setLike(0);
                    if (bDM != null) {
                        bDM.ul(0);
                    }
                    f.this.gpZ.at(true);
                    f.this.m(false, id);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                    t tVar = new t();
                    tVar.setLike(0);
                    tVar.setFid(id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.y.a
        public void E(String str, long j) {
        }
    };

    public f(FrsFragment frsFragment) {
        this.gpZ = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.gLV = tBSpecificationBtn;
        bGN();
    }

    public void bGN() {
        if (this.gLV != null) {
            this.gLV.aHN();
        }
    }

    public void agv() {
        bde();
        bKx();
    }

    public void aiI() {
        if (this.djU != null) {
            this.djU.cKu();
        }
    }

    private void bde() {
        if (this.gpZ != null) {
            this.djU = new LikeModel(this.gpZ.getPageContext());
            this.djU.setLoadDataCallBack(this.gLZ);
        }
    }

    private void bKx() {
        this.gLW = new y();
        this.gLW.setFrom("from_frs");
        this.gLW.a(this.gMa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKy() {
        an anVar = new an("c13605");
        if (this.gpZ != null) {
            com.baidu.tbadk.pageInfo.c.a(this.gpZ.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.bYb().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void me(boolean z) {
        if (this.gpZ != null && this.djU != null) {
            FrsViewData bEp = this.gpZ.bEp();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.gpZ.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.gpZ.getActivity(), true, 11002)));
            } else if (bEp != null && bEp.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.gpZ.getFrom())) {
                    TiebaStatic.log(new an("c10356").cy("fid", bEp.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.gpZ.getFrom())) {
                    TiebaStatic.log(new an("c10590").X("obj_type", 2).cy("fid", bEp.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.gpZ.getFrom())) {
                    TiebaStatic.log(new an("c10587").X("obj_type", 2).cy("fid", bEp.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.gpZ.getFrom())) {
                    TiebaStatic.log(new an("c10578").X("obj_type", 2).cy("fid", bEp.getForum().getId()));
                }
                this.djU.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.gpZ.getFrom())) {
                    TiebaStatic.eventStat(this.gpZ.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.gpZ.getFrom())) {
                    TiebaStatic.log(new an("c10359").cy("fid", bEp.getForum().getId()));
                }
                this.djU.au(bEp.getForum().getName(), bEp.getForum().getId(), "FRS");
                this.gLX = z;
            }
        }
    }

    public void bKz() {
        if (this.gpZ != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gpZ.getActivity());
            String str = "";
            FrsViewData bEp = this.gpZ.bEp();
            if (bEp != null && bEp.getForum() != null && bEp.getForum().getName() != null) {
                str = bEp.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.sS(String.format(this.gpZ.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.sS(this.gpZ.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.gpZ.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.gpZ != null && f.this.gLW != null) {
                        FrsViewData bEp2 = f.this.gpZ.bEp();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.gpZ.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.gpZ.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (bEp2 != null && bEp2.getForum() != null) {
                            f.this.gLW.L(bEp2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(bEp2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.gpZ.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.gpZ.getTbPageContext()).aEC();
        }
    }
}
