package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> eXF = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0250a {
        void b(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0250a interfaceC0250a) {
        interfaceC0250a.b(this.eXF.values().iterator());
    }

    public void aTz() {
        this.eXF.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.eXF.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo qt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.eXF.get(str);
    }

    public boolean qu(String str) {
        return (TextUtils.isEmpty(str) || this.eXF.remove(str) == null) ? false : true;
    }
}
