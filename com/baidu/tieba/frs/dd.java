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
    final /* synthetic */ dc aYa;
    private final /* synthetic */ com.baidu.tbadk.core.data.q aYb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(dc dcVar, com.baidu.tbadk.core.data.q qVar) {
        this.aYa = dcVar;
        this.aYb = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.q qVar;
        Context context;
        Context context2;
        com.baidu.tbadk.core.data.q qVar2;
        TiebaStatic.log("cluster_btn_addFd");
        com.baidu.tbadk.core.data.r rS = this.aYb.rS();
        qVar = this.aYa.aXZ;
        if (qVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.aYa.mContext;
            String valueOf = String.valueOf(rS.getUserId());
            String name = rS.getName();
            String rY = rS.rY();
            qVar2 = this.aYa.aXZ;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context2, valueOf, name, rY, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, qVar2.rV())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context = this.aYa.mContext;
        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(rS.getUserId()), rS.getName(), rS.rY(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
