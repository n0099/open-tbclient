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
    private w aDh;
    public l aHI;
    private AnimatorSet aVN;
    Activity bMo;
    private int ds20;
    private int ds240;
    private long gKV;
    private View gKY;
    private TextView gKZ;
    private View gLA;
    private long gLF;
    private ViewGroup gLa;
    private ViewGroup gLb;
    private TextView gLc;
    private TextView gLd;
    private ViewGroup gLe;
    private ViewGroup gLf;
    private View gLg;
    private View gLh;
    private ViewGroup gLi;
    private HeadImageView gLj;
    private HeadImageView gLk;
    private HeadImageView gLl;
    private HeadImageView gLm;
    private ImageView gLn;
    private TbImageView gLo;
    private TextView gLp;
    private ImageView gLq;
    private ObjectAnimator gLr;
    private ObjectAnimator gLs;
    private ObjectAnimator gLt;
    private ObjectAnimator gLu;
    private ObjectAnimator gLv;
    private List<Animator> gLw;
    private int gLx;
    private RelativeLayout.LayoutParams gLy;
    private TBLottieAnimationView gLz;
    private boolean isHost;
    private int mScreenWidth;
    private boolean DEBUG = false;
    String otherParams = "";
    private int aRp = 1;
    private boolean gKX = false;
    private boolean aVD = false;
    private Runnable gLB = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.15
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.gKX) {
                ObjectAnimator bTM = a.this.bTM();
                if (bTM != null && !bTM.isRunning()) {
                    bTM.start();
                }
                a.this.mHandler.postDelayed(this, 2000L);
            }
        }
    };
    private Runnable gLC = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.16
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.gKX) {
                if (!a.this.aVD) {
                    a.this.mHandler.removeCallbacks(this);
                    return;
                }
                ObjectAnimator bTL = a.this.bTL();
                if (bTL != null && !bTL.isRunning()) {
                    bTL.start();
                }
                a.this.mHandler.postDelayed(this, 1500L);
            }
        }
    };
    private boolean gLD = false;
    private Runnable gLE = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17
        @Override // java.lang.Runnable
        public void run() {
            a.this.gKV--;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913245, Long.valueOf(a.this.gKV)));
            if (a.this.gKV <= 0) {
                a.this.gLd.setText("");
                a.this.gLc.setText("");
                a.this.L(false, false);
                a.this.mHandler.removeCallbacks(this);
                if (a.this.aHI != null) {
                    a.this.gLF = a.this.aHI.aGB;
                    return;
                }
                return;
            }
            a.this.gLd.setText(a.this.gKV + "s");
            if (a.this.gLD) {
                a.this.gLD = false;
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.gLc != null) {
                            a.this.gLc.setText(a.this.gKV + "s");
                        }
                    }
                }, 1000L);
            } else {
                a.this.gLc.setText(a.this.gKV + "s");
            }
            a.this.mHandler.postDelayed(this, 1000L);
        }
    };
    private List<l> mList = new ArrayList();
    private Handler mHandler = new Handler();

    public View bTE() {
        return this.gLA;
    }

    public a(TbPageContext tbPageContext) {
        this.bMo = tbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.gKY = LayoutInflater.from(this.bMo).inflate(a.g.sdk_headline_layout, (ViewGroup) null, false);
        this.gLb = (ViewGroup) this.gKY.findViewById(a.f.ala_sdk_rl_all_content_container);
        this.gLe = (ViewGroup) this.gKY.findViewById(a.f.ala_ll_have_fixed_container);
        this.gLf = (ViewGroup) this.gKY.findViewById(a.f.ala_ll_empty_fixed_container);
        this.gLc = (TextView) this.gKY.findViewById(a.f.ala_tv_time);
        this.gLq = (ImageView) this.gKY.findViewById(a.f.ala_sdk_iv_sweep);
        this.gLk = (HeadImageView) this.gKY.findViewById(a.f.ala_iv_host_head);
        b(this.gLk);
        this.gLj = (HeadImageView) this.gKY.findViewById(a.f.ala_iv_user_head);
        b(this.gLj);
        this.gLp = (TextView) this.gKY.findViewById(a.f.ala_sdk_head_line_tv_text);
        this.gLo = (TbImageView) this.gKY.findViewById(a.f.ala_iv_empty_icon);
        this.gLg = this.gKY.findViewById(a.f.ala_sdk_rl_boardcast_root_view);
        this.gLg.setVisibility(4);
        this.gLh = this.gLg.findViewById(a.f.ala_sdk_anim_container);
        this.gLi = (ViewGroup) this.gLg.findViewById(a.f.ala_anim_ll_have_fixed_container);
        this.gLd = (TextView) this.gLg.findViewById(a.f.ala_anim_tv_time);
        this.gKZ = (TextView) this.gLg.findViewById(a.f.ala_sdk_tv_gift_show);
        this.gLa = (ViewGroup) this.gLg.findViewById(a.f.ala_sdk_ll_gift_text_show_container);
        this.gLm = (HeadImageView) this.gLg.findViewById(a.f.ala_anim_iv_host_head);
        b(this.gLm);
        this.gLl = (HeadImageView) this.gLg.findViewById(a.f.ala_anim_iv_user_head);
        b(this.gLl);
        this.gLn = (ImageView) this.gLg.findViewById(a.f.ala_sdk_iv_anim_sweep);
        this.gLb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.PA();
            }
        });
        this.gLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.PA();
            }
        });
        this.gLA = LayoutInflater.from(this.bMo).inflate(a.g.ala_sdk_head_line_lottie_layout, (ViewGroup) null, false);
        this.gLz = (TBLottieAnimationView) this.gLA.findViewById(a.f.ala_sdk_head_line_lot_view);
        this.gLz.setAnimation("head_linedata_explosion.json");
        this.gLz.setAnimationDir("/");
        this.gLy = (RelativeLayout.LayoutParams) this.gLh.getLayoutParams();
        this.mScreenWidth = ScreenHelper.getRealScreenWidth(this.bMo);
        this.ds20 = this.bMo.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.ds240 = this.bMo.getResources().getDimensionPixelSize(a.d.sdk_ds232);
        this.gLx = this.mScreenWidth - (this.ds20 * 2);
        this.gLy.width = this.gLx;
        this.gLh.setLayoutParams(this.gLy);
        this.mHandler.postDelayed(this.gLB, 2000L);
    }

    private void b(HeadImageView headImageView) {
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setBorderWidth(BdUtilHelper.getDimens(this.bMo, a.d.sdk_ds2));
        headImageView.setBorderColor(-1);
    }

    public View getRootView() {
        return this.gKY;
    }

    private void a(final l lVar, boolean z) {
        if (lVar != null) {
            this.gLm.startLoad(lVar.aGI, 12, false);
            this.gLl.startLoad(lVar.aGJ, 12, false);
            if (z) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(lVar);
                    }
                }, 1000L);
                final SpannableStringBuilder c = c(lVar);
                if (c == null || c.length() <= 0) {
                    Hd();
                    next();
                    return;
                }
                this.aVD = true;
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
        if (this.gLk != null && lVar != null) {
            this.gLk.startLoad(lVar.aGI, 12, false);
        }
        if (this.gLj != null && lVar != null) {
            this.gLj.startLoad(lVar.aGJ, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SpannableStringBuilder spannableStringBuilder) {
        if (this.bMo != null) {
            if (spannableStringBuilder == null || spannableStringBuilder.length() <= 0) {
                Hd();
                next();
                return;
            }
            this.gKZ.setText(spannableStringBuilder);
            this.gKZ.setTranslationX(0.0f);
            int textWidth = BdUtilHelper.getTextWidth(this.gKZ.getPaint(), spannableStringBuilder.toString());
            int width = this.gLa.getWidth();
            int width2 = this.gLi.getWidth();
            int i = width > 0 ? width : this.gLx - this.ds240;
            float f = -(textWidth - i);
            if (this.DEBUG) {
                Log.e(">>>>>>", "1 calculateWidthAndStartAnimator ssb.length:" + spannableStringBuilder.length() + " " + spannableStringBuilder.toString() + " mScreenWidth：" + this.mScreenWidth);
                Log.e(">>>>>>", "2 maxContentLength:" + i + " textWidth:" + textWidth + " desToXValue:" + f + " mBoardCastContentWidth:" + this.gLx + " mLlBoardCastContainerView width:" + width + " mBoardCastFixedContainerViewwidth1: " + width2);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gKZ.getLayoutParams();
            if (textWidth < i) {
                layoutParams.width = -2;
                this.gKZ.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = textWidth;
                this.gKZ.setLayoutParams(layoutParams);
                this.gLr = ObjectAnimator.ofFloat(this.gKZ, "translationX", 0.0f, f);
                this.gLr.setDuration(1000L);
                this.gLr.setStartDelay(1000L);
            }
            ObjectAnimator bTK = bTK();
            ValueAnimator bTJ = bTJ();
            ObjectAnimator bTI = bTI();
            ObjectAnimator bTL = bTL();
            ObjectAnimator bTH = bTH();
            ObjectAnimator bTG = bTG();
            this.aVN = new AnimatorSet();
            this.gLw = new ArrayList();
            this.gLw.add(bTK);
            this.gLw.add(bTH);
            this.gLw.add(bTG);
            if (this.gLr != null) {
                this.gLw.add(this.gLr);
            }
            this.gLw.add(bTL);
            this.gLw.add(bTJ);
            this.gLw.add(bTI);
            this.aVN.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.18
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.Hd();
                    a.this.aVN.removeAllListeners();
                    a.this.next();
                }
            });
            this.aVN.playTogether(this.gLw);
            this.aVN.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        if (this.DEBUG) {
            Log.e(">>>>>>", "1-next:mList.size:" + this.mList.size());
        }
        if (!this.mList.isEmpty()) {
            l lVar = this.mList.get(this.mList.size() - 1);
            if (lVar.aGD > this.gLF) {
                this.aHI = lVar;
                this.gLF = this.aHI.aGD;
                this.gKV = this.aHI.endTime - this.aHI.serverTime;
                bTF();
                a(this.aHI, true);
            }
            this.mList.clear();
        }
    }

    private void bTF() {
        this.gLD = true;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.19
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.gLE);
                if (a.this.gKV > 1) {
                    a.this.gKV++;
                }
                a.this.mHandler.post(a.this.gLE);
            }
        });
    }

    private ObjectAnimator bTG() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gLb, "alpha", 0.1f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(6700L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.gLb.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.mHandler.removeCallbacks(a.this.gLB);
                a.this.mHandler.post(a.this.gLB);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bTH() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gLb, "translationX", 0.0f, this.gLb.getWidth());
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(100L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.gLb.setTranslationX(0.0f);
                a.this.gLb.setVisibility(4);
                a.this.gLz.setVisibility(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.gLz.setVisibility(0);
                a.this.gLz.playAnimation();
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bTI() {
        if (this.gLv == null) {
            this.gLv = ObjectAnimator.ofFloat(this.gLg, "alpha", 1.0f, 0.0f);
            this.gLv.setDuration(300L);
            this.gLv.setStartDelay(6700L);
        }
        return this.gLv;
    }

    private ValueAnimator bTJ() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.gLh.getMeasuredWidth() - this.gLb.getMeasuredWidth());
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (a.this.gLy.leftMargin < intValue) {
                    a.this.gLy.leftMargin = intValue;
                    a.this.gLh.setLayoutParams(a.this.gLy);
                }
            }
        });
        ofInt.setStartDelay(6000L);
        ofInt.setDuration(1000L);
        return ofInt;
    }

    private ObjectAnimator bTK() {
        if (this.gLu == null) {
            this.gLu = ObjectAnimator.ofFloat(this.gLg, "translationX", -this.mScreenWidth, 0.0f);
            this.gLu.setDuration(1000L);
            this.gLu.setInterpolator(new OvershootInterpolator());
            this.gLu.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.aVD = true;
                    a.this.gLg.setVisibility(0);
                }
            });
        }
        return this.gLu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator bTL() {
        if (this.gLs == null) {
            this.gLs = ObjectAnimator.ofFloat(this.gLn, "translationX", 0.0f, this.gLx);
            this.gLs.setDuration(800L);
            this.gLs.setInterpolator(new AccelerateInterpolator());
            this.gLs.setStartDelay(1000L);
            this.gLs.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    a.this.gLn.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.gLn.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.gLn.setVisibility(8);
                    a.this.mHandler.removeCallbacks(a.this.gLC);
                    a.this.mHandler.postDelayed(a.this.gLC, 1500L);
                }
            });
            this.gLs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                        a.this.gLn.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                    } else {
                        a.this.gLn.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                    }
                }
            });
        } else {
            this.gLn.clearAnimation();
        }
        return this.gLs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator bTM() {
        int width;
        if (this.gLq == null) {
            return null;
        }
        if ((this.gLf.getVisibility() == 0 || this.gLe.getVisibility() == 0) && (width = this.gLb.getWidth()) > 0) {
            this.gLq.clearAnimation();
            if (this.gLt == null) {
                this.gLt = ObjectAnimator.ofFloat(this.gLq, "translationX", 0.0f, width);
                this.gLt.setDuration(1000L);
                this.gLt.setInterpolator(new AccelerateInterpolator());
                this.gLt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.8
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        a.this.gLq.setVisibility(0);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.gLq.setVisibility(8);
                    }
                });
                this.gLt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.9
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                            a.this.gLq.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                        } else {
                            a.this.gLq.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                        }
                    }
                });
            } else {
                this.gLt.setFloatValues(0.0f, width);
            }
            return this.gLt;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hd() {
        this.aVD = false;
        this.gLg.clearAnimation();
        this.gKZ.clearAnimation();
        this.gLb.clearAnimation();
        this.gLb.setAlpha(1.0f);
        this.gKZ.setAlpha(1.0f);
        this.gLn.clearAnimation();
        this.gLg.setAlpha(1.0f);
        this.gLy.leftMargin = 0;
        this.gLh.setLayoutParams(this.gLy);
        this.gLg.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(final boolean z, boolean z2) {
        this.aRp = z ? 2 : 1;
        if (z2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        a.this.gLe.setVisibility(0);
                        a.this.gLf.setVisibility(8);
                        return;
                    }
                    a.this.gLe.setVisibility(8);
                    a.this.gLf.setVisibility(0);
                }
            }, 1000L);
        } else if (z) {
            this.gLe.setVisibility(0);
            this.gLf.setVisibility(8);
        } else {
            this.gLe.setVisibility(8);
            this.gLf.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PA() {
        if (this.aDh != null && this.aDh.aHI != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new j(this.bMo, this.aDh, this.aRp, this.otherParams, this.gKV)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aDh));
        }
    }

    public void mx(boolean z) {
        this.gKY.setVisibility(8);
        if (this.DEBUG) {
            Log.e(">>>>>>", "onCloseEntryView first：" + z);
        }
        this.gLF = 0L;
        this.gKX = true;
        if (!z) {
            Hd();
            this.mList.clear();
        }
    }

    public void bTN() {
        if (this.gKY != null && this.gKY.getVisibility() != 0) {
            if (this.DEBUG) {
                Log.e(">>>>>>", "setEntryViewVisibility");
            }
            this.gKX = false;
            this.mHandler.removeCallbacks(this.gLB);
            this.mHandler.post(this.gLB);
            this.gKY.setVisibility(0);
        }
    }

    public void y(w wVar) {
        l lVar = wVar.aHI;
        this.aDh = wVar;
        this.isHost = wVar.isHost;
        if (lVar.endTime - lVar.serverTime <= 1) {
            this.gLF = lVar.aGB;
            L(false, false);
        } else {
            if (this.gLF <= 0) {
                this.gLF = lVar.aGD;
            }
            if (this.gLF < lVar.aGD) {
                if (this.aRp != 1) {
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "3 setData countdownTime:" + this.gKV + " mCurScore:" + this.gLF);
                    }
                    if (!b(lVar)) {
                        this.mList.add(lVar);
                    }
                }
                if (this.aVD) {
                    if (!b(lVar)) {
                        this.mList.add(lVar);
                    }
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "2 setData countdownTime:" + this.gKV + " mCurScore:" + this.gLF);
                    }
                } else {
                    if (this.aRp == 1) {
                        L(true, true);
                    }
                    this.aHI = lVar;
                    this.gLF = lVar.aGD;
                    this.gKV = lVar.endTime - lVar.serverTime;
                    bTF();
                    a(this.aHI, true);
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "1 setData countdownTime:" + this.gKV + " mCurScore:" + this.gLF + "info.endTime:" + lVar.endTime + " info.serverTime:" + lVar.serverTime);
                    }
                }
            } else {
                this.aHI = lVar;
                this.gLF = lVar.aGD;
                if (this.gLF <= lVar.aGB) {
                    this.gKV = 0L;
                    L(false, false);
                } else {
                    if (this.gKV <= 0) {
                        this.gKV = lVar.endTime - lVar.serverTime;
                    } else {
                        long j = lVar.endTime - lVar.serverTime;
                        if (j < this.gKV && j > 1) {
                            this.gKV = j;
                        }
                    }
                    L(true, true);
                    bTF();
                    a(this.aHI, false);
                }
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aDh));
        this.gKX = false;
    }

    private boolean b(l lVar) {
        if (this.mList.isEmpty()) {
            return false;
        }
        Iterator<l> it = this.mList.iterator();
        while (it.hasNext()) {
            if (it.next().aGD == lVar.aGD) {
                return true;
            }
        }
        return false;
    }

    public void onDestory() {
        this.gLF = 0L;
        this.gKX = true;
        this.gKV = 0L;
    }

    public void Ke() {
        this.gKV = 0L;
        this.gLF = 0L;
        this.aRp = 1;
        this.aVD = false;
        this.gKX = true;
        if (this.mList != null) {
            this.mList.clear();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        Hd();
    }

    public SpannableStringBuilder c(l lVar) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            spannableStringBuilder.append((CharSequence) lVar.userName);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFEAAA")), 0, lVar.userName.length(), 33);
            spannableStringBuilder.append((CharSequence) " 送给 ");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) lVar.aGH);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFEAAA")), length, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) (" " + lVar.giftName));
            final int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) "[img]");
            spannableStringBuilder.append((CharSequence) ("X" + lVar.giftNum + "个"));
            BdResourceLoader.getInstance().loadResource(lVar.aGG, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.tieba.ala.headline.view.a.11
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i) {
                    super.onLoaded((AnonymousClass11) bdImage, str, i);
                    Bitmap a2 = a.this.a(bdImage);
                    if (a2 != null) {
                        CenteredImageSpan centeredImageSpan = new CenteredImageSpan(a.this.bMo, a2);
                        SpannableString spannableString = new SpannableString("[img]");
                        spannableString.setSpan(centeredImageSpan, 0, spannableString.length(), 33);
                        spannableStringBuilder.replace(length2, length2 + "[img]".length(), (CharSequence) spannableString);
                        a.this.gKZ.setText(spannableStringBuilder);
                        a.this.gKZ.forceLayout();
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
        int dimensionPixelSize = this.bMo.getResources().getDimensionPixelSize(a.d.sdk_ds24);
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

    public void dT(int i) {
    }
}
