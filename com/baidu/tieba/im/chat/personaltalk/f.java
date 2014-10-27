package com.baidu.tieba.im.chat.personaltalk;

import android.app.Dialog;
import android.content.DialogInterface;
/* loaded from: classes.dex */
class f implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonalTalkSettingActivity aSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aSq = personalTalkSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.adp.lib.g.j.b((Dialog) dialogInterface, this.aSq);
    }
}
