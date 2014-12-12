package com.baidu.tieba.im.chat.personaltalk;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class f implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonalTalkSettingActivity aTQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aTQ = personalTalkSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        o oVar;
        oVar = this.aTQ.aTP;
        oVar.cz(false);
    }
}
