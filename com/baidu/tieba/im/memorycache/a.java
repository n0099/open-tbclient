package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> bAn = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0059a interfaceC0059a) {
        interfaceC0059a.a(this.bAn.values().iterator());
    }

    public void Vm() {
        this.bAn.clear();
    }

    public void b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.bAn.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo ia(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bAn.get(str);
    }

    public boolean ib(String str) {
        return (TextUtils.isEmpty(str) || this.bAn.remove(str) == null) ? false : true;
    }
}
