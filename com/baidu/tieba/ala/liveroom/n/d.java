package com.baidu.tieba.ala.liveroom.n;

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
import com.baidu.live.view.web.e;
/* loaded from: classes3.dex */
public class d extends f implements e {
    private CommonWebLayout aGg;
    private View aGh;
    private RoundRectRelativeLayout euW;
    private float euX;
    private int euY;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout bdH() {
        return this.aGg;
    }

    public void show(String str) {
        View findViewById;
        int bdL;
        int bdM;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.euY = 80;
                    bdL = bdJ();
                    bdM = bdK();
                    this.euW.setCornerRadius(this.euX, this.euX, 0.0f, 0.0f);
                    break;
                case 2:
                    this.euY = 5;
                    bdL = bdL();
                    bdM = bdM();
                    this.euW.setCornerRadius(this.euX, 0.0f, 0.0f, this.euX);
                    break;
                default:
                    this.euY = 80;
                    bdL = bdJ();
                    bdM = bdK();
                    this.euW.setCornerRadius(this.euX, this.euX, 0.0f, 0.0f);
                    break;
            }
            setWidth(bdL);
            setHeight(bdM);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                U(this.euW);
            }
            xG();
            this.aGg.loadUrl(str);
        }
    }

    public void bdI() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bdN()) {
            bdI();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (d.this.aGg != null) {
                    d.this.aGg.release();
                }
            }
        });
    }

    private void initView() {
        this.euX = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.euW = new RoundRectRelativeLayout(this.mContext);
        p(this.euW);
        Q(this.euW);
        setContentView(this.euW);
    }

    private void p(ViewGroup viewGroup) {
        this.aGg = new CommonWebLayout(this.mContext);
        this.aGg.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.aGg.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.n.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void el(String str) {
                super.el(str);
                if (d.this.aGh != null) {
                    d.this.aGh.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cX(int i) {
                super.cX(i);
                if (i == 100 && d.this.aGh != null) {
                    d.this.aGh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void em(String str) {
                super.em(str);
                if (d.this.aGh != null) {
                    d.this.aGh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (d.this.aGh != null) {
                    d.this.aGh.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.aGg, new ViewGroup.LayoutParams(-1, -1));
    }

    private void Q(ViewGroup viewGroup) {
        this.aGh = LayoutInflater.from(this.mContext).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.aGh, layoutParams);
        this.aGh.setVisibility(8);
    }

    private int bdJ() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int bdK() {
        return (bdJ() * 470) / 375;
    }

    private int bdL() {
        return (bdM() * 375) / 470;
    }

    private int bdM() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void xG() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.euY) {
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

    private boolean bdN() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.euY) {
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    d.this.bdI();
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
    public void cY(int i) {
        dismiss();
    }

    private void U(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
