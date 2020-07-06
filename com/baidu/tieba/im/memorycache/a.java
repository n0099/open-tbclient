package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> iXt = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0655a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0655a interfaceC0655a) {
        interfaceC0655a.a(this.iXt.values().iterator());
    }

    public void crW() {
        this.iXt.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.iXt.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo Hm(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.iXt.get(str);
    }

    public boolean Hn(String str) {
        return (TextUtils.isEmpty(str) || this.iXt.remove(str) == null) ? false : true;
    }
}
