package com.baidu.tieba.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bfi;
    private final /* synthetic */ boolean bfj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.bfi = cVar;
        this.bfj = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SecretSettingActivity secretSettingActivity;
        g gVar;
        secretSettingActivity = this.bfi.bfh;
        gVar = secretSettingActivity.bfb;
        gVar.dp(!this.bfj);
    }
}
