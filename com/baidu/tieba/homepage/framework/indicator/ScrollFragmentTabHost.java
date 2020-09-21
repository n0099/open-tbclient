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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.baidu.tbadk.core.util.SvgManager;
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
/* loaded from: classes21.dex */
public class ScrollFragmentTabHost extends RelativeLayout {
    private View.OnClickListener aBS;
    private FrameLayout dCg;
    private CustomViewPager ekP;
    private NoNetworkView fHl;
    private AlphaAnimation fJC;
    private AlphaAnimation fJD;
    private View fJz;
    private View fpN;
    private PluginErrorTipView hCk;
    private HomeTabBarView iRT;
    private TBSpecificationBtn iRU;
    private boolean iRV;
    private NewScrollFragmentAdapter iRW;
    private b iRX;
    private e iRY;
    private List<a> iRZ;
    private boolean iSa;
    CustomMessageListener iSb;
    CustomMessageListener iSc;
    CustomMessageListener iSd;
    CustomMessageListener iSe;
    CustomMessageListener iSf;
    CustomMessageTask iSg;
    CustomMessageTask iSh;
    private StickyAppBarLayout iSi;
    private NestedScrollHeader iSj;
    private e iSk;
    private com.baidu.tieba.homepage.concern.b iSl;
    private boolean iSm;
    private com.baidu.tieba.homepage.framework.indicator.b iSn;
    private com.baidu.tieba.homepage.framework.e iSo;
    private d iSp;
    private boolean isPrimary;
    private Context mContext;
    private TbPageContext mPageContext;

