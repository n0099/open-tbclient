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
    ViewGroup eoQ;
    public AnimatorSet hJA;
    public AnimatorSet hJB;
    public AnimatorSet hJC;
    public AnimatorSet hJD;
    ImageView hJx;
    ImageView hJy;
    AnimatorListenerAdapter hJz;
    boolean isHost;

    public AlaFirstBloodAnim(Context context, boolean z) {
        super(context);
        this.hJA = new AnimatorSet();
        this.hJB = new AnimatorSet();
        this.hJC = new AnimatorSet();
        this.hJD = new AnimatorSet();
        this.isHost = z;
        init(context);
    }

    private void init(Context context) {
        if (this.isHost) {
            LayoutInflater.from(context).inflate(a.h.ala_pk_rank_firstblood_top_layout, this);
        } else {
            LayoutInflater.from(context).inflate(a.h.ala_pk_rank_firstblood_bottom_layout, this);
        }
        this.hJx = (ImageView) findViewById(a.g.first_blood_cover);
        this.hJy = (ImageView) findViewById(a.g.first_blood_img);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hJx, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hJy, "scaleX", 5.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hJy, "scaleY", 5.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hJy, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hJx, "alpha", 1.0f, 0.0f);
        ofFloat5.setDuration(300L);
        ofFloat5.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hJA.play(ofFloat).with(ofFloat2).with(ofFloat3);
        this.hJC.play(ofFloat5).with(ofFloat4).after(IMConnection.RETRY_DELAY_TIMES);
        this.hJD.play(this.hJA).before(this.hJB).before(this.hJC);
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.hJz = animatorListenerAdapter;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.eoQ = viewGroup;
    }

    @Override // com.baidu.tieba.ala.view.anim.a
    public void startAnim() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.isHost) {
            this.hJx.setImageResource(a.f.pk_rank_black_cover_top);
        } else {
            layoutParams.addRule(12);
            this.hJx.setImageResource(a.f.pk_rank_black_cover_bottom);
        }
        this.eoQ.addView(this, layoutParams);
        this.hJD.addListener(this.hJz);
        this.hJD.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.AlaFirstBloodAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaFirstBloodAnim.this.eoQ.removeView(AlaFirstBloodAnim.this);
            }
        });
        this.hJy.setVisibility(0);
        this.hJx.setVisibility(0);
        this.hJD.start();
    }
}
