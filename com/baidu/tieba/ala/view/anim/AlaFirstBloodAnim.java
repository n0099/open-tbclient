package com.baidu.tieba.ala.view.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaFirstBloodAnim extends RelativeLayout implements a {
    ViewGroup dUq;
    ImageView hig;
    ImageView hih;
    AnimatorListenerAdapter hii;
    public AnimatorSet hij;
    public AnimatorSet hik;
    public AnimatorSet hil;
    public AnimatorSet him;
    boolean isHost;

    public AlaFirstBloodAnim(Context context, boolean z) {
        super(context);
        this.hij = new AnimatorSet();
        this.hik = new AnimatorSet();
        this.hil = new AnimatorSet();
        this.him = new AnimatorSet();
        this.isHost = z;
        init(context);
    }

    private void init(Context context) {
        if (this.isHost) {
            LayoutInflater.from(context).inflate(a.h.ala_pk_rank_firstblood_top_layout, this);
        } else {
            LayoutInflater.from(context).inflate(a.h.ala_pk_rank_firstblood_bottom_layout, this);
        }
        this.hig = (ImageView) findViewById(a.g.first_blood_cover);
        this.hih = (ImageView) findViewById(a.g.first_blood_img);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hig, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hih, "scaleX", 5.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hih, "scaleY", 5.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hih, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hig, "alpha", 1.0f, 0.0f);
        ofFloat5.setDuration(300L);
        ofFloat5.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hij.play(ofFloat).with(ofFloat2).with(ofFloat3);
        this.hil.play(ofFloat5).with(ofFloat4).after(IMConnection.RETRY_DELAY_TIMES);
        this.him.play(this.hij).before(this.hik).before(this.hil);
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.hii = animatorListenerAdapter;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.dUq = viewGroup;
    }

    @Override // com.baidu.tieba.ala.view.anim.a
    public void startAnim() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.isHost) {
            this.hig.setImageResource(a.f.pk_rank_black_cover_top);
        } else {
            layoutParams.addRule(12);
            this.hig.setImageResource(a.f.pk_rank_black_cover_bottom);
        }
        this.dUq.addView(this, layoutParams);
        this.him.addListener(this.hii);
        this.him.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.AlaFirstBloodAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaFirstBloodAnim.this.dUq.removeView(AlaFirstBloodAnim.this);
            }
        });
        this.hih.setVisibility(0);
        this.hig.setVisibility(0);
        this.him.start();
    }
}
