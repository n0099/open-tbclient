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
    private HeadImageView hwJ;
    private TextView hwK;
    private AnimatorSet hwL;

    public PkRankStartAvatarView(Context context) {
        super(context);
        init();
    }

    public void setData(String str, CharSequence charSequence) {
        if (this.hwJ != null) {
            HeadImageView headImageView = this.hwJ;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            headImageView.startLoad(str, 12, false, false);
        }
        if (this.hwK != null) {
            TextView textView = this.hwK;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            textView.setText(charSequence);
            this.hwK.setVisibility(4);
        }
    }

    public Animator getStreakAnim() {
        if (this.hwK == null || TextUtils.isEmpty(this.hwK.getText())) {
            return null;
        }
        if (this.hwL != null) {
            this.hwL.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hwK, "scaleX", 0.0f, 1.0f);
        ofFloat.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat.setRepeatCount(0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hwK, "scaleY", 0.0f, 1.0f);
        ofFloat2.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat2.setRepeatCount(0);
        if (this.hwL == null) {
            this.hwL = new AnimatorSet();
        }
        this.hwL.setDuration(440L);
        this.hwL.setInterpolator(new LinearInterpolator());
        this.hwL.playTogether(ofFloat, ofFloat2);
        this.hwL.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAvatarView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAvatarView.this.hwK.setPivotX(PkRankStartAvatarView.this.hwK.getWidth() * 0.5f);
                PkRankStartAvatarView.this.hwK.setPivotY(PkRankStartAvatarView.this.hwK.getHeight());
                PkRankStartAvatarView.this.hwK.setVisibility(0);
            }
        });
        return this.hwL;
    }

    public void release() {
        if (this.hwL != null) {
            this.hwL.cancel();
        }
        if (this.hwJ != null) {
            this.hwJ.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.sdk_pk_rank_start_avatar, (ViewGroup) this, true);
        this.hwJ = (HeadImageView) findViewById(a.g.iv_pk_rank_start_avatar);
        this.hwK = (TextView) findViewById(a.g.tv_pk_rank_start_streak);
        cgQ();
        cgR();
    }

    private void cgQ() {
        this.hwJ.setAutoChangeStyle(false);
        this.hwJ.setIsRound(true);
        this.hwJ.setBorderWidth(getResources().getDimensionPixelOffset(a.e.sdk_ds4));
        this.hwJ.setBorderColor(-1275068417);
        this.hwJ.setDefaultBgResource(a.f.sdk_default_avatar);
    }

    private void cgR() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1072425964);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds26));
        this.hwK.setBackgroundDrawable(gradientDrawable);
    }
}
