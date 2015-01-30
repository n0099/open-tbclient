package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        str = this.aDW.aCQ;
        com.baidu.tieba.tbadkCore.util.j.is(str);
    }
}
