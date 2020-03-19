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
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.d;
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
    private CustomViewPager cYo;
    private View cey;
    private FrameLayout cvq;
    private NoNetworkView elL;
    private View enZ;
    private AlphaAnimation eoc;
    private AlphaAnimation eod;
    private PluginErrorTipView fVN;
    private List<a> fWK;
    private e hbA;
    private d hbB;
    private HomeTabBarView hbn;
    private boolean hbo;
    private NewScrollFragmentAdapter hbp;
    private b hbq;
    private com.baidu.tieba.c.d hbr;
    CustomMessageListener hbs;
    CustomMessageListener hbt;
    CustomMessageTask hbu;
    CustomMessageTask hbv;
    private StickyAppBarLayout hbw;
    private NestedScrollHeader hbx;
    private com.baidu.tieba.c.d hby;
    private com.baidu.tieba.homepage.framework.indicator.b hbz;
    private boolean isPrimary;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes9.dex */
    public interface b {
        void vr(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.hbs = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bcR();
                } else {
                    ScrollFragmentTabHost.this.bcS();
                }
            }
        };
        this.hbt = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.hby != null) {
                    ScrollFragmentTabHost.this.hby.zG();
                    ScrollFragmentTabHost.this.hby = null;
                }
            }
        };
        this.hbu = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.hbw == null || ScrollFragmentTabHost.this.hbx == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.hbn.getTaskView() : ScrollFragmentTabHost.this.hbx.getTaskView();
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
                    if (ScrollFragmentTabHost.this.hby != null) {
                        ScrollFragmentTabHost.this.hby.zG();
                    }
                    ScrollFragmentTabHost.this.hby = new com.baidu.tieba.c.d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.hby.cj(48);
                    ScrollFragmentTabHost.this.hby.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.hby.rz(4);
                    ScrollFragmentTabHost.this.hby.cl(i);
                    ScrollFragmentTabHost.this.hby.kB(true);
                    ScrollFragmentTabHost.this.hby.rB(0);
                    ScrollFragmentTabHost.this.hby.Af(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.hbv = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.hbw == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bcS();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.hbw.bOf();
                } else if (ScrollFragmentTabHost.this.hbw.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.hbw.bOf();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.hbz = new com.baidu.tieba.homepage.framework.indicator.b();
        this.hbA = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void vi(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.hbp.vk(i), false);
                ScrollFragmentTabHost.this.hbp.vm(i);
            }
        };
        this.hbB = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void vh(int i) {
                ScrollFragmentTabHost.this.hbz.a(i, ScrollFragmentTabHost.this.hbA);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hbs = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bcR();
                } else {
                    ScrollFragmentTabHost.this.bcS();
                }
            }
        };
        this.hbt = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.hby != null) {
                    ScrollFragmentTabHost.this.hby.zG();
                    ScrollFragmentTabHost.this.hby = null;
                }
            }
        };
        this.hbu = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.hbw == null || ScrollFragmentTabHost.this.hbx == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.hbn.getTaskView() : ScrollFragmentTabHost.this.hbx.getTaskView();
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
                    if (ScrollFragmentTabHost.this.hby != null) {
                        ScrollFragmentTabHost.this.hby.zG();
                    }
                    ScrollFragmentTabHost.this.hby = new com.baidu.tieba.c.d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.hby.cj(48);
                    ScrollFragmentTabHost.this.hby.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.hby.rz(4);
                    ScrollFragmentTabHost.this.hby.cl(i);
                    ScrollFragmentTabHost.this.hby.kB(true);
                    ScrollFragmentTabHost.this.hby.rB(0);
                    ScrollFragmentTabHost.this.hby.Af(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.hbv = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.hbw == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bcS();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.hbw.bOf();
                } else if (ScrollFragmentTabHost.this.hbw.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.hbw.bOf();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.hbz = new com.baidu.tieba.homepage.framework.indicator.b();
        this.hbA = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void vi(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.hbp.vk(i), false);
                ScrollFragmentTabHost.this.hbp.vm(i);
            }
        };
        this.hbB = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void vh(int i) {
                ScrollFragmentTabHost.this.hbz.a(i, ScrollFragmentTabHost.this.hbA);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.hbw = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.hbx = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.hbn = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.fVN = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.elL = (NoNetworkView) findViewById(R.id.view_no_network);
        this.cvq = (FrameLayout) findViewById(R.id.home_pager_container);
        this.cYo = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.cey = findViewById(R.id.divider_line);
        this.enZ = findViewById(R.id.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hbw.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.cvq.getLayoutParams()).topMargin = 0;
        this.hbn.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.hbp.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.hbq != null) {
                    ScrollFragmentTabHost.this.hbq.vr(i);
                }
                com.baidu.tbadk.core.bigday.b.azZ().fu(ScrollFragmentTabHost.this.hbp.vj(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.vq(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.fWK != null && ScrollFragmentTabHost.this.hbp != null) {
                    int vj = ScrollFragmentTabHost.this.hbp.vj(ScrollFragmentTabHost.this.cYo.getCurrentItem());
                    if (vj == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.fWK) {
                            aVar.bOd();
                        }
                    } else if (vj == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.fWK) {
                            aVar2.bOc();
                        }
                    } else if (vj == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.fWK) {
                            aVar3.bNv();
                        }
                    } else if (vj == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (vj == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (vj == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.bcS();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.bNZ();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.vq(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean bNU = ScrollFragmentTabHost.this.bNU();
                    TiebaStatic.log(new an("c12350").X("obj_type", bNU ? 1 : 0));
                    if (bNU && ScrollFragmentTabHost.this.hbp != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.hbp.bNS();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.hbn.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void k(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.cYo.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.vq(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.vq(i) == 7) {
                    TiebaStatic.log(new an("c13483").cx("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.vq(i) == 8) {
                    TiebaStatic.log(new an("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.vq(i));
            }
        });
        this.hbw.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void mI(boolean z) {
                if (z && ScrollFragmentTabHost.this.hby != null) {
                    ScrollFragmentTabHost.this.hby.zG();
                }
            }
        });
        this.hbx.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void Cg(String str) {
                if (ScrollFragmentTabHost.this.hby != null) {
                    ScrollFragmentTabHost.this.hby.zG();
                    ScrollFragmentTabHost.this.hby = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    ba.aGK().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.hbx.setVisibility(8);
            this.hbn.setMissionEntranceVisibility(true);
            this.hbn.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void Cg(String str) {
                    if (ScrollFragmentTabHost.this.hby != null) {
                        ScrollFragmentTabHost.this.hby.zG();
                        ScrollFragmentTabHost.this.hby = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        ba.aGK().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.hbx.setVisibility(0);
        this.hbn.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.hbv.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hbv);
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
        this.elL.a(aVar);
        MessageManager.getInstance().registerListener(this.hbs);
        MessageManager.getInstance().registerListener(this.hbt);
        this.hbu.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.hbu);
    }

    public void notifyDataSetChanged() {
        if (this.hbp != null && !HomePageStatic.gXD) {
            this.cYo.setAdapter(this.hbp);
            this.hbn.notifyDataSetChanged();
            this.hbz.a(this.hbA);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.hbp != null) {
            this.hbp.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.hbp != null) {
            this.hbp.d(dataRes, z);
        }
    }

    public void bNR() {
        if (this.hbp != null) {
            this.hbp.bNR();
        }
    }

    public void w(String str, int i, int i2) {
        if (this.cYo != null) {
            this.hbp.w(str, i, i2);
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
        this.hbp = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.hbp.setScrollFragmentTabHost(this);
        this.cYo.setOffscreenPageLimit(2);
        this.cYo.setAdapter(this.hbp);
        int bNP = this.hbp.bNP();
        if (com.baidu.tbadk.core.sharedPref.b.aFH().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.aFH().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.hbp;
            if (HomePageStatic.gXD) {
                i = 0;
            }
            this.cYo.setCurrentItem(newScrollFragmentAdapter.vk(i));
            this.hbn.setViewPager(this.cYo);
            this.hbn.setConcernTabIndex(this.hbp.vk(0));
            bNZ();
        }
        i = bNP;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.hbp;
        if (HomePageStatic.gXD) {
        }
        this.cYo.setCurrentItem(newScrollFragmentAdapter2.vk(i));
        this.hbn.setViewPager(this.cYo);
        this.hbn.setConcernTabIndex(this.hbp.vk(0));
        bNZ();
    }

    public boolean bNX() {
        return this.hbp != null && this.hbp.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.hbp.getCount()) {
            this.hbn.setTabItemClicked(z);
            this.hbp.vn(i);
            this.cYo.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.hbp.vk(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hbn.setPageUniqueId(bdUniqueId);
        this.hbs.setTag(bdUniqueId);
        this.hbt.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.cvq;
    }

    public int getCurrentTabType() {
        return this.hbp.vj(this.cYo.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.cYo.getAdapter() != null) {
            int count = this.cYo.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.hbp.vj(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int vq(int i) {
        return this.hbp.vj(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.hbw, R.color.cp_bg_line_h);
        this.hbx.onChangeSkinType();
        this.hbn.onChangeSkinType();
        if (this.mPageContext != null && this.elL != null) {
            this.elL.onChangeSkinType(this.mPageContext, i);
        }
        if (this.hbp != null) {
            this.hbp.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.fVN != null) {
            this.fVN.onChangeSkinType(this.mPageContext, i);
        }
        am.setBackgroundColor(this.cey, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.enZ, R.drawable.personalize_tab_shadow);
    }

    private boolean bcQ() {
        return this.enZ.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.hbo = z;
        if (z) {
            if (this.cey != null) {
                this.cey.setVisibility(8);
            }
        } else if (this.cey != null) {
            this.cey.setVisibility(0);
        }
    }

    public void bcR() {
        if (this.hbo && !bcQ()) {
            this.enZ.setVisibility(0);
            if (this.eoc == null) {
                this.eoc = new AlphaAnimation(0.0f, 1.0f);
                this.eoc.setFillAfter(true);
                this.eoc.setDuration(300L);
            }
            this.enZ.startAnimation(this.eoc);
        }
    }

    public void bcS() {
        if (this.hbo && bcQ()) {
            if (this.eod == null) {
                this.eod = new AlphaAnimation(1.0f, 0.0f);
                this.eod.setFillAfter(true);
                this.eod.setDuration(300L);
                this.eod.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.enZ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.enZ.startAnimation(this.eod);
        }
    }

    public void bNT() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.hbp != null) {
            this.hbp.bNT();
        }
        if ((currentTabType == 1 || currentTabType == 8 || currentTabType == 5 || currentTabType == 6 || currentTabType == 7) && this.hbp != null) {
            this.hbp.bNT();
        }
    }

    public void bdw() {
        this.hbp.bdw();
    }

    public String getCurrentPageKey() {
        if (this.hbp != null) {
            return this.hbp.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.cYo != null) {
            return this.cYo.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.hbp != null) {
            this.hbp.setPrimary(z);
        }
        if (this.elL != null && z) {
            this.elL.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void bNY() {
        this.hbp.a(this.hbB);
    }

    public void lz(boolean z) {
        if (!z && this.hbn != null && this.hbn.getTaskView() != null && this.hbn.getTaskView().getVisibility() != 0) {
            this.hbn.bOh();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.hbq = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.hby != null) {
            this.hby.zG();
            this.hby = null;
        }
        bOb();
    }

    public void bNZ() {
        int i = 1;
        if (this.hbp != null) {
            int vj = this.hbp.vj(this.cYo.getCurrentItem());
            if (vj == 0) {
                i = 0;
            } else if (vj != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.aFH().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.hbn != null && this.hbp.bNQ()) {
            this.hbn.setShowConcernRedTip(z);
        }
    }

    public boolean bNU() {
        if (this.hbn == null || !this.hbp.bNQ()) {
            return false;
        }
        return this.hbn.bNU();
    }

    public void setVideoThreadId(String str) {
        if (this.hbp != null) {
            this.hbp.setVideoThreadId(str);
        }
    }

    public void bOa() {
        if (com.baidu.tbadk.core.sharedPref.b.aFH().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int vk = this.hbp != null ? this.hbp.vk(0) : 0;
            if (this.hbr == null) {
                this.hbr = new com.baidu.tieba.c.d(this.mPageContext, this.hbn.vo(vk));
                this.hbr.ck(R.drawable.bg_tip_blue_up);
                this.hbr.cj(32);
                this.hbr.kB(true);
                this.hbr.setUseDirectOffset(true);
                this.hbr.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.hbr.cl(4000);
            }
            this.hbr.d(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void bOb() {
        if (this.hbr != null) {
            this.hbr.zG();
        }
    }

    public void onResume() {
        if (this.hbn != null) {
            this.hbn.onResume();
        }
    }

    public void a(a aVar) {
        if (this.fWK == null) {
            this.fWK = new ArrayList();
        }
        this.fWK.add(aVar);
    }

    public void b(a aVar) {
        if (this.fWK != null && this.fWK.size() > 0) {
            this.fWK.remove(aVar);
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class a {
        public void bOc() {
        }

        public void bOd() {
        }

        public void bNv() {
        }
    }
}
