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
    private FrameLayout hTA;
    private ImageView hTB;
    private Runnable hTC;
    private FrameLayout hZu;
    private FrameLayout hZv;
    private PkRankStartInfoView hZw;
    private PkRankStartInfoView hZx;
    private AnimatorSet hZy;
    private a hZz;

    /* loaded from: classes4.dex */
    public interface a {
        void onAnimEnd();
    }

    public PkRankStartAnimView(Context context) {
        super(context);
        setBackgroundColor(Integer.MIN_VALUE);
    }

    public void setCallback(a aVar) {
        this.hZz = aVar;
    }

    public void ca(int i, int i2) {
        cb(i, i2);
        coA();
        coB();
        int i3 = (int) (i * 0.5f);
        int i4 = (int) (i2 * 0.6183575f * 0.5f);
        int i5 = (int) ((i2 * 58.0f) / 414.0f);
        O(i3, i4, i5);
        P(i3, i4, i5);
        cqb();
        cqc();
    }

    public void setData(q qVar, q qVar2) {
        if (this.hZw != null) {
            this.hZw.setData(qVar);
            this.hZw.setVisibility(8);
        }
        if (this.hZx != null) {
            this.hZx.setData(qVar2);
            this.hZx.setVisibility(8);
        }
    }

    public void Je(String str) {
        Animator streakAnim;
        Animator streakAnim2;
        if (this.bef != null && !TextUtils.isEmpty(str)) {
            this.hTB.setVisibility(8);
            this.bef.getView().setVisibility(0);
            this.bef.play(str);
        } else {
            if (this.bef != null) {
                this.bef.getView().setVisibility(8);
            }
            this.hTB.setVisibility(0);
            this.hTC = new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankStartAnimView.this.hZz != null) {
                        PkRankStartAnimView.this.hZz.onAnimEnd();
                    }
                }
            };
            postDelayed(this.hTC, IMConnection.RETRY_DELAY_TIMES);
        }
        if (this.hZy != null) {
            this.hZy.cancel();
        }
        this.hZy = new AnimatorSet();
        ArrayList arrayList = null;
        if (this.hZw != null && (streakAnim2 = this.hZw.getStreakAnim()) != null) {
            arrayList = new ArrayList();
            arrayList.add(streakAnim2);
        }
        if (this.hZx != null && (streakAnim = this.hZx.getStreakAnim()) != null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(streakAnim);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.hZy.play(cqd()).with(cqe()).before(animatorSet);
            arrayList.clear();
        } else {
            this.hZy.playTogether(cqd(), cqe());
        }
        this.hZy.setStartDelay(800L);
        this.hZy.start();
    }

    public void stopAnim() {
        if (this.hTC != null) {
            removeCallbacks(this.hTC);
        }
        if (this.bef != null) {
            this.bef.stop();
            this.bef.reset();
        }
        if (this.hZy != null) {
            this.hZy.cancel();
        }
        if (this.hZw != null) {
            this.hZw.release();
        }
        if (this.hZx != null) {
            this.hZx.release();
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
        if (this.hTA == null) {
            this.hTA = new FrameLayout(getContext());
        }
        if (indexOfChild(this.hTA) < 0) {
            addView(this.hTA);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hTA.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.hTA.setLayoutParams(layoutParams);
    }

    private void coA() {
        if (this.bef == null || this.bef.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bef = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.bef != null) {
            if (this.hTA.indexOfChild(this.bef.getView()) < 0) {
                this.hTA.addView(this.bef.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.bef.a(new c.a() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PkRankStartAnimView.this.hZz != null) {
                        PkRankStartAnimView.this.hZz.onAnimEnd();
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

    private void coB() {
        if (this.hTB == null) {
            this.hTB = new ImageView(getContext());
            this.hTB.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hTB.setImageResource(a.e.pk_rank_start_anim_default);
        }
        if (this.hTA.indexOfChild(this.hTB) < 0) {
            this.hTA.addView(this.hTB, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hTB.setVisibility(8);
    }

    private void O(int i, int i2, int i3) {
        if (this.hZu == null) {
            this.hZu = new FrameLayout(getContext());
        }
        if (this.hTA.indexOfChild(this.hZu) < 0) {
            this.hTA.addView(this.hZu);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hZu.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 51;
        layoutParams.topMargin = i3;
        this.hZu.setLayoutParams(layoutParams);
    }

    private void P(int i, int i2, int i3) {
        if (this.hZv == null) {
            this.hZv = new FrameLayout(getContext());
        }
        if (this.hTA.indexOfChild(this.hZv) < 0) {
            this.hTA.addView(this.hZv);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hZv.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = i3;
        this.hZv.setLayoutParams(layoutParams);
    }

    private void cqb() {
        if (this.hZu != null) {
            if (this.hZw == null) {
                this.hZw = new PkRankStartInfoView(getContext(), false);
            }
            if (this.hZu.indexOfChild(this.hZw) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                this.hZu.addView(this.hZw, layoutParams);
            }
        }
    }

    private void cqc() {
        if (this.hZv != null) {
            if (this.hZx == null) {
                this.hZx = new PkRankStartInfoView(getContext(), true);
            }
            if (this.hZv.indexOfChild(this.hZx) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 19;
                this.hZv.addView(this.hZx, layoutParams);
            }
        }
    }

    private AnimatorSet cqd() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hZw, "translationX", (-this.hZu.getLayoutParams().width) * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hZw, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.hZw.setVisibility(0);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cqe() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hZx, "translationX", this.hZv.getLayoutParams().width * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hZx, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.hZx.setVisibility(0);
            }
        });
        return animatorSet;
    }
}
