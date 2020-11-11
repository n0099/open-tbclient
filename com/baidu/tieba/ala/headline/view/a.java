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
import com.baidu.live.b.j;
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
    private w aES;
    public l aJt;
    private AnimatorSet aXy;
    Activity bNY;
    private int ds20;
    private int ds240;
    private View gLA;
    private ViewGroup gLB;
    private HeadImageView gLC;
    private HeadImageView gLD;
    private HeadImageView gLE;
    private HeadImageView gLF;
    private ImageView gLG;
    private TbImageView gLH;
    private TextView gLI;
    private ImageView gLJ;
    private ObjectAnimator gLK;
    private ObjectAnimator gLL;
    private ObjectAnimator gLM;
    private ObjectAnimator gLN;
    private ObjectAnimator gLO;
    private List<Animator> gLP;
    private int gLQ;
    private RelativeLayout.LayoutParams gLR;
    private TBLottieAnimationView gLS;
    private View gLT;
    private long gLY;
    private long gLo;
    private View gLr;
    private TextView gLs;
    private ViewGroup gLt;
    private ViewGroup gLu;
    private TextView gLv;
    private TextView gLw;
    private ViewGroup gLx;
    private ViewGroup gLy;
    private View gLz;
    private boolean isHost;
    private int mScreenWidth;
    private boolean DEBUG = false;
    String otherParams = "";
    private int aTa = 1;
    private boolean gLq = false;
    private boolean aXo = false;
    private Runnable gLU = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.15
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.gLq) {
                ObjectAnimator bUt = a.this.bUt();
                if (bUt != null && !bUt.isRunning()) {
                    bUt.start();
                }
                a.this.mHandler.postDelayed(this, 2000L);
            }
        }
    };
    private Runnable gLV = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.16
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.gLq) {
                if (!a.this.aXo) {
                    a.this.mHandler.removeCallbacks(this);
                    return;
                }
                ObjectAnimator bUs = a.this.bUs();
                if (bUs != null && !bUs.isRunning()) {
                    bUs.start();
                }
                a.this.mHandler.postDelayed(this, 1500L);
            }
        }
    };
    private boolean gLW = false;
    private Runnable gLX = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17
        @Override // java.lang.Runnable
        public void run() {
            a.this.gLo--;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913245, Long.valueOf(a.this.gLo)));
            if (a.this.gLo <= 0) {
                a.this.gLw.setText("");
                a.this.gLv.setText("");
                a.this.L(false, false);
                a.this.mHandler.removeCallbacks(this);
                if (a.this.aJt != null) {
                    a.this.gLY = a.this.aJt.aIm;
                    return;
                }
                return;
            }
            a.this.gLw.setText(a.this.gLo + "s");
            if (a.this.gLW) {
                a.this.gLW = false;
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.gLv != null) {
                            a.this.gLv.setText(a.this.gLo + "s");
                        }
                    }
                }, 1000L);
            } else {
                a.this.gLv.setText(a.this.gLo + "s");
            }
            a.this.mHandler.postDelayed(this, 1000L);
        }
    };
    private List<l> mList = new ArrayList();
    private Handler mHandler = new Handler();

    public View bUl() {
        return this.gLT;
    }

    public a(TbPageContext tbPageContext) {
        this.bNY = tbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.gLr = LayoutInflater.from(this.bNY).inflate(a.g.sdk_headline_layout, (ViewGroup) null, false);
        this.gLu = (ViewGroup) this.gLr.findViewById(a.f.ala_sdk_rl_all_content_container);
        this.gLx = (ViewGroup) this.gLr.findViewById(a.f.ala_ll_have_fixed_container);
        this.gLy = (ViewGroup) this.gLr.findViewById(a.f.ala_ll_empty_fixed_container);
        this.gLv = (TextView) this.gLr.findViewById(a.f.ala_tv_time);
        this.gLJ = (ImageView) this.gLr.findViewById(a.f.ala_sdk_iv_sweep);
        this.gLD = (HeadImageView) this.gLr.findViewById(a.f.ala_iv_host_head);
        b(this.gLD);
        this.gLC = (HeadImageView) this.gLr.findViewById(a.f.ala_iv_user_head);
        b(this.gLC);
        this.gLI = (TextView) this.gLr.findViewById(a.f.ala_sdk_head_line_tv_text);
        this.gLH = (TbImageView) this.gLr.findViewById(a.f.ala_iv_empty_icon);
        this.gLz = this.gLr.findViewById(a.f.ala_sdk_rl_boardcast_root_view);
        this.gLz.setVisibility(4);
        this.gLA = this.gLz.findViewById(a.f.ala_sdk_anim_container);
        this.gLB = (ViewGroup) this.gLz.findViewById(a.f.ala_anim_ll_have_fixed_container);
        this.gLw = (TextView) this.gLz.findViewById(a.f.ala_anim_tv_time);
        this.gLs = (TextView) this.gLz.findViewById(a.f.ala_sdk_tv_gift_show);
        this.gLt = (ViewGroup) this.gLz.findViewById(a.f.ala_sdk_ll_gift_text_show_container);
        this.gLF = (HeadImageView) this.gLz.findViewById(a.f.ala_anim_iv_host_head);
        b(this.gLF);
        this.gLE = (HeadImageView) this.gLz.findViewById(a.f.ala_anim_iv_user_head);
        b(this.gLE);
        this.gLG = (ImageView) this.gLz.findViewById(a.f.ala_sdk_iv_anim_sweep);
        this.gLu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Qj();
            }
        });
        this.gLz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Qj();
            }
        });
        this.gLT = LayoutInflater.from(this.bNY).inflate(a.g.ala_sdk_head_line_lottie_layout, (ViewGroup) null, false);
        this.gLS = (TBLottieAnimationView) this.gLT.findViewById(a.f.ala_sdk_head_line_lot_view);
        this.gLS.setAnimation("head_linedata_explosion.json");
        this.gLS.setAnimationDir("/");
        this.gLR = (RelativeLayout.LayoutParams) this.gLA.getLayoutParams();
        this.mScreenWidth = ScreenHelper.getRealScreenWidth(this.bNY);
        this.ds20 = this.bNY.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.ds240 = this.bNY.getResources().getDimensionPixelSize(a.d.sdk_ds232);
        this.gLQ = this.mScreenWidth - (this.ds20 * 2);
        this.gLR.width = this.gLQ;
        this.gLA.setLayoutParams(this.gLR);
        this.mHandler.postDelayed(this.gLU, 2000L);
    }

    private void b(HeadImageView headImageView) {
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setBorderWidth(BdUtilHelper.getDimens(this.bNY, a.d.sdk_ds2));
        headImageView.setBorderColor(-1);
    }

    public View getRootView() {
        return this.gLr;
    }

    private void a(final l lVar, boolean z) {
        if (lVar != null) {
            this.gLF.startLoad(lVar.aIt, 12, false);
            this.gLE.startLoad(lVar.aIu, 12, false);
            if (z) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(lVar);
                    }
                }, 1000L);
                final SpannableStringBuilder c = c(lVar);
                if (c == null || c.length() <= 0) {
                    HM();
                    next();
                    return;
                }
                this.aXo = true;
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.14
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.c(c);
                    }
                }, 300L);
                return;
            }
            a(lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        if (this.gLD != null && lVar != null) {
            this.gLD.startLoad(lVar.aIt, 12, false);
        }
        if (this.gLC != null && lVar != null) {
            this.gLC.startLoad(lVar.aIu, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SpannableStringBuilder spannableStringBuilder) {
        if (this.bNY != null) {
            if (spannableStringBuilder == null || spannableStringBuilder.length() <= 0) {
                HM();
                next();
                return;
            }
            this.gLs.setText(spannableStringBuilder);
            this.gLs.setTranslationX(0.0f);
            int textWidth = BdUtilHelper.getTextWidth(this.gLs.getPaint(), spannableStringBuilder.toString());
            int width = this.gLt.getWidth();
            int width2 = this.gLB.getWidth();
            int i = width > 0 ? width : this.gLQ - this.ds240;
            float f = -(textWidth - i);
            if (this.DEBUG) {
                Log.e(">>>>>>", "1 calculateWidthAndStartAnimator ssb.length:" + spannableStringBuilder.length() + " " + spannableStringBuilder.toString() + " mScreenWidth：" + this.mScreenWidth);
                Log.e(">>>>>>", "2 maxContentLength:" + i + " textWidth:" + textWidth + " desToXValue:" + f + " mBoardCastContentWidth:" + this.gLQ + " mLlBoardCastContainerView width:" + width + " mBoardCastFixedContainerViewwidth1: " + width2);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gLs.getLayoutParams();
            if (textWidth < i) {
                layoutParams.width = -2;
                this.gLs.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = textWidth;
                this.gLs.setLayoutParams(layoutParams);
                this.gLK = ObjectAnimator.ofFloat(this.gLs, "translationX", 0.0f, f);
                this.gLK.setDuration(1000L);
                this.gLK.setStartDelay(1000L);
            }
            ObjectAnimator bUr = bUr();
            ValueAnimator bUq = bUq();
            ObjectAnimator bUp = bUp();
            ObjectAnimator bUs = bUs();
            ObjectAnimator bUo = bUo();
            ObjectAnimator bUn = bUn();
            this.aXy = new AnimatorSet();
            this.gLP = new ArrayList();
            this.gLP.add(bUr);
            this.gLP.add(bUo);
            this.gLP.add(bUn);
            if (this.gLK != null) {
                this.gLP.add(this.gLK);
            }
            this.gLP.add(bUs);
            this.gLP.add(bUq);
            this.gLP.add(bUp);
            this.aXy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.18
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.HM();
                    a.this.aXy.removeAllListeners();
                    a.this.next();
                }
            });
            this.aXy.playTogether(this.gLP);
            this.aXy.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        if (this.DEBUG) {
            Log.e(">>>>>>", "1-next:mList.size:" + this.mList.size());
        }
        if (!this.mList.isEmpty()) {
            l lVar = this.mList.get(this.mList.size() - 1);
            if (lVar.aIo > this.gLY) {
                this.aJt = lVar;
                this.gLY = this.aJt.aIo;
                this.gLo = this.aJt.endTime - this.aJt.serverTime;
                bUm();
                a(this.aJt, true);
            }
            this.mList.clear();
        }
    }

    private void bUm() {
        this.gLW = true;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.19
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.gLX);
                if (a.this.gLo > 1) {
                    a.this.gLo++;
                }
                a.this.mHandler.post(a.this.gLX);
            }
        });
    }

    private ObjectAnimator bUn() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gLu, "alpha", 0.1f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(6700L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.gLu.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.mHandler.removeCallbacks(a.this.gLU);
                a.this.mHandler.post(a.this.gLU);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bUo() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gLu, "translationX", 0.0f, this.gLu.getWidth());
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(100L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.gLu.setTranslationX(0.0f);
                a.this.gLu.setVisibility(4);
                a.this.gLS.setVisibility(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.gLS.setVisibility(0);
                a.this.gLS.playAnimation();
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bUp() {
        if (this.gLO == null) {
            this.gLO = ObjectAnimator.ofFloat(this.gLz, "alpha", 1.0f, 0.0f);
            this.gLO.setDuration(300L);
            this.gLO.setStartDelay(6700L);
        }
        return this.gLO;
    }

    private ValueAnimator bUq() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.gLA.getMeasuredWidth() - this.gLu.getMeasuredWidth());
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (a.this.gLR.leftMargin < intValue) {
                    a.this.gLR.leftMargin = intValue;
                    a.this.gLA.setLayoutParams(a.this.gLR);
                }
            }
        });
        ofInt.setStartDelay(6000L);
        ofInt.setDuration(1000L);
        return ofInt;
    }

    private ObjectAnimator bUr() {
        if (this.gLN == null) {
            this.gLN = ObjectAnimator.ofFloat(this.gLz, "translationX", -this.mScreenWidth, 0.0f);
            this.gLN.setDuration(1000L);
            this.gLN.setInterpolator(new OvershootInterpolator());
            this.gLN.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.aXo = true;
                    a.this.gLz.setVisibility(0);
                }
            });
        }
        return this.gLN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator bUs() {
        if (this.gLL == null) {
            this.gLL = ObjectAnimator.ofFloat(this.gLG, "translationX", 0.0f, this.gLQ);
            this.gLL.setDuration(800L);
            this.gLL.setInterpolator(new AccelerateInterpolator());
            this.gLL.setStartDelay(1000L);
            this.gLL.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    a.this.gLG.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.gLG.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.gLG.setVisibility(8);
                    a.this.mHandler.removeCallbacks(a.this.gLV);
                    a.this.mHandler.postDelayed(a.this.gLV, 1500L);
                }
            });
            this.gLL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                        a.this.gLG.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                    } else {
                        a.this.gLG.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                    }
                }
            });
        } else {
            this.gLG.clearAnimation();
        }
        return this.gLL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator bUt() {
        int width;
        if (this.gLJ == null) {
            return null;
        }
        if ((this.gLy.getVisibility() == 0 || this.gLx.getVisibility() == 0) && (width = this.gLu.getWidth()) > 0) {
            this.gLJ.clearAnimation();
            if (this.gLM == null) {
                this.gLM = ObjectAnimator.ofFloat(this.gLJ, "translationX", 0.0f, width);
                this.gLM.setDuration(1000L);
                this.gLM.setInterpolator(new AccelerateInterpolator());
                this.gLM.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.8
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        a.this.gLJ.setVisibility(0);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.gLJ.setVisibility(8);
                    }
                });
                this.gLM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.9
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                            a.this.gLJ.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                        } else {
                            a.this.gLJ.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                        }
                    }
                });
            } else {
                this.gLM.setFloatValues(0.0f, width);
            }
            return this.gLM;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HM() {
        this.aXo = false;
        this.gLz.clearAnimation();
        this.gLs.clearAnimation();
        this.gLu.clearAnimation();
        this.gLu.setAlpha(1.0f);
        this.gLs.setAlpha(1.0f);
        this.gLG.clearAnimation();
        this.gLz.setAlpha(1.0f);
        this.gLR.leftMargin = 0;
        this.gLA.setLayoutParams(this.gLR);
        this.gLz.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(final boolean z, boolean z2) {
        this.aTa = z ? 2 : 1;
        if (z2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        a.this.gLx.setVisibility(0);
                        a.this.gLy.setVisibility(8);
                        return;
                    }
                    a.this.gLx.setVisibility(8);
                    a.this.gLy.setVisibility(0);
                }
            }, 1000L);
        } else if (z) {
            this.gLx.setVisibility(0);
            this.gLy.setVisibility(8);
        } else {
            this.gLx.setVisibility(8);
            this.gLy.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qj() {
        if (this.aES != null && this.aES.aJt != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new j(this.bNY, this.aES, this.aTa, this.otherParams, this.gLo)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aES));
        }
    }

    public void mw(boolean z) {
        this.gLr.setVisibility(8);
        if (this.DEBUG) {
            Log.e(">>>>>>", "onCloseEntryView first：" + z);
        }
        this.gLY = 0L;
        this.gLq = true;
        if (!z) {
            HM();
            this.mList.clear();
        }
    }

    public void bUu() {
        if (this.gLr != null && this.gLr.getVisibility() != 0) {
            if (this.DEBUG) {
                Log.e(">>>>>>", "setEntryViewVisibility");
            }
            this.gLq = false;
            this.mHandler.removeCallbacks(this.gLU);
            this.mHandler.post(this.gLU);
            this.gLr.setVisibility(0);
        }
    }

    public void y(w wVar) {
        l lVar = wVar.aJt;
        this.aES = wVar;
        this.isHost = wVar.isHost;
        if (lVar.endTime - lVar.serverTime <= 1) {
            this.gLY = lVar.aIm;
            L(false, false);
        } else {
            if (this.gLY <= 0) {
                this.gLY = lVar.aIo;
            }
            if (this.gLY < lVar.aIo) {
                if (this.aTa != 1) {
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "3 setData countdownTime:" + this.gLo + " mCurScore:" + this.gLY);
                    }
                    if (!b(lVar)) {
                        this.mList.add(lVar);
                    }
                }
                if (this.aXo) {
                    if (!b(lVar)) {
                        this.mList.add(lVar);
                    }
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "2 setData countdownTime:" + this.gLo + " mCurScore:" + this.gLY);
                    }
                } else {
                    if (this.aTa == 1) {
                        L(true, true);
                    }
                    this.aJt = lVar;
                    this.gLY = lVar.aIo;
                    this.gLo = lVar.endTime - lVar.serverTime;
                    bUm();
                    a(this.aJt, true);
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "1 setData countdownTime:" + this.gLo + " mCurScore:" + this.gLY + "info.endTime:" + lVar.endTime + " info.serverTime:" + lVar.serverTime);
                    }
                }
            } else {
                this.aJt = lVar;
                this.gLY = lVar.aIo;
                if (this.gLY <= lVar.aIm) {
                    this.gLo = 0L;
                    L(false, false);
                } else {
                    if (this.gLo <= 0) {
                        this.gLo = lVar.endTime - lVar.serverTime;
                    } else {
                        long j = lVar.endTime - lVar.serverTime;
                        if (j < this.gLo && j > 1) {
                            this.gLo = j;
                        }
                    }
                    L(true, true);
                    bUm();
                    a(this.aJt, false);
                }
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aES));
        this.gLq = false;
    }

    private boolean b(l lVar) {
        if (this.mList.isEmpty()) {
            return false;
        }
        Iterator<l> it = this.mList.iterator();
        while (it.hasNext()) {
            if (it.next().aIo == lVar.aIo) {
                return true;
            }
        }
        return false;
    }

    public void onDestory() {
        this.gLY = 0L;
        this.gLq = true;
        this.gLo = 0L;
    }

    public void KN() {
        this.gLo = 0L;
        this.gLY = 0L;
        this.aTa = 1;
        this.aXo = false;
        this.gLq = true;
        if (this.mList != null) {
            this.mList.clear();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        HM();
    }

    public SpannableStringBuilder c(l lVar) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            spannableStringBuilder.append((CharSequence) lVar.userName);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFEAAA")), 0, lVar.userName.length(), 33);
            spannableStringBuilder.append((CharSequence) " 送给 ");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) lVar.aIs);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFEAAA")), length, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) (" " + lVar.giftName));
            final int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) "[img]");
            spannableStringBuilder.append((CharSequence) ("X" + lVar.giftNum + "个"));
            BdResourceLoader.getInstance().loadResource(lVar.aIr, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.tieba.ala.headline.view.a.11
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i) {
                    super.onLoaded((AnonymousClass11) bdImage, str, i);
                    Bitmap a2 = a.this.a(bdImage);
                    if (a2 != null) {
                        CenteredImageSpan centeredImageSpan = new CenteredImageSpan(a.this.bNY, a2);
                        SpannableString spannableString = new SpannableString("[img]");
                        spannableString.setSpan(centeredImageSpan, 0, spannableString.length(), 33);
                        spannableStringBuilder.replace(length2, length2 + "[img]".length(), (CharSequence) spannableString);
                        a.this.gLs.setText(spannableStringBuilder);
                        a.this.gLs.forceLayout();
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
        int dimensionPixelSize = this.bNY.getResources().getDimensionPixelSize(a.d.sdk_ds24);
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

    public void dX(int i) {
    }
}
