package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BdToken.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.c.d;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.e;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class ScrollFragmentTabHost extends RelativeLayout {
    private CustomViewPager cYb;
    private View cen;
    private FrameLayout cvf;
    private NoNetworkView elv;
    private View enI;
    private AlphaAnimation enL;
    private AlphaAnimation enM;
    private PluginErrorTipView fVe;
    private List<a> fWc;
    private HomeTabBarView haf;
    private boolean hag;
    private NewScrollFragmentAdapter hah;
    private b hai;
    private d haj;
    CustomMessageListener hak;
    CustomMessageListener hal;
    CustomMessageTask ham;
    CustomMessageTask han;
    private StickyAppBarLayout hao;
    private NestedScrollHeader hap;
    private d haq;
    private com.baidu.tieba.homepage.framework.indicator.b har;
    private e has;
    private com.baidu.tieba.homepage.framework.d hat;
    private boolean isPrimary;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes9.dex */
    public interface b {
        void vk(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.hak = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bcN();
                } else {
                    ScrollFragmentTabHost.this.bcO();
                }
            }
        };
        this.hal = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.haq != null) {
                    ScrollFragmentTabHost.this.haq.zz();
                    ScrollFragmentTabHost.this.haq = null;
                }
            }
        };
        this.ham = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.hao == null || ScrollFragmentTabHost.this.hap == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.haf.getTaskView() : ScrollFragmentTabHost.this.hap.getTaskView();
                if ((taskView == null || taskView.getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof n.a)) {
                    n.a data = customMessage.getData();
                    int i = 5000;
                    if (data.duration.intValue() > 0) {
                        i = data.duration.intValue() * 1000;
                    }
                    String str = data.toast;
                    if (TextUtils.isEmpty(str)) {
                        str = ScrollFragmentTabHost.this.mPageContext.getString(R.string.task_float_tip_toast);
                    }
                    String fixedText = UtilHelper.getFixedText(str, 20);
                    if (ScrollFragmentTabHost.this.haq != null) {
                        ScrollFragmentTabHost.this.haq.zz();
                    }
                    ScrollFragmentTabHost.this.haq = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.haq.cj(48);
                    ScrollFragmentTabHost.this.haq.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.haq.rx(4);
                    ScrollFragmentTabHost.this.haq.cl(i);
                    ScrollFragmentTabHost.this.haq.kw(true);
                    ScrollFragmentTabHost.this.haq.rz(0);
                    ScrollFragmentTabHost.this.haq.Ad(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.han = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.hao == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bcO();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.hao.bNR();
                } else if (ScrollFragmentTabHost.this.hao.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.hao.bNR();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.har = new com.baidu.tieba.homepage.framework.indicator.b();
        this.has = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void vb(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.hah.vd(i), false);
                ScrollFragmentTabHost.this.hah.vf(i);
            }
        };
        this.hat = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void va(int i) {
                ScrollFragmentTabHost.this.har.a(i, ScrollFragmentTabHost.this.has);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hak = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bcN();
                } else {
                    ScrollFragmentTabHost.this.bcO();
                }
            }
        };
        this.hal = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.haq != null) {
                    ScrollFragmentTabHost.this.haq.zz();
                    ScrollFragmentTabHost.this.haq = null;
                }
            }
        };
        this.ham = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.hao == null || ScrollFragmentTabHost.this.hap == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.haf.getTaskView() : ScrollFragmentTabHost.this.hap.getTaskView();
                if ((taskView == null || taskView.getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof n.a)) {
                    n.a data = customMessage.getData();
                    int i = 5000;
                    if (data.duration.intValue() > 0) {
                        i = data.duration.intValue() * 1000;
                    }
                    String str = data.toast;
                    if (TextUtils.isEmpty(str)) {
                        str = ScrollFragmentTabHost.this.mPageContext.getString(R.string.task_float_tip_toast);
                    }
                    String fixedText = UtilHelper.getFixedText(str, 20);
                    if (ScrollFragmentTabHost.this.haq != null) {
                        ScrollFragmentTabHost.this.haq.zz();
                    }
                    ScrollFragmentTabHost.this.haq = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.haq.cj(48);
                    ScrollFragmentTabHost.this.haq.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.haq.rx(4);
                    ScrollFragmentTabHost.this.haq.cl(i);
                    ScrollFragmentTabHost.this.haq.kw(true);
                    ScrollFragmentTabHost.this.haq.rz(0);
                    ScrollFragmentTabHost.this.haq.Ad(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.han = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.hao == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bcO();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.hao.bNR();
                } else if (ScrollFragmentTabHost.this.hao.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.hao.bNR();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.har = new com.baidu.tieba.homepage.framework.indicator.b();
        this.has = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void vb(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.hah.vd(i), false);
                ScrollFragmentTabHost.this.hah.vf(i);
            }
        };
        this.hat = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void va(int i) {
                ScrollFragmentTabHost.this.har.a(i, ScrollFragmentTabHost.this.has);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.hao = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.hap = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.haf = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.fVe = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.elv = (NoNetworkView) findViewById(R.id.view_no_network);
        this.cvf = (FrameLayout) findViewById(R.id.home_pager_container);
        this.cYb = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.cen = findViewById(R.id.divider_line);
        this.enI = findViewById(R.id.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hao.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.cvf.getLayoutParams()).topMargin = 0;
        this.haf.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.hah.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.hai != null) {
                    ScrollFragmentTabHost.this.hai.vk(i);
                }
                com.baidu.tbadk.core.bigday.b.azW().ft(ScrollFragmentTabHost.this.hah.vc(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.vj(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.fWc != null && ScrollFragmentTabHost.this.hah != null) {
                    int vc = ScrollFragmentTabHost.this.hah.vc(ScrollFragmentTabHost.this.cYb.getCurrentItem());
                    if (vc == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.fWc) {
                            aVar.bNP();
                        }
                    } else if (vc == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.fWc) {
                            aVar2.bNO();
                        }
                    } else if (vc == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.fWc) {
                            aVar3.bNh();
                        }
                    } else if (vc == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (vc == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (vc == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.bcO();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.bNL();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.vj(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean bNG = ScrollFragmentTabHost.this.bNG();
                    TiebaStatic.log(new an("c12350").X("obj_type", bNG ? 1 : 0));
                    if (bNG && ScrollFragmentTabHost.this.hah != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.hah.bNE();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.haf.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void k(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.cYb.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.vj(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.vj(i) == 7) {
                    TiebaStatic.log(new an("c13483").cy("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.vj(i) == 8) {
                    TiebaStatic.log(new an("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.vj(i));
            }
        });
        this.hao.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void mC(boolean z) {
                if (z && ScrollFragmentTabHost.this.haq != null) {
                    ScrollFragmentTabHost.this.haq.zz();
                }
            }
        });
        this.hap.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void Cg(String str) {
                if (ScrollFragmentTabHost.this.haq != null) {
                    ScrollFragmentTabHost.this.haq.zz();
                    ScrollFragmentTabHost.this.haq = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    ba.aGG().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.hap.setVisibility(8);
            this.haf.setMissionEntranceVisibility(true);
            this.haf.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void Cg(String str) {
                    if (ScrollFragmentTabHost.this.haq != null) {
                        ScrollFragmentTabHost.this.haq.zz();
                        ScrollFragmentTabHost.this.haq = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        ba.aGG().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.hap.setVisibility(0);
        this.haf.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.han.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.han);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            MessageManager.getInstance().unRegisterTask(2921405);
        }
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.elv.a(aVar);
        MessageManager.getInstance().registerListener(this.hak);
        MessageManager.getInstance().registerListener(this.hal);
        this.ham.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.ham);
    }

    public void notifyDataSetChanged() {
        if (this.hah != null && !HomePageStatic.gWw) {
            this.cYb.setAdapter(this.hah);
            this.haf.notifyDataSetChanged();
            this.har.a(this.has);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.hah != null) {
            this.hah.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.hah != null) {
            this.hah.d(dataRes, z);
        }
    }

    public void bND() {
        if (this.hah != null) {
            this.hah.bND();
        }
    }

    public void w(String str, int i, int i2) {
        if (this.cYb != null) {
            this.hah.w(str, i, i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0065, code lost:
        if (r3 != 1) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        int i = 1;
        this.hah = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.hah.setScrollFragmentTabHost(this);
        this.cYb.setOffscreenPageLimit(2);
        this.cYb.setAdapter(this.hah);
        int bNB = this.hah.bNB();
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.aFD().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.hah;
            if (HomePageStatic.gWw) {
                i = 0;
            }
            this.cYb.setCurrentItem(newScrollFragmentAdapter.vd(i));
            this.haf.setViewPager(this.cYb);
            this.haf.setConcernTabIndex(this.hah.vd(0));
            bNL();
        }
        i = bNB;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.hah;
        if (HomePageStatic.gWw) {
        }
        this.cYb.setCurrentItem(newScrollFragmentAdapter2.vd(i));
        this.haf.setViewPager(this.cYb);
        this.haf.setConcernTabIndex(this.hah.vd(0));
        bNL();
    }

    public boolean bNJ() {
        return this.hah != null && this.hah.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.hah.getCount()) {
            this.haf.setTabItemClicked(z);
            this.hah.vg(i);
            this.cYb.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.hah.vd(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.haf.setPageUniqueId(bdUniqueId);
        this.hak.setTag(bdUniqueId);
        this.hal.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.cvf;
    }

    public int getCurrentTabType() {
        return this.hah.vc(this.cYb.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.cYb.getAdapter() != null) {
            int count = this.cYb.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.hah.vc(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int vj(int i) {
        return this.hah.vc(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.hao, R.color.cp_bg_line_h);
        this.hap.onChangeSkinType();
        this.haf.onChangeSkinType();
        if (this.mPageContext != null && this.elv != null) {
            this.elv.onChangeSkinType(this.mPageContext, i);
        }
        if (this.hah != null) {
            this.hah.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.fVe != null) {
            this.fVe.onChangeSkinType(this.mPageContext, i);
        }
        am.setBackgroundColor(this.cen, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.enI, R.drawable.personalize_tab_shadow);
    }

    private boolean bcM() {
        return this.enI.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.hag = z;
        if (z) {
            if (this.cen != null) {
                this.cen.setVisibility(8);
            }
        } else if (this.cen != null) {
            this.cen.setVisibility(0);
        }
    }

    public void bcN() {
        if (this.hag && !bcM()) {
            this.enI.setVisibility(0);
            if (this.enL == null) {
                this.enL = new AlphaAnimation(0.0f, 1.0f);
                this.enL.setFillAfter(true);
                this.enL.setDuration(300L);
            }
            this.enI.startAnimation(this.enL);
        }
    }

    public void bcO() {
        if (this.hag && bcM()) {
            if (this.enM == null) {
                this.enM = new AlphaAnimation(1.0f, 0.0f);
                this.enM.setFillAfter(true);
                this.enM.setDuration(300L);
                this.enM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.enI.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.enI.startAnimation(this.enM);
        }
    }

    public void bNF() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.hah != null) {
            this.hah.bNF();
        }
        if ((currentTabType == 1 || currentTabType == 8 || currentTabType == 5 || currentTabType == 6 || currentTabType == 7) && this.hah != null) {
            this.hah.bNF();
        }
    }

    public void bdr() {
        this.hah.bdr();
    }

    public String getCurrentPageKey() {
        if (this.hah != null) {
            return this.hah.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.cYb != null) {
            return this.cYb.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.hah != null) {
            this.hah.setPrimary(z);
        }
        if (this.elv != null && z) {
            this.elv.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void bNK() {
        this.hah.a(this.hat);
    }

    public void lt(boolean z) {
        if (!z && this.haf != null && this.haf.getTaskView() != null && this.haf.getTaskView().getVisibility() != 0) {
            this.haf.bNT();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.hai = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.haq != null) {
            this.haq.zz();
            this.haq = null;
        }
        bNN();
    }

    public void bNL() {
        int i = 1;
        if (this.hah != null) {
            int vc = this.hah.vc(this.cYb.getCurrentItem());
            if (vc == 0) {
                i = 0;
            } else if (vc != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.haf != null && this.hah.bNC()) {
            this.haf.setShowConcernRedTip(z);
        }
    }

    public boolean bNG() {
        if (this.haf == null || !this.hah.bNC()) {
            return false;
        }
        return this.haf.bNG();
    }

    public void setVideoThreadId(String str) {
        if (this.hah != null) {
            this.hah.setVideoThreadId(str);
        }
    }

    public void bNM() {
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int vd = this.hah != null ? this.hah.vd(0) : 0;
            if (this.haj == null) {
                this.haj = new d(this.mPageContext, this.haf.vh(vd));
                this.haj.ck(R.drawable.bg_tip_blue_up);
                this.haj.cj(32);
                this.haj.kw(true);
                this.haj.setUseDirectOffset(true);
                this.haj.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.haj.cl(4000);
            }
            this.haj.d(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void bNN() {
        if (this.haj != null) {
            this.haj.zz();
        }
    }

    public void onResume() {
        if (this.haf != null) {
            this.haf.onResume();
        }
    }

    public void a(a aVar) {
        if (this.fWc == null) {
            this.fWc = new ArrayList();
        }
        this.fWc.add(aVar);
    }

    public void b(a aVar) {
        if (this.fWc != null && this.fWc.size() > 0) {
            this.fWc.remove(aVar);
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class a {
        public void bNO() {
        }

        public void bNP() {
        }

        public void bNh() {
        }
    }
}
