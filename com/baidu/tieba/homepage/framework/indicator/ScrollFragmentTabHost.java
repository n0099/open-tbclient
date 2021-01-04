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
    private View.OnClickListener aHh;
    private FrameLayout bDW;
    private CustomViewPager fbv;
    private NoNetworkView gCe;
    private View gEA;
    private AlphaAnimation gED;
    private AlphaAnimation gEE;
    private View ghM;
    private PluginErrorTipView iHz;
    private boolean isPrimary;
    private HomeTabBarView kaV;
    private TBSpecificationBtn kaW;
    private boolean kaX;
    private NewScrollFragmentAdapter kaY;
    private b kaZ;
    private e kba;
    private List<a> kbb;
    private boolean kbc;
    CustomMessageListener kbd;
    CustomMessageListener kbe;
    CustomMessageListener kbf;
    CustomMessageListener kbg;
    CustomMessageListener kbh;
    CustomMessageTask kbi;
    CustomMessageTask kbj;
    private StickyAppBarLayout kbk;
    private NestedScrollHeader kbl;
    private e kbm;
    private com.baidu.tieba.homepage.concern.b kbn;
    private boolean kbo;
    private com.baidu.tieba.homepage.framework.indicator.b kbp;
    private com.baidu.tieba.homepage.framework.e kbq;
    private d kbr;
    private Context mContext;
    private TbPageContext mPageContext;
    CustomMessageListener mYoungsterModeChangeListener;

    /* loaded from: classes2.dex */
    public interface b {
        void Dd(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.kbc = false;
        this.kbd = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bUX();
                } else {
                    ScrollFragmentTabHost.this.bUY();
                }
            }
        };
        this.kbe = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.kbm != null) {
                    ScrollFragmentTabHost.this.kbm.VL();
                    ScrollFragmentTabHost.this.kbm = null;
                }
            }
        };
        this.kbf = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.kaV.Da(0);
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
                        if (ScrollFragmentTabHost.this.kaV != null) {
                            ScrollFragmentTabHost.this.kbn.setBackgroundAlpha(ScrollFragmentTabHost.this.kaV.getBackgroundAlpha());
                            ScrollFragmentTabHost.this.kbn.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        ScrollFragmentTabHost.this.kbn.a(ScrollFragmentTabHost.this.kbk);
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
        this.kbg = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.kbo != com.baidu.tbadk.a.d.bmN()) {
                    ScrollFragmentTabHost.this.kaV.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bmN() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cRL();
                        ScrollFragmentTabHost.this.cRK();
                    }
                }
            }
        };
        this.kbh = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
                    final String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.kaV.Da(0);
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
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_home_concern_all_status", 1);
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
                            com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.kaY != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.kaY.cRz();
                    if (!booleanValue || !c.bMD()) {
                        ScrollFragmentTabHost.this.kaY.cRr();
                    } else {
                        ScrollFragmentTabHost.this.kaY.cRq();
                    }
                    ScrollFragmentTabHost.this.kaV.cTJ();
                }
            }
        };
        this.kbi = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.kbk == null || ScrollFragmentTabHost.this.kbl == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.kaV.getTaskView() : ScrollFragmentTabHost.this.kbl.getTaskView();
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
                    if (ScrollFragmentTabHost.this.kbm != null) {
                        ScrollFragmentTabHost.this.kbm.VL();
                    }
                    ScrollFragmentTabHost.this.kbm = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.kbm.fO(48);
                    ScrollFragmentTabHost.this.kbm.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.kbm.setAnchor(4);
                    ScrollFragmentTabHost.this.kbm.fQ(i);
                    ScrollFragmentTabHost.this.kbm.pD(true);
                    ScrollFragmentTabHost.this.kbm.yH(0);
                    ScrollFragmentTabHost.this.kbm.Jy(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.kbj = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.kbk == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bUY();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.kbk.cRP();
                } else if (ScrollFragmentTabHost.this.kbk.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.kbk.cRP();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aHh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(ScrollFragmentTabHost.this.mPageContext.getPageActivity()).setType(9).setForumId("27307585").setForumName("贴吧众测").setShowHomepageTestBtn(true).send();
                }
            }
        };
        this.kbp = new com.baidu.tieba.homepage.framework.indicator.b();
        this.kbq = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void CU(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.kaY.CW(i), false);
                ScrollFragmentTabHost.this.kaY.CY(i);
            }
        };
        this.kbr = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void CT(int i) {
                ScrollFragmentTabHost.this.kbp.a(i, ScrollFragmentTabHost.this.kbq);
            }
        };
        init();
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kbc = false;
        this.kbd = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bUX();
                } else {
                    ScrollFragmentTabHost.this.bUY();
                }
            }
        };
        this.kbe = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.kbm != null) {
                    ScrollFragmentTabHost.this.kbm.VL();
                    ScrollFragmentTabHost.this.kbm = null;
                }
            }
        };
        this.kbf = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.kaV.Da(0);
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
                        if (ScrollFragmentTabHost.this.kaV != null) {
                            ScrollFragmentTabHost.this.kbn.setBackgroundAlpha(ScrollFragmentTabHost.this.kaV.getBackgroundAlpha());
                            ScrollFragmentTabHost.this.kbn.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        ScrollFragmentTabHost.this.kbn.a(ScrollFragmentTabHost.this.kbk);
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
        this.kbg = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.kbo != com.baidu.tbadk.a.d.bmN()) {
                    ScrollFragmentTabHost.this.kaV.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bmN() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cRL();
                        ScrollFragmentTabHost.this.cRK();
                    }
                }
            }
        };
        this.kbh = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
                    final String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.kaV.Da(0);
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
                                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_home_concern_all_status", 1);
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
                            com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.kaY != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.kaY.cRz();
                    if (!booleanValue || !c.bMD()) {
                        ScrollFragmentTabHost.this.kaY.cRr();
                    } else {
                        ScrollFragmentTabHost.this.kaY.cRq();
                    }
                    ScrollFragmentTabHost.this.kaV.cTJ();
                }
            }
        };
        this.kbi = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.kbk == null || ScrollFragmentTabHost.this.kbl == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.kaV.getTaskView() : ScrollFragmentTabHost.this.kbl.getTaskView();
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
                    if (ScrollFragmentTabHost.this.kbm != null) {
                        ScrollFragmentTabHost.this.kbm.VL();
                    }
                    ScrollFragmentTabHost.this.kbm = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.kbm.fO(48);
                    ScrollFragmentTabHost.this.kbm.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.kbm.setAnchor(4);
                    ScrollFragmentTabHost.this.kbm.fQ(i);
                    ScrollFragmentTabHost.this.kbm.pD(true);
                    ScrollFragmentTabHost.this.kbm.yH(0);
                    ScrollFragmentTabHost.this.kbm.Jy(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.kbj = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.kbk == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bUY();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.kbk.cRP();
                } else if (ScrollFragmentTabHost.this.kbk.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.kbk.cRP();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aHh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(ScrollFragmentTabHost.this.mPageContext.getPageActivity()).setType(9).setForumId("27307585").setForumName("贴吧众测").setShowHomepageTestBtn(true).send();
                }
            }
        };
        this.kbp = new com.baidu.tieba.homepage.framework.indicator.b();
        this.kbq = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void CU(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.kaY.CW(i), false);
                ScrollFragmentTabHost.this.kaY.CY(i);
            }
        };
        this.kbr = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void CT(int i) {
                ScrollFragmentTabHost.this.kbp.a(i, ScrollFragmentTabHost.this.kbq);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.kbk = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.kbl = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.kaV = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.iHz = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.gCe = (NoNetworkView) findViewById(R.id.view_no_network);
        this.bDW = (FrameLayout) findViewById(R.id.home_pager_container);
        this.fbv = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.ghM = findViewById(R.id.divider_line);
        this.gEA = findViewById(R.id.divider_shadow);
        this.kaW = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.kaW.setVisibility(8);
        this.kbn = new com.baidu.tieba.homepage.concern.b(this.mContext);
        this.kbo = com.baidu.tbadk.a.d.bmN();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.kbk.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.bDW.getLayoutParams()).topMargin = 0;
        this.kaV.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.kaY.onPageScrolled(i, f, i2);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.kaZ != null) {
                    ScrollFragmentTabHost.this.kaZ.Dd(i);
                }
                com.baidu.tbadk.core.bigday.b.boC().jr(ScrollFragmentTabHost.this.kaY.CV(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.Dc(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                int CV = ScrollFragmentTabHost.this.kaY.CV(ScrollFragmentTabHost.this.fbv.getCurrentItem());
                if (CV == 5) {
                    if (ScrollFragmentTabHost.this.kbc) {
                        ScrollFragmentTabHost.this.kbc = false;
                    } else {
                        aq aqVar = new aq("c13740");
                        aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar.an("obj_type", ScrollFragmentTabHost.this.cRB() ? 1 : 0);
                        aqVar.bwn();
                    }
                }
                if (CV == 0) {
                    ScrollFragmentTabHost.this.cRL();
                }
                View Da = ScrollFragmentTabHost.this.kaV.Da(0);
                if ((Da instanceof LinearLayout) && TbadkCoreApplication.isLogin() && com.baidu.tbadk.a.d.bmN()) {
                    LinearLayout linearLayout = (LinearLayout) Da;
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                        if (CV == 0) {
                            imageView.setVisibility(0);
                        } else {
                            imageView.setVisibility(4);
                        }
                    }
                }
                if (ScrollFragmentTabHost.this.kbb != null && ScrollFragmentTabHost.this.kaY != null) {
                    int CV2 = ScrollFragmentTabHost.this.kaY.CV(ScrollFragmentTabHost.this.fbv.getCurrentItem());
                    if (CV2 == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar : ScrollFragmentTabHost.this.kbb) {
                            aVar.cRN();
                        }
                    } else if (CV2 == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar2 : ScrollFragmentTabHost.this.kbb) {
                            aVar2.cRM();
                        }
                    } else if (CV2 == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar3 : ScrollFragmentTabHost.this.kbb) {
                            aVar3.cQI();
                        }
                    } else if (CV2 == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (CV2 == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (CV2 == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    } else {
                        ScrollFragmentTabHost.this.bUY();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.Dc(i));
                if (ScrollFragmentTabHost.this.Dc(i) == 5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.bvq().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.bvq().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.kaV.cRB()) {
                        ScrollFragmentTabHost.this.kaV.setShowHotTopicRedTip(false);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean cRA = ScrollFragmentTabHost.this.cRA();
                    TiebaStatic.log(new aq("c12350").an("obj_type", cRA ? 1 : 0));
                    if (cRA && ScrollFragmentTabHost.this.kaY != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.kaY.cRx();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.kaV.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void t(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.fbv.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.Dc(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.Dc(i) == 7) {
                    TiebaStatic.log(new aq("c13483").dX("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.Dc(i) == 8) {
                    TiebaStatic.log(new aq("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.Dc(i));
                if (ScrollFragmentTabHost.this.Dc(i) == 5) {
                    aq aqVar = new aq("c13740");
                    aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.an("obj_type", ScrollFragmentTabHost.this.cRB() ? 1 : 0);
                    aqVar.bwn();
                    ScrollFragmentTabHost.this.kbc = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.bvq().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.bvq().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.kaV.cRB()) {
                        ScrollFragmentTabHost.this.kaV.setShowHotTopicRedTip(false);
                    }
                }
            }
        });
        this.kbk.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void rV(boolean z) {
                if (z && ScrollFragmentTabHost.this.kbm != null) {
                    ScrollFragmentTabHost.this.kbm.VL();
                }
            }
        });
        this.kbl.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void Mr(String str) {
                if (ScrollFragmentTabHost.this.kbm != null) {
                    ScrollFragmentTabHost.this.kbm.VL();
                    ScrollFragmentTabHost.this.kbm = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    be.bwu().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.kbl.setVisibility(8);
            this.kaV.setMissionEntranceVisibility(true);
            this.kaV.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void Mr(String str) {
                    if (ScrollFragmentTabHost.this.kbm != null) {
                        ScrollFragmentTabHost.this.kbm.VL();
                        ScrollFragmentTabHost.this.kbm = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        be.bwu().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.kbl.setVisibility(0);
        this.kaV.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.kbj.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.kbj);
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
        MessageManager.getInstance().registerListener(this.kbd);
        MessageManager.getInstance().registerListener(this.kbe);
        MessageManager.getInstance().registerListener(this.kbh);
        MessageManager.getInstance().registerListener(this.kbf);
        MessageManager.getInstance().registerListener(this.kbg);
        MessageManager.getInstance().registerListener(this.mYoungsterModeChangeListener);
        this.kbi.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.kbi);
    }

    public void notifyDataSetChanged() {
        if (this.kaY != null && !HomePageStatic.jVT) {
            this.fbv.setAdapter(this.kaY);
            this.kaV.notifyDataSetChanged();
            this.kbp.a(this.kbq);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.kaY != null) {
            this.kaY.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.kaY != null) {
            this.kaY.d(dataRes, z);
        }
    }

    public void cRw() {
        if (this.kaY != null) {
            this.kaY.cRw();
        }
    }

    public void z(String str, int i, int i2) {
        if (this.fbv != null) {
            this.kaY.z(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.kaY = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.kaY.setScrollFragmentTabHost(this);
        this.fbv.setOffscreenPageLimit(2);
        this.fbv.setAdapter(this.kaY);
        int cRt = this.kaY.cRt();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.kaY;
        if (HomePageStatic.jVT) {
            cRt = 0;
        }
        this.fbv.setCurrentItem(newScrollFragmentAdapter.CW(cRt));
        this.kaV.setViewPager(this.fbv);
        this.kaV.setConcernTabIndex(this.kaY.CW(0));
        this.kaV.setHotTopicTabIndex(this.kaY.CW(5));
        this.kaV.setShowHotTopicRedTip(cRF());
    }

    private boolean cRF() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            if (currentTimeMillis - com.baidu.tbadk.core.sharedPref.b.bvq().getLong("unlogin_hot_top_timestamp", 0L) >= 86400000) {
                return true;
            }
        } else {
            long j = com.baidu.tbadk.core.sharedPref.b.bvq().getLong(TbadkApplication.getCurrentAccount(), 0L);
            if (!StringUtils.isNull(TbadkApplication.getCurrentAccount()) && currentTimeMillis - j >= 86400000) {
                return true;
            }
        }
        return false;
    }

    public boolean cRG() {
        return this.kaY != null && this.kaY.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.kaY.getCount()) {
            this.kaV.setTabItemClicked(z);
            this.kaY.CZ(i);
            this.fbv.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.kaY.CW(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.kaY.CW(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.kaY.Ms(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.kaV.setPageUniqueId(bdUniqueId);
        this.kbd.setTag(bdUniqueId);
        this.kbe.setTag(bdUniqueId);
        this.kbh.setTag(bdUniqueId);
        this.kbf.setTag(bdUniqueId);
        this.mYoungsterModeChangeListener.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.bDW;
    }

    public int getCurrentTabType() {
        return this.kaY.CV(this.fbv.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.fbv.getAdapter() != null) {
            int count = this.fbv.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.kaY.CV(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int Dc(int i) {
        return this.kaY.CV(i);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.elementsMaven.c.bv(this.kbk).l(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
        this.kbl.onChangeSkinType();
        this.kaV.onChangeSkinType();
        if (this.mPageContext != null && this.gCe != null) {
            this.gCe.onChangeSkinType(this.mPageContext, i);
        }
        if (this.kaY != null) {
            this.kaY.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.iHz != null) {
            this.iHz.onChangeSkinType(this.mPageContext, i);
        }
        if (this.kbn != null) {
            this.kbn.onChangeSkinType(i);
        }
        ao.setBackgroundColor(this.ghM, R.color.CAM_X0203);
        ao.setBackgroundResource(this.gEA, R.drawable.personalize_tab_shadow);
    }

    private boolean bUW() {
        return this.gEA.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.kaX = z;
        if (z) {
            if (this.ghM != null) {
                this.ghM.setVisibility(8);
            }
        } else if (this.ghM != null) {
            this.ghM.setVisibility(0);
        }
    }

    public void bUX() {
        if (this.kaX && !bUW()) {
            this.gEA.setVisibility(0);
            if (this.gED == null) {
                this.gED = new AlphaAnimation(0.0f, 1.0f);
                this.gED.setFillAfter(true);
                this.gED.setDuration(300L);
            }
            this.gEA.startAnimation(this.gED);
        }
    }

    public void bUY() {
        if (this.kaX && bUW()) {
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

    public void cRy() {
        if (this.kaY != null) {
            this.kaY.cRy();
        }
    }

    public void bVE() {
        this.kaY.bVE();
    }

    public String getCurrentPageKey() {
        if (this.kaY != null) {
            return this.kaY.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.fbv != null) {
            return this.fbv.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.kaY != null) {
            this.kaY.setPrimary(z);
        }
        if (this.gCe != null && z) {
            this.gCe.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cRH() {
        this.kaY.a(this.kbr);
    }

    public void qD(boolean z) {
    }

    public void cRI() {
        if (this.kbk != null && !this.kbk.isSticky() && this.kaV != null && this.kaV.getTaskView() != null && this.kaV.getTaskView().getVisibility() != 0) {
            this.kaV.cRR();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.kaZ = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.kbm != null) {
            this.kbm.VL();
            this.kbm = null;
        }
        cRL();
        MessageManager.getInstance().unRegisterListener(this.kbg);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.kaV != null && this.kaY.cRu()) {
            this.kaV.setShowConcernRedTip(z);
        }
    }

    public boolean cRA() {
        if (this.kaV == null || !this.kaY.cRu()) {
            return false;
        }
        return this.kaV.cRA();
    }

    public boolean cRB() {
        if (this.kaV == null || this.kaY == null || !this.kaY.cRv()) {
            return false;
        }
        return this.kaV.cRB();
    }

    public void setVideoThreadId(String str) {
        if (this.kaY != null) {
            this.kaY.setVideoThreadId(str);
        }
    }

    public void cRJ() {
        if (com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int CW = this.kaY != null ? this.kaY.CW(0) : 0;
            if (this.kba == null) {
                this.kba = new e(this.mPageContext, this.kaV.Da(CW));
                this.kba.fP(R.drawable.bg_tip_blue_up);
                this.kba.fO(32);
                this.kba.pD(true);
                this.kba.setUseDirectOffset(true);
                this.kba.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.kba.fQ(4000);
            }
            this.kba.C(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cRK() {
        if (TbadkCoreApplication.isLogin()) {
            int CW = this.kaY != null ? this.kaY.CW(0) : 0;
            if (this.kba == null) {
                this.kba = new e(this.mPageContext, this.kaV.Da(CW));
                this.kba.fP(R.drawable.bg_tip_blue_up_left);
                this.kba.fO(16);
                this.kba.pD(true);
                this.kba.yH(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.kba.setUseDirectOffset(true);
                this.kba.fQ(4000);
            }
            this.kba.aK(this.mContext.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void cRL() {
        if (this.kba != null) {
            this.kba.VL();
        }
    }

    public void onResume() {
        if (this.kaV != null) {
            this.kaV.onResume();
        }
    }

    public void a(a aVar) {
        if (this.kbb == null) {
            this.kbb = new ArrayList();
        }
        this.kbb.add(aVar);
    }

    public void b(a aVar) {
        if (this.kbb != null && this.kbb.size() > 0) {
            this.kbb.remove(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class a {
        public void cRM() {
        }

        public void cRN() {
        }

        public void cQI() {
        }
    }
}
