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
    private View.OnClickListener aFf;
    private FrameLayout dWE;
    private CustomViewPager eFw;
    private View fKv;
    private NoNetworkView gdx;
    private View gfU;
    private AlphaAnimation gfX;
    private AlphaAnimation gfY;
    private PluginErrorTipView idG;
    private boolean isPrimary;
    CustomMessageListener jtA;
    CustomMessageTask jtB;
    CustomMessageTask jtC;
    private StickyAppBarLayout jtD;
    private NestedScrollHeader jtE;
    private e jtF;
    private com.baidu.tieba.homepage.concern.b jtG;
    private boolean jtH;
    private com.baidu.tieba.homepage.framework.indicator.b jtI;
    private com.baidu.tieba.homepage.framework.e jtJ;
    private d jtK;
    private HomeTabBarView jto;
    private TBSpecificationBtn jtp;
    private boolean jtq;
    private NewScrollFragmentAdapter jtr;
    private b jts;
    private e jtt;
    private List<a> jtu;
    private boolean jtv;
    CustomMessageListener jtw;
    CustomMessageListener jtx;
    CustomMessageListener jty;
    CustomMessageListener jtz;
    private Context mContext;
    private TbPageContext mPageContext;
    CustomMessageListener mYoungsterModeChangeListener;

    /* loaded from: classes22.dex */
    public interface b {
        void Bp(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.jtv = false;
        this.jtw = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bMQ();
                } else {
                    ScrollFragmentTabHost.this.bMR();
                }
            }
        };
        this.jtx = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.jtF != null) {
                    ScrollFragmentTabHost.this.jtF.Qh();
                    ScrollFragmentTabHost.this.jtF = null;
                }
            }
        };
        this.jty = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jto.Bm(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 1) {
                                SvgManager.boN().a((ImageView) linearLayout2.getChildAt(1), R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                            }
                        }
                        ScrollFragmentTabHost.this.jtG.a(ScrollFragmentTabHost.this.jtD);
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 1) {
                            SvgManager.boN().a((ImageView) linearLayout3.getChildAt(1), R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                        }
                    }
                }
            }
        };
        this.jtz = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.jtH != com.baidu.tbadk.a.d.bfD()) {
                    ScrollFragmentTabHost.this.jto.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bfD() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cHj();
                        ScrollFragmentTabHost.this.cHi();
                    }
                }
            }
        };
        this.jtA = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jto.Bm(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 0 && (linearLayout2.getChildAt(0) instanceof TextView)) {
                                ((TextView) linearLayout2.getChildAt(0)).setText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person));
                                com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_home_concern_all_status", 1);
                            }
                        }
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 0 && (linearLayout3.getChildAt(0) instanceof TextView)) {
                            ((TextView) linearLayout3.getChildAt(0)).setText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention));
                            com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.jtr != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.jtr.cGX();
                    if (!booleanValue || !c.bET()) {
                        ScrollFragmentTabHost.this.jtr.cGP();
                    } else {
                        ScrollFragmentTabHost.this.jtr.cGO();
                    }
                    ScrollFragmentTabHost.this.jto.notifyDataSetChanged();
                }
            }
        };
        this.jtB = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.jtD == null || ScrollFragmentTabHost.this.jtE == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.jto.getTaskView() : ScrollFragmentTabHost.this.jtE.getTaskView();
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
                    if (ScrollFragmentTabHost.this.jtF != null) {
                        ScrollFragmentTabHost.this.jtF.Qh();
                    }
                    ScrollFragmentTabHost.this.jtF = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.jtF.fg(48);
                    ScrollFragmentTabHost.this.jtF.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.jtF.setAnchor(4);
                    ScrollFragmentTabHost.this.jtF.fi(i);
                    ScrollFragmentTabHost.this.jtF.ox(true);
                    ScrollFragmentTabHost.this.jtF.xd(0);
                    ScrollFragmentTabHost.this.jtF.IS(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.jtC = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.jtD == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bMR();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.jtD.cHn();
                } else if (ScrollFragmentTabHost.this.jtD.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.jtD.cHn();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aFf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
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
        this.jtI = new com.baidu.tieba.homepage.framework.indicator.b();
        this.jtJ = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void Bg(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.jtr.Bi(i), false);
                ScrollFragmentTabHost.this.jtr.Bk(i);
            }
        };
        this.jtK = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void Bf(int i) {
                ScrollFragmentTabHost.this.jtI.a(i, ScrollFragmentTabHost.this.jtJ);
            }
        };
        init();
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jtv = false;
        this.jtw = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bMQ();
                } else {
                    ScrollFragmentTabHost.this.bMR();
                }
            }
        };
        this.jtx = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.jtF != null) {
                    ScrollFragmentTabHost.this.jtF.Qh();
                    ScrollFragmentTabHost.this.jtF = null;
                }
            }
        };
        this.jty = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jto.Bm(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 1) {
                                SvgManager.boN().a((ImageView) linearLayout2.getChildAt(1), R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                            }
                        }
                        ScrollFragmentTabHost.this.jtG.a(ScrollFragmentTabHost.this.jtD);
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 1) {
                            SvgManager.boN().a((ImageView) linearLayout3.getChildAt(1), R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                        }
                    }
                }
            }
        };
        this.jtz = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.jtH != com.baidu.tbadk.a.d.bfD()) {
                    ScrollFragmentTabHost.this.jto.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bfD() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cHj();
                        ScrollFragmentTabHost.this.cHi();
                    }
                }
            }
        };
        this.jtA = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jto.Bm(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 0 && (linearLayout2.getChildAt(0) instanceof TextView)) {
                                ((TextView) linearLayout2.getChildAt(0)).setText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person));
                                com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_home_concern_all_status", 1);
                            }
                        }
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 0 && (linearLayout3.getChildAt(0) instanceof TextView)) {
                            ((TextView) linearLayout3.getChildAt(0)).setText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention));
                            com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.jtr != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.jtr.cGX();
                    if (!booleanValue || !c.bET()) {
                        ScrollFragmentTabHost.this.jtr.cGP();
                    } else {
                        ScrollFragmentTabHost.this.jtr.cGO();
                    }
                    ScrollFragmentTabHost.this.jto.notifyDataSetChanged();
                }
            }
        };
        this.jtB = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.jtD == null || ScrollFragmentTabHost.this.jtE == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.jto.getTaskView() : ScrollFragmentTabHost.this.jtE.getTaskView();
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
                    if (ScrollFragmentTabHost.this.jtF != null) {
                        ScrollFragmentTabHost.this.jtF.Qh();
                    }
                    ScrollFragmentTabHost.this.jtF = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.jtF.fg(48);
                    ScrollFragmentTabHost.this.jtF.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.jtF.setAnchor(4);
                    ScrollFragmentTabHost.this.jtF.fi(i);
                    ScrollFragmentTabHost.this.jtF.ox(true);
                    ScrollFragmentTabHost.this.jtF.xd(0);
                    ScrollFragmentTabHost.this.jtF.IS(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.jtC = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.jtD == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bMR();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.jtD.cHn();
                } else if (ScrollFragmentTabHost.this.jtD.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.jtD.cHn();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aFf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
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
        this.jtI = new com.baidu.tieba.homepage.framework.indicator.b();
        this.jtJ = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void Bg(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.jtr.Bi(i), false);
                ScrollFragmentTabHost.this.jtr.Bk(i);
            }
        };
        this.jtK = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void Bf(int i) {
                ScrollFragmentTabHost.this.jtI.a(i, ScrollFragmentTabHost.this.jtJ);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.jtD = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.jtE = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.jto = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.idG = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.gdx = (NoNetworkView) findViewById(R.id.view_no_network);
        this.dWE = (FrameLayout) findViewById(R.id.home_pager_container);
        this.eFw = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.fKv = findViewById(R.id.divider_line);
        this.gfU = findViewById(R.id.divider_shadow);
        this.jtp = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.jtp.setVisibility(8);
        this.jtG = new com.baidu.tieba.homepage.concern.b(this.mContext);
        this.jtH = com.baidu.tbadk.a.d.bfD();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.jtD.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.dWE.getLayoutParams()).topMargin = 0;
        this.jto.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.jtr.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.jts != null) {
                    ScrollFragmentTabHost.this.jts.Bp(i);
                }
                com.baidu.tbadk.core.bigday.b.bhp().ix(ScrollFragmentTabHost.this.jtr.Bh(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.Bo(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                int Bh = ScrollFragmentTabHost.this.jtr.Bh(ScrollFragmentTabHost.this.eFw.getCurrentItem());
                if (Bh == 5) {
                    if (ScrollFragmentTabHost.this.jtv) {
                        ScrollFragmentTabHost.this.jtv = false;
                    } else {
                        aq aqVar = new aq("c13740");
                        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar.aj("obj_type", ScrollFragmentTabHost.this.cGZ() ? 1 : 0);
                        aqVar.boK();
                    }
                }
                if (Bh == 0) {
                    ScrollFragmentTabHost.this.cHj();
                }
                View Bm = ScrollFragmentTabHost.this.jto.Bm(0);
                if ((Bm instanceof LinearLayout) && TbadkCoreApplication.isLogin() && com.baidu.tbadk.a.d.bfD()) {
                    LinearLayout linearLayout = (LinearLayout) Bm;
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                        if (Bh == 0) {
                            imageView.setVisibility(0);
                        } else {
                            imageView.setVisibility(4);
                        }
                    }
                }
                if (ScrollFragmentTabHost.this.jtu != null && ScrollFragmentTabHost.this.jtr != null) {
                    int Bh2 = ScrollFragmentTabHost.this.jtr.Bh(ScrollFragmentTabHost.this.eFw.getCurrentItem());
                    if (Bh2 == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar : ScrollFragmentTabHost.this.jtu) {
                            aVar.cHl();
                        }
                    } else if (Bh2 == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar2 : ScrollFragmentTabHost.this.jtu) {
                            aVar2.cHk();
                        }
                    } else if (Bh2 == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                        for (a aVar3 : ScrollFragmentTabHost.this.jtu) {
                            aVar3.cGg();
                        }
                    } else if (Bh2 == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (Bh2 == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (Bh2 == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else {
                        ScrollFragmentTabHost.this.bMR();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.Bo(i));
                if (ScrollFragmentTabHost.this.Bo(i) == 5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.bnH().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.bnH().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.jto.cGZ()) {
                        ScrollFragmentTabHost.this.jto.setShowHotTopicRedTip(false);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean cGY = ScrollFragmentTabHost.this.cGY();
                    TiebaStatic.log(new aq("c12350").aj("obj_type", cGY ? 1 : 0));
                    if (cGY && ScrollFragmentTabHost.this.jtr != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.jtr.cGV();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.jto.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void n(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.eFw.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.Bo(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.Bo(i) == 7) {
                    TiebaStatic.log(new aq("c13483").dR("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.Bo(i) == 8) {
                    TiebaStatic.log(new aq("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.Bo(i));
                if (ScrollFragmentTabHost.this.Bo(i) == 5) {
                    aq aqVar = new aq("c13740");
                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.aj("obj_type", ScrollFragmentTabHost.this.cGZ() ? 1 : 0);
                    aqVar.boK();
                    ScrollFragmentTabHost.this.jtv = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.bnH().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.bnH().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.jto.cGZ()) {
                        ScrollFragmentTabHost.this.jto.setShowHotTopicRedTip(false);
                    }
                }
            }
        });
        this.jtD.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void qL(boolean z) {
                if (z && ScrollFragmentTabHost.this.jtF != null) {
                    ScrollFragmentTabHost.this.jtF.Qh();
                }
            }
        });
        this.jtE.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void Ls(String str) {
                if (ScrollFragmentTabHost.this.jtF != null) {
                    ScrollFragmentTabHost.this.jtF.Qh();
                    ScrollFragmentTabHost.this.jtF = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    be.boR().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.jtE.setVisibility(8);
            this.jto.setMissionEntranceVisibility(true);
            this.jto.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void Ls(String str) {
                    if (ScrollFragmentTabHost.this.jtF != null) {
                        ScrollFragmentTabHost.this.jtF.Qh();
                        ScrollFragmentTabHost.this.jtF = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        be.boR().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.jtE.setVisibility(0);
        this.jto.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.jtC.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.jtC);
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
        this.gdx.a(aVar);
        MessageManager.getInstance().registerListener(this.jtw);
        MessageManager.getInstance().registerListener(this.jtx);
        MessageManager.getInstance().registerListener(this.jtA);
        MessageManager.getInstance().registerListener(this.jty);
        MessageManager.getInstance().registerListener(this.jtz);
        MessageManager.getInstance().registerListener(this.mYoungsterModeChangeListener);
        this.jtB.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.jtB);
    }

    public void notifyDataSetChanged() {
        if (this.jtr != null && !HomePageStatic.joD) {
            this.eFw.setAdapter(this.jtr);
            this.jto.notifyDataSetChanged();
            this.jtI.a(this.jtJ);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.jtr != null) {
            this.jtr.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.jtr != null) {
            this.jtr.d(dataRes, z);
        }
    }

    public void cGU() {
        if (this.jtr != null) {
            this.jtr.cGU();
        }
    }

    public void y(String str, int i, int i2) {
        if (this.eFw != null) {
            this.jtr.y(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.jtr = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.jtr.setScrollFragmentTabHost(this);
        this.eFw.setOffscreenPageLimit(2);
        this.eFw.setAdapter(this.jtr);
        int cGR = this.jtr.cGR();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.jtr;
        if (HomePageStatic.joD) {
            cGR = 0;
        }
        this.eFw.setCurrentItem(newScrollFragmentAdapter.Bi(cGR));
        this.jto.setViewPager(this.eFw);
        this.jto.setConcernTabIndex(this.jtr.Bi(0));
        this.jto.setHotTopicTabIndex(this.jtr.Bi(5));
        this.jto.setShowHotTopicRedTip(cHd());
    }

    private boolean cHd() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            if (currentTimeMillis - com.baidu.tbadk.core.sharedPref.b.bnH().getLong("unlogin_hot_top_timestamp", 0L) >= 86400000) {
                return true;
            }
        } else {
            long j = com.baidu.tbadk.core.sharedPref.b.bnH().getLong(TbadkApplication.getCurrentAccount(), 0L);
            if (!StringUtils.isNull(TbadkApplication.getCurrentAccount()) && currentTimeMillis - j >= 86400000) {
                return true;
            }
        }
        return false;
    }

    public boolean cHe() {
        return this.jtr != null && this.jtr.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.jtr.getCount()) {
            this.jto.setTabItemClicked(z);
            this.jtr.Bl(i);
            this.eFw.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.jtr.Bi(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.jtr.Bi(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.jtr.Lt(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jto.setPageUniqueId(bdUniqueId);
        this.jtw.setTag(bdUniqueId);
        this.jtx.setTag(bdUniqueId);
        this.jtA.setTag(bdUniqueId);
        this.jty.setTag(bdUniqueId);
        this.mYoungsterModeChangeListener.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.dWE;
    }

    public int getCurrentTabType() {
        return this.jtr.Bh(this.eFw.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.eFw.getAdapter() != null) {
            int count = this.eFw.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.jtr.Bh(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int Bo(int i) {
        return this.jtr.Bh(i);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.jtD, R.color.cp_bg_line_h);
        this.jtE.onChangeSkinType();
        this.jto.onChangeSkinType();
        if (this.mPageContext != null && this.gdx != null) {
            this.gdx.onChangeSkinType(this.mPageContext, i);
        }
        if (this.jtr != null) {
            this.jtr.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.idG != null) {
            this.idG.onChangeSkinType(this.mPageContext, i);
        }
        if (this.jtG != null) {
            this.jtG.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this.fKv, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.gfU, R.drawable.personalize_tab_shadow);
    }

    private boolean bMP() {
        return this.gfU.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.jtq = z;
        if (z) {
            if (this.fKv != null) {
                this.fKv.setVisibility(8);
            }
        } else if (this.fKv != null) {
            this.fKv.setVisibility(0);
        }
    }

    public void bMQ() {
        if (this.jtq && !bMP()) {
            this.gfU.setVisibility(0);
            if (this.gfX == null) {
                this.gfX = new AlphaAnimation(0.0f, 1.0f);
                this.gfX.setFillAfter(true);
                this.gfX.setDuration(300L);
            }
            this.gfU.startAnimation(this.gfX);
        }
    }

    public void bMR() {
        if (this.jtq && bMP()) {
            if (this.gfY == null) {
                this.gfY = new AlphaAnimation(1.0f, 0.0f);
                this.gfY.setFillAfter(true);
                this.gfY.setDuration(300L);
                this.gfY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.gfU.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gfU.startAnimation(this.gfY);
        }
    }

    public void cGW() {
        if (this.jtr != null) {
            this.jtr.cGW();
        }
    }

    public void bNv() {
        this.jtr.bNv();
    }

    public String getCurrentPageKey() {
        if (this.jtr != null) {
            return this.jtr.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.eFw != null) {
            return this.eFw.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.jtr != null) {
            this.jtr.setPrimary(z);
        }
        if (this.gdx != null && z) {
            this.gdx.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cHf() {
        this.jtr.a(this.jtK);
    }

    public void pw(boolean z) {
    }

    public void cHg() {
        if (this.jtD != null && !this.jtD.isSticky() && this.jto != null && this.jto.getTaskView() != null && this.jto.getTaskView().getVisibility() != 0) {
            this.jto.cHp();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.jts = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.jtF != null) {
            this.jtF.Qh();
            this.jtF = null;
        }
        cHj();
        MessageManager.getInstance().unRegisterListener(this.jtz);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.jto != null && this.jtr.cGS()) {
            this.jto.setShowConcernRedTip(z);
        }
    }

    public boolean cGY() {
        if (this.jto == null || !this.jtr.cGS()) {
            return false;
        }
        return this.jto.cGY();
    }

    public boolean cGZ() {
        if (this.jto == null || this.jtr == null || !this.jtr.cGT()) {
            return false;
        }
        return this.jto.cGZ();
    }

    public void setVideoThreadId(String str) {
        if (this.jtr != null) {
            this.jtr.setVideoThreadId(str);
        }
    }

    public void cHh() {
        if (com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int Bi = this.jtr != null ? this.jtr.Bi(0) : 0;
            if (this.jtt == null) {
                this.jtt = new e(this.mPageContext, this.jto.Bm(Bi));
                this.jtt.fh(R.drawable.bg_tip_blue_up);
                this.jtt.fg(32);
                this.jtt.ox(true);
                this.jtt.setUseDirectOffset(true);
                this.jtt.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.jtt.fi(4000);
            }
            this.jtt.y(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cHi() {
        if (TbadkCoreApplication.isLogin()) {
            int Bi = this.jtr != null ? this.jtr.Bi(0) : 0;
            if (this.jtt == null) {
                this.jtt = new e(this.mPageContext, this.jto.Bm(Bi));
                this.jtt.fh(R.drawable.bg_tip_blue_up_left);
                this.jtt.fg(16);
                this.jtt.ox(true);
                this.jtt.xd(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.jtt.setUseDirectOffset(true);
                this.jtt.fi(4000);
            }
            this.jtt.aL(this.mContext.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void cHj() {
        if (this.jtt != null) {
            this.jtt.Qh();
        }
    }

    public void onResume() {
        if (this.jto != null) {
            this.jto.onResume();
        }
    }

    public void a(a aVar) {
        if (this.jtu == null) {
            this.jtu = new ArrayList();
        }
        this.jtu.add(aVar);
    }

    public void b(a aVar) {
        if (this.jtu != null && this.jtu.size() > 0) {
            this.jtu.remove(aVar);
        }
    }

    /* loaded from: classes22.dex */
    public static abstract class a {
        public void cHk() {
        }

        public void cHl() {
        }

        public void cGg() {
        }
    }
}
