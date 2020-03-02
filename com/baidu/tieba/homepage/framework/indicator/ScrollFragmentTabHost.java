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
    private CustomViewPager cYa;
    private View cem;
    private FrameLayout cve;
    private NoNetworkView eli;
    private View enu;
    private AlphaAnimation eny;
    private AlphaAnimation enz;
    private PluginErrorTipView fUR;
    private List<a> fVP;
    private HomeTabBarView gZT;
    private boolean gZU;
    private NewScrollFragmentAdapter gZV;
    private b gZW;
    private d gZX;
    CustomMessageListener gZY;
    CustomMessageListener gZZ;
    CustomMessageTask haa;
    CustomMessageTask hab;
    private StickyAppBarLayout hac;
    private NestedScrollHeader had;
    private d hae;
    private com.baidu.tieba.homepage.framework.indicator.b haf;
    private e hag;
    private com.baidu.tieba.homepage.framework.d hah;
    private boolean isPrimary;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes9.dex */
    public interface b {
        void vk(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.gZY = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bcM();
                } else {
                    ScrollFragmentTabHost.this.bcN();
                }
            }
        };
        this.gZZ = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.hae != null) {
                    ScrollFragmentTabHost.this.hae.zz();
                    ScrollFragmentTabHost.this.hae = null;
                }
            }
        };
        this.haa = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.hac == null || ScrollFragmentTabHost.this.had == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.gZT.getTaskView() : ScrollFragmentTabHost.this.had.getTaskView();
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
                    if (ScrollFragmentTabHost.this.hae != null) {
                        ScrollFragmentTabHost.this.hae.zz();
                    }
                    ScrollFragmentTabHost.this.hae = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.hae.cj(48);
                    ScrollFragmentTabHost.this.hae.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.hae.rx(4);
                    ScrollFragmentTabHost.this.hae.cl(i);
                    ScrollFragmentTabHost.this.hae.kw(true);
                    ScrollFragmentTabHost.this.hae.rz(0);
                    ScrollFragmentTabHost.this.hae.Ac(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.hab = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.hac == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bcN();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.hac.bNQ();
                } else if (ScrollFragmentTabHost.this.hac.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.hac.bNQ();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.haf = new com.baidu.tieba.homepage.framework.indicator.b();
        this.hag = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void vb(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.gZV.vd(i), false);
                ScrollFragmentTabHost.this.gZV.vf(i);
            }
        };
        this.hah = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void va(int i) {
                ScrollFragmentTabHost.this.haf.a(i, ScrollFragmentTabHost.this.hag);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gZY = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bcM();
                } else {
                    ScrollFragmentTabHost.this.bcN();
                }
            }
        };
        this.gZZ = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.hae != null) {
                    ScrollFragmentTabHost.this.hae.zz();
                    ScrollFragmentTabHost.this.hae = null;
                }
            }
        };
        this.haa = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.hac == null || ScrollFragmentTabHost.this.had == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.gZT.getTaskView() : ScrollFragmentTabHost.this.had.getTaskView();
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
                    if (ScrollFragmentTabHost.this.hae != null) {
                        ScrollFragmentTabHost.this.hae.zz();
                    }
                    ScrollFragmentTabHost.this.hae = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.hae.cj(48);
                    ScrollFragmentTabHost.this.hae.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.hae.rx(4);
                    ScrollFragmentTabHost.this.hae.cl(i);
                    ScrollFragmentTabHost.this.hae.kw(true);
                    ScrollFragmentTabHost.this.hae.rz(0);
                    ScrollFragmentTabHost.this.hae.Ac(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.hab = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.hac == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bcN();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.hac.bNQ();
                } else if (ScrollFragmentTabHost.this.hac.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.hac.bNQ();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.haf = new com.baidu.tieba.homepage.framework.indicator.b();
        this.hag = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void vb(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.gZV.vd(i), false);
                ScrollFragmentTabHost.this.gZV.vf(i);
            }
        };
        this.hah = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void va(int i) {
                ScrollFragmentTabHost.this.haf.a(i, ScrollFragmentTabHost.this.hag);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.hac = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.had = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.gZT = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.fUR = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.eli = (NoNetworkView) findViewById(R.id.view_no_network);
        this.cve = (FrameLayout) findViewById(R.id.home_pager_container);
        this.cYa = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.cem = findViewById(R.id.divider_line);
        this.enu = findViewById(R.id.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hac.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.cve.getLayoutParams()).topMargin = 0;
        this.gZT.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.gZV.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.gZW != null) {
                    ScrollFragmentTabHost.this.gZW.vk(i);
                }
                com.baidu.tbadk.core.bigday.b.azW().ft(ScrollFragmentTabHost.this.gZV.vc(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.vj(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.fVP != null && ScrollFragmentTabHost.this.gZV != null) {
                    int vc = ScrollFragmentTabHost.this.gZV.vc(ScrollFragmentTabHost.this.cYa.getCurrentItem());
                    if (vc == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.fVP) {
                            aVar.bNO();
                        }
                    } else if (vc == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.fVP) {
                            aVar2.bNN();
                        }
                    } else if (vc == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.fVP) {
                            aVar3.bNg();
                        }
                    } else if (vc == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (vc == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (vc == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.bcN();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.bNK();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.vj(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean bNF = ScrollFragmentTabHost.this.bNF();
                    TiebaStatic.log(new an("c12350").X("obj_type", bNF ? 1 : 0));
                    if (bNF && ScrollFragmentTabHost.this.gZV != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.gZV.bND();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.gZT.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void k(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.cYa.getCurrentItem() != i) {
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
        this.hac.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void mC(boolean z) {
                if (z && ScrollFragmentTabHost.this.hae != null) {
                    ScrollFragmentTabHost.this.hae.zz();
                }
            }
        });
        this.had.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void Cf(String str) {
                if (ScrollFragmentTabHost.this.hae != null) {
                    ScrollFragmentTabHost.this.hae.zz();
                    ScrollFragmentTabHost.this.hae = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    ba.aGG().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.had.setVisibility(8);
            this.gZT.setMissionEntranceVisibility(true);
            this.gZT.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void Cf(String str) {
                    if (ScrollFragmentTabHost.this.hae != null) {
                        ScrollFragmentTabHost.this.hae.zz();
                        ScrollFragmentTabHost.this.hae = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        ba.aGG().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.had.setVisibility(0);
        this.gZT.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.hab.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hab);
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
        this.eli.a(aVar);
        MessageManager.getInstance().registerListener(this.gZY);
        MessageManager.getInstance().registerListener(this.gZZ);
        this.haa.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.haa);
    }

    public void notifyDataSetChanged() {
        if (this.gZV != null && !HomePageStatic.gWk) {
            this.cYa.setAdapter(this.gZV);
            this.gZT.notifyDataSetChanged();
            this.haf.a(this.hag);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gZV != null) {
            this.gZV.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gZV != null) {
            this.gZV.d(dataRes, z);
        }
    }

    public void bNC() {
        if (this.gZV != null) {
            this.gZV.bNC();
        }
    }

    public void w(String str, int i, int i2) {
        if (this.cYa != null) {
            this.gZV.w(str, i, i2);
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
        this.gZV = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.gZV.setScrollFragmentTabHost(this);
        this.cYa.setOffscreenPageLimit(2);
        this.cYa.setAdapter(this.gZV);
        int bNA = this.gZV.bNA();
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.aFD().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.gZV;
            if (HomePageStatic.gWk) {
                i = 0;
            }
            this.cYa.setCurrentItem(newScrollFragmentAdapter.vd(i));
            this.gZT.setViewPager(this.cYa);
            this.gZT.setConcernTabIndex(this.gZV.vd(0));
            bNK();
        }
        i = bNA;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.gZV;
        if (HomePageStatic.gWk) {
        }
        this.cYa.setCurrentItem(newScrollFragmentAdapter2.vd(i));
        this.gZT.setViewPager(this.cYa);
        this.gZT.setConcernTabIndex(this.gZV.vd(0));
        bNK();
    }

    public boolean bNI() {
        return this.gZV != null && this.gZV.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.gZV.getCount()) {
            this.gZT.setTabItemClicked(z);
            this.gZV.vg(i);
            this.cYa.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.gZV.vd(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gZT.setPageUniqueId(bdUniqueId);
        this.gZY.setTag(bdUniqueId);
        this.gZZ.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.cve;
    }

    public int getCurrentTabType() {
        return this.gZV.vc(this.cYa.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.cYa.getAdapter() != null) {
            int count = this.cYa.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.gZV.vc(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int vj(int i) {
        return this.gZV.vc(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.hac, R.color.cp_bg_line_h);
        this.had.onChangeSkinType();
        this.gZT.onChangeSkinType();
        if (this.mPageContext != null && this.eli != null) {
            this.eli.onChangeSkinType(this.mPageContext, i);
        }
        if (this.gZV != null) {
            this.gZV.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.fUR != null) {
            this.fUR.onChangeSkinType(this.mPageContext, i);
        }
        am.setBackgroundColor(this.cem, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.enu, R.drawable.personalize_tab_shadow);
    }

    private boolean bcL() {
        return this.enu.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.gZU = z;
        if (z) {
            if (this.cem != null) {
                this.cem.setVisibility(8);
            }
        } else if (this.cem != null) {
            this.cem.setVisibility(0);
        }
    }

    public void bcM() {
        if (this.gZU && !bcL()) {
            this.enu.setVisibility(0);
            if (this.eny == null) {
                this.eny = new AlphaAnimation(0.0f, 1.0f);
                this.eny.setFillAfter(true);
                this.eny.setDuration(300L);
            }
            this.enu.startAnimation(this.eny);
        }
    }

    public void bcN() {
        if (this.gZU && bcL()) {
            if (this.enz == null) {
                this.enz = new AlphaAnimation(1.0f, 0.0f);
                this.enz.setFillAfter(true);
                this.enz.setDuration(300L);
                this.enz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.enu.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.enu.startAnimation(this.enz);
        }
    }

    public void bNE() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.gZV != null) {
            this.gZV.bNE();
        }
        if ((currentTabType == 1 || currentTabType == 8 || currentTabType == 5 || currentTabType == 6 || currentTabType == 7) && this.gZV != null) {
            this.gZV.bNE();
        }
    }

    public void bdq() {
        this.gZV.bdq();
    }

    public String getCurrentPageKey() {
        if (this.gZV != null) {
            return this.gZV.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.cYa != null) {
            return this.cYa.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.gZV != null) {
            this.gZV.setPrimary(z);
        }
        if (this.eli != null && z) {
            this.eli.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void bNJ() {
        this.gZV.a(this.hah);
    }

    public void lt(boolean z) {
        if (!z && this.gZT != null && this.gZT.getTaskView() != null && this.gZT.getTaskView().getVisibility() != 0) {
            this.gZT.bNS();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.gZW = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.hae != null) {
            this.hae.zz();
            this.hae = null;
        }
        bNM();
    }

    public void bNK() {
        int i = 1;
        if (this.gZV != null) {
            int vc = this.gZV.vc(this.cYa.getCurrentItem());
            if (vc == 0) {
                i = 0;
            } else if (vc != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.gZT != null && this.gZV.bNB()) {
            this.gZT.setShowConcernRedTip(z);
        }
    }

    public boolean bNF() {
        if (this.gZT == null || !this.gZV.bNB()) {
            return false;
        }
        return this.gZT.bNF();
    }

    public void setVideoThreadId(String str) {
        if (this.gZV != null) {
            this.gZV.setVideoThreadId(str);
        }
    }

    public void bNL() {
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int vd = this.gZV != null ? this.gZV.vd(0) : 0;
            if (this.gZX == null) {
                this.gZX = new d(this.mPageContext, this.gZT.vh(vd));
                this.gZX.ck(R.drawable.bg_tip_blue_up);
                this.gZX.cj(32);
                this.gZX.kw(true);
                this.gZX.setUseDirectOffset(true);
                this.gZX.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.gZX.cl(4000);
            }
            this.gZX.d(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void bNM() {
        if (this.gZX != null) {
            this.gZX.zz();
        }
    }

    public void onResume() {
        if (this.gZT != null) {
            this.gZT.onResume();
        }
    }

    public void a(a aVar) {
        if (this.fVP == null) {
            this.fVP = new ArrayList();
        }
        this.fVP.add(aVar);
    }

    public void b(a aVar) {
        if (this.fVP != null && this.fVP.size() > 0) {
            this.fVP.remove(aVar);
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class a {
        public void bNN() {
        }

        public void bNO() {
        }

        public void bNg() {
        }
    }
}
