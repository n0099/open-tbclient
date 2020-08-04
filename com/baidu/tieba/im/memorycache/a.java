package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> jfF = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0666a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0666a interfaceC0666a) {
        interfaceC0666a.a(this.jfF.values().iterator());
    }

    public void cvU() {
        this.jfF.clear();
    }

    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.jfF.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo Ib(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.jfF.get(str);
    }

    public boolean Ic(String str) {
        return (TextUtils.isEmpty(str) || this.jfF.remove(str) == null) ? false : true;
    }
}
