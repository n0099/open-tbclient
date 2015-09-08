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
public class co implements View.OnClickListener {
    final /* synthetic */ cn aYy;
    private final /* synthetic */ com.baidu.tbadk.core.data.r aYz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cn cnVar, com.baidu.tbadk.core.data.r rVar) {
        this.aYy = cnVar;
        this.aYz = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.r rVar;
        Context context;
        Context context2;
        com.baidu.tbadk.core.data.r rVar2;
        TiebaStatic.log("cluster_btn_addFd");
        com.baidu.tbadk.core.data.s rX = this.aYz.rX();
        rVar = this.aYy.aYx;
        if (rVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.aYy.mContext;
            String valueOf = String.valueOf(rX.getUserId());
            String name = rX.getName();
            String sd = rX.sd();
            rVar2 = this.aYy.aYx;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context2, valueOf, name, sd, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, rVar2.sa())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context = this.aYy.mContext;
        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(rX.getUserId()), rX.getName(), rX.sd(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
