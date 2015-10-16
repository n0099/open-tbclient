package com.baidu.tieba.frs.b;

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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.Cdo;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.eh;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.i;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.ai;
import com.baidu.tieba.tbadkCore.w;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f<FrsActivity> {
    private w LT;
    private int aLz;
    private final View.OnClickListener aWQ;
    private FrsActivity baR;
    private HorizontalTabView bag;
    private TabData bai;
    private BdListView bbG;
    private FrsHeaderView bbH;
    private com.baidu.tieba.frs.view.q bbI;
    private HorizontalTabView bbJ;
    private com.baidu.tieba.frs.view.j bbK;
    private bp bbL;
    private int bbM;
    private int bbN;
    private String bbO;
    private Runnable bbP;
    private boolean bbQ;
    private ai bbR;
    private eh bbS;
    private o bbT;
    private boolean bbU;
    private boolean bbV;
    private ea bbW;
    private ea bbX;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int NK = NK();
        if (this.bbJ.Nl() && i >= NK) {
            this.bbJ.setVisibility(0);
            this.bag.setVisibility(4);
            return;
        }
        this.bbJ.setVisibility(8);
        this.bag.setVisibility(0);
    }

    public a(FrsActivity frsActivity, o oVar) {
        super(frsActivity.getPageContext());
        this.bbG = null;
        this.bbH = null;
        this.bbI = null;
        this.bag = null;
        this.bbJ = null;
        this.bbK = null;
        this.bbL = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.bbO = null;
        this.bbQ = false;
        this.LT = null;
        this.bbR = null;
        this.bbS = null;
        this.bbU = false;
        this.bbV = false;
        this.bbW = new b(this);
        this.aWQ = new c(this);
        this.baR = frsActivity;
        this.bbT = oVar;
    }

    public void h(Bundle bundle) {
        oM();
        NH();
        NI();
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90);
        this.bag = new HorizontalTabView(this.baR.getActivity(), dimensionPixelSize);
        this.bag.setAutoFillTabCount(4);
        this.bbJ = new HorizontalTabView(this.baR.getActivity(), dimensionPixelSize);
        this.bbJ.setAutoFillTabCount(4);
        this.bbJ.clearAnimation();
        this.bbJ.setVisibility(8);
        this.bag.setFakeTab(this.bbJ);
        this.bbJ.setFakeTab(this.bag);
        this.bbT.D(this.bbJ);
        this.bbQ = TbadkSettings.getInst().loadBoolean(FrsActivity.aTD, false);
    }

    public void onActivityDestroy() {
        if (this.bbH != null) {
            this.bbH.onDestory();
        }
        if (this.bbI != null) {
            this.bbI.onDestory();
        }
        if (this.LT != null) {
            this.LT.ME();
        }
        if (this.bbS != null) {
            this.bbS.ME();
        }
        if (this.bbP != null) {
            this.baR.mHandler.removeCallbacks(this.bbP);
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.bbI != null) {
            this.bbI.changeSkinType(i);
        }
        if (this.bbL != null) {
            this.bbL.notifyDataSetChanged();
        }
        if (this.bbK != null) {
            this.bbK.changeSkinType(i);
        }
        if (this.bbH != null) {
            this.bbH.changeSkinType(i);
        }
        if (this.bag != null) {
            this.bag.vA();
        }
        if (this.bbJ != null) {
            this.bbJ.vA();
            return true;
        }
        return true;
    }

    public FrsHeaderView Nn() {
        return this.bbH;
    }

    public com.baidu.tieba.frs.view.q No() {
        return this.bbI;
    }

    public void t(BdListView bdListView) {
        this.bbG = bdListView;
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
        if (oVar.avG() != null && oVar.avG().size() != 0) {
            z = true;
        }
        if ("frs_page".equals(str)) {
            if (oVar != null && oVar.getUserData() != null && oVar.aeN() != null) {
                d(oVar.getUserData().getIsMem(), oVar.aeN().isLike(), z);
            }
        } else if ("normal_page".equals(str)) {
            if (oVar != null && oVar.getUserData() != null && oVar.aeN() != null) {
                c(oVar.getUserData().getIsMem(), oVar.aeN().isLike(), z);
            }
        } else if ("good_page".equals(str) && oVar != null && oVar.aeN() != null) {
            b(oVar.aeN().getGood_classify(), this.baR.aUB);
        }
        b(oVar);
    }

    public void c(int i, int i2, boolean z) {
        this.aLz = i2;
        Nq();
        this.bbO = "normal_page";
        if (this.bbH == null) {
            this.bbH = new FrsHeaderView(this.baR, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.bbH.changeSkinType(this.mSkinType);
            this.bbH.setCommonClickListener(this.aWQ);
        }
        this.bbG.addHeaderView(this.bbH.getView());
        if (z) {
            MU();
        }
        if (!this.bbV) {
            this.bbG.addHeaderView(this.bbH.NT());
            this.bbV = true;
        }
        Nr();
    }

    public void d(int i, int i2, boolean z) {
        this.aLz = i2;
        Nq();
        this.bbO = "frs_page";
        fT(i);
        this.bbG.addHeaderView(this.bbI.getView());
        if (z) {
            MU();
        }
        if (!this.bbV) {
            this.bbG.addHeaderView(this.bbI.NT());
            this.bbV = true;
        }
        Nr();
    }

    public void fT(int i) {
        if (this.bbI == null) {
            this.bbI = new com.baidu.tieba.frs.view.q(this.baR.getPageContext(), null, null, i);
            this.bbI.changeSkinType(this.mSkinType);
            this.bbI.setCommonClickListener(this.aWQ);
        }
    }

    public void Np() {
        Nq();
        this.bbO = "good_page";
        if (this.bbK == null) {
            this.bbK = new com.baidu.tieba.frs.view.j(getPageContext().getPageActivity());
            this.bbK.changeSkinType(this.mSkinType);
        }
        this.bbG.addHeaderView(this.bbK.getView());
    }

    private void Nq() {
        if ("normal_page".equals(this.bbO) && this.bbH != null) {
            this.bbG.removeHeaderView(this.bbH.getView());
            this.bbG.removeHeaderView(this.bbH.NT());
        } else if ("frs_page".equals(this.bbO) && this.bbI != null) {
            this.bbG.removeHeaderView(this.bbI.getView());
            this.bbG.removeHeaderView(this.bbI.NT());
        } else if ("good_page".equals(this.bbO) && this.bbK != null) {
            this.bbG.removeHeaderView(this.bbK.getView());
        }
        this.bbV = false;
        if (this.bag != null) {
            this.bbG.removeHeaderView(this.bag);
            this.bbU = false;
        }
    }

    public void cj(boolean z) {
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
        if (this.bbP == null) {
            this.bbP = new d(this);
        }
        this.baR.mHandler.postDelayed(this.bbP, 4000L);
    }

    public void c(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            if ("frs_page".equals(this.mPageType)) {
                a(oVar.aeN(), oVar);
            } else if ("normal_page".equals(this.mPageType)) {
                b(oVar.aeN(), oVar);
            }
            b(oVar);
        }
    }

    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (forumData != null && oVar != null) {
            float a = a(forumData);
            if (this.bbI != null) {
                this.bbI.c(forumData, oVar);
                this.bbI.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.bbI.gc(forumData.getSignData().getSigned());
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.bbI.cm(false);
                    }
                }
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (forumData != null && oVar != null) {
            float a = a(forumData);
            if (this.bbH != null) {
                this.bbH.c(forumData, oVar);
                this.bbH.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.bbH.cm(false);
                        return;
                    }
                    this.bbH.cm(true);
                    this.bbH.gc(forumData.getSignData().getSigned());
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.bbM = forumData.getLevelupScore();
        this.bbN = forumData.getCurScore();
        if (this.bbM > 0) {
            return this.bbN / this.bbM;
        }
        return 0.0f;
    }

    public void b(ArrayList<com.baidu.tbadk.core.data.k> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        Np();
        if (arrayList != null) {
            if (this.bbL == null) {
                this.bbL = new bp(getPageContext().getPageActivity(), arrayList);
                this.bbK.a(this.bbL);
                this.bbK.b(onItemClickListener);
                return;
            }
            this.bbL.setData(arrayList);
            this.bbL.notifyDataSetChanged();
        }
    }

    public void fw(int i) {
        if (this.bbL != null) {
            this.bbL.fw(i);
        }
    }

    public void fU(int i) {
        if (i > 1) {
            if (this.bbH != null) {
                this.bbH.setIsFirstPage(false);
            }
            if (this.bbI != null) {
                this.bbI.setIsFirstPage(false);
                return;
            }
            return;
        }
        if (this.bbH != null) {
            this.bbH.setIsFirstPage(true);
        }
        if (this.bbI != null) {
            this.bbI.setIsFirstPage(true);
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
        if (this.bbH != null) {
            this.bbH.setMemberType(i);
        }
        if (this.bbI != null) {
            this.bbI.setMemberType(i);
        }
    }

    public void Ns() {
        if ("normal_page".equals(this.bbO)) {
            if (this.bbH != null) {
                this.bbH.Ns();
            }
        } else if ("frs_page".equals(this.bbO) && this.bbI != null) {
            this.bbI.Ns();
        }
    }

    public void Nt() {
        if (this.bbH != null) {
            this.bbH.NZ();
        }
    }

    public void Nu() {
        if (this.bbI != null) {
            this.bbI.NZ();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (oVar != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(1, oVar.aeN(), oVar, z);
            } else if ("frs_page".equals(this.mPageType)) {
                b(1, oVar.aeN(), oVar, z);
            }
        }
    }

    public void Nv() {
        if ("normal_page".equals(this.mPageType)) {
            fW(0);
        } else if ("frs_page".equals(this.mPageType)) {
            fX(0);
        }
    }

    public void fV(int i) {
        if ("normal_page".equals(this.mPageType)) {
            fW(i);
        } else if ("frs_page".equals(this.mPageType)) {
            fX(i);
        }
    }

    public void fW(int i) {
        if (this.bbH != null) {
            this.bbH.gb(i);
        }
    }

    public void fX(int i) {
        if (this.bbI != null) {
            this.bbI.gb(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (this.bbH != null) {
            this.bbH.c(forumData, oVar);
            if (forumData != null) {
                this.bbH.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.bbH.cm(false);
                }
            }
        }
    }

    public void b(int i, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (this.bbI != null) {
            this.bbI.c(forumData, oVar);
            float a = a(forumData);
            if (forumData != null) {
                this.bbI.a(i, forumData.getLevelName(), forumData.getUser_level(), a, z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.bbI.cm(false);
                }
            }
        }
    }

    public boolean Nw() {
        if ("normal_page".equals(this.bbO) && this.bbH != null) {
            return this.bbH.NR();
        }
        if ("frs_page".equals(this.bbO) && this.bbI != null) {
            return this.bbI.NR();
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
            if (bonusPoint >= this.bbM - this.bbN) {
                z = true;
                this.bbM = signData.getLevelUpScore();
            }
            this.bbN = bonusPoint + this.bbN;
            if (this.bbN > this.bbM) {
                this.bbN = this.bbM;
            }
            if (this.bbM != 0) {
                f = this.bbN / this.bbM;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            aVar.a(z, f);
        }
    }

    public void fY(int i) {
        if ("normal_page".equals(this.mPageType)) {
            fZ(i);
        } else if ("frs_page".equals(this.mPageType)) {
            ga(i);
        }
    }

    public void d(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null && oVar.aeN() != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(oVar.aeN().getSignData(), oVar.aeN(), oVar);
            } else if ("frs_page".equals(this.mPageType)) {
                b(oVar.aeN().getSignData(), oVar.aeN(), oVar);
            }
        }
    }

    public void fZ(int i) {
        if (this.bbH != null) {
            this.bbH.gc(i);
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (this.bbH != null && signData != null && forumData != null && oVar != null) {
            this.bbH.c(forumData, oVar);
            this.bbH.gc(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.bbH.NR()) {
                a(this.bbH, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.bbN);
                    forumData.setLevelupScore(this.bbM);
                }
                this.bbH.c(forumData, oVar);
                this.bbH.e(this.bbH.NX(), true);
            }
        }
    }

    public void ga(int i) {
        if (this.bbI != null) {
            this.bbI.gc(i);
        }
    }

    public void b(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (this.bbI != null && signData != null && forumData != null && oVar != null) {
            this.bbI.c(forumData, oVar);
            this.bbI.gc(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.bbI.NR()) {
                a(this.bbI, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.bbN);
                    forumData.setLevelupScore(this.bbM);
                }
                this.bbI.c(forumData, oVar);
                this.bbI.e(this.bbI.NX(), true);
            }
        }
    }

    public void Nz() {
        if (this.bbH != null) {
            this.bbH.NY().setVisibility(0);
        }
    }

    public void NA() {
        if (this.bbH != null) {
            this.bbH.NY().setVisibility(8);
        }
    }

    public void NB() {
        if (this.bbI != null) {
            this.bbI.NY().setVisibility(0);
        }
    }

    public void NC() {
        if (this.bbI != null) {
            this.bbI.NY().setVisibility(8);
        }
    }

    public boolean ND() {
        if ("normal_page".equals(this.bbO) && this.bbH != null) {
            return this.bbH.ND();
        }
        if ("frs_page".equals(this.bbO) && this.bbI != null) {
            return this.bbI.ND();
        }
        return false;
    }

    public void B(View view) {
        if (this.bbH != null) {
            this.bbH.e(view, false);
        }
    }

    public void C(View view) {
        if (this.bbI != null) {
            this.bbI.e(view, false);
        }
    }

    public boolean NE() {
        if ("normal_page".equals(this.bbO)) {
            if (this.bbH != null) {
                return this.bbH.NE();
            }
        } else if ("frs_page".equals(this.bbO) && this.bbI != null) {
            return this.bbI.NE();
        }
        return false;
    }

    public BarImageView NF() {
        com.baidu.tieba.frs.view.q No;
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
    public void oN() {
        if (this.baR != null) {
            com.baidu.tieba.tbadkCore.o Lh = this.baR.Lh();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m411getInst().login(this.baR.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, 11002)));
            } else if (Lh != null && Lh.aeN() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.baR.getFrom())) {
                    this.LT.setFrom(FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                    TiebaStatic.log(new aq("c10356").ae(ImageViewerConfig.FORUM_ID, Lh.aeN().getId()));
                } else {
                    this.LT.setFrom("from_frs");
                }
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.baR.getFrom())) {
                    TiebaStatic.eventStat(this.baR.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                }
                this.LT.be(Lh.aeN().getName(), Lh.aeN().getId());
            }
        }
    }

    public void Ll() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.baR.Lh() != null && this.baR.Lh().aeN() != null && this.baR.Lh().aeN().getName() != null) {
            str = this.baR.Lh().aeN().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cu(String.format(getPageContext().getString(i.h.attention_cancel_dialog_content), str));
        } else {
            aVar.cu(getPageContext().getString(i.h.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(i.h.editor_dialog_yes), new e(this));
        aVar.b(getPageContext().getString(i.h.editor_dialog_no), new f(this));
        aVar.b(getPageContext()).sR();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void NG() {
        com.baidu.tieba.tbadkCore.o Lh = this.baR.Lh();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.baR.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, 11014)));
        } else if (Lh != null && Lh.aeN() != null) {
            Nx();
            this.bbS.au(Lh.aeN().getName(), Lh.aeN().getId());
        }
    }

    private void oM() {
        this.LT = new w(this.baR.getPageContext());
        this.LT.setLoadDataCallBack(new g(this));
    }

    private void NH() {
        this.bbR = new ai();
        this.bbR.setFrom("from_frs");
        this.bbR.a(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        new i(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void NI() {
        this.bbS = new eh(this.baR);
        this.bbS.setLoadDataCallBack(new j(this));
    }

    private void MU() {
        if (this.bag != null && !this.bbU) {
            this.bbG.addHeaderView(this.bag, Integer.valueOf(this.bbG.getHeaderViewsCount()), false);
            this.bbU = true;
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
        if (oVar != null && oVar.avG() != null && oVar.avG().size() != 0) {
            if (oVar.avA() != null) {
                z = oVar.avA().avs() != 1;
            } else {
                z = false;
            }
            ck(z);
            this.bai = new TabData();
            for (FrsTabInfo frsTabInfo : oVar.avG()) {
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
                            sb.append(oVar.aeN().getId());
                            gVar.url = sb.toString();
                            if (!TextUtils.isEmpty(gVar.url)) {
                            }
                            gVar.bbr = frsTabInfo.tab_id.intValue();
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
                                aq aqVar = new aq("c10078");
                                aqVar.ae("obj_type", host);
                                TiebaStatic.log(aqVar);
                            }
                        }
                        gVar.bbr = frsTabInfo.tab_id.intValue();
                        gVar.name = frsTabInfo.tab_name;
                        if (frsTabInfo.tab_id.intValue() == 1 && Cdo.Mw().fI(frsTabInfo.tab_id.intValue())) {
                            List<n> fF = dm.Mv().fF(gVar.bbr);
                            if (fF != null && fF.size() > 0) {
                                gVar.bbs = new LinkedList();
                                boolean z3 = true;
                                for (n nVar : fF) {
                                    if (nVar != null) {
                                        com.baidu.tieba.frs.tab.h hVar = new com.baidu.tieba.frs.tab.h();
                                        hVar.name = nVar.name;
                                        hVar.bbx = nVar.bbx;
                                        if (z3) {
                                            hVar.isSelected = true;
                                            z2 = false;
                                        } else {
                                            z2 = z3;
                                        }
                                        gVar.bbs.add(hVar);
                                        z3 = z2;
                                    }
                                }
                            }
                            this.bai.add(gVar);
                        } else if (frsTabInfo.tab_id.intValue() != 1) {
                            this.bai.add(gVar);
                        }
                    }
                }
            }
            this.bag.setData((List<com.baidu.tieba.frs.tab.g>) this.bai, true);
            boolean z4 = !this.bbJ.Nl();
            boolean z5 = this.bbJ.getVisibility() == 0;
            this.bbJ.setData((List<com.baidu.tieba.frs.tab.g>) this.bai, true);
            if (z4 && !z5) {
                this.bbJ.setVisibility(8);
            }
            if (!this.bbU) {
                MU();
            }
        }
    }

    private void ck(boolean z) {
        ArrayList arrayList = new ArrayList();
        n nVar = new n();
        nVar.bbx = 2;
        nVar.name = this.baR.getResources().getString(i.h.frsgroup_hot);
        arrayList.add(nVar);
        n nVar2 = new n();
        nVar2.bbx = 3;
        nVar2.name = this.baR.getResources().getString(i.h.frsgroup_official);
        arrayList.add(nVar2);
        if (z) {
            n nVar3 = new n();
            nVar3.bbx = 1;
            nVar3.name = this.baR.getResources().getString(i.h.frsgroup_recommend);
            arrayList.add(0, nVar3);
        }
        dm.Mv().c(4, arrayList);
    }

    public void a(ea eaVar) {
        if (this.bag != null) {
            this.bag.setDataLoadInterface(this.bbW);
        }
        this.bbX = eaVar;
    }

    public boolean NJ() {
        return this.bbJ.getVisibility() == 0;
    }

    private int NK() {
        if (this.mPageType == "normal_page") {
            if (this.bbH.NT() != null && this.bbH.NT().getParent() != null) {
                return this.bbG.getHeaderViewsCount() - 2;
            }
            return this.bbG.getHeaderViewsCount() - 1;
        } else if (this.mPageType == "frs_page") {
            if (this.bbI.NT() != null && this.bbI.NT().getParent() != null) {
                return this.bbG.getHeaderViewsCount() - 2;
            }
            return this.bbG.getHeaderViewsCount() - 1;
        } else {
            return 0;
        }
    }

    public boolean NL() {
        return this.bbV;
    }
}
