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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.util.x;
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
    private CustomViewPager bQG;
    private View cUD;
    private NoNetworkView dnM;
    private View dpq;
    private AlphaAnimation dpt;
    private AlphaAnimation dpu;
    private PluginErrorTipView eXg;
    private List<a> eYh;
    private NewScrollFragmentAdapter ggA;
    private b ggB;
    private d ggC;
    private boolean ggD;
    public CustomMessageListener ggE;
    public CustomMessageListener ggF;
    CustomMessageListener ggG;
    private StickyAppBarLayout ggH;
    private NestedScrollHeader ggI;
    private d ggJ;
    CustomMessageTask ggK;
    CustomMessageTask ggL;
    CustomMessageListener ggM;
    private c ggN;
    private e ggO;
    private com.baidu.tieba.homepage.framework.d ggP;
    private x ggw;
    private View ggx;
    private HomeTabBarView ggy;
    private boolean ggz;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void tY(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.ggE = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                }
            }
        };
        this.ggF = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.ggA != null) {
                    ScrollFragmentTabHost.this.ggA.bvL();
                }
                if (ScrollFragmentTabHost.this.ggy != null) {
                    ScrollFragmentTabHost.this.ggy.notifyDataSetChanged();
                }
            }
        };
        this.ggG = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aJw();
                } else {
                    ScrollFragmentTabHost.this.aJx();
                }
            }
        };
        this.ggK = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.ggH == null || ScrollFragmentTabHost.this.ggI == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.ggy.getTaskView() : ScrollFragmentTabHost.this.ggI.getTaskView();
                if ((taskView == null || taskView.getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof n.a)) {
                    n.a data = customMessage.getData();
                    int i = UIMsg.m_AppUI.MSG_APP_GPS;
                    if (data.duration.intValue() > 0) {
                        i = data.duration.intValue() * 1000;
                    }
                    String str = data.toast;
                    if (TextUtils.isEmpty(str)) {
                        str = ScrollFragmentTabHost.this.mPageContext.getString(R.string.task_float_tip_toast);
                    }
                    String fixedText = UtilHelper.getFixedText(str, 20);
                    if (ScrollFragmentTabHost.this.ggJ != null) {
                        ScrollFragmentTabHost.this.ggJ.bbB();
                    }
                    ScrollFragmentTabHost.this.ggJ = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.ggJ.qb(48);
                    ScrollFragmentTabHost.this.ggJ.S(true);
                    ScrollFragmentTabHost.this.ggJ.qa(4);
                    ScrollFragmentTabHost.this.ggJ.qd(i);
                    ScrollFragmentTabHost.this.ggJ.iR(true);
                    ScrollFragmentTabHost.this.ggJ.qf(0);
                    ScrollFragmentTabHost.this.ggJ.vJ(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.ggL = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.ggH == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aJx();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.ggH.bwb();
                } else if (!ScrollFragmentTabHost.this.ggH.isSticky()) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.ggH.bwb();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.ggM = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.ggJ != null) {
                    ScrollFragmentTabHost.this.ggJ.bbB();
                    ScrollFragmentTabHost.this.ggJ = null;
                }
            }
        };
        this.ggN = new c();
        this.ggO = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.e
            public void tO(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.ggA.tQ(i), false);
                ScrollFragmentTabHost.this.ggA.tS(i);
            }
        };
        this.ggP = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.d
            public void tN(int i) {
                ScrollFragmentTabHost.this.ggN.a(i, ScrollFragmentTabHost.this.ggO);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ggE = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                }
            }
        };
        this.ggF = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.ggA != null) {
                    ScrollFragmentTabHost.this.ggA.bvL();
                }
                if (ScrollFragmentTabHost.this.ggy != null) {
                    ScrollFragmentTabHost.this.ggy.notifyDataSetChanged();
                }
            }
        };
        this.ggG = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aJw();
                } else {
                    ScrollFragmentTabHost.this.aJx();
                }
            }
        };
        this.ggK = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.ggH == null || ScrollFragmentTabHost.this.ggI == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.ggy.getTaskView() : ScrollFragmentTabHost.this.ggI.getTaskView();
                if ((taskView == null || taskView.getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof n.a)) {
                    n.a data = customMessage.getData();
                    int i = UIMsg.m_AppUI.MSG_APP_GPS;
                    if (data.duration.intValue() > 0) {
                        i = data.duration.intValue() * 1000;
                    }
                    String str = data.toast;
                    if (TextUtils.isEmpty(str)) {
                        str = ScrollFragmentTabHost.this.mPageContext.getString(R.string.task_float_tip_toast);
                    }
                    String fixedText = UtilHelper.getFixedText(str, 20);
                    if (ScrollFragmentTabHost.this.ggJ != null) {
                        ScrollFragmentTabHost.this.ggJ.bbB();
                    }
                    ScrollFragmentTabHost.this.ggJ = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.ggJ.qb(48);
                    ScrollFragmentTabHost.this.ggJ.S(true);
                    ScrollFragmentTabHost.this.ggJ.qa(4);
                    ScrollFragmentTabHost.this.ggJ.qd(i);
                    ScrollFragmentTabHost.this.ggJ.iR(true);
                    ScrollFragmentTabHost.this.ggJ.qf(0);
                    ScrollFragmentTabHost.this.ggJ.vJ(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.ggL = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.ggH == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aJx();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.ggH.bwb();
                } else if (!ScrollFragmentTabHost.this.ggH.isSticky()) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.ggH.bwb();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.ggM = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.ggJ != null) {
                    ScrollFragmentTabHost.this.ggJ.bbB();
                    ScrollFragmentTabHost.this.ggJ = null;
                }
            }
        };
        this.ggN = new c();
        this.ggO = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.e
            public void tO(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.ggA.tQ(i), false);
                ScrollFragmentTabHost.this.ggA.tS(i);
            }
        };
        this.ggP = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.d
            public void tN(int i) {
                ScrollFragmentTabHost.this.ggN.a(i, ScrollFragmentTabHost.this.ggO);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.ggH = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.ggI = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.ggx = findViewById(R.id.home_page_statebar_view);
        this.ggy = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.eXg = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.dnM = (NoNetworkView) findViewById(R.id.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(R.id.home_pager_container);
        this.bQG = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.cUD = findViewById(R.id.divider_line);
        this.dpq = findViewById(R.id.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.ggx.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.ggy.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.ggA.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.ggB != null) {
                    ScrollFragmentTabHost.this.ggB.tY(i);
                }
                com.baidu.tbadk.core.bigday.b.aco().dG(ScrollFragmentTabHost.this.ggA.tP(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.tX(i) == 3) {
                    an anVar = new an("c12478");
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(anVar);
                }
                if (ScrollFragmentTabHost.this.tX(i) == 4) {
                    TiebaStatic.log(new an("c13172").P("obj_type", ScrollFragmentTabHost.this.ggD ? 2 : 1));
                    ScrollFragmentTabHost.this.ggD = false;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.tX(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.eYh != null && ScrollFragmentTabHost.this.ggA != null) {
                    int tP = ScrollFragmentTabHost.this.ggA.tP(ScrollFragmentTabHost.this.bQG.getCurrentItem());
                    if (tP == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.eYh) {
                            aVar.bvZ();
                        }
                    } else if (tP == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.eYh) {
                            aVar2.bvY();
                        }
                    } else if (tP == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.eYh) {
                            aVar3.bvh();
                        }
                    } else if (tP == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (tP == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.aJx();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.bvV();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.tX(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean bvQ = ScrollFragmentTabHost.this.bvQ();
                    TiebaStatic.log(new an("c12350").P("obj_type", bvQ ? 1 : 0));
                    if (bvQ && ScrollFragmentTabHost.this.ggA != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.ggA.bvO();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.ggy.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void r(View view, int i) {
                if (ScrollFragmentTabHost.this.bQG.getCurrentItem() != i && ScrollFragmentTabHost.this.tX(i) == 4) {
                    ScrollFragmentTabHost.this.ggD = true;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.bQG.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.tX(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.tX(i) == 7) {
                    TiebaStatic.log(new an("c13483").bT("obj_type", "1"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.tX(i));
            }
        });
        this.ggH.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void ll(boolean z) {
                if (z && ScrollFragmentTabHost.this.ggJ != null) {
                    ScrollFragmentTabHost.this.ggJ.bbB();
                }
            }
        });
        this.ggI.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void ye(String str) {
                if (ScrollFragmentTabHost.this.ggJ != null) {
                    ScrollFragmentTabHost.this.ggJ.bbB();
                    ScrollFragmentTabHost.this.ggJ = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    bb.ajE().c(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.ggI.setVisibility(8);
            this.ggy.setMissionEntranceVisibility(true);
            this.ggy.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void ye(String str) {
                    if (ScrollFragmentTabHost.this.ggJ != null) {
                        ScrollFragmentTabHost.this.ggJ.bbB();
                        ScrollFragmentTabHost.this.ggJ = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        bb.ajE().c(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.ggI.setVisibility(0);
        this.ggy.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.ggL.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.ggL);
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
        this.dnM.a(aVar);
        MessageManager.getInstance().registerListener(this.ggE);
        MessageManager.getInstance().registerListener(this.ggF);
        MessageManager.getInstance().registerListener(this.ggG);
        MessageManager.getInstance().registerListener(this.ggM);
        this.ggK.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.ggK);
    }

    public void notifyDataSetChanged() {
        if (this.ggA != null && !HomePageStatic.gcm) {
            this.bQG.setAdapter(this.ggA);
            this.ggy.notifyDataSetChanged();
            this.ggN.a(this.ggO);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ggA != null) {
            this.ggA.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ggA != null) {
            this.ggA.d(dataRes, z);
        }
    }

    public void bvN() {
        if (this.ggA != null) {
            this.ggA.bvN();
        }
    }

    public void v(String str, int i, int i2) {
        if (this.bQG != null) {
            this.ggA.v(str, i, i2);
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
        this.ggA = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.ggA.setScrollFragmentTabHost(this);
        this.bQG.setOffscreenPageLimit(2);
        this.bQG.setAdapter(this.ggA);
        int bvK = this.ggA.bvK();
        if (com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.ggA;
            if (HomePageStatic.gcm) {
                i = 0;
            }
            this.bQG.setCurrentItem(newScrollFragmentAdapter.tQ(i));
            this.ggy.setViewPager(this.bQG);
            this.ggy.setConcernTabIndex(this.ggA.tQ(0));
            if (this.ggw != null) {
                this.ggA.setRecommendFrsNavigationAnimDispatcher(this.ggw);
            }
            bvV();
        }
        i = bvK;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.ggA;
        if (HomePageStatic.gcm) {
        }
        this.bQG.setCurrentItem(newScrollFragmentAdapter2.tQ(i));
        this.ggy.setViewPager(this.bQG);
        this.ggy.setConcernTabIndex(this.ggA.tQ(0));
        if (this.ggw != null) {
        }
        bvV();
    }

    public boolean bvT() {
        return this.ggA != null && this.ggA.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.ggA.getCount()) {
            this.ggy.setTabItemClicked(z);
            this.ggA.tT(i);
            this.bQG.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.ggA.tQ(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ggy.setPageUniqueId(bdUniqueId);
        this.ggE.setTag(bdUniqueId);
        this.ggF.setTag(bdUniqueId);
        this.ggG.setTag(bdUniqueId);
        this.ggM.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.ggA.tP(this.bQG.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.bQG.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.ggA.tP(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int tX(int i) {
        return this.ggA.tP(i);
    }

    public void onChangeSkinType(int i) {
        am.l(this.ggx, R.color.cp_bg_line_d);
        this.ggI.onChangeSkinType();
        this.ggy.onChangeSkinType();
        if (this.mPageContext != null && this.dnM != null) {
            this.dnM.onChangeSkinType(this.mPageContext, i);
        }
        if (this.ggA != null) {
            this.ggA.jd(i);
        }
        if (this.mPageContext != null && this.eXg != null) {
            this.eXg.onChangeSkinType(this.mPageContext, i);
        }
        am.l(this.cUD, R.color.cp_bg_line_c);
    }

    private boolean aJv() {
        return this.dpq.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.ggz = z;
        if (z) {
            if (this.cUD != null) {
                this.cUD.setVisibility(8);
            }
        } else if (this.cUD != null) {
            this.cUD.setVisibility(0);
        }
    }

    public void aJw() {
        if (this.ggz && !aJv()) {
            this.dpq.setVisibility(0);
            if (this.dpt == null) {
                this.dpt = new AlphaAnimation(0.0f, 1.0f);
                this.dpt.setFillAfter(true);
                this.dpt.setDuration(300L);
            }
            this.dpq.startAnimation(this.dpt);
        }
    }

    public void aJx() {
        if (this.ggz && aJv()) {
            if (this.dpu == null) {
                this.dpu = new AlphaAnimation(1.0f, 0.0f);
                this.dpu.setFillAfter(true);
                this.dpu.setDuration(300L);
                this.dpu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.dpq.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.dpq.startAnimation(this.dpu);
        }
    }

    public void bvP() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.ggA != null) {
            this.ggA.bvP();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4 || currentTabType == 5 || currentTabType == 6 || currentTabType == 7) && this.ggA != null) {
            this.ggA.bvP();
        }
    }

    public void aKj() {
        this.ggA.aKj();
    }

    public String getCurrentPageKey() {
        if (this.ggA != null) {
            return this.ggA.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.bQG != null) {
            return this.bQG.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.ggA != null) {
            this.ggA.setPrimary(z);
        }
        if (this.dnM != null && z) {
            this.dnM.setVisibility(j.jQ() ? 8 : 0);
        }
    }

    public void bvU() {
        this.ggA.a(this.ggP);
    }

    public void kc(boolean z) {
        if (!z && this.ggy != null && this.ggy.getTaskView() != null && this.ggy.getTaskView().getVisibility() != 0) {
            this.ggy.bwc();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.ggB = bVar;
    }

    public void onDestroy() {
        if (this.ggw != null) {
            this.ggw.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.ggJ != null) {
            this.ggJ.bbB();
            this.ggJ = null;
        }
        bvX();
    }

    public void bvV() {
        int i = 1;
        if (this.ggA != null) {
            int tP = this.ggA.tP(this.bQG.getCurrentItem());
            if (tP == 0) {
                i = 0;
            } else if (tP != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.ggy != null && this.ggA.bvM()) {
            this.ggy.setShowConcernRedTip(z);
        }
    }

    public boolean bvQ() {
        if (this.ggy == null || !this.ggA.bvM()) {
            return false;
        }
        return this.ggy.bvQ();
    }

    public void setVideoThreadId(String str) {
        if (this.ggA != null) {
            this.ggA.setVideoThreadId(str);
        }
    }

    public void bvW() {
        if (com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int tQ = this.ggA != null ? this.ggA.tQ(0) : 0;
            if (this.ggC == null) {
                this.ggC = new d(this.mPageContext, this.ggy.tU(tQ));
                this.ggC.qc(R.drawable.bg_tip_blue_up);
                this.ggC.qb(32);
                this.ggC.iR(true);
                this.ggC.S(true);
                this.ggC.setYOffset(l.g(this.mContext, R.dimen.ds16));
                this.ggC.qd(UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
            }
            this.ggC.u(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void bvX() {
        if (this.ggC != null) {
            this.ggC.bbB();
        }
    }

    public void onResume() {
        if (this.ggy != null) {
            this.ggy.onResume();
        }
    }

    public void a(a aVar) {
        if (this.eYh == null) {
            this.eYh = new ArrayList();
        }
        this.eYh.add(aVar);
    }

    public void b(a aVar) {
        if (this.eYh != null && this.eYh.size() > 0) {
            this.eYh.remove(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void bvY() {
        }

        public void bvZ() {
        }

        public void bvh() {
        }
    }
}
