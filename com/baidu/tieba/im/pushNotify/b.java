package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.db.ag;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImMessageCenterPojo f1858a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ImMessageCenterPojo imMessageCenterPojo) {
        this.f1858a = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        ag.a().a(this.f1858a);
        com.baidu.tieba.im.d.a.a().g();
    }
}
