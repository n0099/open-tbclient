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
    ViewGroup egs;
    ImageView hxb;
    AnimatorListenerAdapter hxd;
    private AnimatorSet hxh;
    ImageView hxj;
    TextView hxk;
    TextView hxl;
    RelativeLayout hxm;
    private AnimatorSet hxn;
    private AnimatorSet hxo;
    private int hxp;
    private boolean isHost;

    public PkRankPropAnim(Context context, boolean z, int i) {
        super(context);
        this.hxn = new AnimatorSet();
        this.hxo = new AnimatorSet();
        this.hxh = new AnimatorSet();
        this.isHost = z;
        this.hxp = i;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.h.ala_pk_rank_prop_layout, this);
        this.hxb = (ImageView) findViewById(a.g.pk_rank_prop_bg_cover);
        this.hxm = (RelativeLayout) findViewById(a.g.pk_rank_prop_content);
        this.hxj = (ImageView) findViewById(a.g.pk_rank_prop_img);
        this.hxk = (TextView) findViewById(a.g.pk_rank_prop_title);
        this.hxl = (TextView) findViewById(a.g.pk_rank_prop_tip);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hxb, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hxb, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(300L);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hxm, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hxm, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hxm, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hxm, "scaleY", 1.0f, 0.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.hxm, "alpha", 1.0f, 0.0f);
        this.hxn.play(ofFloat).with(ofFloat3).with(ofFloat4);
        this.hxo.play(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).after(IMConnection.RETRY_DELAY_TIMES);
        this.hxh.play(this.hxn).before(this.hxo);
    }

    public int J(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
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
            this.egs.addView(this, layoutParams);
        } else {
            layoutParams.addRule(12);
            this.egs.addView(this, layoutParams);
            this.hxb.setImageResource(a.f.pk_rank_black_cover_bottom);
            ((RelativeLayout.LayoutParams) this.hxm.getLayoutParams()).topMargin = J(20.0f);
        }
        if (this.hxp == 1) {
            this.hxj.setImageResource(a.f.pk_rank_red_potion);
            this.hxk.setText(a.i.sdk_pk_rank_potion);
            this.hxl.setText(a.i.sdk_pk_rank_potion_title);
        } else if (this.hxp == 2) {
            this.hxj.setImageResource(a.f.pk_rank_boom);
            this.hxk.setText(a.i.sdk_pk_rank_smoke);
            this.hxl.setText(a.i.sdk_pk_rank_smoke_tip);
        }
        this.hxh.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.PkRankPropAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankPropAnim.this.egs.removeView(PkRankPropAnim.this);
            }
        });
        this.hxh.addListener(this.hxd);
        this.hxm.setVisibility(0);
        this.hxb.setVisibility(0);
        this.hxh.start();
    }
}
