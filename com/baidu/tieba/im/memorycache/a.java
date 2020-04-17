package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> iqR = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0571a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0571a interfaceC0571a) {
        interfaceC0571a.a(this.iqR.values().iterator());
    }

    public void chB() {
        this.iqR.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.iqR.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo EY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.iqR.get(str);
    }

    public boolean EZ(String str) {
        return (TextUtils.isEmpty(str) || this.iqR.remove(str) == null) ? false : true;
    }
}
