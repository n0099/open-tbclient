package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.message.s;
/* loaded from: classes.dex */
public abstract class d extends com.baidu.tieba.im.c<da> {
    private s a = null;

    public abstract da a(s sVar);

    public s a() {
        return this.a;
    }

    public void b(s sVar) {
        this.a = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: c */
    public da b() {
        da a = a(a());
        if (a != null) {
            a.a(this.a);
        }
        return a;
    }
}
