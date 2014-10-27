package com.baidu.tieba.im.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c beU;
    private final /* synthetic */ boolean beV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.beU = cVar;
        this.beV = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SecretSettingActivity secretSettingActivity;
        g gVar;
        secretSettingActivity = this.beU.beT;
        gVar = secretSettingActivity.beN;
        gVar.dp(!this.beV);
    }
}
