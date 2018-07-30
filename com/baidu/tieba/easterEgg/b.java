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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    private Runnable bin;
    private PopupWindow cQc;
    private com.baidu.tieba.tbadkCore.e.a cQd;
    private ActivityLifeCycleListener cQe;
    private com.baidu.tieba.tbadkCore.e.c cQf;
    private Handler handler;

    private b() {
        this.handler = new Handler();
        this.cQf = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.easterEgg.b.1
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                return b.this.cQd != null && b.this.cQd.b(str, jsPromptResult);
            }
        };
        this.bin = new Runnable() { // from class: com.baidu.tieba.easterEgg.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.handler.removeCallbacksAndMessages(null);
                b.this.anP();
            }
        };
        this.cQd = new com.baidu.tieba.tbadkCore.e.a();
        this.cQd.a(new com.baidu.tieba.easterEgg.a());
        this.cQe = new ActivityLifeCycleListener();
    }

    public static b anO() {
        return a.cQi;
    }

    private void b(Activity activity, View view) {
        this.cQc = new PopupWindow(activity);
        this.cQc.setBackgroundDrawable(new ColorDrawable(0));
        this.cQc.setWidth(l.ah(activity));
        this.cQc.setHeight(l.aj(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cQc.setContentView(view);
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.bin, TbConfig.NOTIFY_SOUND_INTERVAL);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null) {
            fragmentManager.beginTransaction().add(this.cQe, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.cQc.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.easterEgg.b.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                b.this.cQc = null;
            }
        });
        try {
            this.cQc.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new an("c13126"));
        } catch (Throwable th) {
        }
    }

    public void lt(final String str) {
        Activity ex;
        if (!ap.isEmpty(str) && (ex = com.baidu.adp.base.a.ew().ex()) != null && ex.getWindow() != null && ex.getWindow().getDecorView() != null) {
            if (A(ex)) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lt(str);
                    }
                }, 1000L);
                return;
            }
            if (this.cQc != null && this.cQc.isShowing()) {
                if (this.cQc.getContentView() == null || this.cQc.getContentView().getContext() != ex) {
                    anP();
                } else {
                    return;
                }
            }
            View inflate = LayoutInflater.from(ex).inflate(d.h.easter_egg_dialog_h5_layout, (ViewGroup) null);
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
                    b.this.anP();
                }
            });
            baseWebView.setBackgroundColor(0);
            baseWebView.setOnJsPromptCallback(this.cQf);
            b(ex, inflate);
        }
    }

    public void aT(final String str, final String str2) {
        Activity ex;
        if (!ap.isEmpty(str)) {
            if ((this.cQc == null || !this.cQc.isShowing()) && (ex = com.baidu.adp.base.a.ew().ex()) != null && ac.aR(ex)) {
                if (A(ex)) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.7
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.aT(str, str2);
                        }
                    }, 1000L);
                    return;
                }
                View inflate = LayoutInflater.from(ex).inflate(d.h.easter_egg_dialog_lottie_layout, (ViewGroup) null);
                inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) inflate.findViewById(d.g.easter_egg_lottie_view);
                tBLottieAnimationView.setBackgroundResource(d.C0140d.transparent);
                tBLottieAnimationView.setAnimationUrl(str);
                tBLottieAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.easterEgg.b.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ap.isEmpty(str2) && (view.getContext() instanceof TbPageContextSupport)) {
                            ay.zK().c(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{str2});
                        } else {
                            b.this.anP();
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
                        b.this.anP();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        b.this.anP();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                tBLottieAnimationView.aX();
                b(ex, inflate);
            }
        }
    }

    public void anP() {
        if (this.cQc != null && this.cQc.isShowing()) {
            try {
                this.cQc.dismiss();
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static b cQi = new b();
    }

    private boolean A(Activity activity) {
        return activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode"));
    }
}
