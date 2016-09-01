package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements View.OnClickListener {
    final /* synthetic */ cd bSJ;
    private final /* synthetic */ com.baidu.tbadk.core.data.av bSK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cd cdVar, com.baidu.tbadk.core.data.av avVar) {
        this.bSJ = cdVar;
        this.bSK = avVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.av avVar;
        Context context;
        Context context2;
        com.baidu.tbadk.core.data.av avVar2;
        TiebaStatic.log("cluster_btn_addFd");
        com.baidu.tbadk.core.data.ax qE = this.bSK.qE();
        avVar = this.bSJ.bSI;
        if (avVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.bSJ.mContext;
            String valueOf = String.valueOf(qE.getUserId());
            String name = qE.getName();
            String qO = qE.qO();
            avVar2 = this.bSJ.bSI;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context2, valueOf, name, qO, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, avVar2.qH())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context = this.bSJ.mContext;
        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(qE.getUserId()), qE.getName(), qE.qO(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
