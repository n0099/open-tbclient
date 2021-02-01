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
    private AnimatorSet igE;
    ImageView inB;
    TextView inC;
    TextView inD;
    RelativeLayout inE;
    private AnimatorSet inF;
    private AnimatorSet inG;
    private int inH;
    ImageView inu;
    AnimatorListenerAdapter inw;
    private boolean isHost;

    public PkRankPropAnim(Context context, boolean z, int i) {
        super(context);
        this.inF = new AnimatorSet();
        this.inG = new AnimatorSet();
        this.igE = new AnimatorSet();
        this.isHost = z;
        this.inH = i;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.ala_pk_rank_prop_layout, this);
        this.inu = (ImageView) findViewById(a.f.pk_rank_prop_bg_cover);
        this.inE = (RelativeLayout) findViewById(a.f.pk_rank_prop_content);
        this.inB = (ImageView) findViewById(a.f.pk_rank_prop_img);
        this.inC = (TextView) findViewById(a.f.pk_rank_prop_title);
        this.inD = (TextView) findViewById(a.f.pk_rank_prop_tip);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.inu, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.inu, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(300L);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.inE, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.inE, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.inE, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.inE, "scaleY", 1.0f, 0.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.inE, "alpha", 1.0f, 0.0f);
        this.inF.play(ofFloat).with(ofFloat3).with(ofFloat4);
        this.inG.play(ofFloat2).with(ofFloat5).with(ofFloat6).with(ofFloat7).after(IMConnection.RETRY_DELAY_TIMES);
        this.igE.play(this.inF).before(this.inG);
    }

    public int P(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.inw = animatorListenerAdapter;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.eHf = viewGroup;
    }

    @Override // com.baidu.tieba.ala.view.anim.a
    public void startAnim() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.isHost) {
            this.inu.setImageResource(a.e.pk_rank_black_cover_top);
            this.eHf.addView(this, layoutParams);
        } else {
            layoutParams.addRule(12);
            this.eHf.addView(this, layoutParams);
            this.inu.setImageResource(a.e.pk_rank_black_cover_bottom);
            ((RelativeLayout.LayoutParams) this.inE.getLayoutParams()).topMargin = P(20.0f);
        }
        if (this.inH == 1) {
            this.inB.setImageResource(a.e.pk_rank_red_potion);
            this.inC.setText(a.h.sdk_pk_rank_potion);
            this.inD.setText(a.h.sdk_pk_rank_potion_title);
        } else if (this.inH == 2) {
            this.inB.setImageResource(a.e.pk_rank_boom);
            this.inC.setText(a.h.sdk_pk_rank_smoke);
            this.inD.setText(a.h.sdk_pk_rank_smoke_tip);
        }
        this.igE.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.anim.PkRankPropAnim.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankPropAnim.this.eHf.removeView(PkRankPropAnim.this);
            }
        });
        this.igE.addListener(this.inw);
        this.inE.setVisibility(0);
        this.inu.setVisibility(0);
        this.igE.start();
    }
}
