package com.baidu.tieba.im.b;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseOnlineMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1480a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.f1480a = dVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        if (this.f1480a.b != null && (message instanceof ResponseOnlineMessage) && !((ResponseOnlineMessage) message).hasError() && this.f1480a.b != null) {
            this.f1480a.a();
            this.f1480a.b.c();
        }
    }
}
