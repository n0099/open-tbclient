package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h aqM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aqM = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        z zVar;
        z zVar2;
        zVar = this.aqM.aqH;
        if (zVar != null) {
            zVar2 = this.aqM.aqH;
            zVar2.oD();
        }
    }
}
