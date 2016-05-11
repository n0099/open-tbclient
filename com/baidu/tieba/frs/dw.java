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
public class dw implements View.OnClickListener {
    final /* synthetic */ dv blu;
    private final /* synthetic */ com.baidu.tbadk.core.data.am blv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dw(dv dvVar, com.baidu.tbadk.core.data.am amVar) {
        this.blu = dvVar;
        this.blv = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.am amVar;
        Context context;
        Context context2;
        com.baidu.tbadk.core.data.am amVar2;
        TiebaStatic.log("cluster_btn_addFd");
        com.baidu.tbadk.core.data.ao pX = this.blv.pX();
        amVar = this.blu.blt;
        if (amVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.blu.mContext;
            String valueOf = String.valueOf(pX.getUserId());
            String name = pX.getName();
            String qh = pX.qh();
            amVar2 = this.blu.blt;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context2, valueOf, name, qh, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, amVar2.qa())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context = this.blu.mContext;
        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(pX.getUserId()), pX.getName(), pX.qh(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
