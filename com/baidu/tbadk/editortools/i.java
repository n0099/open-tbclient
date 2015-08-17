package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h aoE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aoE = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        wVar = this.aoE.aoA;
        if (wVar != null) {
            wVar2 = this.aoE.aoA;
            wVar2.oy();
        }
    }
}
