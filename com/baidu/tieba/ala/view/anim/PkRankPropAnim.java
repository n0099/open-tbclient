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
/* loaded from: classes11.dex */
public class PkRankPropAnim extends RelativeLayout implements a {
    ViewGroup eJJ;
    ImageView imB;
    TextView imC;
    TextView imD;
    RelativeLayout imE;
    private AnimatorSet imF;
    private AnimatorSet imG;
    private int imH;
    ImageView imt;
    AnimatorListenerAdapter imv;
    private AnimatorSet imz;
    private boolean isHost;

    public PkRankPropAnim(Context context, boolean z, int i) {
        super(context);
        this.imF = new AnimatorSet();
        this.imG = new AnimatorSet();
        this.imz = new AnimatorSet();
        this.isHost = z;
        this.imH = i;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.ala_pk_rank_prop_layout, this);
        this.imt = (ImageView) findViewById(a.f.pk_rank_prop_bg_cover);
        this.imE = (RelativeLayout) findViewById(a.f.pk_rank_prop_content);
        this.imB = (ImageView) findViewById(a.f.pk_rank_prop_img);
        this.imC = (TextView) findViewById(a.f.pk_rank_prop_title);
        this.imD = (TextView) findViewById(a.f.pk_rank_prop_tip);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.imt, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.imt, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(300L);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.imE, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.imE, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.imE, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.imE, "scaleY", 1.0f, 0.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.imE, "alpha", 1.0f, 0.0f);
        this.imF.play(ofFloat).with(ofFloat3).with(ofFloat4);
        this.imG.play(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).after(IMConnection.RETRY_DELAY_TIMES);
        this.imz.play(this.imF).before(this.imG);
    }

    public int O(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.imv = animatorListenerAdapter;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.eJJ = viewGroup;
    }

    @Override // com.baidu.tieba.ala.view.anim.a
    public void startAnim() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.isHost) {
            this.imt.setImageResource(a.e.pk_rank_black_cover_top);
            this.eJJ.addView(this, layoutParams);
        } else {
            layoutParams.addRule(12);
            this.eJJ.addView(this, layoutParams);
            this.imt.setImageResource(a.e.pk_rank_black_cover_bottom);
            ((RelativeLayout.LayoutParams) this.imE.getLayoutParams()).topMargin = O(20.0f);
        }
        if (this.imH == 1) {
            this.imB.setImageResource(a.e.pk_rank_red_potion);
            this.imC.setText(a.h.sdk_pk_rank_potion);
            this.imD.setText(a.h.sdk_pk_rank_potion_title);
        } else if (this.imH == 2) {
            this.imB.setImageResource(a.e.pk_rank_boom);
            this.imC.setText(a.h.sdk_pk_rank_smoke);
            this.imD.setText(a.h.sdk_pk_rank_smoke_tip);
        }
        this.imz.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.PkRankPropAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankPropAnim.this.eJJ.removeView(PkRankPropAnim.this);
            }
        });
        this.imz.addListener(this.imv);
        this.imE.setVisibility(0);
        this.imt.setVisibility(0);
        this.imz.start();
    }
}
