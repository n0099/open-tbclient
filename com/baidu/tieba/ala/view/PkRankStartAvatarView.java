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
    private HeadImageView inj;
    private TextView ink;
    private AnimatorSet inl;

    public PkRankStartAvatarView(Context context) {
        super(context);
        init();
    }

    public void setData(String str, CharSequence charSequence) {
        if (this.inj != null) {
            HeadImageView headImageView = this.inj;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            headImageView.startLoad(str, 12, false, false);
        }
        if (this.ink != null) {
            TextView textView = this.ink;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            textView.setText(charSequence);
            this.ink.setVisibility(4);
        }
    }

    public Animator getStreakAnim() {
        if (this.ink == null || TextUtils.isEmpty(this.ink.getText())) {
            return null;
        }
        if (this.inl != null) {
            this.inl.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ink, "scaleX", 0.0f, 1.0f);
        ofFloat.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat.setRepeatCount(0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ink, "scaleY", 0.0f, 1.0f);
        ofFloat2.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat2.setRepeatCount(0);
        if (this.inl == null) {
            this.inl = new AnimatorSet();
        }
        this.inl.setDuration(440L);
        this.inl.setInterpolator(new LinearInterpolator());
        this.inl.playTogether(ofFloat, ofFloat2);
        this.inl.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAvatarView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAvatarView.this.ink.setPivotX(PkRankStartAvatarView.this.ink.getWidth() * 0.5f);
                PkRankStartAvatarView.this.ink.setPivotY(PkRankStartAvatarView.this.ink.getHeight());
                PkRankStartAvatarView.this.ink.setVisibility(0);
            }
        });
        return this.inl;
    }

    public void release() {
        if (this.inl != null) {
            this.inl.cancel();
        }
        if (this.inj != null) {
            this.inj.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.sdk_pk_rank_start_avatar, (ViewGroup) this, true);
        this.inj = (HeadImageView) findViewById(a.f.iv_pk_rank_start_avatar);
        this.ink = (TextView) findViewById(a.f.tv_pk_rank_start_streak);
        cqw();
        cqx();
    }

    private void cqw() {
        this.inj.setAutoChangeStyle(false);
        this.inj.setIsRound(true);
        this.inj.setBorderWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        this.inj.setBorderColor(-1275068417);
        this.inj.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void cqx() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1072425964);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds26));
        this.ink.setBackgroundDrawable(gradientDrawable);
    }
}
