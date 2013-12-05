package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1869a;
    final /* synthetic */ UpdatesItemData b;
    final /* synthetic */ l c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar, String str, UpdatesItemData updatesItemData) {
        this.c = lVar;
        this.f1869a = str;
        this.b = updatesItemData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(this.f1869a);
        if (imMessageCenterPojo != null) {
            imMessageCenterPojo.setGroup_head(this.b.getGroupHeadUrl());
        }
    }
}
