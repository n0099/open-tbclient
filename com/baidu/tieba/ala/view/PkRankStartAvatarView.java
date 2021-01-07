package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes11.dex */
public class PkRankStartAvatarView extends RelativeLayout {
    private HeadImageView imc;
    private TextView imd;
    private AnimatorSet ime;

    public PkRankStartAvatarView(Context context) {
        super(context);
        init();
    }

    public void setData(String str, CharSequence charSequence) {
        if (this.imc != null) {
            HeadImageView headImageView = this.imc;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            headImageView.startLoad(str, 12, false, false);
        }
        if (this.imd != null) {
            TextView textView = this.imd;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            textView.setText(charSequence);
            this.imd.setVisibility(4);
        }
    }

    public Animator getStreakAnim() {
        if (this.imd == null || TextUtils.isEmpty(this.imd.getText())) {
            return null;
        }
        if (this.ime != null) {
            this.ime.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.imd, "scaleX", 0.0f, 1.0f);
        ofFloat.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat.setRepeatCount(0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.imd, "scaleY", 0.0f, 1.0f);
        ofFloat2.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat2.setRepeatCount(0);
        if (this.ime == null) {
            this.ime = new AnimatorSet();
        }
        this.ime.setDuration(440L);
        this.ime.setInterpolator(new LinearInterpolator());
        this.ime.playTogether(ofFloat, ofFloat2);
        this.ime.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAvatarView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAvatarView.this.imd.setPivotX(PkRankStartAvatarView.this.imd.getWidth() * 0.5f);
                PkRankStartAvatarView.this.imd.setPivotY(PkRankStartAvatarView.this.imd.getHeight());
                PkRankStartAvatarView.this.imd.setVisibility(0);
            }
        });
        return this.ime;
    }

    public void release() {
        if (this.ime != null) {
            this.ime.cancel();
        }
        if (this.imc != null) {
            this.imc.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.sdk_pk_rank_start_avatar, (ViewGroup) this, true);
        this.imc = (HeadImageView) findViewById(a.f.iv_pk_rank_start_avatar);
        this.imd = (TextView) findViewById(a.f.tv_pk_rank_start_streak);
        cta();
        ctb();
    }

    private void cta() {
        this.imc.setAutoChangeStyle(false);
        this.imc.setIsRound(true);
        this.imc.setBorderWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        this.imc.setBorderColor(-1275068417);
        this.imc.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void ctb() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1072425964);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds26));
        this.imd.setBackgroundDrawable(gradientDrawable);
    }
}
