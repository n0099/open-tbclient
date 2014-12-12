package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class bz extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ by aRG;
    private final /* synthetic */ LinkedList aRH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(by byVar, LinkedList linkedList) {
        this.aRG = byVar;
        this.aRH = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.o.MO().j(this.aRH);
    }
}
