package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements com.baidu.tieba.tbadkCore.c {
    final /* synthetic */ bl aDP;
    private final /* synthetic */ bo aDQ;
    private final /* synthetic */ com.baidu.tbadk.core.data.l aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bl blVar, bo boVar, com.baidu.tbadk.core.data.l lVar) {
        this.aDP = blVar;
        this.aDQ = boVar;
        this.aDT = lVar;
    }

    @Override // com.baidu.tieba.tbadkCore.c
    public void eI(int i) {
        int eK;
        Context context;
        Context context2;
        eK = this.aDQ.eK(i);
        if (this.aDT != null && this.aDT.mO() != null && eK >= 0 && eK < this.aDT.mO().size()) {
            context = this.aDP.mContext;
            com.baidu.tbadk.core.i.B(context, "forum_live_ck");
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.aDP.mContext;
            messageManager.sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(context2, this.aDT.mO().get(eK).getGroupId())));
        }
    }
}
