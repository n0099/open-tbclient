package com.baidu.tieba.im.chat.officialBar;

import java.util.LinkedList;
/* loaded from: classes.dex */
class r extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ LinkedList aSP;
    final /* synthetic */ q aUn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, LinkedList linkedList) {
        this.aUn = qVar;
        this.aSP = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KF */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.n.Ne().j(this.aSP);
    }
}
