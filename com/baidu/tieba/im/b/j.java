package com.baidu.tieba.im.b;

import android.text.TextUtils;
import com.baidu.tieba.im.chat.x;
import com.baidu.tieba.im.db.n;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.model.p;
/* loaded from: classes.dex */
public final class j extends c {
    private static j a;

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (a == null) {
                a = new j();
            }
            jVar = a;
        }
        return jVar;
    }

    private j() {
    }

    public final void a(String str, int i, CommonMsgPojo commonMsgPojo) {
        e.a(this, str, i, commonMsgPojo);
    }

    @Override // com.baidu.tieba.im.b.c
    protected final void b() {
        com.baidu.tieba.im.db.h.a();
        ImMessageCenterPojo b = com.baidu.tieba.im.db.h.b("-1000");
        if (b != null) {
            p.a(b.getUnread_count() > 0);
        }
        com.baidu.adp.lib.util.f.e("see init private chat begin ");
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setGid(String.valueOf(x.a));
        imMessageCenterPojo.setCustomGroupType(4);
        for (String str : n.d().b()) {
            com.baidu.adp.lib.util.f.e("see init private chat id:" + str);
            if (!TextUtils.isEmpty(str)) {
                long c = n.d().c(str);
                if (c > imMessageCenterPojo.getPulled_msgId()) {
                    imMessageCenterPojo.setPulled_msgId(c);
                }
                CommonMsgPojo d = n.d().d(str);
                if (d == null) {
                    com.baidu.adp.lib.util.f.e("see init private chat cmpojo null id:" + str);
                } else {
                    d.checkRidAndSelf();
                    ImMessageCenterPojo fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(d);
                    if (fromCommonMsg == null) {
                        com.baidu.adp.lib.util.f.e("see init private chat person null id:" + str);
                    } else {
                        fromCommonMsg.setUnread_count(n.d().a(str));
                        if (d.getRid() > imMessageCenterPojo.getLast_rid()) {
                            imMessageCenterPojo.setLast_rid(d.getRid());
                        }
                        if (com.baidu.tieba.im.db.h.c(str) != null) {
                            com.baidu.tieba.im.db.h.a();
                            ImMessageCenterPojo b2 = com.baidu.tieba.im.db.h.b(str);
                            if (b2 != null) {
                                imMessageCenterPojo.setIs_hidden(b2.getIs_hidden());
                                fromCommonMsg.setIs_hidden(b2.getIs_hidden());
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
