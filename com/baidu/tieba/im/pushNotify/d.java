package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.db.aa;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImMessageCenterPojo f1763a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ImMessageCenterPojo imMessageCenterPojo) {
        this.f1763a = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        aa.a().a(this.f1763a);
        com.baidu.tieba.im.c.a.a().h();
    }
}
