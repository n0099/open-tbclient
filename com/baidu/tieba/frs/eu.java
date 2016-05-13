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
public class eu implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.ax bjh;
    final /* synthetic */ er bmg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eu(er erVar, com.baidu.tbadk.core.data.ax axVar) {
        this.bmg = erVar;
        this.bjh = axVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bmg.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.bjh.getAuthor().getUserId(), this.bjh.getAuthor().getName_show(), this.bmg.bgq.avD().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
