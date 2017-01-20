package com.baidu.tieba.frs.c;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bRP;
    private final /* synthetic */ aa bRQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, aa aaVar) {
        this.bRP = aVar;
        this.bRQ = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        n nVar;
        Context context;
        n nVar2;
        n nVar3;
        String str = "";
        nVar = this.bRP.bFG;
        if (nVar != null) {
            nVar2 = this.bRP.bFG;
            if (nVar2.aJY() != null) {
                nVar3 = this.bRP.bFG;
                str = nVar3.aJY().getName();
            }
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bRP.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.bRQ.getAuthor().getUserId(), this.bRQ.getAuthor().getName_show(), str, AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
