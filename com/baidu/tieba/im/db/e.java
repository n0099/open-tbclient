package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class e {
    private ConcurrentHashMap<String, ImMessageCenterPojo> a = new ConcurrentHashMap<>();
    private final Object b = new Object();

    public void a(File file) {
    }

    public void b(File file) {
    }

    public void a(com.baidu.tieba.im.b.d dVar) {
        synchronized (this.b) {
            for (ImMessageCenterPojo imMessageCenterPojo : this.a.values()) {
                dVar.a(imMessageCenterPojo);
            }
        }
    }

    public void a() {
        synchronized (this.b) {
            this.a.clear();
        }
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            synchronized (this.b) {
                this.a.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
            }
        }
    }

    public ImMessageCenterPojo a(String str) {
        return this.a.get(str);
    }

    public boolean b(String str) {
        if (str != null) {
            synchronized (this.b) {
                r0 = this.a.remove(str) != null;
            }
        }
        return r0;
    }
}
