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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes2.dex */
public class GuardClubRankHeaderAvatarItemView extends FrameLayout {
    private HeadImageView aeR;
    private TbImageView eDd;
    private LottieAnimationView eDe;
    private AnimatorSet eDf;
    private boolean eDg;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aeR != null) {
            this.aeR.startLoad(str, 12, false);
        }
        if (this.eDd != null) {
            this.eDd.startLoad(str2, 10, false);
        }
        this.eDg = z;
        if (z) {
            this.eDe.setVisibility(0);
            bdj();
            return;
        }
        bdk();
        this.eDe.setVisibility(8);
    }

    public void bdj() {
        if (this.eDg) {
            bdl();
            this.eDe.playAnimation();
            this.eDf.start();
        }
    }

    public void bdk() {
        if (this.eDe != null) {
            this.eDe.cancelAnimation();
        }
        if (this.eDf != null) {
            this.eDf.cancel();
        }
    }

    public void release() {
        if (this.aeR != null) {
            this.aeR.stopLoad();
        }
        if (this.eDd != null) {
            this.eDd.stopLoad();
        }
        bdk();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aeR = (HeadImageView) findViewById(a.g.iv_avatar);
        this.eDd = (TbImageView) findViewById(a.g.iv_level);
        this.eDe = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.aeR.setIsRound(true);
        this.aeR.setAutoChangeStyle(false);
        this.aeR.setDrawBorder(false);
        this.aeR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aeR.setDefaultBgResource(a.f.sdk_default_avatar);
        this.eDd.setDefaultBgResource(a.d.sdk_transparent);
        this.eDd.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void bdl() {
        this.eDe.setAnimation("live_anim_guard_join.json");
        this.eDe.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aeR, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aeR, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.eDf = new AnimatorSet();
        this.eDf.setDuration(1000L);
        this.eDf.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eDf.play(ofFloat).with(ofFloat2);
    }
}
