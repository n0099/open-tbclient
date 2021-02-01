package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ab;
import com.baidu.live.data.ah;
import com.baidu.live.data.s;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class c {
    private String aHq;
    private ah aJK;
    private String eue;
    private TbImageView iig;
    private LinearLayout iih;
    private LinearLayout iii;
    private TextView iij;
    private ViewGroup iik;
    private TbImageView iil;
    private TextView iim;
    private int iin;
    private AnimatorSet iio;
    private AnimatorSet iip;
    private AnimatorSet iiq;
    private AnimatorSet iir;
    private ObjectAnimator iis;
    private AnimatorSet iit;
    private int iiu;
    private boolean iiv;
    private boolean iix;
    private long liveId;
    private Context mContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private boolean iiw = true;
    private Runnable iiy = new Runnable() { // from class: com.baidu.tieba.ala.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.iiw) {
                if (c.this.mRootView == null || c.this.mRootView.getParent() != null) {
                    c.this.cpp();
                }
            }
        }
    };

    public c(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = View.inflate(this.mContext, a.g.ala_pk_rank_level_view, null);
        this.iig = (TbImageView) this.mRootView.findViewById(a.f.alaPkLevel);
        this.iik = (ViewGroup) this.mRootView.findViewById(a.f.ll_kingStar_container);
        this.iil = (TbImageView) this.mRootView.findViewById(a.f.kingstar_icon);
        this.iim = (TextView) this.mRootView.findViewById(a.f.kingstar_msg);
        this.iih = (LinearLayout) this.mRootView.findViewById(a.f.alaPkLevelStar);
        this.iii = (LinearLayout) this.mRootView.findViewById(a.f.integralToast);
        this.iij = (TextView) this.mRootView.findViewById(a.f.textInfo);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cB(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(View view) {
        if (!TextUtils.isEmpty(this.aHq)) {
            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
            cVar.url = this.aHq;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void setId(int i) {
        this.mRootView.setId(i);
    }

    public void X(ab abVar) {
        if (abVar != null && abVar.aIF != null && abVar.aIF.aJK != null && !Y(abVar)) {
            cancelAnimation();
            if (abVar.mLiveInfo != null) {
                this.liveId = abVar.mLiveInfo.live_id;
            }
            this.aJK = abVar.aIF.aJK;
            Z(abVar);
            this.eue = abVar.aIF.msg;
            this.iix = abVar.aIF.Cc();
            if (this.iix) {
                this.iiw = false;
                s sVar = abVar.aIF.aJJ;
                if (sVar != null) {
                    this.iil.startLoad(sVar.iconUrl, 10, false);
                    this.iim.setText(sVar.msg);
                    cpn();
                    return;
                }
                cpm();
                cpo();
                return;
            }
            cpm();
            cpo();
            this.iiw = TextUtils.isEmpty(this.eue) ? false : true;
            if (this.iiw) {
                this.mHandler.removeCallbacks(this.iiy);
                this.mHandler.postDelayed(this.iiy, 9000L);
            }
        }
    }

    private boolean Y(ab abVar) {
        return this.aJK != null && abVar.mLiveInfo != null && this.liveId == abVar.mLiveInfo.live_id && this.aJK.aJD == abVar.aIF.aJK.aJD && TextUtils.equals(this.aJK.division, abVar.aIF.aJK.division) && TextUtils.equals(this.eue, abVar.aIF.msg) && this.aJK.maxStar == abVar.aIF.aJK.maxStar && this.iix == abVar.aIF.Cc();
    }

    private void cpm() {
        this.iik.setVisibility(8);
        this.iig.setVisibility(0);
        this.iih.setVisibility(0);
    }

    private void cpn() {
        this.iik.setVisibility(0);
        this.iig.setVisibility(4);
        this.iii.setVisibility(4);
        this.iih.setVisibility(4);
    }

    private void Z(ab abVar) {
        long j;
        long j2;
        long j3;
        if (abVar.mLiveInfo == null || abVar.aId == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
        } else {
            long j4 = abVar.aId.userId;
            long j5 = abVar.mLiveInfo.room_id;
            j = abVar.mLiveInfo.live_id;
            j2 = j5;
            j3 = j4;
        }
        long j6 = abVar.aIz != null ? abVar.aIz.userId : 0L;
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)));
        this.aHq = com.baidu.live.utils.b.a(1, abVar.aIF.aHq, abVar.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(j6)), ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)), String.valueOf(j2), String.valueOf(j), hashMap);
    }

    private void cpo() {
        if (this.aJK != null && !TextUtils.isEmpty(this.aJK.division) && this.aJK.aJD > 0 && this.aJK.maxStar > 0) {
            int i = this.aJK.maxStar - this.aJK.aJD;
            this.iig.startLoad(this.aJK.iconUrl, 10, false);
            bY(this.aJK.aJD, i);
        }
    }

    private void bY(int i, int i2) {
        int i3;
        int i4;
        if (this.iih != null && this.iii != null) {
            this.iih.removeAllViews();
            this.iih.setVisibility(0);
            this.iii.setVisibility(4);
            if (i + i2 <= 4) {
                i4 = a.d.sdk_ds5;
                i3 = a.d.sdk_ds28;
            } else {
                i3 = a.d.sdk_ds22;
                i4 = a.d.sdk_ds3;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.mContext, i3), BdUtilHelper.getDimens(this.mContext, i3));
            layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, i4);
            layoutParams.gravity = 16;
            for (int i5 = 0; i5 < i; i5++) {
                this.iih.addView(getSolidStarView(), layoutParams);
            }
            for (int i6 = 0; i6 < i2; i6++) {
                this.iih.addView(getBlankStarView(), layoutParams);
            }
            this.iij.setText(this.eue);
            this.iiu = BdUtilHelper.getTextWidth(this.iij.getPaint(), this.eue);
            ViewGroup.LayoutParams layoutParams2 = this.iij.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = this.iiu;
                this.iij.setLayoutParams(layoutParams2);
            }
            this.iij.setTranslationX(0.0f);
            this.iih.setTranslationY(0.0f);
            this.iii.setTranslationY(0.0f);
            this.iih.setAlpha(1.0f);
            this.iih.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpp() {
        this.iiv = true;
        cpv();
        cpw();
        cpu();
        cps();
        cpr();
        this.iit = new AnimatorSet();
        this.iit.play(this.iiq).before(this.iir);
        this.iit.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.iit.removeAllListeners();
                c.this.iit.cancel();
                c.this.cpq();
            }
        });
        this.iit.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpq() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.iiv && c.this.iis != null) {
                    c.this.iis.start();
                }
            }
        }, 300L);
    }

    private void cpr() {
        if (this.iip == null) {
            this.iip = cD(this.iih);
            this.iip.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.iih.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (c.this.iiv) {
                        c.this.iiv = false;
                        c.this.mHandler.postDelayed(c.this.iiy, 9000L);
                    }
                }
            });
        }
    }

    private void cps() {
        if (this.iii != null && this.iio == null) {
            this.iio = cC(this.iii);
            this.iio.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.iii.setVisibility(4);
                    c.this.iij.setTranslationX(0.0f);
                    c.this.cpt();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpt() {
        if (this.iiv && this.iip != null) {
            this.iip.start();
        }
    }

    private void cpu() {
        if (this.iii != null) {
            this.iin = this.iii.getWidth();
            this.iis = ObjectAnimator.ofFloat(this.iij, "translationX", 0.0f, -(this.iiu - this.iin));
            this.iis.setDuration(IMConnection.RETRY_DELAY_TIMES);
            this.iis.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.cpx();
                }
            });
        }
    }

    private void cpv() {
        if (this.iiq == null) {
            this.iiq = cC(this.iih);
        }
    }

    private void cpw() {
        if (this.iir == null) {
            this.iir = cD(this.iii);
            this.iir.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.iii.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpx() {
        if (this.iiv) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.iiv && c.this.iio != null) {
                        c.this.iio.start();
                    }
                }
            }, 7000L);
        }
    }

    private AnimatorSet cC(final View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds12));
        ofFloat.setDuration(625L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(625L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(4);
                view.setAlpha(1.0f);
                view.setTranslationY(0.0f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cD(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds12), 0.0f);
        ofFloat.setDuration(625L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(625L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        return animatorSet;
    }

    public View getView() {
        return this.mRootView;
    }

    private View getSolidStarView() {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setImageResource(a.e.ala_icon_five_pointed_star);
        return imageView;
    }

    private View getBlankStarView() {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setImageResource(a.e.ala_icon_blank_five_pointed_star);
        return imageView;
    }

    private void cancelAnimation() {
        if (this.iiv) {
            this.iiv = false;
            if (this.iio != null) {
                this.iio.cancel();
            }
            if (this.iip != null) {
                this.iip.cancel();
            }
            if (this.iiq != null) {
                this.iiq.cancel();
            }
            if (this.iir != null) {
                this.iir.cancel();
            }
            if (this.iis != null) {
                this.iis.cancel();
            }
            if (this.iit != null) {
                this.iit.cancel();
            }
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void xh() {
        this.aJK = null;
        this.liveId = 0L;
        cancelAnimation();
    }

    public void onDestroy() {
        cancelAnimation();
    }
}
