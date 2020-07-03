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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
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
/* loaded from: classes9.dex */
public class ScrollFragmentTabHost extends RelativeLayout {
    private View.OnClickListener aXG;
    private CustomViewPager dSy;
    private FrameLayout dkf;
    private View eVD;
    private NoNetworkView fns;
    private View fpG;
    private AlphaAnimation fpJ;
    private AlphaAnimation fpK;
    private PluginErrorTipView hcq;
    private HomeTabBarView ioS;
    private TBSpecificationBtn ioT;
    private boolean ioU;
    private NewScrollFragmentAdapter ioV;
    private b ioW;
    private e ioX;
    private List<a> ioY;
    CustomMessageListener ioZ;
    CustomMessageListener ipa;
    CustomMessageTask ipb;
    CustomMessageTask ipc;
    private StickyAppBarLayout ipd;
    private NestedScrollHeader ipe;
    private e ipf;
    private com.baidu.tieba.homepage.framework.indicator.b ipg;
    private com.baidu.tieba.homepage.framework.e iph;
    private d ipi;
    private boolean isPrimary;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes9.dex */
    public interface b {
        void xd(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.ioZ = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.buc();
                } else {
                    ScrollFragmentTabHost.this.bud();
                }
            }
        };
        this.ipa = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.ipf != null) {
                    ScrollFragmentTabHost.this.ipf.HH();
                    ScrollFragmentTabHost.this.ipf = null;
                }
            }
        };
        this.ipb = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.ipd == null || ScrollFragmentTabHost.this.ipe == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.ioS.getTaskView() : ScrollFragmentTabHost.this.ipe.getTaskView();
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
                    if (ScrollFragmentTabHost.this.ipf != null) {
                        ScrollFragmentTabHost.this.ipf.HH();
                    }
                    ScrollFragmentTabHost.this.ipf = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.ipf.cR(48);
                    ScrollFragmentTabHost.this.ipf.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.ipf.sV(4);
                    ScrollFragmentTabHost.this.ipf.cT(i);
                    ScrollFragmentTabHost.this.ipf.mk(true);
                    ScrollFragmentTabHost.this.ipf.sZ(0);
                    ScrollFragmentTabHost.this.ipf.DY(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.ipc = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.ipd == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bud();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.ipd.ciF();
                } else if (!com.baidu.tbadk.a.d.aNV() && ScrollFragmentTabHost.this.ipd.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.ipd.ciF();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aXG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
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
        this.ipg = new com.baidu.tieba.homepage.framework.indicator.b();
        this.iph = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void wU(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.ioV.wW(i), false);
                ScrollFragmentTabHost.this.ioV.wY(i);
            }
        };
        this.ipi = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void wT(int i) {
                ScrollFragmentTabHost.this.ipg.a(i, ScrollFragmentTabHost.this.iph);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ioZ = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.buc();
                } else {
                    ScrollFragmentTabHost.this.bud();
                }
            }
        };
        this.ipa = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.ipf != null) {
                    ScrollFragmentTabHost.this.ipf.HH();
                    ScrollFragmentTabHost.this.ipf = null;
                }
            }
        };
        this.ipb = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.ipd == null || ScrollFragmentTabHost.this.ipe == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.ioS.getTaskView() : ScrollFragmentTabHost.this.ipe.getTaskView();
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
                    if (ScrollFragmentTabHost.this.ipf != null) {
                        ScrollFragmentTabHost.this.ipf.HH();
                    }
                    ScrollFragmentTabHost.this.ipf = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.ipf.cR(48);
                    ScrollFragmentTabHost.this.ipf.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.ipf.sV(4);
                    ScrollFragmentTabHost.this.ipf.cT(i);
                    ScrollFragmentTabHost.this.ipf.mk(true);
                    ScrollFragmentTabHost.this.ipf.sZ(0);
                    ScrollFragmentTabHost.this.ipf.DY(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.ipc = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.ipd == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bud();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.ipd.ciF();
                } else if (!com.baidu.tbadk.a.d.aNV() && ScrollFragmentTabHost.this.ipd.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.ipd.ciF();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aXG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
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
        this.ipg = new com.baidu.tieba.homepage.framework.indicator.b();
        this.iph = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.e
            public void wU(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.ioV.wW(i), false);
                ScrollFragmentTabHost.this.ioV.wY(i);
            }
        };
        this.ipi = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.d
            public void wT(int i) {
                ScrollFragmentTabHost.this.ipg.a(i, ScrollFragmentTabHost.this.iph);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.ipd = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.ipe = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.ioS = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.hcq = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.fns = (NoNetworkView) findViewById(R.id.view_no_network);
        this.dkf = (FrameLayout) findViewById(R.id.home_pager_container);
        this.dSy = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.eVD = findViewById(R.id.divider_line);
        this.fpG = findViewById(R.id.divider_shadow);
        this.ioT = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.ioT.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.ipd.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.dkf.getLayoutParams()).topMargin = 0;
        this.ioS.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.ioV.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.ioW != null) {
                    ScrollFragmentTabHost.this.ioW.xd(i);
                }
                com.baidu.tbadk.core.bigday.b.aPI().gQ(ScrollFragmentTabHost.this.ioV.wV(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.xc(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.ioY != null && ScrollFragmentTabHost.this.ioV != null) {
                    int wV = ScrollFragmentTabHost.this.ioV.wV(ScrollFragmentTabHost.this.dSy.getCurrentItem());
                    if (wV == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.ioY) {
                            aVar.ciD();
                        }
                    } else if (wV == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.ioY) {
                            aVar2.ciC();
                        }
                    } else if (wV == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.ioY) {
                            aVar3.chY();
                        }
                    } else if (wV == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (wV == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (wV == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.bud();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.xc(i));
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean cit = ScrollFragmentTabHost.this.cit();
                    TiebaStatic.log(new ao("c12350").ag("obj_type", cit ? 1 : 0));
                    if (cit && ScrollFragmentTabHost.this.ioV != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.ioV.cir();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.ioS.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void k(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.dSy.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.xc(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.xc(i) == 7) {
                    TiebaStatic.log(new ao("c13483").dk("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.xc(i) == 8) {
                    TiebaStatic.log(new ao("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.xc(i));
            }
        });
        this.ipd.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void ot(boolean z) {
                if (z && ScrollFragmentTabHost.this.ipf != null) {
                    ScrollFragmentTabHost.this.ipf.HH();
                }
            }
        });
        this.ipe.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void Ga(String str) {
                if (ScrollFragmentTabHost.this.ipf != null) {
                    ScrollFragmentTabHost.this.ipf.HH();
                    ScrollFragmentTabHost.this.ipf = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    bc.aWU().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.ipe.setVisibility(8);
            this.ioS.setMissionEntranceVisibility(true);
            this.ioS.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void Ga(String str) {
                    if (ScrollFragmentTabHost.this.ipf != null) {
                        ScrollFragmentTabHost.this.ipf.HH();
                        ScrollFragmentTabHost.this.ipf = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        bc.aWU().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.ipe.setVisibility(0);
        this.ioS.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.ipc.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.ipc);
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
        this.fns.a(aVar);
        MessageManager.getInstance().registerListener(this.ioZ);
        MessageManager.getInstance().registerListener(this.ipa);
        this.ipb.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.ipb);
    }

    public void notifyDataSetChanged() {
        if (this.ioV != null && !HomePageStatic.ilv) {
            this.dSy.setAdapter(this.ioV);
            this.ioS.notifyDataSetChanged();
            this.ipg.a(this.iph);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ioV != null) {
            this.ioV.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ioV != null) {
            this.ioV.d(dataRes, z);
        }
    }

    public void ciq() {
        if (this.ioV != null) {
            this.ioV.ciq();
        }
    }

    public void x(String str, int i, int i2) {
        if (this.dSy != null) {
            this.ioV.x(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.ioV = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.ioV.setScrollFragmentTabHost(this);
        this.dSy.setOffscreenPageLimit(2);
        this.dSy.setAdapter(this.ioV);
        int cio = this.ioV.cio();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.ioV;
        if (HomePageStatic.ilv) {
            cio = 0;
        }
        this.dSy.setCurrentItem(newScrollFragmentAdapter.wW(cio));
        this.ioS.setViewPager(this.dSy);
        this.ioS.setConcernTabIndex(this.ioV.wW(0));
    }

    public boolean cix() {
        return this.ioV != null && this.ioV.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.ioV.getCount()) {
            this.ioS.setTabItemClicked(z);
            this.ioV.wZ(i);
            this.dSy.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.ioV.wW(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.ioV.wW(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.ioV.Gb(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ioS.setPageUniqueId(bdUniqueId);
        this.ioZ.setTag(bdUniqueId);
        this.ipa.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.dkf;
    }

    public int getCurrentTabType() {
        return this.ioV.wV(this.dSy.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.dSy.getAdapter() != null) {
            int count = this.dSy.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.ioV.wV(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int xc(int i) {
        return this.ioV.wV(i);
    }

    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this.ipd, R.color.cp_bg_line_h);
        this.ipe.onChangeSkinType();
        this.ioS.onChangeSkinType();
        if (this.mPageContext != null && this.fns != null) {
            this.fns.onChangeSkinType(this.mPageContext, i);
        }
        if (this.ioV != null) {
            this.ioV.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.hcq != null) {
            this.hcq.onChangeSkinType(this.mPageContext, i);
        }
        an.setBackgroundColor(this.eVD, R.color.cp_bg_line_c);
        an.setBackgroundResource(this.fpG, R.drawable.personalize_tab_shadow);
    }

    private boolean bub() {
        return this.fpG.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.ioU = z;
        if (z) {
            if (this.eVD != null) {
                this.eVD.setVisibility(8);
            }
        } else if (this.eVD != null) {
            this.eVD.setVisibility(0);
        }
    }

    public void buc() {
        if (this.ioU && !bub()) {
            this.fpG.setVisibility(0);
            if (this.fpJ == null) {
                this.fpJ = new AlphaAnimation(0.0f, 1.0f);
                this.fpJ.setFillAfter(true);
                this.fpJ.setDuration(300L);
            }
            this.fpG.startAnimation(this.fpJ);
        }
    }

    public void bud() {
        if (this.ioU && bub()) {
            if (this.fpK == null) {
                this.fpK = new AlphaAnimation(1.0f, 0.0f);
                this.fpK.setFillAfter(true);
                this.fpK.setDuration(300L);
                this.fpK.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.fpG.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fpG.startAnimation(this.fpK);
        }
    }

    public void cis() {
        if (this.ioV != null) {
            this.ioV.cis();
        }
    }

    public void buH() {
        this.ioV.buH();
    }

    public String getCurrentPageKey() {
        if (this.ioV != null) {
            return this.ioV.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.dSy != null) {
            return this.dSy.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.ioV != null) {
            this.ioV.setPrimary(z);
        }
        if (this.fns != null && z) {
            this.fns.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void ciy() {
        this.ioV.a(this.ipi);
    }

    public void ni(boolean z) {
    }

    public void ciz() {
        if (this.ipd != null && !this.ipd.isSticky() && this.ioS != null && this.ioS.getTaskView() != null && this.ioS.getTaskView().getVisibility() != 0) {
            this.ioS.ciH();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.ioW = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.ipf != null) {
            this.ipf.HH();
            this.ipf = null;
        }
        ciB();
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.ioS != null && this.ioV.cip()) {
            this.ioS.setShowConcernRedTip(z);
        }
    }

    public boolean cit() {
        if (this.ioS == null || !this.ioV.cip()) {
            return false;
        }
        return this.ioS.cit();
    }

    public void setVideoThreadId(String str) {
        if (this.ioV != null) {
            this.ioV.setVideoThreadId(str);
        }
    }

    public void ciA() {
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int wW = this.ioV != null ? this.ioV.wW(0) : 0;
            if (this.ioX == null) {
                this.ioX = new e(this.mPageContext, this.ioS.xa(wW));
                this.ioX.cS(R.drawable.bg_tip_blue_up);
                this.ioX.cR(32);
                this.ioX.mk(true);
                this.ioX.setUseDirectOffset(true);
                this.ioX.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.ioX.cT(4000);
            }
            this.ioX.z(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void ciB() {
        if (this.ioX != null) {
            this.ioX.HH();
        }
    }

    public void onResume() {
        if (this.ioS != null) {
            this.ioS.onResume();
        }
    }

    public void a(a aVar) {
        if (this.ioY == null) {
            this.ioY = new ArrayList();
        }
        this.ioY.add(aVar);
    }

    public void b(a aVar) {
        if (this.ioY != null && this.ioY.size() > 0) {
            this.ioY.remove(aVar);
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class a {
        public void ciC() {
        }

        public void ciD() {
        }

        public void chY() {
        }
    }
}
