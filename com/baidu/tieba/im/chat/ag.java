package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.tieba.im.c<Boolean> {
    final /* synthetic */ q a;
    private final /* synthetic */ com.baidu.tieba.im.message.w c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(q qVar, com.baidu.tieba.im.message.w wVar, LinkedList linkedList) {
        this.a = qVar;
        this.c = wVar;
        this.d = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(com.baidu.tieba.im.db.q.a().a(this.c.m(), this.c.c(), this.d, false));
    }
}
