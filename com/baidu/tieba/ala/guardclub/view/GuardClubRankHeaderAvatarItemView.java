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
    private HeadImageView aFf;
    private TbImageView bKU;
    private LottieAnimationView gJe;
    private AnimatorSet gJf;
    private boolean gJg;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aFf != null) {
            this.aFf.startLoad(str, 12, false);
        }
        if (this.bKU != null) {
            this.bKU.startLoad(str2, 10, false);
        }
        this.gJg = z;
        if (z) {
            this.gJe.setVisibility(0);
            bTI();
            return;
        }
        bTJ();
        this.gJe.setVisibility(8);
    }

    public void bTI() {
        if (this.gJg) {
            bTK();
            this.gJe.playAnimation();
            this.gJf.start();
        }
    }

    public void bTJ() {
        if (this.gJe != null) {
            this.gJe.cancelAnimation();
        }
        if (this.gJf != null) {
            this.gJf.cancel();
        }
    }

    public void release() {
        if (this.aFf != null) {
            this.aFf.stopLoad();
        }
        if (this.bKU != null) {
            this.bKU.stopLoad();
        }
        bTJ();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aFf = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bKU = (TbImageView) findViewById(a.f.iv_level);
        this.gJe = (LottieAnimationView) findViewById(a.f.lottie_live);
        this.aFf.setIsRound(true);
        this.aFf.setAutoChangeStyle(false);
        this.aFf.setDrawBorder(false);
        this.aFf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aFf.setDefaultBgResource(a.e.sdk_default_avatar);
        this.bKU.setDefaultBgResource(a.c.sdk_transparent);
        this.bKU.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void bTK() {
        this.gJe.setAnimation("live_anim_guard_join.json");
        this.gJe.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aFf, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aFf, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.gJf = new AnimatorSet();
        this.gJf.setDuration(1000L);
        this.gJf.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gJf.play(ofFloat).with(ofFloat2);
    }
}
