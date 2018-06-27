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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.e;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private FrameLayout alG;
    private CustomViewPager aoe;
    private final d bdi;
    private View bjZ;
    private NoNetworkView buT;
    private PluginErrorTipView cPN;
    private t dSD;
    private ObservedChangeLinearLayout dSE;
    private View dSF;
    private HomeTabBarView dSG;
    private View dSH;
    private NewScrollFragmentAdapter dSI;
    private a dSJ;
    private com.baidu.tieba.c.d dSK;
    public CustomMessageListener dSL;
    private b dSM;
    private e dSN;
    private com.baidu.tieba.homepage.framework.d dSO;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void mC(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.bdi = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dSI != null) {
                    ScrollFragmentTabHost.this.dSI.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dSL = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.dSE != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.dSE.animate().translationY(-ScrollFragmentTabHost.this.dSE.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.dSE.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.dSM = new b();
        this.dSN = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void ms(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.dSI.mu(i), false);
                ScrollFragmentTabHost.this.dSI.mw(i);
            }
        };
        this.dSO = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void mr(int i) {
                ScrollFragmentTabHost.this.dSM.a(i, ScrollFragmentTabHost.this.dSN);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdi = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dSI != null) {
                    ScrollFragmentTabHost.this.dSI.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dSL = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.dSE != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.dSE.animate().translationY(-ScrollFragmentTabHost.this.dSE.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.dSE.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.dSM = new b();
        this.dSN = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void ms(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.dSI.mu(i), false);
                ScrollFragmentTabHost.this.dSI.mw(i);
            }
        };
        this.dSO = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void mr(int i) {
                ScrollFragmentTabHost.this.dSM.a(i, ScrollFragmentTabHost.this.dSN);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.i.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.dSE = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.dSF = findViewById(d.g.home_page_statebar_view);
        this.dSG = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.cPN = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.buT = (NoNetworkView) findViewById(d.g.view_no_network);
        this.alG = (FrameLayout) findViewById(d.g.home_pager_container);
        this.aoe = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.dSH = findViewById(d.g.home_statebar_view);
        this.bjZ = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dSF.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.dSE.setOnSizeChangeListener(this.bdi);
        this.dSG.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.dSI.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.dSJ != null) {
                    ScrollFragmentTabHost.this.dSJ.mC(i);
                }
                com.baidu.tbadk.core.bigday.b.tJ().aq(ScrollFragmentTabHost.this.dSI.mt(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.mB(i) == 3) {
                    an anVar = new an("c12478");
                    anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(anVar);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aCY = ScrollFragmentTabHost.this.aCY();
                    TiebaStatic.log(new an("c12350").r("obj_type", aCY ? 1 : 0));
                    if (aCY && ScrollFragmentTabHost.this.dSI != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.dSI.aCW();
                        ScrollFragmentTabHost.this.dSI.notifyDataSetChanged();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.buT.a(aVar);
        this.dSL.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.dSL);
    }

    public void notifyDataSetChanged() {
        if (this.dSI != null && !HomePageStatic.dPJ) {
            this.aoe.setAdapter(this.dSI);
            this.dSG.notifyDataSetChanged();
            this.dSM.a(this.dSN);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dSI != null) {
            this.dSI.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dSI != null) {
            this.dSI.d(dataRes, z);
        }
    }

    public void aCx() {
        if (this.dSI != null) {
            this.dSI.aCx();
        }
        if (this.dSI != null && this.aoe != null && this.aoe.getCurrentItem() == 0) {
            this.dSI.aCV();
        }
    }

    public void q(String str, int i, int i2) {
        if (this.aoe != null) {
            this.dSI.q(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.dSI = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.dSI.setScrollFragmentTabHost(this);
        this.aoe.setOffscreenPageLimit(2);
        this.aoe.setAdapter(this.dSI);
        this.aoe.setCurrentItem(this.dSI.mu(HomePageStatic.dPJ ? 0 : 1));
        this.dSG.setViewPager(this.aoe);
        if (this.dSD != null) {
            this.dSI.setRecommendFrsNavigationAnimDispatcher(this.dSD);
        }
    }

    public boolean aDa() {
        return this.dSI != null && this.dSI.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.dSI.getCount()) {
            this.dSG.setTabItemClicked(z);
            this.dSI.mx(i);
            this.aoe.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.dSI.mu(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dSG.setPageUniqueId(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.alG;
    }

    public int getCurrentTabType() {
        return this.dSI.mt(this.aoe.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.aoe.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.dSI.mt(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int mB(int i) {
        return this.dSI.mt(i);
    }

    public void onChangeSkinType(int i) {
        am.j(this.dSF, d.C0142d.cp_bg_line_d);
        this.dSG.onChangeSkinType();
        if (this.mPageContext != null && this.buT != null) {
            this.buT.onChangeSkinType(this.mPageContext, i);
        }
        if (this.dSI != null) {
            this.dSI.dD(i);
        }
        if (this.mPageContext != null && this.cPN != null) {
            this.cPN.onChangeSkinType(this.mPageContext, i);
        }
        am.j(this.dSH, d.C0142d.cp_bg_line_d);
        am.j(this.bjZ, d.C0142d.cp_bg_line_c);
    }

    public void aCX() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.dSI != null) {
            this.dSI.aCX();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.dSI != null) {
            this.dSI.aCX();
        }
    }

    public void Ua() {
        this.dSI.Ua();
    }

    public String getCurrentPageKey() {
        if (this.dSI != null) {
            return this.dSI.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.aoe != null) {
            return this.aoe.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.dSI != null) {
            this.dSI.setPrimary(z);
        }
        if (this.buT != null && z) {
            this.buT.setVisibility(j.jr() ? 8 : 0);
        }
    }

    public void aDb() {
        this.dSI.a(this.dSO);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dSJ = aVar;
    }

    public void onDestroy() {
        if (this.dSD != null) {
            this.dSD.onDestroy();
        }
        aDd();
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.dSG != null && this.dSI.aCU()) {
            this.dSG.setShowConcernRedTip(z);
        }
    }

    public boolean aCY() {
        if (this.dSG == null || !this.dSI.aCU()) {
            return false;
        }
        return this.dSG.aCY();
    }

    public void setVideoThreadId(String str) {
        if (this.dSI != null) {
            this.dSI.setVideoThreadId(str);
        }
    }

    public void aDc() {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int mu = this.dSI != null ? this.dSI.mu(0) : 0;
            if (this.dSK == null) {
                this.dSK = new com.baidu.tieba.c.d(this.mPageContext, this.dSG.my(mu));
                this.dSK.jd(d.f.bg_tip_blue_up);
                this.dSK.jc(32);
                this.dSK.eK(true);
                this.dSK.D(true);
                this.dSK.jh(l.e(this.mContext, d.e.ds16));
                this.dSK.je(4000);
            }
            this.dSK.h(this.mContext.getString(d.k.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void aDd() {
        if (this.dSK != null) {
            this.dSK.akn();
        }
    }

    public void onResume() {
        if (this.dSG != null) {
            this.dSG.onResume();
        }
    }
}
