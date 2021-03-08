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
/* loaded from: classes10.dex */
public class c {
    private String aIQ;
    private ah aLk;
    private String evF;
    private TbImageView ikd;
    private LinearLayout ike;
    private LinearLayout ikf;
    private TextView ikg;
    private ViewGroup ikh;
    private TbImageView iki;
    private TextView ikj;
    private int ikk;
    private AnimatorSet ikl;
    private AnimatorSet ikm;
    private AnimatorSet ikn;
    private AnimatorSet iko;
    private ObjectAnimator ikp;
    private AnimatorSet ikq;
    private int ikr;
    private boolean iks;
    private boolean iku;
    private long liveId;
    private Context mContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private boolean ikt = true;
    private Runnable ikv = new Runnable() { // from class: com.baidu.tieba.ala.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.ikt) {
                if (c.this.mRootView == null || c.this.mRootView.getParent() != null) {
                    c.this.cpC();
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
        this.ikd = (TbImageView) this.mRootView.findViewById(a.f.alaPkLevel);
        this.ikh = (ViewGroup) this.mRootView.findViewById(a.f.ll_kingStar_container);
        this.iki = (TbImageView) this.mRootView.findViewById(a.f.kingstar_icon);
        this.ikj = (TextView) this.mRootView.findViewById(a.f.kingstar_msg);
        this.ike = (LinearLayout) this.mRootView.findViewById(a.f.alaPkLevelStar);
        this.ikf = (LinearLayout) this.mRootView.findViewById(a.f.integralToast);
        this.ikg = (TextView) this.mRootView.findViewById(a.f.textInfo);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cB(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(View view) {
        if (!TextUtils.isEmpty(this.aIQ)) {
            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
            cVar.url = this.aIQ;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void setId(int i) {
        this.mRootView.setId(i);
    }

    public void X(ab abVar) {
        if (abVar != null && abVar.aKf != null && abVar.aKf.aLk != null && !Y(abVar)) {
            cancelAnimation();
            if (abVar.mLiveInfo != null) {
                this.liveId = abVar.mLiveInfo.live_id;
            }
            this.aLk = abVar.aKf.aLk;
            Z(abVar);
            this.evF = abVar.aKf.msg;
            this.iku = abVar.aKf.Cf();
            if (this.iku) {
                this.ikt = false;
                s sVar = abVar.aKf.aLj;
                if (sVar != null) {
                    this.iki.startLoad(sVar.iconUrl, 10, false);
                    this.ikj.setText(sVar.msg);
                    cpA();
                    return;
                }
                cpz();
                cpB();
                return;
            }
            cpz();
            cpB();
            this.ikt = TextUtils.isEmpty(this.evF) ? false : true;
            if (this.ikt) {
                this.mHandler.removeCallbacks(this.ikv);
                this.mHandler.postDelayed(this.ikv, 9000L);
            }
        }
    }

    private boolean Y(ab abVar) {
        return this.aLk != null && abVar.mLiveInfo != null && this.liveId == abVar.mLiveInfo.live_id && this.aLk.aLd == abVar.aKf.aLk.aLd && TextUtils.equals(this.aLk.division, abVar.aKf.aLk.division) && TextUtils.equals(this.evF, abVar.aKf.msg) && this.aLk.maxStar == abVar.aKf.aLk.maxStar && this.iku == abVar.aKf.Cf();
    }

    private void cpz() {
        this.ikh.setVisibility(8);
        this.ikd.setVisibility(0);
        this.ike.setVisibility(0);
    }

    private void cpA() {
        this.ikh.setVisibility(0);
        this.ikd.setVisibility(4);
        this.ikf.setVisibility(4);
        this.ike.setVisibility(4);
    }

    private void Z(ab abVar) {
        long j;
        long j2;
        long j3;
        if (abVar.mLiveInfo == null || abVar.aJD == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
        } else {
            long j4 = abVar.aJD.userId;
            long j5 = abVar.mLiveInfo.room_id;
            j = abVar.mLiveInfo.live_id;
            j2 = j5;
            j3 = j4;
        }
        long j6 = abVar.aJZ != null ? abVar.aJZ.userId : 0L;
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)));
        this.aIQ = com.baidu.live.utils.b.a(1, abVar.aKf.aIQ, abVar.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(j6)), ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)), String.valueOf(j2), String.valueOf(j), hashMap);
    }

    private void cpB() {
        if (this.aLk != null && !TextUtils.isEmpty(this.aLk.division) && this.aLk.aLd > 0 && this.aLk.maxStar > 0) {
            int i = this.aLk.maxStar - this.aLk.aLd;
            this.ikd.startLoad(this.aLk.iconUrl, 10, false);
            bZ(this.aLk.aLd, i);
        }
    }

    private void bZ(int i, int i2) {
        int i3;
        int i4;
        if (this.ike != null && this.ikf != null) {
            this.ike.removeAllViews();
            this.ike.setVisibility(0);
            this.ikf.setVisibility(4);
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
                this.ike.addView(getSolidStarView(), layoutParams);
            }
            for (int i6 = 0; i6 < i2; i6++) {
                this.ike.addView(getBlankStarView(), layoutParams);
            }
            this.ikg.setText(this.evF);
            this.ikr = BdUtilHelper.getTextWidth(this.ikg.getPaint(), this.evF);
            ViewGroup.LayoutParams layoutParams2 = this.ikg.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = this.ikr;
                this.ikg.setLayoutParams(layoutParams2);
            }
            this.ikg.setTranslationX(0.0f);
            this.ike.setTranslationY(0.0f);
            this.ikf.setTranslationY(0.0f);
            this.ike.setAlpha(1.0f);
            this.ike.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpC() {
        this.iks = true;
        cpI();
        cpJ();
        cpH();
        cpF();
        cpE();
        this.ikq = new AnimatorSet();
        this.ikq.play(this.ikn).before(this.iko);
        this.ikq.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.ikq.removeAllListeners();
                c.this.ikq.cancel();
                c.this.cpD();
            }
        });
        this.ikq.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpD() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.iks && c.this.ikp != null) {
                    c.this.ikp.start();
                }
            }
        }, 300L);
    }

    private void cpE() {
        if (this.ikm == null) {
            this.ikm = cD(this.ike);
            this.ikm.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.ike.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (c.this.iks) {
                        c.this.iks = false;
                        c.this.mHandler.postDelayed(c.this.ikv, 9000L);
                    }
                }
            });
        }
    }

    private void cpF() {
        if (this.ikf != null && this.ikl == null) {
            this.ikl = cC(this.ikf);
            this.ikl.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.ikf.setVisibility(4);
                    c.this.ikg.setTranslationX(0.0f);
                    c.this.cpG();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpG() {
        if (this.iks && this.ikm != null) {
            this.ikm.start();
        }
    }

    private void cpH() {
        if (this.ikf != null) {
            this.ikk = this.ikf.getWidth();
            this.ikp = ObjectAnimator.ofFloat(this.ikg, "translationX", 0.0f, -(this.ikr - this.ikk));
            this.ikp.setDuration(IMConnection.RETRY_DELAY_TIMES);
            this.ikp.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.cpK();
                }
            });
        }
    }

    private void cpI() {
        if (this.ikn == null) {
            this.ikn = cC(this.ike);
        }
    }

    private void cpJ() {
        if (this.iko == null) {
            this.iko = cD(this.ikf);
            this.iko.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.ikf.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpK() {
        if (this.iks) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.iks && c.this.ikl != null) {
                        c.this.ikl.start();
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
        if (this.iks) {
            this.iks = false;
            if (this.ikl != null) {
                this.ikl.cancel();
            }
            if (this.ikm != null) {
                this.ikm.cancel();
            }
            if (this.ikn != null) {
                this.ikn.cancel();
            }
            if (this.iko != null) {
                this.iko.cancel();
            }
            if (this.ikp != null) {
                this.ikp.cancel();
            }
            if (this.ikq != null) {
                this.ikq.cancel();
            }
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void xk() {
        this.aLk = null;
        this.liveId = 0L;
        cancelAnimation();
    }

    public void onDestroy() {
        cancelAnimation();
    }
}
