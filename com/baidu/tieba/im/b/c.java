package com.baidu.tieba.im.b;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class c {
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final com.baidu.tieba.im.db.e b = new com.baidu.tieba.im.db.e();

    protected abstract void b();

    public final boolean c() {
        return this.a.get();
    }

    public final synchronized void d() {
        this.a.set(false);
        this.b.a();
        b();
        this.a.set(true);
    }

    public final void e() {
        this.b.a();
    }

    public final void a(ImMessageCenterPojo imMessageCenterPojo) {
        this.b.a(imMessageCenterPojo);
    }

    public final ImMessageCenterPojo a(String str) {
        return this.b.a(str);
    }

    public final void b(String str) {
        this.b.b(str);
    }

    public final void a(d dVar) {
        this.b.a(dVar);
    }
}
