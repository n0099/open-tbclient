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
    private View cDw;
    private FrameLayout cUm;
    private CustomViewPager dxy;
    private NoNetworkView ePl;
    private AlphaAnimation eRA;
    private AlphaAnimation eRB;
    private View eRx;
    private PluginErrorTipView gAH;
    private HomeTabBarView hLc;
    private boolean hLd;
    private NewScrollFragmentAdapter hLe;
    private b hLf;
    private d hLg;
    private List<a> hLh;
    CustomMessageListener hLi;
    CustomMessageListener hLj;
    CustomMessageTask hLk;
    CustomMessageTask hLl;
    private StickyAppBarLayout hLm;
    private NestedScrollHeader hLn;
    private d hLo;
    private com.baidu.tieba.homepage.framework.indicator.b hLp;
    private e hLq;
    private com.baidu.tieba.homepage.framework.d hLr;
    private boolean isPrimary;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes9.dex */
    public interface b {
        void vP(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.hLi = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.blI();
                } else {
                    ScrollFragmentTabHost.this.blJ();
                }
            }
        };
        this.hLj = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.hLo != null) {
                    ScrollFragmentTabHost.this.hLo.EE();
                    ScrollFragmentTabHost.this.hLo = null;
                }
            }
        };
        this.hLk = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.hLm == null || ScrollFragmentTabHost.this.hLn == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.hLc.getTaskView() : ScrollFragmentTabHost.this.hLn.getTaskView();
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
                    if (ScrollFragmentTabHost.this.hLo != null) {
                        ScrollFragmentTabHost.this.hLo.EE();
                    }
                    ScrollFragmentTabHost.this.hLo = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.hLo.cy(48);
                    ScrollFragmentTabHost.this.hLo.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.hLo.rR(4);
                    ScrollFragmentTabHost.this.hLo.cA(i);
                    ScrollFragmentTabHost.this.hLo.lE(true);
                    ScrollFragmentTabHost.this.hLo.rS(0);
                    ScrollFragmentTabHost.this.hLo.BL(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.hLl = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.hLm == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.blJ();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.hLm.bYG();
                } else if (ScrollFragmentTabHost.this.hLm.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.hLm.bYG();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.hLp = new com.baidu.tieba.homepage.framework.indicator.b();
        this.hLq = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void vG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.hLe.vI(i), false);
                ScrollFragmentTabHost.this.hLe.vK(i);
            }
        };
        this.hLr = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void vF(int i) {
                ScrollFragmentTabHost.this.hLp.a(i, ScrollFragmentTabHost.this.hLq);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hLi = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.blI();
                } else {
                    ScrollFragmentTabHost.this.blJ();
                }
            }
        };
        this.hLj = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.hLo != null) {
                    ScrollFragmentTabHost.this.hLo.EE();
                    ScrollFragmentTabHost.this.hLo = null;
                }
            }
        };
        this.hLk = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.hLm == null || ScrollFragmentTabHost.this.hLn == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.hLc.getTaskView() : ScrollFragmentTabHost.this.hLn.getTaskView();
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
                    if (ScrollFragmentTabHost.this.hLo != null) {
                        ScrollFragmentTabHost.this.hLo.EE();
                    }
                    ScrollFragmentTabHost.this.hLo = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.hLo.cy(48);
                    ScrollFragmentTabHost.this.hLo.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.hLo.rR(4);
                    ScrollFragmentTabHost.this.hLo.cA(i);
                    ScrollFragmentTabHost.this.hLo.lE(true);
                    ScrollFragmentTabHost.this.hLo.rS(0);
                    ScrollFragmentTabHost.this.hLo.BL(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.hLl = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.hLm == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.blJ();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.hLm.bYG();
                } else if (ScrollFragmentTabHost.this.hLm.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.hLm.bYG();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.hLp = new com.baidu.tieba.homepage.framework.indicator.b();
        this.hLq = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void vG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.hLe.vI(i), false);
                ScrollFragmentTabHost.this.hLe.vK(i);
            }
        };
        this.hLr = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void vF(int i) {
                ScrollFragmentTabHost.this.hLp.a(i, ScrollFragmentTabHost.this.hLq);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.hLm = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.hLn = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.hLc = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.gAH = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.ePl = (NoNetworkView) findViewById(R.id.view_no_network);
        this.cUm = (FrameLayout) findViewById(R.id.home_pager_container);
        this.dxy = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.cDw = findViewById(R.id.divider_line);
        this.eRx = findViewById(R.id.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hLm.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.cUm.getLayoutParams()).topMargin = 0;
        this.hLc.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.hLe.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.hLf != null) {
                    ScrollFragmentTabHost.this.hLf.vP(i);
                }
                com.baidu.tbadk.core.bigday.b.aIm().gr(ScrollFragmentTabHost.this.hLe.vH(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.vO(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.hLh != null && ScrollFragmentTabHost.this.hLe != null) {
                    int vH = ScrollFragmentTabHost.this.hLe.vH(ScrollFragmentTabHost.this.dxy.getCurrentItem());
                    if (vH == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.hLh) {
                            aVar.bYE();
                        }
                    } else if (vH == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.hLh) {
                            aVar2.bYD();
                        }
                    } else if (vH == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.hLh) {
                            aVar3.bXW();
                        }
                    } else if (vH == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (vH == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (vH == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.blJ();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.bYA();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.vO(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean bYv = ScrollFragmentTabHost.this.bYv();
                    TiebaStatic.log(new an("c12350").af("obj_type", bYv ? 1 : 0));
                    if (bYv && ScrollFragmentTabHost.this.hLe != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.hLe.bYt();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.hLc.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void j(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.dxy.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.vO(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.vO(i) == 7) {
                    TiebaStatic.log(new an("c13483").cI("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.vO(i) == 8) {
                    TiebaStatic.log(new an("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.vO(i));
            }
        });
        this.hLm.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void nM(boolean z) {
                if (z && ScrollFragmentTabHost.this.hLo != null) {
                    ScrollFragmentTabHost.this.hLo.EE();
                }
            }
        });
        this.hLn.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void DO(String str) {
                if (ScrollFragmentTabHost.this.hLo != null) {
                    ScrollFragmentTabHost.this.hLo.EE();
                    ScrollFragmentTabHost.this.hLo = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    ba.aOY().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.hLn.setVisibility(8);
            this.hLc.setMissionEntranceVisibility(true);
            this.hLc.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void DO(String str) {
                    if (ScrollFragmentTabHost.this.hLo != null) {
                        ScrollFragmentTabHost.this.hLo.EE();
                        ScrollFragmentTabHost.this.hLo = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        ba.aOY().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.hLn.setVisibility(0);
        this.hLc.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.hLl.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hLl);
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
        this.ePl.a(aVar);
        MessageManager.getInstance().registerListener(this.hLi);
        MessageManager.getInstance().registerListener(this.hLj);
        this.hLk.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.hLk);
    }

    public void notifyDataSetChanged() {
        if (this.hLe != null && !HomePageStatic.hHu) {
            this.dxy.setAdapter(this.hLe);
            this.hLc.notifyDataSetChanged();
            this.hLp.a(this.hLq);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.hLe != null) {
            this.hLe.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.hLe != null) {
            this.hLe.d(dataRes, z);
        }
    }

    public void bYs() {
        if (this.hLe != null) {
            this.hLe.bYs();
        }
    }

    public void v(String str, int i, int i2) {
        if (this.dxy != null) {
            this.hLe.v(str, i, i2);
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
        this.hLe = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.hLe.setScrollFragmentTabHost(this);
        this.dxy.setOffscreenPageLimit(2);
        this.dxy.setAdapter(this.hLe);
        int bYq = this.hLe.bYq();
        if (com.baidu.tbadk.core.sharedPref.b.aNV().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.aNV().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.hLe;
            if (HomePageStatic.hHu) {
                i = 0;
            }
            this.dxy.setCurrentItem(newScrollFragmentAdapter.vI(i));
            this.hLc.setViewPager(this.dxy);
            this.hLc.setConcernTabIndex(this.hLe.vI(0));
            bYA();
        }
        i = bYq;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.hLe;
        if (HomePageStatic.hHu) {
        }
        this.dxy.setCurrentItem(newScrollFragmentAdapter2.vI(i));
        this.hLc.setViewPager(this.dxy);
        this.hLc.setConcernTabIndex(this.hLe.vI(0));
        bYA();
    }

    public boolean bYy() {
        return this.hLe != null && this.hLe.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.hLe.getCount()) {
            this.hLc.setTabItemClicked(z);
            this.hLe.vL(i);
            this.dxy.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.hLe.vI(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.hLe.vI(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hLc.setPageUniqueId(bdUniqueId);
        this.hLi.setTag(bdUniqueId);
        this.hLj.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.cUm;
    }

    public int getCurrentTabType() {
        return this.hLe.vH(this.dxy.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.dxy.getAdapter() != null) {
            int count = this.dxy.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.hLe.vH(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int vO(int i) {
        return this.hLe.vH(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.hLm, R.color.cp_bg_line_h);
        this.hLn.onChangeSkinType();
        this.hLc.onChangeSkinType();
        if (this.mPageContext != null && this.ePl != null) {
            this.ePl.onChangeSkinType(this.mPageContext, i);
        }
        if (this.hLe != null) {
            this.hLe.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.gAH != null) {
            this.gAH.onChangeSkinType(this.mPageContext, i);
        }
        am.setBackgroundColor(this.cDw, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.eRx, R.drawable.personalize_tab_shadow);
    }

    private boolean blH() {
        return this.eRx.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.hLd = z;
        if (z) {
            if (this.cDw != null) {
                this.cDw.setVisibility(8);
            }
        } else if (this.cDw != null) {
            this.cDw.setVisibility(0);
        }
    }

    public void blI() {
        if (this.hLd && !blH()) {
            this.eRx.setVisibility(0);
            if (this.eRA == null) {
                this.eRA = new AlphaAnimation(0.0f, 1.0f);
                this.eRA.setFillAfter(true);
                this.eRA.setDuration(300L);
            }
            this.eRx.startAnimation(this.eRA);
        }
    }

    public void blJ() {
        if (this.hLd && blH()) {
            if (this.eRB == null) {
                this.eRB = new AlphaAnimation(1.0f, 0.0f);
                this.eRB.setFillAfter(true);
                this.eRB.setDuration(300L);
                this.eRB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.eRx.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.eRx.startAnimation(this.eRB);
        }
    }

    public void bYu() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.hLe != null) {
            this.hLe.bYu();
        }
        if ((currentTabType == 1 || currentTabType == 8 || currentTabType == 5 || currentTabType == 6 || currentTabType == 7) && this.hLe != null) {
            this.hLe.bYu();
        }
    }

    public void bmn() {
        this.hLe.bmn();
    }

    public String getCurrentPageKey() {
        if (this.hLe != null) {
            return this.hLe.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.dxy != null) {
            return this.dxy.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.hLe != null) {
            this.hLe.setPrimary(z);
        }
        if (this.ePl != null && z) {
            this.ePl.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void bYz() {
        this.hLe.a(this.hLr);
    }

    public void mC(boolean z) {
        if (!z && this.hLc != null && this.hLc.getTaskView() != null && this.hLc.getTaskView().getVisibility() != 0) {
            this.hLc.bYI();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.hLf = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.hLo != null) {
            this.hLo.EE();
            this.hLo = null;
        }
        bYC();
    }

    public void bYA() {
        int i = 1;
        if (this.hLe != null) {
            int vH = this.hLe.vH(this.dxy.getCurrentItem());
            if (vH == 0) {
                i = 0;
            } else if (vH != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.aNV().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.hLc != null && this.hLe.bYr()) {
            this.hLc.setShowConcernRedTip(z);
        }
    }

    public boolean bYv() {
        if (this.hLc == null || !this.hLe.bYr()) {
            return false;
        }
        return this.hLc.bYv();
    }

    public void setVideoThreadId(String str) {
        if (this.hLe != null) {
            this.hLe.setVideoThreadId(str);
        }
    }

    public void bYB() {
        if (com.baidu.tbadk.core.sharedPref.b.aNV().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int vI = this.hLe != null ? this.hLe.vI(0) : 0;
            if (this.hLg == null) {
                this.hLg = new d(this.mPageContext, this.hLc.vM(vI));
                this.hLg.cz(R.drawable.bg_tip_blue_up);
                this.hLg.cy(32);
                this.hLg.lE(true);
                this.hLg.setUseDirectOffset(true);
                this.hLg.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.hLg.cA(4000);
            }
            this.hLg.d(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void bYC() {
        if (this.hLg != null) {
            this.hLg.EE();
        }
    }

    public void onResume() {
        if (this.hLc != null) {
            this.hLc.onResume();
        }
    }

    public void a(a aVar) {
        if (this.hLh == null) {
            this.hLh = new ArrayList();
        }
        this.hLh.add(aVar);
    }

    public void b(a aVar) {
        if (this.hLh != null && this.hLh.size() > 0) {
            this.hLh.remove(aVar);
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class a {
        public void bYD() {
        }

        public void bYE() {
        }

        public void bXW() {
        }
    }
}
