package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class e {
    private final ConcurrentHashMap<String, ImMessageCenterPojo> a = new ConcurrentHashMap<>();
    private final Object b = new Object();

    public final void a(com.baidu.tieba.im.b.d dVar) {
        synchronized (this.b) {
            for (ImMessageCenterPojo imMessageCenterPojo : this.a.values()) {
                dVar.a(imMessageCenterPojo);
            }
        }
    }

    public final void a() {
        synchronized (this.b) {
            this.a.clear();
        }
    }

    public final void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return;
        }
        synchronized (this.b) {
            this.a.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public final ImMessageCenterPojo a(String str) {
        return this.a.get(str);
    }

    public final boolean b(String str) {
        if (str != null) {
            synchronized (this.b) {
                r0 = this.a.remove(str) != null;
            }
        }
        return r0;
    }
}
