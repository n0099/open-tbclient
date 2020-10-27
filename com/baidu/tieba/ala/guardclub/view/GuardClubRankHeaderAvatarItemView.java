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
    private HeadImageView aEp;
    private TbImageView gDq;
    private LottieAnimationView gDr;
    private AnimatorSet gDs;
    private boolean gDt;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aEp != null) {
            this.aEp.startLoad(str, 12, false);
        }
        if (this.gDq != null) {
            this.gDq.startLoad(str2, 10, false);
        }
        this.gDt = z;
        if (z) {
            this.gDr.setVisibility(0);
            bRj();
            return;
        }
        bRk();
        this.gDr.setVisibility(8);
    }

    public void bRj() {
        if (this.gDt) {
            bRl();
            this.gDr.playAnimation();
            this.gDs.start();
        }
    }

    public void bRk() {
        if (this.gDr != null) {
            this.gDr.cancelAnimation();
        }
        if (this.gDs != null) {
            this.gDs.cancel();
        }
    }

    public void release() {
        if (this.aEp != null) {
            this.aEp.stopLoad();
        }
        if (this.gDq != null) {
            this.gDq.stopLoad();
        }
        bRk();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aEp = (HeadImageView) findViewById(a.g.iv_avatar);
        this.gDq = (TbImageView) findViewById(a.g.iv_level);
        this.gDr = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.aEp.setIsRound(true);
        this.aEp.setAutoChangeStyle(false);
        this.aEp.setDrawBorder(false);
        this.aEp.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aEp.setDefaultBgResource(a.f.sdk_default_avatar);
        this.gDq.setDefaultBgResource(a.d.sdk_transparent);
        this.gDq.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void bRl() {
        this.gDr.setAnimation("live_anim_guard_join.json");
        this.gDr.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aEp, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aEp, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.gDs = new AnimatorSet();
        this.gDs.setDuration(1000L);
        this.gDs.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gDs.play(ofFloat).with(ofFloat2);
    }
}
