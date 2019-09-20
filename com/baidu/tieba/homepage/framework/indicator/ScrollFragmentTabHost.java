package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
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
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.BdToken.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.util.w;
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
/* loaded from: classes4.dex */
public class ScrollFragmentTabHost extends RelativeLayout {
    private CustomViewPager bRh;
    private View cVw;
    private NoNetworkView dpy;
    private View drb;
    private AlphaAnimation dre;
    private AlphaAnimation drf;
    private PluginErrorTipView eYM;
    private List<a> eZN;
    private StickyAppBarLayout giA;
    private NestedScrollHeader giB;
    private d giC;
    CustomMessageTask giD;
    CustomMessageTask giE;
    CustomMessageListener giF;
    private c giG;
    private e giH;
    private com.baidu.tieba.homepage.framework.d giI;
    private w gip;
    private View giq;
    private HomeTabBarView gir;
    private boolean gis;
    private NewScrollFragmentAdapter git;
    private b giu;
    private d giv;
    private boolean giw;
    public CustomMessageListener gix;
    public CustomMessageListener giy;
    CustomMessageListener giz;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void uc(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.gix = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                }
            }
        };
        this.giy = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.git != null) {
                    ScrollFragmentTabHost.this.git.bwz();
                }
                if (ScrollFragmentTabHost.this.gir != null) {
                    ScrollFragmentTabHost.this.gir.notifyDataSetChanged();
                }
            }
        };
        this.giz = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aKa();
                } else {
                    ScrollFragmentTabHost.this.aKb();
                }
            }
        };
        this.giD = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.giA == null || ScrollFragmentTabHost.this.giB == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.gir.getTaskView() : ScrollFragmentTabHost.this.giB.getTaskView();
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
                    if (ScrollFragmentTabHost.this.giC != null) {
                        ScrollFragmentTabHost.this.giC.bcf();
                    }
                    ScrollFragmentTabHost.this.giC = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.giC.qe(48);
                    ScrollFragmentTabHost.this.giC.S(true);
                    ScrollFragmentTabHost.this.giC.qd(4);
                    ScrollFragmentTabHost.this.giC.qg(i);
                    ScrollFragmentTabHost.this.giC.iU(true);
                    ScrollFragmentTabHost.this.giC.qi(0);
                    ScrollFragmentTabHost.this.giC.wi(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.giE = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.giA == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aKb();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.giA.bwP();
                } else if (!ScrollFragmentTabHost.this.giA.isSticky()) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.giA.bwP();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.giF = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.giC != null) {
                    ScrollFragmentTabHost.this.giC.bcf();
                    ScrollFragmentTabHost.this.giC = null;
                }
            }
        };
        this.giG = new c();
        this.giH = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.e
            public void tS(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.git.tU(i), false);
                ScrollFragmentTabHost.this.git.tW(i);
            }
        };
        this.giI = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.d
            public void tR(int i) {
                ScrollFragmentTabHost.this.giG.a(i, ScrollFragmentTabHost.this.giH);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gix = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                }
            }
        };
        this.giy = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.git != null) {
                    ScrollFragmentTabHost.this.git.bwz();
                }
                if (ScrollFragmentTabHost.this.gir != null) {
                    ScrollFragmentTabHost.this.gir.notifyDataSetChanged();
                }
            }
        };
        this.giz = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aKa();
                } else {
                    ScrollFragmentTabHost.this.aKb();
                }
            }
        };
        this.giD = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.giA == null || ScrollFragmentTabHost.this.giB == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.gir.getTaskView() : ScrollFragmentTabHost.this.giB.getTaskView();
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
                    if (ScrollFragmentTabHost.this.giC != null) {
                        ScrollFragmentTabHost.this.giC.bcf();
                    }
                    ScrollFragmentTabHost.this.giC = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.giC.qe(48);
                    ScrollFragmentTabHost.this.giC.S(true);
                    ScrollFragmentTabHost.this.giC.qd(4);
                    ScrollFragmentTabHost.this.giC.qg(i);
                    ScrollFragmentTabHost.this.giC.iU(true);
                    ScrollFragmentTabHost.this.giC.qi(0);
                    ScrollFragmentTabHost.this.giC.wi(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.giE = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.giA == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aKb();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.giA.bwP();
                } else if (!ScrollFragmentTabHost.this.giA.isSticky()) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.giA.bwP();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.giF = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.giC != null) {
                    ScrollFragmentTabHost.this.giC.bcf();
                    ScrollFragmentTabHost.this.giC = null;
                }
            }
        };
        this.giG = new c();
        this.giH = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.e
            public void tS(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.git.tU(i), false);
                ScrollFragmentTabHost.this.git.tW(i);
            }
        };
        this.giI = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.d
            public void tR(int i) {
                ScrollFragmentTabHost.this.giG.a(i, ScrollFragmentTabHost.this.giH);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.giA = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.giB = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.giq = findViewById(R.id.home_page_statebar_view);
        this.gir = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.eYM = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.dpy = (NoNetworkView) findViewById(R.id.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(R.id.home_pager_container);
        this.bRh = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.cVw = findViewById(R.id.divider_line);
        this.drb = findViewById(R.id.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.giq.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.gir.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.git.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.giu != null) {
                    ScrollFragmentTabHost.this.giu.uc(i);
                }
                com.baidu.tbadk.core.bigday.b.acs().dG(ScrollFragmentTabHost.this.git.tT(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.ub(i) == 3) {
                    an anVar = new an("c12478");
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(anVar);
                }
                if (ScrollFragmentTabHost.this.ub(i) == 4) {
                    TiebaStatic.log(new an("c13172").P("obj_type", ScrollFragmentTabHost.this.giw ? 2 : 1));
                    ScrollFragmentTabHost.this.giw = false;
                } else if (ScrollFragmentTabHost.this.ub(i) == 6) {
                    TiebaStatic.log("c13545");
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.ub(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.eZN != null && ScrollFragmentTabHost.this.git != null) {
                    int tT = ScrollFragmentTabHost.this.git.tT(ScrollFragmentTabHost.this.bRh.getCurrentItem());
                    if (tT == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.eZN) {
                            aVar.bwN();
                        }
                    } else if (tT == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.eZN) {
                            aVar2.bwM();
                        }
                    } else if (tT == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.eZN) {
                            aVar3.bvV();
                        }
                    } else if (tT == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (tT == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.aKb();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.bwJ();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.ub(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean bwE = ScrollFragmentTabHost.this.bwE();
                    TiebaStatic.log(new an("c12350").P("obj_type", bwE ? 1 : 0));
                    if (bwE && ScrollFragmentTabHost.this.git != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.git.bwC();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.gir.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void r(View view, int i) {
                if (ScrollFragmentTabHost.this.bRh.getCurrentItem() != i && ScrollFragmentTabHost.this.ub(i) == 4) {
                    ScrollFragmentTabHost.this.giw = true;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.bRh.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.ub(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.ub(i) == 7) {
                    TiebaStatic.log(new an("c13483").bT("obj_type", "1"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.ub(i));
            }
        });
        this.giA.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void lo(boolean z) {
                if (z && ScrollFragmentTabHost.this.giC != null) {
                    ScrollFragmentTabHost.this.giC.bcf();
                }
            }
        });
        this.giB.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void yD(String str) {
                if (ScrollFragmentTabHost.this.giC != null) {
                    ScrollFragmentTabHost.this.giC.bcf();
                    ScrollFragmentTabHost.this.giC = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    ba.ajK().c(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.giB.setVisibility(8);
            this.gir.setMissionEntranceVisibility(true);
            this.gir.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void yD(String str) {
                    if (ScrollFragmentTabHost.this.giC != null) {
                        ScrollFragmentTabHost.this.giC.bcf();
                        ScrollFragmentTabHost.this.giC = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        ba.ajK().c(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.giB.setVisibility(0);
        this.gir.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.giE.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.giE);
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
        this.dpy.a(aVar);
        MessageManager.getInstance().registerListener(this.gix);
        MessageManager.getInstance().registerListener(this.giy);
        MessageManager.getInstance().registerListener(this.giz);
        MessageManager.getInstance().registerListener(this.giF);
        this.giD.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.giD);
    }

    public void notifyDataSetChanged() {
        if (this.git != null && !HomePageStatic.ged) {
            this.bRh.setAdapter(this.git);
            this.gir.notifyDataSetChanged();
            this.giG.a(this.giH);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.git != null) {
            this.git.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.git != null) {
            this.git.d(dataRes, z);
        }
    }

    public void bwB() {
        if (this.git != null) {
            this.git.bwB();
        }
    }

    public void v(String str, int i, int i2) {
        if (this.bRh != null) {
            this.git.v(str, i, i2);
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
        this.git = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.git.setScrollFragmentTabHost(this);
        this.bRh.setOffscreenPageLimit(2);
        this.bRh.setAdapter(this.git);
        int bwy = this.git.bwy();
        if (com.baidu.tbadk.core.sharedPref.b.ahU().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.git;
            if (HomePageStatic.ged) {
                i = 0;
            }
            this.bRh.setCurrentItem(newScrollFragmentAdapter.tU(i));
            this.gir.setViewPager(this.bRh);
            this.gir.setConcernTabIndex(this.git.tU(0));
            if (this.gip != null) {
                this.git.setRecommendFrsNavigationAnimDispatcher(this.gip);
            }
            bwJ();
        }
        i = bwy;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.git;
        if (HomePageStatic.ged) {
        }
        this.bRh.setCurrentItem(newScrollFragmentAdapter2.tU(i));
        this.gir.setViewPager(this.bRh);
        this.gir.setConcernTabIndex(this.git.tU(0));
        if (this.gip != null) {
        }
        bwJ();
    }

    public boolean bwH() {
        return this.git != null && this.git.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.git.getCount()) {
            this.gir.setTabItemClicked(z);
            this.git.tX(i);
            this.bRh.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.git.tU(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gir.setPageUniqueId(bdUniqueId);
        this.gix.setTag(bdUniqueId);
        this.giy.setTag(bdUniqueId);
        this.giz.setTag(bdUniqueId);
        this.giF.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.git.tT(this.bRh.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.bRh.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.git.tT(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int ub(int i) {
        return this.git.tT(i);
    }

    public void onChangeSkinType(int i) {
        am.l(this.giq, R.color.cp_bg_line_h);
        this.giB.onChangeSkinType();
        this.gir.onChangeSkinType();
        if (this.mPageContext != null && this.dpy != null) {
            this.dpy.onChangeSkinType(this.mPageContext, i);
        }
        if (this.git != null) {
            this.git.jg(i);
        }
        if (this.mPageContext != null && this.eYM != null) {
            this.eYM.onChangeSkinType(this.mPageContext, i);
        }
        am.l(this.cVw, R.color.cp_bg_line_c);
    }

    private boolean aJZ() {
        return this.drb.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.gis = z;
        if (z) {
            if (this.cVw != null) {
                this.cVw.setVisibility(8);
            }
        } else if (this.cVw != null) {
            this.cVw.setVisibility(0);
        }
    }

    public void aKa() {
        if (this.gis && !aJZ()) {
            this.drb.setVisibility(0);
            if (this.dre == null) {
                this.dre = new AlphaAnimation(0.0f, 1.0f);
                this.dre.setFillAfter(true);
                this.dre.setDuration(300L);
            }
            this.drb.startAnimation(this.dre);
        }
    }

    public void aKb() {
        if (this.gis && aJZ()) {
            if (this.drf == null) {
                this.drf = new AlphaAnimation(1.0f, 0.0f);
                this.drf.setFillAfter(true);
                this.drf.setDuration(300L);
                this.drf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.drb.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.drb.startAnimation(this.drf);
        }
    }

    public void bwD() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.git != null) {
            this.git.bwD();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4 || currentTabType == 5 || currentTabType == 6 || currentTabType == 7) && this.git != null) {
            this.git.bwD();
        }
    }

    public void aKN() {
        this.git.aKN();
    }

    public String getCurrentPageKey() {
        if (this.git != null) {
            return this.git.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.bRh != null) {
            return this.bRh.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.git != null) {
            this.git.setPrimary(z);
        }
        if (this.dpy != null && z) {
            this.dpy.setVisibility(j.jQ() ? 8 : 0);
        }
    }

    public void bwI() {
        this.git.a(this.giI);
    }

    public void kf(boolean z) {
        if (!z && this.gir != null && this.gir.getTaskView() != null && this.gir.getTaskView().getVisibility() != 0) {
            this.gir.bwQ();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.giu = bVar;
    }

    public void onDestroy() {
        if (this.gip != null) {
            this.gip.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.giC != null) {
            this.giC.bcf();
            this.giC = null;
        }
        bwL();
    }

    public void bwJ() {
        int i = 1;
        if (this.git != null) {
            int tT = this.git.tT(this.bRh.getCurrentItem());
            if (tT == 0) {
                i = 0;
            } else if (tT != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.ahU().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.gir != null && this.git.bwA()) {
            this.gir.setShowConcernRedTip(z);
        }
    }

    public boolean bwE() {
        if (this.gir == null || !this.git.bwA()) {
            return false;
        }
        return this.gir.bwE();
    }

    public void setVideoThreadId(String str) {
        if (this.git != null) {
            this.git.setVideoThreadId(str);
        }
    }

    public void bwK() {
        if (com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int tU = this.git != null ? this.git.tU(0) : 0;
            if (this.giv == null) {
                this.giv = new d(this.mPageContext, this.gir.tY(tU));
                this.giv.qf(R.drawable.bg_tip_blue_up);
                this.giv.qe(32);
                this.giv.iU(true);
                this.giv.S(true);
                this.giv.setYOffset(l.g(this.mContext, R.dimen.ds16));
                this.giv.qg(UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
            }
            this.giv.v(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void bwL() {
        if (this.giv != null) {
            this.giv.bcf();
        }
    }

    public void onResume() {
        if (this.gir != null) {
            this.gir.onResume();
        }
    }

    public void a(a aVar) {
        if (this.eZN == null) {
            this.eZN = new ArrayList();
        }
        this.eZN.add(aVar);
    }

    public void b(a aVar) {
        if (this.eZN != null && this.eZN.size() > 0) {
            this.eZN.remove(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void bwM() {
        }

        public void bwN() {
        }

        public void bvV() {
        }
    }
}
