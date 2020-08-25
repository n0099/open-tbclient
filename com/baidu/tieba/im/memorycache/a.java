package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> juF = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0718a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0718a interfaceC0718a) {
        interfaceC0718a.a(this.juF.values().iterator());
    }

    public void cGL() {
        this.juF.clear();
    }

    public void e(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.juF.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo KT(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.juF.get(str);
    }

    public boolean KU(String str) {
        return (TextUtils.isEmpty(str) || this.juF.remove(str) == null) ? false : true;
    }
}
