package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> jDn = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0715a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0715a interfaceC0715a) {
        interfaceC0715a.a(this.jDn.values().iterator());
    }

    public void cKs() {
        this.jDn.clear();
    }

    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.jDn.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo Lw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.jDn.get(str);
    }

    public boolean Lx(String str) {
        return (TextUtils.isEmpty(str) || this.jDn.remove(str) == null) ? false : true;
    }
}
