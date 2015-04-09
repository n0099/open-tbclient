package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private ConcurrentHashMap<String, ImMessageCenterPojo> bjp = new ConcurrentHashMap<>();

    public void a(b bVar) {
        bVar.a(this.bjp.values().iterator());
    }

    public void Sp() {
        this.bjp.clear();
    }

    public void b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            this.bjp.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }

    public ImMessageCenterPojo gM(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bjp.get(str);
    }

    public boolean gN(String str) {
        return (TextUtils.isEmpty(str) || this.bjp.remove(str) == null) ? false : true;
    }
}
