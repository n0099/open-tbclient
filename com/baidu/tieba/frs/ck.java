package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements View.OnClickListener {
    final /* synthetic */ cj aDK;
    private final /* synthetic */ com.baidu.tbadk.core.data.q aDL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cj cjVar, com.baidu.tbadk.core.data.q qVar) {
        this.aDK = cjVar;
        this.aDL = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aDK.mContext;
        messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, this.aDL.getAuthor().getUserId(), this.aDL.getAuthor().getName_show(), this.aDK.aCf.zL().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
