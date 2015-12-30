package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h asq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.asq = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        z zVar;
        z zVar2;
        zVar = this.asq.asl;
        if (zVar != null) {
            zVar2 = this.asq.asl;
            zVar2.ob();
        }
    }
}
