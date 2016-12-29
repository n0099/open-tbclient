package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h aup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aup = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        y yVar;
        y yVar2;
        yVar = this.aup.auk;
        if (yVar != null) {
            yVar2 = this.aup.auk;
            yVar2.lz();
        }
    }
}
