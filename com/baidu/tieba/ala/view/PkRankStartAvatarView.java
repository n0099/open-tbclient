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
/* loaded from: classes4.dex */
public class PkRankStartAvatarView extends RelativeLayout {
    private HeadImageView hZD;
    private TextView hZE;
    private AnimatorSet hZF;

    public PkRankStartAvatarView(Context context) {
        super(context);
        init();
    }

    public void setData(String str, CharSequence charSequence) {
        if (this.hZD != null) {
            HeadImageView headImageView = this.hZD;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            headImageView.startLoad(str, 12, false, false);
        }
        if (this.hZE != null) {
            TextView textView = this.hZE;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            textView.setText(charSequence);
            this.hZE.setVisibility(4);
        }
    }

    public Animator getStreakAnim() {
        if (this.hZE == null || TextUtils.isEmpty(this.hZE.getText())) {
            return null;
        }
        if (this.hZF != null) {
            this.hZF.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hZE, "scaleX", 0.0f, 1.0f);
        ofFloat.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat.setRepeatCount(0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hZE, "scaleY", 0.0f, 1.0f);
        ofFloat2.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat2.setRepeatCount(0);
        if (this.hZF == null) {
            this.hZF = new AnimatorSet();
        }
        this.hZF.setDuration(440L);
        this.hZF.setInterpolator(new LinearInterpolator());
        this.hZF.playTogether(ofFloat, ofFloat2);
        this.hZF.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAvatarView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAvatarView.this.hZE.setPivotX(PkRankStartAvatarView.this.hZE.getWidth() * 0.5f);
                PkRankStartAvatarView.this.hZE.setPivotY(PkRankStartAvatarView.this.hZE.getHeight());
                PkRankStartAvatarView.this.hZE.setVisibility(0);
            }
        });
        return this.hZF;
    }

    public void release() {
        if (this.hZF != null) {
            this.hZF.cancel();
        }
        if (this.hZD != null) {
            this.hZD.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.sdk_pk_rank_start_avatar, (ViewGroup) this, true);
        this.hZD = (HeadImageView) findViewById(a.f.iv_pk_rank_start_avatar);
        this.hZE = (TextView) findViewById(a.f.tv_pk_rank_start_streak);
        cqg();
        cqh();
    }

    private void cqg() {
        this.hZD.setAutoChangeStyle(false);
        this.hZD.setIsRound(true);
        this.hZD.setBorderWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        this.hZD.setBorderColor(-1275068417);
        this.hZD.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void cqh() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1072425964);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds26));
        this.hZE.setBackgroundDrawable(gradientDrawable);
    }
}
