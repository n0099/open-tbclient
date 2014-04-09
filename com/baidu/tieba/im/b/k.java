package com.baidu.tieba.im.b;

import android.text.TextUtils;
import com.baidu.tieba.im.chat.x;
import com.baidu.tieba.im.db.o;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
public final class k extends c {
    private static k a;

    public static synchronized k a() {
        k kVar;
        synchronized (k.class) {
            if (a == null) {
                a = new k();
            }
            kVar = a;
        }
        return kVar;
    }

    private k() {
    }

    public final void a(String str, int i, CommonMsgPojo commonMsgPojo) {
        e.a(this, str, i, commonMsgPojo);
    }

    @Override // com.baidu.tieba.im.b.c
    protected final void b() {
        com.baidu.adp.lib.util.f.e("see init private chat begin ");
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setGid(String.valueOf(x.a));
        imMessageCenterPojo.setCustomGroupType(2);
        for (String str : o.d().b()) {
            com.baidu.adp.lib.util.f.e("see init private chat id:" + str);
            if (!TextUtils.isEmpty(str)) {
                long c = o.d().c(str);
                if (c > imMessageCenterPojo.getPulled_msgId()) {
                    imMessageCenterPojo.setPulled_msgId(c);
                }
                CommonMsgPojo d = o.d().d(str);
                if (d == null) {
                    com.baidu.adp.lib.util.f.e("see init private chat cmpojo null id:" + str);
                } else {
                    ImMessageCenterPojo fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(d);
                    if (fromCommonMsg == null) {
                        com.baidu.adp.lib.util.f.e("see init private chat person null id:" + str);
                    } else {
                        fromCommonMsg.setUnread_count(o.d().a(str));
                        if (d.getRid() > imMessageCenterPojo.getLast_rid()) {
                            imMessageCenterPojo.setLast_rid(d.getRid());
                        }
                        if (com.baidu.tieba.im.db.h.c(str) != null) {
                            com.baidu.tieba.im.db.h.a();
                            ImMessageCenterPojo b = com.baidu.tieba.im.db.h.b(str);
                            if (b != null) {
                                imMessageCenterPojo.setIs_hidden(b.getIs_hidden());
                                fromCommonMsg.setIs_hidden(b.getIs_hidden());
                            }
                        }
                        a(fromCommonMsg);
                    }
                }
            }
        }
        a(imMessageCenterPojo);
    }
}
