package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> dzT = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0097a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0097a interfaceC0097a) {
        interfaceC0097a.a(this.dzT.values().iterator());
    }

    public void axK() {
        this.dzT.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.dzT.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo mx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.dzT.get(str);
    }

    public boolean my(String str) {
        return (TextUtils.isEmpty(str) || this.dzT.remove(str) == null) ? false : true;
    }
}
