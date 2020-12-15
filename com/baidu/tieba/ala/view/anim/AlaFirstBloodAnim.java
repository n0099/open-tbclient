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
    ImageView hZT;
    ImageView hZU;
    AnimatorListenerAdapter hZV;
    public AnimatorSet hZW;
    public AnimatorSet hZX;
    public AnimatorSet hZY;
    public AnimatorSet hZZ;
    boolean isHost;

    public AlaFirstBloodAnim(Context context, boolean z) {
        super(context);
        this.hZW = new AnimatorSet();
        this.hZX = new AnimatorSet();
        this.hZY = new AnimatorSet();
        this.hZZ = new AnimatorSet();
        this.isHost = z;
        init(context);
    }

    private void init(Context context) {
        if (this.isHost) {
            LayoutInflater.from(context).inflate(a.g.ala_pk_rank_firstblood_top_layout, this);
        } else {
            LayoutInflater.from(context).inflate(a.g.ala_pk_rank_firstblood_bottom_layout, this);
        }
        this.hZT = (ImageView) findViewById(a.f.first_blood_cover);
        this.hZU = (ImageView) findViewById(a.f.first_blood_img);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hZT, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hZU, "scaleX", 5.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hZU, "scaleY", 5.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hZU, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hZT, "alpha", 1.0f, 0.0f);
        ofFloat5.setDuration(300L);
        ofFloat5.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hZW.play(ofFloat).with(ofFloat2).with(ofFloat3);
        this.hZY.play(ofFloat5).with(ofFloat4).after(IMConnection.RETRY_DELAY_TIMES);
        this.hZZ.play(this.hZW).before(this.hZX).before(this.hZY);
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.hZV = animatorListenerAdapter;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.eAg = viewGroup;
    }

    @Override // com.baidu.tieba.ala.view.anim.a
    public void startAnim() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.isHost) {
            this.hZT.setImageResource(a.e.pk_rank_black_cover_top);
        } else {
            layoutParams.addRule(12);
            this.hZT.setImageResource(a.e.pk_rank_black_cover_bottom);
        }
        this.eAg.addView(this, layoutParams);
        this.hZZ.addListener(this.hZV);
        this.hZZ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.AlaFirstBloodAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaFirstBloodAnim.this.eAg.removeView(AlaFirstBloodAnim.this);
            }
        });
        this.hZU.setVisibility(0);
        this.hZT.setVisibility(0);
        this.hZZ.start();
    }
}
