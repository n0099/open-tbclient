package com.baidu.tieba.easterEgg;

import android.animation.Animator;
import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b {
    private Runnable bws;
    private PopupWindow doN;
    private com.baidu.tieba.tbadkCore.e.a doO;
    private ActivityLifeCycleListener doP;
    private com.baidu.tieba.tbadkCore.e.c doQ;
    private Handler handler;

    private b() {
        this.handler = new Handler();
        this.doQ = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.easterEgg.b.1
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                return b.this.doO != null && b.this.doO.b(str, jsPromptResult);
            }
        };
        this.bws = new Runnable() { // from class: com.baidu.tieba.easterEgg.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.handler.removeCallbacksAndMessages(null);
                b.this.avc();
            }
        };
        this.doO = new com.baidu.tieba.tbadkCore.e.a();
        this.doO.a(new com.baidu.tieba.easterEgg.a());
        this.doP = new ActivityLifeCycleListener();
    }

    public static b avb() {
        return a.doT;
    }

    private void f(Activity activity, View view) {
        this.doN = new PopupWindow(activity);
        this.doN.setBackgroundDrawable(new ColorDrawable(0));
        this.doN.setWidth(l.aO(activity));
        this.doN.setHeight(l.aQ(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.doN.setContentView(view);
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.bws, 5000L);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null) {
            fragmentManager.beginTransaction().add(this.doP, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.doN.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.easterEgg.b.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                b.this.doN = null;
            }
        });
        try {
            this.doN.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new am("c13126"));
        } catch (Throwable th) {
        }
    }

    public void nc(final String str) {
        Activity fX;
        if (!ao.isEmpty(str) && (fX = com.baidu.adp.base.a.fW().fX()) != null && fX.getWindow() != null && fX.getWindow().getDecorView() != null) {
            if (J(fX)) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.nc(str);
                        } catch (Throwable th) {
                            b.this.avc();
                        }
                    }
                }, 1000L);
                return;
            }
            if (this.doN != null && this.doN.isShowing()) {
                if (this.doN.getContentView() == null || this.doN.getContentView().getContext() != fX) {
                    avc();
                } else {
                    return;
                }
            }
            View inflate = LayoutInflater.from(fX).inflate(e.h.easter_egg_dialog_h5_layout, (ViewGroup) null);
            inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            BaseWebView baseWebView = (BaseWebView) inflate.findViewById(e.g.dialog_webview);
            baseWebView.loadUrl(str);
            baseWebView.setOnPageFinishedListener(new BaseWebView.c() { // from class: com.baidu.tieba.easterEgg.b.5
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
                public void onPageFinished(WebView webView, String str2) {
                    b.this.handler.removeCallbacksAndMessages(null);
                }
            });
            baseWebView.setOnReceivedErrorListener(new BaseWebView.f() { // from class: com.baidu.tieba.easterEgg.b.6
                @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.f
                public void onReceivedError(WebView webView, int i, String str2, String str3) {
                    b.this.handler.removeCallbacksAndMessages(null);
                    b.this.avc();
                }
            });
            baseWebView.setBackgroundColor(0);
            baseWebView.setOnJsPromptCallback(this.doQ);
            f(fX, inflate);
        }
    }

    public void bs(final String str, final String str2) {
        Activity fX;
        if (!ao.isEmpty(str)) {
            if ((this.doN == null || !this.doN.isShowing()) && (fX = com.baidu.adp.base.a.fW().fX()) != null && ab.bF(fX)) {
                if (J(fX)) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.7
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.bs(str, str2);
                            } catch (Throwable th) {
                                b.this.avc();
                            }
                        }
                    }, 1000L);
                    return;
                }
                View inflate = LayoutInflater.from(fX).inflate(e.h.easter_egg_dialog_lottie_layout, (ViewGroup) null);
                inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) inflate.findViewById(e.g.easter_egg_lottie_view);
                tBLottieAnimationView.setBackgroundResource(e.d.transparent);
                tBLottieAnimationView.setAnimationUrl(str);
                tBLottieAnimationView.F(true);
                tBLottieAnimationView.E(true);
                tBLottieAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.easterEgg.b.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ao.isEmpty(str2) && (view.getContext() instanceof TbPageContextSupport)) {
                            ay.Ef().c(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{str2});
                        } else {
                            b.this.avc();
                        }
                    }
                });
                tBLottieAnimationView.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.easterEgg.b.9
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        b.this.handler.removeCallbacksAndMessages(null);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        b.this.avc();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        b.this.avc();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                tBLottieAnimationView.cv();
                f(fX, inflate);
            }
        }
    }

    public void avc() {
        if (this.doN != null && this.doN.isShowing()) {
            try {
                this.doN.dismiss();
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static b doT = new b();
    }

    private boolean J(Activity activity) {
        return activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode"));
    }
}
