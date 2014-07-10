package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ w a;
    private final /* synthetic */ ResponsedMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(w wVar, ResponsedMessage responsedMessage) {
        this.a = wVar;
        this.b = responsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.a.a(this.b);
    }
}
