package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.alphavideo.c;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.q;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class PkRankStartAnimView extends FrameLayout {
    private com.baidu.live.alphavideo.c bfL;
    private FrameLayout ihM;
    private ImageView ihN;
    private Runnable ihO;
    private FrameLayout ioM;
    private FrameLayout ioN;
    private PkRankStartInfoView ioO;
    private PkRankStartInfoView ioP;
    private AnimatorSet ioQ;
    private a ioR;

    /* loaded from: classes10.dex */
    public interface a {
        void coI();
    }

    public PkRankStartAnimView(Context context) {
        super(context);
        setBackgroundColor(Integer.MIN_VALUE);
    }

    public void setCallback(a aVar) {
        this.ioR = aVar;
    }

    public void bX(int i, int i2) {
        bY(i, i2);
        coO();
        coP();
        int i3 = (int) (i * 0.5f);
        int i4 = (int) (i2 * 0.6183575f * 0.5f);
        int i5 = (int) ((i2 * 58.0f) / 414.0f);
        Q(i3, i4, i5);
        R(i3, i4, i5);
        cqy();
        cqz();
    }

    public void setData(q qVar, q qVar2) {
        if (this.ioO != null) {
            this.ioO.setData(qVar);
            this.ioO.setVisibility(8);
        }
        if (this.ioP != null) {
            this.ioP.setData(qVar2);
            this.ioP.setVisibility(8);
        }
    }

    public void IE(String str) {
        Animator streakAnim;
        Animator streakAnim2;
        if (this.bfL != null && !TextUtils.isEmpty(str)) {
            this.ihN.setVisibility(8);
            this.bfL.getView().setVisibility(0);
            this.bfL.play(str);
        } else {
            if (this.bfL != null) {
                this.bfL.getView().setVisibility(8);
            }
            this.ihN.setVisibility(0);
            this.ihO = new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankStartAnimView.this.ioR != null) {
                        PkRankStartAnimView.this.ioR.coI();
                    }
                }
            };
            postDelayed(this.ihO, IMConnection.RETRY_DELAY_TIMES);
        }
        if (this.ioQ != null) {
            this.ioQ.cancel();
        }
        this.ioQ = new AnimatorSet();
        ArrayList arrayList = null;
        if (this.ioO != null && (streakAnim2 = this.ioO.getStreakAnim()) != null) {
            arrayList = new ArrayList();
            arrayList.add(streakAnim2);
        }
        if (this.ioP != null && (streakAnim = this.ioP.getStreakAnim()) != null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(streakAnim);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.ioQ.play(cqA()).with(cqB()).before(animatorSet);
            arrayList.clear();
        } else {
            this.ioQ.playTogether(cqA(), cqB());
        }
        this.ioQ.setStartDelay(800L);
        this.ioQ.start();
    }

    public void stopAnim() {
        if (this.ihO != null) {
            removeCallbacks(this.ihO);
        }
        if (this.bfL != null) {
            this.bfL.stop();
            this.bfL.reset();
        }
        if (this.ioQ != null) {
            this.ioQ.cancel();
        }
        if (this.ioO != null) {
            this.ioO.release();
        }
        if (this.ioP != null) {
            this.ioP.release();
        }
    }

    public void release() {
        stopAnim();
        if (this.bfL != null) {
            this.bfL.release();
        }
        removeAllViews();
    }

    private void bY(int i, int i2) {
        if (this.ihM == null) {
            this.ihM = new FrameLayout(getContext());
        }
        if (indexOfChild(this.ihM) < 0) {
            addView(this.ihM);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ihM.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.ihM.setLayoutParams(layoutParams);
    }

    private void coO() {
        if (this.bfL == null || this.bfL.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bfL = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.bfL != null) {
            if (this.ihM.indexOfChild(this.bfL.getView()) < 0) {
                this.ihM.addView(this.bfL.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.bfL.a(new c.a() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PkRankStartAnimView.this.ioR != null) {
                        PkRankStartAnimView.this.ioR.coI();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    onEnd();
                }
            });
            this.bfL.getView().setVisibility(8);
        }
    }

    private void coP() {
        if (this.ihN == null) {
            this.ihN = new ImageView(getContext());
            this.ihN.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ihN.setImageResource(a.e.pk_rank_start_anim_default);
        }
        if (this.ihM.indexOfChild(this.ihN) < 0) {
            this.ihM.addView(this.ihN, new ViewGroup.LayoutParams(-1, -1));
        }
        this.ihN.setVisibility(8);
    }

    private void Q(int i, int i2, int i3) {
        if (this.ioM == null) {
            this.ioM = new FrameLayout(getContext());
        }
        if (this.ihM.indexOfChild(this.ioM) < 0) {
            this.ihM.addView(this.ioM);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ioM.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 51;
        layoutParams.topMargin = i3;
        this.ioM.setLayoutParams(layoutParams);
    }

    private void R(int i, int i2, int i3) {
        if (this.ioN == null) {
            this.ioN = new FrameLayout(getContext());
        }
        if (this.ihM.indexOfChild(this.ioN) < 0) {
            this.ihM.addView(this.ioN);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ioN.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = i3;
        this.ioN.setLayoutParams(layoutParams);
    }

    private void cqy() {
        if (this.ioM != null) {
            if (this.ioO == null) {
                this.ioO = new PkRankStartInfoView(getContext(), false);
            }
            if (this.ioM.indexOfChild(this.ioO) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                this.ioM.addView(this.ioO, layoutParams);
            }
        }
    }

    private void cqz() {
        if (this.ioN != null) {
            if (this.ioP == null) {
                this.ioP = new PkRankStartInfoView(getContext(), true);
            }
            if (this.ioN.indexOfChild(this.ioP) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 19;
                this.ioN.addView(this.ioP, layoutParams);
            }
        }
    }

    private AnimatorSet cqA() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ioO, "translationX", (-this.ioM.getLayoutParams().width) * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ioO, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.ioO.setVisibility(0);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cqB() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ioP, "translationX", this.ioN.getLayoutParams().width * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ioP, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.ioP.setVisibility(0);
            }
        });
        return animatorSet;
    }
}
