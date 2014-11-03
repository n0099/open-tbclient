package com.baidu.tieba.im.selectfriend;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ ShareFromGameCenterMsgData bfS;
    private final /* synthetic */ com.baidu.tieba.im.mygroup.a bfT;
    final /* synthetic */ SelectFriendActivity biu;
    private final /* synthetic */ long biv;
    private final /* synthetic */ String biw;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.mygroup.a aVar) {
        this.biu = selectFriendActivity;
        this.biv = j;
        this.bfS = shareFromGameCenterMsgData;
        this.val$name = str;
        this.biw = str2;
        this.bfT = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long G = com.baidu.tieba.im.memorycache.c.PN().G(String.valueOf(this.biv), 2);
        MessageUtils.createPersonalChatMessage(G, 9, this.bfS.toChatMessageContent(), this.biv, this.val$name, this.biw);
        MessageUtils.createPersonalChatMessage(G + 1, 1, this.bfT.getLeaveMsg(), this.biv, this.val$name, this.biw);
        aVar.dismiss();
        this.biu.setResult(-1);
        if (UtilHelper.getNetStatusInfo(this.biu.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.biu.showToast(this.biu.getString(y.no_network_guide));
        }
        this.biu.finish();
    }
}
