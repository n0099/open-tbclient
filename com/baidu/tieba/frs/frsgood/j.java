package com.baidu.tieba.frs.frsgood;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ FrsGoodActivity aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsGoodActivity frsGoodActivity) {
        this.aZp = frsGoodActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        str = this.aZp.aUq;
        com.baidu.tieba.tbadkCore.util.k.kA(str);
    }
}
