package com.baidu.tieba.ala.liveroom.guide;

import android.animation.Animator;
import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaLivePriseGuideView extends LinearLayout {
    private ArrayList<LottieAnimationView> gRV;
    private LottieAnimationView gRW;
    private boolean isShowing;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlaLivePriseGuideView(Context context) {
        super(context);
        this.gRV = new ArrayList<>();
        initUI();
    }

    public boolean bXc() {
        if (this.gRW != null) {
            this.gRW.cancelAnimation();
            this.gRW = null;
        }
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (this.isShowing) {
            this.isShowing = false;
            return true;
        }
        return false;
    }

    private void initUI() {
        LottieAnimationView lottieAnimationView;
        int i = 0;
        while (true) {
            if (i >= this.gRV.size()) {
                lottieAnimationView = null;
                break;
            }
            lottieAnimationView = this.gRV.get(i);
            if (!lottieAnimationView.isAnimating()) {
                break;
            }
            i++;
        }
        int applyDimension = (int) TypedValue.applyDimension(1, 133, getResources().getDisplayMetrics());
        int applyDimension2 = (int) TypedValue.applyDimension(1, 143, getResources().getDisplayMetrics());
        if (lottieAnimationView == null) {
            final LottieAnimationView lottieAnimationView2 = new LottieAnimationView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(applyDimension, applyDimension2);
            layoutParams.gravity = 1;
            lottieAnimationView2.setLayoutParams(layoutParams);
            lottieAnimationView2.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.guide.AlaLivePriseGuideView.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    lottieAnimationView2.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    lottieAnimationView2.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            try {
                lottieAnimationView2.setImageAssetsFolder("/");
                lottieAnimationView2.setAnimation("praise_click_guide.json");
                addView(lottieAnimationView2);
                this.gRV.add(lottieAnimationView2);
                lottieAnimationView = lottieAnimationView2;
            } catch (Exception e) {
                Log.i("DetailPraise", e.getMessage());
            }
        }
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.bringToFront();
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
            this.gRW = lottieAnimationView;
            this.isShowing = true;
        }
    }
}
