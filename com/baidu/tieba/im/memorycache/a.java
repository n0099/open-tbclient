package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> kEl = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0774a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0774a interfaceC0774a) {
        interfaceC0774a.a(this.kEl.values().iterator());
    }

    public void cYx() {
        this.kEl.clear();
    }

    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.kEl.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo Nq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.kEl.get(str);
    }

    public boolean Nr(String str) {
        return (TextUtils.isEmpty(str) || this.kEl.remove(str) == null) ? false : true;
    }
}
