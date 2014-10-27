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
    final /* synthetic */ cj aDA;
    private final /* synthetic */ com.baidu.tbadk.core.data.q aDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cj cjVar, com.baidu.tbadk.core.data.q qVar) {
        this.aDA = cjVar;
        this.aDB = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aDA.mContext;
        messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, this.aDB.getAuthor().getUserId(), this.aDB.getAuthor().getName_show(), this.aDA.aBV.zJ().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
