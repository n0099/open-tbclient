package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> cmF = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0059a interfaceC0059a) {
        interfaceC0059a.a(this.cmF.values().iterator());
    }

    public void agY() {
        this.cmF.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.cmF.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo jC(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cmF.get(str);
    }

    public boolean jD(String str) {
        return (TextUtils.isEmpty(str) || this.cmF.remove(str) == null) ? false : true;
    }
}
