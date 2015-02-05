package com.baidu.tieba.im.chat.personaltalk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    private final /* synthetic */ boolean aRy;
    final /* synthetic */ PersonalTalkSettingActivity aVj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.aVj = personalTalkSettingActivity;
        this.aRy = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        x xVar;
        x xVar2;
        x xVar3;
        xVar = this.aVj.aVg;
        xVar.a((com.baidu.adp.widget.BdSwitchView.c) null);
        xVar2 = this.aVj.aVg;
        xVar2.cF(!this.aRy);
        xVar3 = this.aVj.aVg;
        xVar3.a(this.aVj);
    }
}
