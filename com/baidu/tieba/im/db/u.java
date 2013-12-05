package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImMessageCenterPojo f1682a;
    final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.b = tVar;
        this.f1682a = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        return this.b.a(this.f1682a);
    }
}
