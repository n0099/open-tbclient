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
    private w aEc;
    public l aIC;
    private AnimatorSet aWg;
    Activity bIs;
    private int ds20;
    private int ds240;
    private long gFC;
    private View gFF;
    private TextView gFG;
    private ViewGroup gFH;
    private ViewGroup gFI;
    private TextView gFJ;
    private TextView gFK;
    private ViewGroup gFL;
    private ViewGroup gFM;
    private View gFN;
    private View gFO;
    private ViewGroup gFP;
    private HeadImageView gFQ;
    private HeadImageView gFR;
    private HeadImageView gFS;
    private HeadImageView gFT;
    private ImageView gFU;
    private TbImageView gFV;
    private TextView gFW;
    private ImageView gFX;
    private ObjectAnimator gFY;
    private ObjectAnimator gFZ;
    private ObjectAnimator gGa;
    private ObjectAnimator gGb;
    private ObjectAnimator gGc;
    private List<Animator> gGd;
    private int gGe;
    private RelativeLayout.LayoutParams gGf;
    private TBLottieAnimationView gGg;
    private View gGh;
    private long gGm;
    private boolean isHost;
    private int mScreenWidth;
    private boolean DEBUG = false;
    String otherParams = "";
    private int aRI = 1;
    private boolean gFE = false;
    private boolean aVW = false;
    private Runnable gGi = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.15
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.gFE) {
                ObjectAnimator bRU = a.this.bRU();
                if (bRU != null && !bRU.isRunning()) {
                    bRU.start();
                }
                a.this.mHandler.postDelayed(this, 2000L);
            }
        }
    };
    private Runnable gGj = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.16
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.gFE) {
                if (!a.this.aVW) {
                    a.this.mHandler.removeCallbacks(this);
                    return;
                }
                ObjectAnimator bRT = a.this.bRT();
                if (bRT != null && !bRT.isRunning()) {
                    bRT.start();
                }
                a.this.mHandler.postDelayed(this, 1500L);
            }
        }
    };
    private boolean gGk = false;
    private Runnable gGl = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17
        @Override // java.lang.Runnable
        public void run() {
            a.this.gFC--;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913245, Long.valueOf(a.this.gFC)));
            if (a.this.gFC <= 0) {
                a.this.gFK.setText("");
                a.this.gFJ.setText("");
                a.this.L(false, false);
                a.this.mHandler.removeCallbacks(this);
                if (a.this.aIC != null) {
                    a.this.gGm = a.this.aIC.aHu;
                    return;
                }
                return;
            }
            a.this.gFK.setText(a.this.gFC + "s");
            if (a.this.gGk) {
                a.this.gGk = false;
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.gFJ != null) {
                            a.this.gFJ.setText(a.this.gFC + "s");
                        }
                    }
                }, 1000L);
            } else {
                a.this.gFJ.setText(a.this.gFC + "s");
            }
            a.this.mHandler.postDelayed(this, 1000L);
        }
    };
    private List<l> mList = new ArrayList();
    private Handler mHandler = new Handler();

    public View bRM() {
        return this.gGh;
    }

    public a(TbPageContext tbPageContext) {
        this.bIs = tbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.gFF = LayoutInflater.from(this.bIs).inflate(a.h.sdk_headline_layout, (ViewGroup) null, false);
        this.gFI = (ViewGroup) this.gFF.findViewById(a.g.ala_sdk_rl_all_content_container);
        this.gFL = (ViewGroup) this.gFF.findViewById(a.g.ala_ll_have_fixed_container);
        this.gFM = (ViewGroup) this.gFF.findViewById(a.g.ala_ll_empty_fixed_container);
        this.gFJ = (TextView) this.gFF.findViewById(a.g.ala_tv_time);
        this.gFX = (ImageView) this.gFF.findViewById(a.g.ala_sdk_iv_sweep);
        this.gFR = (HeadImageView) this.gFF.findViewById(a.g.ala_iv_host_head);
        b(this.gFR);
        this.gFQ = (HeadImageView) this.gFF.findViewById(a.g.ala_iv_user_head);
        b(this.gFQ);
        this.gFW = (TextView) this.gFF.findViewById(a.g.ala_sdk_head_line_tv_text);
        this.gFV = (TbImageView) this.gFF.findViewById(a.g.ala_iv_empty_icon);
        this.gFN = this.gFF.findViewById(a.g.ala_sdk_rl_boardcast_root_view);
        this.gFN.setVisibility(4);
        this.gFO = this.gFN.findViewById(a.g.ala_sdk_anim_container);
        this.gFP = (ViewGroup) this.gFN.findViewById(a.g.ala_anim_ll_have_fixed_container);
        this.gFK = (TextView) this.gFN.findViewById(a.g.ala_anim_tv_time);
        this.gFG = (TextView) this.gFN.findViewById(a.g.ala_sdk_tv_gift_show);
        this.gFH = (ViewGroup) this.gFN.findViewById(a.g.ala_sdk_ll_gift_text_show_container);
        this.gFT = (HeadImageView) this.gFN.findViewById(a.g.ala_anim_iv_host_head);
        b(this.gFT);
        this.gFS = (HeadImageView) this.gFN.findViewById(a.g.ala_anim_iv_user_head);
        b(this.gFS);
        this.gFU = (ImageView) this.gFN.findViewById(a.g.ala_sdk_iv_anim_sweep);
        this.gFI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.PJ();
            }
        });
        this.gFN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.PJ();
            }
        });
        this.gGh = LayoutInflater.from(this.bIs).inflate(a.h.ala_sdk_head_line_lottie_layout, (ViewGroup) null, false);
        this.gGg = (TBLottieAnimationView) this.gGh.findViewById(a.g.ala_sdk_head_line_lot_view);
        this.gGg.setAnimation("head_linedata_explosion.json");
        this.gGg.setAnimationDir("/");
        this.gGf = (RelativeLayout.LayoutParams) this.gFO.getLayoutParams();
        this.mScreenWidth = ScreenHelper.getRealScreenWidth(this.bIs);
        this.ds20 = this.bIs.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.ds240 = this.bIs.getResources().getDimensionPixelSize(a.e.sdk_ds232);
        this.gGe = this.mScreenWidth - (this.ds20 * 2);
        this.gGf.width = this.gGe;
        this.gFO.setLayoutParams(this.gGf);
        this.mHandler.postDelayed(this.gGi, 2000L);
    }

    private void b(HeadImageView headImageView) {
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setBorderWidth(BdUtilHelper.getDimens(this.bIs, a.e.sdk_ds2));
        headImageView.setBorderColor(-1);
    }

    public View getRootView() {
        return this.gFF;
    }

    private void a(final l lVar, boolean z) {
        if (lVar != null) {
            this.gFT.startLoad(lVar.aHC, 12, false);
            this.gFS.startLoad(lVar.aHD, 12, false);
            if (z) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(lVar);
                    }
                }, 1000L);
                final SpannableStringBuilder c = c(lVar);
                if (c == null || c.length() <= 0) {
                    Hl();
                    next();
                    return;
                }
                this.aVW = true;
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
        if (this.gFR != null && lVar != null) {
            this.gFR.startLoad(lVar.aHC, 12, false);
        }
        if (this.gFQ != null && lVar != null) {
            this.gFQ.startLoad(lVar.aHD, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SpannableStringBuilder spannableStringBuilder) {
        if (this.bIs != null) {
            if (spannableStringBuilder == null || spannableStringBuilder.length() <= 0) {
                Hl();
                next();
                return;
            }
            this.gFG.setText(spannableStringBuilder);
            this.gFG.setTranslationX(0.0f);
            int textWidth = BdUtilHelper.getTextWidth(this.gFG.getPaint(), spannableStringBuilder.toString());
            int width = this.gFH.getWidth();
            int width2 = this.gFP.getWidth();
            int i = width > 0 ? width : this.gGe - this.ds240;
            float f = -(textWidth - i);
            if (this.DEBUG) {
                Log.e(">>>>>>", "1 calculateWidthAndStartAnimator ssb.length:" + spannableStringBuilder.length() + " " + spannableStringBuilder.toString() + " mScreenWidth：" + this.mScreenWidth);
                Log.e(">>>>>>", "2 maxContentLength:" + i + " textWidth:" + textWidth + " desToXValue:" + f + " mBoardCastContentWidth:" + this.gGe + " mLlBoardCastContainerView width:" + width + " mBoardCastFixedContainerViewwidth1: " + width2);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gFG.getLayoutParams();
            if (textWidth < i) {
                layoutParams.width = -2;
                this.gFG.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = textWidth;
                this.gFG.setLayoutParams(layoutParams);
                this.gFY = ObjectAnimator.ofFloat(this.gFG, "translationX", 0.0f, f);
                this.gFY.setDuration(1000L);
                this.gFY.setStartDelay(1000L);
            }
            ObjectAnimator bRS = bRS();
            ValueAnimator bRR = bRR();
            ObjectAnimator bRQ = bRQ();
            ObjectAnimator bRT = bRT();
            ObjectAnimator bRP = bRP();
            ObjectAnimator bRO = bRO();
            this.aWg = new AnimatorSet();
            this.gGd = new ArrayList();
            this.gGd.add(bRS);
            this.gGd.add(bRP);
            this.gGd.add(bRO);
            if (this.gFY != null) {
                this.gGd.add(this.gFY);
            }
            this.gGd.add(bRT);
            this.gGd.add(bRR);
            this.gGd.add(bRQ);
            this.aWg.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.18
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.Hl();
                    a.this.aWg.removeAllListeners();
                    a.this.next();
                }
            });
            this.aWg.playTogether(this.gGd);
            this.aWg.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        if (this.DEBUG) {
            Log.e(">>>>>>", "1-next:mList.size:" + this.mList.size());
        }
        if (!this.mList.isEmpty()) {
            l lVar = this.mList.get(this.mList.size() - 1);
            if (lVar.aHw > this.gGm) {
                this.aIC = lVar;
                this.gGm = this.aIC.aHw;
                this.gFC = this.aIC.endTime - this.aIC.serverTime;
                bRN();
                a(this.aIC, true);
            }
            this.mList.clear();
        }
    }

    private void bRN() {
        this.gGk = true;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.19
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.gGl);
                if (a.this.gFC > 1) {
                    a.this.gFC++;
                }
                a.this.mHandler.post(a.this.gGl);
            }
        });
    }

    private ObjectAnimator bRO() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gFI, "alpha", 0.1f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(6700L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.gFI.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.mHandler.removeCallbacks(a.this.gGi);
                a.this.mHandler.post(a.this.gGi);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bRP() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gFI, "translationX", 0.0f, this.gFI.getWidth());
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(100L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.gFI.setTranslationX(0.0f);
                a.this.gFI.setVisibility(4);
                a.this.gGg.setVisibility(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.gGg.setVisibility(0);
                a.this.gGg.playAnimation();
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bRQ() {
        if (this.gGc == null) {
            this.gGc = ObjectAnimator.ofFloat(this.gFN, "alpha", 1.0f, 0.0f);
            this.gGc.setDuration(300L);
            this.gGc.setStartDelay(6700L);
        }
        return this.gGc;
    }

    private ValueAnimator bRR() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.gFO.getMeasuredWidth() - this.gFI.getMeasuredWidth());
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (a.this.gGf.leftMargin < intValue) {
                    a.this.gGf.leftMargin = intValue;
                    a.this.gFO.setLayoutParams(a.this.gGf);
                }
            }
        });
        ofInt.setStartDelay(6000L);
        ofInt.setDuration(1000L);
        return ofInt;
    }

    private ObjectAnimator bRS() {
        if (this.gGb == null) {
            this.gGb = ObjectAnimator.ofFloat(this.gFN, "translationX", -this.mScreenWidth, 0.0f);
            this.gGb.setDuration(1000L);
            this.gGb.setInterpolator(new OvershootInterpolator());
            this.gGb.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.aVW = true;
                    a.this.gFN.setVisibility(0);
                }
            });
        }
        return this.gGb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator bRT() {
        if (this.gFZ == null) {
            this.gFZ = ObjectAnimator.ofFloat(this.gFU, "translationX", 0.0f, this.gGe);
            this.gFZ.setDuration(800L);
            this.gFZ.setInterpolator(new AccelerateInterpolator());
            this.gFZ.setStartDelay(1000L);
            this.gFZ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    a.this.gFU.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.gFU.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.gFU.setVisibility(8);
                    a.this.mHandler.removeCallbacks(a.this.gGj);
                    a.this.mHandler.postDelayed(a.this.gGj, 1500L);
                }
            });
            this.gFZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                        a.this.gFU.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                    } else {
                        a.this.gFU.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                    }
                }
            });
        } else {
            this.gFU.clearAnimation();
        }
        return this.gFZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator bRU() {
        int width;
        if (this.gFX == null) {
            return null;
        }
        if ((this.gFM.getVisibility() == 0 || this.gFL.getVisibility() == 0) && (width = this.gFI.getWidth()) > 0) {
            this.gFX.clearAnimation();
            if (this.gGa == null) {
                this.gGa = ObjectAnimator.ofFloat(this.gFX, "translationX", 0.0f, width);
                this.gGa.setDuration(1000L);
                this.gGa.setInterpolator(new AccelerateInterpolator());
                this.gGa.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.8
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        a.this.gFX.setVisibility(0);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.gFX.setVisibility(8);
                    }
                });
                this.gGa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.9
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                            a.this.gFX.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                        } else {
                            a.this.gFX.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                        }
                    }
                });
            } else {
                this.gGa.setFloatValues(0.0f, width);
            }
            return this.gGa;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hl() {
        this.aVW = false;
        this.gFN.clearAnimation();
        this.gFG.clearAnimation();
        this.gFI.clearAnimation();
        this.gFI.setAlpha(1.0f);
        this.gFG.setAlpha(1.0f);
        this.gFU.clearAnimation();
        this.gFN.setAlpha(1.0f);
        this.gGf.leftMargin = 0;
        this.gFO.setLayoutParams(this.gGf);
        this.gFN.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(final boolean z, boolean z2) {
        this.aRI = z ? 2 : 1;
        if (z2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        a.this.gFL.setVisibility(0);
                        a.this.gFM.setVisibility(8);
                        return;
                    }
                    a.this.gFL.setVisibility(8);
                    a.this.gFM.setVisibility(0);
                }
            }, 1000L);
        } else if (z) {
            this.gFL.setVisibility(0);
            this.gFM.setVisibility(8);
        } else {
            this.gFL.setVisibility(8);
            this.gFM.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PJ() {
        if (this.aEc != null && this.aEc.aIC != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new j(this.bIs, this.aEc, this.aRI, this.otherParams, this.gFC)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aEc));
        }
    }

    public void mn(boolean z) {
        this.gFF.setVisibility(8);
        if (this.DEBUG) {
            Log.e(">>>>>>", "onCloseEntryView first：" + z);
        }
        this.gGm = 0L;
        this.gFE = true;
        if (!z) {
            Hl();
            this.mList.clear();
        }
    }

    public void bRV() {
        if (this.gFF != null && this.gFF.getVisibility() != 0) {
            if (this.DEBUG) {
                Log.e(">>>>>>", "setEntryViewVisibility");
            }
            this.gFE = false;
            this.mHandler.removeCallbacks(this.gGi);
            this.mHandler.post(this.gGi);
            this.gFF.setVisibility(0);
        }
    }

    public void t(w wVar) {
        l lVar = wVar.aIC;
        this.aEc = wVar;
        this.isHost = wVar.isHost;
        if (lVar.endTime - lVar.serverTime <= 1) {
            this.gGm = lVar.aHu;
            L(false, false);
        } else {
            if (this.gGm <= 0) {
                this.gGm = lVar.aHw;
            }
            if (this.gGm < lVar.aHw) {
                if (this.aRI != 1) {
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "3 setData countdownTime:" + this.gFC + " mCurScore:" + this.gGm);
                    }
                    if (!b(lVar)) {
                        this.mList.add(lVar);
                    }
                }
                if (this.aVW) {
                    if (!b(lVar)) {
                        this.mList.add(lVar);
                    }
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "2 setData countdownTime:" + this.gFC + " mCurScore:" + this.gGm);
                    }
                } else {
                    if (this.aRI == 1) {
                        L(true, true);
                    }
                    this.aIC = lVar;
                    this.gGm = lVar.aHw;
                    this.gFC = lVar.endTime - lVar.serverTime;
                    bRN();
                    a(this.aIC, true);
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "1 setData countdownTime:" + this.gFC + " mCurScore:" + this.gGm + "info.endTime:" + lVar.endTime + " info.serverTime:" + lVar.serverTime);
                    }
                }
            } else {
                this.aIC = lVar;
                this.gGm = lVar.aHw;
                if (this.gGm <= lVar.aHu) {
                    this.gFC = 0L;
                    L(false, false);
                } else {
                    if (this.gFC <= 0) {
                        this.gFC = lVar.endTime - lVar.serverTime;
                    } else {
                        long j = lVar.endTime - lVar.serverTime;
                        if (j < this.gFC && j > 1) {
                            this.gFC = j;
                        }
                    }
                    L(true, true);
                    bRN();
                    a(this.aIC, false);
                }
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aEc));
        this.gFE = false;
    }

    private boolean b(l lVar) {
        if (this.mList.isEmpty()) {
            return false;
        }
        Iterator<l> it = this.mList.iterator();
        while (it.hasNext()) {
            if (it.next().aHw == lVar.aHw) {
                return true;
            }
        }
        return false;
    }

    public void onDestory() {
        this.gGm = 0L;
        this.gFE = true;
        this.gFC = 0L;
    }

    public void Kn() {
        this.gFC = 0L;
        this.gGm = 0L;
        this.aRI = 1;
        this.aVW = false;
        this.gFE = true;
        if (this.mList != null) {
            this.mList.clear();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        Hl();
    }

    public SpannableStringBuilder c(l lVar) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            spannableStringBuilder.append((CharSequence) lVar.userName);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFEAAA")), 0, lVar.userName.length(), 33);
            spannableStringBuilder.append((CharSequence) " 送给 ");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) lVar.aHA);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFEAAA")), length, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) (" " + lVar.giftName));
            final int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) "[img]");
            spannableStringBuilder.append((CharSequence) ("X" + lVar.giftNum + "个"));
            BdResourceLoader.getInstance().loadResource(lVar.aHz, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.tieba.ala.headline.view.a.11
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i) {
                    super.onLoaded((AnonymousClass11) bdImage, str, i);
                    Bitmap a2 = a.this.a(bdImage);
                    if (a2 != null) {
                        CenteredImageSpan centeredImageSpan = new CenteredImageSpan(a.this.bIs, a2);
                        SpannableString spannableString = new SpannableString("[img]");
                        spannableString.setSpan(centeredImageSpan, 0, spannableString.length(), 33);
                        spannableStringBuilder.replace(length2, length2 + "[img]".length(), (CharSequence) spannableString);
                        a.this.gFG.setText(spannableStringBuilder);
                        a.this.gFG.forceLayout();
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
        int dimensionPixelSize = this.bIs.getResources().getDimensionPixelSize(a.e.sdk_ds24);
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
