package com.baidu.tieba.ala.liveroom.challenge.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaChallengeCountDown extends LinearLayout {
    private int count;
    private ImageView hyR;
    private TextView hyS;
    private boolean hyT;
    private boolean hyU;
    private Context mContext;
    private int maxCount;
    private View rootView;

    public AlaChallengeCountDown(Context context) {
        super(context);
        this.maxCount = 3;
        this.count = this.maxCount;
        this.hyT = false;
        this.hyU = false;
        init(context);
    }

    public AlaChallengeCountDown(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.maxCount = 3;
        this.count = this.maxCount;
        this.hyT = false;
        this.hyU = false;
        init(context);
    }

    public AlaChallengeCountDown(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maxCount = 3;
        this.count = this.maxCount;
        this.hyT = false;
        this.hyU = false;
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        this.rootView = View.inflate(context, a.g.ala_challenge_count_down, this);
        this.hyR = (ImageView) this.rootView.findViewById(a.f.ala_challenge_count_down_bg);
        this.hyS = (TextView) this.rootView.findViewById(a.f.ala_challenge_count_down_time);
        this.hyR.setAlpha(0.0f);
        this.hyS.setVisibility(8);
    }

    public void setMaxCountDownNum(int i) {
        this.maxCount = i;
    }

    private void cgI() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeCountDown.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AlaChallengeCountDown.this.hyR.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0203a.challenge_count_down_roll);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        loadAnimation.setDuration(700L);
        loadAnimation.setInterpolator(linearInterpolator);
        this.hyR.setVisibility(0);
        this.hyR.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgJ() {
        if (this.count <= 0) {
            cgL();
            return;
        }
        this.hyS.setText(String.valueOf(this.count));
        this.hyS.setVisibility(0);
        this.count--;
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setStartOffset(650L);
        alphaAnimation.setDuration(350L);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        scaleAnimation.setDuration(650L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeCountDown.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                AlaChallengeCountDown.this.hyS.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaChallengeCountDown.this.cgJ();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hyS.startAnimation(animationSet);
    }

    public void cgK() {
        this.hyT = false;
        this.hyU = false;
        if (this.hyR != null) {
            this.hyR.setVisibility(8);
            this.hyR.clearAnimation();
        }
        if (this.hyS != null) {
            this.hyS.setVisibility(8);
            this.hyS.clearAnimation();
        }
    }

    public void cgL() {
        if (!this.hyU) {
            this.hyU = true;
            if (this.hyR != null) {
                this.hyR.setVisibility(8);
                this.hyR.clearAnimation();
            }
            if (this.hyS != null) {
                this.hyS.setVisibility(8);
                this.hyS.clearAnimation();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeCountDown.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeCountDown.this.rootView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeCountDown.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AlaChallengeCountDown.this.hyT = false;
                    AlaChallengeCountDown.this.hyU = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofFloat.start();
        }
    }

    public void startCountDown() {
        if (!this.hyT) {
            this.hyU = false;
            this.hyT = true;
            this.count = this.maxCount;
            this.rootView.setAlpha(1.0f);
            cgI();
            cgJ();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.hyS != null) {
            this.hyS.clearAnimation();
        }
        if (this.hyR != null) {
            this.hyR.clearAnimation();
        }
    }
}
