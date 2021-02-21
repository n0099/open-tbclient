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
    ViewGroup eHf;
    private AnimatorSet igS;
    ImageView inI;
    AnimatorListenerAdapter inK;
    ImageView inP;
    TextView inQ;
    TextView inR;
    RelativeLayout inS;
    private AnimatorSet inT;
    private AnimatorSet inU;
    private int inV;
    private boolean isHost;

    public PkRankPropAnim(Context context, boolean z, int i) {
        super(context);
        this.inT = new AnimatorSet();
        this.inU = new AnimatorSet();
        this.igS = new AnimatorSet();
        this.isHost = z;
        this.inV = i;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.ala_pk_rank_prop_layout, this);
        this.inI = (ImageView) findViewById(a.f.pk_rank_prop_bg_cover);
        this.inS = (RelativeLayout) findViewById(a.f.pk_rank_prop_content);
        this.inP = (ImageView) findViewById(a.f.pk_rank_prop_img);
        this.inQ = (TextView) findViewById(a.f.pk_rank_prop_title);
        this.inR = (TextView) findViewById(a.f.pk_rank_prop_tip);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.inI, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.inI, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(300L);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.inS, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.inS, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.inS, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.inS, "scaleY", 1.0f, 0.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.inS, "alpha", 1.0f, 0.0f);
        this.inT.play(ofFloat).with(ofFloat3).with(ofFloat4);
        this.inU.play(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).after(IMConnection.RETRY_DELAY_TIMES);
        this.igS.play(this.inT).before(this.inU);
    }

    public int P(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
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
            this.eHf.addView(this, layoutParams);
        } else {
            layoutParams.addRule(12);
            this.eHf.addView(this, layoutParams);
            this.inI.setImageResource(a.e.pk_rank_black_cover_bottom);
            ((RelativeLayout.LayoutParams) this.inS.getLayoutParams()).topMargin = P(20.0f);
        }
        if (this.inV == 1) {
            this.inP.setImageResource(a.e.pk_rank_red_potion);
            this.inQ.setText(a.h.sdk_pk_rank_potion);
            this.inR.setText(a.h.sdk_pk_rank_potion_title);
        } else if (this.inV == 2) {
            this.inP.setImageResource(a.e.pk_rank_boom);
            this.inQ.setText(a.h.sdk_pk_rank_smoke);
            this.inR.setText(a.h.sdk_pk_rank_smoke_tip);
        }
        this.igS.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.PkRankPropAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankPropAnim.this.eHf.removeView(PkRankPropAnim.this);
            }
        });
        this.igS.addListener(this.inK);
        this.inS.setVisibility(0);
        this.inI.setVisibility(0);
        this.igS.start();
    }
}
