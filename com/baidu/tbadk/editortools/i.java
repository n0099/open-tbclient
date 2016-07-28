package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h arf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.arf = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ab abVar;
        ab abVar2;
        abVar = this.arf.ara;
        if (abVar != null) {
            abVar2 = this.arf.ara;
            abVar2.kB();
        }
    }
}
