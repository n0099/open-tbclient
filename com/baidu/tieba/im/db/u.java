package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends SingleRunnable<Boolean> {
    final /* synthetic */ ImMessageCenterPojo a;
    final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.b = tVar;
        this.a = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        return this.b.a(this.a);
    }
}
