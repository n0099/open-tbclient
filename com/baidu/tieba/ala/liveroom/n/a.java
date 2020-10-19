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
    private RoundRectRelativeLayout bnA;
    private CommonWebLayout bnB;
    private View bnC;
    private float bnD;
    private boolean gCt;
    private Activity mActivity;

    public a(Activity activity) {
        super(activity);
        this.mActivity = activity;
        setClippingEnabled(false);
        init();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        mM(false);
        if (!TF()) {
            TA();
        }
    }

    public void a(long j, String str, long j2, AlaLastLiveroomInfo alaLastLiveroomInfo, boolean z) {
        g gVar = new g();
        gVar.x(this.mActivity).a(this).a(this.bnB.getSchemeCallback()).aE(j).iu(str).cU(z).aF(j2).a(alaLastLiveroomInfo);
        com.baidu.live.view.web.a[] Tx = gVar.Tx();
        for (com.baidu.live.view.web.a aVar : Tx) {
            this.bnB.addJavascriptInterface(aVar, aVar.getName());
        }
    }

    public void Fz(String str) {
        View findViewById;
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            setWidth(ScreenHelper.getScreenWidth(this.mActivity));
            setHeight(-1);
            showAtLocation(findViewById, 80, 0, 0);
            ad(this.bnA);
            LX();
            this.bnB.loadUrl(str);
            mM(true);
        }
    }

    private void mM(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913224, Boolean.valueOf(z)));
    }

    public void dI(int i) {
        if (this.mActivity != null && !this.mActivity.isFinishing() && this.bnA != null && this.mActivity.getWindow().getDecorView().findViewById(16908290) != null) {
            update(ScreenHelper.getScreenWidth(this.mActivity), -1);
        }
    }

    public void onResume() {
        if (this.bnB != null) {
            this.bnB.onResume();
        }
    }

    public void onPause() {
        if (this.bnB != null) {
            this.bnB.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TA() {
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
                if (a.this.bnB != null) {
                    a.this.bnB.release();
                }
            }
        });
    }

    private void initView() {
        bWJ();
        initWebView();
        bWK();
        setContentView(this.bnA);
    }

    private void bWJ() {
        if (this.bnA == null) {
            this.bnD = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            this.bnA = new RoundRectRelativeLayout(this.mActivity);
            this.bnA.setCornerRadius(this.bnD);
            if (Build.VERSION.SDK_INT >= 19) {
                this.bnA.setSystemUiVisibility(5380);
            }
        }
    }

    private void initWebView() {
        this.bnB = new CommonWebLayout(this.mActivity);
        this.bnB.setBackgroundColor(0);
        this.bnB.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.n.a.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hF(String str) {
                super.hF(str);
                if (a.this.bnC != null) {
                    a.this.bnC.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void eX(int i) {
                super.eX(i);
                if (i == 100 && a.this.bnC != null) {
                    a.this.bnC.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hG(String str) {
                super.hG(str);
                if (a.this.bnC != null) {
                    a.this.bnC.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (a.this.bnC != null) {
                    a.this.bnC.setVisibility(8);
                }
            }
        });
        this.bnA.addView(this.bnB, new ViewGroup.LayoutParams(-1, -1));
    }

    private void bWK() {
        if (this.mActivity != null && !this.mActivity.isFinishing() && !this.mActivity.isDestroyed()) {
            this.bnC = LayoutInflater.from(this.mActivity).inflate(a.h.live_web_pop_progress, (ViewGroup) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.bnA.addView(this.bnC, layoutParams);
            this.bnC.setVisibility(8);
        }
    }

    private void LX() {
        TranslateAnimation translateAnimation;
        if (getContentView() != null && (translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f)) != null) {
            translateAnimation.setDuration(250L);
            translateAnimation.setInterpolator(new LinearInterpolator());
            getContentView().startAnimation(translateAnimation);
        }
    }

    private boolean TF() {
        if (getContentView() == null) {
            return false;
        }
        if (this.gCt) {
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
                a.this.TA();
                a.this.gCt = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        getContentView().startAnimation(translateAnimation);
        this.gCt = true;
        return true;
    }

    public void release() {
        if (this.bnB != null) {
            this.bnB.release();
        }
    }

    @Override // com.baidu.live.view.web.f
    public void eU(int i) {
        dismiss();
        if (this.bnB != null) {
            this.bnB.release();
        }
    }

    private void ad(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
