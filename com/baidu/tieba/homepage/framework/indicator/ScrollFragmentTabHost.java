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
    private View.OnClickListener aFV;
    private FrameLayout bvK;
    private CustomViewPager eLl;
    private View fQl;
    private NoNetworkView gjn;
    private View glJ;
    private AlphaAnimation glM;
    private AlphaAnimation glN;
    private PluginErrorTipView ijD;
    private boolean isPrimary;
    private StickyAppBarLayout jzA;
    private NestedScrollHeader jzB;
    private e jzC;
    private com.baidu.tieba.homepage.concern.b jzD;
    private boolean jzE;
    private com.baidu.tieba.homepage.framework.indicator.b jzF;
    private com.baidu.tieba.homepage.framework.e jzG;
    private d jzH;
    private HomeTabBarView jzl;
    private TBSpecificationBtn jzm;
    private boolean jzn;
    private NewScrollFragmentAdapter jzo;
    private b jzp;
    private e jzq;
    private List<a> jzr;
    private boolean jzs;
    CustomMessageListener jzt;
    CustomMessageListener jzu;
    CustomMessageListener jzv;
    CustomMessageListener jzw;
    CustomMessageListener jzx;
    CustomMessageTask jzy;
    CustomMessageTask jzz;
    private Context mContext;
    private TbPageContext mPageContext;
    CustomMessageListener mYoungsterModeChangeListener;

    /* loaded from: classes22.dex */
    public interface b {
        void BC(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.jzs = false;
        this.jzt = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bPq();
                } else {
                    ScrollFragmentTabHost.this.bPr();
                }
            }
        };
        this.jzu = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.jzC != null) {
                    ScrollFragmentTabHost.this.jzC.SR();
                    ScrollFragmentTabHost.this.jzC = null;
                }
            }
        };
        this.jzv = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jzl.Bz(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 1) {
                                SvgManager.brn().a((ImageView) linearLayout2.getChildAt(1), R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                            }
                        }
                        ScrollFragmentTabHost.this.jzD.a(ScrollFragmentTabHost.this.jzA);
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 1) {
                            SvgManager.brn().a((ImageView) linearLayout3.getChildAt(1), R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                        }
                    }
                }
            }
        };
        this.jzw = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.jzE != com.baidu.tbadk.a.d.bid()) {
                    ScrollFragmentTabHost.this.jzl.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bid() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cJK();
                        ScrollFragmentTabHost.this.cJJ();
                    }
                }
            }
        };
        this.jzx = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jzl.Bz(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 0 && (linearLayout2.getChildAt(0) instanceof TextView)) {
                                ((TextView) linearLayout2.getChildAt(0)).setText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person));
                                com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_home_concern_all_status", 1);
                            }
                        }
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 0 && (linearLayout3.getChildAt(0) instanceof TextView)) {
                            ((TextView) linearLayout3.getChildAt(0)).setText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention));
                            com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.jzo != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.jzo.cJy();
                    if (!booleanValue || !c.bHs()) {
                        ScrollFragmentTabHost.this.jzo.cJq();
                    } else {
                        ScrollFragmentTabHost.this.jzo.cJp();
                    }
                    ScrollFragmentTabHost.this.jzl.notifyDataSetChanged();
                }
            }
        };
        this.jzy = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.jzA == null || ScrollFragmentTabHost.this.jzB == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.jzl.getTaskView() : ScrollFragmentTabHost.this.jzB.getTaskView();
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
                    if (ScrollFragmentTabHost.this.jzC != null) {
                        ScrollFragmentTabHost.this.jzC.SR();
                    }
                    ScrollFragmentTabHost.this.jzC = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.jzC.ft(48);
                    ScrollFragmentTabHost.this.jzC.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.jzC.setAnchor(4);
                    ScrollFragmentTabHost.this.jzC.fv(i);
                    ScrollFragmentTabHost.this.jzC.oG(true);
                    ScrollFragmentTabHost.this.jzC.xq(0);
                    ScrollFragmentTabHost.this.jzC.Jj(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.jzz = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.jzA == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bPr();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.jzA.cJO();
                } else if (ScrollFragmentTabHost.this.jzA.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.jzA.cJO();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aFV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
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
        this.jzF = new com.baidu.tieba.homepage.framework.indicator.b();
        this.jzG = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void Bt(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.jzo.Bv(i), false);
                ScrollFragmentTabHost.this.jzo.Bx(i);
            }
        };
        this.jzH = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void Bs(int i) {
                ScrollFragmentTabHost.this.jzF.a(i, ScrollFragmentTabHost.this.jzG);
            }
        };
        init();
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jzs = false;
        this.jzt = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bPq();
                } else {
                    ScrollFragmentTabHost.this.bPr();
                }
            }
        };
        this.jzu = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.jzC != null) {
                    ScrollFragmentTabHost.this.jzC.SR();
                    ScrollFragmentTabHost.this.jzC = null;
                }
            }
        };
        this.jzv = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jzl.Bz(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 1) {
                                SvgManager.brn().a((ImageView) linearLayout2.getChildAt(1), R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                            }
                        }
                        ScrollFragmentTabHost.this.jzD.a(ScrollFragmentTabHost.this.jzA);
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 1) {
                            SvgManager.brn().a((ImageView) linearLayout3.getChildAt(1), R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                        }
                    }
                }
            }
        };
        this.jzw = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.jzE != com.baidu.tbadk.a.d.bid()) {
                    ScrollFragmentTabHost.this.jzl.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bid() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cJK();
                        ScrollFragmentTabHost.this.cJJ();
                    }
                }
            }
        };
        this.jzx = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jzl.Bz(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 0 && (linearLayout2.getChildAt(0) instanceof TextView)) {
                                ((TextView) linearLayout2.getChildAt(0)).setText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person));
                                com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_home_concern_all_status", 1);
                            }
                        }
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 0 && (linearLayout3.getChildAt(0) instanceof TextView)) {
                            ((TextView) linearLayout3.getChildAt(0)).setText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention));
                            com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.jzo != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.jzo.cJy();
                    if (!booleanValue || !c.bHs()) {
                        ScrollFragmentTabHost.this.jzo.cJq();
                    } else {
                        ScrollFragmentTabHost.this.jzo.cJp();
                    }
                    ScrollFragmentTabHost.this.jzl.notifyDataSetChanged();
                }
            }
        };
        this.jzy = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.jzA == null || ScrollFragmentTabHost.this.jzB == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.jzl.getTaskView() : ScrollFragmentTabHost.this.jzB.getTaskView();
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
                    if (ScrollFragmentTabHost.this.jzC != null) {
                        ScrollFragmentTabHost.this.jzC.SR();
                    }
                    ScrollFragmentTabHost.this.jzC = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.jzC.ft(48);
                    ScrollFragmentTabHost.this.jzC.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.jzC.setAnchor(4);
                    ScrollFragmentTabHost.this.jzC.fv(i);
                    ScrollFragmentTabHost.this.jzC.oG(true);
                    ScrollFragmentTabHost.this.jzC.xq(0);
                    ScrollFragmentTabHost.this.jzC.Jj(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.jzz = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.jzA == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bPr();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.jzA.cJO();
                } else if (ScrollFragmentTabHost.this.jzA.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.jzA.cJO();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aFV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
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
        this.jzF = new com.baidu.tieba.homepage.framework.indicator.b();
        this.jzG = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void Bt(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.jzo.Bv(i), false);
                ScrollFragmentTabHost.this.jzo.Bx(i);
            }
        };
        this.jzH = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void Bs(int i) {
                ScrollFragmentTabHost.this.jzF.a(i, ScrollFragmentTabHost.this.jzG);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.jzA = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.jzB = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.jzl = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.ijD = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.gjn = (NoNetworkView) findViewById(R.id.view_no_network);
        this.bvK = (FrameLayout) findViewById(R.id.home_pager_container);
        this.eLl = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.fQl = findViewById(R.id.divider_line);
        this.glJ = findViewById(R.id.divider_shadow);
        this.jzm = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.jzm.setVisibility(8);
        this.jzD = new com.baidu.tieba.homepage.concern.b(this.mContext);
        this.jzE = com.baidu.tbadk.a.d.bid();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.jzA.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.bvK.getLayoutParams()).topMargin = 0;
        this.jzl.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.jzo.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.jzp != null) {
                    ScrollFragmentTabHost.this.jzp.BC(i);
                }
                com.baidu.tbadk.core.bigday.b.bjP().iG(ScrollFragmentTabHost.this.jzo.Bu(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.BB(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                int Bu = ScrollFragmentTabHost.this.jzo.Bu(ScrollFragmentTabHost.this.eLl.getCurrentItem());
                if (Bu == 5) {
                    if (ScrollFragmentTabHost.this.jzs) {
                        ScrollFragmentTabHost.this.jzs = false;
                    } else {
                        aq aqVar = new aq("c13740");
                        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar.al("obj_type", ScrollFragmentTabHost.this.cJA() ? 1 : 0);
                        aqVar.brk();
                    }
                }
                if (Bu == 0) {
                    ScrollFragmentTabHost.this.cJK();
                }
                View Bz = ScrollFragmentTabHost.this.jzl.Bz(0);
                if ((Bz instanceof LinearLayout) && TbadkCoreApplication.isLogin() && com.baidu.tbadk.a.d.bid()) {
                    LinearLayout linearLayout = (LinearLayout) Bz;
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                        if (Bu == 0) {
                            imageView.setVisibility(0);
                        } else {
                            imageView.setVisibility(4);
                        }
                    }
                }
                if (ScrollFragmentTabHost.this.jzr != null && ScrollFragmentTabHost.this.jzo != null) {
                    int Bu2 = ScrollFragmentTabHost.this.jzo.Bu(ScrollFragmentTabHost.this.eLl.getCurrentItem());
                    if (Bu2 == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.jzr) {
                            aVar.cJM();
                        }
                    } else if (Bu2 == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.jzr) {
                            aVar2.cJL();
                        }
                    } else if (Bu2 == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.jzr) {
                            aVar3.cIH();
                        }
                    } else if (Bu2 == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (Bu2 == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (Bu2 == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.bPr();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.BB(i));
                if (ScrollFragmentTabHost.this.BB(i) == 5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.bqh().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.bqh().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.jzl.cJA()) {
                        ScrollFragmentTabHost.this.jzl.setShowHotTopicRedTip(false);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean cJz = ScrollFragmentTabHost.this.cJz();
                    TiebaStatic.log(new aq("c12350").al("obj_type", cJz ? 1 : 0));
                    if (cJz && ScrollFragmentTabHost.this.jzo != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.jzo.cJw();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.jzl.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void n(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.eLl.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.BB(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.BB(i) == 7) {
                    TiebaStatic.log(new aq("c13483").dR("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.BB(i) == 8) {
                    TiebaStatic.log(new aq("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.BB(i));
                if (ScrollFragmentTabHost.this.BB(i) == 5) {
                    aq aqVar = new aq("c13740");
                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.al("obj_type", ScrollFragmentTabHost.this.cJA() ? 1 : 0);
                    aqVar.brk();
                    ScrollFragmentTabHost.this.jzs = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.bqh().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.bqh().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.jzl.cJA()) {
                        ScrollFragmentTabHost.this.jzl.setShowHotTopicRedTip(false);
                    }
                }
            }
        });
        this.jzA.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void qU(boolean z) {
                if (z && ScrollFragmentTabHost.this.jzC != null) {
                    ScrollFragmentTabHost.this.jzC.SR();
                }
            }
        });
        this.jzB.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void LJ(String str) {
                if (ScrollFragmentTabHost.this.jzC != null) {
                    ScrollFragmentTabHost.this.jzC.SR();
                    ScrollFragmentTabHost.this.jzC = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    be.brr().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.jzB.setVisibility(8);
            this.jzl.setMissionEntranceVisibility(true);
            this.jzl.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void LJ(String str) {
                    if (ScrollFragmentTabHost.this.jzC != null) {
                        ScrollFragmentTabHost.this.jzC.SR();
                        ScrollFragmentTabHost.this.jzC = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        be.brr().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.jzB.setVisibility(0);
        this.jzl.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.jzz.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.jzz);
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
        this.gjn.a(aVar);
        MessageManager.getInstance().registerListener(this.jzt);
        MessageManager.getInstance().registerListener(this.jzu);
        MessageManager.getInstance().registerListener(this.jzx);
        MessageManager.getInstance().registerListener(this.jzv);
        MessageManager.getInstance().registerListener(this.jzw);
        MessageManager.getInstance().registerListener(this.mYoungsterModeChangeListener);
        this.jzy.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.jzy);
    }

    public void notifyDataSetChanged() {
        if (this.jzo != null && !HomePageStatic.juA) {
            this.eLl.setAdapter(this.jzo);
            this.jzl.notifyDataSetChanged();
            this.jzF.a(this.jzG);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.jzo != null) {
            this.jzo.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.jzo != null) {
            this.jzo.d(dataRes, z);
        }
    }

    public void cJv() {
        if (this.jzo != null) {
            this.jzo.cJv();
        }
    }

    public void y(String str, int i, int i2) {
        if (this.eLl != null) {
            this.jzo.y(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.jzo = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.jzo.setScrollFragmentTabHost(this);
        this.eLl.setOffscreenPageLimit(2);
        this.eLl.setAdapter(this.jzo);
        int cJs = this.jzo.cJs();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.jzo;
        if (HomePageStatic.juA) {
            cJs = 0;
        }
        this.eLl.setCurrentItem(newScrollFragmentAdapter.Bv(cJs));
        this.jzl.setViewPager(this.eLl);
        this.jzl.setConcernTabIndex(this.jzo.Bv(0));
        this.jzl.setHotTopicTabIndex(this.jzo.Bv(5));
        this.jzl.setShowHotTopicRedTip(cJE());
    }

    private boolean cJE() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            if (currentTimeMillis - com.baidu.tbadk.core.sharedPref.b.bqh().getLong("unlogin_hot_top_timestamp", 0L) >= 86400000) {
                return true;
            }
        } else {
            long j = com.baidu.tbadk.core.sharedPref.b.bqh().getLong(TbadkApplication.getCurrentAccount(), 0L);
            if (!StringUtils.isNull(TbadkApplication.getCurrentAccount()) && currentTimeMillis - j >= 86400000) {
                return true;
            }
        }
        return false;
    }

    public boolean cJF() {
        return this.jzo != null && this.jzo.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.jzo.getCount()) {
            this.jzl.setTabItemClicked(z);
            this.jzo.By(i);
            this.eLl.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.jzo.Bv(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.jzo.Bv(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.jzo.LK(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jzl.setPageUniqueId(bdUniqueId);
        this.jzt.setTag(bdUniqueId);
        this.jzu.setTag(bdUniqueId);
        this.jzx.setTag(bdUniqueId);
        this.jzv.setTag(bdUniqueId);
        this.mYoungsterModeChangeListener.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.bvK;
    }

    public int getCurrentTabType() {
        return this.jzo.Bu(this.eLl.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.eLl.getAdapter() != null) {
            int count = this.eLl.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.jzo.Bu(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int BB(int i) {
        return this.jzo.Bu(i);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.jzA, R.color.cp_bg_line_h);
        this.jzB.onChangeSkinType();
        this.jzl.onChangeSkinType();
        if (this.mPageContext != null && this.gjn != null) {
            this.gjn.onChangeSkinType(this.mPageContext, i);
        }
        if (this.jzo != null) {
            this.jzo.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.ijD != null) {
            this.ijD.onChangeSkinType(this.mPageContext, i);
        }
        if (this.jzD != null) {
            this.jzD.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this.fQl, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.glJ, R.drawable.personalize_tab_shadow);
    }

    private boolean bPp() {
        return this.glJ.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.jzn = z;
        if (z) {
            if (this.fQl != null) {
                this.fQl.setVisibility(8);
            }
        } else if (this.fQl != null) {
            this.fQl.setVisibility(0);
        }
    }

    public void bPq() {
        if (this.jzn && !bPp()) {
            this.glJ.setVisibility(0);
            if (this.glM == null) {
                this.glM = new AlphaAnimation(0.0f, 1.0f);
                this.glM.setFillAfter(true);
                this.glM.setDuration(300L);
            }
            this.glJ.startAnimation(this.glM);
        }
    }

    public void bPr() {
        if (this.jzn && bPp()) {
            if (this.glN == null) {
                this.glN = new AlphaAnimation(1.0f, 0.0f);
                this.glN.setFillAfter(true);
                this.glN.setDuration(300L);
                this.glN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.glJ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.glJ.startAnimation(this.glN);
        }
    }

    public void cJx() {
        if (this.jzo != null) {
            this.jzo.cJx();
        }
    }

    public void bPV() {
        this.jzo.bPV();
    }

    public String getCurrentPageKey() {
        if (this.jzo != null) {
            return this.jzo.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.eLl != null) {
            return this.eLl.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.jzo != null) {
            this.jzo.setPrimary(z);
        }
        if (this.gjn != null && z) {
            this.gjn.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cJG() {
        this.jzo.a(this.jzH);
    }

    public void pF(boolean z) {
    }

    public void cJH() {
        if (this.jzA != null && !this.jzA.isSticky() && this.jzl != null && this.jzl.getTaskView() != null && this.jzl.getTaskView().getVisibility() != 0) {
            this.jzl.cJQ();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.jzp = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.jzC != null) {
            this.jzC.SR();
            this.jzC = null;
        }
        cJK();
        MessageManager.getInstance().unRegisterListener(this.jzw);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.jzl != null && this.jzo.cJt()) {
            this.jzl.setShowConcernRedTip(z);
        }
    }

    public boolean cJz() {
        if (this.jzl == null || !this.jzo.cJt()) {
            return false;
        }
        return this.jzl.cJz();
    }

    public boolean cJA() {
        if (this.jzl == null || this.jzo == null || !this.jzo.cJu()) {
            return false;
        }
        return this.jzl.cJA();
    }

    public void setVideoThreadId(String str) {
        if (this.jzo != null) {
            this.jzo.setVideoThreadId(str);
        }
    }

    public void cJI() {
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int Bv = this.jzo != null ? this.jzo.Bv(0) : 0;
            if (this.jzq == null) {
                this.jzq = new e(this.mPageContext, this.jzl.Bz(Bv));
                this.jzq.fu(R.drawable.bg_tip_blue_up);
                this.jzq.ft(32);
                this.jzq.oG(true);
                this.jzq.setUseDirectOffset(true);
                this.jzq.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.jzq.fv(4000);
            }
            this.jzq.z(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cJJ() {
        if (TbadkCoreApplication.isLogin()) {
            int Bv = this.jzo != null ? this.jzo.Bv(0) : 0;
            if (this.jzq == null) {
                this.jzq = new e(this.mPageContext, this.jzl.Bz(Bv));
                this.jzq.fu(R.drawable.bg_tip_blue_up_left);
                this.jzq.ft(16);
                this.jzq.oG(true);
                this.jzq.xq(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.jzq.setUseDirectOffset(true);
                this.jzq.fv(4000);
            }
            this.jzq.aM(this.mContext.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void cJK() {
        if (this.jzq != null) {
            this.jzq.SR();
        }
    }

    public void onResume() {
        if (this.jzl != null) {
            this.jzl.onResume();
        }
    }

    public void a(a aVar) {
        if (this.jzr == null) {
            this.jzr = new ArrayList();
        }
        this.jzr.add(aVar);
    }

    public void b(a aVar) {
        if (this.jzr != null && this.jzr.size() > 0) {
            this.jzr.remove(aVar);
        }
    }

    /* loaded from: classes22.dex */
    public static abstract class a {
        public void cJL() {
        }

        public void cJM() {
        }

        public void cIH() {
        }
    }
}
