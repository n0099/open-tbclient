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
    private HeadImageView hJg;
    private TextView hJh;
    private AnimatorSet hJi;

    public PkRankStartAvatarView(Context context) {
        super(context);
        init();
    }

    public void setData(String str, CharSequence charSequence) {
        if (this.hJg != null) {
            HeadImageView headImageView = this.hJg;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            headImageView.startLoad(str, 12, false, false);
        }
        if (this.hJh != null) {
            TextView textView = this.hJh;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            textView.setText(charSequence);
            this.hJh.setVisibility(4);
        }
    }

    public Animator getStreakAnim() {
        if (this.hJh == null || TextUtils.isEmpty(this.hJh.getText())) {
            return null;
        }
        if (this.hJi != null) {
            this.hJi.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hJh, "scaleX", 0.0f, 1.0f);
        ofFloat.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat.setRepeatCount(0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hJh, "scaleY", 0.0f, 1.0f);
        ofFloat2.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat2.setRepeatCount(0);
        if (this.hJi == null) {
            this.hJi = new AnimatorSet();
        }
        this.hJi.setDuration(440L);
        this.hJi.setInterpolator(new LinearInterpolator());
        this.hJi.playTogether(ofFloat, ofFloat2);
        this.hJi.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAvatarView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAvatarView.this.hJh.setPivotX(PkRankStartAvatarView.this.hJh.getWidth() * 0.5f);
                PkRankStartAvatarView.this.hJh.setPivotY(PkRankStartAvatarView.this.hJh.getHeight());
                PkRankStartAvatarView.this.hJh.setVisibility(0);
            }
        });
        return this.hJi;
    }

    public void release() {
        if (this.hJi != null) {
            this.hJi.cancel();
        }
        if (this.hJg != null) {
            this.hJg.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.sdk_pk_rank_start_avatar, (ViewGroup) this, true);
        this.hJg = (HeadImageView) findViewById(a.g.iv_pk_rank_start_avatar);
        this.hJh = (TextView) findViewById(a.g.tv_pk_rank_start_streak);
        cjX();
        cjY();
    }

    private void cjX() {
        this.hJg.setAutoChangeStyle(false);
        this.hJg.setIsRound(true);
        this.hJg.setBorderWidth(getResources().getDimensionPixelOffset(a.e.sdk_ds4));
        this.hJg.setBorderColor(-1275068417);
        this.hJg.setDefaultBgResource(a.f.sdk_default_avatar);
    }

    private void cjY() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1072425964);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds26));
        this.hJh.setBackgroundDrawable(gradientDrawable);
    }
}
