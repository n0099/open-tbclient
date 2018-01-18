package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> eEf = new ConcurrentHashMap<>();

    /* renamed from: com.baidu.tieba.im.memorycache.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0121a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(InterfaceC0121a interfaceC0121a) {
        interfaceC0121a.a(this.eEf.values().iterator());
    }

    public void aIT() {
        this.eEf.clear();
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.eEf.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo no(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.eEf.get(str);
    }

    public boolean np(String str) {
        return (TextUtils.isEmpty(str) || this.eEf.remove(str) == null) ? false : true;
    }
}
