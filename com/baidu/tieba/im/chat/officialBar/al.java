package com.baidu.tieba.im.chat.officialBar;

import android.content.DialogInterface;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class al implements DialogInterface.OnClickListener {
    final /* synthetic */ OfficialBarInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(OfficialBarInfoActivity officialBarInfoActivity) {
        this.a = officialBarInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        String str;
        OfficialBarInfoActivity officialBarInfoActivity = this.a;
        i2 = this.a.c;
        officialBarInfoActivity.sendMessage(new CustomMessage(2001155, String.valueOf(i2)));
        StringBuilder sb = new StringBuilder("clear cache by official:");
        str = this.a.d;
        BdSocketLinkService.startService(true, sb.append(str).toString());
        dialogInterface.cancel();
    }
}
