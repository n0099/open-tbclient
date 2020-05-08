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
    private HeadImageView aAs;
    private View fbd;
    private TextView fbe;
    private View fbf;
    private TextView fbg;
    private ImageView fbh;
    private TextView fbi;
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
                    this.aAs.setVisibility(0);
                    this.fbf.setVisibility(8);
                    this.fbi.setVisibility(0);
                    bnm();
                    return;
                case 2:
                    this.aAs.setVisibility(8);
                    this.fbf.setVisibility(0);
                    this.fbg.setVisibility(0);
                    this.fbh.setVisibility(8);
                    this.fbi.setVisibility(4);
                    bnm();
                    return;
                case 3:
                    this.aAs.setVisibility(8);
                    this.fbf.setVisibility(0);
                    this.fbg.setVisibility(8);
                    this.fbh.setVisibility(0);
                    this.fbi.setVisibility(4);
                    bnl();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.fbd.setVisibility(0);
            if (TextUtils.isEmpty(this.fbe.getText()) || !this.fbe.getText().equals(str)) {
                this.fbe.setText(str);
                Drawable background = this.fbd.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.fbd.setBackgroundDrawable(background);
                }
                Drawable background2 = this.fbe.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.fbe.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.fbd.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.aAs.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.fbg.setText(str);
        this.fbi.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        bnm();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.red_packet_widget_charm, (ViewGroup) this, true);
        this.fbd = findViewById(a.g.layout_badge);
        this.fbe = (TextView) findViewById(a.g.tv_badge);
        this.aAs = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fbf = findViewById(a.g.layout_action);
        this.fbg = (TextView) findViewById(a.g.tv_countdown_action);
        this.fbh = (ImageView) findViewById(a.g.iv_process);
        this.fbi = (TextView) findViewById(a.g.tv_countdown_format);
        this.aAs.setIsRound(true);
        this.aAs.setAutoChangeStyle(false);
        this.aAs.setBorderColor(-4981);
        this.aAs.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aAs.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bnl() {
        if (this.fbf != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fbf, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fbf, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.fbf.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bnm() {
        if (this.fbf != null && (this.fbf.getTag() instanceof Animator)) {
            ((Animator) this.fbf.getTag()).cancel();
        }
    }
}
