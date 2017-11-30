package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> dPo = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0096a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0096a interfaceC0096a) {
        interfaceC0096a.a(this.dPo.values().iterator());
    }

    public void aBE() {
        this.dPo.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.dPo.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo nc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.dPo.get(str);
    }

    public boolean nd(String str) {
        return (TextUtils.isEmpty(str) || this.dPo.remove(str) == null) ? false : true;
    }
}
