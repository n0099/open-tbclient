package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> eEX = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0179a {
        void b(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0179a interfaceC0179a) {
        interfaceC0179a.b(this.eEX.values().iterator());
    }

    public void aOi() {
        this.eEX.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.eEX.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo pl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.eEX.get(str);
    }

    public boolean pm(String str) {
        return (TextUtils.isEmpty(str) || this.eEX.remove(str) == null) ? false : true;
    }
}
