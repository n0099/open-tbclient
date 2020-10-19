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
import com.baidu.tieba.ala.data.o;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PkRankStartAnimView extends FrameLayout {
    private com.baidu.live.alphavideo.c aZA;
    private ImageView hwA;
    private FrameLayout hwB;
    private FrameLayout hwC;
    private PkRankStartInfoView hwD;
    private PkRankStartInfoView hwE;
    private AnimatorSet hwF;
    private Runnable hwG;
    private a hwH;
    private FrameLayout hwz;

    /* loaded from: classes4.dex */
    public interface a {
        void onAnimEnd();
    }

    public PkRankStartAnimView(Context context) {
        super(context);
        setBackgroundColor(Integer.MIN_VALUE);
    }

    public void setCallback(a aVar) {
        this.hwH = aVar;
    }

    public void bT(int i, int i2) {
        bU(i, i2);
        cgK();
        cgL();
        int i3 = (int) (i * 0.5f);
        int i4 = (int) (i2 * 0.6183575f * 0.5f);
        int i5 = (int) ((i2 * 58.0f) / 414.0f);
        L(i3, i4, i5);
        M(i3, i4, i5);
        cgM();
        cgN();
    }

    public void setData(o oVar, o oVar2) {
        if (this.hwD != null) {
            this.hwD.setData(oVar);
            this.hwD.setVisibility(8);
        }
        if (this.hwE != null) {
            this.hwE.setData(oVar2);
            this.hwE.setVisibility(8);
        }
    }

    public void Ib(String str) {
        Animator streakAnim;
        Animator streakAnim2;
        if (this.aZA != null && !TextUtils.isEmpty(str)) {
            this.hwA.setVisibility(8);
            this.aZA.getView().setVisibility(0);
            this.aZA.play(str);
        } else {
            if (this.aZA != null) {
                this.aZA.getView().setVisibility(8);
            }
            this.hwA.setVisibility(0);
            this.hwG = new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankStartAnimView.this.hwH != null) {
                        PkRankStartAnimView.this.hwH.onAnimEnd();
                    }
                }
            };
            postDelayed(this.hwG, IMConnection.RETRY_DELAY_TIMES);
        }
        if (this.hwF != null) {
            this.hwF.cancel();
        }
        this.hwF = new AnimatorSet();
        ArrayList arrayList = null;
        if (this.hwD != null && (streakAnim2 = this.hwD.getStreakAnim()) != null) {
            arrayList = new ArrayList();
            arrayList.add(streakAnim2);
        }
        if (this.hwE != null && (streakAnim = this.hwE.getStreakAnim()) != null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(streakAnim);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.hwF.play(cgO()).with(cgP()).before(animatorSet);
            arrayList.clear();
        } else {
            this.hwF.playTogether(cgO(), cgP());
        }
        this.hwF.setStartDelay(800L);
        this.hwF.start();
    }

    public void stopAnim() {
        if (this.hwG != null) {
            removeCallbacks(this.hwG);
        }
        if (this.aZA != null) {
            this.aZA.stop();
            this.aZA.reset();
        }
        if (this.hwF != null) {
            this.hwF.cancel();
        }
        if (this.hwD != null) {
            this.hwD.release();
        }
        if (this.hwE != null) {
            this.hwE.release();
        }
    }

    public void release() {
        stopAnim();
        if (this.aZA != null) {
            this.aZA.release();
        }
        removeAllViews();
    }

    private void bU(int i, int i2) {
        if (this.hwz == null) {
            this.hwz = new FrameLayout(getContext());
        }
        if (indexOfChild(this.hwz) < 0) {
            addView(this.hwz);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hwz.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.hwz.setLayoutParams(layoutParams);
    }

    private void cgK() {
        if (this.aZA == null || this.aZA.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.aZA = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.aZA != null) {
            if (this.hwz.indexOfChild(this.aZA.getView()) < 0) {
                this.hwz.addView(this.aZA.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.aZA.a(new c.a() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PkRankStartAnimView.this.hwH != null) {
                        PkRankStartAnimView.this.hwH.onAnimEnd();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    onEnd();
                }
            });
            this.aZA.getView().setVisibility(8);
        }
    }

    private void cgL() {
        if (this.hwA == null) {
            this.hwA = new ImageView(getContext());
            this.hwA.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hwA.setImageResource(a.f.pk_rank_start_anim_default);
        }
        if (this.hwz.indexOfChild(this.hwA) < 0) {
            this.hwz.addView(this.hwA, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hwA.setVisibility(8);
    }

    private void L(int i, int i2, int i3) {
        if (this.hwB == null) {
            this.hwB = new FrameLayout(getContext());
        }
        if (this.hwz.indexOfChild(this.hwB) < 0) {
            this.hwz.addView(this.hwB);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hwB.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 51;
        layoutParams.topMargin = i3;
        this.hwB.setLayoutParams(layoutParams);
    }

    private void M(int i, int i2, int i3) {
        if (this.hwC == null) {
            this.hwC = new FrameLayout(getContext());
        }
        if (this.hwz.indexOfChild(this.hwC) < 0) {
            this.hwz.addView(this.hwC);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hwC.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = i3;
        this.hwC.setLayoutParams(layoutParams);
    }

    private void cgM() {
        if (this.hwB != null) {
            if (this.hwD == null) {
                this.hwD = new PkRankStartInfoView(getContext(), false);
            }
            if (this.hwB.indexOfChild(this.hwD) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                this.hwB.addView(this.hwD, layoutParams);
            }
        }
    }

    private void cgN() {
        if (this.hwC != null) {
            if (this.hwE == null) {
                this.hwE = new PkRankStartInfoView(getContext(), true);
            }
            if (this.hwC.indexOfChild(this.hwE) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 19;
                this.hwC.addView(this.hwE, layoutParams);
            }
        }
    }

    private AnimatorSet cgO() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hwD, "translationX", (-this.hwB.getLayoutParams().width) * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hwD, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.hwD.setVisibility(0);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cgP() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hwE, "translationX", this.hwC.getLayoutParams().width * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hwE, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.hwE.setVisibility(0);
            }
        });
        return animatorSet;
    }
}
