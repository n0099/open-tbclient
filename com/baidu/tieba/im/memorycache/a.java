package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> bzG = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0059a interfaceC0059a) {
        interfaceC0059a.a(this.bzG.values().iterator());
    }

    public void Vk() {
        this.bzG.clear();
    }

    public void b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.bzG.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo hR(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bzG.get(str);
    }

    public boolean hS(String str) {
        return (TextUtils.isEmpty(str) || this.bzG.remove(str) == null) ? false : true;
    }
}
