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
    private View.OnClickListener aFH;
    private FrameLayout bEq;
    private CustomViewPager faC;
    private NoNetworkView gCe;
    private View gEA;
    private AlphaAnimation gED;
    private AlphaAnimation gEE;
    private View ghb;
    private PluginErrorTipView iKz;
    private boolean isPrimary;
    private com.baidu.tieba.homepage.concern.b kgA;
    private boolean kgB;
    private com.baidu.tieba.homepage.framework.indicator.b kgC;
    private e kgD;
    private d kgE;
    private HomeTabBarView kgi;
    private TBSpecificationBtn kgj;
    private boolean kgk;
    private NewScrollFragmentAdapter kgl;
    private b kgm;
    private com.baidu.tieba.c.e kgn;
    private List<a> kgo;
    private boolean kgp;
    CustomMessageListener kgq;
    CustomMessageListener kgr;
    CustomMessageListener kgs;
    CustomMessageListener kgt;
    CustomMessageListener kgu;
    CustomMessageTask kgv;
    CustomMessageTask kgw;
    private StickyAppBarLayout kgx;
    private NestedScrollHeader kgy;
    private com.baidu.tieba.c.e kgz;
    private Context mContext;
    private TbPageContext mPageContext;
    CustomMessageListener mYoungsterModeChangeListener;

    /* loaded from: classes2.dex */
    public interface b {
        void BP(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.kgp = false;
        this.kgq = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bRW();
                } else {
                    ScrollFragmentTabHost.this.bRX();
                }
            }
        };
        this.kgr = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.kgz != null) {
                    ScrollFragmentTabHost.this.kgz.TC();
                    ScrollFragmentTabHost.this.kgz = null;
                }
            }
        };
        this.kgs = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.kgi.BM(0);
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
                        if (ScrollFragmentTabHost.this.kgi != null) {
                            ScrollFragmentTabHost.this.kgA.setBackgroundAlpha(ScrollFragmentTabHost.this.kgi.getBackgroundAlpha());
                            ScrollFragmentTabHost.this.kgA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        ScrollFragmentTabHost.this.kgA.a(ScrollFragmentTabHost.this.kgx);
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
        this.kgt = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.kgB != com.baidu.tbadk.a.d.bji()) {
                    ScrollFragmentTabHost.this.kgi.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bji() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cQf();
                        ScrollFragmentTabHost.this.cQe();
                    }
                }
            }
        };
        this.kgu = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
                    final String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.kgi.BM(0);
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
                                com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_home_concern_all_status", 1);
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
                            com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.kgl != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.kgl.cPT();
                    if (!booleanValue || !c.bJj()) {
                        ScrollFragmentTabHost.this.kgl.cPK();
                    } else {
                        ScrollFragmentTabHost.this.kgl.cPJ();
                    }
                    ScrollFragmentTabHost.this.kgi.cSf();
                }
            }
        };
        this.kgv = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.kgx == null || ScrollFragmentTabHost.this.kgy == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.kgi.getTaskView() : ScrollFragmentTabHost.this.kgy.getTaskView();
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
                    if (ScrollFragmentTabHost.this.kgz != null) {
                        ScrollFragmentTabHost.this.kgz.TC();
                    }
                    ScrollFragmentTabHost.this.kgz = new com.baidu.tieba.c.e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.kgz.en(48);
                    ScrollFragmentTabHost.this.kgz.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.kgz.xi(4);
                    ScrollFragmentTabHost.this.kgz.ep(i);
                    ScrollFragmentTabHost.this.kgz.pJ(true);
                    ScrollFragmentTabHost.this.kgz.xm(0);
                    ScrollFragmentTabHost.this.kgz.Jh(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.kgw = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.kgx == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bRX();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.kgx.cQj();
                } else if (ScrollFragmentTabHost.this.kgx.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.kgx.cQj();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aFH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(ScrollFragmentTabHost.this.mPageContext.getPageActivity()).setType(9).setForumId("27307585").setForumName("贴吧众测").setShowHomepageTestBtn(true).send();
                }
            }
        };
        this.kgC = new com.baidu.tieba.homepage.framework.indicator.b();
        this.kgD = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void BG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.kgl.BI(i), false);
                ScrollFragmentTabHost.this.kgl.BK(i);
            }
        };
        this.kgE = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void BF(int i) {
                ScrollFragmentTabHost.this.kgC.a(i, ScrollFragmentTabHost.this.kgD);
            }
        };
        init();
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgp = false;
        this.kgq = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bRW();
                } else {
                    ScrollFragmentTabHost.this.bRX();
                }
            }
        };
        this.kgr = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.kgz != null) {
                    ScrollFragmentTabHost.this.kgz.TC();
                    ScrollFragmentTabHost.this.kgz = null;
                }
            }
        };
        this.kgs = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.kgi.BM(0);
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
                        if (ScrollFragmentTabHost.this.kgi != null) {
                            ScrollFragmentTabHost.this.kgA.setBackgroundAlpha(ScrollFragmentTabHost.this.kgi.getBackgroundAlpha());
                            ScrollFragmentTabHost.this.kgA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        ScrollFragmentTabHost.this.kgA.a(ScrollFragmentTabHost.this.kgx);
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
        this.kgt = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.kgB != com.baidu.tbadk.a.d.bji()) {
                    ScrollFragmentTabHost.this.kgi.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bji() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cQf();
                        ScrollFragmentTabHost.this.cQe();
                    }
                }
            }
        };
        this.kgu = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
                    final String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.kgi.BM(0);
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
                                com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_home_concern_all_status", 1);
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
                            com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.kgl != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.kgl.cPT();
                    if (!booleanValue || !c.bJj()) {
                        ScrollFragmentTabHost.this.kgl.cPK();
                    } else {
                        ScrollFragmentTabHost.this.kgl.cPJ();
                    }
                    ScrollFragmentTabHost.this.kgi.cSf();
                }
            }
        };
        this.kgv = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.kgx == null || ScrollFragmentTabHost.this.kgy == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.kgi.getTaskView() : ScrollFragmentTabHost.this.kgy.getTaskView();
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
                    if (ScrollFragmentTabHost.this.kgz != null) {
                        ScrollFragmentTabHost.this.kgz.TC();
                    }
                    ScrollFragmentTabHost.this.kgz = new com.baidu.tieba.c.e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.kgz.en(48);
                    ScrollFragmentTabHost.this.kgz.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.kgz.xi(4);
                    ScrollFragmentTabHost.this.kgz.ep(i);
                    ScrollFragmentTabHost.this.kgz.pJ(true);
                    ScrollFragmentTabHost.this.kgz.xm(0);
                    ScrollFragmentTabHost.this.kgz.Jh(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.kgw = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.kgx == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bRX();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.kgx.cQj();
                } else if (ScrollFragmentTabHost.this.kgx.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.kgx.cQj();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aFH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(ScrollFragmentTabHost.this.mPageContext.getPageActivity()).setType(9).setForumId("27307585").setForumName("贴吧众测").setShowHomepageTestBtn(true).send();
                }
            }
        };
        this.kgC = new com.baidu.tieba.homepage.framework.indicator.b();
        this.kgD = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void BG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.kgl.BI(i), false);
                ScrollFragmentTabHost.this.kgl.BK(i);
            }
        };
        this.kgE = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void BF(int i) {
                ScrollFragmentTabHost.this.kgC.a(i, ScrollFragmentTabHost.this.kgD);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.kgx = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.kgy = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.kgi = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.iKz = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.gCe = (NoNetworkView) findViewById(R.id.view_no_network);
        this.bEq = (FrameLayout) findViewById(R.id.home_pager_container);
        this.faC = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.ghb = findViewById(R.id.divider_line);
        this.gEA = findViewById(R.id.divider_shadow);
        this.kgj = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.kgj.setVisibility(8);
        this.kgA = new com.baidu.tieba.homepage.concern.b(this.mContext);
        this.kgB = com.baidu.tbadk.a.d.bji();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.kgx.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.bEq.getLayoutParams()).topMargin = 0;
        this.kgi.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.kgl.onPageScrolled(i, f, i2);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.kgm != null) {
                    ScrollFragmentTabHost.this.kgm.BP(i);
                }
                com.baidu.tbadk.core.bigday.b.bld().jp(ScrollFragmentTabHost.this.kgl.BH(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.BO(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                int BH = ScrollFragmentTabHost.this.kgl.BH(ScrollFragmentTabHost.this.faC.getCurrentItem());
                if (BH == 5) {
                    if (ScrollFragmentTabHost.this.kgp) {
                        ScrollFragmentTabHost.this.kgp = false;
                    } else {
                        ar arVar = new ar("c13740");
                        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar.aq("obj_type", ScrollFragmentTabHost.this.cPV() ? 1 : 0);
                        arVar.bsR();
                    }
                }
                if (BH == 0) {
                    ScrollFragmentTabHost.this.cQf();
                }
                View BM = ScrollFragmentTabHost.this.kgi.BM(0);
                if ((BM instanceof LinearLayout) && TbadkCoreApplication.isLogin() && com.baidu.tbadk.a.d.bji()) {
                    LinearLayout linearLayout = (LinearLayout) BM;
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                        if (BH == 0) {
                            imageView.setVisibility(0);
                        } else {
                            imageView.setVisibility(4);
                        }
                    }
                }
                if (ScrollFragmentTabHost.this.kgo != null && ScrollFragmentTabHost.this.kgl != null) {
                    int BH2 = ScrollFragmentTabHost.this.kgl.BH(ScrollFragmentTabHost.this.faC.getCurrentItem());
                    if (BH2 == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar : ScrollFragmentTabHost.this.kgo) {
                            aVar.cQh();
                        }
                    } else if (BH2 == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar2 : ScrollFragmentTabHost.this.kgo) {
                            aVar2.cQg();
                        }
                    } else if (BH2 == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar3 : ScrollFragmentTabHost.this.kgo) {
                            aVar3.cPc();
                        }
                    } else if (BH2 == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (BH2 == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (BH2 == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    } else {
                        ScrollFragmentTabHost.this.bRX();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.BO(i));
                if (ScrollFragmentTabHost.this.BO(i) == 5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.brR().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.brR().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.kgi.cPV()) {
                        ScrollFragmentTabHost.this.kgi.setShowHotTopicRedTip(false);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean cPU = ScrollFragmentTabHost.this.cPU();
                    TiebaStatic.log(new ar("c12350").aq("obj_type", cPU ? 1 : 0));
                    if (cPU && ScrollFragmentTabHost.this.kgl != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.kgl.cPR();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.kgi.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void t(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.faC.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.BO(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.BO(i) == 7) {
                    TiebaStatic.log(new ar("c13483").dR("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.BO(i) == 8) {
                    TiebaStatic.log(new ar("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.BO(i));
                if (ScrollFragmentTabHost.this.BO(i) == 5) {
                    ar arVar = new ar("c13740");
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.aq("obj_type", ScrollFragmentTabHost.this.cPV() ? 1 : 0);
                    arVar.bsR();
                    ScrollFragmentTabHost.this.kgp = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.brR().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.brR().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.kgi.cPV()) {
                        ScrollFragmentTabHost.this.kgi.setShowHotTopicRedTip(false);
                    }
                }
            }
        });
        this.kgx.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void sd(boolean z) {
                if (z && ScrollFragmentTabHost.this.kgz != null) {
                    ScrollFragmentTabHost.this.kgz.TC();
                }
            }
        });
        this.kgy.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void Ma(String str) {
                if (ScrollFragmentTabHost.this.kgz != null) {
                    ScrollFragmentTabHost.this.kgz.TC();
                    ScrollFragmentTabHost.this.kgz = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    bf.bsY().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.kgy.setVisibility(8);
            this.kgi.setMissionEntranceVisibility(true);
            this.kgi.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void Ma(String str) {
                    if (ScrollFragmentTabHost.this.kgz != null) {
                        ScrollFragmentTabHost.this.kgz.TC();
                        ScrollFragmentTabHost.this.kgz = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        bf.bsY().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.kgy.setVisibility(0);
        this.kgi.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.kgw.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.kgw);
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
        this.gCe.a(aVar);
        MessageManager.getInstance().registerListener(this.kgq);
        MessageManager.getInstance().registerListener(this.kgr);
        MessageManager.getInstance().registerListener(this.kgu);
        MessageManager.getInstance().registerListener(this.kgs);
        MessageManager.getInstance().registerListener(this.kgt);
        MessageManager.getInstance().registerListener(this.mYoungsterModeChangeListener);
        this.kgv.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.kgv);
    }

    public void notifyDataSetChanged() {
        if (this.kgl != null && !HomePageStatic.kbg) {
            this.faC.setAdapter(this.kgl);
            this.kgi.notifyDataSetChanged();
            this.kgC.a(this.kgD);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.kgl != null) {
            this.kgl.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.kgl != null) {
            this.kgl.d(dataRes, z);
        }
    }

    public void cPQ() {
        if (this.kgl != null) {
            this.kgl.cPQ();
        }
    }

    public void z(String str, int i, int i2) {
        if (this.faC != null) {
            this.kgl.z(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.kgl = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.kgl.setScrollFragmentTabHost(this);
        this.faC.setOffscreenPageLimit(2);
        this.faC.setAdapter(this.kgl);
        int cPN = this.kgl.cPN();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.kgl;
        if (HomePageStatic.kbg) {
            cPN = 0;
        }
        this.faC.setCurrentItem(newScrollFragmentAdapter.BI(cPN));
        this.kgi.setViewPager(this.faC);
        this.kgi.setConcernTabIndex(this.kgl.BI(0));
        if (this.kgl.cPM() != -1) {
            this.kgi.setHotTopicTabIndex(this.kgl.cPM());
            this.kgi.setShowHotTopicRedTip(cPZ());
        }
    }

    private boolean cPZ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            if (currentTimeMillis - com.baidu.tbadk.core.sharedPref.b.brR().getLong("unlogin_hot_top_timestamp", 0L) >= 86400000) {
                return true;
            }
        } else {
            long j = com.baidu.tbadk.core.sharedPref.b.brR().getLong(TbadkApplication.getCurrentAccount(), 0L);
            if (!StringUtils.isNull(TbadkApplication.getCurrentAccount()) && currentTimeMillis - j >= 86400000) {
                return true;
            }
        }
        return false;
    }

    public boolean cQa() {
        return this.kgl != null && this.kgl.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.kgl.getCount()) {
            this.kgi.setTabItemClicked(z);
            this.kgl.BL(i);
            this.faC.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.kgl.BI(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.kgl.BI(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.kgl.Mb(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.kgi.setPageUniqueId(bdUniqueId);
        this.kgq.setTag(bdUniqueId);
        this.kgr.setTag(bdUniqueId);
        this.kgu.setTag(bdUniqueId);
        this.kgs.setTag(bdUniqueId);
        this.mYoungsterModeChangeListener.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.bEq;
    }

    public int getCurrentTabType() {
        return this.kgl.BH(this.faC.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.faC.getAdapter() != null) {
            int count = this.faC.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.kgl.BH(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int BO(int i) {
        return this.kgl.BH(i);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.br(this.kgx).l(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
        this.kgy.onChangeSkinType();
        this.kgi.onChangeSkinType();
        if (this.mPageContext != null && this.gCe != null) {
            this.gCe.onChangeSkinType(this.mPageContext, i);
        }
        if (this.kgl != null) {
            this.kgl.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.iKz != null) {
            this.iKz.onChangeSkinType(this.mPageContext, i);
        }
        if (this.kgA != null) {
            this.kgA.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this.ghb, R.color.CAM_X0203);
        ap.setBackgroundResource(this.gEA, R.drawable.personalize_tab_shadow);
    }

    private boolean bRV() {
        return this.gEA.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.kgk = z;
        if (z) {
            if (this.ghb != null) {
                this.ghb.setVisibility(8);
            }
        } else if (this.ghb != null) {
            this.ghb.setVisibility(0);
        }
    }

    public void bRW() {
        if (this.kgk && !bRV()) {
            this.gEA.setVisibility(0);
            if (this.gED == null) {
                this.gED = new AlphaAnimation(0.0f, 1.0f);
                this.gED.setFillAfter(true);
                this.gED.setDuration(300L);
            }
            this.gEA.startAnimation(this.gED);
        }
    }

    public void bRX() {
        if (this.kgk && bRV()) {
            if (this.gEE == null) {
                this.gEE = new AlphaAnimation(1.0f, 0.0f);
                this.gEE.setFillAfter(true);
                this.gEE.setDuration(300L);
                this.gEE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.gEA.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gEA.startAnimation(this.gEE);
        }
    }

    public void cPS() {
        if (this.kgl != null) {
            this.kgl.cPS();
        }
    }

    public void bSD() {
        this.kgl.bSD();
    }

    public String getCurrentPageKey() {
        if (this.kgl != null) {
            return this.kgl.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.faC != null) {
            return this.faC.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.kgl != null) {
            this.kgl.setPrimary(z);
        }
        if (this.gCe != null && z) {
            this.gCe.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cQb() {
        this.kgl.a(this.kgE);
    }

    public void qJ(boolean z) {
    }

    public void cQc() {
        if (this.kgx != null && !this.kgx.isSticky() && this.kgi != null && this.kgi.getTaskView() != null && this.kgi.getTaskView().getVisibility() != 0) {
            this.kgi.cQl();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.kgm = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.kgz != null) {
            this.kgz.TC();
            this.kgz = null;
        }
        cQf();
        MessageManager.getInstance().unRegisterListener(this.kgt);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.kgi != null && this.kgl.cPO()) {
            this.kgi.setShowConcernRedTip(z);
        }
    }

    public boolean cPU() {
        if (this.kgi == null || !this.kgl.cPO()) {
            return false;
        }
        return this.kgi.cPU();
    }

    public boolean cPV() {
        if (this.kgi == null || this.kgl == null || !this.kgl.cPP()) {
            return false;
        }
        return this.kgi.cPV();
    }

    public void setVideoThreadId(String str) {
        if (this.kgl != null) {
            this.kgl.setVideoThreadId(str);
        }
    }

    public void cQd() {
        if (com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int BI = this.kgl != null ? this.kgl.BI(0) : 0;
            if (this.kgn == null) {
                this.kgn = new com.baidu.tieba.c.e(this.mPageContext, this.kgi.BM(BI));
                this.kgn.eo(R.drawable.bg_tip_blue_up);
                this.kgn.en(32);
                this.kgn.pJ(true);
                this.kgn.setUseDirectOffset(true);
                this.kgn.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.kgn.ep(4000);
            }
            this.kgn.C(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cQe() {
        if (TbadkCoreApplication.isLogin()) {
            int BI = this.kgl != null ? this.kgl.BI(0) : 0;
            if (this.kgn == null) {
                this.kgn = new com.baidu.tieba.c.e(this.mPageContext, this.kgi.BM(BI));
                this.kgn.eo(R.drawable.bg_tip_blue_up_left);
                this.kgn.en(16);
                this.kgn.pJ(true);
                this.kgn.xm(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.kgn.setUseDirectOffset(true);
                this.kgn.ep(4000);
            }
            this.kgn.aJ(this.mContext.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void cQf() {
        if (this.kgn != null) {
            this.kgn.TC();
        }
    }

    public void onResume() {
        if (this.kgi != null) {
            this.kgi.onResume();
        }
    }

    public void a(a aVar) {
        if (this.kgo == null) {
            this.kgo = new ArrayList();
        }
        this.kgo.add(aVar);
    }

    public void b(a aVar) {
        if (this.kgo != null && this.kgo.size() > 0) {
            this.kgo.remove(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class a {
        public void cQg() {
        }

        public void cQh() {
        }

        public void cPc() {
        }
    }
}
