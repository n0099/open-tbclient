package com.baidu.tieba.ala.view.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class PkRankPropAnim extends RelativeLayout implements a {
    ViewGroup eIG;
    private AnimatorSet iiB;
    TextView ipA;
    RelativeLayout ipB;
    private AnimatorSet ipC;
    private AnimatorSet ipD;
    private int ipE;
    ImageView ipr;
    AnimatorListenerAdapter ipt;
    ImageView ipy;
    TextView ipz;
    private boolean isHost;

    public PkRankPropAnim(Context context, boolean z, int i) {
        super(context);
        this.ipC = new AnimatorSet();
        this.ipD = new AnimatorSet();
        this.iiB = new AnimatorSet();
        this.isHost = z;
        this.ipE = i;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.ala_pk_rank_prop_layout, this);
        this.ipr = (ImageView) findViewById(a.f.pk_rank_prop_bg_cover);
        this.ipB = (RelativeLayout) findViewById(a.f.pk_rank_prop_content);
        this.ipy = (ImageView) findViewById(a.f.pk_rank_prop_img);
        this.ipz = (TextView) findViewById(a.f.pk_rank_prop_title);
        this.ipA = (TextView) findViewById(a.f.pk_rank_prop_tip);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ipr, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ipr, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(300L);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.ipB, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.ipB, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.ipB, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.ipB, "scaleY", 1.0f, 0.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.ipB, "alpha", 1.0f, 0.0f);
        this.ipC.play(ofFloat).with(ofFloat3).with(ofFloat4);
        this.ipD.play(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).after(IMConnection.RETRY_DELAY_TIMES);
        this.iiB.play(this.ipC).before(this.ipD);
    }

    public int T(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.ipt = animatorListenerAdapter;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.eIG = viewGroup;
    }

    @Override // com.baidu.tieba.ala.view.anim.a
    public void startAnim() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.isHost) {
            this.ipr.setImageResource(a.e.pk_rank_black_cover_top);
            this.eIG.addView(this, layoutParams);
        } else {
            layoutParams.addRule(12);
            this.eIG.addView(this, layoutParams);
            this.ipr.setImageResource(a.e.pk_rank_black_cover_bottom);
            ((RelativeLayout.LayoutParams) this.ipB.getLayoutParams()).topMargin = T(20.0f);
        }
        if (this.ipE == 1) {
            this.ipy.setImageResource(a.e.pk_rank_red_potion);
            this.ipz.setText(a.h.sdk_pk_rank_potion);
            this.ipA.setText(a.h.sdk_pk_rank_potion_title);
        } else if (this.ipE == 2) {
            this.ipy.setImageResource(a.e.pk_rank_boom);
            this.ipz.setText(a.h.sdk_pk_rank_smoke);
            this.ipA.setText(a.h.sdk_pk_rank_smoke_tip);
        }
        this.iiB.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.PkRankPropAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankPropAnim.this.eIG.removeView(PkRankPropAnim.this);
            }
        });
        this.iiB.addListener(this.ipt);
        this.ipB.setVisibility(0);
        this.ipr.setVisibility(0);
        this.iiB.start();
    }
}
