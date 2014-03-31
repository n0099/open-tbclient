package com.baidu.tieba.im.b;

import android.text.TextUtils;
import com.baidu.tieba.im.chat.x;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
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
        com.baidu.adp.lib.util.f.e("see init private chat begin ");
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setGid(String.valueOf(x.a));
        imMessageCenterPojo.setCustomGroupType(4);
        for (String str : m.d().b()) {
            com.baidu.adp.lib.util.f.e("see init private chat id:" + str);
            if (!TextUtils.isEmpty(str)) {
                long c = m.d().c(str);
                if (c > imMessageCenterPojo.getPulled_msgId()) {
                    imMessageCenterPojo.setPulled_msgId(c);
                }
                CommonMsgPojo d = m.d().d(str);
                if (d == null) {
                    com.baidu.adp.lib.util.f.e("see init private chat cmpojo null id:" + str);
                } else {
                    d.checkRidAndSelf();
                    ImMessageCenterPojo fromCommonMsg = ImMessageCenterPojo.fromCommonMsg(d);
                    if (fromCommonMsg == null) {
                        com.baidu.adp.lib.util.f.e("see init private chat person null id:" + str);
                    } else {
                        fromCommonMsg.setUnread_count(m.d().a(str));
                        if (d.getRid() > imMessageCenterPojo.getLast_rid()) {
                            imMessageCenterPojo.setLast_rid(d.getRid());
                        }
                        if (com.baidu.tieba.im.db.g.c(str) != null) {
                            com.baidu.tieba.im.db.g.a();
                            ImMessageCenterPojo b = com.baidu.tieba.im.db.g.b(str);
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
