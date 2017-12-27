package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> eCF = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0122a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0122a interfaceC0122a) {
        interfaceC0122a.a(this.eCF.values().iterator());
    }

    public void aIO() {
        this.eCF.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.eCF.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo nl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.eCF.get(str);
    }

    public boolean nm(String str) {
        return (TextUtils.isEmpty(str) || this.eCF.remove(str) == null) ? false : true;
    }
}
