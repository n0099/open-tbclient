package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> kKb = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0766a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0766a interfaceC0766a) {
        interfaceC0766a.a(this.kKb.values().iterator());
    }

    public void cWR() {
        this.kKb.clear();
    }

    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.kKb.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo Ne(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.kKb.get(str);
    }

    public boolean Nf(String str) {
        return (TextUtils.isEmpty(str) || this.kKb.remove(str) == null) ? false : true;
    }
}
