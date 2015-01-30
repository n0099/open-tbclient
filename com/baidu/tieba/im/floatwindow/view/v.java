package com.baidu.tieba.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class v extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ LinkedList aSQ;
    final /* synthetic */ u bac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, LinkedList linkedList) {
        this.bac = uVar;
        this.aSQ = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KK */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.o.Nk().j(this.aSQ);
    }
}
