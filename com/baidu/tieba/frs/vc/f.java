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
    private FrsFragment han;
    private TBSpecificationBtn hwV;
    private boolean hwX;
    private LikeModel dKs = null;
    private ac hwW = null;
    private AntiHelper.a hwY = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).af("obj_locate", at.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).af("obj_locate", at.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d hwZ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData bOX;
            u uVar;
            boolean z = false;
            if (f.this.han != null && (bOX = f.this.han.bOX()) != null && bOX.getForum() != null && obj != null) {
                if (AntiHelper.bq(f.this.dKs.getErrorCode(), f.this.dKs.getErrorString())) {
                    if (AntiHelper.a(f.this.han.getActivity(), f.this.dKs.getBlockPopInfoData(), f.this.hwY) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = bOX.getForum().getName();
                String id = bOX.getForum().getId();
                if (!(obj instanceof u)) {
                    uVar = null;
                } else {
                    uVar = (u) obj;
                }
                boolean z2 = uVar != null && f.this.dKs.getErrorCode() == 0;
                if (uVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), uVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aMX();
                } else {
                    z = z2;
                }
                if (uVar == null || !z) {
                    if (f.this.dKs.getErrorCode() == 22) {
                        f.this.han.showToast(f.this.han.getString(R.string.had_liked_forum));
                    } else {
                        f.this.han.showToast(f.this.dKs.getErrorString());
                    }
                } else {
                    h bOt = f.this.han.bOt();
                    if (bOt != null) {
                        bOt.DC(name);
                    }
                    uVar.setLike(1);
                    bOX.updateLikeData(uVar);
                    bOX.setLikeFeedForumDataList(uVar.cVC());
                    if (bOt != null) {
                        bOt.a(bOX, f.this.hwX);
                    }
                    f.this.hwX = true;
                    f.this.han.showToast(f.this.han.getResources().getString(R.string.attention_success));
                    f.this.n(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                    f.this.bVl();
                }
                f.this.han.ax(Boolean.valueOf(z));
            }
        }
    };
    private ac.a hxa = new ac.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ac.a
        public void A(String str, long j) {
            FrsViewData bOX;
            if (f.this.han != null && (bOX = f.this.han.bOX()) != null && bOX.getForum() != null) {
                String name = bOX.getForum().getName();
                String id = bOX.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h bOt = f.this.han.bOt();
                    if (bOt != null) {
                        bOt.DC(str);
                    }
                    bOX.getForum().setLike(0);
                    if (bOt != null) {
                        bOt.uO(0);
                    }
                    f.this.han.aw(true);
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
        this.han = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.hwV = tBSpecificationBtn;
        bRD();
    }

    public void bRD() {
        if (this.hwV != null) {
            this.hwV.aQm();
        }
    }

    public void aoC() {
        blZ();
        bVk();
    }

    public void aqS() {
        if (this.dKs != null) {
            this.dKs.cVJ();
        }
    }

    private void blZ() {
        if (this.han != null) {
            this.dKs = new LikeModel(this.han.getPageContext());
            this.dKs.setLoadDataCallBack(this.hwZ);
        }
    }

    private void bVk() {
        this.hwW = new ac();
        this.hwW.setFrom("from_frs");
        this.hwW.a(this.hxa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVl() {
        an anVar = new an("c13605");
        if (this.han != null) {
            com.baidu.tbadk.pageInfo.c.a(this.han.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.ciU().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void no(boolean z) {
        if (this.han != null && this.dKs != null) {
            FrsViewData bOX = this.han.bOX();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.han.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.han.getActivity(), true, 11002)));
            } else if (bOX != null && bOX.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.han.getFrom())) {
                    TiebaStatic.log(new an("c10356").cI("fid", bOX.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.han.getFrom())) {
                    TiebaStatic.log(new an("c10590").af("obj_type", 2).cI("fid", bOX.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.han.getFrom())) {
                    TiebaStatic.log(new an("c10587").af("obj_type", 2).cI("fid", bOX.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.han.getFrom())) {
                    TiebaStatic.log(new an("c10578").af("obj_type", 2).cI("fid", bOX.getForum().getId()));
                }
                this.dKs.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.han.getFrom())) {
                    TiebaStatic.eventStat(this.han.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.han.getFrom())) {
                    TiebaStatic.log(new an("c10359").cI("fid", bOX.getForum().getId()));
                }
                this.dKs.au(bOX.getForum().getName(), bOX.getForum().getId(), "FRS");
                this.hwX = z;
            }
        }
    }

    public void bVm() {
        if (this.han != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.han.getActivity());
            String str = "";
            FrsViewData bOX = this.han.bOX();
            if (bOX != null && bOX.getForum() != null && bOX.getForum().getName() != null) {
                str = bOX.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.ui(String.format(this.han.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.ui(this.han.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.han.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.han != null && f.this.hwW != null) {
                        FrsViewData bOX2 = f.this.han.bOX();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.han.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.han.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (bOX2 != null && bOX2.getForum() != null) {
                            f.this.hwW.L(bOX2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(bOX2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.han.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.han.getTbPageContext()).aMS();
        }
    }
}
