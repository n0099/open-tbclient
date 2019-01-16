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
import com.baidu.tbadk.util.v;
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
    private CustomViewPager azS;
    private NoNetworkView bPl;
    private final d bqb;
    private View bzG;
    private PluginErrorTipView drP;
    public CustomMessageListener exA;
    public CustomMessageListener exB;
    private b exC;
    private e exD;
    private com.baidu.tieba.homepage.framework.d exE;
    private v exq;
    private ObservedChangeLinearLayout exr;
    private View exs;
    private HomeTabBarView exu;
    private View exv;
    private NewScrollFragmentAdapter exw;
    private a exx;
    private com.baidu.tieba.c.d exy;
    private boolean exz;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes6.dex */
    public interface a {
        void oS(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.bqb = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.exw != null) {
                    ScrollFragmentTabHost.this.exw.b(view, i, i2, i3, i4);
                }
            }
        };
        this.exA = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.exr != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.exr.animate().translationY(-ScrollFragmentTabHost.this.exr.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.exr.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.exB = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.exw != null) {
                    ScrollFragmentTabHost.this.exw.aLV();
                }
                if (ScrollFragmentTabHost.this.exu != null) {
                    ScrollFragmentTabHost.this.exu.notifyDataSetChanged();
                }
            }
        };
        this.exC = new b();
        this.exD = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.e
            public void oI(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.exw.oK(i), false);
                ScrollFragmentTabHost.this.exw.oM(i);
            }
        };
        this.exE = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.d
            public void oH(int i) {
                ScrollFragmentTabHost.this.exC.a(i, ScrollFragmentTabHost.this.exD);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqb = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.exw != null) {
                    ScrollFragmentTabHost.this.exw.b(view, i, i2, i3, i4);
                }
            }
        };
        this.exA = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.exr != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.exr.animate().translationY(-ScrollFragmentTabHost.this.exr.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.exr.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.exB = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.exw != null) {
                    ScrollFragmentTabHost.this.exw.aLV();
                }
                if (ScrollFragmentTabHost.this.exu != null) {
                    ScrollFragmentTabHost.this.exu.notifyDataSetChanged();
                }
            }
        };
        this.exC = new b();
        this.exD = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.e
            public void oI(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.exw.oK(i), false);
                ScrollFragmentTabHost.this.exw.oM(i);
            }
        };
        this.exE = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.d
            public void oH(int i) {
                ScrollFragmentTabHost.this.exC.a(i, ScrollFragmentTabHost.this.exD);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.exr = (ObservedChangeLinearLayout) findViewById(e.g.home_page_fragment_tab_layout);
        this.exs = findViewById(e.g.home_page_statebar_view);
        this.exu = (HomeTabBarView) findViewById(e.g.home_tab_bar_view);
        this.drP = (PluginErrorTipView) findViewById(e.g.view_plugin_error_tip);
        this.bPl = (NoNetworkView) findViewById(e.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(e.g.home_pager_container);
        this.azS = (CustomViewPager) findViewById(e.g.tab_widget_view_pager);
        this.exv = findViewById(e.g.home_statebar_view);
        this.bzG = findViewById(e.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.exs.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.exr.setOnSizeChangeListener(this.bqb);
        this.exu.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.exw.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.exx != null) {
                    ScrollFragmentTabHost.this.exx.oS(i);
                }
                com.baidu.tbadk.core.bigday.b.yf().aY(ScrollFragmentTabHost.this.exw.oJ(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.oR(i) == 3) {
                    am amVar = new am("c12478");
                    amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(amVar);
                }
                if (ScrollFragmentTabHost.this.oR(i) == 4) {
                    TiebaStatic.log(new am("c13172").y("obj_type", ScrollFragmentTabHost.this.exz ? 2 : 1));
                    ScrollFragmentTabHost.this.exz = false;
                }
                ScrollFragmentTabHost.this.aMe();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aMa = ScrollFragmentTabHost.this.aMa();
                    TiebaStatic.log(new am("c12350").y("obj_type", aMa ? 1 : 0));
                    if (aMa && ScrollFragmentTabHost.this.exw != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.exw.aLY();
                        ScrollFragmentTabHost.this.exw.notifyDataSetChanged();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.exu.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void s(View view, int i) {
                if (ScrollFragmentTabHost.this.azS.getCurrentItem() != i && ScrollFragmentTabHost.this.oR(i) == 4) {
                    ScrollFragmentTabHost.this.exz = true;
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.bPl.a(aVar);
        MessageManager.getInstance().registerListener(this.exA);
        MessageManager.getInstance().registerListener(this.exB);
    }

    public void notifyDataSetChanged() {
        if (this.exw != null && !HomePageStatic.eto) {
            this.azS.setAdapter(this.exw);
            this.exu.notifyDataSetChanged();
            this.exC.a(this.exD);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.exw != null) {
            this.exw.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.exw != null) {
            this.exw.d(dataRes, z);
        }
    }

    public void aLX() {
        if (this.exw != null) {
            this.exw.aLX();
        }
    }

    public void w(String str, int i, int i2) {
        if (this.azS != null) {
            this.exw.w(str, i, i2);
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
        this.exw = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.exw.setScrollFragmentTabHost(this);
        this.azS.setOffscreenPageLimit(2);
        this.azS.setAdapter(this.exw);
        int aLU = this.exw.aLU();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.exw;
            if (HomePageStatic.eto) {
                i = 0;
            }
            this.azS.setCurrentItem(newScrollFragmentAdapter.oK(i));
            this.exu.setViewPager(this.azS);
            this.exu.setConcernTabIndex(this.exw.oK(0));
            if (this.exq != null) {
                this.exw.setRecommendFrsNavigationAnimDispatcher(this.exq);
            }
            aMe();
        }
        i = aLU;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.exw;
        if (HomePageStatic.eto) {
        }
        this.azS.setCurrentItem(newScrollFragmentAdapter2.oK(i));
        this.exu.setViewPager(this.azS);
        this.exu.setConcernTabIndex(this.exw.oK(0));
        if (this.exq != null) {
        }
        aMe();
    }

    public boolean aMc() {
        return this.exw != null && this.exw.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.exw.getCount()) {
            this.exu.setTabItemClicked(z);
            this.exw.oN(i);
            this.azS.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.exw.oK(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.exu.setPageUniqueId(bdUniqueId);
        this.exA.setTag(bdUniqueId);
        this.exB.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.exw.oJ(this.azS.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.azS.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.exw.oJ(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int oR(int i) {
        return this.exw.oJ(i);
    }

    public void onChangeSkinType(int i) {
        al.j(this.exs, e.d.cp_bg_line_d);
        this.exu.onChangeSkinType();
        if (this.mPageContext != null && this.bPl != null) {
            this.bPl.onChangeSkinType(this.mPageContext, i);
        }
        if (this.exw != null) {
            this.exw.eD(i);
        }
        if (this.mPageContext != null && this.drP != null) {
            this.drP.onChangeSkinType(this.mPageContext, i);
        }
        al.j(this.exv, e.d.cp_bg_line_d);
        al.j(this.bzG, e.d.cp_bg_line_c);
    }

    public void aLZ() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.exw != null) {
            this.exw.aLZ();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4) && this.exw != null) {
            this.exw.aLZ();
        }
    }

    public void abv() {
        this.exw.abv();
    }

    public String getCurrentPageKey() {
        if (this.exw != null) {
            return this.exw.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.azS != null) {
            return this.azS.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.exw != null) {
            this.exw.setPrimary(z);
        }
        if (this.bPl != null && z) {
            this.bPl.setVisibility(j.kK() ? 8 : 0);
        }
    }

    public void aMd() {
        this.exw.a(this.exE);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.exx = aVar;
    }

    public void onDestroy() {
        if (this.exq != null) {
            this.exq.onDestroy();
        }
        aMg();
    }

    public void aMe() {
        int i = 1;
        if (this.exw != null) {
            int oJ = this.exw.oJ(this.azS.getCurrentItem());
            if (oJ == 0) {
                i = 0;
            } else if (oJ != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.exu != null && this.exw.aLW()) {
            this.exu.setShowConcernRedTip(z);
        }
    }

    public boolean aMa() {
        if (this.exu == null || !this.exw.aLW()) {
            return false;
        }
        return this.exu.aMa();
    }

    public void setVideoThreadId(String str) {
        if (this.exw != null) {
            this.exw.setVideoThreadId(str);
        }
    }

    public void aMf() {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int oK = this.exw != null ? this.exw.oK(0) : 0;
            if (this.exy == null) {
                this.exy = new com.baidu.tieba.c.d(this.mPageContext, this.exu.oO(oK));
                this.exy.li(e.f.bg_tip_blue_up);
                this.exy.lh(32);
                this.exy.fL(true);
                this.exy.aa(true);
                this.exy.setYOffset(l.h(this.mContext, e.C0210e.ds16));
                this.exy.lj(UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
            }
            this.exy.h(this.mContext.getString(e.j.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void aMg() {
        if (this.exy != null) {
            this.exy.asz();
        }
    }

    public void onResume() {
        if (this.exu != null) {
            this.exu.onResume();
        }
    }

    public boolean aMh() {
        if (this.exu != null) {
            return this.exu.aMh();
        }
        return false;
    }
}
