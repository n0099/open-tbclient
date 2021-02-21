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
    private FrameLayout igd;
    private ImageView ige;
    private Runnable igf;
    private FrameLayout inc;
    private FrameLayout ind;
    private PkRankStartInfoView ine;
    private PkRankStartInfoView inf;
    private AnimatorSet ing;
    private a inh;

    /* loaded from: classes11.dex */
    public interface a {
        void coC();
    }

    public PkRankStartAnimView(Context context) {
        super(context);
        setBackgroundColor(Integer.MIN_VALUE);
    }

    public void setCallback(a aVar) {
        this.inh = aVar;
    }

    public void bX(int i, int i2) {
        bY(i, i2);
        coI();
        coJ();
        int i3 = (int) (i * 0.5f);
        int i4 = (int) (i2 * 0.6183575f * 0.5f);
        int i5 = (int) ((i2 * 58.0f) / 414.0f);
        Q(i3, i4, i5);
        R(i3, i4, i5);
        cqs();
        cqt();
    }

    public void setData(q qVar, q qVar2) {
        if (this.ine != null) {
            this.ine.setData(qVar);
            this.ine.setVisibility(8);
        }
        if (this.inf != null) {
            this.inf.setData(qVar2);
            this.inf.setVisibility(8);
        }
    }

    public void Iv(String str) {
        Animator streakAnim;
        Animator streakAnim2;
        if (this.bei != null && !TextUtils.isEmpty(str)) {
            this.ige.setVisibility(8);
            this.bei.getView().setVisibility(0);
            this.bei.play(str);
        } else {
            if (this.bei != null) {
                this.bei.getView().setVisibility(8);
            }
            this.ige.setVisibility(0);
            this.igf = new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankStartAnimView.this.inh != null) {
                        PkRankStartAnimView.this.inh.coC();
                    }
                }
            };
            postDelayed(this.igf, IMConnection.RETRY_DELAY_TIMES);
        }
        if (this.ing != null) {
            this.ing.cancel();
        }
        this.ing = new AnimatorSet();
        ArrayList arrayList = null;
        if (this.ine != null && (streakAnim2 = this.ine.getStreakAnim()) != null) {
            arrayList = new ArrayList();
            arrayList.add(streakAnim2);
        }
        if (this.inf != null && (streakAnim = this.inf.getStreakAnim()) != null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(streakAnim);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.ing.play(cqu()).with(cqv()).before(animatorSet);
            arrayList.clear();
        } else {
            this.ing.playTogether(cqu(), cqv());
        }
        this.ing.setStartDelay(800L);
        this.ing.start();
    }

    public void stopAnim() {
        if (this.igf != null) {
            removeCallbacks(this.igf);
        }
        if (this.bei != null) {
            this.bei.stop();
            this.bei.reset();
        }
        if (this.ing != null) {
            this.ing.cancel();
        }
        if (this.ine != null) {
            this.ine.release();
        }
        if (this.inf != null) {
            this.inf.release();
        }
    }

    public void release() {
        stopAnim();
        if (this.bei != null) {
            this.bei.release();
        }
        removeAllViews();
    }

    private void bY(int i, int i2) {
        if (this.igd == null) {
            this.igd = new FrameLayout(getContext());
        }
        if (indexOfChild(this.igd) < 0) {
            addView(this.igd);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.igd.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.igd.setLayoutParams(layoutParams);
    }

    private void coI() {
        if (this.bei == null || this.bei.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bei = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.bei != null) {
            if (this.igd.indexOfChild(this.bei.getView()) < 0) {
                this.igd.addView(this.bei.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.bei.a(new c.a() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PkRankStartAnimView.this.inh != null) {
                        PkRankStartAnimView.this.inh.coC();
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

    private void coJ() {
        if (this.ige == null) {
            this.ige = new ImageView(getContext());
            this.ige.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ige.setImageResource(a.e.pk_rank_start_anim_default);
        }
        if (this.igd.indexOfChild(this.ige) < 0) {
            this.igd.addView(this.ige, new ViewGroup.LayoutParams(-1, -1));
        }
        this.ige.setVisibility(8);
    }

    private void Q(int i, int i2, int i3) {
        if (this.inc == null) {
            this.inc = new FrameLayout(getContext());
        }
        if (this.igd.indexOfChild(this.inc) < 0) {
            this.igd.addView(this.inc);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.inc.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 51;
        layoutParams.topMargin = i3;
        this.inc.setLayoutParams(layoutParams);
    }

    private void R(int i, int i2, int i3) {
        if (this.ind == null) {
            this.ind = new FrameLayout(getContext());
        }
        if (this.igd.indexOfChild(this.ind) < 0) {
            this.igd.addView(this.ind);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ind.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = i3;
        this.ind.setLayoutParams(layoutParams);
    }

    private void cqs() {
        if (this.inc != null) {
            if (this.ine == null) {
                this.ine = new PkRankStartInfoView(getContext(), false);
            }
            if (this.inc.indexOfChild(this.ine) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                this.inc.addView(this.ine, layoutParams);
            }
        }
    }

    private void cqt() {
        if (this.ind != null) {
            if (this.inf == null) {
                this.inf = new PkRankStartInfoView(getContext(), true);
            }
            if (this.ind.indexOfChild(this.inf) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 19;
                this.ind.addView(this.inf, layoutParams);
            }
        }
    }

    private AnimatorSet cqu() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ine, "translationX", (-this.inc.getLayoutParams().width) * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ine, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.ine.setVisibility(0);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cqv() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.inf, "translationX", this.ind.getLayoutParams().width * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.inf, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.inf.setVisibility(0);
            }
        });
        return animatorSet;
    }
}
