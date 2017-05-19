package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> cWR = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0068a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0068a interfaceC0068a) {
        interfaceC0068a.a(this.cWR.values().iterator());
    }

    public void apV() {
        this.cWR.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.cWR.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo kN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cWR.get(str);
    }

    public boolean kO(String str) {
        return (TextUtils.isEmpty(str) || this.cWR.remove(str) == null) ? false : true;
    }
}
