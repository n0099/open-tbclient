package com.baidu.tieba.frs.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.browser.Static;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.frs.ev;
import com.baidu.tieba.frs.ew;
import com.baidu.tieba.frs.ex;
import com.baidu.tieba.frs.ez;
import com.baidu.tieba.frs.fo;
import com.baidu.tieba.frs.fu;
import com.baidu.tieba.frs.fv;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.frs.view.u;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ah;
import com.baidu.tieba.tbadkCore.aj;
import com.baidu.tieba.tbadkCore.w;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.CategoryInfo;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f<FrsActivity> {
    private w MY;
    private int aVC;
    private final View.OnClickListener boQ;
    private HorizontalTabView bsD;
    private TabData bsF;
    private FrsActivity bts;
    private com.baidu.tieba.frs.view.l buA;
    private cm buB;
    private int buC;
    private int buD;
    private String buE;
    private Runnable buF;
    private boolean buG;
    private aj buH;
    private ah buI;
    private o buJ;
    private boolean buK;
    private boolean buL;
    private fo buM;
    private fo buN;
    private HorizontalTabView.a buO;
    private BdListView buw;
    private FrsHeaderView bux;
    private u buy;
    private HorizontalTabView buz;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public void hj(int i) {
        if (i != 1) {
            if ("normal_page".equals(this.buE) && this.bux != null) {
                this.buw.removeHeaderView(this.bux.Uc());
                this.buL = false;
            } else if ("frs_page".equals(this.buE) && this.buy != null) {
                this.buw.removeHeaderView(this.buy.Uc());
                this.buL = false;
            }
        } else if ("normal_page".equals(this.buE) && this.bux != null && this.bux.Uc() != null && !this.buL) {
            this.buw.f(this.bux.Uc(), this.buw.getHeaderViewsCount());
            this.buL = true;
        } else if ("frs_page".equals(this.buE) && this.buy != null && this.buy.Uc() != null && !this.buL) {
            this.buw.f(this.buy.Uc(), this.buw.getHeaderViewsCount());
            this.buL = true;
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int TT = TT();
        if (this.buz.Tr() && i >= TT) {
            this.buz.setVisibility(0);
            this.bsD.setVisibility(4);
            return;
        }
        this.buz.setVisibility(8);
        this.bsD.setVisibility(0);
    }

    public a(FrsActivity frsActivity, o oVar) {
        super(frsActivity.getPageContext());
        this.buw = null;
        this.bux = null;
        this.buy = null;
        this.bsD = null;
        this.buz = null;
        this.buA = null;
        this.buB = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.buE = null;
        this.buG = false;
        this.MY = null;
        this.buH = null;
        this.buI = null;
        this.buK = false;
        this.buL = false;
        this.buM = new b(this);
        this.buO = new d(this);
        this.boQ = new e(this);
        this.bts = frsActivity;
        this.buJ = oVar;
    }

    public void g(Bundle bundle) {
        oF();
        TP();
        TQ();
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds90);
        this.bsD = new HorizontalTabView(this.bts.getActivity(), dimensionPixelSize);
        this.bsD.setAutoFillTabCount(4);
        this.bsD.setmShowMenuCallBack(this.buO);
        this.buz = new HorizontalTabView(this.bts.getActivity(), dimensionPixelSize);
        this.buz.setAutoFillTabCount(4);
        this.buz.clearAnimation();
        this.buz.setVisibility(8);
        this.bsD.setFakeTab(this.buz);
        this.buz.setFakeTab(this.bsD);
        this.buJ.ab(this.buz);
        this.buG = TbadkSettings.getInst().loadBoolean(FrsActivity.bjW, false);
    }

    public void onActivityDestroy() {
        if (this.bux != null) {
            this.bux.onDestory();
        }
        if (this.buy != null) {
            this.buy.onDestory();
        }
        if (this.MY != null) {
            this.MY.aSx();
        }
        if (this.buI != null) {
            this.buI.aQp();
        }
        if (this.buF != null) {
            this.bts.mHandler.removeCallbacks(this.buF);
        }
    }

    public void onActivityStop() {
        if (this.bux != null) {
            this.bux.onStop();
        }
        if (this.buy != null) {
            this.buy.onStop();
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.buy != null) {
            this.buy.changeSkinType(i);
        }
        if (this.buB != null) {
            this.buB.notifyDataSetChanged();
        }
        if (this.buA != null) {
            this.buA.changeSkinType(i);
        }
        if (this.bux != null) {
            this.bux.changeSkinType(i);
        }
        if (this.bsD != null) {
            this.bsD.xy();
        }
        if (this.buz != null) {
            this.buz.xy();
            return true;
        }
        return true;
    }

    public FrsHeaderView Tv() {
        return this.bux;
    }

    public u Tw() {
        return this.buy;
    }

    public void t(BdListView bdListView) {
        this.buw = bdListView;
    }

    public void a(boolean z, int i, int i2, boolean z2) {
        if (z) {
            this.mPageType = "frs_page";
            d(i, i2, z2);
            return;
        }
        this.mPageType = "normal_page";
        c(i, i2, z2);
    }

    public void a(String str, com.baidu.tieba.tbadkCore.o oVar) {
        boolean z = false;
        this.mPageType = str;
        if (oVar.aRP() != null && oVar.aRP().size() != 0) {
            z = true;
        }
        if ("frs_page".equals(str)) {
            if (oVar != null && oVar.getUserData() != null && oVar.avu() != null) {
                d(oVar.getUserData().getIsMem(), oVar.avu().isLike(), z);
            }
        } else if ("normal_page".equals(str)) {
            if (oVar != null && oVar.getUserData() != null && oVar.avu() != null) {
                c(oVar.getUserData().getIsMem(), oVar.avu().isLike(), z);
            }
        } else if ("good_page".equals(str) && oVar != null && oVar.avu() != null) {
            b(oVar.avu().getGood_classify(), this.bts.blb);
        }
        c(oVar);
    }

    public void c(int i, int i2, boolean z) {
        this.aVC = i2;
        Ty();
        this.buE = "normal_page";
        if (this.bux == null) {
            this.bux = new FrsHeaderView(this.bts, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.bux.changeSkinType(this.mSkinType);
            this.bux.setCommonClickListener(this.boQ);
        }
        this.buw.addHeaderView(this.bux.getView());
        if (z) {
            SS();
        }
        if (!this.buL) {
            this.buw.addHeaderView(this.bux.Uc());
            this.buL = true;
        }
        Tz();
    }

    public void d(int i, int i2, boolean z) {
        this.aVC = i2;
        Ty();
        this.buE = "frs_page";
        hk(i);
        this.buw.addHeaderView(this.buy.getView());
        if (z) {
            SS();
        }
        if (!this.buL) {
            this.buw.addHeaderView(this.buy.Uc());
            this.buL = true;
        }
        Tz();
    }

    public void hk(int i) {
        if (this.buy == null) {
            this.buy = new u(this.bts.getPageContext(), null, null, i);
            this.buy.changeSkinType(this.mSkinType);
            this.buy.setCommonClickListener(this.boQ);
        }
    }

    public void Tx() {
        Ty();
        this.buE = "good_page";
        if (this.buA == null) {
            this.buA = new com.baidu.tieba.frs.view.l(getPageContext().getPageActivity());
            this.buA.changeSkinType(this.mSkinType);
        }
        this.buw.addHeaderView(this.buA.getView());
    }

    private void Ty() {
        if ("normal_page".equals(this.buE) && this.bux != null) {
            this.buw.removeHeaderView(this.bux.getView());
            this.buw.removeHeaderView(this.bux.Uc());
        } else if ("frs_page".equals(this.buE) && this.buy != null) {
            this.buw.removeHeaderView(this.buy.getView());
            this.buw.removeHeaderView(this.buy.Uc());
        } else if ("good_page".equals(this.buE) && this.buA != null) {
            this.buw.removeHeaderView(this.buA.getView());
        }
        this.buL = false;
        if (this.bsD != null) {
            this.buw.removeHeaderView(this.bsD);
            this.buK = false;
        }
    }

    public void cL(boolean z) {
        if (z) {
            if (Tv() != null) {
                Tv().Uf();
            }
            if (Tw() != null) {
                Tw().Uf();
                return;
            }
            return;
        }
        if (Tv() != null) {
            Tv().Ue();
        }
        if (Tw() != null) {
            Tw().Ue();
        }
    }

    private void Tz() {
        if (this.buF == null) {
            this.buF = new f(this);
        }
        this.bts.mHandler.postDelayed(this.buF, 4000L);
    }

    public void d(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            if ("frs_page".equals(this.mPageType)) {
                a(oVar.avu(), oVar);
            } else if ("normal_page".equals(this.mPageType)) {
                b(oVar.avu(), oVar);
            }
            c(oVar);
        }
    }

    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (forumData != null && oVar != null) {
            float a = a(forumData);
            if (this.buy != null) {
                this.buy.c(forumData, oVar);
                this.buy.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.buy.hu(forumData.getSignData().getSigned());
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.buy.cO(false);
                    }
                }
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (forumData != null && oVar != null) {
            float a = a(forumData);
            if (this.bux != null) {
                this.bux.c(forumData, oVar);
                this.bux.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.bux.cO(false);
                        return;
                    }
                    this.bux.cO(true);
                    this.bux.hu(forumData.getSignData().getSigned());
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.buC = forumData.getLevelupScore();
        this.buD = forumData.getCurScore();
        if (this.buC > 0) {
            return this.buD / this.buC;
        }
        return 0.0f;
    }

    public void b(ArrayList<com.baidu.tbadk.core.data.t> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        Tx();
        if (arrayList != null) {
            if (this.buB == null) {
                this.buB = new cm(getPageContext().getPageActivity(), arrayList);
                this.buA.a(this.buB);
                this.buA.c(onItemClickListener);
                return;
            }
            this.buB.setData(arrayList);
            this.buB.notifyDataSetChanged();
        }
    }

    public void gK(int i) {
        if (this.buB != null) {
            this.buB.gK(i);
        }
    }

    public void hl(int i) {
        if (i > 1) {
            if (this.bux != null) {
                this.bux.cP(false);
            }
            if (this.buy != null) {
                this.buy.cP(false);
                return;
            }
            return;
        }
        if (this.bux != null) {
            this.bux.cP(true);
        }
        if (this.buy != null) {
            this.buy.cP(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void a(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType)) {
            TC();
        } else if ("normal_page".equals(this.mPageType)) {
            TB();
        }
    }

    public void setIsMem(int i) {
        if (this.bux != null) {
            this.bux.setMemberType(i);
        }
        if (this.buy != null) {
            this.buy.setMemberType(i);
        }
    }

    public void TA() {
        if ("normal_page".equals(this.buE)) {
            if (this.bux != null) {
                this.bux.TA();
            }
        } else if ("frs_page".equals(this.buE) && this.buy != null) {
            this.buy.TA();
        }
    }

    public void TB() {
        if (this.bux != null) {
            this.bux.Ui();
        }
    }

    public void TC() {
        if (this.buy != null) {
            this.buy.Ui();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (oVar != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(1, oVar.avu(), oVar, z);
            } else if ("frs_page".equals(this.mPageType)) {
                b(1, oVar.avu(), oVar, z);
            }
        }
    }

    public void TD() {
        if ("normal_page".equals(this.mPageType)) {
            hn(0);
        } else if ("frs_page".equals(this.mPageType)) {
            ho(0);
        }
    }

    public void hm(int i) {
        if ("normal_page".equals(this.mPageType)) {
            hn(i);
        } else if ("frs_page".equals(this.mPageType)) {
            ho(i);
        }
    }

    public void hn(int i) {
        if (this.bux != null) {
            this.bux.ht(i);
        }
    }

    public void ho(int i) {
        if (this.buy != null) {
            this.buy.ht(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (this.bux != null) {
            this.bux.c(forumData, oVar);
            if (forumData != null) {
                this.bux.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.bux.cO(false);
                }
            }
        }
    }

    public void b(int i, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (this.buy != null) {
            this.buy.c(forumData, oVar);
            float a = a(forumData);
            if (forumData != null) {
                this.buy.a(i, forumData.getLevelName(), forumData.getUser_level(), a, z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.buy.cO(false);
                }
            }
        }
    }

    public boolean TE() {
        if ("normal_page".equals(this.buE) && this.bux != null) {
            return this.bux.Ua();
        }
        if ("frs_page".equals(this.buE) && this.buy != null) {
            return this.buy.Ua();
        }
        return false;
    }

    public void TF() {
        if ("normal_page".equals(this.mPageType)) {
            TH();
        } else if ("frs_page".equals(this.mPageType)) {
            TJ();
        }
    }

    public void TG() {
        if ("normal_page".equals(this.mPageType)) {
            TI();
        } else if ("frs_page".equals(this.mPageType)) {
            TK();
        }
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.buC - this.buD) {
                z = true;
                this.buC = signData.getLevelUpScore();
            }
            this.buD = bonusPoint + this.buD;
            if (this.buD > this.buC) {
                this.buD = this.buC;
            }
            if (this.buC != 0) {
                f = this.buD / this.buC;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.a(z, f);
        }
    }

    public void hp(int i) {
        if ("normal_page".equals(this.mPageType)) {
            hq(i);
        } else if ("frs_page".equals(this.mPageType)) {
            hr(i);
        }
    }

    public void e(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null && oVar.avu() != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(oVar.avu().getSignData(), oVar.avu(), oVar);
            } else if ("frs_page".equals(this.mPageType)) {
                b(oVar.avu().getSignData(), oVar.avu(), oVar);
            }
        }
    }

    public void hq(int i) {
        if (this.bux != null) {
            this.bux.hu(i);
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (this.bux != null && signData != null && forumData != null && oVar != null) {
            this.bux.c(forumData, oVar);
            this.bux.hu(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.bux.Ua()) {
                a(this.bux, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.buD);
                    forumData.setLevelupScore(this.buC);
                }
                this.bux.c(forumData, oVar);
                this.bux.f(this.bux.Ug(), true);
            }
        }
    }

    public void hr(int i) {
        if (this.buy != null) {
            this.buy.hu(i);
        }
    }

    public void b(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (this.buy != null && signData != null && forumData != null && oVar != null) {
            this.buy.c(forumData, oVar);
            this.buy.hu(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.buy.Ua()) {
                a(this.buy, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.buD);
                    forumData.setLevelupScore(this.buC);
                }
                this.buy.c(forumData, oVar);
                this.buy.f(this.buy.Ug(), true);
            }
        }
    }

    public void TH() {
        if (this.bux != null) {
            this.bux.Uh().setVisibility(0);
        }
    }

    public void TI() {
        if (this.bux != null) {
            this.bux.Uh().setVisibility(8);
        }
    }

    public void TJ() {
        if (this.buy != null) {
            this.buy.Uh().setVisibility(0);
        }
    }

    public void TK() {
        if (this.buy != null) {
            this.buy.Uh().setVisibility(8);
        }
    }

    public boolean TL() {
        if ("normal_page".equals(this.buE) && this.bux != null) {
            return this.bux.TL();
        }
        if ("frs_page".equals(this.buE) && this.buy != null) {
            return this.buy.TL();
        }
        return false;
    }

    public void Z(View view) {
        if (this.bux != null) {
            this.bux.f(view, false);
        }
    }

    public void aa(View view) {
        if (this.buy != null) {
            this.buy.f(view, false);
        }
    }

    public boolean TM() {
        if ("normal_page".equals(this.buE)) {
            if (this.bux != null) {
                return this.bux.TM();
            }
        } else if ("frs_page".equals(this.buE) && this.buy != null) {
            return this.buy.TM();
        }
        return false;
    }

    public BarImageView TN() {
        u Tw;
        if ("normal_page".equals(this.mPageType)) {
            FrsHeaderView Tv = Tv();
            if (Tv != null) {
                return Tv.TN();
            }
        } else if ("frs_page".equals(this.mPageType) && (Tw = Tw()) != null) {
            return Tw.TN();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void oG() {
        if (this.bts != null) {
            com.baidu.tieba.tbadkCore.o QZ = this.bts.QZ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m411getInst().login(this.bts.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11002)));
            } else if (QZ != null && QZ.avu() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bts.getFrom())) {
                    TiebaStatic.log(new aw("c10356").ac("fid", QZ.avu().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.bts.getFrom())) {
                    TiebaStatic.log(new aw("c10590").r("obj_type", 2).ac("fid", QZ.avu().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.bts.getFrom())) {
                    TiebaStatic.log(new aw("c10587").r("obj_type", 2).ac("fid", QZ.avu().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.bts.getFrom())) {
                    TiebaStatic.log(new aw("c10578").r("obj_type", 2).ac("fid", QZ.avu().getId()));
                }
                this.MY.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bts.getFrom())) {
                    TiebaStatic.eventStat(this.bts.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.bts.getFrom())) {
                    TiebaStatic.log(new aw("c10359").ac("fid", QZ.avu().getId()));
                }
                this.MY.B(QZ.avu().getName(), QZ.avu().getId(), "FRS");
            }
        }
    }

    public void Rc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bts.QZ() != null && this.bts.QZ().avu() != null && this.bts.QZ().avu().getName() != null) {
            str = this.bts.QZ().avu().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cC(String.format(getPageContext().getString(t.j.attention_cancel_dialog_content), str));
        } else {
            aVar.cC(getPageContext().getString(t.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(t.j.editor_dialog_yes), new g(this));
        aVar.b(getPageContext().getString(t.j.editor_dialog_no), new h(this));
        aVar.b(getPageContext()).up();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void TO() {
        com.baidu.tieba.tbadkCore.o QZ = this.bts.QZ();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.bts.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11014)));
        } else if (QZ != null && QZ.avu() != null) {
            TF();
            this.buI.bB(QZ.avu().getName(), QZ.avu().getId());
        }
    }

    private void oF() {
        this.MY = new w(this.bts.getPageContext());
        this.MY.setLoadDataCallBack(new i(this));
    }

    private void TP() {
        this.buH = new aj();
        this.buH.setFrom("from_frs");
        this.buH.a(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new k(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void q(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.o QZ;
        if (i > 0 && i2 > 0 && (QZ = this.bts.QZ()) != null && QZ.avu() != null && QZ.getSignData() != null) {
            ForumData avu = QZ.avu();
            SignData signData = QZ.getSignData();
            signData.setLevelUpScore(avu.getLevelupScore());
            signData.setBonusPoint(i3);
            signData.setMissSignNum(signData.getMissSignNum() - i2);
            signData.setCountSignNum(i);
            QZ.d(signData);
            signData.setForumId(avu.getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            e(QZ);
            int i4 = -1;
            if (TM()) {
                i4 = avu.getUser_level() + 1;
            }
            TbadkCoreApplication.m411getInst().addSignedForum(avu.getName(), signData.getBonusPoint(), i4);
        }
    }

    private void TQ() {
        this.buI = new ah(this.bts);
        this.buI.setLoadDataCallBack(new c(this));
    }

    private void SS() {
        if (this.bsD != null && !this.buK) {
            this.buw.addHeaderView(this.bsD, Integer.valueOf(this.buw.getHeaderViewsCount()), false);
            this.buK = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x0251 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(com.baidu.tieba.tbadkCore.o oVar) {
        boolean z;
        boolean z2;
        URI uri;
        if (oVar != null && oVar.aRP() != null && oVar.aRP().size() != 0) {
            if (oVar.aRK() != null) {
                z = oVar.aRK().aRB() != 1;
            } else {
                z = false;
            }
            cM(z);
            f(oVar);
            this.bsF = new TabData();
            int aRY = oVar.aRY();
            for (FrsTabInfo frsTabInfo : oVar.aRP()) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() > 0 && !TextUtils.isEmpty(frsTabInfo.tab_name) && !TextUtils.isEmpty(frsTabInfo.tab_name.trim()) && (frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11)) {
                    com.baidu.tieba.frs.tab.h hVar = new com.baidu.tieba.frs.tab.h();
                    if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                        if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                            StringBuilder sb = new StringBuilder();
                            String lowerCase = frsTabInfo.tab_url.toLowerCase();
                            if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://") && !lowerCase.contains("://")) {
                                sb.append("http://");
                            }
                            sb.append(frsTabInfo.tab_url);
                            sb.append("&");
                            sb.append("fid");
                            sb.append("=");
                            sb.append(oVar.avu().getId());
                            hVar.url = sb.toString();
                            if (!TextUtils.isEmpty(hVar.url)) {
                            }
                            hVar.btZ = frsTabInfo.tab_id.intValue();
                            hVar.name = frsTabInfo.tab_name;
                            if (frsTabInfo.tab_type.intValue() != 11) {
                            }
                            if (frsTabInfo.tab_id.intValue() == 1) {
                            }
                            if (frsTabInfo.tab_id.intValue() == 1) {
                            }
                        }
                    } else if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                        if (frsTabInfo.tab_type.intValue() != 1 || frsTabInfo.tab_id.intValue() >= 100) {
                            if (frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.hd(frsTabInfo.tab_id.intValue())) {
                            }
                            if (!TextUtils.isEmpty(hVar.url)) {
                                try {
                                    uri = new URI(hVar.url);
                                } catch (URISyntaxException e) {
                                    BdLog.e(e);
                                    uri = null;
                                }
                                if (uri != null) {
                                    String host = uri.getHost();
                                    aw awVar = new aw("c10078");
                                    awVar.ac("obj_type", host);
                                    TiebaStatic.log(awVar);
                                }
                            }
                            hVar.btZ = frsTabInfo.tab_id.intValue();
                            hVar.name = frsTabInfo.tab_name;
                            if (frsTabInfo.tab_type.intValue() != 11 && HorizontalTabView.hd(frsTabInfo.tab_id.intValue())) {
                                hVar.url = frsTabInfo.tab_url;
                                if (Static.bY(hVar.url)) {
                                    if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                        this.bsF.add(hVar);
                                    }
                                } else {
                                    this.bsF.add(hVar);
                                }
                            } else if (frsTabInfo.tab_id.intValue() == 1 && ez.Su().gU(frsTabInfo.tab_id.intValue())) {
                                ex gR = ew.St().gR(hVar.btZ);
                                if (gR != null && gR.bqQ != null && gR.bqQ.size() > 0) {
                                    hVar.bua = new fv();
                                    hVar.bua.bqP = gR.bqP;
                                    hVar.bua.bqQ = new LinkedList();
                                    boolean z3 = true;
                                    for (ev evVar : gR.bqQ) {
                                        if (evVar != null) {
                                            fu fuVar = new fu();
                                            fuVar.name = evVar.name;
                                            fuVar.bqM = evVar.bqM;
                                            if (z3) {
                                                fuVar.isSelected = true;
                                                z2 = false;
                                            } else {
                                                z2 = z3;
                                            }
                                            hVar.bua.bqQ.add(fuVar);
                                            z3 = z2;
                                        }
                                    }
                                }
                                this.bsF.add(hVar);
                            } else if (frsTabInfo.tab_id.intValue() == 1) {
                                ex gR2 = ew.St().gR(hVar.btZ);
                                if (gR2 != null && gR2.bqQ != null && gR2.bqQ.size() > 0) {
                                    hVar.bua = new fv();
                                    hVar.bua.bqP = gR2.bqP;
                                    hVar.bua.bqQ = new LinkedList();
                                    for (ev evVar2 : gR2.bqQ) {
                                        if (evVar2 != null) {
                                            fu fuVar2 = new fu();
                                            fuVar2.name = evVar2.name;
                                            fuVar2.bqM = evVar2.bqM;
                                            hVar.bua.bqQ.add(fuVar2);
                                        }
                                    }
                                }
                                this.bsF.add(hVar);
                            }
                        }
                    }
                }
            }
            this.bsD.g(this.bsF, aRY);
            boolean z4 = !this.buz.Tr();
            boolean z5 = this.buz.getVisibility() == 0;
            this.buz.g(this.bsF, aRY);
            if (z4 && !z5) {
                this.buz.setVisibility(8);
            }
            if (!this.buK) {
                SS();
            }
        }
    }

    private void f(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar == null || oVar.aRV() == null || oVar.aRV().size() == 0) {
            ew.St().a(1, null);
            return;
        }
        List<CategoryInfo> aRV = oVar.aRV();
        ex exVar = new ex();
        exVar.bqP = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < aRV.size()) {
                if (aRV.get(i2) != null) {
                    ev evVar = new ev();
                    evVar.bqM = aRV.get(i2).category_id.intValue();
                    evVar.name = aRV.get(i2).category_name;
                    arrayList.add(evVar);
                }
                i = i2 + 1;
            } else {
                exVar.bqQ = arrayList;
                ew.St().a(1, exVar);
                return;
            }
        }
    }

    private void cM(boolean z) {
        ex exVar = new ex();
        exVar.bqP = 0;
        ArrayList arrayList = new ArrayList();
        ev evVar = new ev();
        evVar.bqM = 2;
        evVar.name = this.bts.getResources().getString(t.j.frsgroup_hot);
        arrayList.add(evVar);
        ev evVar2 = new ev();
        evVar2.bqM = 3;
        evVar2.name = this.bts.getResources().getString(t.j.frsgroup_official);
        arrayList.add(evVar2);
        if (z) {
            ev evVar3 = new ev();
            evVar3.bqM = 1;
            evVar3.name = this.bts.getResources().getString(t.j.frsgroup_recommend);
            arrayList.add(0, evVar3);
        }
        exVar.bqQ = arrayList;
        ew.St().a(4, exVar);
    }

    public void a(fo foVar) {
        if (this.bsD != null) {
            this.bsD.setDataLoadInterface(this.buM);
        }
        this.buN = foVar;
    }

    public boolean TR() {
        return this.buz.getVisibility() == 0;
    }

    public TabData TS() {
        return this.bsF;
    }

    private int TT() {
        if (this.mPageType == "normal_page") {
            if (this.bux.Uc() != null && this.bux.Uc().getParent() != null) {
                return this.buw.getHeaderViewsCount() - 2;
            }
            return this.buw.getHeaderViewsCount() - 1;
        } else if (this.mPageType == "frs_page") {
            if (this.buy.Uc() != null && this.buy.Uc().getParent() != null) {
                return this.buw.getHeaderViewsCount() - 2;
            }
            return this.buw.getHeaderViewsCount() - 1;
        } else {
            return 0;
        }
    }

    public boolean TU() {
        return this.buL;
    }
}
