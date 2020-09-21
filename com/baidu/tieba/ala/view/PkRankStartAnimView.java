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
    private com.baidu.live.alphavideo.c aWp;
    private FrameLayout hhD;
    private ImageView hhE;
    private FrameLayout hhF;
    private FrameLayout hhG;
    private PkRankStartInfoView hhH;
    private PkRankStartInfoView hhI;
    private AnimatorSet hhJ;
    private Runnable hhK;
    private a hhL;

    /* loaded from: classes4.dex */
    public interface a {
        void onAnimEnd();
    }

    public PkRankStartAnimView(Context context) {
        super(context);
        setBackgroundColor(Integer.MIN_VALUE);
    }

    public void setCallback(a aVar) {
        this.hhL = aVar;
    }

    public void bT(int i, int i2) {
        bU(i, i2);
        cdo();
        cdp();
        int i3 = (int) (i * 0.5f);
        int i4 = (int) (i2 * 0.6183575f * 0.5f);
        int i5 = (int) ((i2 * 58.0f) / 414.0f);
        L(i3, i4, i5);
        M(i3, i4, i5);
        cdq();
        cdr();
    }

    public void setData(o oVar, o oVar2) {
        if (this.hhH != null) {
            this.hhH.setData(oVar);
            this.hhH.setVisibility(8);
        }
        if (this.hhI != null) {
            this.hhI.setData(oVar2);
            this.hhI.setVisibility(8);
        }
    }

    public void Ho(String str) {
        Animator streakAnim;
        Animator streakAnim2;
        if (this.aWp != null && !TextUtils.isEmpty(str)) {
            this.hhE.setVisibility(8);
            this.aWp.getView().setVisibility(0);
            this.aWp.play(str);
        } else {
            if (this.aWp != null) {
                this.aWp.getView().setVisibility(8);
            }
            this.hhE.setVisibility(0);
            this.hhK = new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankStartAnimView.this.hhL != null) {
                        PkRankStartAnimView.this.hhL.onAnimEnd();
                    }
                }
            };
            postDelayed(this.hhK, IMConnection.RETRY_DELAY_TIMES);
        }
        if (this.hhJ != null) {
            this.hhJ.cancel();
        }
        this.hhJ = new AnimatorSet();
        ArrayList arrayList = null;
        if (this.hhH != null && (streakAnim2 = this.hhH.getStreakAnim()) != null) {
            arrayList = new ArrayList();
            arrayList.add(streakAnim2);
        }
        if (this.hhI != null && (streakAnim = this.hhI.getStreakAnim()) != null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(streakAnim);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.hhJ.play(cds()).with(cdt()).before(animatorSet);
            arrayList.clear();
        } else {
            this.hhJ.playTogether(cds(), cdt());
        }
        this.hhJ.setStartDelay(800L);
        this.hhJ.start();
    }

    public void stopAnim() {
        if (this.hhK != null) {
            removeCallbacks(this.hhK);
        }
        if (this.aWp != null) {
            this.aWp.stop();
            this.aWp.reset();
        }
        if (this.hhJ != null) {
            this.hhJ.cancel();
        }
        if (this.hhH != null) {
            this.hhH.release();
        }
        if (this.hhI != null) {
            this.hhI.release();
        }
    }

    public void release() {
        stopAnim();
        if (this.aWp != null) {
            this.aWp.release();
        }
        removeAllViews();
    }

    private void bU(int i, int i2) {
        if (this.hhD == null) {
            this.hhD = new FrameLayout(getContext());
        }
        if (indexOfChild(this.hhD) < 0) {
            addView(this.hhD);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hhD.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.hhD.setLayoutParams(layoutParams);
    }

    private void cdo() {
        if (this.aWp == null || this.aWp.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.aWp = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.aWp != null) {
            if (this.hhD.indexOfChild(this.aWp.getView()) < 0) {
                this.hhD.addView(this.aWp.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.aWp.a(new c.a() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PkRankStartAnimView.this.hhL != null) {
                        PkRankStartAnimView.this.hhL.onAnimEnd();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    onEnd();
                }
            });
            this.aWp.getView().setVisibility(8);
        }
    }

    private void cdp() {
        if (this.hhE == null) {
            this.hhE = new ImageView(getContext());
            this.hhE.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hhE.setImageResource(a.f.pk_rank_start_anim_default);
        }
        if (this.hhD.indexOfChild(this.hhE) < 0) {
            this.hhD.addView(this.hhE, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hhE.setVisibility(8);
    }

    private void L(int i, int i2, int i3) {
        if (this.hhF == null) {
            this.hhF = new FrameLayout(getContext());
        }
        if (this.hhD.indexOfChild(this.hhF) < 0) {
            this.hhD.addView(this.hhF);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hhF.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 51;
        layoutParams.topMargin = i3;
        this.hhF.setLayoutParams(layoutParams);
    }

    private void M(int i, int i2, int i3) {
        if (this.hhG == null) {
            this.hhG = new FrameLayout(getContext());
        }
        if (this.hhD.indexOfChild(this.hhG) < 0) {
            this.hhD.addView(this.hhG);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hhG.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = i3;
        this.hhG.setLayoutParams(layoutParams);
    }

    private void cdq() {
        if (this.hhF != null) {
            if (this.hhH == null) {
                this.hhH = new PkRankStartInfoView(getContext(), false);
            }
            if (this.hhF.indexOfChild(this.hhH) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 21;
                this.hhF.addView(this.hhH, layoutParams);
            }
        }
    }

    private void cdr() {
        if (this.hhG != null) {
            if (this.hhI == null) {
                this.hhI = new PkRankStartInfoView(getContext(), true);
            }
            if (this.hhG.indexOfChild(this.hhI) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 19;
                this.hhG.addView(this.hhI, layoutParams);
            }
        }
    }

    private AnimatorSet cds() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hhH, "translationX", (-this.hhF.getLayoutParams().width) * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hhH, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.hhH.setVisibility(0);
            }
        });
        return animatorSet;
    }

    private AnimatorSet cdt() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hhI, "translationX", this.hhG.getLayoutParams().width * 0.25f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hhI, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAnimView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAnimView.this.hhI.setVisibility(0);
            }
        });
        return animatorSet;
    }
}
