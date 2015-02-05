package com.baidu.tieba.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bjX;
    private final /* synthetic */ boolean bjY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.bjX = cVar;
        this.bjY = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SecretSettingActivity secretSettingActivity;
        g gVar;
        secretSettingActivity = this.bjX.bjW;
        gVar = secretSettingActivity.bjQ;
        gVar.di(!this.bjY);
    }
}
