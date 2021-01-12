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
    private com.baidu.live.alphavideo.c bbc;
    private FrameLayout ibr;
    private ImageView ibs;
    private Runnable ibt;
    private FrameLayout iho;
    private FrameLayout ihp;
    private PkRankStartInfoView ihq;
    private PkRankStartInfoView ihr;
    private AnimatorSet ihs;
    private a iht;

    /* loaded from: classes10.dex */
    public interface a {
        void cnx();
    }

    public PkRankStartAnimView(Context context) {
        super(context);
        setBackgroundColor(Integer.MIN_VALUE);
    }

    public void setCallback(a aVar) {
        this.iht = aVar;
    }

    public void bZ(int i, int i2) {
        ca(i, i2);
        cnD();
        cnE();
        int i3 = (int) (i * 0.5f);
        int i4 = (int) (i2 * 0.6183575f * 0.5f);
        int i5 = (int) ((i2 * 58.0f) / 414.0f);
        Q(i3, i4, i5);
        R(i3, i4, i5);
        cpe();
        cpf();
    }

    public void setData(q qVar, q qVar2) {
        if (this.ihq != null) {
            this.ihq.setData(qVar);
            this.ihq.setVisibility(8);
        }
        if (this.ihr != null) {
            this.ihr.setData(qVar2);
            this.ihr.setVisibility(8);
        }
    }

    public void HQ(String str) {
        Animator streakAnim;
        Animator streakAnim2;
        if (this.bbc != null && !TextUtils.isEmpty(str)) {
            this.ibs.setVisibility(8);
            this.bbc.getView().setVisibility(0);
            this.bbc.play(str);
        } else {
            if (this.bbc != null) {
                this.bbc.getView().setVisibility(8);
            }
            this.ibs.setVisibility(0);
            this.ibt = new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankStartAnimView.this.iht != null) {
                        PkRankStartAnimView.this.iht.cnx();
                    }
                }
            };
            postDelayed(this.ibt, IMConnection.RETRY_DELAY_TIMES);
        }
        if (this.ihs != null) {
            this.ihs.cancel();
        }
        this.ihs = new AnimatorSet();
        ArrayList arrayList = null;
        if (this.ihq != null && (streakAnim2 = this.ihq.getStreakAnim()) != null) {
            arrayList = new ArrayList();
            arrayList.add(streakAnim2);
        }
        if (this.ihr != null && (streakAnim = this.ihr.getStreakAnim()) != null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(streakAnim);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.ihs.play(cpg()).with(cph()).before(animatorSet);
            arrayList.clear();
        } else {
            this.ihs.playTogether(cpg(), cph());
        }
        this.ihs.setStartDelay(800L);
        this.ihs.start();
    }

    public void stopAnim() {
        if (this.ibt != null) {
            removeCallbacks(this.ibt);
        }
        if (this.bbc != null) {
            this.bbc.stop();
            this.bbc.reset();
        }
        if (this.ihs != null) {
            this.ihs.cancel();
        }
        if (this.ihq != null) {
            this.ihq.release();
        }
        if (this.ihr != null) {
            this.ihr.release();
        }
    }

    public void release() {
        stopAnim();
        if (this.bbc != null) {
            this.bbc.release();
        }
        removeAllViews();
    }

    private void ca(int i, int i2) {
        if (this.ibr == null) {
            this.ibr = new FrameLayout(getContext());
        }
        if (indexOfChild(this.ibr) < 0) {
            addView(this.ibr);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ibr.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.ibr.setLayoutParams(layoutParams);
    }

    private void cnD() {
        if (this.bbc == null || this.bbc.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bbc = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.bbc != null) {
            if (this.ibr.indexOfChild(this.bbc.getView()) < 0) {
                this.ibr.addView(this.bbc.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.bbc.a(new c.a() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PkRankStartAnimView.this.iht != null) {
                        PkRankStartAnimView.this.iht.cnx();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    onEnd();
                }
            });
            this.bbc.getView().setVisibility(8);
        }
    }

    private void cnE() {
        if (this.ibs == null) {
            this.ibs = new ImageView(getContext());
            this.ibs.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ibs.setImageResource(a.e.pk_rank_start_anim_default);
        }
        if (this.ibr.indexOfChild(this.ibs) < 0) {
            this.ibr.addView(this.ibs, new ViewGroup.LayoutParams(-1, -1));
        }
        this.ibs.setVisibility(8);
    }

    private void Q(int i, int i2, int i3) {
        if (this.iho == null) {
            this.iho = new FrameLayout(getContext());
        }
        if (this.ibr.indexOfChild(this.iho) < 0) {
            this.ibr.addView(this.iho);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iho.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 51;
        layoutParams.topMargin = i3;
        this.iho.setLayoutParams(layoutParams);
    }

    private void R(int i, int i2, int i3) {
        if (this.ihp == null) {
            this.ihp = new FrameLayout(getContext());
        }
        if (this.ibr.indexOfChild(this.ihp) < 0) {
            this.ibr.addView(this.ihp);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ihp.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = i3;
        this.ihp.setLayoutParams(layoutParams);
    }

    private void cpe() {
        if (this.iho != null) {
            if (this.ihq == null) {
                this.ihq = new PkRankStartInfoView(getContext(), false);
            }
            if (this.iho.indexOfChild(this.ihq) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                this.iho.addView(this.ihq, layoutParams);
            }
        }
    }

    private void cpf() {
        if (this.ihp != null) {
            if (this.ihr == null) {
                this.ihr = new PkRankStartInfoView(getContext(), true);
            }
            if (this.ihp.indexOfChild(this.ihr) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 19;
                this.ihp.addView(this.ihr, layoutParams);
            }
        }
    }

    private AnimatorSet cpg() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ihq, "translationX", (-this.iho.getLayoutParams().width) * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ihq, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.ihq.setVisibility(0);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cph() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ihr, "translationX", this.ihp.getLayoutParams().width * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ihr, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.ihr.setVisibility(0);
            }
        });
        return animatorSet;
    }
}
