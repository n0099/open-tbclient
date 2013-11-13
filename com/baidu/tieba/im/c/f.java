package com.baidu.tieba.im.c;

import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.z;
import com.baidu.tieba.im.db.aa;
import com.baidu.tieba.im.db.n;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.v;
import com.baidu.tieba.im.message.GroupUpdateMessage;
import com.baidu.tieba.im.message.ResponseOnlineMessage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ResponseOnlineMessage f1489a;
    final /* synthetic */ LinkedList b;
    final /* synthetic */ LinkedList c;
    final /* synthetic */ e d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, ResponseOnlineMessage responseOnlineMessage, LinkedList linkedList, LinkedList linkedList2) {
        this.d = eVar;
        this.f1489a = responseOnlineMessage;
        this.b = linkedList;
        this.c = linkedList2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        Handler handler;
        Handler handler2;
        boolean z;
        ImMessageCenterPojo a2;
        if (this.f1489a.getGroupInfos() != null) {
            for (GroupUpdateMessage groupUpdateMessage : this.f1489a.getGroupInfos()) {
                if (groupUpdateMessage != null) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    this.b.add(imMessageCenterPojo);
                    imMessageCenterPojo.setGid(String.valueOf(groupUpdateMessage.getGroupId()));
                    imMessageCenterPojo.setGroup_name(groupUpdateMessage.getName());
                    imMessageCenterPojo.setGroup_type(groupUpdateMessage.getGroupType());
                    a2 = this.d.f1488a.a(concurrentHashMap, groupUpdateMessage.getGroupId());
                    if (a2 == null || a2.getPulled_msgId() == 0 || a2.getLast_msgId() == 0) {
                        long b = z.b(groupUpdateMessage.getLastMsgId());
                        imMessageCenterPojo.setPulled_msgId(b);
                        imMessageCenterPojo.setLast_msgId(b);
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
                            v.d(TiebaApplication.A(), str, true);
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        v.d(TiebaApplication.A(), imMessageCenterPojo2.getGid(), false);
                        imMessageCenterPojo2.setIs_delete(1);
                        this.b.add(imMessageCenterPojo2);
                    }
                }
            }
        }
        com.baidu.tieba.im.messageCenter.f.a().a(false);
        com.baidu.adp.lib.h.d.c("----online succ");
        this.d.f1488a.m = false;
        this.d.f1488a.n = true;
        this.d.f1488a.l = 0;
        aa.a().a(concurrentHashMap, this.b);
        if (TiebaApplication.B()) {
            handler = this.d.f1488a.D;
            handler2 = this.d.f1488a.D;
            handler.sendMessage(handler2.obtainMessage(3));
        }
        n.a().a(this.b, (com.baidu.tieba.im.a<Void>) null);
    }
}
