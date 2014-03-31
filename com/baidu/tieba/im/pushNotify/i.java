package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements com.baidu.tieba.im.b.d {
    final /* synthetic */ a a;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.b.c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, com.baidu.tbadk.coreExtra.b.c cVar) {
        this.a = aVar;
        this.b = cVar;
    }

    @Override // com.baidu.tieba.im.b.d
    public final void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (a.a(this.a, imMessageCenterPojo)) {
            if (imMessageCenterPojo.getCustomGroupType() == 4) {
                a.a(this.a, imMessageCenterPojo.getGid(), imMessageCenterPojo);
                return;
            }
            a.a(this.a, a.b(this.a, imMessageCenterPojo.getGid(), imMessageCenterPojo), this.b);
        }
    }
}
