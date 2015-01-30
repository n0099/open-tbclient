package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
class ct implements View.OnClickListener {
    final /* synthetic */ cs aGO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cs csVar) {
        this.aGO = csVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.t tVar;
        Context context2;
        Context context3;
        com.baidu.tbadk.core.data.t tVar2;
        context = this.aGO.mContext;
        com.baidu.tbadk.core.i.A(context, "cluster_btn_addFd");
        if (view.getTag() instanceof com.baidu.tbadk.core.data.u) {
            com.baidu.tbadk.core.data.u uVar = (com.baidu.tbadk.core.data.u) view.getTag();
            tVar = this.aGO.aGN;
            if (tVar != null) {
                MessageManager messageManager = MessageManager.getInstance();
                context3 = this.aGO.mContext;
                String valueOf = String.valueOf(uVar.getUserId());
                String name = uVar.getName();
                String nn = uVar.nn();
                tVar2 = this.aGO.aGN;
                messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context3, valueOf, name, nn, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, tVar2.nk())));
                return;
            }
            MessageManager messageManager2 = MessageManager.getInstance();
            context2 = this.aGO.mContext;
            messageManager2.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context2, String.valueOf(uVar.getUserId()), uVar.getName(), uVar.nn(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
        }
    }
}
