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
    private com.baidu.live.alphavideo.c baY;
    private FrameLayout hIW;
    private ImageView hIX;
    private FrameLayout hIY;
    private FrameLayout hIZ;
    private PkRankStartInfoView hJa;
    private PkRankStartInfoView hJb;
    private AnimatorSet hJc;
    private Runnable hJd;
    private a hJe;

    /* loaded from: classes4.dex */
    public interface a {
        void onAnimEnd();
    }

    public PkRankStartAnimView(Context context) {
        super(context);
        setBackgroundColor(Integer.MIN_VALUE);
    }

    public void setCallback(a aVar) {
        this.hJe = aVar;
    }

    public void bV(int i, int i2) {
        bW(i, i2);
        cjR();
        cjS();
        int i3 = (int) (i * 0.5f);
        int i4 = (int) (i2 * 0.6183575f * 0.5f);
        int i5 = (int) ((i2 * 58.0f) / 414.0f);
        N(i3, i4, i5);
        O(i3, i4, i5);
        cjT();
        cjU();
    }

    public void setData(q qVar, q qVar2) {
        if (this.hJa != null) {
            this.hJa.setData(qVar);
            this.hJa.setVisibility(8);
        }
        if (this.hJb != null) {
            this.hJb.setData(qVar2);
            this.hJb.setVisibility(8);
        }
    }

    public void IA(String str) {
        Animator streakAnim;
        Animator streakAnim2;
        if (this.baY != null && !TextUtils.isEmpty(str)) {
            this.hIX.setVisibility(8);
            this.baY.getView().setVisibility(0);
            this.baY.play(str);
        } else {
            if (this.baY != null) {
                this.baY.getView().setVisibility(8);
            }
            this.hIX.setVisibility(0);
            this.hJd = new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankStartAnimView.this.hJe != null) {
                        PkRankStartAnimView.this.hJe.onAnimEnd();
                    }
                }
            };
            postDelayed(this.hJd, IMConnection.RETRY_DELAY_TIMES);
        }
        if (this.hJc != null) {
            this.hJc.cancel();
        }
        this.hJc = new AnimatorSet();
        ArrayList arrayList = null;
        if (this.hJa != null && (streakAnim2 = this.hJa.getStreakAnim()) != null) {
            arrayList = new ArrayList();
            arrayList.add(streakAnim2);
        }
        if (this.hJb != null && (streakAnim = this.hJb.getStreakAnim()) != null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(streakAnim);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.hJc.play(cjV()).with(cjW()).before(animatorSet);
            arrayList.clear();
        } else {
            this.hJc.playTogether(cjV(), cjW());
        }
        this.hJc.setStartDelay(800L);
        this.hJc.start();
    }

    public void stopAnim() {
        if (this.hJd != null) {
            removeCallbacks(this.hJd);
        }
        if (this.baY != null) {
            this.baY.stop();
            this.baY.reset();
        }
        if (this.hJc != null) {
            this.hJc.cancel();
        }
        if (this.hJa != null) {
            this.hJa.release();
        }
        if (this.hJb != null) {
            this.hJb.release();
        }
    }

    public void release() {
        stopAnim();
        if (this.baY != null) {
            this.baY.release();
        }
        removeAllViews();
    }

    private void bW(int i, int i2) {
        if (this.hIW == null) {
            this.hIW = new FrameLayout(getContext());
        }
        if (indexOfChild(this.hIW) < 0) {
            addView(this.hIW);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hIW.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.hIW.setLayoutParams(layoutParams);
    }

    private void cjR() {
        if (this.baY == null || this.baY.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.baY = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.baY != null) {
            if (this.hIW.indexOfChild(this.baY.getView()) < 0) {
                this.hIW.addView(this.baY.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.baY.a(new c.a() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PkRankStartAnimView.this.hJe != null) {
                        PkRankStartAnimView.this.hJe.onAnimEnd();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    onEnd();
                }
            });
            this.baY.getView().setVisibility(8);
        }
    }

    private void cjS() {
        if (this.hIX == null) {
            this.hIX = new ImageView(getContext());
            this.hIX.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hIX.setImageResource(a.f.pk_rank_start_anim_default);
        }
        if (this.hIW.indexOfChild(this.hIX) < 0) {
            this.hIW.addView(this.hIX, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hIX.setVisibility(8);
    }

    private void N(int i, int i2, int i3) {
        if (this.hIY == null) {
            this.hIY = new FrameLayout(getContext());
        }
        if (this.hIW.indexOfChild(this.hIY) < 0) {
            this.hIW.addView(this.hIY);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hIY.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 51;
        layoutParams.topMargin = i3;
        this.hIY.setLayoutParams(layoutParams);
    }

    private void O(int i, int i2, int i3) {
        if (this.hIZ == null) {
            this.hIZ = new FrameLayout(getContext());
        }
        if (this.hIW.indexOfChild(this.hIZ) < 0) {
            this.hIW.addView(this.hIZ);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hIZ.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = i3;
        this.hIZ.setLayoutParams(layoutParams);
    }

    private void cjT() {
        if (this.hIY != null) {
            if (this.hJa == null) {
                this.hJa = new PkRankStartInfoView(getContext(), false);
            }
            if (this.hIY.indexOfChild(this.hJa) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                this.hIY.addView(this.hJa, layoutParams);
            }
        }
    }

    private void cjU() {
        if (this.hIZ != null) {
            if (this.hJb == null) {
                this.hJb = new PkRankStartInfoView(getContext(), true);
            }
            if (this.hIZ.indexOfChild(this.hJb) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 19;
                this.hIZ.addView(this.hJb, layoutParams);
            }
        }
    }

    private AnimatorSet cjV() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hJa, "translationX", (-this.hIY.getLayoutParams().width) * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hJa, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.hJa.setVisibility(0);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cjW() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hJb, "translationX", this.hIZ.getLayoutParams().width * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hJb, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.hJb.setVisibility(0);
            }
        });
        return animatorSet;
    }
}
