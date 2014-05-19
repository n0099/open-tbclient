package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements Runnable {
    final /* synthetic */ ap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap apVar) {
        this.a = apVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.a();
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "run", e.toString());
        }
    }
}
