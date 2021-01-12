package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> kzG = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0757a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0757a interfaceC0757a) {
        interfaceC0757a.a(this.kzG.values().iterator());
    }

    public void cUF() {
        this.kzG.clear();
    }

    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.kzG.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo Mi(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.kzG.get(str);
    }

    public boolean Mj(String str) {
        return (TextUtils.isEmpty(str) || this.kzG.remove(str) == null) ? false : true;
    }
}
