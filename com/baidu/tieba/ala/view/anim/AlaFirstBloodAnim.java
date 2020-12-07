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
    ViewGroup eAg;
    ImageView hZR;
    ImageView hZS;
    AnimatorListenerAdapter hZT;
    public AnimatorSet hZU;
    public AnimatorSet hZV;
    public AnimatorSet hZW;
    public AnimatorSet hZX;
    boolean isHost;

    public AlaFirstBloodAnim(Context context, boolean z) {
        super(context);
        this.hZU = new AnimatorSet();
        this.hZV = new AnimatorSet();
        this.hZW = new AnimatorSet();
        this.hZX = new AnimatorSet();
        this.isHost = z;
        init(context);
    }

    private void init(Context context) {
        if (this.isHost) {
            LayoutInflater.from(context).inflate(a.g.ala_pk_rank_firstblood_top_layout, this);
        } else {
            LayoutInflater.from(context).inflate(a.g.ala_pk_rank_firstblood_bottom_layout, this);
        }
        this.hZR = (ImageView) findViewById(a.f.first_blood_cover);
        this.hZS = (ImageView) findViewById(a.f.first_blood_img);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hZR, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hZS, "scaleX", 5.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hZS, "scaleY", 5.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hZS, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hZR, "alpha", 1.0f, 0.0f);
        ofFloat5.setDuration(300L);
        ofFloat5.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hZU.play(ofFloat).with(ofFloat2).with(ofFloat3);
        this.hZW.play(ofFloat5).with(ofFloat4).after(IMConnection.RETRY_DELAY_TIMES);
        this.hZX.play(this.hZU).before(this.hZV).before(this.hZW);
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.hZT = animatorListenerAdapter;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.eAg = viewGroup;
    }

    @Override // com.baidu.tieba.ala.view.anim.a
    public void startAnim() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.isHost) {
            this.hZR.setImageResource(a.e.pk_rank_black_cover_top);
        } else {
            layoutParams.addRule(12);
            this.hZR.setImageResource(a.e.pk_rank_black_cover_bottom);
        }
        this.eAg.addView(this, layoutParams);
        this.hZX.addListener(this.hZT);
        this.hZX.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.AlaFirstBloodAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaFirstBloodAnim.this.eAg.removeView(AlaFirstBloodAnim.this);
            }
        });
        this.hZS.setVisibility(0);
        this.hZR.setVisibility(0);
        this.hZX.start();
    }
}
