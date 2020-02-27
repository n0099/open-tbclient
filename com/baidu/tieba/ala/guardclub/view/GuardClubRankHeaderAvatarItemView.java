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
    private HeadImageView ahI;
    private TbImageView eIi;
    private LottieAnimationView eIj;
    private AnimatorSet eIk;
    private boolean eIl;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.ahI != null) {
            this.ahI.startLoad(str, 12, false);
        }
        if (this.eIi != null) {
            this.eIi.startLoad(str2, 10, false);
        }
        this.eIl = z;
        if (z) {
            this.eIj.setVisibility(0);
            bfO();
            return;
        }
        bfP();
        this.eIj.setVisibility(8);
    }

    public void bfO() {
        if (this.eIl) {
            bfQ();
            this.eIj.playAnimation();
            this.eIk.start();
        }
    }

    public void bfP() {
        if (this.eIj != null) {
            this.eIj.cancelAnimation();
        }
        if (this.eIk != null) {
            this.eIk.cancel();
        }
    }

    public void release() {
        if (this.ahI != null) {
            this.ahI.stopLoad();
        }
        if (this.eIi != null) {
            this.eIi.stopLoad();
        }
        bfP();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.ahI = (HeadImageView) findViewById(a.g.iv_avatar);
        this.eIi = (TbImageView) findViewById(a.g.iv_level);
        this.eIj = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.ahI.setIsRound(true);
        this.ahI.setAutoChangeStyle(false);
        this.ahI.setDrawBorder(false);
        this.ahI.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ahI.setDefaultBgResource(a.f.sdk_default_avatar);
        this.eIi.setDefaultBgResource(a.d.sdk_transparent);
        this.eIi.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void bfQ() {
        this.eIj.setAnimation("live_anim_guard_join.json");
        this.eIj.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ahI, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ahI, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.eIk = new AnimatorSet();
        this.eIk.setDuration(1000L);
        this.eIk.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eIk.play(ofFloat).with(ofFloat2);
    }
}
