package com.baidu.tieba.im.chat.personaltalk;

import android.content.DialogInterface;
import com.baidu.tieba.im.db.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonalTalkSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.a = personalTalkSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        long j;
        long j2;
        this.a.showLoadingDialog(null);
        StringBuilder append = new StringBuilder().append("see del person :");
        j = this.a.c;
        com.baidu.adp.lib.h.e.d(append.append(j).toString());
        as a = as.a();
        j2 = this.a.c;
        a.a(String.valueOf(j2), new f(this));
    }
}
