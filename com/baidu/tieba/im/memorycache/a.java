package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> juL = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0718a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0718a interfaceC0718a) {
        interfaceC0718a.a(this.juL.values().iterator());
    }

    public void cGM() {
        this.juL.clear();
    }

    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.juL.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo KU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.juL.get(str);
    }

    public boolean KV(String str) {
        return (TextUtils.isEmpty(str) || this.juL.remove(str) == null) ? false : true;
    }
}
