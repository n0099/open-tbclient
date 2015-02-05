package com.baidu.tieba.im.mygroup;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ ShareFromGameCenterMsgData bkA;
    private final /* synthetic */ com.baidu.tieba.im.widget.b bkB;
    final /* synthetic */ PersonGroupActivity bky;
    private final /* synthetic */ int bkz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PersonGroupActivity personGroupActivity, int i, ShareFromGameCenterMsgData shareFromGameCenterMsgData, com.baidu.tieba.im.widget.b bVar) {
        this.bky = personGroupActivity;
        this.bkz = i;
        this.bkA = shareFromGameCenterMsgData;
        this.bkB = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long M = com.baidu.tieba.im.memorycache.c.QJ().M(String.valueOf(this.bkz), 1);
        MessageUtils.createGroupChatMessage(M, 9, this.bkA.toChatMessageContent(), this.bkz);
        MessageUtils.createGroupChatMessage(M + 1, 1, this.bkB.getLeaveMsg(), this.bkz);
        aVar.dismiss();
        this.bky.setResult(-1);
        if (UtilHelper.getNetStatusInfo(this.bky.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.bky.showToast(this.bky.getPageContext().getContext().getString(z.no_network_guide));
        }
        this.bky.finish();
    }
}
