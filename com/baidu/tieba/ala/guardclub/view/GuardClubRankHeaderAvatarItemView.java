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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes6.dex */
public class GuardClubRankHeaderAvatarItemView extends FrameLayout {
    private HeadImageView Xg;
    private TbImageView dOX;
    private LottieAnimationView dOY;
    private AnimatorSet dOZ;
    private boolean dPa;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.Xg != null) {
            this.Xg.startLoad(str, 12, false);
        }
        if (this.dOX != null) {
            this.dOX.startLoad(str2, 10, false);
        }
        this.dPa = z;
        if (z) {
            this.dOY.setVisibility(0);
            aMa();
            return;
        }
        aMb();
        this.dOY.setVisibility(8);
    }

    public void aMa() {
        if (this.dPa) {
            aMc();
            this.dOY.playAnimation();
            this.dOZ.start();
        }
    }

    public void aMb() {
        if (this.dOY != null) {
            this.dOY.cancelAnimation();
        }
        if (this.dOZ != null) {
            this.dOZ.cancel();
        }
    }

    public void release() {
        if (this.Xg != null) {
            this.Xg.stopLoad();
        }
        if (this.dOX != null) {
            this.dOX.stopLoad();
        }
        aMb();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.Xg = (HeadImageView) findViewById(a.g.iv_avatar);
        this.dOX = (TbImageView) findViewById(a.g.iv_level);
        this.dOY = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.Xg.setIsRound(true);
        this.Xg.setAutoChangeStyle(false);
        this.Xg.setDrawBorder(false);
        this.Xg.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Xg.setDefaultBgResource(a.f.sdk_default_avatar);
        this.dOX.setDefaultBgResource(a.d.sdk_transparent);
        this.dOX.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void aMc() {
        this.dOY.setAnimation("live_anim_guard_join.json");
        this.dOY.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.Xg, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.Xg, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.dOZ = new AnimatorSet();
        this.dOZ.setDuration(1000L);
        this.dOZ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.dOZ.play(ofFloat).with(ofFloat2);
    }
}
