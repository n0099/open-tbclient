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
/* loaded from: classes7.dex */
public class ScrollFragmentTabHost extends RelativeLayout {
    private CustomViewPager cTX;
    private View caf;
    private FrameLayout cra;
    private NoNetworkView ehd;
    private View ejk;
    private AlphaAnimation ejn;
    private AlphaAnimation ejo;
    private PluginErrorTipView fSv;
    private List<a> fTu;
    private HomeTabBarView gXQ;
    private boolean gXR;
    private NewScrollFragmentAdapter gXS;
    private b gXT;
    private d gXU;
    CustomMessageListener gXV;
    CustomMessageListener gXW;
    CustomMessageTask gXX;
    CustomMessageTask gXY;
    private StickyAppBarLayout gXZ;
    private NestedScrollHeader gYa;
    private d gYb;
    private com.baidu.tieba.homepage.framework.indicator.b gYc;
    private e gYd;
    private com.baidu.tieba.homepage.framework.d gYe;
    private boolean isPrimary;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes7.dex */
    public interface b {
        void ve(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.gXV = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bav();
                } else {
                    ScrollFragmentTabHost.this.baw();
                }
            }
        };
        this.gXW = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.gYb != null) {
                    ScrollFragmentTabHost.this.gYb.xg();
                    ScrollFragmentTabHost.this.gYb = null;
                }
            }
        };
        this.gXX = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.gXZ == null || ScrollFragmentTabHost.this.gYa == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.gXQ.getTaskView() : ScrollFragmentTabHost.this.gYa.getTaskView();
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
                    if (ScrollFragmentTabHost.this.gYb != null) {
                        ScrollFragmentTabHost.this.gYb.xg();
                    }
                    ScrollFragmentTabHost.this.gYb = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.gYb.bT(48);
                    ScrollFragmentTabHost.this.gYb.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.gYb.rq(4);
                    ScrollFragmentTabHost.this.gYb.bV(i);
                    ScrollFragmentTabHost.this.gYb.ku(true);
                    ScrollFragmentTabHost.this.gYb.rs(0);
                    ScrollFragmentTabHost.this.gYb.zM(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.gXY = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.gXZ == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.baw();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.gXZ.bMm();
                } else if (ScrollFragmentTabHost.this.gXZ.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.gXZ.bMm();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.gYc = new com.baidu.tieba.homepage.framework.indicator.b();
        this.gYd = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void uV(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.gXS.uX(i), false);
                ScrollFragmentTabHost.this.gXS.uZ(i);
            }
        };
        this.gYe = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void uU(int i) {
                ScrollFragmentTabHost.this.gYc.a(i, ScrollFragmentTabHost.this.gYd);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gXV = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bav();
                } else {
                    ScrollFragmentTabHost.this.baw();
                }
            }
        };
        this.gXW = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.gYb != null) {
                    ScrollFragmentTabHost.this.gYb.xg();
                    ScrollFragmentTabHost.this.gYb = null;
                }
            }
        };
        this.gXX = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.gXZ == null || ScrollFragmentTabHost.this.gYa == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.gXQ.getTaskView() : ScrollFragmentTabHost.this.gYa.getTaskView();
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
                    if (ScrollFragmentTabHost.this.gYb != null) {
                        ScrollFragmentTabHost.this.gYb.xg();
                    }
                    ScrollFragmentTabHost.this.gYb = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.gYb.bT(48);
                    ScrollFragmentTabHost.this.gYb.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.gYb.rq(4);
                    ScrollFragmentTabHost.this.gYb.bV(i);
                    ScrollFragmentTabHost.this.gYb.ku(true);
                    ScrollFragmentTabHost.this.gYb.rs(0);
                    ScrollFragmentTabHost.this.gYb.zM(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.gXY = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.gXZ == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.baw();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.gXZ.bMm();
                } else if (ScrollFragmentTabHost.this.gXZ.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.gXZ.bMm();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.gYc = new com.baidu.tieba.homepage.framework.indicator.b();
        this.gYd = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void uV(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.gXS.uX(i), false);
                ScrollFragmentTabHost.this.gXS.uZ(i);
            }
        };
        this.gYe = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void uU(int i) {
                ScrollFragmentTabHost.this.gYc.a(i, ScrollFragmentTabHost.this.gYd);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.gXZ = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.gYa = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.gXQ = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.fSv = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.ehd = (NoNetworkView) findViewById(R.id.view_no_network);
        this.cra = (FrameLayout) findViewById(R.id.home_pager_container);
        this.cTX = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.caf = findViewById(R.id.divider_line);
        this.ejk = findViewById(R.id.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gXZ.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.cra.getLayoutParams();
        if (TbSingleton.getInstance().isShowNewYearSkin()) {
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.tbds_20);
            this.gXQ.bMb();
            this.gXZ.setPadding(0, this.gXZ.getPaddingTop(), 0, l.getDimens(this.mContext, R.dimen.tbds21));
        } else {
            layoutParams.topMargin = 0;
        }
        this.gXQ.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.gXS.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.gXT != null) {
                    ScrollFragmentTabHost.this.gXT.ve(i);
                }
                com.baidu.tbadk.core.bigday.b.axG().fm(ScrollFragmentTabHost.this.gXS.uW(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.vd(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.fTu != null && ScrollFragmentTabHost.this.gXS != null) {
                    int uW = ScrollFragmentTabHost.this.gXS.uW(ScrollFragmentTabHost.this.cTX.getCurrentItem());
                    if (uW == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.fTu) {
                            aVar.bMk();
                        }
                    } else if (uW == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.fTu) {
                            aVar2.bMj();
                        }
                    } else if (uW == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.fTu) {
                            aVar3.bLB();
                        }
                    } else if (uW == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (uW == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (uW == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.baw();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.bMg();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.vd(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean bMa = ScrollFragmentTabHost.this.bMa();
                    TiebaStatic.log(new an("c12350").Z("obj_type", bMa ? 1 : 0));
                    if (bMa && ScrollFragmentTabHost.this.gXS != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.gXS.bLY();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.gXQ.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void k(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.cTX.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.vd(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.vd(i) == 7) {
                    TiebaStatic.log(new an("c13483").cp("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.vd(i) == 8) {
                    TiebaStatic.log(new an("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.vd(i));
            }
        });
        this.gXZ.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void mA(boolean z) {
                if (z && ScrollFragmentTabHost.this.gYb != null) {
                    ScrollFragmentTabHost.this.gYb.xg();
                }
            }
        });
        this.gYa.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void BP(String str) {
                if (ScrollFragmentTabHost.this.gYb != null) {
                    ScrollFragmentTabHost.this.gYb.xg();
                    ScrollFragmentTabHost.this.gYb = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    ba.aEt().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.gYa.setVisibility(8);
            this.gXQ.setMissionEntranceVisibility(true);
            this.gXQ.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void BP(String str) {
                    if (ScrollFragmentTabHost.this.gYb != null) {
                        ScrollFragmentTabHost.this.gYb.xg();
                        ScrollFragmentTabHost.this.gYb = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        ba.aEt().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.gYa.setVisibility(0);
        this.gXQ.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.gXY.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.gXY);
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
        this.ehd.a(aVar);
        MessageManager.getInstance().registerListener(this.gXV);
        MessageManager.getInstance().registerListener(this.gXW);
        this.gXX.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.gXX);
    }

    public void notifyDataSetChanged() {
        if (this.gXS != null && !HomePageStatic.gUh) {
            this.cTX.setAdapter(this.gXS);
            this.gXQ.notifyDataSetChanged();
            this.gYc.a(this.gYd);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gXS != null) {
            this.gXS.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gXS != null) {
            this.gXS.d(dataRes, z);
        }
    }

    public void bLX() {
        if (this.gXS != null) {
            this.gXS.bLX();
        }
    }

    public void w(String str, int i, int i2) {
        if (this.cTX != null) {
            this.gXS.w(str, i, i2);
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
        this.gXS = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.gXS.setScrollFragmentTabHost(this);
        this.cTX.setOffscreenPageLimit(2);
        this.cTX.setAdapter(this.gXS);
        int bLV = this.gXS.bLV();
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.aDr().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.gXS;
            if (HomePageStatic.gUh) {
                i = 0;
            }
            this.cTX.setCurrentItem(newScrollFragmentAdapter.uX(i));
            this.gXQ.setViewPager(this.cTX);
            this.gXQ.setConcernTabIndex(this.gXS.uX(0));
            bMg();
        }
        i = bLV;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.gXS;
        if (HomePageStatic.gUh) {
        }
        this.cTX.setCurrentItem(newScrollFragmentAdapter2.uX(i));
        this.gXQ.setViewPager(this.cTX);
        this.gXQ.setConcernTabIndex(this.gXS.uX(0));
        bMg();
    }

    public boolean bMe() {
        return this.gXS != null && this.gXS.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.gXS.getCount()) {
            this.gXQ.setTabItemClicked(z);
            this.gXS.va(i);
            this.cTX.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.gXS.uX(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gXQ.setPageUniqueId(bdUniqueId);
        this.gXV.setTag(bdUniqueId);
        this.gXW.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.cra;
    }

    public int getCurrentTabType() {
        return this.gXS.uW(this.cTX.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.cTX.getAdapter() != null) {
            int count = this.cTX.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.gXS.uW(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int vd(int i) {
        return this.gXS.uW(i);
    }

    public void onChangeSkinType(int i) {
        if (TbSingleton.getInstance().isShowNewYearSkin()) {
            this.gXZ.setBackgroundColor(getResources().getColor(R.color.transparent));
        } else {
            am.setBackgroundColor(this.gXZ, R.color.cp_bg_line_h);
        }
        this.gXZ.onChangeSkinType();
        this.gYa.onChangeSkinType();
        this.gXQ.onChangeSkinType();
        if (this.mPageContext != null && this.ehd != null) {
            this.ehd.onChangeSkinType(this.mPageContext, i);
        }
        if (this.gXS != null) {
            this.gXS.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.fSv != null) {
            this.fSv.onChangeSkinType(this.mPageContext, i);
        }
        am.setBackgroundColor(this.caf, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.ejk, R.drawable.personalize_tab_shadow);
    }

    private boolean bau() {
        return this.ejk.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.gXR = z;
        if (z) {
            if (this.caf != null) {
                this.caf.setVisibility(8);
            }
        } else if (this.caf != null) {
            this.caf.setVisibility(0);
        }
    }

    public void bav() {
        if (this.gXR && !bau()) {
            this.ejk.setVisibility(0);
            if (this.ejn == null) {
                this.ejn = new AlphaAnimation(0.0f, 1.0f);
                this.ejn.setFillAfter(true);
                this.ejn.setDuration(300L);
            }
            this.ejk.startAnimation(this.ejn);
        }
    }

    public void baw() {
        if (this.gXR && bau()) {
            if (this.ejo == null) {
                this.ejo = new AlphaAnimation(1.0f, 0.0f);
                this.ejo.setFillAfter(true);
                this.ejo.setDuration(300L);
                this.ejo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.ejk.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.ejk.startAnimation(this.ejo);
        }
    }

    public void bLZ() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.gXS != null) {
            this.gXS.bLZ();
        }
        if ((currentTabType == 1 || currentTabType == 8 || currentTabType == 5 || currentTabType == 6 || currentTabType == 7) && this.gXS != null) {
            this.gXS.bLZ();
        }
    }

    public void baZ() {
        this.gXS.baZ();
    }

    public String getCurrentPageKey() {
        if (this.gXS != null) {
            return this.gXS.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.cTX != null) {
            return this.cTX.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.gXS != null) {
            this.gXS.setPrimary(z);
        }
        if (this.ehd != null && z) {
            this.ehd.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void bMf() {
        this.gXS.a(this.gYe);
    }

    public void lq(boolean z) {
        if (!z && this.gXQ != null && this.gXQ.getTaskView() != null && this.gXQ.getTaskView().getVisibility() != 0) {
            this.gXQ.bMo();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.gXT = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.gYb != null) {
            this.gYb.xg();
            this.gYb = null;
        }
        bMi();
    }

    public void bMg() {
        int i = 1;
        if (this.gXS != null) {
            int uW = this.gXS.uW(this.cTX.getCurrentItem());
            if (uW == 0) {
                i = 0;
            } else if (uW != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.aDr().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.gXQ != null && this.gXS.bLW()) {
            this.gXQ.setShowConcernRedTip(z);
        }
    }

    public boolean bMa() {
        if (this.gXQ == null || !this.gXS.bLW()) {
            return false;
        }
        return this.gXQ.bMa();
    }

    public void setVideoThreadId(String str) {
        if (this.gXS != null) {
            this.gXS.setVideoThreadId(str);
        }
    }

    public void bMh() {
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int uX = this.gXS != null ? this.gXS.uX(0) : 0;
            if (this.gXU == null) {
                this.gXU = new d(this.mPageContext, this.gXQ.vb(uX));
                this.gXU.bU(R.drawable.bg_tip_blue_up);
                this.gXU.bT(32);
                this.gXU.ku(true);
                this.gXU.setUseDirectOffset(true);
                this.gXU.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.gXU.bV(4000);
            }
            this.gXU.c(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void bMi() {
        if (this.gXU != null) {
            this.gXU.xg();
        }
    }

    public void onResume() {
        if (this.gXQ != null) {
            this.gXQ.onResume();
        }
    }

    public void a(a aVar) {
        if (this.fTu == null) {
            this.fTu = new ArrayList();
        }
        this.fTu.add(aVar);
    }

    public void b(a aVar) {
        if (this.fTu != null && this.fTu.size() > 0) {
            this.fTu.remove(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class a {
        public void bMj() {
        }

        public void bMk() {
        }

        public void bLB() {
        }
    }
}
