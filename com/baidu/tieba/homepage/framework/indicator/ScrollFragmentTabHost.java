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
    private CustomViewPager bQA;
    private View cUw;
    private NoNetworkView dnF;
    private View dpj;
    private AlphaAnimation dpm;
    private AlphaAnimation dpn;
    private PluginErrorTipView eWW;
    private List<a> eXU;
    private x gfG;
    private View gfH;
    private HomeTabBarView gfI;
    private boolean gfJ;
    private NewScrollFragmentAdapter gfK;
    private b gfL;
    private d gfM;
    private boolean gfN;
    public CustomMessageListener gfO;
    public CustomMessageListener gfP;
    CustomMessageListener gfQ;
    private StickyAppBarLayout gfR;
    private NestedScrollHeader gfS;
    private d gfT;
    CustomMessageTask gfU;
    CustomMessageTask gfV;
    CustomMessageListener gfW;
    private c gfX;
    private e gfY;
    private com.baidu.tieba.homepage.framework.d gfZ;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface b {
        void tW(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.gfO = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                }
            }
        };
        this.gfP = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.gfK != null) {
                    ScrollFragmentTabHost.this.gfK.bvy();
                }
                if (ScrollFragmentTabHost.this.gfI != null) {
                    ScrollFragmentTabHost.this.gfI.notifyDataSetChanged();
                }
            }
        };
        this.gfQ = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aJu();
                } else {
                    ScrollFragmentTabHost.this.aJv();
                }
            }
        };
        this.gfU = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.gfR == null || ScrollFragmentTabHost.this.gfS == null) {
                    return null;
                }
                if ((ScrollFragmentTabHost.this.gfS.getTaskView() == null || ScrollFragmentTabHost.this.gfS.getTaskView().getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof n.a)) {
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
                    if (ScrollFragmentTabHost.this.gfT != null) {
                        ScrollFragmentTabHost.this.gfT.bbz();
                    }
                    ScrollFragmentTabHost.this.gfT = new d(ScrollFragmentTabHost.this.mPageContext, ScrollFragmentTabHost.this.gfS.getTaskView());
                    ScrollFragmentTabHost.this.gfT.qa(48);
                    ScrollFragmentTabHost.this.gfT.S(true);
                    ScrollFragmentTabHost.this.gfT.pZ(4);
                    ScrollFragmentTabHost.this.gfT.qc(i);
                    ScrollFragmentTabHost.this.gfT.iR(true);
                    ScrollFragmentTabHost.this.gfT.qe(0);
                    ScrollFragmentTabHost.this.gfT.vI(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.gfV = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.gfR == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aJv();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.gfR.bvO();
                } else if (!ScrollFragmentTabHost.this.gfR.isSticky()) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.gfR.bvO();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.gfW = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.gfT != null) {
                    ScrollFragmentTabHost.this.gfT.bbz();
                    ScrollFragmentTabHost.this.gfT = null;
                }
            }
        };
        this.gfX = new c();
        this.gfY = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void tM(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.gfK.tO(i), false);
                ScrollFragmentTabHost.this.gfK.tQ(i);
            }
        };
        this.gfZ = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void tL(int i) {
                ScrollFragmentTabHost.this.gfX.a(i, ScrollFragmentTabHost.this.gfY);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gfO = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                }
            }
        };
        this.gfP = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.gfK != null) {
                    ScrollFragmentTabHost.this.gfK.bvy();
                }
                if (ScrollFragmentTabHost.this.gfI != null) {
                    ScrollFragmentTabHost.this.gfI.notifyDataSetChanged();
                }
            }
        };
        this.gfQ = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aJu();
                } else {
                    ScrollFragmentTabHost.this.aJv();
                }
            }
        };
        this.gfU = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.gfR == null || ScrollFragmentTabHost.this.gfS == null) {
                    return null;
                }
                if ((ScrollFragmentTabHost.this.gfS.getTaskView() == null || ScrollFragmentTabHost.this.gfS.getTaskView().getVisibility() == 0) && customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof n.a)) {
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
                    if (ScrollFragmentTabHost.this.gfT != null) {
                        ScrollFragmentTabHost.this.gfT.bbz();
                    }
                    ScrollFragmentTabHost.this.gfT = new d(ScrollFragmentTabHost.this.mPageContext, ScrollFragmentTabHost.this.gfS.getTaskView());
                    ScrollFragmentTabHost.this.gfT.qa(48);
                    ScrollFragmentTabHost.this.gfT.S(true);
                    ScrollFragmentTabHost.this.gfT.pZ(4);
                    ScrollFragmentTabHost.this.gfT.qc(i);
                    ScrollFragmentTabHost.this.gfT.iR(true);
                    ScrollFragmentTabHost.this.gfT.qe(0);
                    ScrollFragmentTabHost.this.gfT.vI(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.gfV = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.gfR == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aJv();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.gfR.bvO();
                } else if (!ScrollFragmentTabHost.this.gfR.isSticky()) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.gfR.bvO();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.gfW = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.gfT != null) {
                    ScrollFragmentTabHost.this.gfT.bbz();
                    ScrollFragmentTabHost.this.gfT = null;
                }
            }
        };
        this.gfX = new c();
        this.gfY = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void tM(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.gfK.tO(i), false);
                ScrollFragmentTabHost.this.gfK.tQ(i);
            }
        };
        this.gfZ = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void tL(int i) {
                ScrollFragmentTabHost.this.gfX.a(i, ScrollFragmentTabHost.this.gfY);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.gfR = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.gfS = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.gfH = findViewById(R.id.home_page_statebar_view);
        this.gfI = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.eWW = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.dnF = (NoNetworkView) findViewById(R.id.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(R.id.home_pager_container);
        this.bQA = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.cUw = findViewById(R.id.divider_line);
        this.dpj = findViewById(R.id.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gfH.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.gfI.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.gfK.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.gfL != null) {
                    ScrollFragmentTabHost.this.gfL.tW(i);
                }
                com.baidu.tbadk.core.bigday.b.aco().dG(ScrollFragmentTabHost.this.gfK.tN(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.tV(i) == 3) {
                    an anVar = new an("c12478");
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(anVar);
                }
                if (ScrollFragmentTabHost.this.tV(i) == 4) {
                    TiebaStatic.log(new an("c13172").P("obj_type", ScrollFragmentTabHost.this.gfN ? 2 : 1));
                    ScrollFragmentTabHost.this.gfN = false;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.tV(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.eXU != null && ScrollFragmentTabHost.this.gfK != null) {
                    int tN = ScrollFragmentTabHost.this.gfK.tN(ScrollFragmentTabHost.this.bQA.getCurrentItem());
                    if (tN == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.eXU) {
                            aVar.bvM();
                        }
                    } else if (tN == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.eXU) {
                            aVar2.bvL();
                        }
                    } else if (tN == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.eXU) {
                            aVar3.buU();
                        }
                    } else if (tN == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (tN == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.aJv();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.bvI();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.tV(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean bvD = ScrollFragmentTabHost.this.bvD();
                    TiebaStatic.log(new an("c12350").P("obj_type", bvD ? 1 : 0));
                    if (bvD && ScrollFragmentTabHost.this.gfK != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.gfK.bvB();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.gfI.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void r(View view, int i) {
                if (ScrollFragmentTabHost.this.bQA.getCurrentItem() != i && ScrollFragmentTabHost.this.tV(i) == 4) {
                    ScrollFragmentTabHost.this.gfN = true;
                }
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.bQA.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.tV(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.tV(i) == 7) {
                    TiebaStatic.log(new an("c13483").bT("obj_type", "1"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.tV(i));
            }
        });
        this.gfR.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void ll(boolean z) {
                if (z && ScrollFragmentTabHost.this.gfT != null) {
                    ScrollFragmentTabHost.this.gfT.bbz();
                }
            }
        });
        this.gfS.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void yd(String str) {
                if (ScrollFragmentTabHost.this.gfT != null) {
                    ScrollFragmentTabHost.this.gfT.bbz();
                    ScrollFragmentTabHost.this.gfT = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    bb.ajC().c(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.gfV.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.gfV);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterTask(2921405);
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.dnF.a(aVar);
        MessageManager.getInstance().registerListener(this.gfO);
        MessageManager.getInstance().registerListener(this.gfP);
        MessageManager.getInstance().registerListener(this.gfQ);
        MessageManager.getInstance().registerListener(this.gfW);
        this.gfU.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.gfU);
    }

    public void notifyDataSetChanged() {
        if (this.gfK != null && !HomePageStatic.gbw) {
            this.bQA.setAdapter(this.gfK);
            this.gfI.notifyDataSetChanged();
            this.gfX.a(this.gfY);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gfK != null) {
            this.gfK.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gfK != null) {
            this.gfK.d(dataRes, z);
        }
    }

    public void bvA() {
        if (this.gfK != null) {
            this.gfK.bvA();
        }
    }

    public void v(String str, int i, int i2) {
        if (this.bQA != null) {
            this.gfK.v(str, i, i2);
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
        this.gfK = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.gfK.setScrollFragmentTabHost(this);
        this.bQA.setOffscreenPageLimit(2);
        this.bQA.setAdapter(this.gfK);
        int bvx = this.gfK.bvx();
        if (com.baidu.tbadk.core.sharedPref.b.ahO().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.gfK;
            if (HomePageStatic.gbw) {
                i = 0;
            }
            this.bQA.setCurrentItem(newScrollFragmentAdapter.tO(i));
            this.gfI.setViewPager(this.bQA);
            this.gfI.setConcernTabIndex(this.gfK.tO(0));
            if (this.gfG != null) {
                this.gfK.setRecommendFrsNavigationAnimDispatcher(this.gfG);
            }
            bvI();
        }
        i = bvx;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.gfK;
        if (HomePageStatic.gbw) {
        }
        this.bQA.setCurrentItem(newScrollFragmentAdapter2.tO(i));
        this.gfI.setViewPager(this.bQA);
        this.gfI.setConcernTabIndex(this.gfK.tO(0));
        if (this.gfG != null) {
        }
        bvI();
    }

    public boolean bvG() {
        return this.gfK != null && this.gfK.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.gfK.getCount()) {
            this.gfI.setTabItemClicked(z);
            this.gfK.tR(i);
            this.bQA.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.gfK.tO(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gfI.setPageUniqueId(bdUniqueId);
        this.gfO.setTag(bdUniqueId);
        this.gfP.setTag(bdUniqueId);
        this.gfQ.setTag(bdUniqueId);
        this.gfW.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.gfK.tN(this.bQA.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.bQA.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.gfK.tN(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int tV(int i) {
        return this.gfK.tN(i);
    }

    public void onChangeSkinType(int i) {
        am.l(this.gfH, R.color.cp_bg_line_d);
        this.gfS.onChangeSkinType();
        this.gfI.onChangeSkinType();
        if (this.mPageContext != null && this.dnF != null) {
            this.dnF.onChangeSkinType(this.mPageContext, i);
        }
        if (this.gfK != null) {
            this.gfK.jc(i);
        }
        if (this.mPageContext != null && this.eWW != null) {
            this.eWW.onChangeSkinType(this.mPageContext, i);
        }
        am.l(this.cUw, R.color.cp_bg_line_c);
    }

    private boolean aJt() {
        return this.dpj.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.gfJ = z;
        if (z) {
            if (this.cUw != null) {
                this.cUw.setVisibility(8);
            }
        } else if (this.cUw != null) {
            this.cUw.setVisibility(0);
        }
    }

    public void aJu() {
        if (this.gfJ && !aJt()) {
            this.dpj.setVisibility(0);
            if (this.dpm == null) {
                this.dpm = new AlphaAnimation(0.0f, 1.0f);
                this.dpm.setFillAfter(true);
                this.dpm.setDuration(300L);
            }
            this.dpj.startAnimation(this.dpm);
        }
    }

    public void aJv() {
        if (this.gfJ && aJt()) {
            if (this.dpn == null) {
                this.dpn = new AlphaAnimation(1.0f, 0.0f);
                this.dpn.setFillAfter(true);
                this.dpn.setDuration(300L);
                this.dpn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.dpj.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.dpj.startAnimation(this.dpn);
        }
    }

    public void bvC() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.gfK != null) {
            this.gfK.bvC();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4 || currentTabType == 5 || currentTabType == 6 || currentTabType == 7) && this.gfK != null) {
            this.gfK.bvC();
        }
    }

    public void aKh() {
        this.gfK.aKh();
    }

    public String getCurrentPageKey() {
        if (this.gfK != null) {
            return this.gfK.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.bQA != null) {
            return this.bQA.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.gfK != null) {
            this.gfK.setPrimary(z);
        }
        if (this.dnF != null && z) {
            this.dnF.setVisibility(j.jQ() ? 8 : 0);
        }
    }

    public void bvH() {
        this.gfK.a(this.gfZ);
    }

    public void setOnTabSelectedListener(b bVar) {
        this.gfL = bVar;
    }

    public void onDestroy() {
        if (this.gfG != null) {
            this.gfG.onDestroy();
        }
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.gfT != null) {
            this.gfT.bbz();
            this.gfT = null;
        }
        bvK();
    }

    public void bvI() {
        int i = 1;
        if (this.gfK != null) {
            int tN = this.gfK.tN(this.bQA.getCurrentItem());
            if (tN == 0) {
                i = 0;
            } else if (tN != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.ahO().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.gfI != null && this.gfK.bvz()) {
            this.gfI.setShowConcernRedTip(z);
        }
    }

    public boolean bvD() {
        if (this.gfI == null || !this.gfK.bvz()) {
            return false;
        }
        return this.gfI.bvD();
    }

    public void setVideoThreadId(String str) {
        if (this.gfK != null) {
            this.gfK.setVideoThreadId(str);
        }
    }

    public void bvJ() {
        if (com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int tO = this.gfK != null ? this.gfK.tO(0) : 0;
            if (this.gfM == null) {
                this.gfM = new d(this.mPageContext, this.gfI.tS(tO));
                this.gfM.qb(R.drawable.bg_tip_blue_up);
                this.gfM.qa(32);
                this.gfM.iR(true);
                this.gfM.S(true);
                this.gfM.setYOffset(l.g(this.mContext, R.dimen.ds16));
                this.gfM.qc(UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
            }
            this.gfM.u(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void bvK() {
        if (this.gfM != null) {
            this.gfM.bbz();
        }
    }

    public void onResume() {
        if (this.gfI != null) {
            this.gfI.onResume();
        }
    }

    public void a(a aVar) {
        if (this.eXU == null) {
            this.eXU = new ArrayList();
        }
        this.eXU.add(aVar);
    }

    public void b(a aVar) {
        if (this.eXU != null && this.eXU.size() > 0) {
            this.eXU.remove(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class a {
        public void bvL() {
        }

        public void bvM() {
        }

        public void buU() {
        }
    }
}
