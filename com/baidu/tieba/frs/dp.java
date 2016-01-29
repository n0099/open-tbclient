package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dp implements Runnable {
    final /* synthetic */ Cdo bkH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(Cdo cdo) {
        this.bkH = cdo;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bkH.Qv();
    }
}
