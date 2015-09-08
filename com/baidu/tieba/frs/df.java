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
public class df implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.x aXM;
    final /* synthetic */ dd aYP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(dd ddVar, com.baidu.tbadk.core.data.x xVar) {
        this.aYP = ddVar;
        this.aXM = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aYP.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.aXM.getAuthor().getUserId(), this.aXM.getAuthor().getName_show(), this.aYP.aUN.acP().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
