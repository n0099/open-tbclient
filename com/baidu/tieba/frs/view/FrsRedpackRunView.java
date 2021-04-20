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
    public AutoScrollTextView f16413e;

    /* renamed from: f  reason: collision with root package name */
    public TBLottieAnimationView f16414f;

    /* renamed from: g  reason: collision with root package name */
    public View f16415g;

    /* renamed from: h  reason: collision with root package name */
    public Context f16416h;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning() && valueAnimator.getAnimatedFraction() > 0.5d) {
                FrsRedpackRunView.this.f16413e.d(valueAnimator.getAnimatedFraction());
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
            FrsRedpackRunView.this.f16413e.a(((Activity) FrsRedpackRunView.this.f16416h).getWindowManager());
            FrsRedpackRunView.this.f16413e.c();
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
        this.f16416h = context;
        d(context);
    }

    public void c() {
    }

    public final void d(Context context) {
        this.f16415g = LayoutInflater.from(context).inflate(R.layout.frs_main_redpack_run_view, this);
        this.f16413e = (AutoScrollTextView) findViewById(R.id.tv_redpack_live_title);
        this.f16414f = (TBLottieAnimationView) findViewById(R.id.frs_tblottie_anim);
    }

    public void e() {
        SkinManager.setLottieAnimation(this.f16414f, R.raw.lottie_redpack_run);
        this.f16414f.setImageAssetsFolder("lottie_redpack_runscoll");
        this.f16414f.addAnimatorUpdateListener(new a());
        this.f16414f.addAnimatorListener(new b());
        this.f16414f.playAnimation();
    }

    public void setClickliner(View.OnClickListener onClickListener) {
        View view = this.f16415g;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
        AutoScrollTextView autoScrollTextView = this.f16413e;
        if (autoScrollTextView != null) {
            autoScrollTextView.setClickliner(onClickListener);
        }
    }

    public void settextTitle(String str) {
        AutoScrollTextView autoScrollTextView = this.f16413e;
        if (autoScrollTextView != null) {
            autoScrollTextView.setText(str);
            this.f16413e.a(((Activity) this.f16416h).getWindowManager());
            e();
        }
    }

    public FrsRedpackRunView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16416h = context;
        d(context);
    }
}
