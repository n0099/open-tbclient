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
/* loaded from: classes7.dex */
public class f {
    private TBSpecificationBtn gJU;
    private boolean gJW;
    private FrsFragment gnW;
    private LikeModel dfN = null;
    private y gJV = null;
    private AntiHelper.a gJX = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d gJY = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData bCK;
            t tVar;
            boolean z = false;
            if (f.this.gnW != null && (bCK = f.this.gnW.bCK()) != null && bCK.getForum() != null && obj != null) {
                if (AntiHelper.bc(f.this.dfN.getErrorCode(), f.this.dfN.getErrorString())) {
                    if (AntiHelper.a(f.this.gnW.getActivity(), f.this.dfN.getBlockPopInfoData(), f.this.gJX) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = bCK.getForum().getName();
                String id = bCK.getForum().getId();
                if (!(obj instanceof t)) {
                    tVar = null;
                } else {
                    tVar = (t) obj;
                }
                boolean z2 = tVar != null && f.this.dfN.getErrorCode() == 0;
                if (tVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), tVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aCu();
                } else {
                    z = z2;
                }
                if (tVar == null || !z) {
                    if (f.this.dfN.getErrorCode() == 22) {
                        f.this.gnW.showToast(f.this.gnW.getString(R.string.had_liked_forum));
                    } else {
                        f.this.gnW.showToast(f.this.dfN.getErrorString());
                    }
                } else {
                    h bCh = f.this.gnW.bCh();
                    if (bCh != null) {
                        bCh.BA(name);
                    }
                    tVar.setLike(1);
                    bCK.updateLikeData(tVar);
                    bCK.setLikeFeedForumDataList(tVar.cIH());
                    if (bCh != null) {
                        bCh.a(bCK, f.this.gJW);
                    }
                    f.this.gJW = true;
                    f.this.gnW.showToast(f.this.gnW.getResources().getString(R.string.attention_success));
                    f.this.l(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                    f.this.bIU();
                }
                f.this.gnW.as(Boolean.valueOf(z));
            }
        }
    };
    private y.a gJZ = new y.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.y.a
        public void D(String str, long j) {
            FrsViewData bCK;
            if (f.this.gnW != null && (bCK = f.this.gnW.bCK()) != null && bCK.getForum() != null) {
                String name = bCK.getForum().getName();
                String id = bCK.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h bCh = f.this.gnW.bCh();
                    if (bCh != null) {
                        bCh.BA(str);
                    }
                    bCK.getForum().setLike(0);
                    if (bCh != null) {
                        bCh.uf(0);
                    }
                    f.this.gnW.ar(true);
                    f.this.l(false, id);
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
        this.gnW = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.gJU = tBSpecificationBtn;
        bFj();
    }

    public void bFj() {
        if (this.gJU != null) {
            this.gJU.aFw();
        }
    }

    public void aef() {
        baN();
        bIT();
    }

    public void ags() {
        if (this.dfN != null) {
            this.dfN.cIO();
        }
    }

    private void baN() {
        if (this.gnW != null) {
            this.dfN = new LikeModel(this.gnW.getPageContext());
            this.dfN.setLoadDataCallBack(this.gJY);
        }
    }

    private void bIT() {
        this.gJV = new y();
        this.gJV.setFrom("from_frs");
        this.gJV.a(this.gJZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIU() {
        an anVar = new an("c13605");
        if (this.gnW != null) {
            com.baidu.tbadk.pageInfo.c.a(this.gnW.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.bWy().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void mc(boolean z) {
        if (this.gnW != null && this.dfN != null) {
            FrsViewData bCK = this.gnW.bCK();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.gnW.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.gnW.getActivity(), true, 11002)));
            } else if (bCK != null && bCK.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.gnW.getFrom())) {
                    TiebaStatic.log(new an("c10356").cp("fid", bCK.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.gnW.getFrom())) {
                    TiebaStatic.log(new an("c10590").Z("obj_type", 2).cp("fid", bCK.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.gnW.getFrom())) {
                    TiebaStatic.log(new an("c10587").Z("obj_type", 2).cp("fid", bCK.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.gnW.getFrom())) {
                    TiebaStatic.log(new an("c10578").Z("obj_type", 2).cp("fid", bCK.getForum().getId()));
                }
                this.dfN.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.gnW.getFrom())) {
                    TiebaStatic.eventStat(this.gnW.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.gnW.getFrom())) {
                    TiebaStatic.log(new an("c10359").cp("fid", bCK.getForum().getId()));
                }
                this.dfN.au(bCK.getForum().getName(), bCK.getForum().getId(), "FRS");
                this.gJW = z;
            }
        }
    }

    public void bIV() {
        if (this.gnW != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gnW.getActivity());
            String str = "";
            FrsViewData bCK = this.gnW.bCK();
            if (bCK != null && bCK.getForum() != null && bCK.getForum().getName() != null) {
                str = bCK.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.sC(String.format(this.gnW.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.sC(this.gnW.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.gnW.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.gnW != null && f.this.gJV != null) {
                        FrsViewData bCK2 = f.this.gnW.bCK();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.gnW.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.gnW.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (bCK2 != null && bCK2.getForum() != null) {
                            f.this.gJV.L(bCK2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(bCK2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.gnW.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.gnW.getTbPageContext()).aCp();
        }
    }
}
