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
public class dt implements View.OnClickListener {
    final /* synthetic */ ds bim;
    private final /* synthetic */ com.baidu.tbadk.core.data.u bin;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar, com.baidu.tbadk.core.data.u uVar) {
        this.bim = dsVar;
        this.bin = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.u uVar;
        Context context;
        Context context2;
        com.baidu.tbadk.core.data.u uVar2;
        TiebaStatic.log("cluster_btn_addFd");
        com.baidu.tbadk.core.data.v rX = this.bin.rX();
        uVar = this.bim.bil;
        if (uVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.bim.mContext;
            String valueOf = String.valueOf(rX.getUserId());
            String name = rX.getName();
            String sd = rX.sd();
            uVar2 = this.bim.bil;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context2, valueOf, name, sd, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, uVar2.sa())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context = this.bim.mContext;
        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(rX.getUserId()), rX.getName(), rX.sd(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
