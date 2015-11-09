package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h aoV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aoV = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        x xVar;
        x xVar2;
        xVar = this.aoV.aoR;
        if (xVar != null) {
            xVar2 = this.aoV.aoR;
            xVar2.ox();
        }
    }
}
