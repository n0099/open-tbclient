package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tieba.im.a<LinkedList<ImMessageCenterPojo>> {
    final /* synthetic */ com.baidu.tieba.im.a a;
    final /* synthetic */ ae b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, com.baidu.tieba.im.a aVar) {
        this.b = aeVar;
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<ImMessageCenterPojo> linkedList) {
        AtomicBoolean atomicBoolean;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        AtomicBoolean atomicBoolean2;
        ConcurrentHashMap concurrentHashMap3;
        atomicBoolean = this.b.c;
        if (!atomicBoolean.get() && linkedList != null) {
            concurrentHashMap2 = this.b.d;
            concurrentHashMap2.clear();
            if (linkedList != null) {
                Iterator<ImMessageCenterPojo> it = linkedList.iterator();
                while (it.hasNext()) {
                    ImMessageCenterPojo next = it.next();
                    concurrentHashMap3 = this.b.d;
                    concurrentHashMap3.put(next.getGid(), next);
                }
            }
            atomicBoolean2 = this.b.c;
            atomicBoolean2.set(true);
        }
        com.baidu.tieba.im.a aVar = this.a;
        concurrentHashMap = this.b.d;
        aVar.a(concurrentHashMap);
    }
}
