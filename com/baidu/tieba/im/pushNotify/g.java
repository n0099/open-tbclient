package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1775a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f1775a = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        a.b(this.f1775a.f1774a, concurrentHashMap);
    }
}
