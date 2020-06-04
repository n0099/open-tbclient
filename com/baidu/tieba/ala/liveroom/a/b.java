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
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.u.a;
import com.baidu.live.utils.p;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes3.dex */
public class b extends f implements com.baidu.live.view.web.f {
    private CommonWebLayout bjK;
    private View bjL;
    private boolean fIq;
    private RoundRectRelativeLayout fma;
    private float fmb;
    private int fmc;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout bsc() {
        return this.bjK;
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bsi()) {
            bsd();
        }
    }

    public void aB(String str, int i) {
        View findViewById;
        int bsg;
        int bsh;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.fmc = 80;
                    bsg = bse();
                    bsh = (int) Math.min(ScreenHelper.getRealScreenHeight(this.mActivity) * 0.64f, this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
                    this.fma.setCornerRadius(this.fmb, this.fmb, 0.0f, 0.0f);
                    break;
                case 1:
                    this.fmc = 80;
                    bsg = bse();
                    bsh = bxf();
                    this.fma.setCornerRadius(this.fmb, this.fmb, 0.0f, 0.0f);
                    break;
                case 2:
                    this.fmc = 5;
                    bsg = bsg();
                    bsh = bsh();
                    this.fma.setCornerRadius(this.fmb, 0.0f, 0.0f, this.fmb);
                    break;
                default:
                    bsh = 0;
                    bsg = 0;
                    break;
            }
            setWidth(bsg);
            setHeight(bsh);
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                V(this.fma);
            }
            DX();
            this.bjK.loadUrl(str);
        }
    }

    public void cu(int i) {
        int bsg;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.fmc = 80;
                    bsg = bse();
                    i2 = bxf();
                    this.fma.setCornerRadius(this.fmb, this.fmb, 0.0f, 0.0f);
                    break;
                case 2:
                    this.fmc = 5;
                    bsg = bsg();
                    i2 = bsh();
                    this.fma.setCornerRadius(this.fmb, 0.0f, 0.0f, this.fmb);
                    break;
                default:
                    bsg = 0;
                    break;
            }
            update(bsg, i2);
            if (i == 2) {
                V(this.fma);
            }
        }
    }

    public void bsd() {
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
                if (b.this.bjK != null) {
                    b.this.bjK.release();
                }
            }
        });
    }

    private void initView() {
        this.fmb = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.fma = new RoundRectRelativeLayout(this.mActivity);
        u(this.fma);
        W(this.fma);
        setContentView(this.fma);
    }

    private void u(ViewGroup viewGroup) {
        this.bjK = new CommonWebLayout(this.mActivity);
        this.bjK.setBackgroundColor(this.mActivity.getResources().getColor(a.d.sdk_black_alpha85));
        this.bjK.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fP(String str) {
                super.fP(str);
                if (b.this.bjL != null) {
                    b.this.bjL.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dt(int i) {
                super.dt(i);
                if (i == 100 && b.this.bjL != null) {
                    b.this.bjL.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fQ(String str) {
                super.fQ(str);
                if (b.this.bjL != null) {
                    b.this.bjL.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (b.this.bjL != null) {
                    b.this.bjL.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bjK, new ViewGroup.LayoutParams(-1, -1));
    }

    private void W(ViewGroup viewGroup) {
        this.bjL = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bjL, layoutParams);
        this.bjL.setVisibility(8);
    }

    private int bse() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int bsg() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bxf() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - p.t(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.e.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int bsh() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void DX() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.fmc) {
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

    private boolean bsi() {
        if (getContentView() == null) {
            return false;
        }
        if (this.fIq) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.fmc) {
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
                    b.this.bsd();
                    b.this.fIq = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.fIq = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void dv(int i) {
        dismiss();
        if (this.bjK != null) {
            this.bjK.release();
        }
    }

    private void V(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
