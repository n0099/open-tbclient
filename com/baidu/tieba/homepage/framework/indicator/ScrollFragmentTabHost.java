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
    private CustomViewPager bPz;
    private View cSY;
    private NoNetworkView dlW;
    private View dni;
    private AlphaAnimation dnl;
    private AlphaAnimation dnm;
    private PluginErrorTipView eRV;
    private List<a> eST;
    private x gaB;
    private View gaC;
    private HomeTabBarView gaD;
    private boolean gaE;
    private NewScrollFragmentAdapter gaF;
    private b gaG;
    private d gaH;
    private boolean gaI;
    public CustomMessageListener gaJ;
    public CustomMessageListener gaK;
    CustomMessageListener gaL;
    private StickyAppBarLayout gaM;
    private NestedScrollHeader gaN;
    private d gaO;
    CustomMessageTask gaP;
    CustomMessageTask gaQ;
    CustomMessageListener gaR;
    private c gaS;
    private e gaT;
    private com.baidu.tieba.homepage.framework.d gaU;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void tE(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.gaJ = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                }
            }
        };
        this.gaK = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.gaF != null) {
                    ScrollFragmentTabHost.this.gaF.btr();
                }
                if (ScrollFragmentTabHost.this.gaD != null) {
                    ScrollFragmentTabHost.this.gaD.notifyDataSetChanged();
                }
            }
        };
        this.gaL = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aHR();
                } else {
                    ScrollFragmentTabHost.this.aHS();
                }
            }
        };
        this.gaP = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.gaM == null || ScrollFragmentTabHost.this.gaN == null) {
                    return null;
                }
                if ((ScrollFragmentTabHost.this.gaN.getTaskView() == null || ScrollFragmentTabHost.this.gaN.getTaskView().getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof n.a)) {
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
                    if (ScrollFragmentTabHost.this.gaO != null) {
                        ScrollFragmentTabHost.this.gaO.aZx();
                    }
                    ScrollFragmentTabHost.this.gaO = new d(ScrollFragmentTabHost.this.mPageContext, ScrollFragmentTabHost.this.gaN.getTaskView());
                    ScrollFragmentTabHost.this.gaO.pJ(48);
                    ScrollFragmentTabHost.this.gaO.S(true);
                    ScrollFragmentTabHost.this.gaO.pI(4);
                    ScrollFragmentTabHost.this.gaO.pL(i);
                    ScrollFragmentTabHost.this.gaO.iI(true);
                    ScrollFragmentTabHost.this.gaO.pN(0);
                    ScrollFragmentTabHost.this.gaO.ve(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.gaQ = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.gaM == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aHS();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.gaM.btH();
                } else if (!ScrollFragmentTabHost.this.gaM.isSticky()) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.gaM.btH();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.gaR = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.gaO != null) {
                    ScrollFragmentTabHost.this.gaO.aZx();
                    ScrollFragmentTabHost.this.gaO = null;
                }
            }
        };
        this.gaS = new c();
        this.gaT = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void tu(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.gaF.tw(i), false);
                ScrollFragmentTabHost.this.gaF.ty(i);
            }
        };
        this.gaU = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void tt(int i) {
                ScrollFragmentTabHost.this.gaS.a(i, ScrollFragmentTabHost.this.gaT);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaJ = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                }
            }
        };
        this.gaK = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.gaF != null) {
                    ScrollFragmentTabHost.this.gaF.btr();
                }
                if (ScrollFragmentTabHost.this.gaD != null) {
                    ScrollFragmentTabHost.this.gaD.notifyDataSetChanged();
                }
            }
        };
        this.gaL = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aHR();
                } else {
                    ScrollFragmentTabHost.this.aHS();
                }
            }
        };
        this.gaP = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.gaM == null || ScrollFragmentTabHost.this.gaN == null) {
                    return null;
                }
                if ((ScrollFragmentTabHost.this.gaN.getTaskView() == null || ScrollFragmentTabHost.this.gaN.getTaskView().getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof n.a)) {
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
                    if (ScrollFragmentTabHost.this.gaO != null) {
                        ScrollFragmentTabHost.this.gaO.aZx();
                    }
                    ScrollFragmentTabHost.this.gaO = new d(ScrollFragmentTabHost.this.mPageContext, ScrollFragmentTabHost.this.gaN.getTaskView());
                    ScrollFragmentTabHost.this.gaO.pJ(48);
                    ScrollFragmentTabHost.this.gaO.S(true);
                    ScrollFragmentTabHost.this.gaO.pI(4);
                    ScrollFragmentTabHost.this.gaO.pL(i);
                    ScrollFragmentTabHost.this.gaO.iI(true);
                    ScrollFragmentTabHost.this.gaO.pN(0);
                    ScrollFragmentTabHost.this.gaO.ve(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.gaQ = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.gaM == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aHS();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.gaM.btH();
                } else if (!ScrollFragmentTabHost.this.gaM.isSticky()) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.gaM.btH();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.gaR = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.gaO != null) {
                    ScrollFragmentTabHost.this.gaO.aZx();
                    ScrollFragmentTabHost.this.gaO = null;
                }
            }
        };
        this.gaS = new c();
        this.gaT = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void tu(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.gaF.tw(i), false);
                ScrollFragmentTabHost.this.gaF.ty(i);
            }
        };
        this.gaU = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void tt(int i) {
                ScrollFragmentTabHost.this.gaS.a(i, ScrollFragmentTabHost.this.gaT);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.gaM = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.gaN = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.gaC = findViewById(R.id.home_page_statebar_view);
        this.gaD = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.eRV = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.dlW = (NoNetworkView) findViewById(R.id.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(R.id.home_pager_container);
        this.bPz = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.cSY = findViewById(R.id.divider_line);
        this.dni = findViewById(R.id.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gaC.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.gaD.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.gaF.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.gaG != null) {
                    ScrollFragmentTabHost.this.gaG.tE(i);
                }
                com.baidu.tbadk.core.bigday.b.abp().dC(ScrollFragmentTabHost.this.gaF.tv(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.tD(i) == 3) {
                    am amVar = new am("c12478");
                    amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(amVar);
                }
                if (ScrollFragmentTabHost.this.tD(i) == 4) {
                    TiebaStatic.log(new am("c13172").P("obj_type", ScrollFragmentTabHost.this.gaI ? 2 : 1));
                    ScrollFragmentTabHost.this.gaI = false;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.tD(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.eST != null && ScrollFragmentTabHost.this.gaF != null) {
                    int tv2 = ScrollFragmentTabHost.this.gaF.tv(ScrollFragmentTabHost.this.bPz.getCurrentItem());
                    if (tv2 == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.eST) {
                            aVar.btF();
                        }
                    } else if (tv2 == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.eST) {
                            aVar2.btE();
                        }
                    } else if (tv2 == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.eST) {
                            aVar3.bsO();
                        }
                    } else if (tv2 == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.aHS();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.btB();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.tD(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean btw = ScrollFragmentTabHost.this.btw();
                    TiebaStatic.log(new am("c12350").P("obj_type", btw ? 1 : 0));
                    if (btw && ScrollFragmentTabHost.this.gaF != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.gaF.btu();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.gaD.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void r(View view, int i) {
                if (ScrollFragmentTabHost.this.bPz.getCurrentItem() != i && ScrollFragmentTabHost.this.tD(i) == 4) {
                    ScrollFragmentTabHost.this.gaI = true;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.bPz.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.tD(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.tD(i));
            }
        });
        this.gaM.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void la(boolean z) {
                if (z && ScrollFragmentTabHost.this.gaO != null) {
                    ScrollFragmentTabHost.this.gaO.aZx();
                }
            }
        });
        this.gaN.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ScrollFragmentTabHost.this.gaO != null) {
                    ScrollFragmentTabHost.this.gaO.aZx();
                    ScrollFragmentTabHost.this.gaO = null;
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.gaQ.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.gaQ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterTask(2921405);
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.dlW.a(aVar);
        MessageManager.getInstance().registerListener(this.gaJ);
        MessageManager.getInstance().registerListener(this.gaK);
        MessageManager.getInstance().registerListener(this.gaL);
        MessageManager.getInstance().registerListener(this.gaR);
        this.gaP.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.gaP);
    }

    public void notifyDataSetChanged() {
        if (this.gaF != null && !HomePageStatic.fWw) {
            this.bPz.setAdapter(this.gaF);
            this.gaD.notifyDataSetChanged();
            this.gaS.a(this.gaT);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gaF != null) {
            this.gaF.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gaF != null) {
            this.gaF.d(dataRes, z);
        }
    }

    public void btt() {
        if (this.gaF != null) {
            this.gaF.btt();
        }
    }

    public void v(String str, int i, int i2) {
        if (this.bPz != null) {
            this.gaF.v(str, i, i2);
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
        this.gaF = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.gaF.setScrollFragmentTabHost(this);
        this.bPz.setOffscreenPageLimit(2);
        this.bPz.setAdapter(this.gaF);
        int btq = this.gaF.btq();
        if (com.baidu.tbadk.core.sharedPref.b.agM().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.agM().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.gaF;
            if (HomePageStatic.fWw) {
                i = 0;
            }
            this.bPz.setCurrentItem(newScrollFragmentAdapter.tw(i));
            this.gaD.setViewPager(this.bPz);
            this.gaD.setConcernTabIndex(this.gaF.tw(0));
            if (this.gaB != null) {
                this.gaF.setRecommendFrsNavigationAnimDispatcher(this.gaB);
            }
            btB();
        }
        i = btq;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.gaF;
        if (HomePageStatic.fWw) {
        }
        this.bPz.setCurrentItem(newScrollFragmentAdapter2.tw(i));
        this.gaD.setViewPager(this.bPz);
        this.gaD.setConcernTabIndex(this.gaF.tw(0));
        if (this.gaB != null) {
        }
        btB();
    }

    public boolean btz() {
        return this.gaF != null && this.gaF.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.gaF.getCount()) {
            this.gaD.setTabItemClicked(z);
            this.gaF.tz(i);
            this.bPz.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.gaF.tw(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gaD.setPageUniqueId(bdUniqueId);
        this.gaJ.setTag(bdUniqueId);
        this.gaK.setTag(bdUniqueId);
        this.gaL.setTag(bdUniqueId);
        this.gaR.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.gaF.tv(this.bPz.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.bPz.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.gaF.tv(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int tD(int i) {
        return this.gaF.tv(i);
    }

    public void onChangeSkinType(int i) {
        al.l(this.gaC, R.color.cp_bg_line_d);
        this.gaN.onChangeSkinType();
        this.gaD.onChangeSkinType();
        if (this.mPageContext != null && this.dlW != null) {
            this.dlW.onChangeSkinType(this.mPageContext, i);
        }
        if (this.gaF != null) {
            this.gaF.iW(i);
        }
        if (this.mPageContext != null && this.eRV != null) {
            this.eRV.onChangeSkinType(this.mPageContext, i);
        }
        al.l(this.cSY, R.color.cp_bg_line_c);
    }

    private boolean aHQ() {
        return this.dni.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.gaE = z;
        if (z) {
            if (this.cSY != null) {
                this.cSY.setVisibility(8);
            }
        } else if (this.cSY != null) {
            this.cSY.setVisibility(0);
        }
    }

    public void aHR() {
        if (this.gaE && !aHQ()) {
            this.dni.setVisibility(0);
            if (this.dnl == null) {
                this.dnl = new AlphaAnimation(0.0f, 1.0f);
                this.dnl.setFillAfter(true);
                this.dnl.setDuration(300L);
            }
            this.dni.startAnimation(this.dnl);
        }
    }

    public void aHS() {
        if (this.gaE && aHQ()) {
            if (this.dnm == null) {
                this.dnm = new AlphaAnimation(1.0f, 0.0f);
                this.dnm.setFillAfter(true);
                this.dnm.setDuration(300L);
                this.dnm.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.dni.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.dni.startAnimation(this.dnm);
        }
    }

    public void btv() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.gaF != null) {
            this.gaF.btv();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4 || currentTabType == 5 || currentTabType == 6) && this.gaF != null) {
            this.gaF.btv();
        }
    }

    public void aID() {
        this.gaF.aID();
    }

    public String getCurrentPageKey() {
        if (this.gaF != null) {
            return this.gaF.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.bPz != null) {
            return this.bPz.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.gaF != null) {
            this.gaF.setPrimary(z);
        }
        if (this.dlW != null && z) {
            this.dlW.setVisibility(j.jG() ? 8 : 0);
        }
    }

    public void btA() {
        this.gaF.a(this.gaU);
    }

    public void setOnTabSelectedListener(b bVar) {
        this.gaG = bVar;
    }

    public void onDestroy() {
        if (this.gaB != null) {
            this.gaB.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.gaO != null) {
            this.gaO.aZx();
            this.gaO = null;
        }
        btD();
    }

    public void btB() {
        int i = 1;
        if (this.gaF != null) {
            int tv2 = this.gaF.tv(this.bPz.getCurrentItem());
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
        if (this.gaD != null && this.gaF.bts()) {
            this.gaD.setShowConcernRedTip(z);
        }
    }

    public boolean btw() {
        if (this.gaD == null || !this.gaF.bts()) {
            return false;
        }
        return this.gaD.btw();
    }

    public void setVideoThreadId(String str) {
        if (this.gaF != null) {
            this.gaF.setVideoThreadId(str);
        }
    }

    public void btC() {
        if (com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int tw = this.gaF != null ? this.gaF.tw(0) : 0;
            if (this.gaH == null) {
                this.gaH = new d(this.mPageContext, this.gaD.tA(tw));
                this.gaH.pK(R.drawable.bg_tip_blue_up);
                this.gaH.pJ(32);
                this.gaH.iI(true);
                this.gaH.S(true);
                this.gaH.setYOffset(l.g(this.mContext, R.dimen.ds16));
                this.gaH.pL(UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
            }
            this.gaH.u(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void btD() {
        if (this.gaH != null) {
            this.gaH.aZx();
        }
    }

    public void onResume() {
        if (this.gaD != null) {
            this.gaD.onResume();
        }
    }

    public void a(a aVar) {
        if (this.eST == null) {
            this.eST = new ArrayList();
        }
        this.eST.add(aVar);
    }

    public void b(a aVar) {
        if (this.eST != null && this.eST.size() > 0) {
            this.eST.remove(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void btE() {
        }

        public void btF() {
        }

        public void bsO() {
        }
    }
}
