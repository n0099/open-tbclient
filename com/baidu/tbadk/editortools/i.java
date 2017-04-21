package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h azh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.azh = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        y yVar;
        y yVar2;
        yVar = this.azh.azc;
        if (yVar != null) {
            yVar2 = this.azh.azc;
            yVar2.mp();
        }
    }
}
