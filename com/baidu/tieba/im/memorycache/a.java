package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> duj = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0095a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0095a interfaceC0095a) {
        interfaceC0095a.a(this.duj.values().iterator());
    }

    public void aww() {
        this.duj.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.duj.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo mq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.duj.get(str);
    }

    public boolean mr(String str) {
        return (TextUtils.isEmpty(str) || this.duj.remove(str) == null) ? false : true;
    }
}
