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
    private int hVA;
    private AnimatorSet hVB;
    private AnimatorSet hVC;
    private AnimatorSet hVD;
    private AnimatorSet hVE;
    private ObjectAnimator hVF;
    private AnimatorSet hVG;
    private int hVH;
    private boolean hVI;
    private boolean hVK;
    private TbImageView hVt;
    private LinearLayout hVu;
    private LinearLayout hVv;
    private TextView hVw;
    private ViewGroup hVx;
    private TbImageView hVy;
    private TextView hVz;
    private long liveId;
    private Context mContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private boolean hVJ = true;
    private Runnable hVL = new Runnable() { // from class: com.baidu.tieba.ala.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.hVJ) {
                if (c.this.mRootView == null || c.this.mRootView.getParent() != null) {
                    c.this.cpi();
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
        this.hVt = (TbImageView) this.mRootView.findViewById(a.f.alaPkLevel);
        this.hVx = (ViewGroup) this.mRootView.findViewById(a.f.ll_kingStar_container);
        this.hVy = (TbImageView) this.mRootView.findViewById(a.f.kingstar_icon);
        this.hVz = (TextView) this.mRootView.findViewById(a.f.kingstar_msg);
        this.hVu = (LinearLayout) this.mRootView.findViewById(a.f.alaPkLevelStar);
        this.hVv = (LinearLayout) this.mRootView.findViewById(a.f.integralToast);
        this.hVw = (TextView) this.mRootView.findViewById(a.f.textInfo);
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
            this.hVK = wVar.aKx.Fu();
            if (this.hVK) {
                this.hVJ = false;
                n nVar = wVar.aKx.aLq;
                if (nVar != null) {
                    this.hVy.startLoad(nVar.iconUrl, 10, false);
                    this.hVz.setText(nVar.msg);
                    cpg();
                    return;
                }
                cpf();
                cph();
                return;
            }
            cpf();
            cph();
            this.hVJ = TextUtils.isEmpty(this.enb) ? false : true;
            if (this.hVJ) {
                this.mHandler.removeCallbacks(this.hVL);
                this.mHandler.postDelayed(this.hVL, 9000L);
            }
        }
    }

    private boolean U(w wVar) {
        return this.aLr != null && wVar.mLiveInfo != null && this.liveId == wVar.mLiveInfo.live_id && this.aLr.aLk == wVar.aKx.aLr.aLk && TextUtils.equals(this.aLr.division, wVar.aKx.aLr.division) && TextUtils.equals(this.enb, wVar.aKx.msg) && this.aLr.maxStar == wVar.aKx.aLr.maxStar && this.hVK == wVar.aKx.Fu();
    }

    private void cpf() {
        this.hVx.setVisibility(8);
        this.hVt.setVisibility(0);
        this.hVu.setVisibility(0);
    }

    private void cpg() {
        this.hVx.setVisibility(0);
        this.hVt.setVisibility(4);
        this.hVv.setVisibility(4);
        this.hVu.setVisibility(4);
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

    private void cph() {
        if (this.aLr != null && !TextUtils.isEmpty(this.aLr.division) && this.aLr.aLk > 0 && this.aLr.maxStar > 0) {
            int i = this.aLr.maxStar - this.aLr.aLk;
            this.hVt.startLoad(this.aLr.iconUrl, 10, false);
            cc(this.aLr.aLk, i);
        }
    }

    private void cc(int i, int i2) {
        int i3;
        int i4;
        if (this.hVu != null && this.hVv != null) {
            this.hVu.removeAllViews();
            this.hVu.setVisibility(0);
            this.hVv.setVisibility(4);
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
                this.hVu.addView(getSolidStarView(), layoutParams);
            }
            for (int i6 = 0; i6 < i2; i6++) {
                this.hVu.addView(getBlankStarView(), layoutParams);
            }
            this.hVw.setText(this.enb);
            this.hVH = BdUtilHelper.getTextWidth(this.hVw.getPaint(), this.enb);
            ViewGroup.LayoutParams layoutParams2 = this.hVw.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = this.hVH;
                this.hVw.setLayoutParams(layoutParams2);
            }
            this.hVw.setTranslationX(0.0f);
            this.hVu.setTranslationY(0.0f);
            this.hVv.setTranslationY(0.0f);
            this.hVu.setAlpha(1.0f);
            this.hVu.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpi() {
        this.hVI = true;
        cpo();
        cpp();
        cpn();
        cpl();
        cpk();
        this.hVG = new AnimatorSet();
        this.hVG.play(this.hVD).before(this.hVE);
        this.hVG.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.hVG.removeAllListeners();
                c.this.hVG.cancel();
                c.this.cpj();
            }
        });
        this.hVG.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpj() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.hVI && c.this.hVF != null) {
                    c.this.hVF.start();
                }
            }
        }, 300L);
    }

    private void cpk() {
        if (this.hVC == null) {
            this.hVC = cx(this.hVu);
            this.hVC.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.hVu.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (c.this.hVI) {
                        c.this.hVI = false;
                        c.this.mHandler.postDelayed(c.this.hVL, 9000L);
                    }
                }
            });
        }
    }

    private void cpl() {
        if (this.hVv != null && this.hVB == null) {
            this.hVB = cw(this.hVv);
            this.hVB.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.hVv.setVisibility(4);
                    c.this.hVw.setTranslationX(0.0f);
                    c.this.cpm();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpm() {
        if (this.hVI && this.hVC != null) {
            this.hVC.start();
        }
    }

    private void cpn() {
        if (this.hVv != null) {
            this.hVA = this.hVv.getWidth();
            this.hVF = ObjectAnimator.ofFloat(this.hVw, "translationX", 0.0f, -(this.hVH - this.hVA));
            this.hVF.setDuration(IMConnection.RETRY_DELAY_TIMES);
            this.hVF.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.cpq();
                }
            });
        }
    }

    private void cpo() {
        if (this.hVD == null) {
            this.hVD = cw(this.hVu);
        }
    }

    private void cpp() {
        if (this.hVE == null) {
            this.hVE = cx(this.hVv);
            this.hVE.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.hVv.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpq() {
        if (this.hVI) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hVI && c.this.hVB != null) {
                        c.this.hVB.start();
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
        if (this.hVI) {
            this.hVI = false;
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
            if (this.hVF != null) {
                this.hVF.cancel();
            }
            if (this.hVG != null) {
                this.hVG.cancel();
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
