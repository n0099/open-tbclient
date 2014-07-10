package com.baidu.tieba.im;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class c extends Handler {
    public c() {
        super(Looper.getMainLooper());
    }

    public synchronized <T> void a(T t, a<T> aVar) {
        post(new d(this, aVar, t));
    }
}
