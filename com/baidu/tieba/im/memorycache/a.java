package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> eNZ = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0239a {
        void b(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0239a interfaceC0239a) {
        interfaceC0239a.b(this.eNZ.values().iterator());
    }

    public void aQU() {
        this.eNZ.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.eNZ.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo pO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.eNZ.get(str);
    }

    public boolean pP(String str) {
        return (TextUtils.isEmpty(str) || this.eNZ.remove(str) == null) ? false : true;
    }
}
