package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ x a;
    private final /* synthetic */ ResponseCommitPersonalMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(x xVar, ResponseCommitPersonalMessage responseCommitPersonalMessage) {
        this.a = xVar;
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
