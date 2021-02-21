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
    private TextView iiA;
    private int iiB;
    private AnimatorSet iiC;
    private AnimatorSet iiD;
    private AnimatorSet iiE;
    private AnimatorSet iiF;
    private ObjectAnimator iiG;
    private AnimatorSet iiH;
    private int iiI;
    private boolean iiJ;
    private boolean iiL;
    private TbImageView iiu;
    private LinearLayout iiv;
    private LinearLayout iiw;
    private TextView iix;
    private ViewGroup iiy;
    private TbImageView iiz;
    private long liveId;
    private Context mContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private boolean iiK = true;
    private Runnable iiM = new Runnable() { // from class: com.baidu.tieba.ala.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.iiK) {
                if (c.this.mRootView == null || c.this.mRootView.getParent() != null) {
                    c.this.cpw();
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
        this.iiu = (TbImageView) this.mRootView.findViewById(a.f.alaPkLevel);
        this.iiy = (ViewGroup) this.mRootView.findViewById(a.f.ll_kingStar_container);
        this.iiz = (TbImageView) this.mRootView.findViewById(a.f.kingstar_icon);
        this.iiA = (TextView) this.mRootView.findViewById(a.f.kingstar_msg);
        this.iiv = (LinearLayout) this.mRootView.findViewById(a.f.alaPkLevelStar);
        this.iiw = (LinearLayout) this.mRootView.findViewById(a.f.integralToast);
        this.iix = (TextView) this.mRootView.findViewById(a.f.textInfo);
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
            this.iiL = abVar.aIF.Cc();
            if (this.iiL) {
                this.iiK = false;
                s sVar = abVar.aIF.aJJ;
                if (sVar != null) {
                    this.iiz.startLoad(sVar.iconUrl, 10, false);
                    this.iiA.setText(sVar.msg);
                    cpu();
                    return;
                }
                cpt();
                cpv();
                return;
            }
            cpt();
            cpv();
            this.iiK = TextUtils.isEmpty(this.eue) ? false : true;
            if (this.iiK) {
                this.mHandler.removeCallbacks(this.iiM);
                this.mHandler.postDelayed(this.iiM, 9000L);
            }
        }
    }

    private boolean Y(ab abVar) {
        return this.aJK != null && abVar.mLiveInfo != null && this.liveId == abVar.mLiveInfo.live_id && this.aJK.aJD == abVar.aIF.aJK.aJD && TextUtils.equals(this.aJK.division, abVar.aIF.aJK.division) && TextUtils.equals(this.eue, abVar.aIF.msg) && this.aJK.maxStar == abVar.aIF.aJK.maxStar && this.iiL == abVar.aIF.Cc();
    }

    private void cpt() {
        this.iiy.setVisibility(8);
        this.iiu.setVisibility(0);
        this.iiv.setVisibility(0);
    }

    private void cpu() {
        this.iiy.setVisibility(0);
        this.iiu.setVisibility(4);
        this.iiw.setVisibility(4);
        this.iiv.setVisibility(4);
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

    private void cpv() {
        if (this.aJK != null && !TextUtils.isEmpty(this.aJK.division) && this.aJK.aJD > 0 && this.aJK.maxStar > 0) {
            int i = this.aJK.maxStar - this.aJK.aJD;
            this.iiu.startLoad(this.aJK.iconUrl, 10, false);
            bZ(this.aJK.aJD, i);
        }
    }

    private void bZ(int i, int i2) {
        int i3;
        int i4;
        if (this.iiv != null && this.iiw != null) {
            this.iiv.removeAllViews();
            this.iiv.setVisibility(0);
            this.iiw.setVisibility(4);
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
                this.iiv.addView(getSolidStarView(), layoutParams);
            }
            for (int i6 = 0; i6 < i2; i6++) {
                this.iiv.addView(getBlankStarView(), layoutParams);
            }
            this.iix.setText(this.eue);
            this.iiI = BdUtilHelper.getTextWidth(this.iix.getPaint(), this.eue);
            ViewGroup.LayoutParams layoutParams2 = this.iix.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = this.iiI;
                this.iix.setLayoutParams(layoutParams2);
            }
            this.iix.setTranslationX(0.0f);
            this.iiv.setTranslationY(0.0f);
            this.iiw.setTranslationY(0.0f);
            this.iiv.setAlpha(1.0f);
            this.iiv.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpw() {
        this.iiJ = true;
        cpC();
        cpD();
        cpB();
        cpz();
        cpy();
        this.iiH = new AnimatorSet();
        this.iiH.play(this.iiE).before(this.iiF);
        this.iiH.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.iiH.removeAllListeners();
                c.this.iiH.cancel();
                c.this.cpx();
            }
        });
        this.iiH.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpx() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.iiJ && c.this.iiG != null) {
                    c.this.iiG.start();
                }
            }
        }, 300L);
    }

    private void cpy() {
        if (this.iiD == null) {
            this.iiD = cD(this.iiv);
            this.iiD.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.iiv.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (c.this.iiJ) {
                        c.this.iiJ = false;
                        c.this.mHandler.postDelayed(c.this.iiM, 9000L);
                    }
                }
            });
        }
    }

    private void cpz() {
        if (this.iiw != null && this.iiC == null) {
            this.iiC = cC(this.iiw);
            this.iiC.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.iiw.setVisibility(4);
                    c.this.iix.setTranslationX(0.0f);
                    c.this.cpA();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpA() {
        if (this.iiJ && this.iiD != null) {
            this.iiD.start();
        }
    }

    private void cpB() {
        if (this.iiw != null) {
            this.iiB = this.iiw.getWidth();
            this.iiG = ObjectAnimator.ofFloat(this.iix, "translationX", 0.0f, -(this.iiI - this.iiB));
            this.iiG.setDuration(IMConnection.RETRY_DELAY_TIMES);
            this.iiG.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.cpE();
                }
            });
        }
    }

    private void cpC() {
        if (this.iiE == null) {
            this.iiE = cC(this.iiv);
        }
    }

    private void cpD() {
        if (this.iiF == null) {
            this.iiF = cD(this.iiw);
            this.iiF.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.iiw.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpE() {
        if (this.iiJ) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.iiJ && c.this.iiC != null) {
                        c.this.iiC.start();
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
        if (this.iiJ) {
            this.iiJ = false;
            if (this.iiC != null) {
                this.iiC.cancel();
            }
            if (this.iiD != null) {
                this.iiD.cancel();
            }
            if (this.iiE != null) {
                this.iiE.cancel();
            }
            if (this.iiF != null) {
                this.iiF.cancel();
            }
            if (this.iiG != null) {
                this.iiG.cancel();
            }
            if (this.iiH != null) {
                this.iiH.cancel();
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
