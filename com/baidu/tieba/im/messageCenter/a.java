package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.message.Message;
/* loaded from: classes.dex */
public abstract class a extends SingleRunnable<Message> {

    /* renamed from: a  reason: collision with root package name */
    private Message f1719a = null;
    private com.baidu.tieba.im.codec.p b = null;

    public abstract Message a(Message message, com.baidu.tieba.im.codec.p pVar);

    public Message a() {
        return this.f1719a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: c */
    public Message b() {
        return a(a(), d());
    }

    public com.baidu.tieba.im.codec.p d() {
        return this.b;
    }
}
