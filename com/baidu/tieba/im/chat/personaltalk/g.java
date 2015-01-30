package com.baidu.tieba.im.chat.personaltalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    private final /* synthetic */ boolean aRz;
    final /* synthetic */ PersonalTalkSettingActivity aVk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.aVk = personalTalkSettingActivity;
        this.aRz = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        x xVar;
        x xVar2;
        x xVar3;
        xVar = this.aVk.aVh;
        xVar.a((com.baidu.adp.widget.BdSwitchView.c) null);
        xVar2 = this.aVk.aVh;
        xVar2.cF(!this.aRz);
        xVar3 = this.aVk.aVh;
        xVar3.a(this.aVk);
    }
}
