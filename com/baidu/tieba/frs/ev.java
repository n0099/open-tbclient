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
public class ev implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.ah biT;
    final /* synthetic */ es blB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ev(es esVar, com.baidu.tbadk.core.data.ah ahVar) {
        this.blB = esVar;
        this.biT = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.blB.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.biT.getAuthor().getUserId(), this.biT.getAuthor().getName_show(), this.blB.bfF.aoE().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
