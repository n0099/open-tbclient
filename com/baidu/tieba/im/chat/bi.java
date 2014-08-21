package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
/* loaded from: classes.dex */
class bi implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bm bmVar;
        bm bmVar2;
        com.baidu.tbadk.core.f.a(this.a, "clear_group_msg_at_gsetting");
        this.a.showLoadingDialog(this.a.getString(com.baidu.tieba.x.deleting));
        bmVar = this.a.b;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.g(bmVar.b(), 1, null, 1)));
        com.baidu.tieba.im.e.a(new bj(this), new bk(this));
        StringBuilder sb = new StringBuilder("clear cache by group:");
        bmVar2 = this.a.b;
        BdSocketLinkService.startService(true, sb.append(bmVar2.a()).toString());
        dialogInterface.cancel();
    }
}
