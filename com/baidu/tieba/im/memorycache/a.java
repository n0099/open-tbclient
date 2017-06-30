package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> dkn = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0070a interfaceC0070a) {
        interfaceC0070a.a(this.dkn.values().iterator());
    }

    public void auG() {
        this.dkn.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.dkn.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo lW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.dkn.get(str);
    }

    public boolean lX(String str) {
        return (TextUtils.isEmpty(str) || this.dkn.remove(str) == null) ? false : true;
    }
}
