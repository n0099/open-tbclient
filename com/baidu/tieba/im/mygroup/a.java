package com.baidu.tieba.im.mygroup;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonGroupActivity bjc;
    private final /* synthetic */ int bjd;
    private final /* synthetic */ ShareFromGameCenterMsgData bje;
    private final /* synthetic */ com.baidu.tieba.im.widget.b bjf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PersonGroupActivity personGroupActivity, int i, ShareFromGameCenterMsgData shareFromGameCenterMsgData, com.baidu.tieba.im.widget.b bVar) {
        this.bjc = personGroupActivity;
        this.bjd = i;
        this.bje = shareFromGameCenterMsgData;
        this.bjf = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long M = com.baidu.tieba.im.memorycache.c.Qs().M(String.valueOf(this.bjd), 1);
        MessageUtils.createGroupChatMessage(M, 9, this.bje.toChatMessageContent(), this.bjd);
        MessageUtils.createGroupChatMessage(M + 1, 1, this.bjf.getLeaveMsg(), this.bjd);
        aVar.dismiss();
        this.bjc.setResult(-1);
        if (UtilHelper.getNetStatusInfo(this.bjc.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.bjc.showToast(this.bjc.getPageContext().getContext().getString(z.no_network_guide));
        }
        this.bjc.finish();
    }
}
