package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        str = this.aCV.aBP;
        com.baidu.tieba.tbadkCore.util.j.il(str);
    }
}
