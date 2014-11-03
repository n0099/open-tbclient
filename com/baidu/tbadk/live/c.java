package com.baidu.tbadk.live;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ a Vw;
    private final /* synthetic */ String Vx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str) {
        this.Vw = aVar;
        this.Vx = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Vw.dz(this.Vx);
    }
}
