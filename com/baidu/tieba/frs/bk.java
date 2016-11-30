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
public class bk implements View.OnClickListener {
    final /* synthetic */ bj bUR;
    private final /* synthetic */ com.baidu.tbadk.core.data.az bUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar, com.baidu.tbadk.core.data.az azVar) {
        this.bUR = bjVar;
        this.bUS = azVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.az azVar;
        Context context;
        Context context2;
        com.baidu.tbadk.core.data.az azVar2;
        TiebaStatic.log("cluster_btn_addFd");
        com.baidu.tbadk.core.data.bb qR = this.bUS.qR();
        azVar = this.bUR.bUQ;
        if (azVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.bUR.mContext;
            String valueOf = String.valueOf(qR.getUserId());
            String name = qR.getName();
            String rb = qR.rb();
            azVar2 = this.bUR.bUQ;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context2, valueOf, name, rb, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, azVar2.qU())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context = this.bUR.mContext;
        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(qR.getUserId()), qR.getName(), qR.rb(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
