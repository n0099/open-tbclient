package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> bTb = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0067a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0067a interfaceC0067a) {
        interfaceC0067a.a(this.bTb.values().iterator());
    }

    public void Zs() {
        this.bTb.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.bTb.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo iB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bTb.get(str);
    }

    public boolean iC(String str) {
        return (TextUtils.isEmpty(str) || this.bTb.remove(str) == null) ? false : true;
    }
}
