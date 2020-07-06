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
/* loaded from: classes3.dex */
public class RedPacketCharmView extends RelativeLayout {
    private HeadImageView aIh;
    private View fAc;
    private TextView fAd;
    private View fAe;
    private TextView fAf;
    private ImageView fAg;
    private TextView fAh;
    private String mAvatar;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void qw(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    this.aIh.setVisibility(0);
                    this.fAe.setVisibility(8);
                    this.fAh.setVisibility(0);
                    bwb();
                    return;
                case 2:
                    this.aIh.setVisibility(8);
                    this.fAe.setVisibility(0);
                    this.fAf.setVisibility(0);
                    this.fAg.setVisibility(8);
                    this.fAh.setVisibility(4);
                    bwb();
                    return;
                case 3:
                    this.aIh.setVisibility(8);
                    this.fAe.setVisibility(0);
                    this.fAf.setVisibility(8);
                    this.fAg.setVisibility(0);
                    this.fAh.setVisibility(4);
                    bwa();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.fAc.setVisibility(0);
            if (TextUtils.isEmpty(this.fAd.getText()) || !this.fAd.getText().equals(str)) {
                this.fAd.setText(str);
                Drawable background = this.fAc.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.fAc.setBackgroundDrawable(background);
                }
                Drawable background2 = this.fAd.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.fAd.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.fAc.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.aIh.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.fAf.setText(str);
        this.fAh.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        bwb();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.red_packet_widget_charm, (ViewGroup) this, true);
        this.fAc = findViewById(a.g.layout_badge);
        this.fAd = (TextView) findViewById(a.g.tv_badge);
        this.aIh = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fAe = findViewById(a.g.layout_action);
        this.fAf = (TextView) findViewById(a.g.tv_countdown_action);
        this.fAg = (ImageView) findViewById(a.g.iv_process);
        this.fAh = (TextView) findViewById(a.g.tv_countdown_format);
        this.aIh.setIsRound(true);
        this.aIh.setAutoChangeStyle(false);
        this.aIh.setBorderColor(-4981);
        this.aIh.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aIh.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bwa() {
        if (this.fAe != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fAe, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fAe, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.fAe.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bwb() {
        if (this.fAe != null && (this.fAe.getTag() instanceof Animator)) {
            ((Animator) this.fAe.getTag()).cancel();
        }
    }
}
