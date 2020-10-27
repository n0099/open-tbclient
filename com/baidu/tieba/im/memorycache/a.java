package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> keK = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0749a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0749a interfaceC0749a) {
        interfaceC0749a.a(this.keK.values().iterator());
    }

    public void cRi() {
        this.keK.clear();
    }

    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.keK.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo MJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.keK.get(str);
    }

    public boolean MK(String str) {
        return (TextUtils.isEmpty(str) || this.keK.remove(str) == null) ? false : true;
    }
}
