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
import com.baidu.tbadk.youngster.b.c;
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
/* loaded from: classes22.dex */
public class ScrollFragmentTabHost extends RelativeLayout {
    private View.OnClickListener aEX;
    private FrameLayout dOh;
    private CustomViewPager ewX;
    private View fCa;
    private NoNetworkView fTu;
    private View fVQ;
    private AlphaAnimation fVT;
    private AlphaAnimation fVU;
    private PluginErrorTipView hRf;
    private boolean isPrimary;
    private HomeTabBarView jgQ;
    private TBSpecificationBtn jgR;
    private boolean jgS;
    private NewScrollFragmentAdapter jgT;
    private b jgU;
    private e jgV;
    private List<a> jgW;
    private boolean jgX;
    CustomMessageListener jgY;
    CustomMessageListener jgZ;
    CustomMessageListener jha;
    CustomMessageListener jhb;
    CustomMessageListener jhc;
    CustomMessageTask jhd;
    CustomMessageTask jhe;
    private StickyAppBarLayout jhf;
    private NestedScrollHeader jhg;
    private e jhh;
    private com.baidu.tieba.homepage.concern.b jhi;
    private boolean jhj;
    private com.baidu.tieba.homepage.framework.indicator.b jhk;
    private com.baidu.tieba.homepage.framework.e jhl;
    private d jhm;
    private Context mContext;
    private TbPageContext mPageContext;
    CustomMessageListener mYoungsterModeChangeListener;

