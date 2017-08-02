package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> dsR = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0096a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0096a interfaceC0096a) {
        interfaceC0096a.a(this.dsR.values().iterator());
    }

    public void awl() {
        this.dsR.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.dsR.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo mm(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.dsR.get(str);
    }

    public boolean mn(String str) {
        return (TextUtils.isEmpty(str) || this.dsR.remove(str) == null) ? false : true;
    }
}
