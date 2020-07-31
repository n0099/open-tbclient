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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
/* loaded from: classes4.dex */
public class d extends f implements com.baidu.live.view.web.f {
    private CommonWebLayout bdJ;
    private View bdK;
    private RoundRectRelativeLayout fCu;
    private float fCv;
    private int fCw;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout Hl() {
        return this.bdJ;
    }

    public void show(String str) {
        View findViewById;
        int byl;
        int bym;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.fCw = 80;
                    byl = byj();
                    bym = byk();
                    this.fCu.setCornerRadius(this.fCv, this.fCv, 0.0f, 0.0f);
                    break;
                case 2:
                    this.fCw = 5;
                    byl = byl();
                    bym = bym();
                    this.fCu.setCornerRadius(this.fCv, 0.0f, 0.0f, this.fCv);
                    break;
                default:
                    this.fCw = 80;
                    byl = byj();
                    bym = byk();
                    this.fCu.setCornerRadius(this.fCv, this.fCv, 0.0f, 0.0f);
                    break;
            }
            setWidth(byl);
            setHeight(bym);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                Z((View) this.fCu);
            }
            EG();
            this.bdJ.loadUrl(str);
        }
    }

    public void byi() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!byn()) {
            byi();
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
                if (d.this.bdJ != null) {
                    d.this.bdJ.release();
                }
            }
        });
    }

    private void initView() {
        this.fCv = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.fCu = new RoundRectRelativeLayout(this.mContext);
        x(this.fCu);
        Z((ViewGroup) this.fCu);
        setContentView(this.fCu);
    }

    private void x(ViewGroup viewGroup) {
        this.bdJ = new CommonWebLayout(this.mContext);
        this.bdJ.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.bdJ.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.p.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fX(String str) {
                super.fX(str);
                if (d.this.bdK != null) {
                    d.this.bdK.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dE(int i) {
                super.dE(i);
                if (i == 100 && d.this.bdK != null) {
                    d.this.bdK.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fH(String str) {
                super.fH(str);
                if (d.this.bdK != null) {
                    d.this.bdK.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (d.this.bdK != null) {
                    d.this.bdK.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bdJ, new ViewGroup.LayoutParams(-1, -1));
    }

    private void Z(ViewGroup viewGroup) {
        this.bdK = LayoutInflater.from(this.mContext).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bdK, layoutParams);
        this.bdK.setVisibility(8);
    }

    private int byj() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int byk() {
        return (byj() * 470) / 375;
    }

    private int byl() {
        return (bym() * 375) / 470;
    }

    private int bym() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    d.this.byi();
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
    public void cN(int i) {
        dismiss();
    }

    private void Z(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
