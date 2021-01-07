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
/* loaded from: classes11.dex */
public class a {
    private x aGe;
    public m aKS;
    private AnimatorSet baG;
    private int ds20;
    private int ds240;
    private long hfX;
    private RelativeLayout.LayoutParams hgA;
    private TBLottieAnimationView hgB;
    private View hgC;
    private long hgH;
    private View hga;
    private TextView hgb;
    private ViewGroup hgc;
    private ViewGroup hgd;
    private TextView hge;
    private TextView hgf;
    private ViewGroup hgg;
    private ViewGroup hgh;
    private View hgi;
    private View hgj;
    private ViewGroup hgk;
    private HeadImageView hgl;
    private HeadImageView hgm;
    private HeadImageView hgn;
    private HeadImageView hgo;
    private ImageView hgp;
    private TbImageView hgq;
    private TextView hgr;
    private ImageView hgs;
    private ObjectAnimator hgt;
    private ObjectAnimator hgu;
    private ObjectAnimator hgv;
    private ObjectAnimator hgw;
    private ObjectAnimator hgx;
    private List<Animator> hgy;
    private int hgz;
    private boolean isHost;
    Activity mContext;
    private int mScreenWidth;
    private boolean DEBUG = false;
    String otherParams = "";
    private int aVJ = 1;
    private boolean hfZ = false;
    private boolean bav = false;
    private Runnable hgD = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.15
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.hfZ) {
                ObjectAnimator cac = a.this.cac();
                if (cac != null && !cac.isRunning()) {
                    cac.start();
                }
                a.this.mHandler.postDelayed(this, 2000L);
            }
        }
    };
    private Runnable hgE = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.16
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.hfZ) {
                if (!a.this.bav) {
                    a.this.mHandler.removeCallbacks(this);
                    return;
                }
                ObjectAnimator cab = a.this.cab();
                if (cab != null && !cab.isRunning()) {
                    cab.start();
                }
                a.this.mHandler.postDelayed(this, 1500L);
            }
        }
    };
    private boolean hgF = false;
    private Runnable hgG = new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17
        @Override // java.lang.Runnable
        public void run() {
            a.this.hfX--;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913245, Long.valueOf(a.this.hfX)));
            if (a.this.hfX <= 0) {
                a.this.hgf.setText("");
                a.this.hge.setText("");
                a.this.N(false, false);
                a.this.mHandler.removeCallbacks(this);
                if (a.this.aKS != null) {
                    a.this.hgH = a.this.aKS.aJJ;
                    return;
                }
                return;
            }
            a.this.hgf.setText(a.this.hfX + "s");
            if (a.this.hgF) {
                a.this.hgF = false;
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.hge != null) {
                            a.this.hge.setText(a.this.hfX + "s");
                        }
                    }
                }, 1000L);
            } else {
                a.this.hge.setText(a.this.hfX + "s");
            }
            a.this.mHandler.postDelayed(this, 1000L);
        }
    };
    private List<m> mList = new ArrayList();
    private Handler mHandler = new Handler();

    public View bZU() {
        return this.hgC;
    }

    public a(TbPageContext tbPageContext) {
        this.mContext = tbPageContext.getPageActivity();
        initView();
    }

    private void initView() {
        this.hga = LayoutInflater.from(this.mContext).inflate(a.g.sdk_headline_layout, (ViewGroup) null, false);
        this.hgd = (ViewGroup) this.hga.findViewById(a.f.ala_sdk_rl_all_content_container);
        this.hgg = (ViewGroup) this.hga.findViewById(a.f.ala_ll_have_fixed_container);
        this.hgh = (ViewGroup) this.hga.findViewById(a.f.ala_ll_empty_fixed_container);
        this.hge = (TextView) this.hga.findViewById(a.f.ala_tv_time);
        this.hgs = (ImageView) this.hga.findViewById(a.f.ala_sdk_iv_sweep);
        this.hgm = (HeadImageView) this.hga.findViewById(a.f.ala_iv_host_head);
        b(this.hgm);
        this.hgl = (HeadImageView) this.hga.findViewById(a.f.ala_iv_user_head);
        b(this.hgl);
        this.hgr = (TextView) this.hga.findViewById(a.f.ala_sdk_head_line_tv_text);
        this.hgq = (TbImageView) this.hga.findViewById(a.f.ala_iv_empty_icon);
        this.hgi = this.hga.findViewById(a.f.ala_sdk_rl_boardcast_root_view);
        this.hgi.setVisibility(4);
        this.hgj = this.hgi.findViewById(a.f.ala_sdk_anim_container);
        this.hgk = (ViewGroup) this.hgi.findViewById(a.f.ala_anim_ll_have_fixed_container);
        this.hgf = (TextView) this.hgi.findViewById(a.f.ala_anim_tv_time);
        this.hgb = (TextView) this.hgi.findViewById(a.f.ala_sdk_tv_gift_show);
        this.hgc = (ViewGroup) this.hgi.findViewById(a.f.ala_sdk_ll_gift_text_show_container);
        this.hgo = (HeadImageView) this.hgi.findViewById(a.f.ala_anim_iv_host_head);
        b(this.hgo);
        this.hgn = (HeadImageView) this.hgi.findViewById(a.f.ala_anim_iv_user_head);
        b(this.hgn);
        this.hgp = (ImageView) this.hgi.findViewById(a.f.ala_sdk_iv_anim_sweep);
        this.hgd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.SY();
            }
        });
        this.hgi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.a.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.SY();
            }
        });
        this.hgC = LayoutInflater.from(this.mContext).inflate(a.g.ala_sdk_head_line_lottie_layout, (ViewGroup) null, false);
        this.hgB = (TBLottieAnimationView) this.hgC.findViewById(a.f.ala_sdk_head_line_lot_view);
        this.hgB.setAnimation("head_linedata_explosion.json");
        this.hgB.setAnimationDir("/");
        this.hgA = (RelativeLayout.LayoutParams) this.hgj.getLayoutParams();
        this.mScreenWidth = ScreenHelper.getRealScreenWidth(this.mContext);
        this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.ds240 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds232);
        this.hgz = this.mScreenWidth - (this.ds20 * 2);
        this.hgA.width = this.hgz;
        this.hgj.setLayoutParams(this.hgA);
        this.mHandler.postDelayed(this.hgD, 2000L);
    }

    private void b(HeadImageView headImageView) {
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setBorderWidth(BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds2));
        headImageView.setBorderColor(-1);
    }

    public View getRootView() {
        return this.hga;
    }

    private void a(final m mVar, boolean z) {
        if (mVar != null) {
            this.hgo.startLoad(mVar.aJQ, 12, false);
            this.hgn.startLoad(mVar.aJR, 12, false);
            if (z) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b(mVar);
                    }
                }, 1000L);
                final SpannableStringBuilder d = d(mVar);
                if (d == null || d.length() <= 0) {
                    Iu();
                    next();
                    return;
                }
                this.bav = true;
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
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, Long.valueOf(mVar.aJM));
            jSONObject.putOpt("gift_count", Long.valueOf(mVar.giftNum));
            jSONObject.putOpt("total_score", Long.valueOf(mVar.aJL));
            jSONObject.putOpt("start_time", Long.valueOf(mVar.startTime));
            jSONObject.putOpt("end_time", Long.valueOf(mVar.endTime));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_HEADLINE, UbcStatConstant.ContentType.UBC_TYPE_HEADLINE_UPDATE, this.isHost ? "author_liveroom" : "liveroom", mVar.aJS ? "im" : UbcStatConstant.Value.VALUE_HEADLINE_FROM_SERVER).setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(m mVar) {
        if (this.hgm != null && mVar != null) {
            this.hgm.startLoad(mVar.aJQ, 12, false);
        }
        if (this.hgl != null && mVar != null) {
            this.hgl.startLoad(mVar.aJR, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SpannableStringBuilder spannableStringBuilder) {
        if (this.mContext != null) {
            if (spannableStringBuilder == null || spannableStringBuilder.length() <= 0) {
                Iu();
                next();
                return;
            }
            this.hgb.setText(spannableStringBuilder);
            this.hgb.setTranslationX(0.0f);
            int textWidth = BdUtilHelper.getTextWidth(this.hgb.getPaint(), spannableStringBuilder.toString());
            int width = this.hgc.getWidth();
            int width2 = this.hgk.getWidth();
            int i = width > 0 ? width : this.hgz - this.ds240;
            float f = -(textWidth - i);
            if (this.DEBUG) {
                Log.e(">>>>>>", "1 calculateWidthAndStartAnimator ssb.length:" + spannableStringBuilder.length() + " " + spannableStringBuilder.toString() + " mScreenWidth：" + this.mScreenWidth);
                Log.e(">>>>>>", "2 maxContentLength:" + i + " textWidth:" + textWidth + " desToXValue:" + f + " mBoardCastContentWidth:" + this.hgz + " mLlBoardCastContainerView width:" + width + " mBoardCastFixedContainerViewwidth1: " + width2);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hgb.getLayoutParams();
            if (textWidth < i) {
                layoutParams.width = -2;
                this.hgb.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = textWidth;
                this.hgb.setLayoutParams(layoutParams);
                this.hgt = ObjectAnimator.ofFloat(this.hgb, "translationX", 0.0f, f);
                this.hgt.setDuration(1000L);
                this.hgt.setStartDelay(1000L);
            }
            ObjectAnimator caa = caa();
            ValueAnimator bZZ = bZZ();
            ObjectAnimator bZY = bZY();
            ObjectAnimator cab = cab();
            ObjectAnimator bZX = bZX();
            ObjectAnimator bZW = bZW();
            this.baG = new AnimatorSet();
            this.hgy = new ArrayList();
            this.hgy.add(caa);
            this.hgy.add(bZX);
            this.hgy.add(bZW);
            if (this.hgt != null) {
                this.hgy.add(this.hgt);
            }
            this.hgy.add(cab);
            this.hgy.add(bZZ);
            this.hgy.add(bZY);
            this.baG.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.18
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.Iu();
                    a.this.baG.removeAllListeners();
                    a.this.next();
                }
            });
            this.baG.playTogether(this.hgy);
            this.baG.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        if (this.DEBUG) {
            Log.e(">>>>>>", "1-next:mList.size:" + this.mList.size());
        }
        if (!this.mList.isEmpty()) {
            m mVar = this.mList.get(this.mList.size() - 1);
            if (mVar.aJL > this.hgH) {
                this.aKS = mVar;
                this.hgH = this.aKS.aJL;
                this.hfX = this.aKS.endTime - this.aKS.serverTime;
                bZV();
                a(this.aKS, true);
            }
            this.mList.clear();
        }
    }

    private void bZV() {
        this.hgF = true;
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.19
            @Override // java.lang.Runnable
            public void run() {
                a.this.mHandler.removeCallbacks(a.this.hgG);
                if (a.this.hfX > 1) {
                    a.this.hfX++;
                }
                a.this.mHandler.post(a.this.hgG);
            }
        });
    }

    private ObjectAnimator bZW() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hgd, "alpha", 0.1f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(6700L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.hgd.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.mHandler.removeCallbacks(a.this.hgD);
                a.this.mHandler.post(a.this.hgD);
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bZX() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hgd, "translationX", 0.0f, this.hgd.getWidth());
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.setStartDelay(100L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.hgd.setTranslationX(0.0f);
                a.this.hgd.setVisibility(4);
                a.this.hgB.setVisibility(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                a.this.hgB.setVisibility(0);
                a.this.hgB.playAnimation();
            }
        });
        return ofFloat;
    }

    private ObjectAnimator bZY() {
        if (this.hgx == null) {
            this.hgx = ObjectAnimator.ofFloat(this.hgi, "alpha", 1.0f, 0.0f);
            this.hgx.setDuration(300L);
            this.hgx.setStartDelay(6700L);
        }
        return this.hgx;
    }

    private ValueAnimator bZZ() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.hgj.getMeasuredWidth() - this.hgd.getMeasuredWidth());
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (a.this.hgA.leftMargin < intValue) {
                    a.this.hgA.leftMargin = intValue;
                    a.this.hgj.setLayoutParams(a.this.hgA);
                }
            }
        });
        ofInt.setStartDelay(6000L);
        ofInt.setDuration(1000L);
        return ofInt;
    }

    private ObjectAnimator caa() {
        if (this.hgw == null) {
            this.hgw = ObjectAnimator.ofFloat(this.hgi, "translationX", -this.mScreenWidth, 0.0f);
            this.hgw.setDuration(1000L);
            this.hgw.setInterpolator(new OvershootInterpolator());
            this.hgw.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.bav = true;
                    a.this.hgi.setVisibility(0);
                }
            });
        }
        return this.hgw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator cab() {
        if (this.hgu == null) {
            this.hgu = ObjectAnimator.ofFloat(this.hgp, "translationX", 0.0f, this.hgz);
            this.hgu.setDuration(800L);
            this.hgu.setInterpolator(new AccelerateInterpolator());
            this.hgu.setStartDelay(1000L);
            this.hgu.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    a.this.hgp.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    a.this.hgp.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.this.hgp.setVisibility(8);
                    a.this.mHandler.removeCallbacks(a.this.hgE);
                    a.this.mHandler.postDelayed(a.this.hgE, 1500L);
                }
            });
            this.hgu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                        a.this.hgp.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                    } else {
                        a.this.hgp.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                    }
                }
            });
        } else {
            this.hgp.clearAnimation();
        }
        return this.hgu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator cac() {
        int width;
        if (this.hgs == null) {
            return null;
        }
        if ((this.hgh.getVisibility() == 0 || this.hgg.getVisibility() == 0) && (width = this.hgd.getWidth()) > 0) {
            this.hgs.clearAnimation();
            if (this.hgv == null) {
                this.hgv = ObjectAnimator.ofFloat(this.hgs, "translationX", 0.0f, width);
                this.hgv.setDuration(1000L);
                this.hgv.setInterpolator(new AccelerateInterpolator());
                this.hgv.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.headline.view.a.8
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        a.this.hgs.setVisibility(0);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.hgs.setVisibility(8);
                    }
                });
                this.hgv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.headline.view.a.9
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                            a.this.hgs.setAlpha(valueAnimator.getAnimatedFraction() * 2.0f * 0.8f);
                        } else {
                            a.this.hgs.setAlpha((2.0f - (valueAnimator.getAnimatedFraction() * 2.0f)) * 0.8f);
                        }
                    }
                });
            } else {
                this.hgv.setFloatValues(0.0f, width);
            }
            return this.hgv;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iu() {
        this.bav = false;
        this.hgi.clearAnimation();
        this.hgb.clearAnimation();
        this.hgd.clearAnimation();
        this.hgd.setAlpha(1.0f);
        this.hgb.setAlpha(1.0f);
        this.hgp.clearAnimation();
        this.hgi.setAlpha(1.0f);
        this.hgA.leftMargin = 0;
        this.hgj.setLayoutParams(this.hgA);
        this.hgi.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(final boolean z, boolean z2) {
        this.aVJ = z ? 2 : 1;
        if (z2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.headline.view.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        a.this.hgg.setVisibility(0);
                        a.this.hgh.setVisibility(8);
                        return;
                    }
                    a.this.hgg.setVisibility(8);
                    a.this.hgh.setVisibility(0);
                }
            }, 1000L);
        } else if (z) {
            this.hgg.setVisibility(0);
            this.hgh.setVisibility(8);
        } else {
            this.hgg.setVisibility(8);
            this.hgh.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SY() {
        if (this.aGe != null && this.aGe.aKS != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new j(this.mContext, this.aGe, this.aVJ, this.otherParams, this.hfX)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aGe));
        }
    }

    public void ns(boolean z) {
        this.hga.setVisibility(8);
        if (this.DEBUG) {
            Log.e(">>>>>>", "onCloseEntryView first：" + z);
        }
        this.hgH = 0L;
        this.hfZ = true;
        if (!z) {
            Iu();
            this.mList.clear();
        }
    }

    public void cad() {
        if (this.hga != null && this.hga.getVisibility() != 0) {
            if (this.DEBUG) {
                Log.e(">>>>>>", "setEntryViewVisibility");
            }
            this.hfZ = false;
            this.mHandler.removeCallbacks(this.hgD);
            this.mHandler.post(this.hgD);
            this.hga.setVisibility(0);
        }
    }

    public void b(x xVar, boolean z) {
        m mVar = xVar.aKS;
        mVar.aJS = z;
        this.aGe = xVar;
        this.isHost = xVar.isHost;
        if (mVar.endTime - mVar.serverTime <= 1) {
            this.hgH = mVar.aJJ;
            N(false, false);
        } else {
            if (this.hgH <= 0) {
                this.hgH = mVar.aJL;
            }
            if (this.hgH < mVar.aJL) {
                if (this.aVJ != 1) {
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "3 setData countdownTime:" + this.hfX + " mCurScore:" + this.hgH);
                    }
                    if (!c(mVar)) {
                        this.mList.add(mVar);
                    }
                }
                if (this.bav) {
                    if (!c(mVar)) {
                        this.mList.add(mVar);
                    }
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "2 setData countdownTime:" + this.hfX + " mCurScore:" + this.hgH);
                    }
                } else {
                    if (this.aVJ == 1) {
                        N(true, true);
                    }
                    this.aKS = mVar;
                    this.hgH = mVar.aJL;
                    this.hfX = mVar.endTime - mVar.serverTime;
                    bZV();
                    a(this.aKS, true);
                    if (this.DEBUG) {
                        Log.e(">>>>>>", "1 setData countdownTime:" + this.hfX + " mCurScore:" + this.hgH + "info.endTime:" + mVar.endTime + " info.serverTime:" + mVar.serverTime);
                    }
                }
            } else {
                this.aKS = mVar;
                this.hgH = mVar.aJL;
                if (this.hgH <= mVar.aJJ) {
                    this.hfX = 0L;
                    N(false, false);
                } else {
                    if (this.hfX <= 0) {
                        this.hfX = mVar.endTime - mVar.serverTime;
                    } else {
                        long j = mVar.endTime - mVar.serverTime;
                        if (j < this.hfX && j > 1) {
                            this.hfX = j;
                        }
                    }
                    N(true, true);
                    bZV();
                    a(this.aKS, false);
                }
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913242, this.aGe));
        this.hfZ = false;
    }

    private boolean c(m mVar) {
        if (this.mList.isEmpty()) {
            return false;
        }
        Iterator<m> it = this.mList.iterator();
        while (it.hasNext()) {
            if (it.next().aJL == mVar.aJL) {
                return true;
            }
        }
        return false;
    }

    public void onDestory() {
        this.hgH = 0L;
        this.hfZ = true;
        this.hfX = 0L;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void LE() {
        this.hfX = 0L;
        this.hgH = 0L;
        this.aVJ = 1;
        this.bav = false;
        this.hfZ = true;
        if (this.mList != null) {
            this.mList.clear();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        Iu();
    }

    public SpannableStringBuilder d(m mVar) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            spannableStringBuilder.append((CharSequence) mVar.userName);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFEAAA")), 0, mVar.userName.length(), 33);
            spannableStringBuilder.append((CharSequence) " 送给 ");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) mVar.aJP);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFEAAA")), length, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) (" " + mVar.giftName));
            final int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) "[img]");
            spannableStringBuilder.append((CharSequence) ("X" + mVar.giftNum + "个"));
            BdResourceLoader.getInstance().loadResource(mVar.aJO, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.tieba.ala.headline.view.a.11
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
                        a.this.hgb.setText(spannableStringBuilder);
                        a.this.hgb.forceLayout();
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

    public void el(int i) {
    }
}
