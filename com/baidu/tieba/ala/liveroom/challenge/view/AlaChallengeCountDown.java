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
/* loaded from: classes4.dex */
public class AlaChallengeCountDown extends LinearLayout {
    private int count;
    private ImageView hmW;
    private TextView hmX;
    private boolean hmY;
    private boolean hmZ;
    private Context mContext;
    private int maxCount;
    private View rootView;

    public AlaChallengeCountDown(Context context) {
        super(context);
        this.maxCount = 3;
        this.count = this.maxCount;
        this.hmY = false;
        this.hmZ = false;
        init(context);
    }

    public AlaChallengeCountDown(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.maxCount = 3;
        this.count = this.maxCount;
        this.hmY = false;
        this.hmZ = false;
        init(context);
    }

    public AlaChallengeCountDown(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maxCount = 3;
        this.count = this.maxCount;
        this.hmY = false;
        this.hmZ = false;
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        this.rootView = View.inflate(context, a.g.ala_challenge_count_down, this);
        this.hmW = (ImageView) this.rootView.findViewById(a.f.ala_challenge_count_down_bg);
        this.hmX = (TextView) this.rootView.findViewById(a.f.ala_challenge_count_down_time);
        this.hmW.setAlpha(0.0f);
        this.hmX.setVisibility(8);
    }

    public void setMaxCountDownNum(int i) {
        this.maxCount = i;
    }

    private void cdS() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeCountDown.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AlaChallengeCountDown.this.hmW.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0205a.challenge_count_down_roll);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        loadAnimation.setDuration(700L);
        loadAnimation.setInterpolator(linearInterpolator);
        this.hmW.setVisibility(0);
        this.hmW.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdT() {
        if (this.count <= 0) {
            cdV();
            return;
        }
        this.hmX.setText(String.valueOf(this.count));
        this.hmX.setVisibility(0);
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
                AlaChallengeCountDown.this.hmX.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaChallengeCountDown.this.cdT();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.hmX.startAnimation(animationSet);
    }

    public void cdU() {
        this.hmY = false;
        this.hmZ = false;
        if (this.hmW != null) {
            this.hmW.setVisibility(8);
            this.hmW.clearAnimation();
        }
        if (this.hmX != null) {
            this.hmX.setVisibility(8);
            this.hmX.clearAnimation();
        }
    }

    public void cdV() {
        if (!this.hmZ) {
            this.hmZ = true;
            if (this.hmW != null) {
                this.hmW.setVisibility(8);
                this.hmW.clearAnimation();
            }
            if (this.hmX != null) {
                this.hmX.setVisibility(8);
                this.hmX.clearAnimation();
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
                    AlaChallengeCountDown.this.hmY = false;
                    AlaChallengeCountDown.this.hmZ = false;
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
        if (!this.hmY) {
            this.hmZ = false;
            this.hmY = true;
            this.count = this.maxCount;
            this.rootView.setAlpha(1.0f);
            cdS();
            cdT();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.hmX != null) {
            this.hmX.clearAnimation();
        }
        if (this.hmW != null) {
            this.hmW.clearAnimation();
        }
    }
}
