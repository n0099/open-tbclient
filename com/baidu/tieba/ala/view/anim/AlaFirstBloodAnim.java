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
/* loaded from: classes11.dex */
public class AlaFirstBloodAnim extends RelativeLayout implements a {
    ViewGroup eHf;
    public AnimatorSet igS;
    ImageView inI;
    ImageView inJ;
    AnimatorListenerAdapter inK;
    public AnimatorSet inL;
    public AnimatorSet inM;
    public AnimatorSet inN;
    boolean isHost;

    public AlaFirstBloodAnim(Context context, boolean z) {
        super(context);
        this.inL = new AnimatorSet();
        this.inM = new AnimatorSet();
        this.inN = new AnimatorSet();
        this.igS = new AnimatorSet();
        this.isHost = z;
        init(context);
    }

    private void init(Context context) {
        if (this.isHost) {
            LayoutInflater.from(context).inflate(a.g.ala_pk_rank_firstblood_top_layout, this);
        } else {
            LayoutInflater.from(context).inflate(a.g.ala_pk_rank_firstblood_bottom_layout, this);
        }
        this.inI = (ImageView) findViewById(a.f.first_blood_cover);
        this.inJ = (ImageView) findViewById(a.f.first_blood_img);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.inI, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.inJ, "scaleX", 5.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.inJ, "scaleY", 5.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.inJ, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.inI, "alpha", 1.0f, 0.0f);
        ofFloat5.setDuration(300L);
        ofFloat5.setInterpolator(new AccelerateDecelerateInterpolator());
        this.inL.play(ofFloat).with(ofFloat2).with(ofFloat3);
        this.inN.play(ofFloat5).with(ofFloat4).after(IMConnection.RETRY_DELAY_TIMES);
        this.igS.play(this.inL).before(this.inM).before(this.inN);
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.inK = animatorListenerAdapter;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.eHf = viewGroup;
    }

    @Override // com.baidu.tieba.ala.view.anim.a
    public void startAnim() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.isHost) {
            this.inI.setImageResource(a.e.pk_rank_black_cover_top);
        } else {
            layoutParams.addRule(12);
            this.inI.setImageResource(a.e.pk_rank_black_cover_bottom);
        }
        this.eHf.addView(this, layoutParams);
        this.igS.addListener(this.inK);
        this.igS.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.AlaFirstBloodAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaFirstBloodAnim.this.eHf.removeView(AlaFirstBloodAnim.this);
            }
        });
        this.inJ.setVisibility(0);
        this.inI.setVisibility(0);
        this.igS.start();
    }
}
