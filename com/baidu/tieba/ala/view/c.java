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
    private String aIk;
    private ab aKn;
    private String ehI;
    private TbImageView hKQ;
    private LinearLayout hKR;
    private LinearLayout hKS;
    private TextView hKT;
    private ViewGroup hKU;
    private TbImageView hKV;
    private TextView hKW;
    private int hKX;
    private AnimatorSet hKY;
    private AnimatorSet hKZ;
    private AnimatorSet hLa;
    private AnimatorSet hLb;
    private ObjectAnimator hLc;
    private AnimatorSet hLd;
    private int hLe;
    private boolean hLf;
    private boolean hLh;
    private long liveId;
    private Context mContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private boolean hLg = true;
    private Runnable hLi = new Runnable() { // from class: com.baidu.tieba.ala.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.hLg) {
                if (c.this.mRootView == null || c.this.mRootView.getParent() != null) {
                    c.this.clz();
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
        this.hKQ = (TbImageView) this.mRootView.findViewById(a.f.alaPkLevel);
        this.hKU = (ViewGroup) this.mRootView.findViewById(a.f.ll_kingStar_container);
        this.hKV = (TbImageView) this.mRootView.findViewById(a.f.kingstar_icon);
        this.hKW = (TextView) this.mRootView.findViewById(a.f.kingstar_msg);
        this.hKR = (LinearLayout) this.mRootView.findViewById(a.f.alaPkLevelStar);
        this.hKS = (LinearLayout) this.mRootView.findViewById(a.f.integralToast);
        this.hKT = (TextView) this.mRootView.findViewById(a.f.textInfo);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cl(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(View view) {
        if (!TextUtils.isEmpty(this.aIk)) {
            com.baidu.live.ak.c cVar = new com.baidu.live.ak.c();
            cVar.url = this.aIk;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void setId(int i) {
        this.mRootView.setId(i);
    }

    public void O(w wVar) {
        if (wVar != null && wVar.aJx != null && wVar.aJx.aKn != null && !P(wVar)) {
            cancelAnimation();
            if (wVar.mLiveInfo != null) {
                this.liveId = wVar.mLiveInfo.live_id;
            }
            this.aKn = wVar.aJx.aKn;
            Q(wVar);
            this.ehI = wVar.aJx.msg;
            this.hLh = wVar.aJx.Es();
            if (this.hLh) {
                this.hLg = false;
                n nVar = wVar.aJx.aKm;
                if (nVar != null) {
                    this.hKV.startLoad(nVar.iconUrl, 10, false);
                    this.hKW.setText(nVar.msg);
                    clx();
                    return;
                }
                clw();
                cly();
                return;
            }
            clw();
            cly();
            this.hLg = TextUtils.isEmpty(this.ehI) ? false : true;
            if (this.hLg) {
                this.mHandler.removeCallbacks(this.hLi);
                this.mHandler.postDelayed(this.hLi, 9000L);
            }
        }
    }

    private boolean P(w wVar) {
        return this.aKn != null && wVar.mLiveInfo != null && this.liveId == wVar.mLiveInfo.live_id && this.aKn.aKg == wVar.aJx.aKn.aKg && TextUtils.equals(this.aKn.division, wVar.aJx.aKn.division) && TextUtils.equals(this.ehI, wVar.aJx.msg) && this.aKn.maxStar == wVar.aJx.aKn.maxStar && this.hLh == wVar.aJx.Es();
    }

    private void clw() {
        this.hKU.setVisibility(8);
        this.hKQ.setVisibility(0);
        this.hKR.setVisibility(0);
    }

    private void clx() {
        this.hKU.setVisibility(0);
        this.hKQ.setVisibility(4);
        this.hKS.setVisibility(4);
        this.hKR.setVisibility(4);
    }

    private void Q(w wVar) {
        long j;
        long j2;
        long j3;
        if (wVar.mLiveInfo == null || wVar.aIV == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
        } else {
            long j4 = wVar.aIV.userId;
            long j5 = wVar.mLiveInfo.room_id;
            j = wVar.mLiveInfo.live_id;
            j2 = j5;
            j3 = j4;
        }
        long j6 = wVar.aJr != null ? wVar.aJr.userId : 0L;
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)));
        this.aIk = com.baidu.live.utils.b.a(1, wVar.aJx.aIk, wVar.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(j6)), ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)), String.valueOf(j2), String.valueOf(j), hashMap);
    }

    private void cly() {
        if (this.aKn != null && !TextUtils.isEmpty(this.aKn.division) && this.aKn.aKg > 0 && this.aKn.maxStar > 0) {
            int i = this.aKn.maxStar - this.aKn.aKg;
            this.hKQ.startLoad(this.aKn.iconUrl, 10, false);
            bW(this.aKn.aKg, i);
        }
    }

    private void bW(int i, int i2) {
        int i3;
        int i4;
        if (this.hKR != null && this.hKS != null) {
            this.hKR.removeAllViews();
            this.hKR.setVisibility(0);
            this.hKS.setVisibility(4);
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
                this.hKR.addView(getSolidStarView(), layoutParams);
            }
            for (int i6 = 0; i6 < i2; i6++) {
                this.hKR.addView(getBlankStarView(), layoutParams);
            }
            this.hKT.setText(this.ehI);
            this.hLe = BdUtilHelper.getTextWidth(this.hKT.getPaint(), this.ehI);
            ViewGroup.LayoutParams layoutParams2 = this.hKT.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = this.hLe;
                this.hKT.setLayoutParams(layoutParams2);
            }
            this.hKT.setTranslationX(0.0f);
            this.hKR.setTranslationY(0.0f);
            this.hKS.setTranslationY(0.0f);
            this.hKR.setAlpha(1.0f);
            this.hKR.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clz() {
        this.hLf = true;
        clF();
        clG();
        clE();
        clC();
        clB();
        this.hLd = new AnimatorSet();
        this.hLd.play(this.hLa).before(this.hLb);
        this.hLd.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.hLd.removeAllListeners();
                c.this.hLd.cancel();
                c.this.clA();
            }
        });
        this.hLd.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clA() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.hLf && c.this.hLc != null) {
                    c.this.hLc.start();
                }
            }
        }, 300L);
    }

    private void clB() {
        if (this.hKZ == null) {
            this.hKZ = cn(this.hKR);
            this.hKZ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.hKR.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (c.this.hLf) {
                        c.this.hLf = false;
                        c.this.mHandler.postDelayed(c.this.hLi, 9000L);
                    }
                }
            });
        }
    }

    private void clC() {
        if (this.hKS != null && this.hKY == null) {
            this.hKY = cm(this.hKS);
            this.hKY.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.hKS.setVisibility(4);
                    c.this.hKT.setTranslationX(0.0f);
                    c.this.clD();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clD() {
        if (this.hLf && this.hKZ != null) {
            this.hKZ.start();
        }
    }

    private void clE() {
        if (this.hKS != null) {
            this.hKX = this.hKS.getWidth();
            this.hLc = ObjectAnimator.ofFloat(this.hKT, "translationX", 0.0f, -(this.hLe - this.hKX));
            this.hLc.setDuration(IMConnection.RETRY_DELAY_TIMES);
            this.hLc.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.clH();
                }
            });
        }
    }

    private void clF() {
        if (this.hLa == null) {
            this.hLa = cm(this.hKR);
        }
    }

    private void clG() {
        if (this.hLb == null) {
            this.hLb = cn(this.hKS);
            this.hLb.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.hKS.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clH() {
        if (this.hLf) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hLf && c.this.hKY != null) {
                        c.this.hKY.start();
                    }
                }
            }, 7000L);
        }
    }

    private AnimatorSet cm(final View view) {
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

    private AnimatorSet cn(View view) {
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
        if (this.hLf) {
            this.hLf = false;
            if (this.hKY != null) {
                this.hKY.cancel();
            }
            if (this.hKZ != null) {
                this.hKZ.cancel();
            }
            if (this.hLa != null) {
                this.hLa.cancel();
            }
            if (this.hLb != null) {
                this.hLb.cancel();
            }
            if (this.hLc != null) {
                this.hLc.cancel();
            }
            if (this.hLd != null) {
                this.hLd.cancel();
            }
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void KJ() {
        this.aKn = null;
        this.liveId = 0L;
        cancelAnimation();
    }

    public void onDestroy() {
        cancelAnimation();
    }
}
