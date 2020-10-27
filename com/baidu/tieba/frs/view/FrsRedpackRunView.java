package com.baidu.tieba.frs.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class FrsRedpackRunView extends RelativeLayout {
    private AutoScrollTextView jib;
    private TBLottieAnimationView jic;
    private String mContent;
    private Context mContext;
    private View rootView;

    public FrsRedpackRunView(Context context) {
        super(context);
        this.mContext = context;
        initUI(context);
    }

    public FrsRedpackRunView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI(context);
    }

    private void initUI(Context context) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.frs_main_redpack_run_view, this);
        this.jib = (AutoScrollTextView) findViewById(R.id.tv_redpack_live_title);
        this.jic = (TBLottieAnimationView) findViewById(R.id.frs_tblottie_anim);
    }

    public void settextTitle(String str) {
        if (this.jib != null) {
            this.mContent = str;
            this.jib.setText(str);
            this.jib.b(((Activity) this.mContext).getWindowManager());
            show();
        }
    }

    public void show() {
        ap.a(this.jic, R.raw.lottie_redpack_run);
        this.jic.setImageAssetsFolder("lottie_redpack_runscoll");
        this.jic.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.view.FrsRedpackRunView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && valueAnimator.getAnimatedFraction() > 0.5d) {
                    FrsRedpackRunView.this.jib.aw(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jic.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.view.FrsRedpackRunView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FrsRedpackRunView.this.jib.b(((Activity) FrsRedpackRunView.this.mContext).getWindowManager());
                FrsRedpackRunView.this.jib.cyy();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jic.playAnimation();
    }

    public void hide() {
    }

    public void setClickliner(View.OnClickListener onClickListener) {
        if (this.rootView != null) {
            this.rootView.setOnClickListener(onClickListener);
        }
        if (this.jib != null) {
            this.jib.setClickliner(onClickListener);
        }
    }
}
