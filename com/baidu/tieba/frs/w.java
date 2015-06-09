package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {
    final /* synthetic */ FrsActivity aLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.aLY = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        str = this.aLY.aLc;
        com.baidu.tieba.tbadkCore.util.j.jH(str);
    }
}
