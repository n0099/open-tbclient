package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public abstract class d extends SingleRunnable<ResponsedMessage> {

    /* renamed from: a  reason: collision with root package name */
    private Message f1794a = null;

    public abstract ResponsedMessage a(Message message);

    public Message a() {
        return this.f1794a;
    }

    public void b(Message message) {
        this.f1794a = message;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: c */
    public ResponsedMessage b() {
        ResponsedMessage a2 = a(a());
        if (a2 != null) {
            a2.setOrginalMessage(this.f1794a);
        }
        return a2;
    }
}
