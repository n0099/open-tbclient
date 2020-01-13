package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> hDo = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0526a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0526a interfaceC0526a) {
        interfaceC0526a.a(this.hDo.values().iterator());
    }

    public void bVe() {
        this.hDo.clear();
    }

    public void g(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.hDo.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo CZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.hDo.get(str);
    }

    public boolean Da(String str) {
        return (TextUtils.isEmpty(str) || this.hDo.remove(str) == null) ? false : true;
    }
}
