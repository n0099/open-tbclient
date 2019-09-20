package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> gOx = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0351a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0351a interfaceC0351a) {
        interfaceC0351a.a(this.gOx.values().iterator());
    }

    public void bFZ() {
        this.gOx.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.gOx.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo zO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.gOx.get(str);
    }

    public boolean zP(String str) {
        return (TextUtils.isEmpty(str) || this.gOx.remove(str) == null) ? false : true;
    }
}
