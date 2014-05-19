package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements Runnable {
    final /* synthetic */ bg a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg bgVar) {
        this.a = bgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.f();
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "run", e.toString());
        }
    }
}
