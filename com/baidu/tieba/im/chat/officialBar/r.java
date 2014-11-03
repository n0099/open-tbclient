package com.baidu.tieba.im.chat.officialBar;

import java.util.LinkedList;
/* loaded from: classes.dex */
class r extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ LinkedList aPZ;
    final /* synthetic */ q aRs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, LinkedList linkedList) {
        this.aRs = qVar;
        this.aPZ = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.n.MT().j(this.aPZ);
    }
}
