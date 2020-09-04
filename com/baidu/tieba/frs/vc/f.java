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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes16.dex */
public class f {
    private FrsFragment hVq;
    private TBSpecificationBtn itV;
    private boolean itX;
    private LikeModel exb = null;
    private ad itW = null;
    private AntiHelper.a itY = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d itZ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData cmx;
            v vVar;
            if (f.this.hVq != null && (cmx = f.this.hVq.cmx()) != null && cmx.getForum() != null && obj != null) {
                if (AntiHelper.by(f.this.exb.getErrorCode(), f.this.exb.getErrorString())) {
                    if (AntiHelper.a(f.this.hVq.getActivity(), f.this.exb.getBlockPopInfoData(), f.this.itY) != null) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = cmx.getForum().getName();
                String id = cmx.getForum().getId();
                if (!(obj instanceof v)) {
                    vVar = null;
                } else {
                    vVar = (v) obj;
                }
                boolean z = vVar != null && f.this.exb.getErrorCode() == 0;
                if (vVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), vVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bhm();
                    z = false;
                }
                if (vVar == null || !z) {
                    if (f.this.exb.getErrorCode() == 22) {
                        f.this.hVq.showToast(f.this.hVq.getString(R.string.had_liked_forum));
                    } else {
                        f.this.hVq.showToast(f.this.exb.getErrorString());
                    }
                } else {
                    h clQ = f.this.hVq.clQ();
                    if (clQ != null) {
                        clQ.Jb(name);
                    }
                    vVar.setLike(1);
                    cmx.updateLikeData(vVar);
                    cmx.setLikeFeedForumDataList(vVar.dvW());
                    if (clQ != null) {
                        clQ.a(cmx, f.this.itX);
                    }
                    f.this.itX = true;
                    f.this.hVq.showToast(f.this.hVq.getResources().getString(R.string.attention_success));
                    if (com.baidu.tbadk.coreExtra.c.a.w(f.this.hVq.getContext(), 0)) {
                        com.baidu.tbadk.coreExtra.c.a.a(f.this.hVq.getPageContext(), 4, 2000L);
                    }
                    f.this.q(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                    f.this.ctn();
                }
                f.this.hVq.aD(Boolean.valueOf(z));
            }
        }
    };
    private ad.a iua = new ad.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void y(String str, long j) {
            FrsViewData cmx;
            if (f.this.hVq != null && (cmx = f.this.hVq.cmx()) != null && cmx.getForum() != null) {
                String name = cmx.getForum().getName();
                String id = cmx.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h clQ = f.this.hVq.clQ();
                    if (clQ != null) {
                        clQ.Jb(str);
                    }
                    cmx.getForum().setLike(0);
                    if (clQ != null) {
                        clQ.yM(0);
                    }
                    f.this.hVq.aC(true);
                    f.this.q(false, id);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                    v vVar = new v();
                    vVar.setLike(0);
                    vVar.setFid(id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void z(String str, long j) {
        }
    };

    public f(FrsFragment frsFragment) {
        this.hVq = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.itV = tBSpecificationBtn;
        cpu();
    }

    public void cpu() {
        if (this.itV != null) {
            this.itV.bkF();
        }
    }

    public void aEu() {
        bGF();
        ctm();
    }

    public void crr() {
        if (this.exb != null) {
            this.exb.dwd();
        }
    }

    private void bGF() {
        if (this.hVq != null) {
            this.exb = new LikeModel(this.hVq.getPageContext());
            this.exb.setLoadDataCallBack(this.itZ);
        }
    }

    private void ctm() {
        this.itW = new ad();
        this.itW.setFrom("from_frs");
        this.itW.a(this.iua);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctn() {
        aq aqVar = new aq("c13605");
        if (this.hVq != null) {
            com.baidu.tbadk.pageInfo.c.a(this.hVq.getContext(), aqVar);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cIk().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void pg(boolean z) {
        if (this.hVq != null && this.exb != null) {
            FrsViewData cmx = this.hVq.cmx();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.hVq.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.hVq.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_LIKE)));
            } else if (cmx != null && cmx.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.hVq.getFrom())) {
                    TiebaStatic.log(new aq("c10356").dD("fid", cmx.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.hVq.getFrom())) {
                    TiebaStatic.log(new aq("c10590").ai("obj_type", 2).dD("fid", cmx.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.hVq.getFrom())) {
                    TiebaStatic.log(new aq("c10587").ai("obj_type", 2).dD("fid", cmx.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.hVq.getFrom())) {
                    TiebaStatic.log(new aq("c10578").ai("obj_type", 2).dD("fid", cmx.getForum().getId()));
                }
                this.exb.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.hVq.getFrom())) {
                    TiebaStatic.eventStat(this.hVq.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.hVq.getFrom())) {
                    TiebaStatic.log(new aq("c10359").dD("fid", cmx.getForum().getId()));
                }
                this.exb.ay(cmx.getForum().getName(), cmx.getForum().getId(), "FRS");
                this.itX = z;
            }
        }
    }

    public void cto() {
        if (this.hVq != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hVq.getActivity());
            String str = "";
            FrsViewData cmx = this.hVq.cmx();
            if (cmx != null && cmx.getForum() != null && cmx.getForum().getName() != null) {
                str = cmx.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.zA(String.format(this.hVq.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.zA(this.hVq.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.hVq.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.hVq != null && f.this.itW != null) {
                        FrsViewData cmx2 = f.this.hVq.cmx();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.hVq.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.hVq.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (cmx2 != null && cmx2.getForum() != null) {
                            f.this.itW.K(cmx2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(cmx2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.hVq.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hVq.getTbPageContext()).bhg();
        }
    }
}
