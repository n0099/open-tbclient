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
    private Runnable bsR;
    private PopupWindow dfo;
    private com.baidu.tieba.tbadkCore.e.a dfp;
    private ActivityLifeCycleListener dfq;
    private com.baidu.tieba.tbadkCore.e.c dfr;
    private Handler handler;

    private b() {
        this.handler = new Handler();
        this.dfr = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.easterEgg.b.1
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                return b.this.dfp != null && b.this.dfp.b(str, jsPromptResult);
            }
        };
        this.bsR = new Runnable() { // from class: com.baidu.tieba.easterEgg.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.handler.removeCallbacksAndMessages(null);
                b.this.asB();
            }
        };
        this.dfp = new com.baidu.tieba.tbadkCore.e.a();
        this.dfp.a(new com.baidu.tieba.easterEgg.a());
        this.dfq = new ActivityLifeCycleListener();
    }

    public static b asA() {
        return a.dfu;
    }

    private void f(Activity activity, View view) {
        this.dfo = new PopupWindow(activity);
        this.dfo.setBackgroundDrawable(new ColorDrawable(0));
        this.dfo.setWidth(l.aO(activity));
        this.dfo.setHeight(l.aQ(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.dfo.setContentView(view);
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.bsR, 5000L);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null) {
            fragmentManager.beginTransaction().add(this.dfq, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.dfo.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.easterEgg.b.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                b.this.dfo = null;
            }
        });
        try {
            this.dfo.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new am("c13126"));
        } catch (Throwable th) {
        }
    }

    public void mA(final String str) {
        Activity fX;
        if (!ao.isEmpty(str) && (fX = com.baidu.adp.base.a.fW().fX()) != null && fX.getWindow() != null && fX.getWindow().getDecorView() != null) {
            if (G(fX)) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.mA(str);
                        } catch (Throwable th) {
                            b.this.asB();
                        }
                    }
                }, 1000L);
                return;
            }
            if (this.dfo != null && this.dfo.isShowing()) {
                if (this.dfo.getContentView() == null || this.dfo.getContentView().getContext() != fX) {
                    asB();
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
                    b.this.asB();
                }
            });
            baseWebView.setBackgroundColor(0);
            baseWebView.setOnJsPromptCallback(this.dfr);
            f(fX, inflate);
        }
    }

    public void bn(final String str, final String str2) {
        Activity fX;
        if (!ao.isEmpty(str)) {
            if ((this.dfo == null || !this.dfo.isShowing()) && (fX = com.baidu.adp.base.a.fW().fX()) != null && ab.bC(fX)) {
                if (G(fX)) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.7
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.bn(str, str2);
                            } catch (Throwable th) {
                                b.this.asB();
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
                            ay.Db().c(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{str2});
                        } else {
                            b.this.asB();
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
                        b.this.asB();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        b.this.asB();
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

    public void asB() {
        if (this.dfo != null && this.dfo.isShowing()) {
            try {
                this.dfo.dismiss();
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static b dfu = new b();
    }

    private boolean G(Activity activity) {
        return activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode"));
    }
}
