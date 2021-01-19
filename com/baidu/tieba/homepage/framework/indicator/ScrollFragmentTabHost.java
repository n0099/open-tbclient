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
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes2.dex */
public class ScrollFragmentTabHost extends RelativeLayout {
    private View.OnClickListener aCu;
    private FrameLayout bzk;
    private CustomViewPager eWN;
    private View gde;
    private NoNetworkView gxx;
    private View gzT;
    private AlphaAnimation gzW;
    private AlphaAnimation gzX;
    private PluginErrorTipView iCS;
    private boolean isPrimary;
    CustomMessageListener jWA;
    CustomMessageListener jWB;
    CustomMessageListener jWC;
    CustomMessageTask jWD;
    CustomMessageTask jWE;
    private StickyAppBarLayout jWF;
    private NestedScrollHeader jWG;
    private e jWH;
    private com.baidu.tieba.homepage.concern.b jWI;
    private boolean jWJ;
    private com.baidu.tieba.homepage.framework.indicator.b jWK;
    private com.baidu.tieba.homepage.framework.e jWL;
    private d jWM;
    private HomeTabBarView jWq;
    private TBSpecificationBtn jWr;
    private boolean jWs;
    private NewScrollFragmentAdapter jWt;
    private b jWu;
    private e jWv;
    private List<a> jWw;
    private boolean jWx;
    CustomMessageListener jWy;
    CustomMessageListener jWz;
    private Context mContext;
    private TbPageContext mPageContext;
    CustomMessageListener mYoungsterModeChangeListener;

