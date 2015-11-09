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
public class ea implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.w aXA;
    final /* synthetic */ dy aZb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(dy dyVar, com.baidu.tbadk.core.data.w wVar) {
        this.aZb = dyVar;
        this.aXA = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aZb.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.aXA.getAuthor().getUserId(), this.aXA.getAuthor().getName_show(), this.aZb.aUe.afg().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
