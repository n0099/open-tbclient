package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> eIX = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0176a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0176a interfaceC0176a) {
        interfaceC0176a.a(this.eIX.values().iterator());
    }

    public void aKz() {
        this.eIX.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.eIX.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo nG(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.eIX.get(str);
    }

    public boolean nH(String str) {
        return (TextUtils.isEmpty(str) || this.eIX.remove(str) == null) ? false : true;
    }
}
