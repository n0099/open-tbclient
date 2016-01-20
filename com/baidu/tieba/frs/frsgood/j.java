package com.baidu.tieba.frs.frsgood;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ FrsGoodActivity bkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsGoodActivity frsGoodActivity) {
        this.bkp = frsGoodActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        str = this.bkp.bde;
        com.baidu.tieba.tbadkCore.util.m.my(str);
    }
}
