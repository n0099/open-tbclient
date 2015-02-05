package com.baidu.tieba.im.floatwindow.a;

import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class a {
    private static a aYY;
    private final b aYZ = new b(this, Looper.getMainLooper());

    private a() {
    }

    public static a NG() {
        if (aYY == null) {
            aYY = new a();
        }
        return aYY;
    }

    public void a(c cVar) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = cVar;
        this.aYZ.sendMessage(obtain);
    }
}
