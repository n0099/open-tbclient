package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> hFn = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0533a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0533a interfaceC0533a) {
        interfaceC0533a.a(this.hFn.values().iterator());
    }

    public void bWF() {
        this.hFn.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.hFn.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo Dp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.hFn.get(str);
    }

    public boolean Dq(String str) {
        return (TextUtils.isEmpty(str) || this.hFn.remove(str) == null) ? false : true;
    }
}
