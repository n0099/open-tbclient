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
    private FrsFragment hah;
    private TBSpecificationBtn hwP;
    private boolean hwR;
    private LikeModel dKo = null;
    private ac hwQ = null;
    private AntiHelper.a hwS = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).af("obj_locate", at.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).af("obj_locate", at.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d hwT = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData bOY;
            u uVar;
            boolean z = false;
            if (f.this.hah != null && (bOY = f.this.hah.bOY()) != null && bOY.getForum() != null && obj != null) {
                if (AntiHelper.bq(f.this.dKo.getErrorCode(), f.this.dKo.getErrorString())) {
                    if (AntiHelper.a(f.this.hah.getActivity(), f.this.dKo.getBlockPopInfoData(), f.this.hwS) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = bOY.getForum().getName();
                String id = bOY.getForum().getId();
                if (!(obj instanceof u)) {
                    uVar = null;
                } else {
                    uVar = (u) obj;
                }
                boolean z2 = uVar != null && f.this.dKo.getErrorCode() == 0;
                if (uVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), uVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aMZ();
                } else {
                    z = z2;
                }
                if (uVar == null || !z) {
                    if (f.this.dKo.getErrorCode() == 22) {
                        f.this.hah.showToast(f.this.hah.getString(R.string.had_liked_forum));
                    } else {
                        f.this.hah.showToast(f.this.dKo.getErrorString());
                    }
                } else {
                    h bOu = f.this.hah.bOu();
                    if (bOu != null) {
                        bOu.Dz(name);
                    }
                    uVar.setLike(1);
                    bOY.updateLikeData(uVar);
                    bOY.setLikeFeedForumDataList(uVar.cVE());
                    if (bOu != null) {
                        bOu.a(bOY, f.this.hwR);
                    }
                    f.this.hwR = true;
                    f.this.hah.showToast(f.this.hah.getResources().getString(R.string.attention_success));
                    f.this.n(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                    f.this.bVm();
                }
                f.this.hah.aw(Boolean.valueOf(z));
            }
        }
    };
    private ac.a hwU = new ac.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ac.a
        public void A(String str, long j) {
            FrsViewData bOY;
            if (f.this.hah != null && (bOY = f.this.hah.bOY()) != null && bOY.getForum() != null) {
                String name = bOY.getForum().getName();
                String id = bOY.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h bOu = f.this.hah.bOu();
                    if (bOu != null) {
                        bOu.Dz(str);
                    }
                    bOY.getForum().setLike(0);
                    if (bOu != null) {
                        bOu.uO(0);
                    }
                    f.this.hah.av(true);
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
        public void B(String str, long j) {
        }
    };

    public f(FrsFragment frsFragment) {
        this.hah = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.hwP = tBSpecificationBtn;
        bRE();
    }

    public void bRE() {
        if (this.hwP != null) {
            this.hwP.aQp();
        }
    }

    public void aoD() {
        bmb();
        bVl();
    }

    public void aqT() {
        if (this.dKo != null) {
            this.dKo.cVL();
        }
    }

    private void bmb() {
        if (this.hah != null) {
            this.dKo = new LikeModel(this.hah.getPageContext());
            this.dKo.setLoadDataCallBack(this.hwT);
        }
    }

    private void bVl() {
        this.hwQ = new ac();
        this.hwQ.setFrom("from_frs");
        this.hwQ.a(this.hwU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVm() {
        an anVar = new an("c13605");
        if (this.hah != null) {
            com.baidu.tbadk.pageInfo.c.a(this.hah.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.ciV().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void no(boolean z) {
        if (this.hah != null && this.dKo != null) {
            FrsViewData bOY = this.hah.bOY();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.hah.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.hah.getActivity(), true, 11002)));
            } else if (bOY != null && bOY.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.hah.getFrom())) {
                    TiebaStatic.log(new an("c10356").cI("fid", bOY.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.hah.getFrom())) {
                    TiebaStatic.log(new an("c10590").af("obj_type", 2).cI("fid", bOY.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.hah.getFrom())) {
                    TiebaStatic.log(new an("c10587").af("obj_type", 2).cI("fid", bOY.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.hah.getFrom())) {
                    TiebaStatic.log(new an("c10578").af("obj_type", 2).cI("fid", bOY.getForum().getId()));
                }
                this.dKo.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.hah.getFrom())) {
                    TiebaStatic.eventStat(this.hah.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.hah.getFrom())) {
                    TiebaStatic.log(new an("c10359").cI("fid", bOY.getForum().getId()));
                }
                this.dKo.au(bOY.getForum().getName(), bOY.getForum().getId(), "FRS");
                this.hwR = z;
            }
        }
    }

    public void bVn() {
        if (this.hah != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hah.getActivity());
            String str = "";
            FrsViewData bOY = this.hah.bOY();
            if (bOY != null && bOY.getForum() != null && bOY.getForum().getName() != null) {
                str = bOY.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.uf(String.format(this.hah.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.uf(this.hah.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.hah.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.hah != null && f.this.hwQ != null) {
                        FrsViewData bOY2 = f.this.hah.bOY();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.hah.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.hah.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (bOY2 != null && bOY2.getForum() != null) {
                            f.this.hwQ.L(bOY2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(bOY2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.hah.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hah.getTbPageContext()).aMU();
        }
    }
}
