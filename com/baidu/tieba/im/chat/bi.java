package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
/* loaded from: classes.dex */
class bi implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity aOo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(GroupSettingActivity groupSettingActivity) {
        this.aOo = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bm bmVar;
        bm bmVar2;
        com.baidu.tbadk.core.i.l(this.aOo, "clear_group_msg_at_gsetting");
        this.aOo.showLoadingDialog(this.aOo.getString(com.baidu.tieba.y.deleting));
        bmVar = this.aOo.aOi;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.f(bmVar.getGroupId(), 1, null, 1)));
        com.baidu.tieba.im.e.a(new bj(this), new bk(this));
        StringBuilder sb = new StringBuilder("clear cache by group:");
        bmVar2 = this.aOo.aOi;
        BdSocketLinkService.startService(true, sb.append(bmVar2.getGroupName()).toString());
        dialogInterface.cancel();
    }
}
