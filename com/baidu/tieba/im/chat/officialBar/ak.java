package com.baidu.tieba.im.chat.officialBar;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class ak implements DialogInterface.OnClickListener {
    final /* synthetic */ OfficialBarInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(OfficialBarInfoActivity officialBarInfoActivity) {
        this.a = officialBarInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        String str;
        OfficialBarInfoActivity officialBarInfoActivity = this.a;
        i2 = this.a.c;
        officialBarInfoActivity.sendMessage(new com.baidu.adp.framework.message.a(2001155, String.valueOf(i2)));
        com.baidu.adp.framework.e.c.a();
        StringBuilder sb = new StringBuilder("clear cache by official:");
        str = this.a.d;
        com.baidu.adp.framework.e.c.a(true, sb.append(str).toString());
        dialogInterface.cancel();
    }
}
