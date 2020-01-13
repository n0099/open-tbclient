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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes2.dex */
public class GuardClubRankHeaderAvatarItemView extends FrameLayout {
    private HeadImageView afA;
    private TbImageView eEo;
    private LottieAnimationView eEp;
    private AnimatorSet eEq;
    private boolean eEr;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.afA != null) {
            this.afA.startLoad(str, 12, false);
        }
        if (this.eEo != null) {
            this.eEo.startLoad(str2, 10, false);
        }
        this.eEr = z;
        if (z) {
            this.eEp.setVisibility(0);
            bdE();
            return;
        }
        bdF();
        this.eEp.setVisibility(8);
    }

    public void bdE() {
        if (this.eEr) {
            bdG();
            this.eEp.playAnimation();
            this.eEq.start();
        }
    }

    public void bdF() {
        if (this.eEp != null) {
            this.eEp.cancelAnimation();
        }
        if (this.eEq != null) {
            this.eEq.cancel();
        }
    }

    public void release() {
        if (this.afA != null) {
            this.afA.stopLoad();
        }
        if (this.eEo != null) {
            this.eEo.stopLoad();
        }
        bdF();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.afA = (HeadImageView) findViewById(a.g.iv_avatar);
        this.eEo = (TbImageView) findViewById(a.g.iv_level);
        this.eEp = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.afA.setIsRound(true);
        this.afA.setAutoChangeStyle(false);
        this.afA.setDrawBorder(false);
        this.afA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.afA.setDefaultBgResource(a.f.sdk_default_avatar);
        this.eEo.setDefaultBgResource(a.d.sdk_transparent);
        this.eEo.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void bdG() {
        this.eEp.setAnimation("live_anim_guard_join.json");
        this.eEp.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.afA, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.afA, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.eEq = new AnimatorSet();
        this.eEq.setDuration(1000L);
        this.eEq.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eEq.play(ofFloat).with(ofFloat2);
    }
}
