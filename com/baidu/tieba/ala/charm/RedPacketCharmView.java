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
/* loaded from: classes10.dex */
public class RedPacketCharmView extends RelativeLayout {
    private HeadImageView aBE;
    private View bbq;
    private String eMY;
    private View gLA;
    private TextView gLB;
    private TextView gLC;
    private ImageView gLD;
    private TextView gLE;
    private a gLx;
    private LottieAnimationView gLy;
    private ImageView gLz;
    private int mStyle;

    /* loaded from: classes10.dex */
    interface a {
        void ua(int i);
    }

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.gLx = aVar;
    }

    public int getStyle() {
        return this.mStyle;
    }

    public void ub(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            bTc();
            bTe();
            switch (i) {
                case 1:
                    this.gLz.setImageResource(a.e.icon_redpacket_charm_body_02);
                    this.aBE.setVisibility(0);
                    this.bbq.setVisibility(8);
                    this.gLE.setVisibility(0);
                    break;
                case 2:
                    this.gLz.setImageResource(a.e.icon_redpacket_charm_body_02);
                    bTa();
                    break;
                case 3:
                    this.gLz.setImageResource(a.e.icon_redpacket_charm_body_01);
                    bTa();
                    bTb();
                    break;
                case 4:
                    this.gLz.setImageResource(a.e.icon_redpacket_charm_body_01);
                    this.aBE.setVisibility(8);
                    this.bbq.setVisibility(0);
                    this.gLC.setVisibility(8);
                    this.gLD.setVisibility(0);
                    this.gLE.setVisibility(4);
                    bTb();
                    bTd();
                    break;
            }
            if (this.gLx != null) {
                this.gLx.ua(this.mStyle);
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.gLA.setVisibility(0);
            if (TextUtils.isEmpty(this.gLB.getText()) || !this.gLB.getText().equals(str)) {
                this.gLB.setText(str);
                Drawable background = this.gLA.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.gLA.setBackgroundDrawable(background);
                }
                Drawable background2 = this.gLB.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.gLB.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.gLA.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.eMY) || !this.eMY.equals(str)) {
            this.eMY = str;
            this.aBE.startLoad(this.eMY, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.gLC.setText(str);
        this.gLE.setText(str2);
    }

    public void release() {
        this.eMY = "";
        bTc();
        bTe();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.red_packet_widget_charm, (ViewGroup) this, true);
        this.gLy = (LottieAnimationView) findViewById(a.f.lottie_redpacket_charm);
        this.gLz = (ImageView) findViewById(a.f.iv_redpacket_charm_body);
        this.gLA = findViewById(a.f.layout_badge);
        this.gLB = (TextView) findViewById(a.f.tv_badge);
        this.aBE = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bbq = findViewById(a.f.layout_action);
        this.gLC = (TextView) findViewById(a.f.tv_countdown_action);
        this.gLD = (ImageView) findViewById(a.f.iv_process);
        this.gLE = (TextView) findViewById(a.f.tv_countdown_format);
        this.gLy.loop(true);
        this.gLy.setAnimation("sdk_redpacket_charm_coin.json");
        this.aBE.setIsRound(true);
        this.aBE.setAutoChangeStyle(false);
        this.aBE.setBorderColor(-4981);
        this.aBE.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aBE.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bTa() {
        this.aBE.setVisibility(8);
        this.bbq.setVisibility(0);
        this.gLC.setVisibility(0);
        this.gLD.setVisibility(8);
        this.gLE.setVisibility(4);
    }

    private void bTb() {
        if (this.gLy != null) {
            this.gLy.setVisibility(0);
            this.gLy.playAnimation();
        }
    }

    private void bTc() {
        if (this.gLy != null) {
            this.gLy.cancelAnimation();
            this.gLy.setVisibility(4);
        }
    }

    private void bTd() {
        if (this.bbq != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bbq, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bbq, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.bbq.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bTe() {
        if (this.bbq != null && (this.bbq.getTag() instanceof Animator)) {
            ((Animator) this.bbq.getTag()).cancel();
        }
    }
}
