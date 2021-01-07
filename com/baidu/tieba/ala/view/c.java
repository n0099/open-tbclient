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
import com.baidu.live.data.ad;
import com.baidu.live.data.o;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class c {
    private String aJH;
    private ad aLT;
    private String ewK;
    private TbImageView ihT;
    private LinearLayout ihU;
    private LinearLayout ihV;
    private TextView ihW;
    private ViewGroup ihX;
    private TbImageView ihY;
    private TextView ihZ;
    private int iia;
    private AnimatorSet iib;
    private AnimatorSet iic;
    private AnimatorSet iid;
    private AnimatorSet iie;
    private ObjectAnimator iif;
    private AnimatorSet iig;
    private int iih;
    private boolean iii;
    private boolean iik;
    private long liveId;
    private Context mContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private boolean iij = true;
    private Runnable iil = new Runnable() { // from class: com.baidu.tieba.ala.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.iij) {
                if (c.this.mRootView == null || c.this.mRootView.getParent() != null) {
                    c.this.csc();
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
        this.ihT = (TbImageView) this.mRootView.findViewById(a.f.alaPkLevel);
        this.ihX = (ViewGroup) this.mRootView.findViewById(a.f.ll_kingStar_container);
        this.ihY = (TbImageView) this.mRootView.findViewById(a.f.kingstar_icon);
        this.ihZ = (TextView) this.mRootView.findViewById(a.f.kingstar_msg);
        this.ihU = (LinearLayout) this.mRootView.findViewById(a.f.alaPkLevelStar);
        this.ihV = (LinearLayout) this.mRootView.findViewById(a.f.integralToast);
        this.ihW = (TextView) this.mRootView.findViewById(a.f.textInfo);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cF(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(View view) {
        if (!TextUtils.isEmpty(this.aJH)) {
            com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
            cVar.url = this.aJH;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void setId(int i) {
        this.mRootView.setId(i);
    }

    public void V(x xVar) {
        if (xVar != null && xVar.aKW != null && xVar.aKW.aLT != null && !W(xVar)) {
            cancelAnimation();
            if (xVar.mLiveInfo != null) {
                this.liveId = xVar.mLiveInfo.live_id;
            }
            this.aLT = xVar.aKW.aLT;
            X(xVar);
            this.ewK = xVar.aKW.msg;
            this.iik = xVar.aKW.EK();
            if (this.iik) {
                this.iij = false;
                o oVar = xVar.aKW.aLS;
                if (oVar != null) {
                    this.ihY.startLoad(oVar.iconUrl, 10, false);
                    this.ihZ.setText(oVar.msg);
                    csa();
                    return;
                }
                crZ();
                csb();
                return;
            }
            crZ();
            csb();
            this.iij = TextUtils.isEmpty(this.ewK) ? false : true;
            if (this.iij) {
                this.mHandler.removeCallbacks(this.iil);
                this.mHandler.postDelayed(this.iil, 9000L);
            }
        }
    }

    private boolean W(x xVar) {
        return this.aLT != null && xVar.mLiveInfo != null && this.liveId == xVar.mLiveInfo.live_id && this.aLT.aLM == xVar.aKW.aLT.aLM && TextUtils.equals(this.aLT.division, xVar.aKW.aLT.division) && TextUtils.equals(this.ewK, xVar.aKW.msg) && this.aLT.maxStar == xVar.aKW.aLT.maxStar && this.iik == xVar.aKW.EK();
    }

    private void crZ() {
        this.ihX.setVisibility(8);
        this.ihT.setVisibility(0);
        this.ihU.setVisibility(0);
    }

    private void csa() {
        this.ihX.setVisibility(0);
        this.ihT.setVisibility(4);
        this.ihV.setVisibility(4);
        this.ihU.setVisibility(4);
    }

    private void X(x xVar) {
        long j;
        long j2;
        long j3;
        if (xVar.mLiveInfo == null || xVar.aKu == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
        } else {
            long j4 = xVar.aKu.userId;
            long j5 = xVar.mLiveInfo.room_id;
            j = xVar.mLiveInfo.live_id;
            j2 = j5;
            j3 = j4;
        }
        long j6 = xVar.aKQ != null ? xVar.aKQ.userId : 0L;
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)));
        this.aJH = com.baidu.live.utils.b.a(1, xVar.aKW.aJH, xVar.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(j6)), ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)), String.valueOf(j2), String.valueOf(j), hashMap);
    }

    private void csb() {
        if (this.aLT != null && !TextUtils.isEmpty(this.aLT.division) && this.aLT.aLM > 0 && this.aLT.maxStar > 0) {
            int i = this.aLT.maxStar - this.aLT.aLM;
            this.ihT.startLoad(this.aLT.iconUrl, 10, false);
            cb(this.aLT.aLM, i);
        }
    }

    private void cb(int i, int i2) {
        int i3;
        int i4;
        if (this.ihU != null && this.ihV != null) {
            this.ihU.removeAllViews();
            this.ihU.setVisibility(0);
            this.ihV.setVisibility(4);
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
                this.ihU.addView(getSolidStarView(), layoutParams);
            }
            for (int i6 = 0; i6 < i2; i6++) {
                this.ihU.addView(getBlankStarView(), layoutParams);
            }
            this.ihW.setText(this.ewK);
            this.iih = BdUtilHelper.getTextWidth(this.ihW.getPaint(), this.ewK);
            ViewGroup.LayoutParams layoutParams2 = this.ihW.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = this.iih;
                this.ihW.setLayoutParams(layoutParams2);
            }
            this.ihW.setTranslationX(0.0f);
            this.ihU.setTranslationY(0.0f);
            this.ihV.setTranslationY(0.0f);
            this.ihU.setAlpha(1.0f);
            this.ihU.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csc() {
        this.iii = true;
        csi();
        csj();
        csh();
        csf();
        cse();
        this.iig = new AnimatorSet();
        this.iig.play(this.iid).before(this.iie);
        this.iig.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.iig.removeAllListeners();
                c.this.iig.cancel();
                c.this.csd();
            }
        });
        this.iig.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csd() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.iii && c.this.iif != null) {
                    c.this.iif.start();
                }
            }
        }, 300L);
    }

    private void cse() {
        if (this.iic == null) {
            this.iic = cH(this.ihU);
            this.iic.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.ihU.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (c.this.iii) {
                        c.this.iii = false;
                        c.this.mHandler.postDelayed(c.this.iil, 9000L);
                    }
                }
            });
        }
    }

    private void csf() {
        if (this.ihV != null && this.iib == null) {
            this.iib = cG(this.ihV);
            this.iib.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.ihV.setVisibility(4);
                    c.this.ihW.setTranslationX(0.0f);
                    c.this.csg();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csg() {
        if (this.iii && this.iic != null) {
            this.iic.start();
        }
    }

    private void csh() {
        if (this.ihV != null) {
            this.iia = this.ihV.getWidth();
            this.iif = ObjectAnimator.ofFloat(this.ihW, "translationX", 0.0f, -(this.iih - this.iia));
            this.iif.setDuration(IMConnection.RETRY_DELAY_TIMES);
            this.iif.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.csk();
                }
            });
        }
    }

    private void csi() {
        if (this.iid == null) {
            this.iid = cG(this.ihU);
        }
    }

    private void csj() {
        if (this.iie == null) {
            this.iie = cH(this.ihV);
            this.iie.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.ihV.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csk() {
        if (this.iii) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.iii && c.this.iib != null) {
                        c.this.iib.start();
                    }
                }
            }, 7000L);
        }
    }

    private AnimatorSet cG(final View view) {
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

    private AnimatorSet cH(View view) {
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
        if (this.iii) {
            this.iii = false;
            if (this.iib != null) {
                this.iib.cancel();
            }
            if (this.iic != null) {
                this.iic.cancel();
            }
            if (this.iid != null) {
                this.iid.cancel();
            }
            if (this.iie != null) {
                this.iie.cancel();
            }
            if (this.iif != null) {
                this.iif.cancel();
            }
            if (this.iig != null) {
                this.iig.cancel();
            }
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void Bf() {
        this.aLT = null;
        this.liveId = 0L;
        cancelAnimation();
    }

    public void onDestroy() {
        cancelAnimation();
    }
}
