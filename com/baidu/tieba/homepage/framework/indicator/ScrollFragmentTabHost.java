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
/* loaded from: classes22.dex */
public class ScrollFragmentTabHost extends RelativeLayout {
    private View.OnClickListener aGQ;
    private FrameLayout bzj;
    private CustomViewPager eRw;
    private View fYf;
    private NoNetworkView grf;
    private View gtB;
    private AlphaAnimation gtE;
    private AlphaAnimation gtF;
    private boolean isPrimary;
    private PluginErrorTipView ivm;
    private HomeTabBarView jNH;
    private TBSpecificationBtn jNI;
    private boolean jNJ;
    private NewScrollFragmentAdapter jNK;
    private b jNL;
    private e jNM;
    private List<a> jNN;
    private boolean jNO;
    CustomMessageListener jNP;
    CustomMessageListener jNQ;
    CustomMessageListener jNR;
    CustomMessageListener jNS;
    CustomMessageListener jNT;
    CustomMessageTask jNU;
    CustomMessageTask jNV;
    private StickyAppBarLayout jNW;
    private NestedScrollHeader jNX;
    private e jNY;
    private com.baidu.tieba.homepage.concern.b jNZ;
    private boolean jOa;
    private com.baidu.tieba.homepage.framework.indicator.b jOb;
    private com.baidu.tieba.homepage.framework.e jOc;
    private d jOd;
    private Context mContext;
    private TbPageContext mPageContext;
    CustomMessageListener mYoungsterModeChangeListener;

