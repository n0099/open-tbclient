package com.baidu.tieba.frs.b;

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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.ee;
import com.baidu.tieba.frs.eg;
import com.baidu.tieba.frs.eu;
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
    private x MB;
    private int aPS;
    private final View.OnClickListener bgT;
    private HorizontalTabView bkJ;
    private TabData bkL;
    private FrsActivity blE;
    private BdListView bmG;
    private FrsHeaderView bmH;
    private com.baidu.tieba.frs.view.q bmI;
    private HorizontalTabView bmJ;
    private com.baidu.tieba.frs.view.j bmK;
    private cd bmL;
    private int bmM;
    private int bmN;
    private String bmO;
    private Runnable bmP;
    private boolean bmQ;
    private aj bmR;
    private fb bmS;
    private o bmT;
    private boolean bmU;
    private boolean bmV;
    private eu bmW;
    private eu bmX;
    private HorizontalTabView.a bmY;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int Qa = Qa();
        if (this.bmJ.Pz() && i >= Qa) {
            this.bmJ.setVisibility(0);
            this.bkJ.setVisibility(4);
            return;
        }
        this.bmJ.setVisibility(8);
        this.bkJ.setVisibility(0);
    }

    public a(FrsActivity frsActivity, o oVar) {
        super(frsActivity.getPageContext());
        this.bmG = null;
        this.bmH = null;
        this.bmI = null;
        this.bkJ = null;
        this.bmJ = null;
        this.bmK = null;
        this.bmL = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.bmO = null;
        this.bmQ = false;
        this.MB = null;
        this.bmR = null;
        this.bmS = null;
        this.bmU = false;
        this.bmV = false;
        this.bmW = new b(this);
        this.bmY = new d(this);
        this.bgT = new e(this);
        this.blE = frsActivity;
        this.bmT = oVar;
    }

    public void d(Bundle bundle) {
        or();
        PX();
        PY();
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds90);
        this.bkJ = new HorizontalTabView(this.blE.getActivity(), dimensionPixelSize);
        this.bkJ.setAutoFillTabCount(4);
        this.bkJ.setmShowMenuCallBack(this.bmY);
        this.bmJ = new HorizontalTabView(this.blE.getActivity(), dimensionPixelSize);
        this.bmJ.setAutoFillTabCount(4);
        this.bmJ.clearAnimation();
        this.bmJ.setVisibility(8);
        this.bkJ.setFakeTab(this.bmJ);
        this.bmJ.setFakeTab(this.bkJ);
        this.bmT.J(this.bmJ);
        this.bmQ = TbadkSettings.getInst().loadBoolean(FrsActivity.bcV, false);
    }

    public void onActivityDestroy() {
        if (this.bmH != null) {
            this.bmH.onDestory();
        }
        if (this.bmI != null) {
            this.bmI.onDestory();
        }
        if (this.MB != null) {
            this.MB.OH();
        }
        if (this.bmS != null) {
            this.bmS.OH();
        }
        if (this.bmP != null) {
            this.blE.mHandler.removeCallbacks(this.bmP);
        }
    }

    public void onActivityStop() {
        if (this.bmH != null) {
            this.bmH.onStop();
        }
        if (this.bmI != null) {
            this.bmI.onStop();
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        if (this.bmI != null) {
            this.bmI.changeSkinType(i);
        }
        if (this.bmL != null) {
            this.bmL.notifyDataSetChanged();
        }
        if (this.bmK != null) {
            this.bmK.changeSkinType(i);
        }
        if (this.bmH != null) {
            this.bmH.changeSkinType(i);
        }
        if (this.bkJ != null) {
            this.bkJ.vR();
        }
        if (this.bmJ != null) {
            this.bmJ.vR();
            return true;
        }
        return true;
    }

    public FrsHeaderView PD() {
        return this.bmH;
    }

    public com.baidu.tieba.frs.view.q PE() {
        return this.bmI;
    }

    public void t(BdListView bdListView) {
        this.bmG = bdListView;
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
        if (pVar.aDW() != null && pVar.aDW().size() != 0) {
            z = true;
        }
        if ("frs_page".equals(str)) {
            if (pVar != null && pVar.getUserData() != null && pVar.akG() != null) {
                d(pVar.getUserData().getIsMem(), pVar.akG().isLike(), z);
            }
        } else if ("normal_page".equals(str)) {
            if (pVar != null && pVar.getUserData() != null && pVar.akG() != null) {
                c(pVar.getUserData().getIsMem(), pVar.akG().isLike(), z);
            }
        } else if ("good_page".equals(str) && pVar != null && pVar.akG() != null) {
            b(pVar.akG().getGood_classify(), this.blE.bdU);
        }
        c(pVar);
    }

    public void c(int i, int i2, boolean z) {
        this.aPS = i2;
        PG();
        this.bmO = "normal_page";
        if (this.bmH == null) {
            this.bmH = new FrsHeaderView(this.blE, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.bmH.changeSkinType(this.mSkinType);
            this.bmH.setCommonClickListener(this.bgT);
        }
        this.bmG.addHeaderView(this.bmH.getView());
        if (z) {
            Pc();
        }
        if (!this.bmV) {
            this.bmG.addHeaderView(this.bmH.Qj());
            this.bmV = true;
        }
        PH();
    }

    public void d(int i, int i2, boolean z) {
        this.aPS = i2;
        PG();
        this.bmO = "frs_page";
        gu(i);
        this.bmG.addHeaderView(this.bmI.getView());
        if (z) {
            Pc();
        }
        if (!this.bmV) {
            this.bmG.addHeaderView(this.bmI.Qj());
            this.bmV = true;
        }
        PH();
    }

    public void gu(int i) {
        if (this.bmI == null) {
            this.bmI = new com.baidu.tieba.frs.view.q(this.blE.getPageContext(), null, null, i);
            this.bmI.changeSkinType(this.mSkinType);
            this.bmI.setCommonClickListener(this.bgT);
        }
    }

    public void PF() {
        PG();
        this.bmO = "good_page";
        if (this.bmK == null) {
            this.bmK = new com.baidu.tieba.frs.view.j(getPageContext().getPageActivity());
            this.bmK.changeSkinType(this.mSkinType);
        }
        this.bmG.addHeaderView(this.bmK.getView());
    }

    private void PG() {
        if ("normal_page".equals(this.bmO) && this.bmH != null) {
            this.bmG.removeHeaderView(this.bmH.getView());
            this.bmG.removeHeaderView(this.bmH.Qj());
        } else if ("frs_page".equals(this.bmO) && this.bmI != null) {
            this.bmG.removeHeaderView(this.bmI.getView());
            this.bmG.removeHeaderView(this.bmI.Qj());
        } else if ("good_page".equals(this.bmO) && this.bmK != null) {
            this.bmG.removeHeaderView(this.bmK.getView());
        }
        this.bmV = false;
        if (this.bkJ != null) {
            this.bmG.removeHeaderView(this.bkJ);
            this.bmU = false;
        }
    }

    public void cz(boolean z) {
        if (z) {
            if (PD() != null) {
                PD().Qm();
            }
            if (PE() != null) {
                PE().Qm();
                return;
            }
            return;
        }
        if (PD() != null) {
            PD().Ql();
        }
        if (PE() != null) {
            PE().Ql();
        }
    }

    private void PH() {
        if (this.bmP == null) {
            this.bmP = new f(this);
        }
        this.blE.mHandler.postDelayed(this.bmP, 4000L);
    }

    public void d(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            if ("frs_page".equals(this.mPageType)) {
                a(pVar.akG(), pVar);
            } else if ("normal_page".equals(this.mPageType)) {
                b(pVar.akG(), pVar);
            }
            c(pVar);
        }
    }

    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (forumData != null && pVar != null) {
            float a = a(forumData);
            if (this.bmI != null) {
                this.bmI.c(forumData, pVar);
                this.bmI.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    this.bmI.gE(forumData.getSignData().getSigned());
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.bmI.cC(false);
                    }
                }
            }
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (forumData != null && pVar != null) {
            float a = a(forumData);
            if (this.bmH != null) {
                this.bmH.c(forumData, pVar);
                this.bmH.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
                if (forumData.getSignData() != null) {
                    if (forumData.getSignData().getForumRank() == -2) {
                        this.bmH.cC(false);
                        return;
                    }
                    this.bmH.cC(true);
                    this.bmH.gE(forumData.getSignData().getSigned());
                }
            }
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.bmM = forumData.getLevelupScore();
        this.bmN = forumData.getCurScore();
        if (this.bmM > 0) {
            return this.bmN / this.bmM;
        }
        return 0.0f;
    }

    public void b(ArrayList<com.baidu.tbadk.core.data.m> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        PF();
        if (arrayList != null) {
            if (this.bmL == null) {
                this.bmL = new cd(getPageContext().getPageActivity(), arrayList);
                this.bmK.a(this.bmL);
                this.bmK.b(onItemClickListener);
                return;
            }
            this.bmL.setData(arrayList);
            this.bmL.notifyDataSetChanged();
        }
    }

    public void fW(int i) {
        if (this.bmL != null) {
            this.bmL.fW(i);
        }
    }

    public void gv(int i) {
        if (i > 1) {
            if (this.bmH != null) {
                this.bmH.setIsFirstPage(false);
            }
            if (this.bmI != null) {
                this.bmI.setIsFirstPage(false);
                return;
            }
            return;
        }
        if (this.bmH != null) {
            this.bmH.setIsFirstPage(true);
        }
        if (this.bmI != null) {
            this.bmI.setIsFirstPage(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void b(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType)) {
            PK();
        } else if ("normal_page".equals(this.mPageType)) {
            PJ();
        }
    }

    public void setIsMem(int i) {
        if (this.bmH != null) {
            this.bmH.setMemberType(i);
        }
        if (this.bmI != null) {
            this.bmI.setMemberType(i);
        }
    }

    public void PI() {
        if ("normal_page".equals(this.bmO)) {
            if (this.bmH != null) {
                this.bmH.PI();
            }
        } else if ("frs_page".equals(this.bmO) && this.bmI != null) {
            this.bmI.PI();
        }
    }

    public void PJ() {
        if (this.bmH != null) {
            this.bmH.Qp();
        }
    }

    public void PK() {
        if (this.bmI != null) {
            this.bmI.Qp();
        }
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar, boolean z) {
        if (pVar != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(1, pVar.akG(), pVar, z);
            } else if ("frs_page".equals(this.mPageType)) {
                b(1, pVar.akG(), pVar, z);
            }
        }
    }

    public void PL() {
        if ("normal_page".equals(this.mPageType)) {
            gx(0);
        } else if ("frs_page".equals(this.mPageType)) {
            gy(0);
        }
    }

    public void gw(int i) {
        if ("normal_page".equals(this.mPageType)) {
            gx(i);
        } else if ("frs_page".equals(this.mPageType)) {
            gy(i);
        }
    }

    public void gx(int i) {
        if (this.bmH != null) {
            this.bmH.gD(i);
        }
    }

    public void gy(int i) {
        if (this.bmI != null) {
            this.bmI.gD(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar, boolean z) {
        if (this.bmH != null) {
            this.bmH.c(forumData, pVar);
            if (forumData != null) {
                this.bmH.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.bmH.cC(false);
                }
            }
        }
    }

    public void b(int i, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar, boolean z) {
        if (this.bmI != null) {
            this.bmI.c(forumData, pVar);
            float a = a(forumData);
            if (forumData != null) {
                this.bmI.a(i, forumData.getLevelName(), forumData.getUser_level(), a, z);
                if (forumData.getSignData() != null && forumData.getSignData().getForumRank() == -2) {
                    this.bmI.cC(false);
                }
            }
        }
    }

    public boolean PM() {
        if ("normal_page".equals(this.bmO) && this.bmH != null) {
            return this.bmH.Qh();
        }
        if ("frs_page".equals(this.bmO) && this.bmI != null) {
            return this.bmI.Qh();
        }
        return false;
    }

    public void PN() {
        if ("normal_page".equals(this.mPageType)) {
            PP();
        } else if ("frs_page".equals(this.mPageType)) {
            PR();
        }
    }

    public void PO() {
        if ("normal_page".equals(this.mPageType)) {
            PQ();
        } else if ("frs_page".equals(this.mPageType)) {
            PS();
        }
    }

    private void a(com.baidu.tieba.frs.view.a aVar, SignData signData) {
        if (aVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.bmM - this.bmN) {
                z = true;
                this.bmM = signData.getLevelUpScore();
            }
            this.bmN = bonusPoint + this.bmN;
            if (this.bmN > this.bmM) {
                this.bmN = this.bmM;
            }
            if (this.bmM != 0) {
                f = this.bmN / this.bmM;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            aVar.a(z, f);
        }
    }

    public void gz(int i) {
        if ("normal_page".equals(this.mPageType)) {
            gA(i);
        } else if ("frs_page".equals(this.mPageType)) {
            gB(i);
        }
    }

    public void e(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null && pVar.akG() != null) {
            if ("normal_page".equals(this.mPageType)) {
                a(pVar.akG().getSignData(), pVar.akG(), pVar);
            } else if ("frs_page".equals(this.mPageType)) {
                b(pVar.akG().getSignData(), pVar.akG(), pVar);
            }
        }
    }

    public void gA(int i) {
        if (this.bmH != null) {
            this.bmH.gE(i);
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (this.bmH != null && signData != null && forumData != null && pVar != null) {
            this.bmH.c(forumData, pVar);
            this.bmH.gE(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.bmH.Qh()) {
                a(this.bmH, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.bmN);
                    forumData.setLevelupScore(this.bmM);
                }
                this.bmH.c(forumData, pVar);
                this.bmH.e(this.bmH.Qn(), true);
            }
        }
    }

    public void gB(int i) {
        if (this.bmI != null) {
            this.bmI.gE(i);
        }
    }

    public void b(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (this.bmI != null && signData != null && forumData != null && pVar != null) {
            this.bmI.c(forumData, pVar);
            this.bmI.gE(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.bmI.Qh()) {
                a(this.bmI, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.bmN);
                    forumData.setLevelupScore(this.bmM);
                }
                this.bmI.c(forumData, pVar);
                this.bmI.e(this.bmI.Qn(), true);
            }
        }
    }

    public void PP() {
        if (this.bmH != null) {
            this.bmH.Qo().setVisibility(0);
        }
    }

    public void PQ() {
        if (this.bmH != null) {
            this.bmH.Qo().setVisibility(8);
        }
    }

    public void PR() {
        if (this.bmI != null) {
            this.bmI.Qo().setVisibility(0);
        }
    }

    public void PS() {
        if (this.bmI != null) {
            this.bmI.Qo().setVisibility(8);
        }
    }

    public boolean PT() {
        if ("normal_page".equals(this.bmO) && this.bmH != null) {
            return this.bmH.PT();
        }
        if ("frs_page".equals(this.bmO) && this.bmI != null) {
            return this.bmI.PT();
        }
        return false;
    }

    public void H(View view) {
        if (this.bmH != null) {
            this.bmH.e(view, false);
        }
    }

    public void I(View view) {
        if (this.bmI != null) {
            this.bmI.e(view, false);
        }
    }

    public boolean PU() {
        if ("normal_page".equals(this.bmO)) {
            if (this.bmH != null) {
                return this.bmH.PU();
            }
        } else if ("frs_page".equals(this.bmO) && this.bmI != null) {
            return this.bmI.PU();
        }
        return false;
    }

    public BarImageView PV() {
        com.baidu.tieba.frs.view.q PE;
        if ("normal_page".equals(this.mPageType)) {
            FrsHeaderView PD = PD();
            if (PD != null) {
                return PD.PV();
            }
        } else if ("frs_page".equals(this.mPageType) && (PE = PE()) != null) {
            return PE.PV();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void os() {
        if (this.blE != null) {
            com.baidu.tieba.tbadkCore.p Nn = this.blE.Nn();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.m411getInst().login(this.blE.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(n.j.login_to_use), true, 11002)));
            } else if (Nn != null && Nn.akG() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.blE.getFrom())) {
                    TiebaStatic.log(new av("c10356").aa(ImageViewerConfig.FORUM_ID, Nn.akG().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.blE.getFrom())) {
                    TiebaStatic.log(new av("c10590").r("obj_type", 2).aa(ImageViewerConfig.FORUM_ID, Nn.akG().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.blE.getFrom())) {
                    TiebaStatic.log(new av("c10587").r("obj_type", 2).aa(ImageViewerConfig.FORUM_ID, Nn.akG().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.blE.getFrom())) {
                    TiebaStatic.log(new av("c10578").r("obj_type", 2).aa(ImageViewerConfig.FORUM_ID, Nn.akG().getId()));
                }
                this.MB.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.blE.getFrom())) {
                    TiebaStatic.eventStat(this.blE.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.blE.getFrom())) {
                    TiebaStatic.log(new av("c10359").aa(ImageViewerConfig.FORUM_ID, Nn.akG().getId()));
                }
                this.MB.x(Nn.akG().getName(), Nn.akG().getId(), "FRS");
            }
        }
    }

    public void Nq() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.blE.Nn() != null && this.blE.Nn().akG() != null && this.blE.Nn().akG().getName() != null) {
            str = this.blE.Nn().akG().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.cF(String.format(getPageContext().getString(n.j.attention_cancel_dialog_content), str));
        } else {
            aVar.cF(getPageContext().getString(n.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(n.j.editor_dialog_yes), new g(this));
        aVar.b(getPageContext().getString(n.j.editor_dialog_no), new h(this));
        aVar.b(getPageContext()).tf();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void PW() {
        com.baidu.tieba.tbadkCore.p Nn = this.blE.Nn();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(this.blE.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(n.j.login_to_use), true, 11014)));
        } else if (Nn != null && Nn.akG() != null) {
            PN();
            this.bmS.au(Nn.akG().getName(), Nn.akG().getId());
        }
    }

    private void or() {
        this.MB = new x(this.blE.getPageContext());
        this.MB.setLoadDataCallBack(new i(this));
    }

    private void PX() {
        this.bmR = new aj();
        this.bmR.setFrom("from_frs");
        this.bmR.a(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, String str) {
        new k(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void r(int i, int i2, int i3) {
        com.baidu.tieba.tbadkCore.p Nn;
        if (i > 0 && i2 > 0 && (Nn = this.blE.Nn()) != null && Nn.akG() != null && Nn.getSignData() != null) {
            ForumData akG = Nn.akG();
            SignData signData = Nn.getSignData();
            signData.setLevelUpScore(akG.getLevelupScore());
            signData.setBonusPoint(i3);
            signData.setMissSignNum(signData.getMissSignNum() - i2);
            signData.setCountSignNum(i);
            Nn.d(signData);
            signData.setForumId(akG.getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE, signData));
            e(Nn);
            int i4 = -1;
            if (PU()) {
                i4 = akG.getUser_level() + 1;
            }
            TbadkCoreApplication.m411getInst().addSignedForum(akG.getName(), signData.getBonusPoint(), i4);
        }
    }

    private void PY() {
        this.bmS = new fb(this.blE);
        this.bmS.setLoadDataCallBack(new c(this));
    }

    private void Pc() {
        if (this.bkJ != null && !this.bmU) {
            this.bmG.addHeaderView(this.bkJ, Integer.valueOf(this.bmG.getHeaderViewsCount()), false);
            this.bmU = true;
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
        if (pVar != null && pVar.aDW() != null && pVar.aDW().size() != 0) {
            if (pVar.aDQ() != null) {
                z = pVar.aDQ().aDH() != 1;
            } else {
                z = false;
            }
            cA(z);
            f(pVar);
            this.bkL = new TabData();
            for (FrsTabInfo frsTabInfo : pVar.aDW()) {
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
                            sb.append(pVar.akG().getId());
                            hVar.url = sb.toString();
                            if (!TextUtils.isEmpty(hVar.url)) {
                            }
                            hVar.bmi = frsTabInfo.tab_id.intValue();
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
                                avVar.aa("obj_type", host);
                                TiebaStatic.log(avVar);
                            }
                        }
                        hVar.bmi = frsTabInfo.tab_id.intValue();
                        hVar.name = frsTabInfo.tab_name;
                        if (frsTabInfo.tab_id.intValue() == 1 && eg.Oy().gf(frsTabInfo.tab_id.intValue())) {
                            ee gc = ed.Ox().gc(hVar.bmi);
                            if (gc != null && gc.biD != null && gc.biD.size() > 0) {
                                hVar.bmj = new fd();
                                hVar.bmj.biC = gc.biC;
                                hVar.bmj.biD = new LinkedList();
                                boolean z3 = true;
                                for (ec ecVar : gc.biD) {
                                    if (ecVar != null) {
                                        fc fcVar = new fc();
                                        fcVar.name = ecVar.name;
                                        fcVar.biz = ecVar.biz;
                                        if (z3) {
                                            fcVar.isSelected = true;
                                            z2 = false;
                                        } else {
                                            z2 = z3;
                                        }
                                        hVar.bmj.biD.add(fcVar);
                                        z3 = z2;
                                    }
                                }
                            }
                            this.bkL.add(hVar);
                        } else if (frsTabInfo.tab_id.intValue() == 1) {
                            ee gc2 = ed.Ox().gc(hVar.bmi);
                            if (gc2 != null && gc2.biD != null && gc2.biD.size() > 0) {
                                hVar.bmj = new fd();
                                hVar.bmj.biC = gc2.biC;
                                hVar.bmj.biD = new LinkedList();
                                for (ec ecVar2 : gc2.biD) {
                                    if (ecVar2 != null) {
                                        fc fcVar2 = new fc();
                                        fcVar2.name = ecVar2.name;
                                        fcVar2.biz = ecVar2.biz;
                                        hVar.bmj.biD.add(fcVar2);
                                    }
                                }
                            }
                            this.bkL.add(hVar);
                        }
                    }
                }
            }
            this.bkJ.setData(this.bkL);
            boolean z4 = !this.bmJ.Pz();
            boolean z5 = this.bmJ.getVisibility() == 0;
            this.bmJ.setData(this.bkL);
            if (z4 && !z5) {
                this.bmJ.setVisibility(8);
            }
            if (!this.bmU) {
                Pc();
            }
        }
    }

    private void f(com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar == null || pVar.aEc() == null || pVar.aEc().size() == 0) {
            ed.Ox().a(1, null);
            return;
        }
        List<CategoryInfo> aEc = pVar.aEc();
        ee eeVar = new ee();
        eeVar.biC = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < aEc.size()) {
                if (aEc.get(i2) != null) {
                    ec ecVar = new ec();
                    ecVar.biz = aEc.get(i2).category_id.intValue();
                    ecVar.name = aEc.get(i2).category_name;
                    arrayList.add(ecVar);
                }
                i = i2 + 1;
            } else {
                eeVar.biD = arrayList;
                ed.Ox().a(1, eeVar);
                return;
            }
        }
    }

    private void cA(boolean z) {
        ee eeVar = new ee();
        eeVar.biC = 0;
        ArrayList arrayList = new ArrayList();
        ec ecVar = new ec();
        ecVar.biz = 2;
        ecVar.name = this.blE.getResources().getString(n.j.frsgroup_hot);
        arrayList.add(ecVar);
        ec ecVar2 = new ec();
        ecVar2.biz = 3;
        ecVar2.name = this.blE.getResources().getString(n.j.frsgroup_official);
        arrayList.add(ecVar2);
        if (z) {
            ec ecVar3 = new ec();
            ecVar3.biz = 1;
            ecVar3.name = this.blE.getResources().getString(n.j.frsgroup_recommend);
            arrayList.add(0, ecVar3);
        }
        eeVar.biD = arrayList;
        ed.Ox().a(4, eeVar);
    }

    public void a(eu euVar) {
        if (this.bkJ != null) {
            this.bkJ.setDataLoadInterface(this.bmW);
        }
        this.bmX = euVar;
    }

    public boolean PZ() {
        return this.bmJ.getVisibility() == 0;
    }

    private int Qa() {
        if (this.mPageType == "normal_page") {
            if (this.bmH.Qj() != null && this.bmH.Qj().getParent() != null) {
                return this.bmG.getHeaderViewsCount() - 2;
            }
            return this.bmG.getHeaderViewsCount() - 1;
        } else if (this.mPageType == "frs_page") {
            if (this.bmI.Qj() != null && this.bmI.Qj().getParent() != null) {
                return this.bmG.getHeaderViewsCount() - 2;
            }
            return this.bmG.getHeaderViewsCount() - 1;
        } else {
            return 0;
        }
    }

    public boolean Qb() {
        return this.bmV;
    }
}
