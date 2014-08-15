package com.baidu.tieba.im.chat.personaltalk;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class i implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonalTalkSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.a = personalTalkSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        l lVar;
        com.baidu.tbadk.core.f.a(this.a, "personalchat_morepage_addblack");
        lVar = this.a.b;
        lVar.b(true);
    }
}
