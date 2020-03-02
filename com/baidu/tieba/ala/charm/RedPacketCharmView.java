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
    private HeadImageView ahI;
    private View ewm;
    private TextView ewn;
    private View ewo;
    private TextView ewp;
    private ImageView ewq;
    private TextView ewr;
    private String mAvatar;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void oX(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    this.ahI.setVisibility(0);
                    this.ewo.setVisibility(8);
                    this.ewr.setVisibility(0);
                    bdW();
                    return;
                case 2:
                    this.ahI.setVisibility(8);
                    this.ewo.setVisibility(0);
                    this.ewp.setVisibility(0);
                    this.ewq.setVisibility(8);
                    this.ewr.setVisibility(4);
                    bdW();
                    return;
                case 3:
                    this.ahI.setVisibility(8);
                    this.ewo.setVisibility(0);
                    this.ewp.setVisibility(8);
                    this.ewq.setVisibility(0);
                    this.ewr.setVisibility(4);
                    bdV();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.ewm.setVisibility(0);
            if (TextUtils.isEmpty(this.ewn.getText()) || !this.ewn.getText().equals(str)) {
                this.ewn.setText(str);
                Drawable background = this.ewm.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.ewm.setBackgroundDrawable(background);
                }
                Drawable background2 = this.ewn.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.ewn.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.ewm.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.ahI.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.ewp.setText(str);
        this.ewr.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        bdW();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.red_packet_widget_charm, (ViewGroup) this, true);
        this.ewm = findViewById(a.g.layout_badge);
        this.ewn = (TextView) findViewById(a.g.tv_badge);
        this.ahI = (HeadImageView) findViewById(a.g.iv_avatar);
        this.ewo = findViewById(a.g.layout_action);
        this.ewp = (TextView) findViewById(a.g.tv_countdown_action);
        this.ewq = (ImageView) findViewById(a.g.iv_process);
        this.ewr = (TextView) findViewById(a.g.tv_countdown_format);
        this.ahI.setIsRound(true);
        this.ahI.setAutoChangeStyle(false);
        this.ahI.setBorderColor(-4981);
        this.ahI.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.ahI.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bdV() {
        if (this.ewo != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ewo, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ewo, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.ewo.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bdW() {
        if (this.ewo != null && (this.ewo.getTag() instanceof Animator)) {
            ((Animator) this.ewo.getTag()).cancel();
        }
    }
}
