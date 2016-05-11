package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h apA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.apA = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ab abVar;
        ab abVar2;
        abVar = this.apA.apv;
        if (abVar != null) {
            abVar2 = this.apA.apv;
            abVar2.kC();
        }
    }
}
