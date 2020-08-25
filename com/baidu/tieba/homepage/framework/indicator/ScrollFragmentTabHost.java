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
    private View.OnClickListener aBk;
    private FrameLayout dAb;
    private CustomViewPager eiw;
    private NoNetworkView fDV;
    private View fGj;
    private AlphaAnimation fGm;
    private AlphaAnimation fGn;
    private View fmE;
    private PluginErrorTipView huZ;
    private e iJA;
    private com.baidu.tieba.homepage.framework.indicator.b iJB;
    private com.baidu.tieba.homepage.framework.e iJC;
    private d iJD;
    private HomeTabBarView iJn;
    private TBSpecificationBtn iJo;
    private boolean iJp;
    private NewScrollFragmentAdapter iJq;
    private b iJr;
    private e iJs;
    private List<a> iJt;
    CustomMessageListener iJu;
    CustomMessageListener iJv;
    CustomMessageTask iJw;
    CustomMessageTask iJx;
    private StickyAppBarLayout iJy;
    private NestedScrollHeader iJz;
    private boolean isPrimary;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes16.dex */
    public interface b {
        void zP(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.iJu = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bGl();
                } else {
                    ScrollFragmentTabHost.this.bGm();
                }
            }
        };
        this.iJv = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.iJA != null) {
                    ScrollFragmentTabHost.this.iJA.NG();
                    ScrollFragmentTabHost.this.iJA = null;
                }
            }
        };
        this.iJw = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.iJy == null || ScrollFragmentTabHost.this.iJz == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.iJn.getTaskView() : ScrollFragmentTabHost.this.iJz.getTaskView();
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
                    if (ScrollFragmentTabHost.this.iJA != null) {
                        ScrollFragmentTabHost.this.iJA.NG();
                    }
                    ScrollFragmentTabHost.this.iJA = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.iJA.eK(48);
                    ScrollFragmentTabHost.this.iJA.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.iJA.setAnchor(4);
                    ScrollFragmentTabHost.this.iJA.eM(i);
                    ScrollFragmentTabHost.this.iJA.ns(true);
                    ScrollFragmentTabHost.this.iJA.vF(0);
                    ScrollFragmentTabHost.this.iJA.Hi(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.iJx = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.iJy == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bGm();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.iJy.cwQ();
                } else if (ScrollFragmentTabHost.this.iJy.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.iJy.cwQ();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aBk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
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
        this.iJB = new com.baidu.tieba.homepage.framework.indicator.b();
        this.iJC = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void zG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.iJq.zI(i), false);
                ScrollFragmentTabHost.this.iJq.zK(i);
            }
        };
        this.iJD = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void zF(int i) {
                ScrollFragmentTabHost.this.iJB.a(i, ScrollFragmentTabHost.this.iJC);
            }
        };
        init();
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iJu = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bGl();
                } else {
                    ScrollFragmentTabHost.this.bGm();
                }
            }
        };
        this.iJv = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.iJA != null) {
                    ScrollFragmentTabHost.this.iJA.NG();
                    ScrollFragmentTabHost.this.iJA = null;
                }
            }
        };
        this.iJw = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.iJy == null || ScrollFragmentTabHost.this.iJz == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.iJn.getTaskView() : ScrollFragmentTabHost.this.iJz.getTaskView();
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
                    if (ScrollFragmentTabHost.this.iJA != null) {
                        ScrollFragmentTabHost.this.iJA.NG();
                    }
                    ScrollFragmentTabHost.this.iJA = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.iJA.eK(48);
                    ScrollFragmentTabHost.this.iJA.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.iJA.setAnchor(4);
                    ScrollFragmentTabHost.this.iJA.eM(i);
                    ScrollFragmentTabHost.this.iJA.ns(true);
                    ScrollFragmentTabHost.this.iJA.vF(0);
                    ScrollFragmentTabHost.this.iJA.Hi(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.iJx = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.iJy == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bGm();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.iJy.cwQ();
                } else if (ScrollFragmentTabHost.this.iJy.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.iJy.cwQ();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aBk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
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
        this.iJB = new com.baidu.tieba.homepage.framework.indicator.b();
        this.iJC = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void zG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.iJq.zI(i), false);
                ScrollFragmentTabHost.this.iJq.zK(i);
            }
        };
        this.iJD = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void zF(int i) {
                ScrollFragmentTabHost.this.iJB.a(i, ScrollFragmentTabHost.this.iJC);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.iJy = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.iJz = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.iJn = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.huZ = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.fDV = (NoNetworkView) findViewById(R.id.view_no_network);
        this.dAb = (FrameLayout) findViewById(R.id.home_pager_container);
        this.eiw = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.fmE = findViewById(R.id.divider_line);
        this.fGj = findViewById(R.id.divider_shadow);
        this.iJo = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.iJo.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.iJy.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.dAb.getLayoutParams()).topMargin = 0;
        this.iJn.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.iJq.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.iJr != null) {
                    ScrollFragmentTabHost.this.iJr.zP(i);
                }
                com.baidu.tbadk.core.bigday.b.bbU().hQ(ScrollFragmentTabHost.this.iJq.zH(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.zO(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.iJt != null && ScrollFragmentTabHost.this.iJq != null) {
                    int zH = ScrollFragmentTabHost.this.iJq.zH(ScrollFragmentTabHost.this.eiw.getCurrentItem());
                    if (zH == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.iJt) {
                            aVar.cwO();
                        }
                    } else if (zH == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.iJt) {
                            aVar2.cwN();
                        }
                    } else if (zH == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.iJt) {
                            aVar3.cwh();
                        }
                    } else if (zH == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (zH == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (zH == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.bGm();
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
                    if (ScrollFragmentTabHost.this.iJn.cwD()) {
                        ScrollFragmentTabHost.this.iJn.setShowHotTopicRedTip(false);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean cwC = ScrollFragmentTabHost.this.cwC();
                    TiebaStatic.log(new aq("c12350").ai("obj_type", cwC ? 1 : 0));
                    if (cwC && ScrollFragmentTabHost.this.iJq != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.iJq.cwA();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.iJn.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void l(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.eiw.getCurrentItem() != i) {
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
                    if (ScrollFragmentTabHost.this.iJn.cwD()) {
                        ScrollFragmentTabHost.this.iJn.setShowHotTopicRedTip(false);
                    }
                }
            }
        });
        this.iJy.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void pD(boolean z) {
                if (z && ScrollFragmentTabHost.this.iJA != null) {
                    ScrollFragmentTabHost.this.iJA.NG();
                }
            }
        });
        this.iJz.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void JC(String str) {
                if (ScrollFragmentTabHost.this.iJA != null) {
                    ScrollFragmentTabHost.this.iJA.NG();
                    ScrollFragmentTabHost.this.iJA = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    be.bju().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.iJz.setVisibility(8);
            this.iJn.setMissionEntranceVisibility(true);
            this.iJn.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void JC(String str) {
                    if (ScrollFragmentTabHost.this.iJA != null) {
                        ScrollFragmentTabHost.this.iJA.NG();
                        ScrollFragmentTabHost.this.iJA = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        be.bju().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.iJz.setVisibility(0);
        this.iJn.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.iJx.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.iJx);
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
        this.fDV.a(aVar);
        MessageManager.getInstance().registerListener(this.iJu);
        MessageManager.getInstance().registerListener(this.iJv);
        this.iJw.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.iJw);
    }

    public void notifyDataSetChanged() {
        if (this.iJq != null && !HomePageStatic.iFP) {
            this.eiw.setAdapter(this.iJq);
            this.iJn.notifyDataSetChanged();
            this.iJB.a(this.iJC);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.iJq != null) {
            this.iJq.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.iJq != null) {
            this.iJq.d(dataRes, z);
        }
    }

    public void cwz() {
        if (this.iJq != null) {
            this.iJq.cwz();
        }
    }

    public void w(String str, int i, int i2) {
        if (this.eiw != null) {
            this.iJq.w(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.iJq = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.iJq.setScrollFragmentTabHost(this);
        this.eiw.setOffscreenPageLimit(2);
        this.eiw.setAdapter(this.iJq);
        int cwx = this.iJq.cwx();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.iJq;
        if (HomePageStatic.iFP) {
            cwx = 0;
        }
        this.eiw.setCurrentItem(newScrollFragmentAdapter.zI(cwx));
        this.iJn.setViewPager(this.eiw);
        this.iJn.setConcernTabIndex(this.iJq.zI(0));
        this.iJn.setHotTopicTabIndex(this.iJq.zI(5));
        this.iJn.setShowHotTopicRedTip(cwH());
    }

    private boolean cwH() {
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

    public boolean cwI() {
        return this.iJq != null && this.iJq.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.iJq.getCount()) {
            this.iJn.setTabItemClicked(z);
            this.iJq.zL(i);
            this.eiw.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.iJq.zI(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.iJq.zI(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.iJq.JD(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iJn.setPageUniqueId(bdUniqueId);
        this.iJu.setTag(bdUniqueId);
        this.iJv.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.dAb;
    }

    public int getCurrentTabType() {
        return this.iJq.zH(this.eiw.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.eiw.getAdapter() != null) {
            int count = this.eiw.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.iJq.zH(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int zO(int i) {
        return this.iJq.zH(i);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.iJy, R.color.cp_bg_line_h);
        this.iJz.onChangeSkinType();
        this.iJn.onChangeSkinType();
        if (this.mPageContext != null && this.fDV != null) {
            this.fDV.onChangeSkinType(this.mPageContext, i);
        }
        if (this.iJq != null) {
            this.iJq.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.huZ != null) {
            this.huZ.onChangeSkinType(this.mPageContext, i);
        }
        ap.setBackgroundColor(this.fmE, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.fGj, R.drawable.personalize_tab_shadow);
    }

    private boolean bGk() {
        return this.fGj.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.iJp = z;
        if (z) {
            if (this.fmE != null) {
                this.fmE.setVisibility(8);
            }
        } else if (this.fmE != null) {
            this.fmE.setVisibility(0);
        }
    }

    public void bGl() {
        if (this.iJp && !bGk()) {
            this.fGj.setVisibility(0);
            if (this.fGm == null) {
                this.fGm = new AlphaAnimation(0.0f, 1.0f);
                this.fGm.setFillAfter(true);
                this.fGm.setDuration(300L);
            }
            this.fGj.startAnimation(this.fGm);
        }
    }

    public void bGm() {
        if (this.iJp && bGk()) {
            if (this.fGn == null) {
                this.fGn = new AlphaAnimation(1.0f, 0.0f);
                this.fGn.setFillAfter(true);
                this.fGn.setDuration(300L);
                this.fGn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.fGj.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fGj.startAnimation(this.fGn);
        }
    }

    public void cwB() {
        if (this.iJq != null) {
            this.iJq.cwB();
        }
    }

    public void bGQ() {
        this.iJq.bGQ();
    }

    public String getCurrentPageKey() {
        if (this.iJq != null) {
            return this.iJq.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.eiw != null) {
            return this.eiw.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.iJq != null) {
            this.iJq.setPrimary(z);
        }
        if (this.fDV != null && z) {
            this.fDV.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cwJ() {
        this.iJq.a(this.iJD);
    }

    public void or(boolean z) {
    }

    public void cwK() {
        if (this.iJy != null && !this.iJy.isSticky() && this.iJn != null && this.iJn.getTaskView() != null && this.iJn.getTaskView().getVisibility() != 0) {
            this.iJn.cwS();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.iJr = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.iJA != null) {
            this.iJA.NG();
            this.iJA = null;
        }
        cwM();
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.iJn != null && this.iJq.cwy()) {
            this.iJn.setShowConcernRedTip(z);
        }
    }

    public boolean cwC() {
        if (this.iJn == null || !this.iJq.cwy()) {
            return false;
        }
        return this.iJn.cwC();
    }

    public void setVideoThreadId(String str) {
        if (this.iJq != null) {
            this.iJq.setVideoThreadId(str);
        }
    }

    public void cwL() {
        if (com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int zI = this.iJq != null ? this.iJq.zI(0) : 0;
            if (this.iJs == null) {
                this.iJs = new e(this.mPageContext, this.iJn.zM(zI));
                this.iJs.eL(R.drawable.bg_tip_blue_up);
                this.iJs.eK(32);
                this.iJs.ns(true);
                this.iJs.setUseDirectOffset(true);
                this.iJs.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.iJs.eM(4000);
            }
            this.iJs.y(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cwM() {
        if (this.iJs != null) {
            this.iJs.NG();
        }
    }

    public void onResume() {
        if (this.iJn != null) {
            this.iJn.onResume();
        }
    }

    public void a(a aVar) {
        if (this.iJt == null) {
            this.iJt = new ArrayList();
        }
        this.iJt.add(aVar);
    }

    public void b(a aVar) {
        if (this.iJt != null && this.iJt.size() > 0) {
            this.iJt.remove(aVar);
        }
    }

    /* loaded from: classes16.dex */
    public static abstract class a {
        public void cwN() {
        }

        public void cwO() {
        }

        public void cwh() {
        }
    }
}
