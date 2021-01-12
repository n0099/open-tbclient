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
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes2.dex */
public class f {
    private TBSpecificationBtn jEF;
    private boolean jEH;
    private FrsFragment jcX;
    private LikeModel fle = null;
    private ae jEG = null;
    private AntiHelper.a jEI = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_BAR));
        }
    };
    private com.baidu.adp.base.e jEJ = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.frs.vc.f.2
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            FrsViewData cBN;
            w wVar;
            if (f.this.jcX != null && (cBN = f.this.jcX.cBN()) != null && cBN.getForum() != null && obj != null) {
                if (AntiHelper.bQ(f.this.fle.getErrorCode(), f.this.fle.getErrorString())) {
                    if (AntiHelper.a(f.this.jcX.getActivity(), f.this.fle.getBlockPopInfoData(), f.this.jEI) != null) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_LIKE_BAR));
                        return;
                    }
                    return;
                }
                String name = cBN.getForum().getName();
                String id = cBN.getForum().getId();
                if (!(obj instanceof w)) {
                    wVar = null;
                } else {
                    wVar = (w) obj;
                }
                boolean z = wVar != null && f.this.fle.getErrorCode() == 0;
                if (wVar.getErrorCode() == 3250013) {
                    BdToast.a(TbadkCoreApplication.getInst().getContext(), wVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqk();
                    z = false;
                }
                if (wVar == null || !z) {
                    if (f.this.fle.getErrorCode() == 22) {
                        f.this.jcX.showToast(f.this.jcX.getString(R.string.had_liked_forum));
                    } else {
                        f.this.jcX.showToast(f.this.fle.getErrorString());
                    }
                } else {
                    h cBf = f.this.jcX.cBf();
                    if (cBf != null) {
                        cBf.Kz(name);
                    }
                    wVar.setLike(1);
                    cBN.updateLikeData(wVar);
                    cBN.setLikeFeedForumDataList(wVar.dKt());
                    if (cBf != null) {
                        cBf.a(cBN, f.this.jEH);
                    }
                    f.this.jEH = true;
                    f.this.jcX.showToast(f.this.jcX.getResources().getString(R.string.attention_success));
                    if (com.baidu.tbadk.coreExtra.c.a.G(f.this.jcX.getContext(), 0)) {
                        com.baidu.tbadk.coreExtra.c.a.a(f.this.jcX.getPageContext(), 4, 2000L);
                    }
                    f.this.s(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                    f.this.cJL();
                }
                f.this.jcX.aL(Boolean.valueOf(z));
            }
        }
    };
    private ae.a jEK = new ae.a() { // from class: com.baidu.tieba.frs.vc.f.3
        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            FrsViewData cBN;
            if (f.this.jcX != null && (cBN = f.this.jcX.cBN()) != null && cBN.getForum() != null) {
                String name = cBN.getForum().getName();
                String id = cBN.getForum().getId();
                if (j == com.baidu.adp.lib.f.b.toLong(id, 0L) && TextUtils.equals(name, str)) {
                    h cBf = f.this.jcX.cBf();
                    if (cBf != null) {
                        cBf.Kz(str);
                    }
                    cBN.getForum().setLike(0);
                    if (cBf != null) {
                        cBf.Ap(0);
                    }
                    f.this.jcX.aK(true);
                    f.this.s(false, id);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                    w wVar = new w();
                    wVar.setLike(0);
                    wVar.setFid(id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void D(String str, long j) {
        }
    };

    public f(FrsFragment frsFragment) {
        this.jcX = frsFragment;
    }

    public void e(TBSpecificationBtn tBSpecificationBtn) {
        this.jEF = tBSpecificationBtn;
        cEL();
    }

    public void cEL() {
        if (this.jEF != null) {
            this.jEF.btV();
        }
    }

    public void aNe() {
        bRB();
        cJK();
    }

    public void cHM() {
        if (this.fle != null) {
            this.fle.dKC();
        }
    }

    private void bRB() {
        if (this.jcX != null) {
            this.fle = new LikeModel(this.jcX.getPageContext());
            this.fle.setLoadDataCallBack(this.jEJ);
        }
    }

    private void cJK() {
        this.jEG = new ae();
        this.jEG.setFrom("from_frs");
        this.jEG.a(this.jEK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJL() {
        aq aqVar = new aq("c13605");
        if (this.jcX != null) {
            com.baidu.tbadk.pageInfo.c.a(this.jcX.getContext(), aqVar);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.cVV().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void rq(boolean z) {
        if (this.jcX != null && this.fle != null) {
            FrsViewData cBN = this.jcX.cBN();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.jcX.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.jcX.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_LIKE)));
            } else if (cBN != null && cBN.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.jcX.getFrom())) {
                    TiebaStatic.log(new aq("c10356").dW("fid", cBN.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.jcX.getFrom())) {
                    TiebaStatic.log(new aq("c10590").an("obj_type", 2).dW("fid", cBN.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.jcX.getFrom())) {
                    TiebaStatic.log(new aq("c10587").an("obj_type", 2).dW("fid", cBN.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.jcX.getFrom())) {
                    TiebaStatic.log(new aq("c10578").an("obj_type", 2).dW("fid", cBN.getForum().getId()));
                }
                this.fle.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.jcX.getFrom())) {
                    TiebaStatic.eventStat(this.jcX.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.jcX.getFrom())) {
                    TiebaStatic.log(new aq("c10359").dW("fid", cBN.getForum().getId()));
                }
                this.fle.aN(cBN.getForum().getName(), cBN.getForum().getId(), "FRS");
                this.jEH = z;
            }
        }
    }

    public void cJM() {
        if (this.jcX != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jcX.getActivity());
            String str = "";
            FrsViewData cBN = this.jcX.cBN();
            if (cBN != null && cBN.getForum() != null && cBN.getForum().getName() != null) {
                str = cBN.getForum().getName();
            }
            if (!StringUtils.isNull(str)) {
                aVar.Ad(String.format(this.jcX.getString(R.string.attention_cancel_dialog_content), str));
            } else {
                aVar.Ad(this.jcX.getString(R.string.attention_cancel_dialog_content_default));
            }
            aVar.a(this.jcX.getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.4
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    if (f.this.jcX != null && f.this.jEG != null) {
                        FrsViewData cBN2 = f.this.jcX.cBN();
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (currentAccount == null || currentAccount.length() <= 0) {
                            TbadkCoreApplication.getInst().login(f.this.jcX.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(f.this.jcX.getActivity(), true, RequestResponseCode.REQUEST_LOGIN_UNLIKE)));
                        } else if (cBN2 != null && cBN2.getForum() != null) {
                            f.this.jEG.P(cBN2.getForum().getName(), com.baidu.adp.lib.f.b.toLong(cBN2.getForum().getId(), 0L));
                        }
                    }
                }
            });
            aVar.b(this.jcX.getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jcX.getTbPageContext()).bqe();
        }
    }

    public void fl(String str, String str2) {
        if (this.fle != null) {
            this.fle.aN(str, str2, "FRS");
        }
    }
}
