package com.baidu.tieba.im.mygroup;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonGroupActivity bfC;
    private final /* synthetic */ int bfD;
    private final /* synthetic */ ShareFromGameCenterMsgData bfE;
    private final /* synthetic */ a bfF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PersonGroupActivity personGroupActivity, int i, ShareFromGameCenterMsgData shareFromGameCenterMsgData, a aVar) {
        this.bfC = personGroupActivity;
        this.bfD = i;
        this.bfE = shareFromGameCenterMsgData;
        this.bfF = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long G = com.baidu.tieba.im.memorycache.c.PK().G(String.valueOf(this.bfD), 1);
        MessageUtils.createGroupChatMessage(G, 9, this.bfE.toChatMessageContent(), this.bfD);
        MessageUtils.createGroupChatMessage(G + 1, 1, this.bfF.getLeaveMsg(), this.bfD);
        aVar.dismiss();
        this.bfC.setResult(-1);
        if (UtilHelper.getNetStatusInfo(this.bfC.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.bfC.showToast(this.bfC.getString(y.no_network_guide));
        }
        this.bfC.finish();
    }
}
