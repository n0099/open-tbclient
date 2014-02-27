package com.baidu.tieba.im.chat.personaltalk;

import android.content.DialogInterface;
import com.baidu.tieba.ai;
/* loaded from: classes.dex */
final class i implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonalTalkSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.a = personalTalkSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        l lVar;
        ai.a(this.a, "personalchat_morepage_addblack");
        lVar = this.a.b;
        lVar.b(true);
    }
}
