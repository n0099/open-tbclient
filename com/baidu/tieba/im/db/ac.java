package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class ac implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ab f1652a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.f1652a = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(this.f1652a.f1651a);
        if (imMessageCenterPojo != null) {
            imMessageCenterPojo.setGroup_head(this.f1652a.b);
        }
    }
}
