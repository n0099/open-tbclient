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
    private HeadImageView aAs;
    private TbImageView fno;
    private LottieAnimationView fnp;
    private AnimatorSet fnq;
    private boolean fnr;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aAs != null) {
            this.aAs.startLoad(str, 12, false);
        }
        if (this.fno != null) {
            this.fno.startLoad(str2, 10, false);
        }
        this.fnr = z;
        if (z) {
            this.fnp.setVisibility(0);
            bpl();
            return;
        }
        bpm();
        this.fnp.setVisibility(8);
    }

    public void bpl() {
        if (this.fnr) {
            bpn();
            this.fnp.playAnimation();
            this.fnq.start();
        }
    }

    public void bpm() {
        if (this.fnp != null) {
            this.fnp.cancelAnimation();
        }
        if (this.fnq != null) {
            this.fnq.cancel();
        }
    }

    public void release() {
        if (this.aAs != null) {
            this.aAs.stopLoad();
        }
        if (this.fno != null) {
            this.fno.stopLoad();
        }
        bpm();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aAs = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fno = (TbImageView) findViewById(a.g.iv_level);
        this.fnp = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.aAs.setIsRound(true);
        this.aAs.setAutoChangeStyle(false);
        this.aAs.setDrawBorder(false);
        this.aAs.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aAs.setDefaultBgResource(a.f.sdk_default_avatar);
        this.fno.setDefaultBgResource(a.d.sdk_transparent);
        this.fno.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void bpn() {
        this.fnp.setAnimation("live_anim_guard_join.json");
        this.fnp.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aAs, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aAs, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.fnq = new AnimatorSet();
        this.fnq.setDuration(1000L);
        this.fnq.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fnq.play(ofFloat).with(ofFloat2);
    }
}
