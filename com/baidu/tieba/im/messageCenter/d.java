package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.message.cc;
/* loaded from: classes.dex */
public abstract class d extends SingleRunnable<cc> {
    private com.baidu.tieba.im.message.o a = null;

    public abstract cc a(com.baidu.tieba.im.message.o oVar);

    public com.baidu.tieba.im.message.o a() {
        return this.a;
    }

    public void b(com.baidu.tieba.im.message.o oVar) {
        this.a = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: c */
    public cc b() {
        cc a = a(a());
        if (a != null) {
            a.a(this.a);
        }
        return a;
    }
}
