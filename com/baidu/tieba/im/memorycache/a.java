package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> kyN = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0781a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0781a interfaceC0781a) {
        interfaceC0781a.a(this.kyN.values().iterator());
    }

    public void cYB() {
        this.kyN.clear();
    }

    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.kyN.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo NJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.kyN.get(str);
    }

    public boolean NK(String str) {
        return (TextUtils.isEmpty(str) || this.kyN.remove(str) == null) ? false : true;
    }
}
