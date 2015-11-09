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
    final /* synthetic */ dc aYu;
    private final /* synthetic */ com.baidu.tbadk.core.data.r aYv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(dc dcVar, com.baidu.tbadk.core.data.r rVar) {
        this.aYu = dcVar;
        this.aYv = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.r rVar;
        Context context;
        Context context2;
        com.baidu.tbadk.core.data.r rVar2;
        TiebaStatic.log("cluster_btn_addFd");
        com.baidu.tbadk.core.data.s rR = this.aYv.rR();
        rVar = this.aYu.aYt;
        if (rVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.aYu.mContext;
            String valueOf = String.valueOf(rR.getUserId());
            String name = rR.getName();
            String rX = rR.rX();
            rVar2 = this.aYu.aYt;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context2, valueOf, name, rX, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, rVar2.rU())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context = this.aYu.mContext;
        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(rR.getUserId()), rR.getName(), rR.rX(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
