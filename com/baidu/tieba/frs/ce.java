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
public class ce implements View.OnClickListener {
    final /* synthetic */ bz aXQ;
    private final /* synthetic */ com.baidu.tbadk.core.data.v aXR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(bz bzVar, com.baidu.tbadk.core.data.v vVar) {
        this.aXQ = bzVar;
        this.aXR = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aXQ.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.aXR.getAuthor().getUserId(), this.aXR.getAuthor().getName_show(), this.aXQ.aUy.acG().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
