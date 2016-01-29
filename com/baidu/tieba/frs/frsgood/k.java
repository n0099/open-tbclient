package com.baidu.tieba.frs.frsgood;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ FrsGoodActivity bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsGoodActivity frsGoodActivity) {
        this.bnm = frsGoodActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        str = this.bnm.bfv;
        com.baidu.tieba.tbadkCore.util.m.mO(str);
    }
}
