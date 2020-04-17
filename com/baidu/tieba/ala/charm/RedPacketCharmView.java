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
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class RedPacketCharmView extends RelativeLayout {
    private HeadImageView aAm;
    private View faY;
    private TextView faZ;
    private View fba;
    private TextView fbb;
    private ImageView fbc;
    private TextView fbd;
    private String mAvatar;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void pu(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    this.aAm.setVisibility(0);
                    this.fba.setVisibility(8);
                    this.fbd.setVisibility(0);
                    bno();
                    return;
                case 2:
                    this.aAm.setVisibility(8);
                    this.fba.setVisibility(0);
                    this.fbb.setVisibility(0);
                    this.fbc.setVisibility(8);
                    this.fbd.setVisibility(4);
                    bno();
                    return;
                case 3:
                    this.aAm.setVisibility(8);
                    this.fba.setVisibility(0);
                    this.fbb.setVisibility(8);
                    this.fbc.setVisibility(0);
                    this.fbd.setVisibility(4);
                    bnn();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.faY.setVisibility(0);
            if (TextUtils.isEmpty(this.faZ.getText()) || !this.faZ.getText().equals(str)) {
                this.faZ.setText(str);
                Drawable background = this.faY.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.faY.setBackgroundDrawable(background);
                }
                Drawable background2 = this.faZ.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.faZ.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.faY.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.aAm.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.fbb.setText(str);
        this.fbd.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        bno();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.red_packet_widget_charm, (ViewGroup) this, true);
        this.faY = findViewById(a.g.layout_badge);
        this.faZ = (TextView) findViewById(a.g.tv_badge);
        this.aAm = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fba = findViewById(a.g.layout_action);
        this.fbb = (TextView) findViewById(a.g.tv_countdown_action);
        this.fbc = (ImageView) findViewById(a.g.iv_process);
        this.fbd = (TextView) findViewById(a.g.tv_countdown_format);
        this.aAm.setIsRound(true);
        this.aAm.setAutoChangeStyle(false);
        this.aAm.setBorderColor(-4981);
        this.aAm.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aAm.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bnn() {
        if (this.fba != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fba, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fba, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.fba.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bno() {
        if (this.fba != null && (this.fba.getTag() instanceof Animator)) {
            ((Animator) this.fba.getTag()).cancel();
        }
    }
}
