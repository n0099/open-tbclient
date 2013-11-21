package com.baidu.tieba.im.b;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseOnlineMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1471a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.f1471a = dVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        if (this.f1471a.b != null && (message instanceof ResponseOnlineMessage) && !((ResponseOnlineMessage) message).hasError() && this.f1471a.b != null) {
            this.f1471a.a();
            this.f1471a.b.c();
        }
    }
}
