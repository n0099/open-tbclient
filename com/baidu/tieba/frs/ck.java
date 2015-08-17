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
public class ck implements View.OnClickListener {
    final /* synthetic */ cj aYj;
    private final /* synthetic */ com.baidu.tbadk.core.data.q aYk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cj cjVar, com.baidu.tbadk.core.data.q qVar) {
        this.aYj = cjVar;
        this.aYk = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.q qVar;
        Context context;
        Context context2;
        com.baidu.tbadk.core.data.q qVar2;
        TiebaStatic.log("cluster_btn_addFd");
        com.baidu.tbadk.core.data.r rZ = this.aYk.rZ();
        qVar = this.aYj.aYi;
        if (qVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.aYj.mContext;
            String valueOf = String.valueOf(rZ.getUserId());
            String name = rZ.getName();
            String sf = rZ.sf();
            qVar2 = this.aYj.aYi;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context2, valueOf, name, sf, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, qVar2.sc())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context = this.aYj.mContext;
        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(rZ.getUserId()), rZ.getName(), rZ.sf(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
