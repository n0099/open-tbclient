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
    private HeadImageView aER;
    private View bfZ;
    private String eQL;
    private a gQa;
    private LottieAnimationView gQb;
    private ImageView gQc;
    private View gQd;
    private TextView gQe;
    private TextView gQf;
    private ImageView gQg;
    private TextView gQh;
    private int mStyle;

    /* loaded from: classes10.dex */
    interface a {
        void ui(int i);
    }

    public RedPacketCharmView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.gQa = aVar;
    }

    public int getStyle() {
        return this.mStyle;
    }

    public void uj(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            bTS();
            bTU();
            switch (i) {
                case 1:
                    this.gQc.setImageResource(a.e.icon_redpacket_charm_body_02);
                    this.aER.setVisibility(0);
                    this.bfZ.setVisibility(8);
                    this.gQh.setVisibility(0);
                    break;
                case 2:
                    this.gQc.setImageResource(a.e.icon_redpacket_charm_body_02);
                    bTQ();
                    break;
                case 3:
                    this.gQc.setImageResource(a.e.icon_redpacket_charm_body_01);
                    bTQ();
                    bTR();
                    break;
                case 4:
                    this.gQc.setImageResource(a.e.icon_redpacket_charm_body_01);
                    this.aER.setVisibility(8);
                    this.bfZ.setVisibility(0);
                    this.gQf.setVisibility(8);
                    this.gQg.setVisibility(0);
                    this.gQh.setVisibility(4);
                    bTR();
                    bTT();
                    break;
            }
            if (this.gQa != null) {
                this.gQa.ui(this.mStyle);
            }
        }
    }

    public void setBadge(boolean z, String str) {
        if (z) {
            this.gQd.setVisibility(0);
            if (TextUtils.isEmpty(this.gQe.getText()) || !this.gQe.getText().equals(str)) {
                this.gQe.setText(str);
                Drawable background = this.gQd.getBackground();
                if (background instanceof GradientDrawable) {
                    ((GradientDrawable) background).setShape(str.length() == 1 ? 1 : 0);
                    this.gQd.setBackgroundDrawable(background);
                }
                Drawable background2 = this.gQe.getBackground();
                if (background2 instanceof GradientDrawable) {
                    ((GradientDrawable) background2).setShape(str.length() != 1 ? 0 : 1);
                    this.gQe.setBackgroundDrawable(background2);
                    return;
                }
                return;
            }
            return;
        }
        this.gQd.setVisibility(8);
    }

    public void setAvatar(String str) {
        if (TextUtils.isEmpty(this.eQL) || !this.eQL.equals(str)) {
            this.eQL = str;
            this.aER.startLoad(this.eQL, 12, false, false);
        }
    }

    public void setCountDownTimer(String str, String str2) {
        this.gQf.setText(str);
        this.gQh.setText(str2);
    }

    public void release() {
        this.eQL = "";
        bTS();
        bTU();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.red_packet_widget_charm, (ViewGroup) this, true);
        this.gQb = (LottieAnimationView) findViewById(a.f.lottie_redpacket_charm);
        this.gQc = (ImageView) findViewById(a.f.iv_redpacket_charm_body);
        this.gQd = findViewById(a.f.layout_badge);
        this.gQe = (TextView) findViewById(a.f.tv_badge);
        this.aER = (HeadImageView) findViewById(a.f.iv_avatar);
        this.bfZ = findViewById(a.f.layout_action);
        this.gQf = (TextView) findViewById(a.f.tv_countdown_action);
        this.gQg = (ImageView) findViewById(a.f.iv_process);
        this.gQh = (TextView) findViewById(a.f.tv_countdown_format);
        this.gQb.loop(true);
        this.gQb.setAnimation("sdk_redpacket_charm_coin.json");
        this.aER.setIsRound(true);
        this.aER.setAutoChangeStyle(false);
        this.aER.setBorderColor(-4981);
        this.aER.setBorderWidth((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.aER.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void bTQ() {
        this.aER.setVisibility(8);
        this.bfZ.setVisibility(0);
        this.gQf.setVisibility(0);
        this.gQg.setVisibility(8);
        this.gQh.setVisibility(4);
    }

    private void bTR() {
        if (this.gQb != null) {
            this.gQb.setVisibility(0);
            this.gQb.playAnimation();
        }
    }

    private void bTS() {
        if (this.gQb != null) {
            this.gQb.cancelAnimation();
            this.gQb.setVisibility(4);
        }
    }

    private void bTT() {
        if (this.bfZ != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bfZ, "scaleX", 1.0f, 0.8f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bfZ, "scaleY", 1.0f, 0.8f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(ofFloat, ofFloat2);
            this.bfZ.setTag(animatorSet);
            animatorSet.start();
        }
    }

    private void bTU() {
        if (this.bfZ != null && (this.bfZ.getTag() instanceof Animator)) {
            ((Animator) this.bfZ.getTag()).cancel();
        }
    }
}
