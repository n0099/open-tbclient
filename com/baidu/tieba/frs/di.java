package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class di implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.ah biT;
    final /* synthetic */ df bkk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(df dfVar, com.baidu.tbadk.core.data.ah ahVar) {
        this.bkk = dfVar;
        this.biT = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bkk.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.biT.getAuthor().getUserId(), this.biT.getAuthor().getName_show(), this.bkk.bfF.aoE().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
