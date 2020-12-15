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
    ViewGroup eAg;
    ImageView hZT;
    AnimatorListenerAdapter hZV;
    private AnimatorSet hZZ;
    ImageView iab;
    TextView iac;
    TextView iad;
    RelativeLayout iae;
    private AnimatorSet iaf;
    private AnimatorSet iag;
    private int iah;
    private boolean isHost;

    public PkRankPropAnim(Context context, boolean z, int i) {
        super(context);
        this.iaf = new AnimatorSet();
        this.iag = new AnimatorSet();
        this.hZZ = new AnimatorSet();
        this.isHost = z;
        this.iah = i;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.ala_pk_rank_prop_layout, this);
        this.hZT = (ImageView) findViewById(a.f.pk_rank_prop_bg_cover);
        this.iae = (RelativeLayout) findViewById(a.f.pk_rank_prop_content);
        this.iab = (ImageView) findViewById(a.f.pk_rank_prop_img);
        this.iac = (TextView) findViewById(a.f.pk_rank_prop_title);
        this.iad = (TextView) findViewById(a.f.pk_rank_prop_tip);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hZT, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hZT, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(300L);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.iae, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.iae, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.iae, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.iae, "scaleY", 1.0f, 0.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.iae, "alpha", 1.0f, 0.0f);
        this.iaf.play(ofFloat).with(ofFloat3).with(ofFloat4);
        this.iag.play(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).after(IMConnection.RETRY_DELAY_TIMES);
        this.hZZ.play(this.iaf).before(this.iag);
    }

    public int M(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
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
            this.eAg.addView(this, layoutParams);
        } else {
            layoutParams.addRule(12);
            this.eAg.addView(this, layoutParams);
            this.hZT.setImageResource(a.e.pk_rank_black_cover_bottom);
            ((RelativeLayout.LayoutParams) this.iae.getLayoutParams()).topMargin = M(20.0f);
        }
        if (this.iah == 1) {
            this.iab.setImageResource(a.e.pk_rank_red_potion);
            this.iac.setText(a.h.sdk_pk_rank_potion);
            this.iad.setText(a.h.sdk_pk_rank_potion_title);
        } else if (this.iah == 2) {
            this.iab.setImageResource(a.e.pk_rank_boom);
            this.iac.setText(a.h.sdk_pk_rank_smoke);
            this.iad.setText(a.h.sdk_pk_rank_smoke_tip);
        }
        this.hZZ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.PkRankPropAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankPropAnim.this.eAg.removeView(PkRankPropAnim.this);
            }
        });
        this.hZZ.addListener(this.hZV);
        this.iae.setVisibility(0);
        this.hZT.setVisibility(0);
        this.hZZ.start();
    }
}
