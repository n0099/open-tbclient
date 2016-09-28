package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h atQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.atQ = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ab abVar;
        ab abVar2;
        abVar = this.atQ.atL;
        if (abVar != null) {
            abVar2 = this.atQ.atL;
            abVar2.lw();
        }
    }
}
