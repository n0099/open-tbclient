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
    private HeadImageView aGa;
    private TbImageView bOr;
    private LottieAnimationView gRW;
    private AnimatorSet gRX;
    private boolean gRY;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aGa != null) {
            this.aGa.startLoad(str, 12, false);
        }
        if (this.bOr != null) {
            this.bOr.startLoad(str2, 10, false);
        }
        this.gRY = z;
        if (z) {
            this.gRW.setVisibility(0);
            bWL();
            return;
        }
        bWM();
        this.gRW.setVisibility(8);
    }

    public void bWL() {
        if (this.gRY) {
            bWN();
            this.gRW.playAnimation();
            this.gRX.start();
        }
    }

    public void bWM() {
        if (this.gRW != null) {
            this.gRW.cancelAnimation();
        }
        if (this.gRX != null) {
            this.gRX.cancel();
        }
    }

    public void release() {
        if (this.aGa != null) {
            this.aGa.stopLoad();
        }
        if (this.bOr != null) {
            this.bOr.stopLoad();
        }
        bWM();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aGa = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bOr = (TbImageView) findViewById(a.f.iv_level);
        this.gRW = (LottieAnimationView) findViewById(a.f.lottie_live);
        this.aGa.setIsRound(true);
        this.aGa.setAutoChangeStyle(false);
        this.aGa.setDrawBorder(false);
        this.aGa.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aGa.setDefaultBgResource(a.e.sdk_default_avatar);
        this.bOr.setDefaultBgResource(a.c.sdk_transparent);
        this.bOr.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void bWN() {
        this.gRW.setAnimation("live_anim_guard_join.json");
        this.gRW.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aGa, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aGa, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.gRX = new AnimatorSet();
        this.gRX.setDuration(1000L);
        this.gRX.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gRX.play(ofFloat).with(ofFloat2);
    }
}
