package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.UserData;
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
        int i;
        int i2;
        UserData userData;
        UserData userData2;
        if (concurrentHashMap != null) {
            ImMessageCenterPojo imMessageCenterPojo = null;
            i = this.c.e;
            if (i != 0 || !(this.a instanceof com.baidu.tieba.im.message.e)) {
                i2 = this.c.e;
                if (i2 == 1) {
                    userData = this.c.g;
                    if (userData != null) {
                        userData2 = this.c.g;
                        imMessageCenterPojo = concurrentHashMap.get(String.valueOf(userData2.getUserId()));
                    }
                }
            } else {
                imMessageCenterPojo = concurrentHashMap.get(((com.baidu.tieba.im.message.e) this.a).t());
            }
            if (imMessageCenterPojo != null) {
                if (this.b != null) {
                    imMessageCenterPojo.setLast_content_time(this.b.o() * 1000);
                    imMessageCenterPojo.setLast_content(com.baidu.tieba.im.d.d.h(this.b));
                    imMessageCenterPojo.setLast_user_name(this.b.f().getName());
                    imMessageCenterPojo.setLast_rid(this.b.i());
                    return;
                }
                imMessageCenterPojo.setLast_content(" ");
                imMessageCenterPojo.setLast_user_name(" ");
            }
        }
    }
}
