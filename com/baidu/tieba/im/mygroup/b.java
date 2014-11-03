package com.baidu.tieba.im.mygroup;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonGroupActivity bfQ;
    private final /* synthetic */ int bfR;
    private final /* synthetic */ ShareFromGameCenterMsgData bfS;
    private final /* synthetic */ a bfT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PersonGroupActivity personGroupActivity, int i, ShareFromGameCenterMsgData shareFromGameCenterMsgData, a aVar) {
        this.bfQ = personGroupActivity;
        this.bfR = i;
        this.bfS = shareFromGameCenterMsgData;
        this.bfT = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long G = com.baidu.tieba.im.memorycache.c.PN().G(String.valueOf(this.bfR), 1);
        MessageUtils.createGroupChatMessage(G, 9, this.bfS.toChatMessageContent(), this.bfR);
        MessageUtils.createGroupChatMessage(G + 1, 1, this.bfT.getLeaveMsg(), this.bfR);
        aVar.dismiss();
        this.bfQ.setResult(-1);
        if (UtilHelper.getNetStatusInfo(this.bfQ.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.bfQ.showToast(this.bfQ.getString(y.no_network_guide));
        }
        this.bfQ.finish();
    }
}
