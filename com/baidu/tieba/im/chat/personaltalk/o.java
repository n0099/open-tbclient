package com.baidu.tieba.im.chat.personaltalk;

import android.app.Dialog;
import android.content.DialogInterface;
/* loaded from: classes.dex */
class o implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonalTalkSettingActivity aVk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aVk = personalTalkSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.adp.lib.g.k.b((Dialog) dialogInterface, this.aVk.getPageContext());
    }
}
