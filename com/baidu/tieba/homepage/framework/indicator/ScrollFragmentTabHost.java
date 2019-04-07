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
    private CustomViewPager bHO;
    private final e cAN;
    private View cKM;
    private NoNetworkView dbq;
    private View dcF;
    private AlphaAnimation dcI;
    private AlphaAnimation dcJ;
    private PluginErrorTipView eCf;
    private List<a> eDc;
    private x fJC;
    private ObservedChangeLinearLayout fJD;
    private View fJE;
    private HomeTabBarView fJF;
    private View fJG;
    private boolean fJH;
    private NewScrollFragmentAdapter fJI;
    private b fJJ;
    private d fJK;
    private boolean fJL;
    public CustomMessageListener fJM;
    public CustomMessageListener fJN;
    CustomMessageListener fJO;
    private com.baidu.tieba.homepage.framework.indicator.b fJP;
    private com.baidu.tieba.homepage.framework.e fJQ;
    private com.baidu.tieba.homepage.framework.d fJR;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void sx(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.cAN = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void b(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.fJI != null) {
                    ScrollFragmentTabHost.this.fJI.c(view, i, i2, i3, i4);
                }
            }
        };
        this.fJM = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.fJD != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.fJD.animate().translationY(-ScrollFragmentTabHost.this.fJD.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.fJD.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.fJN = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.fJI != null) {
                    ScrollFragmentTabHost.this.fJI.blU();
                }
                if (ScrollFragmentTabHost.this.fJF != null) {
                    ScrollFragmentTabHost.this.fJF.notifyDataSetChanged();
                }
            }
        };
        this.fJO = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aBB();
                } else {
                    ScrollFragmentTabHost.this.aBC();
                }
            }
        };
        this.fJP = new com.baidu.tieba.homepage.framework.indicator.b();
        this.fJQ = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void sn(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.fJI.sp(i), false);
                ScrollFragmentTabHost.this.fJI.sr(i);
            }
        };
        this.fJR = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void sm(int i) {
                ScrollFragmentTabHost.this.fJP.a(i, ScrollFragmentTabHost.this.fJQ);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cAN = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void b(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.fJI != null) {
                    ScrollFragmentTabHost.this.fJI.c(view, i, i2, i3, i4);
                }
            }
        };
        this.fJM = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.fJD != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.fJD.animate().translationY(-ScrollFragmentTabHost.this.fJD.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.fJD.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.fJN = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.fJI != null) {
                    ScrollFragmentTabHost.this.fJI.blU();
                }
                if (ScrollFragmentTabHost.this.fJF != null) {
                    ScrollFragmentTabHost.this.fJF.notifyDataSetChanged();
                }
            }
        };
        this.fJO = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aBB();
                } else {
                    ScrollFragmentTabHost.this.aBC();
                }
            }
        };
        this.fJP = new com.baidu.tieba.homepage.framework.indicator.b();
        this.fJQ = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void sn(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.fJI.sp(i), false);
                ScrollFragmentTabHost.this.fJI.sr(i);
            }
        };
        this.fJR = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void sm(int i) {
                ScrollFragmentTabHost.this.fJP.a(i, ScrollFragmentTabHost.this.fJQ);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.fJD = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.fJE = findViewById(d.g.home_page_statebar_view);
        this.fJF = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.eCf = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.dbq = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.bHO = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.fJG = findViewById(d.g.home_statebar_view);
        this.cKM = findViewById(d.g.divider_line);
        this.dcF = findViewById(d.g.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fJE.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.fJD.setOnSizeChangeListener(this.cAN);
        this.fJF.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.fJI.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.fJJ != null) {
                    ScrollFragmentTabHost.this.fJJ.sx(i);
                }
                com.baidu.tbadk.core.bigday.b.WJ().dh(ScrollFragmentTabHost.this.fJI.so(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.sw(i) == 3) {
                    am amVar = new am("c12478");
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(amVar);
                }
                if (ScrollFragmentTabHost.this.sw(i) == 4) {
                    TiebaStatic.log(new am("c13172").T("obj_type", ScrollFragmentTabHost.this.fJL ? 2 : 1));
                    ScrollFragmentTabHost.this.fJL = false;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || (i == 1 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.sw(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.eDc != null && ScrollFragmentTabHost.this.fJI != null) {
                    int so = ScrollFragmentTabHost.this.fJI.so(ScrollFragmentTabHost.this.bHO.getCurrentItem());
                    if (so == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.eDc) {
                            aVar.bmi();
                        }
                    } else if (so == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.eDc) {
                            aVar2.bmh();
                        }
                    } else if (so == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.aBC();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.bme();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.sw(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean blZ = ScrollFragmentTabHost.this.blZ();
                    TiebaStatic.log(new am("c12350").T("obj_type", blZ ? 1 : 0));
                    if (blZ && ScrollFragmentTabHost.this.fJI != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.fJI.blX();
                        ScrollFragmentTabHost.this.fJI.notifyDataSetChanged();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.fJF.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void r(View view, int i) {
                if (ScrollFragmentTabHost.this.bHO.getCurrentItem() != i && ScrollFragmentTabHost.this.sw(i) == 4) {
                    ScrollFragmentTabHost.this.fJL = true;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || (i == 1 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.bHO.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.sw(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.sw(i));
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.dbq.a(aVar);
        MessageManager.getInstance().registerListener(this.fJM);
        MessageManager.getInstance().registerListener(this.fJN);
        MessageManager.getInstance().registerListener(this.fJO);
    }

    public void notifyDataSetChanged() {
        if (this.fJI != null && !HomePageStatic.fFz) {
            this.bHO.setAdapter(this.fJI);
            this.fJF.notifyDataSetChanged();
            this.fJP.a(this.fJQ);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.fJI != null) {
            this.fJI.c(dataRes, z, z2);
        }
    }

    public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.fJI != null) {
            this.fJI.c(dataRes, z);
        }
    }

    public void blW() {
        if (this.fJI != null) {
            this.fJI.blW();
        }
    }

    public void v(String str, int i, int i2) {
        if (this.bHO != null) {
            this.fJI.v(str, i, i2);
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
        this.fJI = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.fJI.setScrollFragmentTabHost(this);
        this.bHO.setOffscreenPageLimit(2);
        this.bHO.setAdapter(this.fJI);
        int blT = this.fJI.blT();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.fJI;
            if (HomePageStatic.fFz) {
                i = 0;
            }
            this.bHO.setCurrentItem(newScrollFragmentAdapter.sp(i));
            this.fJF.setViewPager(this.bHO);
            this.fJF.setConcernTabIndex(this.fJI.sp(0));
            if (this.fJC != null) {
                this.fJI.setRecommendFrsNavigationAnimDispatcher(this.fJC);
            }
            bme();
        }
        i = blT;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.fJI;
        if (HomePageStatic.fFz) {
        }
        this.bHO.setCurrentItem(newScrollFragmentAdapter2.sp(i));
        this.fJF.setViewPager(this.bHO);
        this.fJF.setConcernTabIndex(this.fJI.sp(0));
        if (this.fJC != null) {
        }
        bme();
    }

    public boolean bmc() {
        return this.fJI != null && this.fJI.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.fJI.getCount()) {
            this.fJF.setTabItemClicked(z);
            this.fJI.ss(i);
            this.bHO.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.fJI.sp(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fJF.setPageUniqueId(bdUniqueId);
        this.fJM.setTag(bdUniqueId);
        this.fJN.setTag(bdUniqueId);
        this.fJO.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.fJI.so(this.bHO.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.bHO.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.fJI.so(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int sw(int i) {
        return this.fJI.so(i);
    }

    public void onChangeSkinType(int i) {
        al.l(this.fJE, d.C0277d.cp_bg_line_d);
        this.fJF.onChangeSkinType();
        if (this.mPageContext != null && this.dbq != null) {
            this.dbq.onChangeSkinType(this.mPageContext, i);
        }
        if (this.fJI != null) {
            this.fJI.ii(i);
        }
        if (this.mPageContext != null && this.eCf != null) {
            this.eCf.onChangeSkinType(this.mPageContext, i);
        }
        al.l(this.fJG, d.C0277d.cp_bg_line_d);
        al.l(this.cKM, d.C0277d.cp_bg_line_c);
    }

    private boolean aBA() {
        return this.dcF.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.fJH = z;
        if (z) {
            if (this.cKM != null) {
                this.cKM.setVisibility(8);
            }
        } else if (this.cKM != null) {
            this.cKM.setVisibility(0);
        }
    }

    public void aBB() {
        if (this.fJH && !aBA()) {
            this.dcF.setVisibility(0);
            if (this.dcI == null) {
                this.dcI = new AlphaAnimation(0.0f, 1.0f);
                this.dcI.setFillAfter(true);
                this.dcI.setDuration(300L);
            }
            this.dcF.startAnimation(this.dcI);
        }
    }

    public void aBC() {
        if (this.fJH && aBA()) {
            if (this.dcJ == null) {
                this.dcJ = new AlphaAnimation(1.0f, 0.0f);
                this.dcJ.setFillAfter(true);
                this.dcJ.setDuration(300L);
                this.dcJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.dcF.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.dcF.startAnimation(this.dcJ);
        }
    }

    public void blY() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.fJI != null) {
            this.fJI.blY();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4 || currentTabType == 5 || currentTabType == 6) && this.fJI != null) {
            this.fJI.blY();
        }
    }

    public void aCq() {
        this.fJI.aCq();
    }

    public String getCurrentPageKey() {
        if (this.fJI != null) {
            return this.fJI.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.bHO != null) {
            return this.bHO.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.fJI != null) {
            this.fJI.setPrimary(z);
        }
        if (this.dbq != null && z) {
            this.dbq.setVisibility(j.kM() ? 8 : 0);
        }
    }

    public void bmd() {
        this.fJI.a(this.fJR);
    }

    public void setOnTabSelectedListener(b bVar) {
        this.fJJ = bVar;
    }

    public void onDestroy() {
        if (this.fJC != null) {
            this.fJC.onDestroy();
        }
        bmg();
    }

    public void bme() {
        int i = 1;
        if (this.fJI != null) {
            int so = this.fJI.so(this.bHO.getCurrentItem());
            if (so == 0) {
                i = 0;
            } else if (so != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.fJF != null && this.fJI.blV()) {
            this.fJF.setShowConcernRedTip(z);
        }
    }

    public boolean blZ() {
        if (this.fJF == null || !this.fJI.blV()) {
            return false;
        }
        return this.fJF.blZ();
    }

    public void setVideoThreadId(String str) {
        if (this.fJI != null) {
            this.fJI.setVideoThreadId(str);
        }
    }

    public void bmf() {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int sp = this.fJI != null ? this.fJI.sp(0) : 0;
            if (this.fJK == null) {
                this.fJK = new com.baidu.tieba.c.d(this.mPageContext, this.fJF.st(sp));
                this.fJK.oG(d.f.bg_tip_blue_up);
                this.fJK.oF(32);
                this.fJK.id(true);
                this.fJK.aa(true);
                this.fJK.setYOffset(l.h(this.mContext, d.e.ds16));
                this.fJK.oH(UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
            }
            this.fJK.s(this.mContext.getString(d.j.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void bmg() {
        if (this.fJK != null) {
            this.fJK.aSp();
        }
    }

    public void onResume() {
        if (this.fJF != null) {
            this.fJF.onResume();
        }
    }

    public void a(a aVar) {
        if (this.eDc == null) {
            this.eDc = new ArrayList();
        }
        this.eDc.add(aVar);
    }

    public void b(a aVar) {
        if (this.eDc != null && this.eDc.size() > 0) {
            this.eDc.remove(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void bmh() {
        }

        public void bmi() {
        }
    }
}
