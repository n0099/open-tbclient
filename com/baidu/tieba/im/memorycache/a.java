package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> gLH = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0440a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0440a interfaceC0440a) {
        interfaceC0440a.a(this.gLH.values().iterator());
    }

    public void bCI() {
        this.gLH.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.gLH.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo yg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.gLH.get(str);
    }

    public boolean yh(String str) {
        return (TextUtils.isEmpty(str) || this.gLH.remove(str) == null) ? false : true;
    }
}
