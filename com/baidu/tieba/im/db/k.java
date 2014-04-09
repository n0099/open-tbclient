package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
/* loaded from: classes.dex */
final class k extends com.baidu.tieba.im.m<Void> {
    final /* synthetic */ j b;
    private final /* synthetic */ ResponseRemoveMembersMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, ResponseRemoveMembersMessage responseRemoveMembersMessage) {
        this.b = jVar;
        this.c = responseRemoveMembersMessage;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        h.a();
        h.c(this.c.d(), true);
        return null;
    }
}
