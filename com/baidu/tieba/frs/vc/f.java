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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes16.dex */
public class f {
    private FrsFragment hHU;
    private TBSpecificationBtn ifL;
    private boolean ifN;
    private LikeModel emT = null;
    private ac ifM = null;
    private AntiHelper.a ifO = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", aw.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", aw.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d ifP = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData cbZ;
            u uVar;
            boolean z = false;
            if (f.this.hHU != null && (cbZ = f.this.hHU.cbZ()) != null && cbZ.getForum() != null && obj != null) {
                if (AntiHelper.bB(f.this.emT.getErrorCode(), f.this.emT.getErrorString())) {
                    if (AntiHelper.a(f.this.hHU.getActivity(), f.this.emT.getBlockPopInfoData(), f.this.ifO) != null) {
                        TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ah("obj_locate", aw.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = cbZ.getForum().getName();
                String id = cbZ.getForum().getId();
                if (!(obj instanceof u)) {
                    uVar = null;
                } else {
                    uVar = (u) obj;
                }
                boolean z2 = uVar != null && f.this.emT.getErrorCode() == 0;
                if (uVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), uVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aYR();
                } else {
                    z = z2;
                }
                if (uVar == null || !z) {
                    if (f.this.emT.getErrorCode() == 22) {
                        f.this.hHU.showToast(f.this.hHU.getString(R.string.had_liked_forum));
                    } else {
                        f.this.hHU.showToast(f.this.emT.getErrorString());
                    }
                } else {
                    h cbt = f.this.hHU.cbt();
                    if (cbt != null) {
                        cbt.Gy(name);
                    }
                    uVar.setLike(1);
                    cbZ.updateLikeData(uVar);
                    cbZ.setLikeFeedForumDataList(uVar.dku());
                    if (cbt != null) {
                        cbt.a(cbZ, f.this.ifN);
                    }
                    f.this.ifN = true;
                    f.this.hHU.showToast(f.this.hHU.getResources().getString(R.string.attention_success));
                    f.this.p(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                    f.this.ciI();
                }
                f.this.hHU.aB(Boolean.valueOf(z));
            }
        }
    };
    private ac.a ifQ = new ac.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ac.a
        public void x(String str, long j) {
            FrsViewData cbZ;
            if (f.this.hHU != null && (cbZ = f.this.hHU.cbZ()) != null && cbZ.getForum() != null) {
                String name = cbZ.getForum().getName();
                String id = cbZ.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h cbt = f.this.hHU.cbt();
                    if (cbt != null) {
                        cbt.Gy(str);
                    }
                    cbZ.getForum().setLike(0);
                    if (cbt != null) {
                        cbt.wt(0);
                    }
                    f.this.hHU.aA(true);
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
        public void y(String str, long j) {
        }
    };

    public f(FrsFragment frsFragment) {
        this.hHU = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.ifL = tBSpecificationBtn;
        ceP();
    }

    public void ceP() {
        if (this.ifL != null) {
            this.ifL.bci();
        }
    }

    public void awk() {
        bxF();
        ciH();
    }

    public void cgL() {
        if (this.emT != null) {
            this.emT.dkB();
        }
    }

    private void bxF() {
        if (this.hHU != null) {
            this.emT = new LikeModel(this.hHU.getPageContext());
            this.emT.setLoadDataCallBack(this.ifP);
        }
    }

    private void ciH() {
        this.ifM = new ac();
        this.ifM.setFrom("from_frs");
        this.ifM.a(this.ifQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciI() {
        ap apVar = new ap("c13605");
        if (this.hHU != null) {
            com.baidu.tbadk.pageInfo.c.a(this.hHU.getContext(), apVar);
        }
        TiebaStatic.log(apVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cxs().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void oA(boolean z) {
        if (this.hHU != null && this.emT != null) {
            FrsViewData cbZ = this.hHU.cbZ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.hHU.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.hHU.getActivity(), true, 11002)));
            } else if (cbZ != null && cbZ.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.hHU.getFrom())) {
                    TiebaStatic.log(new ap("c10356").dn("fid", cbZ.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.hHU.getFrom())) {
                    TiebaStatic.log(new ap("c10590").ah("obj_type", 2).dn("fid", cbZ.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.hHU.getFrom())) {
                    TiebaStatic.log(new ap("c10587").ah("obj_type", 2).dn("fid", cbZ.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.hHU.getFrom())) {
                    TiebaStatic.log(new ap("c10578").ah("obj_type", 2).dn("fid", cbZ.getForum().getId()));
                }
                this.emT.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.hHU.getFrom())) {
                    TiebaStatic.eventStat(this.hHU.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.hHU.getFrom())) {
                    TiebaStatic.log(new ap("c10359").dn("fid", cbZ.getForum().getId()));
                }
                this.emT.ay(cbZ.getForum().getName(), cbZ.getForum().getId(), "FRS");
                this.ifN = z;
            }
        }
    }

    public void ciJ() {
        if (this.hHU != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hHU.getActivity());
            String str = "";
            FrsViewData cbZ = this.hHU.cbZ();
            if (cbZ != null && cbZ.getForum() != null && cbZ.getForum().getName() != null) {
                str = cbZ.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.xl(String.format(this.hHU.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.xl(this.hHU.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.hHU.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.hHU != null && f.this.ifM != null) {
                        FrsViewData cbZ2 = f.this.hHU.cbZ();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.hHU.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.hHU.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (cbZ2 != null && cbZ2.getForum() != null) {
                            f.this.ifM.J(cbZ2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(cbZ2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.hHU.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hHU.getTbPageContext()).aYL();
        }
    }
}
