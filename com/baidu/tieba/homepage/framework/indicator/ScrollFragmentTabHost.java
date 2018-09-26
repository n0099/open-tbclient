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
/* loaded from: classes2.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private CustomViewPager aqm;
    private NoNetworkView bBq;
    private final d bgM;
    private View bqy;
    private PluginErrorTipView cYn;
    private u edH;
    private ObservedChangeLinearLayout edI;
    private View edJ;
    private HomeTabBarView edK;
    private View edL;
    private NewScrollFragmentAdapter edM;
    private a edN;
    private com.baidu.tieba.c.d edO;
    private boolean edP;
    public CustomMessageListener edQ;
    public CustomMessageListener edR;
    private b edS;
    private e edT;
    private com.baidu.tieba.homepage.framework.d edU;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void nu(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.bgM = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.edM != null) {
                    ScrollFragmentTabHost.this.edM.b(view, i, i2, i3, i4);
                }
            }
        };
        this.edQ = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.edI != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.edI.animate().translationY(-ScrollFragmentTabHost.this.edI.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.edI.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.edR = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.edM != null) {
                    ScrollFragmentTabHost.this.edM.aGa();
                }
                if (ScrollFragmentTabHost.this.edK != null) {
                    ScrollFragmentTabHost.this.edK.notifyDataSetChanged();
                }
            }
        };
        this.edS = new b();
        this.edT = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.e
            public void nk(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.edM.nm(i), false);
                ScrollFragmentTabHost.this.edM.no(i);
            }
        };
        this.edU = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.d
            public void nj(int i) {
                ScrollFragmentTabHost.this.edS.a(i, ScrollFragmentTabHost.this.edT);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bgM = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.edM != null) {
                    ScrollFragmentTabHost.this.edM.b(view, i, i2, i3, i4);
                }
            }
        };
        this.edQ = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.edI != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.edI.animate().translationY(-ScrollFragmentTabHost.this.edI.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.edI.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.edR = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.edM != null) {
                    ScrollFragmentTabHost.this.edM.aGa();
                }
                if (ScrollFragmentTabHost.this.edK != null) {
                    ScrollFragmentTabHost.this.edK.notifyDataSetChanged();
                }
            }
        };
        this.edS = new b();
        this.edT = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.e
            public void nk(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.edM.nm(i), false);
                ScrollFragmentTabHost.this.edM.no(i);
            }
        };
        this.edU = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.d
            public void nj(int i) {
                ScrollFragmentTabHost.this.edS.a(i, ScrollFragmentTabHost.this.edT);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.edI = (ObservedChangeLinearLayout) findViewById(e.g.home_page_fragment_tab_layout);
        this.edJ = findViewById(e.g.home_page_statebar_view);
        this.edK = (HomeTabBarView) findViewById(e.g.home_tab_bar_view);
        this.cYn = (PluginErrorTipView) findViewById(e.g.view_plugin_error_tip);
        this.bBq = (NoNetworkView) findViewById(e.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(e.g.home_pager_container);
        this.aqm = (CustomViewPager) findViewById(e.g.tab_widget_view_pager);
        this.edL = findViewById(e.g.home_statebar_view);
        this.bqy = findViewById(e.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.edJ.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.edI.setOnSizeChangeListener(this.bgM);
        this.edK.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.edM.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.edN != null) {
                    ScrollFragmentTabHost.this.edN.nu(i);
                }
                com.baidu.tbadk.core.bigday.b.ux().aw(ScrollFragmentTabHost.this.edM.nl(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.nt(i) == 3) {
                    am amVar = new am("c12478");
                    amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(amVar);
                }
                if (ScrollFragmentTabHost.this.nt(i) == 4) {
                    TiebaStatic.log(new am("c13172").w("obj_type", ScrollFragmentTabHost.this.edP ? 2 : 1));
                    ScrollFragmentTabHost.this.edP = false;
                }
                ScrollFragmentTabHost.this.aGl();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aGg = ScrollFragmentTabHost.this.aGg();
                    TiebaStatic.log(new am("c12350").w("obj_type", aGg ? 1 : 0));
                    if (aGg && ScrollFragmentTabHost.this.edM != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.edM.aGe();
                        ScrollFragmentTabHost.this.edM.notifyDataSetChanged();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.edK.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void r(View view, int i) {
                if (ScrollFragmentTabHost.this.aqm.getCurrentItem() != i && ScrollFragmentTabHost.this.nt(i) == 4) {
                    ScrollFragmentTabHost.this.edP = true;
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.bBq.a(aVar);
        MessageManager.getInstance().registerListener(this.edQ);
        MessageManager.getInstance().registerListener(this.edR);
    }

    public void notifyDataSetChanged() {
        if (this.edM != null && !HomePageStatic.dZI) {
            this.aqm.setAdapter(this.edM);
            this.edK.notifyDataSetChanged();
            this.edS.a(this.edT);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.edM != null) {
            this.edM.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.edM != null) {
            this.edM.d(dataRes, z);
        }
    }

    public void aGd() {
        if (this.edM != null) {
            this.edM.aGd();
        }
    }

    public void u(String str, int i, int i2) {
        if (this.aqm != null) {
            this.edM.u(str, i, i2);
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
        this.edM = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.edM.setScrollFragmentTabHost(this);
        this.aqm.setOffscreenPageLimit(2);
        this.aqm.setAdapter(this.edM);
        int aFZ = this.edM.aFZ();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.edM;
            if (HomePageStatic.dZI) {
                i = 0;
            }
            this.aqm.setCurrentItem(newScrollFragmentAdapter.nm(i));
            this.edK.setViewPager(this.aqm);
            this.edK.setConcernTabIndex(this.edM.nm(0));
            if (this.edH != null) {
                this.edM.setRecommendFrsNavigationAnimDispatcher(this.edH);
            }
            aGl();
        }
        i = aFZ;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.edM;
        if (HomePageStatic.dZI) {
        }
        this.aqm.setCurrentItem(newScrollFragmentAdapter2.nm(i));
        this.edK.setViewPager(this.aqm);
        this.edK.setConcernTabIndex(this.edM.nm(0));
        if (this.edH != null) {
        }
        aGl();
    }

    public boolean aGj() {
        return this.edM != null && this.edM.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.edM.getCount()) {
            this.edK.setTabItemClicked(z);
            this.edM.np(i);
            this.aqm.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.edM.nm(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.edK.setPageUniqueId(bdUniqueId);
        this.edQ.setTag(bdUniqueId);
        this.edR.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.edM.nl(this.aqm.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.aqm.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.edM.nl(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int nt(int i) {
        return this.edM.nl(i);
    }

    public void onChangeSkinType(int i) {
        al.j(this.edJ, e.d.cp_bg_line_d);
        this.edK.onChangeSkinType();
        if (this.mPageContext != null && this.bBq != null) {
            this.bBq.onChangeSkinType(this.mPageContext, i);
        }
        if (this.edM != null) {
            this.edM.dQ(i);
        }
        if (this.mPageContext != null && this.cYn != null) {
            this.cYn.onChangeSkinType(this.mPageContext, i);
        }
        al.j(this.edL, e.d.cp_bg_line_d);
        al.j(this.bqy, e.d.cp_bg_line_c);
    }

    public void aGf() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.edM != null) {
            this.edM.aGf();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4) && this.edM != null) {
            this.edM.aGf();
        }
    }

    public void VY() {
        this.edM.VY();
    }

    public String getCurrentPageKey() {
        if (this.edM != null) {
            return this.edM.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.aqm != null) {
            return this.aqm.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.edM != null) {
            this.edM.setPrimary(z);
        }
        if (this.bBq != null && z) {
            this.bBq.setVisibility(j.ky() ? 8 : 0);
        }
    }

    public void aGk() {
        this.edM.a(this.edU);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.edN = aVar;
    }

    public void onDestroy() {
        if (this.edH != null) {
            this.edH.onDestroy();
        }
        aGn();
    }

    public void aGl() {
        int i = 1;
        if (this.edM != null) {
            int nl = this.edM.nl(this.aqm.getCurrentItem());
            if (nl == 0) {
                i = 0;
            } else if (nl != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.edK != null && this.edM.aGc()) {
            this.edK.setShowConcernRedTip(z);
        }
    }

    public boolean aGg() {
        if (this.edK == null || !this.edM.aGc()) {
            return false;
        }
        return this.edK.aGg();
    }

    public void setVideoThreadId(String str) {
        if (this.edM != null) {
            this.edM.setVideoThreadId(str);
        }
    }

    public void aGm() {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int nm = this.edM != null ? this.edM.nm(0) : 0;
            if (this.edO == null) {
                this.edO = new com.baidu.tieba.c.d(this.mPageContext, this.edK.nq(nm));
                this.edO.jN(e.f.bg_tip_blue_up);
                this.edO.jM(32);
                this.edO.fc(true);
                this.edO.M(true);
                this.edO.jR(l.h(this.mContext, e.C0141e.ds16));
                this.edO.jO(4000);
            }
            this.edO.g(this.mContext.getString(e.j.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void aGn() {
        if (this.edO != null) {
            this.edO.amz();
        }
    }

    public void onResume() {
        if (this.edK != null) {
            this.edK.onResume();
        }
    }
}
