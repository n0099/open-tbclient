package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h azf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.azf = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        y yVar;
        y yVar2;
        yVar = this.azf.aza;
        if (yVar != null) {
            yVar2 = this.azf.aza;
            yVar2.mp();
        }
    }
}
