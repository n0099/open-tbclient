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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class b {
    private Runnable cIp;
    private PopupWindow eze;
    private com.baidu.tieba.tbadkCore.e.a ezf;
    private ActivityLifeCycleListener ezg;
    private com.baidu.tieba.tbadkCore.e.c ezh;
    private Handler handler;

    private b() {
        this.handler = new Handler();
        this.ezh = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.easterEgg.b.1
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                return b.this.ezf != null && b.this.ezf.a(str, jsPromptResult);
            }
        };
        this.cIp = new Runnable() { // from class: com.baidu.tieba.easterEgg.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.handler.removeCallbacksAndMessages(null);
                b.this.aVp();
            }
        };
        this.ezf = new com.baidu.tieba.tbadkCore.e.a();
        this.ezf.a(new com.baidu.tieba.easterEgg.a());
        this.ezg = new ActivityLifeCycleListener();
    }

    public static b aVo() {
        return a.ezk;
    }

    private void f(Activity activity, View view) {
        this.eze = new PopupWindow(activity);
        this.eze.setBackgroundDrawable(new ColorDrawable(0));
        this.eze.setWidth(l.aO(activity));
        this.eze.setHeight(l.aQ(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.eze.setContentView(view);
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.cIp, 5000L);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null) {
            fragmentManager.beginTransaction().add(this.ezg, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.eze.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.easterEgg.b.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                b.this.eze = null;
            }
        });
        try {
            this.eze.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new am("c13126"));
        } catch (Throwable th) {
        }
    }

    public void tS(final String str) {
        Activity fU;
        if (!ap.isEmpty(str) && (fU = com.baidu.adp.base.a.fT().fU()) != null && fU.getWindow() != null && fU.getWindow().getDecorView() != null) {
            if (af(fU)) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.tS(str);
                        } catch (Throwable th) {
                            b.this.aVp();
                        }
                    }
                }, 1000L);
                return;
            }
            if (this.eze != null && this.eze.isShowing()) {
                if (this.eze.getContentView() == null || this.eze.getContentView().getContext() != fU) {
                    aVp();
                } else {
                    return;
                }
            }
            View inflate = LayoutInflater.from(fU).inflate(d.h.easter_egg_dialog_h5_layout, (ViewGroup) null);
            inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            BaseWebView baseWebView = (BaseWebView) inflate.findViewById(d.g.dialog_webview);
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
                    b.this.aVp();
                }
            });
            baseWebView.setBackgroundColor(0);
            baseWebView.setOnJsPromptCallback(this.ezh);
            f(fU, inflate);
        }
    }

    public void cz(final String str, final String str2) {
        Activity fU;
        if (!ap.isEmpty(str)) {
            if ((this.eze == null || !this.eze.isShowing()) && (fU = com.baidu.adp.base.a.fT().fU()) != null && ab.cV(fU)) {
                if (af(fU)) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.7
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.cz(str, str2);
                            } catch (Throwable th) {
                                b.this.aVp();
                            }
                        }
                    }, 1000L);
                    return;
                }
                View inflate = LayoutInflater.from(fU).inflate(d.h.easter_egg_dialog_lottie_layout, (ViewGroup) null);
                inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) inflate.findViewById(d.g.easter_egg_lottie_view);
                tBLottieAnimationView.setBackgroundResource(d.C0277d.transparent);
                tBLottieAnimationView.setAnimationUrl(str);
                tBLottieAnimationView.F(true);
                tBLottieAnimationView.E(true);
                tBLottieAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.easterEgg.b.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ap.isEmpty(str2) && (view.getContext() instanceof TbPageContextSupport)) {
                            ba.adA().c(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{str2});
                        } else {
                            b.this.aVp();
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
                        b.this.aVp();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        b.this.aVp();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                tBLottieAnimationView.cu();
                f(fU, inflate);
            }
        }
    }

    public void aVp() {
        if (this.eze != null && this.eze.isShowing()) {
            try {
                this.eze.dismiss();
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static b ezk = new b();
    }

    private boolean af(Activity activity) {
        return activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode"));
    }
}
