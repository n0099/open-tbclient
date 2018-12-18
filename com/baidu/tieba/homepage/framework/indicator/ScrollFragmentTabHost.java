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
    private NoNetworkView bOx;
    private final d bpk;
    private View byP;
    private PluginErrorTipView doq;
    private u etQ;
    private ObservedChangeLinearLayout etR;
    private View etS;
    private HomeTabBarView etT;
    private View etU;
    private NewScrollFragmentAdapter etV;
    private a etW;
    private com.baidu.tieba.c.d etX;
    private boolean etY;
    public CustomMessageListener etZ;
    public CustomMessageListener eua;
    private b eub;
    private e euc;
    private com.baidu.tieba.homepage.framework.d eud;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes6.dex */
    public interface a {
        void oE(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.bpk = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.etV != null) {
                    ScrollFragmentTabHost.this.etV.b(view, i, i2, i3, i4);
                }
            }
        };
        this.etZ = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.etR != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.etR.animate().translationY(-ScrollFragmentTabHost.this.etR.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.etR.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.eua = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.etV != null) {
                    ScrollFragmentTabHost.this.etV.aKH();
                }
                if (ScrollFragmentTabHost.this.etT != null) {
                    ScrollFragmentTabHost.this.etT.notifyDataSetChanged();
                }
            }
        };
        this.eub = new b();
        this.euc = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.e
            public void ou(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.etV.ow(i), false);
                ScrollFragmentTabHost.this.etV.oy(i);
            }
        };
        this.eud = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.d
            public void ot(int i) {
                ScrollFragmentTabHost.this.eub.a(i, ScrollFragmentTabHost.this.euc);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bpk = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.etV != null) {
                    ScrollFragmentTabHost.this.etV.b(view, i, i2, i3, i4);
                }
            }
        };
        this.etZ = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.etR != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.etR.animate().translationY(-ScrollFragmentTabHost.this.etR.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.etR.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.eua = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.etV != null) {
                    ScrollFragmentTabHost.this.etV.aKH();
                }
                if (ScrollFragmentTabHost.this.etT != null) {
                    ScrollFragmentTabHost.this.etT.notifyDataSetChanged();
                }
            }
        };
        this.eub = new b();
        this.euc = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.e
            public void ou(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.etV.ow(i), false);
                ScrollFragmentTabHost.this.etV.oy(i);
            }
        };
        this.eud = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.d
            public void ot(int i) {
                ScrollFragmentTabHost.this.eub.a(i, ScrollFragmentTabHost.this.euc);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.etR = (ObservedChangeLinearLayout) findViewById(e.g.home_page_fragment_tab_layout);
        this.etS = findViewById(e.g.home_page_statebar_view);
        this.etT = (HomeTabBarView) findViewById(e.g.home_tab_bar_view);
        this.doq = (PluginErrorTipView) findViewById(e.g.view_plugin_error_tip);
        this.bOx = (NoNetworkView) findViewById(e.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(e.g.home_pager_container);
        this.azq = (CustomViewPager) findViewById(e.g.tab_widget_view_pager);
        this.etU = findViewById(e.g.home_statebar_view);
        this.byP = findViewById(e.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.etS.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.etR.setOnSizeChangeListener(this.bpk);
        this.etT.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.etV.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.etW != null) {
                    ScrollFragmentTabHost.this.etW.oE(i);
                }
                com.baidu.tbadk.core.bigday.b.xS().aX(ScrollFragmentTabHost.this.etV.ov(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.oD(i) == 3) {
                    am amVar = new am("c12478");
                    amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(amVar);
                }
                if (ScrollFragmentTabHost.this.oD(i) == 4) {
                    TiebaStatic.log(new am("c13172").x("obj_type", ScrollFragmentTabHost.this.etY ? 2 : 1));
                    ScrollFragmentTabHost.this.etY = false;
                }
                ScrollFragmentTabHost.this.aKR();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aKN = ScrollFragmentTabHost.this.aKN();
                    TiebaStatic.log(new am("c12350").x("obj_type", aKN ? 1 : 0));
                    if (aKN && ScrollFragmentTabHost.this.etV != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.etV.aKL();
                        ScrollFragmentTabHost.this.etV.notifyDataSetChanged();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.etT.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void s(View view, int i) {
                if (ScrollFragmentTabHost.this.azq.getCurrentItem() != i && ScrollFragmentTabHost.this.oD(i) == 4) {
                    ScrollFragmentTabHost.this.etY = true;
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.bOx.a(aVar);
        MessageManager.getInstance().registerListener(this.etZ);
        MessageManager.getInstance().registerListener(this.eua);
    }

    public void notifyDataSetChanged() {
        if (this.etV != null && !HomePageStatic.epQ) {
            this.azq.setAdapter(this.etV);
            this.etT.notifyDataSetChanged();
            this.eub.a(this.euc);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.etV != null) {
            this.etV.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.etV != null) {
            this.etV.d(dataRes, z);
        }
    }

    public void aKK() {
        if (this.etV != null) {
            this.etV.aKK();
        }
    }

    public void w(String str, int i, int i2) {
        if (this.azq != null) {
            this.etV.w(str, i, i2);
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
        this.etV = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.etV.setScrollFragmentTabHost(this);
        this.azq.setOffscreenPageLimit(2);
        this.azq.setAdapter(this.etV);
        int aKG = this.etV.aKG();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.etV;
            if (HomePageStatic.epQ) {
                i = 0;
            }
            this.azq.setCurrentItem(newScrollFragmentAdapter.ow(i));
            this.etT.setViewPager(this.azq);
            this.etT.setConcernTabIndex(this.etV.ow(0));
            if (this.etQ != null) {
                this.etV.setRecommendFrsNavigationAnimDispatcher(this.etQ);
            }
            aKR();
        }
        i = aKG;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.etV;
        if (HomePageStatic.epQ) {
        }
        this.azq.setCurrentItem(newScrollFragmentAdapter2.ow(i));
        this.etT.setViewPager(this.azq);
        this.etT.setConcernTabIndex(this.etV.ow(0));
        if (this.etQ != null) {
        }
        aKR();
    }

    public boolean aKP() {
        return this.etV != null && this.etV.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.etV.getCount()) {
            this.etT.setTabItemClicked(z);
            this.etV.oz(i);
            this.azq.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.etV.ow(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.etT.setPageUniqueId(bdUniqueId);
        this.etZ.setTag(bdUniqueId);
        this.eua.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.etV.ov(this.azq.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.azq.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.etV.ov(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int oD(int i) {
        return this.etV.ov(i);
    }

    public void onChangeSkinType(int i) {
        al.j(this.etS, e.d.cp_bg_line_d);
        this.etT.onChangeSkinType();
        if (this.mPageContext != null && this.bOx != null) {
            this.bOx.onChangeSkinType(this.mPageContext, i);
        }
        if (this.etV != null) {
            this.etV.eC(i);
        }
        if (this.mPageContext != null && this.doq != null) {
            this.doq.onChangeSkinType(this.mPageContext, i);
        }
        al.j(this.etU, e.d.cp_bg_line_d);
        al.j(this.byP, e.d.cp_bg_line_c);
    }

    public void aKM() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.etV != null) {
            this.etV.aKM();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4) && this.etV != null) {
            this.etV.aKM();
        }
    }

    public void aaW() {
        this.etV.aaW();
    }

    public String getCurrentPageKey() {
        if (this.etV != null) {
            return this.etV.getCurrentPageKey();
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
        if (this.etV != null) {
            this.etV.setPrimary(z);
        }
        if (this.bOx != null && z) {
            this.bOx.setVisibility(j.kK() ? 8 : 0);
        }
    }

    public void aKQ() {
        this.etV.a(this.eud);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.etW = aVar;
    }

    public void onDestroy() {
        if (this.etQ != null) {
            this.etQ.onDestroy();
        }
        aKT();
    }

    public void aKR() {
        int i = 1;
        if (this.etV != null) {
            int ov = this.etV.ov(this.azq.getCurrentItem());
            if (ov == 0) {
                i = 0;
            } else if (ov != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.etT != null && this.etV.aKJ()) {
            this.etT.setShowConcernRedTip(z);
        }
    }

    public boolean aKN() {
        if (this.etT == null || !this.etV.aKJ()) {
            return false;
        }
        return this.etT.aKN();
    }

    public void setVideoThreadId(String str) {
        if (this.etV != null) {
            this.etV.setVideoThreadId(str);
        }
    }

    public void aKS() {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int ow = this.etV != null ? this.etV.ow(0) : 0;
            if (this.etX == null) {
                this.etX = new com.baidu.tieba.c.d(this.mPageContext, this.etT.oA(ow));
                this.etX.kU(e.f.bg_tip_blue_up);
                this.etX.kT(32);
                this.etX.fG(true);
                this.etX.aa(true);
                this.etX.setYOffset(l.h(this.mContext, e.C0210e.ds16));
                this.etX.kV(UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
            }
            this.etX.h(this.mContext.getString(e.j.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void aKT() {
        if (this.etX != null) {
            this.etX.arm();
        }
    }

    public void onResume() {
        if (this.etT != null) {
            this.etT.onResume();
        }
    }
}
