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
    private TbImageView eIw;
    private LottieAnimationView eIx;
    private AnimatorSet eIy;
    private boolean eIz;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.ahI != null) {
            this.ahI.startLoad(str, 12, false);
        }
        if (this.eIw != null) {
            this.eIw.startLoad(str2, 10, false);
        }
        this.eIz = z;
        if (z) {
            this.eIx.setVisibility(0);
            bfR();
            return;
        }
        bfS();
        this.eIx.setVisibility(8);
    }

    public void bfR() {
        if (this.eIz) {
            bfT();
            this.eIx.playAnimation();
            this.eIy.start();
        }
    }

    public void bfS() {
        if (this.eIx != null) {
            this.eIx.cancelAnimation();
        }
        if (this.eIy != null) {
            this.eIy.cancel();
        }
    }

    public void release() {
        if (this.ahI != null) {
            this.ahI.stopLoad();
        }
        if (this.eIw != null) {
            this.eIw.stopLoad();
        }
        bfS();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.ahI = (HeadImageView) findViewById(a.g.iv_avatar);
        this.eIw = (TbImageView) findViewById(a.g.iv_level);
        this.eIx = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.ahI.setIsRound(true);
        this.ahI.setAutoChangeStyle(false);
        this.ahI.setDrawBorder(false);
        this.ahI.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ahI.setDefaultBgResource(a.f.sdk_default_avatar);
        this.eIw.setDefaultBgResource(a.d.sdk_transparent);
        this.eIw.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void bfT() {
        this.eIx.setAnimation("live_anim_guard_join.json");
        this.eIx.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ahI, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ahI, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.eIy = new AnimatorSet();
        this.eIy.setDuration(1000L);
        this.eIy.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eIy.play(ofFloat).with(ofFloat2);
    }
}
