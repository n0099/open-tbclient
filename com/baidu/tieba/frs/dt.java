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
    final /* synthetic */ ds ber;
    private final /* synthetic */ com.baidu.tbadk.core.data.u bes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar, com.baidu.tbadk.core.data.u uVar) {
        this.ber = dsVar;
        this.bes = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.u uVar;
        Context context;
        Context context2;
        com.baidu.tbadk.core.data.u uVar2;
        TiebaStatic.log("cluster_btn_addFd");
        com.baidu.tbadk.core.data.v so = this.bes.so();
        uVar = this.ber.beq;
        if (uVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.ber.mContext;
            String valueOf = String.valueOf(so.getUserId());
            String name = so.getName();
            String su = so.su();
            uVar2 = this.ber.beq;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context2, valueOf, name, su, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, uVar2.sr())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context = this.ber.mContext;
        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(so.getUserId()), so.getName(), so.su(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
