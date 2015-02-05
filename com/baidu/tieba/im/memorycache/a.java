package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> bhJ = new ConcurrentHashMap<>();

    public void a(b bVar) {
        bVar.a(this.bhJ.values().iterator());
    }

    public void QI() {
        this.bhJ.clear();
    }

    public void i(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.bhJ.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo gT(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bhJ.get(str);
    }

    public boolean gU(String str) {
        return (TextUtils.isEmpty(str) || this.bhJ.remove(str) == null) ? false : true;
    }
}
