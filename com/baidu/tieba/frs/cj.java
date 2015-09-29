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
public class cj implements View.OnClickListener {
    final /* synthetic */ cf aXf;
    private final /* synthetic */ com.baidu.tbadk.core.data.v aXg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(cf cfVar, com.baidu.tbadk.core.data.v vVar) {
        this.aXf = cfVar;
        this.aXg = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aXf.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.aXg.getAuthor().getUserId(), this.aXg.getAuthor().getName_show(), this.aXf.aTL.aeN().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
