package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1864a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f1864a = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        a.b(this.f1864a.f1863a, concurrentHashMap);
    }
}
