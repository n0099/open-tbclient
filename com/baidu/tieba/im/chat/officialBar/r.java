package com.baidu.tieba.im.chat.officialBar;

import java.util.LinkedList;
/* loaded from: classes.dex */
class r extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ LinkedList aRH;
    final /* synthetic */ q aSY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, LinkedList linkedList) {
        this.aSY = qVar;
        this.aRH = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.n.MN().j(this.aRH);
    }
}
