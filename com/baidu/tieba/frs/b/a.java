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
import com.baidu.tbadk.core.util.ap;
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
    private w LS;
    private int aLo;
    private final View.OnClickListener aWF;
    private HorizontalTabView aZV;
    private TabData aZX;
    private FrsActivity baG;
    private bp bbA;
    private int bbB;
    private int bbC;
    private String bbD;
    private Runnable bbE;
    private boolean bbF;
    private ai bbG;
    private eh bbH;
    private o bbI;
    private boolean bbJ;
    private boolean bbK;
    private ea bbL;
    private ea bbM;
    private BdListView bbv;
    private FrsHeaderView bbw;
    private com.baidu.tieba.frs.view.q bbx;
    private HorizontalTabView bby;
    private com.baidu.tieba.frs.view.j bbz;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int NK = NK();
        if (this.bby.Nl() && i >= NK) {
            this.bby.setVisibility(0);
            this.aZV.setVisibility(4);
            return;
        }
        this.bby.setVisibility(8);
        this.aZV.setVisibility(0);
    }

    public a(FrsActivity frsActivity, o oVar) {
        super(frsActivity.getPageContext());
        this.bbv = null;
        this.bbw = null;
        this.bbx = null;
        this.aZV = null;
        this.bby = null;
        this.bbz = null;
        this.bbA = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.bbD = null;
        this.bbF = false;
        this.LS = null;
        this.bbG = null;
        this.bbH = null;
        this.bbJ = false;
        this.bbK = false;
        this.bbL = new b(this);
        this.aWF = new c(this);
        this.baG = frsActivity;
        this.bbI = oVar;
    }

    public void h(Bundle bundle) {
        oM();
        NH();
        NI();
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90);
        this.aZV = new HorizontalTabView(this.baG.getActivity(), dimensionPixelSize);
        this.aZV.setAutoFillTabCount(4);
        this.bby = new HorizontalTabView(this.baG.getActivity(), dimensionPixelSize);
        this.bby.setAutoFillTabCount(4);
        this.bby.clearAnimation();
        this.bby.setVisibility(8);
        this.aZV.setFakeTab(this.bby);
        this.bby.setFakeTab(this.aZV);
        this.bbI.D(this.bby);
        this.bbF = TbadkSettings.getInst().loadBoolean(FrsActivity.aTs, false);
    }

    public void onActivityDestroy() {
        if (this.bbw != null) {
            this.bbw.onDestory();
        }
        if (this.bbx != null) {
            this.bbx.onDestory();
        }
        if (this.LS != null) {
            this.LS.ME();
        }
        if (this.bbH != null) {
            this.bbH.ME();
        }
        if (this.bbE != null) {
            this.baG.mHandler.removeCallbacks(this.bbE);
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.bbx != null) {
            this.bbx.changeSkinType(i);
        }
        if (this.bbA != null) {
            this.bbA.notifyDataSetChanged();
        }
        if (this.bbz != null) {
            this.bbz.changeSkinType(i);
        }
        if (this.bbw != null) {
            this.bbw.changeSkinType(i);
        }
        if (this.aZV != null) {
            this.aZV.vA();
        }
        if (this.bby != null) {
            this.bby.vA();
            return true;
        }
        return true;
    }

    public FrsHeaderView Nn() {
        return this.bbw;
    }

    public com.baidu.tieba.frs.view.q No() {
        return this.bbx;
    }

    public void t(BdListView bdListView) {
        this.bbv = bdListView;
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
        if (oVar.avA() != null && oVar.avA().size() != 0) {
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
            b(oVar.aeN().getGood_classify(), this.baG.aUq);
        }
        b(oVar);
    }

    public void c(int i, int i2, boolean z) {
        this.aLo = i2;
        Nq();
        this.bbD = "normal_page";
        if (this.bbw == null) {
            this.bbw = new FrsHeaderView(this.baG, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.bbw.changeSkinType(this.mSkinType);
            this.bbw.setCommonClickListener(this.aWF);
        }
        this.bbv.addHeaderView(this.bbw.getView());
        if (z) {
            MU();
        }
        if (!this.bbK) {
            this.bbv.addHeaderView(this.bbw.NT());
            this.bbK = true;
        }
        Nr();
    }

    public void d(int i, int i2, boolean z) {
        this.aLo = i2;
        Nq();
        this.bbD = "frs_page";
        fT(i);
        this.bbv.addHeaderView(this.bbx.getView());
        if (z) {
            MU();
        }
        if (!this.bbK) {
            this.bbv.addHeaderView(this.bbx.NT());
            this.bbK = true;
        }
        Nr();
    }

    public void fT(int i) {
        if (this.bbx == null) {
            this.bbx = new com.baidu.tieba.frs.view.q(this.baG.getPageContext(), null, null, i);
            this.bbx.changeSkinType(this.mSkinType);
            this.bbx.setCommonClickListener(this.aWF);
        }
    }

    public void Np() {
        Nq();
        this.bbD = "good_page";
        if (this.bbz == null) {
            this.bbz = new com.baidu.tieba.frs.view.j(getPageContext().getPageActivity());
            this.bbz.changeSkinType(this.mSkinType);
        }
        this.bbv.addHeaderView(this.bbz.getView());
    }

    private void Nq() {
        if ("normal_page".equals(this.bbD) && this.bbw != null) {
            this.bbv.removeHeaderView(this.bbw.getView());
            this.bbv.removeHeaderView(this.bbw.NT());
        } else if ("frs_page".equals(this.bbD) && this.bbx != null) {
            this.bbv.removeHeaderView(this.bbx.getView());
            this.bbv.removeHeaderView(this.bbx.NT());
        } else if ("good_page".equals(this.bbD) && this.bbz != null) {
            this.bbv.removeHeaderView(this.bbz.getView());
        }
        this.bbK = false;
        if (this.aZV != null) {
            this.bbv.removeHeaderView(this.aZV);
            this.bbJ = false;
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
        if (this.bbE == null) {
            this.bbE = new d(this);
        }
        this.baG.mHandler.postDelayed(this.bbE, 4000L);
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
            if (this.bbx != null) {
                this.bbx.c(forumData, oVar);
                this.bbx.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.bbx.gc(forumData.getSignData().getSigned());
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.bbx.cm(false);
                    }
                }
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (forumData != null && oVar != null) {
            float a = a(forumData);
            if (this.bbw != null) {
                this.bbw.c(forumData, oVar);
                this.bbw.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.bbw.cm(false);
                        return;
                    }
                    this.bbw.cm(true);
                    this.bbw.gc(forumData.getSignData().getSigned());
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.bbB = forumData.getLevelupScore();
        this.bbC = forumData.getCurScore();
        if (this.bbB > 0) {
            return this.bbC / this.bbB;
        }
        return 0.0f;
    }

    public void b(ArrayList<com.baidu.tbadk.core.data.j> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        Np();
        if (arrayList != null) {
            if (this.bbA == null) {
                this.bbA = new bp(getPageContext().getPageActivity(), arrayList);
                this.bbz.a(this.bbA);
                this.bbz.b(onItemClickListener);
                return;
            }
            this.bbA.setData(arrayList);
            this.bbA.notifyDataSetChanged();
        }
    }

    public void fw(int i) {
        if (this.bbA != null) {
            this.bbA.fw(i);
        }
    }

    public void fU(int i) {
        if (i > 1) {
            if (this.bbw != null) {
                this.bbw.setIsFirstPage(false);
            }
            if (this.bbx != null) {
                this.bbx.setIsFirstPage(false);
                return;
            }
            return;
        }
        if (this.bbw != null) {
            this.bbw.setIsFirstPage(true);
        }
        if (this.bbx != null) {
            this.bbx.setIsFirstPage(true);
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
        if (this.bbw != null) {
            this.bbw.setMemberType(i);
        }
        if (this.bbx != null) {
            this.bbx.setMemberType(i);
        }
    }

    public void Ns() {
        if ("normal_page".equals(this.bbD)) {
            if (this.bbw != null) {
                this.bbw.Ns();
            }
        } else if ("frs_page".equals(this.bbD) && this.bbx != null) {
            this.bbx.Ns();
        }
    }

    public void Nt() {
        if (this.bbw != null) {
            this.bbw.NZ();
        }
    }

    public void Nu() {
        if (this.bbx != null) {
            this.bbx.NZ();
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
        if (this.bbw != null) {
            this.bbw.gb(i);
        }
    }

    public void fX(int i) {
        if (this.bbx != null) {
            this.bbx.gb(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (this.bbw != null) {
            this.bbw.c(forumData, oVar);
            if (forumData != null) {
                this.bbw.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.bbw.cm(false);
                }
            }
        }
    }

    public void b(int i, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (this.bbx != null) {
            this.bbx.c(forumData, oVar);
            float a = a(forumData);
            if (forumData != null) {
                this.bbx.a(i, forumData.getLevelName(), forumData.getUser_level(), a, z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.bbx.cm(false);
                }
            }
        }
    }

    public boolean Nw() {
        if ("normal_page".equals(this.bbD) && this.bbw != null) {
            return this.bbw.NR();
        }
        if ("frs_page".equals(this.bbD) && this.bbx != null) {
            return this.bbx.NR();
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
            if (bonusPoint >= this.bbB - this.bbC) {
                z = true;
                this.bbB = signData.getLevelUpScore();
            }
            this.bbC = bonusPoint + this.bbC;
            if (this.bbC > this.bbB) {
                this.bbC = this.bbB;
            }
            if (this.bbB != 0) {
                f = this.bbC / this.bbB;
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
        if (this.bbw != null) {
            this.bbw.gc(i);
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (this.bbw != null && signData != null && forumData != null && oVar != null) {
            this.bbw.c(forumData, oVar);
            this.bbw.gc(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.bbw.NR()) {
                a(this.bbw, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.bbC);
                    forumData.setLevelupScore(this.bbB);
                }
                this.bbw.c(forumData, oVar);
                this.bbw.e(this.bbw.NX(), true);
            }
        }
    }

    public void ga(int i) {
        if (this.bbx != null) {
            this.bbx.gc(i);
        }
    }

    public void b(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (this.bbx != null && signData != null && forumData != null && oVar != null) {
            this.bbx.c(forumData, oVar);
            this.bbx.gc(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.bbx.NR()) {
                a(this.bbx, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.bbC);
                    forumData.setLevelupScore(this.bbB);
                }
                this.bbx.c(forumData, oVar);
                this.bbx.e(this.bbx.NX(), true);
            }
        }
    }

    public void Nz() {
        if (this.bbw != null) {
            this.bbw.NY().setVisibility(0);
        }
    }

    public void NA() {
        if (this.bbw != null) {
            this.bbw.NY().setVisibility(8);
        }
    }

    public void NB() {
        if (this.bbx != null) {
            this.bbx.NY().setVisibility(0);
        }
    }

    public void NC() {
        if (this.bbx != null) {
            this.bbx.NY().setVisibility(8);
        }
    }

    public boolean ND() {
        if ("normal_page".equals(this.bbD) && this.bbw != null) {
            return this.bbw.ND();
        }
        if ("frs_page".equals(this.bbD) && this.bbx != null) {
            return this.bbx.ND();
        }
        return false;
    }

    public void B(View view) {
        if (this.bbw != null) {
            this.bbw.e(view, false);
        }
    }

    public void C(View view) {
        if (this.bbx != null) {
            this.bbx.e(view, false);
        }
    }

    public boolean NE() {
        if ("normal_page".equals(this.bbD)) {
            if (this.bbw != null) {
                return this.bbw.NE();
            }
        } else if ("frs_page".equals(this.bbD) && this.bbx != null) {
            return this.bbx.NE();
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
        if (this.baG != null) {
            com.baidu.tieba.tbadkCore.o Lh = this.baG.Lh();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m411getInst().login(this.baG.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, 11002)));
            } else if (Lh != null && Lh.aeN() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.baG.getFrom())) {
                    this.LS.setFrom(FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                    TiebaStatic.log(new ap("c10356").ae(ImageViewerConfig.FORUM_ID, Lh.aeN().getId()));
                } else {
                    this.LS.setFrom("from_frs");
                }
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.baG.getFrom())) {
                    TiebaStatic.eventStat(this.baG.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                }
                this.LS.be(Lh.aeN().getName(), Lh.aeN().getId());
            }
        }
    }

    public void Ll() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.baG.Lh() != null && this.baG.Lh().aeN() != null && this.baG.Lh().aeN().getName() != null) {
            str = this.baG.Lh().aeN().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.ct(String.format(getPageContext().getString(i.h.attention_cancel_dialog_content), str));
        } else {
            aVar.ct(getPageContext().getString(i.h.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(i.h.editor_dialog_yes), new e(this));
        aVar.b(getPageContext().getString(i.h.editor_dialog_no), new f(this));
        aVar.b(getPageContext()).sR();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void NG() {
        com.baidu.tieba.tbadkCore.o Lh = this.baG.Lh();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.baG.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, 11014)));
        } else if (Lh != null && Lh.aeN() != null) {
            Nx();
            this.bbH.au(Lh.aeN().getName(), Lh.aeN().getId());
        }
    }

    private void oM() {
        this.LS = new w(this.baG.getPageContext());
        this.LS.setLoadDataCallBack(new g(this));
    }

    private void NH() {
        this.bbG = new ai();
        this.bbG.setFrom("from_frs");
        this.bbG.a(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        new i(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void NI() {
        this.bbH = new eh(this.baG);
        this.bbH.setLoadDataCallBack(new j(this));
    }

    private void MU() {
        if (this.aZV != null && !this.bbJ) {
            this.bbv.addHeaderView(this.aZV, Integer.valueOf(this.bbv.getHeaderViewsCount()), false);
            this.bbJ = true;
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
        if (oVar != null && oVar.avA() != null && oVar.avA().size() != 0) {
            if (oVar.avu() != null) {
                z = oVar.avu().avm() != 1;
            } else {
                z = false;
            }
            ck(z);
            this.aZX = new TabData();
            for (FrsTabInfo frsTabInfo : oVar.avA()) {
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
                            gVar.bbg = frsTabInfo.tab_id.intValue();
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
                                ap apVar = new ap("c10078");
                                apVar.ae("obj_type", host);
                                TiebaStatic.log(apVar);
                            }
                        }
                        gVar.bbg = frsTabInfo.tab_id.intValue();
                        gVar.name = frsTabInfo.tab_name;
                        if (frsTabInfo.tab_id.intValue() == 1 && Cdo.Mw().fI(frsTabInfo.tab_id.intValue())) {
                            List<n> fF = dm.Mv().fF(gVar.bbg);
                            if (fF != null && fF.size() > 0) {
                                gVar.bbh = new LinkedList();
                                boolean z3 = true;
                                for (n nVar : fF) {
                                    if (nVar != null) {
                                        com.baidu.tieba.frs.tab.h hVar = new com.baidu.tieba.frs.tab.h();
                                        hVar.name = nVar.name;
                                        hVar.bbm = nVar.bbm;
                                        if (z3) {
                                            hVar.isSelected = true;
                                            z2 = false;
                                        } else {
                                            z2 = z3;
                                        }
                                        gVar.bbh.add(hVar);
                                        z3 = z2;
                                    }
                                }
                            }
                            this.aZX.add(gVar);
                        } else if (frsTabInfo.tab_id.intValue() != 1) {
                            this.aZX.add(gVar);
                        }
                    }
                }
            }
            this.aZV.setData((List<com.baidu.tieba.frs.tab.g>) this.aZX, true);
            boolean z4 = !this.bby.Nl();
            boolean z5 = this.bby.getVisibility() == 0;
            this.bby.setData((List<com.baidu.tieba.frs.tab.g>) this.aZX, true);
            if (z4 && !z5) {
                this.bby.setVisibility(8);
            }
            if (!this.bbJ) {
                MU();
            }
        }
    }

    private void ck(boolean z) {
        ArrayList arrayList = new ArrayList();
        n nVar = new n();
        nVar.bbm = 2;
        nVar.name = this.baG.getResources().getString(i.h.frsgroup_hot);
        arrayList.add(nVar);
        n nVar2 = new n();
        nVar2.bbm = 3;
        nVar2.name = this.baG.getResources().getString(i.h.frsgroup_official);
        arrayList.add(nVar2);
        if (z) {
            n nVar3 = new n();
            nVar3.bbm = 1;
            nVar3.name = this.baG.getResources().getString(i.h.frsgroup_recommend);
            arrayList.add(0, nVar3);
        }
        dm.Mv().c(4, arrayList);
    }

    public void a(ea eaVar) {
        if (this.aZV != null) {
            this.aZV.setDataLoadInterface(this.bbL);
        }
        this.bbM = eaVar;
    }

    public boolean NJ() {
        return this.bby.getVisibility() == 0;
    }

    private int NK() {
        if (this.mPageType == "normal_page") {
            if (this.bbw.NT() != null && this.bbw.NT().getParent() != null) {
                return this.bbv.getHeaderViewsCount() - 2;
            }
            return this.bbv.getHeaderViewsCount() - 1;
        } else if (this.mPageType == "frs_page") {
            if (this.bbx.NT() != null && this.bbx.NT().getParent() != null) {
                return this.bbv.getHeaderViewsCount() - 2;
            }
            return this.bbv.getHeaderViewsCount() - 1;
        } else {
            return 0;
        }
    }

    public boolean NL() {
        return this.bbK;
    }
}
