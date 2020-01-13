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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.utils.p;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.e;
/* loaded from: classes2.dex */
public class b extends f implements e {
    private CommonWebLayout aBY;
    private View aBZ;
    private RoundRectRelativeLayout eqK;
    private float eqL;
    private int eqM;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout bbq() {
        return this.aBY;
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bbw()) {
            bbr();
        }
    }

    public void as(String str, int i) {
        View findViewById;
        int bbu;
        int bbv;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.eqM = 80;
                    bbu = bbs();
                    bbv = (int) Math.min(ScreenHelper.getRealScreenHeight(this.mActivity) * 0.64f, this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
                    this.eqK.setCornerRadius(this.eqL, this.eqL, 0.0f, 0.0f);
                    break;
                case 1:
                    this.eqM = 80;
                    bbu = bbs();
                    bbv = bfC();
                    this.eqK.setCornerRadius(this.eqL, this.eqL, 0.0f, 0.0f);
                    break;
                case 2:
                    this.eqM = 5;
                    bbu = bbu();
                    bbv = bbv();
                    this.eqK.setCornerRadius(this.eqL, 0.0f, 0.0f, this.eqL);
                    break;
                default:
                    bbv = 0;
                    bbu = 0;
                    break;
            }
            setWidth(bbu);
            setHeight(bbv);
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                U(this.eqK);
            }
            vI();
            this.aBY.loadUrl(str);
        }
    }

    public void bN(int i) {
        int bbu;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.eqM = 80;
                    bbu = bbs();
                    i2 = bfC();
                    this.eqK.setCornerRadius(this.eqL, this.eqL, 0.0f, 0.0f);
                    break;
                case 2:
                    this.eqM = 5;
                    bbu = bbu();
                    i2 = bbv();
                    this.eqK.setCornerRadius(this.eqL, 0.0f, 0.0f, this.eqL);
                    break;
                default:
                    bbu = 0;
                    break;
            }
            update(bbu, i2);
            if (i == 2) {
                U(this.eqK);
            }
        }
    }

    public void bbr() {
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
                if (b.this.aBY != null) {
                    b.this.aBY.release();
                }
            }
        });
    }

    private void initView() {
        this.eqL = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.eqK = new RoundRectRelativeLayout(this.mActivity);
        o(this.eqK);
        P(this.eqK);
        setContentView(this.eqK);
    }

    private void o(ViewGroup viewGroup) {
        this.aBY = new CommonWebLayout(this.mActivity);
        this.aBY.setBackgroundColor(this.mActivity.getResources().getColor(a.d.sdk_black_alpha85));
        this.aBY.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dW(String str) {
                super.dW(str);
                if (b.this.aBZ != null) {
                    b.this.aBZ.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cH(int i) {
                super.cH(i);
                if (i == 100 && b.this.aBZ != null) {
                    b.this.aBZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dX(String str) {
                super.dX(str);
                if (b.this.aBZ != null) {
                    b.this.aBZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void b(String str, int i, String str2) {
                super.b(str, i, str2);
                if (b.this.aBZ != null) {
                    b.this.aBZ.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.aBY, new ViewGroup.LayoutParams(-1, -1));
    }

    private void P(ViewGroup viewGroup) {
        this.aBZ = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.aBZ, layoutParams);
        this.aBZ.setVisibility(8);
    }

    private int bbs() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int bbu() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bfC() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - p.w(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.e.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int bbv() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void vI() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.eqM) {
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

    private boolean bbw() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.eqM) {
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
                    b.this.bbr();
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
    public void cI(int i) {
        dismiss();
        if (this.aBY != null) {
            this.aBY.release();
        }
    }

    private void U(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
