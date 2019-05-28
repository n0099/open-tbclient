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
    private View cSZ;
    private NoNetworkView dlX;
    private View dnj;
    private AlphaAnimation dnm;
    private AlphaAnimation dnn;
    private PluginErrorTipView eRW;
    private List<a> eSU;
    private x gaC;
    private View gaD;
    private HomeTabBarView gaE;
    private boolean gaF;
    private NewScrollFragmentAdapter gaG;
    private b gaH;
    private d gaI;
    private boolean gaJ;
    public CustomMessageListener gaK;
    public CustomMessageListener gaL;
    CustomMessageListener gaM;
    private StickyAppBarLayout gaN;
    private NestedScrollHeader gaO;
    private d gaP;
    CustomMessageTask gaQ;
    CustomMessageTask gaR;
    CustomMessageListener gaS;
    private c gaT;
    private e gaU;
    private com.baidu.tieba.homepage.framework.d gaV;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void tE(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.gaK = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                }
            }
        };
        this.gaL = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.gaG != null) {
                    ScrollFragmentTabHost.this.gaG.btu();
                }
                if (ScrollFragmentTabHost.this.gaE != null) {
                    ScrollFragmentTabHost.this.gaE.notifyDataSetChanged();
                }
            }
        };
        this.gaM = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
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
        this.gaQ = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.gaN == null || ScrollFragmentTabHost.this.gaO == null) {
                    return null;
                }
                if ((ScrollFragmentTabHost.this.gaO.getTaskView() == null || ScrollFragmentTabHost.this.gaO.getTaskView().getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof n.a)) {
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
                    if (ScrollFragmentTabHost.this.gaP != null) {
                        ScrollFragmentTabHost.this.gaP.aZA();
                    }
                    ScrollFragmentTabHost.this.gaP = new d(ScrollFragmentTabHost.this.mPageContext, ScrollFragmentTabHost.this.gaO.getTaskView());
                    ScrollFragmentTabHost.this.gaP.pJ(48);
                    ScrollFragmentTabHost.this.gaP.S(true);
                    ScrollFragmentTabHost.this.gaP.pI(4);
                    ScrollFragmentTabHost.this.gaP.pL(i);
                    ScrollFragmentTabHost.this.gaP.iI(true);
                    ScrollFragmentTabHost.this.gaP.pN(0);
                    ScrollFragmentTabHost.this.gaP.ve(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.gaR = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.gaN == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aHV();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.gaN.btK();
                } else if (!ScrollFragmentTabHost.this.gaN.isSticky()) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.gaN.btK();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.gaS = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.gaP != null) {
                    ScrollFragmentTabHost.this.gaP.aZA();
                    ScrollFragmentTabHost.this.gaP = null;
                }
            }
        };
        this.gaT = new c();
        this.gaU = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void tu(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.gaG.tw(i), false);
                ScrollFragmentTabHost.this.gaG.ty(i);
            }
        };
        this.gaV = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void tt(int i) {
                ScrollFragmentTabHost.this.gaT.a(i, ScrollFragmentTabHost.this.gaU);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaK = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                }
            }
        };
        this.gaL = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.gaG != null) {
                    ScrollFragmentTabHost.this.gaG.btu();
                }
                if (ScrollFragmentTabHost.this.gaE != null) {
                    ScrollFragmentTabHost.this.gaE.notifyDataSetChanged();
                }
            }
        };
        this.gaM = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
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
        this.gaQ = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.gaN == null || ScrollFragmentTabHost.this.gaO == null) {
                    return null;
                }
                if ((ScrollFragmentTabHost.this.gaO.getTaskView() == null || ScrollFragmentTabHost.this.gaO.getTaskView().getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof n.a)) {
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
                    if (ScrollFragmentTabHost.this.gaP != null) {
                        ScrollFragmentTabHost.this.gaP.aZA();
                    }
                    ScrollFragmentTabHost.this.gaP = new d(ScrollFragmentTabHost.this.mPageContext, ScrollFragmentTabHost.this.gaO.getTaskView());
                    ScrollFragmentTabHost.this.gaP.pJ(48);
                    ScrollFragmentTabHost.this.gaP.S(true);
                    ScrollFragmentTabHost.this.gaP.pI(4);
                    ScrollFragmentTabHost.this.gaP.pL(i);
                    ScrollFragmentTabHost.this.gaP.iI(true);
                    ScrollFragmentTabHost.this.gaP.pN(0);
                    ScrollFragmentTabHost.this.gaP.ve(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.gaR = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.gaN == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aHV();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.gaN.btK();
                } else if (!ScrollFragmentTabHost.this.gaN.isSticky()) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.gaN.btK();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.gaS = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.gaP != null) {
                    ScrollFragmentTabHost.this.gaP.aZA();
                    ScrollFragmentTabHost.this.gaP = null;
                }
            }
        };
        this.gaT = new c();
        this.gaU = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void tu(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.gaG.tw(i), false);
                ScrollFragmentTabHost.this.gaG.ty(i);
            }
        };
        this.gaV = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void tt(int i) {
                ScrollFragmentTabHost.this.gaT.a(i, ScrollFragmentTabHost.this.gaU);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.gaN = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.gaO = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.gaD = findViewById(R.id.home_page_statebar_view);
        this.gaE = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.eRW = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.dlX = (NoNetworkView) findViewById(R.id.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(R.id.home_pager_container);
        this.bPz = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.cSZ = findViewById(R.id.divider_line);
        this.dnj = findViewById(R.id.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gaD.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.gaE.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.gaG.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.gaH != null) {
                    ScrollFragmentTabHost.this.gaH.tE(i);
                }
                com.baidu.tbadk.core.bigday.b.abp().dC(ScrollFragmentTabHost.this.gaG.tv(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.tD(i) == 3) {
                    am amVar = new am("c12478");
                    amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(amVar);
                }
                if (ScrollFragmentTabHost.this.tD(i) == 4) {
                    TiebaStatic.log(new am("c13172").P("obj_type", ScrollFragmentTabHost.this.gaJ ? 2 : 1));
                    ScrollFragmentTabHost.this.gaJ = false;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.tD(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.eSU != null && ScrollFragmentTabHost.this.gaG != null) {
                    int tv2 = ScrollFragmentTabHost.this.gaG.tv(ScrollFragmentTabHost.this.bPz.getCurrentItem());
                    if (tv2 == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.eSU) {
                            aVar.btI();
                        }
                    } else if (tv2 == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.eSU) {
                            aVar2.btH();
                        }
                    } else if (tv2 == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.eSU) {
                            aVar3.bsR();
                        }
                    } else if (tv2 == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.aHV();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.btE();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.tD(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean btz = ScrollFragmentTabHost.this.btz();
                    TiebaStatic.log(new am("c12350").P("obj_type", btz ? 1 : 0));
                    if (btz && ScrollFragmentTabHost.this.gaG != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.gaG.btx();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.gaE.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void r(View view, int i) {
                if (ScrollFragmentTabHost.this.bPz.getCurrentItem() != i && ScrollFragmentTabHost.this.tD(i) == 4) {
                    ScrollFragmentTabHost.this.gaJ = true;
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
        this.gaN.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void la(boolean z) {
                if (z && ScrollFragmentTabHost.this.gaP != null) {
                    ScrollFragmentTabHost.this.gaP.aZA();
                }
            }
        });
        this.gaO.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ScrollFragmentTabHost.this.gaP != null) {
                    ScrollFragmentTabHost.this.gaP.aZA();
                    ScrollFragmentTabHost.this.gaP = null;
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.gaR.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.gaR);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterTask(2921405);
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.dlX.a(aVar);
        MessageManager.getInstance().registerListener(this.gaK);
        MessageManager.getInstance().registerListener(this.gaL);
        MessageManager.getInstance().registerListener(this.gaM);
        MessageManager.getInstance().registerListener(this.gaS);
        this.gaQ.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.gaQ);
    }

    public void notifyDataSetChanged() {
        if (this.gaG != null && !HomePageStatic.fWx) {
            this.bPz.setAdapter(this.gaG);
            this.gaE.notifyDataSetChanged();
            this.gaT.a(this.gaU);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gaG != null) {
            this.gaG.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gaG != null) {
            this.gaG.d(dataRes, z);
        }
    }

    public void btw() {
        if (this.gaG != null) {
            this.gaG.btw();
        }
    }

    public void v(String str, int i, int i2) {
        if (this.bPz != null) {
            this.gaG.v(str, i, i2);
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
        this.gaG = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.gaG.setScrollFragmentTabHost(this);
        this.bPz.setOffscreenPageLimit(2);
        this.bPz.setAdapter(this.gaG);
        int btt = this.gaG.btt();
        if (com.baidu.tbadk.core.sharedPref.b.agM().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.agM().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.gaG;
            if (HomePageStatic.fWx) {
                i = 0;
            }
            this.bPz.setCurrentItem(newScrollFragmentAdapter.tw(i));
            this.gaE.setViewPager(this.bPz);
            this.gaE.setConcernTabIndex(this.gaG.tw(0));
            if (this.gaC != null) {
                this.gaG.setRecommendFrsNavigationAnimDispatcher(this.gaC);
            }
            btE();
        }
        i = btt;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.gaG;
        if (HomePageStatic.fWx) {
        }
        this.bPz.setCurrentItem(newScrollFragmentAdapter2.tw(i));
        this.gaE.setViewPager(this.bPz);
        this.gaE.setConcernTabIndex(this.gaG.tw(0));
        if (this.gaC != null) {
        }
        btE();
    }

    public boolean btC() {
        return this.gaG != null && this.gaG.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.gaG.getCount()) {
            this.gaE.setTabItemClicked(z);
            this.gaG.tz(i);
            this.bPz.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.gaG.tw(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gaE.setPageUniqueId(bdUniqueId);
        this.gaK.setTag(bdUniqueId);
        this.gaL.setTag(bdUniqueId);
        this.gaM.setTag(bdUniqueId);
        this.gaS.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.gaG.tv(this.bPz.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.bPz.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.gaG.tv(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int tD(int i) {
        return this.gaG.tv(i);
    }

    public void onChangeSkinType(int i) {
        al.l(this.gaD, R.color.cp_bg_line_d);
        this.gaO.onChangeSkinType();
        this.gaE.onChangeSkinType();
        if (this.mPageContext != null && this.dlX != null) {
            this.dlX.onChangeSkinType(this.mPageContext, i);
        }
        if (this.gaG != null) {
            this.gaG.iW(i);
        }
        if (this.mPageContext != null && this.eRW != null) {
            this.eRW.onChangeSkinType(this.mPageContext, i);
        }
        al.l(this.cSZ, R.color.cp_bg_line_c);
    }

    private boolean aHT() {
        return this.dnj.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.gaF = z;
        if (z) {
            if (this.cSZ != null) {
                this.cSZ.setVisibility(8);
            }
        } else if (this.cSZ != null) {
            this.cSZ.setVisibility(0);
        }
    }

    public void aHU() {
        if (this.gaF && !aHT()) {
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
        if (this.gaF && aHT()) {
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

    public void bty() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.gaG != null) {
            this.gaG.bty();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4 || currentTabType == 5 || currentTabType == 6) && this.gaG != null) {
            this.gaG.bty();
        }
    }

    public void aIG() {
        this.gaG.aIG();
    }

    public String getCurrentPageKey() {
        if (this.gaG != null) {
            return this.gaG.getCurrentPageKey();
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
        if (this.gaG != null) {
            this.gaG.setPrimary(z);
        }
        if (this.dlX != null && z) {
            this.dlX.setVisibility(j.jG() ? 8 : 0);
        }
    }

    public void btD() {
        this.gaG.a(this.gaV);
    }

    public void setOnTabSelectedListener(b bVar) {
        this.gaH = bVar;
    }

    public void onDestroy() {
        if (this.gaC != null) {
            this.gaC.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.gaP != null) {
            this.gaP.aZA();
            this.gaP = null;
        }
        btG();
    }

    public void btE() {
        int i = 1;
        if (this.gaG != null) {
            int tv2 = this.gaG.tv(this.bPz.getCurrentItem());
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
        if (this.gaE != null && this.gaG.btv()) {
            this.gaE.setShowConcernRedTip(z);
        }
    }

    public boolean btz() {
        if (this.gaE == null || !this.gaG.btv()) {
            return false;
        }
        return this.gaE.btz();
    }

    public void setVideoThreadId(String str) {
        if (this.gaG != null) {
            this.gaG.setVideoThreadId(str);
        }
    }

    public void btF() {
        if (com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int tw = this.gaG != null ? this.gaG.tw(0) : 0;
            if (this.gaI == null) {
                this.gaI = new d(this.mPageContext, this.gaE.tA(tw));
                this.gaI.pK(R.drawable.bg_tip_blue_up);
                this.gaI.pJ(32);
                this.gaI.iI(true);
                this.gaI.S(true);
                this.gaI.setYOffset(l.g(this.mContext, R.dimen.ds16));
                this.gaI.pL(UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
            }
            this.gaI.u(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void btG() {
        if (this.gaI != null) {
            this.gaI.aZA();
        }
    }

    public void onResume() {
        if (this.gaE != null) {
            this.gaE.onResume();
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
        public void btH() {
        }

        public void btI() {
        }

        public void bsR() {
        }
    }
}
