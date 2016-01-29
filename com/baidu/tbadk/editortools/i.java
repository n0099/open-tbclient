package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h atj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.atj = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        z zVar;
        z zVar2;
        zVar = this.atj.ate;
        if (zVar != null) {
            zVar2 = this.atj.ate;
            zVar2.ow();
        }
    }
}
