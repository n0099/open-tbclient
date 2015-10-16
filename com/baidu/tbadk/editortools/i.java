package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h aoQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aoQ = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        wVar = this.aoQ.aoM;
        if (wVar != null) {
            wVar2 = this.aoQ.aoM;
            wVar2.ow();
        }
    }
}
