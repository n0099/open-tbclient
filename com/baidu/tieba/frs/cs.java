package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
class cs implements View.OnClickListener {
    final /* synthetic */ cr aFE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cr crVar) {
        this.aFE = crVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.s sVar;
        Context context2;
        Context context3;
        com.baidu.tbadk.core.data.s sVar2;
        context = this.aFE.mContext;
        com.baidu.tbadk.core.i.B(context, "cluster_btn_addFd");
        if (view.getTag() instanceof com.baidu.tbadk.core.data.t) {
            com.baidu.tbadk.core.data.t tVar = (com.baidu.tbadk.core.data.t) view.getTag();
            sVar = this.aFE.aFD;
            if (sVar != null) {
                MessageManager messageManager = MessageManager.getInstance();
                context3 = this.aFE.mContext;
                String valueOf = String.valueOf(tVar.getUserId());
                String name = tVar.getName();
                String nl = tVar.nl();
                sVar2 = this.aFE.aFD;
                messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context3, valueOf, name, nl, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, sVar2.ni())));
                return;
            }
            MessageManager messageManager2 = MessageManager.getInstance();
            context2 = this.aFE.mContext;
            messageManager2.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context2, String.valueOf(tVar.getUserId()), tVar.getName(), tVar.nl(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
        }
    }
}
