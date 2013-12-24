package com.baidu.tieba.im.c;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ boolean a;
    final /* synthetic */ com.baidu.tieba.im.a b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, boolean z, com.baidu.tieba.im.a aVar2) {
        this.c = aVar;
        this.a = z;
        this.b = aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        this.c.a(this.a, concurrentHashMap);
        if (this.b != null) {
            this.b.a(null);
        }
    }
}
