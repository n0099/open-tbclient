package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements Runnable {
    final /* synthetic */ aq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar) {
        this.a = aqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.f();
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "run", e.toString());
        }
    }
}
