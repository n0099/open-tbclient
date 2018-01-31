package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> eEA = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0122a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0122a interfaceC0122a) {
        interfaceC0122a.a(this.eEA.values().iterator());
    }

    public void aIY() {
        this.eEA.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.eEA.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo nv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.eEA.get(str);
    }

    public boolean nw(String str) {
        return (TextUtils.isEmpty(str) || this.eEA.remove(str) == null) ? false : true;
    }
}
