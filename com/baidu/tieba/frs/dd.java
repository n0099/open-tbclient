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
public class dd implements View.OnClickListener {
    final /* synthetic */ dc aYl;
    private final /* synthetic */ com.baidu.tbadk.core.data.r aYm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(dc dcVar, com.baidu.tbadk.core.data.r rVar) {
        this.aYl = dcVar;
        this.aYm = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.r rVar;
        Context context;
        Context context2;
        com.baidu.tbadk.core.data.r rVar2;
        TiebaStatic.log("cluster_btn_addFd");
        com.baidu.tbadk.core.data.s rP = this.aYm.rP();
        rVar = this.aYl.aYk;
        if (rVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.aYl.mContext;
            String valueOf = String.valueOf(rP.getUserId());
            String name = rP.getName();
            String rV = rP.rV();
            rVar2 = this.aYl.aYk;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context2, valueOf, name, rV, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, rVar2.rS())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context = this.aYl.mContext;
        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(rP.getUserId()), rP.getName(), rP.rV(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
