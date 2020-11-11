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
    private FrsFragment iJK;
    private TBSpecificationBtn jiB;
    private boolean jiD;
    private LikeModel eZA = null;
    private ad jiC = null;
    private AntiHelper.a jiE = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d jiF = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData cyP;
            v vVar;
            if (f.this.iJK != null && (cyP = f.this.iJK.cyP()) != null && cyP.getForum() != null && obj != null) {
                if (AntiHelper.bR(f.this.eZA.getErrorCode(), f.this.eZA.getErrorString())) {
                    if (AntiHelper.a(f.this.iJK.getActivity(), f.this.eZA.getBlockPopInfoData(), f.this.jiE) != null) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ax.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = cyP.getForum().getName();
                String id = cyP.getForum().getId();
                if (!(obj instanceof v)) {
                    vVar = null;
                } else {
                    vVar = (v) obj;
                }
                boolean z = vVar != null && f.this.eZA.getErrorCode() == 0;
                if (vVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), vVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bpi();
                    z = false;
                }
                if (vVar == null || !z) {
                    if (f.this.eZA.getErrorCode() == 22) {
                        f.this.iJK.showToast(f.this.iJK.getString(R.string.had_liked_forum));
                    } else {
                        f.this.iJK.showToast(f.this.eZA.getErrorString());
                    }
                } else {
                    h cyi = f.this.iJK.cyi();
                    if (cyi != null) {
                        cyi.Lc(name);
                    }
                    vVar.setLike(1);
                    cyP.updateLikeData(vVar);
                    cyP.setLikeFeedForumDataList(vVar.dJk());
                    if (cyi != null) {
                        cyi.a(cyP, f.this.jiD);
                    }
                    f.this.jiD = true;
                    f.this.iJK.showToast(f.this.iJK.getResources().getString(R.string.attention_success));
                    if (com.baidu.tbadk.coreExtra.c.a.w(f.this.iJK.getContext(), 0)) {
                        com.baidu.tbadk.coreExtra.c.a.a(f.this.iJK.getPageContext(), 4, 2000L);
                    }
                    f.this.s(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                    f.this.cFJ();
                }
                f.this.iJK.aJ(Boolean.valueOf(z));
            }
        }
    };
    private ad.a jiG = new ad.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void C(String str, long j) {
            FrsViewData cyP;
            if (f.this.iJK != null && (cyP = f.this.iJK.cyP()) != null && cyP.getForum() != null) {
                String name = cyP.getForum().getName();
                String id = cyP.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h cyi = f.this.iJK.cyi();
                    if (cyi != null) {
                        cyi.Lc(str);
                    }
                    cyP.getForum().setLike(0);
                    if (cyi != null) {
                        cyi.Ax(0);
                    }
                    f.this.iJK.aI(true);
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
        this.iJK = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jiB = tBSpecificationBtn;
        cBM();
    }

    public void cBM() {
        if (this.jiB != null) {
            this.jiB.bsD();
        }
    }

    public void aMh() {
        bPJ();
        cFI();
    }

    public void cDL() {
        if (this.eZA != null) {
            this.eZA.dJs();
        }
    }

    private void bPJ() {
        if (this.iJK != null) {
            this.eZA = new LikeModel(this.iJK.getPageContext());
            this.eZA.setLoadDataCallBack(this.jiF);
        }
    }

    private void cFI() {
        this.jiC = new ad();
        this.jiC.setFrom("from_frs");
        this.jiC.a(this.jiG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFJ() {
        aq aqVar = new aq("c13605");
        if (this.iJK != null) {
            com.baidu.tbadk.pageInfo.c.a(this.iJK.getContext(), aqVar);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cVg().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void qs(boolean z) {
        if (this.iJK != null && this.eZA != null) {
            FrsViewData cyP = this.iJK.cyP();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.iJK.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.iJK.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_LIKE)));
            } else if (cyP != null && cyP.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.iJK.getFrom())) {
                    TiebaStatic.log(new aq("c10356").dR("fid", cyP.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.iJK.getFrom())) {
                    TiebaStatic.log(new aq("c10590").al("obj_type", 2).dR("fid", cyP.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.iJK.getFrom())) {
                    TiebaStatic.log(new aq("c10587").al("obj_type", 2).dR("fid", cyP.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.iJK.getFrom())) {
                    TiebaStatic.log(new aq("c10578").al("obj_type", 2).dR("fid", cyP.getForum().getId()));
                }
                this.eZA.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.iJK.getFrom())) {
                    TiebaStatic.eventStat(this.iJK.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.iJK.getFrom())) {
                    TiebaStatic.log(new aq("c10359").dR("fid", cyP.getForum().getId()));
                }
                this.eZA.aI(cyP.getForum().getName(), cyP.getForum().getId(), "FRS");
                this.jiD = z;
            }
        }
    }

    public void cFK() {
        if (this.iJK != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iJK.getActivity());
            String str = "";
            FrsViewData cyP = this.iJK.cyP();
            if (cyP != null && cyP.getForum() != null && cyP.getForum().getName() != null) {
                str = cyP.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.Bo(String.format(this.iJK.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.Bo(this.iJK.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.iJK.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.iJK != null && f.this.jiC != null) {
                        FrsViewData cyP2 = f.this.iJK.cyP();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.iJK.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.iJK.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (cyP2 != null && cyP2.getForum() != null) {
                            f.this.jiC.O(cyP2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(cyP2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.iJK.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iJK.getTbPageContext()).bpc();
        }
    }

    public void ff(String str, String str2) {
        if (this.eZA != null) {
            this.eZA.aI(str, str2, "FRS");
        }
    }
}
