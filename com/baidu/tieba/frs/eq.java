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
public class eq implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.z bgh;
    final /* synthetic */ ep biW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eq(ep epVar, com.baidu.tbadk.core.data.z zVar) {
        this.biW = epVar;
        this.bgh = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.biW.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.bgh.getAuthor().getUserId(), this.bgh.getAuthor().getName_show(), this.biW.bdo.akG().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
