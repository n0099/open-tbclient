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
    private Runnable bxg;
    private com.baidu.tieba.tbadkCore.e.a dpA;
    private ActivityLifeCycleListener dpB;
    private com.baidu.tieba.tbadkCore.e.c dpC;
    private PopupWindow dpz;
    private Handler handler;

    private b() {
        this.handler = new Handler();
        this.dpC = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.easterEgg.b.1
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                return b.this.dpA != null && b.this.dpA.b(str, jsPromptResult);
            }
        };
        this.bxg = new Runnable() { // from class: com.baidu.tieba.easterEgg.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.handler.removeCallbacksAndMessages(null);
                b.this.avA();
            }
        };
        this.dpA = new com.baidu.tieba.tbadkCore.e.a();
        this.dpA.a(new com.baidu.tieba.easterEgg.a());
        this.dpB = new ActivityLifeCycleListener();
    }

    public static b avz() {
        return a.dpF;
    }

    private void f(Activity activity, View view) {
        this.dpz = new PopupWindow(activity);
        this.dpz.setBackgroundDrawable(new ColorDrawable(0));
        this.dpz.setWidth(l.aO(activity));
        this.dpz.setHeight(l.aQ(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.dpz.setContentView(view);
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.bxg, 5000L);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null) {
            fragmentManager.beginTransaction().add(this.dpB, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.dpz.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.easterEgg.b.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                b.this.dpz = null;
            }
        });
        try {
            this.dpz.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new am("c13126"));
        } catch (Throwable th) {
        }
    }

    public void ns(final String str) {
        Activity fX;
        if (!ao.isEmpty(str) && (fX = com.baidu.adp.base.a.fW().fX()) != null && fX.getWindow() != null && fX.getWindow().getDecorView() != null) {
            if (K(fX)) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.ns(str);
                        } catch (Throwable th) {
                            b.this.avA();
                        }
                    }
                }, 1000L);
                return;
            }
            if (this.dpz != null && this.dpz.isShowing()) {
                if (this.dpz.getContentView() == null || this.dpz.getContentView().getContext() != fX) {
                    avA();
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
                    b.this.avA();
                }
            });
            baseWebView.setBackgroundColor(0);
            baseWebView.setOnJsPromptCallback(this.dpC);
            f(fX, inflate);
        }
    }

    public void bt(final String str, final String str2) {
        Activity fX;
        if (!ao.isEmpty(str)) {
            if ((this.dpz == null || !this.dpz.isShowing()) && (fX = com.baidu.adp.base.a.fW().fX()) != null && ab.bF(fX)) {
                if (K(fX)) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.7
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.bt(str, str2);
                            } catch (Throwable th) {
                                b.this.avA();
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
                            ay.Es().c(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{str2});
                        } else {
                            b.this.avA();
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
                        b.this.avA();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        b.this.avA();
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

    public void avA() {
        if (this.dpz != null && this.dpz.isShowing()) {
            try {
                this.dpz.dismiss();
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static b dpF = new b();
    }

    private boolean K(Activity activity) {
        return activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode"));
    }
}
