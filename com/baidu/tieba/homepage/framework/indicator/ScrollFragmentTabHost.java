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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
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
    private View.OnClickListener aBm;
    private FrameLayout dAf;
    private CustomViewPager eiA;
    private NoNetworkView fDZ;
    private View fGn;
    private AlphaAnimation fGq;
    private AlphaAnimation fGr;
    private View fmI;
    private PluginErrorTipView hvf;
    CustomMessageListener iJA;
    CustomMessageListener iJB;
    CustomMessageTask iJC;
    CustomMessageTask iJD;
    private StickyAppBarLayout iJE;
    private NestedScrollHeader iJF;
    private e iJG;
    private com.baidu.tieba.homepage.framework.indicator.b iJH;
    private com.baidu.tieba.homepage.framework.e iJI;
    private d iJJ;
    private HomeTabBarView iJt;
    private TBSpecificationBtn iJu;
    private boolean iJv;
    private NewScrollFragmentAdapter iJw;
    private b iJx;
    private e iJy;
    private List<a> iJz;
    private boolean isPrimary;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes16.dex */
    public interface b {
        void zP(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.iJA = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bGm();
                } else {
                    ScrollFragmentTabHost.this.bGn();
                }
            }
        };
        this.iJB = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.iJG != null) {
                    ScrollFragmentTabHost.this.iJG.NG();
                    ScrollFragmentTabHost.this.iJG = null;
                }
            }
        };
        this.iJC = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.iJE == null || ScrollFragmentTabHost.this.iJF == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.iJt.getTaskView() : ScrollFragmentTabHost.this.iJF.getTaskView();
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
                    if (ScrollFragmentTabHost.this.iJG != null) {
                        ScrollFragmentTabHost.this.iJG.NG();
                    }
                    ScrollFragmentTabHost.this.iJG = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.iJG.eK(48);
                    ScrollFragmentTabHost.this.iJG.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.iJG.setAnchor(4);
                    ScrollFragmentTabHost.this.iJG.eM(i);
                    ScrollFragmentTabHost.this.iJG.nu(true);
                    ScrollFragmentTabHost.this.iJG.vF(0);
                    ScrollFragmentTabHost.this.iJG.Hj(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.iJD = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.iJE == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bGn();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.iJE.cwR();
                } else if (ScrollFragmentTabHost.this.iJE.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.iJE.cwR();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aBm = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
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
        this.iJH = new com.baidu.tieba.homepage.framework.indicator.b();
        this.iJI = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void zG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.iJw.zI(i), false);
                ScrollFragmentTabHost.this.iJw.zK(i);
            }
        };
        this.iJJ = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void zF(int i) {
                ScrollFragmentTabHost.this.iJH.a(i, ScrollFragmentTabHost.this.iJI);
            }
        };
        init();
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iJA = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bGm();
                } else {
                    ScrollFragmentTabHost.this.bGn();
                }
            }
        };
        this.iJB = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.iJG != null) {
                    ScrollFragmentTabHost.this.iJG.NG();
                    ScrollFragmentTabHost.this.iJG = null;
                }
            }
        };
        this.iJC = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.iJE == null || ScrollFragmentTabHost.this.iJF == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.iJt.getTaskView() : ScrollFragmentTabHost.this.iJF.getTaskView();
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
                    if (ScrollFragmentTabHost.this.iJG != null) {
                        ScrollFragmentTabHost.this.iJG.NG();
                    }
                    ScrollFragmentTabHost.this.iJG = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.iJG.eK(48);
                    ScrollFragmentTabHost.this.iJG.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.iJG.setAnchor(4);
                    ScrollFragmentTabHost.this.iJG.eM(i);
                    ScrollFragmentTabHost.this.iJG.nu(true);
                    ScrollFragmentTabHost.this.iJG.vF(0);
                    ScrollFragmentTabHost.this.iJG.Hj(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.iJD = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.iJE == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bGn();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.iJE.cwR();
                } else if (ScrollFragmentTabHost.this.iJE.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.iJE.cwR();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aBm = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
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
        this.iJH = new com.baidu.tieba.homepage.framework.indicator.b();
        this.iJI = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void zG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.iJw.zI(i), false);
                ScrollFragmentTabHost.this.iJw.zK(i);
            }
        };
        this.iJJ = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void zF(int i) {
                ScrollFragmentTabHost.this.iJH.a(i, ScrollFragmentTabHost.this.iJI);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.iJE = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.iJF = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.iJt = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.hvf = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.fDZ = (NoNetworkView) findViewById(R.id.view_no_network);
        this.dAf = (FrameLayout) findViewById(R.id.home_pager_container);
        this.eiA = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.fmI = findViewById(R.id.divider_line);
        this.fGn = findViewById(R.id.divider_shadow);
        this.iJu = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.iJu.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.iJE.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.dAf.getLayoutParams()).topMargin = 0;
        this.iJt.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.iJw.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.iJx != null) {
                    ScrollFragmentTabHost.this.iJx.zP(i);
                }
                com.baidu.tbadk.core.bigday.b.bbU().hR(ScrollFragmentTabHost.this.iJw.zH(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.zO(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.iJz != null && ScrollFragmentTabHost.this.iJw != null) {
                    int zH = ScrollFragmentTabHost.this.iJw.zH(ScrollFragmentTabHost.this.eiA.getCurrentItem());
                    if (zH == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.iJz) {
                            aVar.cwP();
                        }
                    } else if (zH == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.iJz) {
                            aVar2.cwO();
                        }
                    } else if (zH == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.iJz) {
                            aVar3.cwi();
                        }
                    } else if (zH == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (zH == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (zH == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.bGn();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.zO(i));
                if (ScrollFragmentTabHost.this.zO(i) == 5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.bik().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.bik().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.iJt.cwE()) {
                        ScrollFragmentTabHost.this.iJt.setShowHotTopicRedTip(false);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean cwD = ScrollFragmentTabHost.this.cwD();
                    TiebaStatic.log(new aq("c12350").ai("obj_type", cwD ? 1 : 0));
                    if (cwD && ScrollFragmentTabHost.this.iJw != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.iJw.cwB();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.iJt.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void l(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.eiA.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.zO(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.zO(i) == 7) {
                    TiebaStatic.log(new aq("c13483").dD("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.zO(i) == 8) {
                    TiebaStatic.log(new aq("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.zO(i));
                if (ScrollFragmentTabHost.this.zO(i) == 5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.bik().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.bik().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.iJt.cwE()) {
                        ScrollFragmentTabHost.this.iJt.setShowHotTopicRedTip(false);
                    }
                }
            }
        });
        this.iJE.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void pF(boolean z) {
                if (z && ScrollFragmentTabHost.this.iJG != null) {
                    ScrollFragmentTabHost.this.iJG.NG();
                }
            }
        });
        this.iJF.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void JD(String str) {
                if (ScrollFragmentTabHost.this.iJG != null) {
                    ScrollFragmentTabHost.this.iJG.NG();
                    ScrollFragmentTabHost.this.iJG = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    be.bju().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.iJF.setVisibility(8);
            this.iJt.setMissionEntranceVisibility(true);
            this.iJt.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void JD(String str) {
                    if (ScrollFragmentTabHost.this.iJG != null) {
                        ScrollFragmentTabHost.this.iJG.NG();
                        ScrollFragmentTabHost.this.iJG = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        be.bju().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.iJF.setVisibility(0);
        this.iJt.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.iJD.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.iJD);
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
        this.fDZ.a(aVar);
        MessageManager.getInstance().registerListener(this.iJA);
        MessageManager.getInstance().registerListener(this.iJB);
        this.iJC.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.iJC);
    }

    public void notifyDataSetChanged() {
        if (this.iJw != null && !HomePageStatic.iFV) {
            this.eiA.setAdapter(this.iJw);
            this.iJt.notifyDataSetChanged();
            this.iJH.a(this.iJI);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.iJw != null) {
            this.iJw.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.iJw != null) {
            this.iJw.d(dataRes, z);
        }
    }

    public void cwA() {
        if (this.iJw != null) {
            this.iJw.cwA();
        }
    }

    public void w(String str, int i, int i2) {
        if (this.eiA != null) {
            this.iJw.w(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.iJw = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.iJw.setScrollFragmentTabHost(this);
        this.eiA.setOffscreenPageLimit(2);
        this.eiA.setAdapter(this.iJw);
        int cwy = this.iJw.cwy();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.iJw;
        if (HomePageStatic.iFV) {
            cwy = 0;
        }
        this.eiA.setCurrentItem(newScrollFragmentAdapter.zI(cwy));
        this.iJt.setViewPager(this.eiA);
        this.iJt.setConcernTabIndex(this.iJw.zI(0));
        this.iJt.setHotTopicTabIndex(this.iJw.zI(5));
        this.iJt.setShowHotTopicRedTip(cwI());
    }

    private boolean cwI() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            if (currentTimeMillis - com.baidu.tbadk.core.sharedPref.b.bik().getLong("unlogin_hot_top_timestamp", 0L) >= 86400000) {
                return true;
            }
        } else {
            long j = com.baidu.tbadk.core.sharedPref.b.bik().getLong(TbadkApplication.getCurrentAccount(), 0L);
            if (!StringUtils.isNull(TbadkApplication.getCurrentAccount()) && currentTimeMillis - j >= 86400000) {
                return true;
            }
        }
        return false;
    }

    public boolean cwJ() {
        return this.iJw != null && this.iJw.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.iJw.getCount()) {
            this.iJt.setTabItemClicked(z);
            this.iJw.zL(i);
            this.eiA.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.iJw.zI(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.iJw.zI(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.iJw.JE(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iJt.setPageUniqueId(bdUniqueId);
        this.iJA.setTag(bdUniqueId);
        this.iJB.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.dAf;
    }

    public int getCurrentTabType() {
        return this.iJw.zH(this.eiA.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.eiA.getAdapter() != null) {
            int count = this.eiA.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.iJw.zH(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int zO(int i) {
        return this.iJw.zH(i);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.iJE, R.color.cp_bg_line_h);
        this.iJF.onChangeSkinType();
        this.iJt.onChangeSkinType();
        if (this.mPageContext != null && this.fDZ != null) {
            this.fDZ.onChangeSkinType(this.mPageContext, i);
        }
        if (this.iJw != null) {
            this.iJw.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.hvf != null) {
            this.hvf.onChangeSkinType(this.mPageContext, i);
        }
        ap.setBackgroundColor(this.fmI, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.fGn, R.drawable.personalize_tab_shadow);
    }

    private boolean bGl() {
        return this.fGn.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.iJv = z;
        if (z) {
            if (this.fmI != null) {
                this.fmI.setVisibility(8);
            }
        } else if (this.fmI != null) {
            this.fmI.setVisibility(0);
        }
    }

    public void bGm() {
        if (this.iJv && !bGl()) {
            this.fGn.setVisibility(0);
            if (this.fGq == null) {
                this.fGq = new AlphaAnimation(0.0f, 1.0f);
                this.fGq.setFillAfter(true);
                this.fGq.setDuration(300L);
            }
            this.fGn.startAnimation(this.fGq);
        }
    }

    public void bGn() {
        if (this.iJv && bGl()) {
            if (this.fGr == null) {
                this.fGr = new AlphaAnimation(1.0f, 0.0f);
                this.fGr.setFillAfter(true);
                this.fGr.setDuration(300L);
                this.fGr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.fGn.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fGn.startAnimation(this.fGr);
        }
    }

    public void cwC() {
        if (this.iJw != null) {
            this.iJw.cwC();
        }
    }

    public void bGR() {
        this.iJw.bGR();
    }

    public String getCurrentPageKey() {
        if (this.iJw != null) {
            return this.iJw.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.eiA != null) {
            return this.eiA.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.iJw != null) {
            this.iJw.setPrimary(z);
        }
        if (this.fDZ != null && z) {
            this.fDZ.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cwK() {
        this.iJw.a(this.iJJ);
    }

    public void ot(boolean z) {
    }

    public void cwL() {
        if (this.iJE != null && !this.iJE.isSticky() && this.iJt != null && this.iJt.getTaskView() != null && this.iJt.getTaskView().getVisibility() != 0) {
            this.iJt.cwT();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.iJx = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.iJG != null) {
            this.iJG.NG();
            this.iJG = null;
        }
        cwN();
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.iJt != null && this.iJw.cwz()) {
            this.iJt.setShowConcernRedTip(z);
        }
    }

    public boolean cwD() {
        if (this.iJt == null || !this.iJw.cwz()) {
            return false;
        }
        return this.iJt.cwD();
    }

    public void setVideoThreadId(String str) {
        if (this.iJw != null) {
            this.iJw.setVideoThreadId(str);
        }
    }

    public void cwM() {
        if (com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int zI = this.iJw != null ? this.iJw.zI(0) : 0;
            if (this.iJy == null) {
                this.iJy = new e(this.mPageContext, this.iJt.zM(zI));
                this.iJy.eL(R.drawable.bg_tip_blue_up);
                this.iJy.eK(32);
                this.iJy.nu(true);
                this.iJy.setUseDirectOffset(true);
                this.iJy.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.iJy.eM(4000);
            }
            this.iJy.y(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cwN() {
        if (this.iJy != null) {
            this.iJy.NG();
        }
    }

    public void onResume() {
        if (this.iJt != null) {
            this.iJt.onResume();
        }
    }

    public void a(a aVar) {
        if (this.iJz == null) {
            this.iJz = new ArrayList();
        }
        this.iJz.add(aVar);
    }

    public void b(a aVar) {
        if (this.iJz != null && this.iJz.size() > 0) {
            this.iJz.remove(aVar);
        }
    }

    /* loaded from: classes16.dex */
    public static abstract class a {
        public void cwO() {
        }

        public void cwP() {
        }

        public void cwi() {
        }
    }
}
