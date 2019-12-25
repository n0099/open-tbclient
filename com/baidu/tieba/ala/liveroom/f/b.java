package com.baidu.tieba.ala.liveroom.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.JsResult;
import com.baidu.live.q.a;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.c;
import com.baidu.live.view.web.e;
import com.baidu.live.view.web.f;
/* loaded from: classes2.dex */
public class b extends Dialog {
    private CommonWebLayout aBg;
    private View aBh;
    private e aBy;
    private a eUf;
    private RoundRectRelativeLayout eUg;
    private Activity mContext;

    /* loaded from: classes2.dex */
    public interface a {
        boolean a(String str, JsResult jsResult);
    }

    public b(@NonNull Activity activity) {
        super(activity, a.j.sdk_Transparent);
        this.mContext = activity;
        init();
    }

    public void a(a aVar) {
        this.eUf = aVar;
    }

    public void b(e eVar) {
        this.aBy = eVar;
    }

    public CommonWebLayout baV() {
        return this.aBg;
    }

    public void show(String str) {
        vr();
        show();
        this.aBg.loadUrl(str);
    }

    private void init() {
        initWindow();
        initView();
        qS();
    }

    private void initWindow() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.setGravity(80);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            if (windowManager != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (Build.VERSION.SDK_INT >= 17) {
                    windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                } else {
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                }
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = displayMetrics.widthPixels;
                attributes.height = (int) (displayMetrics.heightPixels * 0.4f);
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        float dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        this.eUg = new RoundRectRelativeLayout(this.mContext);
        this.eUg.setCornerRadius(dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f);
        initWebView();
        biU();
        setContentView(this.eUg);
    }

    private void initWebView() {
        this.aBg = new CommonWebLayout(this.mContext);
        this.aBg.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.f.b.1
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dV(String str) {
                if (b.this.aBh != null) {
                    b.this.aBh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void b(String str, int i, String str2) {
                if (b.this.aBh != null) {
                    b.this.aBh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void yL() {
                if (b.this.aBh != null) {
                    b.this.aBh.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean a(String str, JsResult jsResult) {
                if (b.this.eUf != null) {
                    return b.this.eUf.a(str, jsResult);
                }
                return true;
            }
        });
        f fVar = new f();
        fVar.x(this.mContext).a(this.aBy).a(this.aBg.getSchemeCallback());
        com.baidu.live.view.web.a[] yO = fVar.yO();
        for (com.baidu.live.view.web.a aVar : yO) {
            this.aBg.addJavascriptInterface(aVar, aVar.getName());
        }
        this.eUg.addView(this.aBg, new ViewGroup.LayoutParams(-1, -1));
    }

    private void biU() {
        this.aBh = LayoutInflater.from(this.mContext).inflate(a.h.live_commerce_web_goods_progress, (ViewGroup) null);
        this.eUg.addView(this.aBh, new ViewGroup.LayoutParams(-1, -1));
    }

    private void qS() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.f.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.aBg != null) {
                    b.this.aBg.release();
                }
            }
        });
    }

    private void vr() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        if (this.eUg != null) {
            this.eUg.startAnimation(translateAnimation);
        }
    }
}
