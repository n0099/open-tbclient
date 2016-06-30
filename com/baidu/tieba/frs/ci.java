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
    final /* synthetic */ ch bGh;
    private final /* synthetic */ com.baidu.tbadk.core.data.ao bGi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar, com.baidu.tbadk.core.data.ao aoVar) {
        this.bGh = chVar;
        this.bGi = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.ao aoVar;
        Context context;
        Context context2;
        com.baidu.tbadk.core.data.ao aoVar2;
        TiebaStatic.log("cluster_btn_addFd");
        com.baidu.tbadk.core.data.aq pR = this.bGi.pR();
        aoVar = this.bGh.bGg;
        if (aoVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.bGh.mContext;
            String valueOf = String.valueOf(pR.getUserId());
            String name = pR.getName();
            String qb = pR.qb();
            aoVar2 = this.bGh.bGg;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context2, valueOf, name, qb, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, aoVar2.pU())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context = this.bGh.mContext;
        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(pR.getUserId()), pR.getName(), pR.qb(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
