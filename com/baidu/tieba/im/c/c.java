package com.baidu.tieba.im.c;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.im.a<Boolean> {
    private final /* synthetic */ ImMessageCenterPojo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ImMessageCenterPojo imMessageCenterPojo) {
        this.a = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        com.baidu.tieba.im.db.l.a().a(this.a);
        com.baidu.tieba.im.b.a.c().i();
    }
}
