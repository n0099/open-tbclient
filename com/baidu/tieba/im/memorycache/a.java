package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> gom = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0318a {
        void b(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0318a interfaceC0318a) {
        interfaceC0318a.b(this.gom.values().iterator());
    }

    public void buA() {
        this.gom.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.gom.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo xm(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.gom.get(str);
    }

    public boolean xn(String str) {
        return (TextUtils.isEmpty(str) || this.gom.remove(str) == null) ? false : true;
    }
}
