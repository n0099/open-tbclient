package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h aum;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aum = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ab abVar;
        ab abVar2;
        abVar = this.aum.auh;
        if (abVar != null) {
            abVar2 = this.aum.auh;
            abVar2.lw();
        }
    }
}
