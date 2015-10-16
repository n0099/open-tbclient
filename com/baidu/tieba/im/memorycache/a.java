package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> bDA = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0059a interfaceC0059a) {
        interfaceC0059a.a(this.bDA.values().iterator());
    }

    public void VV() {
        this.bDA.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.bDA.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo ie(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bDA.get(str);
    }

    public boolean ig(String str) {
        return (TextUtils.isEmpty(str) || this.bDA.remove(str) == null) ? false : true;
    }
}
