package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ am aue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.aue = amVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.aue.Dg();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
