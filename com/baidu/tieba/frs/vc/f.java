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
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes9.dex */
public class f {
    private TBSpecificationBtn gNm;
    private boolean gNo;
    private FrsFragment gqW;
    private LikeModel dku = null;
    private z gNn = null;
    private AntiHelper.a gNp = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d gNq = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData bEz;
            u uVar;
            boolean z = false;
            if (f.this.gqW != null && (bEz = f.this.gqW.bEz()) != null && bEz.getForum() != null && obj != null) {
                if (AntiHelper.bb(f.this.dku.getErrorCode(), f.this.dku.getErrorString())) {
                    if (AntiHelper.a(f.this.gqW.getActivity(), f.this.dku.getBlockPopInfoData(), f.this.gNp) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = bEz.getForum().getName();
                String id = bEz.getForum().getId();
                if (!(obj instanceof u)) {
                    uVar = null;
                } else {
                    uVar = (u) obj;
                }
                boolean z2 = uVar != null && f.this.dku.getErrorCode() == 0;
                if (uVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), uVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEL();
                } else {
                    z = z2;
                }
                if (uVar == null || !z) {
                    if (f.this.dku.getErrorCode() == 22) {
                        f.this.gqW.showToast(f.this.gqW.getString(R.string.had_liked_forum));
                    } else {
                        f.this.gqW.showToast(f.this.dku.getErrorString());
                    }
                } else {
                    h bDV = f.this.gqW.bDV();
                    if (bDV != null) {
                        bDV.BQ(name);
                    }
                    uVar.setLike(1);
                    bEz.updateLikeData(uVar);
                    bEz.setLikeFeedForumDataList(uVar.cKI());
                    if (bDV != null) {
                        bDV.a(bEz, f.this.gNo);
                    }
                    f.this.gNo = true;
                    f.this.gqW.showToast(f.this.gqW.getResources().getString(R.string.attention_success));
                    f.this.m(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                    f.this.bKM();
                }
                f.this.gqW.au(Boolean.valueOf(z));
            }
        }
    };
    private z.a gNr = new z.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.z.a
        public void D(String str, long j) {
            FrsViewData bEz;
            if (f.this.gqW != null && (bEz = f.this.gqW.bEz()) != null && bEz.getForum() != null) {
                String name = bEz.getForum().getName();
                String id = bEz.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h bDV = f.this.gqW.bDV();
                    if (bDV != null) {
                        bDV.BQ(str);
                    }
                    bEz.getForum().setLike(0);
                    if (bDV != null) {
                        bDV.ur(0);
                    }
                    f.this.gqW.at(true);
                    f.this.m(false, id);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                    u uVar = new u();
                    uVar.setLike(0);
                    uVar.setFid(id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.z.a
        public void E(String str, long j) {
        }
    };

    public f(FrsFragment frsFragment) {
        this.gqW = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.gNm = tBSpecificationBtn;
        bHd();
    }

    public void bHd() {
        if (this.gNm != null) {
            this.gNm.aHS();
        }
    }

    public void agy() {
        bdk();
        bKL();
    }

    public void aiL() {
        if (this.dku != null) {
            this.dku.cKP();
        }
    }

    private void bdk() {
        if (this.gqW != null) {
            this.dku = new LikeModel(this.gqW.getPageContext());
            this.dku.setLoadDataCallBack(this.gNq);
        }
    }

    private void bKL() {
        this.gNn = new z();
        this.gNn.setFrom("from_frs");
        this.gNn.a(this.gNr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKM() {
        an anVar = new an("c13605");
        if (this.gqW != null) {
            com.baidu.tbadk.pageInfo.c.a(this.gqW.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.bYu().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void mk(boolean z) {
        if (this.gqW != null && this.dku != null) {
            FrsViewData bEz = this.gqW.bEz();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.gqW.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.gqW.getActivity(), true, 11002)));
            } else if (bEz != null && bEz.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.gqW.getFrom())) {
                    TiebaStatic.log(new an("c10356").cx("fid", bEz.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.gqW.getFrom())) {
                    TiebaStatic.log(new an("c10590").X("obj_type", 2).cx("fid", bEz.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.gqW.getFrom())) {
                    TiebaStatic.log(new an("c10587").X("obj_type", 2).cx("fid", bEz.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.gqW.getFrom())) {
                    TiebaStatic.log(new an("c10578").X("obj_type", 2).cx("fid", bEz.getForum().getId()));
                }
                this.dku.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.gqW.getFrom())) {
                    TiebaStatic.eventStat(this.gqW.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.gqW.getFrom())) {
                    TiebaStatic.log(new an("c10359").cx("fid", bEz.getForum().getId()));
                }
                this.dku.au(bEz.getForum().getName(), bEz.getForum().getId(), "FRS");
                this.gNo = z;
            }
        }
    }

    public void bKN() {
        if (this.gqW != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gqW.getActivity());
            String str = "";
            FrsViewData bEz = this.gqW.bEz();
            if (bEz != null && bEz.getForum() != null && bEz.getForum().getName() != null) {
                str = bEz.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.sR(String.format(this.gqW.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.sR(this.gqW.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.gqW.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.gqW != null && f.this.gNn != null) {
                        FrsViewData bEz2 = f.this.gqW.bEz();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.gqW.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.gqW.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (bEz2 != null && bEz2.getForum() != null) {
                            f.this.gNn.L(bEz2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(bEz2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.gqW.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.gqW.getTbPageContext()).aEG();
        }
    }
}
