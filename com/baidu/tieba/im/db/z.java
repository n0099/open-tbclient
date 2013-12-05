package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class z implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f1687a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.f1687a = yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(this.f1687a.f1686a);
        if (imMessageCenterPojo != null) {
            imMessageCenterPojo.setGroup_name(this.f1687a.b);
        }
    }
}
