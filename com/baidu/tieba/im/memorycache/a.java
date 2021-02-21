package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> kHZ = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0760a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0760a interfaceC0760a) {
        interfaceC0760a.a(this.kHZ.values().iterator());
    }

    public void cWK() {
        this.kHZ.clear();
    }

    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.kHZ.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo MY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.kHZ.get(str);
    }

    public boolean MZ(String str) {
        return (TextUtils.isEmpty(str) || this.kHZ.remove(str) == null) ? false : true;
    }
}
