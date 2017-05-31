package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> dcp = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0067a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0067a interfaceC0067a) {
        interfaceC0067a.a(this.dcp.values().iterator());
    }

    public void aqV() {
        this.dcp.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.dcp.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo kX(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.dcp.get(str);
    }

    public boolean kY(String str) {
        return (TextUtils.isEmpty(str) || this.dcp.remove(str) == null) ? false : true;
    }
}
