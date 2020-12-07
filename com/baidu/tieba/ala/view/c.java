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
import com.baidu.live.data.ac;
import com.baidu.live.data.n;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class c {
    private String aJj;
    private ac aLr;
    private String enb;
    private AnimatorSet hVA;
    private AnimatorSet hVB;
    private AnimatorSet hVC;
    private ObjectAnimator hVD;
    private AnimatorSet hVE;
    private int hVF;
    private boolean hVG;
    private boolean hVI;
    private TbImageView hVr;
    private LinearLayout hVs;
    private LinearLayout hVt;
    private TextView hVu;
    private ViewGroup hVv;
    private TbImageView hVw;
    private TextView hVx;
    private int hVy;
    private AnimatorSet hVz;
    private long liveId;
    private Context mContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private boolean hVH = true;
    private Runnable hVJ = new Runnable() { // from class: com.baidu.tieba.ala.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.hVH) {
                if (c.this.mRootView == null || c.this.mRootView.getParent() != null) {
                    c.this.cph();
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
        this.hVr = (TbImageView) this.mRootView.findViewById(a.f.alaPkLevel);
        this.hVv = (ViewGroup) this.mRootView.findViewById(a.f.ll_kingStar_container);
        this.hVw = (TbImageView) this.mRootView.findViewById(a.f.kingstar_icon);
        this.hVx = (TextView) this.mRootView.findViewById(a.f.kingstar_msg);
        this.hVs = (LinearLayout) this.mRootView.findViewById(a.f.alaPkLevelStar);
        this.hVt = (LinearLayout) this.mRootView.findViewById(a.f.integralToast);
        this.hVu = (TextView) this.mRootView.findViewById(a.f.textInfo);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cv(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(View view) {
        if (!TextUtils.isEmpty(this.aJj)) {
            com.baidu.live.ao.c cVar = new com.baidu.live.ao.c();
            cVar.url = this.aJj;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void setId(int i) {
        this.mRootView.setId(i);
    }

    public void T(w wVar) {
        if (wVar != null && wVar.aKx != null && wVar.aKx.aLr != null && !U(wVar)) {
            cancelAnimation();
            if (wVar.mLiveInfo != null) {
                this.liveId = wVar.mLiveInfo.live_id;
            }
            this.aLr = wVar.aKx.aLr;
            V(wVar);
            this.enb = wVar.aKx.msg;
            this.hVI = wVar.aKx.Fu();
            if (this.hVI) {
                this.hVH = false;
                n nVar = wVar.aKx.aLq;
                if (nVar != null) {
                    this.hVw.startLoad(nVar.iconUrl, 10, false);
                    this.hVx.setText(nVar.msg);
                    cpf();
                    return;
                }
                cpe();
                cpg();
                return;
            }
            cpe();
            cpg();
            this.hVH = TextUtils.isEmpty(this.enb) ? false : true;
            if (this.hVH) {
                this.mHandler.removeCallbacks(this.hVJ);
                this.mHandler.postDelayed(this.hVJ, 9000L);
            }
        }
    }

    private boolean U(w wVar) {
        return this.aLr != null && wVar.mLiveInfo != null && this.liveId == wVar.mLiveInfo.live_id && this.aLr.aLk == wVar.aKx.aLr.aLk && TextUtils.equals(this.aLr.division, wVar.aKx.aLr.division) && TextUtils.equals(this.enb, wVar.aKx.msg) && this.aLr.maxStar == wVar.aKx.aLr.maxStar && this.hVI == wVar.aKx.Fu();
    }

    private void cpe() {
        this.hVv.setVisibility(8);
        this.hVr.setVisibility(0);
        this.hVs.setVisibility(0);
    }

    private void cpf() {
        this.hVv.setVisibility(0);
        this.hVr.setVisibility(4);
        this.hVt.setVisibility(4);
        this.hVs.setVisibility(4);
    }

    private void V(w wVar) {
        long j;
        long j2;
        long j3;
        if (wVar.mLiveInfo == null || wVar.aJV == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
        } else {
            long j4 = wVar.aJV.userId;
            long j5 = wVar.mLiveInfo.room_id;
            j = wVar.mLiveInfo.live_id;
            j2 = j5;
            j3 = j4;
        }
        long j6 = wVar.aKr != null ? wVar.aKr.userId : 0L;
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)));
        this.aJj = com.baidu.live.utils.b.a(1, wVar.aKx.aJj, wVar.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(j6)), ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)), String.valueOf(j2), String.valueOf(j), hashMap);
    }

    private void cpg() {
        if (this.aLr != null && !TextUtils.isEmpty(this.aLr.division) && this.aLr.aLk > 0 && this.aLr.maxStar > 0) {
            int i = this.aLr.maxStar - this.aLr.aLk;
            this.hVr.startLoad(this.aLr.iconUrl, 10, false);
            cc(this.aLr.aLk, i);
        }
    }

    private void cc(int i, int i2) {
        int i3;
        int i4;
        if (this.hVs != null && this.hVt != null) {
            this.hVs.removeAllViews();
            this.hVs.setVisibility(0);
            this.hVt.setVisibility(4);
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
                this.hVs.addView(getSolidStarView(), layoutParams);
            }
            for (int i6 = 0; i6 < i2; i6++) {
                this.hVs.addView(getBlankStarView(), layoutParams);
            }
            this.hVu.setText(this.enb);
            this.hVF = BdUtilHelper.getTextWidth(this.hVu.getPaint(), this.enb);
            ViewGroup.LayoutParams layoutParams2 = this.hVu.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = this.hVF;
                this.hVu.setLayoutParams(layoutParams2);
            }
            this.hVu.setTranslationX(0.0f);
            this.hVs.setTranslationY(0.0f);
            this.hVt.setTranslationY(0.0f);
            this.hVs.setAlpha(1.0f);
            this.hVs.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cph() {
        this.hVG = true;
        cpn();
        cpo();
        cpm();
        cpk();
        cpj();
        this.hVE = new AnimatorSet();
        this.hVE.play(this.hVB).before(this.hVC);
        this.hVE.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.hVE.removeAllListeners();
                c.this.hVE.cancel();
                c.this.cpi();
            }
        });
        this.hVE.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpi() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.hVG && c.this.hVD != null) {
                    c.this.hVD.start();
                }
            }
        }, 300L);
    }

    private void cpj() {
        if (this.hVA == null) {
            this.hVA = cx(this.hVs);
            this.hVA.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.hVs.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (c.this.hVG) {
                        c.this.hVG = false;
                        c.this.mHandler.postDelayed(c.this.hVJ, 9000L);
                    }
                }
            });
        }
    }

    private void cpk() {
        if (this.hVt != null && this.hVz == null) {
            this.hVz = cw(this.hVt);
            this.hVz.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.hVt.setVisibility(4);
                    c.this.hVu.setTranslationX(0.0f);
                    c.this.cpl();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpl() {
        if (this.hVG && this.hVA != null) {
            this.hVA.start();
        }
    }

    private void cpm() {
        if (this.hVt != null) {
            this.hVy = this.hVt.getWidth();
            this.hVD = ObjectAnimator.ofFloat(this.hVu, "translationX", 0.0f, -(this.hVF - this.hVy));
            this.hVD.setDuration(IMConnection.RETRY_DELAY_TIMES);
            this.hVD.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.cpp();
                }
            });
        }
    }

    private void cpn() {
        if (this.hVB == null) {
            this.hVB = cw(this.hVs);
        }
    }

    private void cpo() {
        if (this.hVC == null) {
            this.hVC = cx(this.hVt);
            this.hVC.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.hVt.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpp() {
        if (this.hVG) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hVG && c.this.hVz != null) {
                        c.this.hVz.start();
                    }
                }
            }, 7000L);
        }
    }

    private AnimatorSet cw(final View view) {
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

    private AnimatorSet cx(View view) {
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
        if (this.hVG) {
            this.hVG = false;
            if (this.hVz != null) {
                this.hVz.cancel();
            }
            if (this.hVA != null) {
                this.hVA.cancel();
            }
            if (this.hVB != null) {
                this.hVB.cancel();
            }
            if (this.hVC != null) {
                this.hVC.cancel();
            }
            if (this.hVD != null) {
                this.hVD.cancel();
            }
            if (this.hVE != null) {
                this.hVE.cancel();
            }
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void Do() {
        this.aLr = null;
        this.liveId = 0L;
        cancelAnimation();
    }

    public void onDestroy() {
        cancelAnimation();
    }
}
