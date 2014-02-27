package com.baidu.tieba.im.chat.personaltalk;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class j implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonalTalkSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.a = personalTalkSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
