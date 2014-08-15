package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bl implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
