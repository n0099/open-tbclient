package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> bcM = new ConcurrentHashMap<>();

    public void a(b bVar) {
        bVar.a(this.bcM.values().iterator());
    }

    public void PI() {
        this.bcM.clear();
    }

    public void b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.bcM.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo gq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bcM.get(str);
    }

    public boolean gr(String str) {
        return (TextUtils.isEmpty(str) || this.bcM.remove(str) == null) ? false : true;
    }
}
