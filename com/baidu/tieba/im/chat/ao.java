package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ w a;
    private final /* synthetic */ ResponseCommitPersonalMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(w wVar, ResponseCommitPersonalMessage responseCommitPersonalMessage) {
        this.a = wVar;
        this.b = responseCommitPersonalMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        if (this.b != null) {
            this.a.a((ResponsedMessage<?>) this.b);
        }
    }
}
