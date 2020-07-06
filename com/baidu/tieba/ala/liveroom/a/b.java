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
/* loaded from: classes3.dex */
public class b extends f implements com.baidu.live.view.web.f {
    private CommonWebLayout bdr;
    private View bds;
    private boolean fTy;
    private RoundRectRelativeLayout fxn;
    private float fxo;
    private int fxp;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout Hf() {
        return this.bdr;
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bve()) {
            buZ();
        }
    }

    public void aB(String str, int i) {
        View findViewById;
        int bvc;
        int bvd;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.fxp = 80;
                    bvc = bva();
                    bvd = (int) Math.min(ScreenHelper.getRealScreenHeight(this.mActivity) * 0.64f, this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
                    this.fxn.setCornerRadius(this.fxo, this.fxo, 0.0f, 0.0f);
                    break;
                case 1:
                    this.fxp = 80;
                    bvc = bva();
                    bvd = bAa();
                    this.fxn.setCornerRadius(this.fxo, this.fxo, 0.0f, 0.0f);
                    break;
                case 2:
                    this.fxp = 5;
                    bvc = bvc();
                    bvd = bvd();
                    this.fxn.setCornerRadius(this.fxo, 0.0f, 0.0f, this.fxo);
                    break;
                default:
                    bvd = 0;
                    bvc = 0;
                    break;
            }
            setWidth(bvc);
            setHeight(bvd);
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                W(this.fxn);
            }
            Ez();
            this.bdr.loadUrl(str);
        }
    }

    public void cA(int i) {
        int bvc;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.fxp = 80;
                    bvc = bva();
                    i2 = bAa();
                    this.fxn.setCornerRadius(this.fxo, this.fxo, 0.0f, 0.0f);
                    break;
                case 2:
                    this.fxp = 5;
                    bvc = bvc();
                    i2 = bvd();
                    this.fxn.setCornerRadius(this.fxo, 0.0f, 0.0f, this.fxo);
                    break;
                default:
                    bvc = 0;
                    break;
            }
            update(bvc, i2);
            if (i == 2) {
                W(this.fxn);
            }
        }
    }

    public void buZ() {
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
                if (b.this.bdr != null) {
                    b.this.bdr.release();
                }
            }
        });
    }

    private void initView() {
        this.fxo = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.fxn = new RoundRectRelativeLayout(this.mActivity);
        w(this.fxn);
        Y(this.fxn);
        setContentView(this.fxn);
    }

    private void w(ViewGroup viewGroup) {
        this.bdr = new CommonWebLayout(this.mActivity);
        this.bdr.setBackgroundColor(this.mActivity.getResources().getColor(a.d.sdk_black_alpha85));
        this.bdr.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fY(String str) {
                super.fY(str);
                if (b.this.bds != null) {
                    b.this.bds.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dE(int i) {
                super.dE(i);
                if (i == 100 && b.this.bds != null) {
                    b.this.bds.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fJ(String str) {
                super.fJ(str);
                if (b.this.bds != null) {
                    b.this.bds.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (b.this.bds != null) {
                    b.this.bds.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bdr, new ViewGroup.LayoutParams(-1, -1));
    }

    private void Y(ViewGroup viewGroup) {
        this.bds = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bds, layoutParams);
        this.bds.setVisibility(8);
    }

    private int bva() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int bvc() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bAa() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - o.t(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.e.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int bvd() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void Ez() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.fxp) {
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

    private boolean bve() {
        if (getContentView() == null) {
            return false;
        }
        if (this.fTy) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.fxp) {
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
                    b.this.buZ();
                    b.this.fTy = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.fTy = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void cM(int i) {
        dismiss();
        if (this.bdr != null) {
            this.bdr.release();
        }
    }

    private void W(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