    /* loaded from: classes2.dex */
    public interface b {
        void Bw(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.jWx = false;
        this.jWy = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bRg();
                } else {
                    ScrollFragmentTabHost.this.bRh();
                }
            }
        };
        this.jWz = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.jWH != null) {
                    ScrollFragmentTabHost.this.jWH.RS();
                    ScrollFragmentTabHost.this.jWH = null;
                }
            }
        };
        this.jWA = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jWq.Bt(0);
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
                        if (ScrollFragmentTabHost.this.jWq != null) {
                            ScrollFragmentTabHost.this.jWI.setBackgroundAlpha(ScrollFragmentTabHost.this.jWq.getBackgroundAlpha());
                            ScrollFragmentTabHost.this.jWI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        ScrollFragmentTabHost.this.jWI.a(ScrollFragmentTabHost.this.jWF);
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
        this.jWB = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.jWJ != com.baidu.tbadk.a.d.biU()) {
                    ScrollFragmentTabHost.this.jWq.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.biU() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cNU();
                        ScrollFragmentTabHost.this.cNT();
                    }
                }
            }
        };
        this.jWC = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
                    final String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jWq.Bt(0);
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
                                com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_home_concern_all_status", 1);
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
                            com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.jWt != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.jWt.cNI();
                    if (!booleanValue || !c.bIM()) {
                        ScrollFragmentTabHost.this.jWt.cNA();
                    } else {
                        ScrollFragmentTabHost.this.jWt.cNz();
                    }
                    ScrollFragmentTabHost.this.jWq.cPS();
                }
            }
        };
        this.jWD = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.jWF == null || ScrollFragmentTabHost.this.jWG == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.jWq.getTaskView() : ScrollFragmentTabHost.this.jWG.getTaskView();
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
                    if (ScrollFragmentTabHost.this.jWH != null) {
                        ScrollFragmentTabHost.this.jWH.RS();
                    }
                    ScrollFragmentTabHost.this.jWH = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.jWH.ei(48);
                    ScrollFragmentTabHost.this.jWH.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.jWH.wX(4);
                    ScrollFragmentTabHost.this.jWH.ek(i);
                    ScrollFragmentTabHost.this.jWH.pz(true);
                    ScrollFragmentTabHost.this.jWH.xb(0);
                    ScrollFragmentTabHost.this.jWH.Im(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.jWE = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.jWF == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bRh();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.jWF.cNY();
                } else if (ScrollFragmentTabHost.this.jWF.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.jWF.cNY();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aCu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(ScrollFragmentTabHost.this.mPageContext.getPageActivity()).setType(9).setForumId("27307585").setForumName("贴吧众测").setShowHomepageTestBtn(true).send();
                }
            }
        };
        this.jWK = new com.baidu.tieba.homepage.framework.indicator.b();
        this.jWL = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void Bn(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.jWt.Bp(i), false);
                ScrollFragmentTabHost.this.jWt.Br(i);
            }
        };
        this.jWM = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void Bm(int i) {
                ScrollFragmentTabHost.this.jWK.a(i, ScrollFragmentTabHost.this.jWL);
            }
        };
        init();
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jWx = false;
        this.jWy = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bRg();
                } else {
                    ScrollFragmentTabHost.this.bRh();
                }
            }
        };
        this.jWz = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.jWH != null) {
                    ScrollFragmentTabHost.this.jWH.RS();
                    ScrollFragmentTabHost.this.jWH = null;
                }
            }
        };
        this.jWA = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jWq.Bt(0);
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
                        if (ScrollFragmentTabHost.this.jWq != null) {
                            ScrollFragmentTabHost.this.jWI.setBackgroundAlpha(ScrollFragmentTabHost.this.jWq.getBackgroundAlpha());
                            ScrollFragmentTabHost.this.jWI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        ScrollFragmentTabHost.this.jWI.a(ScrollFragmentTabHost.this.jWF);
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
        this.jWB = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.jWJ != com.baidu.tbadk.a.d.biU()) {
                    ScrollFragmentTabHost.this.jWq.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.biU() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cNU();
                        ScrollFragmentTabHost.this.cNT();
                    }
                }
            }
        };
        this.jWC = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
                    final String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jWq.Bt(0);
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
                                com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_home_concern_all_status", 1);
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
                            com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.jWt != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.jWt.cNI();
                    if (!booleanValue || !c.bIM()) {
                        ScrollFragmentTabHost.this.jWt.cNA();
                    } else {
                        ScrollFragmentTabHost.this.jWt.cNz();
                    }
                    ScrollFragmentTabHost.this.jWq.cPS();
                }
            }
        };
        this.jWD = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.jWF == null || ScrollFragmentTabHost.this.jWG == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.jWq.getTaskView() : ScrollFragmentTabHost.this.jWG.getTaskView();
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
                    if (ScrollFragmentTabHost.this.jWH != null) {
                        ScrollFragmentTabHost.this.jWH.RS();
                    }
                    ScrollFragmentTabHost.this.jWH = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.jWH.ei(48);
                    ScrollFragmentTabHost.this.jWH.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.jWH.wX(4);
                    ScrollFragmentTabHost.this.jWH.ek(i);
                    ScrollFragmentTabHost.this.jWH.pz(true);
                    ScrollFragmentTabHost.this.jWH.xb(0);
                    ScrollFragmentTabHost.this.jWH.Im(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.jWE = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.jWF == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bRh();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.jWF.cNY();
                } else if (ScrollFragmentTabHost.this.jWF.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.jWF.cNY();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aCu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(ScrollFragmentTabHost.this.mPageContext.getPageActivity()).setType(9).setForumId("27307585").setForumName("贴吧众测").setShowHomepageTestBtn(true).send();
                }
            }
        };
        this.jWK = new com.baidu.tieba.homepage.framework.indicator.b();
        this.jWL = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void Bn(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.jWt.Bp(i), false);
                ScrollFragmentTabHost.this.jWt.Br(i);
            }
        };
        this.jWM = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void Bm(int i) {
                ScrollFragmentTabHost.this.jWK.a(i, ScrollFragmentTabHost.this.jWL);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.jWF = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.jWG = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.jWq = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.iCS = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.gxx = (NoNetworkView) findViewById(R.id.view_no_network);
        this.bzk = (FrameLayout) findViewById(R.id.home_pager_container);
        this.eWN = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.gde = findViewById(R.id.divider_line);
        this.gzT = findViewById(R.id.divider_shadow);
        this.jWr = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.jWr.setVisibility(8);
        this.jWI = new com.baidu.tieba.homepage.concern.b(this.mContext);
        this.jWJ = com.baidu.tbadk.a.d.biU();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.jWF.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.bzk.getLayoutParams()).topMargin = 0;
        this.jWq.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.jWt.onPageScrolled(i, f, i2);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.jWu != null) {
                    ScrollFragmentTabHost.this.jWu.Bw(i);
                }
                com.baidu.tbadk.core.bigday.b.bkJ().jn(ScrollFragmentTabHost.this.jWt.Bo(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.Bv(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                int Bo = ScrollFragmentTabHost.this.jWt.Bo(ScrollFragmentTabHost.this.eWN.getCurrentItem());
                if (Bo == 5) {
                    if (ScrollFragmentTabHost.this.jWx) {
                        ScrollFragmentTabHost.this.jWx = false;
                    } else {
                        aq aqVar = new aq("c13740");
                        aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar.an("obj_type", ScrollFragmentTabHost.this.cNK() ? 1 : 0);
                        aqVar.bsu();
                    }
                }
                if (Bo == 0) {
                    ScrollFragmentTabHost.this.cNU();
                }
                View Bt = ScrollFragmentTabHost.this.jWq.Bt(0);
                if ((Bt instanceof LinearLayout) && TbadkCoreApplication.isLogin() && com.baidu.tbadk.a.d.biU()) {
                    LinearLayout linearLayout = (LinearLayout) Bt;
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                        if (Bo == 0) {
                            imageView.setVisibility(0);
                        } else {
                            imageView.setVisibility(4);
                        }
                    }
                }
                if (ScrollFragmentTabHost.this.jWw != null && ScrollFragmentTabHost.this.jWt != null) {
                    int Bo2 = ScrollFragmentTabHost.this.jWt.Bo(ScrollFragmentTabHost.this.eWN.getCurrentItem());
                    if (Bo2 == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar : ScrollFragmentTabHost.this.jWw) {
                            aVar.cNW();
                        }
                    } else if (Bo2 == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar2 : ScrollFragmentTabHost.this.jWw) {
                            aVar2.cNV();
                        }
                    } else if (Bo2 == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar3 : ScrollFragmentTabHost.this.jWw) {
                            aVar3.cMR();
                        }
                    } else if (Bo2 == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (Bo2 == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (Bo2 == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    } else {
                        ScrollFragmentTabHost.this.bRh();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.Bv(i));
                if (ScrollFragmentTabHost.this.Bv(i) == 5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.brx().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.brx().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.jWq.cNK()) {
                        ScrollFragmentTabHost.this.jWq.setShowHotTopicRedTip(false);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean cNJ = ScrollFragmentTabHost.this.cNJ();
                    TiebaStatic.log(new aq("c12350").an("obj_type", cNJ ? 1 : 0));
                    if (cNJ && ScrollFragmentTabHost.this.jWt != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.jWt.cNG();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.jWq.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void t(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.eWN.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.Bv(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.Bv(i) == 7) {
                    TiebaStatic.log(new aq("c13483").dW("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.Bv(i) == 8) {
                    TiebaStatic.log(new aq("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.Bv(i));
                if (ScrollFragmentTabHost.this.Bv(i) == 5) {
                    aq aqVar = new aq("c13740");
                    aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.an("obj_type", ScrollFragmentTabHost.this.cNK() ? 1 : 0);
                    aqVar.bsu();
                    ScrollFragmentTabHost.this.jWx = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.brx().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.brx().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.jWq.cNK()) {
                        ScrollFragmentTabHost.this.jWq.setShowHotTopicRedTip(false);
                    }
                }
            }
        });
        this.jWF.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void rR(boolean z) {
                if (z && ScrollFragmentTabHost.this.jWH != null) {
                    ScrollFragmentTabHost.this.jWH.RS();
                }
            }
        });
        this.jWG.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void Lj(String str) {
                if (ScrollFragmentTabHost.this.jWH != null) {
                    ScrollFragmentTabHost.this.jWH.RS();
                    ScrollFragmentTabHost.this.jWH = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    be.bsB().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.jWG.setVisibility(8);
            this.jWq.setMissionEntranceVisibility(true);
            this.jWq.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void Lj(String str) {
                    if (ScrollFragmentTabHost.this.jWH != null) {
                        ScrollFragmentTabHost.this.jWH.RS();
                        ScrollFragmentTabHost.this.jWH = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        be.bsB().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.jWG.setVisibility(0);
        this.jWq.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.jWE.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.jWE);
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
        this.gxx.a(aVar);
        MessageManager.getInstance().registerListener(this.jWy);
        MessageManager.getInstance().registerListener(this.jWz);
        MessageManager.getInstance().registerListener(this.jWC);
        MessageManager.getInstance().registerListener(this.jWA);
        MessageManager.getInstance().registerListener(this.jWB);
        MessageManager.getInstance().registerListener(this.mYoungsterModeChangeListener);
        this.jWD.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.jWD);
    }

    public void notifyDataSetChanged() {
        if (this.jWt != null && !HomePageStatic.jRo) {
            this.eWN.setAdapter(this.jWt);
            this.jWq.notifyDataSetChanged();
            this.jWK.a(this.jWL);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.jWt != null) {
            this.jWt.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.jWt != null) {
            this.jWt.d(dataRes, z);
        }
    }

    public void cNF() {
        if (this.jWt != null) {
            this.jWt.cNF();
        }
    }

    public void z(String str, int i, int i2) {
        if (this.eWN != null) {
            this.jWt.z(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.jWt = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.jWt.setScrollFragmentTabHost(this);
        this.eWN.setOffscreenPageLimit(2);
        this.eWN.setAdapter(this.jWt);
        int cNC = this.jWt.cNC();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.jWt;
        if (HomePageStatic.jRo) {
            cNC = 0;
        }
        this.eWN.setCurrentItem(newScrollFragmentAdapter.Bp(cNC));
        this.jWq.setViewPager(this.eWN);
        this.jWq.setConcernTabIndex(this.jWt.Bp(0));
        this.jWq.setHotTopicTabIndex(this.jWt.Bp(5));
        this.jWq.setShowHotTopicRedTip(cNO());
    }

    private boolean cNO() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            if (currentTimeMillis - com.baidu.tbadk.core.sharedPref.b.brx().getLong("unlogin_hot_top_timestamp", 0L) >= 86400000) {
                return true;
            }
        } else {
            long j = com.baidu.tbadk.core.sharedPref.b.brx().getLong(TbadkApplication.getCurrentAccount(), 0L);
            if (!StringUtils.isNull(TbadkApplication.getCurrentAccount()) && currentTimeMillis - j >= 86400000) {
                return true;
            }
        }
        return false;
    }

    public boolean cNP() {
        return this.jWt != null && this.jWt.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.jWt.getCount()) {
            this.jWq.setTabItemClicked(z);
            this.jWt.Bs(i);
            this.eWN.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.jWt.Bp(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.jWt.Bp(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.jWt.Lk(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jWq.setPageUniqueId(bdUniqueId);
        this.jWy.setTag(bdUniqueId);
        this.jWz.setTag(bdUniqueId);
        this.jWC.setTag(bdUniqueId);
        this.jWA.setTag(bdUniqueId);
        this.mYoungsterModeChangeListener.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.bzk;
    }

    public int getCurrentTabType() {
        return this.jWt.Bo(this.eWN.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.eWN.getAdapter() != null) {
            int count = this.eWN.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.jWt.Bo(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int Bv(int i) {
        return this.jWt.Bo(i);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jWF).l(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
        this.jWG.onChangeSkinType();
        this.jWq.onChangeSkinType();
        if (this.mPageContext != null && this.gxx != null) {
            this.gxx.onChangeSkinType(this.mPageContext, i);
        }
        if (this.jWt != null) {
            this.jWt.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.iCS != null) {
            this.iCS.onChangeSkinType(this.mPageContext, i);
        }
        if (this.jWI != null) {
            this.jWI.onChangeSkinType(i);
        }
        ao.setBackgroundColor(this.gde, R.color.CAM_X0203);
        ao.setBackgroundResource(this.gzT, R.drawable.personalize_tab_shadow);
    }

    private boolean bRf() {
        return this.gzT.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.jWs = z;
        if (z) {
            if (this.gde != null) {
                this.gde.setVisibility(8);
            }
        } else if (this.gde != null) {
            this.gde.setVisibility(0);
        }
    }

    public void bRg() {
        if (this.jWs && !bRf()) {
            this.gzT.setVisibility(0);
            if (this.gzW == null) {
                this.gzW = new AlphaAnimation(0.0f, 1.0f);
                this.gzW.setFillAfter(true);
                this.gzW.setDuration(300L);
            }
            this.gzT.startAnimation(this.gzW);
        }
    }

    public void bRh() {
        if (this.jWs && bRf()) {
            if (this.gzX == null) {
                this.gzX = new AlphaAnimation(1.0f, 0.0f);
                this.gzX.setFillAfter(true);
                this.gzX.setDuration(300L);
                this.gzX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.gzT.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gzT.startAnimation(this.gzX);
        }
    }

    public void cNH() {
        if (this.jWt != null) {
            this.jWt.cNH();
        }
    }

    public void bRN() {
        this.jWt.bRN();
    }

    public String getCurrentPageKey() {
        if (this.jWt != null) {
            return this.jWt.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.eWN != null) {
            return this.eWN.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.jWt != null) {
            this.jWt.setPrimary(z);
        }
        if (this.gxx != null && z) {
            this.gxx.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cNQ() {
        this.jWt.a(this.jWM);
    }

    public void qz(boolean z) {
    }

    public void cNR() {
        if (this.jWF != null && !this.jWF.isSticky() && this.jWq != null && this.jWq.getTaskView() != null && this.jWq.getTaskView().getVisibility() != 0) {
            this.jWq.cOa();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.jWu = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.jWH != null) {
            this.jWH.RS();
            this.jWH = null;
        }
        cNU();
        MessageManager.getInstance().unRegisterListener(this.jWB);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.jWq != null && this.jWt.cND()) {
            this.jWq.setShowConcernRedTip(z);
        }
    }

    public boolean cNJ() {
        if (this.jWq == null || !this.jWt.cND()) {
            return false;
        }
        return this.jWq.cNJ();
    }

    public boolean cNK() {
        if (this.jWq == null || this.jWt == null || !this.jWt.cNE()) {
            return false;
        }
        return this.jWq.cNK();
    }

    public void setVideoThreadId(String str) {
        if (this.jWt != null) {
            this.jWt.setVideoThreadId(str);
        }
    }

    public void cNS() {
        if (com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int Bp = this.jWt != null ? this.jWt.Bp(0) : 0;
            if (this.jWv == null) {
                this.jWv = new e(this.mPageContext, this.jWq.Bt(Bp));
                this.jWv.ej(R.drawable.bg_tip_blue_up);
                this.jWv.ei(32);
                this.jWv.pz(true);
                this.jWv.setUseDirectOffset(true);
                this.jWv.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.jWv.ek(4000);
            }
            this.jWv.C(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cNT() {
        if (TbadkCoreApplication.isLogin()) {
            int Bp = this.jWt != null ? this.jWt.Bp(0) : 0;
            if (this.jWv == null) {
                this.jWv = new e(this.mPageContext, this.jWq.Bt(Bp));
                this.jWv.ej(R.drawable.bg_tip_blue_up_left);
                this.jWv.ei(16);
                this.jWv.pz(true);
                this.jWv.xb(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.jWv.setUseDirectOffset(true);
                this.jWv.ek(4000);
            }
            this.jWv.aJ(this.mContext.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void cNU() {
        if (this.jWv != null) {
            this.jWv.RS();
        }
    }

    public void onResume() {
        if (this.jWq != null) {
            this.jWq.onResume();
        }
    }

    public void a(a aVar) {
        if (this.jWw == null) {
            this.jWw = new ArrayList();
        }
        this.jWw.add(aVar);
    }

    public void b(a aVar) {
        if (this.jWw != null && this.jWw.size() > 0) {
            this.jWw.remove(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class a {
        public void cNV() {
        }

        public void cNW() {
        }

        public void cMR() {
        }
    }
}
