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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes6.dex */
public class GuardClubRankHeaderAvatarItemView extends FrameLayout {
    private HeadImageView Xy;
    private TbImageView dPO;
    private LottieAnimationView dPP;
    private AnimatorSet dPQ;
    private boolean dPR;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.Xy != null) {
            this.Xy.startLoad(str, 12, false);
        }
        if (this.dPO != null) {
            this.dPO.startLoad(str2, 10, false);
        }
        this.dPR = z;
        if (z) {
            this.dPP.setVisibility(0);
            aMc();
            return;
        }
        aMd();
        this.dPP.setVisibility(8);
    }

    public void aMc() {
        if (this.dPR) {
            aMe();
            this.dPP.playAnimation();
            this.dPQ.start();
        }
    }

    public void aMd() {
        if (this.dPP != null) {
            this.dPP.cancelAnimation();
        }
        if (this.dPQ != null) {
            this.dPQ.cancel();
        }
    }

    public void release() {
        if (this.Xy != null) {
            this.Xy.stopLoad();
        }
        if (this.dPO != null) {
            this.dPO.stopLoad();
        }
        aMd();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.Xy = (HeadImageView) findViewById(a.g.iv_avatar);
        this.dPO = (TbImageView) findViewById(a.g.iv_level);
        this.dPP = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.Xy.setIsRound(true);
        this.Xy.setAutoChangeStyle(false);
        this.Xy.setDrawBorder(false);
        this.Xy.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Xy.setDefaultBgResource(a.f.sdk_default_avatar);
        this.dPO.setDefaultBgResource(a.d.sdk_transparent);
        this.dPO.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void aMe() {
        this.dPP.setAnimation("live_anim_guard_join.json");
        this.dPP.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.Xy, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.Xy, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.dPQ = new AnimatorSet();
        this.dPQ.setDuration(1000L);
        this.dPQ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.dPQ.play(ofFloat).with(ofFloat2);
    }
}
