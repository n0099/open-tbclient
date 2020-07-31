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
/* loaded from: classes4.dex */
public class b extends f implements com.baidu.live.view.web.f {
    private CommonWebLayout bdJ;
    private View bdK;
    private RoundRectRelativeLayout fCu;
    private float fCv;
    private int fCw;
    private boolean fYQ;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout Hl() {
        return this.bdJ;
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!byn()) {
            byi();
        }
    }

    public void aA(String str, int i) {
        View findViewById;
        int byl;
        int bym;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (i) {
                case 0:
                    this.fCw = 80;
                    byl = byj();
                    bym = (int) Math.min(ScreenHelper.getRealScreenHeight(this.mActivity) * 0.64f, this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
                    this.fCu.setCornerRadius(this.fCv, this.fCv, 0.0f, 0.0f);
                    break;
                case 1:
                    this.fCw = 80;
                    byl = byj();
                    bym = bDo();
                    this.fCu.setCornerRadius(this.fCv, this.fCv, 0.0f, 0.0f);
                    break;
                case 2:
                    this.fCw = 5;
                    byl = byl();
                    bym = bym();
                    this.fCu.setCornerRadius(this.fCv, 0.0f, 0.0f, this.fCv);
                    break;
                default:
                    bym = 0;
                    byl = 0;
                    break;
            }
            setWidth(byl);
            setHeight(bym);
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                Z((View) this.fCu);
            }
            EG();
            this.bdJ.loadUrl(str);
        }
    }

    public void bN(int i) {
        int byl;
        int i2 = 0;
        if (this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.fCw = 80;
                    byl = byj();
                    i2 = bDo();
                    this.fCu.setCornerRadius(this.fCv, this.fCv, 0.0f, 0.0f);
                    break;
                case 2:
                    this.fCw = 5;
                    byl = byl();
                    i2 = bym();
                    this.fCu.setCornerRadius(this.fCv, 0.0f, 0.0f, this.fCv);
                    break;
                default:
                    byl = 0;
                    break;
            }
            update(byl, i2);
            if (i == 2) {
                Z((View) this.fCu);
            }
        }
    }

    public void byi() {
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
                if (b.this.bdJ != null) {
                    b.this.bdJ.release();
                }
            }
        });
    }

    private void initView() {
        this.fCv = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.fCu = new RoundRectRelativeLayout(this.mActivity);
        x(this.fCu);
        Z((ViewGroup) this.fCu);
        setContentView(this.fCu);
    }

    private void x(ViewGroup viewGroup) {
        this.bdJ = new CommonWebLayout(this.mActivity);
        this.bdJ.setBackgroundColor(this.mActivity.getResources().getColor(a.d.sdk_black_alpha85));
        this.bdJ.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fX(String str) {
                super.fX(str);
                if (b.this.bdK != null) {
                    b.this.bdK.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dE(int i) {
                super.dE(i);
                if (i == 100 && b.this.bdK != null) {
                    b.this.bdK.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fH(String str) {
                super.fH(str);
                if (b.this.bdK != null) {
                    b.this.bdK.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (b.this.bdK != null) {
                    b.this.bdK.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bdJ, new ViewGroup.LayoutParams(-1, -1));
    }

    private void Z(ViewGroup viewGroup) {
        this.bdK = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bdK, layoutParams);
        this.bdK.setVisibility(8);
    }

    private int byj() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private int byl() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bDo() {
        int dimensionPixelSize;
        int screenHeight = ScreenHelper.getScreenHeight(this.mActivity) - o.u(this.mActivity);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize = UtilHelper.getStatusBarHeight();
        } else {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(a.e.sdk_ds12);
        }
        return screenHeight - dimensionPixelSize;
    }

    private int bym() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void EG() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.fCw) {
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

    private boolean byn() {
        if (getContentView() == null) {
            return false;
        }
        if (this.fYQ) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.fCw) {
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
                    b.this.byi();
                    b.this.fYQ = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.fYQ = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void cN(int i) {
        dismiss();
        if (this.bdJ != null) {
            this.bdJ.release();
        }
    }

    private void Z(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
