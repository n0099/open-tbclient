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
/* loaded from: classes21.dex */
public class f {
    private TBSpecificationBtn iBr;
    private boolean iBt;
    private FrsFragment icq;
    private LikeModel ezi = null;
    private ad iBs = null;
    private AntiHelper.a iBu = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d iBv = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData cpJ;
            v vVar;
            if (f.this.icq != null && (cpJ = f.this.icq.cpJ()) != null && cpJ.getForum() != null && obj != null) {
                if (AntiHelper.bC(f.this.ezi.getErrorCode(), f.this.ezi.getErrorString())) {
                    if (AntiHelper.a(f.this.icq.getActivity(), f.this.ezi.getBlockPopInfoData(), f.this.iBu) != null) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = cpJ.getForum().getName();
                String id = cpJ.getForum().getId();
                if (!(obj instanceof v)) {
                    vVar = null;
                } else {
                    vVar = (v) obj;
                }
                boolean z = vVar != null && f.this.ezi.getErrorCode() == 0;
                if (vVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), vVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).big();
                    z = false;
                }
                if (vVar == null || !z) {
                    if (f.this.ezi.getErrorCode() == 22) {
                        f.this.icq.showToast(f.this.icq.getString(R.string.had_liked_forum));
                    } else {
                        f.this.icq.showToast(f.this.ezi.getErrorString());
                    }
                } else {
                    h cpc = f.this.icq.cpc();
                    if (cpc != null) {
                        cpc.Jz(name);
                    }
                    vVar.setLike(1);
                    cpJ.updateLikeData(vVar);
                    cpJ.setLikeFeedForumDataList(vVar.dzP());
                    if (cpc != null) {
                        cpc.a(cpJ, f.this.iBt);
                    }
                    f.this.iBt = true;
                    f.this.icq.showToast(f.this.icq.getResources().getString(R.string.attention_success));
                    if (com.baidu.tbadk.coreExtra.c.a.w(f.this.icq.getContext(), 0)) {
                        com.baidu.tbadk.coreExtra.c.a.a(f.this.icq.getPageContext(), 4, 2000L);
                    }
                    f.this.q(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                    f.this.cwE();
                }
                f.this.icq.aF(Boolean.valueOf(z));
            }
        }
    };
    private ad.a iBw = new ad.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void z(String str, long j) {
            FrsViewData cpJ;
            if (f.this.icq != null && (cpJ = f.this.icq.cpJ()) != null && cpJ.getForum() != null) {
                String name = cpJ.getForum().getName();
                String id = cpJ.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h cpc = f.this.icq.cpc();
                    if (cpc != null) {
                        cpc.Jz(str);
                    }
                    cpJ.getForum().setLike(0);
                    if (cpc != null) {
                        cpc.zl(0);
                    }
                    f.this.icq.aE(true);
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
        public void A(String str, long j) {
        }
    };

    public f(FrsFragment frsFragment) {
        this.icq = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.iBr = tBSpecificationBtn;
        csH();
    }

    public void csH() {
        if (this.iBr != null) {
            this.iBr.blA();
        }
    }

    public void aFe() {
        bHV();
        cwD();
    }

    public void cuG() {
        if (this.ezi != null) {
            this.ezi.dzW();
        }
    }

    private void bHV() {
        if (this.icq != null) {
            this.ezi = new LikeModel(this.icq.getPageContext());
            this.ezi.setLoadDataCallBack(this.iBv);
        }
    }

    private void cwD() {
        this.iBs = new ad();
        this.iBs.setFrom("from_frs");
        this.iBs.a(this.iBw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwE() {
        aq aqVar = new aq("c13605");
        if (this.icq != null) {
            com.baidu.tbadk.pageInfo.c.a(this.icq.getContext(), aqVar);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cLQ().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void pm(boolean z) {
        if (this.icq != null && this.ezi != null) {
            FrsViewData cpJ = this.icq.cpJ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.icq.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.icq.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_LIKE)));
            } else if (cpJ != null && cpJ.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.icq.getFrom())) {
                    TiebaStatic.log(new aq("c10356").dF("fid", cpJ.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.icq.getFrom())) {
                    TiebaStatic.log(new aq("c10590").ai("obj_type", 2).dF("fid", cpJ.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.icq.getFrom())) {
                    TiebaStatic.log(new aq("c10587").ai("obj_type", 2).dF("fid", cpJ.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.icq.getFrom())) {
                    TiebaStatic.log(new aq("c10578").ai("obj_type", 2).dF("fid", cpJ.getForum().getId()));
                }
                this.ezi.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.icq.getFrom())) {
                    TiebaStatic.eventStat(this.icq.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.icq.getFrom())) {
                    TiebaStatic.log(new aq("c10359").dF("fid", cpJ.getForum().getId()));
                }
                this.ezi.ay(cpJ.getForum().getName(), cpJ.getForum().getId(), "FRS");
                this.iBt = z;
            }
        }
    }

    public void cwF() {
        if (this.icq != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.icq.getActivity());
            String str = "";
            FrsViewData cpJ = this.icq.cpJ();
            if (cpJ != null && cpJ.getForum() != null && cpJ.getForum().getName() != null) {
                str = cpJ.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.zV(String.format(this.icq.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.zV(this.icq.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.icq.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.icq != null && f.this.iBs != null) {
                        FrsViewData cpJ2 = f.this.icq.cpJ();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.icq.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.icq.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (cpJ2 != null && cpJ2.getForum() != null) {
                            f.this.iBs.L(cpJ2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(cpJ2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.icq.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.icq.getTbPageContext()).bia();
        }
    }

    public void eU(String str, String str2) {
        if (this.ezi != null) {
            this.ezi.ay(str, str2, "FRS");
        }
    }
}
