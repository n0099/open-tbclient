package com.baidu.tieba.frs.i;

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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.am;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<FrsActivity> {
    private com.baidu.tieba.tbadkCore.x Ge;
    private com.baidu.tieba.play.i aNV;
    private int bGq;
    com.baidu.tieba.frs.entelechy.b.b bPM;
    private final View.OnClickListener bRE;
    private FrsActivity bWH;
    private BdTypeListView bZE;
    private com.baidu.tieba.frs.view.c cfm;
    private int cfn;
    private int cfo;
    private String cfp;
    private Runnable cfq;
    private boolean cfr;
    private am cfs;
    private boolean cft;
    private com.baidu.tieba.frs.entelechy.b.a cfu;
    private CustomMessageListener cfv;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public p(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.a aVar) {
        super(frsActivity.getPageContext());
        this.bZE = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.cfp = null;
        this.cfr = false;
        this.Ge = null;
        this.cfs = null;
        this.cft = false;
        this.cfv = new q(this, CmdConfigCustom.CMD_SIGN_MODEL_TASK);
        this.bRE = new r(this);
        this.bWH = frsActivity;
        this.cfu = aVar;
        if (this.cfu != null) {
            this.bPM = this.cfu.acI();
        }
        frsActivity.registerListener(this.cfv);
    }

    public void a(com.baidu.tieba.play.i iVar) {
        this.aNV = iVar;
    }

    public void f(Bundle bundle) {
        lM();
        afC();
        this.cfr = TbadkSettings.getInst().loadBoolean(FrsActivity.bOT, false);
    }

    public void onActivityDestroy() {
        if (this.cfm != null) {
            this.cfm.onDestory();
        }
        if (this.Ge != null) {
            this.Ge.bij();
        }
        if (this.cfq != null) {
            this.bWH.mHandler.removeCallbacks(this.cfq);
        }
    }

    public void onActivityStop() {
        if (this.cfm != null) {
            this.cfm.onStop();
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.cfm != null) {
            this.cfm.changeSkinType(i);
            return true;
        }
        return true;
    }

    public com.baidu.tieba.frs.view.c afp() {
        return this.cfm;
    }

    public void c(BdTypeListView bdTypeListView) {
        this.bZE = bdTypeListView;
    }

    public void e(String str, int i, int i2) {
        if (str.equals("frs_page") || str.equals("book_page")) {
            this.mPageType = str;
        } else {
            this.mPageType = "normal_page";
        }
        f(this.mPageType, i, i2);
    }

    public void eg(boolean z) {
        if (z) {
            if (this.cfm != null) {
                this.bZE.removeHeaderView(this.cfm.afH());
                this.cft = false;
            }
        } else if (this.cfm != null && this.cfm.afH() != null && !this.cft) {
            this.bZE.f(this.cfm.afH(), this.bZE.getHeaderViewsCount());
            this.cft = true;
        }
    }

    public void a(String str, com.baidu.tieba.tbadkCore.p pVar) {
        this.mPageType = str;
        if (("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str)) && pVar != null && pVar.getUserData() != null && pVar.aLP() != null) {
            f(str, pVar.getUserData().getIsMem(), pVar.aLP().isLike());
        }
    }

    public void f(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.cfp, str);
        this.bGq = i2;
        this.cfp = str;
        afr();
        if (this.cfm == null || z) {
            this.cfm = this.cfu.a(str, this.bWH, i);
            this.cfm.changeSkinType(this.mSkinType);
            this.cfm.setCommonClickListener(this.bRE);
        }
        this.bZE.addHeaderView(this.cfm.getView());
        if (this.aNV != null) {
            this.aNV.a(this.cfm.afL());
        }
        if (this.bPM != null) {
            this.bPM.a(this.bZE, this.cfm);
        }
        afs();
    }

    public void afq() {
        if (!this.cft && this.cfm != null) {
            this.bZE.addHeaderView(this.cfm.afH());
            this.cft = true;
        }
    }

    private void afr() {
        if (("normal_page".equals(this.cfp) || "frs_page".equals(this.cfp) || "book_page".equals(this.cfp)) && this.cfm != null) {
            this.bZE.removeHeaderView(this.cfm.getView());
            this.bZE.removeHeaderView(this.cfm.afH());
        }
        this.cft = false;
    }

    private void afs() {
        if (this.cfq == null) {
            this.cfq = new s(this);
        }
        this.bWH.mHandler.postDelayed(this.cfq, 4000L);
    }

    public void f(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                b(pVar.aLP(), pVar);
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (forumData != null && pVar != null) {
            float a = a(forumData);
            if (this.cfm != null) {
                this.cfm.a(forumData, pVar);
                this.cfm.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.cfm.iE(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.cfm.ek(false);
                        return;
                    }
                    this.cfm.ek(true);
                    this.cfm.iE(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.cfn = forumData.getLevelupScore();
        this.cfo = forumData.getCurScore();
        if (this.cfn > 0) {
            return this.cfo / this.cfn;
        }
        return 0.0f;
    }

    public void iz(int i) {
        if (i > 1) {
            if (this.cfm != null) {
                this.cfm.el(false);
            }
        } else if (this.cfm != null) {
            this.cfm.el(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void d(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            aft();
        }
    }

    public void setIsMem(int i) {
        if (this.cfm != null) {
            this.cfm.setMemberType(i);
        }
    }

    public void acS() {
        if (("normal_page".equals(this.cfp) || "frs_page".equals(this.cfp) || "book_page".equals(this.cfp)) && this.cfm != null) {
            this.cfm.acS();
        }
    }

    public void aft() {
        if (this.cfm != null) {
            this.cfm.acU();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar, boolean z) {
        if (pVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(1, pVar.aLP(), pVar, z);
            }
        }
    }

    public void afu() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            iB(0);
        }
    }

    public void iA(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            iB(i);
        }
    }

    public void iB(int i) {
        if (this.cfm != null) {
            this.cfm.iD(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar, boolean z) {
        if (this.cfm != null) {
            this.cfm.a(forumData, pVar);
            if (forumData != null) {
                this.cfm.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.cfm.ek(false);
                }
            }
        }
    }

    public boolean afv() {
        if (("normal_page".equals(this.cfp) || "frs_page".equals(this.cfp) || "book_page".equals(this.cfp)) && this.cfm != null) {
            return this.cfm.afF();
        }
        return false;
    }

    public void afw() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cfm != null) {
            this.cfm.afK().setVisibility(0);
        }
    }

    public void afx() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cfm != null) {
            this.cfm.afK().setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.frs.view.c cVar, SignData signData) {
        if (cVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.cfn - this.cfo) {
                z = true;
                this.cfn = signData.levelup_score;
            }
            this.cfo = i + this.cfo;
            if (this.cfo > this.cfn) {
                this.cfo = this.cfn;
            }
            if (this.cfn != 0) {
                f = this.cfo / this.cfn;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            cVar.a(z, f);
        }
    }

    public void iC(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cfm != null) {
            this.cfm.iE(i);
        }
    }

    public void g(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null && pVar.aLP() != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
                a(pVar.aLP().getSignData(), pVar.aLP(), pVar);
            }
        }
    }

    public void h(com.baidu.tieba.tbadkCore.p pVar) {
        SignData signData;
        ForumData aLP;
        if (pVar != null && pVar.aLP() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cfm != null && (signData = pVar.aLP().getSignData()) != null && (aLP = pVar.aLP()) != null && pVar != null) {
                if (this.cfm.afL() != null) {
                    this.cfm.afL().setWithSign(true);
                }
                this.cfm.a(aLP, pVar);
                this.cfm.iE(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.cfm.afF()) {
                    a(this.cfm, signData);
                    aLP.setCurScore(this.cfo);
                    aLP.setLevelupScore(this.cfn);
                    this.cfm.afL().setWithSign(true);
                    this.cfm.a(aLP, pVar);
                    this.cfm.c(this.cfm.afJ(), true);
                }
            }
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (this.cfm != null && signData != null && forumData != null && pVar != null) {
            this.cfm.a(forumData, pVar);
            this.cfm.iE(signData.is_signed);
            if (signData.sign_bonus_point > 0 && this.cfm.afF()) {
                a(this.cfm, signData);
                forumData.setCurScore(this.cfo);
                forumData.setLevelupScore(this.cfn);
                this.cfm.a(forumData, pVar);
                this.cfm.c(this.cfm.afJ(), true);
            }
        }
    }

    public boolean afy() {
        if (("normal_page".equals(this.cfp) || "frs_page".equals(this.cfp) || "book_page".equals(this.cfp)) && this.cfm != null) {
            return this.cfm.afy();
        }
        return false;
    }

    public boolean afz() {
        if (("normal_page".equals(this.cfp) || "frs_page".equals(this.cfp) || "book_page".equals(this.cfp)) && this.cfm != null) {
            return this.cfm.afz();
        }
        return false;
    }

    public BarImageView afA() {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) && this.cfm != null) {
            return this.cfm.afA();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void lN() {
        if (this.bWH != null) {
            com.baidu.tieba.tbadkCore.p aaR = this.bWH.aaR();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m9getInst().login(this.bWH.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11002)));
            } else if (aaR != null && aaR.aLP() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bWH.getFrom())) {
                    TiebaStatic.log(new ay("c10356").ab("fid", aaR.aLP().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.bWH.getFrom())) {
                    TiebaStatic.log(new ay("c10590").s("obj_type", 2).ab("fid", aaR.aLP().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.bWH.getFrom())) {
                    TiebaStatic.log(new ay("c10587").s("obj_type", 2).ab("fid", aaR.aLP().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.bWH.getFrom())) {
                    TiebaStatic.log(new ay("c10578").s("obj_type", 2).ab("fid", aaR.aLP().getId()));
                }
                this.Ge.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bWH.getFrom())) {
                    TiebaStatic.eventStat(this.bWH.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.bWH.getFrom())) {
                    TiebaStatic.log(new ay("c10359").ab("fid", aaR.aLP().getId()));
                }
                this.Ge.I(aaR.aLP().getName(), aaR.aLP().getId(), "FRS");
            }
        }
    }

    public void aaU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bWH.aaR() != null && this.bWH.aaR().aLP() != null && this.bWH.aaR().aLP().getName() != null) {
            str = this.bWH.aaR().aLP().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cB(String.format(getPageContext().getString(t.j.attention_cancel_dialog_content), str));
        } else {
            aVar.cB(getPageContext().getString(t.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(t.j.editor_dialog_yes), new t(this));
        aVar.b(getPageContext().getString(t.j.editor_dialog_no), new u(this));
        aVar.b(getPageContext()).sX();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void afB() {
        com.baidu.tieba.tbadkCore.p aaR = this.bWH.aaR();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(this.bWH.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11014)));
        } else if (aaR != null && aaR.aLP() != null) {
            afw();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SIGN_MODEL_TASK, aaR.aLP()));
        }
    }

    private void lM() {
        this.Ge = new com.baidu.tieba.tbadkCore.x(this.bWH.getPageContext());
        this.Ge.setLoadDataCallBack(new v(this));
    }

    private void afC() {
        this.cfs = new am();
        this.cfs.setFrom("from_frs");
        this.cfs.a(new w(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new x(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void r(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.p aaR;
        if (i > 0 && i2 > 0 && (aaR = this.bWH.aaR()) != null && aaR.aLP() != null && aaR.getSignData() != null) {
            ForumData aLP = aaR.aLP();
            SignData signData = aaR.getSignData();
            signData.levelup_score = aLP.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            aaR.d(signData);
            signData.forumId = aLP.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            g(aaR);
            int i4 = -1;
            if (afz()) {
                i4 = aLP.getUser_level() + 1;
            }
            TbadkCoreApplication.m9getInst().addSignedForum(aLP.getName(), signData.sign_bonus_point, i4);
        }
    }

    public int afD() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType)) {
            if (this.cfm.afH() != null && this.cfm.afH().getParent() != null) {
                return this.bZE.getHeaderViewsCount() - 2;
            }
            return this.bZE.getHeaderViewsCount() - 1;
        }
        return 0;
    }

    public void acF() {
        if (this.cfm != null) {
            this.cfm.acF();
        }
    }

    public static boolean i(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            return (pVar.bhB() == null || StringUtils.isNull(pVar.bhB().getBookId(), true) || pVar.bhB().getBookId().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean j(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            return ((pVar.bhf() == null || pVar.bhf().bhI() != 1) && pVar.bhA() == null && com.baidu.tbadk.core.util.y.t(pVar.bhG()) && (pVar.bhg() == null || com.baidu.tbadk.core.util.y.t(pVar.bhg().pv())) && (pVar.aLP() == null || pVar.aLP().getFrsBannerData() == null || pVar.aLP().getFrsBannerData().getType() != 2)) ? false : true;
        }
        return false;
    }
}
