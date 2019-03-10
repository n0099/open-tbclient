package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> goA = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0257a {
        void b(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0257a interfaceC0257a) {
        interfaceC0257a.b(this.goA.values().iterator());
    }

    public void buE() {
        this.goA.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.goA.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo xp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.goA.get(str);
    }

    public boolean xq(String str) {
        return (TextUtils.isEmpty(str) || this.goA.remove(str) == null) ? false : true;
    }
}
