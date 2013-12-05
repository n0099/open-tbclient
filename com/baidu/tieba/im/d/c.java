package com.baidu.tieba.im.d;

import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.ac;
import com.baidu.tieba.im.data.GroupMidData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.m;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.log.i;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1641a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f1641a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        long j;
        boolean z;
        LinkedList linkedList;
        boolean z2;
        MessageSyncMessage k;
        LinkedList linkedList2;
        LinkedList linkedList3;
        String str;
        LinkedList linkedList4;
        long j2;
        long j3;
        int i;
        int i2;
        Handler handler;
        Handler handler2;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        if (concurrentHashMap != null) {
            j = this.f1641a.v;
            if (j > 0) {
                j4 = this.f1641a.w;
                if (j4 > 0) {
                    j5 = this.f1641a.w;
                    long b = ac.b(j5 - 1);
                    j6 = this.f1641a.v;
                    ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(String.valueOf(j6));
                    if (imMessageCenterPojo == null) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        j7 = this.f1641a.v;
                        imMessageCenterPojo2.setGid(String.valueOf(j7));
                        imMessageCenterPojo2.setPulled_msgId(b);
                        j8 = this.f1641a.v;
                        concurrentHashMap.put(String.valueOf(j8), imMessageCenterPojo2);
                    } else if (0 == imMessageCenterPojo.getPulled_msgId() || imMessageCenterPojo.getIs_delete() == 1) {
                        imMessageCenterPojo.setPulled_msgId(b);
                    }
                }
            }
            if (m.a() > 10) {
                com.baidu.adp.lib.h.e.c("----pull message, but TiebaIMSingleExecutor.QueueSize too big");
                handler = this.f1641a.r;
                handler2 = this.f1641a.r;
                handler.sendMessageDelayed(handler2.obtainMessage(2), 2000L);
                return;
            }
            this.f1641a.f = com.baidu.tieba.im.messageCenter.e.a().b(202003);
            z = this.f1641a.f;
            if (!z) {
                if (TiebaApplication.h().aC()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = this.f1641a.l;
                    if (currentTimeMillis - j2 > Util.MILLSECONDS_OF_MINUTE) {
                        j3 = this.f1641a.j;
                        if (currentTimeMillis - j3 < 180000) {
                            i = this.f1641a.k;
                            if (i < 20) {
                                a.i(this.f1641a);
                                StringBuilder append = new StringBuilder().append("----background pull skip. no pull count ");
                                i2 = this.f1641a.k;
                                com.baidu.adp.lib.h.e.c(append.append(i2).toString());
                                return;
                            }
                        }
                    }
                }
                com.baidu.adp.lib.h.e.c("----real pull msg.");
                this.f1641a.k = 0;
                linkedList = this.f1641a.h;
                linkedList.clear();
                z2 = this.f1641a.u;
                if (z2) {
                    this.f1641a.i = "active";
                } else {
                    this.f1641a.i = "passive";
                }
                k = this.f1641a.k();
                this.f1641a.h = new LinkedList();
                for (String str2 : concurrentHashMap.keySet()) {
                    ImMessageCenterPojo imMessageCenterPojo3 = concurrentHashMap.get(str2);
                    if (imMessageCenterPojo3.getIs_delete() == 0) {
                        long c = ac.c(imMessageCenterPojo3.getPulled_msgId());
                        if (c != 0) {
                            GroupMidData groupMidData = new GroupMidData();
                            groupMidData.setGroupId(Long.parseLong(imMessageCenterPojo3.getGid()));
                            groupMidData.setLastMsgId(c);
                            linkedList4 = this.f1641a.h;
                            linkedList4.add(groupMidData);
                        }
                    }
                }
                List<GroupMidData> groupMids = k.getGroupMids();
                linkedList2 = this.f1641a.h;
                groupMids.addAll(linkedList2);
                this.f1641a.g = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder(200);
                linkedList3 = this.f1641a.h;
                Iterator it = linkedList3.iterator();
                while (it.hasNext()) {
                    GroupMidData groupMidData2 = (GroupMidData) it.next();
                    sb.append(groupMidData2.getGroupId());
                    sb.append("-");
                    sb.append(groupMidData2.getLastMsgId());
                    sb.append("|");
                }
                str = this.f1641a.i;
                com.baidu.tieba.log.a.b(i.a(202003, 0, str, "MessageSync-send-pullmsg", "succ", 0, "", 0L, 0, sb.toString()));
                com.baidu.tieba.im.messageCenter.e.a().a(k);
            }
        }
    }
}
