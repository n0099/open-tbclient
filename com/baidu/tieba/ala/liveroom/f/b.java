package com.baidu.tieba.ala.liveroom.f;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.JsResult;
import com.baidu.live.k.a;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.c;
import com.baidu.live.view.web.e;
import com.baidu.live.view.web.f;
/* loaded from: classes6.dex */
public class b extends Dialog {
    private e atC;
    private CommonWebLayout atm;
    private View atn;
    private a eek;
    private RoundRectRelativeLayout eel;
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        boolean a(String str, JsResult jsResult);
    }

    public b(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        this.mContext = context;
        init();
    }

    public void a(a aVar) {
        this.eek = aVar;
    }

    public void b(e eVar) {
        this.atC = eVar;
    }

    public CommonWebLayout aNC() {
        return this.atm;
    }

    public void tD(String str) {
        tx();
        show();
        this.atm.loadUrl(str);
    }

    private void init() {
        wD();
        initView();
        pv();
    }

    private void wD() {
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
        this.eel = new RoundRectRelativeLayout(this.mContext);
        this.eel.setCornerRadius(dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f);
        initWebView();
        aRt();
        setContentView(this.eel);
    }

    private void initWebView() {
        this.atm = new CommonWebLayout(this.mContext);
        this.atm.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.f.b.1
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void db(String str) {
                if (b.this.atn != null) {
                    b.this.atn.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void b(String str, int i, String str2) {
                if (b.this.atn != null) {
                    b.this.atn.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void wM() {
                if (b.this.atn != null) {
                    b.this.atn.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean a(String str, JsResult jsResult) {
                Log.e("Da88", "onJsConfirm-1 = " + str);
                if (b.this.eek != null) {
                    return b.this.eek.a(str, jsResult);
                }
                return true;
            }
        });
        f fVar = new f();
        fVar.az(this.mContext).a(this.atC).a(this.atm.getSchemeCallback());
        com.baidu.live.view.web.a[] wP = fVar.wP();
        for (com.baidu.live.view.web.a aVar : wP) {
            this.atm.addJavascriptInterface(aVar, aVar.getName());
        }
        this.eel.addView(this.atm, new ViewGroup.LayoutParams(-1, -1));
    }

    private void aRt() {
        this.atn = LayoutInflater.from(this.mContext).inflate(a.h.live_commerce_web_goods_progress, (ViewGroup) null);
        this.eel.addView(this.atn, new ViewGroup.LayoutParams(-1, -1));
    }

    private void pv() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.f.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.atm != null) {
                    b.this.atm.release();
                }
            }
        });
    }

    private void tx() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        if (this.eel != null) {
            this.eel.startAnimation(translateAnimation);
        }
    }
}
