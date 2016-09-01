package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> dgz = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0065a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0065a interfaceC0065a) {
        interfaceC0065a.a(this.dgz.values().iterator());
    }

    public void auL() {
        this.dgz.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.dgz.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo lL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.dgz.get(str);
    }

    public boolean lM(String str) {
        return (TextUtils.isEmpty(str) || this.dgz.remove(str) == null) ? false : true;
    }
}
