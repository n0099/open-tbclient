package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements Runnable {
    final /* synthetic */ r bPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(r rVar) {
        this.bPn = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.tbadkCore.util.l.qc(this.bPn.bOf);
    }
}
