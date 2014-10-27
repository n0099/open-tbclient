package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements Runnable {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        str = this.aBk.aAn;
        com.baidu.tieba.util.j.hz(str);
    }
}
