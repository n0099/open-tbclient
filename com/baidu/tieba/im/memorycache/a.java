package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> eYs = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0250a {
        void b(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0250a interfaceC0250a) {
        interfaceC0250a.b(this.eYs.values().iterator());
    }

    public void aTZ() {
        this.eYs.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.eYs.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo qJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.eYs.get(str);
    }

    public boolean qK(String str) {
        return (TextUtils.isEmpty(str) || this.eYs.remove(str) == null) ? false : true;
    }
}
