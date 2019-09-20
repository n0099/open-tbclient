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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b {
    private Runnable cSX;
    private PopupWindow eVv;
    private com.baidu.tieba.tbadkCore.e.a eVw;
    private ActivityLifeCycleListener eVx;
    private com.baidu.tieba.tbadkCore.e.c eVy;
    private Handler handler;

    private b() {
        this.handler = new Handler();
        this.eVy = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.easterEgg.b.1
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                return b.this.eVw != null && b.this.eVw.a(str, jsPromptResult);
            }
        };
        this.cSX = new Runnable() { // from class: com.baidu.tieba.easterEgg.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.handler.removeCallbacksAndMessages(null);
                b.this.bfh();
            }
        };
        this.eVw = new com.baidu.tieba.tbadkCore.e.a();
        this.eVw.a(new com.baidu.tieba.easterEgg.a());
        this.eVx = new ActivityLifeCycleListener();
    }

    public static b bfg() {
        return a.eVB;
    }

    private void g(Activity activity, View view) {
        this.eVv = new PopupWindow(activity);
        this.eVv.setBackgroundDrawable(new ColorDrawable(0));
        this.eVv.setWidth(l.af(activity));
        this.eVv.setHeight(l.ah(activity));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.eVv.setContentView(view);
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(this.cSX, 5000L);
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null) {
            fragmentManager.beginTransaction().add(this.eVx, "LIFE_CYCLE").commitAllowingStateLoss();
        }
        this.eVv.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.easterEgg.b.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                b.this.eVv = null;
            }
        });
        try {
            this.eVv.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
            TiebaStatic.log(new an("c13126"));
        } catch (Throwable th) {
        }
    }

    public void wq(final String str) {
        Activity eU;
        if (!aq.isEmpty(str) && (eU = com.baidu.adp.base.a.eT().eU()) != null && eU.getWindow() != null && eU.getWindow().getDecorView() != null) {
            if (al(eU)) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.wq(str);
                        } catch (Throwable th) {
                            b.this.bfh();
                        }
                    }
                }, 1000L);
                return;
            }
            if (this.eVv != null && this.eVv.isShowing()) {
                if (this.eVv.getContentView() == null || this.eVv.getContentView().getContext() != eU) {
                    bfh();
                } else {
                    return;
                }
            }
            View inflate = LayoutInflater.from(eU).inflate(R.layout.easter_egg_dialog_h5_layout, (ViewGroup) null);
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
                    b.this.bfh();
                }
            });
            baseWebView.setBackgroundColor(0);
            baseWebView.setOnJsPromptCallback(this.eVy);
            g(eU, inflate);
        }
    }

    public void cN(final String str, final String str2) {
        Activity eU;
        if (!aq.isEmpty(str)) {
            if ((this.eVv == null || !this.eVv.isShowing()) && (eU = com.baidu.adp.base.a.eT().eU()) != null && ab.cB(eU)) {
                if (al(eU)) {
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.easterEgg.b.7
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.cN(str, str2);
                            } catch (Throwable th) {
                                b.this.bfh();
                            }
                        }
                    }, 1000L);
                    return;
                }
                View inflate = LayoutInflater.from(eU).inflate(R.layout.easter_egg_dialog_lottie_layout, (ViewGroup) null);
                inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) inflate.findViewById(R.id.easter_egg_lottie_view);
                tBLottieAnimationView.setBackgroundResource(R.color.transparent);
                tBLottieAnimationView.setAnimationUrl(str);
                tBLottieAnimationView.x(true);
                tBLottieAnimationView.w(true);
                tBLottieAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.easterEgg.b.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!aq.isEmpty(str2) && (view.getContext() instanceof TbPageContextSupport)) {
                            TiebaStatic.log(new an("c13451").P("obj_type", 1));
                            ba.ajK().c(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{str2});
                            return;
                        }
                        TiebaStatic.log(new an("c13451").P("obj_type", 2));
                        b.this.bfh();
                    }
                });
                tBLottieAnimationView.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.easterEgg.b.9
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        b.this.handler.removeCallbacksAndMessages(null);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        b.this.bfh();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        b.this.bfh();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                tBLottieAnimationView.br();
                g(eU, inflate);
            }
        }
    }

    public void bfh() {
        if (this.eVv != null && this.eVv.isShowing()) {
            try {
                this.eVv.dismiss();
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static b eVB = new b();
    }

    private boolean al(Activity activity) {
        return activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode"));
    }
}
