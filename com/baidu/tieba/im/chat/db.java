package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class db extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ da aPY;
    private final /* synthetic */ LinkedList aPZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(da daVar, LinkedList linkedList) {
        this.aPY = daVar;
        this.aPZ = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.o.MU().j(this.aPZ);
    }
}
