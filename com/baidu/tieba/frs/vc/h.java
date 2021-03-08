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
    private FrsFragment jGE;
    private String jMA;
    private boolean jMB;
    private int jMC;
    private com.baidu.tieba.f.a jMD;
    private FrsTabViewController jME;
    private g jMF;
    private f jMG;
    private final Runnable jMH;
    private final Runnable jMI;
    private BdUniqueId jMp;
    private com.baidu.tieba.frs.view.b jMx;
    private com.baidu.tieba.frs.entelechy.a.a jMy;
    private boolean jMz;
    private final View.OnClickListener jkS;
    private FrsHeaderViewContainer jlj;
    private Runnable mRefreshRunnable;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.a.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.jMz = false;
        this.mSkinType = 0;
        this.jMA = "normal_page";
        this.mScrollState = 0;
        this.jMB = false;
        this.jMH = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                q cCH;
                if (h.this.jGE != null && h.this.mScrollState == 0 && (cCH = h.this.jGE.cCH()) != null && cCH.cDN() != null && !cCH.cDN().cLj() && !cCH.cDn() && h.this.jlj.isShown() && h.this.jGE.isPrimary() && !h.this.jMB && h.this.jGE.cDu() && h.this.jMC == 1 && h.this.cLA() && h.this.jMx != null && h.this.jMx.cNj()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.cGw();
                    h.this.jGE.jhR = true;
                    h.this.jMB = true;
                }
            }
        };
        this.jMI = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.jGE != null && h.this.mScrollState == 0 && !h.this.jGE.cCH().cDn() && h.this.jlj.isShown() && h.this.jGE.isPrimary()) {
                    h.this.cGx();
                }
            }
        };
        this.mRefreshRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.jlj != null) {
                    int childCount = h.this.jlj.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.jlj.getChildAt(i));
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
        this.jkS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.jGE != null) {
                    FrsViewData cDm = h.this.jGE.cDm();
                    if (cDm != null && cDm.getForum() != null && h.this.jMx != null && (view == h.this.jMx.cNl() || view == h.this.jMx.cNm() || view == h.this.jMx.cNn())) {
                        if (h.this.jGE != null && cDm.getForum() != null) {
                            TiebaStatic.log(new ar("c12046").dR("fid", cDm.getForum().getId()).aq("obj_locate", h.this.jGE.cDp() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (cDm.getEntelechyTabInfo() != null && cDm.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < cDm.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(cDm.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), cDm.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.jGE.cDn()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jGE.showToast(R.string.neterror);
                            } else if (!bh.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new ar("c10517").aq("obj_locate", 1).dR("fid", h.this.jGE.getForumId()));
                            } else {
                                h.this.rA(true);
                                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    ar arVar = new ar("c10048");
                                    arVar.dR("fid", h.this.jGE.getForumId());
                                    arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(arVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.jGE.cDn()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jGE.showToast(R.string.neterror);
                            } else if (bh.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.cLF()) {
                                    h.this.cLE();
                                    ar.Bk("c13560").aq("obj_type", 2).bsR();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.jGE.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.jGE.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bh.checkUpIsLogin(h.this.mContext.getPageActivity()) && cDm != null && cDm.getGameUrl() != null) {
                            bf.bsY().a((TbPageContext) h.this.getPageContext(), new String[]{cDm.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (cDm != null && cDm.getUserData() != null && cDm.getUserData().isBawu()) {
                            String bawuCenterUrl = cDm.getBawuCenterUrl();
                            if (!au.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (cDm.getForum() != null) {
                                    TiebaStatic.log(new ar("c10502").dR("fid", cDm.getForum().getId()).dR("uid", cDm.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.jGE.cDn() && h.this.mScrollState == 0 && h.this.cLA() && h.this.jMx != null) {
                            h.this.jMx.l(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (cDm != null && cDm.getForum() != null && !TextUtils.isEmpty(cDm.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(cDm.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            ar arVar2 = new ar("c13666");
                            arVar2.dR("fid", cDm.getForum().getId());
                            TiebaStatic.log(arVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (cDm != null && cDm.getForum() != null && !TextUtils.isEmpty(cDm.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(cDm.getForum().getId()), cDm.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && bh.checkUpIsLogin(h.this.mContext.getPageActivity()) && cDm != null && cDm.getForum() != null && !TextUtils.isEmpty(cDm.getForum().getId())) {
                        bf.bsY().b(h.this.jGE.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + cDm.getForum().getId()});
                    }
                }
            }
        };
        this.jGE = frsFragment;
        this.jMy = aVar;
        this.jlj = frsHeaderViewContainer;
        this.jMp = BdUniqueId.gen();
        this.jMF = new g(this.jGE, this.jMp);
        this.jMG = new f(this.jGE);
        this.jMD = new com.baidu.tieba.f.a();
    }

    public void as(Bundle bundle) {
        if (this.jMF != null) {
            this.jMF.registerListener();
        }
        if (this.jMG != null) {
            this.jMG.aNA();
        }
        this.jMB = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void cJm() {
        if (this.jMx != null) {
            this.jMx.onDestory();
        }
        if (this.jMG != null) {
            this.jMG.cJm();
        }
        if (this.jMH != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMH);
        }
        if (this.jMI != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMI);
        }
    }

    public void bua() {
        if (this.jMx != null) {
            this.jMx.onStop();
        }
        if (this.jlj != null) {
            this.jlj.removeCallbacks(this.mRefreshRunnable);
        }
    }

    public void cb(boolean z) {
        if (this.jMx != null) {
            this.jMx.cb(z);
        }
    }

    public boolean Ay(int i) {
        this.mSkinType = i;
        if (this.jMx != null) {
            this.jMx.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void rD(boolean z) {
        if (z) {
            if (this.jMx != null) {
                this.jlj.removeHeaderView(this.jMx.cNk());
                this.jMz = false;
            }
        } else if (this.jMx != null && this.jMx.cNk() != null && !this.jMz) {
            this.jlj.addHeaderView(this.jMx.cNk(), this.jlj.getHeaderViewsCount());
            this.jMz = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            y(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cLs() {
        return true;
    }

    private void y(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.jMA, str);
        this.jMC = i2;
        this.jMA = str;
        cLx();
        if (this.jMx == null || z) {
            this.jMx = this.jMy.a(str, this.jGE, i);
            this.jMx.changeSkinType(this.mSkinType);
            this.jMx.C(this.jkS);
        }
        if (this.jMF != null) {
            this.jMx.i(this.jMF);
        }
        if (this.jMG != null) {
            this.jMx.g(this.jMG);
        }
        this.jlj.addHeaderView(this.jMx.getView());
        Lt(str);
        cLt();
        cLu();
    }

    private void cLt() {
        com.baidu.adp.lib.f.e.mA().postDelayed(this.jMH, 4000L);
    }

    public void cLu() {
        com.baidu.adp.lib.f.e.mA().postDelayed(this.jMI, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGw() {
        if (cLA() && this.jMx != null) {
            this.jMx.cGw();
        }
    }

    public void cGx() {
        if (this.jMx != null) {
            this.jMx.cGx();
        }
    }

    public void cLv() {
        if (this.jMx != null) {
            this.jMx.cGy();
        }
    }

    public void cLw() {
        if (!this.jMz && this.jMx != null) {
            this.jlj.addHeaderView(this.jMx.cNk());
            this.jMz = true;
        }
    }

    private void cLx() {
        if (this.jMx != null) {
            this.jlj.removeHeaderView(this.jMx.getView());
            this.jlj.removeHeaderView(this.jMx.cNk());
            cLy();
        }
        this.jMz = false;
    }

    private void cLy() {
        if (this.jME != null && this.jGE != null && this.jGE.getListView() != null) {
            this.jGE.getListView().removeHeaderView(this.jME.cLS());
        }
    }

    private void Lt(String str) {
        RelativeLayout cLS;
        if (this.jME != null && this.jGE != null && this.jGE.getListView() != null && (cLS = this.jME.cLS()) != null) {
            if ("brand_page".equals(str)) {
                this.jGE.getListView().removeHeaderView(cLS);
                return;
            }
            this.jGE.getListView().removeHeaderView(cLS);
            this.jGE.getListView().addHeaderView(cLS, 0);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData != null && cLA()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.jMA)) {
                this.jMx.cGh();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float f = f(forumData);
            if (this.jMx != null) {
                this.jMx.a(forumData, frsViewData);
                this.jMx.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), f, false);
                this.jMx.a(forumData.getSignData());
            }
        }
    }

    public void k(FrsViewData frsViewData) {
        if (frsViewData != null && this.jMx != null && cLA()) {
            this.jMx.aQ(f(frsViewData.getForum()));
        }
    }

    private float f(ForumData forumData) {
        if (forumData == null || this.jMF == null) {
            return 0.0f;
        }
        return this.jMF.f(forumData);
    }

    public void Az(int i) {
        if (i > 1) {
            if (this.jMx != null) {
                this.jMx.rL(false);
            }
        } else if (this.jMx != null) {
            this.jMx.rL(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void cLz() {
        if (this.jlj != null) {
            this.jlj.removeCallbacks(this.mRefreshRunnable);
            this.jlj.postDelayed(this.mRefreshRunnable, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cLA() {
        return "frs_page".equals(this.jMA) || "normal_page".equals(this.jMA) || "book_page".equals(this.jMA) || "brand_page".equals(this.jMA);
    }

    public void q(Integer num) {
        setIsMem(num.intValue());
        if (cLA()) {
            cLB();
        }
    }

    public void setIsMem(int i) {
        if (this.jMx != null) {
            this.jMx.setMemberType(i);
        }
    }

    public void cLB() {
        if (this.jMx != null) {
            this.jMx.cGB();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && cLA()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void cLC() {
        if (cLA()) {
            AB(0);
        }
    }

    public void AA(int i) {
        if (cLA()) {
            AB(i);
        }
    }

    public void AB(int i) {
        if (this.jMx != null) {
            this.jMx.Bd(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.jMx != null) {
            this.jMx.a(forumData, frsViewData);
            if (forumData != null) {
                this.jMx.a(i, forumData.getLevelName(), forumData.getUser_level(), f(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.jMx.rC(false);
                }
            }
        }
    }

    public boolean cLD() {
        if (!cLA() || this.jMx == null) {
            return false;
        }
        return this.jMx.cNi();
    }

    public void cLE() {
        if (this.jMF != null) {
            if (this.jMx != null) {
                this.jMF.B(this.jMx.cGs(), this.jMx.getActivityId());
            } else {
                this.jMF.B(false, "");
            }
            if (this.jMx != null) {
                this.jMF.a(this.jMx.cGt());
            }
        }
    }

    public void T(int i, int i2, int i3) {
        if (this.jMF != null) {
            this.jMF.T(i, i2, i3);
        }
    }

    public void AC(int i) {
        if (cLA() && this.jMx != null) {
            this.jMx.Be(i);
        }
    }

    public void l(FrsViewData frsViewData) {
        if (cLA() && this.jMF != null) {
            this.jMF.a(this.jMx, frsViewData);
        }
    }

    public boolean cLF() {
        if (!cLA() || this.jMx == null) {
            return false;
        }
        return this.jMx.cLF();
    }

    public boolean cLG() {
        if (!cLA() || this.jMx == null) {
            return false;
        }
        return this.jMx.cLG();
    }

    public void rA(boolean z) {
        if (this.jMG != null) {
            this.jMG.rA(z);
        }
    }

    public void cLn() {
        if (this.jMG != null) {
            this.jMG.cLn();
        }
    }

    public void Lu(String str) {
        if (this.jGE.cCC() != null && this.jGE.cCC().cJI() != null) {
            com.baidu.tieba.tbadkCore.e.dMI().bd(com.baidu.tieba.tbadkCore.e.dMI().f("1~" + str, this.jGE.cCC().cJI().getSortType(), this.jGE.cCC().cJI().getIsGood(), this.jGE.cCC().cJI().getCategoryId()), false);
        }
    }

    public void cGr() {
        if (this.jMx != null) {
            this.jMx.cGr();
        }
    }

    public static boolean m(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().blV(), true) || frsViewData.getBookInfo().blV().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean n(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().dMV() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || y.isEmpty(frsViewData.getActivityHeadData().blT())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().getImgUrl(), true)))) ? false : true;
        }
        return false;
    }

    public void AD(int i) {
        if (this.jMx != null && this.jMx.cNk() != null) {
            View findViewById = this.jMx.cNk().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.jMx.cGy();
        }
    }

    public void cGz() {
        this.jMx.cGz();
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.jMD != null) {
            this.jMD.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.jME = frsTabViewController;
    }

    public f cLH() {
        return this.jMG;
    }
}
