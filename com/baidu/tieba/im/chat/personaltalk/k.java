package com.baidu.tieba.im.chat.personaltalk;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class k implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonalTalkSettingActivity aSE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aSE = personalTalkSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        n nVar;
        com.baidu.tbadk.core.j.l(this.aSE, "personalchat_morepage_addblack");
        nVar = this.aSE.aSD;
        nVar.cM(true);
    }
}
