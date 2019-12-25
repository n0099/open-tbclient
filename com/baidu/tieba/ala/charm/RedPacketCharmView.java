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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class RedPacketCharmView extends RelativeLayout {
    private HeadImageView aeR;
    private View eqO;
    private TextView eqP;
    private View eqQ;
    private TextView eqR;
    private ImageView eqS;
    private TextView eqT;
    private String eqU;
    private int mStyle;

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void oF(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    this.aeR.setVisibility(0);
                    this.eqQ.setVisibility(8);
                    this.eqT.setVisibility(0);
                    bbk();
                    return;
                case 2:
                    this.aeR.setVisibility(8);
                    this.eqQ.setVisibility(0);
                    this.eqR.setVisibility(0);
                    this.eqS.setVisibility(8);
                    this.eqT.setVisibility(4);
                    bbk();
                    return;
                case 3:
                    this.aeR.setVisibility(8);
                    this.eqQ.setVisibility(0);
                    this.eqR.setVisibility(8);
                    this.eqS.setVisibility(0);
                    this.eqT.setVisibility(4);
                    bbj();
                    return;
                default:
                    return;
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.eqO.setVisibility(0);
            if (TextUtils.isEmpty(this.eqP.getText()) || !this.eqP.getText().equals(str)) {
                this.eqP.setText(str);
                Drawable background = this.eqO.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.eqO.setBackgroundDrawable(background);
                }
                Drawable background2 = this.eqP.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.eqP.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.eqO.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.eqU) || !this.eqU.equals(str)) {
            this.eqU = str;
            this.aeR.startLoad(this.eqU, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.eqR.setText(str);
        this.eqT.setText(str2);
    }

    public void release() {
        this.eqU = "";
        bbk();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.red_packet_widget_charm, (ViewGroup) this, true);
        this.eqO = findViewById(a.g.layout_badge);
        this.eqP = (TextView) findViewById(a.g.tv_badge);
        this.aeR = (HeadImageView) findViewById(a.g.iv_avatar);
        this.eqQ = findViewById(a.g.layout_action);
        this.eqR = (TextView) findViewById(a.g.tv_countdown_action);
        this.eqS = (ImageView) findViewById(a.g.iv_process);
        this.eqT = (TextView) findViewById(a.g.tv_countdown_format);
        this.aeR.setIsRound(true);
        this.aeR.setAutoChangeStyle(false);
        this.aeR.setBorderColor(-4981);
        this.aeR.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aeR.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bbj() {
        if (this.eqQ != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eqQ, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eqQ, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.eqQ.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bbk() {
        if (this.eqQ != null && (this.eqQ.getTag() instanceof Animator)) {
            ((Animator) this.eqQ.getTag()).cancel();
        }
    }
}
