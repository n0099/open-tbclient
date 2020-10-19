package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> jSk = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0733a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0733a interfaceC0733a) {
        interfaceC0733a.a(this.jSk.values().iterator());
    }

    public void cOb() {
        this.jSk.clear();
    }

    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.jSk.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo Ml(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.jSk.get(str);
    }

    public boolean Mm(String str) {
        return (TextUtils.isEmpty(str) || this.jSk.remove(str) == null) ? false : true;
    }
}
