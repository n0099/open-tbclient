package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements Runnable {
    final /* synthetic */ cs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cs csVar) {
        this.a = csVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.c();
    }
}
