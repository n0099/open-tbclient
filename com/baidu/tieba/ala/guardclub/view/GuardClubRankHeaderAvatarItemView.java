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
    private HeadImageView aBc;
    private TbImageView ggX;
    private LottieAnimationView ggY;
    private AnimatorSet ggZ;
    private boolean gha;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aBc != null) {
            this.aBc.startLoad(str, 12, false);
        }
        if (this.ggX != null) {
            this.ggX.startLoad(str2, 10, false);
        }
        this.gha = z;
        if (z) {
            this.ggY.setVisibility(0);
            bLU();
            return;
        }
        bLV();
        this.ggY.setVisibility(8);
    }

    public void bLU() {
        if (this.gha) {
            bLW();
            this.ggY.playAnimation();
            this.ggZ.start();
        }
    }

    public void bLV() {
        if (this.ggY != null) {
            this.ggY.cancelAnimation();
        }
        if (this.ggZ != null) {
            this.ggZ.cancel();
        }
    }

    public void release() {
        if (this.aBc != null) {
            this.aBc.stopLoad();
        }
        if (this.ggX != null) {
            this.ggX.stopLoad();
        }
        bLV();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aBc = (HeadImageView) findViewById(a.g.iv_avatar);
        this.ggX = (TbImageView) findViewById(a.g.iv_level);
        this.ggY = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.aBc.setIsRound(true);
        this.aBc.setAutoChangeStyle(false);
        this.aBc.setDrawBorder(false);
        this.aBc.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aBc.setDefaultBgResource(a.f.sdk_default_avatar);
        this.ggX.setDefaultBgResource(a.d.sdk_transparent);
        this.ggX.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void bLW() {
        this.ggY.setAnimation("live_anim_guard_join.json");
        this.ggY.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aBc, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aBc, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.ggZ = new AnimatorSet();
        this.ggZ.setDuration(1000L);
        this.ggZ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ggZ.play(ofFloat).with(ofFloat2);
    }
}
