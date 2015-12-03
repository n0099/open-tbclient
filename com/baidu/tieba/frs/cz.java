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
public class cz implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.z bci;
    final /* synthetic */ cv bdx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cv cvVar, com.baidu.tbadk.core.data.z zVar) {
        this.bdx = cvVar;
        this.bci = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bdx.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.bci.getAuthor().getUserId(), this.bci.getAuthor().getName_show(), this.bdx.aZs.ajy().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
