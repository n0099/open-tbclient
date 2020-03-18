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
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.u.a;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes3.dex */
public class d extends f implements com.baidu.live.view.web.e {
    private CommonWebLayout aGv;
    private View aGw;
    private RoundRectRelativeLayout evF;
    private float evG;
    private int evH;
    private a flJ;
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

    public CommonWebLayout bdN() {
        return this.aGv;
    }

    public void a(a aVar) {
        this.flJ = aVar;
    }

    public void show(String str) {
        View findViewById;
        int bdR;
        int bdS;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.evH = 80;
                    bdR = bdP();
                    bdS = bdQ();
                    this.evF.setCornerRadius(this.evG, this.evG, 0.0f, 0.0f);
                    break;
                case 2:
                    this.evH = 5;
                    bdR = bdR();
                    bdS = bdS();
                    this.evF.setCornerRadius(this.evG, 0.0f, 0.0f, this.evG);
                    break;
                default:
                    this.evH = 80;
                    bdR = bdP();
                    bdS = bdQ();
                    this.evF.setCornerRadius(this.evG, this.evG, 0.0f, 0.0f);
                    break;
            }
            setWidth(bdR);
            setHeight(bdS);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                U(this.evF);
            }
            xL();
            this.aGv.loadUrl(str);
        }
    }

    public void bW(int i) {
        int bdS;
        int i2 = 0;
        if (((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290) != null) {
            switch (i) {
                case 1:
                    this.evH = 80;
                    i2 = bdP();
                    bdS = bdQ();
                    this.evF.setCornerRadius(this.evG, this.evG, 0.0f, 0.0f);
                    break;
                case 2:
                    this.evH = 5;
                    i2 = bdR();
                    bdS = bdS();
                    this.evF.setCornerRadius(this.evG, 0.0f, 0.0f, this.evG);
                    break;
                default:
                    bdS = 0;
                    break;
            }
            update(i2, bdS);
            if (i == 2) {
                U(this.evF);
            }
        }
    }

    public void bdO() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bdT()) {
            bdO();
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
                if (d.this.aGv != null) {
                    d.this.aGv.release();
                }
                if (d.this.flJ != null) {
                    d.this.flJ.onDismiss();
                }
            }
        });
    }

    private void initView() {
        this.evG = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.evF = new RoundRectRelativeLayout(this.mContext);
        p(this.evF);
        Q(this.evF);
        setContentView(this.evF);
    }

    private void p(ViewGroup viewGroup) {
        this.aGv = new CommonWebLayout(this.mContext);
        this.aGv.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.aGv.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.turntable.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ek(String str) {
                super.ek(str);
                if (d.this.aGw != null) {
                    d.this.aGw.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cX(int i) {
                super.cX(i);
                if (i == 100 && d.this.aGw != null) {
                    d.this.aGw.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void el(String str) {
                super.el(str);
                if (d.this.aGw != null) {
                    d.this.aGw.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (d.this.aGw != null) {
                    d.this.aGw.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.aGv, new ViewGroup.LayoutParams(-1, -1));
    }

    private void Q(ViewGroup viewGroup) {
        this.aGw = LayoutInflater.from(this.mContext).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.aGw, layoutParams);
        this.aGw.setVisibility(8);
    }

    private int bdP() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int bdQ() {
        return (bdP() * 470) / 375;
    }

    private int bdR() {
        return (bdS() * 375) / 470;
    }

    private int bdS() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void xL() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.evH) {
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

    private boolean bdT() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.evH) {
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
                    d.this.bdO();
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
