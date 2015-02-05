package com.baidu.tieba.im.selectfriend;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ ShareFromGameCenterMsgData bkA;
    private final /* synthetic */ com.baidu.tieba.im.widget.b bkB;
    final /* synthetic */ SelectFriendActivity bor;
    private final /* synthetic */ long bot;
    private final /* synthetic */ String bou;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.bor = selectFriendActivity;
        this.bot = j;
        this.bkA = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bou = str2;
        this.bkB = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long M = com.baidu.tieba.im.memorycache.c.QJ().M(String.valueOf(this.bot), 2);
        MessageUtils.createPersonalChatMessage(M, 9, this.bkA.toChatMessageContent(), this.bot, this.val$name, this.bou);
        MessageUtils.createPersonalChatMessage(M + 1, 1, this.bkB.getLeaveMsg(), this.bot, this.val$name, this.bou);
        aVar.dismiss();
        this.bor.setResult(-1);
        if (UtilHelper.getNetStatusInfo(this.bor.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.bor.showToast(this.bor.getPageContext().getString(z.no_network_guide));
        }
        this.bor.finish();
    }
}
