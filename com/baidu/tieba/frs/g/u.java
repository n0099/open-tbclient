package com.baidu.tieba.frs.g;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.e<FrsActivity> {
    private com.baidu.tieba.play.ac aRf;
    private int bEj;
    com.baidu.tieba.frs.entelechy.b.b bNa;
    private final View.OnClickListener bOx;
    private FrsActivity bST;
    private BdTypeListView bVP;
    private LikeModel brQ;
    private String cbA;
    private Runnable cbB;
    private boolean cbC;
    private com.baidu.tieba.tbadkCore.ag cbD;
    private boolean cbE;
    private com.baidu.tieba.frs.entelechy.b.a cbF;
    private boolean cbG;
    private CustomMessageListener cbH;
    private com.baidu.tieba.frs.view.c cbx;
    private int cby;
    private int cbz;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public u(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(frsActivity.getPageContext());
        this.bVP = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.cbA = null;
        this.cbC = false;
        this.brQ = null;
        this.cbD = null;
        this.cbE = false;
        this.cbH = new v(this, CmdConfigCustom.CMD_SIGN_MODEL_TASK);
        this.bOx = new w(this);
        this.bST = frsActivity;
        this.cbF = aVar;
        if (this.cbF != null) {
            this.bNa = this.cbF.aaZ();
        }
        frsActivity.registerListener(this.cbH);
    }

    public void a(com.baidu.tieba.play.ac acVar) {
        this.aRf = acVar;
    }

    public void h(Bundle bundle) {
        Yy();
        aec();
        this.cbC = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.cbx != null) {
            this.cbx.onDestory();
        }
        if (this.brQ != null) {
            this.brQ.bhx();
        }
        if (this.cbB != null) {
            this.bST.mHandler.removeCallbacks(this.cbB);
        }
    }

    public void onActivityStop() {
        if (this.cbx != null) {
            this.cbx.onStop();
        }
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.cbx != null) {
            this.cbx.changeSkinType(i);
            return true;
        }
        return true;
    }

    public com.baidu.tieba.frs.view.c adP() {
        return this.cbx;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.bVP = bdTypeListView;
    }

    public void ek(boolean z) {
        if (z) {
            if (this.cbx != null) {
                this.bVP.removeHeaderView(this.cbx.aer());
                this.cbE = false;
            }
        } else if (this.cbx != null && this.cbx.aer() != null && !this.cbE) {
            this.bVP.addHeaderView(this.cbx.aer(), this.bVP.getHeaderViewsCount());
            this.cbE = true;
        }
    }

    public void a(String str, com.baidu.tieba.tbadkCore.n nVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && nVar != null && nVar.getUserData() != null && nVar.aJw() != null) {
            e(str, nVar.getUserData().getIsMem(), nVar.aJw().isLike());
        }
    }

    public void e(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.cbA, str);
        this.bEj = i2;
        this.cbA = str;
        adR();
        if (this.cbx == null || z) {
            this.cbx = this.cbF.a(str, this.bST, i);
            this.cbx.changeSkinType(this.mSkinType);
            this.cbx.setCommonClickListener(this.bOx);
        }
        if (!this.bST.Zh()) {
            this.bVP.addHeaderView(this.cbx.getView());
        }
        if (this.bNa != null) {
            this.bNa.a(this.bVP, this.cbx);
        }
        adS();
    }

    public void adQ() {
        if (!this.cbE && this.cbx != null) {
            if (!this.bST.Zh()) {
                this.bVP.addHeaderView(this.cbx.aer());
            }
            this.cbE = true;
        }
    }

    private void adR() {
        if (("normal_page".equals(this.cbA) || "frs_page".equals(this.cbA) || "book_page".equals(this.cbA)) && this.cbx != null) {
            this.bVP.removeHeaderView(this.cbx.getView());
            this.bVP.removeHeaderView(this.cbx.aer());
        }
        this.cbE = false;
    }

    private void adS() {
        if (this.cbB == null) {
            this.cbB = new x(this);
        }
        this.bST.mHandler.postDelayed(this.cbB, 4000L);
    }

    public void h(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(nVar.aJw(), nVar);
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (forumData != null && nVar != null) {
            float a = a(forumData);
            if (this.cbx != null) {
                this.cbx.a(forumData, nVar);
                this.cbx.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.cbx.iL(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.cbx.eo(false);
                        return;
                    }
                    this.cbx.eo(true);
                    this.cbx.iL(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.cby = forumData.getLevelupScore();
        this.cbz = forumData.getCurScore();
        if (this.cby > 0) {
            return this.cbz / this.cby;
        }
        return 0.0f;
    }

    public void iE(int i) {
        if (i > 1) {
            if (this.cbx != null) {
                this.cbx.ep(false);
            }
        } else if (this.cbx != null) {
            this.cbx.ep(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void a(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            adT();
        }
    }

    public void setIsMem(int i) {
        if (this.cbx != null) {
            this.cbx.setMemberType(i);
        }
    }

    public void abh() {
        if (("normal_page".equals(this.cbA) || "frs_page".equals(this.cbA) || "book_page".equals(this.cbA)) && this.cbx != null) {
            this.cbx.abh();
        }
    }

    public void adT() {
        if (this.cbx != null) {
            this.cbx.abj();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (nVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, nVar.aJw(), nVar, z);
            }
        }
    }

    public void adU() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            iG(0);
        }
    }

    public void iF(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            iG(i);
        }
    }

    public void iG(int i) {
        if (this.cbx != null) {
            this.cbx.iK(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (this.cbx != null) {
            this.cbx.a(forumData, nVar);
            if (forumData != null) {
                this.cbx.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.cbx.eo(false);
                }
            }
        }
    }

    public boolean adV() {
        if (("normal_page".equals(this.cbA) || "frs_page".equals(this.cbA) || "book_page".equals(this.cbA)) && this.cbx != null) {
            return this.cbx.aep();
        }
        return false;
    }

    public void adW() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cbx != null) {
            this.cbx.aev().setVisibility(0);
        }
    }

    public void adX() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cbx != null) {
            this.cbx.aev().setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.cby - this.cbz) {
                z = true;
                this.cby = signData.levelup_score;
            }
            this.cbz = i + this.cbz;
            if (this.cbz > this.cby) {
                this.cbz = this.cby;
            }
            if (this.cby != 0) {
                f = this.cbz / this.cby;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.c(z, f);
        }
    }

    public void iH(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cbx != null) {
            this.cbx.iL(i);
        }
    }

    public void i(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null && nVar.aJw() != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(nVar.aJw().getSignData(), nVar.aJw(), nVar);
            }
        }
    }

    public void j(com.baidu.tieba.tbadkCore.n nVar) {
        SignData signData;
        ForumData aJw;
        if (nVar != null && nVar.aJw() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cbx != null && (signData = nVar.aJw().getSignData()) != null && (aJw = nVar.aJw()) != null) {
                this.cbx.a(aJw, nVar);
                this.cbx.iL(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.cbx.aep()) {
                    a(this.cbx, signData);
                    aJw.setCurScore(this.cbz);
                    aJw.setLevelupScore(this.cby);
                    this.cbx.a(aJw, nVar);
                    this.cbx.c(this.cbx.aeu(), true);
                }
            }
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (this.cbx != null && signData != null && forumData != null && nVar != null) {
            this.cbx.a(forumData, nVar);
            this.cbx.iL(signData.is_signed);
            if (signData.sign_bonus_point > 0 && this.cbx.aep()) {
                a(this.cbx, signData);
                forumData.setCurScore(this.cbz);
                forumData.setLevelupScore(this.cby);
                this.cbx.a(forumData, nVar);
                this.cbx.c(this.cbx.aeu(), true);
            }
        }
    }

    public boolean adY() {
        if (("normal_page".equals(this.cbA) || "frs_page".equals(this.cbA) || "book_page".equals(this.cbA)) && this.cbx != null) {
            return this.cbx.adY();
        }
        return false;
    }

    public boolean adZ() {
        if (("normal_page".equals(this.cbA) || "frs_page".equals(this.cbA) || "book_page".equals(this.cbA)) && this.cbx != null) {
            return this.cbx.adZ();
        }
        return false;
    }

    public BarImageView aea() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cbx != null) {
            return this.cbx.aea();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void el(boolean z) {
        if (this.bST != null) {
            com.baidu.tieba.tbadkCore.n Zr = this.bST.Zr();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m9getInst().login(this.bST.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(w.l.login_to_use), true, 11002)));
            } else if (Zr != null && Zr.aJw() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bST.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10356").aa("fid", Zr.aJw().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.bST.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10590").s("obj_type", 2).aa("fid", Zr.aJw().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.bST.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10587").s("obj_type", 2).aa("fid", Zr.aJw().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.bST.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10578").s("obj_type", 2).aa("fid", Zr.aJw().getId()));
                }
                this.brQ.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bST.getFrom())) {
                    TiebaStatic.eventStat(this.bST.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.bST.getFrom())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10359").aa("fid", Zr.aJw().getId()));
                }
                this.brQ.D(Zr.aJw().getName(), Zr.aJw().getId(), "FRS");
                this.cbG = z;
            }
        }
    }

    public void Zu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bST.Zr() != null && this.bST.Zr().aJw() != null && this.bST.Zr().aJw().getName() != null) {
            str = this.bST.Zr().aJw().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cE(String.format(getPageContext().getString(w.l.attention_cancel_dialog_content), str));
        } else {
            aVar.cE(getPageContext().getString(w.l.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(w.l.editor_dialog_yes), new y(this));
        aVar.b(getPageContext().getString(w.l.editor_dialog_no), new z(this));
        aVar.b(getPageContext()).tQ();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void aeb() {
        com.baidu.tieba.tbadkCore.n Zr = this.bST.Zr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(this.bST.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(w.l.login_to_use), true, 11014)));
        } else if (Zr != null && Zr.aJw() != null) {
            adW();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, Zr.aJw()));
        }
    }

    private void Yy() {
        this.brQ = new LikeModel(this.bST.getPageContext());
        this.brQ.setLoadDataCallBack(new aa(this));
    }

    private void aec() {
        this.cbD = new com.baidu.tieba.tbadkCore.ag();
        this.cbD.setFrom("from_frs");
        this.cbD.a(new ab(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        new ac(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void t(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.n Zr;
        if (i > 0 && i2 > 0 && (Zr = this.bST.Zr()) != null && Zr.aJw() != null && Zr.getSignData() != null) {
            ForumData aJw = Zr.aJw();
            SignData signData = Zr.getSignData();
            signData.levelup_score = aJw.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            Zr.d(signData);
            signData.forumId = aJw.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            i(Zr);
            int i4 = -1;
            if (adZ()) {
                i4 = aJw.getUser_level() + 1;
            }
            TbadkCoreApplication.m9getInst().addSignedForum(aJw.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int aed() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.cbx.aer() != null && this.cbx.aer().getParent() != null) {
                return this.bVP.getHeaderViewsCount() - 2;
            }
            return this.bVP.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void aaW() {
        if (this.cbx != null) {
            this.cbx.aaW();
        }
    }

    public static boolean k(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            return (nVar.bgJ() == null || StringUtils.isNull(nVar.bgJ().getBookId(), true) || nVar.bgJ().getBookId().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            return ((nVar.bgn() == null || nVar.bgn().bgU() != 1) && nVar.bgI() == null && com.baidu.tbadk.core.util.x.q(nVar.bgP()) && (nVar.bgo() == null || com.baidu.tbadk.core.util.x.q(nVar.bgo().qi())) && ((nVar.aJw() == null || nVar.aJw().getFrsBannerData() == null || nVar.aJw().getFrsBannerData().getType() != 2) && (nVar.bgK() == null || StringUtils.isNull(nVar.bgK().qB(), true)))) ? false : true;
        }
        return false;
    }

    public void iI(int i) {
        View findViewById;
        if (this.cbx != null && this.cbx.aer() != null && (findViewById = this.cbx.aer().findViewById(w.h.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }
}
