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
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.framework.e;
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
    private NoNetworkView gAv;
    private View gCR;
    private AlphaAnimation gCU;
    private AlphaAnimation gCV;
    private View gfy;
    private PluginErrorTipView iIQ;
    private boolean isPrimary;
    private com.baidu.tieba.homepage.framework.indicator.b keA;
    private e keB;
    private d keC;
    private HomeTabBarView kef;
    private TBSpecificationBtn keg;
    private boolean keh;
    private NewScrollFragmentAdapter kei;
    private b kej;
    private com.baidu.tieba.c.e kek;
    private List<a> kel;
    private boolean kem;
    CustomMessageListener ken;
    CustomMessageListener keo;
    CustomMessageListener kep;
    CustomMessageListener keq;
    CustomMessageListener ker;
    CustomMessageTask kes;
    CustomMessageTask ket;
    private StickyAppBarLayout keu;
    private NestedScrollHeader kev;
    private com.baidu.tieba.c.e kew;
    private com.baidu.tieba.homepage.concern.b kex;
    private boolean kez;
    private Context mContext;
    private TbPageContext mPageContext;
    CustomMessageListener mYoungsterModeChangeListener;

    /* loaded from: classes2.dex */
    public interface b {
        void BM(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.kem = false;
        this.ken = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bRQ();
                } else {
                    ScrollFragmentTabHost.this.bRR();
                }
            }
        };
        this.keo = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.kew != null) {
                    ScrollFragmentTabHost.this.kew.Tz();
                    ScrollFragmentTabHost.this.kew = null;
                }
            }
        };
        this.kep = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.kef.BJ(0);
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
                        if (ScrollFragmentTabHost.this.kef != null) {
                            ScrollFragmentTabHost.this.kex.setBackgroundAlpha(ScrollFragmentTabHost.this.kef.getBackgroundAlpha());
                            ScrollFragmentTabHost.this.kex.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        ScrollFragmentTabHost.this.kex.a(ScrollFragmentTabHost.this.keu);
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
        this.keq = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.kez != com.baidu.tbadk.a.d.bjg()) {
                    ScrollFragmentTabHost.this.kef.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bjg() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cPY();
                        ScrollFragmentTabHost.this.cPX();
                    }
                }
            }
        };
        this.ker = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
                    final String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.kef.BJ(0);
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
                if (ScrollFragmentTabHost.this.kei != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.kei.cPM();
                    if (!booleanValue || !c.bJf()) {
                        ScrollFragmentTabHost.this.kei.cPD();
                    } else {
                        ScrollFragmentTabHost.this.kei.cPC();
                    }
                    ScrollFragmentTabHost.this.kef.cRY();
                }
            }
        };
        this.kes = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.keu == null || ScrollFragmentTabHost.this.kev == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.kef.getTaskView() : ScrollFragmentTabHost.this.kev.getTaskView();
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
                    if (ScrollFragmentTabHost.this.kew != null) {
                        ScrollFragmentTabHost.this.kew.Tz();
                    }
                    ScrollFragmentTabHost.this.kew = new com.baidu.tieba.c.e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.kew.em(48);
                    ScrollFragmentTabHost.this.kew.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.kew.xh(4);
                    ScrollFragmentTabHost.this.kew.eo(i);
                    ScrollFragmentTabHost.this.kew.pJ(true);
                    ScrollFragmentTabHost.this.kew.xl(0);
                    ScrollFragmentTabHost.this.kew.IY(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.ket = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.keu == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bRR();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.keu.cQc();
                } else if (ScrollFragmentTabHost.this.keu.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.keu.cQc();
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
        this.keA = new com.baidu.tieba.homepage.framework.indicator.b();
        this.keB = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void BD(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.kei.BF(i), false);
                ScrollFragmentTabHost.this.kei.BH(i);
            }
        };
        this.keC = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void BC(int i) {
                ScrollFragmentTabHost.this.keA.a(i, ScrollFragmentTabHost.this.keB);
            }
        };
        init();
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kem = false;
        this.ken = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bRQ();
                } else {
                    ScrollFragmentTabHost.this.bRR();
                }
            }
        };
        this.keo = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.kew != null) {
                    ScrollFragmentTabHost.this.kew.Tz();
                    ScrollFragmentTabHost.this.kew = null;
                }
            }
        };
        this.kep = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.kef.BJ(0);
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
                        if (ScrollFragmentTabHost.this.kef != null) {
                            ScrollFragmentTabHost.this.kex.setBackgroundAlpha(ScrollFragmentTabHost.this.kef.getBackgroundAlpha());
                            ScrollFragmentTabHost.this.kex.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        ScrollFragmentTabHost.this.kex.a(ScrollFragmentTabHost.this.keu);
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
        this.keq = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.kez != com.baidu.tbadk.a.d.bjg()) {
                    ScrollFragmentTabHost.this.kef.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bjg() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cPY();
                        ScrollFragmentTabHost.this.cPX();
                    }
                }
            }
        };
        this.ker = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
                    final String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.kef.BJ(0);
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
                if (ScrollFragmentTabHost.this.kei != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.kei.cPM();
                    if (!booleanValue || !c.bJf()) {
                        ScrollFragmentTabHost.this.kei.cPD();
                    } else {
                        ScrollFragmentTabHost.this.kei.cPC();
                    }
                    ScrollFragmentTabHost.this.kef.cRY();
                }
            }
        };
        this.kes = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.keu == null || ScrollFragmentTabHost.this.kev == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.kef.getTaskView() : ScrollFragmentTabHost.this.kev.getTaskView();
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
                    if (ScrollFragmentTabHost.this.kew != null) {
                        ScrollFragmentTabHost.this.kew.Tz();
                    }
                    ScrollFragmentTabHost.this.kew = new com.baidu.tieba.c.e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.kew.em(48);
                    ScrollFragmentTabHost.this.kew.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.kew.xh(4);
                    ScrollFragmentTabHost.this.kew.eo(i);
                    ScrollFragmentTabHost.this.kew.pJ(true);
                    ScrollFragmentTabHost.this.kew.xl(0);
                    ScrollFragmentTabHost.this.kew.IY(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.ket = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.keu == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bRR();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.keu.cQc();
                } else if (ScrollFragmentTabHost.this.keu.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.keu.cQc();
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
        this.keA = new com.baidu.tieba.homepage.framework.indicator.b();
        this.keB = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void BD(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.kei.BF(i), false);
                ScrollFragmentTabHost.this.kei.BH(i);
            }
        };
        this.keC = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void BC(int i) {
                ScrollFragmentTabHost.this.keA.a(i, ScrollFragmentTabHost.this.keB);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.keu = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.kev = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.kef = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.iIQ = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.gAv = (NoNetworkView) findViewById(R.id.view_no_network);
        this.bCQ = (FrameLayout) findViewById(R.id.home_pager_container);
        this.eZd = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.gfy = findViewById(R.id.divider_line);
        this.gCR = findViewById(R.id.divider_shadow);
        this.keg = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.keg.setVisibility(8);
        this.kex = new com.baidu.tieba.homepage.concern.b(this.mContext);
        this.kez = com.baidu.tbadk.a.d.bjg();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.keu.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.bCQ.getLayoutParams()).topMargin = 0;
        this.kef.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.kei.onPageScrolled(i, f, i2);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.kej != null) {
                    ScrollFragmentTabHost.this.kej.BM(i);
                }
                com.baidu.tbadk.core.bigday.b.blb().jp(ScrollFragmentTabHost.this.kei.BE(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.BL(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                int BE = ScrollFragmentTabHost.this.kei.BE(ScrollFragmentTabHost.this.eZd.getCurrentItem());
                if (BE == 5) {
                    if (ScrollFragmentTabHost.this.kem) {
                        ScrollFragmentTabHost.this.kem = false;
                    } else {
                        ar arVar = new ar("c13740");
                        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar.ap("obj_type", ScrollFragmentTabHost.this.cPO() ? 1 : 0);
                        arVar.bsO();
                    }
                }
                if (BE == 0) {
                    ScrollFragmentTabHost.this.cPY();
                }
                View BJ = ScrollFragmentTabHost.this.kef.BJ(0);
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
                if (ScrollFragmentTabHost.this.kel != null && ScrollFragmentTabHost.this.kei != null) {
                    int BE2 = ScrollFragmentTabHost.this.kei.BE(ScrollFragmentTabHost.this.eZd.getCurrentItem());
                    if (BE2 == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar : ScrollFragmentTabHost.this.kel) {
                            aVar.cQa();
                        }
                    } else if (BE2 == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar2 : ScrollFragmentTabHost.this.kel) {
                            aVar2.cPZ();
                        }
                    } else if (BE2 == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar3 : ScrollFragmentTabHost.this.kel) {
                            aVar3.cOV();
                        }
                    } else if (BE2 == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (BE2 == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (BE2 == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    } else {
                        ScrollFragmentTabHost.this.bRR();
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
                    if (ScrollFragmentTabHost.this.kef.cPO()) {
                        ScrollFragmentTabHost.this.kef.setShowHotTopicRedTip(false);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean cPN = ScrollFragmentTabHost.this.cPN();
                    TiebaStatic.log(new ar("c12350").ap("obj_type", cPN ? 1 : 0));
                    if (cPN && ScrollFragmentTabHost.this.kei != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.kei.cPK();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.kef.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
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
                    arVar.ap("obj_type", ScrollFragmentTabHost.this.cPO() ? 1 : 0);
                    arVar.bsO();
                    ScrollFragmentTabHost.this.kem = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.brQ().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.brQ().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.kef.cPO()) {
                        ScrollFragmentTabHost.this.kef.setShowHotTopicRedTip(false);
                    }
                }
            }
        });
        this.keu.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void sd(boolean z) {
                if (z && ScrollFragmentTabHost.this.kew != null) {
                    ScrollFragmentTabHost.this.kew.Tz();
                }
            }
        });
        this.kev.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void LU(String str) {
                if (ScrollFragmentTabHost.this.kew != null) {
                    ScrollFragmentTabHost.this.kew.Tz();
                    ScrollFragmentTabHost.this.kew = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    bf.bsV().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.kev.setVisibility(8);
            this.kef.setMissionEntranceVisibility(true);
            this.kef.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void LU(String str) {
                    if (ScrollFragmentTabHost.this.kew != null) {
                        ScrollFragmentTabHost.this.kew.Tz();
                        ScrollFragmentTabHost.this.kew = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        bf.bsV().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.kev.setVisibility(0);
        this.kef.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.ket.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.ket);
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
        this.gAv.a(aVar);
        MessageManager.getInstance().registerListener(this.ken);
        MessageManager.getInstance().registerListener(this.keo);
        MessageManager.getInstance().registerListener(this.ker);
        MessageManager.getInstance().registerListener(this.kep);
        MessageManager.getInstance().registerListener(this.keq);
        MessageManager.getInstance().registerListener(this.mYoungsterModeChangeListener);
        this.kes.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.kes);
    }

    public void notifyDataSetChanged() {
        if (this.kei != null && !HomePageStatic.jZe) {
            this.eZd.setAdapter(this.kei);
            this.kef.notifyDataSetChanged();
            this.keA.a(this.keB);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.kei != null) {
            this.kei.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.kei != null) {
            this.kei.d(dataRes, z);
        }
    }

    public void cPJ() {
        if (this.kei != null) {
            this.kei.cPJ();
        }
    }

    public void z(String str, int i, int i2) {
        if (this.eZd != null) {
            this.kei.z(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.kei = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.kei.setScrollFragmentTabHost(this);
        this.eZd.setOffscreenPageLimit(2);
        this.eZd.setAdapter(this.kei);
        int cPG = this.kei.cPG();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.kei;
        if (HomePageStatic.jZe) {
            cPG = 0;
        }
        this.eZd.setCurrentItem(newScrollFragmentAdapter.BF(cPG));
        this.kef.setViewPager(this.eZd);
        this.kef.setConcernTabIndex(this.kei.BF(0));
        if (this.kei.cPF() != -1) {
            this.kef.setHotTopicTabIndex(this.kei.cPF());
            this.kef.setShowHotTopicRedTip(cPS());
        }
    }

    private boolean cPS() {
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

    public boolean cPT() {
        return this.kei != null && this.kei.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.kei.getCount()) {
            this.kef.setTabItemClicked(z);
            this.kei.BI(i);
            this.eZd.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.kei.BF(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.kei.BF(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.kei.LV(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.kef.setPageUniqueId(bdUniqueId);
        this.ken.setTag(bdUniqueId);
        this.keo.setTag(bdUniqueId);
        this.ker.setTag(bdUniqueId);
        this.kep.setTag(bdUniqueId);
        this.mYoungsterModeChangeListener.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.bCQ;
    }

    public int getCurrentTabType() {
        return this.kei.BE(this.eZd.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.eZd.getAdapter() != null) {
            int count = this.eZd.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.kei.BE(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int BL(int i) {
        return this.kei.BE(i);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.br(this.keu).l(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
        this.kev.onChangeSkinType();
        this.kef.onChangeSkinType();
        if (this.mPageContext != null && this.gAv != null) {
            this.gAv.onChangeSkinType(this.mPageContext, i);
        }
        if (this.kei != null) {
            this.kei.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.iIQ != null) {
            this.iIQ.onChangeSkinType(this.mPageContext, i);
        }
        if (this.kex != null) {
            this.kex.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this.gfy, R.color.CAM_X0203);
        ap.setBackgroundResource(this.gCR, R.drawable.personalize_tab_shadow);
    }

    private boolean bRP() {
        return this.gCR.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.keh = z;
        if (z) {
            if (this.gfy != null) {
                this.gfy.setVisibility(8);
            }
        } else if (this.gfy != null) {
            this.gfy.setVisibility(0);
        }
    }

    public void bRQ() {
        if (this.keh && !bRP()) {
            this.gCR.setVisibility(0);
            if (this.gCU == null) {
                this.gCU = new AlphaAnimation(0.0f, 1.0f);
                this.gCU.setFillAfter(true);
                this.gCU.setDuration(300L);
            }
            this.gCR.startAnimation(this.gCU);
        }
    }

    public void bRR() {
        if (this.keh && bRP()) {
            if (this.gCV == null) {
                this.gCV = new AlphaAnimation(1.0f, 0.0f);
                this.gCV.setFillAfter(true);
                this.gCV.setDuration(300L);
                this.gCV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.gCR.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gCR.startAnimation(this.gCV);
        }
    }

    public void cPL() {
        if (this.kei != null) {
            this.kei.cPL();
        }
    }

    public void bSx() {
        this.kei.bSx();
    }

    public String getCurrentPageKey() {
        if (this.kei != null) {
            return this.kei.getCurrentPageKey();
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
        if (this.kei != null) {
            this.kei.setPrimary(z);
        }
        if (this.gAv != null && z) {
            this.gAv.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cPU() {
        this.kei.a(this.keC);
    }

    public void qJ(boolean z) {
    }

    public void cPV() {
        if (this.keu != null && !this.keu.isSticky() && this.kef != null && this.kef.getTaskView() != null && this.kef.getTaskView().getVisibility() != 0) {
            this.kef.cQe();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.kej = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.kew != null) {
            this.kew.Tz();
            this.kew = null;
        }
        cPY();
        MessageManager.getInstance().unRegisterListener(this.keq);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.kef != null && this.kei.cPH()) {
            this.kef.setShowConcernRedTip(z);
        }
    }

    public boolean cPN() {
        if (this.kef == null || !this.kei.cPH()) {
            return false;
        }
        return this.kef.cPN();
    }

    public boolean cPO() {
        if (this.kef == null || this.kei == null || !this.kei.cPI()) {
            return false;
        }
        return this.kef.cPO();
    }

    public void setVideoThreadId(String str) {
        if (this.kei != null) {
            this.kei.setVideoThreadId(str);
        }
    }

    public void cPW() {
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int BF = this.kei != null ? this.kei.BF(0) : 0;
            if (this.kek == null) {
                this.kek = new com.baidu.tieba.c.e(this.mPageContext, this.kef.BJ(BF));
                this.kek.en(R.drawable.bg_tip_blue_up);
                this.kek.em(32);
                this.kek.pJ(true);
                this.kek.setUseDirectOffset(true);
                this.kek.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.kek.eo(4000);
            }
            this.kek.C(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cPX() {
        if (TbadkCoreApplication.isLogin()) {
            int BF = this.kei != null ? this.kei.BF(0) : 0;
            if (this.kek == null) {
                this.kek = new com.baidu.tieba.c.e(this.mPageContext, this.kef.BJ(BF));
                this.kek.en(R.drawable.bg_tip_blue_up_left);
                this.kek.em(16);
                this.kek.pJ(true);
                this.kek.xl(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.kek.setUseDirectOffset(true);
                this.kek.eo(4000);
            }
            this.kek.aJ(this.mContext.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void cPY() {
        if (this.kek != null) {
            this.kek.Tz();
        }
    }

    public void onResume() {
        if (this.kef != null) {
            this.kef.onResume();
        }
    }

    public void a(a aVar) {
        if (this.kel == null) {
            this.kel = new ArrayList();
        }
        this.kel.add(aVar);
    }

    public void b(a aVar) {
        if (this.kel != null && this.kel.size() > 0) {
            this.kel.remove(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class a {
        public void cPZ() {
        }

        public void cQa() {
        }

        public void cOV() {
        }
    }
}
