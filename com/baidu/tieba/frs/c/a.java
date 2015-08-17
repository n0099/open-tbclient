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
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.cr;
import com.baidu.tieba.frs.cs;
import com.baidu.tieba.frs.cu;
import com.baidu.tieba.frs.db;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.i;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.ai;
import com.baidu.tieba.tbadkCore.v;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f<FrsActivity> {
    private v LT;
    private int aMh;
    private final View.OnClickListener aXl;
    private HorizontalTabView aZK;
    private TabData aZM;
    private FrsActivity bat;
    private BdListView bbh;
    private FrsHeaderView bbi;
    private com.baidu.tieba.frs.view.p bbj;
    private HorizontalTabView bbk;
    private com.baidu.tieba.frs.view.j bbl;
    private be bbm;
    private int bbn;
    private int bbo;
    private String bbp;
    private Runnable bbq;
    private boolean bbr;
    private ai bbs;
    private di bbt;
    private n bbu;
    private boolean bbv;
    private boolean bbw;
    private db bbx;
    private db bby;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int NJ = NJ();
        if (this.bbk.Nl() && i >= NJ) {
            this.bbk.setVisibility(0);
            this.aZK.setVisibility(4);
            return;
        }
        this.bbk.setVisibility(8);
        this.aZK.setVisibility(0);
    }

    public a(FrsActivity frsActivity, n nVar) {
        super(frsActivity.getPageContext());
        this.bbh = null;
        this.bbi = null;
        this.bbj = null;
        this.aZK = null;
        this.bbk = null;
        this.bbl = null;
        this.bbm = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.bbp = null;
        this.bbr = false;
        this.LT = null;
        this.bbs = null;
        this.bbt = null;
        this.bbv = false;
        this.bbw = false;
        this.bbx = new b(this);
        this.aXl = new c(this);
        this.bat = frsActivity;
        this.bbu = nVar;
    }

    public void h(Bundle bundle) {
        oO();
        NG();
        NH();
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90);
        this.aZK = new HorizontalTabView(this.bat.getActivity(), dimensionPixelSize);
        this.aZK.setAutoFillTabCount(4);
        this.bbk = new HorizontalTabView(this.bat.getActivity(), dimensionPixelSize);
        this.bbk.setAutoFillTabCount(4);
        this.bbk.clearAnimation();
        this.bbk.setVisibility(8);
        this.aZK.setFakeTab(this.bbk);
        this.bbk.setFakeTab(this.aZK);
        this.bbu.D(this.bbk);
        this.bbr = TbadkSettings.getInst().loadBoolean(FrsActivity.aUi, false);
    }

    public void onActivityDestroy() {
        if (this.bbi != null) {
            this.bbi.onDestory();
        }
        if (this.bbj != null) {
            this.bbj.onDestory();
        }
        if (this.LT != null) {
            this.LT.MF();
        }
        if (this.bbt != null) {
            this.bbt.MF();
        }
        if (this.bbq != null) {
            this.bat.mHandler.removeCallbacks(this.bbq);
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.bbj != null) {
            this.bbj.changeSkinType(i);
        }
        if (this.bbm != null) {
            this.bbm.notifyDataSetChanged();
        }
        if (this.bbl != null) {
            this.bbl.changeSkinType(i);
        }
        if (this.bbi != null) {
            this.bbi.changeSkinType(i);
        }
        if (this.aZK != null) {
            this.aZK.vD();
        }
        if (this.bbk != null) {
            this.bbk.vD();
            return true;
        }
        return true;
    }

    public FrsHeaderView Nm() {
        return this.bbi;
    }

    public com.baidu.tieba.frs.view.p Nn() {
        return this.bbj;
    }

    public void t(BdListView bdListView) {
        this.bbh = bdListView;
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

    public void a(String str, com.baidu.tieba.tbadkCore.n nVar) {
        boolean z = false;
        this.mPageType = str;
        if (nVar.apc() != null && nVar.apc().size() != 0) {
            z = true;
        }
        if ("frs_page".equals(str)) {
            if (nVar != null && nVar.getUserData() != null && nVar.acG() != null) {
                d(nVar.getUserData().getIsMem(), nVar.acG().isLike(), z);
            }
        } else if ("normal_page".equals(str)) {
            if (nVar != null && nVar.getUserData() != null && nVar.acG() != null) {
                c(nVar.getUserData().getIsMem(), nVar.acG().isLike(), z);
            }
        } else if ("good_page".equals(str) && nVar != null && nVar.acG() != null) {
            b(nVar.acG().getGood_classify(), this.bat.aVc);
        }
        c(nVar);
    }

    public void c(int i, int i2, boolean z) {
        this.aMh = i2;
        Np();
        this.bbp = "normal_page";
        if (this.bbi == null) {
            this.bbi = new FrsHeaderView(this.bat, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.bbi.changeSkinType(this.mSkinType);
            this.bbi.n(this.aXl);
        }
        this.bbh.addHeaderView(this.bbi.getView());
        if (z) {
            MV();
        }
        if (!this.bbw) {
            this.bbh.addHeaderView(this.bbi.NS());
            this.bbw = true;
        }
        Nq();
    }

    public void d(int i, int i2, boolean z) {
        this.aMh = i2;
        Np();
        this.bbp = "frs_page";
        fF(i);
        this.bbh.addHeaderView(this.bbj.getView());
        if (z) {
            MV();
        }
        if (!this.bbw) {
            this.bbh.addHeaderView(this.bbj.NS());
            this.bbw = true;
        }
        Nq();
    }

    public void fF(int i) {
        if (this.bbj == null) {
            this.bbj = new com.baidu.tieba.frs.view.p(this.bat.getPageContext(), null, null, i);
            this.bbj.changeSkinType(this.mSkinType);
            this.bbj.n(this.aXl);
        }
    }

    public void No() {
        Np();
        this.bbp = "good_page";
        if (this.bbl == null) {
            this.bbl = new com.baidu.tieba.frs.view.j(getPageContext().getPageActivity());
            this.bbl.changeSkinType(this.mSkinType);
        }
        this.bbh.addHeaderView(this.bbl.getView());
    }

    private void Np() {
        if ("normal_page".equals(this.bbp) && this.bbi != null) {
            this.bbh.removeHeaderView(this.bbi.getView());
            this.bbh.removeHeaderView(this.bbi.NS());
        } else if ("frs_page".equals(this.bbp) && this.bbj != null) {
            this.bbh.removeHeaderView(this.bbj.getView());
            this.bbh.removeHeaderView(this.bbj.NS());
        } else if ("good_page".equals(this.bbp) && this.bbl != null) {
            this.bbh.removeHeaderView(this.bbl.getView());
        }
        this.bbw = false;
        if (this.aZK != null) {
            this.bbh.removeHeaderView(this.aZK);
            this.bbv = false;
        }
    }

    public void ch(boolean z) {
        if (z) {
            if (Nm() != null) {
                Nm().NV();
            }
            if (Nn() != null) {
                Nn().NV();
                return;
            }
            return;
        }
        if (Nm() != null) {
            Nm().NU();
        }
        if (Nn() != null) {
            Nn().NU();
        }
    }

    private void Nq() {
        if (this.bbq == null) {
            this.bbq = new d(this);
        }
        this.bat.mHandler.postDelayed(this.bbq, 4000L);
    }

    public void d(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            if ("frs_page".equals(this.mPageType)) {
                a(nVar.acG(), nVar);
            } else if ("normal_page".equals(this.mPageType)) {
                b(nVar.acG(), nVar);
            }
            c(nVar);
        }
    }

    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (forumData != null && nVar != null) {
            float a = a(forumData);
            if (this.bbj != null) {
                this.bbj.c(forumData, nVar);
                this.bbj.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.bbj.fO(forumData.getSignData().getSigned());
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.bbj.ck(false);
                    }
                }
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (forumData != null && nVar != null) {
            float a = a(forumData);
            if (this.bbi != null) {
                this.bbi.c(forumData, nVar);
                this.bbi.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.bbi.ck(false);
                        return;
                    }
                    this.bbi.ck(true);
                    this.bbi.fO(forumData.getSignData().getSigned());
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.bbn = forumData.getLevelupScore();
        this.bbo = forumData.getCurScore();
        if (this.bbn > 0) {
            return this.bbo / this.bbn;
        }
        return 0.0f;
    }

    public void b(ArrayList<com.baidu.tbadk.core.data.k> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        No();
        if (arrayList != null) {
            if (this.bbm == null) {
                this.bbm = new be(getPageContext().getPageActivity(), arrayList);
                this.bbl.a(this.bbm);
                this.bbl.b(onItemClickListener);
                return;
            }
            this.bbm.setData(arrayList);
            this.bbm.notifyDataSetChanged();
        }
    }

    public void fj(int i) {
        if (this.bbm != null) {
            this.bbm.fj(i);
        }
    }

    public void fG(int i) {
        if (i > 1) {
            if (this.bbi != null) {
                this.bbi.setIsFirstPage(false);
            }
            if (this.bbj != null) {
                this.bbj.setIsFirstPage(false);
                return;
            }
            return;
        }
        if (this.bbi != null) {
            this.bbi.setIsFirstPage(true);
        }
        if (this.bbj != null) {
            this.bbj.setIsFirstPage(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void b(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType)) {
            Nt();
        } else if ("normal_page".equals(this.mPageType)) {
            Ns();
        }
    }

    public void setIsMem(int i) {
        if (this.bbi != null) {
            this.bbi.setMemberType(i);
        }
        if (this.bbj != null) {
            this.bbj.setMemberType(i);
        }
    }

    public void Nr() {
        if ("normal_page".equals(this.bbp)) {
            if (this.bbi != null) {
                this.bbi.Nr();
            }
        } else if ("frs_page".equals(this.bbp) && this.bbj != null) {
            this.bbj.Nr();
        }
    }

    public void Ns() {
        if (this.bbi != null) {
            this.bbi.NY();
        }
    }

    public void Nt() {
        if (this.bbj != null) {
            this.bbj.NY();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (nVar != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(1, nVar.acG(), nVar, z);
            } else if ("frs_page".equals(this.mPageType)) {
                b(1, nVar.acG(), nVar, z);
            }
        }
    }

    public void Nu() {
        if ("normal_page".equals(this.mPageType)) {
            fI(0);
        } else if ("frs_page".equals(this.mPageType)) {
            fJ(0);
        }
    }

    public void fH(int i) {
        if ("normal_page".equals(this.mPageType)) {
            fI(i);
        } else if ("frs_page".equals(this.mPageType)) {
            fJ(i);
        }
    }

    public void fI(int i) {
        if (this.bbi != null) {
            this.bbi.fN(i);
        }
    }

    public void fJ(int i) {
        if (this.bbj != null) {
            this.bbj.fN(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (this.bbi != null) {
            this.bbi.c(forumData, nVar);
            if (forumData != null) {
                this.bbi.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.bbi.ck(false);
                }
            }
        }
    }

    public void b(int i, ForumData forumData, com.baidu.tieba.tbadkCore.n nVar, boolean z) {
        if (this.bbj != null) {
            this.bbj.c(forumData, nVar);
            float a = a(forumData);
            if (forumData != null) {
                this.bbj.a(i, forumData.getLevelName(), forumData.getUser_level(), a, z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.bbj.ck(false);
                }
            }
        }
    }

    public boolean Nv() {
        if ("normal_page".equals(this.bbp) && this.bbi != null) {
            return this.bbi.NQ();
        }
        if ("frs_page".equals(this.bbp) && this.bbj != null) {
            return this.bbj.NQ();
        }
        return false;
    }

    public void Nw() {
        if ("normal_page".equals(this.mPageType)) {
            Ny();
        } else if ("frs_page".equals(this.mPageType)) {
            NA();
        }
    }

    public void Nx() {
        if ("normal_page".equals(this.mPageType)) {
            Nz();
        } else if ("frs_page".equals(this.mPageType)) {
            NB();
        }
    }

    private void a(com.baidu.tieba.frs.view.a aVar, SignData signData) {
        if (aVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.bbn - this.bbo) {
                z = true;
                this.bbn = signData.getLevelUpScore();
            }
            this.bbo = bonusPoint + this.bbo;
            if (this.bbo > this.bbn) {
                this.bbo = this.bbn;
            }
            if (this.bbn != 0) {
                f = this.bbo / this.bbn;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            aVar.a(z, f);
        }
    }

    public void fK(int i) {
        if ("normal_page".equals(this.mPageType)) {
            fL(i);
        } else if ("frs_page".equals(this.mPageType)) {
            fM(i);
        }
    }

    public void e(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null && nVar.acG() != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(nVar.acG().getSignData(), nVar.acG(), nVar);
            } else if ("frs_page".equals(this.mPageType)) {
                b(nVar.acG().getSignData(), nVar.acG(), nVar);
            }
        }
    }

    public void fL(int i) {
        if (this.bbi != null) {
            this.bbi.fO(i);
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (this.bbi != null && signData != null && forumData != null && nVar != null) {
            this.bbi.c(forumData, nVar);
            this.bbi.fO(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.bbi.NQ()) {
                a(this.bbi, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.bbo);
                    forumData.setLevelupScore(this.bbn);
                }
                this.bbi.c(forumData, nVar);
                this.bbi.e(this.bbi.NW(), true);
            }
        }
    }

    public void fM(int i) {
        if (this.bbj != null) {
            this.bbj.fO(i);
        }
    }

    public void b(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (this.bbj != null && signData != null && forumData != null && nVar != null) {
            this.bbj.c(forumData, nVar);
            this.bbj.fO(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.bbj.NQ()) {
                a(this.bbj, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.bbo);
                    forumData.setLevelupScore(this.bbn);
                }
                this.bbj.c(forumData, nVar);
                this.bbj.e(this.bbj.NW(), true);
            }
        }
    }

    public void Ny() {
        if (this.bbi != null) {
            this.bbi.NX().setVisibility(0);
        }
    }

    public void Nz() {
        if (this.bbi != null) {
            this.bbi.NX().setVisibility(8);
        }
    }

    public void NA() {
        if (this.bbj != null) {
            this.bbj.NX().setVisibility(0);
        }
    }

    public void NB() {
        if (this.bbj != null) {
            this.bbj.NX().setVisibility(8);
        }
    }

    public boolean NC() {
        if ("normal_page".equals(this.bbp) && this.bbi != null) {
            return this.bbi.NC();
        }
        if ("frs_page".equals(this.bbp) && this.bbj != null) {
            return this.bbj.NC();
        }
        return false;
    }

    public void B(View view) {
        if (this.bbi != null) {
            this.bbi.e(view, false);
        }
    }

    public void C(View view) {
        if (this.bbj != null) {
            this.bbj.e(view, false);
        }
    }

    public boolean ND() {
        if ("normal_page".equals(this.bbp)) {
            if (this.bbi != null) {
                return this.bbi.ND();
            }
        } else if ("frs_page".equals(this.bbp) && this.bbj != null) {
            return this.bbj.ND();
        }
        return false;
    }

    public BarImageView NE() {
        com.baidu.tieba.frs.view.p Nn;
        if ("normal_page".equals(this.mPageType)) {
            FrsHeaderView Nm = Nm();
            if (Nm != null) {
                return Nm.NE();
            }
        } else if ("frs_page".equals(this.mPageType) && (Nn = Nn()) != null) {
            return Nn.NE();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void oP() {
        if (this.bat != null) {
            com.baidu.tieba.tbadkCore.n Lu = this.bat.Lu();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m411getInst().login(this.bat.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.C0057i.login_to_use), true, 11002)));
            } else if (Lu != null && Lu.acG() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bat.getFrom())) {
                    this.LT.setFrom(FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                } else {
                    this.LT.setFrom("from_frs");
                }
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bat.getFrom())) {
                    TiebaStatic.eventStat(this.bat.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                }
                this.LT.ba(Lu.acG().getName(), Lu.acG().getId());
            }
        }
    }

    public void Ly() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bat.Lu() != null && this.bat.Lu().acG() != null && this.bat.Lu().acG().getName() != null) {
            str = this.bat.Lu().acG().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cn(String.format(getPageContext().getString(i.C0057i.attention_cancel_dialog_content), str));
        } else {
            aVar.cn(getPageContext().getString(i.C0057i.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(i.C0057i.editor_dialog_yes), new e(this));
        aVar.b(getPageContext().getString(i.C0057i.editor_dialog_no), new f(this));
        aVar.b(getPageContext()).sP();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void NF() {
        com.baidu.tieba.tbadkCore.n Lu = this.bat.Lu();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.bat.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(i.C0057i.login_to_use), true, 11014)));
        } else if (Lu != null && Lu.acG() != null) {
            Nw();
            this.bbt.au(Lu.acG().getName(), Lu.acG().getId());
        }
    }

    private void oO() {
        this.LT = new v(this.bat.getPageContext());
        this.LT.setLoadDataCallBack(new g(this));
    }

    private void NG() {
        this.bbs = new ai();
        this.bbs.setFrom("from_frs");
        this.bbs.a(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new i(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void NH() {
        this.bbt = new di(this.bat);
        this.bbt.setLoadDataCallBack(new j(this));
    }

    private void MV() {
        if (this.aZK != null && !this.bbv) {
            this.bbh.addHeaderView(this.aZK, Integer.valueOf(this.bbh.getHeaderViewsCount()), false);
            this.bbv = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01d9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x003a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(com.baidu.tieba.tbadkCore.n nVar) {
        boolean z;
        boolean z2;
        URI uri;
        if (nVar != null && nVar.apc() != null && nVar.apc().size() != 0) {
            if (nVar.aoX() != null) {
                z = nVar.aoX().aoP() != 1;
            } else {
                z = false;
            }
            ci(z);
            this.aZM = new TabData();
            for (FrsTabInfo frsTabInfo : nVar.apc()) {
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
                            sb.append(nVar.acG().getId());
                            gVar.url = sb.toString();
                            if (!TextUtils.isEmpty(gVar.url)) {
                            }
                            gVar.baT = frsTabInfo.tab_id.intValue();
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
                        gVar.baT = frsTabInfo.tab_id.intValue();
                        gVar.name = frsTabInfo.tab_name;
                        if (frsTabInfo.tab_id.intValue() == 1 && cu.My().fv(frsTabInfo.tab_id.intValue())) {
                            List<cr> fs = cs.Mx().fs(gVar.baT);
                            if (fs != null && fs.size() > 0) {
                                gVar.baU = new LinkedList();
                                boolean z3 = true;
                                for (cr crVar : fs) {
                                    if (crVar != null) {
                                        com.baidu.tieba.frs.tab.h hVar = new com.baidu.tieba.frs.tab.h();
                                        hVar.name = crVar.name;
                                        hVar.aYt = crVar.aYt;
                                        if (z3) {
                                            hVar.isSelected = true;
                                            z2 = false;
                                        } else {
                                            z2 = z3;
                                        }
                                        gVar.baU.add(hVar);
                                        z3 = z2;
                                    }
                                }
                            }
                            this.aZM.add(gVar);
                        } else if (frsTabInfo.tab_id.intValue() != 1) {
                            this.aZM.add(gVar);
                        }
                    }
                }
            }
            this.aZK.setData((List<com.baidu.tieba.frs.tab.g>) this.aZM, true);
            boolean z4 = !this.bbk.Nl();
            boolean z5 = this.bbk.getVisibility() == 0;
            this.bbk.setData((List<com.baidu.tieba.frs.tab.g>) this.aZM, true);
            if (z4 && !z5) {
                this.bbk.setVisibility(8);
            }
            if (!this.bbv) {
                MV();
            }
        }
    }

    private void ci(boolean z) {
        ArrayList arrayList = new ArrayList();
        cr crVar = new cr();
        crVar.aYt = 2;
        crVar.name = this.bat.getResources().getString(i.C0057i.frsgroup_hot);
        arrayList.add(crVar);
        cr crVar2 = new cr();
        crVar2.aYt = 3;
        crVar2.name = this.bat.getResources().getString(i.C0057i.frsgroup_official);
        arrayList.add(crVar2);
        if (z) {
            cr crVar3 = new cr();
            crVar3.aYt = 1;
            crVar3.name = this.bat.getResources().getString(i.C0057i.frsgroup_recommend);
            arrayList.add(0, crVar3);
        }
        cs.Mx().c(4, arrayList);
    }

    public void a(db dbVar) {
        if (this.aZK != null) {
            this.aZK.setDataLoadInterface(this.bbx);
        }
        this.bby = dbVar;
    }

    public boolean NI() {
        return this.bbk.getVisibility() == 0;
    }

    private int NJ() {
        if (this.mPageType == "normal_page") {
            if (this.bbi.NS() != null && this.bbi.NS().getParent() != null) {
                return this.bbh.getHeaderViewsCount() - 2;
            }
            return this.bbh.getHeaderViewsCount() - 1;
        } else if (this.mPageType == "frs_page") {
            if (this.bbj.NS() != null && this.bbj.NS().getParent() != null) {
                return this.bbh.getHeaderViewsCount() - 2;
            }
            return this.bbh.getHeaderViewsCount() - 1;
        } else {
            return 0;
        }
    }

    public boolean NK() {
        return this.bbw;
    }
}
