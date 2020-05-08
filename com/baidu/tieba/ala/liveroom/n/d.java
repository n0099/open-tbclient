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
/* loaded from: classes3.dex */
public class d extends f implements com.baidu.live.view.web.f {
    private CommonWebLayout bck;
    private View bcl;
    private RoundRectRelativeLayout eZf;
    private float eZg;
    private int eZh;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout bmC() {
        return this.bck;
    }

    public void show(String str) {
        View findViewById;
        int bmG;
        int bmH;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.eZh = 80;
                    bmG = bmE();
                    bmH = bmF();
                    this.eZf.setCornerRadius(this.eZg, this.eZg, 0.0f, 0.0f);
                    break;
                case 2:
                    this.eZh = 5;
                    bmG = bmG();
                    bmH = bmH();
                    this.eZf.setCornerRadius(this.eZg, 0.0f, 0.0f, this.eZg);
                    break;
                default:
                    this.eZh = 80;
                    bmG = bmE();
                    bmH = bmF();
                    this.eZf.setCornerRadius(this.eZg, this.eZg, 0.0f, 0.0f);
                    break;
            }
            setWidth(bmG);
            setHeight(bmH);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                W(this.eZf);
            }
            CA();
            this.bck.loadUrl(str);
        }
    }

    public void bmD() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bmI()) {
            bmD();
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
                if (d.this.bck != null) {
                    d.this.bck.release();
                }
            }
        });
    }

    private void initView() {
        this.eZg = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        this.eZf = new RoundRectRelativeLayout(this.mContext);
        q(this.eZf);
        R(this.eZf);
        setContentView(this.eZf);
    }

    private void q(ViewGroup viewGroup) {
        this.bck = new CommonWebLayout(this.mContext);
        this.bck.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha85));
        this.bck.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.ala.liveroom.n.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fd(String str) {
                super.fd(str);
                if (d.this.bcl != null) {
                    d.this.bcl.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dm(int i) {
                super.dm(i);
                if (i == 100 && d.this.bcl != null) {
                    d.this.bcl.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fe(String str) {
                super.fe(str);
                if (d.this.bcl != null) {
                    d.this.bcl.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (d.this.bcl != null) {
                    d.this.bcl.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bck, new ViewGroup.LayoutParams(-1, -1));
    }

    private void R(ViewGroup viewGroup) {
        this.bcl = LayoutInflater.from(this.mContext).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bcl, layoutParams);
        this.bcl.setVisibility(8);
    }

    private int bmE() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int bmF() {
        return (bmE() * 470) / 375;
    }

    private int bmG() {
        return (bmH() * 375) / 470;
    }

    private int bmH() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void CA() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.eZh) {
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

    private boolean bmI() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.eZh) {
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
                    d.this.bmD();
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
