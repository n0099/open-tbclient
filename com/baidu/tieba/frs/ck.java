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
public class ck implements View.OnClickListener {
    final /* synthetic */ cf aXq;
    private final /* synthetic */ com.baidu.tbadk.core.data.w aXr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cf cfVar, com.baidu.tbadk.core.data.w wVar) {
        this.aXq = cfVar;
        this.aXr = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aXq.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.aXr.getAuthor().getUserId(), this.aXr.getAuthor().getName_show(), this.aXq.aTW.aeJ().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
