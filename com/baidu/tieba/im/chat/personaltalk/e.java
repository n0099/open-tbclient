package com.baidu.tieba.im.chat.personaltalk;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonalTalkSettingActivity aSE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aSE = personalTalkSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        n nVar;
        nVar = this.aSE.aSD;
        nVar.cM(false);
    }
}
