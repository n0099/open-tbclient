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
    private CommonWebLayout bcf;
    private View bcg;
    private RoundRectRelativeLayout eZa;
    private float eZb;
    private int eZc;
    private Context mContext;

    public c(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout bmE() {
        return this.bcf;
    }

    public void show(String str) {
        View findViewById;
        int bmI;
        int bmJ;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.eZc = 80;
                    bmI = bmG();
                    bmJ = bmH();
                    this.eZa.setCornerRadius(this.eZb, this.eZb, 0.0f, 0.0f);
                    break;
                case 2:
                    this.eZc = 5;
                    bmI = bmI();
                    bmJ = bmJ();
                    this.eZa.setCornerRadius(this.eZb, 0.0f, 0.0f, this.eZb);
                    break;
                default:
                    this.eZc = 80;
                    bmI = bmG();
                    bmJ = bmH();
                    this.eZa.setCornerRadius(this.eZb, this.eZb, 0.0f, 0.0f);
                    break;
            }
            setWidth(bmI);
            setHeight(bmJ);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                W(this.eZa);
            }
            CB();
            this.bcf.loadUrl(str);
        }
    }

    public void bmF() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bmK()) {
            bmF();
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
                if (c.this.bcf != null) {
                    c.this.bcf.release();
                }
            }
        });
    }

    private void initView() {
        this.eZb = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.eZa = new RoundRectRelativeLayout(this.mContext);
        q(this.eZa);
        R(this.eZa);
        setContentView(this.eZa);
    }

    private void q(ViewGroup viewGroup) {
        this.bcf = new CommonWebLayout(this.mContext);
        this.bcf.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.bcf.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.anchortask.a.c.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fd(String str) {
                super.fd(str);
                if (c.this.bcg != null) {
                    c.this.bcg.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dm(int i) {
                super.dm(i);
                if (i == 100 && c.this.bcg != null) {
                    c.this.bcg.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fe(String str) {
                super.fe(str);
                if (c.this.bcg != null) {
                    c.this.bcg.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (c.this.bcg != null) {
                    c.this.bcg.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bcf, new ViewGroup.LayoutParams(-1, -1));
    }

    private void R(ViewGroup viewGroup) {
        this.bcg = LayoutInflater.from(this.mContext).inflate(a.h.layout_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bcg, layoutParams);
        this.bcg.setVisibility(8);
    }

    private int bmG() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int bmH() {
        return (int) Math.min(ScreenHelper.getRealScreenHeight(this.mContext) * 0.64f, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds856));
    }

    private int bmI() {
        return (bmJ() * 375) / 470;
    }

    private int bmJ() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void CB() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.eZc) {
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

    private boolean bmK() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.eZc) {
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
                    c.this.bmF();
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
    /* renamed from: do */
    public void mo22do(int i) {
        dismiss();
    }

    private void W(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
