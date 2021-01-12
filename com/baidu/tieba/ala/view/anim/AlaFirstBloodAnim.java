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
/* loaded from: classes10.dex */
public class AlaFirstBloodAnim extends RelativeLayout implements a {
    ViewGroup eEY;
    ImageView ihL;
    ImageView ihM;
    AnimatorListenerAdapter ihN;
    public AnimatorSet ihO;
    public AnimatorSet ihP;
    public AnimatorSet ihQ;
    public AnimatorSet ihR;
    boolean isHost;

    public AlaFirstBloodAnim(Context context, boolean z) {
        super(context);
        this.ihO = new AnimatorSet();
        this.ihP = new AnimatorSet();
        this.ihQ = new AnimatorSet();
        this.ihR = new AnimatorSet();
        this.isHost = z;
        init(context);
    }

    private void init(Context context) {
        if (this.isHost) {
            LayoutInflater.from(context).inflate(a.g.ala_pk_rank_firstblood_top_layout, this);
        } else {
            LayoutInflater.from(context).inflate(a.g.ala_pk_rank_firstblood_bottom_layout, this);
        }
        this.ihL = (ImageView) findViewById(a.f.first_blood_cover);
        this.ihM = (ImageView) findViewById(a.f.first_blood_img);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ihL, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ihM, "scaleX", 5.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.ihM, "scaleY", 5.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.ihM, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.ihL, "alpha", 1.0f, 0.0f);
        ofFloat5.setDuration(300L);
        ofFloat5.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ihO.play(ofFloat).with(ofFloat2).with(ofFloat3);
        this.ihQ.play(ofFloat5).with(ofFloat4).after(IMConnection.RETRY_DELAY_TIMES);
        this.ihR.play(this.ihO).before(this.ihP).before(this.ihQ);
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.ihN = animatorListenerAdapter;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.eEY = viewGroup;
    }

    @Override // com.baidu.tieba.ala.view.anim.a
    public void startAnim() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.isHost) {
            this.ihL.setImageResource(a.e.pk_rank_black_cover_top);
        } else {
            layoutParams.addRule(12);
            this.ihL.setImageResource(a.e.pk_rank_black_cover_bottom);
        }
        this.eEY.addView(this, layoutParams);
        this.ihR.addListener(this.ihN);
        this.ihR.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.AlaFirstBloodAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaFirstBloodAnim.this.eEY.removeView(AlaFirstBloodAnim.this);
            }
        });
        this.ihM.setVisibility(0);
        this.ihL.setVisibility(0);
        this.ihR.start();
    }
}
