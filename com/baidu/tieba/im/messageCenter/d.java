package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.message.cr;
/* loaded from: classes.dex */
public abstract class d extends SingleRunnable<cr> {
    private com.baidu.tieba.im.message.q a = null;

    public abstract cr a(com.baidu.tieba.im.message.q qVar);

    public com.baidu.tieba.im.message.q a() {
        return this.a;
    }

    public void b(com.baidu.tieba.im.message.q qVar) {
        this.a = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: c */
    public cr b() {
        cr a = a(a());
        if (a != null) {
            a.a(this.a);
        }
        return a;
    }
}
