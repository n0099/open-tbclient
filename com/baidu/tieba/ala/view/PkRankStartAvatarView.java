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
    private HeadImageView imV;
    private TextView imW;
    private AnimatorSet imX;

    public PkRankStartAvatarView(Context context) {
        super(context);
        init();
    }

    public void setData(String str, CharSequence charSequence) {
        if (this.imV != null) {
            HeadImageView headImageView = this.imV;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            headImageView.startLoad(str, 12, false, false);
        }
        if (this.imW != null) {
            TextView textView = this.imW;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            textView.setText(charSequence);
            this.imW.setVisibility(4);
        }
    }

    public Animator getStreakAnim() {
        if (this.imW == null || TextUtils.isEmpty(this.imW.getText())) {
            return null;
        }
        if (this.imX != null) {
            this.imX.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.imW, "scaleX", 0.0f, 1.0f);
        ofFloat.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat.setRepeatCount(0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.imW, "scaleY", 0.0f, 1.0f);
        ofFloat2.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat2.setRepeatCount(0);
        if (this.imX == null) {
            this.imX = new AnimatorSet();
        }
        this.imX.setDuration(440L);
        this.imX.setInterpolator(new LinearInterpolator());
        this.imX.playTogether(ofFloat, ofFloat2);
        this.imX.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAvatarView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAvatarView.this.imW.setPivotX(PkRankStartAvatarView.this.imW.getWidth() * 0.5f);
                PkRankStartAvatarView.this.imW.setPivotY(PkRankStartAvatarView.this.imW.getHeight());
                PkRankStartAvatarView.this.imW.setVisibility(0);
            }
        });
        return this.imX;
    }

    public void release() {
        if (this.imX != null) {
            this.imX.cancel();
        }
        if (this.imV != null) {
            this.imV.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.sdk_pk_rank_start_avatar, (ViewGroup) this, true);
        this.imV = (HeadImageView) findViewById(a.f.iv_pk_rank_start_avatar);
        this.imW = (TextView) findViewById(a.f.tv_pk_rank_start_streak);
        cqp();
        cqq();
    }

    private void cqp() {
        this.imV.setAutoChangeStyle(false);
        this.imV.setIsRound(true);
        this.imV.setBorderWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        this.imV.setBorderColor(-1275068417);
        this.imV.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void cqq() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1072425964);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds26));
        this.imW.setBackgroundDrawable(gradientDrawable);
    }
}
