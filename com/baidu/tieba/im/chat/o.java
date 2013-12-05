package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f1601a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f1601a = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        u uVar;
        u uVar2;
        if (concurrentHashMap != null) {
            uVar = this.f1601a.f1600a.b;
            if (uVar != null) {
                uVar2 = this.f1601a.f1600a.b;
                ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(uVar2.c());
                imMessageCenterPojo.setLast_content(" ");
                imMessageCenterPojo.setLast_user_name(" ");
            }
        }
    }
}
