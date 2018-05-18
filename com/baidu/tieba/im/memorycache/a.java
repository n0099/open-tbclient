package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> eeK = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0160a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0160a interfaceC0160a) {
        interfaceC0160a.a(this.eeK.values().iterator());
    }

    public void aFu() {
        this.eeK.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.eeK.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo nN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.eeK.get(str);
    }

    public boolean nO(String str) {
        return (TextUtils.isEmpty(str) || this.eeK.remove(str) == null) ? false : true;
    }
}
