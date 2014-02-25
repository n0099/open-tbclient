package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.GroupData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.im.c<Boolean> {
    final /* synthetic */ MsglistModel a;
    private final /* synthetic */ com.baidu.tieba.im.message.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MsglistModel msglistModel, com.baidu.tieba.im.message.b bVar) {
        this.a = msglistModel;
        this.c = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        GroupData groupData;
        com.baidu.tieba.im.db.b a = com.baidu.tieba.im.db.b.a();
        groupData = this.a.f;
        return Boolean.valueOf(a.a(String.valueOf(groupData.getGroupId()), String.valueOf(this.c.l())));
    }
}
