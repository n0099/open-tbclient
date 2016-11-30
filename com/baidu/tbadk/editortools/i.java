package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h auK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.auK = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ab abVar;
        ab abVar2;
        abVar = this.auK.auF;
        if (abVar != null) {
            abVar2 = this.auK.auF;
            abVar2.lz();
        }
    }
}
