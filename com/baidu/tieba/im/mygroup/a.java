package com.baidu.tieba.im.mygroup;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonGroupActivity blD;
    private final /* synthetic */ int blE;
    private final /* synthetic */ ShareFromGameCenterMsgData blF;
    private final /* synthetic */ com.baidu.tieba.im.widget.b blG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PersonGroupActivity personGroupActivity, int i, ShareFromGameCenterMsgData shareFromGameCenterMsgData, com.baidu.tieba.im.widget.b bVar) {
        this.blD = personGroupActivity;
        this.blE = i;
        this.blF = shareFromGameCenterMsgData;
        this.blG = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long I = com.baidu.tieba.im.memorycache.c.Sq().I(String.valueOf(this.blE), 1);
        MessageUtils.createGroupChatMessage(I, 9, this.blF.toChatMessageContent(), this.blE);
        MessageUtils.createGroupChatMessage(I + 1, 1, this.blG.getLeaveMsg(), this.blE);
        aVar.dismiss();
        this.blD.setResult(-1);
        if (UtilHelper.getNetStatusInfo(this.blD.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.blD.showToast(this.blD.getPageContext().getContext().getString(y.no_network_guide));
        }
        this.blD.finish();
    }
}
