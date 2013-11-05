package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1696a;
    final /* synthetic */ UpdatesItemData b;
    final /* synthetic */ n c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar, String str, UpdatesItemData updatesItemData) {
        this.c = nVar;
        this.f1696a = str;
        this.b = updatesItemData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(this.f1696a);
        if (imMessageCenterPojo != null) {
            imMessageCenterPojo.setGroup_head(this.b.getGroupHeadUrl());
        }
    }
}
