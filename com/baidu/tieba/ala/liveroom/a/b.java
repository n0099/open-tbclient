package com.baidu.tieba.ala.liveroom.a;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.o;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes7.dex */
public class b extends f implements com.baidu.live.view.web.f {
    private float bjp;
    private CommonWebLayout buV;
    private View buW;
    private RoundRectRelativeLayout fNM;
    private int fNN;
    private boolean gkP;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout bHh() {
        return this.buV;
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bHn()) {
            bHi();
        }
    }

    public void aD(String str, int i) {
        View findViewById;
        int bHl;
        int bHm;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.fNN = 80;
                    bHl = bHj();
                    bHm = (int) Math.min(ScreenHelper.getRealScreenHeight(this.mActivity) * 0.64f, this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
                    this.fNM.setCornerRadius(this.bjp, this.bjp, 0.0f, 0.0f);
                    break;
                case 1:
                    this.fNN = 80;
                    bHl = bHj();
                    bHm = bMI();
                    this.fNM.setCornerRadius(this.bjp, this.bjp, 0.0f, 0.0f);
                    break;
                case 2:
                    this.fNN = 5;
                    bHl = bHl();
                    bHm = bHm();
                    this.fNM.setCornerRadius(this.bjp, 0.0f, 0.0f, this.bjp);
                    break;
                default:
                    bHm = 0;
                    bHl = 0;
                    break;
            }
            setWidth(bHl);
            setHeight(bHm);
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                aa((View) this.fNM);
            }
            Kl();
            this.buV.loadUrl(str);
        }
    }

    public void dz(int i) {
        int bHl;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.fNN = 80;
                    bHl = bHj();
                    i2 = bMI();
                    this.fNM.setCornerRadius(this.bjp, this.bjp, 0.0f, 0.0f);
                    break;
                case 2:
                    this.fNN = 5;
                    bHl = bHl();
                    i2 = bHm();
                    this.fNM.setCornerRadius(this.bjp, 0.0f, 0.0f, this.bjp);
                    break;
                default:
                    bHl = 0;
                    break;
            }
            update(bHl, i2);
            if (i == 2) {
                aa((View) this.fNM);
            }
        }
    }

    public void bHi() {
        super.dismiss();
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.a.b.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (b.this.buV != null) {
                    b.this.buV.release();
                }
            }
        });
    }

    private void initView() {
        this.bjp = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.fNM = new RoundRectRelativeLayout(this.mActivity);
        y(this.fNM);
        aa((ViewGroup) this.fNM);
        setContentView(this.fNM);
    }

    private void y(ViewGroup viewGroup) {
        this.buV = new CommonWebLayout(this.mActivity);
        this.buV.setBackgroundColor(this.mActivity.getResources().getColor(a.d.sdk_black_alpha85));
        this.buV.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hr(String str) {
                super.hr(str);
                if (b.this.buW != null) {
                    b.this.buW.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fy(int i) {
                super.fy(i);
                if (i == 100 && b.this.buW != null) {
                    b.this.buW.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hs(String str) {
                super.hs(str);
                if (b.this.buW != null) {
                    b.this.buW.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (b.this.buW != null) {
                    b.this.buW.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.buV, new ViewGroup.LayoutParams(-1, -1));
    }

    private void aa(ViewGroup viewGroup) {
        this.buW = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.buW, layoutParams);
        this.buW.setVisibility(8);
    }

    private int bHj() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int bHl() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bMI() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - o.u(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.e.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int bHm() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void Kl() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.fNN) {
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

    private boolean bHn() {
        if (getContentView() == null) {
            return false;
        }
        if (this.gkP) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.fNN) {
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.a.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.bHi();
                    b.this.gkP = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.gkP = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void fA(int i) {
        dismiss();
        if (this.buV != null) {
            this.buV.release();
        }
    }

    private void aa(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
