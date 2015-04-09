package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements View.OnClickListener {
    final /* synthetic */ bs aMm;
    private final /* synthetic */ com.baidu.tbadk.core.data.w aMn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bs bsVar, com.baidu.tbadk.core.data.w wVar) {
        this.aMm = bsVar;
        this.aMn = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aMm.mContext;
        messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, this.aMn.getAuthor().getUserId(), this.aMn.getAuthor().getName_show(), this.aMm.aJd.Za().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
