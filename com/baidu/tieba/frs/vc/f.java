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
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes9.dex */
public class f {
    private TBSpecificationBtn hMv;
    private boolean hMx;
    private FrsFragment hpm;
    private LikeModel dYI = null;
    private ac hMw = null;
    private AntiHelper.a hMy = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d hMz = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData bVu;
            u uVar;
            boolean z = false;
            if (f.this.hpm != null && (bVu = f.this.hpm.bVu()) != null && bVu.getForum() != null && obj != null) {
                if (AntiHelper.bv(f.this.dYI.getErrorCode(), f.this.dYI.getErrorString())) {
                    if (AntiHelper.a(f.this.hpm.getActivity(), f.this.dYI.getBlockPopInfoData(), f.this.hMy) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = bVu.getForum().getName();
                String id = bVu.getForum().getId();
                if (!(obj instanceof u)) {
                    uVar = null;
                } else {
                    uVar = (u) obj;
                }
                boolean z2 = uVar != null && f.this.dYI.getErrorCode() == 0;
                if (uVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), uVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aSY();
                } else {
                    z = z2;
                }
                if (uVar == null || !z) {
                    if (f.this.dYI.getErrorCode() == 22) {
                        f.this.hpm.showToast(f.this.hpm.getString(R.string.had_liked_forum));
                    } else {
                        f.this.hpm.showToast(f.this.dYI.getErrorString());
                    }
                } else {
                    h bUQ = f.this.hpm.bUQ();
                    if (bUQ != null) {
                        bUQ.Fl(name);
                    }
                    uVar.setLike(1);
                    bVu.updateLikeData(uVar);
                    bVu.setLikeFeedForumDataList(uVar.dcV());
                    if (bUQ != null) {
                        bUQ.a(bVu, f.this.hMx);
                    }
                    f.this.hMx = true;
                    f.this.hpm.showToast(f.this.hpm.getResources().getString(R.string.attention_success));
                    f.this.n(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                    f.this.cbQ();
                }
                f.this.hpm.aA(Boolean.valueOf(z));
            }
        }
    };
    private ac.a hMA = new ac.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ac.a
        public void z(String str, long j) {
            FrsViewData bVu;
            if (f.this.hpm != null && (bVu = f.this.hpm.bVu()) != null && bVu.getForum() != null) {
                String name = bVu.getForum().getName();
                String id = bVu.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h bUQ = f.this.hpm.bUQ();
                    if (bUQ != null) {
                        bUQ.Fl(str);
                    }
                    bVu.getForum().setLike(0);
                    if (bUQ != null) {
                        bUQ.vw(0);
                    }
                    f.this.hpm.az(true);
                    f.this.n(false, id);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                    u uVar = new u();
                    uVar.setLike(0);
                    uVar.setFid(id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ac.a
        public void A(String str, long j) {
        }
    };

    public f(FrsFragment frsFragment) {
        this.hpm = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.hMv = tBSpecificationBtn;
        bYc();
    }

    public void bYc() {
        if (this.hMv != null) {
            this.hMv.aWr();
        }
    }

    public void atc() {
        brz();
        cbP();
    }

    public void bZX() {
        if (this.dYI != null) {
            this.dYI.ddc();
        }
    }

    private void brz() {
        if (this.hpm != null) {
            this.dYI = new LikeModel(this.hpm.getPageContext());
            this.dYI.setLoadDataCallBack(this.hMz);
        }
    }

    private void cbP() {
        this.hMw = new ac();
        this.hMw.setFrom("from_frs");
        this.hMw.a(this.hMA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbQ() {
        an anVar = new an("c13605");
        if (this.hpm != null) {
            com.baidu.tbadk.pageInfo.c.a(this.hpm.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cpA().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void nJ(boolean z) {
        if (this.hpm != null && this.dYI != null) {
            FrsViewData bVu = this.hpm.bVu();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.hpm.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.hpm.getActivity(), true, 11002)));
            } else if (bVu != null && bVu.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.hpm.getFrom())) {
                    TiebaStatic.log(new an("c10356").dh("fid", bVu.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.hpm.getFrom())) {
                    TiebaStatic.log(new an("c10590").ag("obj_type", 2).dh("fid", bVu.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.hpm.getFrom())) {
                    TiebaStatic.log(new an("c10587").ag("obj_type", 2).dh("fid", bVu.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.hpm.getFrom())) {
                    TiebaStatic.log(new an("c10578").ag("obj_type", 2).dh("fid", bVu.getForum().getId()));
                }
                this.dYI.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.hpm.getFrom())) {
                    TiebaStatic.eventStat(this.hpm.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.hpm.getFrom())) {
                    TiebaStatic.log(new an("c10359").dh("fid", bVu.getForum().getId()));
                }
                this.dYI.ay(bVu.getForum().getName(), bVu.getForum().getId(), "FRS");
                this.hMx = z;
            }
        }
    }

    public void cbR() {
        if (this.hpm != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hpm.getActivity());
            String str = "";
            FrsViewData bVu = this.hpm.bVu();
            if (bVu != null && bVu.getForum() != null && bVu.getForum().getName() != null) {
                str = bVu.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.vO(String.format(this.hpm.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.vO(this.hpm.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.hpm.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.hpm != null && f.this.hMw != null) {
                        FrsViewData bVu2 = f.this.hpm.bVu();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.hpm.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.hpm.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (bVu2 != null && bVu2.getForum() != null) {
                            f.this.hMw.K(bVu2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(bVu2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.hpm.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hpm.getTbPageContext()).aST();
        }
    }
}
