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
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b {
    private Runnable cQB;
    private PopupWindow eOI;
    private com.baidu.tieba.tbadkCore.e.a eOJ;
    private ActivityLifeCycleListener eOK;
    private com.baidu.tieba.tbadkCore.e.c eOL;
    private Handler handler;

    private b() {
        this.handler = new Handler();
        this.eOL = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.easterEgg.b.1
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                return b.this.eOJ != null && b.this.eOJ.a(str, jsPromptResult);
            }
        };
        this.cQB = new Runnable() { // from class: com.baidu.tieba.easterEgg.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.handler.removeCallbacksAndMessages(null);
                b.this.bcA();
            }
        };
        this.eOJ = new com.baidu.tieba.tbadkCore.e.a();
        this.eOJ.a(new com.baidu.tieba.easterEgg.a());
        this.eOK = new ActivityLifeCycleListener();
    }

    public static b bcz() {
        return a.eOO;
    }

    private void g(Activity activity, View view) {
        this.eOI = new PopupWindow(activity);
        this.eOI.setBackgroundDrawable(new ColorDrawable(0));
        this.eOI.setWidth(l.af(activity));
        this.eOI.setHeight(l.ah(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.eOI.setContentView(view);
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.cQB, 5000L);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null) {
            fragmentManager.beginTransaction().add(this.eOK, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.eOI.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.easterEgg.b.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                b.this.eOI = null;
            }
        });
        try {
            this.eOI.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new am("c13126"));
        } catch (Throwable th) {
        }
    }

    public void vl(final String str) {
        Activity eN;
        if (!ap.isEmpty(str) && (eN = com.baidu.adp.base.a.eM().eN()) != null && eN.getWindow() != null && eN.getWindow().getDecorView() != null) {
            if (ai(eN)) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.vl(str);
                        } catch (Throwable th) {
                            b.this.bcA();
                        }
                    }
                }, 1000L);
                return;
            }
            if (this.eOI != null && this.eOI.isShowing()) {
                if (this.eOI.getContentView() == null || this.eOI.getContentView().getContext() != eN) {
                    bcA();
                } else {
                    return;
                }
            }
            View inflate = LayoutInflater.from(eN).inflate(R.layout.easter_egg_dialog_h5_layout, (ViewGroup) null);
            inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            BaseWebView baseWebView = (BaseWebView) inflate.findViewById(R.id.dialog_webview);
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
                    b.this.bcA();
                }
            });
            baseWebView.setBackgroundColor(0);
            baseWebView.setOnJsPromptCallback(this.eOL);
            g(eN, inflate);
        }
    }

    public void cL(final String str, final String str2) {
        Activity eN;
        if (!ap.isEmpty(str)) {
            if ((this.eOI == null || !this.eOI.isShowing()) && (eN = com.baidu.adp.base.a.eM().eN()) != null && ab.cA(eN)) {
                if (ai(eN)) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.7
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.cL(str, str2);
                            } catch (Throwable th) {
                                b.this.bcA();
                            }
                        }
                    }, 1000L);
                    return;
                }
                View inflate = LayoutInflater.from(eN).inflate(R.layout.easter_egg_dialog_lottie_layout, (ViewGroup) null);
                inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) inflate.findViewById(R.id.easter_egg_lottie_view);
                tBLottieAnimationView.setBackgroundResource(R.color.transparent);
                tBLottieAnimationView.setAnimationUrl(str);
                tBLottieAnimationView.x(true);
                tBLottieAnimationView.w(true);
                tBLottieAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.easterEgg.b.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ap.isEmpty(str2) && (view.getContext() instanceof TbPageContextSupport)) {
                            TiebaStatic.log(new am("c13451").P("obj_type", 1));
                            ba.aiz().c(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{str2});
                            return;
                        }
                        TiebaStatic.log(new am("c13451").P("obj_type", 2));
                        b.this.bcA();
                    }
                });
                tBLottieAnimationView.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.easterEgg.b.9
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        b.this.handler.removeCallbacksAndMessages(null);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        b.this.bcA();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        b.this.bcA();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                tBLottieAnimationView.bo();
                g(eN, inflate);
            }
        }
    }

    public void bcA() {
        if (this.eOI != null && this.eOI.isShowing()) {
            try {
                this.eOI.dismiss();
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static b eOO = new b();
    }

    private boolean ai(Activity activity) {
        return activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode"));
    }
}
