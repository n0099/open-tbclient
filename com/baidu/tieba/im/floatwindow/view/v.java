package com.baidu.tieba.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class v extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ LinkedList aSP;
    final /* synthetic */ u bab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, LinkedList linkedList) {
        this.bab = uVar;
        this.aSP = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KF */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.o.Nf().j(this.aSP);
    }
}
