package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
/* loaded from: classes.dex */
class bi implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity aOC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(GroupSettingActivity groupSettingActivity) {
        this.aOC = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bm bmVar;
        bm bmVar2;
        com.baidu.tbadk.core.j.l(this.aOC, "clear_group_msg_at_gsetting");
        this.aOC.showLoadingDialog(this.aOC.getString(com.baidu.tieba.y.deleting));
        bmVar = this.aOC.aOw;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.f(bmVar.getGroupId(), 1, null, 1)));
        com.baidu.tieba.im.e.a(new bj(this), new bk(this));
        StringBuilder sb = new StringBuilder("clear cache by group:");
        bmVar2 = this.aOC.aOw;
        BdSocketLinkService.startService(true, sb.append(bmVar2.getGroupName()).toString());
        dialogInterface.cancel();
    }
}
