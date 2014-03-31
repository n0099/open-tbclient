package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class am extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ x b;
    private final /* synthetic */ ResponseCommitGroupMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(x xVar, ResponseCommitGroupMessage responseCommitGroupMessage) {
        this.b = xVar;
        this.c = responseCommitGroupMessage;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().b(this.c.j(), String.valueOf(this.c.i()), String.valueOf(this.c.d()), 3));
    }
}
