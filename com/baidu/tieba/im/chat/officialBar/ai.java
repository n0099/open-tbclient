package com.baidu.tieba.im.chat.officialBar;

import android.content.DialogInterface;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
class ai implements DialogInterface.OnClickListener {
    final /* synthetic */ OfficialBarInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(OfficialBarInfoActivity officialBarInfoActivity) {
        this.a = officialBarInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        String str;
        OfficialBarInfoActivity officialBarInfoActivity = this.a;
        i2 = this.a.c;
        officialBarInfoActivity.sendMessage(new CustomMessage((int) MessageTypes.CMD_DEL_OFFICIAL_DB, String.valueOf(i2)));
        StringBuilder sb = new StringBuilder("clear cache by official:");
        str = this.a.d;
        BdSocketLinkService.startService(true, sb.append(str).toString());
        dialogInterface.cancel();
    }
}
