package com.baidu.tieba.im.chat.personaltalk;

import android.content.DialogInterface;
import com.baidu.tieba.im.db.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonalTalkSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.a = personalTalkSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        long j;
        long j2;
        this.a.showLoadingDialog(null);
        StringBuilder append = new StringBuilder().append("see del person :");
        j = this.a.c;
        com.baidu.adp.lib.g.e.d(append.append(j).toString());
        au a = au.a();
        j2 = this.a.c;
        a.a(String.valueOf(j2), new g(this));
    }
}
