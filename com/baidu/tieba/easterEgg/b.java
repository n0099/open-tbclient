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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    private Runnable bgr;
    private com.baidu.tieba.tbadkCore.e.a cPA;
    private ActivityLifeCycleListener cPB;
    private com.baidu.tieba.tbadkCore.e.c cPC;
    private PopupWindow cPz;
    private Handler handler;

    private b() {
        this.handler = new Handler();
        this.cPC = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.easterEgg.b.1
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                return b.this.cPA != null && b.this.cPA.b(str, jsPromptResult);
            }
        };
        this.bgr = new Runnable() { // from class: com.baidu.tieba.easterEgg.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.handler.removeCallbacksAndMessages(null);
                b.this.anW();
            }
        };
        this.cPA = new com.baidu.tieba.tbadkCore.e.a();
        this.cPA.a(new com.baidu.tieba.easterEgg.a());
        this.cPB = new ActivityLifeCycleListener();
    }

    public static b anV() {
        return a.cPE;
    }

    private void b(Activity activity, View view) {
        this.cPz = new PopupWindow(activity);
        this.cPz.setBackgroundDrawable(new ColorDrawable(0));
        this.cPz.setWidth(l.ah(activity));
        this.cPz.setHeight(l.aj(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cPz.setContentView(view);
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.bgr, TbConfig.NOTIFY_SOUND_INTERVAL);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null) {
            fragmentManager.beginTransaction().add(this.cPB, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.cPz.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.easterEgg.b.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                b.this.cPz = null;
            }
        });
        try {
            this.cPz.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new am("c13126"));
        } catch (Throwable th) {
        }
    }

    public void lx(final String str) {
        Activity ey;
        if (!ao.isEmpty(str) && (ey = com.baidu.adp.base.a.ex().ey()) != null && ey.getWindow() != null && ey.getWindow().getDecorView() != null) {
            if (B(ey)) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lx(str);
                    }
                }, 1000L);
                return;
            }
            if (this.cPz != null && this.cPz.isShowing()) {
                if (this.cPz.getContentView() == null || this.cPz.getContentView().getContext() != ey) {
                    anW();
                } else {
                    return;
                }
            }
            View inflate = LayoutInflater.from(ey).inflate(d.i.easter_egg_dialog_h5_layout, (ViewGroup) null);
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
                    b.this.anW();
                }
            });
            baseWebView.setBackgroundColor(0);
            baseWebView.setOnJsPromptCallback(this.cPC);
            b(ey, inflate);
        }
    }

    public void ly(final String str) {
        Activity ey;
        if (!ao.isEmpty(str)) {
            if ((this.cPz == null || !this.cPz.isShowing()) && (ey = com.baidu.adp.base.a.ex().ey()) != null && ac.aQ(ey)) {
                if (B(ey)) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.7
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.ly(str);
                        }
                    }, 1000L);
                    return;
                }
                View inflate = LayoutInflater.from(ey).inflate(d.i.easter_egg_dialog_lottie_layout, (ViewGroup) null);
                inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) inflate.findViewById(d.g.easter_egg_lottie_view);
                tBLottieAnimationView.setBackgroundResource(d.C0141d.transparent);
                tBLottieAnimationView.setAnimationUrl(str);
                tBLottieAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.easterEgg.b.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.anW();
                    }
                });
                tBLottieAnimationView.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.easterEgg.b.9
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        b.this.handler.removeCallbacksAndMessages(null);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        b.this.anW();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        b.this.anW();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                tBLottieAnimationView.ba();
                b(ey, inflate);
            }
        }
    }

    public void anW() {
        if (this.cPz != null && this.cPz.isShowing()) {
            try {
                this.cPz.dismiss();
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static b cPE = new b();
    }

    private boolean B(Activity activity) {
        return activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode"));
    }
}
