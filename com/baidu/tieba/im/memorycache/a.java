package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> kHL = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0759a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0759a interfaceC0759a) {
        interfaceC0759a.a(this.kHL.values().iterator());
    }

    public void cWD() {
        this.kHL.clear();
    }

    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.kHL.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo MX(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.kHL.get(str);
    }

    public boolean MY(String str) {
        return (TextUtils.isEmpty(str) || this.kHL.remove(str) == null) ? false : true;
    }
}
