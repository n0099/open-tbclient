package com.baidu.tieba.im.b;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseOnlineMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1386a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar) {
        this.f1386a = dVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        if (this.f1386a.b != null && (message instanceof ResponseOnlineMessage) && !((ResponseOnlineMessage) message).hasError() && this.f1386a.b != null) {
            this.f1386a.a();
            this.f1386a.b.c();
        }
    }
}
