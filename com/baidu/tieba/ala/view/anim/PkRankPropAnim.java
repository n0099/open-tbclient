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
    ViewGroup euJ;
    private AnimatorSet hPA;
    ImageView hPC;
    TextView hPD;
    TextView hPE;
    RelativeLayout hPF;
    private AnimatorSet hPG;
    private AnimatorSet hPH;
    private int hPI;
    ImageView hPu;
    AnimatorListenerAdapter hPw;
    private boolean isHost;

    public PkRankPropAnim(Context context, boolean z, int i) {
        super(context);
        this.hPG = new AnimatorSet();
        this.hPH = new AnimatorSet();
        this.hPA = new AnimatorSet();
        this.isHost = z;
        this.hPI = i;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.ala_pk_rank_prop_layout, this);
        this.hPu = (ImageView) findViewById(a.f.pk_rank_prop_bg_cover);
        this.hPF = (RelativeLayout) findViewById(a.f.pk_rank_prop_content);
        this.hPC = (ImageView) findViewById(a.f.pk_rank_prop_img);
        this.hPD = (TextView) findViewById(a.f.pk_rank_prop_title);
        this.hPE = (TextView) findViewById(a.f.pk_rank_prop_tip);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hPu, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hPu, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(300L);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hPF, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hPF, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hPF, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hPF, "scaleY", 1.0f, 0.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.hPF, "alpha", 1.0f, 0.0f);
        this.hPG.play(ofFloat).with(ofFloat3).with(ofFloat4);
        this.hPH.play(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).after(IMConnection.RETRY_DELAY_TIMES);
        this.hPA.play(this.hPG).before(this.hPH);
    }

    public int N(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.hPw = animatorListenerAdapter;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.euJ = viewGroup;
    }

    @Override // com.baidu.tieba.ala.view.anim.a
    public void startAnim() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.isHost) {
            this.hPu.setImageResource(a.e.pk_rank_black_cover_top);
            this.euJ.addView(this, layoutParams);
        } else {
            layoutParams.addRule(12);
            this.euJ.addView(this, layoutParams);
            this.hPu.setImageResource(a.e.pk_rank_black_cover_bottom);
            ((RelativeLayout.LayoutParams) this.hPF.getLayoutParams()).topMargin = N(20.0f);
        }
        if (this.hPI == 1) {
            this.hPC.setImageResource(a.e.pk_rank_red_potion);
            this.hPD.setText(a.h.sdk_pk_rank_potion);
            this.hPE.setText(a.h.sdk_pk_rank_potion_title);
        } else if (this.hPI == 2) {
            this.hPC.setImageResource(a.e.pk_rank_boom);
            this.hPD.setText(a.h.sdk_pk_rank_smoke);
            this.hPE.setText(a.h.sdk_pk_rank_smoke_tip);
        }
        this.hPA.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.PkRankPropAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankPropAnim.this.euJ.removeView(PkRankPropAnim.this);
            }
        });
        this.hPA.addListener(this.hPw);
        this.hPF.setVisibility(0);
        this.hPu.setVisibility(0);
        this.hPA.start();
    }
}
