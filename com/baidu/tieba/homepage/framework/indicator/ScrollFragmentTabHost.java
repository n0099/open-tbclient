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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mapapi.UIMsg;
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
    private FrameLayout cfi;
    private CustomViewPager cig;
    private View deR;
    private NoNetworkView dwI;
    private View dyl;
    private AlphaAnimation dyo;
    private AlphaAnimation dyp;
    private PluginErrorTipView fbx;
    private List<a> fcy;
    private w ghM;
    private View ghN;
    private HomeTabBarView ghO;
    private boolean ghP;
    private NewScrollFragmentAdapter ghQ;
    private b ghR;
    private d ghS;
    private boolean ghT;
    public CustomMessageListener ghU;
    public CustomMessageListener ghV;
    CustomMessageListener ghW;
    private StickyAppBarLayout ghX;
    private NestedScrollHeader ghY;
    private d ghZ;
    CustomMessageTask gia;
    CustomMessageTask gib;
    CustomMessageListener gic;
    private c gie;
    private e gif;
    private com.baidu.tieba.homepage.framework.d gig;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void sX(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.ghU = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                }
            }
        };
        this.ghV = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.ghQ != null) {
                    ScrollFragmentTabHost.this.ghQ.btE();
                }
                if (ScrollFragmentTabHost.this.ghO != null) {
                    ScrollFragmentTabHost.this.ghO.notifyDataSetChanged();
                }
            }
        };
        this.ghW = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aJA();
                } else {
                    ScrollFragmentTabHost.this.aJB();
                }
            }
        };
        this.gia = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.ghX == null || ScrollFragmentTabHost.this.ghY == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.ghO.getTaskView() : ScrollFragmentTabHost.this.ghY.getTaskView();
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
                    if (ScrollFragmentTabHost.this.ghZ != null) {
                        ScrollFragmentTabHost.this.ghZ.uP();
                    }
                    ScrollFragmentTabHost.this.ghZ = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.ghZ.bA(48);
                    ScrollFragmentTabHost.this.ghZ.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.ghZ.pf(4);
                    ScrollFragmentTabHost.this.ghZ.bC(i);
                    ScrollFragmentTabHost.this.ghZ.iX(true);
                    ScrollFragmentTabHost.this.ghZ.ph(0);
                    ScrollFragmentTabHost.this.ghZ.uK(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.gib = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.ghX == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aJB();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.ghX.btU();
                } else if (!ScrollFragmentTabHost.this.ghX.isSticky()) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.ghX.btU();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.gic = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.ghZ != null) {
                    ScrollFragmentTabHost.this.ghZ.uP();
                    ScrollFragmentTabHost.this.ghZ = null;
                }
            }
        };
        this.gie = new c();
        this.gif = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.e
            public void sN(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.ghQ.sP(i), false);
                ScrollFragmentTabHost.this.ghQ.sR(i);
            }
        };
        this.gig = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.d
            public void sM(int i) {
                ScrollFragmentTabHost.this.gie.a(i, ScrollFragmentTabHost.this.gif);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ghU = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                }
            }
        };
        this.ghV = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.ghQ != null) {
                    ScrollFragmentTabHost.this.ghQ.btE();
                }
                if (ScrollFragmentTabHost.this.ghO != null) {
                    ScrollFragmentTabHost.this.ghO.notifyDataSetChanged();
                }
            }
        };
        this.ghW = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aJA();
                } else {
                    ScrollFragmentTabHost.this.aJB();
                }
            }
        };
        this.gia = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.ghX == null || ScrollFragmentTabHost.this.ghY == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.ghO.getTaskView() : ScrollFragmentTabHost.this.ghY.getTaskView();
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
                    if (ScrollFragmentTabHost.this.ghZ != null) {
                        ScrollFragmentTabHost.this.ghZ.uP();
                    }
                    ScrollFragmentTabHost.this.ghZ = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.ghZ.bA(48);
                    ScrollFragmentTabHost.this.ghZ.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.ghZ.pf(4);
                    ScrollFragmentTabHost.this.ghZ.bC(i);
                    ScrollFragmentTabHost.this.ghZ.iX(true);
                    ScrollFragmentTabHost.this.ghZ.ph(0);
                    ScrollFragmentTabHost.this.ghZ.uK(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.gib = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.ghX == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aJB();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.ghX.btU();
                } else if (!ScrollFragmentTabHost.this.ghX.isSticky()) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.ghX.btU();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.gic = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.ghZ != null) {
                    ScrollFragmentTabHost.this.ghZ.uP();
                    ScrollFragmentTabHost.this.ghZ = null;
                }
            }
        };
        this.gie = new c();
        this.gif = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.e
            public void sN(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.ghQ.sP(i), false);
                ScrollFragmentTabHost.this.ghQ.sR(i);
            }
        };
        this.gig = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.d
            public void sM(int i) {
                ScrollFragmentTabHost.this.gie.a(i, ScrollFragmentTabHost.this.gif);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.ghX = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.ghY = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.ghN = findViewById(R.id.home_page_statebar_view);
        this.ghO = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.fbx = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.dwI = (NoNetworkView) findViewById(R.id.view_no_network);
        this.cfi = (FrameLayout) findViewById(R.id.home_pager_container);
        this.cig = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.deR = findViewById(R.id.divider_line);
        this.dyl = findViewById(R.id.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.ghN.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.ghO.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.ghQ.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.ghR != null) {
                    ScrollFragmentTabHost.this.ghR.sX(i);
                }
                com.baidu.tbadk.core.bigday.b.agy().dW(ScrollFragmentTabHost.this.ghQ.sO(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.sW(i) == 3) {
                    an anVar = new an("c12478");
                    anVar.bS("obj_source", "0");
                    TiebaStatic.log(anVar);
                }
                if (ScrollFragmentTabHost.this.sW(i) == 4) {
                    TiebaStatic.log(new an("c13172").O("obj_type", ScrollFragmentTabHost.this.ghT ? 2 : 1));
                    ScrollFragmentTabHost.this.ghT = false;
                } else if (ScrollFragmentTabHost.this.sW(i) == 6) {
                    TiebaStatic.log("c13545");
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.sW(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.fcy != null && ScrollFragmentTabHost.this.ghQ != null) {
                    int sO = ScrollFragmentTabHost.this.ghQ.sO(ScrollFragmentTabHost.this.cig.getCurrentItem());
                    if (sO == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.fcy) {
                            aVar.btS();
                        }
                    } else if (sO == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.fcy) {
                            aVar2.btR();
                        }
                    } else if (sO == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.fcy) {
                            aVar3.bta();
                        }
                    } else if (sO == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (sO == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.aJB();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.btO();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.sW(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean btJ = ScrollFragmentTabHost.this.btJ();
                    TiebaStatic.log(new an("c12350").O("obj_type", btJ ? 1 : 0));
                    if (btJ && ScrollFragmentTabHost.this.ghQ != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.ghQ.btH();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.ghO.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void k(View view, int i) {
                if (ScrollFragmentTabHost.this.cig.getCurrentItem() != i && ScrollFragmentTabHost.this.sW(i) == 4) {
                    ScrollFragmentTabHost.this.ghT = true;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.cig.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.sW(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.sW(i) == 7) {
                    TiebaStatic.log(new an("c13483").bS("obj_type", "1"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.sW(i));
            }
        });
        this.ghX.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void lc(boolean z) {
                if (z && ScrollFragmentTabHost.this.ghZ != null) {
                    ScrollFragmentTabHost.this.ghZ.uP();
                }
            }
        });
        this.ghY.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void wW(String str) {
                if (ScrollFragmentTabHost.this.ghZ != null) {
                    ScrollFragmentTabHost.this.ghZ.uP();
                    ScrollFragmentTabHost.this.ghZ = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    ba.amQ().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.ghY.setVisibility(8);
            this.ghO.setMissionEntranceVisibility(true);
            this.ghO.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void wW(String str) {
                    if (ScrollFragmentTabHost.this.ghZ != null) {
                        ScrollFragmentTabHost.this.ghZ.uP();
                        ScrollFragmentTabHost.this.ghZ = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        ba.amQ().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.ghY.setVisibility(0);
        this.ghO.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.gib.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.gib);
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
        this.dwI.a(aVar);
        MessageManager.getInstance().registerListener(this.ghU);
        MessageManager.getInstance().registerListener(this.ghV);
        MessageManager.getInstance().registerListener(this.ghW);
        MessageManager.getInstance().registerListener(this.gic);
        this.gia.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.gia);
    }

    public void notifyDataSetChanged() {
        if (this.ghQ != null && !HomePageStatic.gdA) {
            this.cig.setAdapter(this.ghQ);
            this.ghO.notifyDataSetChanged();
            this.gie.a(this.gif);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ghQ != null) {
            this.ghQ.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ghQ != null) {
            this.ghQ.d(dataRes, z);
        }
    }

    public void btG() {
        if (this.ghQ != null) {
            this.ghQ.btG();
        }
    }

    public void u(String str, int i, int i2) {
        if (this.cig != null) {
            this.ghQ.u(str, i, i2);
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
        this.ghQ = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.ghQ.setScrollFragmentTabHost(this);
        this.cig.setOffscreenPageLimit(2);
        this.cig.setAdapter(this.ghQ);
        int btD = this.ghQ.btD();
        if (com.baidu.tbadk.core.sharedPref.b.alR().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.alR().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.ghQ;
            if (HomePageStatic.gdA) {
                i = 0;
            }
            this.cig.setCurrentItem(newScrollFragmentAdapter.sP(i));
            this.ghO.setViewPager(this.cig);
            this.ghO.setConcernTabIndex(this.ghQ.sP(0));
            if (this.ghM != null) {
                this.ghQ.setRecommendFrsNavigationAnimDispatcher(this.ghM);
            }
            btO();
        }
        i = btD;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.ghQ;
        if (HomePageStatic.gdA) {
        }
        this.cig.setCurrentItem(newScrollFragmentAdapter2.sP(i));
        this.ghO.setViewPager(this.cig);
        this.ghO.setConcernTabIndex(this.ghQ.sP(0));
        if (this.ghM != null) {
        }
        btO();
    }

    public boolean btM() {
        return this.ghQ != null && this.ghQ.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.ghQ.getCount()) {
            this.ghO.setTabItemClicked(z);
            this.ghQ.sS(i);
            this.cig.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.ghQ.sP(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ghO.setPageUniqueId(bdUniqueId);
        this.ghU.setTag(bdUniqueId);
        this.ghV.setTag(bdUniqueId);
        this.ghW.setTag(bdUniqueId);
        this.gic.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.cfi;
    }

    public int getCurrentTabType() {
        return this.ghQ.sO(this.cig.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.cig.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.ghQ.sO(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int sW(int i) {
        return this.ghQ.sO(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.ghN, R.color.cp_bg_line_h);
        this.ghY.onChangeSkinType();
        this.ghO.onChangeSkinType();
        if (this.mPageContext != null && this.dwI != null) {
            this.dwI.onChangeSkinType(this.mPageContext, i);
        }
        if (this.ghQ != null) {
            this.ghQ.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.fbx != null) {
            this.fbx.onChangeSkinType(this.mPageContext, i);
        }
        am.setBackgroundColor(this.deR, R.color.cp_bg_line_c);
    }

    private boolean aJz() {
        return this.dyl.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.ghP = z;
        if (z) {
            if (this.deR != null) {
                this.deR.setVisibility(8);
            }
        } else if (this.deR != null) {
            this.deR.setVisibility(0);
        }
    }

    public void aJA() {
        if (this.ghP && !aJz()) {
            this.dyl.setVisibility(0);
            if (this.dyo == null) {
                this.dyo = new AlphaAnimation(0.0f, 1.0f);
                this.dyo.setFillAfter(true);
                this.dyo.setDuration(300L);
            }
            this.dyl.startAnimation(this.dyo);
        }
    }

    public void aJB() {
        if (this.ghP && aJz()) {
            if (this.dyp == null) {
                this.dyp = new AlphaAnimation(1.0f, 0.0f);
                this.dyp.setFillAfter(true);
                this.dyp.setDuration(300L);
                this.dyp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.dyl.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.dyl.startAnimation(this.dyp);
        }
    }

    public void btI() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.ghQ != null) {
            this.ghQ.btI();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4 || currentTabType == 5 || currentTabType == 6 || currentTabType == 7) && this.ghQ != null) {
            this.ghQ.btI();
        }
    }

    public void aKh() {
        this.ghQ.aKh();
    }

    public String getCurrentPageKey() {
        if (this.ghQ != null) {
            return this.ghQ.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.cig != null) {
            return this.cig.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.ghQ != null) {
            this.ghQ.setPrimary(z);
        }
        if (this.dwI != null && z) {
            this.dwI.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void btN() {
        this.ghQ.a(this.gig);
    }

    public void jT(boolean z) {
        if (!z && this.ghO != null && this.ghO.getTaskView() != null && this.ghO.getTaskView().getVisibility() != 0) {
            this.ghO.btV();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.ghR = bVar;
    }

    public void onDestroy() {
        if (this.ghM != null) {
            this.ghM.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.ghZ != null) {
            this.ghZ.uP();
            this.ghZ = null;
        }
        btQ();
    }

    public void btO() {
        int i = 1;
        if (this.ghQ != null) {
            int sO = this.ghQ.sO(this.cig.getCurrentItem());
            if (sO == 0) {
                i = 0;
            } else if (sO != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.alR().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.ghO != null && this.ghQ.btF()) {
            this.ghO.setShowConcernRedTip(z);
        }
    }

    public boolean btJ() {
        if (this.ghO == null || !this.ghQ.btF()) {
            return false;
        }
        return this.ghO.btJ();
    }

    public void setVideoThreadId(String str) {
        if (this.ghQ != null) {
            this.ghQ.setVideoThreadId(str);
        }
    }

    public void btP() {
        if (com.baidu.tbadk.core.sharedPref.b.alR().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int sP = this.ghQ != null ? this.ghQ.sP(0) : 0;
            if (this.ghS == null) {
                this.ghS = new d(this.mPageContext, this.ghO.sT(sP));
                this.ghS.bB(R.drawable.bg_tip_blue_up);
                this.ghS.bA(32);
                this.ghS.iX(true);
                this.ghS.setUseDirectOffset(true);
                this.ghS.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.ghS.bC(UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
            }
            this.ghS.c(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void btQ() {
        if (this.ghS != null) {
            this.ghS.uP();
        }
    }

    public void onResume() {
        if (this.ghO != null) {
            this.ghO.onResume();
        }
    }

    public void a(a aVar) {
        if (this.fcy == null) {
            this.fcy = new ArrayList();
        }
        this.fcy.add(aVar);
    }

    public void b(a aVar) {
        if (this.fcy != null && this.fcy.size() > 0) {
            this.fcy.remove(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void btR() {
        }

        public void btS() {
        }

        public void bta() {
        }
    }
}
