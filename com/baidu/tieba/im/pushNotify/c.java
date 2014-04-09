package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends com.baidu.tieba.im.m<Boolean> {
    private final /* synthetic */ LinkedHashMap b;
    private final /* synthetic */ ImMessageCenterPojo c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LinkedHashMap linkedHashMap, ImMessageCenterPojo imMessageCenterPojo) {
        this.b = linkedHashMap;
        this.c = imMessageCenterPojo;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        com.baidu.tieba.im.db.c.a().a(this.b);
        return Boolean.valueOf(com.baidu.tieba.im.db.h.a().a(this.c));
    }
}
