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
    private CustomViewPager bHL;
    private final e cAO;
    private View cKN;
    private NoNetworkView dbq;
    private View dcF;
    private AlphaAnimation dcI;
    private AlphaAnimation dcJ;
    private PluginErrorTipView eCy;
    private List<a> eDv;
    private x fJP;
    private ObservedChangeLinearLayout fJQ;
    private View fJR;
    private HomeTabBarView fJS;
    private View fJT;
    private boolean fJU;
    private NewScrollFragmentAdapter fJV;
    private b fJW;
    private d fJX;
    private boolean fJY;
    public CustomMessageListener fJZ;
    public CustomMessageListener fKa;
    CustomMessageListener fKb;
    private com.baidu.tieba.homepage.framework.indicator.b fKc;
    private com.baidu.tieba.homepage.framework.e fKd;
    private com.baidu.tieba.homepage.framework.d fKe;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void sB(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.cAO = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void b(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.fJV != null) {
                    ScrollFragmentTabHost.this.fJV.c(view, i, i2, i3, i4);
                }
            }
        };
        this.fJZ = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.fJQ != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.fJQ.animate().translationY(-ScrollFragmentTabHost.this.fJQ.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.fJQ.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.fKa = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.fJV != null) {
                    ScrollFragmentTabHost.this.fJV.blY();
                }
                if (ScrollFragmentTabHost.this.fJS != null) {
                    ScrollFragmentTabHost.this.fJS.notifyDataSetChanged();
                }
            }
        };
        this.fKb = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aBF();
                } else {
                    ScrollFragmentTabHost.this.aBG();
                }
            }
        };
        this.fKc = new com.baidu.tieba.homepage.framework.indicator.b();
        this.fKd = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void sr(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.fJV.st(i), false);
                ScrollFragmentTabHost.this.fJV.sv(i);
            }
        };
        this.fKe = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void sq(int i) {
                ScrollFragmentTabHost.this.fKc.a(i, ScrollFragmentTabHost.this.fKd);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cAO = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void b(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.fJV != null) {
                    ScrollFragmentTabHost.this.fJV.c(view, i, i2, i3, i4);
                }
            }
        };
        this.fJZ = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.fJQ != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.fJQ.animate().translationY(-ScrollFragmentTabHost.this.fJQ.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.fJQ.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.fKa = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.fJV != null) {
                    ScrollFragmentTabHost.this.fJV.blY();
                }
                if (ScrollFragmentTabHost.this.fJS != null) {
                    ScrollFragmentTabHost.this.fJS.notifyDataSetChanged();
                }
            }
        };
        this.fKb = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aBF();
                } else {
                    ScrollFragmentTabHost.this.aBG();
                }
            }
        };
        this.fKc = new com.baidu.tieba.homepage.framework.indicator.b();
        this.fKd = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void sr(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.fJV.st(i), false);
                ScrollFragmentTabHost.this.fJV.sv(i);
            }
        };
        this.fKe = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void sq(int i) {
                ScrollFragmentTabHost.this.fKc.a(i, ScrollFragmentTabHost.this.fKd);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.fJQ = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.fJR = findViewById(d.g.home_page_statebar_view);
        this.fJS = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.eCy = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.dbq = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.bHL = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.fJT = findViewById(d.g.home_statebar_view);
        this.cKN = findViewById(d.g.divider_line);
        this.dcF = findViewById(d.g.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fJR.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.fJQ.setOnSizeChangeListener(this.cAO);
        this.fJS.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.fJV.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.fJW != null) {
                    ScrollFragmentTabHost.this.fJW.sB(i);
                }
                com.baidu.tbadk.core.bigday.b.WM().dh(ScrollFragmentTabHost.this.fJV.ss(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.sA(i) == 3) {
                    am amVar = new am("c12478");
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(amVar);
                }
                if (ScrollFragmentTabHost.this.sA(i) == 4) {
                    TiebaStatic.log(new am("c13172").T("obj_type", ScrollFragmentTabHost.this.fJY ? 2 : 1));
                    ScrollFragmentTabHost.this.fJY = false;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || (i == 1 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.sA(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.eDv != null && ScrollFragmentTabHost.this.fJV != null) {
                    int ss = ScrollFragmentTabHost.this.fJV.ss(ScrollFragmentTabHost.this.bHL.getCurrentItem());
                    if (ss == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.eDv) {
                            aVar.bmm();
                        }
                    } else if (ss == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.eDv) {
                            aVar2.bml();
                        }
                    } else if (ss == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.aBG();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.bmi();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.sA(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean bmd = ScrollFragmentTabHost.this.bmd();
                    TiebaStatic.log(new am("c12350").T("obj_type", bmd ? 1 : 0));
                    if (bmd && ScrollFragmentTabHost.this.fJV != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.fJV.bmb();
                        ScrollFragmentTabHost.this.fJV.notifyDataSetChanged();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.fJS.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void r(View view, int i) {
                if (ScrollFragmentTabHost.this.bHL.getCurrentItem() != i && ScrollFragmentTabHost.this.sA(i) == 4) {
                    ScrollFragmentTabHost.this.fJY = true;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || (i == 1 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.bHL.getCurrentItem() != i) {
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
        this.dbq.a(aVar);
        MessageManager.getInstance().registerListener(this.fJZ);
        MessageManager.getInstance().registerListener(this.fKa);
        MessageManager.getInstance().registerListener(this.fKb);
    }

    public void notifyDataSetChanged() {
        if (this.fJV != null && !HomePageStatic.fFM) {
            this.bHL.setAdapter(this.fJV);
            this.fJS.notifyDataSetChanged();
            this.fKc.a(this.fKd);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.fJV != null) {
            this.fJV.c(dataRes, z, z2);
        }
    }

    public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.fJV != null) {
            this.fJV.c(dataRes, z);
        }
    }

    public void bma() {
        if (this.fJV != null) {
            this.fJV.bma();
        }
    }

    public void v(String str, int i, int i2) {
        if (this.bHL != null) {
            this.fJV.v(str, i, i2);
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
        this.fJV = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.fJV.setScrollFragmentTabHost(this);
        this.bHL.setOffscreenPageLimit(2);
        this.bHL.setAdapter(this.fJV);
        int blX = this.fJV.blX();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.fJV;
            if (HomePageStatic.fFM) {
                i = 0;
            }
            this.bHL.setCurrentItem(newScrollFragmentAdapter.st(i));
            this.fJS.setViewPager(this.bHL);
            this.fJS.setConcernTabIndex(this.fJV.st(0));
            if (this.fJP != null) {
                this.fJV.setRecommendFrsNavigationAnimDispatcher(this.fJP);
            }
            bmi();
        }
        i = blX;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.fJV;
        if (HomePageStatic.fFM) {
        }
        this.bHL.setCurrentItem(newScrollFragmentAdapter2.st(i));
        this.fJS.setViewPager(this.bHL);
        this.fJS.setConcernTabIndex(this.fJV.st(0));
        if (this.fJP != null) {
        }
        bmi();
    }

    public boolean bmg() {
        return this.fJV != null && this.fJV.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.fJV.getCount()) {
            this.fJS.setTabItemClicked(z);
            this.fJV.sw(i);
            this.bHL.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.fJV.st(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fJS.setPageUniqueId(bdUniqueId);
        this.fJZ.setTag(bdUniqueId);
        this.fKa.setTag(bdUniqueId);
        this.fKb.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.fJV.ss(this.bHL.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.bHL.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.fJV.ss(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int sA(int i) {
        return this.fJV.ss(i);
    }

    public void onChangeSkinType(int i) {
        al.l(this.fJR, d.C0236d.cp_bg_line_d);
        this.fJS.onChangeSkinType();
        if (this.mPageContext != null && this.dbq != null) {
            this.dbq.onChangeSkinType(this.mPageContext, i);
        }
        if (this.fJV != null) {
            this.fJV.ij(i);
        }
        if (this.mPageContext != null && this.eCy != null) {
            this.eCy.onChangeSkinType(this.mPageContext, i);
        }
        al.l(this.fJT, d.C0236d.cp_bg_line_d);
        al.l(this.cKN, d.C0236d.cp_bg_line_c);
    }

    private boolean aBE() {
        return this.dcF.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.fJU = z;
        if (z) {
            if (this.cKN != null) {
                this.cKN.setVisibility(8);
            }
        } else if (this.cKN != null) {
            this.cKN.setVisibility(0);
        }
    }

    public void aBF() {
        if (this.fJU && !aBE()) {
            this.dcF.setVisibility(0);
            if (this.dcI == null) {
                this.dcI = new AlphaAnimation(0.0f, 1.0f);
                this.dcI.setFillAfter(true);
                this.dcI.setDuration(300L);
            }
            this.dcF.startAnimation(this.dcI);
        }
    }

    public void aBG() {
        if (this.fJU && aBE()) {
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

    public void bmc() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.fJV != null) {
            this.fJV.bmc();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4 || currentTabType == 5 || currentTabType == 6) && this.fJV != null) {
            this.fJV.bmc();
        }
    }

    public void aCu() {
        this.fJV.aCu();
    }

    public String getCurrentPageKey() {
        if (this.fJV != null) {
            return this.fJV.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.bHL != null) {
            return this.bHL.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.fJV != null) {
            this.fJV.setPrimary(z);
        }
        if (this.dbq != null && z) {
            this.dbq.setVisibility(j.kM() ? 8 : 0);
        }
    }

    public void bmh() {
        this.fJV.a(this.fKe);
    }

    public void setOnTabSelectedListener(b bVar) {
        this.fJW = bVar;
    }

    public void onDestroy() {
        if (this.fJP != null) {
            this.fJP.onDestroy();
        }
        bmk();
    }

    public void bmi() {
        int i = 1;
        if (this.fJV != null) {
            int ss = this.fJV.ss(this.bHL.getCurrentItem());
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
        if (this.fJS != null && this.fJV.blZ()) {
            this.fJS.setShowConcernRedTip(z);
        }
    }

    public boolean bmd() {
        if (this.fJS == null || !this.fJV.blZ()) {
            return false;
        }
        return this.fJS.bmd();
    }

    public void setVideoThreadId(String str) {
        if (this.fJV != null) {
            this.fJV.setVideoThreadId(str);
        }
    }

    public void bmj() {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int st = this.fJV != null ? this.fJV.st(0) : 0;
            if (this.fJX == null) {
                this.fJX = new com.baidu.tieba.c.d(this.mPageContext, this.fJS.sx(st));
                this.fJX.oK(d.f.bg_tip_blue_up);
                this.fJX.oJ(32);
                this.fJX.id(true);
                this.fJX.aa(true);
                this.fJX.setYOffset(l.h(this.mContext, d.e.ds16));
                this.fJX.oL(4000);
            }
            this.fJX.s(this.mContext.getString(d.j.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void bmk() {
        if (this.fJX != null) {
            this.fJX.aSs();
        }
    }

    public void onResume() {
        if (this.fJS != null) {
            this.fJS.onResume();
        }
    }

    public void a(a aVar) {
        if (this.eDv == null) {
            this.eDv = new ArrayList();
        }
        this.eDv.add(aVar);
    }

    public void b(a aVar) {
        if (this.eDv != null && this.eDv.size() > 0) {
            this.eDv.remove(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void bml() {
        }

        public void bmm() {
        }
    }
}
