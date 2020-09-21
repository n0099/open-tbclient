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
    private HeadImageView aBc;
    private a fTP;
    private LottieAnimationView fTQ;
    private ImageView fTR;
    private View fTS;
    private TextView fTT;
    private View fTU;
    private TextView fTV;
    private ImageView fTW;
    private TextView fTX;
    private String mAvatar;
    private int mStyle;

    /* loaded from: classes4.dex */
    interface a {
        void tp(int i);
    }

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.fTP = aVar;
    }

    public int getStyle() {
        return this.mStyle;
    }

    public void tq(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            bJz();
            bJB();
            switch (i) {
                case 1:
                    this.fTR.setImageResource(a.f.icon_redpacket_charm_body_02);
                    this.aBc.setVisibility(0);
                    this.fTU.setVisibility(8);
                    this.fTX.setVisibility(0);
                    break;
                case 2:
                    this.fTR.setImageResource(a.f.icon_redpacket_charm_body_02);
                    bJx();
                    break;
                case 3:
                    this.fTR.setImageResource(a.f.icon_redpacket_charm_body_01);
                    bJx();
                    bJy();
                    break;
                case 4:
                    this.fTR.setImageResource(a.f.icon_redpacket_charm_body_01);
                    this.aBc.setVisibility(8);
                    this.fTU.setVisibility(0);
                    this.fTV.setVisibility(8);
                    this.fTW.setVisibility(0);
                    this.fTX.setVisibility(4);
                    bJy();
                    bJA();
                    break;
            }
            if (this.fTP != null) {
                this.fTP.tp(this.mStyle);
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.fTS.setVisibility(0);
            if (TextUtils.isEmpty(this.fTT.getText()) || !this.fTT.getText().equals(str)) {
                this.fTT.setText(str);
                Drawable background = this.fTS.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.fTS.setBackgroundDrawable(background);
                }
                Drawable background2 = this.fTT.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.fTT.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.fTS.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.mAvatar) || !this.mAvatar.equals(str)) {
            this.mAvatar = str;
            this.aBc.startLoad(this.mAvatar, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.fTV.setText(str);
        this.fTX.setText(str2);
    }

    public void release() {
        this.mAvatar = "";
        bJz();
        bJB();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.red_packet_widget_charm, (ViewGroup) this, true);
        this.fTQ = (LottieAnimationView) findViewById(a.g.lottie_redpacket_charm);
        this.fTR = (ImageView) findViewById(a.g.iv_redpacket_charm_body);
        this.fTS = findViewById(a.g.layout_badge);
        this.fTT = (TextView) findViewById(a.g.tv_badge);
        this.aBc = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fTU = findViewById(a.g.layout_action);
        this.fTV = (TextView) findViewById(a.g.tv_countdown_action);
        this.fTW = (ImageView) findViewById(a.g.iv_process);
        this.fTX = (TextView) findViewById(a.g.tv_countdown_format);
        this.fTQ.loop(true);
        this.fTQ.setAnimation("sdk_redpacket_charm_coin.json");
        this.aBc.setIsRound(true);
        this.aBc.setAutoChangeStyle(false);
        this.aBc.setBorderColor(-4981);
        this.aBc.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aBc.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bJx() {
        this.aBc.setVisibility(8);
        this.fTU.setVisibility(0);
        this.fTV.setVisibility(0);
        this.fTW.setVisibility(8);
        this.fTX.setVisibility(4);
    }

    private void bJy() {
        if (this.fTQ != null) {
            this.fTQ.setVisibility(0);
            this.fTQ.playAnimation();
        }
    }

    private void bJz() {
        if (this.fTQ != null) {
            this.fTQ.cancelAnimation();
            this.fTQ.setVisibility(4);
        }
    }

    private void bJA() {
        if (this.fTU != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fTU, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fTU, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.fTU.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bJB() {
        if (this.fTU != null && (this.fTU.getTag() instanceof Animator)) {
            ((Animator) this.fTU.getTag()).cancel();
        }
    }
}
