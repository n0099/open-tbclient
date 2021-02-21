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
import com.baidu.live.data.ab;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private ab aDd;
    public q aIB;
    private AnimatorSet aZa;
    private int ds20;
    private int ds240;
    private View heA;
    private ViewGroup heB;
    private HeadImageView heC;
    private HeadImageView heD;
    private HeadImageView heE;
    private HeadImageView heF;
    private ImageView heG;
    private TbImageView heH;
    private TextView heI;
    private ImageView heJ;
    private ObjectAnimator heK;
    private ObjectAnimator heL;
    private ObjectAnimator heM;
    private ObjectAnimator heN;
    private ObjectAnimator heO;
    private List<Animator> heP;
    private int heQ;
    private RelativeLayout.LayoutParams heR;
    private TBLottieAnimationView heS;
    private View heT;
    private long heY;
    private long heo;
    private View her;
    private TextView hes;
    private ViewGroup het;
    private ViewGroup heu;
    private TextView hev;
    private TextView hew;
    private ViewGroup hex;
    private ViewGroup hey;
    private View hez;
    private boolean isHost;
    Activity mContext;
    private int mScreenWidth;
    private boolean DEBUG = false;
    String otherParams = "";
    private int aUb = 1;
    private boolean heq = false;
    private boolean aYP = false;
    private Runnable heU = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.15
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.heq) {
                ObjectAnimator bWV = a.this.bWV();
                if (bWV != null && !bWV.isRunning()) {
                    bWV.start();
                }
                a.this.mHandler.postDelayed(this, 2000L);
            }
        }
    };
    private Runnable heV = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.16
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.heq) {
                if (!a.this.aYP) {
                    a.this.mHandler.removeCallbacks(this);
                    return;
                }
                ObjectAnimator bWU = a.this.bWU();
                if (bWU != null && !bWU.isRunning()) {
                    bWU.start();
                }
                a.this.mHandler.postDelayed(this, 1500L);
            }
        }
    };
    private boolean heW = false;
    private Runnable heX = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17
        @Override // java.lang.Runnable
        public void run() {
            a.this.heo--;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913245, Long.valueOf(a.this.heo)));
            if (a.this.heo <= 0) {
                a.this.hew.setText("");
                a.this.hev.setText("");
                a.this.N(false, false);
                a.this.mHandler.removeCallbacks(this);
                if (a.this.aIB != null) {
                    a.this.heY = a.this.aIB.aHs;
                    return;
                }
                return;
            }
            a.this.hew.setText(a.this.heo + "s");
            if (a.this.heW) {
                a.this.heW = false;
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.hev != null) {
                            a.this.hev.setText(a.this.heo + "s");
                        }
                    }
                }, 1000L);
            } else {
                a.this.hev.setText(a.this.heo + "s");
            }
            a.this.mHandler.postDelayed(this, 1000L);
        }
    };
    private List<q> mList = new ArrayList();
    private Handler mHandler = new Handler();

    public View bWN() {
        return this.heT;
    }

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.her = LayoutInflater.from(this.mContext).inflate(a.g.sdk_headline_layout, (ViewGroup) null, false);
        this.heu = (ViewGroup) this.her.findViewById(a.f.ala_sdk_rl_all_content_container);
        this.hex = (ViewGroup) this.her.findViewById(a.f.ala_ll_have_fixed_container);
        this.hey = (ViewGroup) this.her.findViewById(a.f.ala_ll_empty_fixed_container);
        this.hev = (TextView) this.her.findViewById(a.f.ala_tv_time);
        this.heJ = (ImageView) this.her.findViewById(a.f.ala_sdk_iv_sweep);
        this.heD = (HeadImageView) this.her.findViewById(a.f.ala_iv_host_head);
        b(this.heD);
        this.heC = (HeadImageView) this.her.findViewById(a.f.ala_iv_user_head);
        b(this.heC);
        this.heI = (TextView) this.her.findViewById(a.f.ala_sdk_head_line_tv_text);
        this.heH = (TbImageView) this.her.findViewById(a.f.ala_iv_empty_icon);
        this.hez = this.her.findViewById(a.f.ala_sdk_rl_boardcast_root_view);
        this.hez.setVisibility(4);
        this.heA = this.hez.findViewById(a.f.ala_sdk_anim_container);
        this.heB = (ViewGroup) this.hez.findViewById(a.f.ala_anim_ll_have_fixed_container);
        this.hew = (TextView) this.hez.findViewById(a.f.ala_anim_tv_time);
        this.hes = (TextView) this.hez.findViewById(a.f.ala_sdk_tv_gift_show);
        this.het = (ViewGroup) this.hez.findViewById(a.f.ala_sdk_ll_gift_text_show_container);
        this.heF = (HeadImageView) this.hez.findViewById(a.f.ala_anim_iv_host_head);
        b(this.heF);
        this.heE = (HeadImageView) this.hez.findViewById(a.f.ala_anim_iv_user_head);
        b(this.heE);
        this.heG = (ImageView) this.hez.findViewById(a.f.ala_sdk_iv_anim_sweep);
        this.heu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.QE();
            }
        });
        this.hez.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.QE();
            }
        });
        this.heT = LayoutInflater.from(this.mContext).inflate(a.g.ala_sdk_head_line_lottie_layout, (ViewGroup) null, false);
        this.heS = (TBLottieAnimationView) this.heT.findViewById(a.f.ala_sdk_head_line_lot_view);
        this.heS.setAnimation("head_linedata_explosion.json");
        this.heS.setAnimationDir("/");
        this.heR = (RelativeLayout.LayoutParams) this.heA.getLayoutParams();
        this.mScreenWidth = ScreenHelper.getRealScreenWidth(this.mContext);
        this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.ds240 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds232);
        this.heQ = this.mScreenWidth - (this.ds20 * 2);
        this.heR.width = this.heQ;
        this.heA.setLayoutParams(this.heR);
        this.mHandler.postDelayed(this.heU, 2000L);
    }

    private void b(HeadImageView headImageView) {
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setBorderWidth(BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds2));
        headImageView.setBorderColor(-1);
    }

    public View getRootView() {
        return this.her;
    }

    private void a(final q qVar, boolean z) {
        if (qVar != null) {
            this.heF.startLoad(qVar.aHz, 12, false);
            this.heE.startLoad(qVar.aHA, 12, false);
            if (z) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b(qVar);
                    }
                }, 1000L);
                final SpannableStringBuilder d = d(qVar);
                if (d == null || d.length() <= 0) {
                    FP();
                    next();
                    return;
                }
                this.aYP = true;
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.14
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.e(d);
                    }
                }, 300L);
                a(qVar);
                return;
            }
            b(qVar);
        }
    }

    private void a(q qVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, Long.valueOf(qVar.aHv));
            jSONObject.putOpt("gift_count", Long.valueOf(qVar.giftNum));
            jSONObject.putOpt("total_score", Long.valueOf(qVar.aHu));
            jSONObject.putOpt("start_time", Long.valueOf(qVar.startTime));
            jSONObject.putOpt("end_time", Long.valueOf(qVar.endTime));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_HEADLINE, UbcStatConstant.ContentType.UBC_TYPE_HEADLINE_UPDATE, this.isHost ? "author_liveroom" : "liveroom", qVar.aHB ? "im" : UbcStatConstant.Value.VALUE_HEADLINE_FROM_SERVER).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(q qVar) {
        if (this.heD != null && qVar != null) {
            this.heD.startLoad(qVar.aHz, 12, false);
        }
        if (this.heC != null && qVar != null) {
            this.heC.startLoad(qVar.aHA, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SpannableStringBuilder spannableStringBuilder) {
        if (this.mContext != null) {
            if (spannableStringBuilder == null || spannableStringBuilder.length() <= 0) {
                FP();
                next();
                return;
            }
            this.hes.setText(spannableStringBuilder);
            this.hes.setTranslationX(0.0f);
            int textWidth = BdUtilHelper.getTextWidth(this.hes.getPaint(), spannableStringBuilder.toString());
            int width = this.het.getWidth();
            int width2 = this.heB.getWidth();
            int i = width > 0 ? width : this.heQ - this.ds240;
            float f = -(textWidth - i);
            if (this.DEBUG) {
                Log.e(">>>>>>", "1 calculateWidthAndStartAnimator ssb.length:" + spannableStringBuilder.length() + " " + spannableStringBuilder.toString() + " mScreenWidth：" + this.mScreenWidth);
                Log.e(">>>>>>", "2 maxContentLength:" + i + " textWidth:" + textWidth + " desToXValue:" + f + " mBoardCastContentWidth:" + this.heQ + " mLlBoardCastContainerView width:" + width + " mBoardCastFixedContainerViewwidth1: " + width2);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hes.getLayoutParams();
            if (textWidth < i) {
                layoutParams.width = -2;
                this.hes.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = textWidth;
                this.hes.setLayoutParams(layoutParams);
                this.heK = ObjectAnimator.ofFloat(this.hes, "translationX", 0.0f, f);
                this.heK.setDuration(1000L);
                this.heK.setStartDelay(1000L);
            }
            ObjectAnimator bWT = bWT();
            ValueAnimator bWS = bWS();
            ObjectAnimator bWR = bWR();
            ObjectAnimator bWU = bWU();
            ObjectAnimator bWQ = bWQ();
            ObjectAnimator bWP = bWP();
            this.aZa = new AnimatorSet();
            this.heP = new ArrayList();
            this.heP.add(bWT);
            this.heP.add(bWQ);
            this.heP.add(bWP);
            if (this.heK != null) {
                this.heP.add(this.heK);
            }
            this.heP.add(bWU);
            this.heP.add(bWS);
            this.heP.add(bWR);
            this.aZa.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.18
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.FP();
                    a.this.aZa.removeAllListeners();
                    a.this.next();
                }
            });
            this.aZa.playTogether(this.heP);
            this.aZa.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        if (this.DEBUG) {
            Log.e(">>>>>>", "1-next:mList.size:" + this.mList.size());
        }
        if (!this.mList.isEmpty()) {
            q qVar = this.mList.get(this.mList.size() - 1);
            if (qVar.aHu > this.heY) {
                this.aIB = qVar;
                this.heY = this.aIB.aHu;
                this.heo = this.aIB.endTime - this.aIB.serverTime;
                bWO();
                a(this.aIB, true);
            }
            this.mList.clear();
        }
    }

    private void bWO() {
        this.heW = true;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.19
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.heX);
                if (a.this.heo > 1) {
                    a.this.heo++;
                }
                a.this.mHandler.post(a.this.heX);
            }
        });
    }

    private ObjectAnimator bWP() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.heu, "alpha", 0.1f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(6700L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.heu.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.mHandler.removeCallbacks(a.this.heU);
                a.this.mHandler.post(a.this.heU);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bWQ() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.heu, "translationX", 0.0f, this.heu.getWidth());
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(100L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.heu.setTranslationX(0.0f);
                a.this.heu.setVisibility(4);
                a.this.heS.setVisibility(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.heS.setVisibility(0);
                a.this.heS.playAnimation();
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bWR() {
        if (this.heO == null) {
            this.heO = ObjectAnimator.ofFloat(this.hez, "alpha", 1.0f, 0.0f);
            this.heO.setDuration(300L);
            this.heO.setStartDelay(6700L);
        }
        return this.heO;
    }

    private ValueAnimator bWS() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.heA.getMeasuredWidth() - this.heu.getMeasuredWidth());
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (a.this.heR.leftMargin < intValue) {
                    a.this.heR.leftMargin = intValue;
                    a.this.heA.setLayoutParams(a.this.heR);
                }
            }
        });
        ofInt.setStartDelay(6000L);
        ofInt.setDuration(1000L);
        return ofInt;
    }

    private ObjectAnimator bWT() {
        if (this.heN == null) {
            this.heN = ObjectAnimator.ofFloat(this.hez, "translationX", -this.mScreenWidth, 0.0f);
            this.heN.setDuration(1000L);
            this.heN.setInterpolator(new OvershootInterpolator());
            this.heN.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.aYP = true;
                    a.this.hez.setVisibility(0);
                }
            });
        }
        return this.heN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator bWU() {
        if (this.heL == null) {
            this.heL = ObjectAnimator.ofFloat(this.heG, "translationX", 0.0f, this.heQ);
            this.heL.setDuration(800L);
            this.heL.setInterpolator(new AccelerateInterpolator());
            this.heL.setStartDelay(1000L);
            this.heL.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    a.this.heG.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.heG.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.heG.setVisibility(8);
                    a.this.mHandler.removeCallbacks(a.this.heV);
                    a.this.mHandler.postDelayed(a.this.heV, 1500L);
                }
            });
            this.heL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                        a.this.heG.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                    } else {
                        a.this.heG.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                    }
                }
            });
        } else {
            this.heG.clearAnimation();
        }
        return this.heL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator bWV() {
        int width;
        if (this.heJ == null) {
            return null;
        }
        if ((this.hey.getVisibility() == 0 || this.hex.getVisibility() == 0) && (width = this.heu.getWidth()) > 0) {
            this.heJ.clearAnimation();
            if (this.heM == null) {
                this.heM = ObjectAnimator.ofFloat(this.heJ, "translationX", 0.0f, width);
                this.heM.setDuration(1000L);
                this.heM.setInterpolator(new AccelerateInterpolator());
                this.heM.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.8
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        a.this.heJ.setVisibility(0);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.heJ.setVisibility(8);
                    }
                });
                this.heM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.9
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                            a.this.heJ.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                        } else {
                            a.this.heJ.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                        }
                    }
                });
            } else {
                this.heM.setFloatValues(0.0f, width);
            }
            return this.heM;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP() {
        this.aYP = false;
        this.hez.clearAnimation();
        this.hes.clearAnimation();
        this.heu.clearAnimation();
        this.heu.setAlpha(1.0f);
        this.hes.setAlpha(1.0f);
        this.heG.clearAnimation();
        this.hez.setAlpha(1.0f);
        this.heR.leftMargin = 0;
        this.heA.setLayoutParams(this.heR);
        this.hez.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(final boolean z, boolean z2) {
        this.aUb = z ? 2 : 1;
        if (z2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        a.this.hex.setVisibility(0);
                        a.this.hey.setVisibility(8);
                        return;
                    }
                    a.this.hex.setVisibility(8);
                    a.this.hey.setVisibility(0);
                }
            }, 1000L);
        } else if (z) {
            this.hex.setVisibility(0);
            this.hey.setVisibility(8);
        } else {
            this.hex.setVisibility(8);
            this.hey.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QE() {
        if (this.aDd != null && this.aDd.aIB != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new j(this.mContext, this.aDd, this.aUb, this.otherParams, this.heo)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aDd));
        }
    }

    public void nt(boolean z) {
        this.her.setVisibility(8);
        if (this.DEBUG) {
            Log.e(">>>>>>", "onCloseEntryView first：" + z);
        }
        this.heY = 0L;
        this.heq = true;
        if (!z) {
            FP();
            this.mList.clear();
        }
    }

    public void bWW() {
        if (this.her != null && this.her.getVisibility() != 0) {
            if (this.DEBUG) {
                Log.e(">>>>>>", "setEntryViewVisibility");
            }
            this.heq = false;
            this.mHandler.removeCallbacks(this.heU);
            this.mHandler.post(this.heU);
            this.her.setVisibility(0);
        }
    }

    public void b(ab abVar, boolean z) {
        q qVar = abVar.aIB;
        qVar.aHB = z;
        this.aDd = abVar;
        this.isHost = abVar.isHost;
        if (qVar.endTime - qVar.serverTime <= 1) {
            this.heY = qVar.aHs;
            N(false, false);
        } else {
            if (this.heY <= 0) {
                this.heY = qVar.aHu;
            }
            if (this.heY < qVar.aHu) {
                if (this.aUb != 1) {
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "3 setData countdownTime:" + this.heo + " mCurScore:" + this.heY);
                    }
                    if (!c(qVar)) {
                        this.mList.add(qVar);
                    }
                }
                if (this.aYP) {
                    if (!c(qVar)) {
                        this.mList.add(qVar);
                    }
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "2 setData countdownTime:" + this.heo + " mCurScore:" + this.heY);
                    }
                } else {
                    if (this.aUb == 1) {
                        N(true, true);
                    }
                    this.aIB = qVar;
                    this.heY = qVar.aHu;
                    this.heo = qVar.endTime - qVar.serverTime;
                    bWO();
                    a(this.aIB, true);
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "1 setData countdownTime:" + this.heo + " mCurScore:" + this.heY + "info.endTime:" + qVar.endTime + " info.serverTime:" + qVar.serverTime);
                    }
                }
            } else {
                this.aIB = qVar;
                this.heY = qVar.aHu;
                if (this.heY <= qVar.aHs) {
                    this.heo = 0L;
                    N(false, false);
                } else {
                    if (this.heo <= 0) {
                        this.heo = qVar.endTime - qVar.serverTime;
                    } else {
                        long j = qVar.endTime - qVar.serverTime;
                        if (j < this.heo && j > 1) {
                            this.heo = j;
                        }
                    }
                    N(true, true);
                    bWO();
                    a(this.aIB, false);
                }
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aDd));
        this.heq = false;
    }

    private boolean c(q qVar) {
        if (this.mList.isEmpty()) {
            return false;
        }
        Iterator<q> it = this.mList.iterator();
        while (it.hasNext()) {
            if (it.next().aHu == qVar.aHu) {
                return true;
            }
        }
        return false;
    }

    public void onDestory() {
        this.heY = 0L;
        this.heq = true;
        this.heo = 0L;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void IZ() {
        this.heo = 0L;
        this.heY = 0L;
        this.aUb = 1;
        this.aYP = false;
        this.heq = true;
        if (this.mList != null) {
            this.mList.clear();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        FP();
    }

    public SpannableStringBuilder d(q qVar) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            spannableStringBuilder.append((CharSequence) qVar.userName);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFEAAA")), 0, qVar.userName.length(), 33);
            spannableStringBuilder.append((CharSequence) " 送给 ");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) qVar.aHy);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFEAAA")), length, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) (" " + qVar.giftName));
            final int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) "[img]");
            spannableStringBuilder.append((CharSequence) ("X" + qVar.giftNum + "个"));
            BdResourceLoader.getInstance().loadResource(qVar.aHx, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.tieba.ala.headline.view.a.11
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i) {
                    super.onLoaded((AnonymousClass11) bdImage, str, i);
                    Bitmap a2 = a.this.a(bdImage);
                    if (a2 != null) {
                        CenteredImageSpan centeredImageSpan = new CenteredImageSpan(a.this.mContext, a2);
                        SpannableString spannableString = new SpannableString("[img]");
                        spannableString.setSpan(centeredImageSpan, 0, spannableString.length(), 33);
                        spannableStringBuilder.replace(length2, length2 + "[img]".length(), (CharSequence) spannableString);
                        a.this.hes.setText(spannableStringBuilder);
                        a.this.hes.forceLayout();
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
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
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

    public void cK(int i) {
    }
}
