package com.baidu.tieba.im.model;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.im.c<Boolean> {
    final /* synthetic */ MsglistModel a;
    private final /* synthetic */ com.baidu.tieba.im.message.w c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(MsglistModel msglistModel, com.baidu.tieba.im.message.w wVar, LinkedList linkedList) {
        this.a = msglistModel;
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
