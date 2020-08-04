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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BdToken.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.c.e;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes16.dex */
public class ScrollFragmentTabHost extends RelativeLayout {
    private View.OnClickListener awi;
    private CustomViewPager dYQ;
    private FrameLayout dpZ;
    private View fbk;
    private NoNetworkView fsB;
    private View fuQ;
    private AlphaAnimation fuT;
    private AlphaAnimation fuU;
    private PluginErrorTipView hhZ;
    private boolean isPrimary;
    private HomeTabBarView iuY;
    private TBSpecificationBtn iuZ;
    private boolean iva;
    private NewScrollFragmentAdapter ivb;
    private b ivc;
    private e ivd;
    private List<a> ive;
    CustomMessageListener ivf;
    CustomMessageListener ivg;
    CustomMessageTask ivh;
    CustomMessageTask ivi;
    private StickyAppBarLayout ivj;
    private NestedScrollHeader ivk;
    private e ivl;
    private com.baidu.tieba.homepage.framework.indicator.b ivm;
    private com.baidu.tieba.homepage.framework.e ivn;
    private d ivo;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes16.dex */
    public interface b {
        void xv(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.ivf = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bxm();
                } else {
                    ScrollFragmentTabHost.this.bxn();
                }
            }
        };
        this.ivg = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.ivl != null) {
                    ScrollFragmentTabHost.this.ivl.HN();
                    ScrollFragmentTabHost.this.ivl = null;
                }
            }
        };
        this.ivh = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.ivj == null || ScrollFragmentTabHost.this.ivk == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.iuY.getTaskView() : ScrollFragmentTabHost.this.ivk.getTaskView();
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
                    if (ScrollFragmentTabHost.this.ivl != null) {
                        ScrollFragmentTabHost.this.ivl.HN();
                    }
                    ScrollFragmentTabHost.this.ivl = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.ivl.cR(48);
                    ScrollFragmentTabHost.this.ivl.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.ivl.tn(4);
                    ScrollFragmentTabHost.this.ivl.cT(i);
                    ScrollFragmentTabHost.this.ivl.mP(true);
                    ScrollFragmentTabHost.this.ivl.tr(0);
                    ScrollFragmentTabHost.this.ivl.EJ(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.ivi = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.ivj == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bxn();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.ivj.cmh();
                } else if (!com.baidu.tbadk.a.d.aRN() && ScrollFragmentTabHost.this.ivj.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.ivj.cmh();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(ScrollFragmentTabHost.this.mPageContext.getPageActivity(), 9, "27307585", "贴吧众测", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
                writeActivityConfig.setShowHomepageTestBtn(true);
                if (!StringUtils.isNull("")) {
                    writeActivityConfig.setTitle("", true);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        };
        this.ivm = new com.baidu.tieba.homepage.framework.indicator.b();
        this.ivn = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void xm(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.ivb.xo(i), false);
                ScrollFragmentTabHost.this.ivb.xq(i);
            }
        };
        this.ivo = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void xl(int i) {
                ScrollFragmentTabHost.this.ivm.a(i, ScrollFragmentTabHost.this.ivn);
            }
        };
        init();
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ivf = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bxm();
                } else {
                    ScrollFragmentTabHost.this.bxn();
                }
            }
        };
        this.ivg = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.ivl != null) {
                    ScrollFragmentTabHost.this.ivl.HN();
                    ScrollFragmentTabHost.this.ivl = null;
                }
            }
        };
        this.ivh = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.ivj == null || ScrollFragmentTabHost.this.ivk == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.iuY.getTaskView() : ScrollFragmentTabHost.this.ivk.getTaskView();
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
                    if (ScrollFragmentTabHost.this.ivl != null) {
                        ScrollFragmentTabHost.this.ivl.HN();
                    }
                    ScrollFragmentTabHost.this.ivl = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.ivl.cR(48);
                    ScrollFragmentTabHost.this.ivl.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.ivl.tn(4);
                    ScrollFragmentTabHost.this.ivl.cT(i);
                    ScrollFragmentTabHost.this.ivl.mP(true);
                    ScrollFragmentTabHost.this.ivl.tr(0);
                    ScrollFragmentTabHost.this.ivl.EJ(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.ivi = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.ivj == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bxn();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.ivj.cmh();
                } else if (!com.baidu.tbadk.a.d.aRN() && ScrollFragmentTabHost.this.ivj.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.ivj.cmh();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(ScrollFragmentTabHost.this.mPageContext.getPageActivity(), 9, "27307585", "贴吧众测", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
                writeActivityConfig.setShowHomepageTestBtn(true);
                if (!StringUtils.isNull("")) {
                    writeActivityConfig.setTitle("", true);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        };
        this.ivm = new com.baidu.tieba.homepage.framework.indicator.b();
        this.ivn = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void xm(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.ivb.xo(i), false);
                ScrollFragmentTabHost.this.ivb.xq(i);
            }
        };
        this.ivo = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void xl(int i) {
                ScrollFragmentTabHost.this.ivm.a(i, ScrollFragmentTabHost.this.ivn);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.ivj = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.ivk = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.iuY = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.hhZ = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.fsB = (NoNetworkView) findViewById(R.id.view_no_network);
        this.dpZ = (FrameLayout) findViewById(R.id.home_pager_container);
        this.dYQ = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.fbk = findViewById(R.id.divider_line);
        this.fuQ = findViewById(R.id.divider_shadow);
        this.iuZ = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.iuZ.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.ivj.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.dpZ.getLayoutParams()).topMargin = 0;
        this.iuY.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.ivb.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.ivc != null) {
                    ScrollFragmentTabHost.this.ivc.xv(i);
                }
                com.baidu.tbadk.core.bigday.b.aTD().hu(ScrollFragmentTabHost.this.ivb.xn(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.xu(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.ive != null && ScrollFragmentTabHost.this.ivb != null) {
                    int xn = ScrollFragmentTabHost.this.ivb.xn(ScrollFragmentTabHost.this.dYQ.getCurrentItem());
                    if (xn == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.ive) {
                            aVar.cmf();
                        }
                    } else if (xn == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.ive) {
                            aVar2.cme();
                        }
                    } else if (xn == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.ive) {
                            aVar3.cly();
                        }
                    } else if (xn == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (xn == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (xn == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.bxn();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.xu(i));
                if (ScrollFragmentTabHost.this.xu(i) == 5) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (com.baidu.tbadk.getUserInfo.b.bkd() != null && com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null && !StringUtils.isNull(com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId())) {
                            com.baidu.tbadk.core.sharedPref.b.aZP().putLong(com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId(), System.currentTimeMillis());
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.aZP().putLong("unlogin_hot_top_timestamp", System.currentTimeMillis());
                    }
                    if (ScrollFragmentTabHost.this.iuY.clU()) {
                        ScrollFragmentTabHost.this.iuY.setShowHotTopicRedTip(false);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean clT = ScrollFragmentTabHost.this.clT();
                    TiebaStatic.log(new ap("c12350").ah("obj_type", clT ? 1 : 0));
                    if (clT && ScrollFragmentTabHost.this.ivb != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.ivb.clR();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.iuY.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void l(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.dYQ.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.xu(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.xu(i) == 7) {
                    TiebaStatic.log(new ap("c13483").dn("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.xu(i) == 8) {
                    TiebaStatic.log(new ap("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.xu(i));
                if (ScrollFragmentTabHost.this.xu(i) == 5) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (com.baidu.tbadk.getUserInfo.b.bkd() != null && com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null && !StringUtils.isNull(com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId())) {
                            com.baidu.tbadk.core.sharedPref.b.aZP().putLong(com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId(), System.currentTimeMillis());
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.aZP().putLong("unlogin_hot_top_timestamp", System.currentTimeMillis());
                    }
                    if (ScrollFragmentTabHost.this.iuY.clU()) {
                        ScrollFragmentTabHost.this.iuY.setShowHotTopicRedTip(false);
                    }
                }
            }
        });
        this.ivj.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void oY(boolean z) {
                if (z && ScrollFragmentTabHost.this.ivl != null) {
                    ScrollFragmentTabHost.this.ivl.HN();
                }
            }
        });
        this.ivk.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void GM(String str) {
                if (ScrollFragmentTabHost.this.ivl != null) {
                    ScrollFragmentTabHost.this.ivl.HN();
                    ScrollFragmentTabHost.this.ivl = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    bd.baV().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.ivk.setVisibility(8);
            this.iuY.setMissionEntranceVisibility(true);
            this.iuY.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void GM(String str) {
                    if (ScrollFragmentTabHost.this.ivl != null) {
                        ScrollFragmentTabHost.this.ivl.HN();
                        ScrollFragmentTabHost.this.ivl = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        bd.baV().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.ivk.setVisibility(0);
        this.iuY.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.ivi.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.ivi);
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
        this.fsB.a(aVar);
        MessageManager.getInstance().registerListener(this.ivf);
        MessageManager.getInstance().registerListener(this.ivg);
        this.ivh.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.ivh);
    }

    public void notifyDataSetChanged() {
        if (this.ivb != null && !HomePageStatic.irA) {
            this.dYQ.setAdapter(this.ivb);
            this.iuY.notifyDataSetChanged();
            this.ivm.a(this.ivn);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ivb != null) {
            this.ivb.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ivb != null) {
            this.ivb.d(dataRes, z);
        }
    }

    public void clQ() {
        if (this.ivb != null) {
            this.ivb.clQ();
        }
    }

    public void x(String str, int i, int i2) {
        if (this.dYQ != null) {
            this.ivb.x(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.ivb = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.ivb.setScrollFragmentTabHost(this);
        this.dYQ.setOffscreenPageLimit(2);
        this.dYQ.setAdapter(this.ivb);
        int clO = this.ivb.clO();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.ivb;
        if (HomePageStatic.irA) {
            clO = 0;
        }
        this.dYQ.setCurrentItem(newScrollFragmentAdapter.xo(clO));
        this.iuY.setViewPager(this.dYQ);
        this.iuY.setConcernTabIndex(this.ivb.xo(0));
        this.iuY.setHotTopicTabIndex(this.ivb.xo(5));
        this.iuY.setShowHotTopicRedTip(clY());
    }

    private boolean clY() {
        if (TbadkCoreApplication.isLogin()) {
            if (com.baidu.tbadk.getUserInfo.b.bkd() != null && com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null && !StringUtils.isNull(com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId()) && System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aZP().getLong(com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId(), 0L) > 86400000) {
                return true;
            }
        } else if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aZP().getLong("unlogin_hot_top_timestamp", 0L) > 86400000) {
            return true;
        }
        return false;
    }

    public boolean clZ() {
        return this.ivb != null && this.ivb.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.ivb.getCount()) {
            this.iuY.setTabItemClicked(z);
            this.ivb.xr(i);
            this.dYQ.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.ivb.xo(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.ivb.xo(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.ivb.GN(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iuY.setPageUniqueId(bdUniqueId);
        this.ivf.setTag(bdUniqueId);
        this.ivg.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.dpZ;
    }

    public int getCurrentTabType() {
        return this.ivb.xn(this.dYQ.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.dYQ.getAdapter() != null) {
            int count = this.dYQ.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.ivb.xn(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int xu(int i) {
        return this.ivb.xn(i);
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.ivj, R.color.cp_bg_line_h);
        this.ivk.onChangeSkinType();
        this.iuY.onChangeSkinType();
        if (this.mPageContext != null && this.fsB != null) {
            this.fsB.onChangeSkinType(this.mPageContext, i);
        }
        if (this.ivb != null) {
            this.ivb.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.hhZ != null) {
            this.hhZ.onChangeSkinType(this.mPageContext, i);
        }
        ao.setBackgroundColor(this.fbk, R.color.cp_bg_line_c);
        ao.setBackgroundResource(this.fuQ, R.drawable.personalize_tab_shadow);
    }

    private boolean bxl() {
        return this.fuQ.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.iva = z;
        if (z) {
            if (this.fbk != null) {
                this.fbk.setVisibility(8);
            }
        } else if (this.fbk != null) {
            this.fbk.setVisibility(0);
        }
    }

    public void bxm() {
        if (this.iva && !bxl()) {
            this.fuQ.setVisibility(0);
            if (this.fuT == null) {
                this.fuT = new AlphaAnimation(0.0f, 1.0f);
                this.fuT.setFillAfter(true);
                this.fuT.setDuration(300L);
            }
            this.fuQ.startAnimation(this.fuT);
        }
    }

    public void bxn() {
        if (this.iva && bxl()) {
            if (this.fuU == null) {
                this.fuU = new AlphaAnimation(1.0f, 0.0f);
                this.fuU.setFillAfter(true);
                this.fuU.setDuration(300L);
                this.fuU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.fuQ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fuQ.startAnimation(this.fuU);
        }
    }

    public void clS() {
        if (this.ivb != null) {
            this.ivb.clS();
        }
    }

    public void bxR() {
        this.ivb.bxR();
    }

    public String getCurrentPageKey() {
        if (this.ivb != null) {
            return this.ivb.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.dYQ != null) {
            return this.dYQ.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.ivb != null) {
            this.ivb.setPrimary(z);
        }
        if (this.fsB != null && z) {
            this.fsB.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cma() {
        this.ivb.a(this.ivo);
    }

    public void nN(boolean z) {
    }

    public void cmb() {
        if (this.ivj != null && !this.ivj.isSticky() && this.iuY != null && this.iuY.getTaskView() != null && this.iuY.getTaskView().getVisibility() != 0) {
            this.iuY.cmj();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.ivc = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.ivl != null) {
            this.ivl.HN();
            this.ivl = null;
        }
        cmd();
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.iuY != null && this.ivb.clP()) {
            this.iuY.setShowConcernRedTip(z);
        }
    }

    public boolean clT() {
        if (this.iuY == null || !this.ivb.clP()) {
            return false;
        }
        return this.iuY.clT();
    }

    public void setVideoThreadId(String str) {
        if (this.ivb != null) {
            this.ivb.setVideoThreadId(str);
        }
    }

    public void cmc() {
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int xo = this.ivb != null ? this.ivb.xo(0) : 0;
            if (this.ivd == null) {
                this.ivd = new e(this.mPageContext, this.iuY.xs(xo));
                this.ivd.cS(R.drawable.bg_tip_blue_up);
                this.ivd.cR(32);
                this.ivd.mP(true);
                this.ivd.setUseDirectOffset(true);
                this.ivd.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.ivd.cT(4000);
            }
            this.ivd.z(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cmd() {
        if (this.ivd != null) {
            this.ivd.HN();
        }
    }

    public void onResume() {
        if (this.iuY != null) {
            this.iuY.onResume();
        }
    }

    public void a(a aVar) {
        if (this.ive == null) {
            this.ive = new ArrayList();
        }
        this.ive.add(aVar);
    }

    public void b(a aVar) {
        if (this.ive != null && this.ive.size() > 0) {
            this.ive.remove(aVar);
        }
    }

    /* loaded from: classes16.dex */
    public static abstract class a {
        public void cme() {
        }

        public void cmf() {
        }

        public void cly() {
        }
    }
}
