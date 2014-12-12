package com.baidu.tieba.im.chat.personaltalk;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class h implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonalTalkSettingActivity aTQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aTQ = personalTalkSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.aTQ.showLoadingDialog(null);
        com.baidu.tieba.im.i.a(new i(this), new j(this));
    }
}
