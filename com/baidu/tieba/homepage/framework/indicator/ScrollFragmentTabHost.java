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
    private HomeTabBarView iuW;
    private TBSpecificationBtn iuX;
    private boolean iuY;
    private NewScrollFragmentAdapter iuZ;
    private b iva;
    private e ivb;
    private List<a> ivc;
    CustomMessageListener ivd;
    CustomMessageListener ive;
    CustomMessageTask ivf;
    CustomMessageTask ivg;
    private StickyAppBarLayout ivh;
    private NestedScrollHeader ivi;
    private e ivj;
    private com.baidu.tieba.homepage.framework.indicator.b ivk;
    private com.baidu.tieba.homepage.framework.e ivl;
    private d ivm;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes16.dex */
    public interface b {
        void xv(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.ivd = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
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
        this.ive = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.ivj != null) {
                    ScrollFragmentTabHost.this.ivj.HN();
                    ScrollFragmentTabHost.this.ivj = null;
                }
            }
        };
        this.ivf = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.ivh == null || ScrollFragmentTabHost.this.ivi == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.iuW.getTaskView() : ScrollFragmentTabHost.this.ivi.getTaskView();
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
                    if (ScrollFragmentTabHost.this.ivj != null) {
                        ScrollFragmentTabHost.this.ivj.HN();
                    }
                    ScrollFragmentTabHost.this.ivj = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.ivj.cR(48);
                    ScrollFragmentTabHost.this.ivj.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.ivj.tn(4);
                    ScrollFragmentTabHost.this.ivj.cT(i);
                    ScrollFragmentTabHost.this.ivj.mP(true);
                    ScrollFragmentTabHost.this.ivj.tr(0);
                    ScrollFragmentTabHost.this.ivj.EJ(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.ivg = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.ivh == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bxn();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.ivh.cmh();
                } else if (!com.baidu.tbadk.a.d.aRN() && ScrollFragmentTabHost.this.ivh.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.ivh.cmh();
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
        this.ivk = new com.baidu.tieba.homepage.framework.indicator.b();
        this.ivl = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void xm(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.iuZ.xo(i), false);
                ScrollFragmentTabHost.this.iuZ.xq(i);
            }
        };
        this.ivm = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void xl(int i) {
                ScrollFragmentTabHost.this.ivk.a(i, ScrollFragmentTabHost.this.ivl);
            }
        };
        init();
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ivd = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
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
        this.ive = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.ivj != null) {
                    ScrollFragmentTabHost.this.ivj.HN();
                    ScrollFragmentTabHost.this.ivj = null;
                }
            }
        };
        this.ivf = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.ivh == null || ScrollFragmentTabHost.this.ivi == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.iuW.getTaskView() : ScrollFragmentTabHost.this.ivi.getTaskView();
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
                    if (ScrollFragmentTabHost.this.ivj != null) {
                        ScrollFragmentTabHost.this.ivj.HN();
                    }
                    ScrollFragmentTabHost.this.ivj = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.ivj.cR(48);
                    ScrollFragmentTabHost.this.ivj.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.ivj.tn(4);
                    ScrollFragmentTabHost.this.ivj.cT(i);
                    ScrollFragmentTabHost.this.ivj.mP(true);
                    ScrollFragmentTabHost.this.ivj.tr(0);
                    ScrollFragmentTabHost.this.ivj.EJ(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.ivg = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.ivh == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bxn();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.ivh.cmh();
                } else if (!com.baidu.tbadk.a.d.aRN() && ScrollFragmentTabHost.this.ivh.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.ivh.cmh();
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
        this.ivk = new com.baidu.tieba.homepage.framework.indicator.b();
        this.ivl = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void xm(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.iuZ.xo(i), false);
                ScrollFragmentTabHost.this.iuZ.xq(i);
            }
        };
        this.ivm = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void xl(int i) {
                ScrollFragmentTabHost.this.ivk.a(i, ScrollFragmentTabHost.this.ivl);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.ivh = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.ivi = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.iuW = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.hhZ = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.fsB = (NoNetworkView) findViewById(R.id.view_no_network);
        this.dpZ = (FrameLayout) findViewById(R.id.home_pager_container);
        this.dYQ = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.fbk = findViewById(R.id.divider_line);
        this.fuQ = findViewById(R.id.divider_shadow);
        this.iuX = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.iuX.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.ivh.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.dpZ.getLayoutParams()).topMargin = 0;
        this.iuW.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.iuZ.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.iva != null) {
                    ScrollFragmentTabHost.this.iva.xv(i);
                }
                com.baidu.tbadk.core.bigday.b.aTD().hu(ScrollFragmentTabHost.this.iuZ.xn(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.xu(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.ivc != null && ScrollFragmentTabHost.this.iuZ != null) {
                    int xn = ScrollFragmentTabHost.this.iuZ.xn(ScrollFragmentTabHost.this.dYQ.getCurrentItem());
                    if (xn == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.ivc) {
                            aVar.cmf();
                        }
                    } else if (xn == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.ivc) {
                            aVar2.cme();
                        }
                    } else if (xn == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.ivc) {
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
                    if (ScrollFragmentTabHost.this.iuW.clU()) {
                        ScrollFragmentTabHost.this.iuW.setShowHotTopicRedTip(false);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean clT = ScrollFragmentTabHost.this.clT();
                    TiebaStatic.log(new ap("c12350").ah("obj_type", clT ? 1 : 0));
                    if (clT && ScrollFragmentTabHost.this.iuZ != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.iuZ.clR();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.iuW.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
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
                    if (ScrollFragmentTabHost.this.iuW.clU()) {
                        ScrollFragmentTabHost.this.iuW.setShowHotTopicRedTip(false);
                    }
                }
            }
        });
        this.ivh.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void oY(boolean z) {
                if (z && ScrollFragmentTabHost.this.ivj != null) {
                    ScrollFragmentTabHost.this.ivj.HN();
                }
            }
        });
        this.ivi.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void GM(String str) {
                if (ScrollFragmentTabHost.this.ivj != null) {
                    ScrollFragmentTabHost.this.ivj.HN();
                    ScrollFragmentTabHost.this.ivj = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    bd.baV().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.ivi.setVisibility(8);
            this.iuW.setMissionEntranceVisibility(true);
            this.iuW.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void GM(String str) {
                    if (ScrollFragmentTabHost.this.ivj != null) {
                        ScrollFragmentTabHost.this.ivj.HN();
                        ScrollFragmentTabHost.this.ivj = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        bd.baV().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.ivi.setVisibility(0);
        this.iuW.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.ivg.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.ivg);
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
        MessageManager.getInstance().registerListener(this.ivd);
        MessageManager.getInstance().registerListener(this.ive);
        this.ivf.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.ivf);
    }

    public void notifyDataSetChanged() {
        if (this.iuZ != null && !HomePageStatic.iry) {
            this.dYQ.setAdapter(this.iuZ);
            this.iuW.notifyDataSetChanged();
            this.ivk.a(this.ivl);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.iuZ != null) {
            this.iuZ.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.iuZ != null) {
            this.iuZ.d(dataRes, z);
        }
    }

    public void clQ() {
        if (this.iuZ != null) {
            this.iuZ.clQ();
        }
    }

    public void x(String str, int i, int i2) {
        if (this.dYQ != null) {
            this.iuZ.x(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.iuZ = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.iuZ.setScrollFragmentTabHost(this);
        this.dYQ.setOffscreenPageLimit(2);
        this.dYQ.setAdapter(this.iuZ);
        int clO = this.iuZ.clO();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.iuZ;
        if (HomePageStatic.iry) {
            clO = 0;
        }
        this.dYQ.setCurrentItem(newScrollFragmentAdapter.xo(clO));
        this.iuW.setViewPager(this.dYQ);
        this.iuW.setConcernTabIndex(this.iuZ.xo(0));
        this.iuW.setHotTopicTabIndex(this.iuZ.xo(5));
        this.iuW.setShowHotTopicRedTip(clY());
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
        return this.iuZ != null && this.iuZ.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.iuZ.getCount()) {
            this.iuW.setTabItemClicked(z);
            this.iuZ.xr(i);
            this.dYQ.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.iuZ.xo(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.iuZ.xo(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.iuZ.GN(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iuW.setPageUniqueId(bdUniqueId);
        this.ivd.setTag(bdUniqueId);
        this.ive.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.dpZ;
    }

    public int getCurrentTabType() {
        return this.iuZ.xn(this.dYQ.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.dYQ.getAdapter() != null) {
            int count = this.dYQ.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.iuZ.xn(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int xu(int i) {
        return this.iuZ.xn(i);
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.ivh, R.color.cp_bg_line_h);
        this.ivi.onChangeSkinType();
        this.iuW.onChangeSkinType();
        if (this.mPageContext != null && this.fsB != null) {
            this.fsB.onChangeSkinType(this.mPageContext, i);
        }
        if (this.iuZ != null) {
            this.iuZ.onChangeSkin(i);
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
        this.iuY = z;
        if (z) {
            if (this.fbk != null) {
                this.fbk.setVisibility(8);
            }
        } else if (this.fbk != null) {
            this.fbk.setVisibility(0);
        }
    }

    public void bxm() {
        if (this.iuY && !bxl()) {
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
        if (this.iuY && bxl()) {
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
        if (this.iuZ != null) {
            this.iuZ.clS();
        }
    }

    public void bxR() {
        this.iuZ.bxR();
    }

    public String getCurrentPageKey() {
        if (this.iuZ != null) {
            return this.iuZ.getCurrentPageKey();
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
        if (this.iuZ != null) {
            this.iuZ.setPrimary(z);
        }
        if (this.fsB != null && z) {
            this.fsB.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cma() {
        this.iuZ.a(this.ivm);
    }

    public void nN(boolean z) {
    }

    public void cmb() {
        if (this.ivh != null && !this.ivh.isSticky() && this.iuW != null && this.iuW.getTaskView() != null && this.iuW.getTaskView().getVisibility() != 0) {
            this.iuW.cmj();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.iva = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.ivj != null) {
            this.ivj.HN();
            this.ivj = null;
        }
        cmd();
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.iuW != null && this.iuZ.clP()) {
            this.iuW.setShowConcernRedTip(z);
        }
    }

    public boolean clT() {
        if (this.iuW == null || !this.iuZ.clP()) {
            return false;
        }
        return this.iuW.clT();
    }

    public void setVideoThreadId(String str) {
        if (this.iuZ != null) {
            this.iuZ.setVideoThreadId(str);
        }
    }

    public void cmc() {
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int xo = this.iuZ != null ? this.iuZ.xo(0) : 0;
            if (this.ivb == null) {
                this.ivb = new e(this.mPageContext, this.iuW.xs(xo));
                this.ivb.cS(R.drawable.bg_tip_blue_up);
                this.ivb.cR(32);
                this.ivb.mP(true);
                this.ivb.setUseDirectOffset(true);
                this.ivb.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.ivb.cT(4000);
            }
            this.ivb.z(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cmd() {
        if (this.ivb != null) {
            this.ivb.HN();
        }
    }

    public void onResume() {
        if (this.iuW != null) {
            this.iuW.onResume();
        }
    }

    public void a(a aVar) {
        if (this.ivc == null) {
            this.ivc = new ArrayList();
        }
        this.ivc.add(aVar);
    }

    public void b(a aVar) {
        if (this.ivc != null && this.ivc.size() > 0) {
            this.ivc.remove(aVar);
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
