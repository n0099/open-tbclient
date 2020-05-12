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
    private View cDC;
    private FrameLayout cUr;
    private CustomViewPager dxC;
    private NoNetworkView ePq;
    private View eRC;
    private AlphaAnimation eRF;
    private AlphaAnimation eRG;
    private PluginErrorTipView gAN;
    private HomeTabBarView hLi;
    private boolean hLj;
    private NewScrollFragmentAdapter hLk;
    private b hLl;
    private d hLm;
    private List<a> hLn;
    CustomMessageListener hLo;
    CustomMessageListener hLp;
    CustomMessageTask hLq;
    CustomMessageTask hLr;
    private StickyAppBarLayout hLs;
    private NestedScrollHeader hLt;
    private d hLu;
    private com.baidu.tieba.homepage.framework.indicator.b hLv;
    private e hLw;
    private com.baidu.tieba.homepage.framework.d hLx;
    private boolean isPrimary;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes9.dex */
    public interface b {
        void vP(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.hLo = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.blG();
                } else {
                    ScrollFragmentTabHost.this.blH();
                }
            }
        };
        this.hLp = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.hLu != null) {
                    ScrollFragmentTabHost.this.hLu.ED();
                    ScrollFragmentTabHost.this.hLu = null;
                }
            }
        };
        this.hLq = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.hLs == null || ScrollFragmentTabHost.this.hLt == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.hLi.getTaskView() : ScrollFragmentTabHost.this.hLt.getTaskView();
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
                    if (ScrollFragmentTabHost.this.hLu != null) {
                        ScrollFragmentTabHost.this.hLu.ED();
                    }
                    ScrollFragmentTabHost.this.hLu = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.hLu.cy(48);
                    ScrollFragmentTabHost.this.hLu.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.hLu.rR(4);
                    ScrollFragmentTabHost.this.hLu.cA(i);
                    ScrollFragmentTabHost.this.hLu.lE(true);
                    ScrollFragmentTabHost.this.hLu.rS(0);
                    ScrollFragmentTabHost.this.hLu.BO(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.hLr = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.hLs == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.blH();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.hLs.bYF();
                } else if (ScrollFragmentTabHost.this.hLs.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.hLs.bYF();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.hLv = new com.baidu.tieba.homepage.framework.indicator.b();
        this.hLw = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void vG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.hLk.vI(i), false);
                ScrollFragmentTabHost.this.hLk.vK(i);
            }
        };
        this.hLx = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void vF(int i) {
                ScrollFragmentTabHost.this.hLv.a(i, ScrollFragmentTabHost.this.hLw);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hLo = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.blG();
                } else {
                    ScrollFragmentTabHost.this.blH();
                }
            }
        };
        this.hLp = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.hLu != null) {
                    ScrollFragmentTabHost.this.hLu.ED();
                    ScrollFragmentTabHost.this.hLu = null;
                }
            }
        };
        this.hLq = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.hLs == null || ScrollFragmentTabHost.this.hLt == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.hLi.getTaskView() : ScrollFragmentTabHost.this.hLt.getTaskView();
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
                    if (ScrollFragmentTabHost.this.hLu != null) {
                        ScrollFragmentTabHost.this.hLu.ED();
                    }
                    ScrollFragmentTabHost.this.hLu = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.hLu.cy(48);
                    ScrollFragmentTabHost.this.hLu.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.hLu.rR(4);
                    ScrollFragmentTabHost.this.hLu.cA(i);
                    ScrollFragmentTabHost.this.hLu.lE(true);
                    ScrollFragmentTabHost.this.hLu.rS(0);
                    ScrollFragmentTabHost.this.hLu.BO(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.hLr = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.hLs == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.blH();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.hLs.bYF();
                } else if (ScrollFragmentTabHost.this.hLs.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.hLs.bYF();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.hLv = new com.baidu.tieba.homepage.framework.indicator.b();
        this.hLw = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void vG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.hLk.vI(i), false);
                ScrollFragmentTabHost.this.hLk.vK(i);
            }
        };
        this.hLx = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void vF(int i) {
                ScrollFragmentTabHost.this.hLv.a(i, ScrollFragmentTabHost.this.hLw);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.hLs = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.hLt = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.hLi = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.gAN = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.ePq = (NoNetworkView) findViewById(R.id.view_no_network);
        this.cUr = (FrameLayout) findViewById(R.id.home_pager_container);
        this.dxC = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.cDC = findViewById(R.id.divider_line);
        this.eRC = findViewById(R.id.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hLs.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.cUr.getLayoutParams()).topMargin = 0;
        this.hLi.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.hLk.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.hLl != null) {
                    ScrollFragmentTabHost.this.hLl.vP(i);
                }
                com.baidu.tbadk.core.bigday.b.aIk().gr(ScrollFragmentTabHost.this.hLk.vH(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.vO(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.hLn != null && ScrollFragmentTabHost.this.hLk != null) {
                    int vH = ScrollFragmentTabHost.this.hLk.vH(ScrollFragmentTabHost.this.dxC.getCurrentItem());
                    if (vH == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.hLn) {
                            aVar.bYD();
                        }
                    } else if (vH == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.hLn) {
                            aVar2.bYC();
                        }
                    } else if (vH == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.hLn) {
                            aVar3.bXV();
                        }
                    } else if (vH == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (vH == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (vH == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.blH();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.bYz();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.vO(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean bYu = ScrollFragmentTabHost.this.bYu();
                    TiebaStatic.log(new an("c12350").af("obj_type", bYu ? 1 : 0));
                    if (bYu && ScrollFragmentTabHost.this.hLk != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.hLk.bYs();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.hLi.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void j(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.dxC.getCurrentItem() != i) {
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
        this.hLs.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void nM(boolean z) {
                if (z && ScrollFragmentTabHost.this.hLu != null) {
                    ScrollFragmentTabHost.this.hLu.ED();
                }
            }
        });
        this.hLt.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void DR(String str) {
                if (ScrollFragmentTabHost.this.hLu != null) {
                    ScrollFragmentTabHost.this.hLu.ED();
                    ScrollFragmentTabHost.this.hLu = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    ba.aOV().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.hLt.setVisibility(8);
            this.hLi.setMissionEntranceVisibility(true);
            this.hLi.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void DR(String str) {
                    if (ScrollFragmentTabHost.this.hLu != null) {
                        ScrollFragmentTabHost.this.hLu.ED();
                        ScrollFragmentTabHost.this.hLu = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        ba.aOV().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.hLt.setVisibility(0);
        this.hLi.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.hLr.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hLr);
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
        this.ePq.a(aVar);
        MessageManager.getInstance().registerListener(this.hLo);
        MessageManager.getInstance().registerListener(this.hLp);
        this.hLq.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.hLq);
    }

    public void notifyDataSetChanged() {
        if (this.hLk != null && !HomePageStatic.hHA) {
            this.dxC.setAdapter(this.hLk);
            this.hLi.notifyDataSetChanged();
            this.hLv.a(this.hLw);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.hLk != null) {
            this.hLk.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.hLk != null) {
            this.hLk.d(dataRes, z);
        }
    }

    public void bYr() {
        if (this.hLk != null) {
            this.hLk.bYr();
        }
    }

    public void v(String str, int i, int i2) {
        if (this.dxC != null) {
            this.hLk.v(str, i, i2);
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
        this.hLk = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.hLk.setScrollFragmentTabHost(this);
        this.dxC.setOffscreenPageLimit(2);
        this.dxC.setAdapter(this.hLk);
        int bYp = this.hLk.bYp();
        if (com.baidu.tbadk.core.sharedPref.b.aNT().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.aNT().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.hLk;
            if (HomePageStatic.hHA) {
                i = 0;
            }
            this.dxC.setCurrentItem(newScrollFragmentAdapter.vI(i));
            this.hLi.setViewPager(this.dxC);
            this.hLi.setConcernTabIndex(this.hLk.vI(0));
            bYz();
        }
        i = bYp;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.hLk;
        if (HomePageStatic.hHA) {
        }
        this.dxC.setCurrentItem(newScrollFragmentAdapter2.vI(i));
        this.hLi.setViewPager(this.dxC);
        this.hLi.setConcernTabIndex(this.hLk.vI(0));
        bYz();
    }

    public boolean bYx() {
        return this.hLk != null && this.hLk.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.hLk.getCount()) {
            this.hLi.setTabItemClicked(z);
            this.hLk.vL(i);
            this.dxC.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.hLk.vI(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.hLk.vI(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hLi.setPageUniqueId(bdUniqueId);
        this.hLo.setTag(bdUniqueId);
        this.hLp.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.cUr;
    }

    public int getCurrentTabType() {
        return this.hLk.vH(this.dxC.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.dxC.getAdapter() != null) {
            int count = this.dxC.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.hLk.vH(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int vO(int i) {
        return this.hLk.vH(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.hLs, R.color.cp_bg_line_h);
        this.hLt.onChangeSkinType();
        this.hLi.onChangeSkinType();
        if (this.mPageContext != null && this.ePq != null) {
            this.ePq.onChangeSkinType(this.mPageContext, i);
        }
        if (this.hLk != null) {
            this.hLk.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.gAN != null) {
            this.gAN.onChangeSkinType(this.mPageContext, i);
        }
        am.setBackgroundColor(this.cDC, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.eRC, R.drawable.personalize_tab_shadow);
    }

    private boolean blF() {
        return this.eRC.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.hLj = z;
        if (z) {
            if (this.cDC != null) {
                this.cDC.setVisibility(8);
            }
        } else if (this.cDC != null) {
            this.cDC.setVisibility(0);
        }
    }

    public void blG() {
        if (this.hLj && !blF()) {
            this.eRC.setVisibility(0);
            if (this.eRF == null) {
                this.eRF = new AlphaAnimation(0.0f, 1.0f);
                this.eRF.setFillAfter(true);
                this.eRF.setDuration(300L);
            }
            this.eRC.startAnimation(this.eRF);
        }
    }

    public void blH() {
        if (this.hLj && blF()) {
            if (this.eRG == null) {
                this.eRG = new AlphaAnimation(1.0f, 0.0f);
                this.eRG.setFillAfter(true);
                this.eRG.setDuration(300L);
                this.eRG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.eRC.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.eRC.startAnimation(this.eRG);
        }
    }

    public void bYt() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.hLk != null) {
            this.hLk.bYt();
        }
        if ((currentTabType == 1 || currentTabType == 8 || currentTabType == 5 || currentTabType == 6 || currentTabType == 7) && this.hLk != null) {
            this.hLk.bYt();
        }
    }

    public void bml() {
        this.hLk.bml();
    }

    public String getCurrentPageKey() {
        if (this.hLk != null) {
            return this.hLk.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.dxC != null) {
            return this.dxC.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.hLk != null) {
            this.hLk.setPrimary(z);
        }
        if (this.ePq != null && z) {
            this.ePq.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void bYy() {
        this.hLk.a(this.hLx);
    }

    public void mC(boolean z) {
        if (!z && this.hLi != null && this.hLi.getTaskView() != null && this.hLi.getTaskView().getVisibility() != 0) {
            this.hLi.bYH();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.hLl = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.hLu != null) {
            this.hLu.ED();
            this.hLu = null;
        }
        bYB();
    }

    public void bYz() {
        int i = 1;
        if (this.hLk != null) {
            int vH = this.hLk.vH(this.dxC.getCurrentItem());
            if (vH == 0) {
                i = 0;
            } else if (vH != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.aNT().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.hLi != null && this.hLk.bYq()) {
            this.hLi.setShowConcernRedTip(z);
        }
    }

    public boolean bYu() {
        if (this.hLi == null || !this.hLk.bYq()) {
            return false;
        }
        return this.hLi.bYu();
    }

    public void setVideoThreadId(String str) {
        if (this.hLk != null) {
            this.hLk.setVideoThreadId(str);
        }
    }

    public void bYA() {
        if (com.baidu.tbadk.core.sharedPref.b.aNT().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int vI = this.hLk != null ? this.hLk.vI(0) : 0;
            if (this.hLm == null) {
                this.hLm = new d(this.mPageContext, this.hLi.vM(vI));
                this.hLm.cz(R.drawable.bg_tip_blue_up);
                this.hLm.cy(32);
                this.hLm.lE(true);
                this.hLm.setUseDirectOffset(true);
                this.hLm.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.hLm.cA(4000);
            }
            this.hLm.d(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void bYB() {
        if (this.hLm != null) {
            this.hLm.ED();
        }
    }

    public void onResume() {
        if (this.hLi != null) {
            this.hLi.onResume();
        }
    }

    public void a(a aVar) {
        if (this.hLn == null) {
            this.hLn = new ArrayList();
        }
        this.hLn.add(aVar);
    }

    public void b(a aVar) {
        if (this.hLn != null && this.hLn.size() > 0) {
            this.hLn.remove(aVar);
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class a {
        public void bYC() {
        }

        public void bYD() {
        }

        public void bXV() {
        }
    }
}
