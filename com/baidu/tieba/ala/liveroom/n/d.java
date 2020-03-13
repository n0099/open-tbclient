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
    private CommonWebLayout aGh;
    private View aGi;
    private RoundRectRelativeLayout evj;
    private float evk;
    private int evl;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout bdI() {
        return this.aGh;
    }

    public void show(String str) {
        View findViewById;
        int bdM;
        int bdN;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.evl = 80;
                    bdM = bdK();
                    bdN = bdL();
                    this.evj.setCornerRadius(this.evk, this.evk, 0.0f, 0.0f);
                    break;
                case 2:
                    this.evl = 5;
                    bdM = bdM();
                    bdN = bdN();
                    this.evj.setCornerRadius(this.evk, 0.0f, 0.0f, this.evk);
                    break;
                default:
                    this.evl = 80;
                    bdM = bdK();
                    bdN = bdL();
                    this.evj.setCornerRadius(this.evk, this.evk, 0.0f, 0.0f);
                    break;
            }
            setWidth(bdM);
            setHeight(bdN);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                U(this.evj);
            }
            xG();
            this.aGh.loadUrl(str);
        }
    }

    public void bdJ() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bdO()) {
            bdJ();
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
                if (d.this.aGh != null) {
                    d.this.aGh.release();
                }
            }
        });
    }

    private void initView() {
        this.evk = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.evj = new RoundRectRelativeLayout(this.mContext);
        p(this.evj);
        Q(this.evj);
        setContentView(this.evj);
    }

    private void p(ViewGroup viewGroup) {
        this.aGh = new CommonWebLayout(this.mContext);
        this.aGh.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.aGh.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.n.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void el(String str) {
                super.el(str);
                if (d.this.aGi != null) {
                    d.this.aGi.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cX(int i) {
                super.cX(i);
                if (i == 100 && d.this.aGi != null) {
                    d.this.aGi.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void em(String str) {
                super.em(str);
                if (d.this.aGi != null) {
                    d.this.aGi.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (d.this.aGi != null) {
                    d.this.aGi.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.aGh, new ViewGroup.LayoutParams(-1, -1));
    }

    private void Q(ViewGroup viewGroup) {
        this.aGi = LayoutInflater.from(this.mContext).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.aGi, layoutParams);
        this.aGi.setVisibility(8);
    }

    private int bdK() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int bdL() {
        return (bdK() * 470) / 375;
    }

    private int bdM() {
        return (bdN() * 375) / 470;
    }

    private int bdN() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void xG() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.evl) {
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

    private boolean bdO() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.evl) {
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
                    d.this.bdJ();
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
