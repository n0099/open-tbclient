package com.baidu.tieba.im;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public final class n extends Handler {
    public n() {
        super(Looper.getMainLooper());
    }

    public final synchronized <T> void a(T t, a<T> aVar) {
        post(new o(this, aVar, t));
    }
}
