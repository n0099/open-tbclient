package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.s;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tieba.im.c<s> {
    private s a = null;
    private com.baidu.tieba.im.coder.d c = null;

    public abstract s a(s sVar, com.baidu.tieba.im.coder.d dVar);

    public s a() {
        return this.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: c */
    public s b() {
        return a(a(), d());
    }

    public com.baidu.tieba.im.coder.d d() {
        return this.c;
    }
}
