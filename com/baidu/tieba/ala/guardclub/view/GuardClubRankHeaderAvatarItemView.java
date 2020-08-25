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
/* loaded from: classes7.dex */
public class GuardClubRankHeaderAvatarItemView extends FrameLayout {
    private HeadImageView aAu;
    private TbImageView gdH;
    private LottieAnimationView gdI;
    private AnimatorSet gdJ;
    private boolean gdK;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aAu != null) {
            this.aAu.startLoad(str, 12, false);
        }
        if (this.gdH != null) {
            this.gdH.startLoad(str2, 10, false);
        }
        this.gdK = z;
        if (z) {
            this.gdI.setVisibility(0);
            bKJ();
            return;
        }
        bKK();
        this.gdI.setVisibility(8);
    }

    public void bKJ() {
        if (this.gdK) {
            bKL();
            this.gdI.playAnimation();
            this.gdJ.start();
        }
    }

    public void bKK() {
        if (this.gdI != null) {
            this.gdI.cancelAnimation();
        }
        if (this.gdJ != null) {
            this.gdJ.cancel();
        }
    }

    public void release() {
        if (this.aAu != null) {
            this.aAu.stopLoad();
        }
        if (this.gdH != null) {
            this.gdH.stopLoad();
        }
        bKK();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aAu = (HeadImageView) findViewById(a.g.iv_avatar);
        this.gdH = (TbImageView) findViewById(a.g.iv_level);
        this.gdI = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.aAu.setIsRound(true);
        this.aAu.setAutoChangeStyle(false);
        this.aAu.setDrawBorder(false);
        this.aAu.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aAu.setDefaultBgResource(a.f.sdk_default_avatar);
        this.gdH.setDefaultBgResource(a.d.sdk_transparent);
        this.gdH.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void bKL() {
        this.gdI.setAnimation("live_anim_guard_join.json");
        this.gdI.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aAu, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aAu, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.gdJ = new AnimatorSet();
        this.gdJ.setDuration(1000L);
        this.gdJ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gdJ.play(ofFloat).with(ofFloat2);
    }
}
