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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ca;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.ee;
import com.baidu.tieba.frs.eg;
import com.baidu.tieba.frs.et;
import com.baidu.tieba.frs.fb;
import com.baidu.tieba.frs.fc;
import com.baidu.tieba.frs.fd;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.aj;
import com.baidu.tieba.tbadkCore.x;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.CategoryInfo;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f<FrsActivity> {
    private x Ml;
    private int aMO;
    private final View.OnClickListener bcT;
    private HorizontalTabView bgS;
    private TabData bgU;
    private FrsActivity bhN;
    private BdListView biP;
    private FrsHeaderView biQ;
    private com.baidu.tieba.frs.view.q biR;
    private HorizontalTabView biS;
    private com.baidu.tieba.frs.view.j biT;
    private ca biU;
    private int biV;
    private int biW;
    private String biX;
    private Runnable biY;
    private boolean biZ;
    private aj bja;
    private fb bjb;
    private o bjc;
    private boolean bjd;
    private boolean bje;
    private et bjf;
    private et bjg;
    private HorizontalTabView.a bjh;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int PI = PI();
        if (this.biS.Ph() && i >= PI) {
            this.biS.setVisibility(0);
            this.bgS.setVisibility(4);
            return;
        }
        this.biS.setVisibility(8);
        this.bgS.setVisibility(0);
    }

    public a(FrsActivity frsActivity, o oVar) {
        super(frsActivity.getPageContext());
        this.biP = null;
        this.biQ = null;
        this.biR = null;
        this.bgS = null;
        this.biS = null;
        this.biT = null;
        this.biU = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.biX = null;
        this.biZ = false;
        this.Ml = null;
        this.bja = null;
        this.bjb = null;
        this.bjd = false;
        this.bje = false;
        this.bjf = new b(this);
        this.bjh = new d(this);
        this.bcT = new e(this);
        this.bhN = frsActivity;
        this.bjc = oVar;
    }

    public void h(Bundle bundle) {
        oT();
        PF();
        PG();
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds90);
        this.bgS = new HorizontalTabView(this.bhN.getActivity(), dimensionPixelSize);
        this.bgS.setAutoFillTabCount(4);
        this.bgS.setmShowMenuCallBack(this.bjh);
        this.biS = new HorizontalTabView(this.bhN.getActivity(), dimensionPixelSize);
        this.biS.setAutoFillTabCount(4);
        this.biS.clearAnimation();
        this.biS.setVisibility(8);
        this.bgS.setFakeTab(this.biS);
        this.biS.setFakeTab(this.bgS);
        this.bjc.I(this.biS);
        this.biZ = TbadkSettings.getInst().loadBoolean(FrsActivity.aYZ, false);
    }

    public void onActivityDestroy() {
        if (this.biQ != null) {
            this.biQ.onDestory();
        }
        if (this.biR != null) {
            this.biR.onDestory();
        }
        if (this.Ml != null) {
            this.Ml.Op();
        }
        if (this.bjb != null) {
            this.bjb.Op();
        }
        if (this.biY != null) {
            this.bhN.mHandler.removeCallbacks(this.biY);
        }
    }

    public void onActivityStop() {
        if (this.biQ != null) {
            this.biQ.onStop();
        }
        if (this.biR != null) {
            this.biR.onStop();
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.biR != null) {
            this.biR.changeSkinType(i);
        }
        if (this.biU != null) {
            this.biU.notifyDataSetChanged();
        }
        if (this.biT != null) {
            this.biT.changeSkinType(i);
        }
        if (this.biQ != null) {
            this.biQ.changeSkinType(i);
        }
        if (this.bgS != null) {
            this.bgS.wh();
        }
        if (this.biS != null) {
            this.biS.wh();
            return true;
        }
        return true;
    }

    public FrsHeaderView Pl() {
        return this.biQ;
    }

    public com.baidu.tieba.frs.view.q Pm() {
        return this.biR;
    }

    public void t(BdListView bdListView) {
        this.biP = bdListView;
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

    public void a(String str, com.baidu.tieba.tbadkCore.p pVar) {
        boolean z = false;
        this.mPageType = str;
        if (pVar.aBO() != null && pVar.aBO().size() != 0) {
            z = true;
        }
        if ("frs_page".equals(str)) {
            if (pVar != null && pVar.getUserData() != null && pVar.ajy() != null) {
                d(pVar.getUserData().getIsMem(), pVar.ajy().isLike(), z);
            }
        } else if ("normal_page".equals(str)) {
            if (pVar != null && pVar.getUserData() != null && pVar.ajy() != null) {
                c(pVar.getUserData().getIsMem(), pVar.ajy().isLike(), z);
            }
        } else if ("good_page".equals(str) && pVar != null && pVar.ajy() != null) {
            b(pVar.ajy().getGood_classify(), this.bhN.aZX);
        }
        c(pVar);
    }

    public void c(int i, int i2, boolean z) {
        this.aMO = i2;
        Po();
        this.biX = "normal_page";
        if (this.biQ == null) {
            this.biQ = new FrsHeaderView(this.bhN, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.biQ.changeSkinType(this.mSkinType);
            this.biQ.setCommonClickListener(this.bcT);
        }
        this.biP.addHeaderView(this.biQ.getView());
        if (z) {
            OK();
        }
        if (!this.bje) {
            this.biP.addHeaderView(this.biQ.PR());
            this.bje = true;
        }
        Pp();
    }

    public void d(int i, int i2, boolean z) {
        this.aMO = i2;
        Po();
        this.biX = "frs_page";
        gB(i);
        this.biP.addHeaderView(this.biR.getView());
        if (z) {
            OK();
        }
        if (!this.bje) {
            this.biP.addHeaderView(this.biR.PR());
            this.bje = true;
        }
        Pp();
    }

    public void gB(int i) {
        if (this.biR == null) {
            this.biR = new com.baidu.tieba.frs.view.q(this.bhN.getPageContext(), null, null, i);
            this.biR.changeSkinType(this.mSkinType);
            this.biR.setCommonClickListener(this.bcT);
        }
    }

    public void Pn() {
        Po();
        this.biX = "good_page";
        if (this.biT == null) {
            this.biT = new com.baidu.tieba.frs.view.j(getPageContext().getPageActivity());
            this.biT.changeSkinType(this.mSkinType);
        }
        this.biP.addHeaderView(this.biT.getView());
    }

    private void Po() {
        if ("normal_page".equals(this.biX) && this.biQ != null) {
            this.biP.removeHeaderView(this.biQ.getView());
            this.biP.removeHeaderView(this.biQ.PR());
        } else if ("frs_page".equals(this.biX) && this.biR != null) {
            this.biP.removeHeaderView(this.biR.getView());
            this.biP.removeHeaderView(this.biR.PR());
        } else if ("good_page".equals(this.biX) && this.biT != null) {
            this.biP.removeHeaderView(this.biT.getView());
        }
        this.bje = false;
        if (this.bgS != null) {
            this.biP.removeHeaderView(this.bgS);
            this.bjd = false;
        }
    }

    public void cy(boolean z) {
        if (z) {
            if (Pl() != null) {
                Pl().PU();
            }
            if (Pm() != null) {
                Pm().PU();
                return;
            }
            return;
        }
        if (Pl() != null) {
            Pl().PT();
        }
        if (Pm() != null) {
            Pm().PT();
        }
    }

    private void Pp() {
        if (this.biY == null) {
            this.biY = new f(this);
        }
        this.bhN.mHandler.postDelayed(this.biY, 4000L);
    }

    public void d(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            if ("frs_page".equals(this.mPageType)) {
                a(pVar.ajy(), pVar);
            } else if ("normal_page".equals(this.mPageType)) {
                b(pVar.ajy(), pVar);
            }
            c(pVar);
        }
    }

    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (forumData != null && pVar != null) {
            float a = a(forumData);
            if (this.biR != null) {
                this.biR.c(forumData, pVar);
                this.biR.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.biR.gL(forumData.getSignData().getSigned());
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.biR.cB(false);
                    }
                }
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (forumData != null && pVar != null) {
            float a = a(forumData);
            if (this.biQ != null) {
                this.biQ.c(forumData, pVar);
                this.biQ.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.biQ.cB(false);
                        return;
                    }
                    this.biQ.cB(true);
                    this.biQ.gL(forumData.getSignData().getSigned());
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.biV = forumData.getLevelupScore();
        this.biW = forumData.getCurScore();
        if (this.biV > 0) {
            return this.biW / this.biV;
        }
        return 0.0f;
    }

    public void b(ArrayList<com.baidu.tbadk.core.data.m> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        Pn();
        if (arrayList != null) {
            if (this.biU == null) {
                this.biU = new ca(getPageContext().getPageActivity(), arrayList);
                this.biT.a(this.biU);
                this.biT.b(onItemClickListener);
                return;
            }
            this.biU.setData(arrayList);
            this.biU.notifyDataSetChanged();
        }
    }

    public void gb(int i) {
        if (this.biU != null) {
            this.biU.gb(i);
        }
    }

    public void gC(int i) {
        if (i > 1) {
            if (this.biQ != null) {
                this.biQ.setIsFirstPage(false);
            }
            if (this.biR != null) {
                this.biR.setIsFirstPage(false);
                return;
            }
            return;
        }
        if (this.biQ != null) {
            this.biQ.setIsFirstPage(true);
        }
        if (this.biR != null) {
            this.biR.setIsFirstPage(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void b(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType)) {
            Ps();
        } else if ("normal_page".equals(this.mPageType)) {
            Pr();
        }
    }

    public void setIsMem(int i) {
        if (this.biQ != null) {
            this.biQ.setMemberType(i);
        }
        if (this.biR != null) {
            this.biR.setMemberType(i);
        }
    }

    public void Pq() {
        if ("normal_page".equals(this.biX)) {
            if (this.biQ != null) {
                this.biQ.Pq();
            }
        } else if ("frs_page".equals(this.biX) && this.biR != null) {
            this.biR.Pq();
        }
    }

    public void Pr() {
        if (this.biQ != null) {
            this.biQ.PX();
        }
    }

    public void Ps() {
        if (this.biR != null) {
            this.biR.PX();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar, boolean z) {
        if (pVar != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(1, pVar.ajy(), pVar, z);
            } else if ("frs_page".equals(this.mPageType)) {
                b(1, pVar.ajy(), pVar, z);
            }
        }
    }

    public void Pt() {
        if ("normal_page".equals(this.mPageType)) {
            gE(0);
        } else if ("frs_page".equals(this.mPageType)) {
            gF(0);
        }
    }

    public void gD(int i) {
        if ("normal_page".equals(this.mPageType)) {
            gE(i);
        } else if ("frs_page".equals(this.mPageType)) {
            gF(i);
        }
    }

    public void gE(int i) {
        if (this.biQ != null) {
            this.biQ.gK(i);
        }
    }

    public void gF(int i) {
        if (this.biR != null) {
            this.biR.gK(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar, boolean z) {
        if (this.biQ != null) {
            this.biQ.c(forumData, pVar);
            if (forumData != null) {
                this.biQ.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.biQ.cB(false);
                }
            }
        }
    }

    public void b(int i, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar, boolean z) {
        if (this.biR != null) {
            this.biR.c(forumData, pVar);
            float a = a(forumData);
            if (forumData != null) {
                this.biR.a(i, forumData.getLevelName(), forumData.getUser_level(), a, z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.biR.cB(false);
                }
            }
        }
    }

    public boolean Pu() {
        if ("normal_page".equals(this.biX) && this.biQ != null) {
            return this.biQ.PP();
        }
        if ("frs_page".equals(this.biX) && this.biR != null) {
            return this.biR.PP();
        }
        return false;
    }

    public void Pv() {
        if ("normal_page".equals(this.mPageType)) {
            Px();
        } else if ("frs_page".equals(this.mPageType)) {
            Pz();
        }
    }

    public void Pw() {
        if ("normal_page".equals(this.mPageType)) {
            Py();
        } else if ("frs_page".equals(this.mPageType)) {
            PA();
        }
    }

    private void a(com.baidu.tieba.frs.view.a aVar, SignData signData) {
        if (aVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.biV - this.biW) {
                z = true;
                this.biV = signData.getLevelUpScore();
            }
            this.biW = bonusPoint + this.biW;
            if (this.biW > this.biV) {
                this.biW = this.biV;
            }
            if (this.biV != 0) {
                f = this.biW / this.biV;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            aVar.a(z, f);
        }
    }

    public void gG(int i) {
        if ("normal_page".equals(this.mPageType)) {
            gH(i);
        } else if ("frs_page".equals(this.mPageType)) {
            gI(i);
        }
    }

    public void e(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null && pVar.ajy() != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(pVar.ajy().getSignData(), pVar.ajy(), pVar);
            } else if ("frs_page".equals(this.mPageType)) {
                b(pVar.ajy().getSignData(), pVar.ajy(), pVar);
            }
        }
    }

    public void gH(int i) {
        if (this.biQ != null) {
            this.biQ.gL(i);
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (this.biQ != null && signData != null && forumData != null && pVar != null) {
            this.biQ.c(forumData, pVar);
            this.biQ.gL(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.biQ.PP()) {
                a(this.biQ, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.biW);
                    forumData.setLevelupScore(this.biV);
                }
                this.biQ.c(forumData, pVar);
                this.biQ.e(this.biQ.PV(), true);
            }
        }
    }

    public void gI(int i) {
        if (this.biR != null) {
            this.biR.gL(i);
        }
    }

    public void b(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (this.biR != null && signData != null && forumData != null && pVar != null) {
            this.biR.c(forumData, pVar);
            this.biR.gL(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.biR.PP()) {
                a(this.biR, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.biW);
                    forumData.setLevelupScore(this.biV);
                }
                this.biR.c(forumData, pVar);
                this.biR.e(this.biR.PV(), true);
            }
        }
    }

    public void Px() {
        if (this.biQ != null) {
            this.biQ.PW().setVisibility(0);
        }
    }

    public void Py() {
        if (this.biQ != null) {
            this.biQ.PW().setVisibility(8);
        }
    }

    public void Pz() {
        if (this.biR != null) {
            this.biR.PW().setVisibility(0);
        }
    }

    public void PA() {
        if (this.biR != null) {
            this.biR.PW().setVisibility(8);
        }
    }

    public boolean PB() {
        if ("normal_page".equals(this.biX) && this.biQ != null) {
            return this.biQ.PB();
        }
        if ("frs_page".equals(this.biX) && this.biR != null) {
            return this.biR.PB();
        }
        return false;
    }

    public void G(View view) {
        if (this.biQ != null) {
            this.biQ.e(view, false);
        }
    }

    public void H(View view) {
        if (this.biR != null) {
            this.biR.e(view, false);
        }
    }

    public boolean PC() {
        if ("normal_page".equals(this.biX)) {
            if (this.biQ != null) {
                return this.biQ.PC();
            }
        } else if ("frs_page".equals(this.biX) && this.biR != null) {
            return this.biR.PC();
        }
        return false;
    }

    public BarImageView PD() {
        com.baidu.tieba.frs.view.q Pm;
        if ("normal_page".equals(this.mPageType)) {
            FrsHeaderView Pl = Pl();
            if (Pl != null) {
                return Pl.PD();
            }
        } else if ("frs_page".equals(this.mPageType) && (Pm = Pm()) != null) {
            return Pm.PD();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void oU() {
        if (this.bhN != null) {
            com.baidu.tieba.tbadkCore.p MT = this.bhN.MT();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m411getInst().login(this.bhN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(n.i.login_to_use), true, 11002)));
            } else if (MT != null && MT.ajy() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bhN.getFrom())) {
                    TiebaStatic.log(new av("c10356").ab(ImageViewerConfig.FORUM_ID, MT.ajy().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.bhN.getFrom())) {
                    TiebaStatic.log(new av("c10590").r("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, MT.ajy().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.bhN.getFrom())) {
                    TiebaStatic.log(new av("c10587").r("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, MT.ajy().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.bhN.getFrom())) {
                    TiebaStatic.log(new av("c10578").r("obj_type", 2).ab(ImageViewerConfig.FORUM_ID, MT.ajy().getId()));
                }
                this.Ml.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bhN.getFrom())) {
                    TiebaStatic.eventStat(this.bhN.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.bhN.getFrom())) {
                    TiebaStatic.log(new av("c10359").ab(ImageViewerConfig.FORUM_ID, MT.ajy().getId()));
                }
                this.Ml.u(MT.ajy().getName(), MT.ajy().getId(), "FRS");
            }
        }
    }

    public void MW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bhN.MT() != null && this.bhN.MT().ajy() != null && this.bhN.MT().ajy().getName() != null) {
            str = this.bhN.MT().ajy().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cC(String.format(getPageContext().getString(n.i.attention_cancel_dialog_content), str));
        } else {
            aVar.cC(getPageContext().getString(n.i.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(n.i.editor_dialog_yes), new g(this));
        aVar.b(getPageContext().getString(n.i.editor_dialog_no), new h(this));
        aVar.b(getPageContext()).tv();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void PE() {
        com.baidu.tieba.tbadkCore.p MT = this.bhN.MT();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.bhN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(n.i.login_to_use), true, 11014)));
        } else if (MT != null && MT.ajy() != null) {
            Pv();
            this.bjb.aw(MT.ajy().getName(), MT.ajy().getId());
        }
    }

    private void oT() {
        this.Ml = new x(this.bhN.getPageContext());
        this.Ml.setLoadDataCallBack(new i(this));
    }

    private void PF() {
        this.bja = new aj();
        this.bja.setFrom("from_frs");
        this.bja.a(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        new k(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void PG() {
        this.bjb = new fb(this.bhN);
        this.bjb.setLoadDataCallBack(new c(this));
    }

    private void OK() {
        if (this.bgS != null && !this.bjd) {
            this.biP.addHeaderView(this.bgS, Integer.valueOf(this.biP.getHeaderViewsCount()), false);
            this.bjd = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x01f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x003d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(com.baidu.tieba.tbadkCore.p pVar) {
        boolean z;
        boolean z2;
        URI uri;
        if (pVar != null && pVar.aBO() != null && pVar.aBO().size() != 0) {
            if (pVar.aBI() != null) {
                z = pVar.aBI().aBz() != 1;
            } else {
                z = false;
            }
            cz(z);
            f(pVar);
            this.bgU = new TabData();
            for (FrsTabInfo frsTabInfo : pVar.aBO()) {
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
                            sb.append(pVar.ajy().getId());
                            hVar.url = sb.toString();
                            if (!TextUtils.isEmpty(hVar.url)) {
                            }
                            hVar.bis = frsTabInfo.tab_id.intValue();
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
                                av avVar = new av("c10078");
                                avVar.ab("obj_type", host);
                                TiebaStatic.log(avVar);
                            }
                        }
                        hVar.bis = frsTabInfo.tab_id.intValue();
                        hVar.name = frsTabInfo.tab_name;
                        if (frsTabInfo.tab_id.intValue() == 1 && eg.Of().gm(frsTabInfo.tab_id.intValue())) {
                            ee gj = ed.Oe().gj(hVar.bis);
                            if (gj != null && gj.beJ != null && gj.beJ.size() > 0) {
                                hVar.bit = new fd();
                                hVar.bit.beI = gj.beI;
                                hVar.bit.beJ = new LinkedList();
                                boolean z3 = true;
                                for (ec ecVar : gj.beJ) {
                                    if (ecVar != null) {
                                        fc fcVar = new fc();
                                        fcVar.name = ecVar.name;
                                        fcVar.beF = ecVar.beF;
                                        if (z3) {
                                            fcVar.isSelected = true;
                                            z2 = false;
                                        } else {
                                            z2 = z3;
                                        }
                                        hVar.bit.beJ.add(fcVar);
                                        z3 = z2;
                                    }
                                }
                            }
                            this.bgU.add(hVar);
                        } else if (frsTabInfo.tab_id.intValue() == 1) {
                            ee gj2 = ed.Oe().gj(hVar.bis);
                            if (gj2 != null && gj2.beJ != null && gj2.beJ.size() > 0) {
                                hVar.bit = new fd();
                                hVar.bit.beI = gj2.beI;
                                hVar.bit.beJ = new LinkedList();
                                for (ec ecVar2 : gj2.beJ) {
                                    if (ecVar2 != null) {
                                        fc fcVar2 = new fc();
                                        fcVar2.name = ecVar2.name;
                                        fcVar2.beF = ecVar2.beF;
                                        hVar.bit.beJ.add(fcVar2);
                                    }
                                }
                            }
                            this.bgU.add(hVar);
                        }
                    }
                }
            }
            this.bgS.setData(this.bgU);
            boolean z4 = !this.biS.Ph();
            boolean z5 = this.biS.getVisibility() == 0;
            this.biS.setData(this.bgU);
            if (z4 && !z5) {
                this.biS.setVisibility(8);
            }
            if (!this.bjd) {
                OK();
            }
        }
    }

    private void f(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar == null || pVar.aBU() == null || pVar.aBU().size() == 0) {
            ed.Oe().a(1, null);
            return;
        }
        List<CategoryInfo> aBU = pVar.aBU();
        ee eeVar = new ee();
        eeVar.beI = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < aBU.size()) {
                if (aBU.get(i2) != null) {
                    ec ecVar = new ec();
                    ecVar.beF = aBU.get(i2).category_id.intValue();
                    ecVar.name = aBU.get(i2).category_name;
                    arrayList.add(ecVar);
                }
                i = i2 + 1;
            } else {
                eeVar.beJ = arrayList;
                ed.Oe().a(1, eeVar);
                return;
            }
        }
    }

    private void cz(boolean z) {
        ee eeVar = new ee();
        eeVar.beI = 0;
        ArrayList arrayList = new ArrayList();
        ec ecVar = new ec();
        ecVar.beF = 2;
        ecVar.name = this.bhN.getResources().getString(n.i.frsgroup_hot);
        arrayList.add(ecVar);
        ec ecVar2 = new ec();
        ecVar2.beF = 3;
        ecVar2.name = this.bhN.getResources().getString(n.i.frsgroup_official);
        arrayList.add(ecVar2);
        if (z) {
            ec ecVar3 = new ec();
            ecVar3.beF = 1;
            ecVar3.name = this.bhN.getResources().getString(n.i.frsgroup_recommend);
            arrayList.add(0, ecVar3);
        }
        eeVar.beJ = arrayList;
        ed.Oe().a(4, eeVar);
    }

    public void a(et etVar) {
        if (this.bgS != null) {
            this.bgS.setDataLoadInterface(this.bjf);
        }
        this.bjg = etVar;
    }

    public boolean PH() {
        return this.biS.getVisibility() == 0;
    }

    private int PI() {
        if (this.mPageType == "normal_page") {
            if (this.biQ.PR() != null && this.biQ.PR().getParent() != null) {
                return this.biP.getHeaderViewsCount() - 2;
            }
            return this.biP.getHeaderViewsCount() - 1;
        } else if (this.mPageType == "frs_page") {
            if (this.biR.PR() != null && this.biR.PR().getParent() != null) {
                return this.biP.getHeaderViewsCount() - 2;
            }
            return this.biP.getHeaderViewsCount() - 1;
        } else {
            return 0;
        }
    }

    public boolean PJ() {
        return this.bje;
    }
}
