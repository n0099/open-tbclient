package com.baidu.tbadk.coreExtra.c;

import android.os.Handler;
import android.os.SystemClock;
/* loaded from: classes.dex */
public abstract class c {
    private long a;
    private final long b;
    private long c;
    private Handler d = new d(this);

    public abstract void a(long j);

    public abstract void c();

    public c(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final void a() {
        this.d.removeMessages(1);
    }

    public final synchronized c b() {
        c cVar;
        if (this.a <= 0) {
            c();
            cVar = this;
        } else {
            this.c = SystemClock.elapsedRealtime() + this.a;
            this.d.sendMessage(this.d.obtainMessage(1));
            cVar = this;
        }
        return cVar;
    }
}
