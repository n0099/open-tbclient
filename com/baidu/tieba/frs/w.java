package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.aJG = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        str = this.aJG.aIK;
        com.baidu.tieba.tbadkCore.util.j.iK(str);
    }
}
