package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements View.OnClickListener {
    final /* synthetic */ ca aOP;
    private final /* synthetic */ com.baidu.tbadk.core.data.s aOQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(ca caVar, com.baidu.tbadk.core.data.s sVar) {
        this.aOP = caVar;
        this.aOQ = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.s sVar;
        Context context2;
        Context context3;
        com.baidu.tbadk.core.data.s sVar2;
        context = this.aOP.mContext;
        com.baidu.tbadk.core.k.A(context, "cluster_btn_addFd");
        com.baidu.tbadk.core.data.t qW = this.aOQ.qW();
        sVar = this.aOP.aOO;
        if (sVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context3 = this.aOP.mContext;
            String valueOf = String.valueOf(qW.getUserId());
            String name = qW.getName();
            String rc = qW.rc();
            sVar2 = this.aOP.aOO;
            messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context3, valueOf, name, rc, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, sVar2.qZ())));
            return;
        }
        MessageManager messageManager2 = MessageManager.getInstance();
        context2 = this.aOP.mContext;
        messageManager2.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context2, String.valueOf(qW.getUserId()), qW.getName(), qW.rc(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
    }
}
