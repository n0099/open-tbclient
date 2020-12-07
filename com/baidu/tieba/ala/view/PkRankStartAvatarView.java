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
    private HeadImageView hZB;
    private TextView hZC;
    private AnimatorSet hZD;

    public PkRankStartAvatarView(Context context) {
        super(context);
        init();
    }

    public void setData(String str, CharSequence charSequence) {
        if (this.hZB != null) {
            HeadImageView headImageView = this.hZB;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            headImageView.startLoad(str, 12, false, false);
        }
        if (this.hZC != null) {
            TextView textView = this.hZC;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            textView.setText(charSequence);
            this.hZC.setVisibility(4);
        }
    }

    public Animator getStreakAnim() {
        if (this.hZC == null || TextUtils.isEmpty(this.hZC.getText())) {
            return null;
        }
        if (this.hZD != null) {
            this.hZD.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hZC, "scaleX", 0.0f, 1.0f);
        ofFloat.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat.setRepeatCount(0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hZC, "scaleY", 0.0f, 1.0f);
        ofFloat2.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat2.setRepeatCount(0);
        if (this.hZD == null) {
            this.hZD = new AnimatorSet();
        }
        this.hZD.setDuration(440L);
        this.hZD.setInterpolator(new LinearInterpolator());
        this.hZD.playTogether(ofFloat, ofFloat2);
        this.hZD.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAvatarView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAvatarView.this.hZC.setPivotX(PkRankStartAvatarView.this.hZC.getWidth() * 0.5f);
                PkRankStartAvatarView.this.hZC.setPivotY(PkRankStartAvatarView.this.hZC.getHeight());
                PkRankStartAvatarView.this.hZC.setVisibility(0);
            }
        });
        return this.hZD;
    }

    public void release() {
        if (this.hZD != null) {
            this.hZD.cancel();
        }
        if (this.hZB != null) {
            this.hZB.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.sdk_pk_rank_start_avatar, (ViewGroup) this, true);
        this.hZB = (HeadImageView) findViewById(a.f.iv_pk_rank_start_avatar);
        this.hZC = (TextView) findViewById(a.f.tv_pk_rank_start_streak);
        cqf();
        cqg();
    }

    private void cqf() {
        this.hZB.setAutoChangeStyle(false);
        this.hZB.setIsRound(true);
        this.hZB.setBorderWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        this.hZB.setBorderColor(-1275068417);
        this.hZB.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void cqg() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1072425964);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds26));
        this.hZC.setBackgroundDrawable(gradientDrawable);
    }
}
