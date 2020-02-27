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
import com.baidu.live.view.web.e;
/* loaded from: classes3.dex */
public class b extends f implements e {
    private CommonWebLayout aGf;
    private View aGg;
    private boolean eOX;
    private RoundRectRelativeLayout euV;
    private float euW;
    private int euX;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout bdF() {
        return this.aGf;
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bdL()) {
            bdG();
        }
    }

    public void aq(String str, int i) {
        View findViewById;
        int bdJ;
        int bdK;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.euX = 80;
                    bdJ = bdH();
                    bdK = (int) Math.min(ScreenHelper.getRealScreenHeight(this.mActivity) * 0.64f, this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
                    this.euV.setCornerRadius(this.euW, this.euW, 0.0f, 0.0f);
                    break;
                case 1:
                    this.euX = 80;
                    bdJ = bdH();
                    bdK = bhL();
                    this.euV.setCornerRadius(this.euW, this.euW, 0.0f, 0.0f);
                    break;
                case 2:
                    this.euX = 5;
                    bdJ = bdJ();
                    bdK = bdK();
                    this.euV.setCornerRadius(this.euW, 0.0f, 0.0f, this.euW);
                    break;
                default:
                    bdK = 0;
                    bdJ = 0;
                    break;
            }
            setWidth(bdJ);
            setHeight(bdK);
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                U(this.euV);
            }
            xG();
            this.aGf.loadUrl(str);
        }
    }

    public void bW(int i) {
        int bdJ;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.euX = 80;
                    bdJ = bdH();
                    i2 = bhL();
                    this.euV.setCornerRadius(this.euW, this.euW, 0.0f, 0.0f);
                    break;
                case 2:
                    this.euX = 5;
                    bdJ = bdJ();
                    i2 = bdK();
                    this.euV.setCornerRadius(this.euW, 0.0f, 0.0f, this.euW);
                    break;
                default:
                    bdJ = 0;
                    break;
            }
            update(bdJ, i2);
            if (i == 2) {
                U(this.euV);
            }
        }
    }

    public void bdG() {
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
                if (b.this.aGf != null) {
                    b.this.aGf.release();
                }
            }
        });
    }

    private void initView() {
        this.euW = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.euV = new RoundRectRelativeLayout(this.mActivity);
        p(this.euV);
        Q(this.euV);
        setContentView(this.euV);
    }

    private void p(ViewGroup viewGroup) {
        this.aGf = new CommonWebLayout(this.mActivity);
        this.aGf.setBackgroundColor(this.mActivity.getResources().getColor(a.d.sdk_black_alpha85));
        this.aGf.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void el(String str) {
                super.el(str);
                if (b.this.aGg != null) {
                    b.this.aGg.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cX(int i) {
                super.cX(i);
                if (i == 100 && b.this.aGg != null) {
                    b.this.aGg.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void em(String str) {
                super.em(str);
                if (b.this.aGg != null) {
                    b.this.aGg.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (b.this.aGg != null) {
                    b.this.aGg.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.aGf, new ViewGroup.LayoutParams(-1, -1));
    }

    private void Q(ViewGroup viewGroup) {
        this.aGg = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.aGg, layoutParams);
        this.aGg.setVisibility(8);
    }

    private int bdH() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int bdJ() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bhL() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - p.x(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.e.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int bdK() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void xG() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.euX) {
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

    private boolean bdL() {
        if (getContentView() == null) {
            return false;
        }
        if (this.eOX) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.euX) {
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
                    b.this.bdG();
                    b.this.eOX = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.eOX = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.e
    public void cY(int i) {
        dismiss();
        if (this.aGf != null) {
            this.aGf.release();
        }
    }

    private void U(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
