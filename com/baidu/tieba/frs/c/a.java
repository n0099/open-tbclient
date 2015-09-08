package com.baidu.tieba.frs.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.Cdo;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.frs.da;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.i;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.aj;
import com.baidu.tieba.tbadkCore.w;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f<FrsActivity> {
    private w LS;
    private int aMu;
    private final View.OnClickListener aXl;
    private FrsActivity baN;
    private HorizontalTabView bac;
    private TabData bae;
    private BdListView bbB;
    private FrsHeaderView bbC;
    private com.baidu.tieba.frs.view.p bbD;
    private HorizontalTabView bbE;
    private com.baidu.tieba.frs.view.j bbF;
    private bf bbG;
    private int bbH;
    private int bbI;
    private String bbJ;
    private Runnable bbK;
    private boolean bbL;
    private aj bbM;
    private Cdo bbN;
    private n bbO;
    private boolean bbP;
    private boolean bbQ;
    private dh bbR;
    private dh bbS;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int NK = NK();
        if (this.bbE.Nm() && i >= NK) {
            this.bbE.setVisibility(0);
            this.bac.setVisibility(4);
            return;
        }
        this.bbE.setVisibility(8);
        this.bac.setVisibility(0);
    }

    public a(FrsActivity frsActivity, n nVar) {
        super(frsActivity.getPageContext());
        this.bbB = null;
        this.bbC = null;
        this.bbD = null;
        this.bac = null;
        this.bbE = null;
        this.bbF = null;
        this.bbG = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.bbJ = null;
        this.bbL = false;
        this.LS = null;
        this.bbM = null;
        this.bbN = null;
        this.bbP = false;
        this.bbQ = false;
        this.bbR = new b(this);
        this.aXl = new c(this);
        this.baN = frsActivity;
        this.bbO = nVar;
    }

    public void h(Bundle bundle) {
        oL();
        NH();
        NI();
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90);
        this.bac = new HorizontalTabView(this.baN.getActivity(), dimensionPixelSize);
        this.bac.setAutoFillTabCount(4);
        this.bbE = new HorizontalTabView(this.baN.getActivity(), dimensionPixelSize);
        this.bbE.setAutoFillTabCount(4);
        this.bbE.clearAnimation();
        this.bbE.setVisibility(8);
        this.bac.setFakeTab(this.bbE);
        this.bbE.setFakeTab(this.bac);
        this.bbO.D(this.bbE);
        this.bbL = TbadkSettings.getInst().loadBoolean(FrsActivity.aUw, false);
    }

    public void onActivityDestroy() {
        if (this.bbC != null) {
            this.bbC.onDestory();
        }
        if (this.bbD != null) {
            this.bbD.onDestory();
        }
        if (this.LS != null) {
            this.LS.MF();
        }
        if (this.bbN != null) {
            this.bbN.MF();
        }
        if (this.bbK != null) {
            this.baN.mHandler.removeCallbacks(this.bbK);
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.bbD != null) {
            this.bbD.changeSkinType(i);
        }
        if (this.bbG != null) {
            this.bbG.notifyDataSetChanged();
        }
        if (this.bbF != null) {
            this.bbF.changeSkinType(i);
        }
        if (this.bbC != null) {
            this.bbC.changeSkinType(i);
        }
        if (this.bac != null) {
            this.bac.vI();
        }
        if (this.bbE != null) {
            this.bbE.vI();
            return true;
        }
        return true;
    }

    public FrsHeaderView Nn() {
        return this.bbC;
    }

    public com.baidu.tieba.frs.view.p No() {
        return this.bbD;
    }

    public void t(BdListView bdListView) {
        this.bbB = bdListView;
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
        if (oVar.atk() != null && oVar.atk().size() != 0) {
            z = true;
        }
        if ("frs_page".equals(str)) {
            if (oVar != null && oVar.getUserData() != null && oVar.acP() != null) {
                d(oVar.getUserData().getIsMem(), oVar.acP().isLike(), z);
            }
        } else if ("normal_page".equals(str)) {
            if (oVar != null && oVar.getUserData() != null && oVar.acP() != null) {
                c(oVar.getUserData().getIsMem(), oVar.acP().isLike(), z);
            }
        } else if ("good_page".equals(str) && oVar != null && oVar.acP() != null) {
            b(oVar.acP().getGood_classify(), this.baN.aVq);
        }
        b(oVar);
    }

    public void c(int i, int i2, boolean z) {
        this.aMu = i2;
        Nq();
        this.bbJ = "normal_page";
        if (this.bbC == null) {
            this.bbC = new FrsHeaderView(this.baN, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.bbC.changeSkinType(this.mSkinType);
            this.bbC.setCommonClickListener(this.aXl);
        }
        this.bbB.addHeaderView(this.bbC.getView());
        if (z) {
            MV();
        }
        if (!this.bbQ) {
            this.bbB.addHeaderView(this.bbC.NT());
            this.bbQ = true;
        }
        Nr();
    }

    public void d(int i, int i2, boolean z) {
        this.aMu = i2;
        Nq();
        this.bbJ = "frs_page";
        fO(i);
        this.bbB.addHeaderView(this.bbD.getView());
        if (z) {
            MV();
        }
        if (!this.bbQ) {
            this.bbB.addHeaderView(this.bbD.NT());
            this.bbQ = true;
        }
        Nr();
    }

    public void fO(int i) {
        if (this.bbD == null) {
            this.bbD = new com.baidu.tieba.frs.view.p(this.baN.getPageContext(), null, null, i);
            this.bbD.changeSkinType(this.mSkinType);
            this.bbD.setCommonClickListener(this.aXl);
        }
    }

    public void Np() {
        Nq();
        this.bbJ = "good_page";
        if (this.bbF == null) {
            this.bbF = new com.baidu.tieba.frs.view.j(getPageContext().getPageActivity());
            this.bbF.changeSkinType(this.mSkinType);
        }
        this.bbB.addHeaderView(this.bbF.getView());
    }

    private void Nq() {
        if ("normal_page".equals(this.bbJ) && this.bbC != null) {
            this.bbB.removeHeaderView(this.bbC.getView());
            this.bbB.removeHeaderView(this.bbC.NT());
        } else if ("frs_page".equals(this.bbJ) && this.bbD != null) {
            this.bbB.removeHeaderView(this.bbD.getView());
            this.bbB.removeHeaderView(this.bbD.NT());
        } else if ("good_page".equals(this.bbJ) && this.bbF != null) {
            this.bbB.removeHeaderView(this.bbF.getView());
        }
        this.bbQ = false;
        if (this.bac != null) {
            this.bbB.removeHeaderView(this.bac);
            this.bbP = false;
        }
    }

    public void cm(boolean z) {
        if (z) {
            if (Nn() != null) {
                Nn().NW();
            }
            if (No() != null) {
                No().NW();
                return;
            }
            return;
        }
        if (Nn() != null) {
            Nn().NV();
        }
        if (No() != null) {
            No().NV();
        }
    }

    private void Nr() {
        if (this.bbK == null) {
            this.bbK = new d(this);
        }
        this.baN.mHandler.postDelayed(this.bbK, 4000L);
    }

    public void c(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            if ("frs_page".equals(this.mPageType)) {
                a(oVar.acP(), oVar);
            } else if ("normal_page".equals(this.mPageType)) {
                b(oVar.acP(), oVar);
            }
            b(oVar);
        }
    }

    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (forumData != null && oVar != null) {
            float a = a(forumData);
            if (this.bbD != null) {
                this.bbD.c(forumData, oVar);
                this.bbD.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.bbD.fX(forumData.getSignData().getSigned());
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.bbD.cp(false);
                    }
                }
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (forumData != null && oVar != null) {
            float a = a(forumData);
            if (this.bbC != null) {
                this.bbC.c(forumData, oVar);
                this.bbC.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.bbC.cp(false);
                        return;
                    }
                    this.bbC.cp(true);
                    this.bbC.fX(forumData.getSignData().getSigned());
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.bbH = forumData.getLevelupScore();
        this.bbI = forumData.getCurScore();
        if (this.bbH > 0) {
            return this.bbI / this.bbH;
        }
        return 0.0f;
    }

    public void b(ArrayList<com.baidu.tbadk.core.data.k> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        Np();
        if (arrayList != null) {
            if (this.bbG == null) {
                this.bbG = new bf(getPageContext().getPageActivity(), arrayList);
                this.bbF.a(this.bbG);
                this.bbF.b(onItemClickListener);
                return;
            }
            this.bbG.setData(arrayList);
            this.bbG.notifyDataSetChanged();
        }
    }

    public void fr(int i) {
        if (this.bbG != null) {
            this.bbG.fr(i);
        }
    }

    public void fP(int i) {
        if (i > 1) {
            if (this.bbC != null) {
                this.bbC.setIsFirstPage(false);
            }
            if (this.bbD != null) {
                this.bbD.setIsFirstPage(false);
                return;
            }
            return;
        }
        if (this.bbC != null) {
            this.bbC.setIsFirstPage(true);
        }
        if (this.bbD != null) {
            this.bbD.setIsFirstPage(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void b(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType)) {
            Nu();
        } else if ("normal_page".equals(this.mPageType)) {
            Nt();
        }
    }

    public void setIsMem(int i) {
        if (this.bbC != null) {
            this.bbC.setMemberType(i);
        }
        if (this.bbD != null) {
            this.bbD.setMemberType(i);
        }
    }

    public void Ns() {
        if ("normal_page".equals(this.bbJ)) {
            if (this.bbC != null) {
                this.bbC.Ns();
            }
        } else if ("frs_page".equals(this.bbJ) && this.bbD != null) {
            this.bbD.Ns();
        }
    }

    public void Nt() {
        if (this.bbC != null) {
            this.bbC.NZ();
        }
    }

    public void Nu() {
        if (this.bbD != null) {
            this.bbD.NZ();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (oVar != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(1, oVar.acP(), oVar, z);
            } else if ("frs_page".equals(this.mPageType)) {
                b(1, oVar.acP(), oVar, z);
            }
        }
    }

    public void Nv() {
        if ("normal_page".equals(this.mPageType)) {
            fR(0);
        } else if ("frs_page".equals(this.mPageType)) {
            fS(0);
        }
    }

    public void fQ(int i) {
        if ("normal_page".equals(this.mPageType)) {
            fR(i);
        } else if ("frs_page".equals(this.mPageType)) {
            fS(i);
        }
    }

    public void fR(int i) {
        if (this.bbC != null) {
            this.bbC.fW(i);
        }
    }

    public void fS(int i) {
        if (this.bbD != null) {
            this.bbD.fW(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (this.bbC != null) {
            this.bbC.c(forumData, oVar);
            if (forumData != null) {
                this.bbC.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.bbC.cp(false);
                }
            }
        }
    }

    public void b(int i, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (this.bbD != null) {
            this.bbD.c(forumData, oVar);
            float a = a(forumData);
            if (forumData != null) {
                this.bbD.a(i, forumData.getLevelName(), forumData.getUser_level(), a, z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.bbD.cp(false);
                }
            }
        }
    }

    public boolean Nw() {
        if ("normal_page".equals(this.bbJ) && this.bbC != null) {
            return this.bbC.NR();
        }
        if ("frs_page".equals(this.bbJ) && this.bbD != null) {
            return this.bbD.NR();
        }
        return false;
    }

    public void Nx() {
        if ("normal_page".equals(this.mPageType)) {
            Nz();
        } else if ("frs_page".equals(this.mPageType)) {
            NB();
        }
    }

    public void Ny() {
        if ("normal_page".equals(this.mPageType)) {
            NA();
        } else if ("frs_page".equals(this.mPageType)) {
            NC();
        }
    }

    private void a(com.baidu.tieba.frs.view.a aVar, SignData signData) {
        if (aVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.bbH - this.bbI) {
                z = true;
                this.bbH = signData.getLevelUpScore();
            }
            this.bbI = bonusPoint + this.bbI;
            if (this.bbI > this.bbH) {
                this.bbI = this.bbH;
            }
            if (this.bbH != 0) {
                f = this.bbI / this.bbH;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            aVar.a(z, f);
        }
    }

    public void fT(int i) {
        if ("normal_page".equals(this.mPageType)) {
            fU(i);
        } else if ("frs_page".equals(this.mPageType)) {
            fV(i);
        }
    }

    public void d(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null && oVar.acP() != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(oVar.acP().getSignData(), oVar.acP(), oVar);
            } else if ("frs_page".equals(this.mPageType)) {
                b(oVar.acP().getSignData(), oVar.acP(), oVar);
            }
        }
    }

    public void fU(int i) {
        if (this.bbC != null) {
            this.bbC.fX(i);
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (this.bbC != null && signData != null && forumData != null && oVar != null) {
            this.bbC.c(forumData, oVar);
            this.bbC.fX(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.bbC.NR()) {
                a(this.bbC, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.bbI);
                    forumData.setLevelupScore(this.bbH);
                }
                this.bbC.c(forumData, oVar);
                this.bbC.e(this.bbC.NX(), true);
            }
        }
    }

    public void fV(int i) {
        if (this.bbD != null) {
            this.bbD.fX(i);
        }
    }

    public void b(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (this.bbD != null && signData != null && forumData != null && oVar != null) {
            this.bbD.c(forumData, oVar);
            this.bbD.fX(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.bbD.NR()) {
                a(this.bbD, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.bbI);
                    forumData.setLevelupScore(this.bbH);
                }
                this.bbD.c(forumData, oVar);
                this.bbD.e(this.bbD.NX(), true);
            }
        }
    }

    public void Nz() {
        if (this.bbC != null) {
            this.bbC.NY().setVisibility(0);
        }
    }

    public void NA() {
        if (this.bbC != null) {
            this.bbC.NY().setVisibility(8);
        }
    }

    public void NB() {
        if (this.bbD != null) {
            this.bbD.NY().setVisibility(0);
        }
    }

    public void NC() {
        if (this.bbD != null) {
            this.bbD.NY().setVisibility(8);
        }
    }

    public boolean ND() {
        if ("normal_page".equals(this.bbJ) && this.bbC != null) {
            return this.bbC.ND();
        }
        if ("frs_page".equals(this.bbJ) && this.bbD != null) {
            return this.bbD.ND();
        }
        return false;
    }

    public void B(View view) {
        if (this.bbC != null) {
            this.bbC.e(view, false);
        }
    }

    public void C(View view) {
        if (this.bbD != null) {
            this.bbD.e(view, false);
        }
    }

    public boolean NE() {
        if ("normal_page".equals(this.bbJ)) {
            if (this.bbC != null) {
                return this.bbC.NE();
            }
        } else if ("frs_page".equals(this.bbJ) && this.bbD != null) {
            return this.bbD.NE();
        }
        return false;
    }

    public BarImageView NF() {
        com.baidu.tieba.frs.view.p No;
        if ("normal_page".equals(this.mPageType)) {
            FrsHeaderView Nn = Nn();
            if (Nn != null) {
                return Nn.NF();
            }
        } else if ("frs_page".equals(this.mPageType) && (No = No()) != null) {
            return No.NF();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void oM() {
        if (this.baN != null) {
            com.baidu.tieba.tbadkCore.o Ll = this.baN.Ll();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m411getInst().login(this.baN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, 11002)));
            } else if (Ll != null && Ll.acP() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.baN.getFrom())) {
                    this.LS.setFrom(FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                } else {
                    this.LS.setFrom("from_frs");
                }
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.baN.getFrom())) {
                    TiebaStatic.eventStat(this.baN.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                }
                this.LS.be(Ll.acP().getName(), Ll.acP().getId());
            }
        }
    }

    public void Lp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.baN.Ll() != null && this.baN.Ll().acP() != null && this.baN.Ll().acP().getName() != null) {
            str = this.baN.Ll().acP().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.ct(String.format(getPageContext().getString(i.h.attention_cancel_dialog_content), str));
        } else {
            aVar.ct(getPageContext().getString(i.h.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(i.h.editor_dialog_yes), new e(this));
        aVar.b(getPageContext().getString(i.h.editor_dialog_no), new f(this));
        aVar.b(getPageContext()).sU();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void NG() {
        com.baidu.tieba.tbadkCore.o Ll = this.baN.Ll();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.baN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, 11014)));
        } else if (Ll != null && Ll.acP() != null) {
            Nx();
            this.bbN.av(Ll.acP().getName(), Ll.acP().getId());
        }
    }

    private void oL() {
        this.LS = new w(this.baN.getPageContext());
        this.LS.setLoadDataCallBack(new g(this));
    }

    private void NH() {
        this.bbM = new aj();
        this.bbM.setFrom("from_frs");
        this.bbM.a(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        new i(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void NI() {
        this.bbN = new Cdo(this.baN);
        this.bbN.setLoadDataCallBack(new j(this));
    }

    private void MV() {
        if (this.bac != null && !this.bbP) {
            this.bbB.addHeaderView(this.bac, Integer.valueOf(this.bbB.getHeaderViewsCount()), false);
            this.bbP = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01d9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x003a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.tbadkCore.o oVar) {
        boolean z;
        boolean z2;
        URI uri;
        if (oVar != null && oVar.atk() != null && oVar.atk().size() != 0) {
            if (oVar.ate() != null) {
                z = oVar.ate().asW() != 1;
            } else {
                z = false;
            }
            cn(z);
            this.bae = new TabData();
            for (FrsTabInfo frsTabInfo : oVar.atk()) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() > 0 && !TextUtils.isEmpty(frsTabInfo.tab_name) && !TextUtils.isEmpty(frsTabInfo.tab_name.trim()) && (frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0)) {
                    com.baidu.tieba.frs.tab.g gVar = new com.baidu.tieba.frs.tab.g();
                    if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                        if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                            StringBuilder sb = new StringBuilder();
                            String lowerCase = frsTabInfo.tab_url.toLowerCase();
                            if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://") && !lowerCase.contains("://")) {
                                sb.append("http://");
                            }
                            sb.append(frsTabInfo.tab_url);
                            sb.append("&");
                            sb.append(ImageViewerConfig.FORUM_ID);
                            sb.append("=");
                            sb.append(oVar.acP().getId());
                            gVar.url = sb.toString();
                            if (!TextUtils.isEmpty(gVar.url)) {
                            }
                            gVar.bbn = frsTabInfo.tab_id.intValue();
                            gVar.name = frsTabInfo.tab_name;
                            if (frsTabInfo.tab_id.intValue() == 1) {
                            }
                            if (frsTabInfo.tab_id.intValue() != 1) {
                            }
                        }
                    } else if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                        if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() < 100) {
                        }
                        if (!TextUtils.isEmpty(gVar.url)) {
                            try {
                                uri = new URI(gVar.url);
                            } catch (URISyntaxException e) {
                                BdLog.e(e);
                                uri = null;
                            }
                            if (uri != null) {
                                String host = uri.getHost();
                                ao aoVar = new ao("c10078");
                                aoVar.af("obj_type", host);
                                TiebaStatic.log(aoVar);
                            }
                        }
                        gVar.bbn = frsTabInfo.tab_id.intValue();
                        gVar.name = frsTabInfo.tab_name;
                        if (frsTabInfo.tab_id.intValue() == 1 && da.Mx().fD(frsTabInfo.tab_id.intValue())) {
                            List<cx> fA = cy.Mw().fA(gVar.bbn);
                            if (fA != null && fA.size() > 0) {
                                gVar.bbo = new LinkedList();
                                boolean z3 = true;
                                for (cx cxVar : fA) {
                                    if (cxVar != null) {
                                        com.baidu.tieba.frs.tab.h hVar = new com.baidu.tieba.frs.tab.h();
                                        hVar.name = cxVar.name;
                                        hVar.aYK = cxVar.aYK;
                                        if (z3) {
                                            hVar.isSelected = true;
                                            z2 = false;
                                        } else {
                                            z2 = z3;
                                        }
                                        gVar.bbo.add(hVar);
                                        z3 = z2;
                                    }
                                }
                            }
                            this.bae.add(gVar);
                        } else if (frsTabInfo.tab_id.intValue() != 1) {
                            this.bae.add(gVar);
                        }
                    }
                }
            }
            this.bac.setData((List<com.baidu.tieba.frs.tab.g>) this.bae, true);
            boolean z4 = !this.bbE.Nm();
            boolean z5 = this.bbE.getVisibility() == 0;
            this.bbE.setData((List<com.baidu.tieba.frs.tab.g>) this.bae, true);
            if (z4 && !z5) {
                this.bbE.setVisibility(8);
            }
            if (!this.bbP) {
                MV();
            }
        }
    }

    private void cn(boolean z) {
        ArrayList arrayList = new ArrayList();
        cx cxVar = new cx();
        cxVar.aYK = 2;
        cxVar.name = this.baN.getResources().getString(i.h.frsgroup_hot);
        arrayList.add(cxVar);
        cx cxVar2 = new cx();
        cxVar2.aYK = 3;
        cxVar2.name = this.baN.getResources().getString(i.h.frsgroup_official);
        arrayList.add(cxVar2);
        if (z) {
            cx cxVar3 = new cx();
            cxVar3.aYK = 1;
            cxVar3.name = this.baN.getResources().getString(i.h.frsgroup_recommend);
            arrayList.add(0, cxVar3);
        }
        cy.Mw().c(4, arrayList);
    }

    public void a(dh dhVar) {
        if (this.bac != null) {
            this.bac.setDataLoadInterface(this.bbR);
        }
        this.bbS = dhVar;
    }

    public boolean NJ() {
        return this.bbE.getVisibility() == 0;
    }

    private int NK() {
        if (this.mPageType == "normal_page") {
            if (this.bbC.NT() != null && this.bbC.NT().getParent() != null) {
                return this.bbB.getHeaderViewsCount() - 2;
            }
            return this.bbB.getHeaderViewsCount() - 1;
        } else if (this.mPageType == "frs_page") {
            if (this.bbD.NT() != null && this.bbD.NT().getParent() != null) {
                return this.bbB.getHeaderViewsCount() - 2;
            }
            return this.bbB.getHeaderViewsCount() - 1;
        } else {
            return 0;
        }
    }

    public boolean NL() {
        return this.bbQ;
    }
}
