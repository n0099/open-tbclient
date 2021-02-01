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
    private ObjectAnimator heA;
    private List<Animator> heB;
    private int heC;
    private RelativeLayout.LayoutParams heD;
    private TBLottieAnimationView heE;
    private View heF;
    private long heK;
    private long hea;
    private View hed;
    private TextView hee;
    private ViewGroup hef;
    private ViewGroup heg;
    private TextView heh;
    private TextView hei;
    private ViewGroup hej;
    private ViewGroup hek;
    private View hel;
    private View hem;
    private ViewGroup hen;
    private HeadImageView heo;
    private HeadImageView hep;
    private HeadImageView heq;
    private HeadImageView her;
    private ImageView hes;
    private TbImageView het;
    private TextView heu;
    private ImageView hev;
    private ObjectAnimator hew;
    private ObjectAnimator hex;
    private ObjectAnimator hey;
    private ObjectAnimator hez;
    private boolean isHost;
    Activity mContext;
    private int mScreenWidth;
    private boolean DEBUG = false;
    String otherParams = "";
    private int aUb = 1;
    private boolean hec = false;
    private boolean aYP = false;
    private Runnable heG = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.15
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.hec) {
                ObjectAnimator bWO = a.this.bWO();
                if (bWO != null && !bWO.isRunning()) {
                    bWO.start();
                }
                a.this.mHandler.postDelayed(this, 2000L);
            }
        }
    };
    private Runnable heH = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.16
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.hec) {
                if (!a.this.aYP) {
                    a.this.mHandler.removeCallbacks(this);
                    return;
                }
                ObjectAnimator bWN = a.this.bWN();
                if (bWN != null && !bWN.isRunning()) {
                    bWN.start();
                }
                a.this.mHandler.postDelayed(this, 1500L);
            }
        }
    };
    private boolean heI = false;
    private Runnable heJ = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17
        @Override // java.lang.Runnable
        public void run() {
            a.this.hea--;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913245, Long.valueOf(a.this.hea)));
            if (a.this.hea <= 0) {
                a.this.hei.setText("");
                a.this.heh.setText("");
                a.this.N(false, false);
                a.this.mHandler.removeCallbacks(this);
                if (a.this.aIB != null) {
                    a.this.heK = a.this.aIB.aHs;
                    return;
                }
                return;
            }
            a.this.hei.setText(a.this.hea + "s");
            if (a.this.heI) {
                a.this.heI = false;
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.heh != null) {
                            a.this.heh.setText(a.this.hea + "s");
                        }
                    }
                }, 1000L);
            } else {
                a.this.heh.setText(a.this.hea + "s");
            }
            a.this.mHandler.postDelayed(this, 1000L);
        }
    };
    private List<q> mList = new ArrayList();
    private Handler mHandler = new Handler();

    public View bWG() {
        return this.heF;
    }

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.hed = LayoutInflater.from(this.mContext).inflate(a.g.sdk_headline_layout, (ViewGroup) null, false);
        this.heg = (ViewGroup) this.hed.findViewById(a.f.ala_sdk_rl_all_content_container);
        this.hej = (ViewGroup) this.hed.findViewById(a.f.ala_ll_have_fixed_container);
        this.hek = (ViewGroup) this.hed.findViewById(a.f.ala_ll_empty_fixed_container);
        this.heh = (TextView) this.hed.findViewById(a.f.ala_tv_time);
        this.hev = (ImageView) this.hed.findViewById(a.f.ala_sdk_iv_sweep);
        this.hep = (HeadImageView) this.hed.findViewById(a.f.ala_iv_host_head);
        b(this.hep);
        this.heo = (HeadImageView) this.hed.findViewById(a.f.ala_iv_user_head);
        b(this.heo);
        this.heu = (TextView) this.hed.findViewById(a.f.ala_sdk_head_line_tv_text);
        this.het = (TbImageView) this.hed.findViewById(a.f.ala_iv_empty_icon);
        this.hel = this.hed.findViewById(a.f.ala_sdk_rl_boardcast_root_view);
        this.hel.setVisibility(4);
        this.hem = this.hel.findViewById(a.f.ala_sdk_anim_container);
        this.hen = (ViewGroup) this.hel.findViewById(a.f.ala_anim_ll_have_fixed_container);
        this.hei = (TextView) this.hel.findViewById(a.f.ala_anim_tv_time);
        this.hee = (TextView) this.hel.findViewById(a.f.ala_sdk_tv_gift_show);
        this.hef = (ViewGroup) this.hel.findViewById(a.f.ala_sdk_ll_gift_text_show_container);
        this.her = (HeadImageView) this.hel.findViewById(a.f.ala_anim_iv_host_head);
        b(this.her);
        this.heq = (HeadImageView) this.hel.findViewById(a.f.ala_anim_iv_user_head);
        b(this.heq);
        this.hes = (ImageView) this.hel.findViewById(a.f.ala_sdk_iv_anim_sweep);
        this.heg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.QE();
            }
        });
        this.hel.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.QE();
            }
        });
        this.heF = LayoutInflater.from(this.mContext).inflate(a.g.ala_sdk_head_line_lottie_layout, (ViewGroup) null, false);
        this.heE = (TBLottieAnimationView) this.heF.findViewById(a.f.ala_sdk_head_line_lot_view);
        this.heE.setAnimation("head_linedata_explosion.json");
        this.heE.setAnimationDir("/");
        this.heD = (RelativeLayout.LayoutParams) this.hem.getLayoutParams();
        this.mScreenWidth = ScreenHelper.getRealScreenWidth(this.mContext);
        this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.ds240 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds232);
        this.heC = this.mScreenWidth - (this.ds20 * 2);
        this.heD.width = this.heC;
        this.hem.setLayoutParams(this.heD);
        this.mHandler.postDelayed(this.heG, 2000L);
    }

    private void b(HeadImageView headImageView) {
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setBorderWidth(BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds2));
        headImageView.setBorderColor(-1);
    }

    public View getRootView() {
        return this.hed;
    }

    private void a(final q qVar, boolean z) {
        if (qVar != null) {
            this.her.startLoad(qVar.aHz, 12, false);
            this.heq.startLoad(qVar.aHA, 12, false);
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
        if (this.hep != null && qVar != null) {
            this.hep.startLoad(qVar.aHz, 12, false);
        }
        if (this.heo != null && qVar != null) {
            this.heo.startLoad(qVar.aHA, 12, false);
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
            this.hee.setText(spannableStringBuilder);
            this.hee.setTranslationX(0.0f);
            int textWidth = BdUtilHelper.getTextWidth(this.hee.getPaint(), spannableStringBuilder.toString());
            int width = this.hef.getWidth();
            int width2 = this.hen.getWidth();
            int i = width > 0 ? width : this.heC - this.ds240;
            float f = -(textWidth - i);
            if (this.DEBUG) {
                Log.e(">>>>>>", "1 calculateWidthAndStartAnimator ssb.length:" + spannableStringBuilder.length() + " " + spannableStringBuilder.toString() + " mScreenWidth：" + this.mScreenWidth);
                Log.e(">>>>>>", "2 maxContentLength:" + i + " textWidth:" + textWidth + " desToXValue:" + f + " mBoardCastContentWidth:" + this.heC + " mLlBoardCastContainerView width:" + width + " mBoardCastFixedContainerViewwidth1: " + width2);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hee.getLayoutParams();
            if (textWidth < i) {
                layoutParams.width = -2;
                this.hee.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = textWidth;
                this.hee.setLayoutParams(layoutParams);
                this.hew = ObjectAnimator.ofFloat(this.hee, "translationX", 0.0f, f);
                this.hew.setDuration(1000L);
                this.hew.setStartDelay(1000L);
            }
            ObjectAnimator bWM = bWM();
            ValueAnimator bWL = bWL();
            ObjectAnimator bWK = bWK();
            ObjectAnimator bWN = bWN();
            ObjectAnimator bWJ = bWJ();
            ObjectAnimator bWI = bWI();
            this.aZa = new AnimatorSet();
            this.heB = new ArrayList();
            this.heB.add(bWM);
            this.heB.add(bWJ);
            this.heB.add(bWI);
            if (this.hew != null) {
                this.heB.add(this.hew);
            }
            this.heB.add(bWN);
            this.heB.add(bWL);
            this.heB.add(bWK);
            this.aZa.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.18
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.FP();
                    a.this.aZa.removeAllListeners();
                    a.this.next();
                }
            });
            this.aZa.playTogether(this.heB);
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
            if (qVar.aHu > this.heK) {
                this.aIB = qVar;
                this.heK = this.aIB.aHu;
                this.hea = this.aIB.endTime - this.aIB.serverTime;
                bWH();
                a(this.aIB, true);
            }
            this.mList.clear();
        }
    }

    private void bWH() {
        this.heI = true;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.19
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.heJ);
                if (a.this.hea > 1) {
                    a.this.hea++;
                }
                a.this.mHandler.post(a.this.heJ);
            }
        });
    }

    private ObjectAnimator bWI() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.heg, "alpha", 0.1f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(6700L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.heg.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.mHandler.removeCallbacks(a.this.heG);
                a.this.mHandler.post(a.this.heG);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bWJ() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.heg, "translationX", 0.0f, this.heg.getWidth());
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(100L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.heg.setTranslationX(0.0f);
                a.this.heg.setVisibility(4);
                a.this.heE.setVisibility(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.heE.setVisibility(0);
                a.this.heE.playAnimation();
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bWK() {
        if (this.heA == null) {
            this.heA = ObjectAnimator.ofFloat(this.hel, "alpha", 1.0f, 0.0f);
            this.heA.setDuration(300L);
            this.heA.setStartDelay(6700L);
        }
        return this.heA;
    }

    private ValueAnimator bWL() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.hem.getMeasuredWidth() - this.heg.getMeasuredWidth());
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (a.this.heD.leftMargin < intValue) {
                    a.this.heD.leftMargin = intValue;
                    a.this.hem.setLayoutParams(a.this.heD);
                }
            }
        });
        ofInt.setStartDelay(6000L);
        ofInt.setDuration(1000L);
        return ofInt;
    }

    private ObjectAnimator bWM() {
        if (this.hez == null) {
            this.hez = ObjectAnimator.ofFloat(this.hel, "translationX", -this.mScreenWidth, 0.0f);
            this.hez.setDuration(1000L);
            this.hez.setInterpolator(new OvershootInterpolator());
            this.hez.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.aYP = true;
                    a.this.hel.setVisibility(0);
                }
            });
        }
        return this.hez;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator bWN() {
        if (this.hex == null) {
            this.hex = ObjectAnimator.ofFloat(this.hes, "translationX", 0.0f, this.heC);
            this.hex.setDuration(800L);
            this.hex.setInterpolator(new AccelerateInterpolator());
            this.hex.setStartDelay(1000L);
            this.hex.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    a.this.hes.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.hes.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.hes.setVisibility(8);
                    a.this.mHandler.removeCallbacks(a.this.heH);
                    a.this.mHandler.postDelayed(a.this.heH, 1500L);
                }
            });
            this.hex.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                        a.this.hes.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                    } else {
                        a.this.hes.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                    }
                }
            });
        } else {
            this.hes.clearAnimation();
        }
        return this.hex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator bWO() {
        int width;
        if (this.hev == null) {
            return null;
        }
        if ((this.hek.getVisibility() == 0 || this.hej.getVisibility() == 0) && (width = this.heg.getWidth()) > 0) {
            this.hev.clearAnimation();
            if (this.hey == null) {
                this.hey = ObjectAnimator.ofFloat(this.hev, "translationX", 0.0f, width);
                this.hey.setDuration(1000L);
                this.hey.setInterpolator(new AccelerateInterpolator());
                this.hey.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.8
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        a.this.hev.setVisibility(0);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.hev.setVisibility(8);
                    }
                });
                this.hey.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.9
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                            a.this.hev.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                        } else {
                            a.this.hev.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                        }
                    }
                });
            } else {
                this.hey.setFloatValues(0.0f, width);
            }
            return this.hey;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP() {
        this.aYP = false;
        this.hel.clearAnimation();
        this.hee.clearAnimation();
        this.heg.clearAnimation();
        this.heg.setAlpha(1.0f);
        this.hee.setAlpha(1.0f);
        this.hes.clearAnimation();
        this.hel.setAlpha(1.0f);
        this.heD.leftMargin = 0;
        this.hem.setLayoutParams(this.heD);
        this.hel.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(final boolean z, boolean z2) {
        this.aUb = z ? 2 : 1;
        if (z2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        a.this.hej.setVisibility(0);
                        a.this.hek.setVisibility(8);
                        return;
                    }
                    a.this.hej.setVisibility(8);
                    a.this.hek.setVisibility(0);
                }
            }, 1000L);
        } else if (z) {
            this.hej.setVisibility(0);
            this.hek.setVisibility(8);
        } else {
            this.hej.setVisibility(8);
            this.hek.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QE() {
        if (this.aDd != null && this.aDd.aIB != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new j(this.mContext, this.aDd, this.aUb, this.otherParams, this.hea)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aDd));
        }
    }

    public void nt(boolean z) {
        this.hed.setVisibility(8);
        if (this.DEBUG) {
            Log.e(">>>>>>", "onCloseEntryView first：" + z);
        }
        this.heK = 0L;
        this.hec = true;
        if (!z) {
            FP();
            this.mList.clear();
        }
    }

    public void bWP() {
        if (this.hed != null && this.hed.getVisibility() != 0) {
            if (this.DEBUG) {
                Log.e(">>>>>>", "setEntryViewVisibility");
            }
            this.hec = false;
            this.mHandler.removeCallbacks(this.heG);
            this.mHandler.post(this.heG);
            this.hed.setVisibility(0);
        }
    }

    public void b(ab abVar, boolean z) {
        q qVar = abVar.aIB;
        qVar.aHB = z;
        this.aDd = abVar;
        this.isHost = abVar.isHost;
        if (qVar.endTime - qVar.serverTime <= 1) {
            this.heK = qVar.aHs;
            N(false, false);
        } else {
            if (this.heK <= 0) {
                this.heK = qVar.aHu;
            }
            if (this.heK < qVar.aHu) {
                if (this.aUb != 1) {
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "3 setData countdownTime:" + this.hea + " mCurScore:" + this.heK);
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
                        Log.e(">>>>>>", "2 setData countdownTime:" + this.hea + " mCurScore:" + this.heK);
                    }
                } else {
                    if (this.aUb == 1) {
                        N(true, true);
                    }
                    this.aIB = qVar;
                    this.heK = qVar.aHu;
                    this.hea = qVar.endTime - qVar.serverTime;
                    bWH();
                    a(this.aIB, true);
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "1 setData countdownTime:" + this.hea + " mCurScore:" + this.heK + "info.endTime:" + qVar.endTime + " info.serverTime:" + qVar.serverTime);
                    }
                }
            } else {
                this.aIB = qVar;
                this.heK = qVar.aHu;
                if (this.heK <= qVar.aHs) {
                    this.hea = 0L;
                    N(false, false);
                } else {
                    if (this.hea <= 0) {
                        this.hea = qVar.endTime - qVar.serverTime;
                    } else {
                        long j = qVar.endTime - qVar.serverTime;
                        if (j < this.hea && j > 1) {
                            this.hea = j;
                        }
                    }
                    N(true, true);
                    bWH();
                    a(this.aIB, false);
                }
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aDd));
        this.hec = false;
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
        this.heK = 0L;
        this.hec = true;
        this.hea = 0L;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void IZ() {
        this.hea = 0L;
        this.heK = 0L;
        this.aUb = 1;
        this.aYP = false;
        this.hec = true;
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
                        a.this.hee.setText(spannableStringBuilder);
                        a.this.hee.forceLayout();
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
