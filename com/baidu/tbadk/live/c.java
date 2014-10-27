package com.baidu.tbadk.live;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ a Vs;
    private final /* synthetic */ String Vt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str) {
        this.Vs = aVar;
        this.Vt = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Vs.dz(this.Vt);
    }
}
