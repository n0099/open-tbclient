package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h atu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.atu = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        y yVar;
        y yVar2;
        yVar = this.atu.atp;
        if (yVar != null) {
            yVar2 = this.atu.atp;
            yVar2.lr();
        }
    }
}
