package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> dQt = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0111a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0111a interfaceC0111a) {
        interfaceC0111a.a(this.dQt.values().iterator());
    }

    public void aBM() {
        this.dQt.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.dQt.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo nc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.dQt.get(str);
    }

    public boolean nd(String str) {
        return (TextUtils.isEmpty(str) || this.dQt.remove(str) == null) ? false : true;
    }
}
