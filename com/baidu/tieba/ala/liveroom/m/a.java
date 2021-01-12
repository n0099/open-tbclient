package com.baidu.tieba.ala.liveroom.m;

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
import com.baidu.live.view.e;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.c;
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
/* loaded from: classes10.dex */
public class a extends e implements f {
    private RoundRectRelativeLayout bud;
    private CommonWebLayout bue;
    private View bug;
    private float buh;
    private boolean hkI;
    private Activity mActivity;

    public a(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        od(false);
        if (!Wt()) {
            Wo();
        }
    }

    public void a(long j, String str, long j2, AlaLastLiveroomInfo alaLastLiveroomInfo, boolean z) {
        g gVar = new g();
        gVar.w(this.mActivity).a(this).a(this.bue.getSchemeCallback()).bA(j).hY(str).dz(z).bB(j2).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] Wm = gVar.Wm();
        for (com.baidu.live.view.web.a aVar : Wm) {
            this.bue.addJavascriptInterface(aVar, aVar.getName());
        }
    }

    public void Fp(String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            setWidth(ScreenHelper.getScreenWidth(this.mActivity));
            setHeight(-1);
            showAtLocation(findViewById, 80, 0, 0);
            ah(this.bud);
            Ko();
            this.bue.loadUrl(str);
            od(true);
        }
    }

    private void od(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913224, Boolean.valueOf(z)));
    }

    public void co(int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && this.bud != null && this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            update(ScreenHelper.getScreenWidth(this.mActivity), -1);
        }
    }

    public void onResume() {
        if (this.bue != null) {
            this.bue.onResume();
        }
    }

    public void onPause() {
        if (this.bue != null) {
            this.bue.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wo() {
        super.dismiss();
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.m.a.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (a.this.bue != null) {
                    a.this.bue.release();
                }
            }
        });
    }

    private void initView() {
        cev();
        initWebView();
        cew();
        setContentView(this.bud);
    }

    private void cev() {
        if (this.bud == null) {
            this.buh = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            this.bud = new RoundRectRelativeLayout(this.mActivity);
            this.bud.setCornerRadius(this.buh);
            if (Build.VERSION.SDK_INT >= 19) {
                setClippingEnabled(false);
                this.bud.setSystemUiVisibility(5380);
            }
        }
    }

    private void initWebView() {
        this.bue = new CommonWebLayout(this.mActivity);
        this.bue.setBackgroundColor(0);
        this.bue.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.m.a.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void gU(String str) {
                super.gU(str);
                if (a.this.bug != null) {
                    a.this.bug.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dO(int i) {
                super.dO(i);
                if (i == 100 && a.this.bug != null) {
                    a.this.bug.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void gV(String str) {
                super.gV(str);
                if (a.this.bug != null) {
                    a.this.bug.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (a.this.bug != null) {
                    a.this.bug.setVisibility(8);
                }
            }
        });
        this.bud.addView(this.bue, new ViewGroup.LayoutParams(-1, -1));
    }

    private void cew() {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.bug = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.bud.addView(this.bug, layoutParams);
            this.bug.setVisibility(8);
        }
    }

    private void Ko() {
        TranslateAnimation translateAnimation;
        if (getContentView() != null && (translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f)) != null) {
            translateAnimation.setDuration(250L);
            translateAnimation.setInterpolator(new LinearInterpolator());
            getContentView().startAnimation(translateAnimation);
        }
    }

    private boolean Wt() {
        if (getContentView() == null) {
            return false;
        }
        if (this.hkI) {
            return true;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(250L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.m.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                a.this.Wo();
                a.this.hkI = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        getContentView().startAnimation(translateAnimation);
        this.hkI = true;
        return true;
    }

    public void release() {
        if (this.bue != null) {
            this.bue.release();
        }
    }

    @Override // com.baidu.live.view.web.f
    public void dL(int i) {
        dismiss();
        if (this.bue != null) {
            this.bue.release();
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
