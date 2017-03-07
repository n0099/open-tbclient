package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h ayP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.ayP = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        y yVar;
        y yVar2;
        yVar = this.ayP.ayK;
        if (yVar != null) {
            yVar2 = this.ayP.ayK;
            yVar2.ml();
        }
    }
}
