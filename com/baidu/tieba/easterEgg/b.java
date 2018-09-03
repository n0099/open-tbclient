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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class b {
    private Runnable bit;
    private PopupWindow cPZ;
    private com.baidu.tieba.tbadkCore.e.a cQa;
    private ActivityLifeCycleListener cQb;
    private com.baidu.tieba.tbadkCore.e.c cQc;
    private Handler handler;

    private b() {
        this.handler = new Handler();
        this.cQc = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.easterEgg.b.1
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                return b.this.cQa != null && b.this.cQa.b(str, jsPromptResult);
            }
        };
        this.bit = new Runnable() { // from class: com.baidu.tieba.easterEgg.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.handler.removeCallbacksAndMessages(null);
                b.this.anR();
            }
        };
        this.cQa = new com.baidu.tieba.tbadkCore.e.a();
        this.cQa.a(new com.baidu.tieba.easterEgg.a());
        this.cQb = new ActivityLifeCycleListener();
    }

    public static b anQ() {
        return a.cQf;
    }

    private void b(Activity activity, View view) {
        this.cPZ = new PopupWindow(activity);
        this.cPZ.setBackgroundDrawable(new ColorDrawable(0));
        this.cPZ.setWidth(l.ah(activity));
        this.cPZ.setHeight(l.aj(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cPZ.setContentView(view);
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.bit, TbConfig.NOTIFY_SOUND_INTERVAL);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null) {
            fragmentManager.beginTransaction().add(this.cQb, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.cPZ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.easterEgg.b.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                b.this.cPZ = null;
            }
        });
        try {
            this.cPZ.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new an("c13126"));
        } catch (Throwable th) {
        }
    }

    public void lv(final String str) {
        Activity ex;
        if (!ap.isEmpty(str) && (ex = com.baidu.adp.base.a.ew().ex()) != null && ex.getWindow() != null && ex.getWindow().getDecorView() != null) {
            if (A(ex)) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lv(str);
                    }
                }, 1000L);
                return;
            }
            if (this.cPZ != null && this.cPZ.isShowing()) {
                if (this.cPZ.getContentView() == null || this.cPZ.getContentView().getContext() != ex) {
                    anR();
                } else {
                    return;
                }
            }
            View inflate = LayoutInflater.from(ex).inflate(f.h.easter_egg_dialog_h5_layout, (ViewGroup) null);
            inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            BaseWebView baseWebView = (BaseWebView) inflate.findViewById(f.g.dialog_webview);
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
                    b.this.anR();
                }
            });
            baseWebView.setBackgroundColor(0);
            baseWebView.setOnJsPromptCallback(this.cQc);
            b(ex, inflate);
        }
    }

    public void aT(final String str, final String str2) {
        Activity ex;
        if (!ap.isEmpty(str)) {
            if ((this.cPZ == null || !this.cPZ.isShowing()) && (ex = com.baidu.adp.base.a.ew().ex()) != null && ac.aQ(ex)) {
                if (A(ex)) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.7
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.aT(str, str2);
                        }
                    }, 1000L);
                    return;
                }
                View inflate = LayoutInflater.from(ex).inflate(f.h.easter_egg_dialog_lottie_layout, (ViewGroup) null);
                inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) inflate.findViewById(f.g.easter_egg_lottie_view);
                tBLottieAnimationView.setBackgroundResource(f.d.transparent);
                tBLottieAnimationView.setAnimationUrl(str);
                tBLottieAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.easterEgg.b.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ap.isEmpty(str2) && (view.getContext() instanceof TbPageContextSupport)) {
                            az.zI().c(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{str2});
                        } else {
                            b.this.anR();
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
                        b.this.anR();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        b.this.anR();
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

    public void anR() {
        if (this.cPZ != null && this.cPZ.isShowing()) {
            try {
                this.cPZ.dismiss();
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static b cQf = new b();
    }

    private boolean A(Activity activity) {
        return activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode"));
    }
}