    /* loaded from: classes21.dex */
    public interface b {
        void Aq(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.iSa = false;
        this.iSb = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bHC();
                } else {
                    ScrollFragmentTabHost.this.bHD();
                }
            }
        };
        this.iSc = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.iSk != null) {
                    ScrollFragmentTabHost.this.iSk.Oj();
                    ScrollFragmentTabHost.this.iSk = null;
                }
            }
        };
        this.iSd = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.iRT.An(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 1) {
                                SvgManager.bkl().a((ImageView) linearLayout2.getChildAt(1), R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                            }
                        }
                        ScrollFragmentTabHost.this.iSl.a(ScrollFragmentTabHost.this.iSi);
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 1) {
                            SvgManager.bkl().a((ImageView) linearLayout3.getChildAt(1), R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                        }
                    }
                }
            }
        };
        this.iSe = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.iSm != com.baidu.tbadk.a.d.bbc()) {
                    ScrollFragmentTabHost.this.iRT.notifyDataSetChanged();
                }
            }
        };
        this.iSf = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.iRT.An(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 0 && (linearLayout2.getChildAt(0) instanceof TextView)) {
                                ((TextView) linearLayout2.getChildAt(0)).setText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person));
                                com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_home_concern_all_status", 1);
                            }
                        }
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 0 && (linearLayout3.getChildAt(0) instanceof TextView)) {
                            ((TextView) linearLayout3.getChildAt(0)).setText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention));
                            com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.iSg = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.iSi == null || ScrollFragmentTabHost.this.iSj == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.iRT.getTaskView() : ScrollFragmentTabHost.this.iSj.getTaskView();
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
                    if (ScrollFragmentTabHost.this.iSk != null) {
                        ScrollFragmentTabHost.this.iSk.Oj();
                    }
                    ScrollFragmentTabHost.this.iSk = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.iSk.eV(48);
                    ScrollFragmentTabHost.this.iSk.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.iSk.setAnchor(4);
                    ScrollFragmentTabHost.this.iSk.eX(i);
                    ScrollFragmentTabHost.this.iSk.nA(true);
                    ScrollFragmentTabHost.this.iSk.we(0);
                    ScrollFragmentTabHost.this.iSk.HG(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.iSh = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.iSi == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bHD();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.iSi.cAz();
                } else if (ScrollFragmentTabHost.this.iSi.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.iSi.cAz();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aBS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
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
        this.iSn = new com.baidu.tieba.homepage.framework.indicator.b();
        this.iSo = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.e
            public void Ah(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.iRW.Aj(i), false);
                ScrollFragmentTabHost.this.iRW.Al(i);
            }
        };
        this.iSp = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.d
            public void Ag(int i) {
                ScrollFragmentTabHost.this.iSn.a(i, ScrollFragmentTabHost.this.iSo);
            }
        };
        init();
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iSa = false;
        this.iSb = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bHC();
                } else {
                    ScrollFragmentTabHost.this.bHD();
                }
            }
        };
        this.iSc = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.iSk != null) {
                    ScrollFragmentTabHost.this.iSk.Oj();
                    ScrollFragmentTabHost.this.iSk = null;
                }
            }
        };
        this.iSd = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.iRT.An(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 1) {
                                SvgManager.bkl().a((ImageView) linearLayout2.getChildAt(1), R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                            }
                        }
                        ScrollFragmentTabHost.this.iSl.a(ScrollFragmentTabHost.this.iSi);
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 1) {
                            SvgManager.bkl().a((ImageView) linearLayout3.getChildAt(1), R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                        }
                    }
                }
            }
        };
        this.iSe = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.iSm != com.baidu.tbadk.a.d.bbc()) {
                    ScrollFragmentTabHost.this.iRT.notifyDataSetChanged();
                }
            }
        };
        this.iSf = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.iRT.An(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 0 && (linearLayout2.getChildAt(0) instanceof TextView)) {
                                ((TextView) linearLayout2.getChildAt(0)).setText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person));
                                com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_home_concern_all_status", 1);
                            }
                        }
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 0 && (linearLayout3.getChildAt(0) instanceof TextView)) {
                            ((TextView) linearLayout3.getChildAt(0)).setText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention));
                            com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.iSg = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.iSi == null || ScrollFragmentTabHost.this.iSj == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.iRT.getTaskView() : ScrollFragmentTabHost.this.iSj.getTaskView();
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
                    if (ScrollFragmentTabHost.this.iSk != null) {
                        ScrollFragmentTabHost.this.iSk.Oj();
                    }
                    ScrollFragmentTabHost.this.iSk = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.iSk.eV(48);
                    ScrollFragmentTabHost.this.iSk.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.iSk.setAnchor(4);
                    ScrollFragmentTabHost.this.iSk.eX(i);
                    ScrollFragmentTabHost.this.iSk.nA(true);
                    ScrollFragmentTabHost.this.iSk.we(0);
                    ScrollFragmentTabHost.this.iSk.HG(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.iSh = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.iSi == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bHD();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.iSi.cAz();
                } else if (ScrollFragmentTabHost.this.iSi.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.iSi.cAz();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aBS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
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
        this.iSn = new com.baidu.tieba.homepage.framework.indicator.b();
        this.iSo = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.e
            public void Ah(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.iRW.Aj(i), false);
                ScrollFragmentTabHost.this.iRW.Al(i);
            }
        };
        this.iSp = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.d
            public void Ag(int i) {
                ScrollFragmentTabHost.this.iSn.a(i, ScrollFragmentTabHost.this.iSo);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.iSi = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.iSj = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.iRT = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.hCk = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.fHl = (NoNetworkView) findViewById(R.id.view_no_network);
        this.dCg = (FrameLayout) findViewById(R.id.home_pager_container);
        this.ekP = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.fpN = findViewById(R.id.divider_line);
        this.fJz = findViewById(R.id.divider_shadow);
        this.iRU = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.iRU.setVisibility(8);
        this.iSl = new com.baidu.tieba.homepage.concern.b(this.mContext);
        this.iSm = com.baidu.tbadk.a.d.bbc();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.iSi.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.dCg.getLayoutParams()).topMargin = 0;
        this.iRT.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.iRW.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.iRX != null) {
                    ScrollFragmentTabHost.this.iRX.Aq(i);
                }
                com.baidu.tbadk.core.bigday.b.bcO().hO(ScrollFragmentTabHost.this.iRW.Ai(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.Ap(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                int Ai = ScrollFragmentTabHost.this.iRW.Ai(ScrollFragmentTabHost.this.ekP.getCurrentItem());
                if (Ai == 5) {
                    if (ScrollFragmentTabHost.this.iSa) {
                        ScrollFragmentTabHost.this.iSa = false;
                    } else {
                        aq aqVar = new aq("c13740");
                        aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar.ai("obj_type", ScrollFragmentTabHost.this.cAl() ? 1 : 0);
                        aqVar.bki();
                    }
                }
                if (Ai == 0) {
                    ScrollFragmentTabHost.this.cAv();
                }
                View An = ScrollFragmentTabHost.this.iRT.An(0);
                if ((An instanceof LinearLayout) && TbadkCoreApplication.isLogin() && com.baidu.tbadk.a.d.bbc()) {
                    LinearLayout linearLayout = (LinearLayout) An;
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                        if (Ai == 0) {
                            imageView.setVisibility(0);
                        } else {
                            imageView.setVisibility(4);
                        }
                    }
                }
                if (ScrollFragmentTabHost.this.iRZ != null && ScrollFragmentTabHost.this.iRW != null) {
                    int Ai2 = ScrollFragmentTabHost.this.iRW.Ai(ScrollFragmentTabHost.this.ekP.getCurrentItem());
                    if (Ai2 == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.iRZ) {
                            aVar.cAx();
                        }
                    } else if (Ai2 == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.iRZ) {
                            aVar2.cAw();
                        }
                    } else if (Ai2 == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.iRZ) {
                            aVar3.czC();
                        }
                    } else if (Ai2 == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (Ai2 == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (Ai2 == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.bHD();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.Ap(i));
                if (ScrollFragmentTabHost.this.Ap(i) == 5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.bjf().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.bjf().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.iRT.cAl()) {
                        ScrollFragmentTabHost.this.iRT.setShowHotTopicRedTip(false);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean cAk = ScrollFragmentTabHost.this.cAk();
                    TiebaStatic.log(new aq("c12350").ai("obj_type", cAk ? 1 : 0));
                    if (cAk && ScrollFragmentTabHost.this.iRW != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.iRW.cAi();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.iRT.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void m(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.ekP.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.Ap(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.Ap(i) == 7) {
                    TiebaStatic.log(new aq("c13483").dF("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.Ap(i) == 8) {
                    TiebaStatic.log(new aq("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.Ap(i));
                if (ScrollFragmentTabHost.this.Ap(i) == 5) {
                    aq aqVar = new aq("c13740");
                    aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.ai("obj_type", ScrollFragmentTabHost.this.cAl() ? 1 : 0);
                    aqVar.bki();
                    ScrollFragmentTabHost.this.iSa = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.bjf().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.bjf().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.iRT.cAl()) {
                        ScrollFragmentTabHost.this.iRT.setShowHotTopicRedTip(false);
                    }
                }
            }
        });
        this.iSi.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void pN(boolean z) {
                if (z && ScrollFragmentTabHost.this.iSk != null) {
                    ScrollFragmentTabHost.this.iSk.Oj();
                }
            }
        });
        this.iSj.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void Kf(String str) {
                if (ScrollFragmentTabHost.this.iSk != null) {
                    ScrollFragmentTabHost.this.iSk.Oj();
                    ScrollFragmentTabHost.this.iSk = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    be.bkp().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.iSj.setVisibility(8);
            this.iRT.setMissionEntranceVisibility(true);
            this.iRT.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void Kf(String str) {
                    if (ScrollFragmentTabHost.this.iSk != null) {
                        ScrollFragmentTabHost.this.iSk.Oj();
                        ScrollFragmentTabHost.this.iSk = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        be.bkp().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.iSj.setVisibility(0);
        this.iRT.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.iSh.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.iSh);
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
        this.fHl.a(aVar);
        MessageManager.getInstance().registerListener(this.iSb);
        MessageManager.getInstance().registerListener(this.iSc);
        MessageManager.getInstance().registerListener(this.iSf);
        MessageManager.getInstance().registerListener(this.iSd);
        MessageManager.getInstance().registerListener(this.iSe);
        this.iSg.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.iSg);
    }

    public void notifyDataSetChanged() {
        if (this.iRW != null && !HomePageStatic.iNq) {
            this.ekP.setAdapter(this.iRW);
            this.iRT.notifyDataSetChanged();
            this.iSn.a(this.iSo);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.iRW != null) {
            this.iRW.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.iRW != null) {
            this.iRW.d(dataRes, z);
        }
    }

    public void cAh() {
        if (this.iRW != null) {
            this.iRW.cAh();
        }
    }

    public void w(String str, int i, int i2) {
        if (this.ekP != null) {
            this.iRW.w(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.iRW = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.iRW.setScrollFragmentTabHost(this);
        this.ekP.setOffscreenPageLimit(2);
        this.ekP.setAdapter(this.iRW);
        int cAe = this.iRW.cAe();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.iRW;
        if (HomePageStatic.iNq) {
            cAe = 0;
        }
        this.ekP.setCurrentItem(newScrollFragmentAdapter.Aj(cAe));
        this.iRT.setViewPager(this.ekP);
        this.iRT.setConcernTabIndex(this.iRW.Aj(0));
        this.iRT.setHotTopicTabIndex(this.iRW.Aj(5));
        this.iRT.setShowHotTopicRedTip(cAp());
    }

    private boolean cAp() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            if (currentTimeMillis - com.baidu.tbadk.core.sharedPref.b.bjf().getLong("unlogin_hot_top_timestamp", 0L) >= 86400000) {
                return true;
            }
        } else {
            long j = com.baidu.tbadk.core.sharedPref.b.bjf().getLong(TbadkApplication.getCurrentAccount(), 0L);
            if (!StringUtils.isNull(TbadkApplication.getCurrentAccount()) && currentTimeMillis - j >= 86400000) {
                return true;
            }
        }
        return false;
    }

    public boolean cAq() {
        return this.iRW != null && this.iRW.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.iRW.getCount()) {
            this.iRT.setTabItemClicked(z);
            this.iRW.Am(i);
            this.ekP.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.iRW.Aj(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.iRW.Aj(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.iRW.Kg(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iRT.setPageUniqueId(bdUniqueId);
        this.iSb.setTag(bdUniqueId);
        this.iSc.setTag(bdUniqueId);
        this.iSf.setTag(bdUniqueId);
        this.iSd.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.dCg;
    }

    public int getCurrentTabType() {
        return this.iRW.Ai(this.ekP.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.ekP.getAdapter() != null) {
            int count = this.ekP.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.iRW.Ai(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int Ap(int i) {
        return this.iRW.Ai(i);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.iSi, R.color.cp_bg_line_h);
        this.iSj.onChangeSkinType();
        this.iRT.onChangeSkinType();
        if (this.mPageContext != null && this.fHl != null) {
            this.fHl.onChangeSkinType(this.mPageContext, i);
        }
        if (this.iRW != null) {
            this.iRW.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.hCk != null) {
            this.hCk.onChangeSkinType(this.mPageContext, i);
        }
        if (this.iSl != null) {
            this.iSl.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this.fpN, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.fJz, R.drawable.personalize_tab_shadow);
    }

    private boolean bHB() {
        return this.fJz.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.iRV = z;
        if (z) {
            if (this.fpN != null) {
                this.fpN.setVisibility(8);
            }
        } else if (this.fpN != null) {
            this.fpN.setVisibility(0);
        }
    }

    public void bHC() {
        if (this.iRV && !bHB()) {
            this.fJz.setVisibility(0);
            if (this.fJC == null) {
                this.fJC = new AlphaAnimation(0.0f, 1.0f);
                this.fJC.setFillAfter(true);
                this.fJC.setDuration(300L);
            }
            this.fJz.startAnimation(this.fJC);
        }
    }

    public void bHD() {
        if (this.iRV && bHB()) {
            if (this.fJD == null) {
                this.fJD = new AlphaAnimation(1.0f, 0.0f);
                this.fJD.setFillAfter(true);
                this.fJD.setDuration(300L);
                this.fJD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.fJz.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fJz.startAnimation(this.fJD);
        }
    }

    public void cAj() {
        if (this.iRW != null) {
            this.iRW.cAj();
        }
    }

    public void bIh() {
        this.iRW.bIh();
    }

    public String getCurrentPageKey() {
        if (this.iRW != null) {
            return this.iRW.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.ekP != null) {
            return this.ekP.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.iRW != null) {
            this.iRW.setPrimary(z);
        }
        if (this.fHl != null && z) {
            this.fHl.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cAr() {
        this.iRW.a(this.iSp);
    }

    public void oz(boolean z) {
    }

    public void cAs() {
        if (this.iSi != null && !this.iSi.isSticky() && this.iRT != null && this.iRT.getTaskView() != null && this.iRT.getTaskView().getVisibility() != 0) {
            this.iRT.cAB();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.iRX = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.iSk != null) {
            this.iSk.Oj();
            this.iSk = null;
        }
        cAv();
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.iRT != null && this.iRW.cAf()) {
            this.iRT.setShowConcernRedTip(z);
        }
    }

    public boolean cAk() {
        if (this.iRT == null || !this.iRW.cAf()) {
            return false;
        }
        return this.iRT.cAk();
    }

    public boolean cAl() {
        if (this.iRT == null || this.iRW == null || !this.iRW.cAg()) {
            return false;
        }
        return this.iRT.cAl();
    }

    public void setVideoThreadId(String str) {
        if (this.iRW != null) {
            this.iRW.setVideoThreadId(str);
        }
    }

    public void cAt() {
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int Aj = this.iRW != null ? this.iRW.Aj(0) : 0;
            if (this.iRY == null) {
                this.iRY = new e(this.mPageContext, this.iRT.An(Aj));
                this.iRY.eW(R.drawable.bg_tip_blue_up);
                this.iRY.eV(32);
                this.iRY.nA(true);
                this.iRY.setUseDirectOffset(true);
                this.iRY.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.iRY.eX(4000);
            }
            this.iRY.y(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cAu() {
        if (TbadkCoreApplication.isLogin()) {
            int Aj = this.iRW != null ? this.iRW.Aj(0) : 0;
            if (this.iRY == null) {
                this.iRY = new e(this.mPageContext, this.iRT.An(Aj));
                this.iRY.eW(R.drawable.bg_tip_blue_up_left);
                this.iRY.eV(16);
                this.iRY.nA(true);
                this.iRY.we(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.iRY.setUseDirectOffset(true);
                this.iRY.eX(4000);
            }
            this.iRY.aG(this.mContext.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void cAv() {
        if (this.iRY != null) {
            this.iRY.Oj();
        }
    }

    public void onResume() {
        if (this.iRT != null) {
            this.iRT.onResume();
        }
    }

    public void a(a aVar) {
        if (this.iRZ == null) {
            this.iRZ = new ArrayList();
        }
        this.iRZ.add(aVar);
    }

    public void b(a aVar) {
        if (this.iRZ != null && this.iRZ.size() > 0) {
            this.iRZ.remove(aVar);
        }
    }

    /* loaded from: classes21.dex */
    public static abstract class a {
        public void cAw() {
        }

        public void cAx() {
        }

        public void czC() {
        }
    }
}
