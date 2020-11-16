package com.baidu.tieba.ala.guardclub.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class GuardClubRankHeaderAvatarItemView extends FrameLayout {
    private HeadImageView aDu;
    private TbImageView bJj;
    private LottieAnimationView gIL;
    private AnimatorSet gIM;
    private boolean gIN;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aDu != null) {
            this.aDu.startLoad(str, 12, false);
        }
        if (this.bJj != null) {
            this.bJj.startLoad(str2, 10, false);
        }
        this.gIN = z;
        if (z) {
            this.gIL.setVisibility(0);
            bTb();
            return;
        }
        bTc();
        this.gIL.setVisibility(8);
    }

    public void bTb() {
        if (this.gIN) {
            bTd();
            this.gIL.playAnimation();
            this.gIM.start();
        }
    }

    public void bTc() {
        if (this.gIL != null) {
            this.gIL.cancelAnimation();
        }
        if (this.gIM != null) {
            this.gIM.cancel();
        }
    }

    public void release() {
        if (this.aDu != null) {
            this.aDu.stopLoad();
        }
        if (this.bJj != null) {
            this.bJj.stopLoad();
        }
        bTc();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aDu = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bJj = (TbImageView) findViewById(a.f.iv_level);
        this.gIL = (LottieAnimationView) findViewById(a.f.lottie_live);
        this.aDu.setIsRound(true);
        this.aDu.setAutoChangeStyle(false);
        this.aDu.setDrawBorder(false);
        this.aDu.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aDu.setDefaultBgResource(a.e.sdk_default_avatar);
        this.bJj.setDefaultBgResource(a.c.sdk_transparent);
        this.bJj.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void bTd() {
        this.gIL.setAnimation("live_anim_guard_join.json");
        this.gIL.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aDu, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aDu, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.gIM = new AnimatorSet();
        this.gIM.setDuration(1000L);
        this.gIM.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gIM.play(ofFloat).with(ofFloat2);
    }
}
