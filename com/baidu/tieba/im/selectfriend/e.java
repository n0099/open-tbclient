package com.baidu.tieba.im.selectfriend;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ ShareFromGameCenterMsgData bje;
    private final /* synthetic */ com.baidu.tieba.im.widget.b bjf;
    final /* synthetic */ SelectFriendActivity bmV;
    private final /* synthetic */ long bmX;
    private final /* synthetic */ String bmY;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.bmV = selectFriendActivity;
        this.bmX = j;
        this.bje = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bmY = str2;
        this.bjf = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long M = com.baidu.tieba.im.memorycache.c.Qs().M(String.valueOf(this.bmX), 2);
        MessageUtils.createPersonalChatMessage(M, 9, this.bje.toChatMessageContent(), this.bmX, this.val$name, this.bmY);
        MessageUtils.createPersonalChatMessage(M + 1, 1, this.bjf.getLeaveMsg(), this.bmX, this.val$name, this.bmY);
        aVar.dismiss();
        this.bmV.setResult(-1);
        if (UtilHelper.getNetStatusInfo(this.bmV.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.bmV.showToast(this.bmV.getPageContext().getString(z.no_network_guide));
        }
        this.bmV.finish();
    }
}
