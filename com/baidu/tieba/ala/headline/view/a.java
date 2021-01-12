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
import com.baidu.live.data.m;
import com.baidu.live.data.x;
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
/* loaded from: classes10.dex */
public class a {
    private x aBr;
    public m aGf;
    private AnimatorSet aVS;
    private int ds20;
    private int ds240;
    private ViewGroup hbA;
    private ViewGroup hbB;
    private View hbC;
    private View hbD;
    private ViewGroup hbE;
    private HeadImageView hbF;
    private HeadImageView hbG;
    private HeadImageView hbH;
    private HeadImageView hbI;
    private ImageView hbJ;
    private TbImageView hbK;
    private TextView hbL;
    private ImageView hbM;
    private ObjectAnimator hbN;
    private ObjectAnimator hbO;
    private ObjectAnimator hbP;
    private ObjectAnimator hbQ;
    private ObjectAnimator hbR;
    private List<Animator> hbS;
    private int hbT;
    private RelativeLayout.LayoutParams hbU;
    private TBLottieAnimationView hbV;
    private View hbW;
    private long hbr;
    private View hbu;
    private TextView hbv;
    private ViewGroup hbw;
    private ViewGroup hbx;
    private TextView hby;
    private TextView hbz;
    private long hcb;
    private boolean isHost;
    Activity mContext;
    private int mScreenWidth;
    private boolean DEBUG = false;
    String otherParams = "";
    private int aQW = 1;
    private boolean hbt = false;
    private boolean aVH = false;
    private Runnable hbX = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.15
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.hbt) {
                ObjectAnimator bWk = a.this.bWk();
                if (bWk != null && !bWk.isRunning()) {
                    bWk.start();
                }
                a.this.mHandler.postDelayed(this, 2000L);
            }
        }
    };
    private Runnable hbY = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.16
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.hbt) {
                if (!a.this.aVH) {
                    a.this.mHandler.removeCallbacks(this);
                    return;
                }
                ObjectAnimator bWj = a.this.bWj();
                if (bWj != null && !bWj.isRunning()) {
                    bWj.start();
                }
                a.this.mHandler.postDelayed(this, 1500L);
            }
        }
    };
    private boolean hbZ = false;
    private Runnable hca = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17
        @Override // java.lang.Runnable
        public void run() {
            a.this.hbr--;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913245, Long.valueOf(a.this.hbr)));
            if (a.this.hbr <= 0) {
                a.this.hbz.setText("");
                a.this.hby.setText("");
                a.this.N(false, false);
                a.this.mHandler.removeCallbacks(this);
                if (a.this.aGf != null) {
                    a.this.hcb = a.this.aGf.aEW;
                    return;
                }
                return;
            }
            a.this.hbz.setText(a.this.hbr + "s");
            if (a.this.hbZ) {
                a.this.hbZ = false;
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.hby != null) {
                            a.this.hby.setText(a.this.hbr + "s");
                        }
                    }
                }, 1000L);
            } else {
                a.this.hby.setText(a.this.hbr + "s");
            }
            a.this.mHandler.postDelayed(this, 1000L);
        }
    };
    private List<m> mList = new ArrayList();
    private Handler mHandler = new Handler();

    public View bWc() {
        return this.hbW;
    }

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.hbu = LayoutInflater.from(this.mContext).inflate(a.g.sdk_headline_layout, (ViewGroup) null, false);
        this.hbx = (ViewGroup) this.hbu.findViewById(a.f.ala_sdk_rl_all_content_container);
        this.hbA = (ViewGroup) this.hbu.findViewById(a.f.ala_ll_have_fixed_container);
        this.hbB = (ViewGroup) this.hbu.findViewById(a.f.ala_ll_empty_fixed_container);
        this.hby = (TextView) this.hbu.findViewById(a.f.ala_tv_time);
        this.hbM = (ImageView) this.hbu.findViewById(a.f.ala_sdk_iv_sweep);
        this.hbG = (HeadImageView) this.hbu.findViewById(a.f.ala_iv_host_head);
        b(this.hbG);
        this.hbF = (HeadImageView) this.hbu.findViewById(a.f.ala_iv_user_head);
        b(this.hbF);
        this.hbL = (TextView) this.hbu.findViewById(a.f.ala_sdk_head_line_tv_text);
        this.hbK = (TbImageView) this.hbu.findViewById(a.f.ala_iv_empty_icon);
        this.hbC = this.hbu.findViewById(a.f.ala_sdk_rl_boardcast_root_view);
        this.hbC.setVisibility(4);
        this.hbD = this.hbC.findViewById(a.f.ala_sdk_anim_container);
        this.hbE = (ViewGroup) this.hbC.findViewById(a.f.ala_anim_ll_have_fixed_container);
        this.hbz = (TextView) this.hbC.findViewById(a.f.ala_anim_tv_time);
        this.hbv = (TextView) this.hbC.findViewById(a.f.ala_sdk_tv_gift_show);
        this.hbw = (ViewGroup) this.hbC.findViewById(a.f.ala_sdk_ll_gift_text_show_container);
        this.hbI = (HeadImageView) this.hbC.findViewById(a.f.ala_anim_iv_host_head);
        b(this.hbI);
        this.hbH = (HeadImageView) this.hbC.findViewById(a.f.ala_anim_iv_user_head);
        b(this.hbH);
        this.hbJ = (ImageView) this.hbC.findViewById(a.f.ala_sdk_iv_anim_sweep);
        this.hbx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Pd();
            }
        });
        this.hbC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Pd();
            }
        });
        this.hbW = LayoutInflater.from(this.mContext).inflate(a.g.ala_sdk_head_line_lottie_layout, (ViewGroup) null, false);
        this.hbV = (TBLottieAnimationView) this.hbW.findViewById(a.f.ala_sdk_head_line_lot_view);
        this.hbV.setAnimation("head_linedata_explosion.json");
        this.hbV.setAnimationDir("/");
        this.hbU = (RelativeLayout.LayoutParams) this.hbD.getLayoutParams();
        this.mScreenWidth = ScreenHelper.getRealScreenWidth(this.mContext);
        this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.ds240 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds232);
        this.hbT = this.mScreenWidth - (this.ds20 * 2);
        this.hbU.width = this.hbT;
        this.hbD.setLayoutParams(this.hbU);
        this.mHandler.postDelayed(this.hbX, 2000L);
    }

    private void b(HeadImageView headImageView) {
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setBorderWidth(BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds2));
        headImageView.setBorderColor(-1);
    }

    public View getRootView() {
        return this.hbu;
    }

    private void a(final m mVar, boolean z) {
        if (mVar != null) {
            this.hbI.startLoad(mVar.aFd, 12, false);
            this.hbH.startLoad(mVar.aFe, 12, false);
            if (z) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b(mVar);
                    }
                }, 1000L);
                final SpannableStringBuilder d = d(mVar);
                if (d == null || d.length() <= 0) {
                    Ez();
                    next();
                    return;
                }
                this.aVH = true;
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.14
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.e(d);
                    }
                }, 300L);
                a(mVar);
                return;
            }
            b(mVar);
        }
    }

    private void a(m mVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, Long.valueOf(mVar.aEZ));
            jSONObject.putOpt("gift_count", Long.valueOf(mVar.giftNum));
            jSONObject.putOpt("total_score", Long.valueOf(mVar.aEY));
            jSONObject.putOpt("start_time", Long.valueOf(mVar.startTime));
            jSONObject.putOpt("end_time", Long.valueOf(mVar.endTime));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_HEADLINE, UbcStatConstant.ContentType.UBC_TYPE_HEADLINE_UPDATE, this.isHost ? "author_liveroom" : "liveroom", mVar.aFf ? "im" : UbcStatConstant.Value.VALUE_HEADLINE_FROM_SERVER).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(m mVar) {
        if (this.hbG != null && mVar != null) {
            this.hbG.startLoad(mVar.aFd, 12, false);
        }
        if (this.hbF != null && mVar != null) {
            this.hbF.startLoad(mVar.aFe, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SpannableStringBuilder spannableStringBuilder) {
        if (this.mContext != null) {
            if (spannableStringBuilder == null || spannableStringBuilder.length() <= 0) {
                Ez();
                next();
                return;
            }
            this.hbv.setText(spannableStringBuilder);
            this.hbv.setTranslationX(0.0f);
            int textWidth = BdUtilHelper.getTextWidth(this.hbv.getPaint(), spannableStringBuilder.toString());
            int width = this.hbw.getWidth();
            int width2 = this.hbE.getWidth();
            int i = width > 0 ? width : this.hbT - this.ds240;
            float f = -(textWidth - i);
            if (this.DEBUG) {
                Log.e(">>>>>>", "1 calculateWidthAndStartAnimator ssb.length:" + spannableStringBuilder.length() + " " + spannableStringBuilder.toString() + " mScreenWidth：" + this.mScreenWidth);
                Log.e(">>>>>>", "2 maxContentLength:" + i + " textWidth:" + textWidth + " desToXValue:" + f + " mBoardCastContentWidth:" + this.hbT + " mLlBoardCastContainerView width:" + width + " mBoardCastFixedContainerViewwidth1: " + width2);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hbv.getLayoutParams();
            if (textWidth < i) {
                layoutParams.width = -2;
                this.hbv.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = textWidth;
                this.hbv.setLayoutParams(layoutParams);
                this.hbN = ObjectAnimator.ofFloat(this.hbv, "translationX", 0.0f, f);
                this.hbN.setDuration(1000L);
                this.hbN.setStartDelay(1000L);
            }
            ObjectAnimator bWi = bWi();
            ValueAnimator bWh = bWh();
            ObjectAnimator bWg = bWg();
            ObjectAnimator bWj = bWj();
            ObjectAnimator bWf = bWf();
            ObjectAnimator bWe = bWe();
            this.aVS = new AnimatorSet();
            this.hbS = new ArrayList();
            this.hbS.add(bWi);
            this.hbS.add(bWf);
            this.hbS.add(bWe);
            if (this.hbN != null) {
                this.hbS.add(this.hbN);
            }
            this.hbS.add(bWj);
            this.hbS.add(bWh);
            this.hbS.add(bWg);
            this.aVS.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.18
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.Ez();
                    a.this.aVS.removeAllListeners();
                    a.this.next();
                }
            });
            this.aVS.playTogether(this.hbS);
            this.aVS.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        if (this.DEBUG) {
            Log.e(">>>>>>", "1-next:mList.size:" + this.mList.size());
        }
        if (!this.mList.isEmpty()) {
            m mVar = this.mList.get(this.mList.size() - 1);
            if (mVar.aEY > this.hcb) {
                this.aGf = mVar;
                this.hcb = this.aGf.aEY;
                this.hbr = this.aGf.endTime - this.aGf.serverTime;
                bWd();
                a(this.aGf, true);
            }
            this.mList.clear();
        }
    }

    private void bWd() {
        this.hbZ = true;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.19
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.hca);
                if (a.this.hbr > 1) {
                    a.this.hbr++;
                }
                a.this.mHandler.post(a.this.hca);
            }
        });
    }

    private ObjectAnimator bWe() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hbx, "alpha", 0.1f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(6700L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.hbx.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.mHandler.removeCallbacks(a.this.hbX);
                a.this.mHandler.post(a.this.hbX);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bWf() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hbx, "translationX", 0.0f, this.hbx.getWidth());
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(100L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.hbx.setTranslationX(0.0f);
                a.this.hbx.setVisibility(4);
                a.this.hbV.setVisibility(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.hbV.setVisibility(0);
                a.this.hbV.playAnimation();
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bWg() {
        if (this.hbR == null) {
            this.hbR = ObjectAnimator.ofFloat(this.hbC, "alpha", 1.0f, 0.0f);
            this.hbR.setDuration(300L);
            this.hbR.setStartDelay(6700L);
        }
        return this.hbR;
    }

    private ValueAnimator bWh() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.hbD.getMeasuredWidth() - this.hbx.getMeasuredWidth());
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (a.this.hbU.leftMargin < intValue) {
                    a.this.hbU.leftMargin = intValue;
                    a.this.hbD.setLayoutParams(a.this.hbU);
                }
            }
        });
        ofInt.setStartDelay(6000L);
        ofInt.setDuration(1000L);
        return ofInt;
    }

    private ObjectAnimator bWi() {
        if (this.hbQ == null) {
            this.hbQ = ObjectAnimator.ofFloat(this.hbC, "translationX", -this.mScreenWidth, 0.0f);
            this.hbQ.setDuration(1000L);
            this.hbQ.setInterpolator(new OvershootInterpolator());
            this.hbQ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.aVH = true;
                    a.this.hbC.setVisibility(0);
                }
            });
        }
        return this.hbQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator bWj() {
        if (this.hbO == null) {
            this.hbO = ObjectAnimator.ofFloat(this.hbJ, "translationX", 0.0f, this.hbT);
            this.hbO.setDuration(800L);
            this.hbO.setInterpolator(new AccelerateInterpolator());
            this.hbO.setStartDelay(1000L);
            this.hbO.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    a.this.hbJ.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.hbJ.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.hbJ.setVisibility(8);
                    a.this.mHandler.removeCallbacks(a.this.hbY);
                    a.this.mHandler.postDelayed(a.this.hbY, 1500L);
                }
            });
            this.hbO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                        a.this.hbJ.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                    } else {
                        a.this.hbJ.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                    }
                }
            });
        } else {
            this.hbJ.clearAnimation();
        }
        return this.hbO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator bWk() {
        int width;
        if (this.hbM == null) {
            return null;
        }
        if ((this.hbB.getVisibility() == 0 || this.hbA.getVisibility() == 0) && (width = this.hbx.getWidth()) > 0) {
            this.hbM.clearAnimation();
            if (this.hbP == null) {
                this.hbP = ObjectAnimator.ofFloat(this.hbM, "translationX", 0.0f, width);
                this.hbP.setDuration(1000L);
                this.hbP.setInterpolator(new AccelerateInterpolator());
                this.hbP.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.8
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        a.this.hbM.setVisibility(0);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.hbM.setVisibility(8);
                    }
                });
                this.hbP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.9
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                            a.this.hbM.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                        } else {
                            a.this.hbM.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                        }
                    }
                });
            } else {
                this.hbP.setFloatValues(0.0f, width);
            }
            return this.hbP;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ez() {
        this.aVH = false;
        this.hbC.clearAnimation();
        this.hbv.clearAnimation();
        this.hbx.clearAnimation();
        this.hbx.setAlpha(1.0f);
        this.hbv.setAlpha(1.0f);
        this.hbJ.clearAnimation();
        this.hbC.setAlpha(1.0f);
        this.hbU.leftMargin = 0;
        this.hbD.setLayoutParams(this.hbU);
        this.hbC.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(final boolean z, boolean z2) {
        this.aQW = z ? 2 : 1;
        if (z2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        a.this.hbA.setVisibility(0);
                        a.this.hbB.setVisibility(8);
                        return;
                    }
                    a.this.hbA.setVisibility(8);
                    a.this.hbB.setVisibility(0);
                }
            }, 1000L);
        } else if (z) {
            this.hbA.setVisibility(0);
            this.hbB.setVisibility(8);
        } else {
            this.hbA.setVisibility(8);
            this.hbB.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pd() {
        if (this.aBr != null && this.aBr.aGf != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new j(this.mContext, this.aBr, this.aQW, this.otherParams, this.hbr)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aBr));
        }
    }

    public void no(boolean z) {
        this.hbu.setVisibility(8);
        if (this.DEBUG) {
            Log.e(">>>>>>", "onCloseEntryView first：" + z);
        }
        this.hcb = 0L;
        this.hbt = true;
        if (!z) {
            Ez();
            this.mList.clear();
        }
    }

    public void bWl() {
        if (this.hbu != null && this.hbu.getVisibility() != 0) {
            if (this.DEBUG) {
                Log.e(">>>>>>", "setEntryViewVisibility");
            }
            this.hbt = false;
            this.mHandler.removeCallbacks(this.hbX);
            this.mHandler.post(this.hbX);
            this.hbu.setVisibility(0);
        }
    }

    public void b(x xVar, boolean z) {
        m mVar = xVar.aGf;
        mVar.aFf = z;
        this.aBr = xVar;
        this.isHost = xVar.isHost;
        if (mVar.endTime - mVar.serverTime <= 1) {
            this.hcb = mVar.aEW;
            N(false, false);
        } else {
            if (this.hcb <= 0) {
                this.hcb = mVar.aEY;
            }
            if (this.hcb < mVar.aEY) {
                if (this.aQW != 1) {
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "3 setData countdownTime:" + this.hbr + " mCurScore:" + this.hcb);
                    }
                    if (!c(mVar)) {
                        this.mList.add(mVar);
                    }
                }
                if (this.aVH) {
                    if (!c(mVar)) {
                        this.mList.add(mVar);
                    }
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "2 setData countdownTime:" + this.hbr + " mCurScore:" + this.hcb);
                    }
                } else {
                    if (this.aQW == 1) {
                        N(true, true);
                    }
                    this.aGf = mVar;
                    this.hcb = mVar.aEY;
                    this.hbr = mVar.endTime - mVar.serverTime;
                    bWd();
                    a(this.aGf, true);
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "1 setData countdownTime:" + this.hbr + " mCurScore:" + this.hcb + "info.endTime:" + mVar.endTime + " info.serverTime:" + mVar.serverTime);
                    }
                }
            } else {
                this.aGf = mVar;
                this.hcb = mVar.aEY;
                if (this.hcb <= mVar.aEW) {
                    this.hbr = 0L;
                    N(false, false);
                } else {
                    if (this.hbr <= 0) {
                        this.hbr = mVar.endTime - mVar.serverTime;
                    } else {
                        long j = mVar.endTime - mVar.serverTime;
                        if (j < this.hbr && j > 1) {
                            this.hbr = j;
                        }
                    }
                    N(true, true);
                    bWd();
                    a(this.aGf, false);
                }
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aBr));
        this.hbt = false;
    }

    private boolean c(m mVar) {
        if (this.mList.isEmpty()) {
            return false;
        }
        Iterator<m> it = this.mList.iterator();
        while (it.hasNext()) {
            if (it.next().aEY == mVar.aEY) {
                return true;
            }
        }
        return false;
    }

    public void onDestory() {
        this.hcb = 0L;
        this.hbt = true;
        this.hbr = 0L;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void HJ() {
        this.hbr = 0L;
        this.hcb = 0L;
        this.aQW = 1;
        this.aVH = false;
        this.hbt = true;
        if (this.mList != null) {
            this.mList.clear();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        Ez();
    }

    public SpannableStringBuilder d(m mVar) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            spannableStringBuilder.append((CharSequence) mVar.userName);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFEAAA")), 0, mVar.userName.length(), 33);
            spannableStringBuilder.append((CharSequence) " 送给 ");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) mVar.aFc);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFEAAA")), length, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) (" " + mVar.giftName));
            final int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) "[img]");
            spannableStringBuilder.append((CharSequence) ("X" + mVar.giftNum + "个"));
            BdResourceLoader.getInstance().loadResource(mVar.aFb, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.tieba.ala.headline.view.a.11
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
                        a.this.hbv.setText(spannableStringBuilder);
                        a.this.hbv.forceLayout();
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

    public void cF(int i) {
    }
}
