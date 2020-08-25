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
    private FrsFragment hVk;
    private TBSpecificationBtn itP;
    private boolean itR;
    private LikeModel ewX = null;
    private ad itQ = null;
    private AntiHelper.a itS = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d itT = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData cmw;
            v vVar;
            if (f.this.hVk != null && (cmw = f.this.hVk.cmw()) != null && cmw.getForum() != null && obj != null) {
                if (AntiHelper.bz(f.this.ewX.getErrorCode(), f.this.ewX.getErrorString())) {
                    if (AntiHelper.a(f.this.hVk.getActivity(), f.this.ewX.getBlockPopInfoData(), f.this.itS) != null) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = cmw.getForum().getName();
                String id = cmw.getForum().getId();
                if (!(obj instanceof v)) {
                    vVar = null;
                } else {
                    vVar = (v) obj;
                }
                boolean z = vVar != null && f.this.ewX.getErrorCode() == 0;
                if (vVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), vVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bhm();
                    z = false;
                }
                if (vVar == null || !z) {
                    if (f.this.ewX.getErrorCode() == 22) {
                        f.this.hVk.showToast(f.this.hVk.getString(R.string.had_liked_forum));
                    } else {
                        f.this.hVk.showToast(f.this.ewX.getErrorString());
                    }
                } else {
                    h clP = f.this.hVk.clP();
                    if (clP != null) {
                        clP.Ja(name);
                    }
                    vVar.setLike(1);
                    cmw.updateLikeData(vVar);
                    cmw.setLikeFeedForumDataList(vVar.dvR());
                    if (clP != null) {
                        clP.a(cmw, f.this.itR);
                    }
                    f.this.itR = true;
                    f.this.hVk.showToast(f.this.hVk.getResources().getString(R.string.attention_success));
                    if (com.baidu.tbadk.coreExtra.c.a.w(f.this.hVk.getContext(), 0)) {
                        com.baidu.tbadk.coreExtra.c.a.a(f.this.hVk.getPageContext(), 4, 2000L);
                    }
                    f.this.q(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                    f.this.ctm();
                }
                f.this.hVk.aD(Boolean.valueOf(z));
            }
        }
    };
    private ad.a itU = new ad.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void y(String str, long j) {
            FrsViewData cmw;
            if (f.this.hVk != null && (cmw = f.this.hVk.cmw()) != null && cmw.getForum() != null) {
                String name = cmw.getForum().getName();
                String id = cmw.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h clP = f.this.hVk.clP();
                    if (clP != null) {
                        clP.Ja(str);
                    }
                    cmw.getForum().setLike(0);
                    if (clP != null) {
                        clP.yM(0);
                    }
                    f.this.hVk.aC(true);
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
        this.hVk = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.itP = tBSpecificationBtn;
        cpt();
    }

    public void cpt() {
        if (this.itP != null) {
            this.itP.bkF();
        }
    }

    public void aEu() {
        bGE();
        ctl();
    }

    public void crq() {
        if (this.ewX != null) {
            this.ewX.dvY();
        }
    }

    private void bGE() {
        if (this.hVk != null) {
            this.ewX = new LikeModel(this.hVk.getPageContext());
            this.ewX.setLoadDataCallBack(this.itT);
        }
    }

    private void ctl() {
        this.itQ = new ad();
        this.itQ.setFrom("from_frs");
        this.itQ.a(this.itU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctm() {
        aq aqVar = new aq("c13605");
        if (this.hVk != null) {
            com.baidu.tbadk.pageInfo.c.a(this.hVk.getContext(), aqVar);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cIj().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void pe(boolean z) {
        if (this.hVk != null && this.ewX != null) {
            FrsViewData cmw = this.hVk.cmw();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.hVk.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.hVk.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_LIKE)));
            } else if (cmw != null && cmw.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.hVk.getFrom())) {
                    TiebaStatic.log(new aq("c10356").dD("fid", cmw.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.hVk.getFrom())) {
                    TiebaStatic.log(new aq("c10590").ai("obj_type", 2).dD("fid", cmw.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.hVk.getFrom())) {
                    TiebaStatic.log(new aq("c10587").ai("obj_type", 2).dD("fid", cmw.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.hVk.getFrom())) {
                    TiebaStatic.log(new aq("c10578").ai("obj_type", 2).dD("fid", cmw.getForum().getId()));
                }
                this.ewX.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.hVk.getFrom())) {
                    TiebaStatic.eventStat(this.hVk.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.hVk.getFrom())) {
                    TiebaStatic.log(new aq("c10359").dD("fid", cmw.getForum().getId()));
                }
                this.ewX.ay(cmw.getForum().getName(), cmw.getForum().getId(), "FRS");
                this.itR = z;
            }
        }
    }

    public void ctn() {
        if (this.hVk != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hVk.getActivity());
            String str = "";
            FrsViewData cmw = this.hVk.cmw();
            if (cmw != null && cmw.getForum() != null && cmw.getForum().getName() != null) {
                str = cmw.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.zz(String.format(this.hVk.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.zz(this.hVk.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.hVk.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.hVk != null && f.this.itQ != null) {
                        FrsViewData cmw2 = f.this.hVk.cmw();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.hVk.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.hVk.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (cmw2 != null && cmw2.getForum() != null) {
                            f.this.itQ.K(cmw2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(cmw2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.hVk.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hVk.getTbPageContext()).bhg();
        }
    }
}
