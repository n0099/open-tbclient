package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class d {
    private final ConcurrentHashMap<String, ImMessageCenterPojo> a = new ConcurrentHashMap<>();
    private final Object b = new Object();

    public void a(e eVar) {
        synchronized (this.b) {
            eVar.a(this.a.values().iterator());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
