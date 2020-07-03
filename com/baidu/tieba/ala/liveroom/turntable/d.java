package com.baidu.tieba.ala.liveroom.turntable;

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
/* loaded from: classes3.dex */
public class d extends f implements com.baidu.live.view.web.f {
    private CommonWebLayout bdr;
    private View bds;
    private RoundRectRelativeLayout fxn;
    private float fxo;
    private int fxp;
    private a gse;
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void onDismiss();
    }

    public d(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout Hf() {
        return this.bdr;
    }

    public void a(a aVar) {
        this.gse = aVar;
    }

    public void show(String str) {
        View findViewById;
        int bvb;
        int bvc;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.fxp = 80;
                    bvb = buZ();
                    bvc = bva();
                    this.fxn.setCornerRadius(this.fxo, this.fxo, 0.0f, 0.0f);
                    break;
                case 2:
                    this.fxp = 5;
                    bvb = bvb();
                    bvc = bvc();
                    this.fxn.setCornerRadius(this.fxo, 0.0f, 0.0f, this.fxo);
                    break;
                default:
                    this.fxp = 80;
                    bvb = buZ();
                    bvc = bva();
                    this.fxn.setCornerRadius(this.fxo, this.fxo, 0.0f, 0.0f);
                    break;
            }
            setWidth(bvb);
            setHeight(bvc);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                W(this.fxn);
            }
            Ez();
            this.bdr.loadUrl(str);
        }
    }

    public void cA(int i) {
        int bvc;
        int i2 = 0;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.fxp = 80;
                    i2 = buZ();
                    bvc = bva();
                    this.fxn.setCornerRadius(this.fxo, this.fxo, 0.0f, 0.0f);
                    break;
                case 2:
                    this.fxp = 5;
                    i2 = bvb();
                    bvc = bvc();
                    this.fxn.setCornerRadius(this.fxo, 0.0f, 0.0f, this.fxo);
                    break;
                default:
                    bvc = 0;
                    break;
            }
            update(i2, bvc);
            if (i == 2) {
                W(this.fxn);
            }
        }
    }

    public void buY() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bvd()) {
            buY();
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
                if (d.this.bdr != null) {
                    d.this.bdr.release();
                }
                if (d.this.gse != null) {
                    d.this.gse.onDismiss();
                }
            }
        });
    }

    private void initView() {
        this.fxo = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.fxn = new RoundRectRelativeLayout(this.mContext);
        w(this.fxn);
        Y(this.fxn);
        setContentView(this.fxn);
    }

    private void w(ViewGroup viewGroup) {
        this.bdr = new CommonWebLayout(this.mContext);
        this.bdr.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.bdr.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.turntable.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fY(String str) {
                super.fY(str);
                if (d.this.bds != null) {
                    d.this.bds.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dE(int i) {
                super.dE(i);
                if (i == 100 && d.this.bds != null) {
                    d.this.bds.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fJ(String str) {
                super.fJ(str);
                if (d.this.bds != null) {
                    d.this.bds.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (d.this.bds != null) {
                    d.this.bds.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bdr, new ViewGroup.LayoutParams(-1, -1));
    }

    private void Y(ViewGroup viewGroup) {
        this.bds = LayoutInflater.from(this.mContext).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bds, layoutParams);
        this.bds.setVisibility(8);
    }

    private int buZ() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int bva() {
        return (buZ() * 470) / 375;
    }

    private int bvb() {
        return (bvc() * 375) / 470;
    }

    private int bvc() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
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

    private boolean bvd() {
        if (getContentView() == null) {
            return false;
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.turntable.d.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    d.this.buY();
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
    public void cM(int i) {
        dismiss();
    }

    private void W(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
