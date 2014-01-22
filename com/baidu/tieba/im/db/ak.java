package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ HashMap a;
    final /* synthetic */ com.baidu.tieba.im.a b;
    final /* synthetic */ ah c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar, HashMap hashMap, com.baidu.tieba.im.a aVar) {
        this.c = ahVar;
        this.a = hashMap;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        com.baidu.tieba.im.o.a(new al(this, concurrentHashMap), new am(this));
    }
}
