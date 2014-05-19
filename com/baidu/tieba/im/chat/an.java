package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ x a;
    private final /* synthetic */ ResponseCommitGroupMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(x xVar, ResponseCommitGroupMessage responseCommitGroupMessage) {
        this.a = xVar;
        this.b = responseCommitGroupMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        if (this.b != null) {
            this.a.a((ResponsedMessage<?>) this.b);
        }
    }
}
