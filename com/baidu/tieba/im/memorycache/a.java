package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> eMG = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0213a {
        void b(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0213a interfaceC0213a) {
        interfaceC0213a.b(this.eMG.values().iterator());
    }

    public void aRx() {
        this.eMG.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.eMG.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo pN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.eMG.get(str);
    }

    public boolean pO(String str) {
        return (TextUtils.isEmpty(str) || this.eMG.remove(str) == null) ? false : true;
    }
}
