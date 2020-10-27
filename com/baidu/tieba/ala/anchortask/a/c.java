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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes4.dex */
public class c extends f implements com.baidu.live.view.web.f {
    private int bIy;
    private RoundRectRelativeLayout bpn;
    private CommonWebLayout bpo;
    private View bpp;
    private float bpq;
    private Context mContext;

    public c(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout Uz() {
        return this.bpo;
    }

    public void FZ(String str) {
        View findViewById;
        int UD;
        int UE;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.bIy = 80;
                    UD = UB();
                    UE = UC();
                    this.bpn.setCornerRadius(this.bpq, this.bpq, 0.0f, 0.0f);
                    break;
                case 2:
                    this.bIy = 5;
                    UD = UD();
                    UE = UE();
                    this.bpn.setCornerRadius(this.bpq, 0.0f, 0.0f, this.bpq);
                    break;
                default:
                    this.bIy = 80;
                    UD = UB();
                    UE = UC();
                    this.bpn.setCornerRadius(this.bpq, this.bpq, 0.0f, 0.0f);
                    break;
            }
            setWidth(UD);
            setHeight(UE);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                ad(this.bpn);
            }
            Mr();
            this.bpo.loadUrl(str);
        }
    }

    public void UA() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!UF()) {
            UA();
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
                if (c.this.bpo != null) {
                    c.this.bpo.release();
                }
            }
        });
    }

    private void initView() {
        this.bpq = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.bpn = new RoundRectRelativeLayout(this.mContext);
        q(this.bpn);
        r(this.bpn);
        setContentView(this.bpn);
    }

    private void q(ViewGroup viewGroup) {
        this.bpo = new CommonWebLayout(this.mContext);
        this.bpo.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.bpo.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.anchortask.a.c.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hN(String str) {
                super.hN(str);
                if (c.this.bpp != null) {
                    c.this.bpp.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fa(int i) {
                super.fa(i);
                if (i == 100 && c.this.bpp != null) {
                    c.this.bpp.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hO(String str) {
                super.hO(str);
                if (c.this.bpp != null) {
                    c.this.bpp.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (c.this.bpp != null) {
                    c.this.bpp.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bpo, new ViewGroup.LayoutParams(-1, -1));
    }

    private void r(ViewGroup viewGroup) {
        this.bpp = LayoutInflater.from(this.mContext).inflate(a.h.layout_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bpp, layoutParams);
        this.bpp.setVisibility(8);
    }

    private int UB() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int UC() {
        return (int) Math.min(ScreenHelper.getRealScreenHeight(this.mContext) * 0.64f, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
    }

    private int UD() {
        return (UE() * 375) / 470;
    }

    private int UE() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void Mr() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bIy) {
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

    private boolean UF() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bIy) {
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
                    c.this.UA();
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
    public void eX(int i) {
        dismiss();
    }

    private void ad(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
