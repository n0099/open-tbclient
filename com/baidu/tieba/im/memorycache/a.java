package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> cZI = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0066a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0066a interfaceC0066a) {
        interfaceC0066a.a(this.cZI.values().iterator());
    }

    public void asM() {
        this.cZI.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.cZI.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo lb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cZI.get(str);
    }

    public boolean lc(String str) {
        return (TextUtils.isEmpty(str) || this.cZI.remove(str) == null) ? false : true;
    }
}
