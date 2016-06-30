package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h aqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aqq = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ab abVar;
        ab abVar2;
        abVar = this.aqq.aql;
        if (abVar != null) {
            abVar2 = this.aqq.aql;
            abVar2.kF();
        }
    }
}
