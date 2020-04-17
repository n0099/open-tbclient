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
    private HeadImageView aAm;
    private TbImageView fnj;
    private LottieAnimationView fnk;
    private AnimatorSet fnl;
    private boolean fnm;

    public GuardClubRankHeaderAvatarItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(String str, String str2, boolean z) {
        if (this.aAm != null) {
            this.aAm.startLoad(str, 12, false);
        }
        if (this.fnj != null) {
            this.fnj.startLoad(str2, 10, false);
        }
        this.fnm = z;
        if (z) {
            this.fnk.setVisibility(0);
            bpn();
            return;
        }
        bpo();
        this.fnk.setVisibility(8);
    }

    public void bpn() {
        if (this.fnm) {
            bpp();
            this.fnk.playAnimation();
            this.fnl.start();
        }
    }

    public void bpo() {
        if (this.fnk != null) {
            this.fnk.cancelAnimation();
        }
        if (this.fnl != null) {
            this.fnl.cancel();
        }
    }

    public void release() {
        if (this.aAm != null) {
            this.aAm.stopLoad();
        }
        if (this.fnj != null) {
            this.fnj.stopLoad();
        }
        bpo();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_avatar_item, (ViewGroup) this, true);
        this.aAm = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fnj = (TbImageView) findViewById(a.g.iv_level);
        this.fnk = (LottieAnimationView) findViewById(a.g.lottie_live);
        this.aAm.setIsRound(true);
        this.aAm.setAutoChangeStyle(false);
        this.aAm.setDrawBorder(false);
        this.aAm.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aAm.setDefaultBgResource(a.f.sdk_default_avatar);
        this.fnj.setDefaultBgResource(a.d.sdk_transparent);
        this.fnj.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void bpp() {
        this.fnk.setAnimation("live_anim_guard_join.json");
        this.fnk.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aAm, "scaleX", 0.92f, 1.0f, 0.92f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aAm, "scaleY", 0.92f, 1.0f, 0.92f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        this.fnl = new AnimatorSet();
        this.fnl.setDuration(1000L);
        this.fnl.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fnl.play(ofFloat).with(ofFloat2);
    }
}
