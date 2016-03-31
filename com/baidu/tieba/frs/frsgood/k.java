package com.baidu.tieba.frs.frsgood;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ FrsGoodActivity bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsGoodActivity frsGoodActivity) {
        this.bsj = frsGoodActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        str = this.bsj.bkf;
        com.baidu.tieba.tbadkCore.util.m.oa(str);
    }
}
