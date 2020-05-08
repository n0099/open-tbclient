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
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.u.a;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.c;
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
/* loaded from: classes3.dex */
public class b extends Dialog {
    private f bcG;
    private CommonWebLayout bck;
    private View bcl;
    private Activity caN;
    private a fEK;
    private RoundRectRelativeLayout fEL;

    /* loaded from: classes3.dex */
    public interface a {
        boolean a(String str, JsResult jsResult);
    }

    public b(@NonNull Activity activity) {
        super(activity, a.j.sdk_Transparent);
        this.caN = activity;
        init();
    }

    public void a(a aVar) {
        this.fEK = aVar;
    }

    public void b(f fVar) {
        this.bcG = fVar;
    }

    public CommonWebLayout bmC() {
        return this.bck;
    }

    public void show(String str) {
        CA();
        show();
        this.bck.loadUrl(str);
        ShowUtil.windowCount++;
    }

    private void init() {
        Dh();
        initView();
        wC();
    }

    private void Dh() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.setGravity(80);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager windowManager = (WindowManager) this.caN.getSystemService("window");
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
        float dimensionPixelOffset = this.caN.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        this.fEL = new RoundRectRelativeLayout(this.caN);
        this.fEL.setCornerRadius(dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f);
        initWebView();
        buU();
        setContentView(this.fEL);
    }

    private void initWebView() {
        this.bck = new CommonWebLayout(this.caN);
        this.bck.setCallback(new c() { // from class: com.baidu.tieba.ala.liveroom.f.b.1
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fe(String str) {
                if (b.this.bcl != null) {
                    b.this.bcl.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                if (b.this.bcl != null) {
                    b.this.bcl.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void HJ() {
                if (b.this.bcl != null) {
                    b.this.bcl.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean a(String str, JsResult jsResult) {
                if (b.this.fEK != null) {
                    return b.this.fEK.a(str, jsResult);
                }
                return true;
            }
        });
        g gVar = new g();
        gVar.u(this.caN).a(this.bcG).a(this.bck.getSchemeCallback());
        com.baidu.live.view.web.a[] HM = gVar.HM();
        for (com.baidu.live.view.web.a aVar : HM) {
            this.bck.addJavascriptInterface(aVar, aVar.getName());
        }
        this.fEL.addView(this.bck, new ViewGroup.LayoutParams(-1, -1));
    }

    private void buU() {
        this.bcl = LayoutInflater.from(this.caN).inflate(a.h.live_commerce_web_goods_progress, (ViewGroup) null);
        this.fEL.addView(this.bcl, new ViewGroup.LayoutParams(-1, -1));
    }

    private void wC() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.f.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bck != null) {
                    b.this.bck.release();
                }
                if (ShowUtil.windowCount > 0) {
                    ShowUtil.windowCount--;
                }
            }
        });
    }

    private void CA() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        if (this.fEL != null) {
            this.fEL.startAnimation(translateAnimation);
        }
    }
}
