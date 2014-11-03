package com.baidu.tieba.im.chat.personaltalk;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class g implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonalTalkSettingActivity aSE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aSE = personalTalkSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.aSE.showLoadingDialog(null);
        com.baidu.tieba.im.e.a(new h(this), new i(this));
    }
}
