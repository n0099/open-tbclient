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
/* loaded from: classes11.dex */
public class PkRankStartAnimView extends FrameLayout {
    private com.baidu.live.alphavideo.c bei;
    private FrameLayout ifP;
    private ImageView ifQ;
    private Runnable ifR;
    private FrameLayout imO;
    private FrameLayout imP;
    private PkRankStartInfoView imQ;
    private PkRankStartInfoView imR;
    private AnimatorSet imS;
    private a imT;

    /* loaded from: classes11.dex */
    public interface a {
        void cov();
    }

    public PkRankStartAnimView(Context context) {
        super(context);
        setBackgroundColor(Integer.MIN_VALUE);
    }

    public void setCallback(a aVar) {
        this.imT = aVar;
    }

    public void bW(int i, int i2) {
        bX(i, i2);
        coB();
        coC();
        int i3 = (int) (i * 0.5f);
        int i4 = (int) (i2 * 0.6183575f * 0.5f);
        int i5 = (int) ((i2 * 58.0f) / 414.0f);
        Q(i3, i4, i5);
        R(i3, i4, i5);
        cql();
        cqm();
    }

    public void setData(q qVar, q qVar2) {
        if (this.imQ != null) {
            this.imQ.setData(qVar);
            this.imQ.setVisibility(8);
        }
        if (this.imR != null) {
            this.imR.setData(qVar2);
            this.imR.setVisibility(8);
        }
    }

    public void Iu(String str) {
        Animator streakAnim;
        Animator streakAnim2;
        if (this.bei != null && !TextUtils.isEmpty(str)) {
            this.ifQ.setVisibility(8);
            this.bei.getView().setVisibility(0);
            this.bei.play(str);
        } else {
            if (this.bei != null) {
                this.bei.getView().setVisibility(8);
            }
            this.ifQ.setVisibility(0);
            this.ifR = new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankStartAnimView.this.imT != null) {
                        PkRankStartAnimView.this.imT.cov();
                    }
                }
            };
            postDelayed(this.ifR, IMConnection.RETRY_DELAY_TIMES);
        }
        if (this.imS != null) {
            this.imS.cancel();
        }
        this.imS = new AnimatorSet();
        ArrayList arrayList = null;
        if (this.imQ != null && (streakAnim2 = this.imQ.getStreakAnim()) != null) {
            arrayList = new ArrayList();
            arrayList.add(streakAnim2);
        }
        if (this.imR != null && (streakAnim = this.imR.getStreakAnim()) != null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(streakAnim);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.imS.play(cqn()).with(cqo()).before(animatorSet);
            arrayList.clear();
        } else {
            this.imS.playTogether(cqn(), cqo());
        }
        this.imS.setStartDelay(800L);
        this.imS.start();
    }

    public void stopAnim() {
        if (this.ifR != null) {
            removeCallbacks(this.ifR);
        }
        if (this.bei != null) {
            this.bei.stop();
            this.bei.reset();
        }
        if (this.imS != null) {
            this.imS.cancel();
        }
        if (this.imQ != null) {
            this.imQ.release();
        }
        if (this.imR != null) {
            this.imR.release();
        }
    }

    public void release() {
        stopAnim();
        if (this.bei != null) {
            this.bei.release();
        }
        removeAllViews();
    }

    private void bX(int i, int i2) {
        if (this.ifP == null) {
            this.ifP = new FrameLayout(getContext());
        }
        if (indexOfChild(this.ifP) < 0) {
            addView(this.ifP);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ifP.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.ifP.setLayoutParams(layoutParams);
    }

    private void coB() {
        if (this.bei == null || this.bei.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bei = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.bei != null) {
            if (this.ifP.indexOfChild(this.bei.getView()) < 0) {
                this.ifP.addView(this.bei.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.bei.a(new c.a() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PkRankStartAnimView.this.imT != null) {
                        PkRankStartAnimView.this.imT.cov();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    onEnd();
                }
            });
            this.bei.getView().setVisibility(8);
        }
    }

    private void coC() {
        if (this.ifQ == null) {
            this.ifQ = new ImageView(getContext());
            this.ifQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ifQ.setImageResource(a.e.pk_rank_start_anim_default);
        }
        if (this.ifP.indexOfChild(this.ifQ) < 0) {
            this.ifP.addView(this.ifQ, new ViewGroup.LayoutParams(-1, -1));
        }
        this.ifQ.setVisibility(8);
    }

    private void Q(int i, int i2, int i3) {
        if (this.imO == null) {
            this.imO = new FrameLayout(getContext());
        }
        if (this.ifP.indexOfChild(this.imO) < 0) {
            this.ifP.addView(this.imO);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.imO.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 51;
        layoutParams.topMargin = i3;
        this.imO.setLayoutParams(layoutParams);
    }

    private void R(int i, int i2, int i3) {
        if (this.imP == null) {
            this.imP = new FrameLayout(getContext());
        }
        if (this.ifP.indexOfChild(this.imP) < 0) {
            this.ifP.addView(this.imP);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.imP.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = i3;
        this.imP.setLayoutParams(layoutParams);
    }

    private void cql() {
        if (this.imO != null) {
            if (this.imQ == null) {
                this.imQ = new PkRankStartInfoView(getContext(), false);
            }
            if (this.imO.indexOfChild(this.imQ) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                this.imO.addView(this.imQ, layoutParams);
            }
        }
    }

    private void cqm() {
        if (this.imP != null) {
            if (this.imR == null) {
                this.imR = new PkRankStartInfoView(getContext(), true);
            }
            if (this.imP.indexOfChild(this.imR) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 19;
                this.imP.addView(this.imR, layoutParams);
            }
        }
    }

    private AnimatorSet cqn() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.imQ, "translationX", (-this.imO.getLayoutParams().width) * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.imQ, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.imQ.setVisibility(0);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cqo() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.imR, "translationX", this.imP.getLayoutParams().width * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.imR, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.imR.setVisibility(0);
            }
        });
        return animatorSet;
    }
}
