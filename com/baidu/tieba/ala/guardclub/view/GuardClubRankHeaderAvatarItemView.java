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
    private HeadImageView avs;
    private TbImageView fRJ;
    private LottieAnimationView fRK;
    private AnimatorSet fRL;
    private boolean fRM;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.avs != null) {
            this.avs.startLoad(str, 12, false);
        }
        if (this.fRJ != null) {
            this.fRJ.startLoad(str2, 10, false);
        }
        this.fRM = z;
        if (z) {
            this.fRK.setVisibility(0);
            bBp();
            return;
        }
        bBq();
        this.fRK.setVisibility(8);
    }

    public void bBp() {
        if (this.fRM) {
            bBr();
            this.fRK.playAnimation();
            this.fRL.start();
        }
    }

    public void bBq() {
        if (this.fRK != null) {
            this.fRK.cancelAnimation();
        }
        if (this.fRL != null) {
            this.fRL.cancel();
        }
    }

    public void release() {
        if (this.avs != null) {
            this.avs.stopLoad();
        }
        if (this.fRJ != null) {
            this.fRJ.stopLoad();
        }
        bBq();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.avs = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fRJ = (TbImageView) findViewById(a.g.iv_level);
        this.fRK = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.avs.setIsRound(true);
        this.avs.setAutoChangeStyle(false);
        this.avs.setDrawBorder(false);
        this.avs.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.avs.setDefaultBgResource(a.f.sdk_default_avatar);
        this.fRJ.setDefaultBgResource(a.d.sdk_transparent);
        this.fRJ.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void bBr() {
        this.fRK.setAnimation("live_anim_guard_join.json");
        this.fRK.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.avs, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.avs, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.fRL = new AnimatorSet();
        this.fRL.setDuration(1000L);
        this.fRL.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fRL.play(ofFloat).with(ofFloat2);
    }
}
