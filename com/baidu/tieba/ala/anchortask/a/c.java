package com.baidu.tieba.ala.anchortask.a;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes3.dex */
public class c extends f implements com.baidu.live.view.web.f {
    private CommonWebLayout bjK;
    private View bjL;
    private RoundRectRelativeLayout fma;
    private float fmb;
    private int fmc;
    private Context mContext;

    public c(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout bsc() {
        return this.bjK;
    }

    public void show(String str) {
        View findViewById;
        int bsg;
        int bsh;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.fmc = 80;
                    bsg = bse();
                    bsh = bsf();
                    this.fma.setCornerRadius(this.fmb, this.fmb, 0.0f, 0.0f);
                    break;
                case 2:
                    this.fmc = 5;
                    bsg = bsg();
                    bsh = bsh();
                    this.fma.setCornerRadius(this.fmb, 0.0f, 0.0f, this.fmb);
                    break;
                default:
                    this.fmc = 80;
                    bsg = bse();
                    bsh = bsf();
                    this.fma.setCornerRadius(this.fmb, this.fmb, 0.0f, 0.0f);
                    break;
            }
            setWidth(bsg);
            setHeight(bsh);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                V(this.fma);
            }
            DX();
            this.bjK.loadUrl(str);
        }
    }

    public void bsd() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bsi()) {
            bsd();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.anchortask.a.c.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (c.this.bjK != null) {
                    c.this.bjK.release();
                }
            }
        });
    }

    private void initView() {
        this.fmb = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.fma = new RoundRectRelativeLayout(this.mContext);
        u(this.fma);
        W(this.fma);
        setContentView(this.fma);
    }

    private void u(ViewGroup viewGroup) {
        this.bjK = new CommonWebLayout(this.mContext);
        this.bjK.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.bjK.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.anchortask.a.c.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fP(String str) {
                super.fP(str);
                if (c.this.bjL != null) {
                    c.this.bjL.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dt(int i) {
                super.dt(i);
                if (i == 100 && c.this.bjL != null) {
                    c.this.bjL.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fQ(String str) {
                super.fQ(str);
                if (c.this.bjL != null) {
                    c.this.bjL.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (c.this.bjL != null) {
                    c.this.bjL.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bjK, new ViewGroup.LayoutParams(-1, -1));
    }

    private void W(ViewGroup viewGroup) {
        this.bjL = LayoutInflater.from(this.mContext).inflate(a.h.layout_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bjL, layoutParams);
        this.bjL.setVisibility(8);
    }

    private int bse() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int bsf() {
        return (int) Math.min(ScreenHelper.getRealScreenHeight(this.mContext) * 0.64f, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
    }

    private int bsg() {
        return (bsh() * 375) / 470;
    }

    private int bsh() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.anchortask.a.c.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    c.this.bsd();
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

    @Override // com.baidu.live.view.web.f
    public void dv(int i) {
        dismiss();
    }

    private void V(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
