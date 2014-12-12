package com.baidu.tieba.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c biB;
    private final /* synthetic */ boolean biC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.biB = cVar;
        this.biC = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SecretSettingActivity secretSettingActivity;
        g gVar;
        secretSettingActivity = this.biB.biA;
        gVar = secretSettingActivity.biu;
        gVar.dd(!this.biC);
    }
}
