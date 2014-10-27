package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.BackupLiveRoomChatActivityConfig;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements com.baidu.tieba.view.d {
    final /* synthetic */ bp aCe;
    private final /* synthetic */ bs aCf;
    private final /* synthetic */ com.baidu.tbadk.core.data.i aCi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bp bpVar, bs bsVar, com.baidu.tbadk.core.data.i iVar) {
        this.aCe = bpVar;
        this.aCf = bsVar;
        this.aCi = iVar;
    }

    @Override // com.baidu.tieba.view.d
    public void eK(int i) {
        int eM;
        Context context;
        Context context2;
        Context context3;
        eM = this.aCf.eM(i);
        if (this.aCi != null && this.aCi.jY() != null && eM >= 0 && eM < this.aCi.jY().size()) {
            context = this.aCe.mContext;
            com.baidu.tbadk.core.i.l(context, "forum_live_ck");
            LiveCardData liveCardData = this.aCi.jY().get(eM);
            if (TbadkApplication.m251getInst().isLiveSDKOpen()) {
                MessageManager messageManager = MessageManager.getInstance();
                context3 = this.aCe.mContext;
                messageManager.sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(context3, liveCardData.getGroupId())));
                return;
            }
            MessageManager messageManager2 = MessageManager.getInstance();
            context2 = this.aCe.mContext;
            messageManager2.sendMessage(new CustomMessage(2002001, new BackupLiveRoomChatActivityConfig(context2, liveCardData.getGroupId())));
        }
    }
}
