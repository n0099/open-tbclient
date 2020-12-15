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
    private com.baidu.live.alphavideo.c bef;
    private FrameLayout hTC;
    private ImageView hTD;
    private Runnable hTE;
    private AnimatorSet hZA;
    private a hZB;
    private FrameLayout hZw;
    private FrameLayout hZx;
    private PkRankStartInfoView hZy;
    private PkRankStartInfoView hZz;

    /* loaded from: classes4.dex */
    public interface a {
        void onAnimEnd();
    }

    public PkRankStartAnimView(Context context) {
        super(context);
        setBackgroundColor(Integer.MIN_VALUE);
    }

    public void setCallback(a aVar) {
        this.hZB = aVar;
    }

    public void ca(int i, int i2) {
        cb(i, i2);
        coB();
        coC();
        int i3 = (int) (i * 0.5f);
        int i4 = (int) (i2 * 0.6183575f * 0.5f);
        int i5 = (int) ((i2 * 58.0f) / 414.0f);
        O(i3, i4, i5);
        P(i3, i4, i5);
        cqc();
        cqd();
    }

    public void setData(q qVar, q qVar2) {
        if (this.hZy != null) {
            this.hZy.setData(qVar);
            this.hZy.setVisibility(8);
        }
        if (this.hZz != null) {
            this.hZz.setData(qVar2);
            this.hZz.setVisibility(8);
        }
    }

    public void Je(String str) {
        Animator streakAnim;
        Animator streakAnim2;
        if (this.bef != null && !TextUtils.isEmpty(str)) {
            this.hTD.setVisibility(8);
            this.bef.getView().setVisibility(0);
            this.bef.play(str);
        } else {
            if (this.bef != null) {
                this.bef.getView().setVisibility(8);
            }
            this.hTD.setVisibility(0);
            this.hTE = new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankStartAnimView.this.hZB != null) {
                        PkRankStartAnimView.this.hZB.onAnimEnd();
                    }
                }
            };
            postDelayed(this.hTE, IMConnection.RETRY_DELAY_TIMES);
        }
        if (this.hZA != null) {
            this.hZA.cancel();
        }
        this.hZA = new AnimatorSet();
        ArrayList arrayList = null;
        if (this.hZy != null && (streakAnim2 = this.hZy.getStreakAnim()) != null) {
            arrayList = new ArrayList();
            arrayList.add(streakAnim2);
        }
        if (this.hZz != null && (streakAnim = this.hZz.getStreakAnim()) != null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(streakAnim);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.hZA.play(cqe()).with(cqf()).before(animatorSet);
            arrayList.clear();
        } else {
            this.hZA.playTogether(cqe(), cqf());
        }
        this.hZA.setStartDelay(800L);
        this.hZA.start();
    }

    public void stopAnim() {
        if (this.hTE != null) {
            removeCallbacks(this.hTE);
        }
        if (this.bef != null) {
            this.bef.stop();
            this.bef.reset();
        }
        if (this.hZA != null) {
            this.hZA.cancel();
        }
        if (this.hZy != null) {
            this.hZy.release();
        }
        if (this.hZz != null) {
            this.hZz.release();
        }
    }

    public void release() {
        stopAnim();
        if (this.bef != null) {
            this.bef.release();
        }
        removeAllViews();
    }

    private void cb(int i, int i2) {
        if (this.hTC == null) {
            this.hTC = new FrameLayout(getContext());
        }
        if (indexOfChild(this.hTC) < 0) {
            addView(this.hTC);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hTC.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.hTC.setLayoutParams(layoutParams);
    }

    private void coB() {
        if (this.bef == null || this.bef.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bef = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.bef != null) {
            if (this.hTC.indexOfChild(this.bef.getView()) < 0) {
                this.hTC.addView(this.bef.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.bef.a(new c.a() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PkRankStartAnimView.this.hZB != null) {
                        PkRankStartAnimView.this.hZB.onAnimEnd();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    onEnd();
                }
            });
            this.bef.getView().setVisibility(8);
        }
    }

    private void coC() {
        if (this.hTD == null) {
            this.hTD = new ImageView(getContext());
            this.hTD.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hTD.setImageResource(a.e.pk_rank_start_anim_default);
        }
        if (this.hTC.indexOfChild(this.hTD) < 0) {
            this.hTC.addView(this.hTD, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hTD.setVisibility(8);
    }

    private void O(int i, int i2, int i3) {
        if (this.hZw == null) {
            this.hZw = new FrameLayout(getContext());
        }
        if (this.hTC.indexOfChild(this.hZw) < 0) {
            this.hTC.addView(this.hZw);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hZw.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 51;
        layoutParams.topMargin = i3;
        this.hZw.setLayoutParams(layoutParams);
    }

    private void P(int i, int i2, int i3) {
        if (this.hZx == null) {
            this.hZx = new FrameLayout(getContext());
        }
        if (this.hTC.indexOfChild(this.hZx) < 0) {
            this.hTC.addView(this.hZx);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hZx.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = i3;
        this.hZx.setLayoutParams(layoutParams);
    }

    private void cqc() {
        if (this.hZw != null) {
            if (this.hZy == null) {
                this.hZy = new PkRankStartInfoView(getContext(), false);
            }
            if (this.hZw.indexOfChild(this.hZy) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                this.hZw.addView(this.hZy, layoutParams);
            }
        }
    }

    private void cqd() {
        if (this.hZx != null) {
            if (this.hZz == null) {
                this.hZz = new PkRankStartInfoView(getContext(), true);
            }
            if (this.hZx.indexOfChild(this.hZz) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 19;
                this.hZx.addView(this.hZz, layoutParams);
            }
        }
    }

    private AnimatorSet cqe() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hZy, "translationX", (-this.hZw.getLayoutParams().width) * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hZy, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.hZy.setVisibility(0);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cqf() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hZz, "translationX", this.hZx.getLayoutParams().width * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hZz, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.hZz.setVisibility(0);
            }
        });
        return animatorSet;
    }
}
