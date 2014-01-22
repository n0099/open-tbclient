package com.baidu.tieba.im.c;

import com.baidu.tieba.im.db.ah;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ ImMessageCenterPojo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ImMessageCenterPojo imMessageCenterPojo) {
        this.a = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        ah.a().a(this.a);
        com.baidu.tieba.im.b.a.c().i();
    }
}
