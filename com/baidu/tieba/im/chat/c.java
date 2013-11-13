package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.data.GroupIdTypeData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ChatMessage;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1545a;
    final /* synthetic */ GroupNewsPojo b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str, GroupNewsPojo groupNewsPojo) {
        this.c = aVar;
        this.f1545a = str;
        this.b = groupNewsPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo;
        j jVar;
        if (concurrentHashMap != null && (imMessageCenterPojo = concurrentHashMap.get(this.f1545a)) != null) {
            ChatMessage originalPushMsg = this.b.getOriginalPushMsg();
            originalPushMsg.setGroupId(this.f1545a);
            long last_msgId = imMessageCenterPojo.getLast_msgId();
            com.baidu.adp.lib.h.d.d("lastMid:" + last_msgId);
            long j = last_msgId + 1;
            com.baidu.adp.lib.h.d.d("lastMid + :" + j);
            originalPushMsg.setMsgId(j);
            String f = com.baidu.tieba.im.d.c.f(originalPushMsg);
            com.baidu.tieba.im.db.aa.a().a(this.f1545a);
            com.baidu.tieba.im.db.n.a().a(this.f1545a, f, true);
            GroupMsgData groupMsgData = new GroupMsgData(-100);
            GroupIdTypeData groupIdTypeData = new GroupIdTypeData();
            groupIdTypeData.setGroupId(Long.parseLong(this.f1545a));
            groupMsgData.setGroupInfo(groupIdTypeData);
            com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
            LinkedList linkedList = new LinkedList();
            linkedList.add(originalPushMsg);
            bVar.a(linkedList);
            groupMsgData.setListMessageData(bVar);
            jVar = this.c.c;
            jVar.a(groupMsgData);
            com.baidu.tieba.im.pushNotify.a.g().b(false, (com.baidu.tieba.im.a<Void>) null);
        }
    }
}
