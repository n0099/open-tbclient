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
    private HeadImageView hhN;
    private TextView hhO;
    private AnimatorSet hhP;

    public PkRankStartAvatarView(Context context) {
        super(context);
        init();
    }

    public void setData(String str, CharSequence charSequence) {
        if (this.hhN != null) {
            HeadImageView headImageView = this.hhN;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            headImageView.startLoad(str, 12, false, false);
        }
        if (this.hhO != null) {
            TextView textView = this.hhO;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            textView.setText(charSequence);
            this.hhO.setVisibility(4);
        }
    }

    public Animator getStreakAnim() {
        if (this.hhO == null || TextUtils.isEmpty(this.hhO.getText())) {
            return null;
        }
        if (this.hhP != null) {
            this.hhP.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hhO, "scaleX", 0.0f, 1.0f);
        ofFloat.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat.setRepeatCount(0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hhO, "scaleY", 0.0f, 1.0f);
        ofFloat2.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat2.setRepeatCount(0);
        if (this.hhP == null) {
            this.hhP = new AnimatorSet();
        }
        this.hhP.setDuration(440L);
        this.hhP.setInterpolator(new LinearInterpolator());
        this.hhP.playTogether(ofFloat, ofFloat2);
        this.hhP.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAvatarView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAvatarView.this.hhO.setPivotX(PkRankStartAvatarView.this.hhO.getWidth() * 0.5f);
                PkRankStartAvatarView.this.hhO.setPivotY(PkRankStartAvatarView.this.hhO.getHeight());
                PkRankStartAvatarView.this.hhO.setVisibility(0);
            }
        });
        return this.hhP;
    }

    public void release() {
        if (this.hhP != null) {
            this.hhP.cancel();
        }
        if (this.hhN != null) {
            this.hhN.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.sdk_pk_rank_start_avatar, (ViewGroup) this, true);
        this.hhN = (HeadImageView) findViewById(a.g.iv_pk_rank_start_avatar);
        this.hhO = (TextView) findViewById(a.g.tv_pk_rank_start_streak);
        cdu();
        cdv();
    }

    private void cdu() {
        this.hhN.setAutoChangeStyle(false);
        this.hhN.setIsRound(true);
        this.hhN.setBorderWidth(getResources().getDimensionPixelOffset(a.e.sdk_ds4));
        this.hhN.setBorderColor(-1275068417);
        this.hhN.setDefaultBgResource(a.f.sdk_default_avatar);
    }

    private void cdv() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1072425964);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds26));
        this.hhO.setBackgroundDrawable(gradientDrawable);
    }
}
