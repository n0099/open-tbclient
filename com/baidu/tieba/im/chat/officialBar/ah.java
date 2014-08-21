package com.baidu.tieba.im.chat.officialBar;

import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
/* loaded from: classes.dex */
class ah implements DialogInterface.OnClickListener {
    final /* synthetic */ OfficialBarInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(OfficialBarInfoActivity officialBarInfoActivity) {
        this.a = officialBarInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        int i3;
        String str;
        i2 = this.a.c;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.g(String.valueOf(i2), 4, null, 1)));
        OfficialBarInfoActivity officialBarInfoActivity = this.a;
        i3 = this.a.c;
        officialBarInfoActivity.sendMessage(new CustomMessage(2001155, String.valueOf(i3)));
        StringBuilder sb = new StringBuilder("clear cache by official:");
        str = this.a.d;
        BdSocketLinkService.startService(true, sb.append(str).toString());
        dialogInterface.cancel();
    }
}
