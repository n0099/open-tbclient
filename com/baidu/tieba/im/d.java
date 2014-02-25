package com.baidu.tieba.im;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class d extends Handler {
    public d() {
        super(Looper.getMainLooper());
    }

    public synchronized <T> void a(T t, a<T> aVar) {
        post(new e(this, aVar, t));
    }
}
