package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> etR = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0178a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0178a interfaceC0178a) {
        interfaceC0178a.a(this.etR.values().iterator());
    }

    public void aKV() {
        this.etR.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.etR.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo oC(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.etR.get(str);
    }

    public boolean oD(String str) {
        return (TextUtils.isEmpty(str) || this.etR.remove(str) == null) ? false : true;
    }
}
