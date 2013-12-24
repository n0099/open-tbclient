package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.message.bz;
/* loaded from: classes.dex */
public abstract class d extends SingleRunnable<bz> {
    private com.baidu.tieba.im.message.n a = null;

    public abstract bz a(com.baidu.tieba.im.message.n nVar);

    public com.baidu.tieba.im.message.n a() {
        return this.a;
    }

    public void b(com.baidu.tieba.im.message.n nVar) {
        this.a = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: c */
    public bz b() {
        bz a = a(a());
        if (a != null) {
            a.a(this.a);
        }
        return a;
    }
}
