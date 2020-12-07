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
    private ImageView gUA;
    private TbImageView gUB;
    private TextView gUC;
    private ImageView gUD;
    private ObjectAnimator gUE;
    private ObjectAnimator gUF;
    private ObjectAnimator gUG;
    private ObjectAnimator gUH;
    private ObjectAnimator gUI;
    private List<Animator> gUJ;
    private int gUK;
    private RelativeLayout.LayoutParams gUL;
    private TBLottieAnimationView gUM;
    private View gUN;
    private long gUS;
    private long gUi;
    private View gUl;
    private TextView gUm;
    private ViewGroup gUn;
    private ViewGroup gUo;
    private TextView gUp;
    private TextView gUq;
    private ViewGroup gUr;
    private ViewGroup gUs;
    private View gUt;
    private View gUu;
    private ViewGroup gUv;
    private HeadImageView gUw;
    private HeadImageView gUx;
    private HeadImageView gUy;
    private HeadImageView gUz;
    private boolean isHost;
    private int mScreenWidth;
    private boolean DEBUG = false;
    String otherParams = "";
    private int aUr = 1;
    private boolean gUk = false;
    private boolean aYO = false;
    private Runnable gUO = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.15
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.gUk) {
                ObjectAnimator bXv = a.this.bXv();
                if (bXv != null && !bXv.isRunning()) {
                    bXv.start();
                }
                a.this.mHandler.postDelayed(this, 2000L);
            }
        }
    };
    private Runnable gUP = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.16
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.gUk) {
                if (!a.this.aYO) {
                    a.this.mHandler.removeCallbacks(this);
                    return;
                }
                ObjectAnimator bXu = a.this.bXu();
                if (bXu != null && !bXu.isRunning()) {
                    bXu.start();
                }
                a.this.mHandler.postDelayed(this, 1500L);
            }
        }
    };
    private boolean gUQ = false;
    private Runnable gUR = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17
        @Override // java.lang.Runnable
        public void run() {
            a.this.gUi--;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913245, Long.valueOf(a.this.gUi)));
            if (a.this.gUi <= 0) {
                a.this.gUq.setText("");
                a.this.gUp.setText("");
                a.this.L(false, false);
                a.this.mHandler.removeCallbacks(this);
                if (a.this.aKt != null) {
                    a.this.gUS = a.this.aKt.aJl;
                    return;
                }
                return;
            }
            a.this.gUq.setText(a.this.gUi + "s");
            if (a.this.gUQ) {
                a.this.gUQ = false;
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.gUp != null) {
                            a.this.gUp.setText(a.this.gUi + "s");
                        }
                    }
                }, 1000L);
            } else {
                a.this.gUp.setText(a.this.gUi + "s");
            }
            a.this.mHandler.postDelayed(this, 1000L);
        }
    };
    private List<l> mList = new ArrayList();
    private Handler mHandler = new Handler();

    public View bXn() {
        return this.gUN;
    }

    public a(TbPageContext tbPageContext) {
        this.beD = tbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.gUl = LayoutInflater.from(this.beD).inflate(a.g.sdk_headline_layout, (ViewGroup) null, false);
        this.gUo = (ViewGroup) this.gUl.findViewById(a.f.ala_sdk_rl_all_content_container);
        this.gUr = (ViewGroup) this.gUl.findViewById(a.f.ala_ll_have_fixed_container);
        this.gUs = (ViewGroup) this.gUl.findViewById(a.f.ala_ll_empty_fixed_container);
        this.gUp = (TextView) this.gUl.findViewById(a.f.ala_tv_time);
        this.gUD = (ImageView) this.gUl.findViewById(a.f.ala_sdk_iv_sweep);
        this.gUx = (HeadImageView) this.gUl.findViewById(a.f.ala_iv_host_head);
        b(this.gUx);
        this.gUw = (HeadImageView) this.gUl.findViewById(a.f.ala_iv_user_head);
        b(this.gUw);
        this.gUC = (TextView) this.gUl.findViewById(a.f.ala_sdk_head_line_tv_text);
        this.gUB = (TbImageView) this.gUl.findViewById(a.f.ala_iv_empty_icon);
        this.gUt = this.gUl.findViewById(a.f.ala_sdk_rl_boardcast_root_view);
        this.gUt.setVisibility(4);
        this.gUu = this.gUt.findViewById(a.f.ala_sdk_anim_container);
        this.gUv = (ViewGroup) this.gUt.findViewById(a.f.ala_anim_ll_have_fixed_container);
        this.gUq = (TextView) this.gUt.findViewById(a.f.ala_anim_tv_time);
        this.gUm = (TextView) this.gUt.findViewById(a.f.ala_sdk_tv_gift_show);
        this.gUn = (ViewGroup) this.gUt.findViewById(a.f.ala_sdk_ll_gift_text_show_container);
        this.gUz = (HeadImageView) this.gUt.findViewById(a.f.ala_anim_iv_host_head);
        b(this.gUz);
        this.gUy = (HeadImageView) this.gUt.findViewById(a.f.ala_anim_iv_user_head);
        b(this.gUy);
        this.gUA = (ImageView) this.gUt.findViewById(a.f.ala_sdk_iv_anim_sweep);
        this.gUo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.RU();
            }
        });
        this.gUt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.RU();
            }
        });
        this.gUN = LayoutInflater.from(this.beD).inflate(a.g.ala_sdk_head_line_lottie_layout, (ViewGroup) null, false);
        this.gUM = (TBLottieAnimationView) this.gUN.findViewById(a.f.ala_sdk_head_line_lot_view);
        this.gUM.setAnimation("head_linedata_explosion.json");
        this.gUM.setAnimationDir("/");
        this.gUL = (RelativeLayout.LayoutParams) this.gUu.getLayoutParams();
        this.mScreenWidth = ScreenHelper.getRealScreenWidth(this.beD);
        this.ds20 = this.beD.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.ds240 = this.beD.getResources().getDimensionPixelSize(a.d.sdk_ds232);
        this.gUK = this.mScreenWidth - (this.ds20 * 2);
        this.gUL.width = this.gUK;
        this.gUu.setLayoutParams(this.gUL);
        this.mHandler.postDelayed(this.gUO, 2000L);
    }

    private void b(HeadImageView headImageView) {
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setBorderWidth(BdUtilHelper.getDimens(this.beD, a.d.sdk_ds2));
        headImageView.setBorderColor(-1);
    }

    public View getRootView() {
        return this.gUl;
    }

    private void a(final l lVar, boolean z) {
        if (lVar != null) {
            this.gUz.startLoad(lVar.aJs, 12, false);
            this.gUy.startLoad(lVar.aJt, 12, false);
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
        if (this.gUx != null && lVar != null) {
            this.gUx.startLoad(lVar.aJs, 12, false);
        }
        if (this.gUw != null && lVar != null) {
            this.gUw.startLoad(lVar.aJt, 12, false);
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
            this.gUm.setText(spannableStringBuilder);
            this.gUm.setTranslationX(0.0f);
            int textWidth = BdUtilHelper.getTextWidth(this.gUm.getPaint(), spannableStringBuilder.toString());
            int width = this.gUn.getWidth();
            int width2 = this.gUv.getWidth();
            int i = width > 0 ? width : this.gUK - this.ds240;
            float f = -(textWidth - i);
            if (this.DEBUG) {
                Log.e(">>>>>>", "1 calculateWidthAndStartAnimator ssb.length:" + spannableStringBuilder.length() + " " + spannableStringBuilder.toString() + " mScreenWidth：" + this.mScreenWidth);
                Log.e(">>>>>>", "2 maxContentLength:" + i + " textWidth:" + textWidth + " desToXValue:" + f + " mBoardCastContentWidth:" + this.gUK + " mLlBoardCastContainerView width:" + width + " mBoardCastFixedContainerViewwidth1: " + width2);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gUm.getLayoutParams();
            if (textWidth < i) {
                layoutParams.width = -2;
                this.gUm.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = textWidth;
                this.gUm.setLayoutParams(layoutParams);
                this.gUE = ObjectAnimator.ofFloat(this.gUm, "translationX", 0.0f, f);
                this.gUE.setDuration(1000L);
                this.gUE.setStartDelay(1000L);
            }
            ObjectAnimator bXt = bXt();
            ValueAnimator bXs = bXs();
            ObjectAnimator bXr = bXr();
            ObjectAnimator bXu = bXu();
            ObjectAnimator bXq = bXq();
            ObjectAnimator bXp = bXp();
            this.aYZ = new AnimatorSet();
            this.gUJ = new ArrayList();
            this.gUJ.add(bXt);
            this.gUJ.add(bXq);
            this.gUJ.add(bXp);
            if (this.gUE != null) {
                this.gUJ.add(this.gUE);
            }
            this.gUJ.add(bXu);
            this.gUJ.add(bXs);
            this.gUJ.add(bXr);
            this.aYZ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.18
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.IT();
                    a.this.aYZ.removeAllListeners();
                    a.this.next();
                }
            });
            this.aYZ.playTogether(this.gUJ);
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
            if (lVar.aJn > this.gUS) {
                this.aKt = lVar;
                this.gUS = this.aKt.aJn;
                this.gUi = this.aKt.endTime - this.aKt.serverTime;
                bXo();
                a(this.aKt, true);
            }
            this.mList.clear();
        }
    }

    private void bXo() {
        this.gUQ = true;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.19
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.gUR);
                if (a.this.gUi > 1) {
                    a.this.gUi++;
                }
                a.this.mHandler.post(a.this.gUR);
            }
        });
    }

    private ObjectAnimator bXp() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gUo, "alpha", 0.1f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(6700L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.gUo.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.mHandler.removeCallbacks(a.this.gUO);
                a.this.mHandler.post(a.this.gUO);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bXq() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gUo, "translationX", 0.0f, this.gUo.getWidth());
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(100L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.gUo.setTranslationX(0.0f);
                a.this.gUo.setVisibility(4);
                a.this.gUM.setVisibility(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.gUM.setVisibility(0);
                a.this.gUM.playAnimation();
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bXr() {
        if (this.gUI == null) {
            this.gUI = ObjectAnimator.ofFloat(this.gUt, "alpha", 1.0f, 0.0f);
            this.gUI.setDuration(300L);
            this.gUI.setStartDelay(6700L);
        }
        return this.gUI;
    }

    private ValueAnimator bXs() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.gUu.getMeasuredWidth() - this.gUo.getMeasuredWidth());
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (a.this.gUL.leftMargin < intValue) {
                    a.this.gUL.leftMargin = intValue;
                    a.this.gUu.setLayoutParams(a.this.gUL);
                }
            }
        });
        ofInt.setStartDelay(6000L);
        ofInt.setDuration(1000L);
        return ofInt;
    }

    private ObjectAnimator bXt() {
        if (this.gUH == null) {
            this.gUH = ObjectAnimator.ofFloat(this.gUt, "translationX", -this.mScreenWidth, 0.0f);
            this.gUH.setDuration(1000L);
            this.gUH.setInterpolator(new OvershootInterpolator());
            this.gUH.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.aYO = true;
                    a.this.gUt.setVisibility(0);
                }
            });
        }
        return this.gUH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator bXu() {
        if (this.gUF == null) {
            this.gUF = ObjectAnimator.ofFloat(this.gUA, "translationX", 0.0f, this.gUK);
            this.gUF.setDuration(800L);
            this.gUF.setInterpolator(new AccelerateInterpolator());
            this.gUF.setStartDelay(1000L);
            this.gUF.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    a.this.gUA.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.gUA.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.gUA.setVisibility(8);
                    a.this.mHandler.removeCallbacks(a.this.gUP);
                    a.this.mHandler.postDelayed(a.this.gUP, 1500L);
                }
            });
            this.gUF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                        a.this.gUA.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                    } else {
                        a.this.gUA.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                    }
                }
            });
        } else {
            this.gUA.clearAnimation();
        }
        return this.gUF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator bXv() {
        int width;
        if (this.gUD == null) {
            return null;
        }
        if ((this.gUs.getVisibility() == 0 || this.gUr.getVisibility() == 0) && (width = this.gUo.getWidth()) > 0) {
            this.gUD.clearAnimation();
            if (this.gUG == null) {
                this.gUG = ObjectAnimator.ofFloat(this.gUD, "translationX", 0.0f, width);
                this.gUG.setDuration(1000L);
                this.gUG.setInterpolator(new AccelerateInterpolator());
                this.gUG.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.8
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        a.this.gUD.setVisibility(0);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.gUD.setVisibility(8);
                    }
                });
                this.gUG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.9
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                            a.this.gUD.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                        } else {
                            a.this.gUD.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                        }
                    }
                });
            } else {
                this.gUG.setFloatValues(0.0f, width);
            }
            return this.gUG;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IT() {
        this.aYO = false;
        this.gUt.clearAnimation();
        this.gUm.clearAnimation();
        this.gUo.clearAnimation();
        this.gUo.setAlpha(1.0f);
        this.gUm.setAlpha(1.0f);
        this.gUA.clearAnimation();
        this.gUt.setAlpha(1.0f);
        this.gUL.leftMargin = 0;
        this.gUu.setLayoutParams(this.gUL);
        this.gUt.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(final boolean z, boolean z2) {
        this.aUr = z ? 2 : 1;
        if (z2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        a.this.gUr.setVisibility(0);
                        a.this.gUs.setVisibility(8);
                        return;
                    }
                    a.this.gUr.setVisibility(8);
                    a.this.gUs.setVisibility(0);
                }
            }, 1000L);
        } else if (z) {
            this.gUr.setVisibility(0);
            this.gUs.setVisibility(8);
        } else {
            this.gUr.setVisibility(8);
            this.gUs.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RU() {
        if (this.aFN != null && this.aFN.aKt != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new j(this.beD, this.aFN, this.aUr, this.otherParams, this.gUi)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aFN));
        }
    }

    public void mS(boolean z) {
        this.gUl.setVisibility(8);
        if (this.DEBUG) {
            Log.e(">>>>>>", "onCloseEntryView first：" + z);
        }
        this.gUS = 0L;
        this.gUk = true;
        if (!z) {
            IT();
            this.mList.clear();
        }
    }

    public void bXw() {
        if (this.gUl != null && this.gUl.getVisibility() != 0) {
            if (this.DEBUG) {
                Log.e(">>>>>>", "setEntryViewVisibility");
            }
            this.gUk = false;
            this.mHandler.removeCallbacks(this.gUO);
            this.mHandler.post(this.gUO);
            this.gUl.setVisibility(0);
        }
    }

    public void z(w wVar) {
        l lVar = wVar.aKt;
        this.aFN = wVar;
        this.isHost = wVar.isHost;
        if (lVar.endTime - lVar.serverTime <= 1) {
            this.gUS = lVar.aJl;
            L(false, false);
        } else {
            if (this.gUS <= 0) {
                this.gUS = lVar.aJn;
            }
            if (this.gUS < lVar.aJn) {
                if (this.aUr != 1) {
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "3 setData countdownTime:" + this.gUi + " mCurScore:" + this.gUS);
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
                        Log.e(">>>>>>", "2 setData countdownTime:" + this.gUi + " mCurScore:" + this.gUS);
                    }
                } else {
                    if (this.aUr == 1) {
                        L(true, true);
                    }
                    this.aKt = lVar;
                    this.gUS = lVar.aJn;
                    this.gUi = lVar.endTime - lVar.serverTime;
                    bXo();
                    a(this.aKt, true);
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "1 setData countdownTime:" + this.gUi + " mCurScore:" + this.gUS + "info.endTime:" + lVar.endTime + " info.serverTime:" + lVar.serverTime);
                    }
                }
            } else {
                this.aKt = lVar;
                this.gUS = lVar.aJn;
                if (this.gUS <= lVar.aJl) {
                    this.gUi = 0L;
                    L(false, false);
                } else {
                    if (this.gUi <= 0) {
                        this.gUi = lVar.endTime - lVar.serverTime;
                    } else {
                        long j = lVar.endTime - lVar.serverTime;
                        if (j < this.gUi && j > 1) {
                            this.gUi = j;
                        }
                    }
                    L(true, true);
                    bXo();
                    a(this.aKt, false);
                }
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aFN));
        this.gUk = false;
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
        this.gUS = 0L;
        this.gUk = true;
        this.gUi = 0L;
    }

    public void Mg() {
        this.gUi = 0L;
        this.gUS = 0L;
        this.aUr = 1;
        this.aYO = false;
        this.gUk = true;
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
                        a.this.gUm.setText(spannableStringBuilder);
                        a.this.gUm.forceLayout();
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
