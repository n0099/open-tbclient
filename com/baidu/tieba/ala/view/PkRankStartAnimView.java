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
    private com.baidu.live.alphavideo.c bfS;
    private FrameLayout igc;
    private ImageView igd;
    private Runnable ige;
    private FrameLayout ilV;
    private FrameLayout ilW;
    private PkRankStartInfoView ilX;
    private PkRankStartInfoView ilY;
    private AnimatorSet ilZ;
    private a ima;

    /* loaded from: classes11.dex */
    public interface a {
        void crp();
    }

    public PkRankStartAnimView(Context context) {
        super(context);
        setBackgroundColor(Integer.MIN_VALUE);
    }

    public void setCallback(a aVar) {
        this.ima = aVar;
    }

    public void bZ(int i, int i2) {
        ca(i, i2);
        crv();
        crw();
        int i3 = (int) (i * 0.5f);
        int i4 = (int) (i2 * 0.6183575f * 0.5f);
        int i5 = (int) ((i2 * 58.0f) / 414.0f);
        Q(i3, i4, i5);
        R(i3, i4, i5);
        csW();
        csX();
    }

    public void setData(q qVar, q qVar2) {
        if (this.ilX != null) {
            this.ilX.setData(qVar);
            this.ilX.setVisibility(8);
        }
        if (this.ilY != null) {
            this.ilY.setData(qVar2);
            this.ilY.setVisibility(8);
        }
    }

    public void Jb(String str) {
        Animator streakAnim;
        Animator streakAnim2;
        if (this.bfS != null && !TextUtils.isEmpty(str)) {
            this.igd.setVisibility(8);
            this.bfS.getView().setVisibility(0);
            this.bfS.play(str);
        } else {
            if (this.bfS != null) {
                this.bfS.getView().setVisibility(8);
            }
            this.igd.setVisibility(0);
            this.ige = new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankStartAnimView.this.ima != null) {
                        PkRankStartAnimView.this.ima.crp();
                    }
                }
            };
            postDelayed(this.ige, IMConnection.RETRY_DELAY_TIMES);
        }
        if (this.ilZ != null) {
            this.ilZ.cancel();
        }
        this.ilZ = new AnimatorSet();
        ArrayList arrayList = null;
        if (this.ilX != null && (streakAnim2 = this.ilX.getStreakAnim()) != null) {
            arrayList = new ArrayList();
            arrayList.add(streakAnim2);
        }
        if (this.ilY != null && (streakAnim = this.ilY.getStreakAnim()) != null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(streakAnim);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.ilZ.play(csY()).with(csZ()).before(animatorSet);
            arrayList.clear();
        } else {
            this.ilZ.playTogether(csY(), csZ());
        }
        this.ilZ.setStartDelay(800L);
        this.ilZ.start();
    }

    public void stopAnim() {
        if (this.ige != null) {
            removeCallbacks(this.ige);
        }
        if (this.bfS != null) {
            this.bfS.stop();
            this.bfS.reset();
        }
        if (this.ilZ != null) {
            this.ilZ.cancel();
        }
        if (this.ilX != null) {
            this.ilX.release();
        }
        if (this.ilY != null) {
            this.ilY.release();
        }
    }

    public void release() {
        stopAnim();
        if (this.bfS != null) {
            this.bfS.release();
        }
        removeAllViews();
    }

    private void ca(int i, int i2) {
        if (this.igc == null) {
            this.igc = new FrameLayout(getContext());
        }
        if (indexOfChild(this.igc) < 0) {
            addView(this.igc);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.igc.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.igc.setLayoutParams(layoutParams);
    }

    private void crv() {
        if (this.bfS == null || this.bfS.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bfS = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.bfS != null) {
            if (this.igc.indexOfChild(this.bfS.getView()) < 0) {
                this.igc.addView(this.bfS.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.bfS.a(new c.a() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PkRankStartAnimView.this.ima != null) {
                        PkRankStartAnimView.this.ima.crp();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    onEnd();
                }
            });
            this.bfS.getView().setVisibility(8);
        }
    }

    private void crw() {
        if (this.igd == null) {
            this.igd = new ImageView(getContext());
            this.igd.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.igd.setImageResource(a.e.pk_rank_start_anim_default);
        }
        if (this.igc.indexOfChild(this.igd) < 0) {
            this.igc.addView(this.igd, new ViewGroup.LayoutParams(-1, -1));
        }
        this.igd.setVisibility(8);
    }

    private void Q(int i, int i2, int i3) {
        if (this.ilV == null) {
            this.ilV = new FrameLayout(getContext());
        }
        if (this.igc.indexOfChild(this.ilV) < 0) {
            this.igc.addView(this.ilV);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ilV.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 51;
        layoutParams.topMargin = i3;
        this.ilV.setLayoutParams(layoutParams);
    }

    private void R(int i, int i2, int i3) {
        if (this.ilW == null) {
            this.ilW = new FrameLayout(getContext());
        }
        if (this.igc.indexOfChild(this.ilW) < 0) {
            this.igc.addView(this.ilW);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ilW.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = i3;
        this.ilW.setLayoutParams(layoutParams);
    }

    private void csW() {
        if (this.ilV != null) {
            if (this.ilX == null) {
                this.ilX = new PkRankStartInfoView(getContext(), false);
            }
            if (this.ilV.indexOfChild(this.ilX) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                this.ilV.addView(this.ilX, layoutParams);
            }
        }
    }

    private void csX() {
        if (this.ilW != null) {
            if (this.ilY == null) {
                this.ilY = new PkRankStartInfoView(getContext(), true);
            }
            if (this.ilW.indexOfChild(this.ilY) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 19;
                this.ilW.addView(this.ilY, layoutParams);
            }
        }
    }

    private AnimatorSet csY() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ilX, "translationX", (-this.ilV.getLayoutParams().width) * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ilX, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.ilX.setVisibility(0);
            }
        });
        return animatorSet;
    }

    private AnimatorSet csZ() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ilY, "translationX", this.ilW.getLayoutParams().width * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ilY, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.ilY.setVisibility(0);
            }
        });
        return animatorSet;
    }
}
