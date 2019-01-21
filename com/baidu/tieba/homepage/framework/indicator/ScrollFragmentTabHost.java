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
    private CustomViewPager azT;
    private NoNetworkView bPm;
    private final d bqc;
    private View bzH;
    private PluginErrorTipView drQ;
    private boolean exA;
    public CustomMessageListener exB;
    public CustomMessageListener exC;
    private b exD;
    private e exE;
    private com.baidu.tieba.homepage.framework.d exF;
    private v exr;
    private ObservedChangeLinearLayout exs;
    private View exu;
    private HomeTabBarView exv;
    private View exw;
    private NewScrollFragmentAdapter exx;
    private a exy;
    private com.baidu.tieba.c.d exz;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes6.dex */
    public interface a {
        void oS(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.bqc = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.exx != null) {
                    ScrollFragmentTabHost.this.exx.b(view, i, i2, i3, i4);
                }
            }
        };
        this.exB = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.exs != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.exs.animate().translationY(-ScrollFragmentTabHost.this.exs.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.exs.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.exC = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.exx != null) {
                    ScrollFragmentTabHost.this.exx.aLV();
                }
                if (ScrollFragmentTabHost.this.exv != null) {
                    ScrollFragmentTabHost.this.exv.notifyDataSetChanged();
                }
            }
        };
        this.exD = new b();
        this.exE = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.e
            public void oI(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.exx.oK(i), false);
                ScrollFragmentTabHost.this.exx.oM(i);
            }
        };
        this.exF = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.d
            public void oH(int i) {
                ScrollFragmentTabHost.this.exD.a(i, ScrollFragmentTabHost.this.exE);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqc = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.exx != null) {
                    ScrollFragmentTabHost.this.exx.b(view, i, i2, i3, i4);
                }
            }
        };
        this.exB = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.exs != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.exs.animate().translationY(-ScrollFragmentTabHost.this.exs.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.exs.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.exC = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.exx != null) {
                    ScrollFragmentTabHost.this.exx.aLV();
                }
                if (ScrollFragmentTabHost.this.exv != null) {
                    ScrollFragmentTabHost.this.exv.notifyDataSetChanged();
                }
            }
        };
        this.exD = new b();
        this.exE = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.e
            public void oI(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.exx.oK(i), false);
                ScrollFragmentTabHost.this.exx.oM(i);
            }
        };
        this.exF = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.d
            public void oH(int i) {
                ScrollFragmentTabHost.this.exD.a(i, ScrollFragmentTabHost.this.exE);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.exs = (ObservedChangeLinearLayout) findViewById(e.g.home_page_fragment_tab_layout);
        this.exu = findViewById(e.g.home_page_statebar_view);
        this.exv = (HomeTabBarView) findViewById(e.g.home_tab_bar_view);
        this.drQ = (PluginErrorTipView) findViewById(e.g.view_plugin_error_tip);
        this.bPm = (NoNetworkView) findViewById(e.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(e.g.home_pager_container);
        this.azT = (CustomViewPager) findViewById(e.g.tab_widget_view_pager);
        this.exw = findViewById(e.g.home_statebar_view);
        this.bzH = findViewById(e.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.exu.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.exs.setOnSizeChangeListener(this.bqc);
        this.exv.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.exx.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.exy != null) {
                    ScrollFragmentTabHost.this.exy.oS(i);
                }
                com.baidu.tbadk.core.bigday.b.yf().aY(ScrollFragmentTabHost.this.exx.oJ(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.oR(i) == 3) {
                    am amVar = new am("c12478");
                    amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(amVar);
                }
                if (ScrollFragmentTabHost.this.oR(i) == 4) {
                    TiebaStatic.log(new am("c13172").y("obj_type", ScrollFragmentTabHost.this.exA ? 2 : 1));
                    ScrollFragmentTabHost.this.exA = false;
                }
                ScrollFragmentTabHost.this.aMe();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aMa = ScrollFragmentTabHost.this.aMa();
                    TiebaStatic.log(new am("c12350").y("obj_type", aMa ? 1 : 0));
                    if (aMa && ScrollFragmentTabHost.this.exx != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.exx.aLY();
                        ScrollFragmentTabHost.this.exx.notifyDataSetChanged();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.exv.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void s(View view, int i) {
                if (ScrollFragmentTabHost.this.azT.getCurrentItem() != i && ScrollFragmentTabHost.this.oR(i) == 4) {
                    ScrollFragmentTabHost.this.exA = true;
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.bPm.a(aVar);
        MessageManager.getInstance().registerListener(this.exB);
        MessageManager.getInstance().registerListener(this.exC);
    }

    public void notifyDataSetChanged() {
        if (this.exx != null && !HomePageStatic.etp) {
            this.azT.setAdapter(this.exx);
            this.exv.notifyDataSetChanged();
            this.exD.a(this.exE);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.exx != null) {
            this.exx.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.exx != null) {
            this.exx.d(dataRes, z);
        }
    }

    public void aLX() {
        if (this.exx != null) {
            this.exx.aLX();
        }
    }

    public void w(String str, int i, int i2) {
        if (this.azT != null) {
            this.exx.w(str, i, i2);
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
        this.exx = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.exx.setScrollFragmentTabHost(this);
        this.azT.setOffscreenPageLimit(2);
        this.azT.setAdapter(this.exx);
        int aLU = this.exx.aLU();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.exx;
            if (HomePageStatic.etp) {
                i = 0;
            }
            this.azT.setCurrentItem(newScrollFragmentAdapter.oK(i));
            this.exv.setViewPager(this.azT);
            this.exv.setConcernTabIndex(this.exx.oK(0));
            if (this.exr != null) {
                this.exx.setRecommendFrsNavigationAnimDispatcher(this.exr);
            }
            aMe();
        }
        i = aLU;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.exx;
        if (HomePageStatic.etp) {
        }
        this.azT.setCurrentItem(newScrollFragmentAdapter2.oK(i));
        this.exv.setViewPager(this.azT);
        this.exv.setConcernTabIndex(this.exx.oK(0));
        if (this.exr != null) {
        }
        aMe();
    }

    public boolean aMc() {
        return this.exx != null && this.exx.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.exx.getCount()) {
            this.exv.setTabItemClicked(z);
            this.exx.oN(i);
            this.azT.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.exx.oK(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.exv.setPageUniqueId(bdUniqueId);
        this.exB.setTag(bdUniqueId);
        this.exC.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.exx.oJ(this.azT.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.azT.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.exx.oJ(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int oR(int i) {
        return this.exx.oJ(i);
    }

    public void onChangeSkinType(int i) {
        al.j(this.exu, e.d.cp_bg_line_d);
        this.exv.onChangeSkinType();
        if (this.mPageContext != null && this.bPm != null) {
            this.bPm.onChangeSkinType(this.mPageContext, i);
        }
        if (this.exx != null) {
            this.exx.eD(i);
        }
        if (this.mPageContext != null && this.drQ != null) {
            this.drQ.onChangeSkinType(this.mPageContext, i);
        }
        al.j(this.exw, e.d.cp_bg_line_d);
        al.j(this.bzH, e.d.cp_bg_line_c);
    }

    public void aLZ() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.exx != null) {
            this.exx.aLZ();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4) && this.exx != null) {
            this.exx.aLZ();
        }
    }

    public void abv() {
        this.exx.abv();
    }

    public String getCurrentPageKey() {
        if (this.exx != null) {
            return this.exx.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.azT != null) {
            return this.azT.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.exx != null) {
            this.exx.setPrimary(z);
        }
        if (this.bPm != null && z) {
            this.bPm.setVisibility(j.kK() ? 8 : 0);
        }
    }

    public void aMd() {
        this.exx.a(this.exF);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.exy = aVar;
    }

    public void onDestroy() {
        if (this.exr != null) {
            this.exr.onDestroy();
        }
        aMg();
    }

    public void aMe() {
        int i = 1;
        if (this.exx != null) {
            int oJ = this.exx.oJ(this.azT.getCurrentItem());
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
        if (this.exv != null && this.exx.aLW()) {
            this.exv.setShowConcernRedTip(z);
        }
    }

    public boolean aMa() {
        if (this.exv == null || !this.exx.aLW()) {
            return false;
        }
        return this.exv.aMa();
    }

    public void setVideoThreadId(String str) {
        if (this.exx != null) {
            this.exx.setVideoThreadId(str);
        }
    }

    public void aMf() {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int oK = this.exx != null ? this.exx.oK(0) : 0;
            if (this.exz == null) {
                this.exz = new com.baidu.tieba.c.d(this.mPageContext, this.exv.oO(oK));
                this.exz.li(e.f.bg_tip_blue_up);
                this.exz.lh(32);
                this.exz.fL(true);
                this.exz.aa(true);
                this.exz.setYOffset(l.h(this.mContext, e.C0210e.ds16));
                this.exz.lj(UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
            }
            this.exz.h(this.mContext.getString(e.j.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void aMg() {
        if (this.exz != null) {
            this.exz.asz();
        }
    }

    public void onResume() {
        if (this.exv != null) {
            this.exv.onResume();
        }
    }

    public boolean aMh() {
        if (this.exv != null) {
            return this.exv.aMh();
        }
        return false;
    }
}
