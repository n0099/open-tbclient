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
    private HeadImageView hPd;
    private TextView hPe;
    private AnimatorSet hPf;

    public PkRankStartAvatarView(Context context) {
        super(context);
        init();
    }

    public void setData(String str, CharSequence charSequence) {
        if (this.hPd != null) {
            HeadImageView headImageView = this.hPd;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            headImageView.startLoad(str, 12, false, false);
        }
        if (this.hPe != null) {
            TextView textView = this.hPe;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            textView.setText(charSequence);
            this.hPe.setVisibility(4);
        }
    }

    public Animator getStreakAnim() {
        if (this.hPe == null || TextUtils.isEmpty(this.hPe.getText())) {
            return null;
        }
        if (this.hPf != null) {
            this.hPf.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hPe, "scaleX", 0.0f, 1.0f);
        ofFloat.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat.setRepeatCount(0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hPe, "scaleY", 0.0f, 1.0f);
        ofFloat2.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat2.setRepeatCount(0);
        if (this.hPf == null) {
            this.hPf = new AnimatorSet();
        }
        this.hPf.setDuration(440L);
        this.hPf.setInterpolator(new LinearInterpolator());
        this.hPf.playTogether(ofFloat, ofFloat2);
        this.hPf.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAvatarView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAvatarView.this.hPe.setPivotX(PkRankStartAvatarView.this.hPe.getWidth() * 0.5f);
                PkRankStartAvatarView.this.hPe.setPivotY(PkRankStartAvatarView.this.hPe.getHeight());
                PkRankStartAvatarView.this.hPe.setVisibility(0);
            }
        });
        return this.hPf;
    }

    public void release() {
        if (this.hPf != null) {
            this.hPf.cancel();
        }
        if (this.hPd != null) {
            this.hPd.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.sdk_pk_rank_start_avatar, (ViewGroup) this, true);
        this.hPd = (HeadImageView) findViewById(a.f.iv_pk_rank_start_avatar);
        this.hPe = (TextView) findViewById(a.f.tv_pk_rank_start_streak);
        cmz();
        cmA();
    }

    private void cmz() {
        this.hPd.setAutoChangeStyle(false);
        this.hPd.setIsRound(true);
        this.hPd.setBorderWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        this.hPd.setBorderColor(-1275068417);
        this.hPd.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void cmA() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1072425964);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds26));
        this.hPe.setBackgroundDrawable(gradientDrawable);
    }
}
