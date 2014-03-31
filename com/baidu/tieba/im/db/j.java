package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
/* loaded from: classes.dex */
final class j extends com.baidu.tieba.im.m<Void> {
    final /* synthetic */ i b;
    private final /* synthetic */ ResponseRemoveMembersMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, ResponseRemoveMembersMessage responseRemoveMembersMessage) {
        this.b = iVar;
        this.c = responseRemoveMembersMessage;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        g.a();
        g.b(this.c.d(), true);
        return null;
    }
}
