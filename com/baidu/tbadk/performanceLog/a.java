package com.baidu.tbadk.performanceLog;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.a.a.a {
    private d aoo;
    private c aop = null;
    private WindowManager mWindowManager;

    public a(Context context) {
        this.aoo = null;
        this.mWindowManager = null;
        this.aoo = new d(this, context);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            this.mWindowManager.removeView(this.aoo);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
        layoutParams.gravity = 51;
        layoutParams.height = 1;
        layoutParams.width = 1;
        try {
            this.mWindowManager.removeView(this.aoo);
        } catch (Exception e) {
        }
        this.mWindowManager.addView(this.aoo, layoutParams);
        new Handler(Looper.getMainLooper()).post(new b(this));
    }

    public void a(c cVar) {
        if (this.aop == null) {
            this.aop = cVar;
        }
    }
}
