package com.baidu.tieba.frs.f;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private LikeModel bAL;
    private int bSN;
    private com.baidu.tieba.frs.r cbE;
    com.baidu.tieba.frs.entelechy.b.b ccB;
    private final View.OnClickListener cdH;
    private BdTypeListView ckr;
    private com.baidu.tieba.frs.view.b cpM;
    private int cpN;
    private int cpO;
    private String cpP;
    private Runnable cpQ;
    private boolean cpR;
    private ae cpS;
    private boolean cpT;
    private com.baidu.tieba.frs.entelechy.b.a cpU;
    private boolean cpV;
    private com.baidu.tieba.e.a cpW;
    private int cpX;
    private CustomMessageListener cpY;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public m(com.baidu.tieba.frs.r rVar, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(rVar.getPageContext());
        this.ckr = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.cpP = null;
        this.cpR = false;
        this.bAL = null;
        this.cpS = null;
        this.cpT = false;
        this.cpX = 0;
        this.cpY = new n(this, CmdConfigCustom.CMD_SIGN_MODEL_TASK);
        this.cdH = new o(this);
        this.cbE = rVar;
        this.cpU = aVar;
        if (this.cpU != null) {
            this.ccB = this.cpU.afe();
        }
        rVar.registerListener(this.cpY);
        this.cpW = new com.baidu.tieba.e.a();
        this.cpW.a(new p(this));
    }

    public void h(Bundle bundle) {
        acW();
        ahU();
        this.cpR = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.cpM != null) {
            this.cpM.onDestory();
        }
        if (this.bAL != null) {
            this.bAL.blG();
        }
        if (this.cpQ != null) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.cpQ);
        }
    }

    public void onActivityStop() {
        if (this.cpM != null) {
            this.cpM.onStop();
        }
    }

    public boolean jl(int i) {
        this.mSkinType = i;
        if (this.cpM != null) {
            this.cpM.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void d(BdTypeListView bdTypeListView) {
        this.ckr = bdTypeListView;
    }

    public void eP(boolean z) {
        if (z) {
            if (this.cpM != null) {
                this.ckr.removeHeaderView(this.cpM.ahY());
                this.cpT = false;
            }
        } else if (this.cpM != null && this.cpM.ahY() != null && !this.cpT) {
            this.ckr.addHeaderView(this.cpM.ahY(), this.ckr.getHeaderViewsCount());
            this.cpT = true;
        }
    }

    public void a(String str, com.baidu.tieba.tbadkCore.n nVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && nVar != null && nVar.getUserData() != null && nVar.aMt() != null) {
            e(str, nVar.getUserData().getIsMem(), nVar.aMt().isLike());
        }
    }

    public void e(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.cpP, str);
        this.bSN = i2;
        this.cpP = str;
        ahK();
        if (this.cpM == null || z) {
            this.cpM = this.cpU.a(str, this.cbE, i);
            this.cpM.changeSkinType(this.mSkinType);
            this.cpM.setCommonClickListener(this.cdH);
        }
        this.ckr.addHeaderView(this.cpM.getView());
        if (this.ccB != null) {
            this.ccB.a(this.ckr, this.cpM);
        }
        if (this.cbE.aem()) {
            this.cpM.jt(com.baidu.adp.lib.util.k.g(this.cbE.getActivity(), w.f.ds40));
        } else {
            this.cpM.jt(com.baidu.adp.lib.util.k.g(this.cbE.getActivity(), w.f.ds20));
        }
        ahL();
    }

    public void ahJ() {
        if (!this.cpT && this.cpM != null) {
            this.ckr.addHeaderView(this.cpM.ahY());
            this.cpT = true;
        }
    }

    private void ahK() {
        if (("normal_page".equals(this.cpP) || "frs_page".equals(this.cpP) || "book_page".equals(this.cpP)) && this.cpM != null) {
            this.ckr.removeHeaderView(this.cpM.getView());
            this.ckr.removeHeaderView(this.cpM.ahY());
        }
        this.cpT = false;
    }

    private void ahL() {
        if (this.cpQ == null) {
            this.cpQ = new q(this);
        }
        com.baidu.adp.lib.g.h.fR().postDelayed(this.cpQ, 4000L);
    }

    public void f(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(nVar.aMt(), nVar);
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (forumData != null && nVar != null) {
            float a = a(forumData);
            if (this.cpM != null) {
                this.cpM.a(forumData, nVar);
                this.cpM.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.cpM.js(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.cpM.eR(false);
                    } else {
                        this.cpM.eR(true);
                        this.cpM.js(forumData.getSignData().is_signed);
                    }
                }
                if (forumData.getUser_level() > this.cpX) {
                    bf bfVar = new bf();
                    bfVar.setForumName(forumData.getName());
                    bfVar.setForumLevel(forumData.getUser_level());
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_UPDATE_USER_LEVEL, bfVar));
                    this.cpX = forumData.getUser_level();
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.cpN = forumData.getLevelupScore();
        this.cpO = forumData.getCurScore();
        if (this.cpN > 0) {
            return this.cpO / this.cpN;
        }
        return 0.0f;
    }

    public void jm(int i) {
        if (i > 1) {
            if (this.cpM != null) {
                this.cpM.eS(false);
            }
        } else if (this.cpM != null) {
            this.cpM.eS(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void e(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            ahM();
        }
    }

    public void setIsMem(int i) {
        if (this.cpM != null) {
            this.cpM.setMemberType(i);
        }
    }

    public void afq() {
        if (("normal_page".equals(this.cpP) || "frs_page".equals(this.cpP) || "book_page".equals(this.cpP)) && this.cpM != null) {
            this.cpM.afq();
        }
    }

    public void ahM() {
        if (this.cpM != null) {
            this.cpM.afs();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (nVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, nVar.aMt(), nVar, z);
            }
        }
    }

    public void ahN() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            jo(0);
        }
    }

    public void jn(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            jo(i);
        }
    }

    public void jo(int i) {
        if (this.cpM != null) {
            this.cpM.jr(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (this.cpM != null) {
            this.cpM.a(forumData, nVar);
            if (forumData != null) {
                this.cpM.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.cpM.eR(false);
                }
            }
        }
    }

    public boolean ahO() {
        if (("normal_page".equals(this.cpP) || "frs_page".equals(this.cpP) || "book_page".equals(this.cpP)) && this.cpM != null) {
            return this.cpM.ahW();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.cpN - this.cpO) {
                z = true;
                this.cpN = signData.levelup_score;
            }
            this.cpO = i + this.cpO;
            if (this.cpO > this.cpN) {
                this.cpO = this.cpN;
            }
            if (this.cpN != 0) {
                f = this.cpO / this.cpN;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.c(z, f);
        }
    }

    public void jp(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cpM != null) {
            this.cpM.js(i);
        }
    }

    public void g(com.baidu.tieba.tbadkCore.n nVar) {
        SignData signData;
        ForumData aMt;
        if (nVar != null && nVar.aMt() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cpM != null && (signData = nVar.aMt().getSignData()) != null && (aMt = nVar.aMt()) != null) {
                this.cpM.a(aMt, nVar);
                this.cpM.js(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.cpM.ahW()) {
                    a(this.cpM, signData);
                    aMt.setCurScore(this.cpO);
                    aMt.setLevelupScore(this.cpN);
                    this.cpM.a(aMt, nVar);
                }
            }
        }
    }

    public boolean ahP() {
        if (("normal_page".equals(this.cpP) || "frs_page".equals(this.cpP) || "book_page".equals(this.cpP)) && this.cpM != null) {
            return this.cpM.ahP();
        }
        return false;
    }

    public boolean ahQ() {
        if (("normal_page".equals(this.cpP) || "frs_page".equals(this.cpP) || "book_page".equals(this.cpP)) && this.cpM != null) {
            return this.cpM.ahQ();
        }
        return false;
    }

    public BarImageView ahR() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cpM != null) {
            return this.cpM.ahR();
        }
        return null;
    }

    public void eQ(boolean z) {
        if (this.cbE != null) {
            com.baidu.tieba.tbadkCore.n aek = this.cbE.aek();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m9getInst().login(this.cbE.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(w.l.login_to_use), true, 11002)));
            } else if (aek != null && aek.aMt() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.cbE.getFrom())) {
                    TiebaStatic.log(new au("c10356").Z("fid", aek.aMt().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.cbE.getFrom())) {
                    TiebaStatic.log(new au("c10590").r("obj_type", 2).Z("fid", aek.aMt().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.cbE.getFrom())) {
                    TiebaStatic.log(new au("c10587").r("obj_type", 2).Z("fid", aek.aMt().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.cbE.getFrom())) {
                    TiebaStatic.log(new au("c10578").r("obj_type", 2).Z("fid", aek.aMt().getId()));
                }
                this.bAL.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.cbE.getFrom())) {
                    TiebaStatic.eventStat(this.cbE.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.cbE.getFrom())) {
                    TiebaStatic.log(new au("c10359").Z("fid", aek.aMt().getId()));
                }
                this.bAL.I(aek.aMt().getName(), aek.aMt().getId(), "FRS");
                this.cpV = z;
            }
        }
    }

    public void ahS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.cbE.aek() != null && this.cbE.aek().aMt() != null && this.cbE.aek().aMt().getName() != null) {
            str = this.cbE.aek().aMt().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cI(String.format(getPageContext().getString(w.l.attention_cancel_dialog_content), str));
        } else {
            aVar.cI(getPageContext().getString(w.l.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(w.l.editor_dialog_yes), new r(this));
        aVar.b(getPageContext().getString(w.l.editor_dialog_no), new s(this));
        aVar.b(getPageContext()).ta();
    }

    public void ahT() {
        com.baidu.tieba.tbadkCore.n aek = this.cbE.aek();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(this.cbE.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(w.l.login_to_use), true, 11014)));
        } else if (aek != null && aek.aMt() != null) {
            FrsActivityStatic.forumName = aek.aMt().getName() == null ? "" : aek.aMt().getName();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, aek.aMt()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kj(String str) {
        if (this.cbE.adP() != null && this.cbE.adP().agI() != null) {
            com.baidu.tieba.tbadkCore.c.bkt().X(com.baidu.tieba.tbadkCore.c.bkt().g(str, this.cbE.adP().agI().agU(), this.cbE.adP().agI().getIsGood(), this.cbE.adP().agI().getCategoryId()), false);
        }
    }

    private void acW() {
        this.bAL = new LikeModel(this.cbE.getPageContext());
        this.bAL.setLoadDataCallBack(new t(this));
    }

    private void ahU() {
        this.cpS = new ae();
        this.cpS.setFrom("from_frs");
        this.cpS.a(new u(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, String str) {
        com.baidu.tieba.im.settingcache.h.awc().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void u(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.n aek;
        if (i > 0 && i2 > 0 && (aek = this.cbE.aek()) != null && aek.aMt() != null && aek.getSignData() != null) {
            ForumData aMt = aek.aMt();
            SignData signData = aek.getSignData();
            signData.levelup_score = aMt.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            aek.d(signData);
            signData.forumId = aMt.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            int i4 = -1;
            if (ahQ()) {
                i4 = aMt.getUser_level() + 1;
            }
            TbadkCoreApplication.m9getInst().addSignedForum(aMt.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int ahV() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.cpM != null && this.cpM.ahY() != null && this.cpM.ahY().getParent() != null) {
                return this.ckr.getHeaderViewsCount() - 2;
            }
            return this.ckr.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void afd() {
        if (this.cpM != null) {
            this.cpM.afd();
        }
    }

    public static boolean h(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            return (nVar.bkW() == null || StringUtils.isNull(nVar.bkW().getBookId(), true) || nVar.bkW().getBookId().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean i(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            return ((nVar.bkA() == null || nVar.bkA().blh() != 1) && nVar.bkV() == null && (nVar.bkB() == null || com.baidu.tbadk.core.util.z.t(nVar.bkB().pB())) && ((nVar.aMt() == null || nVar.aMt().getFrsBannerData() == null || nVar.aMt().getFrsBannerData().getType() != 2) && (nVar.bkX() == null || StringUtils.isNull(nVar.bkX().pI(), true)))) ? false : true;
        }
        return false;
    }

    public void jq(int i) {
        View findViewById;
        if (this.cpM != null && this.cpM.ahY() != null && (findViewById = this.cpM.ahY().findViewById(w.h.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.cpW != null) {
            this.cpW.onTouchEvent(motionEvent);
        }
    }
}
