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
/* loaded from: classes4.dex */
public class PkRankPropAnim extends RelativeLayout implements a {
    ViewGroup dUq;
    ImageView hig;
    AnimatorListenerAdapter hii;
    private AnimatorSet him;
    ImageView hio;
    TextView hip;
    TextView hiq;
    RelativeLayout hir;
    private AnimatorSet his;
    private AnimatorSet hit;
    private int hiu;
    private boolean isHost;

    public PkRankPropAnim(Context context, boolean z, int i) {
        super(context);
        this.his = new AnimatorSet();
        this.hit = new AnimatorSet();
        this.him = new AnimatorSet();
        this.isHost = z;
        this.hiu = i;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.h.ala_pk_rank_prop_layout, this);
        this.hig = (ImageView) findViewById(a.g.pk_rank_prop_bg_cover);
        this.hir = (RelativeLayout) findViewById(a.g.pk_rank_prop_content);
        this.hio = (ImageView) findViewById(a.g.pk_rank_prop_img);
        this.hip = (TextView) findViewById(a.g.pk_rank_prop_title);
        this.hiq = (TextView) findViewById(a.g.pk_rank_prop_tip);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hig, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hig, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(300L);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hir, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hir, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hir, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hir, "scaleY", 1.0f, 0.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.hir, "alpha", 1.0f, 0.0f);
        this.his.play(ofFloat).with(ofFloat3).with(ofFloat4);
        this.hit.play(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).after(IMConnection.RETRY_DELAY_TIMES);
        this.him.play(this.his).before(this.hit);
    }

    public int H(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
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
            this.dUq.addView(this, layoutParams);
        } else {
            layoutParams.addRule(12);
            this.dUq.addView(this, layoutParams);
            this.hig.setImageResource(a.f.pk_rank_black_cover_bottom);
            ((RelativeLayout.LayoutParams) this.hir.getLayoutParams()).topMargin = H(20.0f);
        }
        if (this.hiu == 1) {
            this.hio.setImageResource(a.f.pk_rank_red_potion);
            this.hip.setText(a.i.sdk_pk_rank_potion);
            this.hiq.setText(a.i.sdk_pk_rank_potion_title);
        } else if (this.hiu == 2) {
            this.hio.setImageResource(a.f.pk_rank_boom);
            this.hip.setText(a.i.sdk_pk_rank_smoke);
            this.hiq.setText(a.i.sdk_pk_rank_smoke_tip);
        }
        this.him.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.PkRankPropAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankPropAnim.this.dUq.removeView(PkRankPropAnim.this);
            }
        });
        this.him.addListener(this.hii);
        this.hir.setVisibility(0);
        this.hig.setVisibility(0);
        this.him.start();
    }
}
