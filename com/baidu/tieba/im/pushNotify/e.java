package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ LinkedHashMap b;
    private final /* synthetic */ ImMessageCenterPojo c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LinkedHashMap linkedHashMap, ImMessageCenterPojo imMessageCenterPojo) {
        this.b = linkedHashMap;
        this.c = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        com.baidu.tieba.im.db.c.a().a(this.b);
        return Boolean.valueOf(com.baidu.tieba.im.db.h.a().a(this.c));
    }
}
