package com.baidu.tieba.im.chat.personaltalk;

import android.content.DialogInterface;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class d implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonalTalkSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.a = personalTalkSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        long j;
        this.a.showLoadingDialog(null);
        StringBuilder sb = new StringBuilder("see del person :");
        j = this.a.c;
        BdLog.d(sb.append(j).toString());
        com.baidu.tieba.im.i.a(new e(this), new f(this));
    }
}
