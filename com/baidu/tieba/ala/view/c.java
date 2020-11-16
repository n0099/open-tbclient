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
import com.baidu.live.data.n;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class c {
    private String aGz;
    private ab aIC;
    private String ega;
    private TextView hKA;
    private ViewGroup hKB;
    private TbImageView hKC;
    private TextView hKD;
    private int hKE;
    private AnimatorSet hKF;
    private AnimatorSet hKG;
    private AnimatorSet hKH;
    private AnimatorSet hKI;
    private ObjectAnimator hKJ;
    private AnimatorSet hKK;
    private int hKL;
    private boolean hKM;
    private boolean hKO;
    private TbImageView hKx;
    private LinearLayout hKy;
    private LinearLayout hKz;
    private long liveId;
    private Context mContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private boolean hKN = true;
    private Runnable hKP = new Runnable() { // from class: com.baidu.tieba.ala.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.hKN) {
                if (c.this.mRootView == null || c.this.mRootView.getParent() != null) {
                    c.this.ckS();
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
        this.hKx = (TbImageView) this.mRootView.findViewById(a.f.alaPkLevel);
        this.hKB = (ViewGroup) this.mRootView.findViewById(a.f.ll_kingStar_container);
        this.hKC = (TbImageView) this.mRootView.findViewById(a.f.kingstar_icon);
        this.hKD = (TextView) this.mRootView.findViewById(a.f.kingstar_msg);
        this.hKy = (LinearLayout) this.mRootView.findViewById(a.f.alaPkLevelStar);
        this.hKz = (LinearLayout) this.mRootView.findViewById(a.f.integralToast);
        this.hKA = (TextView) this.mRootView.findViewById(a.f.textInfo);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.co(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(View view) {
        if (!TextUtils.isEmpty(this.aGz)) {
            com.baidu.live.ak.c cVar = new com.baidu.live.ak.c();
            cVar.url = this.aGz;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void setId(int i) {
        this.mRootView.setId(i);
    }

    public void O(w wVar) {
        if (wVar != null && wVar.aHM != null && wVar.aHM.aIC != null && !P(wVar)) {
            cancelAnimation();
            if (wVar.mLiveInfo != null) {
                this.liveId = wVar.mLiveInfo.live_id;
            }
            this.aIC = wVar.aHM.aIC;
            Q(wVar);
            this.ega = wVar.aHM.msg;
            this.hKO = wVar.aHM.DJ();
            if (this.hKO) {
                this.hKN = false;
                n nVar = wVar.aHM.aIB;
                if (nVar != null) {
                    this.hKC.startLoad(nVar.iconUrl, 10, false);
                    this.hKD.setText(nVar.msg);
                    ckQ();
                    return;
                }
                ckP();
                ckR();
                return;
            }
            ckP();
            ckR();
            this.hKN = TextUtils.isEmpty(this.ega) ? false : true;
            if (this.hKN) {
                this.mHandler.removeCallbacks(this.hKP);
                this.mHandler.postDelayed(this.hKP, 9000L);
            }
        }
    }

    private boolean P(w wVar) {
        return this.aIC != null && wVar.mLiveInfo != null && this.liveId == wVar.mLiveInfo.live_id && this.aIC.aIv == wVar.aHM.aIC.aIv && TextUtils.equals(this.aIC.division, wVar.aHM.aIC.division) && TextUtils.equals(this.ega, wVar.aHM.msg) && this.aIC.maxStar == wVar.aHM.aIC.maxStar && this.hKO == wVar.aHM.DJ();
    }

    private void ckP() {
        this.hKB.setVisibility(8);
        this.hKx.setVisibility(0);
        this.hKy.setVisibility(0);
    }

    private void ckQ() {
        this.hKB.setVisibility(0);
        this.hKx.setVisibility(4);
        this.hKz.setVisibility(4);
        this.hKy.setVisibility(4);
    }

    private void Q(w wVar) {
        long j;
        long j2;
        long j3;
        if (wVar.mLiveInfo == null || wVar.aHk == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
        } else {
            long j4 = wVar.aHk.userId;
            long j5 = wVar.mLiveInfo.room_id;
            j = wVar.mLiveInfo.live_id;
            j2 = j5;
            j3 = j4;
        }
        long j6 = wVar.aHG != null ? wVar.aHG.userId : 0L;
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)));
        this.aGz = com.baidu.live.utils.b.a(1, wVar.aHM.aGz, wVar.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(j6)), ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)), String.valueOf(j2), String.valueOf(j), hashMap);
    }

    private void ckR() {
        if (this.aIC != null && !TextUtils.isEmpty(this.aIC.division) && this.aIC.aIv > 0 && this.aIC.maxStar > 0) {
            int i = this.aIC.maxStar - this.aIC.aIv;
            this.hKx.startLoad(this.aIC.iconUrl, 10, false);
            bW(this.aIC.aIv, i);
        }
    }

    private void bW(int i, int i2) {
        int i3;
        int i4;
        if (this.hKy != null && this.hKz != null) {
            this.hKy.removeAllViews();
            this.hKy.setVisibility(0);
            this.hKz.setVisibility(4);
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
                this.hKy.addView(getSolidStarView(), layoutParams);
            }
            for (int i6 = 0; i6 < i2; i6++) {
                this.hKy.addView(getBlankStarView(), layoutParams);
            }
            this.hKA.setText(this.ega);
            this.hKL = BdUtilHelper.getTextWidth(this.hKA.getPaint(), this.ega);
            ViewGroup.LayoutParams layoutParams2 = this.hKA.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = this.hKL;
                this.hKA.setLayoutParams(layoutParams2);
            }
            this.hKA.setTranslationX(0.0f);
            this.hKy.setTranslationY(0.0f);
            this.hKz.setTranslationY(0.0f);
            this.hKy.setAlpha(1.0f);
            this.hKy.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckS() {
        this.hKM = true;
        ckY();
        ckZ();
        ckX();
        ckV();
        ckU();
        this.hKK = new AnimatorSet();
        this.hKK.play(this.hKH).before(this.hKI);
        this.hKK.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.hKK.removeAllListeners();
                c.this.hKK.cancel();
                c.this.ckT();
            }
        });
        this.hKK.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckT() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.hKM && c.this.hKJ != null) {
                    c.this.hKJ.start();
                }
            }
        }, 300L);
    }

    private void ckU() {
        if (this.hKG == null) {
            this.hKG = cq(this.hKy);
            this.hKG.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.hKy.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (c.this.hKM) {
                        c.this.hKM = false;
                        c.this.mHandler.postDelayed(c.this.hKP, 9000L);
                    }
                }
            });
        }
    }

    private void ckV() {
        if (this.hKz != null && this.hKF == null) {
            this.hKF = cp(this.hKz);
            this.hKF.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.hKz.setVisibility(4);
                    c.this.hKA.setTranslationX(0.0f);
                    c.this.ckW();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckW() {
        if (this.hKM && this.hKG != null) {
            this.hKG.start();
        }
    }

    private void ckX() {
        if (this.hKz != null) {
            this.hKE = this.hKz.getWidth();
            this.hKJ = ObjectAnimator.ofFloat(this.hKA, "translationX", 0.0f, -(this.hKL - this.hKE));
            this.hKJ.setDuration(IMConnection.RETRY_DELAY_TIMES);
            this.hKJ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.cla();
                }
            });
        }
    }

    private void ckY() {
        if (this.hKH == null) {
            this.hKH = cp(this.hKy);
        }
    }

    private void ckZ() {
        if (this.hKI == null) {
            this.hKI = cq(this.hKz);
            this.hKI.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.hKz.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cla() {
        if (this.hKM) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hKM && c.this.hKF != null) {
                        c.this.hKF.start();
                    }
                }
            }, 7000L);
        }
    }

    private AnimatorSet cp(final View view) {
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

    private AnimatorSet cq(View view) {
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
        if (this.hKM) {
            this.hKM = false;
            if (this.hKF != null) {
                this.hKF.cancel();
            }
            if (this.hKG != null) {
                this.hKG.cancel();
            }
            if (this.hKH != null) {
                this.hKH.cancel();
            }
            if (this.hKI != null) {
                this.hKI.cancel();
            }
            if (this.hKJ != null) {
                this.hKJ.cancel();
            }
            if (this.hKK != null) {
                this.hKK.cancel();
            }
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void Ka() {
        this.aIC = null;
        this.liveId = 0L;
        cancelAnimation();
    }

    public void onDestroy() {
        cancelAnimation();
    }
}
