package com.baidu.tieba.im.model;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ com.baidu.tieba.im.message.b a;
    final /* synthetic */ com.baidu.tieba.im.message.b b;
    final /* synthetic */ MsglistModel c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(MsglistModel msglistModel, com.baidu.tieba.im.message.b bVar, com.baidu.tieba.im.message.b bVar2) {
        this.c = msglistModel;
        this.a = bVar;
        this.b = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo;
        if (concurrentHashMap != null) {
            if (this.a instanceof com.baidu.tieba.im.message.d) {
                imMessageCenterPojo = concurrentHashMap.get(((com.baidu.tieba.im.message.d) this.a).s());
            } else {
                imMessageCenterPojo = concurrentHashMap.get(String.valueOf(com.baidu.tieba.im.chat.a.a));
            }
            if (imMessageCenterPojo != null) {
                if (this.b != null) {
                    imMessageCenterPojo.setLast_content_time(this.b.o());
                    imMessageCenterPojo.setLast_content(this.b.j());
                    imMessageCenterPojo.setLast_user_name(this.b.f().getName());
                    return;
                }
                imMessageCenterPojo.setLast_content(" ");
                imMessageCenterPojo.setLast_user_name(" ");
            }
        }
    }
}
