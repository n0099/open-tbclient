package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.im.a<ResponsedMessage> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1732a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f1732a = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(ResponsedMessage responsedMessage) {
        this.f1732a.e(responsedMessage);
    }
}
