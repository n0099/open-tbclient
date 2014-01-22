package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.SingleRunnable;
/* loaded from: classes.dex */
public abstract class a extends SingleRunnable<com.baidu.tieba.im.message.q> {
    private com.baidu.tieba.im.message.q a = null;
    private com.baidu.tieba.im.coder.d b = null;

    public abstract com.baidu.tieba.im.message.q a(com.baidu.tieba.im.message.q qVar, com.baidu.tieba.im.coder.d dVar);

    public com.baidu.tieba.im.message.q a() {
        return this.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: c */
    public com.baidu.tieba.im.message.q b() {
        return a(a(), d());
    }

    public com.baidu.tieba.im.coder.d d() {
        return this.b;
    }
}
