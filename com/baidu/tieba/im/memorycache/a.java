package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> gFB = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0335a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0335a interfaceC0335a) {
        interfaceC0335a.a(this.gFB.values().iterator());
    }

    public void bCp() {
        this.gFB.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.gFB.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo yB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.gFB.get(str);
    }

    public boolean yC(String str) {
        return (TextUtils.isEmpty(str) || this.gFB.remove(str) == null) ? false : true;
    }
}
