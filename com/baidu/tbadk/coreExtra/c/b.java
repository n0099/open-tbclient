package com.baidu.tbadk.coreExtra.c;

import android.os.Handler;
import android.os.SystemClock;
/* loaded from: classes.dex */
public abstract class b {
    private long a;
    private final long b;
    private long c;
    private Handler d = new c(this);

    public abstract void a(long j);

    public abstract void c();

    public b(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final void a() {
        this.d.removeMessages(1);
    }

    public final synchronized b b() {
        b bVar;
        if (this.a <= 0) {
            c();
            bVar = this;
        } else {
            this.c = SystemClock.elapsedRealtime() + this.a;
            this.d.sendMessage(this.d.obtainMessage(1));
            bVar = this;
        }
        return bVar;
    }
}
