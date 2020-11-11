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
    ViewGroup euJ;
    public AnimatorSet hPA;
    ImageView hPu;
    ImageView hPv;
    AnimatorListenerAdapter hPw;
    public AnimatorSet hPx;
    public AnimatorSet hPy;
    public AnimatorSet hPz;
    boolean isHost;

    public AlaFirstBloodAnim(Context context, boolean z) {
        super(context);
        this.hPx = new AnimatorSet();
        this.hPy = new AnimatorSet();
        this.hPz = new AnimatorSet();
        this.hPA = new AnimatorSet();
        this.isHost = z;
        init(context);
    }

    private void init(Context context) {
        if (this.isHost) {
            LayoutInflater.from(context).inflate(a.g.ala_pk_rank_firstblood_top_layout, this);
        } else {
            LayoutInflater.from(context).inflate(a.g.ala_pk_rank_firstblood_bottom_layout, this);
        }
        this.hPu = (ImageView) findViewById(a.f.first_blood_cover);
        this.hPv = (ImageView) findViewById(a.f.first_blood_img);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hPu, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hPv, "scaleX", 5.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hPv, "scaleY", 5.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hPv, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hPu, "alpha", 1.0f, 0.0f);
        ofFloat5.setDuration(300L);
        ofFloat5.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hPx.play(ofFloat).with(ofFloat2).with(ofFloat3);
        this.hPz.play(ofFloat5).with(ofFloat4).after(IMConnection.RETRY_DELAY_TIMES);
        this.hPA.play(this.hPx).before(this.hPy).before(this.hPz);
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.hPw = animatorListenerAdapter;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.euJ = viewGroup;
    }

    @Override // com.baidu.tieba.ala.view.anim.a
    public void startAnim() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.isHost) {
            this.hPu.setImageResource(a.e.pk_rank_black_cover_top);
        } else {
            layoutParams.addRule(12);
            this.hPu.setImageResource(a.e.pk_rank_black_cover_bottom);
        }
        this.euJ.addView(this, layoutParams);
        this.hPA.addListener(this.hPw);
        this.hPA.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.AlaFirstBloodAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaFirstBloodAnim.this.euJ.removeView(AlaFirstBloodAnim.this);
            }
        });
        this.hPv.setVisibility(0);
        this.hPu.setVisibility(0);
        this.hPA.start();
    }
}
