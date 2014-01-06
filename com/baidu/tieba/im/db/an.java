package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ String a;
    final /* synthetic */ ag b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ag agVar, String str) {
        this.b = agVar;
        this.a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(this.a);
        if (imMessageCenterPojo != null) {
            imMessageCenterPojo.setLast_rid(0L);
            imMessageCenterPojo.setPulled_msgId(0L);
            imMessageCenterPojo.setIs_delete(1);
            return;
        }
        com.baidu.adp.lib.h.e.a("删除gid失败");
    }
}
