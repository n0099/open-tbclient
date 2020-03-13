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
    private TBSpecificationBtn gMh;
    private boolean gMj;
    private FrsFragment gqm;
    private LikeModel dkh = null;
    private y gMi = null;
    private AntiHelper.a gMk = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d gMl = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData bEq;
            t tVar;
            boolean z = false;
            if (f.this.gqm != null && (bEq = f.this.gqm.bEq()) != null && bEq.getForum() != null && obj != null) {
                if (AntiHelper.bb(f.this.dkh.getErrorCode(), f.this.dkh.getErrorString())) {
                    if (AntiHelper.a(f.this.gqm.getActivity(), f.this.dkh.getBlockPopInfoData(), f.this.gMk) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = bEq.getForum().getName();
                String id = bEq.getForum().getId();
                if (!(obj instanceof t)) {
                    tVar = null;
                } else {
                    tVar = (t) obj;
                }
                boolean z2 = tVar != null && f.this.dkh.getErrorCode() == 0;
                if (tVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), tVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEH();
                } else {
                    z = z2;
                }
                if (tVar == null || !z) {
                    if (f.this.dkh.getErrorCode() == 22) {
                        f.this.gqm.showToast(f.this.gqm.getString(R.string.had_liked_forum));
                    } else {
                        f.this.gqm.showToast(f.this.dkh.getErrorString());
                    }
                } else {
                    h bDN = f.this.gqm.bDN();
                    if (bDN != null) {
                        bDN.BR(name);
                    }
                    tVar.setLike(1);
                    bEq.updateLikeData(tVar);
                    bEq.setLikeFeedForumDataList(tVar.cKo());
                    if (bDN != null) {
                        bDN.a(bEq, f.this.gMj);
                    }
                    f.this.gMj = true;
                    f.this.gqm.showToast(f.this.gqm.getResources().getString(R.string.attention_success));
                    f.this.m(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                    f.this.bKz();
                }
                f.this.gqm.au(Boolean.valueOf(z));
            }
        }
    };
    private y.a gMm = new y.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.y.a
        public void D(String str, long j) {
            FrsViewData bEq;
            if (f.this.gqm != null && (bEq = f.this.gqm.bEq()) != null && bEq.getForum() != null) {
                String name = bEq.getForum().getName();
                String id = bEq.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h bDN = f.this.gqm.bDN();
                    if (bDN != null) {
                        bDN.BR(str);
                    }
                    bEq.getForum().setLike(0);
                    if (bDN != null) {
                        bDN.ul(0);
                    }
                    f.this.gqm.at(true);
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
        this.gqm = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.gMh = tBSpecificationBtn;
        bGO();
    }

    public void bGO() {
        if (this.gMh != null) {
            this.gMh.aHO();
        }
    }

    public void agv() {
        bdf();
        bKy();
    }

    public void aiI() {
        if (this.dkh != null) {
            this.dkh.cKv();
        }
    }

    private void bdf() {
        if (this.gqm != null) {
            this.dkh = new LikeModel(this.gqm.getPageContext());
            this.dkh.setLoadDataCallBack(this.gMl);
        }
    }

    private void bKy() {
        this.gMi = new y();
        this.gMi.setFrom("from_frs");
        this.gMi.a(this.gMm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKz() {
        an anVar = new an("c13605");
        if (this.gqm != null) {
            com.baidu.tbadk.pageInfo.c.a(this.gqm.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.bYc().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void me(boolean z) {
        if (this.gqm != null && this.dkh != null) {
            FrsViewData bEq = this.gqm.bEq();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.gqm.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.gqm.getActivity(), true, 11002)));
            } else if (bEq != null && bEq.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.gqm.getFrom())) {
                    TiebaStatic.log(new an("c10356").cy("fid", bEq.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.gqm.getFrom())) {
                    TiebaStatic.log(new an("c10590").X("obj_type", 2).cy("fid", bEq.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.gqm.getFrom())) {
                    TiebaStatic.log(new an("c10587").X("obj_type", 2).cy("fid", bEq.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.gqm.getFrom())) {
                    TiebaStatic.log(new an("c10578").X("obj_type", 2).cy("fid", bEq.getForum().getId()));
                }
                this.dkh.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.gqm.getFrom())) {
                    TiebaStatic.eventStat(this.gqm.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.gqm.getFrom())) {
                    TiebaStatic.log(new an("c10359").cy("fid", bEq.getForum().getId()));
                }
                this.dkh.au(bEq.getForum().getName(), bEq.getForum().getId(), "FRS");
                this.gMj = z;
            }
        }
    }

    public void bKA() {
        if (this.gqm != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gqm.getActivity());
            String str = "";
            FrsViewData bEq = this.gqm.bEq();
            if (bEq != null && bEq.getForum() != null && bEq.getForum().getName() != null) {
                str = bEq.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.sS(String.format(this.gqm.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.sS(this.gqm.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.gqm.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.gqm != null && f.this.gMi != null) {
                        FrsViewData bEq2 = f.this.gqm.bEq();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.gqm.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.gqm.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (bEq2 != null && bEq2.getForum() != null) {
                            f.this.gMi.L(bEq2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(bEq2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.gqm.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.gqm.getTbPageContext()).aEC();
        }
    }
}
