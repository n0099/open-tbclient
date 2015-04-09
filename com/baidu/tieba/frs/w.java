package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {
    final /* synthetic */ FrsActivity aJQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.aJQ = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        str = this.aJQ.aIS;
        com.baidu.tieba.tbadkCore.util.j.iN(str);
    }
}
