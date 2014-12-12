package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements View.OnClickListener {
    final /* synthetic */ cg aFl;
    private final /* synthetic */ com.baidu.tbadk.core.data.w aFp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cg cgVar, com.baidu.tbadk.core.data.w wVar) {
        this.aFl = cgVar;
        this.aFp = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aFl.mContext;
        messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, this.aFp.getAuthor().getUserId(), this.aFp.getAuthor().getName_show(), this.aFl.aDH.aej().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
