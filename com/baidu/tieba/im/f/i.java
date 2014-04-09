package com.baidu.tieba.im.f;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
final class i extends com.baidu.tieba.im.m<Void> {
    private final /* synthetic */ ImMessageCenterPojo b;
    private final /* synthetic */ LinkedHashMap c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ImMessageCenterPojo imMessageCenterPojo, LinkedHashMap linkedHashMap) {
        this.b = imMessageCenterPojo;
        this.c = linkedHashMap;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* bridge */ /* synthetic */ Void a() {
        com.baidu.tieba.im.db.h.a().a(this.b);
        return com.baidu.tieba.im.db.c.a().a(this.c);
    }
}
