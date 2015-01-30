package com.baidu.tieba.im.mygroup;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int bkA;
    private final /* synthetic */ ShareFromGameCenterMsgData bkB;
    private final /* synthetic */ com.baidu.tieba.im.widget.b bkC;
    final /* synthetic */ PersonGroupActivity bkz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PersonGroupActivity personGroupActivity, int i, ShareFromGameCenterMsgData shareFromGameCenterMsgData, com.baidu.tieba.im.widget.b bVar) {
        this.bkz = personGroupActivity;
        this.bkA = i;
        this.bkB = shareFromGameCenterMsgData;
        this.bkC = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long M = com.baidu.tieba.im.memorycache.c.QO().M(String.valueOf(this.bkA), 1);
        MessageUtils.createGroupChatMessage(M, 9, this.bkB.toChatMessageContent(), this.bkA);
        MessageUtils.createGroupChatMessage(M + 1, 1, this.bkC.getLeaveMsg(), this.bkA);
        aVar.dismiss();
        this.bkz.setResult(-1);
        if (UtilHelper.getNetStatusInfo(this.bkz.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.bkz.showToast(this.bkz.getPageContext().getContext().getString(z.no_network_guide));
        }
        this.bkz.finish();
    }
}
