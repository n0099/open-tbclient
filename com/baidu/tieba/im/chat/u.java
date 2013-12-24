package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class u implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.a = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        aa aaVar;
        aa aaVar2;
        if (concurrentHashMap != null) {
            aaVar = this.a.a.b;
            if (aaVar != null) {
                aaVar2 = this.a.a.b;
                ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(aaVar2.c());
                imMessageCenterPojo.setLast_content(" ");
                imMessageCenterPojo.setLast_user_name(" ");
            }
        }
    }
}
