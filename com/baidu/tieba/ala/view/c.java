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
    private String aHs;
    private ab aJn;
    private String ebQ;
    private TbImageView hET;
    private LinearLayout hEU;
    private LinearLayout hEV;
    private TextView hEW;
    private ViewGroup hEX;
    private TbImageView hEY;
    private TextView hEZ;
    private int hFa;
    private AnimatorSet hFb;
    private AnimatorSet hFc;
    private AnimatorSet hFd;
    private AnimatorSet hFe;
    private ObjectAnimator hFf;
    private AnimatorSet hFg;
    private int hFh;
    private boolean hFi;
    private boolean hFk;
    private long liveId;
    private Context mContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private boolean hFj = true;
    private Runnable hFl = new Runnable() { // from class: com.baidu.tieba.ala.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.hFj) {
                if (c.this.mRootView == null || c.this.mRootView.getParent() != null) {
                    c.this.ciX();
                }
            }
        }
    };

    public c(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = View.inflate(this.mContext, a.h.ala_pk_rank_level_view, null);
        this.hET = (TbImageView) this.mRootView.findViewById(a.g.alaPkLevel);
        this.hEX = (ViewGroup) this.mRootView.findViewById(a.g.ll_kingStar_container);
        this.hEY = (TbImageView) this.mRootView.findViewById(a.g.kingstar_icon);
        this.hEZ = (TextView) this.mRootView.findViewById(a.g.kingstar_msg);
        this.hEU = (LinearLayout) this.mRootView.findViewById(a.g.alaPkLevelStar);
        this.hEV = (LinearLayout) this.mRootView.findViewById(a.g.integralToast);
        this.hEW = (TextView) this.mRootView.findViewById(a.g.textInfo);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cg(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(View view) {
        if (!TextUtils.isEmpty(this.aHs)) {
            com.baidu.live.ai.c cVar = new com.baidu.live.ai.c();
            cVar.url = this.aHs;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void setId(int i) {
        this.mRootView.setId(i);
    }

    public void J(w wVar) {
        if (wVar != null && wVar.aIG != null && wVar.aIG.aJn != null && !K(wVar)) {
            cancelAnimation();
            if (wVar.mLiveInfo != null) {
                this.liveId = wVar.mLiveInfo.live_id;
            }
            this.aJn = wVar.aIG.aJn;
            L(wVar);
            this.ebQ = wVar.aIG.msg;
            this.hFk = wVar.aIG.DW();
            if (this.hFk) {
                this.hFj = false;
                n nVar = wVar.aIG.aJm;
                if (nVar != null) {
                    this.hEY.startLoad(nVar.iconUrl, 10, false);
                    this.hEZ.setText(nVar.msg);
                    ciV();
                    return;
                }
                ciU();
                ciW();
                return;
            }
            ciU();
            ciW();
            this.hFj = TextUtils.isEmpty(this.ebQ) ? false : true;
            if (this.hFj) {
                this.mHandler.removeCallbacks(this.hFl);
                this.mHandler.postDelayed(this.hFl, 9000L);
            }
        }
    }

    private boolean K(w wVar) {
        return this.aJn != null && wVar.mLiveInfo != null && this.liveId == wVar.mLiveInfo.live_id && this.aJn.aJj == wVar.aIG.aJn.aJj && TextUtils.equals(this.aJn.division, wVar.aIG.aJn.division) && TextUtils.equals(this.ebQ, wVar.aIG.msg) && this.aJn.maxStar == wVar.aIG.aJn.maxStar && this.hFk == wVar.aIG.DW();
    }

    private void ciU() {
        this.hEX.setVisibility(8);
        this.hET.setVisibility(0);
        this.hEU.setVisibility(0);
    }

    private void ciV() {
        this.hEX.setVisibility(0);
        this.hET.setVisibility(4);
        this.hEV.setVisibility(4);
        this.hEU.setVisibility(4);
    }

    private void L(w wVar) {
        long j;
        long j2;
        long j3;
        if (wVar.mLiveInfo == null || wVar.aIe == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
        } else {
            long j4 = wVar.aIe.userId;
            long j5 = wVar.mLiveInfo.room_id;
            j = wVar.mLiveInfo.live_id;
            j2 = j5;
            j3 = j4;
        }
        long j6 = wVar.aIA != null ? wVar.aIA.userId : 0L;
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)));
        this.aHs = com.baidu.live.utils.b.a(1, wVar.aIG.aHs, wVar.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(j6)), ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)), String.valueOf(j2), String.valueOf(j), hashMap);
    }

    private void ciW() {
        if (this.aJn != null && !TextUtils.isEmpty(this.aJn.division) && this.aJn.aJj > 0 && this.aJn.maxStar > 0) {
            int i = this.aJn.maxStar - this.aJn.aJj;
            this.hET.startLoad(this.aJn.iconUrl, 10, false);
            bU(this.aJn.aJj, i);
        }
    }

    private void bU(int i, int i2) {
        int i3;
        int i4;
        if (this.hEU != null && this.hEV != null) {
            this.hEU.removeAllViews();
            this.hEU.setVisibility(0);
            this.hEV.setVisibility(4);
            if (i + i2 <= 4) {
                i4 = a.e.sdk_ds5;
                i3 = a.e.sdk_ds28;
            } else {
                i3 = a.e.sdk_ds22;
                i4 = a.e.sdk_ds3;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.mContext, i3), BdUtilHelper.getDimens(this.mContext, i3));
            layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, i4);
            layoutParams.gravity = 16;
            for (int i5 = 0; i5 < i; i5++) {
                this.hEU.addView(getSolidStarView(), layoutParams);
            }
            for (int i6 = 0; i6 < i2; i6++) {
                this.hEU.addView(getBlankStarView(), layoutParams);
            }
            this.hEW.setText(this.ebQ);
            this.hFh = BdUtilHelper.getTextWidth(this.hEW.getPaint(), this.ebQ);
            ViewGroup.LayoutParams layoutParams2 = this.hEW.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = this.hFh;
                this.hEW.setLayoutParams(layoutParams2);
            }
            this.hEW.setTranslationX(0.0f);
            this.hEU.setTranslationY(0.0f);
            this.hEV.setTranslationY(0.0f);
            this.hEU.setAlpha(1.0f);
            this.hEU.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciX() {
        this.hFi = true;
        cjd();
        cje();
        cjc();
        cja();
        ciZ();
        this.hFg = new AnimatorSet();
        this.hFg.play(this.hFd).before(this.hFe);
        this.hFg.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.hFg.removeAllListeners();
                c.this.hFg.cancel();
                c.this.ciY();
            }
        });
        this.hFg.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciY() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.hFi && c.this.hFf != null) {
                    c.this.hFf.start();
                }
            }
        }, 300L);
    }

    private void ciZ() {
        if (this.hFc == null) {
            this.hFc = ci(this.hEU);
            this.hFc.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.hEU.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (c.this.hFi) {
                        c.this.hFi = false;
                        c.this.mHandler.postDelayed(c.this.hFl, 9000L);
                    }
                }
            });
        }
    }

    private void cja() {
        if (this.hEV != null && this.hFb == null) {
            this.hFb = ch(this.hEV);
            this.hFb.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.hEV.setVisibility(4);
                    c.this.hEW.setTranslationX(0.0f);
                    c.this.cjb();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjb() {
        if (this.hFi && this.hFc != null) {
            this.hFc.start();
        }
    }

    private void cjc() {
        if (this.hEV != null) {
            this.hFa = this.hEV.getWidth();
            this.hFf = ObjectAnimator.ofFloat(this.hEW, "translationX", 0.0f, -(this.hFh - this.hFa));
            this.hFf.setDuration(IMConnection.RETRY_DELAY_TIMES);
            this.hFf.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.cjf();
                }
            });
        }
    }

    private void cjd() {
        if (this.hFd == null) {
            this.hFd = ch(this.hEU);
        }
    }

    private void cje() {
        if (this.hFe == null) {
            this.hFe = ci(this.hEV);
            this.hFe.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.hEV.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjf() {
        if (this.hFi) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hFi && c.this.hFb != null) {
                        c.this.hFb.start();
                    }
                }
            }, 7000L);
        }
    }

    private AnimatorSet ch(final View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -BdUtilHelper.getDimens(this.mContext, a.e.sdk_ds12));
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

    private AnimatorSet ci(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", BdUtilHelper.getDimens(this.mContext, a.e.sdk_ds12), 0.0f);
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
        imageView.setImageResource(a.f.ala_icon_five_pointed_star);
        return imageView;
    }

    private View getBlankStarView() {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setImageResource(a.f.ala_icon_blank_five_pointed_star);
        return imageView;
    }

    private void cancelAnimation() {
        if (this.hFi) {
            this.hFi = false;
            if (this.hFb != null) {
                this.hFb.cancel();
            }
            if (this.hFc != null) {
                this.hFc.cancel();
            }
            if (this.hFd != null) {
                this.hFd.cancel();
            }
            if (this.hFe != null) {
                this.hFe.cancel();
            }
            if (this.hFf != null) {
                this.hFf.cancel();
            }
            if (this.hFg != null) {
                this.hFg.cancel();
            }
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void Kj() {
        this.aJn = null;
        this.liveId = 0L;
        cancelAnimation();
    }

    public void onDestroy() {
        cancelAnimation();
    }
}
