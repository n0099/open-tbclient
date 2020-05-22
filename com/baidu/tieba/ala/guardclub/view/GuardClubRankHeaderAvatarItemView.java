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
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes3.dex */
public class GuardClubRankHeaderAvatarItemView extends FrameLayout {
    private HeadImageView aFL;
    private TbImageView fAV;
    private LottieAnimationView fAW;
    private AnimatorSet fAX;
    private boolean fAY;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aFL != null) {
            this.aFL.startLoad(str, 12, false);
        }
        if (this.fAV != null) {
            this.fAV.startLoad(str2, 10, false);
        }
        this.fAY = z;
        if (z) {
            this.fAW.setVisibility(0);
            bvc();
            return;
        }
        bvd();
        this.fAW.setVisibility(8);
    }

    public void bvc() {
        if (this.fAY) {
            bve();
            this.fAW.playAnimation();
            this.fAX.start();
        }
    }

    public void bvd() {
        if (this.fAW != null) {
            this.fAW.cancelAnimation();
        }
        if (this.fAX != null) {
            this.fAX.cancel();
        }
    }

    public void release() {
        if (this.aFL != null) {
            this.aFL.stopLoad();
        }
        if (this.fAV != null) {
            this.fAV.stopLoad();
        }
        bvd();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aFL = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fAV = (TbImageView) findViewById(a.g.iv_level);
        this.fAW = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.aFL.setIsRound(true);
        this.aFL.setAutoChangeStyle(false);
        this.aFL.setDrawBorder(false);
        this.aFL.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aFL.setDefaultBgResource(a.f.sdk_default_avatar);
        this.fAV.setDefaultBgResource(a.d.sdk_transparent);
        this.fAV.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void bve() {
        this.fAW.setAnimation("live_anim_guard_join.json");
        this.fAW.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aFL, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aFL, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.fAX = new AnimatorSet();
        this.fAX.setDuration(1000L);
        this.fAX.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fAX.play(ofFloat).with(ofFloat2);
    }
}
