package com.baidu.tieba.ala.headline.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.util.BdBitmapHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.CenteredImageSpan;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.d.j;
import com.baidu.live.data.l;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private w aFN;
    public l aKt;
    private AnimatorSet aYZ;
    Activity beD;
    private int ds20;
    private int ds240;
    private HeadImageView gUA;
    private HeadImageView gUB;
    private ImageView gUC;
    private TbImageView gUD;
    private TextView gUE;
    private ImageView gUF;
    private ObjectAnimator gUG;
    private ObjectAnimator gUH;
    private ObjectAnimator gUI;
    private ObjectAnimator gUJ;
    private ObjectAnimator gUK;
    private List<Animator> gUL;
    private int gUM;
    private RelativeLayout.LayoutParams gUN;
    private TBLottieAnimationView gUO;
    private View gUP;
    private long gUU;
    private long gUk;
    private View gUn;
    private TextView gUo;
    private ViewGroup gUp;
    private ViewGroup gUq;
    private TextView gUr;
    private TextView gUs;
    private ViewGroup gUt;
    private ViewGroup gUu;
    private View gUv;
    private View gUw;
    private ViewGroup gUx;
    private HeadImageView gUy;
    private HeadImageView gUz;
    private boolean isHost;
    private int mScreenWidth;
    private boolean DEBUG = false;
    String otherParams = "";
    private int aUr = 1;
    private boolean gUm = false;
    private boolean aYO = false;
    private Runnable gUQ = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.15
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.gUm) {
                ObjectAnimator bXw = a.this.bXw();
                if (bXw != null && !bXw.isRunning()) {
                    bXw.start();
                }
                a.this.mHandler.postDelayed(this, 2000L);
            }
        }
    };
    private Runnable gUR = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.16
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.gUm) {
                if (!a.this.aYO) {
                    a.this.mHandler.removeCallbacks(this);
                    return;
                }
                ObjectAnimator bXv = a.this.bXv();
                if (bXv != null && !bXv.isRunning()) {
                    bXv.start();
                }
                a.this.mHandler.postDelayed(this, 1500L);
            }
        }
    };
    private boolean gUS = false;
    private Runnable gUT = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17
        @Override // java.lang.Runnable
        public void run() {
            a.this.gUk--;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913245, Long.valueOf(a.this.gUk)));
            if (a.this.gUk <= 0) {
                a.this.gUs.setText("");
                a.this.gUr.setText("");
                a.this.L(false, false);
                a.this.mHandler.removeCallbacks(this);
                if (a.this.aKt != null) {
                    a.this.gUU = a.this.aKt.aJl;
                    return;
                }
                return;
            }
            a.this.gUs.setText(a.this.gUk + "s");
            if (a.this.gUS) {
                a.this.gUS = false;
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.gUr != null) {
                            a.this.gUr.setText(a.this.gUk + "s");
                        }
                    }
                }, 1000L);
            } else {
                a.this.gUr.setText(a.this.gUk + "s");
            }
            a.this.mHandler.postDelayed(this, 1000L);
        }
    };
    private List<l> mList = new ArrayList();
    private Handler mHandler = new Handler();

    public View bXo() {
        return this.gUP;
    }

    public a(TbPageContext tbPageContext) {
        this.beD = tbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.gUn = LayoutInflater.from(this.beD).inflate(a.g.sdk_headline_layout, (ViewGroup) null, false);
        this.gUq = (ViewGroup) this.gUn.findViewById(a.f.ala_sdk_rl_all_content_container);
        this.gUt = (ViewGroup) this.gUn.findViewById(a.f.ala_ll_have_fixed_container);
        this.gUu = (ViewGroup) this.gUn.findViewById(a.f.ala_ll_empty_fixed_container);
        this.gUr = (TextView) this.gUn.findViewById(a.f.ala_tv_time);
        this.gUF = (ImageView) this.gUn.findViewById(a.f.ala_sdk_iv_sweep);
        this.gUz = (HeadImageView) this.gUn.findViewById(a.f.ala_iv_host_head);
        b(this.gUz);
        this.gUy = (HeadImageView) this.gUn.findViewById(a.f.ala_iv_user_head);
        b(this.gUy);
        this.gUE = (TextView) this.gUn.findViewById(a.f.ala_sdk_head_line_tv_text);
        this.gUD = (TbImageView) this.gUn.findViewById(a.f.ala_iv_empty_icon);
        this.gUv = this.gUn.findViewById(a.f.ala_sdk_rl_boardcast_root_view);
        this.gUv.setVisibility(4);
        this.gUw = this.gUv.findViewById(a.f.ala_sdk_anim_container);
        this.gUx = (ViewGroup) this.gUv.findViewById(a.f.ala_anim_ll_have_fixed_container);
        this.gUs = (TextView) this.gUv.findViewById(a.f.ala_anim_tv_time);
        this.gUo = (TextView) this.gUv.findViewById(a.f.ala_sdk_tv_gift_show);
        this.gUp = (ViewGroup) this.gUv.findViewById(a.f.ala_sdk_ll_gift_text_show_container);
        this.gUB = (HeadImageView) this.gUv.findViewById(a.f.ala_anim_iv_host_head);
        b(this.gUB);
        this.gUA = (HeadImageView) this.gUv.findViewById(a.f.ala_anim_iv_user_head);
        b(this.gUA);
        this.gUC = (ImageView) this.gUv.findViewById(a.f.ala_sdk_iv_anim_sweep);
        this.gUq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.RU();
            }
        });
        this.gUv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.RU();
            }
        });
        this.gUP = LayoutInflater.from(this.beD).inflate(a.g.ala_sdk_head_line_lottie_layout, (ViewGroup) null, false);
        this.gUO = (TBLottieAnimationView) this.gUP.findViewById(a.f.ala_sdk_head_line_lot_view);
        this.gUO.setAnimation("head_linedata_explosion.json");
        this.gUO.setAnimationDir("/");
        this.gUN = (RelativeLayout.LayoutParams) this.gUw.getLayoutParams();
        this.mScreenWidth = ScreenHelper.getRealScreenWidth(this.beD);
        this.ds20 = this.beD.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.ds240 = this.beD.getResources().getDimensionPixelSize(a.d.sdk_ds232);
        this.gUM = this.mScreenWidth - (this.ds20 * 2);
        this.gUN.width = this.gUM;
        this.gUw.setLayoutParams(this.gUN);
        this.mHandler.postDelayed(this.gUQ, 2000L);
    }

    private void b(HeadImageView headImageView) {
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setBorderWidth(BdUtilHelper.getDimens(this.beD, a.d.sdk_ds2));
        headImageView.setBorderColor(-1);
    }

    public View getRootView() {
        return this.gUn;
    }

    private void a(final l lVar, boolean z) {
        if (lVar != null) {
            this.gUB.startLoad(lVar.aJs, 12, false);
            this.gUA.startLoad(lVar.aJt, 12, false);
            if (z) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(lVar);
                    }
                }, 1000L);
                final SpannableStringBuilder c = c(lVar);
                if (c == null || c.length() <= 0) {
                    IT();
                    next();
                    return;
                }
                this.aYO = true;
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.14
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.e(c);
                    }
                }, 300L);
                return;
            }
            a(lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        if (this.gUz != null && lVar != null) {
            this.gUz.startLoad(lVar.aJs, 12, false);
        }
        if (this.gUy != null && lVar != null) {
            this.gUy.startLoad(lVar.aJt, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SpannableStringBuilder spannableStringBuilder) {
        if (this.beD != null) {
            if (spannableStringBuilder == null || spannableStringBuilder.length() <= 0) {
                IT();
                next();
                return;
            }
            this.gUo.setText(spannableStringBuilder);
            this.gUo.setTranslationX(0.0f);
            int textWidth = BdUtilHelper.getTextWidth(this.gUo.getPaint(), spannableStringBuilder.toString());
            int width = this.gUp.getWidth();
            int width2 = this.gUx.getWidth();
            int i = width > 0 ? width : this.gUM - this.ds240;
            float f = -(textWidth - i);
            if (this.DEBUG) {
                Log.e(">>>>>>", "1 calculateWidthAndStartAnimator ssb.length:" + spannableStringBuilder.length() + " " + spannableStringBuilder.toString() + " mScreenWidth：" + this.mScreenWidth);
                Log.e(">>>>>>", "2 maxContentLength:" + i + " textWidth:" + textWidth + " desToXValue:" + f + " mBoardCastContentWidth:" + this.gUM + " mLlBoardCastContainerView width:" + width + " mBoardCastFixedContainerViewwidth1: " + width2);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gUo.getLayoutParams();
            if (textWidth < i) {
                layoutParams.width = -2;
                this.gUo.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = textWidth;
                this.gUo.setLayoutParams(layoutParams);
                this.gUG = ObjectAnimator.ofFloat(this.gUo, "translationX", 0.0f, f);
                this.gUG.setDuration(1000L);
                this.gUG.setStartDelay(1000L);
            }
            ObjectAnimator bXu = bXu();
            ValueAnimator bXt = bXt();
            ObjectAnimator bXs = bXs();
            ObjectAnimator bXv = bXv();
            ObjectAnimator bXr = bXr();
            ObjectAnimator bXq = bXq();
            this.aYZ = new AnimatorSet();
            this.gUL = new ArrayList();
            this.gUL.add(bXu);
            this.gUL.add(bXr);
            this.gUL.add(bXq);
            if (this.gUG != null) {
                this.gUL.add(this.gUG);
            }
            this.gUL.add(bXv);
            this.gUL.add(bXt);
            this.gUL.add(bXs);
            this.aYZ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.18
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.IT();
                    a.this.aYZ.removeAllListeners();
                    a.this.next();
                }
            });
            this.aYZ.playTogether(this.gUL);
            this.aYZ.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        if (this.DEBUG) {
            Log.e(">>>>>>", "1-next:mList.size:" + this.mList.size());
        }
        if (!this.mList.isEmpty()) {
            l lVar = this.mList.get(this.mList.size() - 1);
            if (lVar.aJn > this.gUU) {
                this.aKt = lVar;
                this.gUU = this.aKt.aJn;
                this.gUk = this.aKt.endTime - this.aKt.serverTime;
                bXp();
                a(this.aKt, true);
            }
            this.mList.clear();
        }
    }

    private void bXp() {
        this.gUS = true;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.19
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.gUT);
                if (a.this.gUk > 1) {
                    a.this.gUk++;
                }
                a.this.mHandler.post(a.this.gUT);
            }
        });
    }

    private ObjectAnimator bXq() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gUq, "alpha", 0.1f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(6700L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.gUq.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.mHandler.removeCallbacks(a.this.gUQ);
                a.this.mHandler.post(a.this.gUQ);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bXr() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gUq, "translationX", 0.0f, this.gUq.getWidth());
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(100L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.gUq.setTranslationX(0.0f);
                a.this.gUq.setVisibility(4);
                a.this.gUO.setVisibility(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.gUO.setVisibility(0);
                a.this.gUO.playAnimation();
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bXs() {
        if (this.gUK == null) {
            this.gUK = ObjectAnimator.ofFloat(this.gUv, "alpha", 1.0f, 0.0f);
            this.gUK.setDuration(300L);
            this.gUK.setStartDelay(6700L);
        }
        return this.gUK;
    }

    private ValueAnimator bXt() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.gUw.getMeasuredWidth() - this.gUq.getMeasuredWidth());
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (a.this.gUN.leftMargin < intValue) {
                    a.this.gUN.leftMargin = intValue;
                    a.this.gUw.setLayoutParams(a.this.gUN);
                }
            }
        });
        ofInt.setStartDelay(6000L);
        ofInt.setDuration(1000L);
        return ofInt;
    }

    private ObjectAnimator bXu() {
        if (this.gUJ == null) {
            this.gUJ = ObjectAnimator.ofFloat(this.gUv, "translationX", -this.mScreenWidth, 0.0f);
            this.gUJ.setDuration(1000L);
            this.gUJ.setInterpolator(new OvershootInterpolator());
            this.gUJ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.aYO = true;
                    a.this.gUv.setVisibility(0);
                }
            });
        }
        return this.gUJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator bXv() {
        if (this.gUH == null) {
            this.gUH = ObjectAnimator.ofFloat(this.gUC, "translationX", 0.0f, this.gUM);
            this.gUH.setDuration(800L);
            this.gUH.setInterpolator(new AccelerateInterpolator());
            this.gUH.setStartDelay(1000L);
            this.gUH.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    a.this.gUC.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.gUC.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.gUC.setVisibility(8);
                    a.this.mHandler.removeCallbacks(a.this.gUR);
                    a.this.mHandler.postDelayed(a.this.gUR, 1500L);
                }
            });
            this.gUH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                        a.this.gUC.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                    } else {
                        a.this.gUC.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                    }
                }
            });
        } else {
            this.gUC.clearAnimation();
        }
        return this.gUH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator bXw() {
        int width;
        if (this.gUF == null) {
            return null;
        }
        if ((this.gUu.getVisibility() == 0 || this.gUt.getVisibility() == 0) && (width = this.gUq.getWidth()) > 0) {
            this.gUF.clearAnimation();
            if (this.gUI == null) {
                this.gUI = ObjectAnimator.ofFloat(this.gUF, "translationX", 0.0f, width);
                this.gUI.setDuration(1000L);
                this.gUI.setInterpolator(new AccelerateInterpolator());
                this.gUI.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.8
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        a.this.gUF.setVisibility(0);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.gUF.setVisibility(8);
                    }
                });
                this.gUI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.9
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                            a.this.gUF.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                        } else {
                            a.this.gUF.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                        }
                    }
                });
            } else {
                this.gUI.setFloatValues(0.0f, width);
            }
            return this.gUI;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IT() {
        this.aYO = false;
        this.gUv.clearAnimation();
        this.gUo.clearAnimation();
        this.gUq.clearAnimation();
        this.gUq.setAlpha(1.0f);
        this.gUo.setAlpha(1.0f);
        this.gUC.clearAnimation();
        this.gUv.setAlpha(1.0f);
        this.gUN.leftMargin = 0;
        this.gUw.setLayoutParams(this.gUN);
        this.gUv.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(final boolean z, boolean z2) {
        this.aUr = z ? 2 : 1;
        if (z2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        a.this.gUt.setVisibility(0);
                        a.this.gUu.setVisibility(8);
                        return;
                    }
                    a.this.gUt.setVisibility(8);
                    a.this.gUu.setVisibility(0);
                }
            }, 1000L);
        } else if (z) {
            this.gUt.setVisibility(0);
            this.gUu.setVisibility(8);
        } else {
            this.gUt.setVisibility(8);
            this.gUu.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RU() {
        if (this.aFN != null && this.aFN.aKt != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new j(this.beD, this.aFN, this.aUr, this.otherParams, this.gUk)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aFN));
        }
    }

    public void mS(boolean z) {
        this.gUn.setVisibility(8);
        if (this.DEBUG) {
            Log.e(">>>>>>", "onCloseEntryView first：" + z);
        }
        this.gUU = 0L;
        this.gUm = true;
        if (!z) {
            IT();
            this.mList.clear();
        }
    }

    public void bXx() {
        if (this.gUn != null && this.gUn.getVisibility() != 0) {
            if (this.DEBUG) {
                Log.e(">>>>>>", "setEntryViewVisibility");
            }
            this.gUm = false;
            this.mHandler.removeCallbacks(this.gUQ);
            this.mHandler.post(this.gUQ);
            this.gUn.setVisibility(0);
        }
    }

    public void z(w wVar) {
        l lVar = wVar.aKt;
        this.aFN = wVar;
        this.isHost = wVar.isHost;
        if (lVar.endTime - lVar.serverTime <= 1) {
            this.gUU = lVar.aJl;
            L(false, false);
        } else {
            if (this.gUU <= 0) {
                this.gUU = lVar.aJn;
            }
            if (this.gUU < lVar.aJn) {
                if (this.aUr != 1) {
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "3 setData countdownTime:" + this.gUk + " mCurScore:" + this.gUU);
                    }
                    if (!b(lVar)) {
                        this.mList.add(lVar);
                    }
                }
                if (this.aYO) {
                    if (!b(lVar)) {
                        this.mList.add(lVar);
                    }
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "2 setData countdownTime:" + this.gUk + " mCurScore:" + this.gUU);
                    }
                } else {
                    if (this.aUr == 1) {
                        L(true, true);
                    }
                    this.aKt = lVar;
                    this.gUU = lVar.aJn;
                    this.gUk = lVar.endTime - lVar.serverTime;
                    bXp();
                    a(this.aKt, true);
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "1 setData countdownTime:" + this.gUk + " mCurScore:" + this.gUU + "info.endTime:" + lVar.endTime + " info.serverTime:" + lVar.serverTime);
                    }
                }
            } else {
                this.aKt = lVar;
                this.gUU = lVar.aJn;
                if (this.gUU <= lVar.aJl) {
                    this.gUk = 0L;
                    L(false, false);
                } else {
                    if (this.gUk <= 0) {
                        this.gUk = lVar.endTime - lVar.serverTime;
                    } else {
                        long j = lVar.endTime - lVar.serverTime;
                        if (j < this.gUk && j > 1) {
                            this.gUk = j;
                        }
                    }
                    L(true, true);
                    bXp();
                    a(this.aKt, false);
                }
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aFN));
        this.gUm = false;
    }

    private boolean b(l lVar) {
        if (this.mList.isEmpty()) {
            return false;
        }
        Iterator<l> it = this.mList.iterator();
        while (it.hasNext()) {
            if (it.next().aJn == lVar.aJn) {
                return true;
            }
        }
        return false;
    }

    public void onDestory() {
        this.gUU = 0L;
        this.gUm = true;
        this.gUk = 0L;
    }

    public void Mg() {
        this.gUk = 0L;
        this.gUU = 0L;
        this.aUr = 1;
        this.aYO = false;
        this.gUm = true;
        if (this.mList != null) {
            this.mList.clear();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        IT();
    }

    public SpannableStringBuilder c(l lVar) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            spannableStringBuilder.append((CharSequence) lVar.userName);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFEAAA")), 0, lVar.userName.length(), 33);
            spannableStringBuilder.append((CharSequence) " 送给 ");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) lVar.aJr);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFEAAA")), length, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) (" " + lVar.giftName));
            final int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) "[img]");
            spannableStringBuilder.append((CharSequence) ("X" + lVar.giftNum + "个"));
            BdResourceLoader.getInstance().loadResource(lVar.aJq, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.tieba.ala.headline.view.a.11
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i) {
                    super.onLoaded((AnonymousClass11) bdImage, str, i);
                    Bitmap a2 = a.this.a(bdImage);
                    if (a2 != null) {
                        CenteredImageSpan centeredImageSpan = new CenteredImageSpan(a.this.beD, a2);
                        SpannableString spannableString = new SpannableString("[img]");
                        spannableString.setSpan(centeredImageSpan, 0, spannableString.length(), 33);
                        spannableStringBuilder.replace(length2, length2 + "[img]".length(), (CharSequence) spannableString);
                        a.this.gUo.setText(spannableStringBuilder);
                        a.this.gUo.forceLayout();
                    }
                }
            }, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(BdImage bdImage) {
        Bitmap copy;
        Bitmap copy2;
        if (bdImage == null) {
            return null;
        }
        Bitmap rawBitmap = bdImage.getRawBitmap();
        if (rawBitmap == null || rawBitmap.isRecycled()) {
            return null;
        }
        try {
            if (rawBitmap.getConfig() == null) {
                copy2 = rawBitmap.copy(Bitmap.Config.ARGB_8888, false);
            } else {
                copy2 = rawBitmap.copy(rawBitmap.getConfig(), false);
            }
            copy = copy2;
        } catch (OutOfMemoryError e) {
            BdLog.e(e);
            if (rawBitmap.getConfig() != null) {
                return null;
            }
            try {
                copy = rawBitmap.copy(Bitmap.Config.RGB_565, false);
            } catch (OutOfMemoryError e2) {
                BdLog.e(e2);
                return null;
            }
        }
        if (copy == null) {
            return null;
        }
        int dimensionPixelSize = this.beD.getResources().getDimensionPixelSize(a.d.sdk_ds24);
        try {
            Bitmap resizeBitmap = BdBitmapHelper.getInstance().resizeBitmap(copy, (int) (((copy.getWidth() * 1.0f) * dimensionPixelSize) / copy.getHeight()), dimensionPixelSize);
            if (resizeBitmap != copy) {
                copy.recycle();
                return resizeBitmap;
            }
            return resizeBitmap;
        } catch (OutOfMemoryError e3) {
            BdLog.e(e3);
            if (copy != null) {
                copy.recycle();
            }
            return null;
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void en(int i) {
    }
}
