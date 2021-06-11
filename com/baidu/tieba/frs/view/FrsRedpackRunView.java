package com.baidu.tieba.frs.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsRedpackRunView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public AutoScrollTextView f15933e;

    /* renamed from: f  reason: collision with root package name */
    public TBLottieAnimationView f15934f;

    /* renamed from: g  reason: collision with root package name */
    public View f15935g;

    /* renamed from: h  reason: collision with root package name */
    public Context f15936h;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning() && valueAnimator.getAnimatedFraction() > 0.5d) {
                FrsRedpackRunView.this.f15933e.d(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FrsRedpackRunView.this.f15933e.a(((Activity) FrsRedpackRunView.this.f15936h).getWindowManager());
            FrsRedpackRunView.this.f15933e.c();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public FrsRedpackRunView(Context context) {
        super(context);
        this.f15936h = context;
        d(context);
    }

    public void c() {
    }

    public final void d(Context context) {
        this.f15935g = LayoutInflater.from(context).inflate(R.layout.frs_main_redpack_run_view, this);
        this.f15933e = (AutoScrollTextView) findViewById(R.id.tv_redpack_live_title);
        this.f15934f = (TBLottieAnimationView) findViewById(R.id.frs_tblottie_anim);
    }

    public void e() {
        SkinManager.setLottieAnimation(this.f15934f, R.raw.lottie_redpack_run);
        this.f15934f.setImageAssetsFolder("lottie_redpack_runscoll");
        this.f15934f.addAnimatorUpdateListener(new a());
        this.f15934f.addAnimatorListener(new b());
        this.f15934f.playAnimation();
    }

    public void setClickliner(View.OnClickListener onClickListener) {
        View view = this.f15935g;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
        AutoScrollTextView autoScrollTextView = this.f15933e;
        if (autoScrollTextView != null) {
            autoScrollTextView.setClickliner(onClickListener);
        }
    }

    public void settextTitle(String str) {
        AutoScrollTextView autoScrollTextView = this.f15933e;
        if (autoScrollTextView != null) {
            autoScrollTextView.setText(str);
            this.f15933e.a(((Activity) this.f15936h).getWindowManager());
            e();
        }
    }

    public FrsRedpackRunView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15936h = context;
        d(context);
    }
}
