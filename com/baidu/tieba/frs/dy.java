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
public class dy implements View.OnClickListener {
    final /* synthetic */ dx blc;
    private final /* synthetic */ com.baidu.tbadk.core.data.y bld;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(dx dxVar, com.baidu.tbadk.core.data.y yVar) {
        this.blc = dxVar;
        this.bld = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.y yVar;
        Context context;
        Context context2;
        com.baidu.tbadk.core.data.y yVar2;
        TiebaStatic.log("cluster_btn_addFd");
        com.baidu.tbadk.core.data.aa sE = this.bld.sE();
        yVar = this.blc.blb;
        if (yVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.blc.mContext;
            String valueOf = String.valueOf(sE.getUserId());
            String name = sE.getName();
            String sO = sE.sO();
            yVar2 = this.blc.blb;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context2, valueOf, name, sO, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, yVar2.sH())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context = this.blc.mContext;
        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(context, String.valueOf(sE.getUserId()), sE.getName(), sE.sO(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
