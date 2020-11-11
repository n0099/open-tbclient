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
    private com.baidu.live.alphavideo.c bcq;
    private FrameLayout hOT;
    private ImageView hOU;
    private FrameLayout hOV;
    private FrameLayout hOW;
    private PkRankStartInfoView hOX;
    private PkRankStartInfoView hOY;
    private AnimatorSet hOZ;
    private Runnable hPa;
    private a hPb;

    /* loaded from: classes4.dex */
    public interface a {
        void onAnimEnd();
    }

    public PkRankStartAnimView(Context context) {
        super(context);
        setBackgroundColor(Integer.MIN_VALUE);
    }

    public void setCallback(a aVar) {
        this.hPb = aVar;
    }

    public void bX(int i, int i2) {
        bY(i, i2);
        cmt();
        cmu();
        int i3 = (int) (i * 0.5f);
        int i4 = (int) (i2 * 0.6183575f * 0.5f);
        int i5 = (int) ((i2 * 58.0f) / 414.0f);
        N(i3, i4, i5);
        O(i3, i4, i5);
        cmv();
        cmw();
    }

    public void setData(q qVar, q qVar2) {
        if (this.hOX != null) {
            this.hOX.setData(qVar);
            this.hOX.setVisibility(8);
        }
        if (this.hOY != null) {
            this.hOY.setData(qVar2);
            this.hOY.setVisibility(8);
        }
    }

    public void IR(String str) {
        Animator streakAnim;
        Animator streakAnim2;
        if (this.bcq != null && !TextUtils.isEmpty(str)) {
            this.hOU.setVisibility(8);
            this.bcq.getView().setVisibility(0);
            this.bcq.play(str);
        } else {
            if (this.bcq != null) {
                this.bcq.getView().setVisibility(8);
            }
            this.hOU.setVisibility(0);
            this.hPa = new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankStartAnimView.this.hPb != null) {
                        PkRankStartAnimView.this.hPb.onAnimEnd();
                    }
                }
            };
            postDelayed(this.hPa, IMConnection.RETRY_DELAY_TIMES);
        }
        if (this.hOZ != null) {
            this.hOZ.cancel();
        }
        this.hOZ = new AnimatorSet();
        ArrayList arrayList = null;
        if (this.hOX != null && (streakAnim2 = this.hOX.getStreakAnim()) != null) {
            arrayList = new ArrayList();
            arrayList.add(streakAnim2);
        }
        if (this.hOY != null && (streakAnim = this.hOY.getStreakAnim()) != null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(streakAnim);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.hOZ.play(cmx()).with(cmy()).before(animatorSet);
            arrayList.clear();
        } else {
            this.hOZ.playTogether(cmx(), cmy());
        }
        this.hOZ.setStartDelay(800L);
        this.hOZ.start();
    }

    public void stopAnim() {
        if (this.hPa != null) {
            removeCallbacks(this.hPa);
        }
        if (this.bcq != null) {
            this.bcq.stop();
            this.bcq.reset();
        }
        if (this.hOZ != null) {
            this.hOZ.cancel();
        }
        if (this.hOX != null) {
            this.hOX.release();
        }
        if (this.hOY != null) {
            this.hOY.release();
        }
    }

    public void release() {
        stopAnim();
        if (this.bcq != null) {
            this.bcq.release();
        }
        removeAllViews();
    }

    private void bY(int i, int i2) {
        if (this.hOT == null) {
            this.hOT = new FrameLayout(getContext());
        }
        if (indexOfChild(this.hOT) < 0) {
            addView(this.hOT);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hOT.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.hOT.setLayoutParams(layoutParams);
    }

    private void cmt() {
        if (this.bcq == null || this.bcq.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bcq = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.bcq != null) {
            if (this.hOT.indexOfChild(this.bcq.getView()) < 0) {
                this.hOT.addView(this.bcq.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.bcq.a(new c.a() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PkRankStartAnimView.this.hPb != null) {
                        PkRankStartAnimView.this.hPb.onAnimEnd();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    onEnd();
                }
            });
            this.bcq.getView().setVisibility(8);
        }
    }

    private void cmu() {
        if (this.hOU == null) {
            this.hOU = new ImageView(getContext());
            this.hOU.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hOU.setImageResource(a.e.pk_rank_start_anim_default);
        }
        if (this.hOT.indexOfChild(this.hOU) < 0) {
            this.hOT.addView(this.hOU, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hOU.setVisibility(8);
    }

    private void N(int i, int i2, int i3) {
        if (this.hOV == null) {
            this.hOV = new FrameLayout(getContext());
        }
        if (this.hOT.indexOfChild(this.hOV) < 0) {
            this.hOT.addView(this.hOV);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hOV.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 51;
        layoutParams.topMargin = i3;
        this.hOV.setLayoutParams(layoutParams);
    }

    private void O(int i, int i2, int i3) {
        if (this.hOW == null) {
            this.hOW = new FrameLayout(getContext());
        }
        if (this.hOT.indexOfChild(this.hOW) < 0) {
            this.hOT.addView(this.hOW);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hOW.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = i3;
        this.hOW.setLayoutParams(layoutParams);
    }

    private void cmv() {
        if (this.hOV != null) {
            if (this.hOX == null) {
                this.hOX = new PkRankStartInfoView(getContext(), false);
            }
            if (this.hOV.indexOfChild(this.hOX) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                this.hOV.addView(this.hOX, layoutParams);
            }
        }
    }

    private void cmw() {
        if (this.hOW != null) {
            if (this.hOY == null) {
                this.hOY = new PkRankStartInfoView(getContext(), true);
            }
            if (this.hOW.indexOfChild(this.hOY) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 19;
                this.hOW.addView(this.hOY, layoutParams);
            }
        }
    }

    private AnimatorSet cmx() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hOX, "translationX", (-this.hOV.getLayoutParams().width) * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hOX, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.hOX.setVisibility(0);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cmy() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hOY, "translationX", this.hOW.getLayoutParams().width * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hOY, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.hOY.setVisibility(0);
            }
        });
        return animatorSet;
    }
}
