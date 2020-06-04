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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.switchs.MissionEntranceSwitch;
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
    private View.OnClickListener aUZ;
    private CustomViewPager dLI;
    private FrameLayout dft;
    private View eLr;
    private NoNetworkView fci;
    private View fev;
    private AlphaAnimation fey;
    private AlphaAnimation fez;
    private PluginErrorTipView gPH;
    private d iaA;
    private List<a> iaB;
    CustomMessageListener iaC;
    CustomMessageListener iaD;
    CustomMessageTask iaE;
    CustomMessageTask iaF;
    private StickyAppBarLayout iaG;
    private NestedScrollHeader iaH;
    private d iaI;
    private com.baidu.tieba.homepage.framework.indicator.b iaJ;
    private e iaK;
    private com.baidu.tieba.homepage.framework.d iaL;
    private HomeTabBarView iav;
    private TBSpecificationBtn iaw;
    private boolean iax;
    private NewScrollFragmentAdapter iay;
    private b iaz;
    private boolean isPrimary;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes9.dex */
    public interface b {
        void wx(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.iaC = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.brg();
                } else {
                    ScrollFragmentTabHost.this.brh();
                }
            }
        };
        this.iaD = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.iaI != null) {
                    ScrollFragmentTabHost.this.iaI.Gu();
                    ScrollFragmentTabHost.this.iaI = null;
                }
            }
        };
        this.iaE = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.iaG == null || ScrollFragmentTabHost.this.iaH == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.iav.getTaskView() : ScrollFragmentTabHost.this.iaH.getTaskView();
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
                    if (ScrollFragmentTabHost.this.iaI != null) {
                        ScrollFragmentTabHost.this.iaI.Gu();
                    }
                    ScrollFragmentTabHost.this.iaI = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.iaI.cH(48);
                    ScrollFragmentTabHost.this.iaI.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.iaI.sx(4);
                    ScrollFragmentTabHost.this.iaI.cJ(i);
                    ScrollFragmentTabHost.this.iaI.ma(true);
                    ScrollFragmentTabHost.this.iaI.sz(0);
                    ScrollFragmentTabHost.this.iaI.Dx(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.iaF = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.iaG == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.brh();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.iaG.cfj();
                } else if (!com.baidu.tbadk.a.d.aMs() && ScrollFragmentTabHost.this.iaG.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.iaG.cfj();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
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
        this.iaJ = new com.baidu.tieba.homepage.framework.indicator.b();
        this.iaK = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void wo(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.iay.wq(i), false);
                ScrollFragmentTabHost.this.iay.ws(i);
            }
        };
        this.iaL = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void wn(int i) {
                ScrollFragmentTabHost.this.iaJ.a(i, ScrollFragmentTabHost.this.iaK);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iaC = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.brg();
                } else {
                    ScrollFragmentTabHost.this.brh();
                }
            }
        };
        this.iaD = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.iaI != null) {
                    ScrollFragmentTabHost.this.iaI.Gu();
                    ScrollFragmentTabHost.this.iaI = null;
                }
            }
        };
        this.iaE = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.iaG == null || ScrollFragmentTabHost.this.iaH == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.iav.getTaskView() : ScrollFragmentTabHost.this.iaH.getTaskView();
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
                    if (ScrollFragmentTabHost.this.iaI != null) {
                        ScrollFragmentTabHost.this.iaI.Gu();
                    }
                    ScrollFragmentTabHost.this.iaI = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.iaI.cH(48);
                    ScrollFragmentTabHost.this.iaI.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.iaI.sx(4);
                    ScrollFragmentTabHost.this.iaI.cJ(i);
                    ScrollFragmentTabHost.this.iaI.ma(true);
                    ScrollFragmentTabHost.this.iaI.sz(0);
                    ScrollFragmentTabHost.this.iaI.Dx(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.iaF = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.iaG == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.brh();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.iaG.cfj();
                } else if (!com.baidu.tbadk.a.d.aMs() && ScrollFragmentTabHost.this.iaG.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.iaG.cfj();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
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
        this.iaJ = new com.baidu.tieba.homepage.framework.indicator.b();
        this.iaK = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void wo(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.iay.wq(i), false);
                ScrollFragmentTabHost.this.iay.ws(i);
            }
        };
        this.iaL = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void wn(int i) {
                ScrollFragmentTabHost.this.iaJ.a(i, ScrollFragmentTabHost.this.iaK);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.iaG = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.iaH = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.iav = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.gPH = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.fci = (NoNetworkView) findViewById(R.id.view_no_network);
        this.dft = (FrameLayout) findViewById(R.id.home_pager_container);
        this.dLI = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.eLr = findViewById(R.id.divider_line);
        this.fev = findViewById(R.id.divider_shadow);
        this.iaw = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.iaw.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.iaG.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.dft.getLayoutParams()).topMargin = 0;
        this.iav.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.iay.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.iaz != null) {
                    ScrollFragmentTabHost.this.iaz.wx(i);
                }
                com.baidu.tbadk.core.bigday.b.aNY().gJ(ScrollFragmentTabHost.this.iay.wp(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.ww(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.iaB != null && ScrollFragmentTabHost.this.iay != null) {
                    int wp = ScrollFragmentTabHost.this.iay.wp(ScrollFragmentTabHost.this.dLI.getCurrentItem());
                    if (wp == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.iaB) {
                            aVar.cfh();
                        }
                    } else if (wp == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.iaB) {
                            aVar2.cfg();
                        }
                    } else if (wp == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.iaB) {
                            aVar3.ceB();
                        }
                    } else if (wp == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (wp == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (wp == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.brh();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.cfd();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.ww(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean ceX = ScrollFragmentTabHost.this.ceX();
                    TiebaStatic.log(new an("c12350").ag("obj_type", ceX ? 1 : 0));
                    if (ceX && ScrollFragmentTabHost.this.iay != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.iay.ceV();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.iav.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void k(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.dLI.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.ww(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.ww(i) == 7) {
                    TiebaStatic.log(new an("c13483").dh("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.ww(i) == 8) {
                    TiebaStatic.log(new an("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.ww(i));
            }
        });
        this.iaG.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void oi(boolean z) {
                if (z && ScrollFragmentTabHost.this.iaI != null) {
                    ScrollFragmentTabHost.this.iaI.Gu();
                }
            }
        });
        this.iaH.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void FA(String str) {
                if (ScrollFragmentTabHost.this.iaI != null) {
                    ScrollFragmentTabHost.this.iaI.Gu();
                    ScrollFragmentTabHost.this.iaI = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    ba.aVa().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.iaH.setVisibility(8);
            this.iav.setMissionEntranceVisibility(true);
            this.iav.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void FA(String str) {
                    if (ScrollFragmentTabHost.this.iaI != null) {
                        ScrollFragmentTabHost.this.iaI.Gu();
                        ScrollFragmentTabHost.this.iaI = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        ba.aVa().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.iaH.setVisibility(0);
        this.iav.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.iaF.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.iaF);
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
        this.fci.a(aVar);
        MessageManager.getInstance().registerListener(this.iaC);
        MessageManager.getInstance().registerListener(this.iaD);
        this.iaE.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.iaE);
    }

    public void notifyDataSetChanged() {
        if (this.iay != null && !HomePageStatic.hXa) {
            this.dLI.setAdapter(this.iay);
            this.iav.notifyDataSetChanged();
            this.iaJ.a(this.iaK);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.iay != null) {
            this.iay.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.iay != null) {
            this.iay.d(dataRes, z);
        }
    }

    public void ceU() {
        if (this.iay != null) {
            this.iay.ceU();
        }
    }

    public void x(String str, int i, int i2) {
        if (this.dLI != null) {
            this.iay.x(str, i, i2);
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
        this.iay = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.iay.setScrollFragmentTabHost(this);
        this.dLI.setOffscreenPageLimit(2);
        this.dLI.setAdapter(this.iay);
        int ceS = this.iay.ceS();
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.iay;
            if (HomePageStatic.hXa) {
                i = 0;
            }
            this.dLI.setCurrentItem(newScrollFragmentAdapter.wq(i));
            this.iav.setViewPager(this.dLI);
            this.iav.setConcernTabIndex(this.iay.wq(0));
            cfd();
        }
        i = ceS;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.iay;
        if (HomePageStatic.hXa) {
        }
        this.dLI.setCurrentItem(newScrollFragmentAdapter2.wq(i));
        this.iav.setViewPager(this.dLI);
        this.iav.setConcernTabIndex(this.iay.wq(0));
        cfd();
    }

    public boolean cfa() {
        return this.iay != null && this.iay.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.iay.getCount()) {
            this.iav.setTabItemClicked(z);
            this.iay.wt(i);
            this.dLI.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.iay.wq(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.iay.wq(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iav.setPageUniqueId(bdUniqueId);
        this.iaC.setTag(bdUniqueId);
        this.iaD.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.dft;
    }

    public int getCurrentTabType() {
        return this.iay.wp(this.dLI.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.dLI.getAdapter() != null) {
            int count = this.dLI.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.iay.wp(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int ww(int i) {
        return this.iay.wp(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.iaG, R.color.cp_bg_line_h);
        this.iaH.onChangeSkinType();
        this.iav.onChangeSkinType();
        if (this.mPageContext != null && this.fci != null) {
            this.fci.onChangeSkinType(this.mPageContext, i);
        }
        if (this.iay != null) {
            this.iay.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.gPH != null) {
            this.gPH.onChangeSkinType(this.mPageContext, i);
        }
        am.setBackgroundColor(this.eLr, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.fev, R.drawable.personalize_tab_shadow);
    }

    private boolean brf() {
        return this.fev.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.iax = z;
        if (z) {
            if (this.eLr != null) {
                this.eLr.setVisibility(8);
            }
        } else if (this.eLr != null) {
            this.eLr.setVisibility(0);
        }
    }

    public void brg() {
        if (this.iax && !brf()) {
            this.fev.setVisibility(0);
            if (this.fey == null) {
                this.fey = new AlphaAnimation(0.0f, 1.0f);
                this.fey.setFillAfter(true);
                this.fey.setDuration(300L);
            }
            this.fev.startAnimation(this.fey);
        }
    }

    public void brh() {
        if (this.iax && brf()) {
            if (this.fez == null) {
                this.fez = new AlphaAnimation(1.0f, 0.0f);
                this.fez.setFillAfter(true);
                this.fez.setDuration(300L);
                this.fez.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.fev.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fev.startAnimation(this.fez);
        }
    }

    public void ceW() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.iay != null) {
            this.iay.ceW();
        }
        if ((currentTabType == 1 || currentTabType == 8 || currentTabType == 5 || currentTabType == 6 || currentTabType == 7) && this.iay != null) {
            this.iay.ceW();
        }
    }

    public void brL() {
        this.iay.brL();
    }

    public String getCurrentPageKey() {
        if (this.iay != null) {
            return this.iay.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.dLI != null) {
            return this.dLI.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.iay != null) {
            this.iay.setPrimary(z);
        }
        if (this.fci != null && z) {
            this.fci.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cfb() {
        this.iay.a(this.iaL);
    }

    public void mX(boolean z) {
    }

    public void cfc() {
        if (this.iaG != null && !this.iaG.isSticky() && MissionEntranceSwitch.isOn() && this.iav != null && this.iav.getTaskView() != null && this.iav.getTaskView().getVisibility() != 0) {
            this.iav.cfl();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.iaz = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.iaI != null) {
            this.iaI.Gu();
            this.iaI = null;
        }
        cff();
    }

    public void cfd() {
        int i = 1;
        if (this.iay != null) {
            int wp = this.iay.wp(this.dLI.getCurrentItem());
            if (wp == 0) {
                i = 0;
            } else if (wp != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.aTX().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.iav != null && this.iay.ceT()) {
            this.iav.setShowConcernRedTip(z);
        }
    }

    public boolean ceX() {
        if (this.iav == null || !this.iay.ceT()) {
            return false;
        }
        return this.iav.ceX();
    }

    public void setVideoThreadId(String str) {
        if (this.iay != null) {
            this.iay.setVideoThreadId(str);
        }
    }

    public void cfe() {
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int wq = this.iay != null ? this.iay.wq(0) : 0;
            if (this.iaA == null) {
                this.iaA = new d(this.mPageContext, this.iav.wu(wq));
                this.iaA.cI(R.drawable.bg_tip_blue_up);
                this.iaA.cH(32);
                this.iaA.ma(true);
                this.iaA.setUseDirectOffset(true);
                this.iaA.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.iaA.cJ(4000);
            }
            this.iaA.f(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cff() {
        if (this.iaA != null) {
            this.iaA.Gu();
        }
    }

    public void onResume() {
        if (this.iav != null) {
            this.iav.onResume();
        }
    }

    public void a(a aVar) {
        if (this.iaB == null) {
            this.iaB = new ArrayList();
        }
        this.iaB.add(aVar);
    }

    public void b(a aVar) {
        if (this.iaB != null && this.iaB.size() > 0) {
            this.iaB.remove(aVar);
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class a {
        public void cfg() {
        }

        public void cfh() {
        }

        public void ceB() {
        }
    }
}
