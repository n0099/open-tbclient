package com.baidu.tieba.im.chat.officialBar;

import java.util.LinkedList;
/* loaded from: classes.dex */
class r extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ LinkedList aPL;
    final /* synthetic */ q aRe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, LinkedList linkedList) {
        this.aRe = qVar;
        this.aPL = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.n.MP().j(this.aPL);
    }
}
