package com.baidu.tieba.frs.vc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.base.d<BaseFragmentActivity> {
    private FrsFragment jEV;
    private BdUniqueId jKG;
    private com.baidu.tieba.frs.view.b jKO;
    private com.baidu.tieba.frs.entelechy.a.a jKP;
    private boolean jKQ;
    private String jKR;
    private boolean jKS;
    private int jKT;
    private com.baidu.tieba.f.a jKU;
    private FrsTabViewController jKV;
    private g jKW;
    private f jKX;
    private final Runnable jKY;
    private final Runnable jKZ;
    private FrsHeaderViewContainer jjA;
    private final View.OnClickListener jjj;
    private Runnable mRefreshRunnable;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.a.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.jKQ = false;
        this.mSkinType = 0;
        this.jKR = "normal_page";
        this.mScrollState = 0;
        this.jKS = false;
        this.jKY = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                q cCB;
                if (h.this.jEV != null && h.this.mScrollState == 0 && (cCB = h.this.jEV.cCB()) != null && cCB.cDH() != null && !cCB.cDH().cLd() && !cCB.cDh() && h.this.jjA.isShown() && h.this.jEV.isPrimary() && !h.this.jKS && h.this.jEV.cDo() && h.this.jKT == 1 && h.this.cLu() && h.this.jKO != null && h.this.jKO.cNd()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.cGq();
                    h.this.jEV.jgi = true;
                    h.this.jKS = true;
                }
            }
        };
        this.jKZ = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.jEV != null && h.this.mScrollState == 0 && !h.this.jEV.cCB().cDh() && h.this.jjA.isShown() && h.this.jEV.isPrimary()) {
                    h.this.cGr();
                }
            }
        };
        this.mRefreshRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.jjA != null) {
                    int childCount = h.this.jjA.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.jjA.getChildAt(i));
                    }
                }
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.newwidget.ImageView.i) {
                        ((com.baidu.adp.newwidget.ImageView.i) view).refresh();
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        int childCount = viewGroup.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            refreshImage(viewGroup.getChildAt(i));
                        }
                    }
                }
            }
        };
        this.jjj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.jEV != null) {
                    FrsViewData cDg = h.this.jEV.cDg();
                    if (cDg != null && cDg.getForum() != null && h.this.jKO != null && (view == h.this.jKO.cNf() || view == h.this.jKO.cNg() || view == h.this.jKO.cNh())) {
                        if (h.this.jEV != null && cDg.getForum() != null) {
                            TiebaStatic.log(new ar("c12046").dR("fid", cDg.getForum().getId()).ap("obj_locate", h.this.jEV.cDj() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (cDg.getEntelechyTabInfo() != null && cDg.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < cDg.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(cDg.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), cDg.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.jEV.cDh()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jEV.showToast(R.string.neterror);
                            } else if (!bh.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new ar("c10517").ap("obj_locate", 1).dR("fid", h.this.jEV.getForumId()));
                            } else {
                                h.this.rA(true);
                                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    ar arVar = new ar("c10048");
                                    arVar.dR("fid", h.this.jEV.getForumId());
                                    arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(arVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.jEV.cDh()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jEV.showToast(R.string.neterror);
                            } else if (bh.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.cLz()) {
                                    h.this.cLy();
                                    ar.Bd("c13560").ap("obj_type", 2).bsO();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.jEV.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.jEV.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bh.checkUpIsLogin(h.this.mContext.getPageActivity()) && cDg != null && cDg.getGameUrl() != null) {
                            bf.bsV().a((TbPageContext) h.this.getPageContext(), new String[]{cDg.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (cDg != null && cDg.getUserData() != null && cDg.getUserData().isBawu()) {
                            String bawuCenterUrl = cDg.getBawuCenterUrl();
                            if (!au.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (cDg.getForum() != null) {
                                    TiebaStatic.log(new ar("c10502").dR("fid", cDg.getForum().getId()).dR("uid", cDg.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.jEV.cDh() && h.this.mScrollState == 0 && h.this.cLu() && h.this.jKO != null) {
                            h.this.jKO.l(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (cDg != null && cDg.getForum() != null && !TextUtils.isEmpty(cDg.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(cDg.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            ar arVar2 = new ar("c13666");
                            arVar2.dR("fid", cDg.getForum().getId());
                            TiebaStatic.log(arVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (cDg != null && cDg.getForum() != null && !TextUtils.isEmpty(cDg.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(cDg.getForum().getId()), cDg.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && bh.checkUpIsLogin(h.this.mContext.getPageActivity()) && cDg != null && cDg.getForum() != null && !TextUtils.isEmpty(cDg.getForum().getId())) {
                        bf.bsV().b(h.this.jEV.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + cDg.getForum().getId()});
                    }
                }
            }
        };
        this.jEV = frsFragment;
        this.jKP = aVar;
        this.jjA = frsHeaderViewContainer;
        this.jKG = BdUniqueId.gen();
        this.jKW = new g(this.jEV, this.jKG);
        this.jKX = new f(this.jEV);
        this.jKU = new com.baidu.tieba.f.a();
    }

    public void as(Bundle bundle) {
        if (this.jKW != null) {
            this.jKW.registerListener();
        }
        if (this.jKX != null) {
            this.jKX.aNx();
        }
        this.jKS = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void cJg() {
        if (this.jKO != null) {
            this.jKO.onDestory();
        }
        if (this.jKX != null) {
            this.jKX.cJg();
        }
        if (this.jKY != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jKY);
        }
        if (this.jKZ != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jKZ);
        }
    }

    public void btX() {
        if (this.jKO != null) {
            this.jKO.onStop();
        }
        if (this.jjA != null) {
            this.jjA.removeCallbacks(this.mRefreshRunnable);
        }
    }

    public void cb(boolean z) {
        if (this.jKO != null) {
            this.jKO.cb(z);
        }
    }

    public boolean Ax(int i) {
        this.mSkinType = i;
        if (this.jKO != null) {
            this.jKO.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void rD(boolean z) {
        if (z) {
            if (this.jKO != null) {
                this.jjA.removeHeaderView(this.jKO.cNe());
                this.jKQ = false;
            }
        } else if (this.jKO != null && this.jKO.cNe() != null && !this.jKQ) {
            this.jjA.addHeaderView(this.jKO.cNe(), this.jjA.getHeaderViewsCount());
            this.jKQ = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            y(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cLm() {
        return true;
    }

    private void y(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.jKR, str);
        this.jKT = i2;
        this.jKR = str;
        cLr();
        if (this.jKO == null || z) {
            this.jKO = this.jKP.a(str, this.jEV, i);
            this.jKO.changeSkinType(this.mSkinType);
            this.jKO.C(this.jjj);
        }
        if (this.jKW != null) {
            this.jKO.i(this.jKW);
        }
        if (this.jKX != null) {
            this.jKO.g(this.jKX);
        }
        this.jjA.addHeaderView(this.jKO.getView());
        Lk(str);
        cLn();
        cLo();
    }

    private void cLn() {
        com.baidu.adp.lib.f.e.mA().postDelayed(this.jKY, 4000L);
    }

    public void cLo() {
        com.baidu.adp.lib.f.e.mA().postDelayed(this.jKZ, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGq() {
        if (cLu() && this.jKO != null) {
            this.jKO.cGq();
        }
    }

    public void cGr() {
        if (this.jKO != null) {
            this.jKO.cGr();
        }
    }

    public void cLp() {
        if (this.jKO != null) {
            this.jKO.cGs();
        }
    }

    public void cLq() {
        if (!this.jKQ && this.jKO != null) {
            this.jjA.addHeaderView(this.jKO.cNe());
            this.jKQ = true;
        }
    }

    private void cLr() {
        if (this.jKO != null) {
            this.jjA.removeHeaderView(this.jKO.getView());
            this.jjA.removeHeaderView(this.jKO.cNe());
            cLs();
        }
        this.jKQ = false;
    }

    private void cLs() {
        if (this.jKV != null && this.jEV != null && this.jEV.getListView() != null) {
            this.jEV.getListView().removeHeaderView(this.jKV.cLM());
        }
    }

    private void Lk(String str) {
        RelativeLayout cLM;
        if (this.jKV != null && this.jEV != null && this.jEV.getListView() != null && (cLM = this.jKV.cLM()) != null) {
            if ("brand_page".equals(str)) {
                this.jEV.getListView().removeHeaderView(cLM);
                return;
            }
            this.jEV.getListView().removeHeaderView(cLM);
            this.jEV.getListView().addHeaderView(cLM, 0);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData != null && cLu()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.jKR)) {
                this.jKO.cGb();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float f = f(forumData);
            if (this.jKO != null) {
                this.jKO.a(forumData, frsViewData);
                this.jKO.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), f, false);
                this.jKO.a(forumData.getSignData());
            }
        }
    }

    public void k(FrsViewData frsViewData) {
        if (frsViewData != null && this.jKO != null && cLu()) {
            this.jKO.aM(f(frsViewData.getForum()));
        }
    }

    private float f(ForumData forumData) {
        if (forumData == null || this.jKW == null) {
            return 0.0f;
        }
        return this.jKW.f(forumData);
    }

    public void Ay(int i) {
        if (i > 1) {
            if (this.jKO != null) {
                this.jKO.rL(false);
            }
        } else if (this.jKO != null) {
            this.jKO.rL(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void cLt() {
        if (this.jjA != null) {
            this.jjA.removeCallbacks(this.mRefreshRunnable);
            this.jjA.postDelayed(this.mRefreshRunnable, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cLu() {
        return "frs_page".equals(this.jKR) || "normal_page".equals(this.jKR) || "book_page".equals(this.jKR) || "brand_page".equals(this.jKR);
    }

    public void q(Integer num) {
        setIsMem(num.intValue());
        if (cLu()) {
            cLv();
        }
    }

    public void setIsMem(int i) {
        if (this.jKO != null) {
            this.jKO.setMemberType(i);
        }
    }

    public void cLv() {
        if (this.jKO != null) {
            this.jKO.cGv();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && cLu()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void cLw() {
        if (cLu()) {
            AA(0);
        }
    }

    public void Az(int i) {
        if (cLu()) {
            AA(i);
        }
    }

    public void AA(int i) {
        if (this.jKO != null) {
            this.jKO.Bc(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.jKO != null) {
            this.jKO.a(forumData, frsViewData);
            if (forumData != null) {
                this.jKO.a(i, forumData.getLevelName(), forumData.getUser_level(), f(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.jKO.rC(false);
                }
            }
        }
    }

    public boolean cLx() {
        if (!cLu() || this.jKO == null) {
            return false;
        }
        return this.jKO.cNc();
    }

    public void cLy() {
        if (this.jKW != null) {
            if (this.jKO != null) {
                this.jKW.B(this.jKO.cGm(), this.jKO.getActivityId());
            } else {
                this.jKW.B(false, "");
            }
            if (this.jKO != null) {
                this.jKW.a(this.jKO.cGn());
            }
        }
    }

    public void T(int i, int i2, int i3) {
        if (this.jKW != null) {
            this.jKW.T(i, i2, i3);
        }
    }

    public void AB(int i) {
        if (cLu() && this.jKO != null) {
            this.jKO.Bd(i);
        }
    }

    public void l(FrsViewData frsViewData) {
        if (cLu() && this.jKW != null) {
            this.jKW.a(this.jKO, frsViewData);
        }
    }

    public boolean cLz() {
        if (!cLu() || this.jKO == null) {
            return false;
        }
        return this.jKO.cLz();
    }

    public boolean cLA() {
        if (!cLu() || this.jKO == null) {
            return false;
        }
        return this.jKO.cLA();
    }

    public void rA(boolean z) {
        if (this.jKX != null) {
            this.jKX.rA(z);
        }
    }

    public void cLh() {
        if (this.jKX != null) {
            this.jKX.cLh();
        }
    }

    public void Ll(String str) {
        if (this.jEV.cCw() != null && this.jEV.cCw().cJC() != null) {
            com.baidu.tieba.tbadkCore.e.dMA().bd(com.baidu.tieba.tbadkCore.e.dMA().f("1~" + str, this.jEV.cCw().cJC().getSortType(), this.jEV.cCw().cJC().getIsGood(), this.jEV.cCw().cJC().getCategoryId()), false);
        }
    }

    public void cGl() {
        if (this.jKO != null) {
            this.jKO.cGl();
        }
    }

    public static boolean m(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().blT(), true) || frsViewData.getBookInfo().blT().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean n(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().dMN() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || y.isEmpty(frsViewData.getActivityHeadData().blR())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().getImgUrl(), true)))) ? false : true;
        }
        return false;
    }

    public void AC(int i) {
        if (this.jKO != null && this.jKO.cNe() != null) {
            View findViewById = this.jKO.cNe().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.jKO.cGs();
        }
    }

    public void cGt() {
        this.jKO.cGt();
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.jKU != null) {
            this.jKU.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.jKV = frsTabViewController;
    }

    public f cLB() {
        return this.jKX;
    }
}
