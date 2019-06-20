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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.c.d;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.e;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class ScrollFragmentTabHost extends RelativeLayout {
    private CustomViewPager bPA;
    private View cTa;
    private NoNetworkView dlX;
    private View dnj;
    private AlphaAnimation dnm;
    private AlphaAnimation dnn;
    private PluginErrorTipView eRW;
    private List<a> eSU;
    private x gaE;
    private View gaF;
    private HomeTabBarView gaG;
    private boolean gaH;
    private NewScrollFragmentAdapter gaI;
    private b gaJ;
    private d gaK;
    private boolean gaL;
    public CustomMessageListener gaM;
    public CustomMessageListener gaN;
    CustomMessageListener gaO;
    private StickyAppBarLayout gaP;
    private NestedScrollHeader gaQ;
    private d gaR;
    CustomMessageTask gaS;
    CustomMessageTask gaT;
    CustomMessageListener gaU;
    private c gaV;
    private e gaW;
    private com.baidu.tieba.homepage.framework.d gaX;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void tE(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.gaM = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                }
            }
        };
        this.gaN = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.gaI != null) {
                    ScrollFragmentTabHost.this.gaI.btv();
                }
                if (ScrollFragmentTabHost.this.gaG != null) {
                    ScrollFragmentTabHost.this.gaG.notifyDataSetChanged();
                }
            }
        };
        this.gaO = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aHU();
                } else {
                    ScrollFragmentTabHost.this.aHV();
                }
            }
        };
        this.gaS = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.gaP == null || ScrollFragmentTabHost.this.gaQ == null) {
                    return null;
                }
                if ((ScrollFragmentTabHost.this.gaQ.getTaskView() == null || ScrollFragmentTabHost.this.gaQ.getTaskView().getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof n.a)) {
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
                    if (ScrollFragmentTabHost.this.gaR != null) {
                        ScrollFragmentTabHost.this.gaR.aZA();
                    }
                    ScrollFragmentTabHost.this.gaR = new d(ScrollFragmentTabHost.this.mPageContext, ScrollFragmentTabHost.this.gaQ.getTaskView());
                    ScrollFragmentTabHost.this.gaR.pJ(48);
                    ScrollFragmentTabHost.this.gaR.S(true);
                    ScrollFragmentTabHost.this.gaR.pI(4);
                    ScrollFragmentTabHost.this.gaR.pL(i);
                    ScrollFragmentTabHost.this.gaR.iI(true);
                    ScrollFragmentTabHost.this.gaR.pN(0);
                    ScrollFragmentTabHost.this.gaR.vd(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.gaT = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.gaP == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aHV();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.gaP.btL();
                } else if (!ScrollFragmentTabHost.this.gaP.isSticky()) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.gaP.btL();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.gaU = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.gaR != null) {
                    ScrollFragmentTabHost.this.gaR.aZA();
                    ScrollFragmentTabHost.this.gaR = null;
                }
            }
        };
        this.gaV = new c();
        this.gaW = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void tu(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.gaI.tw(i), false);
                ScrollFragmentTabHost.this.gaI.ty(i);
            }
        };
        this.gaX = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void tt(int i) {
                ScrollFragmentTabHost.this.gaV.a(i, ScrollFragmentTabHost.this.gaW);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaM = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                }
            }
        };
        this.gaN = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.gaI != null) {
                    ScrollFragmentTabHost.this.gaI.btv();
                }
                if (ScrollFragmentTabHost.this.gaG != null) {
                    ScrollFragmentTabHost.this.gaG.notifyDataSetChanged();
                }
            }
        };
        this.gaO = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aHU();
                } else {
                    ScrollFragmentTabHost.this.aHV();
                }
            }
        };
        this.gaS = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.gaP == null || ScrollFragmentTabHost.this.gaQ == null) {
                    return null;
                }
                if ((ScrollFragmentTabHost.this.gaQ.getTaskView() == null || ScrollFragmentTabHost.this.gaQ.getTaskView().getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof n.a)) {
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
                    if (ScrollFragmentTabHost.this.gaR != null) {
                        ScrollFragmentTabHost.this.gaR.aZA();
                    }
                    ScrollFragmentTabHost.this.gaR = new d(ScrollFragmentTabHost.this.mPageContext, ScrollFragmentTabHost.this.gaQ.getTaskView());
                    ScrollFragmentTabHost.this.gaR.pJ(48);
                    ScrollFragmentTabHost.this.gaR.S(true);
                    ScrollFragmentTabHost.this.gaR.pI(4);
                    ScrollFragmentTabHost.this.gaR.pL(i);
                    ScrollFragmentTabHost.this.gaR.iI(true);
                    ScrollFragmentTabHost.this.gaR.pN(0);
                    ScrollFragmentTabHost.this.gaR.vd(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.gaT = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.gaP == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aHV();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.gaP.btL();
                } else if (!ScrollFragmentTabHost.this.gaP.isSticky()) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.gaP.btL();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.gaU = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.gaR != null) {
                    ScrollFragmentTabHost.this.gaR.aZA();
                    ScrollFragmentTabHost.this.gaR = null;
                }
            }
        };
        this.gaV = new c();
        this.gaW = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void tu(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.gaI.tw(i), false);
                ScrollFragmentTabHost.this.gaI.ty(i);
            }
        };
        this.gaX = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void tt(int i) {
                ScrollFragmentTabHost.this.gaV.a(i, ScrollFragmentTabHost.this.gaW);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.gaP = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.gaQ = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.gaF = findViewById(R.id.home_page_statebar_view);
        this.gaG = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.eRW = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.dlX = (NoNetworkView) findViewById(R.id.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(R.id.home_pager_container);
        this.bPA = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.cTa = findViewById(R.id.divider_line);
        this.dnj = findViewById(R.id.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gaF.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.gaG.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.gaI.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.gaJ != null) {
                    ScrollFragmentTabHost.this.gaJ.tE(i);
                }
                com.baidu.tbadk.core.bigday.b.abp().dC(ScrollFragmentTabHost.this.gaI.tv(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.tD(i) == 3) {
                    am amVar = new am("c12478");
                    amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(amVar);
                }
                if (ScrollFragmentTabHost.this.tD(i) == 4) {
                    TiebaStatic.log(new am("c13172").P("obj_type", ScrollFragmentTabHost.this.gaL ? 2 : 1));
                    ScrollFragmentTabHost.this.gaL = false;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.tD(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.eSU != null && ScrollFragmentTabHost.this.gaI != null) {
                    int tv2 = ScrollFragmentTabHost.this.gaI.tv(ScrollFragmentTabHost.this.bPA.getCurrentItem());
                    if (tv2 == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.eSU) {
                            aVar.btJ();
                        }
                    } else if (tv2 == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.eSU) {
                            aVar2.btI();
                        }
                    } else if (tv2 == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.eSU) {
                            aVar3.bsT();
                        }
                    } else if (tv2 == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.aHV();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.btF();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.tD(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean btA = ScrollFragmentTabHost.this.btA();
                    TiebaStatic.log(new am("c12350").P("obj_type", btA ? 1 : 0));
                    if (btA && ScrollFragmentTabHost.this.gaI != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.gaI.bty();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.gaG.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void r(View view, int i) {
                if (ScrollFragmentTabHost.this.bPA.getCurrentItem() != i && ScrollFragmentTabHost.this.tD(i) == 4) {
                    ScrollFragmentTabHost.this.gaL = true;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.bPA.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.tD(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.tD(i));
            }
        });
        this.gaP.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void lb(boolean z) {
                if (z && ScrollFragmentTabHost.this.gaR != null) {
                    ScrollFragmentTabHost.this.gaR.aZA();
                }
            }
        });
        this.gaQ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ScrollFragmentTabHost.this.gaR != null) {
                    ScrollFragmentTabHost.this.gaR.aZA();
                    ScrollFragmentTabHost.this.gaR = null;
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.gaT.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.gaT);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterTask(2921405);
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.dlX.a(aVar);
        MessageManager.getInstance().registerListener(this.gaM);
        MessageManager.getInstance().registerListener(this.gaN);
        MessageManager.getInstance().registerListener(this.gaO);
        MessageManager.getInstance().registerListener(this.gaU);
        this.gaS.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.gaS);
    }

    public void notifyDataSetChanged() {
        if (this.gaI != null && !HomePageStatic.fWz) {
            this.bPA.setAdapter(this.gaI);
            this.gaG.notifyDataSetChanged();
            this.gaV.a(this.gaW);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gaI != null) {
            this.gaI.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gaI != null) {
            this.gaI.d(dataRes, z);
        }
    }

    public void btx() {
        if (this.gaI != null) {
            this.gaI.btx();
        }
    }

    public void v(String str, int i, int i2) {
        if (this.bPA != null) {
            this.gaI.v(str, i, i2);
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
        this.gaI = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.gaI.setScrollFragmentTabHost(this);
        this.bPA.setOffscreenPageLimit(2);
        this.bPA.setAdapter(this.gaI);
        int btu = this.gaI.btu();
        if (com.baidu.tbadk.core.sharedPref.b.agM().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.agM().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.gaI;
            if (HomePageStatic.fWz) {
                i = 0;
            }
            this.bPA.setCurrentItem(newScrollFragmentAdapter.tw(i));
            this.gaG.setViewPager(this.bPA);
            this.gaG.setConcernTabIndex(this.gaI.tw(0));
            if (this.gaE != null) {
                this.gaI.setRecommendFrsNavigationAnimDispatcher(this.gaE);
            }
            btF();
        }
        i = btu;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.gaI;
        if (HomePageStatic.fWz) {
        }
        this.bPA.setCurrentItem(newScrollFragmentAdapter2.tw(i));
        this.gaG.setViewPager(this.bPA);
        this.gaG.setConcernTabIndex(this.gaI.tw(0));
        if (this.gaE != null) {
        }
        btF();
    }

    public boolean btD() {
        return this.gaI != null && this.gaI.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.gaI.getCount()) {
            this.gaG.setTabItemClicked(z);
            this.gaI.tz(i);
            this.bPA.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.gaI.tw(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gaG.setPageUniqueId(bdUniqueId);
        this.gaM.setTag(bdUniqueId);
        this.gaN.setTag(bdUniqueId);
        this.gaO.setTag(bdUniqueId);
        this.gaU.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.gaI.tv(this.bPA.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.bPA.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.gaI.tv(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int tD(int i) {
        return this.gaI.tv(i);
    }

    public void onChangeSkinType(int i) {
        al.l(this.gaF, R.color.cp_bg_line_d);
        this.gaQ.onChangeSkinType();
        this.gaG.onChangeSkinType();
        if (this.mPageContext != null && this.dlX != null) {
            this.dlX.onChangeSkinType(this.mPageContext, i);
        }
        if (this.gaI != null) {
            this.gaI.iW(i);
        }
        if (this.mPageContext != null && this.eRW != null) {
            this.eRW.onChangeSkinType(this.mPageContext, i);
        }
        al.l(this.cTa, R.color.cp_bg_line_c);
    }

    private boolean aHT() {
        return this.dnj.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.gaH = z;
        if (z) {
            if (this.cTa != null) {
                this.cTa.setVisibility(8);
            }
        } else if (this.cTa != null) {
            this.cTa.setVisibility(0);
        }
    }

    public void aHU() {
        if (this.gaH && !aHT()) {
            this.dnj.setVisibility(0);
            if (this.dnm == null) {
                this.dnm = new AlphaAnimation(0.0f, 1.0f);
                this.dnm.setFillAfter(true);
                this.dnm.setDuration(300L);
            }
            this.dnj.startAnimation(this.dnm);
        }
    }

    public void aHV() {
        if (this.gaH && aHT()) {
            if (this.dnn == null) {
                this.dnn = new AlphaAnimation(1.0f, 0.0f);
                this.dnn.setFillAfter(true);
                this.dnn.setDuration(300L);
                this.dnn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.dnj.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.dnj.startAnimation(this.dnn);
        }
    }

    public void btz() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.gaI != null) {
            this.gaI.btz();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4 || currentTabType == 5 || currentTabType == 6) && this.gaI != null) {
            this.gaI.btz();
        }
    }

    public void aIG() {
        this.gaI.aIG();
    }

    public String getCurrentPageKey() {
        if (this.gaI != null) {
            return this.gaI.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.bPA != null) {
            return this.bPA.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.gaI != null) {
            this.gaI.setPrimary(z);
        }
        if (this.dlX != null && z) {
            this.dlX.setVisibility(j.jG() ? 8 : 0);
        }
    }

    public void btE() {
        this.gaI.a(this.gaX);
    }

    public void setOnTabSelectedListener(b bVar) {
        this.gaJ = bVar;
    }

    public void onDestroy() {
        if (this.gaE != null) {
            this.gaE.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.gaR != null) {
            this.gaR.aZA();
            this.gaR = null;
        }
        btH();
    }

    public void btF() {
        int i = 1;
        if (this.gaI != null) {
            int tv2 = this.gaI.tv(this.bPA.getCurrentItem());
            if (tv2 == 0) {
                i = 0;
            } else if (tv2 != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.agM().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.gaG != null && this.gaI.btw()) {
            this.gaG.setShowConcernRedTip(z);
        }
    }

    public boolean btA() {
        if (this.gaG == null || !this.gaI.btw()) {
            return false;
        }
        return this.gaG.btA();
    }

    public void setVideoThreadId(String str) {
        if (this.gaI != null) {
            this.gaI.setVideoThreadId(str);
        }
    }

    public void btG() {
        if (com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int tw = this.gaI != null ? this.gaI.tw(0) : 0;
            if (this.gaK == null) {
                this.gaK = new d(this.mPageContext, this.gaG.tA(tw));
                this.gaK.pK(R.drawable.bg_tip_blue_up);
                this.gaK.pJ(32);
                this.gaK.iI(true);
                this.gaK.S(true);
                this.gaK.setYOffset(l.g(this.mContext, R.dimen.ds16));
                this.gaK.pL(UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
            }
            this.gaK.u(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void btH() {
        if (this.gaK != null) {
            this.gaK.aZA();
        }
    }

    public void onResume() {
        if (this.gaG != null) {
            this.gaG.onResume();
        }
    }

    public void a(a aVar) {
        if (this.eSU == null) {
            this.eSU = new ArrayList();
        }
        this.eSU.add(aVar);
    }

    public void b(a aVar) {
        if (this.eSU != null && this.eSU.size() > 0) {
            this.eSU.remove(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void btI() {
        }

        public void btJ() {
        }

        public void bsT() {
        }
    }
}
