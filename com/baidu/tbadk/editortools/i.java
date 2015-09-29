package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h aoP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aoP = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        wVar = this.aoP.aoL;
        if (wVar != null) {
            wVar2 = this.aoP.aoL;
            wVar2.ow();
        }
    }
}
