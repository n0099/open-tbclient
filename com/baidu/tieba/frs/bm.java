package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements com.baidu.tieba.tbadkCore.c {
    final /* synthetic */ bk aEO;
    private final /* synthetic */ bn aEP;
    private final /* synthetic */ com.baidu.tbadk.core.data.m aES;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bk bkVar, bn bnVar, com.baidu.tbadk.core.data.m mVar) {
        this.aEO = bkVar;
        this.aEP = bnVar;
        this.aES = mVar;
    }

    @Override // com.baidu.tieba.tbadkCore.c
    public void eO(int i) {
        int eQ;
        Context context;
        Context context2;
        eQ = this.aEP.eQ(i);
        if (this.aES != null && this.aES.mJ() != null && eQ >= 0 && eQ < this.aES.mJ().size()) {
            context = this.aEO.mContext;
            com.baidu.tbadk.core.i.A(context, "forum_live_ck");
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.aEO.mContext;
            messageManager.sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(context2, this.aES.mJ().get(eQ).getGroupId())));
        }
    }
}
