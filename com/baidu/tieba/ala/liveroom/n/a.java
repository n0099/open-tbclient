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
import com.baidu.live.view.e;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.c;
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
/* loaded from: classes4.dex */
public class a extends e implements f {
    private RoundRectRelativeLayout boV;
    private CommonWebLayout boW;
    private View boX;
    private float boY;
    private boolean gUn;
    private Activity mActivity;

    public a(Activity activity) {
        super(activity);
        this.mActivity = activity;
        setClippingEnabled(false);
        init();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        nm(false);
        if (!Ww()) {
            Wr();
        }
    }

    public void a(long j, String str, long j2, AlaLastLiveroomInfo alaLastLiveroomInfo, boolean z) {
        g gVar = new g();
        gVar.x(this.mActivity).a(this).a(this.boW.getSchemeCallback()).bc(j).iM(str).dm(z).bd(j2).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] Wo = gVar.Wo();
        for (com.baidu.live.view.web.a aVar : Wo) {
            this.boW.addJavascriptInterface(aVar, aVar.getName());
        }
    }

    public void FO(String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            setWidth(ScreenHelper.getScreenWidth(this.mActivity));
            setHeight(-1);
            showAtLocation(findViewById, 80, 0, 0);
            ah(this.boV);
            Mi();
            this.boW.loadUrl(str);
            nm(true);
        }
    }

    private void nm(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913224, Boolean.valueOf(z)));
    }

    public void dE(int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && this.boV != null && this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            update(ScreenHelper.getScreenWidth(this.mActivity), -1);
        }
    }

    public void onResume() {
        if (this.boW != null) {
            this.boW.onResume();
        }
    }

    public void onPause() {
        if (this.boW != null) {
            this.boW.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wr() {
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
                if (a.this.boW != null) {
                    a.this.boW.release();
                }
            }
        });
    }

    private void initView() {
        cbD();
        initWebView();
        cbE();
        setContentView(this.boV);
    }

    private void cbD() {
        if (this.boV == null) {
            this.boY = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            this.boV = new RoundRectRelativeLayout(this.mActivity);
            this.boV.setCornerRadius(this.boY);
            if (Build.VERSION.SDK_INT >= 19) {
                this.boV.setSystemUiVisibility(5380);
            }
        }
    }

    private void initWebView() {
        this.boW = new CommonWebLayout(this.mActivity);
        this.boW.setBackgroundColor(0);
        this.boW.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.n.a.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hO(String str) {
                super.hO(str);
                if (a.this.boX != null) {
                    a.this.boX.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void eW(int i) {
                super.eW(i);
                if (i == 100 && a.this.boX != null) {
                    a.this.boX.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hP(String str) {
                super.hP(str);
                if (a.this.boX != null) {
                    a.this.boX.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (a.this.boX != null) {
                    a.this.boX.setVisibility(8);
                }
            }
        });
        this.boV.addView(this.boW, new ViewGroup.LayoutParams(-1, -1));
    }

    private void cbE() {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.boX = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.boV.addView(this.boX, layoutParams);
            this.boX.setVisibility(8);
        }
    }

    private void Mi() {
        TranslateAnimation translateAnimation;
        if (getContentView() != null && (translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f)) != null) {
            translateAnimation.setDuration(250L);
            translateAnimation.setInterpolator(new LinearInterpolator());
            getContentView().startAnimation(translateAnimation);
        }
    }

    private boolean Ww() {
        if (getContentView() == null) {
            return false;
        }
        if (this.gUn) {
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
                a.this.Wr();
                a.this.gUn = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        getContentView().startAnimation(translateAnimation);
        this.gUn = true;
        return true;
    }

    public void release() {
        if (this.boW != null) {
            this.boW.release();
        }
    }

    @Override // com.baidu.live.view.web.f
    public void eT(int i) {
        dismiss();
        if (this.boW != null) {
            this.boW.release();
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
