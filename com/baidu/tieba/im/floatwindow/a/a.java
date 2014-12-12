package com.baidu.tieba.im.floatwindow.a;

import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class a {
    private static a aXD;
    private final b aXE = new b(this, Looper.getMainLooper());

    private a() {
    }

    public static a Np() {
        if (aXD == null) {
            aXD = new a();
        }
        return aXD;
    }

    public void a(c cVar) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = cVar;
        this.aXE.sendMessage(obtain);
    }
}
