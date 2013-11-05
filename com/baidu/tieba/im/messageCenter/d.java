package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public abstract class d extends SingleRunnable<ResponsedMessage> {

    /* renamed from: a  reason: collision with root package name */
    private Message f1642a = null;

    public abstract ResponsedMessage b(Message message);

    public Message a() {
        return this.f1642a;
    }

    public void a(Message message) {
        this.f1642a = message;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: c */
    public ResponsedMessage b() {
        ResponsedMessage b = b(a());
        if (b != null) {
            b.setOrginalMessage(this.f1642a);
        }
        return b;
    }
}
