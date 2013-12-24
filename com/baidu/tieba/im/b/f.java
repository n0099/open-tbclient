package com.baidu.tieba.im.b;

import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.ai;
import com.baidu.tieba.im.db.ag;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.db.t;
import com.baidu.tieba.im.groupInfo.u;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.message.bl;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ bl a;
    final /* synthetic */ LinkedList b;
    final /* synthetic */ LinkedList c;
    final /* synthetic */ e d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, bl blVar, LinkedList linkedList, LinkedList linkedList2) {
        this.d = eVar;
        this.a = blVar;
        this.b = linkedList;
        this.c = linkedList2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        Handler handler;
        Handler handler2;
        boolean z;
        ImMessageCenterPojo a;
        if (this.a.a() != null) {
            for (GroupUpdateMessage groupUpdateMessage : this.a.a()) {
                if (groupUpdateMessage != null) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    this.b.add(imMessageCenterPojo);
                    imMessageCenterPojo.setGid(String.valueOf(groupUpdateMessage.getGroupId()));
                    imMessageCenterPojo.setGroup_name(groupUpdateMessage.getName());
                    imMessageCenterPojo.setGroup_type(groupUpdateMessage.getGroupType());
                    a = this.d.a.a(concurrentHashMap, groupUpdateMessage.getGroupId());
                    if (a == null || a.getPulled_msgId() == 0 || a.getLast_rid() == 0) {
                        long b = ai.b(groupUpdateMessage.getLastMsgId());
                        imMessageCenterPojo.setPulled_msgId(b);
                        imMessageCenterPojo.setLast_rid(b);
                    }
                    imMessageCenterPojo.setGroup_head(groupUpdateMessage.getPortrait());
                }
            }
        }
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            for (Map.Entry<String, ImMessageCenterPojo> entry : concurrentHashMap.entrySet()) {
                ImMessageCenterPojo value = entry.getValue();
                if (value != null && (value instanceof ImMessageCenterPojo)) {
                    ImMessageCenterPojo imMessageCenterPojo2 = value;
                    Iterator it = this.c.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = true;
                            break;
                        }
                        String str = (String) it.next();
                        if (imMessageCenterPojo2.getGid() != null && imMessageCenterPojo2.getGid().equals(str)) {
                            u.d(TiebaApplication.B(), str, true);
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        u.d(TiebaApplication.B(), imMessageCenterPojo2.getGid(), false);
                        imMessageCenterPojo2.setIs_delete(1);
                        this.b.add(imMessageCenterPojo2);
                    }
                }
            }
        }
        com.baidu.tieba.im.messageCenter.e.a().b(false);
        com.baidu.adp.lib.h.e.c("----online succ");
        ag.a().a(concurrentHashMap, this.b);
        if (TiebaApplication.C()) {
            handler = this.d.a.p;
            handler2 = this.d.a.p;
            handler.sendMessage(handler2.obtainMessage(3));
        }
        t.a().a(this.b, (com.baidu.tieba.im.a<Void>) null);
    }
}
