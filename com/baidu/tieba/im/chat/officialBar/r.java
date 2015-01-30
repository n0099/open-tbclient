package com.baidu.tieba.im.chat.officialBar;

import java.util.LinkedList;
/* loaded from: classes.dex */
class r extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ LinkedList aSQ;
    final /* synthetic */ q aUo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, LinkedList linkedList) {
        this.aUo = qVar;
        this.aSQ = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KK */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.n.Nj().j(this.aSQ);
    }
}
