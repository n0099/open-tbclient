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
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes6.dex */
public class f {
    private TBSpecificationBtn gGF;
    private boolean gGH;
    private FrsFragment gkN;
    private LikeModel dfB = null;
    private y gGG = null;
    private AntiHelper.a gGI = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.d gGJ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            FrsViewData bBI;
            t tVar;
            boolean z = false;
            if (f.this.gkN != null && (bBI = f.this.gkN.bBI()) != null && bBI.getForum() != null && obj != null) {
                if (AntiHelper.aW(f.this.dfB.getErrorCode(), f.this.dfB.getErrorString())) {
                    if (AntiHelper.a(f.this.gkN.getActivity(), f.this.dfB.getBlockPopInfoData(), f.this.gGI) != null) {
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = bBI.getForum().getName();
                String id = bBI.getForum().getId();
                if (!(obj instanceof t)) {
                    tVar = null;
                } else {
                    tVar = (t) obj;
                }
                boolean z2 = tVar != null && f.this.dfB.getErrorCode() == 0;
                if (tVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), tVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aCb();
                } else {
                    z = z2;
                }
                if (tVar == null || !z) {
                    if (f.this.dfB.getErrorCode() == 22) {
                        f.this.gkN.showToast(f.this.gkN.getString(R.string.had_liked_forum));
                    } else {
                        f.this.gkN.showToast(f.this.dfB.getErrorString());
                    }
                } else {
                    h bBf = f.this.gkN.bBf();
                    if (bBf != null) {
                        bBf.Bq(name);
                    }
                    tVar.setLike(1);
                    bBI.updateLikeData(tVar);
                    bBI.setLikeFeedForumDataList(tVar.cHB());
                    if (bBf != null) {
                        bBf.a(bBI, f.this.gGH);
                    }
                    f.this.gGH = true;
                    f.this.gkN.showToast(f.this.gkN.getResources().getString(R.string.attention_success));
                    f.this.l(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                    f.this.bHS();
                }
                f.this.gkN.as(Boolean.valueOf(z));
            }
        }
    };
    private y.a gGK = new y.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.y.a
        public void C(String str, long j) {
            FrsViewData bBI;
            if (f.this.gkN != null && (bBI = f.this.gkN.bBI()) != null && bBI.getForum() != null) {
                String name = bBI.getForum().getName();
                String id = bBI.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h bBf = f.this.gkN.bBf();
                    if (bBf != null) {
                        bBf.Bq(str);
                    }
                    bBI.getForum().setLike(0);
                    if (bBf != null) {
                        bBf.ua(0);
                    }
                    f.this.gkN.ar(true);
                    f.this.l(false, id);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                    t tVar = new t();
                    tVar.setLike(0);
                    tVar.setFid(id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.y.a
        public void D(String str, long j) {
        }
    };

    public f(FrsFragment frsFragment) {
        this.gkN = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.gGF = tBSpecificationBtn;
        bEh();
    }

    public void bEh() {
        if (this.gGF != null) {
            this.gGF.aFd();
        }
    }

    public void adM() {
        bas();
        bHR();
    }

    public void afZ() {
        if (this.dfB != null) {
            this.dfB.cHI();
        }
    }

    private void bas() {
        if (this.gkN != null) {
            this.dfB = new LikeModel(this.gkN.getPageContext());
            this.dfB.setLoadDataCallBack(this.gGJ);
        }
    }

    private void bHR() {
        this.gGG = new y();
        this.gGG.setFrom("from_frs");
        this.gGG.a(this.gGK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHS() {
        an anVar = new an("c13605");
        if (this.gkN != null) {
            com.baidu.tbadk.pageInfo.c.a(this.gkN.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.bVp().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void lR(boolean z) {
        if (this.gkN != null && this.dfB != null) {
            FrsViewData bBI = this.gkN.bBI();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.gkN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.gkN.getActivity(), true, 11002)));
            } else if (bBI != null && bBI.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.gkN.getFrom())) {
                    TiebaStatic.log(new an("c10356").cp("fid", bBI.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.gkN.getFrom())) {
                    TiebaStatic.log(new an("c10590").Z("obj_type", 2).cp("fid", bBI.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.gkN.getFrom())) {
                    TiebaStatic.log(new an("c10587").Z("obj_type", 2).cp("fid", bBI.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.gkN.getFrom())) {
                    TiebaStatic.log(new an("c10578").Z("obj_type", 2).cp("fid", bBI.getForum().getId()));
                }
                this.dfB.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.gkN.getFrom())) {
                    TiebaStatic.eventStat(this.gkN.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.gkN.getFrom())) {
                    TiebaStatic.log(new an("c10359").cp("fid", bBI.getForum().getId()));
                }
                this.dfB.at(bBI.getForum().getName(), bBI.getForum().getId(), "FRS");
                this.gGH = z;
            }
        }
    }

    public void bHT() {
        if (this.gkN != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gkN.getActivity());
            String str = "";
            FrsViewData bBI = this.gkN.bBI();
            if (bBI != null && bBI.getForum() != null && bBI.getForum().getName() != null) {
                str = bBI.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.sz(String.format(this.gkN.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.sz(this.gkN.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.gkN.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.gkN != null && f.this.gGG != null) {
                        FrsViewData bBI2 = f.this.gkN.bBI();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.gkN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.gkN.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (bBI2 != null && bBI2.getForum() != null) {
                            f.this.gGG.K(bBI2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(bBI2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.gkN.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.gkN.getTbPageContext()).aBW();
        }
    }
}
