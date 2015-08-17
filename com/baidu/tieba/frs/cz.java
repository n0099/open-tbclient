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
    private final /* synthetic */ com.baidu.tbadk.core.data.v aXR;
    final /* synthetic */ cx aYy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cx cxVar, com.baidu.tbadk.core.data.v vVar) {
        this.aYy = cxVar;
        this.aXR = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aYy.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.aXR.getAuthor().getUserId(), this.aXR.getAuthor().getName_show(), this.aYy.aUy.acG().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
