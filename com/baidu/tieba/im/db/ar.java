package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ String a;
    final /* synthetic */ com.baidu.tieba.im.a b;
    final /* synthetic */ ah c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ah ahVar, String str, com.baidu.tieba.im.a aVar) {
        this.c = ahVar;
        this.a = str;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo;
        if (concurrentHashMap != null && (imMessageCenterPojo = concurrentHashMap.get(this.a)) != null) {
            imMessageCenterPojo.setUnread_count(0);
        }
        if (this.b != null) {
            this.b.a(null);
        }
    }
}
