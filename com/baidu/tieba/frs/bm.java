package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements com.baidu.tieba.tbadkCore.c {
    final /* synthetic */ bk aER;
    private final /* synthetic */ bn aES;
    private final /* synthetic */ com.baidu.tbadk.core.data.m aEV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bk bkVar, bn bnVar, com.baidu.tbadk.core.data.m mVar) {
        this.aER = bkVar;
        this.aES = bnVar;
        this.aEV = mVar;
    }

    @Override // com.baidu.tieba.tbadkCore.c
    public void eO(int i) {
        int eQ;
        Context context;
        Context context2;
        eQ = this.aES.eQ(i);
        if (this.aEV != null && this.aEV.mQ() != null && eQ >= 0 && eQ < this.aEV.mQ().size()) {
            context = this.aER.mContext;
            com.baidu.tbadk.core.i.A(context, "forum_live_ck");
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.aER.mContext;
            messageManager.sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(context2, this.aEV.mQ().get(eQ).getGroupId())));
        }
    }
}
