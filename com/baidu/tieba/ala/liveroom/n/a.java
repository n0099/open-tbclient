package com.baidu.tieba.ala.liveroom.n;

import android.app.Activity;
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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.f;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.c;
import com.baidu.live.view.web.g;
/* loaded from: classes4.dex */
public class a extends f implements com.baidu.live.view.web.f {
    private RoundRectRelativeLayout bpn;
    private CommonWebLayout bpo;
    private View bpp;
    private float bpq;
    private boolean gOh;
    private Activity mActivity;

    public a(Activity activity) {
        super(activity);
        this.mActivity = activity;
        setClippingEnabled(false);
        init();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        nc(false);
        if (!UF()) {
            UA();
        }
    }

    public void a(long j, String str, long j2, AlaLastLiveroomInfo alaLastLiveroomInfo, boolean z) {
        g gVar = new g();
        gVar.x(this.mActivity).a(this).a(this.bpo.getSchemeCallback()).aG(j).iF(str).dd(z).aH(j2).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] Ux = gVar.Ux();
        for (com.baidu.live.view.web.a aVar : Ux) {
            this.bpo.addJavascriptInterface(aVar, aVar.getName());
        }
    }

    public void FZ(String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            setWidth(ScreenHelper.getScreenWidth(this.mActivity));
            setHeight(-1);
            showAtLocation(findViewById, 80, 0, 0);
            ad(this.bpn);
            Mr();
            this.bpo.loadUrl(str);
            nc(true);
        }
    }

    private void nc(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913224, Boolean.valueOf(z)));
    }

    public void dI(int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && this.bpn != null && this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            update(ScreenHelper.getScreenWidth(this.mActivity), -1);
        }
    }

    public void onResume() {
        if (this.bpo != null) {
            this.bpo.onResume();
        }
    }

    public void onPause() {
        if (this.bpo != null) {
            this.bpo.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UA() {
        super.dismiss();
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.n.a.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (a.this.bpo != null) {
                    a.this.bpo.release();
                }
            }
        });
    }

    private void initView() {
        bZI();
        initWebView();
        bZJ();
        setContentView(this.bpn);
    }

    private void bZI() {
        if (this.bpn == null) {
            this.bpq = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            this.bpn = new RoundRectRelativeLayout(this.mActivity);
            this.bpn.setCornerRadius(this.bpq);
            if (Build.VERSION.SDK_INT >= 19) {
                this.bpn.setSystemUiVisibility(5380);
            }
        }
    }

    private void initWebView() {
        this.bpo = new CommonWebLayout(this.mActivity);
        this.bpo.setBackgroundColor(0);
        this.bpo.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.n.a.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hN(String str) {
                super.hN(str);
                if (a.this.bpp != null) {
                    a.this.bpp.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fa(int i) {
                super.fa(i);
                if (i == 100 && a.this.bpp != null) {
                    a.this.bpp.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hO(String str) {
                super.hO(str);
                if (a.this.bpp != null) {
                    a.this.bpp.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (a.this.bpp != null) {
                    a.this.bpp.setVisibility(8);
                }
            }
        });
        this.bpn.addView(this.bpo, new ViewGroup.LayoutParams(-1, -1));
    }

    private void bZJ() {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.bpp = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.bpn.addView(this.bpp, layoutParams);
            this.bpp.setVisibility(8);
        }
    }

    private void Mr() {
        TranslateAnimation translateAnimation;
        if (getContentView() != null && (translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f)) != null) {
            translateAnimation.setDuration(250L);
            translateAnimation.setInterpolator(new LinearInterpolator());
            getContentView().startAnimation(translateAnimation);
        }
    }

    private boolean UF() {
        if (getContentView() == null) {
            return false;
        }
        if (this.gOh) {
            return true;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(250L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.n.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                a.this.UA();
                a.this.gOh = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        getContentView().startAnimation(translateAnimation);
        this.gOh = true;
        return true;
    }

    public void release() {
        if (this.bpo != null) {
            this.bpo.release();
        }
    }

    @Override // com.baidu.live.view.web.f
    public void eX(int i) {
        dismiss();
        if (this.bpo != null) {
            this.bpo.release();
        }
    }

    private void ad(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
