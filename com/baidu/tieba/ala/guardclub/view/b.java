package com.baidu.tieba.ala.guardclub.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import com.baidu.live.guardclub.f;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class b {
    private ImageView aBf;
    private AnimatorSet ggA;
    private AnimatorSet ggB;
    private ImageView ggt;
    private TextSwitcher ggu;
    private boolean ggv;
    private f ggw;
    private boolean ggx;
    private GradientDrawable ggy;
    private GradientDrawable ggz;
    private boolean isHost;
    private Context mContext;
    private View mView;

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.bal > 0) {
                    if (this.ggw != null && TextUtils.equals(this.ggw.aLM, fVar.aLM) && TextUtils.equals(this.ggw.baI, fVar.baI)) {
                        if (fVar.bal != this.ggw.bal) {
                            this.ggu.setText("Lv." + fVar.bal + "级");
                            return;
                        }
                        return;
                    }
                    this.ggw = fVar;
                    str = "Lv." + fVar.bal + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aH(0, "");
                if (this.ggx || z) {
                    str = null;
                } else {
                    this.ggv = this.ggv ? false : true;
                    return;
                }
            }
            this.ggx = z;
            if (!TextUtils.isEmpty(str)) {
                FX(str);
            }
        }
    }

    private Drawable bLS() {
        if (this.ggy != null) {
            return this.ggy;
        }
        this.ggy = new GradientDrawable();
        this.ggy.setShape(0);
        this.ggy.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.ggy.setColors(new int[]{-10026753, -48044});
            this.ggy.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.ggy;
    }

    private Drawable bLT() {
        if (this.ggz != null) {
            return this.ggz;
        }
        this.ggz = new GradientDrawable();
        this.ggz.setShape(0);
        this.ggz.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.ggz.setColors(new int[]{-9549573, -831008});
            this.ggz.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.ggz;
    }

    private void FX(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.ggA = new AnimatorSet();
        this.ggA.setDuration(333L);
        this.ggA.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ggA.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.ggB = new AnimatorSet();
        this.ggB.setDuration(666L);
        this.ggB.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ggB.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.ggB.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aH(1, str);
            }
        });
        this.ggA.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.ggB.start();
            }
        });
        this.ggA.start();
    }

    public void onDestroy() {
        this.ggv = true;
        this.ggw = null;
        this.ggx = false;
        if (this.ggA != null) {
            this.ggA.cancel();
        }
        if (this.ggB != null) {
            this.ggB.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bLS());
                this.ggt.setImageResource(a.f.gcb_icon_enter_not_join);
                this.ggu.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.aBf.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bLT());
                this.ggt.setImageResource(a.f.gcb_icon_enter_joined);
                this.ggu.setCurrentText(str);
                this.aBf.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
