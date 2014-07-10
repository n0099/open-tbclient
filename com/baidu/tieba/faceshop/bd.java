package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements Runnable {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar) {
        this.a = bcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.f();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
