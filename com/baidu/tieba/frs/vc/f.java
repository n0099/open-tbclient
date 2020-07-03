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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.av;
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
    private FrsFragment hBW;
    private TBSpecificationBtn hZH;
    private boolean hZJ;
    private LikeModel egK = null;
    private ac hZI = null;
    private AntiHelper.a hZK = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", av.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", av.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d hZL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData bYB;
            u uVar;
            boolean z = false;
            if (f.this.hBW != null && (bYB = f.this.hBW.bYB()) != null && bYB.getForum() != null && obj != null) {
                if (AntiHelper.bA(f.this.egK.getErrorCode(), f.this.egK.getErrorString())) {
                    if (AntiHelper.a(f.this.hBW.getActivity(), f.this.egK.getBlockPopInfoData(), f.this.hZK) != null) {
                        TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", av.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = bYB.getForum().getName();
                String id = bYB.getForum().getId();
                if (!(obj instanceof u)) {
                    uVar = null;
                } else {
                    uVar = (u) obj;
                }
                boolean z2 = uVar != null && f.this.egK.getErrorCode() == 0;
                if (uVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), uVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aUS();
                } else {
                    z = z2;
                }
                if (uVar == null || !z) {
                    if (f.this.egK.getErrorCode() == 22) {
                        f.this.hBW.showToast(f.this.hBW.getString(R.string.had_liked_forum));
                    } else {
                        f.this.hBW.showToast(f.this.egK.getErrorString());
                    }
                } else {
                    h bXW = f.this.hBW.bXW();
                    if (bXW != null) {
                        bXW.FM(name);
                    }
                    uVar.setLike(1);
                    bYB.updateLikeData(uVar);
                    bYB.setLikeFeedForumDataList(uVar.dhk());
                    if (bXW != null) {
                        bXW.a(bYB, f.this.hZJ);
                    }
                    f.this.hZJ = true;
                    f.this.hBW.showToast(f.this.hBW.getResources().getString(R.string.attention_success));
                    f.this.p(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                    f.this.cfi();
                }
                f.this.hBW.aB(Boolean.valueOf(z));
            }
        }
    };
    private ac.a hZM = new ac.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ac.a
        public void z(String str, long j) {
            FrsViewData bYB;
            if (f.this.hBW != null && (bYB = f.this.hBW.bYB()) != null && bYB.getForum() != null) {
                String name = bYB.getForum().getName();
                String id = bYB.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h bXW = f.this.hBW.bXW();
                    if (bXW != null) {
                        bXW.FM(str);
                    }
                    bYB.getForum().setLike(0);
                    if (bXW != null) {
                        bXW.wb(0);
                    }
                    f.this.hBW.aA(true);
                    f.this.p(false, id);
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
        this.hBW = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.hZH = tBSpecificationBtn;
        cbq();
    }

    public void cbq() {
        if (this.hZH != null) {
            this.hZH.aYj();
        }
    }

    public void aui() {
        buv();
        cfh();
    }

    public void cdl() {
        if (this.egK != null) {
            this.egK.dhr();
        }
    }

    private void buv() {
        if (this.hBW != null) {
            this.egK = new LikeModel(this.hBW.getPageContext());
            this.egK.setLoadDataCallBack(this.hZL);
        }
    }

    private void cfh() {
        this.hZI = new ac();
        this.hZI.setFrom("from_frs");
        this.hZI.a(this.hZM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfi() {
        ao aoVar = new ao("c13605");
        if (this.hBW != null) {
            com.baidu.tbadk.pageInfo.c.a(this.hBW.getContext(), aoVar);
        }
        TiebaStatic.log(aoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.ctp().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void nV(boolean z) {
        if (this.hBW != null && this.egK != null) {
            FrsViewData bYB = this.hBW.bYB();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.hBW.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.hBW.getActivity(), true, 11002)));
            } else if (bYB != null && bYB.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.hBW.getFrom())) {
                    TiebaStatic.log(new ao("c10356").dk("fid", bYB.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.hBW.getFrom())) {
                    TiebaStatic.log(new ao("c10590").ag("obj_type", 2).dk("fid", bYB.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.hBW.getFrom())) {
                    TiebaStatic.log(new ao("c10587").ag("obj_type", 2).dk("fid", bYB.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.hBW.getFrom())) {
                    TiebaStatic.log(new ao("c10578").ag("obj_type", 2).dk("fid", bYB.getForum().getId()));
                }
                this.egK.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.hBW.getFrom())) {
                    TiebaStatic.eventStat(this.hBW.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.hBW.getFrom())) {
                    TiebaStatic.log(new ao("c10359").dk("fid", bYB.getForum().getId()));
                }
                this.egK.az(bYB.getForum().getName(), bYB.getForum().getId(), "FRS");
                this.hZJ = z;
            }
        }
    }

    public void cfj() {
        if (this.hBW != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hBW.getActivity());
            String str = "";
            FrsViewData bYB = this.hBW.bYB();
            if (bYB != null && bYB.getForum() != null && bYB.getForum().getName() != null) {
                str = bYB.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.we(String.format(this.hBW.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.we(this.hBW.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.hBW.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.hBW != null && f.this.hZI != null) {
                        FrsViewData bYB2 = f.this.hBW.bYB();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.hBW.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.hBW.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (bYB2 != null && bYB2.getForum() != null) {
                            f.this.hZI.K(bYB2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(bYB2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.hBW.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hBW.getTbPageContext()).aUN();
        }
    }
}
