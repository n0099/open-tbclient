package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.a<ResponsedMessage> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1796a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f1796a = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ResponsedMessage responsedMessage) {
        this.f1796a.e(responsedMessage);
    }
}
