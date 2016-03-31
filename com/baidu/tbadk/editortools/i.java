package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h atI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.atI = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ab abVar;
        ab abVar2;
        abVar = this.atI.atD;
        if (abVar != null) {
            abVar2 = this.atI.atD;
            abVar2.op();
        }
    }
}
