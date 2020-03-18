package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> hHb = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0534a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0534a interfaceC0534a) {
        interfaceC0534a.a(this.hHb.values().iterator());
    }

    public void bXa() {
        this.hHb.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.hHb.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo Dp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.hHb.get(str);
    }

    public boolean Dq(String str) {
        return (TextUtils.isEmpty(str) || this.hHb.remove(str) == null) ? false : true;
    }
}
