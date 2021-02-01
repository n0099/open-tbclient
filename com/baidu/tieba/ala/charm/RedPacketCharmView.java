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
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes11.dex */
public class RedPacketCharmView extends RelativeLayout {
    private HeadImageView aDr;
    private View bex;
    private String ePk;
    private a gOd;
    private LottieAnimationView gOe;
    private ImageView gOf;
    private View gOg;
    private TextView gOh;
    private TextView gOi;
    private ImageView gOj;
    private TextView gOk;
    private int mStyle;

    /* loaded from: classes11.dex */
    interface a {
        void ug(int i);
    }

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.gOd = aVar;
    }

    public int getStyle() {
        return this.mStyle;
    }

    public void uh(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            bTF();
            bTH();
            switch (i) {
                case 1:
                    this.gOf.setImageResource(a.e.icon_redpacket_charm_body_02);
                    this.aDr.setVisibility(0);
                    this.bex.setVisibility(8);
                    this.gOk.setVisibility(0);
                    break;
                case 2:
                    this.gOf.setImageResource(a.e.icon_redpacket_charm_body_02);
                    bTD();
                    break;
                case 3:
                    this.gOf.setImageResource(a.e.icon_redpacket_charm_body_01);
                    bTD();
                    bTE();
                    break;
                case 4:
                    this.gOf.setImageResource(a.e.icon_redpacket_charm_body_01);
                    this.aDr.setVisibility(8);
                    this.bex.setVisibility(0);
                    this.gOi.setVisibility(8);
                    this.gOj.setVisibility(0);
                    this.gOk.setVisibility(4);
                    bTE();
                    bTG();
                    break;
            }
            if (this.gOd != null) {
                this.gOd.ug(this.mStyle);
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.gOg.setVisibility(0);
            if (TextUtils.isEmpty(this.gOh.getText()) || !this.gOh.getText().equals(str)) {
                this.gOh.setText(str);
                Drawable background = this.gOg.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.gOg.setBackgroundDrawable(background);
                }
                Drawable background2 = this.gOh.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.gOh.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.gOg.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.ePk) || !this.ePk.equals(str)) {
            this.ePk = str;
            this.aDr.startLoad(this.ePk, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.gOi.setText(str);
        this.gOk.setText(str2);
    }

    public void release() {
        this.ePk = "";
        bTF();
        bTH();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.red_packet_widget_charm, (ViewGroup) this, true);
        this.gOe = (LottieAnimationView) findViewById(a.f.lottie_redpacket_charm);
        this.gOf = (ImageView) findViewById(a.f.iv_redpacket_charm_body);
        this.gOg = findViewById(a.f.layout_badge);
        this.gOh = (TextView) findViewById(a.f.tv_badge);
        this.aDr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bex = findViewById(a.f.layout_action);
        this.gOi = (TextView) findViewById(a.f.tv_countdown_action);
        this.gOj = (ImageView) findViewById(a.f.iv_process);
        this.gOk = (TextView) findViewById(a.f.tv_countdown_format);
        this.gOe.loop(true);
        this.gOe.setAnimation("sdk_redpacket_charm_coin.json");
        this.aDr.setIsRound(true);
        this.aDr.setAutoChangeStyle(false);
        this.aDr.setBorderColor(-4981);
        this.aDr.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aDr.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bTD() {
        this.aDr.setVisibility(8);
        this.bex.setVisibility(0);
        this.gOi.setVisibility(0);
        this.gOj.setVisibility(8);
        this.gOk.setVisibility(4);
    }

    private void bTE() {
        if (this.gOe != null) {
            this.gOe.setVisibility(0);
            this.gOe.playAnimation();
        }
    }

    private void bTF() {
        if (this.gOe != null) {
            this.gOe.cancelAnimation();
            this.gOe.setVisibility(4);
        }
    }

    private void bTG() {
        if (this.bex != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bex, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bex, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.bex.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bTH() {
        if (this.bex != null && (this.bex.getTag() instanceof Animator)) {
            ((Animator) this.bex.getTag()).cancel();
        }
    }
}
