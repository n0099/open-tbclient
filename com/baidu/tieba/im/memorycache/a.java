package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> bhK = new ConcurrentHashMap<>();

    public void a(b bVar) {
        bVar.a(this.bhK.values().iterator());
    }

    public void QN() {
        this.bhK.clear();
    }

    public void i(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.bhK.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo gW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bhK.get(str);
    }

    public boolean gX(String str) {
        return (TextUtils.isEmpty(str) || this.bhK.remove(str) == null) ? false : true;
    }
}
