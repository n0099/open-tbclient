package com.baidu.tieba.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bjY;
    private final /* synthetic */ boolean bjZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.bjY = cVar;
        this.bjZ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SecretSettingActivity secretSettingActivity;
        g gVar;
        secretSettingActivity = this.bjY.bjX;
        gVar = secretSettingActivity.bjR;
        gVar.di(!this.bjZ);
    }
}
