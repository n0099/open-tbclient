package com.baidu.tieba.im.c;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> {
    final /* synthetic */ String a;
    final /* synthetic */ UpdatesItemData b;
    final /* synthetic */ m c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(m mVar, String str, UpdatesItemData updatesItemData) {
        this.c = mVar;
        this.a = str;
        this.b = updatesItemData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap) {
        ImMessageCenterPojo imMessageCenterPojo = concurrentHashMap.get(this.a);
        if (imMessageCenterPojo != null) {
            imMessageCenterPojo.setGroup_head(this.b.getGroupHeadUrl());
        }
    }
}
