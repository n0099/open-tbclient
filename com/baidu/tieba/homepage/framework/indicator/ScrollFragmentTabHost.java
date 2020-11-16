package com.baidu.tieba.homepage.framework.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.youngster.b.c;
import com.baidu.tieba.R;
import com.baidu.tieba.d.e;
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
    private View.OnClickListener aEk;
    private FrameLayout btY;
    private CustomViewPager eKk;
    private View fPU;
    private NoNetworkView giU;
    private View glq;
    private AlphaAnimation glt;
    private AlphaAnimation glu;
    private PluginErrorTipView ikr;
    private boolean isPrimary;
    private HomeTabBarView jAd;
    private TBSpecificationBtn jAe;
    private boolean jAf;
    private NewScrollFragmentAdapter jAg;
    private b jAh;
    private e jAi;
    private List<a> jAj;
    private boolean jAk;
    CustomMessageListener jAl;
    CustomMessageListener jAm;
    CustomMessageListener jAn;
    CustomMessageListener jAo;
    CustomMessageListener jAp;
    CustomMessageTask jAq;
    CustomMessageTask jAr;
    private StickyAppBarLayout jAs;
    private NestedScrollHeader jAt;
    private e jAu;
    private com.baidu.tieba.homepage.concern.b jAv;
    private boolean jAw;
    private com.baidu.tieba.homepage.framework.indicator.b jAx;
    private com.baidu.tieba.homepage.framework.e jAy;
    private d jAz;
    private Context mContext;
    private TbPageContext mPageContext;
    CustomMessageListener mYoungsterModeChangeListener;

    /* loaded from: classes21.dex */
    public interface b {
        void Ca(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.jAk = false;
        this.jAl = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bOJ();
                } else {
                    ScrollFragmentTabHost.this.bOK();
                }
            }
        };
        this.jAm = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.jAu != null) {
                    ScrollFragmentTabHost.this.jAu.Si();
                    ScrollFragmentTabHost.this.jAu = null;
                }
            }
        };
        this.jAn = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jAd.BX(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 1) {
                                final ImageView imageView = (ImageView) linearLayout2.getChildAt(1);
                                if (Float.floatToIntBits(imageView.getRotationX()) == Float.floatToIntBits(0.0f)) {
                                    ValueAnimator ofInt = ValueAnimator.ofInt(0, 180);
                                    ofInt.setDuration(200L);
                                    ofInt.setStartDelay(30L);
                                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11.1
                                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                            imageView.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
                                        }
                                    });
                                    ofInt.start();
                                }
                            }
                        }
                        if (ScrollFragmentTabHost.this.jAd != null) {
                            ScrollFragmentTabHost.this.jAv.setBackgroundAlpha(ScrollFragmentTabHost.this.jAd.getBackgroundAlpha());
                            ScrollFragmentTabHost.this.jAv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        ScrollFragmentTabHost.this.jAv.a(ScrollFragmentTabHost.this.jAs);
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 1) {
                            final ImageView imageView2 = (ImageView) linearLayout3.getChildAt(1);
                            if (Float.floatToIntBits(imageView2.getRotationX()) == Float.floatToIntBits(180.0f)) {
                                ValueAnimator ofInt2 = ValueAnimator.ofInt(180, 0);
                                ofInt2.setDuration(200L);
                                ofInt2.setStartDelay(30L);
                                ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11.2
                                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                        imageView2.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
                                    }
                                });
                                ofInt2.start();
                            }
                        }
                    }
                }
            }
        };
        this.jAo = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.jAw != com.baidu.tbadk.a.d.bhv()) {
                    ScrollFragmentTabHost.this.jAd.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bhv() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cJp();
                        ScrollFragmentTabHost.this.cJo();
                    }
                }
            }
        };
        this.jAp = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
                    final String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jAd.BX(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 0 && (linearLayout2.getChildAt(0) instanceof TextView)) {
                                final TextView textView = (TextView) linearLayout2.getChildAt(0);
                                if (string2.equals(textView.getText())) {
                                    final int measuredWidth = textView.getMeasuredWidth();
                                    textView.setText(string);
                                    int measureText = (int) textView.getPaint().measureText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person));
                                    int measureText2 = (int) textView.getPaint().measureText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention));
                                    if (measuredWidth > 0 && measureText > 0 && measureText2 > 0) {
                                        ValueAnimator ofInt = ValueAnimator.ofInt(0, measureText - measureText2);
                                        ofInt.setDuration(360L);
                                        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13.1
                                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                                textView.setMaxWidth(((Integer) valueAnimator.getAnimatedValue()).intValue() + measuredWidth);
                                            }
                                        });
                                        ofInt.start();
                                    }
                                }
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_home_concern_all_status", 1);
                            }
                        }
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 0 && (linearLayout3.getChildAt(0) instanceof TextView)) {
                            final TextView textView2 = (TextView) linearLayout3.getChildAt(0);
                            if (string.equals(textView2.getText())) {
                                final int measuredWidth2 = textView2.getMeasuredWidth();
                                int measureText3 = (int) textView2.getPaint().measureText(string);
                                int measureText4 = (int) textView2.getPaint().measureText(string2);
                                if (measuredWidth2 > 0 && measureText3 > 0 && measureText4 > 0) {
                                    ValueAnimator ofInt2 = ValueAnimator.ofInt(0, measureText3 - measureText4);
                                    ofInt2.setDuration(360L);
                                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13.2
                                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                            textView2.setMaxWidth(measuredWidth2 - ((Integer) valueAnimator.getAnimatedValue()).intValue());
                                        }
                                    });
                                    ofInt2.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13.3
                                        @Override // android.animation.Animator.AnimatorListener
                                        public void onAnimationStart(Animator animator) {
                                        }

                                        @Override // android.animation.Animator.AnimatorListener
                                        public void onAnimationEnd(Animator animator) {
                                            textView2.setText(string2);
                                        }

                                        @Override // android.animation.Animator.AnimatorListener
                                        public void onAnimationCancel(Animator animator) {
                                        }

                                        @Override // android.animation.Animator.AnimatorListener
                                        public void onAnimationRepeat(Animator animator) {
                                        }
                                    });
                                    ofInt2.start();
                                }
                            }
                            com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.jAg != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.jAg.cJd();
                    if (!booleanValue || !c.bGL()) {
                        ScrollFragmentTabHost.this.jAg.cIV();
                    } else {
                        ScrollFragmentTabHost.this.jAg.cIU();
                    }
                    ScrollFragmentTabHost.this.jAd.cLo();
                }
            }
        };
        this.jAq = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.jAs == null || ScrollFragmentTabHost.this.jAt == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.jAd.getTaskView() : ScrollFragmentTabHost.this.jAt.getTaskView();
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
                    if (ScrollFragmentTabHost.this.jAu != null) {
                        ScrollFragmentTabHost.this.jAu.Si();
                    }
                    ScrollFragmentTabHost.this.jAu = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.jAu.fp(48);
                    ScrollFragmentTabHost.this.jAu.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.jAu.setAnchor(4);
                    ScrollFragmentTabHost.this.jAu.fr(i);
                    ScrollFragmentTabHost.this.jAu.oJ(true);
                    ScrollFragmentTabHost.this.jAu.xO(0);
                    ScrollFragmentTabHost.this.jAu.IK(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.jAr = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.jAs == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bOK();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.jAs.cJt();
                } else if (ScrollFragmentTabHost.this.jAs.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.jAs.cJt();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aEk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
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
        this.jAx = new com.baidu.tieba.homepage.framework.indicator.b();
        this.jAy = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void BR(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.jAg.BT(i), false);
                ScrollFragmentTabHost.this.jAg.BV(i);
            }
        };
        this.jAz = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void BQ(int i) {
                ScrollFragmentTabHost.this.jAx.a(i, ScrollFragmentTabHost.this.jAy);
            }
        };
        init();
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jAk = false;
        this.jAl = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bOJ();
                } else {
                    ScrollFragmentTabHost.this.bOK();
                }
            }
        };
        this.jAm = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.jAu != null) {
                    ScrollFragmentTabHost.this.jAu.Si();
                    ScrollFragmentTabHost.this.jAu = null;
                }
            }
        };
        this.jAn = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jAd.BX(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 1) {
                                final ImageView imageView = (ImageView) linearLayout2.getChildAt(1);
                                if (Float.floatToIntBits(imageView.getRotationX()) == Float.floatToIntBits(0.0f)) {
                                    ValueAnimator ofInt = ValueAnimator.ofInt(0, 180);
                                    ofInt.setDuration(200L);
                                    ofInt.setStartDelay(30L);
                                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11.1
                                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                            imageView.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
                                        }
                                    });
                                    ofInt.start();
                                }
                            }
                        }
                        if (ScrollFragmentTabHost.this.jAd != null) {
                            ScrollFragmentTabHost.this.jAv.setBackgroundAlpha(ScrollFragmentTabHost.this.jAd.getBackgroundAlpha());
                            ScrollFragmentTabHost.this.jAv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        ScrollFragmentTabHost.this.jAv.a(ScrollFragmentTabHost.this.jAs);
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 1) {
                            final ImageView imageView2 = (ImageView) linearLayout3.getChildAt(1);
                            if (Float.floatToIntBits(imageView2.getRotationX()) == Float.floatToIntBits(180.0f)) {
                                ValueAnimator ofInt2 = ValueAnimator.ofInt(180, 0);
                                ofInt2.setDuration(200L);
                                ofInt2.setStartDelay(30L);
                                ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11.2
                                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                        imageView2.setRotationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
                                    }
                                });
                                ofInt2.start();
                            }
                        }
                    }
                }
            }
        };
        this.jAo = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.jAw != com.baidu.tbadk.a.d.bhv()) {
                    ScrollFragmentTabHost.this.jAd.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bhv() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cJp();
                        ScrollFragmentTabHost.this.cJo();
                    }
                }
            }
        };
        this.jAp = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
                    final String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jAd.BX(0);
                    if (intValue == 1) {
                        if (linearLayout instanceof LinearLayout) {
                            LinearLayout linearLayout2 = linearLayout;
                            if (linearLayout2.getChildCount() > 0 && (linearLayout2.getChildAt(0) instanceof TextView)) {
                                final TextView textView = (TextView) linearLayout2.getChildAt(0);
                                if (string2.equals(textView.getText())) {
                                    final int measuredWidth = textView.getMeasuredWidth();
                                    textView.setText(string);
                                    int measureText = (int) textView.getPaint().measureText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person));
                                    int measureText2 = (int) textView.getPaint().measureText(ScrollFragmentTabHost.this.getResources().getString(R.string.attention));
                                    if (measuredWidth > 0 && measureText > 0 && measureText2 > 0) {
                                        ValueAnimator ofInt = ValueAnimator.ofInt(0, measureText - measureText2);
                                        ofInt.setDuration(360L);
                                        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13.1
                                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                                textView.setMaxWidth(((Integer) valueAnimator.getAnimatedValue()).intValue() + measuredWidth);
                                            }
                                        });
                                        ofInt.start();
                                    }
                                }
                                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_home_concern_all_status", 1);
                            }
                        }
                    } else if (linearLayout instanceof LinearLayout) {
                        LinearLayout linearLayout3 = linearLayout;
                        if (linearLayout3.getChildCount() > 0 && (linearLayout3.getChildAt(0) instanceof TextView)) {
                            final TextView textView2 = (TextView) linearLayout3.getChildAt(0);
                            if (string.equals(textView2.getText())) {
                                final int measuredWidth2 = textView2.getMeasuredWidth();
                                int measureText3 = (int) textView2.getPaint().measureText(string);
                                int measureText4 = (int) textView2.getPaint().measureText(string2);
                                if (measuredWidth2 > 0 && measureText3 > 0 && measureText4 > 0) {
                                    ValueAnimator ofInt2 = ValueAnimator.ofInt(0, measureText3 - measureText4);
                                    ofInt2.setDuration(360L);
                                    ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13.2
                                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                            textView2.setMaxWidth(measuredWidth2 - ((Integer) valueAnimator.getAnimatedValue()).intValue());
                                        }
                                    });
                                    ofInt2.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13.3
                                        @Override // android.animation.Animator.AnimatorListener
                                        public void onAnimationStart(Animator animator) {
                                        }

                                        @Override // android.animation.Animator.AnimatorListener
                                        public void onAnimationEnd(Animator animator) {
                                            textView2.setText(string2);
                                        }

                                        @Override // android.animation.Animator.AnimatorListener
                                        public void onAnimationCancel(Animator animator) {
                                        }

                                        @Override // android.animation.Animator.AnimatorListener
                                        public void onAnimationRepeat(Animator animator) {
                                        }
                                    });
                                    ofInt2.start();
                                }
                            }
                            com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.jAg != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.jAg.cJd();
                    if (!booleanValue || !c.bGL()) {
                        ScrollFragmentTabHost.this.jAg.cIV();
                    } else {
                        ScrollFragmentTabHost.this.jAg.cIU();
                    }
                    ScrollFragmentTabHost.this.jAd.cLo();
                }
            }
        };
        this.jAq = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.jAs == null || ScrollFragmentTabHost.this.jAt == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.jAd.getTaskView() : ScrollFragmentTabHost.this.jAt.getTaskView();
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
                    if (ScrollFragmentTabHost.this.jAu != null) {
                        ScrollFragmentTabHost.this.jAu.Si();
                    }
                    ScrollFragmentTabHost.this.jAu = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.jAu.fp(48);
                    ScrollFragmentTabHost.this.jAu.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.jAu.setAnchor(4);
                    ScrollFragmentTabHost.this.jAu.fr(i);
                    ScrollFragmentTabHost.this.jAu.oJ(true);
                    ScrollFragmentTabHost.this.jAu.xO(0);
                    ScrollFragmentTabHost.this.jAu.IK(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.jAr = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.jAs == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bOK();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.jAs.cJt();
                } else if (ScrollFragmentTabHost.this.jAs.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.jAs.cJt();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aEk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
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
        this.jAx = new com.baidu.tieba.homepage.framework.indicator.b();
        this.jAy = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void BR(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.jAg.BT(i), false);
                ScrollFragmentTabHost.this.jAg.BV(i);
            }
        };
        this.jAz = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void BQ(int i) {
                ScrollFragmentTabHost.this.jAx.a(i, ScrollFragmentTabHost.this.jAy);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.jAs = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.jAt = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.jAd = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.ikr = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.giU = (NoNetworkView) findViewById(R.id.view_no_network);
        this.btY = (FrameLayout) findViewById(R.id.home_pager_container);
        this.eKk = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.fPU = findViewById(R.id.divider_line);
        this.glq = findViewById(R.id.divider_shadow);
        this.jAe = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.jAe.setVisibility(8);
        this.jAv = new com.baidu.tieba.homepage.concern.b(this.mContext);
        this.jAw = com.baidu.tbadk.a.d.bhv();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.jAs.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.btY.getLayoutParams()).topMargin = 0;
        this.jAd.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.jAg.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.jAh != null) {
                    ScrollFragmentTabHost.this.jAh.Ca(i);
                }
                com.baidu.tbadk.core.bigday.b.biT().iH(ScrollFragmentTabHost.this.jAg.BS(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.BZ(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                int BS = ScrollFragmentTabHost.this.jAg.BS(ScrollFragmentTabHost.this.eKk.getCurrentItem());
                if (BS == 5) {
                    if (ScrollFragmentTabHost.this.jAk) {
                        ScrollFragmentTabHost.this.jAk = false;
                    } else {
                        ar arVar = new ar("c13740");
                        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar.ak("obj_type", ScrollFragmentTabHost.this.cJf() ? 1 : 0);
                        arVar.bqy();
                    }
                }
                if (BS == 0) {
                    ScrollFragmentTabHost.this.cJp();
                }
                View BX = ScrollFragmentTabHost.this.jAd.BX(0);
                if ((BX instanceof LinearLayout) && TbadkCoreApplication.isLogin() && com.baidu.tbadk.a.d.bhv()) {
                    LinearLayout linearLayout = (LinearLayout) BX;
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                        if (BS == 0) {
                            imageView.setVisibility(0);
                        } else {
                            imageView.setVisibility(4);
                        }
                    }
                }
                if (ScrollFragmentTabHost.this.jAj != null && ScrollFragmentTabHost.this.jAg != null) {
                    int BS2 = ScrollFragmentTabHost.this.jAg.BS(ScrollFragmentTabHost.this.eKk.getCurrentItem());
                    if (BS2 == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar : ScrollFragmentTabHost.this.jAj) {
                            aVar.cJr();
                        }
                    } else if (BS2 == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar2 : ScrollFragmentTabHost.this.jAj) {
                            aVar2.cJq();
                        }
                    } else if (BS2 == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar3 : ScrollFragmentTabHost.this.jAj) {
                            aVar3.cIm();
                        }
                    } else if (BS2 == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (BS2 == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (BS2 == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    } else {
                        ScrollFragmentTabHost.this.bOK();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.BZ(i));
                if (ScrollFragmentTabHost.this.BZ(i) == 5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.bpu().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.bpu().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.jAd.cJf()) {
                        ScrollFragmentTabHost.this.jAd.setShowHotTopicRedTip(false);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean cJe = ScrollFragmentTabHost.this.cJe();
                    TiebaStatic.log(new ar("c12350").ak("obj_type", cJe ? 1 : 0));
                    if (cJe && ScrollFragmentTabHost.this.jAg != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.jAg.cJb();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.jAd.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void q(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.eKk.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.BZ(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.BZ(i) == 7) {
                    TiebaStatic.log(new ar("c13483").dR("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.BZ(i) == 8) {
                    TiebaStatic.log(new ar("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.BZ(i));
                if (ScrollFragmentTabHost.this.BZ(i) == 5) {
                    ar arVar = new ar("c13740");
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.ak("obj_type", ScrollFragmentTabHost.this.cJf() ? 1 : 0);
                    arVar.bqy();
                    ScrollFragmentTabHost.this.jAk = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.bpu().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.bpu().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.jAd.cJf()) {
                        ScrollFragmentTabHost.this.jAd.setShowHotTopicRedTip(false);
                    }
                }
            }
        });
        this.jAs.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void qX(boolean z) {
                if (z && ScrollFragmentTabHost.this.jAu != null) {
                    ScrollFragmentTabHost.this.jAu.Si();
                }
            }
        });
        this.jAt.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void Lk(String str) {
                if (ScrollFragmentTabHost.this.jAu != null) {
                    ScrollFragmentTabHost.this.jAu.Si();
                    ScrollFragmentTabHost.this.jAu = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    bf.bqF().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.jAt.setVisibility(8);
            this.jAd.setMissionEntranceVisibility(true);
            this.jAd.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void Lk(String str) {
                    if (ScrollFragmentTabHost.this.jAu != null) {
                        ScrollFragmentTabHost.this.jAu.Si();
                        ScrollFragmentTabHost.this.jAu = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        bf.bqF().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.jAt.setVisibility(0);
        this.jAd.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.jAr.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.jAr);
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
        this.giU.a(aVar);
        MessageManager.getInstance().registerListener(this.jAl);
        MessageManager.getInstance().registerListener(this.jAm);
        MessageManager.getInstance().registerListener(this.jAp);
        MessageManager.getInstance().registerListener(this.jAn);
        MessageManager.getInstance().registerListener(this.jAo);
        MessageManager.getInstance().registerListener(this.mYoungsterModeChangeListener);
        this.jAq.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.jAq);
    }

    public void notifyDataSetChanged() {
        if (this.jAg != null && !HomePageStatic.jvh) {
            this.eKk.setAdapter(this.jAg);
            this.jAd.notifyDataSetChanged();
            this.jAx.a(this.jAy);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.jAg != null) {
            this.jAg.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.jAg != null) {
            this.jAg.d(dataRes, z);
        }
    }

    public void cJa() {
        if (this.jAg != null) {
            this.jAg.cJa();
        }
    }

    public void y(String str, int i, int i2) {
        if (this.eKk != null) {
            this.jAg.y(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.jAg = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.jAg.setScrollFragmentTabHost(this);
        this.eKk.setOffscreenPageLimit(2);
        this.eKk.setAdapter(this.jAg);
        int cIX = this.jAg.cIX();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.jAg;
        if (HomePageStatic.jvh) {
            cIX = 0;
        }
        this.eKk.setCurrentItem(newScrollFragmentAdapter.BT(cIX));
        this.jAd.setViewPager(this.eKk);
        this.jAd.setConcernTabIndex(this.jAg.BT(0));
        this.jAd.setHotTopicTabIndex(this.jAg.BT(5));
        this.jAd.setShowHotTopicRedTip(cJj());
    }

    private boolean cJj() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            if (currentTimeMillis - com.baidu.tbadk.core.sharedPref.b.bpu().getLong("unlogin_hot_top_timestamp", 0L) >= 86400000) {
                return true;
            }
        } else {
            long j = com.baidu.tbadk.core.sharedPref.b.bpu().getLong(TbadkApplication.getCurrentAccount(), 0L);
            if (!StringUtils.isNull(TbadkApplication.getCurrentAccount()) && currentTimeMillis - j >= 86400000) {
                return true;
            }
        }
        return false;
    }

    public boolean cJk() {
        return this.jAg != null && this.jAg.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.jAg.getCount()) {
            this.jAd.setTabItemClicked(z);
            this.jAg.BW(i);
            this.eKk.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.jAg.BT(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.jAg.BT(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.jAg.Ll(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jAd.setPageUniqueId(bdUniqueId);
        this.jAl.setTag(bdUniqueId);
        this.jAm.setTag(bdUniqueId);
        this.jAp.setTag(bdUniqueId);
        this.jAn.setTag(bdUniqueId);
        this.mYoungsterModeChangeListener.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.btY;
    }

    public int getCurrentTabType() {
        return this.jAg.BS(this.eKk.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.eKk.getAdapter() != null) {
            int count = this.eKk.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.jAg.BS(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int BZ(int i) {
        return this.jAg.BS(i);
    }

    public void onChangeSkinType(int i) {
        if (com.baidu.tbadk.a.d.bhw()) {
            com.baidu.tbadk.core.elementsMaven.c.bj(this.jAs).setBackGroundColor(R.color.CAM_X0208);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bj(this.jAs).k(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
        }
        this.jAt.onChangeSkinType();
        this.jAd.onChangeSkinType();
        if (this.mPageContext != null && this.giU != null) {
            this.giU.onChangeSkinType(this.mPageContext, i);
        }
        if (this.jAg != null) {
            this.jAg.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.ikr != null) {
            this.ikr.onChangeSkinType(this.mPageContext, i);
        }
        if (this.jAv != null) {
            this.jAv.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this.fPU, R.color.CAM_X0203);
        ap.setBackgroundResource(this.glq, R.drawable.personalize_tab_shadow);
    }

    private boolean bOI() {
        return this.glq.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.jAf = z;
        if (z) {
            if (this.fPU != null) {
                this.fPU.setVisibility(8);
            }
        } else if (this.fPU != null) {
            this.fPU.setVisibility(0);
        }
    }

    public void bOJ() {
        if (this.jAf && !bOI()) {
            this.glq.setVisibility(0);
            if (this.glt == null) {
                this.glt = new AlphaAnimation(0.0f, 1.0f);
                this.glt.setFillAfter(true);
                this.glt.setDuration(300L);
            }
            this.glq.startAnimation(this.glt);
        }
    }

    public void bOK() {
        if (this.jAf && bOI()) {
            if (this.glu == null) {
                this.glu = new AlphaAnimation(1.0f, 0.0f);
                this.glu.setFillAfter(true);
                this.glu.setDuration(300L);
                this.glu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.glq.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.glq.startAnimation(this.glu);
        }
    }

    public void cJc() {
        if (this.jAg != null) {
            this.jAg.cJc();
        }
    }

    public void bPo() {
        this.jAg.bPo();
    }

    public String getCurrentPageKey() {
        if (this.jAg != null) {
            return this.jAg.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.eKk != null) {
            return this.eKk.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.jAg != null) {
            this.jAg.setPrimary(z);
        }
        if (this.giU != null && z) {
            this.giU.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cJl() {
        this.jAg.a(this.jAz);
    }

    public void pI(boolean z) {
    }

    public void cJm() {
        if (this.jAs != null && !this.jAs.isSticky() && this.jAd != null && this.jAd.getTaskView() != null && this.jAd.getTaskView().getVisibility() != 0) {
            this.jAd.cJv();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.jAh = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.jAu != null) {
            this.jAu.Si();
            this.jAu = null;
        }
        cJp();
        MessageManager.getInstance().unRegisterListener(this.jAo);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.jAd != null && this.jAg.cIY()) {
            this.jAd.setShowConcernRedTip(z);
        }
    }

    public boolean cJe() {
        if (this.jAd == null || !this.jAg.cIY()) {
            return false;
        }
        return this.jAd.cJe();
    }

    public boolean cJf() {
        if (this.jAd == null || this.jAg == null || !this.jAg.cIZ()) {
            return false;
        }
        return this.jAd.cJf();
    }

    public void setVideoThreadId(String str) {
        if (this.jAg != null) {
            this.jAg.setVideoThreadId(str);
        }
    }

    public void cJn() {
        if (com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int BT = this.jAg != null ? this.jAg.BT(0) : 0;
            if (this.jAi == null) {
                this.jAi = new e(this.mPageContext, this.jAd.BX(BT));
                this.jAi.fq(R.drawable.bg_tip_blue_up);
                this.jAi.fp(32);
                this.jAi.oJ(true);
                this.jAi.setUseDirectOffset(true);
                this.jAi.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.jAi.fr(4000);
            }
            this.jAi.z(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cJo() {
        if (TbadkCoreApplication.isLogin()) {
            int BT = this.jAg != null ? this.jAg.BT(0) : 0;
            if (this.jAi == null) {
                this.jAi = new e(this.mPageContext, this.jAd.BX(BT));
                this.jAi.fq(R.drawable.bg_tip_blue_up_left);
                this.jAi.fp(16);
                this.jAi.oJ(true);
                this.jAi.xO(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.jAi.setUseDirectOffset(true);
                this.jAi.fr(4000);
            }
            this.jAi.aL(this.mContext.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void cJp() {
        if (this.jAi != null) {
            this.jAi.Si();
        }
    }

    public void onResume() {
        if (this.jAd != null) {
            this.jAd.onResume();
        }
    }

    public void a(a aVar) {
        if (this.jAj == null) {
            this.jAj = new ArrayList();
        }
        this.jAj.add(aVar);
    }

    public void b(a aVar) {
        if (this.jAj != null && this.jAj.size() > 0) {
            this.jAj.remove(aVar);
        }
    }

    /* loaded from: classes21.dex */
    public static abstract class a {
        public void cJq() {
        }

        public void cJr() {
        }

        public void cIm() {
        }
    }
}
