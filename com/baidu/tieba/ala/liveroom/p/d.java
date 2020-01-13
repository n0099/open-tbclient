package com.baidu.tieba.ala.liveroom.p;

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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.e;
/* loaded from: classes2.dex */
public class d extends f implements e {
    private CommonWebLayout aBY;
    private View aBZ;
    private RoundRectRelativeLayout eqK;
    private float eqL;
    private int eqM;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout bbq() {
        return this.aBY;
    }

    public void show(String str) {
        View findViewById;
        int bbu;
        int bbv;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.eqM = 80;
                    bbu = bbs();
                    bbv = bbt();
                    this.eqK.setCornerRadius(this.eqL, this.eqL, 0.0f, 0.0f);
                    break;
                case 2:
                    this.eqM = 5;
                    bbu = bbu();
                    bbv = bbv();
                    this.eqK.setCornerRadius(this.eqL, 0.0f, 0.0f, this.eqL);
                    break;
                default:
                    this.eqM = 80;
                    bbu = bbs();
                    bbv = bbt();
                    this.eqK.setCornerRadius(this.eqL, this.eqL, 0.0f, 0.0f);
                    break;
            }
            setWidth(bbu);
            setHeight(bbv);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                U(this.eqK);
            }
            vI();
            this.aBY.loadUrl(str);
        }
    }

    public void bbr() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bbw()) {
            bbr();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (d.this.aBY != null) {
                    d.this.aBY.release();
                }
            }
        });
    }

    private void initView() {
        this.eqL = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.eqK = new RoundRectRelativeLayout(this.mContext);
        o(this.eqK);
        P(this.eqK);
        setContentView(this.eqK);
    }

    private void o(ViewGroup viewGroup) {
        this.aBY = new CommonWebLayout(this.mContext);
        this.aBY.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.aBY.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.p.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dW(String str) {
                super.dW(str);
                if (d.this.aBZ != null) {
                    d.this.aBZ.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cH(int i) {
                super.cH(i);
                if (i == 100 && d.this.aBZ != null) {
                    d.this.aBZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dX(String str) {
                super.dX(str);
                if (d.this.aBZ != null) {
                    d.this.aBZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void b(String str, int i, String str2) {
                super.b(str, i, str2);
                if (d.this.aBZ != null) {
                    d.this.aBZ.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.aBY, new ViewGroup.LayoutParams(-1, -1));
    }

    private void P(ViewGroup viewGroup) {
        this.aBZ = LayoutInflater.from(this.mContext).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.aBZ, layoutParams);
        this.aBZ.setVisibility(8);
    }

    private int bbs() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int bbt() {
        return (bbs() * 470) / 375;
    }

    private int bbu() {
        return (bbv() * 375) / 470;
    }

    private int bbv() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    d.this.bbr();
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
    }

    private void U(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
