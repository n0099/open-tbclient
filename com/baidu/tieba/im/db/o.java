package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImMessageCenterPojo f1622a;
    final /* synthetic */ n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.b = nVar;
        this.f1622a = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        Boolean a2;
        a2 = this.b.a(this.f1622a);
        return a2;
    }
}
