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
    private TBSpecificationBtn gLT;
    private boolean gLV;
    private FrsFragment gpX;
    private LikeModel djT = null;
    private y gLU = null;
    private AntiHelper.a gLW = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d gLX = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData bEn;
            t tVar;
            boolean z = false;
            if (f.this.gpX != null && (bEn = f.this.gpX.bEn()) != null && bEn.getForum() != null && obj != null) {
                if (AntiHelper.bb(f.this.djT.getErrorCode(), f.this.djT.getErrorString())) {
                    if (AntiHelper.a(f.this.gpX.getActivity(), f.this.djT.getBlockPopInfoData(), f.this.gLW) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = bEn.getForum().getName();
                String id = bEn.getForum().getId();
                if (!(obj instanceof t)) {
                    tVar = null;
                } else {
                    tVar = (t) obj;
                }
                boolean z2 = tVar != null && f.this.djT.getErrorCode() == 0;
                if (tVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), tVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEF();
                } else {
                    z = z2;
                }
                if (tVar == null || !z) {
                    if (f.this.djT.getErrorCode() == 22) {
                        f.this.gpX.showToast(f.this.gpX.getString(R.string.had_liked_forum));
                    } else {
                        f.this.gpX.showToast(f.this.djT.getErrorString());
                    }
                } else {
                    h bDK = f.this.gpX.bDK();
                    if (bDK != null) {
                        bDK.BQ(name);
                    }
                    tVar.setLike(1);
                    bEn.updateLikeData(tVar);
                    bEn.setLikeFeedForumDataList(tVar.cKl());
                    if (bDK != null) {
                        bDK.a(bEn, f.this.gLV);
                    }
                    f.this.gLV = true;
                    f.this.gpX.showToast(f.this.gpX.getResources().getString(R.string.attention_success));
                    f.this.m(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                    f.this.bKw();
                }
                f.this.gpX.au(Boolean.valueOf(z));
            }
        }
    };
    private y.a gLY = new y.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.y.a
        public void D(String str, long j) {
            FrsViewData bEn;
            if (f.this.gpX != null && (bEn = f.this.gpX.bEn()) != null && bEn.getForum() != null) {
                String name = bEn.getForum().getName();
                String id = bEn.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h bDK = f.this.gpX.bDK();
                    if (bDK != null) {
                        bDK.BQ(str);
                    }
                    bEn.getForum().setLike(0);
                    if (bDK != null) {
                        bDK.ul(0);
                    }
                    f.this.gpX.at(true);
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
        this.gpX = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.gLT = tBSpecificationBtn;
        bGL();
    }

    public void bGL() {
        if (this.gLT != null) {
            this.gLT.aHL();
        }
    }

    public void agt() {
        bdc();
        bKv();
    }

    public void aiG() {
        if (this.djT != null) {
            this.djT.cKs();
        }
    }

    private void bdc() {
        if (this.gpX != null) {
            this.djT = new LikeModel(this.gpX.getPageContext());
            this.djT.setLoadDataCallBack(this.gLX);
        }
    }

    private void bKv() {
        this.gLU = new y();
        this.gLU.setFrom("from_frs");
        this.gLU.a(this.gLY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKw() {
        an anVar = new an("c13605");
        if (this.gpX != null) {
            com.baidu.tbadk.pageInfo.c.a(this.gpX.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.bXZ().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void me(boolean z) {
        if (this.gpX != null && this.djT != null) {
            FrsViewData bEn = this.gpX.bEn();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.gpX.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.gpX.getActivity(), true, 11002)));
            } else if (bEn != null && bEn.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.gpX.getFrom())) {
                    TiebaStatic.log(new an("c10356").cy("fid", bEn.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.gpX.getFrom())) {
                    TiebaStatic.log(new an("c10590").X("obj_type", 2).cy("fid", bEn.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.gpX.getFrom())) {
                    TiebaStatic.log(new an("c10587").X("obj_type", 2).cy("fid", bEn.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.gpX.getFrom())) {
                    TiebaStatic.log(new an("c10578").X("obj_type", 2).cy("fid", bEn.getForum().getId()));
                }
                this.djT.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.gpX.getFrom())) {
                    TiebaStatic.eventStat(this.gpX.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.gpX.getFrom())) {
                    TiebaStatic.log(new an("c10359").cy("fid", bEn.getForum().getId()));
                }
                this.djT.au(bEn.getForum().getName(), bEn.getForum().getId(), "FRS");
                this.gLV = z;
            }
        }
    }

    public void bKx() {
        if (this.gpX != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gpX.getActivity());
            String str = "";
            FrsViewData bEn = this.gpX.bEn();
            if (bEn != null && bEn.getForum() != null && bEn.getForum().getName() != null) {
                str = bEn.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.sS(String.format(this.gpX.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.sS(this.gpX.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.gpX.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.gpX != null && f.this.gLU != null) {
                        FrsViewData bEn2 = f.this.gpX.bEn();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.gpX.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.gpX.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (bEn2 != null && bEn2.getForum() != null) {
                            f.this.gLU.L(bEn2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(bEn2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.gpX.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.gpX.getTbPageContext()).aEA();
        }
    }
}
