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
    private CustomViewPager cXZ;
    private View cel;
    private FrameLayout cvd;
    private NoNetworkView elh;
    private View ent;
    private AlphaAnimation enx;
    private AlphaAnimation eny;
    private PluginErrorTipView fUP;
    private List<a> fVN;
    private HomeTabBarView gZR;
    private boolean gZS;
    private NewScrollFragmentAdapter gZT;
    private b gZU;
    private d gZV;
    CustomMessageListener gZW;
    CustomMessageListener gZX;
    CustomMessageTask gZY;
    CustomMessageTask gZZ;
    private StickyAppBarLayout haa;
    private NestedScrollHeader hab;
    private d hac;
    private com.baidu.tieba.homepage.framework.indicator.b had;
    private e hae;
    private com.baidu.tieba.homepage.framework.d haf;
    private boolean isPrimary;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes9.dex */
    public interface b {
        void vk(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.gZW = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bcK();
                } else {
                    ScrollFragmentTabHost.this.bcL();
                }
            }
        };
        this.gZX = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.hac != null) {
                    ScrollFragmentTabHost.this.hac.zx();
                    ScrollFragmentTabHost.this.hac = null;
                }
            }
        };
        this.gZY = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.haa == null || ScrollFragmentTabHost.this.hab == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.gZR.getTaskView() : ScrollFragmentTabHost.this.hab.getTaskView();
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
                    if (ScrollFragmentTabHost.this.hac != null) {
                        ScrollFragmentTabHost.this.hac.zx();
                    }
                    ScrollFragmentTabHost.this.hac = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.hac.cj(48);
                    ScrollFragmentTabHost.this.hac.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.hac.rx(4);
                    ScrollFragmentTabHost.this.hac.cl(i);
                    ScrollFragmentTabHost.this.hac.kw(true);
                    ScrollFragmentTabHost.this.hac.rz(0);
                    ScrollFragmentTabHost.this.hac.Ac(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.gZZ = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.haa == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bcL();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.haa.bNO();
                } else if (ScrollFragmentTabHost.this.haa.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.haa.bNO();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.had = new com.baidu.tieba.homepage.framework.indicator.b();
        this.hae = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void vb(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.gZT.vd(i), false);
                ScrollFragmentTabHost.this.gZT.vf(i);
            }
        };
        this.haf = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void va(int i) {
                ScrollFragmentTabHost.this.had.a(i, ScrollFragmentTabHost.this.hae);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gZW = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bcK();
                } else {
                    ScrollFragmentTabHost.this.bcL();
                }
            }
        };
        this.gZX = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.hac != null) {
                    ScrollFragmentTabHost.this.hac.zx();
                    ScrollFragmentTabHost.this.hac = null;
                }
            }
        };
        this.gZY = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.haa == null || ScrollFragmentTabHost.this.hab == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.gZR.getTaskView() : ScrollFragmentTabHost.this.hab.getTaskView();
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
                    if (ScrollFragmentTabHost.this.hac != null) {
                        ScrollFragmentTabHost.this.hac.zx();
                    }
                    ScrollFragmentTabHost.this.hac = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.hac.cj(48);
                    ScrollFragmentTabHost.this.hac.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.hac.rx(4);
                    ScrollFragmentTabHost.this.hac.cl(i);
                    ScrollFragmentTabHost.this.hac.kw(true);
                    ScrollFragmentTabHost.this.hac.rz(0);
                    ScrollFragmentTabHost.this.hac.Ac(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.gZZ = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.haa == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bcL();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.haa.bNO();
                } else if (ScrollFragmentTabHost.this.haa.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.haa.bNO();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.had = new com.baidu.tieba.homepage.framework.indicator.b();
        this.hae = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void vb(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.gZT.vd(i), false);
                ScrollFragmentTabHost.this.gZT.vf(i);
            }
        };
        this.haf = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void va(int i) {
                ScrollFragmentTabHost.this.had.a(i, ScrollFragmentTabHost.this.hae);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.haa = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.hab = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.gZR = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.fUP = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.elh = (NoNetworkView) findViewById(R.id.view_no_network);
        this.cvd = (FrameLayout) findViewById(R.id.home_pager_container);
        this.cXZ = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.cel = findViewById(R.id.divider_line);
        this.ent = findViewById(R.id.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.haa.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.cvd.getLayoutParams()).topMargin = 0;
        this.gZR.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.gZT.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.gZU != null) {
                    ScrollFragmentTabHost.this.gZU.vk(i);
                }
                com.baidu.tbadk.core.bigday.b.azU().ft(ScrollFragmentTabHost.this.gZT.vc(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.vj(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.fVN != null && ScrollFragmentTabHost.this.gZT != null) {
                    int vc = ScrollFragmentTabHost.this.gZT.vc(ScrollFragmentTabHost.this.cXZ.getCurrentItem());
                    if (vc == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.fVN) {
                            aVar.bNM();
                        }
                    } else if (vc == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.fVN) {
                            aVar2.bNL();
                        }
                    } else if (vc == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.fVN) {
                            aVar3.bNe();
                        }
                    } else if (vc == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (vc == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (vc == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.bcL();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.bNI();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.vj(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean bND = ScrollFragmentTabHost.this.bND();
                    TiebaStatic.log(new an("c12350").X("obj_type", bND ? 1 : 0));
                    if (bND && ScrollFragmentTabHost.this.gZT != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.gZT.bNB();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.gZR.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void k(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.cXZ.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.vj(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.vj(i) == 7) {
                    TiebaStatic.log(new an("c13483").cy("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.vj(i) == 8) {
                    TiebaStatic.log(new an("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.vj(i));
            }
        });
        this.haa.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void mC(boolean z) {
                if (z && ScrollFragmentTabHost.this.hac != null) {
                    ScrollFragmentTabHost.this.hac.zx();
                }
            }
        });
        this.hab.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void Cf(String str) {
                if (ScrollFragmentTabHost.this.hac != null) {
                    ScrollFragmentTabHost.this.hac.zx();
                    ScrollFragmentTabHost.this.hac = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    ba.aGE().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.hab.setVisibility(8);
            this.gZR.setMissionEntranceVisibility(true);
            this.gZR.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void Cf(String str) {
                    if (ScrollFragmentTabHost.this.hac != null) {
                        ScrollFragmentTabHost.this.hac.zx();
                        ScrollFragmentTabHost.this.hac = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        ba.aGE().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.hab.setVisibility(0);
        this.gZR.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.gZZ.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.gZZ);
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
        this.elh.a(aVar);
        MessageManager.getInstance().registerListener(this.gZW);
        MessageManager.getInstance().registerListener(this.gZX);
        this.gZY.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.gZY);
    }

    public void notifyDataSetChanged() {
        if (this.gZT != null && !HomePageStatic.gWi) {
            this.cXZ.setAdapter(this.gZT);
            this.gZR.notifyDataSetChanged();
            this.had.a(this.hae);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gZT != null) {
            this.gZT.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gZT != null) {
            this.gZT.d(dataRes, z);
        }
    }

    public void bNA() {
        if (this.gZT != null) {
            this.gZT.bNA();
        }
    }

    public void w(String str, int i, int i2) {
        if (this.cXZ != null) {
            this.gZT.w(str, i, i2);
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
        this.gZT = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.gZT.setScrollFragmentTabHost(this);
        this.cXZ.setOffscreenPageLimit(2);
        this.cXZ.setAdapter(this.gZT);
        int bNy = this.gZT.bNy();
        if (com.baidu.tbadk.core.sharedPref.b.aFB().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.aFB().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.gZT;
            if (HomePageStatic.gWi) {
                i = 0;
            }
            this.cXZ.setCurrentItem(newScrollFragmentAdapter.vd(i));
            this.gZR.setViewPager(this.cXZ);
            this.gZR.setConcernTabIndex(this.gZT.vd(0));
            bNI();
        }
        i = bNy;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.gZT;
        if (HomePageStatic.gWi) {
        }
        this.cXZ.setCurrentItem(newScrollFragmentAdapter2.vd(i));
        this.gZR.setViewPager(this.cXZ);
        this.gZR.setConcernTabIndex(this.gZT.vd(0));
        bNI();
    }

    public boolean bNG() {
        return this.gZT != null && this.gZT.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.gZT.getCount()) {
            this.gZR.setTabItemClicked(z);
            this.gZT.vg(i);
            this.cXZ.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.gZT.vd(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gZR.setPageUniqueId(bdUniqueId);
        this.gZW.setTag(bdUniqueId);
        this.gZX.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.cvd;
    }

    public int getCurrentTabType() {
        return this.gZT.vc(this.cXZ.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.cXZ.getAdapter() != null) {
            int count = this.cXZ.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.gZT.vc(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int vj(int i) {
        return this.gZT.vc(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.haa, R.color.cp_bg_line_h);
        this.hab.onChangeSkinType();
        this.gZR.onChangeSkinType();
        if (this.mPageContext != null && this.elh != null) {
            this.elh.onChangeSkinType(this.mPageContext, i);
        }
        if (this.gZT != null) {
            this.gZT.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.fUP != null) {
            this.fUP.onChangeSkinType(this.mPageContext, i);
        }
        am.setBackgroundColor(this.cel, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.ent, R.drawable.personalize_tab_shadow);
    }

    private boolean bcJ() {
        return this.ent.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.gZS = z;
        if (z) {
            if (this.cel != null) {
                this.cel.setVisibility(8);
            }
        } else if (this.cel != null) {
            this.cel.setVisibility(0);
        }
    }

    public void bcK() {
        if (this.gZS && !bcJ()) {
            this.ent.setVisibility(0);
            if (this.enx == null) {
                this.enx = new AlphaAnimation(0.0f, 1.0f);
                this.enx.setFillAfter(true);
                this.enx.setDuration(300L);
            }
            this.ent.startAnimation(this.enx);
        }
    }

    public void bcL() {
        if (this.gZS && bcJ()) {
            if (this.eny == null) {
                this.eny = new AlphaAnimation(1.0f, 0.0f);
                this.eny.setFillAfter(true);
                this.eny.setDuration(300L);
                this.eny.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.ent.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.ent.startAnimation(this.eny);
        }
    }

    public void bNC() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.gZT != null) {
            this.gZT.bNC();
        }
        if ((currentTabType == 1 || currentTabType == 8 || currentTabType == 5 || currentTabType == 6 || currentTabType == 7) && this.gZT != null) {
            this.gZT.bNC();
        }
    }

    public void bdo() {
        this.gZT.bdo();
    }

    public String getCurrentPageKey() {
        if (this.gZT != null) {
            return this.gZT.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.cXZ != null) {
            return this.cXZ.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.gZT != null) {
            this.gZT.setPrimary(z);
        }
        if (this.elh != null && z) {
            this.elh.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void bNH() {
        this.gZT.a(this.haf);
    }

    public void lt(boolean z) {
        if (!z && this.gZR != null && this.gZR.getTaskView() != null && this.gZR.getTaskView().getVisibility() != 0) {
            this.gZR.bNQ();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.gZU = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.hac != null) {
            this.hac.zx();
            this.hac = null;
        }
        bNK();
    }

    public void bNI() {
        int i = 1;
        if (this.gZT != null) {
            int vc = this.gZT.vc(this.cXZ.getCurrentItem());
            if (vc == 0) {
                i = 0;
            } else if (vc != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.aFB().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.gZR != null && this.gZT.bNz()) {
            this.gZR.setShowConcernRedTip(z);
        }
    }

    public boolean bND() {
        if (this.gZR == null || !this.gZT.bNz()) {
            return false;
        }
        return this.gZR.bND();
    }

    public void setVideoThreadId(String str) {
        if (this.gZT != null) {
            this.gZT.setVideoThreadId(str);
        }
    }

    public void bNJ() {
        if (com.baidu.tbadk.core.sharedPref.b.aFB().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int vd = this.gZT != null ? this.gZT.vd(0) : 0;
            if (this.gZV == null) {
                this.gZV = new d(this.mPageContext, this.gZR.vh(vd));
                this.gZV.ck(R.drawable.bg_tip_blue_up);
                this.gZV.cj(32);
                this.gZV.kw(true);
                this.gZV.setUseDirectOffset(true);
                this.gZV.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.gZV.cl(4000);
            }
            this.gZV.d(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void bNK() {
        if (this.gZV != null) {
            this.gZV.zx();
        }
    }

    public void onResume() {
        if (this.gZR != null) {
            this.gZR.onResume();
        }
    }

    public void a(a aVar) {
        if (this.fVN == null) {
            this.fVN = new ArrayList();
        }
        this.fVN.add(aVar);
    }

    public void b(a aVar) {
        if (this.fVN != null && this.fVN.size() > 0) {
            this.fVN.remove(aVar);
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class a {
        public void bNL() {
        }

        public void bNM() {
        }

        public void bNe() {
        }
    }
}
