package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class an implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ x a;
    private final /* synthetic */ ResponseCommitGroupMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(x xVar, ResponseCommitGroupMessage responseCommitGroupMessage) {
        this.a = xVar;
        this.b = responseCommitGroupMessage;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* bridge */ /* synthetic */ void a(Boolean bool) {
        if (this.b != null) {
            this.a.a(this.b);
        }
    }
}
