package com.baidu.tieba.im.model;

import com.baidu.tieba.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ MsglistModel a;
    private final /* synthetic */ com.baidu.tieba.im.message.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MsglistModel msglistModel, com.baidu.tieba.im.message.b bVar) {
        this.a = msglistModel;
        this.c = bVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        UserData userData;
        com.baidu.tieba.im.db.q a = com.baidu.tieba.im.db.q.a();
        userData = this.a.g;
        return Boolean.valueOf(a.b(String.valueOf(userData.getUserId()), String.valueOf(this.c.l())));
    }
}
