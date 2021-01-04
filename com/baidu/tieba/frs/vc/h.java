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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.base.d<BaseFragmentActivity> {
    private FrsFragment jDI;
    private com.baidu.tieba.frs.view.b jJC;
    private com.baidu.tieba.frs.entelechy.a.a jJD;
    private boolean jJE;
    private String jJF;
    private boolean jJG;
    private int jJH;
    private com.baidu.tieba.f.a jJI;
    private FrsTabViewController jJJ;
    private g jJK;
    private f jJL;
    private final Runnable jJM;
    private final Runnable jJN;
    private BdUniqueId jJu;
    private final View.OnClickListener jhV;
    private FrsHeaderViewContainer jin;
    private Runnable mRefreshRunnable;
    private int mScrollState;
    private int mSkinType;

    public h(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.a.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.jJE = false;
        this.mSkinType = 0;
        this.jJF = "normal_page";
        this.mScrollState = 0;
        this.jJG = false;
        this.jJM = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.1
            @Override // java.lang.Runnable
            public void run() {
                q cEZ;
                if (h.this.jDI != null && h.this.mScrollState == 0 && (cEZ = h.this.jDI.cEZ()) != null && cEZ.cGf() != null && !cEZ.cGf().cNA() && !cEZ.cFF() && h.this.jin.isShown() && h.this.jDI.isPrimary() && !h.this.jJG && h.this.jDI.cFM() && h.this.jJH == 1 && h.this.cNQ() && h.this.jJC != null && h.this.jJC.cOY()) {
                    TbadkSettings.getInst().saveBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), true);
                    h.this.cIN();
                    h.this.jDI.jeV = true;
                    h.this.jJG = true;
                }
            }
        };
        this.jJN = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.jDI != null && h.this.mScrollState == 0 && !h.this.jDI.cEZ().cFF() && h.this.jin.isShown() && h.this.jDI.isPrimary()) {
                    h.this.cIO();
                }
            }
        };
        this.mRefreshRunnable = new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.jin != null) {
                    int childCount = h.this.jin.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(h.this.jin.getChildAt(i));
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
        this.jhV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.jDI != null) {
                    FrsViewData cFE = h.this.jDI.cFE();
                    if (cFE != null && cFE.getForum() != null && h.this.jJC != null && (view == h.this.jJC.cPa() || view == h.this.jJC.cPb() || view == h.this.jJC.cPc())) {
                        if (h.this.jDI != null && cFE.getForum() != null) {
                            TiebaStatic.log(new aq("c12046").dX("fid", cFE.getForum().getId()).an("obj_locate", h.this.jDI.cFH() ? 1 : 2));
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (cFE.getEntelechyTabInfo() != null && cFE.getEntelechyTabInfo().tab != null) {
                            for (int i = 0; i < cFE.getEntelechyTabInfo().tab.size(); i++) {
                                arrayList.add(cFE.getEntelechyTabInfo().tab.get(i).tab_name);
                            }
                        }
                        ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), cFE.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                        forumDetailActivityConfig.setForumTabs(arrayList);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumDetailActivityConfig));
                    }
                    int id = view.getId();
                    if (id == R.id.tv_love) {
                        if (!h.this.jDI.cFF()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jDI.showToast(R.string.neterror);
                            } else if (!bg.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                TiebaStatic.log(new aq("c10517").an("obj_locate", 1).dX("fid", h.this.jDI.getForumId()));
                            } else {
                                h.this.ru(true);
                                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    aq aqVar = new aq("c10048");
                                    aqVar.dX("fid", h.this.jDI.getForumId());
                                    aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(aqVar);
                                }
                            }
                        }
                    } else if (id == R.id.tv_sign) {
                        if (!h.this.jDI.cFF()) {
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                h.this.jDI.showToast(R.string.neterror);
                            } else if (bg.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                                if (!h.this.cNV()) {
                                    h.this.cNU();
                                    aq.BY("c13560").an("obj_type", 2).bwn();
                                } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(h.this.jDI.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(h.this.jDI.getForumId(), 0), RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN)));
                                }
                            }
                        }
                    } else if (id == R.id.frs_header_games) {
                        if (bg.checkUpIsLogin(h.this.mContext.getPageActivity()) && cFE != null && cFE.getGameUrl() != null) {
                            be.bwu().a((TbPageContext) h.this.getPageContext(), new String[]{cFE.getGameUrl()}, true);
                        }
                    } else if (id == R.id.frs_bawu_center) {
                        if (cFE != null && cFE.getUserData() != null && cFE.getUserData().isBawu()) {
                            String bawuCenterUrl = cFE.getBawuCenterUrl();
                            if (!at.isEmpty(bawuCenterUrl)) {
                                com.baidu.tbadk.browser.a.startWebActivity(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                                if (cFE.getForum() != null) {
                                    TiebaStatic.log(new aq("c10502").dX("fid", cFE.getForum().getId()).dX("uid", cFE.getUserData().getUserId()));
                                }
                            }
                        }
                    } else if (id == R.id.level_container) {
                        if (!h.this.jDI.cFF() && h.this.mScrollState == 0 && h.this.cNQ() && h.this.jJC != null) {
                            h.this.jJC.l(view, false);
                        }
                    } else if (id == R.id.frs_hot_rank_entry) {
                        if (cFE != null && cFE.getForum() != null && !TextUtils.isEmpty(cFE.getForum().getId())) {
                            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                            hotUserRankActivityConfig.setForumId(Long.valueOf(com.baidu.adp.lib.f.b.toLong(cFE.getForum().getId(), 0L)));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                            aq aqVar2 = new aq("c13666");
                            aqVar2.dX("fid", cFE.getForum().getId());
                            TiebaStatic.log(aqVar2);
                        }
                    } else if (id == R.id.frs_manager_info_layout) {
                        if (cFE != null && cFE.getForum() != null && !TextUtils.isEmpty(cFE.getForum().getId())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(cFE.getForum().getId()), cFE.getForum().getName())));
                        }
                    } else if (id == R.id.frs_manager_application_layout && bg.checkUpIsLogin(h.this.mContext.getPageActivity()) && cFE != null && cFE.getForum() != null && !TextUtils.isEmpty(cFE.getForum().getId())) {
                        be.bwu().b(h.this.jDI.getTbPageContext(), new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + cFE.getForum().getId()});
                    }
                }
            }
        };
        this.jDI = frsFragment;
        this.jJD = aVar;
        this.jin = frsHeaderViewContainer;
        this.jJu = BdUniqueId.gen();
        this.jJK = new g(this.jDI, this.jJu);
        this.jJL = new f(this.jDI);
        this.jJI = new com.baidu.tieba.f.a();
    }

    public void as(Bundle bundle) {
        if (this.jJK != null) {
            this.jJK.registerListener();
        }
        if (this.jJL != null) {
            this.jJL.aQX();
        }
        this.jJG = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.SPEED_ICON_SHOW + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void cLD() {
        if (this.jJC != null) {
            this.jJC.onDestory();
        }
        if (this.jJL != null) {
            this.jJL.cLD();
        }
        if (this.jJM != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jJM);
        }
        if (this.jJN != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jJN);
        }
    }

    public void bxw() {
        if (this.jJC != null) {
            this.jJC.onStop();
        }
        if (this.jin != null) {
            this.jin.removeCallbacks(this.mRefreshRunnable);
        }
    }

    public void ca(boolean z) {
        if (this.jJC != null) {
            this.jJC.ca(z);
        }
    }

    public boolean BT(int i) {
        this.mSkinType = i;
        if (this.jJC != null) {
            this.jJC.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void rx(boolean z) {
        if (z) {
            if (this.jJC != null) {
                this.jin.removeHeaderView(this.jJC.cOZ());
                this.jJE = false;
            }
        } else if (this.jJC != null && this.jJC.cOZ() != null && !this.jJE) {
            this.jin.addHeaderView(this.jJC.cOZ(), this.jin.getHeaderViewsCount());
            this.jJE = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            y(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean cNI() {
        return true;
    }

    private void y(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.jJF, str);
        this.jJH = i2;
        this.jJF = str;
        cNN();
        if (this.jJC == null || z) {
            this.jJC = this.jJD.a(str, this.jDI, i);
            this.jJC.changeSkinType(this.mSkinType);
            this.jJC.C(this.jhV);
        }
        if (this.jJK != null) {
            this.jJC.i(this.jJK);
        }
        if (this.jJL != null) {
            this.jJC.g(this.jJL);
        }
        this.jin.addHeaderView(this.jJC.getView());
        LJ(str);
        cNJ();
        cNK();
    }

    private void cNJ() {
        com.baidu.adp.lib.f.e.mB().postDelayed(this.jJM, 4000L);
    }

    public void cNK() {
        com.baidu.adp.lib.f.e.mB().postDelayed(this.jJN, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIN() {
        if (cNQ() && this.jJC != null) {
            this.jJC.cIN();
        }
    }

    public void cIO() {
        if (this.jJC != null) {
            this.jJC.cIO();
        }
    }

    public void cNL() {
        if (this.jJC != null) {
            this.jJC.cIP();
        }
    }

    public void cNM() {
        if (!this.jJE && this.jJC != null) {
            this.jin.addHeaderView(this.jJC.cOZ());
            this.jJE = true;
        }
    }

    private void cNN() {
        if (this.jJC != null) {
            this.jin.removeHeaderView(this.jJC.getView());
            this.jin.removeHeaderView(this.jJC.cOZ());
            cNO();
        }
        this.jJE = false;
    }

    private void cNO() {
        if (this.jJJ != null && this.jDI != null && this.jDI.getListView() != null) {
            this.jDI.getListView().removeHeaderView(this.jJJ.cOi());
        }
    }

    private void LJ(String str) {
        RelativeLayout cOi;
        if (this.jJJ != null && this.jDI != null && this.jDI.getListView() != null && (cOi = this.jJJ.cOi()) != null) {
            if ("brand_page".equals(str)) {
                this.jDI.getListView().removeHeaderView(cOi);
                return;
            }
            this.jDI.getListView().removeHeaderView(cOi);
            this.jDI.getListView().addHeaderView(cOi, 0);
        }
    }

    public void j(FrsViewData frsViewData) {
        if (frsViewData != null && cNQ()) {
            b(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.jJF)) {
                this.jJC.cIy();
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float f = f(forumData);
            if (this.jJC != null) {
                this.jJC.a(forumData, frsViewData);
                this.jJC.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), f, false);
                this.jJC.a(forumData.getSignData());
            }
        }
    }

    public void k(FrsViewData frsViewData) {
        if (frsViewData != null && this.jJC != null && cNQ()) {
            this.jJC.aJ(f(frsViewData.getForum()));
        }
    }

    private float f(ForumData forumData) {
        if (forumData == null || this.jJK == null) {
            return 0.0f;
        }
        return this.jJK.f(forumData);
    }

    public void BU(int i) {
        if (i > 1) {
            if (this.jJC != null) {
                this.jJC.rF(false);
            }
        } else if (this.jJC != null) {
            this.jJC.rF(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void cNP() {
        if (this.jin != null) {
            this.jin.removeCallbacks(this.mRefreshRunnable);
            this.jin.postDelayed(this.mRefreshRunnable, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cNQ() {
        return "frs_page".equals(this.jJF) || "normal_page".equals(this.jJF) || "book_page".equals(this.jJF) || "brand_page".equals(this.jJF);
    }

    public void q(Integer num) {
        setIsMem(num.intValue());
        if (cNQ()) {
            cNR();
        }
    }

    public void setIsMem(int i) {
        if (this.jJC != null) {
            this.jJC.setMemberType(i);
        }
    }

    public void cNR() {
        if (this.jJC != null) {
            this.jJC.cIS();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && cNQ()) {
            a(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void cNS() {
        if (cNQ()) {
            BW(0);
        }
    }

    public void BV(int i) {
        if (cNQ()) {
            BW(i);
        }
    }

    public void BW(int i) {
        if (this.jJC != null) {
            this.jJC.Ct(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.jJC != null) {
            this.jJC.a(forumData, frsViewData);
            if (forumData != null) {
                this.jJC.a(i, forumData.getLevelName(), forumData.getUser_level(), f(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.jJC.rw(false);
                }
            }
        }
    }

    public boolean cNT() {
        if (!cNQ() || this.jJC == null) {
            return false;
        }
        return this.jJC.cOX();
    }

    public void cNU() {
        if (this.jJK != null) {
            if (this.jJC != null) {
                this.jJK.u(this.jJC.cIJ(), this.jJC.getActivityId());
            } else {
                this.jJK.u(false, "");
            }
            if (this.jJC != null) {
                this.jJK.a(this.jJC.cIK());
            }
        }
    }

    public void T(int i, int i2, int i3) {
        if (this.jJK != null) {
            this.jJK.T(i, i2, i3);
        }
    }

    public void BX(int i) {
        if (cNQ() && this.jJC != null) {
            this.jJC.Cu(i);
        }
    }

    public void l(FrsViewData frsViewData) {
        if (cNQ() && this.jJK != null) {
            this.jJK.a(this.jJC, frsViewData);
        }
    }

    public boolean cNV() {
        if (!cNQ() || this.jJC == null) {
            return false;
        }
        return this.jJC.cNV();
    }

    public boolean cNW() {
        if (!cNQ() || this.jJC == null) {
            return false;
        }
        return this.jJC.cNW();
    }

    public void ru(boolean z) {
        if (this.jJL != null) {
            this.jJL.ru(z);
        }
    }

    public void cND() {
        if (this.jJL != null) {
            this.jJL.cND();
        }
    }

    public void LK(String str) {
        if (this.jDI.cEU() != null && this.jDI.cEU().cLZ() != null) {
            com.baidu.tieba.tbadkCore.e.dNY().bd(com.baidu.tieba.tbadkCore.e.dNY().f("1~" + str, this.jDI.cEU().cLZ().getSortType(), this.jDI.cEU().cLZ().getIsGood(), this.jDI.cEU().cLZ().getCategoryId()), false);
        }
    }

    public void cII() {
        if (this.jJC != null) {
            this.jJC.cII();
        }
    }

    public static boolean m(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().bpu(), true) || frsViewData.getBookInfo().bpu().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean n(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().dOl() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || x.isEmpty(frsViewData.getActivityHeadData().bps())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().getImgUrl(), true)))) ? false : true;
        }
        return false;
    }

    public void BY(int i) {
        if (this.jJC != null && this.jJC.cOZ() != null) {
            View findViewById = this.jJC.cOZ().findViewById(R.id.divider_bottom);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            this.jJC.cIP();
        }
    }

    public void cIQ() {
        this.jJC.cIQ();
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.jJI != null) {
            this.jJI.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.jJJ = frsTabViewController;
    }

    public f cNX() {
        return this.jJL;
    }
}
