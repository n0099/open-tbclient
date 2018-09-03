package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> exF = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0177a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0177a interfaceC0177a) {
        interfaceC0177a.a(this.exF.values().iterator());
    }

    public void aLT() {
        this.exF.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.exF.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo oG(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.exF.get(str);
    }

    public boolean oH(String str) {
        return (TextUtils.isEmpty(str) || this.exF.remove(str) == null) ? false : true;
    }
}
