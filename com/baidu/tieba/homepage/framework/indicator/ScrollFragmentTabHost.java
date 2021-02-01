package com.baidu.tieba.homepage.framework.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
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
/* loaded from: classes2.dex */
public class ScrollFragmentTabHost extends RelativeLayout {
    private View.OnClickListener aEh;
    private FrameLayout bCQ;
    private CustomViewPager eZd;
    private NoNetworkView gAh;
    private View gCD;
    private AlphaAnimation gCG;
    private AlphaAnimation gCH;
    private View gft;
    private PluginErrorTipView iIC;
    private boolean isPrimary;
    private HomeTabBarView kdR;
    private TBSpecificationBtn kdS;
    private boolean kdT;
    private NewScrollFragmentAdapter kdU;
    private b kdV;
    private e kdW;
    private List<a> kdX;
    private boolean kdY;
    CustomMessageListener kdZ;
    CustomMessageListener kea;
    CustomMessageListener keb;
    CustomMessageListener kec;
    CustomMessageListener ked;
    CustomMessageTask kee;
    CustomMessageTask kef;
    private StickyAppBarLayout keg;
    private NestedScrollHeader keh;
    private e kei;
    private com.baidu.tieba.homepage.concern.b kej;
    private boolean kek;
    private com.baidu.tieba.homepage.framework.indicator.b kel;
    private com.baidu.tieba.homepage.framework.e kem;
    private d ken;
    private Context mContext;
    private TbPageContext mPageContext;
    CustomMessageListener mYoungsterModeChangeListener;

