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
/* loaded from: classes3.dex */
public class GuardClubRankHeaderAvatarItemView extends FrameLayout {
    private HeadImageView aIh;
    private TbImageView fMp;
    private LottieAnimationView fMq;
    private AnimatorSet fMr;
    private boolean fMs;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aIh != null) {
            this.aIh.startLoad(str, 12, false);
        }
        if (this.fMp != null) {
            this.fMp.startLoad(str2, 10, false);
        }
        this.fMs = z;
        if (z) {
            this.fMq.setVisibility(0);
            bxZ();
            return;
        }
        bya();
        this.fMq.setVisibility(8);
    }

    public void bxZ() {
        if (this.fMs) {
            byb();
            this.fMq.playAnimation();
            this.fMr.start();
        }
    }

    public void bya() {
        if (this.fMq != null) {
            this.fMq.cancelAnimation();
        }
        if (this.fMr != null) {
            this.fMr.cancel();
        }
    }

    public void release() {
        if (this.aIh != null) {
            this.aIh.stopLoad();
        }
        if (this.fMp != null) {
            this.fMp.stopLoad();
        }
        bya();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aIh = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fMp = (TbImageView) findViewById(a.g.iv_level);
        this.fMq = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.aIh.setIsRound(true);
        this.aIh.setAutoChangeStyle(false);
        this.aIh.setDrawBorder(false);
        this.aIh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aIh.setDefaultBgResource(a.f.sdk_default_avatar);
        this.fMp.setDefaultBgResource(a.d.sdk_transparent);
        this.fMp.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void byb() {
        this.fMq.setAnimation("live_anim_guard_join.json");
        this.fMq.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aIh, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aIh, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.fMr = new AnimatorSet();
        this.fMr.setDuration(1000L);
        this.fMr.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fMr.play(ofFloat).with(ofFloat2);
    }
}
