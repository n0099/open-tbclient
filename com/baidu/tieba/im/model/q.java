package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.GroupData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ MsglistModel a;
    private final /* synthetic */ com.baidu.tieba.im.message.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MsglistModel msglistModel, com.baidu.tieba.im.message.b bVar) {
        this.a = msglistModel;
        this.c = bVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        GroupData groupData;
        com.baidu.tieba.im.db.b a = com.baidu.tieba.im.db.b.a();
        groupData = this.a.f;
        return Boolean.valueOf(a.b(String.valueOf(groupData.getGroupId()), String.valueOf(this.c.l())));
    }
}
