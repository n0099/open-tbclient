package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> bda = new ConcurrentHashMap<>();

    public void a(b bVar) {
        bVar.a(this.bda.values().iterator());
    }

    public void PL() {
        this.bda.clear();
    }

    public void b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.bda.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo gq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bda.get(str);
    }

    public boolean gr(String str) {
        return (TextUtils.isEmpty(str) || this.bda.remove(str) == null) ? false : true;
    }
}
