package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class cc extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ cb aSP;
    private final /* synthetic */ LinkedList aSQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(cb cbVar, LinkedList linkedList) {
        this.aSP = cbVar;
        this.aSQ = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KK */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.o.Nk().j(this.aSQ);
    }
}
