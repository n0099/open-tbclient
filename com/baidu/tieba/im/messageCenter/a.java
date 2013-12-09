package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.message.Message;
/* loaded from: classes.dex */
public abstract class a extends SingleRunnable<Message> {

    /* renamed from: a  reason: collision with root package name */
    private Message f1794a = null;
    private com.baidu.tieba.im.b.p b = null;

    public abstract Message a(Message message, com.baidu.tieba.im.b.p pVar);

    public Message a() {
        return this.f1794a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: c */
    public Message b() {
        return a(a(), d());
    }

    public com.baidu.tieba.im.b.p d() {
        return this.b;
    }
}