    /* loaded from: classes2.dex */
    public interface b {
        void BM(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.kdY = false;
        this.kdZ = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bRJ();
                } else {
                    ScrollFragmentTabHost.this.bRK();
                }
            }
        };
        this.kea = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.kei != null) {
                    ScrollFragmentTabHost.this.kei.Tz();
                    ScrollFragmentTabHost.this.kei = null;
                }
            }
        };
        this.keb = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.kdR.BJ(0);
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
                        if (ScrollFragmentTabHost.this.kdR != null) {
                            ScrollFragmentTabHost.this.kej.setBackgroundAlpha(ScrollFragmentTabHost.this.kdR.getBackgroundAlpha());
                            ScrollFragmentTabHost.this.kej.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        ScrollFragmentTabHost.this.kej.a(ScrollFragmentTabHost.this.keg);
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
        this.kec = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.kek != com.baidu.tbadk.a.d.bjg()) {
                    ScrollFragmentTabHost.this.kdR.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bjg() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cPR();
                        ScrollFragmentTabHost.this.cPQ();
                    }
                }
            }
        };
        this.ked = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
                    final String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.kdR.BJ(0);
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
                                com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_home_concern_all_status", 1);
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
                            com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.kdU != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.kdU.cPF();
                    if (!booleanValue || !c.bJf()) {
                        ScrollFragmentTabHost.this.kdU.cPw();
                    } else {
                        ScrollFragmentTabHost.this.kdU.cPv();
                    }
                    ScrollFragmentTabHost.this.kdR.cRR();
                }
            }
        };
        this.kee = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.keg == null || ScrollFragmentTabHost.this.keh == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.kdR.getTaskView() : ScrollFragmentTabHost.this.keh.getTaskView();
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
                    if (ScrollFragmentTabHost.this.kei != null) {
                        ScrollFragmentTabHost.this.kei.Tz();
                    }
                    ScrollFragmentTabHost.this.kei = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.kei.em(48);
                    ScrollFragmentTabHost.this.kei.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.kei.xh(4);
                    ScrollFragmentTabHost.this.kei.eo(i);
                    ScrollFragmentTabHost.this.kei.pJ(true);
                    ScrollFragmentTabHost.this.kei.xl(0);
                    ScrollFragmentTabHost.this.kei.IX(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.kef = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.keg == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bRK();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.keg.cPV();
                } else if (ScrollFragmentTabHost.this.keg.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.keg.cPV();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(ScrollFragmentTabHost.this.mPageContext.getPageActivity()).setType(9).setForumId("27307585").setForumName("贴吧众测").setShowHomepageTestBtn(true).send();
                }
            }
        };
        this.kel = new com.baidu.tieba.homepage.framework.indicator.b();
        this.kem = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void BD(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.kdU.BF(i), false);
                ScrollFragmentTabHost.this.kdU.BH(i);
            }
        };
        this.ken = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void BC(int i) {
                ScrollFragmentTabHost.this.kel.a(i, ScrollFragmentTabHost.this.kem);
            }
        };
        init();
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kdY = false;
        this.kdZ = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bRJ();
                } else {
                    ScrollFragmentTabHost.this.bRK();
                }
            }
        };
        this.kea = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.kei != null) {
                    ScrollFragmentTabHost.this.kei.Tz();
                    ScrollFragmentTabHost.this.kei = null;
                }
            }
        };
        this.keb = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.kdR.BJ(0);
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
                        if (ScrollFragmentTabHost.this.kdR != null) {
                            ScrollFragmentTabHost.this.kej.setBackgroundAlpha(ScrollFragmentTabHost.this.kdR.getBackgroundAlpha());
                            ScrollFragmentTabHost.this.kej.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        ScrollFragmentTabHost.this.kej.a(ScrollFragmentTabHost.this.keg);
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
        this.kec = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.kek != com.baidu.tbadk.a.d.bjg()) {
                    ScrollFragmentTabHost.this.kdR.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bjg() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cPR();
                        ScrollFragmentTabHost.this.cPQ();
                    }
                }
            }
        };
        this.ked = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
                    final String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.kdR.BJ(0);
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
                                com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_home_concern_all_status", 1);
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
                            com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.kdU != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.kdU.cPF();
                    if (!booleanValue || !c.bJf()) {
                        ScrollFragmentTabHost.this.kdU.cPw();
                    } else {
                        ScrollFragmentTabHost.this.kdU.cPv();
                    }
                    ScrollFragmentTabHost.this.kdR.cRR();
                }
            }
        };
        this.kee = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.keg == null || ScrollFragmentTabHost.this.keh == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.kdR.getTaskView() : ScrollFragmentTabHost.this.keh.getTaskView();
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
                    if (ScrollFragmentTabHost.this.kei != null) {
                        ScrollFragmentTabHost.this.kei.Tz();
                    }
                    ScrollFragmentTabHost.this.kei = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.kei.em(48);
                    ScrollFragmentTabHost.this.kei.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.kei.xh(4);
                    ScrollFragmentTabHost.this.kei.eo(i);
                    ScrollFragmentTabHost.this.kei.pJ(true);
                    ScrollFragmentTabHost.this.kei.xl(0);
                    ScrollFragmentTabHost.this.kei.IX(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.kef = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.keg == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bRK();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.keg.cPV();
                } else if (ScrollFragmentTabHost.this.keg.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.keg.cPV();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(ScrollFragmentTabHost.this.mPageContext.getPageActivity()).setType(9).setForumId("27307585").setForumName("贴吧众测").setShowHomepageTestBtn(true).send();
                }
            }
        };
        this.kel = new com.baidu.tieba.homepage.framework.indicator.b();
        this.kem = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void BD(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.kdU.BF(i), false);
                ScrollFragmentTabHost.this.kdU.BH(i);
            }
        };
        this.ken = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void BC(int i) {
                ScrollFragmentTabHost.this.kel.a(i, ScrollFragmentTabHost.this.kem);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.keg = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.keh = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.kdR = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.iIC = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.gAh = (NoNetworkView) findViewById(R.id.view_no_network);
        this.bCQ = (FrameLayout) findViewById(R.id.home_pager_container);
        this.eZd = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.gft = findViewById(R.id.divider_line);
        this.gCD = findViewById(R.id.divider_shadow);
        this.kdS = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.kdS.setVisibility(8);
        this.kej = new com.baidu.tieba.homepage.concern.b(this.mContext);
        this.kek = com.baidu.tbadk.a.d.bjg();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.keg.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.bCQ.getLayoutParams()).topMargin = 0;
        this.kdR.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.kdU.onPageScrolled(i, f, i2);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.kdV != null) {
                    ScrollFragmentTabHost.this.kdV.BM(i);
                }
                com.baidu.tbadk.core.bigday.b.blb().jp(ScrollFragmentTabHost.this.kdU.BE(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.BL(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                int BE = ScrollFragmentTabHost.this.kdU.BE(ScrollFragmentTabHost.this.eZd.getCurrentItem());
                if (BE == 5) {
                    if (ScrollFragmentTabHost.this.kdY) {
                        ScrollFragmentTabHost.this.kdY = false;
                    } else {
                        ar arVar = new ar("c13740");
                        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar.ap("obj_type", ScrollFragmentTabHost.this.cPH() ? 1 : 0);
                        arVar.bsO();
                    }
                }
                if (BE == 0) {
                    ScrollFragmentTabHost.this.cPR();
                }
                View BJ = ScrollFragmentTabHost.this.kdR.BJ(0);
                if ((BJ instanceof LinearLayout) && TbadkCoreApplication.isLogin() && com.baidu.tbadk.a.d.bjg()) {
                    LinearLayout linearLayout = (LinearLayout) BJ;
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                        if (BE == 0) {
                            imageView.setVisibility(0);
                        } else {
                            imageView.setVisibility(4);
                        }
                    }
                }
                if (ScrollFragmentTabHost.this.kdX != null && ScrollFragmentTabHost.this.kdU != null) {
                    int BE2 = ScrollFragmentTabHost.this.kdU.BE(ScrollFragmentTabHost.this.eZd.getCurrentItem());
                    if (BE2 == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar : ScrollFragmentTabHost.this.kdX) {
                            aVar.cPT();
                        }
                    } else if (BE2 == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar2 : ScrollFragmentTabHost.this.kdX) {
                            aVar2.cPS();
                        }
                    } else if (BE2 == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar3 : ScrollFragmentTabHost.this.kdX) {
                            aVar3.cOO();
                        }
                    } else if (BE2 == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (BE2 == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (BE2 == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    } else {
                        ScrollFragmentTabHost.this.bRK();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.BL(i));
                if (ScrollFragmentTabHost.this.BL(i) == 5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.brQ().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.brQ().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.kdR.cPH()) {
                        ScrollFragmentTabHost.this.kdR.setShowHotTopicRedTip(false);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean cPG = ScrollFragmentTabHost.this.cPG();
                    TiebaStatic.log(new ar("c12350").ap("obj_type", cPG ? 1 : 0));
                    if (cPG && ScrollFragmentTabHost.this.kdU != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.kdU.cPD();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.kdR.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void t(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.eZd.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.BL(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.BL(i) == 7) {
                    TiebaStatic.log(new ar("c13483").dR("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.BL(i) == 8) {
                    TiebaStatic.log(new ar("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.BL(i));
                if (ScrollFragmentTabHost.this.BL(i) == 5) {
                    ar arVar = new ar("c13740");
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.ap("obj_type", ScrollFragmentTabHost.this.cPH() ? 1 : 0);
                    arVar.bsO();
                    ScrollFragmentTabHost.this.kdY = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.brQ().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.brQ().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.kdR.cPH()) {
                        ScrollFragmentTabHost.this.kdR.setShowHotTopicRedTip(false);
                    }
                }
            }
        });
        this.keg.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void sd(boolean z) {
                if (z && ScrollFragmentTabHost.this.kei != null) {
                    ScrollFragmentTabHost.this.kei.Tz();
                }
            }
        });
        this.keh.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void LT(String str) {
                if (ScrollFragmentTabHost.this.kei != null) {
                    ScrollFragmentTabHost.this.kei.Tz();
                    ScrollFragmentTabHost.this.kei = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    bf.bsV().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.keh.setVisibility(8);
            this.kdR.setMissionEntranceVisibility(true);
            this.kdR.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void LT(String str) {
                    if (ScrollFragmentTabHost.this.kei != null) {
                        ScrollFragmentTabHost.this.kei.Tz();
                        ScrollFragmentTabHost.this.kei = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        bf.bsV().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.keh.setVisibility(0);
        this.kdR.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.kef.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.kef);
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
        this.gAh.a(aVar);
        MessageManager.getInstance().registerListener(this.kdZ);
        MessageManager.getInstance().registerListener(this.kea);
        MessageManager.getInstance().registerListener(this.ked);
        MessageManager.getInstance().registerListener(this.keb);
        MessageManager.getInstance().registerListener(this.kec);
        MessageManager.getInstance().registerListener(this.mYoungsterModeChangeListener);
        this.kee.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.kee);
    }

    public void notifyDataSetChanged() {
        if (this.kdU != null && !HomePageStatic.jYQ) {
            this.eZd.setAdapter(this.kdU);
            this.kdR.notifyDataSetChanged();
            this.kel.a(this.kem);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.kdU != null) {
            this.kdU.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.kdU != null) {
            this.kdU.d(dataRes, z);
        }
    }

    public void cPC() {
        if (this.kdU != null) {
            this.kdU.cPC();
        }
    }

    public void z(String str, int i, int i2) {
        if (this.eZd != null) {
            this.kdU.z(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.kdU = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.kdU.setScrollFragmentTabHost(this);
        this.eZd.setOffscreenPageLimit(2);
        this.eZd.setAdapter(this.kdU);
        int cPz = this.kdU.cPz();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.kdU;
        if (HomePageStatic.jYQ) {
            cPz = 0;
        }
        this.eZd.setCurrentItem(newScrollFragmentAdapter.BF(cPz));
        this.kdR.setViewPager(this.eZd);
        this.kdR.setConcernTabIndex(this.kdU.BF(0));
        if (this.kdU.cPy() != -1) {
            this.kdR.setHotTopicTabIndex(this.kdU.cPy());
            this.kdR.setShowHotTopicRedTip(cPL());
        }
    }

    private boolean cPL() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            if (currentTimeMillis - com.baidu.tbadk.core.sharedPref.b.brQ().getLong("unlogin_hot_top_timestamp", 0L) >= 86400000) {
                return true;
            }
        } else {
            long j = com.baidu.tbadk.core.sharedPref.b.brQ().getLong(TbadkApplication.getCurrentAccount(), 0L);
            if (!StringUtils.isNull(TbadkApplication.getCurrentAccount()) && currentTimeMillis - j >= 86400000) {
                return true;
            }
        }
        return false;
    }

    public boolean cPM() {
        return this.kdU != null && this.kdU.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.kdU.getCount()) {
            this.kdR.setTabItemClicked(z);
            this.kdU.BI(i);
            this.eZd.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.kdU.BF(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.kdU.BF(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.kdU.LU(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.kdR.setPageUniqueId(bdUniqueId);
        this.kdZ.setTag(bdUniqueId);
        this.kea.setTag(bdUniqueId);
        this.ked.setTag(bdUniqueId);
        this.keb.setTag(bdUniqueId);
        this.mYoungsterModeChangeListener.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.bCQ;
    }

    public int getCurrentTabType() {
        return this.kdU.BE(this.eZd.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.eZd.getAdapter() != null) {
            int count = this.eZd.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.kdU.BE(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int BL(int i) {
        return this.kdU.BE(i);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.br(this.keg).l(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
        this.keh.onChangeSkinType();
        this.kdR.onChangeSkinType();
        if (this.mPageContext != null && this.gAh != null) {
            this.gAh.onChangeSkinType(this.mPageContext, i);
        }
        if (this.kdU != null) {
            this.kdU.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.iIC != null) {
            this.iIC.onChangeSkinType(this.mPageContext, i);
        }
        if (this.kej != null) {
            this.kej.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this.gft, R.color.CAM_X0203);
        ap.setBackgroundResource(this.gCD, R.drawable.personalize_tab_shadow);
    }

    private boolean bRI() {
        return this.gCD.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.kdT = z;
        if (z) {
            if (this.gft != null) {
                this.gft.setVisibility(8);
            }
        } else if (this.gft != null) {
            this.gft.setVisibility(0);
        }
    }

    public void bRJ() {
        if (this.kdT && !bRI()) {
            this.gCD.setVisibility(0);
            if (this.gCG == null) {
                this.gCG = new AlphaAnimation(0.0f, 1.0f);
                this.gCG.setFillAfter(true);
                this.gCG.setDuration(300L);
            }
            this.gCD.startAnimation(this.gCG);
        }
    }

    public void bRK() {
        if (this.kdT && bRI()) {
            if (this.gCH == null) {
                this.gCH = new AlphaAnimation(1.0f, 0.0f);
                this.gCH.setFillAfter(true);
                this.gCH.setDuration(300L);
                this.gCH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.gCD.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gCD.startAnimation(this.gCH);
        }
    }

    public void cPE() {
        if (this.kdU != null) {
            this.kdU.cPE();
        }
    }

    public void bSq() {
        this.kdU.bSq();
    }

    public String getCurrentPageKey() {
        if (this.kdU != null) {
            return this.kdU.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.eZd != null) {
            return this.eZd.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.kdU != null) {
            this.kdU.setPrimary(z);
        }
        if (this.gAh != null && z) {
            this.gAh.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cPN() {
        this.kdU.a(this.ken);
    }

    public void qJ(boolean z) {
    }

    public void cPO() {
        if (this.keg != null && !this.keg.isSticky() && this.kdR != null && this.kdR.getTaskView() != null && this.kdR.getTaskView().getVisibility() != 0) {
            this.kdR.cPX();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.kdV = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.kei != null) {
            this.kei.Tz();
            this.kei = null;
        }
        cPR();
        MessageManager.getInstance().unRegisterListener(this.kec);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.kdR != null && this.kdU.cPA()) {
            this.kdR.setShowConcernRedTip(z);
        }
    }

    public boolean cPG() {
        if (this.kdR == null || !this.kdU.cPA()) {
            return false;
        }
        return this.kdR.cPG();
    }

    public boolean cPH() {
        if (this.kdR == null || this.kdU == null || !this.kdU.cPB()) {
            return false;
        }
        return this.kdR.cPH();
    }

    public void setVideoThreadId(String str) {
        if (this.kdU != null) {
            this.kdU.setVideoThreadId(str);
        }
    }

    public void cPP() {
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int BF = this.kdU != null ? this.kdU.BF(0) : 0;
            if (this.kdW == null) {
                this.kdW = new e(this.mPageContext, this.kdR.BJ(BF));
                this.kdW.en(R.drawable.bg_tip_blue_up);
                this.kdW.em(32);
                this.kdW.pJ(true);
                this.kdW.setUseDirectOffset(true);
                this.kdW.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.kdW.eo(4000);
            }
            this.kdW.C(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cPQ() {
        if (TbadkCoreApplication.isLogin()) {
            int BF = this.kdU != null ? this.kdU.BF(0) : 0;
            if (this.kdW == null) {
                this.kdW = new e(this.mPageContext, this.kdR.BJ(BF));
                this.kdW.en(R.drawable.bg_tip_blue_up_left);
                this.kdW.em(16);
                this.kdW.pJ(true);
                this.kdW.xl(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.kdW.setUseDirectOffset(true);
                this.kdW.eo(4000);
            }
            this.kdW.aJ(this.mContext.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void cPR() {
        if (this.kdW != null) {
            this.kdW.Tz();
        }
    }

    public void onResume() {
        if (this.kdR != null) {
            this.kdR.onResume();
        }
    }

    public void a(a aVar) {
        if (this.kdX == null) {
            this.kdX = new ArrayList();
        }
        this.kdX.add(aVar);
    }

    public void b(a aVar) {
        if (this.kdX != null && this.kdX.size() > 0) {
            this.kdX.remove(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class a {
        public void cPS() {
        }

        public void cPT() {
        }

        public void cOO() {
        }
    }
}
