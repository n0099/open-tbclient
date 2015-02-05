package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
class ct implements View.OnClickListener {
    final /* synthetic */ cs aGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cs csVar) {
        this.aGL = csVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.t tVar;
        Context context2;
        Context context3;
        com.baidu.tbadk.core.data.t tVar2;
        context = this.aGL.mContext;
        com.baidu.tbadk.core.i.A(context, "cluster_btn_addFd");
        if (view.getTag() instanceof com.baidu.tbadk.core.data.u) {
            com.baidu.tbadk.core.data.u uVar = (com.baidu.tbadk.core.data.u) view.getTag();
            tVar = this.aGL.aGK;
            if (tVar != null) {
                MessageManager messageManager = MessageManager.getInstance();
                context3 = this.aGL.mContext;
                String valueOf = String.valueOf(uVar.getUserId());
                String name = uVar.getName();
                String ng = uVar.ng();
                tVar2 = this.aGL.aGK;
                messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context3, valueOf, name, ng, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, tVar2.nd())));
                return;
            }
            MessageManager messageManager2 = MessageManager.getInstance();
            context2 = this.aGL.mContext;
            messageManager2.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context2, String.valueOf(uVar.getUserId()), uVar.getName(), uVar.ng(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
        }
    }
}
