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
/* loaded from: classes4.dex */
public class PkRankStartAnimView extends FrameLayout {
    private com.baidu.live.alphavideo.c baF;
    private FrameLayout hOA;
    private ImageView hOB;
    private FrameLayout hOC;
    private FrameLayout hOD;
    private PkRankStartInfoView hOE;
    private PkRankStartInfoView hOF;
    private AnimatorSet hOG;
    private Runnable hOH;
    private a hOI;

    /* loaded from: classes4.dex */
    public interface a {
        void onAnimEnd();
    }

    public PkRankStartAnimView(Context context) {
        super(context);
        setBackgroundColor(Integer.MIN_VALUE);
    }

    public void setCallback(a aVar) {
        this.hOI = aVar;
    }

    public void bX(int i, int i2) {
        bY(i, i2);
        clM();
        clN();
        int i3 = (int) (i * 0.5f);
        int i4 = (int) (i2 * 0.6183575f * 0.5f);
        int i5 = (int) ((i2 * 58.0f) / 414.0f);
        P(i3, i4, i5);
        Q(i3, i4, i5);
        clO();
        clP();
    }

    public void setData(q qVar, q qVar2) {
        if (this.hOE != null) {
            this.hOE.setData(qVar);
            this.hOE.setVisibility(8);
        }
        if (this.hOF != null) {
            this.hOF.setData(qVar2);
            this.hOF.setVisibility(8);
        }
    }

    public void Is(String str) {
        Animator streakAnim;
        Animator streakAnim2;
        if (this.baF != null && !TextUtils.isEmpty(str)) {
            this.hOB.setVisibility(8);
            this.baF.getView().setVisibility(0);
            this.baF.play(str);
        } else {
            if (this.baF != null) {
                this.baF.getView().setVisibility(8);
            }
            this.hOB.setVisibility(0);
            this.hOH = new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankStartAnimView.this.hOI != null) {
                        PkRankStartAnimView.this.hOI.onAnimEnd();
                    }
                }
            };
            postDelayed(this.hOH, IMConnection.RETRY_DELAY_TIMES);
        }
        if (this.hOG != null) {
            this.hOG.cancel();
        }
        this.hOG = new AnimatorSet();
        ArrayList arrayList = null;
        if (this.hOE != null && (streakAnim2 = this.hOE.getStreakAnim()) != null) {
            arrayList = new ArrayList();
            arrayList.add(streakAnim2);
        }
        if (this.hOF != null && (streakAnim = this.hOF.getStreakAnim()) != null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(streakAnim);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.hOG.play(clQ()).with(clR()).before(animatorSet);
            arrayList.clear();
        } else {
            this.hOG.playTogether(clQ(), clR());
        }
        this.hOG.setStartDelay(800L);
        this.hOG.start();
    }

    public void stopAnim() {
        if (this.hOH != null) {
            removeCallbacks(this.hOH);
        }
        if (this.baF != null) {
            this.baF.stop();
            this.baF.reset();
        }
        if (this.hOG != null) {
            this.hOG.cancel();
        }
        if (this.hOE != null) {
            this.hOE.release();
        }
        if (this.hOF != null) {
            this.hOF.release();
        }
    }

    public void release() {
        stopAnim();
        if (this.baF != null) {
            this.baF.release();
        }
        removeAllViews();
    }

    private void bY(int i, int i2) {
        if (this.hOA == null) {
            this.hOA = new FrameLayout(getContext());
        }
        if (indexOfChild(this.hOA) < 0) {
            addView(this.hOA);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hOA.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.hOA.setLayoutParams(layoutParams);
    }

    private void clM() {
        if (this.baF == null || this.baF.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.baF = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.baF != null) {
            if (this.hOA.indexOfChild(this.baF.getView()) < 0) {
                this.hOA.addView(this.baF.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.baF.a(new c.a() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PkRankStartAnimView.this.hOI != null) {
                        PkRankStartAnimView.this.hOI.onAnimEnd();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    onEnd();
                }
            });
            this.baF.getView().setVisibility(8);
        }
    }

    private void clN() {
        if (this.hOB == null) {
            this.hOB = new ImageView(getContext());
            this.hOB.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hOB.setImageResource(a.e.pk_rank_start_anim_default);
        }
        if (this.hOA.indexOfChild(this.hOB) < 0) {
            this.hOA.addView(this.hOB, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hOB.setVisibility(8);
    }

    private void P(int i, int i2, int i3) {
        if (this.hOC == null) {
            this.hOC = new FrameLayout(getContext());
        }
        if (this.hOA.indexOfChild(this.hOC) < 0) {
            this.hOA.addView(this.hOC);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hOC.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 51;
        layoutParams.topMargin = i3;
        this.hOC.setLayoutParams(layoutParams);
    }

    private void Q(int i, int i2, int i3) {
        if (this.hOD == null) {
            this.hOD = new FrameLayout(getContext());
        }
        if (this.hOA.indexOfChild(this.hOD) < 0) {
            this.hOA.addView(this.hOD);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hOD.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = i3;
        this.hOD.setLayoutParams(layoutParams);
    }

    private void clO() {
        if (this.hOC != null) {
            if (this.hOE == null) {
                this.hOE = new PkRankStartInfoView(getContext(), false);
            }
            if (this.hOC.indexOfChild(this.hOE) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                this.hOC.addView(this.hOE, layoutParams);
            }
        }
    }

    private void clP() {
        if (this.hOD != null) {
            if (this.hOF == null) {
                this.hOF = new PkRankStartInfoView(getContext(), true);
            }
            if (this.hOD.indexOfChild(this.hOF) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 19;
                this.hOD.addView(this.hOF, layoutParams);
            }
        }
    }

    private AnimatorSet clQ() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hOE, "translationX", (-this.hOC.getLayoutParams().width) * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hOE, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.hOE.setVisibility(0);
            }
        });
        return animatorSet;
    }

    private AnimatorSet clR() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hOF, "translationX", this.hOD.getLayoutParams().width * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hOF, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.hOF.setVisibility(0);
            }
        });
        return animatorSet;
    }
}
