package com.baidu.tieba.im.b;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class c {
    final AtomicBoolean a = new AtomicBoolean(false);
    protected final com.baidu.tieba.im.db.e b = new com.baidu.tieba.im.db.e();

    protected abstract void b();

    public abstract void d();

    public synchronized void e() {
        this.a.set(false);
        this.b.a();
        b();
        this.a.set(true);
    }

    public synchronized void f() {
        d();
    }

    public void g() {
        this.b.a();
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        this.b.a(imMessageCenterPojo);
    }

    public ImMessageCenterPojo a(String str) {
        return this.b.a(str);
    }

    public void b(String str) {
        this.b.b(str);
    }

    public void a(d dVar) {
        this.b.a(dVar);
    }
}
