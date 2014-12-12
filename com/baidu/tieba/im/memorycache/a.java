package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> bgs = new ConcurrentHashMap<>();

    public void a(b bVar) {
        bVar.a(this.bgs.values().iterator());
    }

    public void Qr() {
        this.bgs.clear();
    }

    public void i(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.bgs.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo gR(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bgs.get(str);
    }

    public boolean gS(String str) {
        return (TextUtils.isEmpty(str) || this.bgs.remove(str) == null) ? false : true;
    }
}
