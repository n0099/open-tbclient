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
    private FrameLayout cer;
    private CustomViewPager cho;
    private View ddZ;
    private NoNetworkView dvR;
    private View dxu;
    private AlphaAnimation dxx;
    private AlphaAnimation dxy;
    private PluginErrorTipView faG;
    private List<a> fbH;
    private w ggV;
    private View ggW;
    private HomeTabBarView ggX;
    private boolean ggY;
    private NewScrollFragmentAdapter ggZ;
    private b gha;
    private d ghb;
    private boolean ghc;
    public CustomMessageListener ghd;
    public CustomMessageListener ghe;
    CustomMessageListener ghf;
    private StickyAppBarLayout ghg;
    private NestedScrollHeader ghh;
    private d ghi;
    CustomMessageTask ghj;
    CustomMessageTask ghk;
    CustomMessageListener ghl;
    private c ghm;
    private e ghn;
    private com.baidu.tieba.homepage.framework.d gho;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void sW(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.ghd = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                }
            }
        };
        this.ghe = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.ggZ != null) {
                    ScrollFragmentTabHost.this.ggZ.btC();
                }
                if (ScrollFragmentTabHost.this.ggX != null) {
                    ScrollFragmentTabHost.this.ggX.notifyDataSetChanged();
                }
            }
        };
        this.ghf = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aJy();
                } else {
                    ScrollFragmentTabHost.this.aJz();
                }
            }
        };
        this.ghj = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.ghg == null || ScrollFragmentTabHost.this.ghh == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.ggX.getTaskView() : ScrollFragmentTabHost.this.ghh.getTaskView();
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
                    if (ScrollFragmentTabHost.this.ghi != null) {
                        ScrollFragmentTabHost.this.ghi.uQ();
                    }
                    ScrollFragmentTabHost.this.ghi = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.ghi.bA(48);
                    ScrollFragmentTabHost.this.ghi.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.ghi.pe(4);
                    ScrollFragmentTabHost.this.ghi.bC(i);
                    ScrollFragmentTabHost.this.ghi.iX(true);
                    ScrollFragmentTabHost.this.ghi.pg(0);
                    ScrollFragmentTabHost.this.ghi.uK(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.ghk = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.ghg == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aJz();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.ghg.btS();
                } else if (!ScrollFragmentTabHost.this.ghg.isSticky()) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.ghg.btS();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.ghl = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.ghi != null) {
                    ScrollFragmentTabHost.this.ghi.uQ();
                    ScrollFragmentTabHost.this.ghi = null;
                }
            }
        };
        this.ghm = new c();
        this.ghn = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.e
            public void sM(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.ggZ.sO(i), false);
                ScrollFragmentTabHost.this.ggZ.sQ(i);
            }
        };
        this.gho = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.d
            public void sL(int i) {
                ScrollFragmentTabHost.this.ghm.a(i, ScrollFragmentTabHost.this.ghn);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ghd = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                }
            }
        };
        this.ghe = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.ggZ != null) {
                    ScrollFragmentTabHost.this.ggZ.btC();
                }
                if (ScrollFragmentTabHost.this.ggX != null) {
                    ScrollFragmentTabHost.this.ggX.notifyDataSetChanged();
                }
            }
        };
        this.ghf = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aJy();
                } else {
                    ScrollFragmentTabHost.this.aJz();
                }
            }
        };
        this.ghj = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.ghg == null || ScrollFragmentTabHost.this.ghh == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.ggX.getTaskView() : ScrollFragmentTabHost.this.ghh.getTaskView();
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
                    if (ScrollFragmentTabHost.this.ghi != null) {
                        ScrollFragmentTabHost.this.ghi.uQ();
                    }
                    ScrollFragmentTabHost.this.ghi = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.ghi.bA(48);
                    ScrollFragmentTabHost.this.ghi.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.ghi.pe(4);
                    ScrollFragmentTabHost.this.ghi.bC(i);
                    ScrollFragmentTabHost.this.ghi.iX(true);
                    ScrollFragmentTabHost.this.ghi.pg(0);
                    ScrollFragmentTabHost.this.ghi.uK(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.ghk = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.ghg == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aJz();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.ghg.btS();
                } else if (!ScrollFragmentTabHost.this.ghg.isSticky()) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.ghg.btS();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.ghl = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.ghi != null) {
                    ScrollFragmentTabHost.this.ghi.uQ();
                    ScrollFragmentTabHost.this.ghi = null;
                }
            }
        };
        this.ghm = new c();
        this.ghn = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.e
            public void sM(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.ggZ.sO(i), false);
                ScrollFragmentTabHost.this.ggZ.sQ(i);
            }
        };
        this.gho = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.d
            public void sL(int i) {
                ScrollFragmentTabHost.this.ghm.a(i, ScrollFragmentTabHost.this.ghn);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.ghg = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.ghh = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.ggW = findViewById(R.id.home_page_statebar_view);
        this.ggX = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.faG = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.dvR = (NoNetworkView) findViewById(R.id.view_no_network);
        this.cer = (FrameLayout) findViewById(R.id.home_pager_container);
        this.cho = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.ddZ = findViewById(R.id.divider_line);
        this.dxu = findViewById(R.id.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.ggW.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.ggX.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.ggZ.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.gha != null) {
                    ScrollFragmentTabHost.this.gha.sW(i);
                }
                com.baidu.tbadk.core.bigday.b.agw().dW(ScrollFragmentTabHost.this.ggZ.sN(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.sV(i) == 3) {
                    an anVar = new an("c12478");
                    anVar.bS("obj_source", "0");
                    TiebaStatic.log(anVar);
                }
                if (ScrollFragmentTabHost.this.sV(i) == 4) {
                    TiebaStatic.log(new an("c13172").O("obj_type", ScrollFragmentTabHost.this.ghc ? 2 : 1));
                    ScrollFragmentTabHost.this.ghc = false;
                } else if (ScrollFragmentTabHost.this.sV(i) == 6) {
                    TiebaStatic.log("c13545");
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.sV(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.fbH != null && ScrollFragmentTabHost.this.ggZ != null) {
                    int sN = ScrollFragmentTabHost.this.ggZ.sN(ScrollFragmentTabHost.this.cho.getCurrentItem());
                    if (sN == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.fbH) {
                            aVar.btQ();
                        }
                    } else if (sN == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.fbH) {
                            aVar2.btP();
                        }
                    } else if (sN == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.fbH) {
                            aVar3.bsY();
                        }
                    } else if (sN == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (sN == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.aJz();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.btM();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.sV(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean btH = ScrollFragmentTabHost.this.btH();
                    TiebaStatic.log(new an("c12350").O("obj_type", btH ? 1 : 0));
                    if (btH && ScrollFragmentTabHost.this.ggZ != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.ggZ.btF();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.ggX.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void k(View view, int i) {
                if (ScrollFragmentTabHost.this.cho.getCurrentItem() != i && ScrollFragmentTabHost.this.sV(i) == 4) {
                    ScrollFragmentTabHost.this.ghc = true;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.cho.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.sV(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.sV(i) == 7) {
                    TiebaStatic.log(new an("c13483").bS("obj_type", "1"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.sV(i));
            }
        });
        this.ghg.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void lc(boolean z) {
                if (z && ScrollFragmentTabHost.this.ghi != null) {
                    ScrollFragmentTabHost.this.ghi.uQ();
                }
            }
        });
        this.ghh.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void wW(String str) {
                if (ScrollFragmentTabHost.this.ghi != null) {
                    ScrollFragmentTabHost.this.ghi.uQ();
                    ScrollFragmentTabHost.this.ghi = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    ba.amO().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.ghh.setVisibility(8);
            this.ggX.setMissionEntranceVisibility(true);
            this.ggX.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void wW(String str) {
                    if (ScrollFragmentTabHost.this.ghi != null) {
                        ScrollFragmentTabHost.this.ghi.uQ();
                        ScrollFragmentTabHost.this.ghi = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        ba.amO().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.ghh.setVisibility(0);
        this.ggX.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.ghk.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.ghk);
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
        this.dvR.a(aVar);
        MessageManager.getInstance().registerListener(this.ghd);
        MessageManager.getInstance().registerListener(this.ghe);
        MessageManager.getInstance().registerListener(this.ghf);
        MessageManager.getInstance().registerListener(this.ghl);
        this.ghj.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.ghj);
    }

    public void notifyDataSetChanged() {
        if (this.ggZ != null && !HomePageStatic.gcJ) {
            this.cho.setAdapter(this.ggZ);
            this.ggX.notifyDataSetChanged();
            this.ghm.a(this.ghn);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ggZ != null) {
            this.ggZ.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ggZ != null) {
            this.ggZ.d(dataRes, z);
        }
    }

    public void btE() {
        if (this.ggZ != null) {
            this.ggZ.btE();
        }
    }

    public void u(String str, int i, int i2) {
        if (this.cho != null) {
            this.ggZ.u(str, i, i2);
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
        this.ggZ = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.ggZ.setScrollFragmentTabHost(this);
        this.cho.setOffscreenPageLimit(2);
        this.cho.setAdapter(this.ggZ);
        int btB = this.ggZ.btB();
        if (com.baidu.tbadk.core.sharedPref.b.alP().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.alP().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.ggZ;
            if (HomePageStatic.gcJ) {
                i = 0;
            }
            this.cho.setCurrentItem(newScrollFragmentAdapter.sO(i));
            this.ggX.setViewPager(this.cho);
            this.ggX.setConcernTabIndex(this.ggZ.sO(0));
            if (this.ggV != null) {
                this.ggZ.setRecommendFrsNavigationAnimDispatcher(this.ggV);
            }
            btM();
        }
        i = btB;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.ggZ;
        if (HomePageStatic.gcJ) {
        }
        this.cho.setCurrentItem(newScrollFragmentAdapter2.sO(i));
        this.ggX.setViewPager(this.cho);
        this.ggX.setConcernTabIndex(this.ggZ.sO(0));
        if (this.ggV != null) {
        }
        btM();
    }

    public boolean btK() {
        return this.ggZ != null && this.ggZ.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.ggZ.getCount()) {
            this.ggX.setTabItemClicked(z);
            this.ggZ.sR(i);
            this.cho.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.ggZ.sO(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ggX.setPageUniqueId(bdUniqueId);
        this.ghd.setTag(bdUniqueId);
        this.ghe.setTag(bdUniqueId);
        this.ghf.setTag(bdUniqueId);
        this.ghl.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.cer;
    }

    public int getCurrentTabType() {
        return this.ggZ.sN(this.cho.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.cho.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.ggZ.sN(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int sV(int i) {
        return this.ggZ.sN(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.ggW, R.color.cp_bg_line_h);
        this.ghh.onChangeSkinType();
        this.ggX.onChangeSkinType();
        if (this.mPageContext != null && this.dvR != null) {
            this.dvR.onChangeSkinType(this.mPageContext, i);
        }
        if (this.ggZ != null) {
            this.ggZ.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.faG != null) {
            this.faG.onChangeSkinType(this.mPageContext, i);
        }
        am.setBackgroundColor(this.ddZ, R.color.cp_bg_line_c);
    }

    private boolean aJx() {
        return this.dxu.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.ggY = z;
        if (z) {
            if (this.ddZ != null) {
                this.ddZ.setVisibility(8);
            }
        } else if (this.ddZ != null) {
            this.ddZ.setVisibility(0);
        }
    }

    public void aJy() {
        if (this.ggY && !aJx()) {
            this.dxu.setVisibility(0);
            if (this.dxx == null) {
                this.dxx = new AlphaAnimation(0.0f, 1.0f);
                this.dxx.setFillAfter(true);
                this.dxx.setDuration(300L);
            }
            this.dxu.startAnimation(this.dxx);
        }
    }

    public void aJz() {
        if (this.ggY && aJx()) {
            if (this.dxy == null) {
                this.dxy = new AlphaAnimation(1.0f, 0.0f);
                this.dxy.setFillAfter(true);
                this.dxy.setDuration(300L);
                this.dxy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.dxu.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.dxu.startAnimation(this.dxy);
        }
    }

    public void btG() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.ggZ != null) {
            this.ggZ.btG();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4 || currentTabType == 5 || currentTabType == 6 || currentTabType == 7) && this.ggZ != null) {
            this.ggZ.btG();
        }
    }

    public void aKf() {
        this.ggZ.aKf();
    }

    public String getCurrentPageKey() {
        if (this.ggZ != null) {
            return this.ggZ.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.cho != null) {
            return this.cho.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.ggZ != null) {
            this.ggZ.setPrimary(z);
        }
        if (this.dvR != null && z) {
            this.dvR.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void btL() {
        this.ggZ.a(this.gho);
    }

    public void jT(boolean z) {
        if (!z && this.ggX != null && this.ggX.getTaskView() != null && this.ggX.getTaskView().getVisibility() != 0) {
            this.ggX.btT();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.gha = bVar;
    }

    public void onDestroy() {
        if (this.ggV != null) {
            this.ggV.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.ghi != null) {
            this.ghi.uQ();
            this.ghi = null;
        }
        btO();
    }

    public void btM() {
        int i = 1;
        if (this.ggZ != null) {
            int sN = this.ggZ.sN(this.cho.getCurrentItem());
            if (sN == 0) {
                i = 0;
            } else if (sN != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.alP().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.ggX != null && this.ggZ.btD()) {
            this.ggX.setShowConcernRedTip(z);
        }
    }

    public boolean btH() {
        if (this.ggX == null || !this.ggZ.btD()) {
            return false;
        }
        return this.ggX.btH();
    }

    public void setVideoThreadId(String str) {
        if (this.ggZ != null) {
            this.ggZ.setVideoThreadId(str);
        }
    }

    public void btN() {
        if (com.baidu.tbadk.core.sharedPref.b.alP().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int sO = this.ggZ != null ? this.ggZ.sO(0) : 0;
            if (this.ghb == null) {
                this.ghb = new d(this.mPageContext, this.ggX.sS(sO));
                this.ghb.bB(R.drawable.bg_tip_blue_up);
                this.ghb.bA(32);
                this.ghb.iX(true);
                this.ghb.setUseDirectOffset(true);
                this.ghb.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.ghb.bC(UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
            }
            this.ghb.c(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void btO() {
        if (this.ghb != null) {
            this.ghb.uQ();
        }
    }

    public void onResume() {
        if (this.ggX != null) {
            this.ggX.onResume();
        }
    }

    public void a(a aVar) {
        if (this.fbH == null) {
            this.fbH = new ArrayList();
        }
        this.fbH.add(aVar);
    }

    public void b(a aVar) {
        if (this.fbH != null && this.fbH.size() > 0) {
            this.fbH.remove(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void btP() {
        }

        public void btQ() {
        }

        public void bsY() {
        }
    }
}
