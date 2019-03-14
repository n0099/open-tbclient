package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.layout.e;
import com.baidu.tieba.c.d;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private CustomViewPager bHM;
    private final e cAL;
    private View cKK;
    private NoNetworkView dbm;
    private View dcB;
    private AlphaAnimation dcE;
    private AlphaAnimation dcF;
    private PluginErrorTipView eCu;
    private List<a> eDr;
    private x fJO;
    private ObservedChangeLinearLayout fJP;
    private View fJQ;
    private HomeTabBarView fJR;
    private View fJS;
    private boolean fJT;
    private NewScrollFragmentAdapter fJU;
    private b fJV;
    private d fJW;
    private boolean fJX;
    public CustomMessageListener fJY;
    public CustomMessageListener fJZ;
    CustomMessageListener fKa;
    private com.baidu.tieba.homepage.framework.indicator.b fKb;
    private com.baidu.tieba.homepage.framework.e fKc;
    private com.baidu.tieba.homepage.framework.d fKd;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void sB(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.cAL = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void b(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.fJU != null) {
                    ScrollFragmentTabHost.this.fJU.c(view, i, i2, i3, i4);
                }
            }
        };
        this.fJY = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.fJP != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.fJP.animate().translationY(-ScrollFragmentTabHost.this.fJP.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.fJP.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.fJZ = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.fJU != null) {
                    ScrollFragmentTabHost.this.fJU.blX();
                }
                if (ScrollFragmentTabHost.this.fJR != null) {
                    ScrollFragmentTabHost.this.fJR.notifyDataSetChanged();
                }
            }
        };
        this.fKa = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aBE();
                } else {
                    ScrollFragmentTabHost.this.aBF();
                }
            }
        };
        this.fKb = new com.baidu.tieba.homepage.framework.indicator.b();
        this.fKc = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void sr(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.fJU.st(i), false);
                ScrollFragmentTabHost.this.fJU.sv(i);
            }
        };
        this.fKd = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void sq(int i) {
                ScrollFragmentTabHost.this.fKb.a(i, ScrollFragmentTabHost.this.fKc);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cAL = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void b(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.fJU != null) {
                    ScrollFragmentTabHost.this.fJU.c(view, i, i2, i3, i4);
                }
            }
        };
        this.fJY = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.fJP != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.fJP.animate().translationY(-ScrollFragmentTabHost.this.fJP.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.fJP.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.fJZ = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.fJU != null) {
                    ScrollFragmentTabHost.this.fJU.blX();
                }
                if (ScrollFragmentTabHost.this.fJR != null) {
                    ScrollFragmentTabHost.this.fJR.notifyDataSetChanged();
                }
            }
        };
        this.fKa = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aBE();
                } else {
                    ScrollFragmentTabHost.this.aBF();
                }
            }
        };
        this.fKb = new com.baidu.tieba.homepage.framework.indicator.b();
        this.fKc = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void sr(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.fJU.st(i), false);
                ScrollFragmentTabHost.this.fJU.sv(i);
            }
        };
        this.fKd = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void sq(int i) {
                ScrollFragmentTabHost.this.fKb.a(i, ScrollFragmentTabHost.this.fKc);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.fJP = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.fJQ = findViewById(d.g.home_page_statebar_view);
        this.fJR = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.eCu = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.dbm = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.bHM = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.fJS = findViewById(d.g.home_statebar_view);
        this.cKK = findViewById(d.g.divider_line);
        this.dcB = findViewById(d.g.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fJQ.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.fJP.setOnSizeChangeListener(this.cAL);
        this.fJR.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.fJU.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.fJV != null) {
                    ScrollFragmentTabHost.this.fJV.sB(i);
                }
                com.baidu.tbadk.core.bigday.b.WM().dh(ScrollFragmentTabHost.this.fJU.ss(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.sA(i) == 3) {
                    am amVar = new am("c12478");
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(amVar);
                }
                if (ScrollFragmentTabHost.this.sA(i) == 4) {
                    TiebaStatic.log(new am("c13172").T("obj_type", ScrollFragmentTabHost.this.fJX ? 2 : 1));
                    ScrollFragmentTabHost.this.fJX = false;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || (i == 1 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.sA(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.eDr != null && ScrollFragmentTabHost.this.fJU != null) {
                    int ss = ScrollFragmentTabHost.this.fJU.ss(ScrollFragmentTabHost.this.bHM.getCurrentItem());
                    if (ss == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.eDr) {
                            aVar.bml();
                        }
                    } else if (ss == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.eDr) {
                            aVar2.bmk();
                        }
                    } else if (ss == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.aBF();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.bmh();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.sA(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean bmc = ScrollFragmentTabHost.this.bmc();
                    TiebaStatic.log(new am("c12350").T("obj_type", bmc ? 1 : 0));
                    if (bmc && ScrollFragmentTabHost.this.fJU != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.fJU.bma();
                        ScrollFragmentTabHost.this.fJU.notifyDataSetChanged();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.fJR.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void r(View view, int i) {
                if (ScrollFragmentTabHost.this.bHM.getCurrentItem() != i && ScrollFragmentTabHost.this.sA(i) == 4) {
                    ScrollFragmentTabHost.this.fJX = true;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || (i == 1 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.bHM.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.sA(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.sA(i));
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.dbm.a(aVar);
        MessageManager.getInstance().registerListener(this.fJY);
        MessageManager.getInstance().registerListener(this.fJZ);
        MessageManager.getInstance().registerListener(this.fKa);
    }

    public void notifyDataSetChanged() {
        if (this.fJU != null && !HomePageStatic.fFL) {
            this.bHM.setAdapter(this.fJU);
            this.fJR.notifyDataSetChanged();
            this.fKb.a(this.fKc);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.fJU != null) {
            this.fJU.c(dataRes, z, z2);
        }
    }

    public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.fJU != null) {
            this.fJU.c(dataRes, z);
        }
    }

    public void blZ() {
        if (this.fJU != null) {
            this.fJU.blZ();
        }
    }

    public void v(String str, int i, int i2) {
        if (this.bHM != null) {
            this.fJU.v(str, i, i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0070, code lost:
        if (r3 != 1) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        int i = 1;
        this.fJU = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.fJU.setScrollFragmentTabHost(this);
        this.bHM.setOffscreenPageLimit(2);
        this.bHM.setAdapter(this.fJU);
        int blW = this.fJU.blW();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.fJU;
            if (HomePageStatic.fFL) {
                i = 0;
            }
            this.bHM.setCurrentItem(newScrollFragmentAdapter.st(i));
            this.fJR.setViewPager(this.bHM);
            this.fJR.setConcernTabIndex(this.fJU.st(0));
            if (this.fJO != null) {
                this.fJU.setRecommendFrsNavigationAnimDispatcher(this.fJO);
            }
            bmh();
        }
        i = blW;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.fJU;
        if (HomePageStatic.fFL) {
        }
        this.bHM.setCurrentItem(newScrollFragmentAdapter2.st(i));
        this.fJR.setViewPager(this.bHM);
        this.fJR.setConcernTabIndex(this.fJU.st(0));
        if (this.fJO != null) {
        }
        bmh();
    }

    public boolean bmf() {
        return this.fJU != null && this.fJU.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.fJU.getCount()) {
            this.fJR.setTabItemClicked(z);
            this.fJU.sw(i);
            this.bHM.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.fJU.st(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fJR.setPageUniqueId(bdUniqueId);
        this.fJY.setTag(bdUniqueId);
        this.fJZ.setTag(bdUniqueId);
        this.fKa.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.fJU.ss(this.bHM.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.bHM.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.fJU.ss(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int sA(int i) {
        return this.fJU.ss(i);
    }

    public void onChangeSkinType(int i) {
        al.l(this.fJQ, d.C0277d.cp_bg_line_d);
        this.fJR.onChangeSkinType();
        if (this.mPageContext != null && this.dbm != null) {
            this.dbm.onChangeSkinType(this.mPageContext, i);
        }
        if (this.fJU != null) {
            this.fJU.ij(i);
        }
        if (this.mPageContext != null && this.eCu != null) {
            this.eCu.onChangeSkinType(this.mPageContext, i);
        }
        al.l(this.fJS, d.C0277d.cp_bg_line_d);
        al.l(this.cKK, d.C0277d.cp_bg_line_c);
    }

    private boolean aBD() {
        return this.dcB.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.fJT = z;
        if (z) {
            if (this.cKK != null) {
                this.cKK.setVisibility(8);
            }
        } else if (this.cKK != null) {
            this.cKK.setVisibility(0);
        }
    }

    public void aBE() {
        if (this.fJT && !aBD()) {
            this.dcB.setVisibility(0);
            if (this.dcE == null) {
                this.dcE = new AlphaAnimation(0.0f, 1.0f);
                this.dcE.setFillAfter(true);
                this.dcE.setDuration(300L);
            }
            this.dcB.startAnimation(this.dcE);
        }
    }

    public void aBF() {
        if (this.fJT && aBD()) {
            if (this.dcF == null) {
                this.dcF = new AlphaAnimation(1.0f, 0.0f);
                this.dcF.setFillAfter(true);
                this.dcF.setDuration(300L);
                this.dcF.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.dcB.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.dcB.startAnimation(this.dcF);
        }
    }

    public void bmb() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.fJU != null) {
            this.fJU.bmb();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4 || currentTabType == 5 || currentTabType == 6) && this.fJU != null) {
            this.fJU.bmb();
        }
    }

    public void aCt() {
        this.fJU.aCt();
    }

    public String getCurrentPageKey() {
        if (this.fJU != null) {
            return this.fJU.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.bHM != null) {
            return this.bHM.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.fJU != null) {
            this.fJU.setPrimary(z);
        }
        if (this.dbm != null && z) {
            this.dbm.setVisibility(j.kM() ? 8 : 0);
        }
    }

    public void bmg() {
        this.fJU.a(this.fKd);
    }

    public void setOnTabSelectedListener(b bVar) {
        this.fJV = bVar;
    }

    public void onDestroy() {
        if (this.fJO != null) {
            this.fJO.onDestroy();
        }
        bmj();
    }

    public void bmh() {
        int i = 1;
        if (this.fJU != null) {
            int ss = this.fJU.ss(this.bHM.getCurrentItem());
            if (ss == 0) {
                i = 0;
            } else if (ss != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.fJR != null && this.fJU.blY()) {
            this.fJR.setShowConcernRedTip(z);
        }
    }

    public boolean bmc() {
        if (this.fJR == null || !this.fJU.blY()) {
            return false;
        }
        return this.fJR.bmc();
    }

    public void setVideoThreadId(String str) {
        if (this.fJU != null) {
            this.fJU.setVideoThreadId(str);
        }
    }

    public void bmi() {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int st = this.fJU != null ? this.fJU.st(0) : 0;
            if (this.fJW == null) {
                this.fJW = new com.baidu.tieba.c.d(this.mPageContext, this.fJR.sx(st));
                this.fJW.oK(d.f.bg_tip_blue_up);
                this.fJW.oJ(32);
                this.fJW.id(true);
                this.fJW.aa(true);
                this.fJW.setYOffset(l.h(this.mContext, d.e.ds16));
                this.fJW.oL(UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
            }
            this.fJW.s(this.mContext.getString(d.j.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void bmj() {
        if (this.fJW != null) {
            this.fJW.aSr();
        }
    }

    public void onResume() {
        if (this.fJR != null) {
            this.fJR.onResume();
        }
    }

    public void a(a aVar) {
        if (this.eDr == null) {
            this.eDr = new ArrayList();
        }
        this.eDr.add(aVar);
    }

    public void b(a aVar) {
        if (this.eDr != null && this.eDr.size() > 0) {
            this.eDr.remove(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void bmk() {
        }

        public void bml() {
        }
    }
}
