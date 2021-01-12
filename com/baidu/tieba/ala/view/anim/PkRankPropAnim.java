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
    ViewGroup eEY;
    ImageView ihL;
    AnimatorListenerAdapter ihN;
    private AnimatorSet ihR;
    ImageView ihT;
    TextView ihU;
    TextView ihV;
    RelativeLayout ihW;
    private AnimatorSet ihX;
    private AnimatorSet ihY;
    private int ihZ;
    private boolean isHost;

    public PkRankPropAnim(Context context, boolean z, int i) {
        super(context);
        this.ihX = new AnimatorSet();
        this.ihY = new AnimatorSet();
        this.ihR = new AnimatorSet();
        this.isHost = z;
        this.ihZ = i;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.ala_pk_rank_prop_layout, this);
        this.ihL = (ImageView) findViewById(a.f.pk_rank_prop_bg_cover);
        this.ihW = (RelativeLayout) findViewById(a.f.pk_rank_prop_content);
        this.ihT = (ImageView) findViewById(a.f.pk_rank_prop_img);
        this.ihU = (TextView) findViewById(a.f.pk_rank_prop_title);
        this.ihV = (TextView) findViewById(a.f.pk_rank_prop_tip);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ihL, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ihL, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(300L);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.ihW, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.ihW, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.ihW, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.ihW, "scaleY", 1.0f, 0.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.ihW, "alpha", 1.0f, 0.0f);
        this.ihX.play(ofFloat).with(ofFloat3).with(ofFloat4);
        this.ihY.play(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).after(IMConnection.RETRY_DELAY_TIMES);
        this.ihR.play(this.ihX).before(this.ihY);
    }

    public int O(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.ihN = animatorListenerAdapter;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.eEY = viewGroup;
    }

    @Override // com.baidu.tieba.ala.view.anim.a
    public void startAnim() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.isHost) {
            this.ihL.setImageResource(a.e.pk_rank_black_cover_top);
            this.eEY.addView(this, layoutParams);
        } else {
            layoutParams.addRule(12);
            this.eEY.addView(this, layoutParams);
            this.ihL.setImageResource(a.e.pk_rank_black_cover_bottom);
            ((RelativeLayout.LayoutParams) this.ihW.getLayoutParams()).topMargin = O(20.0f);
        }
        if (this.ihZ == 1) {
            this.ihT.setImageResource(a.e.pk_rank_red_potion);
            this.ihU.setText(a.h.sdk_pk_rank_potion);
            this.ihV.setText(a.h.sdk_pk_rank_potion_title);
        } else if (this.ihZ == 2) {
            this.ihT.setImageResource(a.e.pk_rank_boom);
            this.ihU.setText(a.h.sdk_pk_rank_smoke);
            this.ihV.setText(a.h.sdk_pk_rank_smoke_tip);
        }
        this.ihR.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.PkRankPropAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankPropAnim.this.eEY.removeView(PkRankPropAnim.this);
            }
        });
        this.ihR.addListener(this.ihN);
        this.ihW.setVisibility(0);
        this.ihL.setVisibility(0);
        this.ihR.start();
    }
}
