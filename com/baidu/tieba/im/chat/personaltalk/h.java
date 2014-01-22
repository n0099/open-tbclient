package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        long j;
        if (concurrentHashMap != null) {
            j = this.a.a.a.c;
            ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(String.valueOf(j));
            if (imMessageCenterPojo != null) {
                imMessageCenterPojo.setLast_content(" ");
                imMessageCenterPojo.setLast_user_name(" ");
                imMessageCenterPojo.setLast_rid(0L);
            }
        }
    }
}
