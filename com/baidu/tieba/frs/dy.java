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
public class dy implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.w aXr;
    final /* synthetic */ dw aYP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(dw dwVar, com.baidu.tbadk.core.data.w wVar) {
        this.aYP = dwVar;
        this.aXr = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aYP.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.aXr.getAuthor().getUserId(), this.aXr.getAuthor().getName_show(), this.aYP.aTW.aeJ().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
