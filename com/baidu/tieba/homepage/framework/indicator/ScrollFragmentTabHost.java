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
    private View fYd;
    private NoNetworkView grd;
    private AlphaAnimation gtC;
    private AlphaAnimation gtD;
    private View gtz;
    private boolean isPrimary;
    private PluginErrorTipView ivk;
    private HomeTabBarView jNF;
    private TBSpecificationBtn jNG;
    private boolean jNH;
    private NewScrollFragmentAdapter jNI;
    private b jNJ;
    private e jNK;
    private List<a> jNL;
    private boolean jNM;
    CustomMessageListener jNN;
    CustomMessageListener jNO;
    CustomMessageListener jNP;
    CustomMessageListener jNQ;
    CustomMessageListener jNR;
    CustomMessageTask jNS;
    CustomMessageTask jNT;
    private StickyAppBarLayout jNU;
    private NestedScrollHeader jNV;
    private e jNW;
    private com.baidu.tieba.homepage.concern.b jNX;
    private boolean jNY;
    private com.baidu.tieba.homepage.framework.indicator.b jNZ;
    private com.baidu.tieba.homepage.framework.e jOa;
    private d jOb;
    private Context mContext;
    private TbPageContext mPageContext;
    CustomMessageListener mYoungsterModeChangeListener;

    /* loaded from: classes22.dex */
    public interface b {
        void CP(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.jNM = false;
        this.jNN = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bSu();
                } else {
                    ScrollFragmentTabHost.this.bSv();
                }
            }
        };
        this.jNO = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.jNW != null) {
                    ScrollFragmentTabHost.this.jNW.UG();
                    ScrollFragmentTabHost.this.jNW = null;
                }
            }
        };
        this.jNP = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jNF.CM(0);
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
                        if (ScrollFragmentTabHost.this.jNF != null) {
                            ScrollFragmentTabHost.this.jNX.setBackgroundAlpha(ScrollFragmentTabHost.this.jNF.getBackgroundAlpha());
                            ScrollFragmentTabHost.this.jNX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        ScrollFragmentTabHost.this.jNX.a(ScrollFragmentTabHost.this.jNU);
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
        this.jNQ = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.jNY != com.baidu.tbadk.a.d.bkz()) {
                    ScrollFragmentTabHost.this.jNF.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bkz() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cOE();
                        ScrollFragmentTabHost.this.cOD();
                    }
                }
            }
        };
        this.jNR = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
                    final String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jNF.CM(0);
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
                if (ScrollFragmentTabHost.this.jNI != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.jNI.cOs();
                    if (!booleanValue || !c.bKl()) {
                        ScrollFragmentTabHost.this.jNI.cOk();
                    } else {
                        ScrollFragmentTabHost.this.jNI.cOj();
                    }
                    ScrollFragmentTabHost.this.jNF.cQC();
                }
            }
        };
        this.jNS = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.jNU == null || ScrollFragmentTabHost.this.jNV == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.jNF.getTaskView() : ScrollFragmentTabHost.this.jNV.getTaskView();
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
                    if (ScrollFragmentTabHost.this.jNW != null) {
                        ScrollFragmentTabHost.this.jNW.UG();
                    }
                    ScrollFragmentTabHost.this.jNW = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.jNW.fN(48);
                    ScrollFragmentTabHost.this.jNW.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.jNW.setAnchor(4);
                    ScrollFragmentTabHost.this.jNW.fP(i);
                    ScrollFragmentTabHost.this.jNW.pf(true);
                    ScrollFragmentTabHost.this.jNW.yt(0);
                    ScrollFragmentTabHost.this.jNW.JA(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.jNT = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.jNU == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bSv();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.jNU.cOI();
                } else if (ScrollFragmentTabHost.this.jNU.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.jNU.cOI();
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
        this.jNZ = new com.baidu.tieba.homepage.framework.indicator.b();
        this.jOa = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void CG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.jNI.CI(i), false);
                ScrollFragmentTabHost.this.jNI.CK(i);
            }
        };
        this.jOb = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void CF(int i) {
                ScrollFragmentTabHost.this.jNZ.a(i, ScrollFragmentTabHost.this.jOa);
            }
        };
        init();
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jNM = false;
        this.jNN = new CustomMessageListener(2921400) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z = false;
                if ((customResponsedMessage.getData() instanceof Boolean) && customResponsedMessage.getData() != null) {
                    z = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
                if (z) {
                    ScrollFragmentTabHost.this.bSu();
                } else {
                    ScrollFragmentTabHost.this.bSv();
                }
            }
        };
        this.jNO = new CustomMessageListener(2921415) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && ScrollFragmentTabHost.this.jNW != null) {
                    ScrollFragmentTabHost.this.jNW.UG();
                    ScrollFragmentTabHost.this.jNW = null;
                }
            }
        };
        this.jNP = new CustomMessageListener(2921501) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jNF.CM(0);
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
                        if (ScrollFragmentTabHost.this.jNF != null) {
                            ScrollFragmentTabHost.this.jNX.setBackgroundAlpha(ScrollFragmentTabHost.this.jNF.getBackgroundAlpha());
                            ScrollFragmentTabHost.this.jNX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        }
                        ScrollFragmentTabHost.this.jNX.a(ScrollFragmentTabHost.this.jNU);
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
        this.jNQ = new CustomMessageListener(2921506) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ScrollFragmentTabHost.this.jNY != com.baidu.tbadk.a.d.bkz()) {
                    ScrollFragmentTabHost.this.jNF.notifyDataSetChanged();
                    if (com.baidu.tbadk.a.d.bkz() && ScrollFragmentTabHost.this.isPrimary) {
                        ScrollFragmentTabHost.this.cOE();
                        ScrollFragmentTabHost.this.cOD();
                    }
                }
            }
        };
        this.jNR = new CustomMessageListener(2921502) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    String string = ScrollFragmentTabHost.this.getResources().getString(R.string.attention_person);
                    final String string2 = ScrollFragmentTabHost.this.getResources().getString(R.string.attention);
                    int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                    LinearLayout linearLayout = (LinearLayout) ScrollFragmentTabHost.this.jNF.CM(0);
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
                if (ScrollFragmentTabHost.this.jNI != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    ScrollFragmentTabHost.this.jNI.cOs();
                    if (!booleanValue || !c.bKl()) {
                        ScrollFragmentTabHost.this.jNI.cOk();
                    } else {
                        ScrollFragmentTabHost.this.jNI.cOj();
                    }
                    ScrollFragmentTabHost.this.jNF.cQC();
                }
            }
        };
        this.jNS = new CustomMessageTask(2921409, new CustomMessageTask.CustomRunnable<n.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.15
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<n.a> customMessage) {
                if (ScrollFragmentTabHost.this.mPageContext == null || ScrollFragmentTabHost.this.mPageContext.getPageActivity().isFinishing() || ScrollFragmentTabHost.this.jNU == null || ScrollFragmentTabHost.this.jNV == null) {
                    return null;
                }
                ImageView taskView = (TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0 ? ScrollFragmentTabHost.this.jNF.getTaskView() : ScrollFragmentTabHost.this.jNV.getTaskView();
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
                    if (ScrollFragmentTabHost.this.jNW != null) {
                        ScrollFragmentTabHost.this.jNW.UG();
                    }
                    ScrollFragmentTabHost.this.jNW = new e(ScrollFragmentTabHost.this.mPageContext, taskView);
                    ScrollFragmentTabHost.this.jNW.fN(48);
                    ScrollFragmentTabHost.this.jNW.setUseDirectOffset(true);
                    ScrollFragmentTabHost.this.jNW.setAnchor(4);
                    ScrollFragmentTabHost.this.jNW.fP(i);
                    ScrollFragmentTabHost.this.jNW.pf(true);
                    ScrollFragmentTabHost.this.jNW.yt(0);
                    ScrollFragmentTabHost.this.jNW.JA(fixedText);
                    return new CustomResponsedMessage<>(2921409, true);
                }
                return null;
            }
        });
        this.jNT = new CustomMessageTask(2921405, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.16
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                boolean z;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Boolean) || ScrollFragmentTabHost.this.jNU == null) {
                    return null;
                }
                ScrollFragmentTabHost.this.bSv();
                if (customMessage.getData().booleanValue()) {
                    z = ScrollFragmentTabHost.this.jNU.cOI();
                } else if (ScrollFragmentTabHost.this.jNU.isSticky() && ScrollFragmentTabHost.this.isPrimary) {
                    ScrollFragmentTabHost.this.jNU.cOI();
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
        this.jNZ = new com.baidu.tieba.homepage.framework.indicator.b();
        this.jOa = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.8
            @Override // com.baidu.tieba.homepage.framework.e
            public void CG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.jNI.CI(i), false);
                ScrollFragmentTabHost.this.jNI.CK(i);
            }
        };
        this.jOb = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.9
            @Override // com.baidu.tieba.homepage.framework.d
            public void CF(int i) {
                ScrollFragmentTabHost.this.jNZ.a(i, ScrollFragmentTabHost.this.jOa);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(getContext()).inflate(R.layout.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.jNU = (StickyAppBarLayout) findViewById(R.id.app_bar_layout);
        this.jNV = (NestedScrollHeader) findViewById(R.id.home_nested_header);
        this.jNF = (HomeTabBarView) findViewById(R.id.home_tab_bar_view);
        this.ivk = (PluginErrorTipView) findViewById(R.id.view_plugin_error_tip);
        this.grd = (NoNetworkView) findViewById(R.id.view_no_network);
        this.bzj = (FrameLayout) findViewById(R.id.home_pager_container);
        this.eRw = (CustomViewPager) findViewById(R.id.tab_widget_view_pager);
        this.fYd = findViewById(R.id.divider_line);
        this.gtz = findViewById(R.id.divider_shadow);
        this.jNG = (TBSpecificationBtn) findViewById(R.id.homepage_test_post_btn);
        this.jNG.setVisibility(8);
        this.jNX = new com.baidu.tieba.homepage.concern.b(this.mContext);
        this.jNY = com.baidu.tbadk.a.d.bkz();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.jNU.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        ((CoordinatorLayout.LayoutParams) this.bzj.getLayoutParams()).topMargin = 0;
        this.jNF.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.jNI.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.jNJ != null) {
                    ScrollFragmentTabHost.this.jNJ.CP(i);
                }
                com.baidu.tbadk.core.bigday.b.bmd().iW(ScrollFragmentTabHost.this.jNI.CH(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (i == 0 || i == 1 || (i == 2 && homeBarShowType == 1)) {
                    if (ScrollFragmentTabHost.this.CO(i) != 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 4));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 6));
                    }
                }
                int CH = ScrollFragmentTabHost.this.jNI.CH(ScrollFragmentTabHost.this.eRw.getCurrentItem());
                if (CH == 5) {
                    if (ScrollFragmentTabHost.this.jNM) {
                        ScrollFragmentTabHost.this.jNM = false;
                    } else {
                        ar arVar = new ar("c13740");
                        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar.al("obj_type", ScrollFragmentTabHost.this.cOu() ? 1 : 0);
                        arVar.btT();
                    }
                }
                if (CH == 0) {
                    ScrollFragmentTabHost.this.cOE();
                }
                View CM = ScrollFragmentTabHost.this.jNF.CM(0);
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
                if (ScrollFragmentTabHost.this.jNL != null && ScrollFragmentTabHost.this.jNI != null) {
                    int CH2 = ScrollFragmentTabHost.this.jNI.CH(ScrollFragmentTabHost.this.eRw.getCurrentItem());
                    if (CH2 == 5) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar : ScrollFragmentTabHost.this.jNL) {
                            aVar.cOG();
                        }
                    } else if (CH2 == 1) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar2 : ScrollFragmentTabHost.this.jNL) {
                            aVar2.cOF();
                        }
                    } else if (CH2 == 0) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                        for (a aVar3 : ScrollFragmentTabHost.this.jNL) {
                            aVar3.cNB();
                        }
                    } else if (CH2 == 6) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (CH2 == 7) {
                        ScrollFragmentTabHost.this.setScrollShadow(true);
                    } else if (CH2 == 8) {
                        ScrollFragmentTabHost.this.setScrollShadow(false);
                    } else {
                        ScrollFragmentTabHost.this.bSv();
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
                    if (ScrollFragmentTabHost.this.jNF.cOu()) {
                        ScrollFragmentTabHost.this.jNF.setShowHotTopicRedTip(false);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean cOt = ScrollFragmentTabHost.this.cOt();
                    TiebaStatic.log(new ar("c12350").al("obj_type", cOt ? 1 : 0));
                    if (cOt && ScrollFragmentTabHost.this.jNI != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.jNI.cOq();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
        this.jNF.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
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
                    arVar.al("obj_type", ScrollFragmentTabHost.this.cOu() ? 1 : 0);
                    arVar.btT();
                    ScrollFragmentTabHost.this.jNM = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(TbadkApplication.getCurrentAccount())) {
                            com.baidu.tbadk.core.sharedPref.b.bsO().putLong(TbadkApplication.getCurrentAccount(), currentTimeMillis);
                        }
                    } else {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putLong("unlogin_hot_top_timestamp", currentTimeMillis);
                    }
                    if (ScrollFragmentTabHost.this.jNF.cOu()) {
                        ScrollFragmentTabHost.this.jNF.setShowHotTopicRedTip(false);
                    }
                }
            }
        });
        this.jNU.setOnHeaderStickyListener(new StickyAppBarLayout.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout.a
            public void ry(boolean z) {
                if (z && ScrollFragmentTabHost.this.jNW != null) {
                    ScrollFragmentTabHost.this.jNW.UG();
                }
            }
        });
        this.jNV.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
            public void Mr(String str) {
                if (ScrollFragmentTabHost.this.jNW != null) {
                    ScrollFragmentTabHost.this.jNW.UG();
                    ScrollFragmentTabHost.this.jNW = null;
                }
                if (ScrollFragmentTabHost.this.mPageContext != null) {
                    bf.bua().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                }
            }
        });
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) != 0) {
            this.jNV.setVisibility(8);
            this.jNF.setMissionEntranceVisibility(true);
            this.jNF.setEntranceJumpListener(new NestedScrollHeader.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
                @Override // com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.a
                public void Mr(String str) {
                    if (ScrollFragmentTabHost.this.jNW != null) {
                        ScrollFragmentTabHost.this.jNW.UG();
                        ScrollFragmentTabHost.this.jNW = null;
                    }
                    if (ScrollFragmentTabHost.this.mPageContext != null) {
                        bf.bua().b(ScrollFragmentTabHost.this.mPageContext, new String[]{str});
                    }
                }
            });
            return;
        }
        this.jNV.setVisibility(0);
        this.jNF.setMissionEntranceVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((TbSingleton.getInstance().getHomePageStyleAbTest() & 1) == 0) {
            this.jNT.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.jNT);
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
        this.grd.a(aVar);
        MessageManager.getInstance().registerListener(this.jNN);
        MessageManager.getInstance().registerListener(this.jNO);
        MessageManager.getInstance().registerListener(this.jNR);
        MessageManager.getInstance().registerListener(this.jNP);
        MessageManager.getInstance().registerListener(this.jNQ);
        MessageManager.getInstance().registerListener(this.mYoungsterModeChangeListener);
        this.jNS.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.jNS);
    }

    public void notifyDataSetChanged() {
        if (this.jNI != null && !HomePageStatic.jIH) {
            this.eRw.setAdapter(this.jNI);
            this.jNF.notifyDataSetChanged();
            this.jNZ.a(this.jOa);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.jNI != null) {
            this.jNI.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.jNI != null) {
            this.jNI.d(dataRes, z);
        }
    }

    public void cOp() {
        if (this.jNI != null) {
            this.jNI.cOp();
        }
    }

    public void z(String str, int i, int i2) {
        if (this.eRw != null) {
            this.jNI.z(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.jNI = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.jNI.setScrollFragmentTabHost(this);
        this.eRw.setOffscreenPageLimit(2);
        this.eRw.setAdapter(this.jNI);
        int cOm = this.jNI.cOm();
        NewScrollFragmentAdapter newScrollFragmentAdapter = this.jNI;
        if (HomePageStatic.jIH) {
            cOm = 0;
        }
        this.eRw.setCurrentItem(newScrollFragmentAdapter.CI(cOm));
        this.jNF.setViewPager(this.eRw);
        this.jNF.setConcernTabIndex(this.jNI.CI(0));
        this.jNF.setHotTopicTabIndex(this.jNI.CI(5));
        this.jNF.setShowHotTopicRedTip(cOy());
    }

    private boolean cOy() {
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

    public boolean cOz() {
        return this.jNI != null && this.jNI.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.jNI.getCount()) {
            this.jNF.setTabItemClicked(z);
            this.jNI.CL(i);
            this.eRw.setCurrentItem(i);
        }
    }

    public void setFakeClickCurrentTab(int i) {
        setCurrentTab(this.jNI.CI(i), true);
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.jNI.CI(i), false);
    }

    public void setCurrentTab(String str) {
        setCurrentTab(this.jNI.Ms(str), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.jNF.setPageUniqueId(bdUniqueId);
        this.jNN.setTag(bdUniqueId);
        this.jNO.setTag(bdUniqueId);
        this.jNR.setTag(bdUniqueId);
        this.jNP.setTag(bdUniqueId);
        this.mYoungsterModeChangeListener.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.bzj;
    }

    public int getCurrentTabType() {
        return this.jNI.CH(this.eRw.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        if (this.eRw.getAdapter() != null) {
            int count = this.eRw.getAdapter().getCount();
            for (int i = 0; i < count; i++) {
                if (this.jNI.CH(i) == 8) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int CO(int i) {
        return this.jNI.CH(i);
    }

    public void onChangeSkinType(int i) {
        if (com.baidu.tbadk.a.d.bkA()) {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jNU).setBackGroundColor(R.color.CAM_X0208);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jNU).k(new int[]{R.color.CAM_X0202, R.color.CAM_X0208});
        }
        this.jNV.onChangeSkinType();
        this.jNF.onChangeSkinType();
        if (this.mPageContext != null && this.grd != null) {
            this.grd.onChangeSkinType(this.mPageContext, i);
        }
        if (this.jNI != null) {
            this.jNI.onChangeSkin(i);
        }
        if (this.mPageContext != null && this.ivk != null) {
            this.ivk.onChangeSkinType(this.mPageContext, i);
        }
        if (this.jNX != null) {
            this.jNX.onChangeSkinType(i);
        }
        ap.setBackgroundColor(this.fYd, R.color.CAM_X0203);
        ap.setBackgroundResource(this.gtz, R.drawable.personalize_tab_shadow);
    }

    private boolean bSt() {
        return this.gtz.getVisibility() == 0;
    }

    public void setScrollShadow(boolean z) {
        this.jNH = z;
        if (z) {
            if (this.fYd != null) {
                this.fYd.setVisibility(8);
            }
        } else if (this.fYd != null) {
            this.fYd.setVisibility(0);
        }
    }

    public void bSu() {
        if (this.jNH && !bSt()) {
            this.gtz.setVisibility(0);
            if (this.gtC == null) {
                this.gtC = new AlphaAnimation(0.0f, 1.0f);
                this.gtC.setFillAfter(true);
                this.gtC.setDuration(300L);
            }
            this.gtz.startAnimation(this.gtC);
        }
    }

    public void bSv() {
        if (this.jNH && bSt()) {
            if (this.gtD == null) {
                this.gtD = new AlphaAnimation(1.0f, 0.0f);
                this.gtD.setFillAfter(true);
                this.gtD.setDuration(300L);
                this.gtD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ScrollFragmentTabHost.this.gtz.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gtz.startAnimation(this.gtD);
        }
    }

    public void cOr() {
        if (this.jNI != null) {
            this.jNI.cOr();
        }
    }

    public void bSZ() {
        this.jNI.bSZ();
    }

    public String getCurrentPageKey() {
        if (this.jNI != null) {
            return this.jNI.getCurrentPageKey();
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
        if (this.jNI != null) {
            this.jNI.setPrimary(z);
        }
        if (this.grd != null && z) {
            this.grd.setVisibility(j.isNetworkAvailableForImmediately() ? 8 : 0);
        }
    }

    public void cOA() {
        this.jNI.a(this.jOb);
    }

    public void qf(boolean z) {
    }

    public void cOB() {
        if (this.jNU != null && !this.jNU.isSticky() && this.jNF != null && this.jNF.getTaskView() != null && this.jNF.getTaskView().getVisibility() != 0) {
            this.jNF.cOK();
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.jNJ = bVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(2921409);
        if (this.jNW != null) {
            this.jNW.UG();
            this.jNW = null;
        }
        cOE();
        MessageManager.getInstance().unRegisterListener(this.jNQ);
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.jNF != null && this.jNI.cOn()) {
            this.jNF.setShowConcernRedTip(z);
        }
    }

    public boolean cOt() {
        if (this.jNF == null || !this.jNI.cOn()) {
            return false;
        }
        return this.jNF.cOt();
    }

    public boolean cOu() {
        if (this.jNF == null || this.jNI == null || !this.jNI.cOo()) {
            return false;
        }
        return this.jNF.cOu();
    }

    public void setVideoThreadId(String str) {
        if (this.jNI != null) {
            this.jNI.setVideoThreadId(str);
        }
    }

    public void cOC() {
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int CI = this.jNI != null ? this.jNI.CI(0) : 0;
            if (this.jNK == null) {
                this.jNK = new e(this.mPageContext, this.jNF.CM(CI));
                this.jNK.fO(R.drawable.bg_tip_blue_up);
                this.jNK.fN(32);
                this.jNK.pf(true);
                this.jNK.setUseDirectOffset(true);
                this.jNK.setYOffset(l.getDimens(this.mContext, R.dimen.ds16));
                this.jNK.fP(4000);
            }
            this.jNK.A(this.mContext.getString(R.string.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void cOD() {
        if (TbadkCoreApplication.isLogin()) {
            int CI = this.jNI != null ? this.jNI.CI(0) : 0;
            if (this.jNK == null) {
                this.jNK = new e(this.mPageContext, this.jNF.CM(CI));
                this.jNK.fO(R.drawable.bg_tip_blue_up_left);
                this.jNK.fN(16);
                this.jNK.pf(true);
                this.jNK.yt(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                this.jNK.setUseDirectOffset(true);
                this.jNK.fP(4000);
            }
            this.jNK.aP(this.mContext.getString(R.string.concern_tab_thread_forum_tips), "key_concern_forum_tab_tips_show");
        }
    }

    public void cOE() {
        if (this.jNK != null) {
            this.jNK.UG();
        }
    }

    public void onResume() {
        if (this.jNF != null) {
            this.jNF.onResume();
        }
    }

    public void a(a aVar) {
        if (this.jNL == null) {
            this.jNL = new ArrayList();
        }
        this.jNL.add(aVar);
    }

    public void b(a aVar) {
        if (this.jNL != null && this.jNL.size() > 0) {
            this.jNL.remove(aVar);
        }
    }

    /* loaded from: classes22.dex */
    public static abstract class a {
        public void cOF() {
        }

        public void cOG() {
        }

        public void cNB() {
        }
    }
}
