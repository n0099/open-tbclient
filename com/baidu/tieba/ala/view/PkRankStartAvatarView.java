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
    private HeadImageView hOK;
    private TextView hOL;
    private AnimatorSet hOM;

    public PkRankStartAvatarView(Context context) {
        super(context);
        init();
    }

    public void setData(String str, CharSequence charSequence) {
        if (this.hOK != null) {
            HeadImageView headImageView = this.hOK;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            headImageView.startLoad(str, 12, false, false);
        }
        if (this.hOL != null) {
            TextView textView = this.hOL;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            textView.setText(charSequence);
            this.hOL.setVisibility(4);
        }
    }

    public Animator getStreakAnim() {
        if (this.hOL == null || TextUtils.isEmpty(this.hOL.getText())) {
            return null;
        }
        if (this.hOM != null) {
            this.hOM.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hOL, "scaleX", 0.0f, 1.0f);
        ofFloat.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat.setRepeatCount(0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hOL, "scaleY", 0.0f, 1.0f);
        ofFloat2.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat2.setRepeatCount(0);
        if (this.hOM == null) {
            this.hOM = new AnimatorSet();
        }
        this.hOM.setDuration(440L);
        this.hOM.setInterpolator(new LinearInterpolator());
        this.hOM.playTogether(ofFloat, ofFloat2);
        this.hOM.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAvatarView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAvatarView.this.hOL.setPivotX(PkRankStartAvatarView.this.hOL.getWidth() * 0.5f);
                PkRankStartAvatarView.this.hOL.setPivotY(PkRankStartAvatarView.this.hOL.getHeight());
                PkRankStartAvatarView.this.hOL.setVisibility(0);
            }
        });
        return this.hOM;
    }

    public void release() {
        if (this.hOM != null) {
            this.hOM.cancel();
        }
        if (this.hOK != null) {
            this.hOK.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.sdk_pk_rank_start_avatar, (ViewGroup) this, true);
        this.hOK = (HeadImageView) findViewById(a.f.iv_pk_rank_start_avatar);
        this.hOL = (TextView) findViewById(a.f.tv_pk_rank_start_streak);
        clS();
        clT();
    }

    private void clS() {
        this.hOK.setAutoChangeStyle(false);
        this.hOK.setIsRound(true);
        this.hOK.setBorderWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        this.hOK.setBorderColor(-1275068417);
        this.hOK.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void clT() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1072425964);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds26));
        this.hOL.setBackgroundDrawable(gradientDrawable);
    }
}
