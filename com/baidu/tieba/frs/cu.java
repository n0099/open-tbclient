package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
class cu implements View.OnClickListener {
    final /* synthetic */ ct aDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(ct ctVar) {
        this.aDZ = ctVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.o oVar;
        Context context2;
        Context context3;
        com.baidu.tbadk.core.data.o oVar2;
        context = this.aDZ.mContext;
        com.baidu.tbadk.core.j.l(context, "cluster_btn_addFd");
        if (view.getTag() instanceof com.baidu.tbadk.core.data.p) {
            com.baidu.tbadk.core.data.p pVar = (com.baidu.tbadk.core.data.p) view.getTag();
            oVar = this.aDZ.aDY;
            if (oVar != null) {
                MessageManager messageManager = MessageManager.getInstance();
                context3 = this.aDZ.mContext;
                String valueOf = String.valueOf(pVar.getUserId());
                String name = pVar.getName();
                String ks = pVar.ks();
                oVar2 = this.aDZ.aDY;
                messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context3, valueOf, name, ks, null, false, AddFriendActivityConfig.TYPE_FRS_RECOM, oVar2.kp())));
                return;
            }
            MessageManager messageManager2 = MessageManager.getInstance();
            context2 = this.aDZ.mContext;
            messageManager2.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context2, String.valueOf(pVar.getUserId()), pVar.getName(), pVar.ks(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
        }
    }
}
