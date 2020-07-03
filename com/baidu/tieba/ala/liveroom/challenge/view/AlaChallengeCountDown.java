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
/* loaded from: classes3.dex */
public class AlaChallengeCountDown extends LinearLayout {
    private int count;
    private ImageView gcr;
    private TextView gcs;
    private boolean gct;
    private boolean gcu;
    private Context mContext;
    private int maxCount;
    private View rootView;

    public AlaChallengeCountDown(Context context) {
        super(context);
        this.maxCount = 3;
        this.count = this.maxCount;
        this.gct = false;
        this.gcu = false;
        init(context);
    }

    public AlaChallengeCountDown(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.maxCount = 3;
        this.count = this.maxCount;
        this.gct = false;
        this.gcu = false;
        init(context);
    }

    public AlaChallengeCountDown(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maxCount = 3;
        this.count = this.maxCount;
        this.gct = false;
        this.gcu = false;
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        this.rootView = View.inflate(context, a.h.ala_challenge_count_down, this);
        this.gcr = (ImageView) this.rootView.findViewById(a.g.ala_challenge_count_down_bg);
        this.gcs = (TextView) this.rootView.findViewById(a.g.ala_challenge_count_down_time);
        this.gcr.setAlpha(0.0f);
        this.gcs.setVisibility(8);
    }

    public void setMaxCountDownNum(int i) {
        this.maxCount = i;
    }

    private void bDw() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeCountDown.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AlaChallengeCountDown.this.gcr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, a.C0176a.challenge_count_down_roll);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        loadAnimation.setDuration(700L);
        loadAnimation.setInterpolator(linearInterpolator);
        this.gcr.setVisibility(0);
        this.gcr.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDx() {
        if (this.count <= 0) {
            bDz();
            return;
        }
        this.gcs.setText(String.valueOf(this.count));
        this.gcs.setVisibility(0);
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
                AlaChallengeCountDown.this.gcs.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaChallengeCountDown.this.bDx();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.gcs.startAnimation(animationSet);
    }

    public void bDy() {
        this.gct = false;
        this.gcu = false;
        if (this.gcr != null) {
            this.gcr.setVisibility(8);
            this.gcr.clearAnimation();
        }
        if (this.gcs != null) {
            this.gcs.setVisibility(8);
            this.gcs.clearAnimation();
        }
    }

    public void bDz() {
        if (!this.gcu) {
            this.gcu = true;
            if (this.gcr != null) {
                this.gcr.setVisibility(8);
                this.gcr.clearAnimation();
            }
            if (this.gcs != null) {
                this.gcs.setVisibility(8);
                this.gcs.clearAnimation();
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
                    AlaChallengeCountDown.this.gct = false;
                    AlaChallengeCountDown.this.gcu = false;
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
        if (!this.gct) {
            this.gcu = false;
            this.gct = true;
            this.count = this.maxCount;
            this.rootView.setAlpha(1.0f);
            bDw();
            bDx();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gcs != null) {
            this.gcs.clearAnimation();
        }
        if (this.gcr != null) {
            this.gcr.clearAnimation();
        }
    }
}
