package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class t implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.a = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        z zVar;
        z zVar2;
        if (concurrentHashMap != null) {
            zVar = this.a.a.b;
            if (zVar != null) {
                zVar2 = this.a.a.b;
                ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(zVar2.c());
                imMessageCenterPojo.setLast_content(" ");
                imMessageCenterPojo.setLast_user_name(" ");
            }
        }
    }
}
