package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> klr = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0765a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0765a interfaceC0765a) {
        interfaceC0765a.a(this.klr.values().iterator());
    }

    public void cTp() {
        this.klr.clear();
    }

    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.klr.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo MB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.klr.get(str);
    }

    public boolean MC(String str) {
        return (TextUtils.isEmpty(str) || this.klr.remove(str) == null) ? false : true;
    }
}
