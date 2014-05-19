package com.baidu.tieba.im.f;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class j extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ ImMessageCenterPojo b;
    private final /* synthetic */ LinkedHashMap c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ImMessageCenterPojo imMessageCenterPojo, LinkedHashMap linkedHashMap) {
        this.b = imMessageCenterPojo;
        this.c = linkedHashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.h.a().a(this.b);
        return com.baidu.tieba.im.db.c.a().a(this.c);
    }
}
