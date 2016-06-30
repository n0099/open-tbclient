package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> cRU = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0064a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0064a interfaceC0064a) {
        interfaceC0064a.a(this.cRU.values().iterator());
    }

    public void apl() {
        this.cRU.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.cRU.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo kV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cRU.get(str);
    }

    public boolean kW(String str) {
        return (TextUtils.isEmpty(str) || this.cRU.remove(str) == null) ? false : true;
    }
}
