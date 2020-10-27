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
/* loaded from: classes22.dex */
public class f {
    private FrsFragment iDN;
    private TBSpecificationBtn jcD;
    private boolean jcF;
    private LikeModel eTL = null;
    private ad jcE = null;
    private AntiHelper.a jcG = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d jcH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData cwo;
            v vVar;
            if (f.this.iDN != null && (cwo = f.this.iDN.cwo()) != null && cwo.getForum() != null && obj != null) {
                if (AntiHelper.bN(f.this.eTL.getErrorCode(), f.this.eTL.getErrorString())) {
                    if (AntiHelper.a(f.this.iDN.getActivity(), f.this.eTL.getBlockPopInfoData(), f.this.jcG) != null) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = cwo.getForum().getName();
                String id = cwo.getForum().getId();
                if (!(obj instanceof v)) {
                    vVar = null;
                } else {
                    vVar = (v) obj;
                }
                boolean z = vVar != null && f.this.eTL.getErrorCode() == 0;
                if (vVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), vVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bmI();
                    z = false;
                }
                if (vVar == null || !z) {
                    if (f.this.eTL.getErrorCode() == 22) {
                        f.this.iDN.showToast(f.this.iDN.getString(R.string.had_liked_forum));
                    } else {
                        f.this.iDN.showToast(f.this.eTL.getErrorString());
                    }
                } else {
                    h cvH = f.this.iDN.cvH();
                    if (cvH != null) {
                        cvH.KL(name);
                    }
                    vVar.setLike(1);
                    cwo.updateLikeData(vVar);
                    cwo.setLikeFeedForumDataList(vVar.dGI());
                    if (cvH != null) {
                        cvH.a(cwo, f.this.jcF);
                    }
                    f.this.jcF = true;
                    f.this.iDN.showToast(f.this.iDN.getResources().getString(R.string.attention_success));
                    if (com.baidu.tbadk.coreExtra.c.a.w(f.this.iDN.getContext(), 0)) {
                        com.baidu.tbadk.coreExtra.c.a.a(f.this.iDN.getPageContext(), 4, 2000L);
                    }
                    f.this.s(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                    f.this.cDi();
                }
                f.this.iDN.aJ(Boolean.valueOf(z));
            }
        }
    };
    private ad.a jcI = new ad.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void C(String str, long j) {
            FrsViewData cwo;
            if (f.this.iDN != null && (cwo = f.this.iDN.cwo()) != null && cwo.getForum() != null) {
                String name = cwo.getForum().getName();
                String id = cwo.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h cvH = f.this.iDN.cvH();
                    if (cvH != null) {
                        cvH.KL(str);
                    }
                    cwo.getForum().setLike(0);
                    if (cvH != null) {
                        cvH.Ak(0);
                    }
                    f.this.iDN.aI(true);
                    f.this.s(false, id);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                    v vVar = new v();
                    vVar.setLike(0);
                    vVar.setFid(id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void D(String str, long j) {
        }
    };

    public f(FrsFragment frsFragment) {
        this.iDN = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jcD = tBSpecificationBtn;
        czl();
    }

    public void czl() {
        if (this.jcD != null) {
            this.jcD.bqd();
        }
    }

    public void aJH() {
        bNj();
        cDh();
    }

    public void cBk() {
        if (this.eTL != null) {
            this.eTL.dGQ();
        }
    }

    private void bNj() {
        if (this.iDN != null) {
            this.eTL = new LikeModel(this.iDN.getPageContext());
            this.eTL.setLoadDataCallBack(this.jcH);
        }
    }

    private void cDh() {
        this.jcE = new ad();
        this.jcE.setFrom("from_frs");
        this.jcE.a(this.jcI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDi() {
        aq aqVar = new aq("c13605");
        if (this.iDN != null) {
            com.baidu.tbadk.pageInfo.c.a(this.iDN.getContext(), aqVar);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cSF().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void qj(boolean z) {
        if (this.iDN != null && this.eTL != null) {
            FrsViewData cwo = this.iDN.cwo();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.iDN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.iDN.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_LIKE)));
            } else if (cwo != null && cwo.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.iDN.getFrom())) {
                    TiebaStatic.log(new aq("c10356").dR("fid", cwo.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.iDN.getFrom())) {
                    TiebaStatic.log(new aq("c10590").aj("obj_type", 2).dR("fid", cwo.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.iDN.getFrom())) {
                    TiebaStatic.log(new aq("c10587").aj("obj_type", 2).dR("fid", cwo.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.iDN.getFrom())) {
                    TiebaStatic.log(new aq("c10578").aj("obj_type", 2).dR("fid", cwo.getForum().getId()));
                }
                this.eTL.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.iDN.getFrom())) {
                    TiebaStatic.eventStat(this.iDN.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.iDN.getFrom())) {
                    TiebaStatic.log(new aq("c10359").dR("fid", cwo.getForum().getId()));
                }
                this.eTL.aH(cwo.getForum().getName(), cwo.getForum().getId(), "FRS");
                this.jcF = z;
            }
        }
    }

    public void cDj() {
        if (this.iDN != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iDN.getActivity());
            String str = "";
            FrsViewData cwo = this.iDN.cwo();
            if (cwo != null && cwo.getForum() != null && cwo.getForum().getName() != null) {
                str = cwo.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.Ba(String.format(this.iDN.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.Ba(this.iDN.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.iDN.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.iDN != null && f.this.jcE != null) {
                        FrsViewData cwo2 = f.this.iDN.cwo();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.iDN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.iDN.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (cwo2 != null && cwo2.getForum() != null) {
                            f.this.jcE.O(cwo2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(cwo2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.iDN.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iDN.getTbPageContext()).bmC();
        }
    }

    public void ff(String str, String str2) {
        if (this.eTL != null) {
            this.eTL.aH(str, str2, "FRS");
        }
    }
}
