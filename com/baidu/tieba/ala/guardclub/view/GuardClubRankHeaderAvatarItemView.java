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
    private HeadImageView aEh;
    private TbImageView gtm;
    private LottieAnimationView gtn;
    private AnimatorSet gto;
    private boolean gtp;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aEh != null) {
            this.aEh.startLoad(str, 12, false);
        }
        if (this.gtm != null) {
            this.gtm.startLoad(str2, 10, false);
        }
        this.gtp = z;
        if (z) {
            this.gtn.setVisibility(0);
            bOE();
            return;
        }
        bOF();
        this.gtn.setVisibility(8);
    }

    public void bOE() {
        if (this.gtp) {
            bOG();
            this.gtn.playAnimation();
            this.gto.start();
        }
    }

    public void bOF() {
        if (this.gtn != null) {
            this.gtn.cancelAnimation();
        }
        if (this.gto != null) {
            this.gto.cancel();
        }
    }

    public void release() {
        if (this.aEh != null) {
            this.aEh.stopLoad();
        }
        if (this.gtm != null) {
            this.gtm.stopLoad();
        }
        bOF();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aEh = (HeadImageView) findViewById(a.g.iv_avatar);
        this.gtm = (TbImageView) findViewById(a.g.iv_level);
        this.gtn = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.aEh.setIsRound(true);
        this.aEh.setAutoChangeStyle(false);
        this.aEh.setDrawBorder(false);
        this.aEh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aEh.setDefaultBgResource(a.f.sdk_default_avatar);
        this.gtm.setDefaultBgResource(a.d.sdk_transparent);
        this.gtm.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void bOG() {
        this.gtn.setAnimation("live_anim_guard_join.json");
        this.gtn.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aEh, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aEh, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.gto = new AnimatorSet();
        this.gto.setDuration(1000L);
        this.gto.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gto.play(ofFloat).with(ofFloat2);
    }
}
