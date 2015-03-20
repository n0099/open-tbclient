package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> biZ = new ConcurrentHashMap<>();

    public void a(b bVar) {
        bVar.a(this.biZ.values().iterator());
    }

    public void Sc() {
        this.biZ.clear();
    }

    public void b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.biZ.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo gJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.biZ.get(str);
    }

    public boolean gK(String str) {
        return (TextUtils.isEmpty(str) || this.biZ.remove(str) == null) ? false : true;
    }
}
