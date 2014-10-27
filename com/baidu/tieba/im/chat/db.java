package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class db extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ da aPK;
    private final /* synthetic */ LinkedList aPL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(da daVar, LinkedList linkedList) {
        this.aPK = daVar;
        this.aPL = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.o.MQ().j(this.aPL);
    }
}
