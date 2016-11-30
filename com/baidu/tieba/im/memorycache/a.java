package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> dnE = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0067a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0067a interfaceC0067a) {
        interfaceC0067a.a(this.dnE.values().iterator());
    }

    public void axh() {
        this.dnE.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.dnE.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo ml(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.dnE.get(str);
    }

    public boolean mm(String str) {
        return (TextUtils.isEmpty(str) || this.dnE.remove(str) == null) ? false : true;
    }
}
