package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements Runnable {
    final /* synthetic */ bt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bt btVar) {
        this.a = btVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.o();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
