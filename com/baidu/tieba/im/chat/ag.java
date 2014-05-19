package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ x a;
    private final /* synthetic */ ResponsedMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(x xVar, ResponsedMessage responsedMessage) {
        this.a = xVar;
        this.b = responsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.a.a(this.b);
    }
}
