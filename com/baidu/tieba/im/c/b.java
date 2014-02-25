package com.baidu.tieba.im.c;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.im.c<Boolean> {
    private final /* synthetic */ LinkedHashMap a;
    private final /* synthetic */ ImMessageCenterPojo c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LinkedHashMap linkedHashMap, ImMessageCenterPojo imMessageCenterPojo) {
        this.a = linkedHashMap;
        this.c = imMessageCenterPojo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        com.baidu.tieba.im.db.b.a().a(this.a);
        return Boolean.valueOf(com.baidu.tieba.im.db.k.a().a(this.c));
    }
}
