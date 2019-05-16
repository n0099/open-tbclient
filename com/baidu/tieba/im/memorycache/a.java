package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> gFA = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0335a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0335a interfaceC0335a) {
        interfaceC0335a.a(this.gFA.values().iterator());
    }

    public void bCm() {
        this.gFA.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.gFA.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo yB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.gFA.get(str);
    }

    public boolean yC(String str) {
        return (TextUtils.isEmpty(str) || this.gFA.remove(str) == null) ? false : true;
    }
}
