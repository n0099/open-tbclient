package com.baidu.tieba.data.emotions;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements Runnable {
    final /* synthetic */ l a;
    private final /* synthetic */ ArrayList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, ArrayList arrayList) {
        this.a = lVar;
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b = this.b;
        com.baidu.tieba.im.messageCenter.d.a().d(new com.baidu.tieba.im.message.e(-120));
    }
}
