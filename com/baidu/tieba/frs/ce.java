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
    final /* synthetic */ cd bSC;
    private final /* synthetic */ com.baidu.tbadk.core.data.ax bSD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cd cdVar, com.baidu.tbadk.core.data.ax axVar) {
        this.bSC = cdVar;
        this.bSD = axVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.ax axVar;
        Context context;
        Context context2;
        com.baidu.tbadk.core.data.ax axVar2;
        TiebaStatic.log("cluster_btn_addFd");
        com.baidu.tbadk.core.data.az qP = this.bSD.qP();
        axVar = this.bSC.bSB;
        if (axVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.bSC.mContext;
            String valueOf = String.valueOf(qP.getUserId());
            String name = qP.getName();
            String qZ = qP.qZ();
            axVar2 = this.bSC.bSB;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context2, valueOf, name, qZ, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, axVar2.qS())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context = this.bSC.mContext;
        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(qP.getUserId()), qP.getName(), qP.qZ(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
