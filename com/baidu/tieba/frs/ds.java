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
public class ds implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.w aXr;
    final /* synthetic */ dp aYB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(dp dpVar, com.baidu.tbadk.core.data.w wVar) {
        this.aYB = dpVar;
        this.aXr = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aYB.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.aXr.getAuthor().getUserId(), this.aXr.getAuthor().getName_show(), this.aYB.aTW.aeN().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
