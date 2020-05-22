package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> iFD = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0642a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0642a interfaceC0642a) {
        interfaceC0642a.a(this.iFD.values().iterator());
    }

    public void cnX() {
        this.iFD.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.iFD.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo GK(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.iFD.get(str);
    }

    public boolean GL(String str) {
        return (TextUtils.isEmpty(str) || this.iFD.remove(str) == null) ? false : true;
    }
}
