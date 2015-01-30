package com.baidu.tieba.im.selectfriend;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ ShareFromGameCenterMsgData bkB;
    private final /* synthetic */ com.baidu.tieba.im.widget.b bkC;
    final /* synthetic */ SelectFriendActivity bos;
    private final /* synthetic */ long bou;
    private final /* synthetic */ String bov;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.bos = selectFriendActivity;
        this.bou = j;
        this.bkB = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bov = str2;
        this.bkC = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long M = com.baidu.tieba.im.memorycache.c.QO().M(String.valueOf(this.bou), 2);
        MessageUtils.createPersonalChatMessage(M, 9, this.bkB.toChatMessageContent(), this.bou, this.val$name, this.bov);
        MessageUtils.createPersonalChatMessage(M + 1, 1, this.bkC.getLeaveMsg(), this.bou, this.val$name, this.bov);
        aVar.dismiss();
        this.bos.setResult(-1);
        if (UtilHelper.getNetStatusInfo(this.bos.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.bos.showToast(this.bos.getPageContext().getString(z.no_network_guide));
        }
        this.bos.finish();
    }
}
