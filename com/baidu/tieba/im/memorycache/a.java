package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> blT = new ConcurrentHashMap<>();

    public void a(b bVar) {
        bVar.a(this.blT.values().iterator());
    }

    public void TD() {
        this.blT.clear();
    }

    public void b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.blT.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo hp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.blT.get(str);
    }

    public boolean hq(String str) {
        return (TextUtils.isEmpty(str) || this.blT.remove(str) == null) ? false : true;
    }
}
