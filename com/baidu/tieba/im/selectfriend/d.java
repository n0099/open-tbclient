package com.baidu.tieba.im.selectfriend;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ ShareFromGameCenterMsgData bfE;
    private final /* synthetic */ com.baidu.tieba.im.mygroup.a bfF;
    final /* synthetic */ SelectFriendActivity bif;
    private final /* synthetic */ long bih;
    private final /* synthetic */ String bii;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.mygroup.a aVar) {
        this.bif = selectFriendActivity;
        this.bih = j;
        this.bfE = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bii = str2;
        this.bfF = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long G = com.baidu.tieba.im.memorycache.c.PK().G(String.valueOf(this.bih), 2);
        MessageUtils.createPersonalChatMessage(G, 9, this.bfE.toChatMessageContent(), this.bih, this.val$name, this.bii);
        MessageUtils.createPersonalChatMessage(G + 1, 1, this.bfF.getLeaveMsg(), this.bih, this.val$name, this.bii);
        aVar.dismiss();
        this.bif.setResult(-1);
        if (UtilHelper.getNetStatusInfo(this.bif.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.bif.showToast(this.bif.getString(y.no_network_guide));
        }
        this.bif.finish();
    }
}
