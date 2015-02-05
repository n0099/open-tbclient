package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class cc extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ cb aSO;
    private final /* synthetic */ LinkedList aSP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(cb cbVar, LinkedList linkedList) {
        this.aSO = cbVar;
        this.aSP = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KF */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.o.Nf().j(this.aSP);
    }
}
