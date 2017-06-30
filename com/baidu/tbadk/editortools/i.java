package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h azT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.azT = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        y yVar;
        y yVar2;
        yVar = this.azT.azO;
        if (yVar != null) {
            yVar2 = this.azT.azO;
            yVar2.lM();
        }
    }
}
