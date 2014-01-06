package com.baidu.tieba.data.emotions;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, ArrayList arrayList) {
        this.b = lVar;
        this.a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b = this.a;
        com.baidu.tieba.im.messageCenter.e.a().d(new com.baidu.tieba.im.message.d(-120));
    }
}
