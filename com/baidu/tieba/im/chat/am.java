package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ al a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.a = alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        as asVar;
        as asVar2;
        if (concurrentHashMap != null) {
            asVar = this.a.a.b;
            if (asVar != null) {
                asVar2 = this.a.a.b;
                ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(asVar2.c());
                imMessageCenterPojo.setLast_content(" ");
                imMessageCenterPojo.setLast_user_name(" ");
                imMessageCenterPojo.setLast_rid(0L);
            }
        }
    }
}
