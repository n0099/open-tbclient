package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.e;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private CustomViewPager avQ;
    private NoNetworkView bKI;
    private final d blM;
    private View bvs;
    private PluginErrorTipView dhI;
    private u emU;
    private ObservedChangeLinearLayout emV;
    private View emW;
    private HomeTabBarView emX;
    private View emY;
    private NewScrollFragmentAdapter emZ;
    private a ena;
    private com.baidu.tieba.c.d enb;
    private boolean enc;
    public CustomMessageListener ene;
    public CustomMessageListener enf;
    private b eng;
    private e enh;
    private com.baidu.tieba.homepage.framework.d eni;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes6.dex */
    public interface a {
        void ok(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.blM = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.emZ != null) {
                    ScrollFragmentTabHost.this.emZ.b(view, i, i2, i3, i4);
                }
            }
        };
        this.ene = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.emV != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.emV.animate().translationY(-ScrollFragmentTabHost.this.emV.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.emV.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.enf = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.emZ != null) {
                    ScrollFragmentTabHost.this.emZ.aIQ();
                }
                if (ScrollFragmentTabHost.this.emX != null) {
                    ScrollFragmentTabHost.this.emX.notifyDataSetChanged();
                }
            }
        };
        this.eng = new b();
        this.enh = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.e
            public void oa(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.emZ.oc(i), false);
                ScrollFragmentTabHost.this.emZ.oe(i);
            }
        };
        this.eni = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.d
            public void nZ(int i) {
                ScrollFragmentTabHost.this.eng.a(i, ScrollFragmentTabHost.this.enh);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blM = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.emZ != null) {
                    ScrollFragmentTabHost.this.emZ.b(view, i, i2, i3, i4);
                }
            }
        };
        this.ene = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.emV != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.emV.animate().translationY(-ScrollFragmentTabHost.this.emV.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.emV.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.enf = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.emZ != null) {
                    ScrollFragmentTabHost.this.emZ.aIQ();
                }
                if (ScrollFragmentTabHost.this.emX != null) {
                    ScrollFragmentTabHost.this.emX.notifyDataSetChanged();
                }
            }
        };
        this.eng = new b();
        this.enh = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.e
            public void oa(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.emZ.oc(i), false);
                ScrollFragmentTabHost.this.emZ.oe(i);
            }
        };
        this.eni = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.d
            public void nZ(int i) {
                ScrollFragmentTabHost.this.eng.a(i, ScrollFragmentTabHost.this.enh);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.emV = (ObservedChangeLinearLayout) findViewById(e.g.home_page_fragment_tab_layout);
        this.emW = findViewById(e.g.home_page_statebar_view);
        this.emX = (HomeTabBarView) findViewById(e.g.home_tab_bar_view);
        this.dhI = (PluginErrorTipView) findViewById(e.g.view_plugin_error_tip);
        this.bKI = (NoNetworkView) findViewById(e.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(e.g.home_pager_container);
        this.avQ = (CustomViewPager) findViewById(e.g.tab_widget_view_pager);
        this.emY = findViewById(e.g.home_statebar_view);
        this.bvs = findViewById(e.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.emW.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.emV.setOnSizeChangeListener(this.blM);
        this.emX.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.emZ.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.ena != null) {
                    ScrollFragmentTabHost.this.ena.ok(i);
                }
                com.baidu.tbadk.core.bigday.b.wO().aW(ScrollFragmentTabHost.this.emZ.ob(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.oj(i) == 3) {
                    am amVar = new am("c12478");
                    amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(amVar);
                }
                if (ScrollFragmentTabHost.this.oj(i) == 4) {
                    TiebaStatic.log(new am("c13172").x("obj_type", ScrollFragmentTabHost.this.enc ? 2 : 1));
                    ScrollFragmentTabHost.this.enc = false;
                }
                ScrollFragmentTabHost.this.aJb();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aIW = ScrollFragmentTabHost.this.aIW();
                    TiebaStatic.log(new am("c12350").x("obj_type", aIW ? 1 : 0));
                    if (aIW && ScrollFragmentTabHost.this.emZ != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.emZ.aIU();
                        ScrollFragmentTabHost.this.emZ.notifyDataSetChanged();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.emX.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void s(View view, int i) {
                if (ScrollFragmentTabHost.this.avQ.getCurrentItem() != i && ScrollFragmentTabHost.this.oj(i) == 4) {
                    ScrollFragmentTabHost.this.enc = true;
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.bKI.a(aVar);
        MessageManager.getInstance().registerListener(this.ene);
        MessageManager.getInstance().registerListener(this.enf);
    }

    public void notifyDataSetChanged() {
        if (this.emZ != null && !HomePageStatic.eiW) {
            this.avQ.setAdapter(this.emZ);
            this.emX.notifyDataSetChanged();
            this.eng.a(this.enh);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.emZ != null) {
            this.emZ.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.emZ != null) {
            this.emZ.d(dataRes, z);
        }
    }

    public void aIT() {
        if (this.emZ != null) {
            this.emZ.aIT();
        }
    }

    public void u(String str, int i, int i2) {
        if (this.avQ != null) {
            this.emZ.u(str, i, i2);
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
        this.emZ = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.emZ.setScrollFragmentTabHost(this);
        this.avQ.setOffscreenPageLimit(2);
        this.avQ.setAdapter(this.emZ);
        int aIP = this.emZ.aIP();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.emZ;
            if (HomePageStatic.eiW) {
                i = 0;
            }
            this.avQ.setCurrentItem(newScrollFragmentAdapter.oc(i));
            this.emX.setViewPager(this.avQ);
            this.emX.setConcernTabIndex(this.emZ.oc(0));
            if (this.emU != null) {
                this.emZ.setRecommendFrsNavigationAnimDispatcher(this.emU);
            }
            aJb();
        }
        i = aIP;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.emZ;
        if (HomePageStatic.eiW) {
        }
        this.avQ.setCurrentItem(newScrollFragmentAdapter2.oc(i));
        this.emX.setViewPager(this.avQ);
        this.emX.setConcernTabIndex(this.emZ.oc(0));
        if (this.emU != null) {
        }
        aJb();
    }

    public boolean aIZ() {
        return this.emZ != null && this.emZ.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.emZ.getCount()) {
            this.emX.setTabItemClicked(z);
            this.emZ.of(i);
            this.avQ.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.emZ.oc(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.emX.setPageUniqueId(bdUniqueId);
        this.ene.setTag(bdUniqueId);
        this.enf.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.emZ.ob(this.avQ.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.avQ.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.emZ.ob(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int oj(int i) {
        return this.emZ.ob(i);
    }

    public void onChangeSkinType(int i) {
        al.j(this.emW, e.d.cp_bg_line_d);
        this.emX.onChangeSkinType();
        if (this.mPageContext != null && this.bKI != null) {
            this.bKI.onChangeSkinType(this.mPageContext, i);
        }
        if (this.emZ != null) {
            this.emZ.eo(i);
        }
        if (this.mPageContext != null && this.dhI != null) {
            this.dhI.onChangeSkinType(this.mPageContext, i);
        }
        al.j(this.emY, e.d.cp_bg_line_d);
        al.j(this.bvs, e.d.cp_bg_line_c);
    }

    public void aIV() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.emZ != null) {
            this.emZ.aIV();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4) && this.emZ != null) {
            this.emZ.aIV();
        }
    }

    public void ZQ() {
        this.emZ.ZQ();
    }

    public String getCurrentPageKey() {
        if (this.emZ != null) {
            return this.emZ.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.avQ != null) {
            return this.avQ.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.emZ != null) {
            this.emZ.setPrimary(z);
        }
        if (this.bKI != null && z) {
            this.bKI.setVisibility(j.kK() ? 8 : 0);
        }
    }

    public void aJa() {
        this.emZ.a(this.eni);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.ena = aVar;
    }

    public void onDestroy() {
        if (this.emU != null) {
            this.emU.onDestroy();
        }
        aJd();
    }

    public void aJb() {
        int i = 1;
        if (this.emZ != null) {
            int ob = this.emZ.ob(this.avQ.getCurrentItem());
            if (ob == 0) {
                i = 0;
            } else if (ob != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.emX != null && this.emZ.aIS()) {
            this.emX.setShowConcernRedTip(z);
        }
    }

    public boolean aIW() {
        if (this.emX == null || !this.emZ.aIS()) {
            return false;
        }
        return this.emX.aIW();
    }

    public void setVideoThreadId(String str) {
        if (this.emZ != null) {
            this.emZ.setVideoThreadId(str);
        }
    }

    public void aJc() {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int oc = this.emZ != null ? this.emZ.oc(0) : 0;
            if (this.enb == null) {
                this.enb = new com.baidu.tieba.c.d(this.mPageContext, this.emX.og(oc));
                this.enb.kE(e.f.bg_tip_blue_up);
                this.enb.kD(32);
                this.enb.fF(true);
                this.enb.aa(true);
                this.enb.setYOffset(l.h(this.mContext, e.C0200e.ds16));
                this.enb.kF(UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
            }
            this.enb.h(this.mContext.getString(e.j.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void aJd() {
        if (this.enb != null) {
            this.enb.apA();
        }
    }

    public void onResume() {
        if (this.emX != null) {
            this.emX.onResume();
        }
    }
}
