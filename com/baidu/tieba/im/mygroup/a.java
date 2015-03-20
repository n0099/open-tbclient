package com.baidu.tieba.im.mygroup;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonGroupActivity bln;
    private final /* synthetic */ int blo;
    private final /* synthetic */ ShareFromGameCenterMsgData blp;
    private final /* synthetic */ com.baidu.tieba.im.widget.b blq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PersonGroupActivity personGroupActivity, int i, ShareFromGameCenterMsgData shareFromGameCenterMsgData, com.baidu.tieba.im.widget.b bVar) {
        this.bln = personGroupActivity;
        this.blo = i;
        this.blp = shareFromGameCenterMsgData;
        this.blq = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long I = com.baidu.tieba.im.memorycache.c.Sd().I(String.valueOf(this.blo), 1);
        MessageUtils.createGroupChatMessage(I, 9, this.blp.toChatMessageContent(), this.blo);
        MessageUtils.createGroupChatMessage(I + 1, 1, this.blq.getLeaveMsg(), this.blo);
        aVar.dismiss();
        this.bln.setResult(-1);
        if (UtilHelper.getNetStatusInfo(this.bln.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.bln.showToast(this.bln.getPageContext().getContext().getString(y.no_network_guide));
        }
        this.bln.finish();
    }
}
