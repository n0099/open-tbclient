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
/* loaded from: classes6.dex */
public class ScrollFragmentTabHost extends RelativeLayout {
    private View bZT;
    private CustomViewPager cTN;
    private FrameLayout cqP;
    private NoNetworkView egT;
    private AlphaAnimation eiA;
    private View eiw;
    private AlphaAnimation eiz;
    private PluginErrorTipView fPm;
    private List<a> fQl;
    CustomMessageListener gUA;
    CustomMessageTask gUB;
    CustomMessageTask gUC;
    private StickyAppBarLayout gUD;
    private NestedScrollHeader gUE;
    private d gUF;
    private com.baidu.tieba.homepage.framework.indicator.b gUG;
    private e gUH;
    private com.baidu.tieba.homepage.framework.d gUI;
    private View gUt;
    private HomeTabBarView gUu;
    private boolean gUv;
    private NewScrollFragmentAdapter gUw;
    private b gUx;
    private d gUy;
    CustomMessageListener gUz;
    private boolean isPrimary;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes6.dex */
    public interface b {
        void uZ(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.gUz = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aZW();
                } else {
                    ScrollFragmentTabHost.this.aZX();
                }
            }
        };
        this.gUA = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.gUF != null) {
                    ScrollFragmentTabHost.this.gUF.wP();
                    ScrollFragmentTabHost.this.gUF = null;
                }
            }
        };
        this.gUB = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.gUD == null || ScrollFragmentTabHost.this.gUE == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.gUu.getTaskView() : ScrollFragmentTabHost.this.gUE.getTaskView();
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
                    if (ScrollFragmentTabHost.this.gUF != null) {
                        ScrollFragmentTabHost.this.gUF.wP();
                    }
                    ScrollFragmentTabHost.this.gUF = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.gUF.bS(48);
                    ScrollFragmentTabHost.this.gUF.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.gUF.rl(4);
                    ScrollFragmentTabHost.this.gUF.bU(i);
                    ScrollFragmentTabHost.this.gUF.kj(true);
                    ScrollFragmentTabHost.this.gUF.rn(0);
                    ScrollFragmentTabHost.this.gUF.zC(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.gUC = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.gUD == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aZX();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.gUD.bLg();
                } else if (!ScrollFragmentTabHost.this.gUD.isSticky() || !ScrollFragmentTabHost.this.isPrimary) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.gUD.bLg();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.gUG = new com.baidu.tieba.homepage.framework.indicator.b();
        this.gUH = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void uQ(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.gUw.uS(i), false);
                ScrollFragmentTabHost.this.gUw.uU(i);
            }
        };
        this.gUI = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void uP(int i) {
                ScrollFragmentTabHost.this.gUG.a(i, ScrollFragmentTabHost.this.gUH);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gUz = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.aZW();
                } else {
                    ScrollFragmentTabHost.this.aZX();
                }
            }
        };
        this.gUA = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.gUF != null) {
                    ScrollFragmentTabHost.this.gUF.wP();
                    ScrollFragmentTabHost.this.gUF = null;
                }
            }
        };
        this.gUB = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.gUD == null || ScrollFragmentTabHost.this.gUE == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.gUu.getTaskView() : ScrollFragmentTabHost.this.gUE.getTaskView();
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
                    if (ScrollFragmentTabHost.this.gUF != null) {
                        ScrollFragmentTabHost.this.gUF.wP();
                    }
                    ScrollFragmentTabHost.this.gUF = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.gUF.bS(48);
                    ScrollFragmentTabHost.this.gUF.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.gUF.rl(4);
                    ScrollFragmentTabHost.this.gUF.bU(i);
                    ScrollFragmentTabHost.this.gUF.kj(true);
                    ScrollFragmentTabHost.this.gUF.rn(0);
                    ScrollFragmentTabHost.this.gUF.zC(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.gUC = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.gUD == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.aZX();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.gUD.bLg();
                } else if (!ScrollFragmentTabHost.this.gUD.isSticky() || !ScrollFragmentTabHost.this.isPrimary) {
                    z = false;
                } else {
                    z = true;
                    ScrollFragmentTabHost.this.gUD.bLg();
                }
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.gUG = new com.baidu.tieba.homepage.framework.indicator.b();
        this.gUH = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void uQ(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.gUw.uS(i), false);
                ScrollFragmentTabHost.this.gUw.uU(i);
            }
        };
        this.gUI = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void uP(int i) {
                ScrollFragmentTabHost.this.gUG.a(i, ScrollFragmentTabHost.this.gUH);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.gUD = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.gUE = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.gUt = findViewById(R.id.home_page_statebar_view);
        this.gUu = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.fPm = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.egT = (NoNetworkView) findViewById(R.id.view_no_network);
        this.cqP = (FrameLayout) findViewById(R.id.home_pager_container);
        this.cTN = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.bZT = findViewById(R.id.divider_line);
        this.eiw = findViewById(R.id.divider_shadow);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gUt.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.gUu.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.gUw.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.gUx != null) {
                    ScrollFragmentTabHost.this.gUx.uZ(i);
                }
                com.baidu.tbadk.core.bigday.b.axn().fh(ScrollFragmentTabHost.this.gUw.uR(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.uY(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.fQl != null && ScrollFragmentTabHost.this.gUw != null) {
                    int uR = ScrollFragmentTabHost.this.gUw.uR(ScrollFragmentTabHost.this.cTN.getCurrentItem());
                    if (uR == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.fQl) {
                            aVar.bLe();
                        }
                    } else if (uR == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.fQl) {
                            aVar2.bLd();
                        }
                    } else if (uR == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.fQl) {
                            aVar3.bKw();
                        }
                    } else if (uR == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (uR == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (uR == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.aZX();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.bLa();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.uY(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean bKV = ScrollFragmentTabHost.this.bKV();
                    TiebaStatic.log(new an("c12350").Z("obj_type", bKV ? 1 : 0));
                    if (bKV && ScrollFragmentTabHost.this.gUw != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.gUw.bKT();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.gUu.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void k(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.cTN.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.uY(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.uY(i) == 7) {
                    TiebaStatic.log(new an("c13483").cp("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.uY(i) == 8) {
                    TiebaStatic.log(new an("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.uY(i));
            }
        });
        this.gUD.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void mp(boolean z) {
                if (z && ScrollFragmentTabHost.this.gUF != null) {
                    ScrollFragmentTabHost.this.gUF.wP();
                }
            }
        });
        this.gUE.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void BF(String str) {
                if (ScrollFragmentTabHost.this.gUF != null) {
                    ScrollFragmentTabHost.this.gUF.wP();
                    ScrollFragmentTabHost.this.gUF = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    ba.aEa().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.gUE.setVisibility(8);
            this.gUu.setMissionEntranceVisibility(true);
            this.gUu.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void BF(String str) {
                    if (ScrollFragmentTabHost.this.gUF != null) {
                        ScrollFragmentTabHost.this.gUF.wP();
                        ScrollFragmentTabHost.this.gUF = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        ba.aEa().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.gUE.setVisibility(0);
        this.gUu.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.gUC.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.gUC);
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
        this.egT.a(aVar);
        MessageManager.getInstance().registerListener(this.gUz);
        MessageManager.getInstance().registerListener(this.gUA);
        this.gUB.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.gUB);
    }

    public void notifyDataSetChanged() {
        if (this.gUw != null && !HomePageStatic.gQN) {
            this.cTN.setAdapter(this.gUw);
            this.gUu.notifyDataSetChanged();
            this.gUG.a(this.gUH);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gUw != null) {
            this.gUw.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gUw != null) {
            this.gUw.d(dataRes, z);
        }
    }

    public void bKS() {
        if (this.gUw != null) {
            this.gUw.bKS();
        }
    }

    public void w(String str, int i, int i2) {
        if (this.cTN != null) {
            this.gUw.w(str, i, i2);
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
        this.gUw = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.gUw.setScrollFragmentTabHost(this);
        this.cTN.setOffscreenPageLimit(2);
        this.cTN.setAdapter(this.gUw);
        int bKQ = this.gUw.bKQ();
        if (com.baidu.tbadk.core.sharedPref.b.aCY().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.aCY().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.gUw;
            if (HomePageStatic.gQN) {
                i = 0;
            }
            this.cTN.setCurrentItem(newScrollFragmentAdapter.uS(i));
            this.gUu.setViewPager(this.cTN);
            this.gUu.setConcernTabIndex(this.gUw.uS(0));
            bLa();
        }
        i = bKQ;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.gUw;
        if (HomePageStatic.gQN) {
        }
        this.cTN.setCurrentItem(newScrollFragmentAdapter2.uS(i));
        this.gUu.setViewPager(this.cTN);
        this.gUu.setConcernTabIndex(this.gUw.uS(0));
        bLa();
    }

    public boolean bKY() {
        return this.gUw != null && this.gUw.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.gUw.getCount()) {
            this.gUu.setTabItemClicked(z);
            this.gUw.uV(i);
            this.cTN.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.gUw.uS(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.gUu.setPageUniqueId(bdUniqueId);
        this.gUz.setTag(bdUniqueId);
        this.gUA.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.cqP;
    }

    public int getCurrentTabType() {
        return this.gUw.uR(this.cTN.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.cTN.getAdapter() != null) {
            int count = this.cTN.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.gUw.uR(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int uY(int i) {
        return this.gUw.uR(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.gUt, R.color.cp_bg_line_h);
        this.gUE.onChangeSkinType();
        this.gUu.onChangeSkinType();
        if (this.mPageContext != null && this.egT != null) {
            this.egT.onChangeSkinType(this.mPageContext, i);
        }
        if (this.gUw != null) {
            this.gUw.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.fPm != null) {
            this.fPm.onChangeSkinType(this.mPageContext, i);
        }
        am.setBackgroundColor(this.bZT, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.eiw, R.drawable.personalize_tab_shadow);
    }

    private boolean aZV() {
        return this.eiw.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.gUv = z;
        if (z) {
            if (this.bZT != null) {
                this.bZT.setVisibility(8);
            }
        } else if (this.bZT != null) {
            this.bZT.setVisibility(0);
        }
    }

    public void aZW() {
        if (this.gUv && !aZV()) {
            this.eiw.setVisibility(0);
            if (this.eiz == null) {
                this.eiz = new AlphaAnimation(0.0f, 1.0f);
                this.eiz.setFillAfter(true);
                this.eiz.setDuration(300L);
            }
            this.eiw.startAnimation(this.eiz);
        }
    }

    public void aZX() {
        if (this.gUv && aZV()) {
            if (this.eiA == null) {
                this.eiA = new AlphaAnimation(1.0f, 0.0f);
                this.eiA.setFillAfter(true);
                this.eiA.setDuration(300L);
                this.eiA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.eiw.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.eiw.startAnimation(this.eiA);
        }
    }

    public void bKU() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.gUw != null) {
            this.gUw.bKU();
        }
        if ((currentTabType == 1 || currentTabType == 8 || currentTabType == 5 || currentTabType == 6 || currentTabType == 7) && this.gUw != null) {
            this.gUw.bKU();
        }
    }

    public void baE() {
        this.gUw.baE();
    }

    public String getCurrentPageKey() {
        if (this.gUw != null) {
            return this.gUw.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.cTN != null) {
            return this.cTN.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.gUw != null) {
            this.gUw.setPrimary(z);
        }
        if (this.egT != null && z) {
            this.egT.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void bKZ() {
        this.gUw.a(this.gUI);
    }

    public void lf(boolean z) {
        if (!z && this.gUu != null && this.gUu.getTaskView() != null && this.gUu.getTaskView().getVisibility() != 0) {
            this.gUu.bLh();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.gUx = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.gUF != null) {
            this.gUF.wP();
            this.gUF = null;
        }
        bLc();
    }

    public void bLa() {
        int i = 1;
        if (this.gUw != null) {
            int uR = this.gUw.uR(this.cTN.getCurrentItem());
            if (uR == 0) {
                i = 0;
            } else if (uR != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.aCY().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.gUu != null && this.gUw.bKR()) {
            this.gUu.setShowConcernRedTip(z);
        }
    }

    public boolean bKV() {
        if (this.gUu == null || !this.gUw.bKR()) {
            return false;
        }
        return this.gUu.bKV();
    }

    public void setVideoThreadId(String str) {
        if (this.gUw != null) {
            this.gUw.setVideoThreadId(str);
        }
    }

    public void bLb() {
        if (com.baidu.tbadk.core.sharedPref.b.aCY().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int uS = this.gUw != null ? this.gUw.uS(0) : 0;
            if (this.gUy == null) {
                this.gUy = new d(this.mPageContext, this.gUu.uW(uS));
                this.gUy.bT(R.drawable.bg_tip_blue_up);
                this.gUy.bS(32);
                this.gUy.kj(true);
                this.gUy.setUseDirectOffset(true);
                this.gUy.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.gUy.bU(4000);
            }
            this.gUy.c(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void bLc() {
        if (this.gUy != null) {
            this.gUy.wP();
        }
    }

    public void onResume() {
        if (this.gUu != null) {
            this.gUu.onResume();
        }
    }

    public void a(a aVar) {
        if (this.fQl == null) {
            this.fQl = new ArrayList();
        }
        this.fQl.add(aVar);
    }

    public void b(a aVar) {
        if (this.fQl != null && this.fQl.size() > 0) {
            this.fQl.remove(aVar);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class a {
        public void bLd() {
        }

        public void bLe() {
        }

        public void bKw() {
        }
    }
}
