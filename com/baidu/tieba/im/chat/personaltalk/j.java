package com.baidu.tieba.im.chat.personaltalk;

import android.content.DialogInterface;
import com.baidu.tieba.as;
/* loaded from: classes.dex */
class j implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonalTalkSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.a = personalTalkSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        l lVar;
        as.a(this.a, "personalchat_morepage_addblack");
        lVar = this.a.b;
        lVar.b(true);
    }
}
