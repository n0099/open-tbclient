package com.baidu.tieba.frs.d;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a cfQ;
    private final /* synthetic */ aa cfR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, aa aaVar) {
        this.cfQ = aVar;
        this.cfR = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        Context context;
        p pVar2;
        p pVar3;
        String str = "";
        pVar = this.cfQ.bRX;
        if (pVar != null) {
            pVar2 = this.cfQ.bRX;
            if (pVar2.aOk() != null) {
                pVar3 = this.cfQ.bRX;
                str = pVar3.aOk().getName();
            }
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.cfQ.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.cfR.getAuthor().getUserId(), this.cfR.getAuthor().getName_show(), str, AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
