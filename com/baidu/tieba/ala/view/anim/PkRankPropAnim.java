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
    ViewGroup eoQ;
    private AnimatorSet hJD;
    ImageView hJF;
    TextView hJG;
    TextView hJH;
    RelativeLayout hJI;
    private AnimatorSet hJJ;
    private AnimatorSet hJK;
    private int hJL;
    ImageView hJx;
    AnimatorListenerAdapter hJz;
    private boolean isHost;

    public PkRankPropAnim(Context context, boolean z, int i) {
        super(context);
        this.hJJ = new AnimatorSet();
        this.hJK = new AnimatorSet();
        this.hJD = new AnimatorSet();
        this.isHost = z;
        this.hJL = i;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.h.ala_pk_rank_prop_layout, this);
        this.hJx = (ImageView) findViewById(a.g.pk_rank_prop_bg_cover);
        this.hJI = (RelativeLayout) findViewById(a.g.pk_rank_prop_content);
        this.hJF = (ImageView) findViewById(a.g.pk_rank_prop_img);
        this.hJG = (TextView) findViewById(a.g.pk_rank_prop_title);
        this.hJH = (TextView) findViewById(a.g.pk_rank_prop_tip);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hJx, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hJx, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(300L);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hJI, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hJI, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hJI, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hJI, "scaleY", 1.0f, 0.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.hJI, "alpha", 1.0f, 0.0f);
        this.hJJ.play(ofFloat).with(ofFloat3).with(ofFloat4);
        this.hJK.play(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).after(IMConnection.RETRY_DELAY_TIMES);
        this.hJD.play(this.hJJ).before(this.hJK);
    }

    public int L(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.hJz = animatorListenerAdapter;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.eoQ = viewGroup;
    }

    @Override // com.baidu.tieba.ala.view.anim.a
    public void startAnim() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.isHost) {
            this.hJx.setImageResource(a.f.pk_rank_black_cover_top);
            this.eoQ.addView(this, layoutParams);
        } else {
            layoutParams.addRule(12);
            this.eoQ.addView(this, layoutParams);
            this.hJx.setImageResource(a.f.pk_rank_black_cover_bottom);
            ((RelativeLayout.LayoutParams) this.hJI.getLayoutParams()).topMargin = L(20.0f);
        }
        if (this.hJL == 1) {
            this.hJF.setImageResource(a.f.pk_rank_red_potion);
            this.hJG.setText(a.i.sdk_pk_rank_potion);
            this.hJH.setText(a.i.sdk_pk_rank_potion_title);
        } else if (this.hJL == 2) {
            this.hJF.setImageResource(a.f.pk_rank_boom);
            this.hJG.setText(a.i.sdk_pk_rank_smoke);
            this.hJH.setText(a.i.sdk_pk_rank_smoke_tip);
        }
        this.hJD.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.PkRankPropAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankPropAnim.this.eoQ.removeView(PkRankPropAnim.this);
            }
        });
        this.hJD.addListener(this.hJz);
        this.hJI.setVisibility(0);
        this.hJx.setVisibility(0);
        this.hJD.start();
    }
}
