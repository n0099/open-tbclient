package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ao extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ x b;
    private final /* synthetic */ long c;
    private final /* synthetic */ long d;
    private final /* synthetic */ ResponseCommitPersonalMessage e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(x xVar, long j, long j2, ResponseCommitPersonalMessage responseCommitPersonalMessage) {
        this.b = xVar;
        this.c = j;
        this.d = j2;
        this.e = responseCommitPersonalMessage;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.d().a(this.c, this.d, String.valueOf(this.e.i()), String.valueOf(this.e.d()), 3));
    }
}
