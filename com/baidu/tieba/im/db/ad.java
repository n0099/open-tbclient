package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class ad {

    /* renamed from: a  reason: collision with root package name */
    private static ad f1653a;
    private volatile String b = "";
    private AtomicBoolean c = new AtomicBoolean(false);
    private ConcurrentHashMap<String, ImMessageCenterPojo> d = new ConcurrentHashMap<>();

    private ad() {
    }

    public static synchronized ad a() {
        ad adVar;
        synchronized (ad.class) {
            if (f1653a == null) {
                f1653a = new ad();
            }
            adVar = f1653a;
        }
        return adVar;
    }

    public synchronized void a(com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> aVar) {
        if (Thread.currentThread().getId() != com.baidu.tieba.im.i.f1785a) {
            com.baidu.adp.lib.h.e.a("!!!!!!!!!!!!!!!获取缓存不是在主线程里面执行了！");
            if (com.baidu.tieba.data.h.s()) {
                new RuntimeException().printStackTrace();
            }
        }
        if (aVar != null) {
            d();
            if (this.c.get()) {
                aVar.a(this.d);
            } else {
                b(new ae(this, aVar));
            }
        }
    }

    public synchronized ConcurrentHashMap<String, ImMessageCenterPojo> b() {
        d();
        return this.d;
    }

    private void b(com.baidu.tieba.im.a<LinkedList<ImMessageCenterPojo>> aVar) {
        d();
        com.baidu.tieba.im.m.a(new af(this), aVar);
    }

    private synchronized void d() {
        String B = TiebaApplication.B();
        if (TextUtils.isEmpty(B) || !B.equals(this.b)) {
            this.d.clear();
            this.b = B;
            this.c.set(false);
        }
    }

    public void c() {
        this.c.set(false);
        this.b = null;
        this.d.clear();
    }
}
