package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ am atV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.atV = amVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.atV.De();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
