package com.baidu.tieba.im.floatwindow.a;

import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class a {
    private static a aYZ;
    private final b aZa = new b(this, Looper.getMainLooper());

    private a() {
    }

    public static a NL() {
        if (aYZ == null) {
            aYZ = new a();
        }
        return aYZ;
    }

    public void a(c cVar) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = cVar;
        this.aZa.sendMessage(obtain);
    }
}