    /* loaded from: classes22.dex */
    public interface b {
        void CP(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.jNO = false;
        this.jNP = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bSv();
                } else {
                    ScrollFragmentTabHost.this.bSw();
                }
            }
        };
        this.jNQ = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.jNY != null) {
                    ScrollFragmentTabHost.this.jNY.UG();
                    ScrollFragmentTabHost.this.jNY = null;
                }
            }
        };
        this.jNR = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jNH.CM(0);
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
                        if (ScrollFragmentTabHost.this.jNH != null) {
                            ScrollFragmentTabHost.this.jNZ.setBackgroundAlpha(ScrollFragmentTabHost.this.jNH.getBackgroundAlpha());
                            ScrollFragmentTabHost.this.jNZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        ScrollFragmentTabHost.this.jNZ.a(ScrollFragmentTabHost.this.jNW);
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
        this.jNS = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.jOa != com.baidu.tbadk.a.d.bkz()) {
                    ScrollFragmentTabHost.this.jNH.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bkz() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cOF();
                        ScrollFragmentTabHost.this.cOE();
                    }
                }
            }
        };
        this.jNT = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
                    final String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jNH.CM(0);
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
                                com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_home_concern_all_status", 1);
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
                            com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.jNK != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.jNK.cOt();
                    if (!booleanValue || !c.bKl()) {
                        ScrollFragmentTabHost.this.jNK.cOl();
                    } else {
                        ScrollFragmentTabHost.this.jNK.cOk();
                    }
                    ScrollFragmentTabHost.this.jNH.cQD();
                }
            }
        };
        this.jNU = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.jNW == null || ScrollFragmentTabHost.this.jNX == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.jNH.getTaskView() : ScrollFragmentTabHost.this.jNX.getTaskView();
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
                    if (ScrollFragmentTabHost.this.jNY != null) {
                        ScrollFragmentTabHost.this.jNY.UG();
                    }
                    ScrollFragmentTabHost.this.jNY = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.jNY.fN(48);
                    ScrollFragmentTabHost.this.jNY.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.jNY.setAnchor(4);
                    ScrollFragmentTabHost.this.jNY.fP(i);
                    ScrollFragmentTabHost.this.jNY.pf(true);
                    ScrollFragmentTabHost.this.jNY.yt(0);
                    ScrollFragmentTabHost.this.jNY.JA(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.jNV = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.jNW == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bSw();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.jNW.cOJ();
                } else if (ScrollFragmentTabHost.this.jNW.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.jNW.cOJ();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
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
        this.jOb = new com.baidu.tieba.homepage.framework.indicator.b();
        this.jOc = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void CG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.jNK.CI(i), false);
                ScrollFragmentTabHost.this.jNK.CK(i);
            }
        };
        this.jOd = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void CF(int i) {
                ScrollFragmentTabHost.this.jOb.a(i, ScrollFragmentTabHost.this.jOc);
            }
        };
        init();
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jNO = false;
        this.jNP = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bSv();
                } else {
                    ScrollFragmentTabHost.this.bSw();
                }
            }
        };
        this.jNQ = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.jNY != null) {
                    ScrollFragmentTabHost.this.jNY.UG();
                    ScrollFragmentTabHost.this.jNY = null;
                }
            }
        };
        this.jNR = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jNH.CM(0);
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
                        if (ScrollFragmentTabHost.this.jNH != null) {
                            ScrollFragmentTabHost.this.jNZ.setBackgroundAlpha(ScrollFragmentTabHost.this.jNH.getBackgroundAlpha());
                            ScrollFragmentTabHost.this.jNZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        ScrollFragmentTabHost.this.jNZ.a(ScrollFragmentTabHost.this.jNW);
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
        this.jNS = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.jOa != com.baidu.tbadk.a.d.bkz()) {
                    ScrollFragmentTabHost.this.jNH.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bkz() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cOF();
                        ScrollFragmentTabHost.this.cOE();
                    }
                }
            }
        };
        this.jNT = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
                    final String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jNH.CM(0);
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
                                com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_home_concern_all_status", 1);
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
                            com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_home_concern_all_status", 0);
                        }
                    }
                }
            }
        };
        this.mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.jNK != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.jNK.cOt();
                    if (!booleanValue || !c.bKl()) {
                        ScrollFragmentTabHost.this.jNK.cOl();
                    } else {
                        ScrollFragmentTabHost.this.jNK.cOk();
                    }
                    ScrollFragmentTabHost.this.jNH.cQD();
                }
            }
        };
        this.jNU = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.jNW == null || ScrollFragmentTabHost.this.jNX == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.jNH.getTaskView() : ScrollFragmentTabHost.this.jNX.getTaskView();
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
                    if (ScrollFragmentTabHost.this.jNY != null) {
                        ScrollFragmentTabHost.this.jNY.UG();
                    }
                    ScrollFragmentTabHost.this.jNY = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.jNY.fN(48);
                    ScrollFragmentTabHost.this.jNY.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.jNY.setAnchor(4);
                    ScrollFragmentTabHost.this.jNY.fP(i);
                    ScrollFragmentTabHost.this.jNY.pf(true);
                    ScrollFragmentTabHost.this.jNY.yt(0);
                    ScrollFragmentTabHost.this.jNY.JA(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.jNV = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.jNW == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bSw();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.jNW.cOJ();
                } else if (ScrollFragmentTabHost.this.jNW.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.jNW.cOJ();
                    z = true;
                } else {
                    z = false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921442, true));
                return new CustomResponsedMessage<>(2921405, Boolean.valueOf(z));
            }
        });
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.17
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
        this.jOb = new com.baidu.tieba.homepage.framework.indicator.b();
        this.jOc = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void CG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.jNK.CI(i), false);
                ScrollFragmentTabHost.this.jNK.CK(i);
            }
        };
        this.jOd = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void CF(int i) {
                ScrollFragmentTabHost.this.jOb.a(i, ScrollFragmentTabHost.this.jOc);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.jNW = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.jNX = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.jNH = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.ivm = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.grf = (NoNetworkView) findViewById(R.id.view_no_network);
        this.bzj = (FrameLayout) findViewById(R.id.home_pager_container);
        this.eRw = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.fYf = findViewById(R.id.divider_line);
        this.gtB = findViewById(R.id.divider_shadow);
        this.jNI = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.jNI.setVisibility(8);
        this.jNZ = new com.baidu.tieba.homepage.concern.b(this.mContext);
        this.jOa = com.baidu.tbadk.a.d.bkz();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.jNW.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.bzj.getLayoutParams()).topMargin = 0;
        this.jNH.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.jNK.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.jNL != null) {
                    ScrollFragmentTabHost.this.jNL.CP(i);
                }
                com.baidu.tbadk.core.bigday.b.bmd().iW(ScrollFragmentTabHost.this.jNK.CH(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.CO(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                int CH = ScrollFragmentTabHost.this.jNK.CH(ScrollFragmentTabHost.this.eRw.getCurrentItem());
                if (CH == 5) {
                    if (ScrollFragmentTabHost.this.jNO) {
                        ScrollFragmentTabHost.this.jNO = false;
                    } else {
                        ar arVar = new ar("c13740");
                        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar.al("obj_type", ScrollFragmentTabHost.this.cOv() ? 1 : 0);
                        arVar.btT();
                    }
                }
                if (CH == 0) {
                    ScrollFragmentTabHost.this.cOF();
                }
                View CM = ScrollFragmentTabHost.this.jNH.CM(0);
                if ((CM instanceof LinearLayout) && TbadkCoreApplication.isLogin() && com.baidu.tbadk.a.d.bkz()) {
                    LinearLayout linearLayout = (LinearLayout) CM;
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                        if (CH == 0) {
                            imageView.setVisibility(0);
                        } else {
                            imageView.setVisibility(4);
                        }
                    }
                }
                if (ScrollFragmentTabHost.this.jNN != null && ScrollFragmentTabHost.this.jNK != null) {
                    int CH2 = ScrollFragmentTabHost.this.jNK.CH(ScrollFragmentTabHost.this.eRw.getCurrentItem());
                    if (CH2 == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar : ScrollFragmentTabHost.this.jNN) {
                            aVar.cOH();
                        }
                    } else if (CH2 == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar2 : ScrollFragmentTabHost.this.jNN) {
                            aVar2.cOG();
                        }
                    } else if (CH2 == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar3 : ScrollFragmentTabHost.this.jNN) {
                            aVar3.cNC();
                        }
                    } else if (CH2 == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (CH2 == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (CH2 == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    } else {
                        ScrollFragmentTabHost.this.bSw();
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    }
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.CO(i));
                if (ScrollFragmentTabHost.this.CO(i) == 5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.bsO().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.jNH.cOv()) {
                        ScrollFragmentTabHost.this.jNH.setShowHotTopicRedTip(false);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean cOu = ScrollFragmentTabHost.this.cOu();
                    TiebaStatic.log(new ar("c12350").al("obj_type", cOu ? 1 : 0));
                    if (cOu && ScrollFragmentTabHost.this.jNK != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.jNK.cOr();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.jNH.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void q(View view, int i) {
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if ((i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) && ScrollFragmentTabHost.this.eRw.getCurrentItem() != i) {
                    if (ScrollFragmentTabHost.this.CO(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                if (ScrollFragmentTabHost.this.CO(i) == 7) {
                    TiebaStatic.log(new ar("c13483").dY("obj_type", "1"));
                } else if (ScrollFragmentTabHost.this.CO(i) == 8) {
                    TiebaStatic.log(new ar("c13580"));
                }
                TbadkCoreApplication.getInst().setHomeBarShowType(ScrollFragmentTabHost.this.CO(i));
                if (ScrollFragmentTabHost.this.CO(i) == 5) {
                    ar arVar = new ar("c13740");
                    arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.al("obj_type", ScrollFragmentTabHost.this.cOv() ? 1 : 0);
                    arVar.btT();
                    ScrollFragmentTabHost.this.jNO = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.bsO().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.jNH.cOv()) {
                        ScrollFragmentTabHost.this.jNH.setShowHotTopicRedTip(false);
                    }
                }
            }
        });
        this.jNW.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void ry(boolean z) {
                if (z && ScrollFragmentTabHost.this.jNY != null) {
                    ScrollFragmentTabHost.this.jNY.UG();
                }
            }
        });
        this.jNX.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void Mr(String str) {
                if (ScrollFragmentTabHost.this.jNY != null) {
                    ScrollFragmentTabHost.this.jNY.UG();
                    ScrollFragmentTabHost.this.jNY = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    bf.bua().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.jNX.setVisibility(8);
            this.jNH.setMissionEntranceVisibility(true);
            this.jNH.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void Mr(String str) {
                    if (ScrollFragmentTabHost.this.jNY != null) {
                        ScrollFragmentTabHost.this.jNY.UG();
                        ScrollFragmentTabHost.this.jNY = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        bf.bua().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.jNX.setVisibility(0);
        this.jNH.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.jNV.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.jNV);
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
        this.grf.a(aVar);
        MessageManager.getInstance().registerListener(this.jNP);
        MessageManager.getInstance().registerListener(this.jNQ);
        MessageManager.getInstance().registerListener(this.jNT);
        MessageManager.getInstance().registerListener(this.jNR);
        MessageManager.getInstance().registerListener(this.jNS);
        MessageManager.getInstance().registerListener(this.mYoungsterModeChangeListener);
        this.jNU.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.jNU);
    }

    public void notifyDataSetChanged() {
        if (this.jNK != null && !HomePageStatic.jIJ) {
            this.eRw.setAdapter(this.jNK);
            this.jNH.notifyDataSetChanged();
            this.jOb.a(this.jOc);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.jNK != null) {
            this.jNK.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.jNK != null) {
            this.jNK.d(dataRes, z);
        }
    }

    public void cOq() {
        if (this.jNK != null) {
            this.jNK.cOq();
        }
    }

    public void z(String str, int i, int i2) {
        if (this.eRw != null) {
            this.jNK.z(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.jNK = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.jNK.setScrollFragmentTabHost(this);
        this.eRw.setOffscreenPageLimit(2);
        this.eRw.setAdapter(this.jNK);
        int cOn = this.jNK.cOn();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.jNK;
        if (HomePageStatic.jIJ) {
            cOn = 0;
        }
        this.eRw.setCurrentItem(newScrollFragmentAdapter.CI(cOn));
        this.jNH.setViewPager(this.eRw);
        this.jNH.setConcernTabIndex(this.jNK.CI(0));
        this.jNH.setHotTopicTabIndex(this.jNK.CI(5));
        this.jNH.setShowHotTopicRedTip(cOz());
    }

    private boolean cOz() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            if (currentTimeMillis - com.baidu.tbadk.core.sharedPref.b.bsO().getLong("unlogin_hot_top_timestamp", 0L) >= 86400000) {
                return true;
            }
        } else {
            long j = com.baidu.tbadk.core.sharedPref.b.bsO().getLong(TbadkApplication.getCurrentAccount(), 0L);
            if (!StringUtils.isNull(TbadkApplication.getCurrentAccount()) && currentTimeMillis - j >= 86400000) {
                return true;
            }
        }
        return false;
    }

    public boolean cOA() {
        return this.jNK != null && this.jNK.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.jNK.getCount()) {
            this.jNH.setTabItemClicked(z);
            this.jNK.CL(i);
            this.eRw.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.jNK.CI(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.jNK.CI(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.jNK.Ms(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jNH.setPageUniqueId(bdUniqueId);
        this.jNP.setTag(bdUniqueId);
        this.jNQ.setTag(bdUniqueId);
        this.jNT.setTag(bdUniqueId);
        this.jNR.setTag(bdUniqueId);
        this.mYoungsterModeChangeListener.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.bzj;
    }

    public int getCurrentTabType() {
        return this.jNK.CH(this.eRw.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.eRw.getAdapter() != null) {
            int count = this.eRw.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.jNK.CH(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int CO(int i) {
        return this.jNK.CH(i);
    }

    public void onChangeSkinType(int i) {
        if (com.baidu.tbadk.a.d.bkA()) {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jNW).setBackGroundColor(R.color.CAM_X0208);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jNW).k(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
        }
        this.jNX.onChangeSkinType();
        this.jNH.onChangeSkinType();
        if (this.mPageContext != null && this.grf != null) {
            this.grf.onChangeSkinType(this.mPageContext, i);
        }
        if (this.jNK != null) {
            this.jNK.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.ivm != null) {
            this.ivm.onChangeSkinType(this.mPageContext, i);
        }
        if (this.jNZ != null) {
            this.jNZ.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this.fYf, R.color.CAM_X0203);
        ap.setBackgroundResource(this.gtB, R.drawable.personalize_tab_shadow);
    }

    private boolean bSu() {
        return this.gtB.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.jNJ = z;
        if (z) {
            if (this.fYf != null) {
                this.fYf.setVisibility(8);
            }
        } else if (this.fYf != null) {
            this.fYf.setVisibility(0);
        }
    }

    public void bSv() {
        if (this.jNJ && !bSu()) {
            this.gtB.setVisibility(0);
            if (this.gtE == null) {
                this.gtE = new AlphaAnimation(0.0f, 1.0f);
                this.gtE.setFillAfter(true);
                this.gtE.setDuration(300L);
            }
            this.gtB.startAnimation(this.gtE);
        }
    }

    public void bSw() {
        if (this.jNJ && bSu()) {
            if (this.gtF == null) {
                this.gtF = new AlphaAnimation(1.0f, 0.0f);
                this.gtF.setFillAfter(true);
                this.gtF.setDuration(300L);
                this.gtF.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.gtB.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gtB.startAnimation(this.gtF);
        }
    }

    public void cOs() {
        if (this.jNK != null) {
            this.jNK.cOs();
        }
    }

    public void bTa() {
        this.jNK.bTa();
    }

    public String getCurrentPageKey() {
        if (this.jNK != null) {
            return this.jNK.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.eRw != null) {
            return this.eRw.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
        if (this.jNK != null) {
            this.jNK.setPrimary(z);
        }
        if (this.grf != null && z) {
            this.grf.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cOB() {
        this.jNK.a(this.jOd);
    }

    public void qf(boolean z) {
    }

    public void cOC() {
        if (this.jNW != null && !this.jNW.isSticky() && this.jNH != null && this.jNH.getTaskView() != null && this.jNH.getTaskView().getVisibility() != 0) {
            this.jNH.cOL();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.jNL = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.jNY != null) {
            this.jNY.UG();
            this.jNY = null;
        }
        cOF();
        MessageManager.getInstance().unRegisterListener(this.jNS);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.jNH != null && this.jNK.cOo()) {
            this.jNH.setShowConcernRedTip(z);
        }
    }

    public boolean cOu() {
        if (this.jNH == null || !this.jNK.cOo()) {
            return false;
        }
        return this.jNH.cOu();
    }

    public boolean cOv() {
        if (this.jNH == null || this.jNK == null || !this.jNK.cOp()) {
            return false;
        }
        return this.jNH.cOv();
    }

    public void setVideoThreadId(String str) {
        if (this.jNK != null) {
            this.jNK.setVideoThreadId(str);
        }
    }

    public void cOD() {
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int CI = this.jNK != null ? this.jNK.CI(0) : 0;
            if (this.jNM == null) {
                this.jNM = new e(this.mPageContext, this.jNH.CM(CI));
                this.jNM.fO(R.drawable.bg_tip_blue_up);
                this.jNM.fN(32);
                this.jNM.pf(true);
                this.jNM.setUseDirectOffset(true);
                this.jNM.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.jNM.fP(4000);
            }
            this.jNM.A(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cOE() {
        if (TbadkCoreApplication.isLogin()) {
            int CI = this.jNK != null ? this.jNK.CI(0) : 0;
            if (this.jNM == null) {
                this.jNM = new e(this.mPageContext, this.jNH.CM(CI));
                this.jNM.fO(R.drawable.bg_tip_blue_up_left);
                this.jNM.fN(16);
                this.jNM.pf(true);
                this.jNM.yt(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.jNM.setUseDirectOffset(true);
                this.jNM.fP(4000);
            }
            this.jNM.aP(this.mContext.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void cOF() {
        if (this.jNM != null) {
            this.jNM.UG();
        }
    }

    public void onResume() {
        if (this.jNH != null) {
            this.jNH.onResume();
        }
    }

    public void a(a aVar) {
        if (this.jNN == null) {
            this.jNN = new ArrayList();
        }
        this.jNN.add(aVar);
    }

    public void b(a aVar) {
        if (this.jNN != null && this.jNN.size() > 0) {
            this.jNN.remove(aVar);
        }
    }

    /* loaded from: classes22.dex */
    public static abstract class a {
        public void cOG() {
        }

        public void cOH() {
        }

        public void cNC() {
        }
    }
}
