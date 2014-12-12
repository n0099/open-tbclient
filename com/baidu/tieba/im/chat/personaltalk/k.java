package com.baidu.tieba.im.chat.personaltalk;

import android.app.Dialog;
import android.content.DialogInterface;
/* loaded from: classes.dex */
class k implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonalTalkSettingActivity aTQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aTQ = personalTalkSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.adp.lib.g.k.b((Dialog) dialogInterface, this.aTQ.getPageContext());
    }
}
