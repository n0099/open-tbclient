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
    private TBSpecificationBtn hLI;
    private boolean hLK;
    private FrsFragment hpb;
    private LikeModel dYI = null;
    private ac hLJ = null;
    private AntiHelper.a hLL = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d hLM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData bVs;
            u uVar;
            boolean z = false;
            if (f.this.hpb != null && (bVs = f.this.hpb.bVs()) != null && bVs.getForum() != null && obj != null) {
                if (AntiHelper.bv(f.this.dYI.getErrorCode(), f.this.dYI.getErrorString())) {
                    if (AntiHelper.a(f.this.hpb.getActivity(), f.this.dYI.getBlockPopInfoData(), f.this.hLL) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = bVs.getForum().getName();
                String id = bVs.getForum().getId();
                if (!(obj instanceof u)) {
                    uVar = null;
                } else {
                    uVar = (u) obj;
                }
                boolean z2 = uVar != null && f.this.dYI.getErrorCode() == 0;
                if (uVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), uVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aSY();
                } else {
                    z = z2;
                }
                if (uVar == null || !z) {
                    if (f.this.dYI.getErrorCode() == 22) {
                        f.this.hpb.showToast(f.this.hpb.getString(R.string.had_liked_forum));
                    } else {
                        f.this.hpb.showToast(f.this.dYI.getErrorString());
                    }
                } else {
                    h bUO = f.this.hpb.bUO();
                    if (bUO != null) {
                        bUO.Fl(name);
                    }
                    uVar.setLike(1);
                    bVs.updateLikeData(uVar);
                    bVs.setLikeFeedForumDataList(uVar.dcG());
                    if (bUO != null) {
                        bUO.a(bVs, f.this.hLK);
                    }
                    f.this.hLK = true;
                    f.this.hpb.showToast(f.this.hpb.getResources().getString(R.string.attention_success));
                    f.this.n(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                    f.this.cbI();
                }
                f.this.hpb.aA(Boolean.valueOf(z));
            }
        }
    };
    private ac.a hLN = new ac.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ac.a
        public void z(String str, long j) {
            FrsViewData bVs;
            if (f.this.hpb != null && (bVs = f.this.hpb.bVs()) != null && bVs.getForum() != null) {
                String name = bVs.getForum().getName();
                String id = bVs.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h bUO = f.this.hpb.bUO();
                    if (bUO != null) {
                        bUO.Fl(str);
                    }
                    bVs.getForum().setLike(0);
                    if (bUO != null) {
                        bUO.vu(0);
                    }
                    f.this.hpb.az(true);
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
        public void A(String str, long j) {
        }
    };

    public f(FrsFragment frsFragment) {
        this.hpb = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.hLI = tBSpecificationBtn;
        bXZ();
    }

    public void bXZ() {
        if (this.hLI != null) {
            this.hLI.aWq();
        }
    }

    public void atc() {
        brx();
        cbH();
    }

    public void bZP() {
        if (this.dYI != null) {
            this.dYI.dcN();
        }
    }

    private void brx() {
        if (this.hpb != null) {
            this.dYI = new LikeModel(this.hpb.getPageContext());
            this.dYI.setLoadDataCallBack(this.hLM);
        }
    }

    private void cbH() {
        this.hLJ = new ac();
        this.hLJ.setFrom("from_frs");
        this.hLJ.a(this.hLN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbI() {
        an anVar = new an("c13605");
        if (this.hpb != null) {
            com.baidu.tbadk.pageInfo.c.a(this.hpb.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cpr().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void nJ(boolean z) {
        if (this.hpb != null && this.dYI != null) {
            FrsViewData bVs = this.hpb.bVs();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.hpb.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.hpb.getActivity(), true, 11002)));
            } else if (bVs != null && bVs.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.hpb.getFrom())) {
                    TiebaStatic.log(new an("c10356").dh("fid", bVs.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.hpb.getFrom())) {
                    TiebaStatic.log(new an("c10590").ag("obj_type", 2).dh("fid", bVs.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.hpb.getFrom())) {
                    TiebaStatic.log(new an("c10587").ag("obj_type", 2).dh("fid", bVs.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.hpb.getFrom())) {
                    TiebaStatic.log(new an("c10578").ag("obj_type", 2).dh("fid", bVs.getForum().getId()));
                }
                this.dYI.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.hpb.getFrom())) {
                    TiebaStatic.eventStat(this.hpb.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.hpb.getFrom())) {
                    TiebaStatic.log(new an("c10359").dh("fid", bVs.getForum().getId()));
                }
                this.dYI.ay(bVs.getForum().getName(), bVs.getForum().getId(), "FRS");
                this.hLK = z;
            }
        }
    }

    public void cbJ() {
        if (this.hpb != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hpb.getActivity());
            String str = "";
            FrsViewData bVs = this.hpb.bVs();
            if (bVs != null && bVs.getForum() != null && bVs.getForum().getName() != null) {
                str = bVs.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.vO(String.format(this.hpb.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.vO(this.hpb.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.hpb.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.hpb != null && f.this.hLJ != null) {
                        FrsViewData bVs2 = f.this.hpb.bVs();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.hpb.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.hpb.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (bVs2 != null && bVs2.getForum() != null) {
                            f.this.hLJ.K(bVs2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(bVs2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.hpb.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.hpb.getTbPageContext()).aST();
        }
    }
}
