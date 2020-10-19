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
    private TBSpecificationBtn iQh;
    private boolean iQj;
    private FrsFragment irr;
    private LikeModel eLp = null;
    private ad iQi = null;
    private AntiHelper.a iQk = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d iQl = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData cth;
            v vVar;
            if (f.this.irr != null && (cth = f.this.irr.cth()) != null && cth.getForum() != null && obj != null) {
                if (AntiHelper.bM(f.this.eLp.getErrorCode(), f.this.eLp.getErrorString())) {
                    if (AntiHelper.a(f.this.irr.getActivity(), f.this.eLp.getBlockPopInfoData(), f.this.iQk) != null) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = cth.getForum().getName();
                String id = cth.getForum().getId();
                if (!(obj instanceof v)) {
                    vVar = null;
                } else {
                    vVar = (v) obj;
                }
                boolean z = vVar != null && f.this.eLp.getErrorCode() == 0;
                if (vVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), vVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bkP();
                    z = false;
                }
                if (vVar == null || !z) {
                    if (f.this.eLp.getErrorCode() == 22) {
                        f.this.irr.showToast(f.this.irr.getString(R.string.had_liked_forum));
                    } else {
                        f.this.irr.showToast(f.this.eLp.getErrorString());
                    }
                } else {
                    h csA = f.this.irr.csA();
                    if (csA != null) {
                        csA.Km(name);
                    }
                    vVar.setLike(1);
                    cth.updateLikeData(vVar);
                    cth.setLikeFeedForumDataList(vVar.dDA());
                    if (csA != null) {
                        csA.a(cth, f.this.iQj);
                    }
                    f.this.iQj = true;
                    f.this.irr.showToast(f.this.irr.getResources().getString(R.string.attention_success));
                    if (com.baidu.tbadk.coreExtra.c.a.w(f.this.irr.getContext(), 0)) {
                        com.baidu.tbadk.coreExtra.c.a.a(f.this.irr.getPageContext(), 4, 2000L);
                    }
                    f.this.q(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                    f.this.cAb();
                }
                f.this.irr.aI(Boolean.valueOf(z));
            }
        }
    };
    private ad.a iQm = new ad.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void z(String str, long j) {
            FrsViewData cth;
            if (f.this.irr != null && (cth = f.this.irr.cth()) != null && cth.getForum() != null) {
                String name = cth.getForum().getName();
                String id = cth.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h csA = f.this.irr.csA();
                    if (csA != null) {
                        csA.Km(str);
                    }
                    cth.getForum().setLike(0);
                    if (csA != null) {
                        csA.zR(0);
                    }
                    f.this.irr.aH(true);
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
        this.irr = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.iQh = tBSpecificationBtn;
        cwe();
    }

    public void cwe() {
        if (this.iQh != null) {
            this.iQh.bok();
        }
    }

    public void aHN() {
        bKH();
        cAa();
    }

    public void cyd() {
        if (this.eLp != null) {
            this.eLp.dDI();
        }
    }

    private void bKH() {
        if (this.irr != null) {
            this.eLp = new LikeModel(this.irr.getPageContext());
            this.eLp.setLoadDataCallBack(this.iQl);
        }
    }

    private void cAa() {
        this.iQi = new ad();
        this.iQi.setFrom("from_frs");
        this.iQi.a(this.iQm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAb() {
        aq aqVar = new aq("c13605");
        if (this.irr != null) {
            com.baidu.tbadk.pageInfo.c.a(this.irr.getContext(), aqVar);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cPy().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void pR(boolean z) {
        if (this.irr != null && this.eLp != null) {
            FrsViewData cth = this.irr.cth();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.irr.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.irr.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_LIKE)));
            } else if (cth != null && cth.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.irr.getFrom())) {
                    TiebaStatic.log(new aq("c10356").dK("fid", cth.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.irr.getFrom())) {
                    TiebaStatic.log(new aq("c10590").aj("obj_type", 2).dK("fid", cth.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.irr.getFrom())) {
                    TiebaStatic.log(new aq("c10587").aj("obj_type", 2).dK("fid", cth.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.irr.getFrom())) {
                    TiebaStatic.log(new aq("c10578").aj("obj_type", 2).dK("fid", cth.getForum().getId()));
                }
                this.eLp.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.irr.getFrom())) {
                    TiebaStatic.eventStat(this.irr.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.irr.getFrom())) {
                    TiebaStatic.log(new aq("c10359").dK("fid", cth.getForum().getId()));
                }
                this.eLp.aA(cth.getForum().getName(), cth.getForum().getId(), "FRS");
                this.iQj = z;
            }
        }
    }

    public void cAc() {
        if (this.irr != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.irr.getActivity());
            String str = "";
            FrsViewData cth = this.irr.cth();
            if (cth != null && cth.getForum() != null && cth.getForum().getName() != null) {
                str = cth.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.AH(String.format(this.irr.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.AH(this.irr.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.irr.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.irr != null && f.this.iQi != null) {
                        FrsViewData cth2 = f.this.irr.cth();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.irr.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.irr.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (cth2 != null && cth2.getForum() != null) {
                            f.this.iQi.L(cth2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(cth2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.irr.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.irr.getTbPageContext()).bkJ();
        }
    }

    public void fa(String str, String str2) {
        if (this.eLp != null) {
            this.eLp.aA(str, str2, "FRS");
        }
    }
}
