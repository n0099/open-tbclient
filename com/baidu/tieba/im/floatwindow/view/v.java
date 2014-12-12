package com.baidu.tieba.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class v extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ LinkedList aRH;
    final /* synthetic */ u aYG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, LinkedList linkedList) {
        this.aYG = uVar;
        this.aRH = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.o.MO().j(this.aRH);
    }
}
