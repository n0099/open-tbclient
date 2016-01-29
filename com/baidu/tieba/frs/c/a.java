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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ck;
import com.baidu.tieba.frs.en;
import com.baidu.tieba.frs.eo;
import com.baidu.tieba.frs.ep;
import com.baidu.tieba.frs.er;
import com.baidu.tieba.frs.fe;
import com.baidu.tieba.frs.fl;
import com.baidu.tieba.frs.fm;
import com.baidu.tieba.frs.fn;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.frs.view.t;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.t;
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
    private w MS;
    private int aRV;
    private final View.OnClickListener bjG;
    private HorizontalTabView bnG;
    private TabData bnI;
    private FrsActivity bot;
    private ck bpA;
    private int bpB;
    private int bpC;
    private String bpD;
    private Runnable bpE;
    private boolean bpF;
    private ai bpG;
    private fl bpH;
    private o bpI;
    private boolean bpJ;
    private boolean bpK;
    private fe bpL;
    private fe bpM;
    private HorizontalTabView.a bpN;
    private BdListView bpv;
    private FrsHeaderView bpw;
    private t bpx;
    private HorizontalTabView bpy;
    private com.baidu.tieba.frs.view.k bpz;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int Se = Se();
        if (this.bpy.RD() && i >= Se) {
            this.bpy.setVisibility(0);
            this.bnG.setVisibility(4);
            return;
        }
        this.bpy.setVisibility(8);
        this.bnG.setVisibility(0);
    }

    public a(FrsActivity frsActivity, o oVar) {
        super(frsActivity.getPageContext());
        this.bpv = null;
        this.bpw = null;
        this.bpx = null;
        this.bnG = null;
        this.bpy = null;
        this.bpz = null;
        this.bpA = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.bpD = null;
        this.bpF = false;
        this.MS = null;
        this.bpG = null;
        this.bpH = null;
        this.bpJ = false;
        this.bpK = false;
        this.bpL = new b(this);
        this.bpN = new d(this);
        this.bjG = new e(this);
        this.bot = frsActivity;
        this.bpI = oVar;
    }

    public void e(Bundle bundle) {
        oM();
        Sb();
        Sc();
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds90);
        this.bnG = new HorizontalTabView(this.bot.getActivity(), dimensionPixelSize);
        this.bnG.setAutoFillTabCount(4);
        this.bnG.setmShowMenuCallBack(this.bpN);
        this.bpy = new HorizontalTabView(this.bot.getActivity(), dimensionPixelSize);
        this.bpy.setAutoFillTabCount(4);
        this.bpy.clearAnimation();
        this.bpy.setVisibility(8);
        this.bnG.setFakeTab(this.bpy);
        this.bpy.setFakeTab(this.bnG);
        this.bpI.X(this.bpy);
        this.bpF = TbadkSettings.getInst().loadBoolean(FrsActivity.bfm, false);
    }

    public void onActivityDestroy() {
        if (this.bpw != null) {
            this.bpw.onDestory();
        }
        if (this.bpx != null) {
            this.bpx.onDestory();
        }
        if (this.MS != null) {
            this.MS.QJ();
        }
        if (this.bpH != null) {
            this.bpH.QJ();
        }
        if (this.bpE != null) {
            this.bot.mHandler.removeCallbacks(this.bpE);
        }
    }

    public void onActivityStop() {
        if (this.bpw != null) {
            this.bpw.onStop();
        }
        if (this.bpx != null) {
            this.bpx.onStop();
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.bpx != null) {
            this.bpx.changeSkinType(i);
        }
        if (this.bpA != null) {
            this.bpA.notifyDataSetChanged();
        }
        if (this.bpz != null) {
            this.bpz.changeSkinType(i);
        }
        if (this.bpw != null) {
            this.bpw.changeSkinType(i);
        }
        if (this.bnG != null) {
            this.bnG.xf();
        }
        if (this.bpy != null) {
            this.bpy.xf();
            return true;
        }
        return true;
    }

    public FrsHeaderView RH() {
        return this.bpw;
    }

    public com.baidu.tieba.frs.view.t RI() {
        return this.bpx;
    }

    public void t(BdListView bdListView) {
        this.bpv = bdListView;
    }

    public void a(boolean z, int i, int i2, boolean z2) {
        if (z) {
            this.mPageType = "frs_page";
            e(i, i2, z2);
            return;
        }
        this.mPageType = "normal_page";
        d(i, i2, z2);
    }

    public void a(String str, com.baidu.tieba.tbadkCore.o oVar) {
        boolean z = false;
        this.mPageType = str;
        if (oVar.aLa() != null && oVar.aLa().size() != 0) {
            z = true;
        }
        if ("frs_page".equals(str)) {
            if (oVar != null && oVar.getUserData() != null && oVar.aoE() != null) {
                e(oVar.getUserData().getIsMem(), oVar.aoE().isLike(), z);
            }
        } else if ("normal_page".equals(str)) {
            if (oVar != null && oVar.getUserData() != null && oVar.aoE() != null) {
                d(oVar.getUserData().getIsMem(), oVar.aoE().isLike(), z);
            }
        } else if ("good_page".equals(str) && oVar != null && oVar.aoE() != null) {
            b(oVar.aoE().getGood_classify(), this.bot.bgp);
        }
        c(oVar);
    }

    public void d(int i, int i2, boolean z) {
        this.aRV = i2;
        RK();
        this.bpD = "normal_page";
        if (this.bpw == null) {
            this.bpw = new FrsHeaderView(this.bot, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.bpw.changeSkinType(this.mSkinType);
            this.bpw.setCommonClickListener(this.bjG);
        }
        this.bpv.addHeaderView(this.bpw.getView());
        if (z) {
            Rf();
        }
        if (!this.bpK) {
            this.bpv.addHeaderView(this.bpw.Sn());
            this.bpK = true;
        }
        RL();
    }

    public void e(int i, int i2, boolean z) {
        this.aRV = i2;
        RK();
        this.bpD = "frs_page";
        gR(i);
        this.bpv.addHeaderView(this.bpx.getView());
        if (z) {
            Rf();
        }
        if (!this.bpK) {
            this.bpv.addHeaderView(this.bpx.Sn());
            this.bpK = true;
        }
        RL();
    }

    public void gR(int i) {
        if (this.bpx == null) {
            this.bpx = new com.baidu.tieba.frs.view.t(this.bot.getPageContext(), null, null, i);
            this.bpx.changeSkinType(this.mSkinType);
            this.bpx.setCommonClickListener(this.bjG);
        }
    }

    public void RJ() {
        RK();
        this.bpD = "good_page";
        if (this.bpz == null) {
            this.bpz = new com.baidu.tieba.frs.view.k(getPageContext().getPageActivity());
            this.bpz.changeSkinType(this.mSkinType);
        }
        this.bpv.addHeaderView(this.bpz.getView());
    }

    private void RK() {
        if ("normal_page".equals(this.bpD) && this.bpw != null) {
            this.bpv.removeHeaderView(this.bpw.getView());
            this.bpv.removeHeaderView(this.bpw.Sn());
        } else if ("frs_page".equals(this.bpD) && this.bpx != null) {
            this.bpv.removeHeaderView(this.bpx.getView());
            this.bpv.removeHeaderView(this.bpx.Sn());
        } else if ("good_page".equals(this.bpD) && this.bpz != null) {
            this.bpv.removeHeaderView(this.bpz.getView());
        }
        this.bpK = false;
        if (this.bnG != null) {
            this.bpv.removeHeaderView(this.bnG);
            this.bpJ = false;
        }
    }

    public void cz(boolean z) {
        if (z) {
            if (RH() != null) {
                RH().Sq();
            }
            if (RI() != null) {
                RI().Sq();
                return;
            }
            return;
        }
        if (RH() != null) {
            RH().Sp();
        }
        if (RI() != null) {
            RI().Sp();
        }
    }

    private void RL() {
        if (this.bpE == null) {
            this.bpE = new f(this);
        }
        this.bot.mHandler.postDelayed(this.bpE, 4000L);
    }

    public void d(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            if ("frs_page".equals(this.mPageType)) {
                a(oVar.aoE(), oVar);
            } else if ("normal_page".equals(this.mPageType)) {
                b(oVar.aoE(), oVar);
            }
            c(oVar);
        }
    }

    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (forumData != null && oVar != null) {
            float a = a(forumData);
            if (this.bpx != null) {
                this.bpx.c(forumData, oVar);
                this.bpx.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.bpx.hb(forumData.getSignData().getSigned());
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.bpx.cC(false);
                    }
                }
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (forumData != null && oVar != null) {
            float a = a(forumData);
            if (this.bpw != null) {
                this.bpw.c(forumData, oVar);
                this.bpw.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.bpw.cC(false);
                        return;
                    }
                    this.bpw.cC(true);
                    this.bpw.hb(forumData.getSignData().getSigned());
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.bpB = forumData.getLevelupScore();
        this.bpC = forumData.getCurScore();
        if (this.bpB > 0) {
            return this.bpC / this.bpB;
        }
        return 0.0f;
    }

    public void b(ArrayList<com.baidu.tbadk.core.data.p> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        RJ();
        if (arrayList != null) {
            if (this.bpA == null) {
                this.bpA = new ck(getPageContext().getPageActivity(), arrayList);
                this.bpz.a(this.bpA);
                this.bpz.c(onItemClickListener);
                return;
            }
            this.bpA.setData(arrayList);
            this.bpA.notifyDataSetChanged();
        }
    }

    public void gt(int i) {
        if (this.bpA != null) {
            this.bpA.gt(i);
        }
    }

    public void gS(int i) {
        if (i > 1) {
            if (this.bpw != null) {
                this.bpw.cD(false);
            }
            if (this.bpx != null) {
                this.bpx.cD(false);
                return;
            }
            return;
        }
        if (this.bpw != null) {
            this.bpw.cD(true);
        }
        if (this.bpx != null) {
            this.bpx.cD(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void b(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType)) {
            RO();
        } else if ("normal_page".equals(this.mPageType)) {
            RN();
        }
    }

    public void setIsMem(int i) {
        if (this.bpw != null) {
            this.bpw.setMemberType(i);
        }
        if (this.bpx != null) {
            this.bpx.setMemberType(i);
        }
    }

    public void RM() {
        if ("normal_page".equals(this.bpD)) {
            if (this.bpw != null) {
                this.bpw.RM();
            }
        } else if ("frs_page".equals(this.bpD) && this.bpx != null) {
            this.bpx.RM();
        }
    }

    public void RN() {
        if (this.bpw != null) {
            this.bpw.St();
        }
    }

    public void RO() {
        if (this.bpx != null) {
            this.bpx.St();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (oVar != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(1, oVar.aoE(), oVar, z);
            } else if ("frs_page".equals(this.mPageType)) {
                b(1, oVar.aoE(), oVar, z);
            }
        }
    }

    public void RP() {
        if ("normal_page".equals(this.mPageType)) {
            gU(0);
        } else if ("frs_page".equals(this.mPageType)) {
            gV(0);
        }
    }

    public void gT(int i) {
        if ("normal_page".equals(this.mPageType)) {
            gU(i);
        } else if ("frs_page".equals(this.mPageType)) {
            gV(i);
        }
    }

    public void gU(int i) {
        if (this.bpw != null) {
            this.bpw.ha(i);
        }
    }

    public void gV(int i) {
        if (this.bpx != null) {
            this.bpx.ha(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (this.bpw != null) {
            this.bpw.c(forumData, oVar);
            if (forumData != null) {
                this.bpw.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.bpw.cC(false);
                }
            }
        }
    }

    public void b(int i, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar, boolean z) {
        if (this.bpx != null) {
            this.bpx.c(forumData, oVar);
            float a = a(forumData);
            if (forumData != null) {
                this.bpx.a(i, forumData.getLevelName(), forumData.getUser_level(), a, z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.bpx.cC(false);
                }
            }
        }
    }

    public boolean RQ() {
        if ("normal_page".equals(this.bpD) && this.bpw != null) {
            return this.bpw.Sl();
        }
        if ("frs_page".equals(this.bpD) && this.bpx != null) {
            return this.bpx.Sl();
        }
        return false;
    }

    public void RR() {
        if ("normal_page".equals(this.mPageType)) {
            RT();
        } else if ("frs_page".equals(this.mPageType)) {
            RV();
        }
    }

    public void RS() {
        if ("normal_page".equals(this.mPageType)) {
            RU();
        } else if ("frs_page".equals(this.mPageType)) {
            RW();
        }
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.bpB - this.bpC) {
                z = true;
                this.bpB = signData.getLevelUpScore();
            }
            this.bpC = bonusPoint + this.bpC;
            if (this.bpC > this.bpB) {
                this.bpC = this.bpB;
            }
            if (this.bpB != 0) {
                f = this.bpC / this.bpB;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.a(z, f);
        }
    }

    public void gW(int i) {
        if ("normal_page".equals(this.mPageType)) {
            gX(i);
        } else if ("frs_page".equals(this.mPageType)) {
            gY(i);
        }
    }

    public void e(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null && oVar.aoE() != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(oVar.aoE().getSignData(), oVar.aoE(), oVar);
            } else if ("frs_page".equals(this.mPageType)) {
                b(oVar.aoE().getSignData(), oVar.aoE(), oVar);
            }
        }
    }

    public void gX(int i) {
        if (this.bpw != null) {
            this.bpw.hb(i);
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (this.bpw != null && signData != null && forumData != null && oVar != null) {
            this.bpw.c(forumData, oVar);
            this.bpw.hb(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.bpw.Sl()) {
                a(this.bpw, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.bpC);
                    forumData.setLevelupScore(this.bpB);
                }
                this.bpw.c(forumData, oVar);
                this.bpw.f(this.bpw.Sr(), true);
            }
        }
    }

    public void gY(int i) {
        if (this.bpx != null) {
            this.bpx.hb(i);
        }
    }

    public void b(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (this.bpx != null && signData != null && forumData != null && oVar != null) {
            this.bpx.c(forumData, oVar);
            this.bpx.hb(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.bpx.Sl()) {
                a(this.bpx, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.bpC);
                    forumData.setLevelupScore(this.bpB);
                }
                this.bpx.c(forumData, oVar);
                this.bpx.f(this.bpx.Sr(), true);
            }
        }
    }

    public void RT() {
        if (this.bpw != null) {
            this.bpw.Ss().setVisibility(0);
        }
    }

    public void RU() {
        if (this.bpw != null) {
            this.bpw.Ss().setVisibility(8);
        }
    }

    public void RV() {
        if (this.bpx != null) {
            this.bpx.Ss().setVisibility(0);
        }
    }

    public void RW() {
        if (this.bpx != null) {
            this.bpx.Ss().setVisibility(8);
        }
    }

    public boolean RX() {
        if ("normal_page".equals(this.bpD) && this.bpw != null) {
            return this.bpw.RX();
        }
        if ("frs_page".equals(this.bpD) && this.bpx != null) {
            return this.bpx.RX();
        }
        return false;
    }

    public void V(View view) {
        if (this.bpw != null) {
            this.bpw.f(view, false);
        }
    }

    public void W(View view) {
        if (this.bpx != null) {
            this.bpx.f(view, false);
        }
    }

    public boolean RY() {
        if ("normal_page".equals(this.bpD)) {
            if (this.bpw != null) {
                return this.bpw.RY();
            }
        } else if ("frs_page".equals(this.bpD) && this.bpx != null) {
            return this.bpx.RY();
        }
        return false;
    }

    public BarImageView RZ() {
        com.baidu.tieba.frs.view.t RI;
        if ("normal_page".equals(this.mPageType)) {
            FrsHeaderView RH = RH();
            if (RH != null) {
                return RH.RZ();
            }
        } else if ("frs_page".equals(this.mPageType) && (RI = RI()) != null) {
            return RI.RZ();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void oN() {
        if (this.bot != null) {
            com.baidu.tieba.tbadkCore.o Pk = this.bot.Pk();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m411getInst().login(this.bot.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11002)));
            } else if (Pk != null && Pk.aoE() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.bot.getFrom())) {
                    TiebaStatic.log(new au("c10356").aa(ImageViewerConfig.FORUM_ID, Pk.aoE().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.bot.getFrom())) {
                    TiebaStatic.log(new au("c10590").r("obj_type", 2).aa(ImageViewerConfig.FORUM_ID, Pk.aoE().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.bot.getFrom())) {
                    TiebaStatic.log(new au("c10587").r("obj_type", 2).aa(ImageViewerConfig.FORUM_ID, Pk.aoE().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.bot.getFrom())) {
                    TiebaStatic.log(new au("c10578").r("obj_type", 2).aa(ImageViewerConfig.FORUM_ID, Pk.aoE().getId()));
                }
                this.MS.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.bot.getFrom())) {
                    TiebaStatic.eventStat(this.bot.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.bot.getFrom())) {
                    TiebaStatic.log(new au("c10359").aa(ImageViewerConfig.FORUM_ID, Pk.aoE().getId()));
                }
                this.MS.z(Pk.aoE().getName(), Pk.aoE().getId(), "FRS");
            }
        }
    }

    public void Pn() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.bot.Pk() != null && this.bot.Pk().aoE() != null && this.bot.Pk().aoE().getName() != null) {
            str = this.bot.Pk().aoE().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cE(String.format(getPageContext().getString(t.j.attention_cancel_dialog_content), str));
        } else {
            aVar.cE(getPageContext().getString(t.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(t.j.editor_dialog_yes), new g(this));
        aVar.b(getPageContext().getString(t.j.editor_dialog_no), new h(this));
        aVar.b(getPageContext()).uj();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void Sa() {
        com.baidu.tieba.tbadkCore.o Pk = this.bot.Pk();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.bot.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(t.j.login_to_use), true, 11014)));
        } else if (Pk != null && Pk.aoE() != null) {
            RR();
            this.bpH.au(Pk.aoE().getName(), Pk.aoE().getId());
        }
    }

    private void oM() {
        this.MS = new w(this.bot.getPageContext());
        this.MS.setLoadDataCallBack(new i(this));
    }

    private void Sb() {
        this.bpG = new ai();
        this.bpG.setFrom("from_frs");
        this.bpG.a(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, String str) {
        new k(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void q(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.o Pk;
        if (i > 0 && i2 > 0 && (Pk = this.bot.Pk()) != null && Pk.aoE() != null && Pk.getSignData() != null) {
            ForumData aoE = Pk.aoE();
            SignData signData = Pk.getSignData();
            signData.setLevelUpScore(aoE.getLevelupScore());
            signData.setBonusPoint(i3);
            signData.setMissSignNum(signData.getMissSignNum() - i2);
            signData.setCountSignNum(i);
            Pk.d(signData);
            signData.setForumId(aoE.getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            e(Pk);
            int i4 = -1;
            if (RY()) {
                i4 = aoE.getUser_level() + 1;
            }
            TbadkCoreApplication.m411getInst().addSignedForum(aoE.getName(), signData.getBonusPoint(), i4);
        }
    }

    private void Sc() {
        this.bpH = new fl(this.bot);
        this.bpH.setLoadDataCallBack(new c(this));
    }

    private void Rf() {
        if (this.bnG != null && !this.bpJ) {
            this.bpv.addHeaderView(this.bnG, Integer.valueOf(this.bpv.getHeaderViewsCount()), false);
            this.bpJ = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x01f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x003d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(com.baidu.tieba.tbadkCore.o oVar) {
        boolean z;
        boolean z2;
        URI uri;
        if (oVar != null && oVar.aLa() != null && oVar.aLa().size() != 0) {
            if (oVar.aKV() != null) {
                z = oVar.aKV().aKM() != 1;
            } else {
                z = false;
            }
            cA(z);
            f(oVar);
            this.bnI = new TabData();
            for (FrsTabInfo frsTabInfo : oVar.aLa()) {
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
                            sb.append(oVar.aoE().getId());
                            hVar.url = sb.toString();
                            if (!TextUtils.isEmpty(hVar.url)) {
                            }
                            hVar.boX = frsTabInfo.tab_id.intValue();
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
                                au auVar = new au("c10078");
                                auVar.aa("obj_type", host);
                                TiebaStatic.log(auVar);
                            }
                        }
                        hVar.boX = frsTabInfo.tab_id.intValue();
                        hVar.name = frsTabInfo.tab_name;
                        if (frsTabInfo.tab_id.intValue() == 1 && er.QA().gC(frsTabInfo.tab_id.intValue())) {
                            ep gz = eo.Qz().gz(hVar.boX);
                            if (gz != null && gz.bly != null && gz.bly.size() > 0) {
                                hVar.boY = new fn();
                                hVar.boY.blx = gz.blx;
                                hVar.boY.bly = new LinkedList();
                                boolean z3 = true;
                                for (en enVar : gz.bly) {
                                    if (enVar != null) {
                                        fm fmVar = new fm();
                                        fmVar.name = enVar.name;
                                        fmVar.blu = enVar.blu;
                                        if (z3) {
                                            fmVar.isSelected = true;
                                            z2 = false;
                                        } else {
                                            z2 = z3;
                                        }
                                        hVar.boY.bly.add(fmVar);
                                        z3 = z2;
                                    }
                                }
                            }
                            this.bnI.add(hVar);
                        } else if (frsTabInfo.tab_id.intValue() == 1) {
                            ep gz2 = eo.Qz().gz(hVar.boX);
                            if (gz2 != null && gz2.bly != null && gz2.bly.size() > 0) {
                                hVar.boY = new fn();
                                hVar.boY.blx = gz2.blx;
                                hVar.boY.bly = new LinkedList();
                                for (en enVar2 : gz2.bly) {
                                    if (enVar2 != null) {
                                        fm fmVar2 = new fm();
                                        fmVar2.name = enVar2.name;
                                        fmVar2.blu = enVar2.blu;
                                        hVar.boY.bly.add(fmVar2);
                                    }
                                }
                            }
                            this.bnI.add(hVar);
                        }
                    }
                }
            }
            this.bnG.setData(this.bnI);
            boolean z4 = !this.bpy.RD();
            boolean z5 = this.bpy.getVisibility() == 0;
            this.bpy.setData(this.bnI);
            if (z4 && !z5) {
                this.bpy.setVisibility(8);
            }
            if (!this.bpJ) {
                Rf();
            }
        }
    }

    private void f(com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar == null || oVar.aLg() == null || oVar.aLg().size() == 0) {
            eo.Qz().a(1, null);
            return;
        }
        List<CategoryInfo> aLg = oVar.aLg();
        ep epVar = new ep();
        epVar.blx = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < aLg.size()) {
                if (aLg.get(i2) != null) {
                    en enVar = new en();
                    enVar.blu = aLg.get(i2).category_id.intValue();
                    enVar.name = aLg.get(i2).category_name;
                    arrayList.add(enVar);
                }
                i = i2 + 1;
            } else {
                epVar.bly = arrayList;
                eo.Qz().a(1, epVar);
                return;
            }
        }
    }

    private void cA(boolean z) {
        ep epVar = new ep();
        epVar.blx = 0;
        ArrayList arrayList = new ArrayList();
        en enVar = new en();
        enVar.blu = 2;
        enVar.name = this.bot.getResources().getString(t.j.frsgroup_hot);
        arrayList.add(enVar);
        en enVar2 = new en();
        enVar2.blu = 3;
        enVar2.name = this.bot.getResources().getString(t.j.frsgroup_official);
        arrayList.add(enVar2);
        if (z) {
            en enVar3 = new en();
            enVar3.blu = 1;
            enVar3.name = this.bot.getResources().getString(t.j.frsgroup_recommend);
            arrayList.add(0, enVar3);
        }
        epVar.bly = arrayList;
        eo.Qz().a(4, epVar);
    }

    public void a(fe feVar) {
        if (this.bnG != null) {
            this.bnG.setDataLoadInterface(this.bpL);
        }
        this.bpM = feVar;
    }

    public boolean Sd() {
        return this.bpy.getVisibility() == 0;
    }

    private int Se() {
        if (this.mPageType == "normal_page") {
            if (this.bpw.Sn() != null && this.bpw.Sn().getParent() != null) {
                return this.bpv.getHeaderViewsCount() - 2;
            }
            return this.bpv.getHeaderViewsCount() - 1;
        } else if (this.mPageType == "frs_page") {
            if (this.bpx.Sn() != null && this.bpx.Sn().getParent() != null) {
                return this.bpv.getHeaderViewsCount() - 2;
            }
            return this.bpv.getHeaderViewsCount() - 1;
        } else {
            return 0;
        }
    }

    public boolean Sf() {
        return this.bpK;
    }
}