    /* loaded from: classes22.dex */
    public interface b {
        void AW(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.jgX = false;
        this.jgY = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bKo();
                } else {
                    ScrollFragmentTabHost.this.bKp();
                }
            }
        };
        this.jgZ = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.jhh != null) {
                    ScrollFragmentTabHost.this.jhh.Po();
                    ScrollFragmentTabHost.this.jhh = null;
                }
            }
        };
        this.jha = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jgQ.AT(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 1) {
                                SvgManager.bmU().a((ImageView) linearLayout2.getChildAt(1), R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                            }
                        }
                        ScrollFragmentTabHost.this.jhi.a(ScrollFragmentTabHost.this.jhf);
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 1) {
                            SvgManager.bmU().a((ImageView) linearLayout3.getChildAt(1), R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                        }
                    }
                }
            }
        };
        this.jhb = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.jhj != com.baidu.tbadk.a.d.bdK()) {
                    ScrollFragmentTabHost.this.jgQ.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bdK() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cEc();
                        ScrollFragmentTabHost.this.cEb();
                    }
                }
            }
        };
        this.jhc = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jgQ.AT(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 0 && (linearLayout2.getChildAt(0) instanceof TextView)) {
                                ((TextView) linearLayout2.getChildAt(0)).setText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person));
                                com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_home_concern_all_status", 1);
                            }
                        }
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 0 && (linearLayout3.getChildAt(0) instanceof TextView)) {
                            ((TextView) linearLayout3.getChildAt(0)).setText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention));
                            com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.jgT != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.jgT.cDQ();
                    if (!booleanValue || !c.bDa()) {
                        ScrollFragmentTabHost.this.jgT.cDI();
                    } else {
                        ScrollFragmentTabHost.this.jgT.cDH();
                    }
                    ScrollFragmentTabHost.this.jgQ.notifyDataSetChanged();
                }
            }
        };
        this.jhd = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.jhf == null || ScrollFragmentTabHost.this.jhg == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.jgQ.getTaskView() : ScrollFragmentTabHost.this.jhg.getTaskView();
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
                    if (ScrollFragmentTabHost.this.jhh != null) {
                        ScrollFragmentTabHost.this.jhh.Po();
                    }
                    ScrollFragmentTabHost.this.jhh = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.jhh.fe(48);
                    ScrollFragmentTabHost.this.jhh.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.jhh.setAnchor(4);
                    ScrollFragmentTabHost.this.jhh.fg(i);
                    ScrollFragmentTabHost.this.jhh.of(true);
                    ScrollFragmentTabHost.this.jhh.wK(0);
                    ScrollFragmentTabHost.this.jhh.It(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.jhe = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.jhf == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bKp();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.jhf.cEg();
                } else if (ScrollFragmentTabHost.this.jhf.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.jhf.cEg();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
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
        this.jhk = new com.baidu.tieba.homepage.framework.indicator.b();
        this.jhl = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void AN(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.jgT.AP(i), false);
                ScrollFragmentTabHost.this.jgT.AR(i);
            }
        };
        this.jhm = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void AM(int i) {
                ScrollFragmentTabHost.this.jhk.a(i, ScrollFragmentTabHost.this.jhl);
            }
        };
        init();
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jgX = false;
        this.jgY = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bKo();
                } else {
                    ScrollFragmentTabHost.this.bKp();
                }
            }
        };
        this.jgZ = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.jhh != null) {
                    ScrollFragmentTabHost.this.jhh.Po();
                    ScrollFragmentTabHost.this.jhh = null;
                }
            }
        };
        this.jha = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jgQ.AT(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 1) {
                                SvgManager.bmU().a((ImageView) linearLayout2.getChildAt(1), R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                            }
                        }
                        ScrollFragmentTabHost.this.jhi.a(ScrollFragmentTabHost.this.jhf);
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 1) {
                            SvgManager.bmU().a((ImageView) linearLayout3.getChildAt(1), R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                        }
                    }
                }
            }
        };
        this.jhb = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.jhj != com.baidu.tbadk.a.d.bdK()) {
                    ScrollFragmentTabHost.this.jgQ.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bdK() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cEc();
                        ScrollFragmentTabHost.this.cEb();
                    }
                }
            }
        };
        this.jhc = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jgQ.AT(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 0 && (linearLayout2.getChildAt(0) instanceof TextView)) {
                                ((TextView) linearLayout2.getChildAt(0)).setText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person));
                                com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_home_concern_all_status", 1);
                            }
                        }
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 0 && (linearLayout3.getChildAt(0) instanceof TextView)) {
                            ((TextView) linearLayout3.getChildAt(0)).setText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention));
                            com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.jgT != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.jgT.cDQ();
                    if (!booleanValue || !c.bDa()) {
                        ScrollFragmentTabHost.this.jgT.cDI();
                    } else {
                        ScrollFragmentTabHost.this.jgT.cDH();
                    }
                    ScrollFragmentTabHost.this.jgQ.notifyDataSetChanged();
                }
            }
        };
        this.jhd = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.jhf == null || ScrollFragmentTabHost.this.jhg == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.jgQ.getTaskView() : ScrollFragmentTabHost.this.jhg.getTaskView();
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
                    if (ScrollFragmentTabHost.this.jhh != null) {
                        ScrollFragmentTabHost.this.jhh.Po();
                    }
                    ScrollFragmentTabHost.this.jhh = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.jhh.fe(48);
                    ScrollFragmentTabHost.this.jhh.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.jhh.setAnchor(4);
                    ScrollFragmentTabHost.this.jhh.fg(i);
                    ScrollFragmentTabHost.this.jhh.of(true);
                    ScrollFragmentTabHost.this.jhh.wK(0);
                    ScrollFragmentTabHost.this.jhh.It(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.jhe = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.jhf == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bKp();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.jhf.cEg();
                } else if (ScrollFragmentTabHost.this.jhf.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.jhf.cEg();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
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
        this.jhk = new com.baidu.tieba.homepage.framework.indicator.b();
        this.jhl = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void AN(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.jgT.AP(i), false);
                ScrollFragmentTabHost.this.jgT.AR(i);
            }
        };
        this.jhm = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void AM(int i) {
                ScrollFragmentTabHost.this.jhk.a(i, ScrollFragmentTabHost.this.jhl);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.jhf = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.jhg = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.jgQ = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.hRf = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.fTu = (NoNetworkView) findViewById(R.id.view_no_network);
        this.dOh = (FrameLayout) findViewById(R.id.home_pager_container);
        this.ewX = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.fCa = findViewById(R.id.divider_line);
        this.fVQ = findViewById(R.id.divider_shadow);
        this.jgR = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.jgR.setVisibility(8);
        this.jhi = new com.baidu.tieba.homepage.concern.b(this.mContext);
        this.jhj = com.baidu.tbadk.a.d.bdK();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.jhf.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.dOh.getLayoutParams()).topMargin = 0;
        this.jgQ.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.jgT.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.jgU != null) {
                    ScrollFragmentTabHost.this.jgU.AW(i);
                }
                com.baidu.tbadk.core.bigday.b.bfw().ik(ScrollFragmentTabHost.this.jgT.AO(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.AV(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                int AO = ScrollFragmentTabHost.this.jgT.AO(ScrollFragmentTabHost.this.ewX.getCurrentItem());
                if (AO == 5) {
                    if (ScrollFragmentTabHost.this.jgX) {
                        ScrollFragmentTabHost.this.jgX = false;
                    } else {
                        aq aqVar = new aq("c13740");
                        aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar.aj("obj_type", ScrollFragmentTabHost.this.cDS() ? 1 : 0);
                        aqVar.bmR();
                    }
                }
                if (AO == 0) {
                    ScrollFragmentTabHost.this.cEc();
                }
                View AT = ScrollFragmentTabHost.this.jgQ.AT(0);
                if ((AT instanceof LinearLayout) && TbadkCoreApplication.isLogin() && com.baidu.tbadk.a.d.bdK()) {
                    LinearLayout linearLayout = (LinearLayout) AT;
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                        if (AO == 0) {
                            imageView.setVisibility(0);
                        } else {
                            imageView.setVisibility(4);
                        }
                    }
                }
                if (ScrollFragmentTabHost.this.jgW != null && ScrollFragmentTabHost.this.jgT != null) {
                    int AO2 = ScrollFragmentTabHost.this.jgT.AO(ScrollFragmentTabHost.this.ewX.getCurrentItem());
                    if (AO2 == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.jgW) {
                            aVar.cEe();
                        }
                    } else if (AO2 == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.jgW) {
                            aVar2.cEd();
                        }
                    } else if (AO2 == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.jgW) {
                            aVar3.cCZ();
                        }
                    } else if (AO2 == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (AO2 == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (AO2 == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.bKp();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.AV(i));
                if (ScrollFragmentTabHost.this.AV(i) == 5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.blO().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.blO().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.jgQ.cDS()) {
                        ScrollFragmentTabHost.this.jgQ.setShowHotTopicRedTip(false);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean cDR = ScrollFragmentTabHost.this.cDR();
                    TiebaStatic.log(new aq("c12350").aj("obj_type", cDR ? 1 : 0));
                    if (cDR && ScrollFragmentTabHost.this.jgT != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.jgT.cDO();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.jgQ.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void n(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.ewX.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.AV(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.AV(i) == 7) {
                    TiebaStatic.log(new aq("c13483").dK("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.AV(i) == 8) {
                    TiebaStatic.log(new aq("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.AV(i));
                if (ScrollFragmentTabHost.this.AV(i) == 5) {
                    aq aqVar = new aq("c13740");
                    aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.aj("obj_type", ScrollFragmentTabHost.this.cDS() ? 1 : 0);
                    aqVar.bmR();
                    ScrollFragmentTabHost.this.jgX = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.blO().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.blO().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.jgQ.cDS()) {
                        ScrollFragmentTabHost.this.jgQ.setShowHotTopicRedTip(false);
                    }
                }
            }
        });
        this.jhf.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void qt(boolean z) {
                if (z && ScrollFragmentTabHost.this.jhh != null) {
                    ScrollFragmentTabHost.this.jhh.Po();
                }
            }
        });
        this.jhg.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void KU(String str) {
                if (ScrollFragmentTabHost.this.jhh != null) {
                    ScrollFragmentTabHost.this.jhh.Po();
                    ScrollFragmentTabHost.this.jhh = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    be.bmY().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.jhg.setVisibility(8);
            this.jgQ.setMissionEntranceVisibility(true);
            this.jgQ.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void KU(String str) {
                    if (ScrollFragmentTabHost.this.jhh != null) {
                        ScrollFragmentTabHost.this.jhh.Po();
                        ScrollFragmentTabHost.this.jhh = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        be.bmY().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.jhg.setVisibility(0);
        this.jgQ.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.jhe.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.jhe);
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
        this.fTu.a(aVar);
        MessageManager.getInstance().registerListener(this.jgY);
        MessageManager.getInstance().registerListener(this.jgZ);
        MessageManager.getInstance().registerListener(this.jhc);
        MessageManager.getInstance().registerListener(this.jha);
        MessageManager.getInstance().registerListener(this.jhb);
        MessageManager.getInstance().registerListener(this.mYoungsterModeChangeListener);
        this.jhd.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.jhd);
    }

    public void notifyDataSetChanged() {
        if (this.jgT != null && !HomePageStatic.jci) {
            this.ewX.setAdapter(this.jgT);
            this.jgQ.notifyDataSetChanged();
            this.jhk.a(this.jhl);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.jgT != null) {
            this.jgT.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.jgT != null) {
            this.jgT.d(dataRes, z);
        }
    }

    public void cDN() {
        if (this.jgT != null) {
            this.jgT.cDN();
        }
    }

    public void x(String str, int i, int i2) {
        if (this.ewX != null) {
            this.jgT.x(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.jgT = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.jgT.setScrollFragmentTabHost(this);
        this.ewX.setOffscreenPageLimit(2);
        this.ewX.setAdapter(this.jgT);
        int cDK = this.jgT.cDK();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.jgT;
        if (HomePageStatic.jci) {
            cDK = 0;
        }
        this.ewX.setCurrentItem(newScrollFragmentAdapter.AP(cDK));
        this.jgQ.setViewPager(this.ewX);
        this.jgQ.setConcernTabIndex(this.jgT.AP(0));
        this.jgQ.setHotTopicTabIndex(this.jgT.AP(5));
        this.jgQ.setShowHotTopicRedTip(cDW());
    }

    private boolean cDW() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            if (currentTimeMillis - com.baidu.tbadk.core.sharedPref.b.blO().getLong("unlogin_hot_top_timestamp", 0L) >= 86400000) {
                return true;
            }
        } else {
            long j = com.baidu.tbadk.core.sharedPref.b.blO().getLong(TbadkApplication.getCurrentAccount(), 0L);
            if (!StringUtils.isNull(TbadkApplication.getCurrentAccount()) && currentTimeMillis - j >= 86400000) {
                return true;
            }
        }
        return false;
    }

    public boolean cDX() {
        return this.jgT != null && this.jgT.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.jgT.getCount()) {
            this.jgQ.setTabItemClicked(z);
            this.jgT.AS(i);
            this.ewX.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.jgT.AP(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.jgT.AP(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.jgT.KV(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jgQ.setPageUniqueId(bdUniqueId);
        this.jgY.setTag(bdUniqueId);
        this.jgZ.setTag(bdUniqueId);
        this.jhc.setTag(bdUniqueId);
        this.jha.setTag(bdUniqueId);
        this.mYoungsterModeChangeListener.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.dOh;
    }

    public int getCurrentTabType() {
        return this.jgT.AO(this.ewX.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.ewX.getAdapter() != null) {
            int count = this.ewX.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.jgT.AO(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int AV(int i) {
        return this.jgT.AO(i);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.jhf, R.color.cp_bg_line_h);
        this.jhg.onChangeSkinType();
        this.jgQ.onChangeSkinType();
        if (this.mPageContext != null && this.fTu != null) {
            this.fTu.onChangeSkinType(this.mPageContext, i);
        }
        if (this.jgT != null) {
            this.jgT.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.hRf != null) {
            this.hRf.onChangeSkinType(this.mPageContext, i);
        }
        if (this.jhi != null) {
            this.jhi.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this.fCa, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.fVQ, R.drawable.personalize_tab_shadow);
    }

    private boolean bKn() {
        return this.fVQ.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.jgS = z;
        if (z) {
            if (this.fCa != null) {
                this.fCa.setVisibility(8);
            }
        } else if (this.fCa != null) {
            this.fCa.setVisibility(0);
        }
    }

    public void bKo() {
        if (this.jgS && !bKn()) {
            this.fVQ.setVisibility(0);
            if (this.fVT == null) {
                this.fVT = new AlphaAnimation(0.0f, 1.0f);
                this.fVT.setFillAfter(true);
                this.fVT.setDuration(300L);
            }
            this.fVQ.startAnimation(this.fVT);
        }
    }

    public void bKp() {
        if (this.jgS && bKn()) {
            if (this.fVU == null) {
                this.fVU = new AlphaAnimation(1.0f, 0.0f);
                this.fVU.setFillAfter(true);
                this.fVU.setDuration(300L);
                this.fVU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.fVQ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fVQ.startAnimation(this.fVU);
        }
    }

    public void cDP() {
        if (this.jgT != null) {
            this.jgT.cDP();
        }
    }

    public void bKT() {
        this.jgT.bKT();
    }

    public String getCurrentPageKey() {
        if (this.jgT != null) {
            return this.jgT.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.ewX != null) {
            return this.ewX.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.jgT != null) {
            this.jgT.setPrimary(z);
        }
        if (this.fTu != null && z) {
            this.fTu.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cDY() {
        this.jgT.a(this.jhm);
    }

    public void pe(boolean z) {
    }

    public void cDZ() {
        if (this.jhf != null && !this.jhf.isSticky() && this.jgQ != null && this.jgQ.getTaskView() != null && this.jgQ.getTaskView().getVisibility() != 0) {
            this.jgQ.cEi();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.jgU = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.jhh != null) {
            this.jhh.Po();
            this.jhh = null;
        }
        cEc();
        MessageManager.getInstance().unRegisterListener(this.jhb);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.jgQ != null && this.jgT.cDL()) {
            this.jgQ.setShowConcernRedTip(z);
        }
    }

    public boolean cDR() {
        if (this.jgQ == null || !this.jgT.cDL()) {
            return false;
        }
        return this.jgQ.cDR();
    }

    public boolean cDS() {
        if (this.jgQ == null || this.jgT == null || !this.jgT.cDM()) {
            return false;
        }
        return this.jgQ.cDS();
    }

    public void setVideoThreadId(String str) {
        if (this.jgT != null) {
            this.jgT.setVideoThreadId(str);
        }
    }

    public void cEa() {
        if (com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int AP = this.jgT != null ? this.jgT.AP(0) : 0;
            if (this.jgV == null) {
                this.jgV = new e(this.mPageContext, this.jgQ.AT(AP));
                this.jgV.ff(R.drawable.bg_tip_blue_up);
                this.jgV.fe(32);
                this.jgV.of(true);
                this.jgV.setUseDirectOffset(true);
                this.jgV.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.jgV.fg(4000);
            }
            this.jgV.y(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cEb() {
        if (TbadkCoreApplication.isLogin()) {
            int AP = this.jgT != null ? this.jgT.AP(0) : 0;
            if (this.jgV == null) {
                this.jgV = new e(this.mPageContext, this.jgQ.AT(AP));
                this.jgV.ff(R.drawable.bg_tip_blue_up_left);
                this.jgV.fe(16);
                this.jgV.of(true);
                this.jgV.wK(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.jgV.setUseDirectOffset(true);
                this.jgV.fg(4000);
            }
            this.jgV.aJ(this.mContext.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void cEc() {
        if (this.jgV != null) {
            this.jgV.Po();
        }
    }

    public void onResume() {
        if (this.jgQ != null) {
            this.jgQ.onResume();
        }
    }

    public void a(a aVar) {
        if (this.jgW == null) {
            this.jgW = new ArrayList();
        }
        this.jgW.add(aVar);
    }

    public void b(a aVar) {
        if (this.jgW != null && this.jgW.size() > 0) {
            this.jgW.remove(aVar);
        }
    }

    /* loaded from: classes22.dex */
    public static abstract class a {
        public void cEd() {
        }

        public void cEe() {
        }

        public void cCZ() {
        }
    }
}
