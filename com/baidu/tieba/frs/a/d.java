package com.baidu.tieba.frs.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a boe;
    private final /* synthetic */ n bof;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, n nVar) {
        this.boe = aVar;
        this.bof = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        Context context;
        o oVar2;
        o oVar3;
        String str = "";
        oVar = this.boe.bfF;
        if (oVar != null) {
            oVar2 = this.boe.bfF;
            if (oVar2.aoE() != null) {
                oVar3 = this.boe.bfF;
                str = oVar3.aoE().getName();
            }
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.boe.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.bof.getAuthor().getUserId(), this.bof.getAuthor().getName_show(), str, AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
