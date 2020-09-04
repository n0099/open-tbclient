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
    private HeadImageView aAw;
    private TbImageView gdL;
    private LottieAnimationView gdM;
    private AnimatorSet gdN;
    private boolean gdO;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aAw != null) {
            this.aAw.startLoad(str, 12, false);
        }
        if (this.gdL != null) {
            this.gdL.startLoad(str2, 10, false);
        }
        this.gdO = z;
        if (z) {
            this.gdM.setVisibility(0);
            bKK();
            return;
        }
        bKL();
        this.gdM.setVisibility(8);
    }

    public void bKK() {
        if (this.gdO) {
            bKM();
            this.gdM.playAnimation();
            this.gdN.start();
        }
    }

    public void bKL() {
        if (this.gdM != null) {
            this.gdM.cancelAnimation();
        }
        if (this.gdN != null) {
            this.gdN.cancel();
        }
    }

    public void release() {
        if (this.aAw != null) {
            this.aAw.stopLoad();
        }
        if (this.gdL != null) {
            this.gdL.stopLoad();
        }
        bKL();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aAw = (HeadImageView) findViewById(a.g.iv_avatar);
        this.gdL = (TbImageView) findViewById(a.g.iv_level);
        this.gdM = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.aAw.setIsRound(true);
        this.aAw.setAutoChangeStyle(false);
        this.aAw.setDrawBorder(false);
        this.aAw.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aAw.setDefaultBgResource(a.f.sdk_default_avatar);
        this.gdL.setDefaultBgResource(a.d.sdk_transparent);
        this.gdL.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void bKM() {
        this.gdM.setAnimation("live_anim_guard_join.json");
        this.gdM.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aAw, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aAw, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.gdN = new AnimatorSet();
        this.gdN.setDuration(1000L);
        this.gdN.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gdN.play(ofFloat).with(ofFloat2);
    }
}
