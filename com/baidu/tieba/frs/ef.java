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
public class ef implements View.OnClickListener {
    final /* synthetic */ ee bqs;
    private final /* synthetic */ com.baidu.tbadk.core.data.ai bqt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(ee eeVar, com.baidu.tbadk.core.data.ai aiVar) {
        this.bqs = eeVar;
        this.bqt = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.ai aiVar;
        Context context;
        Context context2;
        com.baidu.tbadk.core.data.ai aiVar2;
        TiebaStatic.log("cluster_btn_addFd");
        com.baidu.tbadk.core.data.ak sz = this.bqt.sz();
        aiVar = this.bqs.bqr;
        if (aiVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.bqs.mContext;
            String valueOf = String.valueOf(sz.getUserId());
            String name = sz.getName();
            String sJ = sz.sJ();
            aiVar2 = this.bqs.bqr;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context2, valueOf, name, sJ, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, aiVar2.sC())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context = this.bqs.mContext;
        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(sz.getUserId()), sz.getName(), sz.sJ(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
