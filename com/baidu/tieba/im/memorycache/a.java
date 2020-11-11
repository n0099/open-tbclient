package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> kkH = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0763a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0763a interfaceC0763a) {
        interfaceC0763a.a(this.kkH.values().iterator());
    }

    public void cTJ() {
        this.kkH.clear();
    }

    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.kkH.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo Na(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.kkH.get(str);
    }

    public boolean Nb(String str) {
        return (TextUtils.isEmpty(str) || this.kkH.remove(str) == null) ? false : true;
    }
}
