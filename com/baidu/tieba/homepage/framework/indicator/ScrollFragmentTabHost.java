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
    private View eLg;
    private NoNetworkView fbX;
    private View fek;
    private AlphaAnimation fen;
    private AlphaAnimation feo;
    private PluginErrorTipView gPw;
    private HomeTabBarView hZI;
    private TBSpecificationBtn hZJ;
    private boolean hZK;
    private NewScrollFragmentAdapter hZL;
    private b hZM;
    private d hZN;
    private List<a> hZO;
    CustomMessageListener hZP;
    CustomMessageListener hZQ;
    CustomMessageTask hZR;
    CustomMessageTask hZS;
    private StickyAppBarLayout hZT;
    private NestedScrollHeader hZU;
    private d hZV;
    private com.baidu.tieba.homepage.framework.indicator.b hZW;
    private e hZX;
    private com.baidu.tieba.homepage.framework.d hZY;
    private boolean isPrimary;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes9.dex */
    public interface b {
        void wv(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.hZP = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bre();
                } else {
                    ScrollFragmentTabHost.this.brf();
                }
            }
        };
        this.hZQ = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.hZV != null) {
                    ScrollFragmentTabHost.this.hZV.Gu();
                    ScrollFragmentTabHost.this.hZV = null;
                }
            }
        };
        this.hZR = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.hZT == null || ScrollFragmentTabHost.this.hZU == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.hZI.getTaskView() : ScrollFragmentTabHost.this.hZU.getTaskView();
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
                    if (ScrollFragmentTabHost.this.hZV != null) {
                        ScrollFragmentTabHost.this.hZV.Gu();
                    }
                    ScrollFragmentTabHost.this.hZV = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.hZV.cF(48);
                    ScrollFragmentTabHost.this.hZV.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.hZV.sv(4);
                    ScrollFragmentTabHost.this.hZV.cH(i);
                    ScrollFragmentTabHost.this.hZV.ma(true);
                    ScrollFragmentTabHost.this.hZV.sx(0);
                    ScrollFragmentTabHost.this.hZV.Dx(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.hZS = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.hZT == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.brf();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.hZT.cfa();
                } else if (!com.baidu.tbadk.a.d.aMs() && ScrollFragmentTabHost.this.hZT.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.hZT.cfa();
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
        this.hZW = new com.baidu.tieba.homepage.framework.indicator.b();
        this.hZX = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void wm(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.hZL.wo(i), false);
                ScrollFragmentTabHost.this.hZL.wq(i);
            }
        };
        this.hZY = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void wl(int i) {
                ScrollFragmentTabHost.this.hZW.a(i, ScrollFragmentTabHost.this.hZX);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hZP = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bre();
                } else {
                    ScrollFragmentTabHost.this.brf();
                }
            }
        };
        this.hZQ = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.hZV != null) {
                    ScrollFragmentTabHost.this.hZV.Gu();
                    ScrollFragmentTabHost.this.hZV = null;
                }
            }
        };
        this.hZR = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.hZT == null || ScrollFragmentTabHost.this.hZU == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.hZI.getTaskView() : ScrollFragmentTabHost.this.hZU.getTaskView();
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
                    if (ScrollFragmentTabHost.this.hZV != null) {
                        ScrollFragmentTabHost.this.hZV.Gu();
                    }
                    ScrollFragmentTabHost.this.hZV = new d(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.hZV.cF(48);
                    ScrollFragmentTabHost.this.hZV.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.hZV.sv(4);
                    ScrollFragmentTabHost.this.hZV.cH(i);
                    ScrollFragmentTabHost.this.hZV.ma(true);
                    ScrollFragmentTabHost.this.hZV.sx(0);
                    ScrollFragmentTabHost.this.hZV.Dx(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.hZS = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.hZT == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.brf();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.hZT.cfa();
                } else if (!com.baidu.tbadk.a.d.aMs() && ScrollFragmentTabHost.this.hZT.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.hZT.cfa();
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
        this.hZW = new com.baidu.tieba.homepage.framework.indicator.b();
        this.hZX = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void wm(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.hZL.wo(i), false);
                ScrollFragmentTabHost.this.hZL.wq(i);
            }
        };
        this.hZY = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void wl(int i) {
                ScrollFragmentTabHost.this.hZW.a(i, ScrollFragmentTabHost.this.hZX);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.hZT = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.hZU = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.hZI = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.gPw = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.fbX = (NoNetworkView) findViewById(R.id.view_no_network);
        this.dft = (FrameLayout) findViewById(R.id.home_pager_container);
        this.dLI = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.eLg = findViewById(R.id.divider_line);
        this.fek = findViewById(R.id.divider_shadow);
        this.hZJ = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.hZJ.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hZT.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.dft.getLayoutParams()).topMargin = 0;
        this.hZI.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.hZL.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.hZM != null) {
                    ScrollFragmentTabHost.this.hZM.wv(i);
                }
                com.baidu.tbadk.core.bigday.b.aNY().gJ(ScrollFragmentTabHost.this.hZL.wn(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.wu(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.hZO != null && ScrollFragmentTabHost.this.hZL != null) {
                    int wn = ScrollFragmentTabHost.this.hZL.wn(ScrollFragmentTabHost.this.dLI.getCurrentItem());
                    if (wn == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.hZO) {
                            aVar.ceY();
                        }
                    } else if (wn == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.hZO) {
                            aVar2.ceX();
                        }
                    } else if (wn == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.hZO) {
                            aVar3.cet();
                        }
                    } else if (wn == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (wn == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (wn == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.brf();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                ScrollFragmentTabHost.this.ceU();
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.wu(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean ceP = ScrollFragmentTabHost.this.ceP();
                    TiebaStatic.log(new an("c12350").ag("obj_type", ceP ? 1 : 0));
                    if (ceP && ScrollFragmentTabHost.this.hZL != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.hZL.ceN();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.hZI.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void k(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.dLI.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.wu(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.wu(i) == 7) {
                    TiebaStatic.log(new an("c13483").dh("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.wu(i) == 8) {
                    TiebaStatic.log(new an("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.wu(i));
            }
        });
        this.hZT.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void oi(boolean z) {
                if (z && ScrollFragmentTabHost.this.hZV != null) {
                    ScrollFragmentTabHost.this.hZV.Gu();
                }
            }
        });
        this.hZU.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void FA(String str) {
                if (ScrollFragmentTabHost.this.hZV != null) {
                    ScrollFragmentTabHost.this.hZV.Gu();
                    ScrollFragmentTabHost.this.hZV = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    ba.aUZ().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.hZU.setVisibility(8);
            this.hZI.setMissionEntranceVisibility(true);
            this.hZI.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void FA(String str) {
                    if (ScrollFragmentTabHost.this.hZV != null) {
                        ScrollFragmentTabHost.this.hZV.Gu();
                        ScrollFragmentTabHost.this.hZV = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        ba.aUZ().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.hZU.setVisibility(0);
        this.hZI.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.hZS.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hZS);
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
        this.fbX.a(aVar);
        MessageManager.getInstance().registerListener(this.hZP);
        MessageManager.getInstance().registerListener(this.hZQ);
        this.hZR.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.hZR);
    }

    public void notifyDataSetChanged() {
        if (this.hZL != null && !HomePageStatic.hWn) {
            this.dLI.setAdapter(this.hZL);
            this.hZI.notifyDataSetChanged();
            this.hZW.a(this.hZX);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.hZL != null) {
            this.hZL.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.hZL != null) {
            this.hZL.d(dataRes, z);
        }
    }

    public void ceM() {
        if (this.hZL != null) {
            this.hZL.ceM();
        }
    }

    public void x(String str, int i, int i2) {
        if (this.dLI != null) {
            this.hZL.x(str, i, i2);
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
        this.hZL = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.hZL.setScrollFragmentTabHost(this);
        this.dLI.setOffscreenPageLimit(2);
        this.dLI.setAdapter(this.hZL);
        int ceK = this.hZL.ceK();
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.hZL;
            if (HomePageStatic.hWn) {
                i = 0;
            }
            this.dLI.setCurrentItem(newScrollFragmentAdapter.wo(i));
            this.hZI.setViewPager(this.dLI);
            this.hZI.setConcernTabIndex(this.hZL.wo(0));
            ceU();
        }
        i = ceK;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.hZL;
        if (HomePageStatic.hWn) {
        }
        this.dLI.setCurrentItem(newScrollFragmentAdapter2.wo(i));
        this.hZI.setViewPager(this.dLI);
        this.hZI.setConcernTabIndex(this.hZL.wo(0));
        ceU();
    }

    public boolean ceS() {
        return this.hZL != null && this.hZL.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.hZL.getCount()) {
            this.hZI.setTabItemClicked(z);
            this.hZL.wr(i);
            this.dLI.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.hZL.wo(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.hZL.wo(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hZI.setPageUniqueId(bdUniqueId);
        this.hZP.setTag(bdUniqueId);
        this.hZQ.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.dft;
    }

    public int getCurrentTabType() {
        return this.hZL.wn(this.dLI.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.dLI.getAdapter() != null) {
            int count = this.dLI.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.hZL.wn(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int wu(int i) {
        return this.hZL.wn(i);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.hZT, R.color.cp_bg_line_h);
        this.hZU.onChangeSkinType();
        this.hZI.onChangeSkinType();
        if (this.mPageContext != null && this.fbX != null) {
            this.fbX.onChangeSkinType(this.mPageContext, i);
        }
        if (this.hZL != null) {
            this.hZL.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.gPw != null) {
            this.gPw.onChangeSkinType(this.mPageContext, i);
        }
        am.setBackgroundColor(this.eLg, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.fek, R.drawable.personalize_tab_shadow);
    }

    private boolean brd() {
        return this.fek.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.hZK = z;
        if (z) {
            if (this.eLg != null) {
                this.eLg.setVisibility(8);
            }
        } else if (this.eLg != null) {
            this.eLg.setVisibility(0);
        }
    }

    public void bre() {
        if (this.hZK && !brd()) {
            this.fek.setVisibility(0);
            if (this.fen == null) {
                this.fen = new AlphaAnimation(0.0f, 1.0f);
                this.fen.setFillAfter(true);
                this.fen.setDuration(300L);
            }
            this.fek.startAnimation(this.fen);
        }
    }

    public void brf() {
        if (this.hZK && brd()) {
            if (this.feo == null) {
                this.feo = new AlphaAnimation(1.0f, 0.0f);
                this.feo.setFillAfter(true);
                this.feo.setDuration(300L);
                this.feo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.fek.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fek.startAnimation(this.feo);
        }
    }

    public void ceO() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.hZL != null) {
            this.hZL.ceO();
        }
        if ((currentTabType == 1 || currentTabType == 8 || currentTabType == 5 || currentTabType == 6 || currentTabType == 7) && this.hZL != null) {
            this.hZL.ceO();
        }
    }

    public void brJ() {
        this.hZL.brJ();
    }

    public String getCurrentPageKey() {
        if (this.hZL != null) {
            return this.hZL.getCurrentPageKey();
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
        if (this.hZL != null) {
            this.hZL.setPrimary(z);
        }
        if (this.fbX != null && z) {
            this.fbX.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void ceT() {
        this.hZL.a(this.hZY);
    }

    public void mX(boolean z) {
        if (!z && this.hZI != null && this.hZI.getTaskView() != null && this.hZI.getTaskView().getVisibility() != 0) {
            this.hZI.cfc();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.hZM = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.hZV != null) {
            this.hZV.Gu();
            this.hZV = null;
        }
        ceW();
    }

    public void ceU() {
        int i = 1;
        if (this.hZL != null) {
            int wn = this.hZL.wn(this.dLI.getCurrentItem());
            if (wn == 0) {
                i = 0;
            } else if (wn != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.aTX().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.hZI != null && this.hZL.ceL()) {
            this.hZI.setShowConcernRedTip(z);
        }
    }

    public boolean ceP() {
        if (this.hZI == null || !this.hZL.ceL()) {
            return false;
        }
        return this.hZI.ceP();
    }

    public void setVideoThreadId(String str) {
        if (this.hZL != null) {
            this.hZL.setVideoThreadId(str);
        }
    }

    public void ceV() {
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int wo = this.hZL != null ? this.hZL.wo(0) : 0;
            if (this.hZN == null) {
                this.hZN = new d(this.mPageContext, this.hZI.ws(wo));
                this.hZN.cG(R.drawable.bg_tip_blue_up);
                this.hZN.cF(32);
                this.hZN.ma(true);
                this.hZN.setUseDirectOffset(true);
                this.hZN.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.hZN.cH(4000);
            }
            this.hZN.f(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void ceW() {
        if (this.hZN != null) {
            this.hZN.Gu();
        }
    }

    public void onResume() {
        if (this.hZI != null) {
            this.hZI.onResume();
        }
    }

    public void a(a aVar) {
        if (this.hZO == null) {
            this.hZO = new ArrayList();
        }
        this.hZO.add(aVar);
    }

    public void b(a aVar) {
        if (this.hZO != null && this.hZO.size() > 0) {
            this.hZO.remove(aVar);
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class a {
        public void ceX() {
        }

        public void ceY() {
        }

        public void cet() {
        }
    }
}
