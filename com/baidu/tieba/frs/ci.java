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
public class ci implements View.OnClickListener {
    final /* synthetic */ ch bHD;
    private final /* synthetic */ com.baidu.tbadk.core.data.at bHE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar, com.baidu.tbadk.core.data.at atVar) {
        this.bHD = chVar;
        this.bHE = atVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.at atVar;
        Context context;
        Context context2;
        com.baidu.tbadk.core.data.at atVar2;
        TiebaStatic.log("cluster_btn_addFd");
        com.baidu.tbadk.core.data.av pA = this.bHE.pA();
        atVar = this.bHD.bHC;
        if (atVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.bHD.mContext;
            String valueOf = String.valueOf(pA.getUserId());
            String name = pA.getName();
            String pK = pA.pK();
            atVar2 = this.bHD.bHC;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context2, valueOf, name, pK, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, atVar2.pD())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context = this.bHD.mContext;
        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(pA.getUserId()), pA.getName(), pA.pK(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
