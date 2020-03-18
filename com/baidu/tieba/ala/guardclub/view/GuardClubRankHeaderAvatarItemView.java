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
    private HeadImageView ahS;
    private TbImageView eIS;
    private LottieAnimationView eIT;
    private AnimatorSet eIU;
    private boolean eIV;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.ahS != null) {
            this.ahS.startLoad(str, 12, false);
        }
        if (this.eIS != null) {
            this.eIS.startLoad(str2, 10, false);
        }
        this.eIV = z;
        if (z) {
            this.eIT.setVisibility(0);
            bfW();
            return;
        }
        bfX();
        this.eIT.setVisibility(8);
    }

    public void bfW() {
        if (this.eIV) {
            bfY();
            this.eIT.playAnimation();
            this.eIU.start();
        }
    }

    public void bfX() {
        if (this.eIT != null) {
            this.eIT.cancelAnimation();
        }
        if (this.eIU != null) {
            this.eIU.cancel();
        }
    }

    public void release() {
        if (this.ahS != null) {
            this.ahS.stopLoad();
        }
        if (this.eIS != null) {
            this.eIS.stopLoad();
        }
        bfX();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.ahS = (HeadImageView) findViewById(a.g.iv_avatar);
        this.eIS = (TbImageView) findViewById(a.g.iv_level);
        this.eIT = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.ahS.setIsRound(true);
        this.ahS.setAutoChangeStyle(false);
        this.ahS.setDrawBorder(false);
        this.ahS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ahS.setDefaultBgResource(a.f.sdk_default_avatar);
        this.eIS.setDefaultBgResource(a.d.sdk_transparent);
        this.eIS.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void bfY() {
        this.eIT.setAnimation("live_anim_guard_join.json");
        this.eIT.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ahS, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ahS, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.eIU = new AnimatorSet();
        this.eIU.setDuration(1000L);
        this.eIU.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eIU.play(ofFloat).with(ofFloat2);
    }
}
