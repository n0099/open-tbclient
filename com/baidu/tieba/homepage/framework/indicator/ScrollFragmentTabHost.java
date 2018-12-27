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
    private CustomViewPager azq;
    private NoNetworkView bOA;
    private final d bpn;
    private View byS;
    private PluginErrorTipView drg;
    private u ewG;
    private ObservedChangeLinearLayout ewH;
    private View ewI;
    private HomeTabBarView ewJ;
    private View ewK;
    private NewScrollFragmentAdapter ewL;
    private a ewM;
    private com.baidu.tieba.c.d ewN;
    private boolean ewO;
    public CustomMessageListener ewP;
    public CustomMessageListener ewQ;
    private b ewR;
    private e ewS;
    private com.baidu.tieba.homepage.framework.d ewT;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes6.dex */
    public interface a {
        void oR(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.bpn = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.ewL != null) {
                    ScrollFragmentTabHost.this.ewL.b(view, i, i2, i3, i4);
                }
            }
        };
        this.ewP = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.ewH != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.ewH.animate().translationY(-ScrollFragmentTabHost.this.ewH.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.ewH.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.ewQ = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.ewL != null) {
                    ScrollFragmentTabHost.this.ewL.aLw();
                }
                if (ScrollFragmentTabHost.this.ewJ != null) {
                    ScrollFragmentTabHost.this.ewJ.notifyDataSetChanged();
                }
            }
        };
        this.ewR = new b();
        this.ewS = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.e
            public void oH(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.ewL.oJ(i), false);
                ScrollFragmentTabHost.this.ewL.oL(i);
            }
        };
        this.ewT = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.d
            public void oG(int i) {
                ScrollFragmentTabHost.this.ewR.a(i, ScrollFragmentTabHost.this.ewS);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bpn = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.ewL != null) {
                    ScrollFragmentTabHost.this.ewL.b(view, i, i2, i3, i4);
                }
            }
        };
        this.ewP = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.ewH != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.ewH.animate().translationY(-ScrollFragmentTabHost.this.ewH.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.ewH.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.ewQ = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.ewL != null) {
                    ScrollFragmentTabHost.this.ewL.aLw();
                }
                if (ScrollFragmentTabHost.this.ewJ != null) {
                    ScrollFragmentTabHost.this.ewJ.notifyDataSetChanged();
                }
            }
        };
        this.ewR = new b();
        this.ewS = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.e
            public void oH(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.ewL.oJ(i), false);
                ScrollFragmentTabHost.this.ewL.oL(i);
            }
        };
        this.ewT = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.d
            public void oG(int i) {
                ScrollFragmentTabHost.this.ewR.a(i, ScrollFragmentTabHost.this.ewS);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.ewH = (ObservedChangeLinearLayout) findViewById(e.g.home_page_fragment_tab_layout);
        this.ewI = findViewById(e.g.home_page_statebar_view);
        this.ewJ = (HomeTabBarView) findViewById(e.g.home_tab_bar_view);
        this.drg = (PluginErrorTipView) findViewById(e.g.view_plugin_error_tip);
        this.bOA = (NoNetworkView) findViewById(e.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(e.g.home_pager_container);
        this.azq = (CustomViewPager) findViewById(e.g.tab_widget_view_pager);
        this.ewK = findViewById(e.g.home_statebar_view);
        this.byS = findViewById(e.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.ewI.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.ewH.setOnSizeChangeListener(this.bpn);
        this.ewJ.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.ewL.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.ewM != null) {
                    ScrollFragmentTabHost.this.ewM.oR(i);
                }
                com.baidu.tbadk.core.bigday.b.xS().aX(ScrollFragmentTabHost.this.ewL.oI(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.oQ(i) == 3) {
                    am amVar = new am("c12478");
                    amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(amVar);
                }
                if (ScrollFragmentTabHost.this.oQ(i) == 4) {
                    TiebaStatic.log(new am("c13172").x("obj_type", ScrollFragmentTabHost.this.ewO ? 2 : 1));
                    ScrollFragmentTabHost.this.ewO = false;
                }
                ScrollFragmentTabHost.this.aLF();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aLB = ScrollFragmentTabHost.this.aLB();
                    TiebaStatic.log(new am("c12350").x("obj_type", aLB ? 1 : 0));
                    if (aLB && ScrollFragmentTabHost.this.ewL != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.ewL.aLz();
                        ScrollFragmentTabHost.this.ewL.notifyDataSetChanged();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.ewJ.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void s(View view, int i) {
                if (ScrollFragmentTabHost.this.azq.getCurrentItem() != i && ScrollFragmentTabHost.this.oQ(i) == 4) {
                    ScrollFragmentTabHost.this.ewO = true;
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.bOA.a(aVar);
        MessageManager.getInstance().registerListener(this.ewP);
        MessageManager.getInstance().registerListener(this.ewQ);
    }

    public void notifyDataSetChanged() {
        if (this.ewL != null && !HomePageStatic.esH) {
            this.azq.setAdapter(this.ewL);
            this.ewJ.notifyDataSetChanged();
            this.ewR.a(this.ewS);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ewL != null) {
            this.ewL.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ewL != null) {
            this.ewL.d(dataRes, z);
        }
    }

    public void aLy() {
        if (this.ewL != null) {
            this.ewL.aLy();
        }
    }

    public void w(String str, int i, int i2) {
        if (this.azq != null) {
            this.ewL.w(str, i, i2);
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
        this.ewL = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.ewL.setScrollFragmentTabHost(this);
        this.azq.setOffscreenPageLimit(2);
        this.azq.setAdapter(this.ewL);
        int aLv = this.ewL.aLv();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.ewL;
            if (HomePageStatic.esH) {
                i = 0;
            }
            this.azq.setCurrentItem(newScrollFragmentAdapter.oJ(i));
            this.ewJ.setViewPager(this.azq);
            this.ewJ.setConcernTabIndex(this.ewL.oJ(0));
            if (this.ewG != null) {
                this.ewL.setRecommendFrsNavigationAnimDispatcher(this.ewG);
            }
            aLF();
        }
        i = aLv;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.ewL;
        if (HomePageStatic.esH) {
        }
        this.azq.setCurrentItem(newScrollFragmentAdapter2.oJ(i));
        this.ewJ.setViewPager(this.azq);
        this.ewJ.setConcernTabIndex(this.ewL.oJ(0));
        if (this.ewG != null) {
        }
        aLF();
    }

    public boolean aLD() {
        return this.ewL != null && this.ewL.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.ewL.getCount()) {
            this.ewJ.setTabItemClicked(z);
            this.ewL.oM(i);
            this.azq.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.ewL.oJ(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ewJ.setPageUniqueId(bdUniqueId);
        this.ewP.setTag(bdUniqueId);
        this.ewQ.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.ewL.oI(this.azq.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.azq.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.ewL.oI(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int oQ(int i) {
        return this.ewL.oI(i);
    }

    public void onChangeSkinType(int i) {
        al.j(this.ewI, e.d.cp_bg_line_d);
        this.ewJ.onChangeSkinType();
        if (this.mPageContext != null && this.bOA != null) {
            this.bOA.onChangeSkinType(this.mPageContext, i);
        }
        if (this.ewL != null) {
            this.ewL.eD(i);
        }
        if (this.mPageContext != null && this.drg != null) {
            this.drg.onChangeSkinType(this.mPageContext, i);
        }
        al.j(this.ewK, e.d.cp_bg_line_d);
        al.j(this.byS, e.d.cp_bg_line_c);
    }

    public void aLA() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.ewL != null) {
            this.ewL.aLA();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4) && this.ewL != null) {
            this.ewL.aLA();
        }
    }

    public void aaY() {
        this.ewL.aaY();
    }

    public String getCurrentPageKey() {
        if (this.ewL != null) {
            return this.ewL.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.azq != null) {
            return this.azq.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.ewL != null) {
            this.ewL.setPrimary(z);
        }
        if (this.bOA != null && z) {
            this.bOA.setVisibility(j.kK() ? 8 : 0);
        }
    }

    public void aLE() {
        this.ewL.a(this.ewT);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.ewM = aVar;
    }

    public void onDestroy() {
        if (this.ewG != null) {
            this.ewG.onDestroy();
        }
        aLH();
    }

    public void aLF() {
        int i = 1;
        if (this.ewL != null) {
            int oI = this.ewL.oI(this.azq.getCurrentItem());
            if (oI == 0) {
                i = 0;
            } else if (oI != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.ewJ != null && this.ewL.aLx()) {
            this.ewJ.setShowConcernRedTip(z);
        }
    }

    public boolean aLB() {
        if (this.ewJ == null || !this.ewL.aLx()) {
            return false;
        }
        return this.ewJ.aLB();
    }

    public void setVideoThreadId(String str) {
        if (this.ewL != null) {
            this.ewL.setVideoThreadId(str);
        }
    }

    public void aLG() {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int oJ = this.ewL != null ? this.ewL.oJ(0) : 0;
            if (this.ewN == null) {
                this.ewN = new com.baidu.tieba.c.d(this.mPageContext, this.ewJ.oN(oJ));
                this.ewN.lh(e.f.bg_tip_blue_up);
                this.ewN.lg(32);
                this.ewN.fI(true);
                this.ewN.aa(true);
                this.ewN.setYOffset(l.h(this.mContext, e.C0210e.ds16));
                this.ewN.li(UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
            }
            this.ewN.h(this.mContext.getString(e.j.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void aLH() {
        if (this.ewN != null) {
            this.ewN.asb();
        }
    }

    public void onResume() {
        if (this.ewJ != null) {
            this.ewJ.onResume();
        }
    }
}
