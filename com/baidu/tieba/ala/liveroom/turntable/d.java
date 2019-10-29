package com.baidu.tieba.ala.liveroom.turntable;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes6.dex */
public class d extends PopupWindow implements com.baidu.live.view.web.e {
    private CommonWebLayout atE;
    private View atF;
    private RoundRectRelativeLayout dVb;
    private float dVc;
    private int dVd;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout aNE() {
        return this.atE;
    }

    public void tD(String str) {
        View findViewById;
        int aNH;
        int aNJ;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.dVd = 80;
                    aNH = aNG();
                    aNJ = aWh();
                    this.dVb.setCornerRadius(this.dVc, this.dVc, 0.0f, 0.0f);
                    break;
                case 2:
                    this.dVd = 5;
                    aNH = aNH();
                    aNJ = aNJ();
                    this.dVb.setCornerRadius(this.dVc, 0.0f, 0.0f, this.dVc);
                    break;
                default:
                    this.dVd = 80;
                    aNH = aNG();
                    aNJ = aWh();
                    this.dVb.setCornerRadius(this.dVc, this.dVc, 0.0f, 0.0f);
                    break;
            }
            setWidth(aNH);
            setHeight(aNJ);
            showAtLocation(findViewById, 85, 0, 0);
            tw();
            this.atE.loadUrl(str);
        }
    }

    public void bw(int i) {
        int aNJ;
        int i2 = 0;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.dVd = 80;
                    i2 = aNG();
                    aNJ = aWh();
                    this.dVb.setCornerRadius(this.dVc, this.dVc, 0.0f, 0.0f);
                    break;
                case 2:
                    this.dVd = 5;
                    i2 = aNH();
                    aNJ = aNJ();
                    this.dVb.setCornerRadius(this.dVc, 0.0f, 0.0f, this.dVc);
                    break;
                default:
                    aNJ = 0;
                    break;
            }
            update(i2, aNJ);
        }
    }

    public void aNF() {
        super.dismiss();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (!aNK()) {
            aNF();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.turntable.d.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (d.this.atE != null) {
                    d.this.atE.release();
                }
            }
        });
    }

    private void initView() {
        this.dVc = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.dVb = new RoundRectRelativeLayout(this.mContext);
        aa(this.dVb);
        ab(this.dVb);
        setContentView(this.dVb);
    }

    private void aa(ViewGroup viewGroup) {
        this.atE = new CommonWebLayout(this.mContext);
        this.atE.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.atE.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.turntable.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void da(String str) {
                super.da(str);
                if (d.this.atF != null) {
                    d.this.atF.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cr(int i) {
                super.cr(i);
                if (i == 100 && d.this.atF != null) {
                    d.this.atF.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void db(String str) {
                super.db(str);
                if (d.this.atF != null) {
                    d.this.atF.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void b(String str, int i, String str2) {
                super.b(str, i, str2);
                if (d.this.atF != null) {
                    d.this.atF.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.atE, new ViewGroup.LayoutParams(-1, -1));
    }

    private void ab(ViewGroup viewGroup) {
        this.atF = LayoutInflater.from(this.mContext).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.atF, layoutParams);
        this.atF.setVisibility(8);
    }

    private int aNG() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int aWh() {
        return (aNG() * 470) / 375;
    }

    private int aNH() {
        return (aNJ() * 375) / 470;
    }

    private int aNJ() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void tw() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.dVd) {
                case 5:
                    translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                    break;
                case 80:
                    translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                    break;
            }
            if (translateAnimation != null) {
                translateAnimation.setDuration(250L);
                translateAnimation.setInterpolator(new LinearInterpolator());
                getContentView().startAnimation(translateAnimation);
            }
        }
    }

    private boolean aNK() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.dVd) {
            case 5:
                translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
                break;
            case 80:
                translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
                break;
        }
        if (translateAnimation != null) {
            translateAnimation.setDuration(250L);
            translateAnimation.setInterpolator(new LinearInterpolator());
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.turntable.d.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    d.this.aNF();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.e
    public void cs(int i) {
        dismiss();
    }
}
