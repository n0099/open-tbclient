package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> iqX = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0592a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0592a interfaceC0592a) {
        interfaceC0592a.a(this.iqX.values().iterator());
    }

    public void chA() {
        this.iqX.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.iqX.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo Fb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.iqX.get(str);
    }

    public boolean Fc(String str) {
        return (TextUtils.isEmpty(str) || this.iqX.remove(str) == null) ? false : true;
    }
}
