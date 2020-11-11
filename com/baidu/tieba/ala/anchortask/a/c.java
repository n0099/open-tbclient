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
import com.baidu.live.view.e;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.f;
/* loaded from: classes4.dex */
public class c extends e implements f {
    private int bOe;
    private RoundRectRelativeLayout bqG;
    private CommonWebLayout bqH;
    private View bqI;
    private float bqJ;
    private Context mContext;

    public c(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout WZ() {
        return this.bqH;
    }

    public void Gn(String str) {
        View findViewById;
        int Xd;
        int Xe;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.bOe = 80;
                    Xd = Xb();
                    Xe = Xc();
                    this.bqG.setCornerRadius(this.bqJ, this.bqJ, 0.0f, 0.0f);
                    break;
                case 2:
                    this.bOe = 5;
                    Xd = Xd();
                    Xe = Xe();
                    this.bqG.setCornerRadius(this.bqJ, 0.0f, 0.0f, this.bqJ);
                    break;
                default:
                    this.bOe = 80;
                    Xd = Xb();
                    Xe = Xc();
                    this.bqG.setCornerRadius(this.bqJ, this.bqJ, 0.0f, 0.0f);
                    break;
            }
            setWidth(Xd);
            setHeight(Xe);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                ah(this.bqG);
            }
            MR();
            this.bqH.loadUrl(str);
        }
    }

    public void Xa() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Xf()) {
            Xa();
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
                if (c.this.bqH != null) {
                    c.this.bqH.release();
                }
            }
        });
    }

    private void initView() {
        this.bqJ = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.bqG = new RoundRectRelativeLayout(this.mContext);
        r(this.bqG);
        s(this.bqG);
        setContentView(this.bqG);
    }

    private void r(ViewGroup viewGroup) {
        this.bqH = new CommonWebLayout(this.mContext);
        this.bqH.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha85));
        this.bqH.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.anchortask.a.c.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hU(String str) {
                super.hU(str);
                if (c.this.bqI != null) {
                    c.this.bqI.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fa(int i) {
                super.fa(i);
                if (i == 100 && c.this.bqI != null) {
                    c.this.bqI.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hV(String str) {
                super.hV(str);
                if (c.this.bqI != null) {
                    c.this.bqI.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (c.this.bqI != null) {
                    c.this.bqI.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bqH, new ViewGroup.LayoutParams(-1, -1));
    }

    private void s(ViewGroup viewGroup) {
        this.bqI = LayoutInflater.from(this.mContext).inflate(a.g.layout_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bqI, layoutParams);
        this.bqI.setVisibility(8);
    }

    private int Xb() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int Xc() {
        return (int) Math.min(ScreenHelper.getRealScreenHeight(this.mContext) * 0.64f, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds856));
    }

    private int Xd() {
        return (Xe() * 375) / 470;
    }

    private int Xe() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void MR() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bOe) {
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

    private boolean Xf() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bOe) {
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
                    c.this.Xa();
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

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
