package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements Runnable {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.tbadkCore.util.m.mO(this.bgz.bfv);
    }
}
