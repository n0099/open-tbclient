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
    ViewGroup egs;
    ImageView hxb;
    ImageView hxc;
    AnimatorListenerAdapter hxd;
    public AnimatorSet hxe;
    public AnimatorSet hxf;
    public AnimatorSet hxg;
    public AnimatorSet hxh;
    boolean isHost;

    public AlaFirstBloodAnim(Context context, boolean z) {
        super(context);
        this.hxe = new AnimatorSet();
        this.hxf = new AnimatorSet();
        this.hxg = new AnimatorSet();
        this.hxh = new AnimatorSet();
        this.isHost = z;
        init(context);
    }

    private void init(Context context) {
        if (this.isHost) {
            LayoutInflater.from(context).inflate(a.h.ala_pk_rank_firstblood_top_layout, this);
        } else {
            LayoutInflater.from(context).inflate(a.h.ala_pk_rank_firstblood_bottom_layout, this);
        }
        this.hxb = (ImageView) findViewById(a.g.first_blood_cover);
        this.hxc = (ImageView) findViewById(a.g.first_blood_img);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hxb, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hxc, "scaleX", 5.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hxc, "scaleY", 5.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hxc, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hxb, "alpha", 1.0f, 0.0f);
        ofFloat5.setDuration(300L);
        ofFloat5.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hxe.play(ofFloat).with(ofFloat2).with(ofFloat3);
        this.hxg.play(ofFloat5).with(ofFloat4).after(IMConnection.RETRY_DELAY_TIMES);
        this.hxh.play(this.hxe).before(this.hxf).before(this.hxg);
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.hxd = animatorListenerAdapter;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.egs = viewGroup;
    }

    @Override // com.baidu.tieba.ala.view.anim.a
    public void startAnim() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.isHost) {
            this.hxb.setImageResource(a.f.pk_rank_black_cover_top);
        } else {
            layoutParams.addRule(12);
            this.hxb.setImageResource(a.f.pk_rank_black_cover_bottom);
        }
        this.egs.addView(this, layoutParams);
        this.hxh.addListener(this.hxd);
        this.hxh.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.AlaFirstBloodAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaFirstBloodAnim.this.egs.removeView(AlaFirstBloodAnim.this);
            }
        });
        this.hxc.setVisibility(0);
        this.hxb.setVisibility(0);
        this.hxh.start();
    }
}
