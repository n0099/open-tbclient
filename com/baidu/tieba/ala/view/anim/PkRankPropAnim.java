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
    ImageView hZR;
    AnimatorListenerAdapter hZT;
    private AnimatorSet hZX;
    ImageView hZZ;
    TextView iaa;
    TextView iab;
    RelativeLayout iac;
    private AnimatorSet iad;
    private AnimatorSet iae;
    private int iaf;
    private boolean isHost;

    public PkRankPropAnim(Context context, boolean z, int i) {
        super(context);
        this.iad = new AnimatorSet();
        this.iae = new AnimatorSet();
        this.hZX = new AnimatorSet();
        this.isHost = z;
        this.iaf = i;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.ala_pk_rank_prop_layout, this);
        this.hZR = (ImageView) findViewById(a.f.pk_rank_prop_bg_cover);
        this.iac = (RelativeLayout) findViewById(a.f.pk_rank_prop_content);
        this.hZZ = (ImageView) findViewById(a.f.pk_rank_prop_img);
        this.iaa = (TextView) findViewById(a.f.pk_rank_prop_title);
        this.iab = (TextView) findViewById(a.f.pk_rank_prop_tip);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hZR, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hZR, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(300L);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.iac, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.iac, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.iac, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.iac, "scaleY", 1.0f, 0.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.iac, "alpha", 1.0f, 0.0f);
        this.iad.play(ofFloat).with(ofFloat3).with(ofFloat4);
        this.iae.play(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).after(IMConnection.RETRY_DELAY_TIMES);
        this.hZX.play(this.iad).before(this.iae);
    }

    public int M(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.hZT = animatorListenerAdapter;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.eAg = viewGroup;
    }

    @Override // com.baidu.tieba.ala.view.anim.a
    public void startAnim() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.isHost) {
            this.hZR.setImageResource(a.e.pk_rank_black_cover_top);
            this.eAg.addView(this, layoutParams);
        } else {
            layoutParams.addRule(12);
            this.eAg.addView(this, layoutParams);
            this.hZR.setImageResource(a.e.pk_rank_black_cover_bottom);
            ((RelativeLayout.LayoutParams) this.iac.getLayoutParams()).topMargin = M(20.0f);
        }
        if (this.iaf == 1) {
            this.hZZ.setImageResource(a.e.pk_rank_red_potion);
            this.iaa.setText(a.h.sdk_pk_rank_potion);
            this.iab.setText(a.h.sdk_pk_rank_potion_title);
        } else if (this.iaf == 2) {
            this.hZZ.setImageResource(a.e.pk_rank_boom);
            this.iaa.setText(a.h.sdk_pk_rank_smoke);
            this.iab.setText(a.h.sdk_pk_rank_smoke_tip);
        }
        this.hZX.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.PkRankPropAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankPropAnim.this.eAg.removeView(PkRankPropAnim.this);
            }
        });
        this.hZX.addListener(this.hZT);
        this.iac.setVisibility(0);
        this.hZR.setVisibility(0);
        this.hZX.start();
    }
}
