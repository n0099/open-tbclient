package com.baidu.tieba.im.c;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements com.baidu.tieba.im.a<Boolean> {
    private final /* synthetic */ ImMessageCenterPojo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ImMessageCenterPojo imMessageCenterPojo) {
        this.a = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        com.baidu.tieba.im.db.l.a().a(this.a);
        com.baidu.tieba.im.b.a.c().i();
    }
}
