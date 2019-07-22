package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> gLN = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0334a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0334a interfaceC0334a) {
        interfaceC0334a.a(this.gLN.values().iterator());
    }

    public void bEX() {
        this.gLN.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.gLN.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo zo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.gLN.get(str);
    }

    public boolean zp(String str) {
        return (TextUtils.isEmpty(str) || this.gLN.remove(str) == null) ? false : true;
    }
}
