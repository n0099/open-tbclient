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
    private HeadImageView ioT;
    private TextView ioU;
    private AnimatorSet ioV;

    public PkRankStartAvatarView(Context context) {
        super(context);
        init();
    }

    public void setData(String str, CharSequence charSequence) {
        if (this.ioT != null) {
            HeadImageView headImageView = this.ioT;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            headImageView.startLoad(str, 12, false, false);
        }
        if (this.ioU != null) {
            TextView textView = this.ioU;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            textView.setText(charSequence);
            this.ioU.setVisibility(4);
        }
    }

    public Animator getStreakAnim() {
        if (this.ioU == null || TextUtils.isEmpty(this.ioU.getText())) {
            return null;
        }
        if (this.ioV != null) {
            this.ioV.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ioU, "scaleX", 0.0f, 1.0f);
        ofFloat.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat.setRepeatCount(0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ioU, "scaleY", 0.0f, 1.0f);
        ofFloat2.setEvaluator(new com.baidu.tieba.ala.a.a());
        ofFloat2.setRepeatCount(0);
        if (this.ioV == null) {
            this.ioV = new AnimatorSet();
        }
        this.ioV.setDuration(440L);
        this.ioV.setInterpolator(new LinearInterpolator());
        this.ioV.playTogether(ofFloat, ofFloat2);
        this.ioV.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankStartAvatarView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                PkRankStartAvatarView.this.ioU.setPivotX(PkRankStartAvatarView.this.ioU.getWidth() * 0.5f);
                PkRankStartAvatarView.this.ioU.setPivotY(PkRankStartAvatarView.this.ioU.getHeight());
                PkRankStartAvatarView.this.ioU.setVisibility(0);
            }
        });
        return this.ioV;
    }

    public void release() {
        if (this.ioV != null) {
            this.ioV.cancel();
        }
        if (this.ioT != null) {
            this.ioT.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.sdk_pk_rank_start_avatar, (ViewGroup) this, true);
        this.ioT = (HeadImageView) findViewById(a.f.iv_pk_rank_start_avatar);
        this.ioU = (TextView) findViewById(a.f.tv_pk_rank_start_streak);
        cqC();
        cqD();
    }

    private void cqC() {
        this.ioT.setAutoChangeStyle(false);
        this.ioT.setIsRound(true);
        this.ioT.setBorderWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        this.ioT.setBorderColor(-1275068417);
        this.ioT.setDefaultBgResource(a.e.sdk_default_avatar);
    }

    private void cqD() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1072425964);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds26));
        this.ioU.setBackgroundDrawable(gradientDrawable);
    }
}
