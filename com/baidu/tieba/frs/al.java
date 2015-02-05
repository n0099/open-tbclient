package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        str = this.aDT.aCN;
        com.baidu.tieba.tbadkCore.util.j.iq(str);
    }
}
