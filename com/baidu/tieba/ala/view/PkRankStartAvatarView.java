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
/* loaded from: classes10.dex */
public class PkRankStartAvatarView extends RelativeLayout {
    private HeadImageView ihv;
    private TextView ihw;
    private AnimatorSet ihx;

    public PkRankStartAvatarView(Context context) {
        super(context);
        init();
    }

    public void setData(String str, CharSequence charSequence) {
        if (this.ihv != null) {
            HeadImageView headImageView = this.ihv;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            headImageView.startLoad(str, 12, false, false);
        }
        if (this.ihw != null) {
            TextView textView = this.ihw;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            textView.setText(charSequence);
            this.ihw.setVisibility(4);
        }
    }

    public Animator getStreakAnim() {
        if (this.ihw == null || TextUtils.isEmpty(this.ihw.getText())) {
            return null;
        }
        if (this.ihx != null) {
            this.ihx.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ihw, "scaleX", 0.0f, 1.0f);
        ofFloat.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat.setRepeatCount(0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ihw, "scaleY", 0.0f, 1.0f);
        ofFloat2.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat2.setRepeatCount(0);
        if (this.ihx == null) {
            this.ihx = new AnimatorSet();
        }
        this.ihx.setDuration(440L);
        this.ihx.setInterpolator(new LinearInterpolator());
        this.ihx.playTogether(ofFloat, ofFloat2);
        this.ihx.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAvatarView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAvatarView.this.ihw.setPivotX(PkRankStartAvatarView.this.ihw.getWidth() * 0.5f);
                PkRankStartAvatarView.this.ihw.setPivotY(PkRankStartAvatarView.this.ihw.getHeight());
                PkRankStartAvatarView.this.ihw.setVisibility(0);
            }
        });
        return this.ihx;
    }

    public void release() {
        if (this.ihx != null) {
            this.ihx.cancel();
        }
        if (this.ihv != null) {
            this.ihv.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.sdk_pk_rank_start_avatar, (ViewGroup) this, true);
        this.ihv = (HeadImageView) findViewById(a.f.iv_pk_rank_start_avatar);
        this.ihw = (TextView) findViewById(a.f.tv_pk_rank_start_streak);
        cpi();
        cpj();
    }

    private void cpi() {
        this.ihv.setAutoChangeStyle(false);
        this.ihv.setIsRound(true);
        this.ihv.setBorderWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        this.ihv.setBorderColor(-1275068417);
        this.ihv.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void cpj() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1072425964);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds26));
        this.ihw.setBackgroundDrawable(gradientDrawable);
    }
}
