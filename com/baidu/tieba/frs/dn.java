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
public class dn implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.as bnE;
    final /* synthetic */ dk bpw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(dk dkVar, com.baidu.tbadk.core.data.as asVar) {
        this.bpw = dkVar;
        this.bnE = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bpw.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.bnE.getAuthor().getUserId(), this.bnE.getAuthor().getName_show(), this.bpw.bkq.avu().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
