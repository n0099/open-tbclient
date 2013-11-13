package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private static x f1631a;
    private volatile String b = "";
    private AtomicBoolean c = new AtomicBoolean(false);
    private ConcurrentHashMap<String, ImMessageCenterPojo> d = new ConcurrentHashMap<>();

    private x() {
    }

    public static synchronized x a() {
        x xVar;
        synchronized (x.class) {
            if (f1631a == null) {
                f1631a = new x();
            }
            xVar = f1631a;
        }
        return xVar;
    }

    public void a(com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> aVar) {
        if (Thread.currentThread().getId() != com.baidu.tieba.im.i.f1721a) {
            com.baidu.adp.lib.h.d.a("!!!!!!!!!!!!!!!获取缓存不是在主线程里面执行了！");
            try {
                throw new RuntimeException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (aVar != null) {
            c();
            if (this.c.get()) {
                aVar.a(this.d);
            } else {
                b(new y(this, aVar));
            }
        }
    }

    private void b(com.baidu.tieba.im.a<LinkedList<ImMessageCenterPojo>> aVar) {
        c();
        com.baidu.tieba.im.m.a(new z(this), aVar);
    }

    private synchronized void c() {
        String A = TiebaApplication.A();
        if (TextUtils.isEmpty(A) || !A.equals(this.b)) {
            this.d.clear();
            this.b = A;
            this.c.set(false);
        }
    }

    public void b() {
        this.c.set(false);
        this.b = null;
        this.d.clear();
    }
}
