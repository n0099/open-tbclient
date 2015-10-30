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
        int NG = NG();
        if (this.bbJ.Nh() && i >= NG) {
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
        ND();
        NE();
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
            this.LT.MA();
        }
        if (this.bbS != null) {
            this.bbS.MA();
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
            this.bag.vx();
        }
        if (this.bbJ != null) {
            this.bbJ.vx();
            return true;
        }
        return true;
    }

    public FrsHeaderView Nj() {
        return this.bbH;
    }

    public com.baidu.tieba.frs.view.q Nk() {
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
        if (oVar.avC() != null && oVar.avC().size() != 0) {
            z = true;
        }
        if ("frs_page".equals(str)) {
            if (oVar != null && oVar.getUserData() != null && oVar.aeJ() != null) {
                d(oVar.getUserData().getIsMem(), oVar.aeJ().isLike(), z);
            }
        } else if ("normal_page".equals(str)) {
            if (oVar != null && oVar.getUserData() != null && oVar.aeJ() != null) {
                c(oVar.getUserData().getIsMem(), oVar.aeJ().isLike(), z);
            }
        } else if ("good_page".equals(str) && oVar != null && oVar.aeJ() != null) {
            b(oVar.aeJ().getGood_classify(), this.baR.aUB);
        }
        b(oVar);
    }

    public void c(int i, int i2, boolean z) {
        this.aLz = i2;
        Nm();
        this.bbO = "normal_page";
        if (this.bbH == null) {
            this.bbH = new FrsHeaderView(this.baR, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.bbH.changeSkinType(this.mSkinType);
            this.bbH.setCommonClickListener(this.aWQ);
        }
        this.bbG.addHeaderView(this.bbH.getView());
        if (z) {
            MQ();
        }
        if (!this.bbV) {
            this.bbG.addHeaderView(this.bbH.NP());
            this.bbV = true;
        }
        Nn();
    }

    public void d(int i, int i2, boolean z) {
        this.aLz = i2;
        Nm();
        this.bbO = "frs_page";
        fT(i);
        this.bbG.addHeaderView(this.bbI.getView());
        if (z) {
            MQ();
        }
        if (!this.bbV) {
            this.bbG.addHeaderView(this.bbI.NP());
            this.bbV = true;
        }
        Nn();
    }

    public void fT(int i) {
        if (this.bbI == null) {
            this.bbI = new com.baidu.tieba.frs.view.q(this.baR.getPageContext(), null, null, i);
            this.bbI.changeSkinType(this.mSkinType);
            this.bbI.setCommonClickListener(this.aWQ);
        }
    }

    public void Nl() {
        Nm();
        this.bbO = "good_page";
        if (this.bbK == null) {
            this.bbK = new com.baidu.tieba.frs.view.j(getPageContext().getPageActivity());
            this.bbK.changeSkinType(this.mSkinType);
        }
        this.bbG.addHeaderView(this.bbK.getView());
    }

    private void Nm() {
        if ("normal_page".equals(this.bbO) && this.bbH != null) {
            this.bbG.removeHeaderView(this.bbH.getView());
            this.bbG.removeHeaderView(this.bbH.NP());
        } else if ("frs_page".equals(this.bbO) && this.bbI != null) {
            this.bbG.removeHeaderView(this.bbI.getView());
            this.bbG.removeHeaderView(this.bbI.NP());
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
            if (Nj() != null) {
                Nj().NS();
            }
            if (Nk() != null) {
                Nk().NS();
                return;
            }
            return;
        }
        if (Nj() != null) {
            Nj().NR();
        }
        if (Nk() != null) {
            Nk().NR();
        }
    }

    private void Nn() {
        if (this.bbP == null) {
            this.bbP = new d(this);
        }
        this.baR.mHandler.postDelayed(this.bbP, 4000L);
    }

    public void c(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            if ("frs_page".equals(this.mPageType)) {
                a(oVar.aeJ(), oVar);
            } else if ("normal_page".equals(this.mPageType)) {
                b(oVar.aeJ(), oVar);
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
        Nl();
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
            Nq();
        } else if ("normal_page".equals(this.mPageType)) {
            Np();
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

    public void No() {
        if ("normal_page".equals(this.bbO)) {
            if (this.bbH != null) {
                this.bbH.No();
            }
        } else if ("frs_page".equals(this.bbO) && this.bbI != null) {
            this.bbI.No();
        }
    }

    public void Np() {
        if (this.bbH != null) {
            this.bbH.NV();
        }
    }

    public void Nq() {
        if (this.bbI != null) {
            this.bbI.NV();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (oVar != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(1, oVar.aeJ(), oVar, z);
            } else if ("frs_page".equals(this.mPageType)) {
                b(1, oVar.aeJ(), oVar, z);
            }
        }
    }

    public void Nr() {
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

    public boolean Ns() {
        if ("normal_page".equals(this.bbO) && this.bbH != null) {
            return this.bbH.NN();
        }
        if ("frs_page".equals(this.bbO) && this.bbI != null) {
            return this.bbI.NN();
        }
        return false;
    }

    public void Nt() {
        if ("normal_page".equals(this.mPageType)) {
            Nv();
        } else if ("frs_page".equals(this.mPageType)) {
            Nx();
        }
    }

    public void Nu() {
        if ("normal_page".equals(this.mPageType)) {
            Nw();
        } else if ("frs_page".equals(this.mPageType)) {
            Ny();
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
        if (oVar != null && oVar.aeJ() != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(oVar.aeJ().getSignData(), oVar.aeJ(), oVar);
            } else if ("frs_page".equals(this.mPageType)) {
                b(oVar.aeJ().getSignData(), oVar.aeJ(), oVar);
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
            if (signData.getBonusPoint() > 0 && this.bbH.NN()) {
                a(this.bbH, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.bbN);
                    forumData.setLevelupScore(this.bbM);
                }
                this.bbH.c(forumData, oVar);
                this.bbH.e(this.bbH.NT(), true);
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
            if (signData.getBonusPoint() > 0 && this.bbI.NN()) {
                a(this.bbI, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.bbN);
                    forumData.setLevelupScore(this.bbM);
                }
                this.bbI.c(forumData, oVar);
                this.bbI.e(this.bbI.NT(), true);
            }
        }
    }

    public void Nv() {
        if (this.bbH != null) {
            this.bbH.NU().setVisibility(0);
        }
    }

    public void Nw() {
        if (this.bbH != null) {
            this.bbH.NU().setVisibility(8);
        }
    }

    public void Nx() {
        if (this.bbI != null) {
            this.bbI.NU().setVisibility(0);
        }
    }

    public void Ny() {
        if (this.bbI != null) {
            this.bbI.NU().setVisibility(8);
        }
    }

    public boolean Nz() {
        if ("normal_page".equals(this.bbO) && this.bbH != null) {
            return this.bbH.Nz();
        }
        if ("frs_page".equals(this.bbO) && this.bbI != null) {
            return this.bbI.Nz();
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

    public boolean NA() {
        if ("normal_page".equals(this.bbO)) {
            if (this.bbH != null) {
                return this.bbH.NA();
            }
        } else if ("frs_page".equals(this.bbO) && this.bbI != null) {
            return this.bbI.NA();
        }
        return false;
    }

    public BarImageView NB() {
        com.baidu.tieba.frs.view.q Nk;
        if ("normal_page".equals(this.mPageType)) {
            FrsHeaderView Nj = Nj();
            if (Nj != null) {
                return Nj.NB();
            }
        } else if ("frs_page".equals(this.mPageType) && (Nk = Nk()) != null) {
            return Nk.NB();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void oN() {
        if (this.baR != null) {
            com.baidu.tieba.tbadkCore.o Ld = this.baR.Ld();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m411getInst().login(this.baR.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, 11002)));
            } else if (Ld != null && Ld.aeJ() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.baR.getFrom())) {
                    this.LT.setFrom(FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                    TiebaStatic.log(new aq("c10356").ae(ImageViewerConfig.FORUM_ID, Ld.aeJ().getId()));
                } else {
                    this.LT.setFrom("from_frs");
                }
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.baR.getFrom())) {
                    TiebaStatic.eventStat(this.baR.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                }
                this.LT.be(Ld.aeJ().getName(), Ld.aeJ().getId());
            }
        }
    }

    public void Lh() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.baR.Ld() != null && this.baR.Ld().aeJ() != null && this.baR.Ld().aeJ().getName() != null) {
            str = this.baR.Ld().aeJ().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cu(String.format(getPageContext().getString(i.h.attention_cancel_dialog_content), str));
        } else {
            aVar.cu(getPageContext().getString(i.h.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(i.h.editor_dialog_yes), new e(this));
        aVar.b(getPageContext().getString(i.h.editor_dialog_no), new f(this));
        aVar.b(getPageContext()).sO();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void NC() {
        com.baidu.tieba.tbadkCore.o Ld = this.baR.Ld();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.baR.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, 11014)));
        } else if (Ld != null && Ld.aeJ() != null) {
            Nt();
            this.bbS.au(Ld.aeJ().getName(), Ld.aeJ().getId());
        }
    }

    private void oM() {
        this.LT = new w(this.baR.getPageContext());
        this.LT.setLoadDataCallBack(new g(this));
    }

    private void ND() {
        this.bbR = new ai();
        this.bbR.setFrom("from_frs");
        this.bbR.a(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        new i(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void NE() {
        this.bbS = new eh(this.baR);
        this.bbS.setLoadDataCallBack(new j(this));
    }

    private void MQ() {
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
        if (oVar != null && oVar.avC() != null && oVar.avC().size() != 0) {
            if (oVar.avw() != null) {
                z = oVar.avw().avo() != 1;
            } else {
                z = false;
            }
            ck(z);
            this.bai = new TabData();
            for (FrsTabInfo frsTabInfo : oVar.avC()) {
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
                            sb.append(oVar.aeJ().getId());
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
                        if (frsTabInfo.tab_id.intValue() == 1 && Cdo.Ms().fI(frsTabInfo.tab_id.intValue())) {
                            List<n> fF = dm.Mr().fF(gVar.bbr);
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
            boolean z4 = !this.bbJ.Nh();
            boolean z5 = this.bbJ.getVisibility() == 0;
            this.bbJ.setData((List<com.baidu.tieba.frs.tab.g>) this.bai, true);
            if (z4 && !z5) {
                this.bbJ.setVisibility(8);
            }
            if (!this.bbU) {
                MQ();
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
        dm.Mr().c(4, arrayList);
    }

    public void a(ea eaVar) {
        if (this.bag != null) {
            this.bag.setDataLoadInterface(this.bbW);
        }
        this.bbX = eaVar;
    }

    public boolean NF() {
        return this.bbJ.getVisibility() == 0;
    }

    private int NG() {
        if (this.mPageType == "normal_page") {
            if (this.bbH.NP() != null && this.bbH.NP().getParent() != null) {
                return this.bbG.getHeaderViewsCount() - 2;
            }
            return this.bbG.getHeaderViewsCount() - 1;
        } else if (this.mPageType == "frs_page") {
            if (this.bbI.NP() != null && this.bbI.NP().getParent() != null) {
                return this.bbG.getHeaderViewsCount() - 2;
            }
            return this.bbG.getHeaderViewsCount() - 1;
        } else {
            return 0;
        }
    }

    public boolean NH() {
        return this.bbV;
    }
}
