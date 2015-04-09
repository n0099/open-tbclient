package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ cb aME;
    private final /* synthetic */ com.baidu.tbadk.core.data.s aMF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(cb cbVar, com.baidu.tbadk.core.data.s sVar) {
        this.aME = cbVar;
        this.aMF = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.s sVar;
        Context context2;
        Context context3;
        com.baidu.tbadk.core.data.s sVar2;
        context = this.aME.mContext;
        com.baidu.tbadk.core.k.A(context, "cluster_btn_addFd");
        com.baidu.tbadk.core.data.t qq = this.aMF.qq();
        sVar = this.aME.aMD;
        if (sVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context3 = this.aME.mContext;
            String valueOf = String.valueOf(qq.getUserId());
            String name = qq.getName();
            String qw = qq.qw();
            sVar2 = this.aME.aMD;
            messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context3, valueOf, name, qw, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, sVar2.qt())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context2 = this.aME.mContext;
        messageManager2.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context2, String.valueOf(qq.getUserId()), qq.getName(), qq.qw(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
