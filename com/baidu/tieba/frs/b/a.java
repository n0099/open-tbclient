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
import com.baidu.tieba.frs.dn;
import com.baidu.tieba.frs.dq;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ej;
import com.baidu.tieba.frs.ek;
import com.baidu.tieba.frs.el;
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
import tbclient.CategoryInfo;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f<FrsActivity> {
    private w LU;
    private int aLH;
    private final View.OnClickListener aWY;
    private HorizontalTabView baA;
    private TabData baC;
    private FrsActivity bbk;
    private ec bcA;
    private ec bcB;
    private HorizontalTabView.a bcC;
    private BdListView bck;
    private FrsHeaderView bcl;
    private com.baidu.tieba.frs.view.q bcm;
    private HorizontalTabView bcn;
    private com.baidu.tieba.frs.view.j bco;
    private bp bcp;
    private int bcq;
    private int bcr;
    private String bcs;
    private Runnable bct;
    private boolean bcu;
    private ai bcv;
    private ej bcw;
    private o bcx;
    private boolean bcy;
    private boolean bcz;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int Oc = Oc();
        if (this.bcn.NB() && i >= Oc) {
            this.bcn.setVisibility(0);
            this.baA.setVisibility(4);
            return;
        }
        this.bcn.setVisibility(8);
        this.baA.setVisibility(0);
    }

    public a(FrsActivity frsActivity, o oVar) {
        super(frsActivity.getPageContext());
        this.bck = null;
        this.bcl = null;
        this.bcm = null;
        this.baA = null;
        this.bcn = null;
        this.bco = null;
        this.bcp = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.bcs = null;
        this.bcu = false;
        this.LU = null;
        this.bcv = null;
        this.bcw = null;
        this.bcy = false;
        this.bcz = false;
        this.bcA = new b(this);
        this.bcC = new d(this);
        this.aWY = new e(this);
        this.bbk = frsActivity;
        this.bcx = oVar;
    }

    public void h(Bundle bundle) {
        oN();
        NZ();
        Oa();
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90);
        this.baA = new HorizontalTabView(this.bbk.getActivity(), dimensionPixelSize);
        this.baA.setAutoFillTabCount(4);
        this.baA.setmShowMenuCallBack(this.bcC);
        this.bcn = new HorizontalTabView(this.bbk.getActivity(), dimensionPixelSize);
        this.bcn.setAutoFillTabCount(4);
        this.bcn.clearAnimation();
        this.bcn.setVisibility(8);
        this.baA.setFakeTab(this.bcn);
        this.bcn.setFakeTab(this.baA);
        this.bcx.E(this.bcn);
        this.bcu = TbadkSettings.getInst().loadBoolean(FrsActivity.aTL, false);
    }

    public void onActivityDestroy() {
        if (this.bcl != null) {
            this.bcl.onDestory();
        }
        if (this.bcm != null) {
            this.bcm.onDestory();
        }
        if (this.LU != null) {
            this.LU.MQ();
        }
        if (this.bcw != null) {
            this.bcw.MQ();
        }
        if (this.bct != null) {
            this.bbk.mHandler.removeCallbacks(this.bct);
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.bcm != null) {
            this.bcm.changeSkinType(i);
        }
        if (this.bcp != null) {
            this.bcp.notifyDataSetChanged();
        }
        if (this.bco != null) {
            this.bco.changeSkinType(i);
        }
        if (this.bcl != null) {
            this.bcl.changeSkinType(i);
        }
        if (this.baA != null) {
            this.baA.vB();
        }
        if (this.bcn != null) {
            this.bcn.vB();
            return true;
        }
        return true;
    }

    public FrsHeaderView NF() {
        return this.bcl;
    }

    public com.baidu.tieba.frs.view.q NG() {
        return this.bcm;
    }

    public void t(BdListView bdListView) {
        this.bck = bdListView;
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
        if (oVar.awj() != null && oVar.awj().size() != 0) {
            z = true;
        }
        if ("frs_page".equals(str)) {
            if (oVar != null && oVar.getUserData() != null && oVar.afg() != null) {
                d(oVar.getUserData().getIsMem(), oVar.afg().isLike(), z);
            }
        } else if ("normal_page".equals(str)) {
            if (oVar != null && oVar.getUserData() != null && oVar.afg() != null) {
                c(oVar.getUserData().getIsMem(), oVar.afg().isLike(), z);
            }
        } else if ("good_page".equals(str) && oVar != null && oVar.afg() != null) {
            b(oVar.afg().getGood_classify(), this.bbk.aUJ);
        }
        b(oVar);
    }

    public void c(int i, int i2, boolean z) {
        this.aLH = i2;
        NI();
        this.bcs = "normal_page";
        if (this.bcl == null) {
            this.bcl = new FrsHeaderView(this.bbk, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.bcl.changeSkinType(this.mSkinType);
            this.bcl.setCommonClickListener(this.aWY);
        }
        this.bck.addHeaderView(this.bcl.getView());
        if (z) {
            Ni();
        }
        if (!this.bcz) {
            this.bck.addHeaderView(this.bcl.Ol());
            this.bcz = true;
        }
        NJ();
    }

    public void d(int i, int i2, boolean z) {
        this.aLH = i2;
        NI();
        this.bcs = "frs_page";
        gf(i);
        this.bck.addHeaderView(this.bcm.getView());
        if (z) {
            Ni();
        }
        if (!this.bcz) {
            this.bck.addHeaderView(this.bcm.Ol());
            this.bcz = true;
        }
        NJ();
    }

    public void gf(int i) {
        if (this.bcm == null) {
            this.bcm = new com.baidu.tieba.frs.view.q(this.bbk.getPageContext(), null, null, i);
            this.bcm.changeSkinType(this.mSkinType);
            this.bcm.setCommonClickListener(this.aWY);
        }
    }

    public void NH() {
        NI();
        this.bcs = "good_page";
        if (this.bco == null) {
            this.bco = new com.baidu.tieba.frs.view.j(getPageContext().getPageActivity());
            this.bco.changeSkinType(this.mSkinType);
        }
        this.bck.addHeaderView(this.bco.getView());
    }

    private void NI() {
        if ("normal_page".equals(this.bcs) && this.bcl != null) {
            this.bck.removeHeaderView(this.bcl.getView());
            this.bck.removeHeaderView(this.bcl.Ol());
        } else if ("frs_page".equals(this.bcs) && this.bcm != null) {
            this.bck.removeHeaderView(this.bcm.getView());
            this.bck.removeHeaderView(this.bcm.Ol());
        } else if ("good_page".equals(this.bcs) && this.bco != null) {
            this.bck.removeHeaderView(this.bco.getView());
        }
        this.bcz = false;
        if (this.baA != null) {
            this.bck.removeHeaderView(this.baA);
            this.bcy = false;
        }
    }

    public void cl(boolean z) {
        if (z) {
            if (NF() != null) {
                NF().Oo();
            }
            if (NG() != null) {
                NG().Oo();
                return;
            }
            return;
        }
        if (NF() != null) {
            NF().On();
        }
        if (NG() != null) {
            NG().On();
        }
    }

    private void NJ() {
        if (this.bct == null) {
            this.bct = new f(this);
        }
        this.bbk.mHandler.postDelayed(this.bct, 4000L);
    }

    public void c(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            if ("frs_page".equals(this.mPageType)) {
                a(oVar.afg(), oVar);
            } else if ("normal_page".equals(this.mPageType)) {
                b(oVar.afg(), oVar);
            }
            b(oVar);
        }
    }

    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (forumData != null && oVar != null) {
            float a = a(forumData);
            if (this.bcm != null) {
                this.bcm.c(forumData, oVar);
                this.bcm.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.bcm.gp(forumData.getSignData().getSigned());
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.bcm.co(false);
                    }
                }
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (forumData != null && oVar != null) {
            float a = a(forumData);
            if (this.bcl != null) {
                this.bcl.c(forumData, oVar);
                this.bcl.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.bcl.co(false);
                        return;
                    }
                    this.bcl.co(true);
                    this.bcl.gp(forumData.getSignData().getSigned());
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.bcq = forumData.getLevelupScore();
        this.bcr = forumData.getCurScore();
        if (this.bcq > 0) {
            return this.bcr / this.bcq;
        }
        return 0.0f;
    }

    public void b(ArrayList<com.baidu.tbadk.core.data.k> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        NH();
        if (arrayList != null) {
            if (this.bcp == null) {
                this.bcp = new bp(getPageContext().getPageActivity(), arrayList);
                this.bco.a(this.bcp);
                this.bco.b(onItemClickListener);
                return;
            }
            this.bcp.setData(arrayList);
            this.bcp.notifyDataSetChanged();
        }
    }

    public void fE(int i) {
        if (this.bcp != null) {
            this.bcp.fE(i);
        }
    }

    public void gg(int i) {
        if (i > 1) {
            if (this.bcl != null) {
                this.bcl.setIsFirstPage(false);
            }
            if (this.bcm != null) {
                this.bcm.setIsFirstPage(false);
                return;
            }
            return;
        }
        if (this.bcl != null) {
            this.bcl.setIsFirstPage(true);
        }
        if (this.bcm != null) {
            this.bcm.setIsFirstPage(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void b(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType)) {
            NM();
        } else if ("normal_page".equals(this.mPageType)) {
            NL();
        }
    }

    public void setIsMem(int i) {
        if (this.bcl != null) {
            this.bcl.setMemberType(i);
        }
        if (this.bcm != null) {
            this.bcm.setMemberType(i);
        }
    }

    public void NK() {
        if ("normal_page".equals(this.bcs)) {
            if (this.bcl != null) {
                this.bcl.NK();
            }
        } else if ("frs_page".equals(this.bcs) && this.bcm != null) {
            this.bcm.NK();
        }
    }

    public void NL() {
        if (this.bcl != null) {
            this.bcl.Or();
        }
    }

    public void NM() {
        if (this.bcm != null) {
            this.bcm.Or();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (oVar != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(1, oVar.afg(), oVar, z);
            } else if ("frs_page".equals(this.mPageType)) {
                b(1, oVar.afg(), oVar, z);
            }
        }
    }

    public void NN() {
        if ("normal_page".equals(this.mPageType)) {
            gi(0);
        } else if ("frs_page".equals(this.mPageType)) {
            gj(0);
        }
    }

    public void gh(int i) {
        if ("normal_page".equals(this.mPageType)) {
            gi(i);
        } else if ("frs_page".equals(this.mPageType)) {
            gj(i);
        }
    }

    public void gi(int i) {
        if (this.bcl != null) {
            this.bcl.go(i);
        }
    }

    public void gj(int i) {
        if (this.bcm != null) {
            this.bcm.go(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (this.bcl != null) {
            this.bcl.c(forumData, oVar);
            if (forumData != null) {
                this.bcl.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.bcl.co(false);
                }
            }
        }
    }

    public void b(int i, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (this.bcm != null) {
            this.bcm.c(forumData, oVar);
            float a = a(forumData);
            if (forumData != null) {
                this.bcm.a(i, forumData.getLevelName(), forumData.getUser_level(), a, z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.bcm.co(false);
                }
            }
        }
    }

    public boolean NO() {
        if ("normal_page".equals(this.bcs) && this.bcl != null) {
            return this.bcl.Oj();
        }
        if ("frs_page".equals(this.bcs) && this.bcm != null) {
            return this.bcm.Oj();
        }
        return false;
    }

    public void NP() {
        if ("normal_page".equals(this.mPageType)) {
            NR();
        } else if ("frs_page".equals(this.mPageType)) {
            NT();
        }
    }

    public void NQ() {
        if ("normal_page".equals(this.mPageType)) {
            NS();
        } else if ("frs_page".equals(this.mPageType)) {
            NU();
        }
    }

    private void a(com.baidu.tieba.frs.view.a aVar, SignData signData) {
        if (aVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.bcq - this.bcr) {
                z = true;
                this.bcq = signData.getLevelUpScore();
            }
            this.bcr = bonusPoint + this.bcr;
            if (this.bcr > this.bcq) {
                this.bcr = this.bcq;
            }
            if (this.bcq != 0) {
                f = this.bcr / this.bcq;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            aVar.a(z, f);
        }
    }

    public void gk(int i) {
        if ("normal_page".equals(this.mPageType)) {
            gl(i);
        } else if ("frs_page".equals(this.mPageType)) {
            gm(i);
        }
    }

    public void d(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null && oVar.afg() != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(oVar.afg().getSignData(), oVar.afg(), oVar);
            } else if ("frs_page".equals(this.mPageType)) {
                b(oVar.afg().getSignData(), oVar.afg(), oVar);
            }
        }
    }

    public void gl(int i) {
        if (this.bcl != null) {
            this.bcl.gp(i);
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (this.bcl != null && signData != null && forumData != null && oVar != null) {
            this.bcl.c(forumData, oVar);
            this.bcl.gp(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.bcl.Oj()) {
                a(this.bcl, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.bcr);
                    forumData.setLevelupScore(this.bcq);
                }
                this.bcl.c(forumData, oVar);
                this.bcl.e(this.bcl.Op(), true);
            }
        }
    }

    public void gm(int i) {
        if (this.bcm != null) {
            this.bcm.gp(i);
        }
    }

    public void b(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (this.bcm != null && signData != null && forumData != null && oVar != null) {
            this.bcm.c(forumData, oVar);
            this.bcm.gp(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.bcm.Oj()) {
                a(this.bcm, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.bcr);
                    forumData.setLevelupScore(this.bcq);
                }
                this.bcm.c(forumData, oVar);
                this.bcm.e(this.bcm.Op(), true);
            }
        }
    }

    public void NR() {
        if (this.bcl != null) {
            this.bcl.Oq().setVisibility(0);
        }
    }

    public void NS() {
        if (this.bcl != null) {
            this.bcl.Oq().setVisibility(8);
        }
    }

    public void NT() {
        if (this.bcm != null) {
            this.bcm.Oq().setVisibility(0);
        }
    }

    public void NU() {
        if (this.bcm != null) {
            this.bcm.Oq().setVisibility(8);
        }
    }

    public boolean NV() {
        if ("normal_page".equals(this.bcs) && this.bcl != null) {
            return this.bcl.NV();
        }
        if ("frs_page".equals(this.bcs) && this.bcm != null) {
            return this.bcm.NV();
        }
        return false;
    }

    public void C(View view) {
        if (this.bcl != null) {
            this.bcl.e(view, false);
        }
    }

    public void D(View view) {
        if (this.bcm != null) {
            this.bcm.e(view, false);
        }
    }

    public boolean NW() {
        if ("normal_page".equals(this.bcs)) {
            if (this.bcl != null) {
                return this.bcl.NW();
            }
        } else if ("frs_page".equals(this.bcs) && this.bcm != null) {
            return this.bcm.NW();
        }
        return false;
    }

    public BarImageView NX() {
        com.baidu.tieba.frs.view.q NG;
        if ("normal_page".equals(this.mPageType)) {
            FrsHeaderView NF = NF();
            if (NF != null) {
                return NF.NX();
            }
        } else if ("frs_page".equals(this.mPageType) && (NG = NG()) != null) {
            return NG.NX();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void oO() {
        if (this.bbk != null) {
            com.baidu.tieba.tbadkCore.o Lt = this.bbk.Lt();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m411getInst().login(this.bbk.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, 11002)));
            } else if (Lt != null && Lt.afg() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bbk.getFrom())) {
                    this.LU.setFrom(FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                    TiebaStatic.log(new aq("c10356").ae(ImageViewerConfig.FORUM_ID, Lt.afg().getId()));
                } else {
                    this.LU.setFrom("from_frs");
                }
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bbk.getFrom())) {
                    TiebaStatic.eventStat(this.bbk.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                }
                this.LU.bd(Lt.afg().getName(), Lt.afg().getId());
            }
        }
    }

    public void Lx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bbk.Lt() != null && this.bbk.Lt().afg() != null && this.bbk.Lt().afg().getName() != null) {
            str = this.bbk.Lt().afg().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cu(String.format(getPageContext().getString(i.h.attention_cancel_dialog_content), str));
        } else {
            aVar.cu(getPageContext().getString(i.h.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(i.h.editor_dialog_yes), new g(this));
        aVar.b(getPageContext().getString(i.h.editor_dialog_no), new h(this));
        aVar.b(getPageContext()).sR();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void NY() {
        com.baidu.tieba.tbadkCore.o Lt = this.bbk.Lt();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.bbk.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.h.login_to_use), true, 11014)));
        } else if (Lt != null && Lt.afg() != null) {
            NP();
            this.bcw.at(Lt.afg().getName(), Lt.afg().getId());
        }
    }

    private void oN() {
        this.LU = new w(this.bbk.getPageContext());
        this.LU.setLoadDataCallBack(new i(this));
    }

    private void NZ() {
        this.bcv = new ai();
        this.bcv.setFrom("from_frs");
        this.bcv.a(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        new k(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void Oa() {
        this.bcw = new ej(this.bbk);
        this.bcw.setLoadDataCallBack(new c(this));
    }

    private void Ni() {
        if (this.baA != null && !this.bcy) {
            this.bck.addHeaderView(this.baA, Integer.valueOf(this.bck.getHeaderViewsCount()), false);
            this.bcy = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x01f5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x003d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.tieba.tbadkCore.o oVar) {
        boolean z;
        boolean z2;
        URI uri;
        if (oVar != null && oVar.awj() != null && oVar.awj().size() != 0) {
            if (oVar.awd() != null) {
                z = oVar.awd().avV() != 1;
            } else {
                z = false;
            }
            cm(z);
            e(oVar);
            this.baC = new TabData();
            for (FrsTabInfo frsTabInfo : oVar.awj()) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() > 0 && !TextUtils.isEmpty(frsTabInfo.tab_name) && !TextUtils.isEmpty(frsTabInfo.tab_name.trim()) && (frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0)) {
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
                            sb.append(ImageViewerConfig.FORUM_ID);
                            sb.append("=");
                            sb.append(oVar.afg().getId());
                            hVar.url = sb.toString();
                            if (!TextUtils.isEmpty(hVar.url)) {
                            }
                            hVar.bbN = frsTabInfo.tab_id.intValue();
                            hVar.name = frsTabInfo.tab_name;
                            if (frsTabInfo.tab_id.intValue() == 1) {
                            }
                            if (frsTabInfo.tab_id.intValue() == 1) {
                            }
                        }
                    } else if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                        if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() < 100) {
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
                                aq aqVar = new aq("c10078");
                                aqVar.ae("obj_type", host);
                                TiebaStatic.log(aqVar);
                            }
                        }
                        hVar.bbN = frsTabInfo.tab_id.intValue();
                        hVar.name = frsTabInfo.tab_name;
                        if (frsTabInfo.tab_id.intValue() == 1 && dq.MI().fQ(frsTabInfo.tab_id.intValue())) {
                            Cdo fN = dn.MH().fN(hVar.bbN);
                            if (fN != null && fN.aYK != null && fN.aYK.size() > 0) {
                                hVar.bbO = new el();
                                hVar.bbO.aYJ = fN.aYJ;
                                hVar.bbO.aYK = new LinkedList();
                                boolean z3 = true;
                                for (dm dmVar : fN.aYK) {
                                    if (dmVar != null) {
                                        ek ekVar = new ek();
                                        ekVar.name = dmVar.name;
                                        ekVar.aYG = dmVar.aYG;
                                        if (z3) {
                                            ekVar.isSelected = true;
                                            z2 = false;
                                        } else {
                                            z2 = z3;
                                        }
                                        hVar.bbO.aYK.add(ekVar);
                                        z3 = z2;
                                    }
                                }
                            }
                            this.baC.add(hVar);
                        } else if (frsTabInfo.tab_id.intValue() == 1) {
                            Cdo fN2 = dn.MH().fN(hVar.bbN);
                            if (fN2 != null && fN2.aYK != null && fN2.aYK.size() > 0) {
                                hVar.bbO = new el();
                                hVar.bbO.aYJ = fN2.aYJ;
                                hVar.bbO.aYK = new LinkedList();
                                for (dm dmVar2 : fN2.aYK) {
                                    if (dmVar2 != null) {
                                        ek ekVar2 = new ek();
                                        ekVar2.name = dmVar2.name;
                                        ekVar2.aYG = dmVar2.aYG;
                                        hVar.bbO.aYK.add(ekVar2);
                                    }
                                }
                            }
                            this.baC.add(hVar);
                        }
                    }
                }
            }
            this.baA.setData((List<com.baidu.tieba.frs.tab.h>) this.baC, true);
            boolean z4 = !this.bcn.NB();
            boolean z5 = this.bcn.getVisibility() == 0;
            this.bcn.setData((List<com.baidu.tieba.frs.tab.h>) this.baC, true);
            if (z4 && !z5) {
                this.bcn.setVisibility(8);
            }
            if (!this.bcy) {
                Ni();
            }
        }
    }

    private void e(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar == null || oVar.awn() == null || oVar.awn().size() == 0) {
            dn.MH().a(1, null);
            return;
        }
        List<CategoryInfo> awn = oVar.awn();
        Cdo cdo = new Cdo();
        cdo.aYJ = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < awn.size()) {
                if (awn.get(i2) != null) {
                    dm dmVar = new dm();
                    dmVar.aYG = awn.get(i2).category_id.intValue();
                    dmVar.name = awn.get(i2).category_name;
                    arrayList.add(dmVar);
                }
                i = i2 + 1;
            } else {
                cdo.aYK = arrayList;
                dn.MH().a(1, cdo);
                return;
            }
        }
    }

    private void cm(boolean z) {
        Cdo cdo = new Cdo();
        cdo.aYJ = 0;
        ArrayList arrayList = new ArrayList();
        dm dmVar = new dm();
        dmVar.aYG = 2;
        dmVar.name = this.bbk.getResources().getString(i.h.frsgroup_hot);
        arrayList.add(dmVar);
        dm dmVar2 = new dm();
        dmVar2.aYG = 3;
        dmVar2.name = this.bbk.getResources().getString(i.h.frsgroup_official);
        arrayList.add(dmVar2);
        if (z) {
            dm dmVar3 = new dm();
            dmVar3.aYG = 1;
            dmVar3.name = this.bbk.getResources().getString(i.h.frsgroup_recommend);
            arrayList.add(0, dmVar3);
        }
        cdo.aYK = arrayList;
        dn.MH().a(4, cdo);
    }

    public void a(ec ecVar) {
        if (this.baA != null) {
            this.baA.setDataLoadInterface(this.bcA);
        }
        this.bcB = ecVar;
    }

    public boolean Ob() {
        return this.bcn.getVisibility() == 0;
    }

    private int Oc() {
        if (this.mPageType == "normal_page") {
            if (this.bcl.Ol() != null && this.bcl.Ol().getParent() != null) {
                return this.bck.getHeaderViewsCount() - 2;
            }
            return this.bck.getHeaderViewsCount() - 1;
        } else if (this.mPageType == "frs_page") {
            if (this.bcm.Ol() != null && this.bcm.Ol().getParent() != null) {
                return this.bck.getHeaderViewsCount() - 2;
            }
            return this.bck.getHeaderViewsCount() - 1;
        } else {
            return 0;
        }
    }

    public boolean Od() {
        return this.bcz;
    }
}
