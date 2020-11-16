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
    ViewGroup ete;
    ImageView hPb;
    AnimatorListenerAdapter hPd;
    private AnimatorSet hPh;
    ImageView hPj;
    TextView hPk;
    TextView hPl;
    RelativeLayout hPm;
    private AnimatorSet hPn;
    private AnimatorSet hPo;
    private int hPp;
    private boolean isHost;

    public PkRankPropAnim(Context context, boolean z, int i) {
        super(context);
        this.hPn = new AnimatorSet();
        this.hPo = new AnimatorSet();
        this.hPh = new AnimatorSet();
        this.isHost = z;
        this.hPp = i;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.ala_pk_rank_prop_layout, this);
        this.hPb = (ImageView) findViewById(a.f.pk_rank_prop_bg_cover);
        this.hPm = (RelativeLayout) findViewById(a.f.pk_rank_prop_content);
        this.hPj = (ImageView) findViewById(a.f.pk_rank_prop_img);
        this.hPk = (TextView) findViewById(a.f.pk_rank_prop_title);
        this.hPl = (TextView) findViewById(a.f.pk_rank_prop_tip);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hPb, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hPb, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(300L);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hPm, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hPm, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hPm, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hPm, "scaleY", 1.0f, 0.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.hPm, "alpha", 1.0f, 0.0f);
        this.hPn.play(ofFloat).with(ofFloat3).with(ofFloat4);
        this.hPo.play(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).after(IMConnection.RETRY_DELAY_TIMES);
        this.hPh.play(this.hPn).before(this.hPo);
    }

    public int M(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.hPd = animatorListenerAdapter;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.ete = viewGroup;
    }

    @Override // com.baidu.tieba.ala.view.anim.a
    public void startAnim() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.isHost) {
            this.hPb.setImageResource(a.e.pk_rank_black_cover_top);
            this.ete.addView(this, layoutParams);
        } else {
            layoutParams.addRule(12);
            this.ete.addView(this, layoutParams);
            this.hPb.setImageResource(a.e.pk_rank_black_cover_bottom);
            ((RelativeLayout.LayoutParams) this.hPm.getLayoutParams()).topMargin = M(20.0f);
        }
        if (this.hPp == 1) {
            this.hPj.setImageResource(a.e.pk_rank_red_potion);
            this.hPk.setText(a.h.sdk_pk_rank_potion);
            this.hPl.setText(a.h.sdk_pk_rank_potion_title);
        } else if (this.hPp == 2) {
            this.hPj.setImageResource(a.e.pk_rank_boom);
            this.hPk.setText(a.h.sdk_pk_rank_smoke);
            this.hPl.setText(a.h.sdk_pk_rank_smoke_tip);
        }
        this.hPh.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.PkRankPropAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankPropAnim.this.ete.removeView(PkRankPropAnim.this);
            }
        });
        this.hPh.addListener(this.hPd);
        this.hPm.setVisibility(0);
        this.hPb.setVisibility(0);
        this.hPh.start();
    }
}
