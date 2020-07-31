package com.baidu.tieba.ala.charm;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class RedPacketCharmView extends RelativeLayout {
    private HeadImageView avs;
    private LottieAnimationView fFk;
    private ImageView fFl;
    private View fFm;
    private TextView fFn;
    private View fFo;
    private TextView fFp;
    private ImageView fFq;
    private TextView fFr;
    private String mAvatar;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void qL(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            bzn();
            bzp();
            switch (i) {
                case 1:
                    this.fFl.setImageResource(a.f.icon_redpacket_charm_body_02);
                    this.avs.setVisibility(0);
                    this.fFo.setVisibility(8);
                    this.fFr.setVisibility(0);
                    return;
                case 2:
                    this.fFl.setImageResource(a.f.icon_redpacket_charm_body_02);
                    bzl();
                    return;
                case 3:
                    this.fFl.setImageResource(a.f.icon_redpacket_charm_body_01);
                    bzl();
                    bzm();
                    return;
                case 4:
                    this.fFl.setImageResource(a.f.icon_redpacket_charm_body_01);
                    this.avs.setVisibility(8);
                    this.fFo.setVisibility(0);
                    this.fFp.setVisibility(8);
                    this.fFq.setVisibility(0);
                    this.fFr.setVisibility(4);
                    bzm();
                    bzo();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.fFm.setVisibility(0);
            if (TextUtils.isEmpty(this.fFn.getText()) || !this.fFn.getText().equals(str)) {
                this.fFn.setText(str);
                Drawable background = this.fFm.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.fFm.setBackgroundDrawable(background);
                }
                Drawable background2 = this.fFn.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.fFn.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.fFm.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.avs.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.fFp.setText(str);
        this.fFr.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        bzn();
        bzp();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.red_packet_widget_charm, (ViewGroup) this, true);
        this.fFk = (LottieAnimationView) findViewById(a.g.lottie_redpacket_charm);
        this.fFl = (ImageView) findViewById(a.g.iv_redpacket_charm_body);
        this.fFm = findViewById(a.g.layout_badge);
        this.fFn = (TextView) findViewById(a.g.tv_badge);
        this.avs = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fFo = findViewById(a.g.layout_action);
        this.fFp = (TextView) findViewById(a.g.tv_countdown_action);
        this.fFq = (ImageView) findViewById(a.g.iv_process);
        this.fFr = (TextView) findViewById(a.g.tv_countdown_format);
        this.fFk.loop(true);
        this.fFk.setAnimation("sdk_redpacket_charm_coin.json");
        this.avs.setIsRound(true);
        this.avs.setAutoChangeStyle(false);
        this.avs.setBorderColor(-4981);
        this.avs.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.avs.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bzl() {
        this.avs.setVisibility(8);
        this.fFo.setVisibility(0);
        this.fFp.setVisibility(0);
        this.fFq.setVisibility(8);
        this.fFr.setVisibility(4);
    }

    private void bzm() {
        if (this.fFk != null) {
            this.fFk.setVisibility(0);
            this.fFk.playAnimation();
        }
    }

    private void bzn() {
        if (this.fFk != null) {
            this.fFk.cancelAnimation();
            this.fFk.setVisibility(4);
        }
    }

    private void bzo() {
        if (this.fFo != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fFo, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fFo, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.fFo.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bzp() {
        if (this.fFo != null && (this.fFo.getTag() instanceof Animator)) {
            ((Animator) this.fFo.getTag()).cancel();
        }
    }
}
